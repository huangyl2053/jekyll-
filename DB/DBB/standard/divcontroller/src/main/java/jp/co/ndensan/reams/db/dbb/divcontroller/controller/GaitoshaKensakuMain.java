/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.GaitoshaKensakuMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgdGaitoushaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N1319
 */
public class GaitoshaKensakuMain {

    private static final RString FUKA_SHOKAI_GAITOSHA = new RString("FukaShokaiGaitoshaData.yml");

    public ResponseData<GaitoshaKensakuMainDiv> getOnLoadData(GaitoshaKensakuMainDiv panel) {
        ResponseData<GaitoshaKensakuMainDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    public ResponseData<GaitoshaKensakuMainDiv> onClick_BtnSearch(GaitoshaKensakuMainDiv panel) {
        ResponseData<GaitoshaKensakuMainDiv> response = new ResponseData<>();
        panel.getGaitoshaSentaku().getTxtFukanendo().setValue(new RDate(2014));
        List<dgdGaitoushaIchiran_Row> arrayData = createRowGaitoshaIchiranData();
        DataGrid<dgdGaitoushaIchiran_Row> grid = panel.getGaitoshaSentaku().getDgdGaitoushaIchiran();
        grid.setDataSource(arrayData);
        response.data = panel;
        return response;
    }

    private List<dgdGaitoushaIchiran_Row> createRowGaitoshaIchiranData() {
        List<dgdGaitoushaIchiran_Row> arrayData = new ArrayList<>();

        List<HashMap> demoDataList = YamlLoader.FOR_DBB.loadAsList(FUKA_SHOKAI_GAITOSHA);
        for (HashMap demoData : demoDataList) {
            // コンストラクタにMapを渡して生成。
            ControlGenerator cg = new ControlGenerator(demoData);
            dgdGaitoushaIchiran_Row row = new dgdGaitoushaIchiran_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

            row.setTxtChoteiNendo(cg.getAsRString("調定年度"));
            row.setTxtTsuchiNo(cg.getAsRString("通知書番号"));
            row.setTxtHihoNo(cg.getAsRString("被保番号"));
            row.setTxtName(cg.getAsRString("氏名"));
            row.setTxtUmareYmd(cg.getAsTextBoxFlexibleDate("生年月日"));
            row.setTxtSeibetsu(cg.getAsRString("性別"));
            row.setTxtShubetsu(cg.getAsRString("住民種別"));
            row.setTxtJusho(cg.getAsRString("住所"));
            row.setTxtShikbetsuCode(cg.getAsRString("識別コード"));

            arrayData.add(row);
        }
        return arrayData;
    }

}
