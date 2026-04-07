package org.jztrmnkl.Controller;

import org.junit.jupiter.api.Test;
import org.jztrmnkl.repository.LibraryRepository;
import org.jztrmnkl.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LibraryController.class)
public class LibraryControllerIntTest {

    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    LibraryService libraryService;

    @MockitoBean
    LibraryRepository libraryRepository;


    @Test
    public void postBorrowerTest() throws Exception {
        mockMvc.perform(post("/Library/Borrower")
                        .content("{ \"id\": 1, \"name\": \"Aladár\" }")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(post("/Library/Borrower")
                        .content("{ \"id\": 2, \"name\": \"Béla\" }")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postBooksTest() throws Exception {
        mockMvc.perform(post("/Library/Borrower")
                        .content("{ \"id\": 1, \"name\": \"Rózsák\" }")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(post("/Library/Books")
                        .content("{ \"id\": 2, \"name\": \"Állatok\" }")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(post("/Library/Books")
                        .content("{ \"id\": 3, \"name\": \"Égbolt\" }")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postBorrowingTest() throws Exception {
        mockMvc.perform(post("/Library/Borrower")
                        .content("{ \"bookId\": 1, \"borrowerId\": \"1\" }")
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
        mockMvc.perform(post("/Library/Borrower")
                    .content("{ \"bookId\": 3, \"borrowerId\": \"1\" }")
                    .contentType("application/json")
                    .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getBooksTest() throws Exception {
        mockMvc.perform(get("/Library/Books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getBorrowedBooksTest() throws Exception {
        mockMvc.perform(get("/Library/Borrowing")
                    .content("{ \"id\": 1 }")
                    .contentType("application/json")
                    .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
