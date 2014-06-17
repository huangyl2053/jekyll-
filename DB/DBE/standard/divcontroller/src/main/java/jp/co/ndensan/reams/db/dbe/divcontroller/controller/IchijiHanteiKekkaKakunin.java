/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.IchijiHanteiKekkaKakuninDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.IchijiHanteiShoriTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ichijiHanteiKekkaInfo.dgIchijiHanteiKeikokuCode_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定結果詳細表示Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class IchijiHanteiKekkaKakunin {

    /**
     * 一次判定確認ボタン押下時の一次判定結果詳細画面初期表示処理を表します。
     *
     * @param panel IchijiHanteiKekkaKakuninDiv
     * @param panel2 IchijiHanteiShoriTaishoshaIchiranDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel,
            IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
        ResponseData<IchijiHanteiKekkaKakuninDiv> response = new ResponseData<>();

        panel.setHidIdxNo(new RString("0"));
        setIchijiHanteiKekkaShosaiData(panel, panel2);

        response.data = panel;
        return response;
    }

    /**
     * 次対象者表示ボタン押下時の一次判定結果詳細画面表示処理を表します。
     *
     * @param panel IchijiHanteiKekkaKakuninDiv
     * @param panel2 IchijiHanteiShoriTaishoshaIchiranDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispNextIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel,
            IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
        ResponseData<IchijiHanteiKekkaKakuninDiv> response = new ResponseData<>();

        panel.setHidIdxNo(new RString(String.valueOf(Integer.parseInt(panel.getHidIdxNo().toString()) + 1)));
        setIchijiHanteiKekkaShosaiData(panel, panel2);

        response.data = panel;
        return response;
    }

    /**
     * 前対象者表示ボタン押下時の一次判定結果詳細画面表示処理を表します。
     *
     * @param panel IchijiHanteiKekkaKakuninDiv
     * @param panel2 IchijiHanteiShoriTaishoshaIchiranDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispPreIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel,
            IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
        ResponseData<IchijiHanteiKekkaKakuninDiv> response = new ResponseData<>();

        panel.setHidIdxNo(new RString(String.valueOf(Integer.parseInt(panel.getHidIdxNo().toString()) - 1)));
        setIchijiHanteiKekkaShosaiData(panel, panel2);

        response.data = panel;
        return response;
    }

    /*
     *一次判定結果詳細情報を取得、設定します。
     */
    private void setIchijiHanteiKekkaShosaiData(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {

        StringBuilder stbKensu;
        int intIdx;

        List<HashMap> ichijiHanteiKekkaShosai = YamlLoader.DBE.
                loadAsList(new RString("dbe3010001/IchijiHanteiKekkaKakunin.yml"));

        List<dgIchijiHanteiTaishoshaIchiran_Row> ichijiHanteiKekkaKakuninData
                = panel2.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();

        if (ichijiHanteiKekkaKakuninData.isEmpty()) {
            panel.getTxtKensu().clearValue();
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHokensha().clearValue();
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHihokenNo().clearValue();
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHihokenshaName().clearValue();
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtShinseibi().clearValue();
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtShinseiKbnShin().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteibi().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteiKekka().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtKijunJikan().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtShokuji().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtHaisetsu().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIdo().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtSeiketsuHoji().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKansetsuCare().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtBpsdKanren().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKinoKunren().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIryoKanren().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtNinchishoKasan().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai1gun().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai2gun().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai3gun().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai4gun().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai5gun().clearValue();

            panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoChosa().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoIkensho().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtGaizensei().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtJyotaiAnteisei().clearValue();
            panel.getCcdIchijiHanteiKakuninJoho().getTxtKyufuKbn().clearValue();

            List<dgIchijiHanteiKeikokuCode_Row> arraydata = new ArrayList<>();
            panel.getCcdIchijiHanteiKakuninJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);

        } else {
            intIdx = Integer.parseInt(panel.getHidIdxNo().toString());
            HashMap hashmapIchijiHanteiKekka = ichijiHanteiKekkaShosai.
                    get(Integer.parseInt(ichijiHanteiKekkaKakuninData.get(intIdx).getIndex().toString()));
            ControlGenerator cg = new ControlGenerator(hashmapIchijiHanteiKekka);
            stbKensu = new StringBuilder();
            stbKensu.append(intIdx + 1);
            stbKensu.append(" / ");
            stbKensu.append(ichijiHanteiKekkaKakuninData.size());
            panel.getTxtKensu().setValue(new RString(stbKensu.toString()));

            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHokensha().setValue(ichijiHanteiKekkaKakuninData.
                    get(intIdx).getHokensha());
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHihokenNo().setValue(ichijiHanteiKekkaKakuninData.
                    get(intIdx).getHihokenNo());
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtHihokenshaName().setValue(ichijiHanteiKekkaKakuninData.
                    get(intIdx).getHihokenshaName());
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtShinseibi().setValue(ichijiHanteiKekkaKakuninData.
                    get(intIdx).getShinseibi().getValue());
            panel.getIchijiHanteiKakuninTaishoshaJoho().getTxtShinseiKbnShin().setValue(ichijiHanteiKekkaKakuninData.
                    get(intIdx).getShinseiKbnShin());

            if (ichijiHanteiKekkaKakuninData.get(intIdx).getIchijiHanteibi().getValue().isEmpty()) {
                panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteibi().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteiKekka().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTxtKijunJikan().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtShokuji().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtHaisetsu().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIdo().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtSeiketsuHoji().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKansetsuCare().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtBpsdKanren().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKinoKunren().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIryoKanren().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtNinchishoKasan().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai1gun().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai2gun().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai3gun().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai4gun().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai5gun().clearValue();

                panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoChosa().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoIkensho().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTxtGaizensei().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTxtJyotaiAnteisei().clearValue();
                panel.getCcdIchijiHanteiKakuninJoho().getTxtKyufuKbn().clearValue();

                List<dgIchijiHanteiKeikokuCode_Row> arraydata = new ArrayList<>();
                panel.getCcdIchijiHanteiKakuninJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);
            } else {
                panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteibi().
                        setValue(ichijiHanteiKekkaKakuninData.get(intIdx).getIchijiHanteibi().getValue());
                panel.getCcdIchijiHanteiKakuninJoho().getTxtIchijiHanteiKekka().setValue(cg.getAsRString("kaigodo"));
                panel.getCcdIchijiHanteiKakuninJoho().getTxtKijunJikan().setValue(cg.getAsRString("kijunjikan"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtShokuji().setValue(cg.getAsRString("shokuji"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtHaisetsu().setValue(cg.getAsRString("haisetsu"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIdo().setValue(cg.getAsRString("ido"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtSeiketsuHoji().setValue(cg.getAsRString("seiketsuhoji"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKansetsuCare().setValue(cg.getAsRString("kansetsucare"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtBpsdKanren().setValue(cg.getAsRString("bpsd"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtKinoKunren().setValue(cg.getAsRString("kinokunren"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtIryoKanren().setValue(cg.getAsRString("iryokanren"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblKijunJikan().getTxtNinchishoKasan().setValue(cg.getAsRString("ninchishokasan"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai1gun().setValue(cg.getAsRString("chukantokuten1"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai2gun().setValue(cg.getAsRString("chukantokuten2"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai3gun().setValue(cg.getAsRString("chukantokuten3"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai4gun().setValue(cg.getAsRString("chukantokuten4"));
                panel.getCcdIchijiHanteiKakuninJoho().getTblTyukanHyokaKomokuTokuten().getTxtDai5gun().setValue(cg.getAsRString("chukantokuten5"));

                panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoChosa().setValue(cg.getAsRString("jiritsudochosa"));
                panel.getCcdIchijiHanteiKakuninJoho().getTxtJiritsudoIkensho().setValue(cg.getAsRString("jiritsudoikensho"));
                panel.getCcdIchijiHanteiKakuninJoho().getTxtGaizensei().setValue(cg.getAsRString("gaizensei"));
                panel.getCcdIchijiHanteiKakuninJoho().getTxtJyotaiAnteisei().setValue(cg.getAsRString("anteisei"));
                panel.getCcdIchijiHanteiKakuninJoho().getTxtKyufuKbn().setValue(cg.getAsRString("kyufukbn"));

                if (hashmapIchijiHanteiKekka.get("keikokusu").toString().equals("0")) {
                    List<dgIchijiHanteiKeikokuCode_Row> arraydata = new ArrayList<>();
                    panel.getCcdIchijiHanteiKakuninJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);
                } else {
                    List arraydata = createRowIchijiHanteiKeikokuCode(hashmapIchijiHanteiKekka);
                    panel.getCcdIchijiHanteiKakuninJoho().getDgIchijiHanteiKeikokuCode().setDataSource(arraydata);
                }
            }

            //ボタン活性化制御
            if ((intIdx + 1) == ichijiHanteiKekkaKakuninData.size()) {
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
    }

    /*
     *一次判定警告コードデータグリッド情報を設定します。
     */
    private List createRowIchijiHanteiKeikokuCode(HashMap ichijiHanteiKekka) {

        List arrayDataList = new ArrayList();

        for (int i = 1; i <= Integer.parseInt((String) ichijiHanteiKekka.get("keikokusu")); i++) {

            ControlGenerator cg = new ControlGenerator(ichijiHanteiKekka);
//            RString strKey1 = new RString("keikokuno" + i);
            RString strKeikokuNo = cg.getAsRString("keikokuno" + i);

//            String strKey2 = "keikokucode" + i;
            RString strKeikokuCode = cg.getAsRString("keikokucode" + i);

//            String strKey3 = "keikokunaiyo" + i;
            RString strKeikokuNaiyo = cg.getAsRString("keikokunaiyo" + i);

            arrayDataList.add(createRowIchijiHanteiKeikokuCode(strKeikokuNo, strKeikokuCode, strKeikokuNaiyo));
        }
        return arrayDataList;
    }

    private dgIchijiHanteiKeikokuCode_Row createRowIchijiHanteiKeikokuCode(
            RString keikokuNo,
            RString keikokuCode,
            RString keikokuNaiyo
    ) {

        dgIchijiHanteiKeikokuCode_Row rowIchijiHanteiKeikokuCode = new dgIchijiHanteiKeikokuCode_Row(
                keikokuNo, keikokuCode, keikokuNaiyo);
        return rowIchijiHanteiKeikokuCode;
    }

}
