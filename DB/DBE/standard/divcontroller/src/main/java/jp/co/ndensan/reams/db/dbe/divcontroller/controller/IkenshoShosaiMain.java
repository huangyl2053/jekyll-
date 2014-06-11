/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.IkenshoShosaiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001.ShujiiIkenshoImageTorikomiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 意見書OCR取込みデータ詳細表示Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class IkenshoShosaiMain {

    /**
     * 意見書取込み対象者一覧データグリッド上の対象者選択時の処理を表します。
     *
     * @param panel IkenshoShosaiMainDiv
     * @param panel2 ShujiiIkenshoImageTorikomiDiv
     * @return ResponseData
     */
    public ResponseData<IkenshoShosaiMainDiv> dispIkenshoKekkaShosai(IkenshoShosaiMainDiv panel, ShujiiIkenshoImageTorikomiDiv panel2) {
        ResponseData<IkenshoShosaiMainDiv> response = new ResponseData<>();
        int iSelectId = panel2.getDgIkenshoTorikomiKekka().getClickedRowId();
        setIkenshoKekkaShosaiData(panel, panel2, iSelectId);
        panel.getIkenshoShosaiImageHyoji().getTxtHyojiBairitsu().setValue(new Decimal(100));

        response.data = panel;
        return response;

    }

    /*
     *意見書結果詳細情報を取得します。
     */
    private void setIkenshoKekkaShosaiData(IkenshoShosaiMainDiv panel, ShujiiIkenshoImageTorikomiDiv panel2, int iSelectId) {

        List<HashMap> ikenshoKekkaShosai = YamlLoader.DBE.loadAsList(new RString("dbe2070001/IkenshoKekkaShosaiMain.yml"));

//        HashMap hashMap = ikenshoKekkaShosai.get(iSelectId);
        ControlGenerator cg = new ControlGenerator(ikenshoKekkaShosai.get(iSelectId));

        RString strHokenshaNo = cg.getAsRString("hokenshaNo");
        RString strShinseiKbn = cg.getAsRString("shinseiKbn");
        RString strIryoKikanNo = cg.getAsRString("iryoKikanNo");
        RString strShujiiNo = cg.getAsRString("shujiiNo");
        RString strIryoKikanMei = cg.getAsRString("iryoKikanMei");
        RString strShujiiMei = cg.getAsRString("shujiiMei");
        RString strNetakirido = cg.getAsRString("netakirido");
        RString strNinchi = cg.getAsRString("ninchi");
        RString strTankiKioku = cg.getAsRString("tankikioku");
        RString strNinchiNoryoku = cg.getAsRString("ninchinoryoku");
        RString strDentatsuNoryoku = cg.getAsRString("dentatsunoryoku");
        RString strShokujiKoi = cg.getAsRString("shokujikoi");

        panel.getKihonJoho().getTxtHokenNo().setValue(strHokenshaNo);
        panel.getKihonJoho().getTxtHihokenNo().setValue(panel2.getDgIkenshoTorikomiKekka().getActiveRow().getHihokenNo());
        panel.getKihonJoho().getTxtShinseibi().setValue(new RDate(panel2.getDgIkenshoTorikomiKekka().getActiveRow().
                getShinseibi().toString()));
        panel.getKihonJoho().getDdlShinseiKbn().setSelectedItem(strShinseiKbn);

        panel.getIkenshoItakuJoho().getTxtIryokikanNo().setValue(strIryoKikanNo);
        panel.getIkenshoItakuJoho().getTxtShujiiNo().setValue(strShujiiNo);
        panel.getIkenshoItakuJoho().getTxtIryokikanMei().setValue(strIryoKikanMei);
        panel.getIkenshoItakuJoho().getTxtShujiiMei().setValue(strShujiiMei);
        panel.getIkenshoItakuJoho().getTxtIkenshoKinyubi().setValue(new RDate(panel2.getDgIkenshoTorikomiKekka().
                getActiveRow().getIkenshoKinyubi().toString()));
        panel.getIkenshoItakuJoho().getTxtIkenshoJuryobi().setValue(new RDate(panel2.getDgIkenshoTorikomiKekka().
                getActiveRow().getIkenshoJuryobi().toString()));

        panel.getIkensho5Komoku().getTblIkensho5Komoku().getDdlNetakirido().setSelectedItem(strNetakirido);
        panel.getIkensho5Komoku().getTblIkensho5Komoku().getDdlNinchi().setSelectedItem(strNinchi);
        panel.getIkensho5Komoku().getTblIkensho5Komoku().getDdlTankikioku().setSelectedItem(strTankiKioku);
        panel.getIkensho5Komoku().getTblIkensho5Komoku().getDdlNinchiNoryoku().setSelectedItem(strNinchiNoryoku);
        panel.getIkensho5Komoku().getTblIkensho5Komoku().getDdlDentatsuNoryoku().setSelectedItem(strDentatsuNoryoku);
        panel.getIkensho5Komoku().getTblIkensho5Komoku().getDdlShokujiKoi().setSelectedItem(strShokujiKoi);

    }

}
