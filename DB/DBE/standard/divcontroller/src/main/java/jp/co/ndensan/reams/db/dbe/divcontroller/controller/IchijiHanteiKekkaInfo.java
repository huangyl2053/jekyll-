/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ichijiHanteiKekkaInfo.IchijiHanteiKekkaInfoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ichijiHanteiKekkaInfo.dgIchijiHanteiKeikokuCode_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定結果をダイアログ使用する際の処理を表します。
 *
 * @author N1013 松本直樹
 */
public class IchijiHanteiKekkaInfo {

    /**
     * ロード時の処理です。
     *
     * @param div IchijiHanteiKekkaInfoDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiKekkaInfoDiv> onLoad(IchijiHanteiKekkaInfoDiv div) {
        ResponseData<IchijiHanteiKekkaInfoDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("IchijiHanteiKekkaInfo/IchijiHanteiKekkaKakunin.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        div.getTxtIchijiHanteibi().setValue(cg.getAsFlexibleDate("ichijihanteibi"));
        div.getTxtIchijiHanteiKekka().setValue(cg.getAsRString("kaigodo"));
        div.getTxtKijunJikan().setValue(cg.getAsRString("kijunjikan"));
        div.getTblKijunJikan().getTxtShokuji().setValue(cg.getAsRString("shokuji"));
        div.getTblKijunJikan().getTxtHaisetsu().setValue(cg.getAsRString("haisetsu"));
        div.getTblKijunJikan().getTxtIdo().setValue(cg.getAsRString("ido"));
        div.getTblKijunJikan().getTxtSeiketsuHoji().setValue(cg.getAsRString("seiketsuhoji"));
        div.getTblKijunJikan().getTxtKansetsuCare().setValue(cg.getAsRString("kansetsucare"));
        div.getTblKijunJikan().getTxtBpsdKanren().setValue(cg.getAsRString("bpsd"));
        div.getTblKijunJikan().getTxtKinoKunren().setValue(cg.getAsRString("kinokunren"));
        div.getTblKijunJikan().getTxtIryoKanren().setValue(cg.getAsRString("iryokanren"));
        div.getTblKijunJikan().getTxtNinchishoKasan().setValue(cg.getAsRString("ninchishokansan"));
        div.getTblTyukanHyokaKomokuTokuten().getTxtDai1gun().setValue(cg.getAsRString("chukantokuten1"));
        div.getTblTyukanHyokaKomokuTokuten().getTxtDai2gun().setValue(cg.getAsRString("chukantokuten2"));
        div.getTblTyukanHyokaKomokuTokuten().getTxtDai3gun().setValue(cg.getAsRString("chukantokuten3"));
        div.getTblTyukanHyokaKomokuTokuten().getTxtDai4gun().setValue(cg.getAsRString("chukantokuten4"));
        div.getTblTyukanHyokaKomokuTokuten().getTxtDai5gun().setValue(cg.getAsRString("chukantokuten5"));
        div.getTxtJiritsudoChosa().setValue(cg.getAsRString("jiritsudochosa"));
        div.getTxtJiritsudoIkensho().setValue(cg.getAsRString("jiritsudoikensho"));
        div.getTxtGaizensei().setValue(cg.getAsRString("gaozensei"));
        div.getTxtJyotaiAnteisei().setValue(cg.getAsRString("anteisei"));
        div.getTxtKyufuKbn().setValue(cg.getAsRString("kyufukbn"));

        div.getDgIchijiHanteiKeikokuCode().setDataSource(createListOfKeikokuIchiran());
        response.data = div;
        return response;
    }

    private static List<dgIchijiHanteiKeikokuCode_Row> createListOfKeikokuIchiran() {
        List<dgIchijiHanteiKeikokuCode_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBE.loadAsList(new RString("IchijiHanteiKekkaInfo/IchijiHanteiKekkaKeikoku.yml"));
        for (Map info : targetSource) {
            list.add(toDgIchijiHanteiKeikokuCode_Row(info));
        }
        return list;
    }

    private static dgIchijiHanteiKeikokuCode_Row toDgIchijiHanteiKeikokuCode_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        RString keikokuNo = cg.getAsRString("keikokuno");
        RString keikokuCode = cg.getAsRString("keikokucode");
        RString keikokuNaiyo = cg.getAsRString("keikokunaiyo");
        dgIchijiHanteiKeikokuCode_Row row = new dgIchijiHanteiKeikokuCode_Row(keikokuNo, keikokuCode, keikokuNaiyo);
        return row;
    }

}
