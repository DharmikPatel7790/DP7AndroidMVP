/*
 * Copyright (c) 2016.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.xperttech.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by
 */

public class SampleResponse implements Parcelable {

  private String userId;
  private int id;
  private String title;
  private String body;

  protected SampleResponse(Parcel in) {
    userId = in.readString();
    id = in.readInt();
    title = in.readString();
    body = in.readString();
  }

  public static final Creator<SampleResponse> CREATOR = new Creator<SampleResponse>() {
    @Override
    public SampleResponse createFromParcel(Parcel in) {
      return new SampleResponse(in);
    }

    @Override
    public SampleResponse[] newArray(int size) {
      return new SampleResponse[size];
    }
  };

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(userId);
    dest.writeInt(id);
    dest.writeString(title);
    dest.writeString(body);
  }
}
