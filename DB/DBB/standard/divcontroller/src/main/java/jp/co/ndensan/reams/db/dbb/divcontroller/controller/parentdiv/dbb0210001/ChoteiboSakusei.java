/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0210001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.choteibo.ChoteiboBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001.ChoteiboSakuseiHandler;
import jp.co.ndensan.reams.db.dbb.service.core.choteibo.ChoteiboSakuseiManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 調定簿作成Divのコントローラです。
 *
 * @author cuilin
 */
public class ChoteiboSakusei {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ChoteiboSakuseiDiv> onLoad(ChoteiboSakuseiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    private ChoteiboSakuseiHandler getHandler(ChoteiboSakuseiDiv div) {
        return ChoteiboSakuseiHandler.of(div);
    }

    /**
     * コントロールdivが「実行する」ボタンされた際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ChoteiboBatchParameter> onClick_btnBatchRegister(ChoteiboSakuseiDiv div) {
        String shoriNendo[] = div.getDdlShoriNendo().getSelectedValue().toString().split("年度");
        ChoteiboBatchParameter parameter = ChoteiboSakuseiManager.getChoteiboParameter(new FlexibleYear(shoriNendo[0]),
                new RDate(div.getLblChushutsuStYMD().getText().toString()),
                new RTime(div.getLblChushutsuStTime().getText()),
                new RDate(div.getLblChushutsuEdYMD().getText().toString()),
                new RTime(div.getLblChushutsuEdTime().getText()));
        return ResponseData.of(parameter).respond();
    }
}
