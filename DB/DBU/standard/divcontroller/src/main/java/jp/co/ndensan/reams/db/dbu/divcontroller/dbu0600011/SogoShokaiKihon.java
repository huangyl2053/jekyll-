/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.dbu0600011;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiSearchDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0600011.SogoShokaiKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会基本情報Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class SogoShokaiKihon {

    /**
     * 検索結果画面-「選択」押下時の処理を表します。
     *
     * @param panel SogoShokaiKihonDiv
     * @param panel2 SogoShokaiSearchDiv
     * @return ResponseData
     */
    public ResponseData<SogoShokaiKihonDiv> dispTaishoshaJoho(
            SogoShokaiKihonDiv panel, SogoShokaiSearchDiv panel2) {
        ResponseData<SogoShokaiKihonDiv> response = new ResponseData<>();

        List<HashMap> hihokenshashoHakkoTaishoshaJohoList = YamlLoader.DBU.loadAsList(
                new RString("dbu0600011/AtenaKihonData.yml"));

        HashMap hashMap = hihokenshashoHakkoTaishoshaJohoList.get(
                panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().getClickedRowId());

        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //宛名基本情報の出力
        panel.getSogoShokaiKihonInfo().getTxtAtenaMeisho().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().getClickedItem().getShimei());

        panel.getSogoShokaiKihonInfo().getTxtAtenaKanaMeisho().
                setValue(ymlData.getAsRString("カナ氏名"));

        panel.getSogoShokaiKihonInfo().getTxtJusho().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().getClickedItem().getJusho());

        panel.getSogoShokaiKihonInfo().getTxtSeinengappiYMD().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().
                        getClickedItem().getBirthDay().getValue());

        panel.getSogoShokaiKihonInfo().getTxtNenrei().
                setValue(ymlData.getAsRString("年齢"));

        panel.getSogoShokaiKihonInfo().getTxtSeibetsu().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().
                        getClickedItem().getGender());

        panel.getSogoShokaiKihonInfo().getTxtGyoseiku().
                setValue(ymlData.getAsRString("行政区"));

        panel.getSogoShokaiKihonInfo().getTxtYubinNo().
                setValue(new YubinNo(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().
                                getClickedItem().getYubinNo()));

        panel.getSogoShokaiKihonInfo().getTxtNihonjinGaikokujin().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().
                        getClickedItem().getJuminShubetsu());

        panel.getSogoShokaiKihonInfo().getTxtJuminJotai().
                setValue(ymlData.getAsRString("住民状態"));

        panel.getSogoShokaiKihonInfo().getTxtShikibetsuCode().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().
                        getClickedItem().getShikibetsuCode());

        panel.getSogoShokaiKihonInfo().getTxtKojinHojinCode().
                setValue(ymlData.getAsRString("個人番号"));

        panel.getSogoShokaiKihonInfo().getTxtSetaiCode().
                setValue(panel2.getSogoShokaiGaitoshaListInfo().getDgSearchResult().
                        getClickedItem().getSetaiCode());

        response.data = panel;
        return response;

    }

}
