/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IchijiHanteiKekkaKakuninDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IchijiHanteiShoriTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiKeikokuCode_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n9606
 */
public class IchijiHanteiKekkaKakunin {

    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
        ResponseData<IchijiHanteiKekkaKakuninDiv> response = new ResponseData<>();

        panel.setHidIdxNo(new RString("0"));
        setIchijiHanteiKekkaShosaiData(panel, panel2);

        response.data = panel;
        return response;
    }

    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispNextIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
        ResponseData<IchijiHanteiKekkaKakuninDiv> response = new ResponseData<>();

        panel.setHidIdxNo(new RString(String.valueOf(Integer.parseInt(panel.getHidIdxNo().toString()) + 1)));
        setIchijiHanteiKekkaShosaiData(panel, panel2);

        response.data = panel;
        return response;
    }

    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispPreIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
        ResponseData<IchijiHanteiKekkaKakuninDiv> response = new ResponseData<>();

        panel.setHidIdxNo(new RString(String.valueOf(Integer.parseInt(panel.getHidIdxNo().toString()) - 1)));
        setIchijiHanteiKekkaShosaiData(panel, panel2);

        response.data = panel;
        return response;
    }

    private void setIchijiHanteiKekkaShosaiData(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {

        StringBuilder stbKensu;
        int intIdx;

        List<HashMap> IchijiHanteiKekkaShosai = YamlLoader.FOR_DBE.loadAsList(new RString("IchijiHanteiKekkaKakunin.yml"));

        List<dgIchijiHanteiTaishoshaIchiran_Row> IchijiHanteiKekkaKakuninData = panel2.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();

        intIdx = Integer.parseInt(panel.getHidIdxNo().toString());
        HashMap hashmapIchijiHanteiKekka = IchijiHanteiKekkaShosai.get(Integer.parseInt(IchijiHanteiKekkaKakuninData.get(intIdx).getIndex().toString()));

        //件数表示
        stbKensu = new StringBuilder();
        stbKensu.append(intIdx + 1);
        stbKensu.append(" / ");
        stbKensu.append(IchijiHanteiKekkaKakuninData.size());
        panel.getTxtKensu().setValue(new RString(stbKensu.toString()));

        //対象者情報表示
        panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHokensha().setValue(IchijiHanteiKekkaKakuninData.get(intIdx).getHokensha());
        panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHihokenNo().setValue(IchijiHanteiKekkaKakuninData.get(intIdx).getHihokenNo());
        panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHihokenshaName().setValue(IchijiHanteiKekkaKakuninData.get(intIdx).getHihokenshaName());
        panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtShinseibi().setValue(new RDate(IchijiHanteiKekkaKakuninData.get(intIdx).getShinseibi().toString()));
        panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtShinseiKbnShin().setValue(IchijiHanteiKekkaKakuninData.get(intIdx).getShinseiKbnShin());

        //一次判定結果表示
        panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteibi().setValue(new RDate(IchijiHanteiKekkaKakuninData.get(intIdx).getIchijiHanteibi().toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteiKekka().setValue(new RString(hashmapIchijiHanteiKekka.get("kaigodo").toString()));

        panel.getCcdIchijiHanteiKakuninJoho().getTxtKijunJikan().setValue(new RString(hashmapIchijiHanteiKekka.get("kijunjikan").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtShokuji().setValue(new RString(hashmapIchijiHanteiKekka.get("shokuji").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtHaisetsu().setValue(new RString(hashmapIchijiHanteiKekka.get("haisetsu").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIdo().setValue(new RString(hashmapIchijiHanteiKekka.get("ido").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtSeiketsuHoji().setValue(new RString(hashmapIchijiHanteiKekka.get("seiketsuhoji").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKansetsuCare().setValue(new RString(hashmapIchijiHanteiKekka.get("kansetsucare").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtBpsdKanren().setValue(new RString(hashmapIchijiHanteiKekka.get("bpsd").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKinoKunren().setValue(new RString(hashmapIchijiHanteiKekka.get("kinokunren").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIryoKanren().setValue(new RString(hashmapIchijiHanteiKekka.get("iryokanren").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtNinchishoKasan().setValue(new RString(hashmapIchijiHanteiKekka.get("ninchishokasan").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai1gun().setValue(new RString(hashmapIchijiHanteiKekka.get("chukantokuten1").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai2gun().setValue(new RString(hashmapIchijiHanteiKekka.get("chukantokuten2").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai3gun().setValue(new RString(hashmapIchijiHanteiKekka.get("chukantokuten3").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai4gun().setValue(new RString(hashmapIchijiHanteiKekka.get("chukantokuten4").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai5gun().setValue(new RString(hashmapIchijiHanteiKekka.get("chukantokuten5").toString()));

        panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoChosa().setValue(new RString(hashmapIchijiHanteiKekka.get("jiritsudochosa").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoIkensho().setValue(new RString(hashmapIchijiHanteiKekka.get("jiritsudoikensho").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTxtGaizensei().setValue(new RString(hashmapIchijiHanteiKekka.get("gaizensei").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTxtJyotaiAnteisei().setValue(new RString(hashmapIchijiHanteiKekka.get("anteisei").toString()));
        panel.getCcdIchijiHanteiKakuninJoho().getTxtKyufuKbn().setValue(new RString(hashmapIchijiHanteiKekka.get("kyufukbn").toString()));

        //一次判定警告コード表示
        if (hashmapIchijiHanteiKekka.get("keikokusu").toString().equals("0")) {
            List<dgIchijiHanteiKeikokuCode_Row> arraydata = new ArrayList<>();
            panel.getCcdIchijiHanteiKakuninJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);
        } else {
            List arraydata = createRowIchijiHanteiKeikokuCode(hashmapIchijiHanteiKekka);
            panel.getCcdIchijiHanteiKakuninJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);
        }

        //ボタン活性化制御
        if ((intIdx + 1) == IchijiHanteiKekkaKakuninData.size()) {
            panel.getBtnNextHyoji().setDisabled(true);
        } else {
            panel.getBtnNextHyoji().setDisabled(false);
        }

        if (intIdx == 0) {
            panel.getBtnPreHyoji().setDisabled(true);
        } else {
            panel.getBtnPreHyoji().setDisabled(false);
        }
    }

    private List createRowIchijiHanteiKeikokuCode(HashMap IchijiHanteiKekka) {

        List arrayDataList = new ArrayList();

        for (int i = 1; i <= Integer.parseInt((String) IchijiHanteiKekka.get("keikokusu")); i++) {

            String strKey1 = "keikokuno" + i;
            String strKeikokuNo = (String) IchijiHanteiKekka.get(strKey1);

            String strKey2 = "keikokucode" + i;
            String strKeikokuCode = (String) IchijiHanteiKekka.get(strKey2);

            String strKey3 = "keikokunaiyo" + i;
            String strKeikokuNaiyo = (String) IchijiHanteiKekka.get(strKey3);

            arrayDataList.add(createRowIchijiHanteiKeikokuCode(strKeikokuNo, strKeikokuCode, strKeikokuNaiyo));
        }
        return arrayDataList;
    }

    private dgIchijiHanteiKeikokuCode_Row createRowIchijiHanteiKeikokuCode(
            String KeikokuNo,
            String KeikokuCode,
            String KeikokuNaiyo
    ) {

        dgIchijiHanteiKeikokuCode_Row rowIchijiHanteiKeikokuCode = new dgIchijiHanteiKeikokuCode_Row(
                new RString(KeikokuNo),
                new RString(KeikokuCode),
                new RString(KeikokuNaiyo)
        );
        return rowIchijiHanteiKeikokuCode;
    }

}
