package persistence;

import org.json.JSONObject;

/**
 * Interface based on example from project instructions
 */

public interface Json {
    //Effects: returns this as JSON object
    JSONObject toJson();
}