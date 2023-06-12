package com.tisteps.JmtAdmin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
*Entity table Jobs which stores the jobs related data by admin
*      Column      |          Type          | Collation | Nullable |               Default
-----------------+------------------------+-----------+----------+--------------------------------------
 id              | bigint                 |           | not null | nextval('tbl_jobs_id_seq'::regclass)
 job_description | character varying(255) |           |          |
 job_role        | character varying(255) |           |          |
Indexes:
    "tbl_jobs_pkey" PRIMARY KEY, btree (id)
Referenced by:
    TABLE "tbl_job_appln" CONSTRAINT "fklanxvivr1yciwc7idh455ksr5" FOREIGN KEY (job_id) REFERENCES tbl_jobs(id)
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_jobs")
@Builder
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "job_role")
    private String jobRole;
    @Column(name = "job_description")
    private String jobDescription;

}
