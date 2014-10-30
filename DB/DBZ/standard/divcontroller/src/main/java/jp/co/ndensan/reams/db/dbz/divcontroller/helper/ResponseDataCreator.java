/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 各DivControllerで共通的に使用される、ReponseData作成処理を提供します。
 *
 * @author n8178 城間篤人
 */
public final class ResponseDataCreator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ResponseDataCreator() {
    }

    /**
     * 引数から受け取った方をデータとして持つResponseDataを生成して返します。
     *
     * @param <T> ResponseDataに渡すデータの型
     * @param setIntoData ResponseDataに渡すデータ
     * @return 引数の値を持つResponseData
     */
    public static <T> ResponseData<T> create(T setIntoData) {
        ResponseData<T> response = new ResponseData<>();
        response.data = setIntoData;
        return response;
    }
}
