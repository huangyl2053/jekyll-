/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB8120001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiKouseiJuminDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 */
public class SokujiKouseiJumin {

    /**
     * 画面の初期化メソッドです。
     *
     * @param sokujiKouseiJuminDiv SokujiKouseiJuminDiv
     * @return 画面のResponseData
     */
    public ResponseData<SokujiKouseiJuminDiv> onLoad_SokujiKouseiJumin(SokujiKouseiJuminDiv sokujiKouseiJuminDiv) {
        return ResponseData.of(sokujiKouseiJuminDiv).respond();
    }
}
