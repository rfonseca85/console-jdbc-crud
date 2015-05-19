package com.knowroaming.rfonseca.dao;

import java.util.List;

import com.knowroaming.rfonseca.pojo.UsageInformation;

public interface UsageInformationDAO {

       public void saveUsageInformation(UsageInformation usageInformation) throws Exception;
       public UsageInformation getUserInformationByUserId(int userId) throws Exception;
       public List<UsageInformation> fetchingUsageInformationsByDateRange(int userId, String startdate, String finalDate) throws Exception;
       
}