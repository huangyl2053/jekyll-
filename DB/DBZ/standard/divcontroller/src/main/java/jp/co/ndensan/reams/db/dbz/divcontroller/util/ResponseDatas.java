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
     * @param <T> ResponseDataに渡すデータの型
     * @param setIntoData ResponseDataに渡すデータ
     * @return 引数の値を持つResponseData
     */
    public static <T> ResponseData<T> createSettingDataTo(T setIntoData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = setIntoData;
        return response;
    }
}
