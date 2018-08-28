package com.vol.notes;

import com.vol.notes.dao.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Runner {

    private BaseDAO baseDAO;

    @Autowired
    public Runner(BaseDAO baseDAO) {
        this.baseDAO = baseDAO;
        System.out.println("Инициализация BaseDAO завершена. Выполним getUsers()");
        this.baseDAO.getUsers();
    }


}
