package com.xperttech.models;

import android.net.Uri;

import java.io.File;

/**
 * Created by
 */

public class FileUri {
  private Uri imageUrl;
  private File file;

  public Uri getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(Uri imageUrl) {
    this.imageUrl = imageUrl;
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }
}
