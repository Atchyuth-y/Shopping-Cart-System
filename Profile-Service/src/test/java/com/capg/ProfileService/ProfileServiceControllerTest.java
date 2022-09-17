package com.capg.ProfileService;

import com.capg.ProfileService.Controller.ProfileController;
import com.capg.ProfileService.Model.User;
import com.capg.ProfileService.Service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProfileServiceControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ProfileService profileService;

    @InjectMocks
    private ProfileController profileController;

    User PROF_1 = new User(1, "Balaji", "balu@gmail.com", "99099099998", null, "Male");

    User PROF_2 = new User(2, "venkatesh", "venki@gmail.com", "9009009999", null, "Male");

    User PROF_3 = new User(3, "padma", "padma@gmail.com", "9999999999", null, "female");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
    }

    @Test
    public void getAllProfiles_Test() throws Exception {
        List<User> records = new ArrayList<>(Arrays.asList(PROF_1, PROF_2, PROF_3));

        Mockito.when(profileService.getAllProfiles()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/profile/show")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));
        // .andExpect(jsonPath("$[2].ProductType",is("skincare")));
    }

    @Test
    public void registerNewCustomerProfile_Test() throws Exception {
        User record = new User(2, "atchyuth", "venki@gmail.com", "9009009999", null, "Male");
        //Product(9,"kidsSpecial","joggers","Clothing",null,null,null,999,"Its a very good",null);

        Mockito.when(profileService.registerNewCustomerProfile(record)).thenReturn(record);

        String content = objectWriter.writeValueAsString(record);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/profile/save")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.fullName", is("atchyuth")));
    }

    @Test
    public void updateProfile_Test() throws Exception {

        User updateRecord = new User(3, "padmavati", "padmavati@gmail.com", "9999999999", null, "female");


        //Mockito.when(productService.updateProducts(PRO_1.getProductId())).thenReturn(Optional.ofNullable(PRO_1));
        Mockito.when(profileService.updateProfile(updateRecord, updateRecord.getProfileId())).thenReturn(updateRecord);

        String updateContent = objectWriter.writeValueAsString(updateRecord);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/profile/update/3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updateContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.emailId", is("padmavati@gmail.com")));

    }

    @Test
    public void deleteProfileById_Test() throws Exception {
        //Mockito.when(productService.deleteProductsById(PRO_3.getProductId())).thenReturn(Optional.ofNullable(PRO_3));
        willDoNothing().given(profileService).deleteProfileById(PROF_3.getProfileId());

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/profile/delete/" + PROF_3.getProfileId()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
}