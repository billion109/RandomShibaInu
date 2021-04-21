package com.example.randomshiba.dao;

public class ShibaPictureDaoSqls {
    public static final String SELECT_ALL = "SELECT id, name from SHIBA";
    public static final String SELECT_RANDOM_ONE = "SELECT id, name from SHIBA ORDER BY RAND() LIMIT 0,1";
}
