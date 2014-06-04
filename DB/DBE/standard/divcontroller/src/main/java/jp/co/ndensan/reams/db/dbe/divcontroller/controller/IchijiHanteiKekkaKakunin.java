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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIchijiHanteiKeikokuCode_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
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
    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispNextIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
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
    public ResponseData<IchijiHanteiKekkaKakuninDiv> dispPreIchijiHanteiKekkaShosai(IchijiHanteiKekkaKakuninDiv panel, IchijiHanteiShoriTaishoshaIchiranDiv panel2) {
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

        List<HashMap> IchijiHanteiKekkaShosai = YamlLoader.FOR_DBE.loadAsList(new RString("dbe3010001/IchijiHanteiKekkaKakunin.yml"));

        List<dgIchijiHanteiTaishoshaIchiran_Row> IchijiHanteiKekkaKakuninData = panel2.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();

        if (IchijiHanteiKekkaKakuninData.isEmpty()) {
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
            if (IchijiHanteiKekkaKakuninData.get(intIdx).getIchijiHanteibi().isEmpty()) {
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
    }

    /*
     *一次判定警告コードデータグリッド情報を設定します。
     */
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
