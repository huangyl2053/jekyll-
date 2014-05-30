/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4040001.ShinakaiScheduleEntryDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 審査会開催予定登録Divの制御を行います。（DBE4040001）
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiScheduleEntity {

    public ResponseData onLoadData(ShinakaiScheduleEntryDiv div) {
        ResponseData<ShinakaiScheduleEntryDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

}
