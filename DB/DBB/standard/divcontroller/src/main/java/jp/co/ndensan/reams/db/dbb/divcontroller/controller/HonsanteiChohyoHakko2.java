/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.dgHonsanteiTsuchisho_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonTsuchiKobetsuJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001.HonsanteiChohyoHakko2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author N8211 田辺 紘一
 */
public class HonsanteiChohyoHakko2 {

    private static final RString ChohyoHakkoShiji = new RString("DBB0310001/ChohyoHakkoShiji.yml");
    private static final RString ChohyoHakkoShiji2 = new RString("DBB0310001/ChohyoHakkoShiji2.yml");

    /**
     * onLoad
     *
     * @param div
     * @return ResponseData
     */
    public ResponseData<HonsanteiChohyoHakko2Div> onLoad(HonsanteiChohyoHakko2Div div) {

        loadDataGrid(div);

        return _createResponseData(div);
    }

    private ResponseData<HonsanteiChohyoHakko2Div> _createResponseData(HonsanteiChohyoHakko2Div div) {
        ResponseData<HonsanteiChohyoHakko2Div> response = new ResponseData<>();
        response.data = div;
        return response;
    }
    
    private void loadDataGrid(HonsanteiChohyoHakko2Div div) {

        List<HashMap> demoDataList = YamlLoader.DBB.loadAsList(ChohyoHakkoShiji);
        List<HashMap> demoDataList2 = YamlLoader.DBB.loadAsList(ChohyoHakkoShiji2);

        ControlGenerator cg2 = new ControlGenerator(demoDataList2.get(0));

        div.getTxtHakkoYMD().setValue(cg2.getAsRDate("発行日"));
        div.getHonTsuchiKobetsuJoho().getTxtKetteiTsuchiYousikiSettei().setValue(new RString("特徴開始通知が出力されない被保険者のみ出力"));
        List dataGrid = new ArrayList();
        for (HashMap demoData : demoDataList) {

            ControlGenerator cg = new ControlGenerator(demoData);
            dgHonsanteiTsuchisho_Row row = new dgHonsanteiTsuchisho_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

            row.setTxtChohyoName(cg.getAsRString("帳票名"));
            row.setTxtShutsuryokuJun1(cg.getAsRString("出力順項目名1"));
            row.setTxtShutsuryokuJun2(cg.getAsRString("出力順項目名2"));
            row.setTxtShutsuryokuJun3(cg.getAsRString("出力順項目名3"));
            row.setTxtShutsuryokuJun4(cg.getAsRString("出力順項目名4"));
            row.setTxtShutsuryokuJun5(cg.getAsRString("出力順項目名5"));

            dataGrid.add(row);
        }

        DataGrid<dgHonsanteiTsuchisho_Row> grid = div.getDgHonsanteiTsuchisho();
        grid.setDataSource(dataGrid);
    }
  
    public ResponseData<HonsanteiChohyoHakko2Div> change_txtKetteiTsuchiYousikiSettei(HonsanteiChohyoHakko2Div div) {
        div.getHonTsuchiKobetsuJoho().getTxtKetteiTsuchiYousikiSettei().setValue(new RString("還付対象者、特徴が中止となった被保険者は変更通知書を出力"));
        return _createResponseData(div);
    }    
}
