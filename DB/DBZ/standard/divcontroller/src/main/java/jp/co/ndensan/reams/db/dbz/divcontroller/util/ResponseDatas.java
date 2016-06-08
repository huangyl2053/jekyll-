/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * ResponseData用のユーティリティです。
 *
 * @author n8178 城間篤人
 */
public final class ResponseDatas {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ResponseDatas() {
    }

    /**
     * ResponseDataを生成し、引数から受け取った値を設定して返します。
     *
     * @param <T> ResponseDataが持つdataの型
     * @param postData ResponseDataに渡すデータ
     * @return 引数から受け取った値を、dataに設定したResponseData
     * @deprecated {@link #newResponseData(java.lang.Object)}を使用して下さい。
     */
    @Deprecated
    public static <T> ResponseData<T> createSettingDataTo(T postData) {
        return newResponseData(postData);
    }

    /**
     * ResponseDataを生成し、引数から受け取った値を設定して返します。
     *
     * @param <T> ResponseDataが持つdataの型
     * @param postData ResponseDataに渡すデータ
     * @return 引数から受け取った値を、dataに設定したResponseData
     */
    public static <T> ResponseData<T> newResponseData(T postData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = postData;
        return response;
    }
}
