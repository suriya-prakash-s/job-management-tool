package com.tisteps.JmtAdmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*Entity table User to store user related details
                                       Table "public.tbl_user"
    Column     |          Type          | Collation | Nullable |               Default
---------------+------------------------+-----------+----------+--------------------------------------
 id            | bigint                 |           | not null | nextval('tbl_user_id_seq'::regclass)
 user_job_role | character varying(255) |           |          |
 user_name     | character varying(255) |           |          |
Indexes:
    "tbl_user_pkey" PRIMARY KEY, btree (id)
Referenced by:
    TABLE "tbl_job_appln" CONSTRAINT "fkjpuwdvdavdg0vkbhsecmf895a" FOREIGN KEY (user_id) REFERENCES tbl_user(id)
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_job_role")
    private String jobRole;

}