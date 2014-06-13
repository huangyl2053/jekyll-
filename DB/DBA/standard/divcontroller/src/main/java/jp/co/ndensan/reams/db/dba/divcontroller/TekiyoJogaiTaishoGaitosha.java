/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgTekiyoJogaiTaishoGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 適用除外対象該当者パネルのDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiTaishoGaitosha {

    private static final RString TEKIYO_JOGAI_TAISHOSHA = new RString("TekiyoJogaiTaishosha.yml");

    /**
     * 検索ボタンを押した際に、該当者グリッドに検索結果を表示します。
     *
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSearchGaitosha(TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiTaishoGaitoshaDiv> response = new ResponseData<>();

        setGaitoshaGrid(tekiyoJogaiTaishoGaitoshaDiv.getDgTekiyoJogaiTaishoGaitosha());

        response.data = tekiyoJogaiTaishoGaitoshaDiv;
        return response;
    }

    private void setGaitoshaGrid(DataGrid<dgTekiyoJogaiTaishoGaitosha_Row> dgTekiyoJogaiTaishoGaitosha) {
        List<HashMap> gaitoshaDemoDataList = YamlLoader.FOR_DBA.loadAsList(TEKIYO_JOGAI_TAISHOSHA);
        List<dgTekiyoJogaiTaishoGaitosha_Row> tekiyoJogaiTaishoGaitoshaList = new ArrayList<>();

        for (HashMap gaitoshaDemoData : gaitoshaDemoDataList) {
            tekiyoJogaiTaishoGaitoshaList.add(createGaitoshaRow(gaitoshaDemoData));
        }

        dgTekiyoJogaiTaishoGaitosha.setDataSource(tekiyoJogaiTaishoGaitoshaList);
    }

    private dgTekiyoJogaiTaishoGaitosha_Row createGaitoshaRow(HashMap gaitoshaDemoData) {
        dgTekiyoJogaiTaishoGaitosha_Row row = new dgTekiyoJogaiTaishoGaitosha_Row(RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        row.setHihokenshaNo(new RString(gaitoshaDemoData.get("被保番号").toString()));
        row.setShimei(new RString(gaitoshaDemoData.get("氏名").toString()));
        row.setAge(new RString(gaitoshaDemoData.get("年齢").toString()));
        row.getDataOfBirth().setValue(new FlexibleDate(gaitoshaDemoData.get("生年月日").toString()));
        row.setJusho(new RString(gaitoshaDemoData.get("住所").toString()));
        row.setGender(new RString(gaitoshaDemoData.get("性別").toString()));
        return row;
    }

    /**
     * 検索した結果、該当者グリッドに複数のデータが入るとき、閉じられている該当者パネルを開きます。
     *
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onMultiRows_dgTekiyoJogaiTaishoGaitosha(TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiTaishoGaitoshaDiv> response = new ResponseData<>();
        tekiyoJogaiTaishoGaitoshaDiv.setCanOpenAndClose(true);
        response.data = tekiyoJogaiTaishoGaitoshaDiv;
        return response;
    }
}
