/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223 ymddata,　共有DIV適用　2014.06.20
 * @author n8223 共有DIV適用　2014.06.28
 *
 */
public class KagoMoshitatePanel {

    /**
     * 介護給付費過誤申立書登録 給付実積該当者一覧で、選択した内容もとに、過誤申立書情報の内容を設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @param gaitoshaListpanel
     * @return
     */
    public ResponseData<KagoMoshitatePanelDiv> onClick_btnSelect(
            KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListpanel) {
        ResponseData<KagoMoshitatePanelDiv> response = new ResponseData<>();

        //住民情報・世帯員情報の内容を設定する。
        setKagoMoshitateHihokensha(panel);
        // 過誤申立書情報の内容を設定する。
        setKagoMoshitate(panel, gaitoshaListpanel);

        response.data = panel;
        return response;
    }

    /*
     * 住民情報(世帯主)
     * 住民情報(世帯員)
     */
    private void setKagoMoshitateHihokensha(KagoMoshitatePanelDiv panel) {

        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000019");
        int rowId = 0;
        KaigoShikakuKihon.setData(panel.getCommonKaigpAtenainfoChildDiv1(),
                panel.getCommonKaigoshikakuKihonChildDiv2(), 識別コード, rowId);
    }

    /**
     * 介護給付費過誤申立書登録 過誤申立書情報の内容を設定する。
     *
     * @param panel MishinsaShikyuShinseiListPanelDiv
     * @param gaitoshaListpanel　KyufuJissekiGaitoshaListPanelDiv
     * @return
     */
    private void setKagoMoshitate(KagoMoshitatePanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListpanel) {

        //入力した情報・選択された情報をもとに過誤申立書情報の内容を設定する。
        //事業者NO
        panel.getKagoMoshitateInfo().getTxtJigyoshaNo().
                setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaNo());

        //事業者NANE 2014.06.25 情報はない場合がある　修正
        if (!gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaName().equals("")) {
            panel.getKagoMoshitateInfo().getTxtJigyoshaName().
                    setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtJigyoshaName());
        }
        //提供年月
        panel.getKagoMoshitateInfo().getTxtTeikyoYM().
                setValue(new RDate(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtTeikyoYM().toString()));

        //申立者区分
        panel.getKagoMoshitateInfo().getTxtMoshitateshaKubun().
                setValue(gaitoshaListpanel.getDgHihokenshaSearchGaitosha().getClickedItem().getTxtKyufuJissekiSakuseiKubun());

        List<HashMap> ymlData = ymlData("dbc1400011/KagoMoshitatePanel.yml");
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        //様式
        panel.getKagoMoshitateInfo().getTxtKagoForm().setValue((ymlDt.getAsRString("様式")));

        //証記載保険者番号　南魚沼市 　152264
        panel.getKagoMoshitateInfo().getTxtShokisaiHokenshaNo().setValue(ymlDt.getAsRString("shokisaiHokenshaNo"));
        //証記載保険者名
        panel.getKagoMoshitateInfo().getTxtShokisaiHokenshaName().setValue(ymlDt.getAsRString("shokisaiHokenshaName"));
        //申立日 2014.06.24 修正　空白
        //panel.getKagoMoshitateInfo().getTxtMoshitateDate().setValue(ymlDt.getAsRDate("moshitateDate"));
        panel.getKagoMoshitateInfo().getTxtMoshitateDate().clearValue();
        //申立事由 2014.06.24 追加　空白 code00
        panel.getKagoMoshitateInfo().getDdlKagoMoshitateRiyu().setSelectedItem(new RString("code00"));

    }

    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }
}
