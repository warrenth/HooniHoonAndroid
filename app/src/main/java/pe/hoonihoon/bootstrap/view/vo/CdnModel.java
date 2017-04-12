package pe.hoonihoon.bootstrap.view.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by 152317 on 2017-04-12.
 */

public class CdnModel {
    ArrayList<Object> tabList;
    ArrayList<ItemModel> itemList;

    public ArrayList<ItemModel> getItemList() {
        return itemList;
    }

    public static class ItemModel implements Parcelable {
        String image;
        String name;

        protected ItemModel(Parcel in) {
            image = in.readString();
            name = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(image);
            dest.writeString(name);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
            @Override
            public ItemModel createFromParcel(Parcel in) {
                return new ItemModel(in);
            }

            @Override
            public ItemModel[] newArray(int size) {
                return new ItemModel[size];
            }
        };

        /**
         * 이미지 URL 리턴
         * @return 이미지 URL
         */
        public String getImageUrl() {
            return image;
        }

        /**
         * 이름 리턴
         * @return 이름
         */
        public String getName() {
            return name;
        }
    }
}
