package com.scratchy.bookshelf.controller;

import com.scratchy.bookshelf.dao.BookDao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class BaseControllerIT {
    
    @Autowired
    protected BookDao bookRepository;

}
