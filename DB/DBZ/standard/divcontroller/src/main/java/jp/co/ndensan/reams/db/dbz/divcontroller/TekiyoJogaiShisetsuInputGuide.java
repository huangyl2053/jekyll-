/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TekiyoJogaiShisetsuInputGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgTekiyoJogaiShisetsu_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 適用除外施設入力ガイドに対応するControllerです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiShisetsuInputGuide {

    private static final RString TEKIYO_JOGAI_SHISETSU = new RString("TekiyoJogaiShisetsuData.yml");

    /**
     * ガイドの呼び出し時に、除外施設を検索して表示します。
     *
     * @param inputGuide 適用除外施設入力ガイドDiv
     * @return レスポンス
     */
    public ResponseData onLoad(TekiyoJogaiShisetsuInputGuideDiv inputGuide) {
        ResponseData<TekiyoJogaiShisetsuInputGuideDiv> response = new ResponseData<>();

        setTekiyoJogaiShisetsuData(inputGuide.getDgTekiyoJogaiShisetsu());

        response.data = inputGuide;
        return response;
    }

    private void setTekiyoJogaiShisetsuData(DataGrid<dgTekiyoJogaiShisetsu_Row> dgTekiyoJogaiShisetsu) {
        List<HashMap> demoDataList = YamlLoader.FOR_DBZ.loadAsList(TEKIYO_JOGAI_SHISETSU);
        List<dgTekiyoJogaiShisetsu_Row> tekiyhoJogaiShisetsuList = new ArrayList<>();

        for (HashMap demoData : demoDataList) {
            tekiyhoJogaiShisetsuList.add(createRowData(demoData));
        }
        dgTekiyoJogaiShisetsu.setDataSource(tekiyhoJogaiShisetsuList);
    }

    private dgTekiyoJogaiShisetsu_Row createRowData(HashMap demoData) {
        dgTekiyoJogaiShisetsu_Row row = new dgTekiyoJogaiShisetsu_Row(new Button(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.setJigyoshaNo(new RString(demoData.get("事業者コード").toString()));
        row.setJigyoshaMeisho(new RString(demoData.get("事業者名称").toString()));
        row.setJigyosha(row.getJigyoshaNo().concat(":").concat(row.getJigyoshaMeisho()));
        row.setJusho(new RString(demoData.get("住所").toString()));
        return row;
    }

    /**
     * グリッドから施設を選択した時に、入力ガイド呼び出し元に対して渡す情報を設定します。
     *
     * @param inputGuide 適用除外施設入力ガイドDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnSelect(TekiyoJogaiShisetsuInputGuideDiv inputGuide) {
        ResponseData<TekiyoJogaiShisetsuInputGuideDiv> response = new ResponseData<>();

        dgTekiyoJogaiShisetsu_Row row = inputGuide.getDgTekiyoJogaiShisetsu().getClickedItem();
        inputGuide.setShisetsuCode(row.getJigyoshaNo());
        inputGuide.setShisetsuMeisho(row.getJigyoshaMeisho());

        response.data = inputGuide;
        return response;
    }
}
