package com.tisteps.JmtAdmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
Entity table to store job appn details
                            Table "public.tbl_job_appln"
 Column  |  Type  | Collation | Nullable |                  Default
---------+--------+-----------+----------+-------------------------------------------
 id      | bigint |           | not null | nextval('tbl_job_appln_id_seq'::regclass)
 job_id  | bigint |           |          |
 user_id | bigint |           |          |
Indexes:
    "tbl_job_appln_pkey" PRIMARY KEY, btree (id)
Foreign-key constraints:
    "fkjpuwdvdavdg0vkbhsecmf895a" FOREIGN KEY (user_id) REFERENCES tbl_user(id)
    "fklanxvivr1yciwc7idh455ksr5" FOREIGN KEY (job_id) REFERENCES tbl_jobs(id)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_job_appln")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "job_id")
    private long job_id;
    @Column(name = "user_id")
    private long user_id;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "job_id",
    referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private Jobs job;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "user_id",
    referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private User user;
}
