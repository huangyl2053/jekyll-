/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.IchijiHanteiShoriTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.dgIchijiHanteiTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 一次判定一括処理対象者一覧Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class IchijiHanteiShoriTaishoshaIchiran {

    /**
     * 一次判定一括処理対象者一覧の初期処理を表します。
     *
     * @param panel IchijiHanteiShoriTaishoshaIchiranDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> onLoad(IchijiHanteiShoriTaishoshaIchiranDiv panel) {
        ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> response = new ResponseData<>();

        int intShoriFlg = 0;
        setIchijiHanteiShoriTaishoshaData(intShoriFlg, panel);
        response.data = panel;

        return response;

    }

    /**
     * 一次判定ボタン押下時の処理を表します。
     *
     * @param panel IchijiHanteiShoriTaishoshaIchiranDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> onClick_BtnIchijiHantei(IchijiHanteiShoriTaishoshaIchiranDiv panel) {
        ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> response = new ResponseData<>();

        int intShoriFlg = 1;
        setIchijiHanteiShoriTaishoshaData(intShoriFlg, panel);
        response.data = panel;

        return response;

    }

    /**
     * 一次判定完了ボタン押下時の処理を表します。
     *
     * @param panel IchijiHanteiShoriTaishoshaIchiranDiv
     * @return ResponseData
     */
    public ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> onClick_BtnIchijiHanteiKanryo(IchijiHanteiShoriTaishoshaIchiranDiv panel) {
        ResponseData<IchijiHanteiShoriTaishoshaIchiranDiv> response = new ResponseData<>();

        int intShoriFlg = 2;
        setIchijiHanteiShoriTaishoshaData(intShoriFlg, panel);
        response.data = panel;

        return response;

    }

    /*
     *一次判定一括処理対象者一覧情報を設定します。
     */
    private void setIchijiHanteiShoriTaishoshaData(int intShoriFlg, IchijiHanteiShoriTaishoshaIchiranDiv panel) {

        List<HashMap> IchijiHanteiTaishoshaData = YamlLoader.FOR_DBE.loadAsList(new RString("dbe3010001/IchijiHanteiShoriTaishoshaIchiran.yml"));

        List<dgIchijiHanteiTaishoshaIchiran_Row> IchijiHanteiTaishoshaSelectData = panel.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();
        if (intShoriFlg == 0) {
            List arraydata = createRowIchijiHanteiTaishosha(IchijiHanteiTaishoshaData);
            DataGrid grid = panel.getDgIchijiHanteiTaishoshaIchiran();
            grid.setDataSource(arraydata);
        } else if (intShoriFlg == 1) {
            for (int i = 0; i < IchijiHanteiTaishoshaSelectData.size(); i++) {
                HashMap hashMap = IchijiHanteiTaishoshaData.get(Integer.parseInt(IchijiHanteiTaishoshaSelectData.get(i).getIndex().toString()));
                IchijiHanteiTaishoshaSelectData.get(i).setIchijiHanteibi(new RString(hashMap.get("ichijiHanteibi").toString()));
                IchijiHanteiTaishoshaSelectData.get(i).setIchijiHanteiKekka(new RString(hashMap.get("ichijiHanteiKekka").toString()));
                IchijiHanteiTaishoshaSelectData.get(i).setKeikokuCode(new RString(hashMap.get("keikokuCode").toString()));
            }

        } else if (intShoriFlg == 2) {

            Locale.setDefault(new Locale("ja", "JP", "JP"));
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat dFormat = new SimpleDateFormat("平yyyy.MM.dd");
            String strSysDate = dFormat.format(cal.getTime());

            for (int i = 0; i < IchijiHanteiTaishoshaSelectData.size(); i++) {
                if (IchijiHanteiTaishoshaSelectData.get(i).getIchijiHanteibi().isEmpty() == Boolean.FALSE) {
                    IchijiHanteiTaishoshaSelectData.get(i).setIchijiHanteiKanryobi(new RString(strSysDate));
                }
            }
        }
    }

    /*
     *一次判定一括処理対象者一覧情報の初期値をセットします。
     */
    private List createRowIchijiHanteiTaishosha(List<HashMap> IchijiHanteiTaishoshaData) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < IchijiHanteiTaishoshaData.size(); i++) {
            HashMap hashMap = IchijiHanteiTaishoshaData.get(i);
            String strHokensha = (String) hashMap.get("hokensha");
            String strHihokenNo = (String) hashMap.get("hihokenNo");
            String strHihokenshaName = (String) hashMap.get("hihokenshaName");
            String strHihokenshaKana = (String) hashMap.get("hihokenshaKana");
            String strShinseibi = (String) hashMap.get("shinseibi");
            String strShinseiKbnShin = (String) hashMap.get("shinseiKbnShin");
            String strIchijiHanteiKanryobi = "";
            String strIchijiHanteibi = "";
            String strIchijiHanteiKekka = "";
            String strKeikokuCode = "";
            String strChosaJissibi = (String) hashMap.get("chosaJissibi");
            String strIkenshoJuryobi = (String) hashMap.get("ikenshoJuryobi");

            arrayDataList.add(createRowIchijiHanteiTaishosha(
                    strHokensha,
                    strHihokenNo,
                    strHihokenshaName,
                    strHihokenshaKana,
                    strShinseibi,
                    strShinseiKbnShin,
                    strIchijiHanteibi,
                    strIchijiHanteiKanryobi,
                    strIchijiHanteiKekka,
                    strKeikokuCode,
                    strChosaJissibi,
                    strIkenshoJuryobi,
                    String.valueOf(i)
            ));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する一次判定一括処理対象者一覧データを作成します。
     */
    private dgIchijiHanteiTaishoshaIchiran_Row createRowIchijiHanteiTaishosha(
            String hokensha,
            String hihokenNo,
            String hihokenshaName,
            String hihokenshaKana,
            String shinseibi,
            String shinseiKbnShin,
            String ichijiHanteiKanryobi,
            String ichijiHanteibi,
            String ichijiHanteiKekka,
            String keikokuCode,
            String chosaJissibi,
            String ikenshoJuryobi,
            String index
    ) {

        dgIchijiHanteiTaishoshaIchiran_Row rowIchijiHanteiTaishoshaData = new dgIchijiHanteiTaishoshaIchiran_Row(
                new RString(hokensha),
                new RString(hihokenNo),
                new RString(hihokenshaName),
                new RString(hihokenshaKana),
                new RString(shinseibi),
                new RString(shinseiKbnShin),
                new RString(ichijiHanteibi),
                new RString(ichijiHanteiKanryobi),
                new RString(ichijiHanteiKekka),
                new RString(keikokuCode),
                new RString(chosaJissibi),
                new RString(ikenshoJuryobi),
                new RString(index)
        );
        return rowIchijiHanteiTaishoshaData;
    }

}
