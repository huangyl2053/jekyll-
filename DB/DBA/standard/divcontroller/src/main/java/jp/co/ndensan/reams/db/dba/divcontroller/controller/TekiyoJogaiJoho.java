/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.controller.helper.DemoKojin;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.JogaishaTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.TekiyoJogaiJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.TekiyoJogaiTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.dgTekiyoJogaiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011.TekiyoJogaiTaishoshaSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShisetsuJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 適用除外情報を表示するDivに対応したControllerです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiJoho {

    private static final RString TEKIYO_JOGAI_SHISETSU = new RString("DBA2050011/tekiyoJogaiShisetsu.yml");

    /**
     * 対象者検索で、適用除外処理を行う個人が選択された際に実行します。<br/>
     * 適用除外グリッドにデータを設定します。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnToDecide(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv, TekiyoJogaiTaishoshaSearchDiv searchDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();

        DemoKojin demoKojin = new DemoKojin("第1号");
        RString hihokenshaNo = demoKojin.getHihokenshaNo();
        //RString hihokenshaNo = searchDiv.getSearchResult().getDgSearchResult().getClickedItem().getHihokenshaNo();
        setTekiyoJogaiGrid(tekiyoJogaiJohoDiv.getDgTekiyoJogaiRireki(), hihokenshaNo);
        ShisetsuJoho.setTekiyoJogaiMode(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku().getJogaishaTekiyoInput().getJogaishaTekiyoJogaiShisetsu());

        response.data = tekiyoJogaiJohoDiv;
        return response;

    }

    private void setTekiyoJogaiGrid(DataGrid<dgTekiyoJogaiRireki_Row> grid, RString hihokenshaNo) {
        List<HashMap> yamlTekiyoJogaiDataList = YamlLoader.DBA.loadAsList(TEKIYO_JOGAI_SHISETSU);
        List<HashMap> tekiyoJogiaDataList = new ArrayList<>();
        for (HashMap yamlTekiyoJogaiData : yamlTekiyoJogaiDataList) {
            ControlGenerator generator = new ControlGenerator(yamlTekiyoJogaiData);
            if (generator.getAsRString("被保番号").equals(hihokenshaNo)) {
                tekiyoJogiaDataList = (List<HashMap>) generator.get("適用除外");
            }
        }

        List<dgTekiyoJogaiRireki_Row> tekiyoJogaiDataSource = new ArrayList<>();
        for (HashMap tekiyoJogaiData : tekiyoJogiaDataList) {
            tekiyoJogaiDataSource.add(createTekiyoJogaiRirekiForYaml(new ControlGenerator(tekiyoJogaiData)));
        }
        grid.setDataSource(tekiyoJogaiDataSource);
    }

    private dgTekiyoJogaiRireki_Row createTekiyoJogaiRirekiForYaml(ControlGenerator controlGenerator) {
        dgTekiyoJogaiRireki_Row row = createTekiyoJogaiRirekiNewRow();

        row.setTekiyoJiyuKey(controlGenerator.getAsRString("適用事由Key"));
        row.setTekiyoJiyu(controlGenerator.getAsRString("適用事由"));
        row.getTekiyoDate().setValue(controlGenerator.getAsFlexibleDate("適用日"));
        row.getTekiyoTodokedeDate().setValue(controlGenerator.getAsFlexibleDate("適用届出日"));
        row.setKaijoJiyuKey(controlGenerator.getAsRString("解除事由Key"));
        row.setKaijoJiyu(controlGenerator.getAsRString("解除事由"));
        row.getKaijoDate().setValue(controlGenerator.getAsFlexibleDate("解除日"));
        row.getKaijoTodokedeDate().setValue(controlGenerator.getAsFlexibleDate("解除届出日"));
        row.getNyushoDate().setValue(controlGenerator.getAsFlexibleDate("入所日"));
        row.getTaishoDate().setValue(controlGenerator.getAsFlexibleDate("退所日"));
        row.setShisetsuCode(controlGenerator.getAsRString("施設コード"));
        row.setShisetsuMeisho(controlGenerator.getAsRString("施設名称"));
        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
        row.getNyushoTsuchiHakkoDate().setValue(controlGenerator.getAsFlexibleDate("入所通知発効日"));
        row.getTaishoTsuchiHakkoDate().setValue(controlGenerator.getAsFlexibleDate("退所通知発効日"));
        row.getHenkoTsuchiHakkoDate().setValue(controlGenerator.getAsFlexibleDate("変更通知発効日"));
        return row;
    }

    /**
     * 適用除外情報を確定するボタンを押した際に、適用除外情報グリッドに情報を追加します。<br/>
     * 追加された入力情報は、適用除外情報入力Divからクリアされます。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onClick_btnInsertTekiyoJogaiJoho(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv, TekiyoJogaiTaishoshaSearchDiv searchDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();

        insertNewData(tekiyoJogaiJohoDiv.getDgTekiyoJogaiRireki(),
                tekiyoJogaiJohoDiv.getTekiyoJogaiToroku());

        clearInputValue(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku());
        tekiyoJogaiJohoDiv.getTekiyoJogaiToroku().setReadOnly(true);
        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

    private void insertNewData(DataGrid<dgTekiyoJogaiRireki_Row> dgTekiyoJogaiRireki, TekiyoJogaiTorokuDiv tekiyoJogaiToroku) {
        List<dgTekiyoJogaiRireki_Row> tekiyoJogaiRirekiList = new ArrayList<>();
        dgTekiyoJogaiRireki_Row item = createTekiyoJogaiRirekiRowForInputData(tekiyoJogaiToroku.getJogaishaTekiyoInput(), createTekiyoJogaiRirekiNewRow());
        tekiyoJogaiRirekiList.add(item);
        dgTekiyoJogaiRireki.setDataSource(tekiyoJogaiRirekiList);
    }

    private dgTekiyoJogaiRireki_Row createTekiyoJogaiRirekiNewRow() {
        return new dgTekiyoJogaiRireki_Row(RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.HALF_SPACE, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate());
    }

    private dgTekiyoJogaiRireki_Row createTekiyoJogaiRirekiRowForInputData(JogaishaTekiyoInputDiv jogaishaTekiyoInput, dgTekiyoJogaiRireki_Row row) {
        row.setRowState(RowState.Added);
        row.setTekiyoJiyuKey(jogaishaTekiyoInput.getDdlTekiyoJiyu().getSelectedItem());
        row.setTekiyoJiyu(jogaishaTekiyoInput.getDdlTekiyoJiyu().getSelectedValue());
        row.getTekiyoDate().setValue(jogaishaTekiyoInput.getTxtTekiyoDate().getValue());
        row.getTekiyoTodokedeDate().setValue(jogaishaTekiyoInput.getTxtTekiyoTodokedeDate().getValue());
        row.getNyushoDate().setValue(jogaishaTekiyoInput.getTxtShisetsuNyushoDate().getValue());
        row.setShisetsuCode(jogaishaTekiyoInput.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuCode().getValue());
        row.setShisetsuMeisho(jogaishaTekiyoInput.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuMeisho().getValue());
        row.setShisetsu(row.getShisetsuCode().concat(new RString(":")).concat(row.getShisetsuMeisho()));
        return row;
    }

    private void clearInputValue(TekiyoJogaiTorokuDiv torokuDiv) {
        JogaishaTekiyoInputDiv inputDiv = torokuDiv.getJogaishaTekiyoInput();
        inputDiv.getDdlTekiyoJiyu().setSelectedItem(new RString("jogaishaTekiyo"));
        inputDiv.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuCode().setValue(RString.EMPTY);
        inputDiv.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuMeisho().setValue(RString.EMPTY);
        inputDiv.getTxtShisetsuNyushoDate().setValue(null);
        inputDiv.getTxtTekiyoDate().setValue(null);
        inputDiv.getTxtTekiyoTodokedeDate().setValue(null);
    }

    /**
     * グリッド内の修正ボタンを押した際に、修正する行の情報を入力Divに表示します。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onSelectByModifyButton_dgTekiyoJogaiRireki(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv, TekiyoJogaiTaishoshaSearchDiv searchDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();
        setTekiyoJogaiToroku(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku(), tekiyoJogaiJohoDiv.getDgTekiyoJogaiRireki().getClickedItem());
        tekiyoJogaiJohoDiv.getTekiyoJogaiToroku().setReadOnly(false);

        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

    private void setTekiyoJogaiToroku(TekiyoJogaiTorokuDiv tekiyoJogaiToroku, dgTekiyoJogaiRireki_Row clickedItem) {
        JogaishaTekiyoInputDiv inputDiv = tekiyoJogaiToroku.getJogaishaTekiyoInput();
        inputDiv.getDdlTekiyoJiyu().setSelectedItem(clickedItem.getTekiyoJiyuKey());
        inputDiv.getTxtShisetsuNyushoDate().setValue(clickedItem.getNyushoDate().getValue());
        inputDiv.getTxtTekiyoDate().setValue(clickedItem.getTekiyoDate().getValue());
        inputDiv.getTxtTekiyoTodokedeDate().setValue(clickedItem.getTekiyoTodokedeDate().getValue());
        inputDiv.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuCode().setValue(clickedItem.getShisetsuCode());
        inputDiv.getJogaishaTekiyoJogaiShisetsu().getTxtShisetsuMeisho().setValue(clickedItem.getShisetsuMeisho());
    }

    /**
     * 施設入所日を入力してフォーカスが外れた時に、適用日と適用届け日が空白だった場合、施設入所日と同じ値を代入します。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param searchDiv 対象者検索Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtShisetsuNyushoDate(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv, TekiyoJogaiTaishoshaSearchDiv searchDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();

        TextBoxFlexibleDate tekiyoDate = tekiyoJogaiJohoDiv.getTekiyoJogaiToroku().getJogaishaTekiyoInput().getTxtTekiyoDate();
        TextBoxFlexibleDate tekiyoTodokedeDate = tekiyoJogaiJohoDiv.getTekiyoJogaiToroku().getJogaishaTekiyoInput().getTxtTekiyoTodokedeDate();
        TextBoxFlexibleDate nyushoDate = tekiyoJogaiJohoDiv.getTekiyoJogaiToroku().getJogaishaTekiyoInput().getTxtShisetsuNyushoDate();
        if (!nyushoDate.getText().equals(RString.EMPTY)) {
            if (tekiyoDate.getText().equals(RString.EMPTY)) {
                tekiyoDate.setValue(nyushoDate.getValue());
            }
            if (tekiyoTodokedeDate.getText().equals(RString.EMPTY)) {
                tekiyoTodokedeDate.setValue(nyushoDate.getValue());
            }
        }

        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

}
