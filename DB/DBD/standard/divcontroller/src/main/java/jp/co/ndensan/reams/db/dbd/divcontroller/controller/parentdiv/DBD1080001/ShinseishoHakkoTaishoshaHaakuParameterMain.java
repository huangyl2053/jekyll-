/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1080001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1080001.ShinseishoHakkoTaishoshaHaakuParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080001.DBD1080001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080001.ShinseishoHakkoTaishoshaHaakuParameterMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1080001.DBD1080001Handler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBDGM12021_1_減免減額申請書発行用対象者把握のクラスです。
 *
 * @reamsid_L DBD-3530-010 liuwei2
 */
public class ShinseishoHakkoTaishoshaHaakuParameterMain {

    /**
     * 減免減額申請書発行用対象者把握の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShinseishoHakkoTaishoshaHaakuParameterMainDiv> onLoad(ShinseishoHakkoTaishoshaHaakuParameterMainDiv div) {
        DBD1080001Handler handler = getHandler(div);
        handler.onload(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 減免・減額種類を選択する
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShinseishoHakkoTaishoshaHaakuParameterMainDiv> select_GemmenGengakuShrui(ShinseishoHakkoTaishoshaHaakuParameterMainDiv div) {
        if (div.getParameters().getDdlGemmenGengakuShrui().getSelectedKey().contains(new RString("key0"))) {
            div.getParameters().getDdlRiyoshaFutanDankai().setVisible(true);
            return ResponseData.of(div).setState(DBD1080001StateName.負担限度額認定);
        } else {
            div.getParameters().getDdlRiyoshaFutanDankai().setVisible(false);
            return ResponseData.of(div).setState(DBD1080001StateName.その他);
        }
    }

    /**
     * 新規・更新区分を選択する
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShinseishoHakkoTaishoshaHaakuParameterMainDiv> select_RadShinkiKoshiKubun(ShinseishoHakkoTaishoshaHaakuParameterMainDiv div) {
        if (div.getParameters().getRadShinkiKoshiKubun().getSelectedKey().contains(new RString("key1"))) {
            div.getParameters().getChkContainsKazeiHihokensha().setDisabled(true);
        } else {
            div.getParameters().getChkContainsKazeiHihokensha().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンをクッリク
     *
     * @param div コントロールdiv
     * @return ResponseData<ShinseishoHakkoTaishoshaHaakuParameter>
     */
    public ResponseData<ShinseishoHakkoTaishoshaHaakuParameter> onClick_btnJiKou(ShinseishoHakkoTaishoshaHaakuParameterMainDiv div) {
        ShinseishoHakkoTaishoshaHaakuParameter parameter = getHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private DBD1080001Handler getHandler(ShinseishoHakkoTaishoshaHaakuParameterMainDiv div) {
        return new DBD1080001Handler(div);
    }

}
