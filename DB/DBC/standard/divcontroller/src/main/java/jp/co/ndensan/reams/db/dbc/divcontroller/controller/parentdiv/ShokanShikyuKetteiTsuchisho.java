/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810000.ShokanShikyuKetteiTsuchishoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 償還支給申請登録の償還払支給（不支給）通知書のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiTsuchisho {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoDiv> onSelectedShinseishoList(ShokanShikyuKetteiTsuchishoDiv panel) {
        setTsuchishoData(panel);

        return ResponseData.of(panel).respond();
    }

    private void setTsuchishoData(ShokanShikyuKetteiTsuchishoDiv panel) {
        // TODO 未使用のメソッド引数があります。 Checkstyle 対応。
        panel.hashCode();
//        panel.getShokanShikyuKetteiTsuchishoPrintContentsSetting().getTxtIssueDate().
//                setValue(new RDate(source.get("発効日").toString()));
    }
}
