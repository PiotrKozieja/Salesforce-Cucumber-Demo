package org.example.API;

import org.example.data.Account;
import org.json.JSONObject;

public class AccountAPI extends BaseAPI {

    public JSONObject getAccountObject(String accountId) {
        return getObject("Account", accountId);
    }

    public String createAccountObject(Account account) {
        JSONObject createdAccount = createObject("Account", account.convertToJson());
        return createdAccount.getString("id");
    }
}
