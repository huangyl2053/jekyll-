/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiFukaKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiKanrijohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiShoriKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgHonsanteiShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgKanrijoho1_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgKanrijoho2_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n8211
 */
public class HonsanteiFukaKakunin {
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
        
        honsanteiFukaKakuninDiv.getTxtFukaNendo().setValue(new RString("平26"));
        
        setShoriJokyo(honsanteiFukaKakuninDiv);
        setKanriJoho1(honsanteiFukaKakuninDiv);
        setKanriJoho2(honsanteiFukaKakuninDiv);
    }

    private void setShoriJokyo(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        
        HonsanteiShoriKakuninDiv honsanteiShoriKakuninDiv = honsanteiFukaKakuninDiv.getHonsanteiShoriKakunin();
        
        List<HashMap> shoriJokyoData = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0310001/ShoriJokyo.yml"));
        
        List<dgHonsanteiShoriKakunin_Row> arrayData = new ArrayList<>();
        dgHonsanteiShoriKakunin_Row item;

        for (int i = 1; i <= Integer.parseInt(shoriJokyoData.get(0).get("データ数").toString()); i++) {
                String 処理名 = (String) shoriJokyoData.get(i).get("処理名");
                String 状況 = (String) shoriJokyoData.get(i).get("状況");
                String 処理日時 = (String) shoriJokyoData.get(i).get("処理日時");
                
                item = createRowShoriJokyo(
                        処理名
                        , 状況
                        , 処理日時);
                arrayData.add(item);
        }

        DataGrid<dgHonsanteiShoriKakunin_Row> grid = honsanteiShoriKakuninDiv.getDgHonsanteiShoriKakunin();
        grid.setDataSource(arrayData);
    }

    private void setKanriJoho1(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        
        HonsanteiKanrijohoDiv honsanteiKanrijohoDiv = honsanteiFukaKakuninDiv.getHonsanteiKanrijoho();
        
        List<HashMap> kanriJoho1Data = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0310001/KanriJoho1.yml"));
        
        List<dgKanrijoho1_Row> arrayData = new ArrayList<>();
        dgKanrijoho1_Row item;

        for (int i = 1; i <= Integer.parseInt(kanriJoho1Data.get(0).get("データ数").toString()); i++) {
            
            NumberFormat isComma = NumberFormat.getNumberInstance();
            
            String 保険料段階 = (String) kanriJoho1Data.get(i).get("保険料段階");
            String 保険料率 = (String) kanriJoho1Data.get(i).get("保険料率");

            if(保険料率 != null)   保険料率   = isComma.format(parseInt(保険料率.toString()));
            item = createRowKanriJoho1(
                    保険料段階
                    , 保険料率);
            arrayData.add(item);
        }

        DataGrid<dgKanrijoho1_Row> grid = honsanteiKanrijohoDiv.getDgKanrijoho1();
        grid.setDataSource(arrayData);
    }

    private void setKanriJoho2(HonsanteiFukaKakuninDiv honsanteiFukaKakuninDiv) {
        
        HonsanteiKanrijohoDiv honsanteiKanrijohoDiv = honsanteiFukaKakuninDiv.getHonsanteiKanrijoho();
        
        List<HashMap> kanriJoho2Data = YamlLoader.FOR_DBB.loadAsList(new RString("DBB0310001/kanriJoho2.yml"));
        
        List<dgKanrijoho2_Row> arrayData = new ArrayList<>();
        dgKanrijoho2_Row item;
        
        for (int i = 1; i <= Integer.parseInt(kanriJoho2Data.get(0).get("データ数").toString()); i++) {
            String 項目 = (String) kanriJoho2Data.get(i).get("項目");
            String 内容 = (String) kanriJoho2Data.get(i).get("内容");
            
            item = createRowKanriJoho2(
                    項目
                    , 内容);
            arrayData.add(item);
        }

        DataGrid<dgKanrijoho2_Row> grid = honsanteiKanrijohoDiv.getDgKanrijoho2();
        grid.setDataSource(arrayData);
    }

    private dgHonsanteiShoriKakunin_Row createRowShoriJokyo(String 処理名, String 状況, String 処理日時) {

        dgHonsanteiShoriKakunin_Row rowShoriJokyoData = new dgHonsanteiShoriKakunin_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowShoriJokyoData.setTxtShoriMei(new RString(処理名));
        rowShoriJokyoData.setTxtJokyo(new RString(状況));
        rowShoriJokyoData.setTxtShoriNichiji(new RString(処理日時));

        return rowShoriJokyoData;
    }

    private dgKanrijoho1_Row createRowKanriJoho1(String 保険料段階, String 保険料率) {
        dgKanrijoho1_Row dgKanrijoho1_Row = new dgKanrijoho1_Row(RString.HALF_SPACE, RString.HALF_SPACE);
        
        dgKanrijoho1_Row.setTxtHokenryoDankai(new RString(保険料段階));
        dgKanrijoho1_Row.setTxtHokenryoritsu(new RString(保険料率));
        
        return dgKanrijoho1_Row;
    }

    private dgKanrijoho2_Row createRowKanriJoho2(String 項目, String 内容) {
        
        dgKanrijoho2_Row dgKanrijoho2_Row = new dgKanrijoho2_Row(RString.EMPTY, RString.EMPTY);
        
        dgKanrijoho2_Row.setTxtKoumoku(new RString(項目));
        dgKanrijoho2_Row.setTxtNaiyo(new RString(内容));
        
        return dgKanrijoho2_Row;
    }
}