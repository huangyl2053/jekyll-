/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2040011.TajutokuTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.RootTitleSetter;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n8178 城間篤人
 */
public class TajutokuTaishoshaSearch {

    /**
     * 読み込み時に実行し、親Divタイトルにメニュー名を設定します。
     *
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onLoad(TajutokuTaishoshaSearchDiv searchDiv) {
        ResponseData<TajutokuTaishoshaSearchDiv> response = new ResponseData<>();
        response.setRootTitle(RootTitleSetter.getTitle());
        response.data = searchDiv;
        return response;
    }
}
