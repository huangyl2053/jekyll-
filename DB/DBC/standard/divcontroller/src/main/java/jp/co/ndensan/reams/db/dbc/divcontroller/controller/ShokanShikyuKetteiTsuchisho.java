/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiTsuchishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        ResponseData<ShokanShikyuKetteiTsuchishoDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private void setTsuchishoData(ShokanShikyuKetteiTsuchishoDiv panel) {
        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("dbc0810000/ShokanShikyuKetteiTsuchisho.yml")).get(0);
        panel.getShokanShikyuKetteiTsuchishoPrintContentsSetting().getTxtIssueDate().
                setValue(new RDate(source.get("発効日").toString()));
        panel.getShokanShikyuKetteiTsuchishoPaymentDate().getTxtKozaPaymentDate().
                setValue(new RDate(source.get("口座振込予定日").toString()));
        panel.getShokanShikyuKetteiTsuchishoPaymentDate().getTxtMadoguchiPaymentDateRange().
                setFromValue(new RDate(source.get("窓口支払期間開始").toString()));
        panel.getShokanShikyuKetteiTsuchishoPaymentDate().getTxtMadoguchiPaymentDateRange().
                setToValue(new RDate(source.get("窓口支払期間終了").toString()));
    }
}
