/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.SearchShisetsuNyutaishoKanriTaishoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKanriTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.dgShisetsuNyutaishoKanriGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 施設入退所管理対象を検索し、その該当者を表示するDivのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShisetsuNyutaishoKanriTaishoGaitosha {

    private static final RString SHISETSU_NYUTAISHO_KANRI_TAISHOSHA = new RString("DBA2010011/TaishoshaData.yml");

    /**
     * 対象者検索ボタンが押下されたときに、該当者グリッドに検索結果を表示します。
     *
     * @param gaitoshaDiv 該当者Div
     * @param searchDiv 検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSearchJushochiTokureiTaishosha(ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SearchShisetsuNyutaishoKanriTaishoshaDiv searchDiv) {
        ResponseData<ShisetsuNyutaishoKanriTaishoGaitoshaDiv> response = new ResponseData<>();

        DataGrid<dgShisetsuNyutaishoKanriGaitosha_Row> gaitoshaGrid = gaitoshaDiv.getDgShisetsuNyutaishoKanriGaitosha();
        setTaishoshaGrid(gaitoshaGrid);
        if (gaitoshaGrid.getDataSource().size() > 1) {
            gaitoshaDiv.setIsOpen(true);
        }

        response.data = gaitoshaDiv;
        return response;
    }

    private void setTaishoshaGrid(DataGrid<dgShisetsuNyutaishoKanriGaitosha_Row> gaitoshaGrid) {
        List<HashMap> searchGaitoshaList = YamlLoader.FOR_DBA.loadAsList(SHISETSU_NYUTAISHO_KANRI_TAISHOSHA);
        List<dgShisetsuNyutaishoKanriGaitosha_Row> gaitoshaList = new ArrayList<>();
        for (HashMap gaitosha : searchGaitoshaList) {
            gaitoshaList.add(createShisetsuNyutaishoKanriTaishosha(gaitosha));
        }
        gaitoshaGrid.setDataSource(gaitoshaList);
    }

    private dgShisetsuNyutaishoKanriGaitosha_Row createShisetsuNyutaishoKanriTaishosha(HashMap gaitosha) {
        dgShisetsuNyutaishoKanriGaitosha_Row row = new dgShisetsuNyutaishoKanriGaitosha_Row(new Button(), RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setShimei(new RString(gaitosha.get("氏名").toString()));
        row.setAge(new RString(gaitosha.get("年齢").toString()));
        row.setGender(new RString(gaitosha.get("性別").toString()));
        row.getDateOfBirth().setValue(new FlexibleDate(gaitosha.get("生年月日").toString()));
        row.setJusho(new RString(gaitosha.get("住所").toString()));
        row.setHihokenshaNo(new RString(gaitosha.get("被保番号").toString()));
        return row;
    }
}
