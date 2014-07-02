/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoGokei.ServiceTeikyoShomeishoGokeiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還支給申請で使用する共有子Divのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ServiceTeikyoShomeishoGokei {

    private List<HashMap> getServiceTeikyoShomeishoGokeiYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("ServiceTeikyoShomeishoGokei.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ServiceTeikyoShomeishoGokeiDiv> onLoad(ServiceTeikyoShomeishoGokeiDiv panel) {
        ResponseData<ServiceTeikyoShomeishoGokeiDiv> response = new ResponseData<>();

        setGokeiData(panel);
        setDisabled(panel);

        response.data = panel;
        return response;
    }

    private void setGokeiData(ServiceTeikyoShomeishoGokeiDiv panel) {
        HashMap source = getServiceTeikyoShomeishoGokeiYaml().get(0);
        panel.getTxtServiceTani().setValue(new Decimal(source.get("サービス単位").toString()));
        panel.getTxtHokengaku().setValue(new Decimal(source.get("保険請求額").toString()));
        panel.getTxtFutangaku().setValue(new Decimal(source.get("利用者負担額").toString()));
        panel.getTxtRyoyohi().clearValue();
        panel.getTxtShinryohi().clearValue();
        panel.getTxtShokujihi().clearValue();
    }

    private void setDisabled(ServiceTeikyoShomeishoGokeiDiv panel) {
        panel.getTxtServiceTani().setDisabled(false);
        panel.getTxtHokengaku().setDisabled(false);
        panel.getTxtFutangaku().setDisabled(false);
        panel.getTxtRyoyohi().setDisabled(true);
        panel.getTxtRyoyohi().setDisabled(true);
        panel.getTxtShinryohi().setDisabled(true);
        panel.getTxtShokujihi().setDisabled(true);
    }

}
