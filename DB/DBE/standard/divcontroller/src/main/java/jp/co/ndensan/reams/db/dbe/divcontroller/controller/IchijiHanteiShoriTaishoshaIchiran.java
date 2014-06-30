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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

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
        setDisabled_btnCommonConfirmResult(true);
        setDisabled_btnCommonCompleteIchijiHantei(true);

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

        if (!panel.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems().isEmpty()) {
            setDisabled_btnCommonConfirmResult(false);
            setDisabled_btnCommonCompleteIchijiHantei(false);
        }

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

        List<HashMap> ichijiHanteiTaishoshaData = YamlLoader.DBE.loadAsList(new RString("dbe3010001/IchijiHanteiShoriTaishoshaIchiran.yml"));

        List<dgIchijiHanteiTaishoshaIchiran_Row> ichijiHanteiTaishoshaSelectData = panel.getDgIchijiHanteiTaishoshaIchiran().getSelectedItems();
        if (intShoriFlg == 0) {
            List arraydata = createRowIchijiHanteiTaishosha(ichijiHanteiTaishoshaData);
            DataGrid grid = panel.getDgIchijiHanteiTaishoshaIchiran();
            grid.setDataSource(arraydata);
        } else if (intShoriFlg == 1) {
            for (int i = 0; i < ichijiHanteiTaishoshaSelectData.size(); i++) {
                ControlGenerator cg = new ControlGenerator(ichijiHanteiTaishoshaData.
                        get(Integer.parseInt(ichijiHanteiTaishoshaSelectData.get(i).getIndex().toString())));
                TextBoxFlexibleDate ichijiDate = new TextBoxFlexibleDate();
                ichijiDate.setValue(FlexibleDate.getNowDate());
                ichijiHanteiTaishoshaSelectData.get(i).setIchijiHanteibi(ichijiDate);
                ichijiHanteiTaishoshaSelectData.get(i).setIchijiHanteiKekka(cg.getAsRString("ichijiHanteiKekka"));
                ichijiHanteiTaishoshaSelectData.get(i).setKeikokuCode(cg.getAsRString("keikokuCode"));
            }

        } else if (intShoriFlg == 2) {

            for (int i = 0; i < ichijiHanteiTaishoshaSelectData.size(); i++) {
                if (ichijiHanteiTaishoshaSelectData.get(i).getIchijiHanteibi().getValue().isEmpty() == Boolean.FALSE) {
                    TextBoxFlexibleDate kanryoDate = new TextBoxFlexibleDate();
                    kanryoDate.setValue(FlexibleDate.getNowDate());
                    ichijiHanteiTaishoshaSelectData.get(i).setIchijiHanteiKanryobi(kanryoDate);
                }
            }
        }
    }

    /*
     *一次判定一括処理対象者一覧情報の初期値をセットします。
     */
    private List createRowIchijiHanteiTaishosha(List<HashMap> ichijiHanteiTaishoshaData) {

        List arrayDataList = new ArrayList();

        for (int i = 0; i < ichijiHanteiTaishoshaData.size(); i++) {
            ControlGenerator cg = new ControlGenerator(ichijiHanteiTaishoshaData.get(i));
            RString strHokensha = cg.getAsRString("hokensha");
            RString strHihokenNo = cg.getAsRString("hihokenNo");
            RString strHihokenshaName = cg.getAsRString("hihokenshaName");
            RString strHihokenshaKana = cg.getAsRString("hihokenshaKana");
            TextBoxFlexibleDate strShinseibi = cg.getAsTextBoxFlexibleDate("shinseibi");
            RString strShinseiKbnShin = cg.getAsRString("shinseiKbnShin");
            TextBoxFlexibleDate strIchijiHanteiKanryobi = new TextBoxFlexibleDate();
            TextBoxFlexibleDate strIchijiHanteibi = new TextBoxFlexibleDate();
            RString strIchijiHanteiKekka = new RString("");
            RString strKeikokuCode = new RString("");
            TextBoxFlexibleDate strChosaJissibi = cg.getAsTextBoxFlexibleDate("chosaJissibi");
            TextBoxFlexibleDate strIkenshoJuryobi = cg.getAsTextBoxFlexibleDate("ikenshoJuryobi");
            RString strIdx = new RString(String.valueOf(i));

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
                    strIdx
            ));
        }
        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する一次判定一括処理対象者一覧データを作成します。
     */
    private dgIchijiHanteiTaishoshaIchiran_Row createRowIchijiHanteiTaishosha(
            RString hokensha,
            RString hihokenNo,
            RString hihokenshaName,
            RString hihokenshaKana,
            TextBoxFlexibleDate shinseibi,
            RString shinseiKbnShin,
            TextBoxFlexibleDate ichijiHanteiKanryobi,
            TextBoxFlexibleDate ichijiHanteibi,
            RString ichijiHanteiKekka,
            RString keikokuCode,
            TextBoxFlexibleDate chosaJissibi,
            TextBoxFlexibleDate ikenshoJuryobi,
            RString index
    ) {

        dgIchijiHanteiTaishoshaIchiran_Row rowIchijiHanteiTaishoshaData = new dgIchijiHanteiTaishoshaIchiran_Row(
                hokensha, hihokenNo, hihokenshaName, hihokenshaKana, shinseibi, shinseiKbnShin, ichijiHanteibi, ichijiHanteiKanryobi,
                ichijiHanteiKekka, keikokuCode, chosaJissibi, ikenshoJuryobi, index);
        return rowIchijiHanteiTaishoshaData;
    }

    private void setDisabled_btnCommonConfirmResult(boolean disabled) {
        try {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnCommonConfirmResult"), disabled);
        } catch (Exception e) {
        }
    }

    private void setDisabled_btnCommonCompleteIchijiHantei(boolean disabled) {
        try {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnCommonCompleteIchijiHantei"), disabled);
        } catch (Exception e) {
        }
    }

}
