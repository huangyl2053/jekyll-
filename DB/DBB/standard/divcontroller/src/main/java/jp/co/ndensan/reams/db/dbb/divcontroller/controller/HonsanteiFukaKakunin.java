/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiFukaKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiKanrijohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiShoriKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgHonsanteiShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgKanrijoho1_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgKanrijoho2_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n8211
 */
public class HonsanteiFukaKakunin {

    private static final RString ShoriNaiyo = new RString("DBB0310001/ShoriNaiyo.yml");

    /**
     * 初期ロード時に実行
     *
     * @param honsanteiFukaKakuninDiv
     *
     * @return
     */
    public ResponseData<HonsanteiFukaKakuninDiv> onLoad(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        ResponseData<HonsanteiFukaKakuninDiv> response = new ResponseData<>();
        setParam(honsanteiFukaKakuninDiv);
        response.data = honsanteiFukaKakuninDiv;
        return response;
    }

    private void setParam(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        List<HashMap> demoData = YamlLoader.DBB.loadAsList(ShoriNaiyo);
        ControlGenerator cg = new ControlGenerator(demoData.get(0));

        honsanteiFukaKakuninDiv.getHonsanteiShoriNaiyo().getTxtChoteiNendo().setValue(cg.getAsRString("調定年度"));
        honsanteiFukaKakuninDiv.getHonsanteiShoriNaiyo().getTxtFukaNendo().setValue(cg.getAsRString("賦課年度"));
        honsanteiFukaKakuninDiv.getHonsanteiShoriNaiyo().getTxtShotokuKijunYMD().setValue(cg.getAsRDate("所得異動基準日"));
        setShoriJokyo(honsanteiFukaKakuninDiv);
        setKanriJoho1(honsanteiFukaKakuninDiv);
        setKanriJoho2(honsanteiFukaKakuninDiv);
    }

    private void setShoriJokyo(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        HonsanteiShoriKakuninDiv honsanteiShoriKakuninDiv = honsanteiFukaKakuninDiv.getHonsanteiShoriKakunin();
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(new RString("DBB0310001/ShoriJokyo.yml"));
        List<dgHonsanteiShoriKakunin_Row> arrayData = new ArrayList<>();
        for (HashMap demoData : demoDataList) {
            dgHonsanteiShoriKakunin_Row row = new dgHonsanteiShoriKakunin_Row();
            ControlGenerator cg = new ControlGenerator(demoData);
            row.setTxtShoriMei(cg.getAsRString("処理名"));
            row.setTxtJokyo(cg.getAsRString("状況"));
            row.setTxtShoriNichiji(cg.getAsRString("処理日時"));
            arrayData.add(row);
        }
        DataGrid<dgHonsanteiShoriKakunin_Row> grid = honsanteiShoriKakuninDiv.getDgHonsanteiShoriKakunin();
        grid.setDataSource(arrayData);
    }

    private void setKanriJoho1(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        HonsanteiKanrijohoDiv honsanteiKanrijohoDiv = honsanteiFukaKakuninDiv.getHonsanteiKanrijoho();
        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(new RString("DBB0310001/KanriJoho1.yml"));
        List<dgKanrijoho1_Row> arrayData = new ArrayList<>();
        for (HashMap demoData : demoDataList) {
            dgKanrijoho1_Row row = new dgKanrijoho1_Row();
            ControlGenerator cg = new ControlGenerator(demoData);
            row.setTxtHokenryoDankai(cg.getAsRString("保険料段階"));
            row.setTxtHokenryoritsu(cg.getAsRString("保険料率"));
            arrayData.add(row);
        }
        DataGrid<dgKanrijoho1_Row> grid = honsanteiKanrijohoDiv.getDgKanrijoho1();
        grid.setDataSource(arrayData);
    }

    private void setKanriJoho2(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {

        HonsanteiKanrijohoDiv honsanteiKanrijohoDiv = honsanteiFukaKakuninDiv.getHonsanteiKanrijoho();

        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(new RString("DBB0310001/KanriJoho2.yml"));
        List<dgKanrijoho2_Row> arrayData = new ArrayList<>();
        for (HashMap demoData : demoDataList) {
            dgKanrijoho2_Row row = new dgKanrijoho2_Row();
            ControlGenerator cg = new ControlGenerator(demoData);
            row.setTxtKoumoku(cg.getAsRString("項目"));
            row.setTxtNaiyo(cg.getAsRString("内容"));
            arrayData.add(row);
        }
        DataGrid<dgKanrijoho2_Row> grid = honsanteiKanrijohoDiv.getDgKanrijoho2();
        grid.setDataSource(arrayData);
    }

}
