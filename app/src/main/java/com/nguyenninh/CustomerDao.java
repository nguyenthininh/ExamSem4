package com.nguyenninh;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CustomerDao {
    @Insert(onConflict = REPLACE)   //khi điền chữ REPLACE vào sẽ báo đỏ, để hết báo đỏ thì chuôt trỏ chuột vào chọn More Action và chọn Import
    void insertCustomer(CustomerEntity customer);

    @Update
    void updateUser(CustomerEntity customer);

    @Delete
    void deleteUser(CustomerEntity customer);

    @Query("SELECT * FROM Customer")
    List<CustomerEntity> getAllUser();

    @Query("SELECT * FROM Customer Where id = :id")
    CustomerEntity findUser(int id);

    @Query("DELETE FROM Customer")
    void deleteAll();
}
