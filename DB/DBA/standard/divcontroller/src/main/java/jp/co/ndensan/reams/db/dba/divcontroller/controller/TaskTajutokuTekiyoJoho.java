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
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.JutokuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.ShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.SochimotoJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.TaskTajutokuTekiyoJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba204001t.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShisetsuJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 他市町村住所地特例の適用情報を入力するDivのControllerです。
 *
 * @author n8178 城間篤人
 */
public class TaskTajutokuTekiyoJoho {

    private static final RString TAJUTOKU_JOHO = new RString("DBA204001T/tajutokuTekiyo.yml");

    /**
     * 対象者検索から個人が一人選ばれた際に実行されます。処理対象の他市町村住所地特例の情報を設定します。
     *
     * @param tajutokuDiv 他市町村住所地特例情報Div
     * @return レスポンス
     */
    public ResponseData onLoad(TaskTajutokuTekiyoJohoDiv tajutokuDiv) {
        ResponseData<TaskTajutokuTekiyoJohoDiv> response = new ResponseData<>();

        DemoKojin demoKojin = new DemoKojin("第1号");
        RString hihokenshaNo = demoKojin.getHihokenshaNo();
        setTajutokuJoho(tajutokuDiv.getDgJushochiTokureiRireki(), hihokenshaNo);
        ShisetsuJoho.setJutokuMode(tajutokuDiv.getJutokuJohoInput().getShisetsuJohoInput().getShisetsuJoho());
        tajutokuDiv.getJutokuJohoInput().getShisetsuJohoInput().getShisetsuJoho().getLblOtherShisetsuShurui().setText(new RString("keyKannai"));

        response.data = tajutokuDiv;
        return response;
    }

    private void setTajutokuJoho(DataGrid<dgJushochiTokureiRireki_Row> grid, RString hihokenshaNo) {
        List<HashMap> yamlJutokuDataList = YamlLoader.DBA.loadAsList(TAJUTOKU_JOHO);
        List<HashMap> jutokuDataList = new ArrayList<>();
        for (HashMap yamlJutokuData : yamlJutokuDataList) {
            ControlGenerator generator = new ControlGenerator(yamlJutokuData);
            if (generator.getAsRString("被保番号").equals(hihokenshaNo)) {
                jutokuDataList = (List<HashMap>) generator.get("他特例適用");
            }
        }

        List<dgJushochiTokureiRireki_Row> jutokuDataSource = new ArrayList<>();
        for (HashMap jutokuData : jutokuDataList) {
            ControlGenerator generator = new ControlGenerator(jutokuData);
            jutokuDataSource.add(createJushochiTokureiRirekiRow(generator));
        }
        grid.setDataSource(jutokuDataSource);
    }

    private dgJushochiTokureiRireki_Row createJushochiTokureiRirekiRow(ControlGenerator generator) {
        dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate());

        row.setTekiyoJiyu(generator.getAsRString("適用事由"));
        row.getTekiyoDate().setValue(generator.getAsFlexibleDate("適用日"));
        row.getTekiyoTodokedeDate().setValue(generator.getAsFlexibleDate("届出日"));

        row.setKaijoJiyu(generator.getAsRString("解除事由"));
        row.getKaijoDate().setValue(generator.getAsFlexibleDate("解除日"));
        row.getKaijoTodokedeDate().setValue(generator.getAsFlexibleDate("届出日"));

        row.setSochiHihokenshaNo(generator.getAsRString("保険者番号"));
        row.setSochiHokenshaNo(generator.getAsRString("保険者"));
        row.setSochiHokenshaMeisho(generator.getAsRString("被保番号"));

        row.getNyushoDate().setValue(generator.getAsFlexibleDate("入所日"));
        row.getTaishoDate().setValue(generator.getAsFlexibleDate("退所日"));
        row.setShisetsuShurui(generator.getAsRString("施設種類"));
        row.setShisetsuCode(generator.getAsRString("入所施設"));
        row.setShisetsuMeisho(generator.getAsRString("施設コード"));
        row.setNyushoShisetsu(generator.getAsRString("施設名称"));

        row.getRenrakuhyoHakkoDate().setValue(generator.getAsFlexibleDate("連絡票発行年月日"));
        row.getShisetsuHenkoTuchiHakkoDate().setValue(generator.getAsFlexibleDate("施設退所通知発行年月日"));
        row.getShisetuTaishoTuchiHakkoDate().setValue(generator.getAsFlexibleDate("施設変更通知発行年月日"));

        return row;
    }

    /**
     * 適用情報登録ボタンを押下した際に動作するメソッドです。<br/>
     * 入力された適用情報を、グリッドの行に挿入します。
     *
     * @param tajutokuDiv 他市町村住所地特例情報Div
     * @return レスポンス
     */
    public ResponseData onClick_btnTekiyoJohoToroku(TaskTajutokuTekiyoJohoDiv tajutokuDiv) {
        ResponseData<TaskTajutokuTekiyoJohoDiv> response = new ResponseData<>();

        JutokuJohoInputDiv jutokuJohoInputDiv = tajutokuDiv.getJutokuJohoInput();
        insertTekiyoJoho(tajutokuDiv.getDgJushochiTokureiRireki(), jutokuJohoInputDiv);
        inputDataClear(jutokuJohoInputDiv);

        tajutokuDiv.getJutokuJohoInput().setReadOnly(true);

        response.data = tajutokuDiv;
        return response;
    }

    private void insertTekiyoJoho(DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki, JutokuJohoInputDiv jutokuJohoInputDiv) {
        List<dgJushochiTokureiRireki_Row> list = new ArrayList<>();
        list.add(0, createDgJushochiTokureiRirekiRowForTekiyo(jutokuJohoInputDiv));
        dgJushochiTokureiRireki.setDataSource(list);
    }

    private dgJushochiTokureiRireki_Row createDgJushochiTokureiRirekiRowForTekiyo(JutokuJohoInputDiv jutokuJohoInputDiv) {
        dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row(RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate());

        row.setRowState(RowState.Added);
        TekiyoJiyuInputDiv 適用事由 = jutokuJohoInputDiv.getTekiyoJiyuInput();
        row.setTekiyoJiyu(適用事由.getDdlTekiyoJiyu().getSelectedValue());
        row.getTekiyoDate().setValue(適用事由.getTxtTekiyoDate().getValue());
        row.getTekiyoTodokedeDate().setValue(適用事由.getTxtTekiyoTodokedeDate().getValue());

        row.setKaijoJiyu(RString.EMPTY);
        row.getKaijoDate().setValue(FlexibleDate.EMPTY);
        row.getKaijoTodokedeDate().setValue(FlexibleDate.EMPTY);

        SochimotoJohoInputDiv 措置元情報 = jutokuJohoInputDiv.getSochimotoJohoInput();
        row.setSochiHihokenshaNo(措置元情報.getTxtSochimotoHihokenshaNo().getValue());
        row.setSochiHokenshaNo(措置元情報.getHokenshaJoho().getTxtHokenshaNo().getValue());
        row.setSochiHokenshaMeisho(措置元情報.getHokenshaJoho().getTxtHokenshaMeisho().getValue());

        ShisetsuJohoInputDiv 施設情報 = jutokuJohoInputDiv.getShisetsuJohoInput();
        row.getNyushoDate().setValue(適用事由.getTxtShisetsuNyushoDate().getValue());
        row.getTaishoDate().setValue(FlexibleDate.EMPTY);
        row.setShisetsuShurui(施設情報.getShisetsuJoho().getRadShisetsuShurui().getSelectedValue());
        row.setShisetsuCode(施設情報.getShisetsuJoho().getTxtShisetsuCode().getValue());
        row.setShisetsuMeisho(施設情報.getShisetsuJoho().getTxtShisetsuMeisho().getValue());
        row.setNyushoShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));

        row.getRenrakuhyoHakkoDate().setValue(FlexibleDate.EMPTY);
        row.getShisetsuHenkoTuchiHakkoDate().setValue(FlexibleDate.EMPTY);
        row.getShisetuTaishoTuchiHakkoDate().setValue(FlexibleDate.EMPTY);

        return row;
    }

    private void inputDataClear(JutokuJohoInputDiv jutokuJohoInputDiv) {
        TekiyoJiyuInputDiv tekiyoJiyuInput = jutokuJohoInputDiv.getTekiyoJiyuInput();
        tekiyoJiyuInput.getTxtTekiyoDate().setValue(null);
        tekiyoJiyuInput.getTxtTekiyoTodokedeDate().setValue(null);
        tekiyoJiyuInput.getTxtShisetsuNyushoDate().setValue(null);

        SochimotoJohoInputDiv sochimotoJohoInput = jutokuJohoInputDiv.getSochimotoJohoInput();
        sochimotoJohoInput.getTxtSochimotoHihokenshaNo().setValue(null);
        sochimotoJohoInput.getHokenshaJoho().getTxtHokenshaNo().setValue(null);
        sochimotoJohoInput.getHokenshaJoho().getTxtHokenshaMeisho().setValue(null);

        ShisetsuJohoInputDiv shisetsuJohoInput = jutokuJohoInputDiv.getShisetsuJohoInput();
        shisetsuJohoInput.getShisetsuJoho().getTxtShisetsuCode().setValue(null);
        shisetsuJohoInput.getShisetsuJoho().getTxtShisetsuMeisho().setValue(null);
    }

    /**
     * グリッドに値が追加された後に、修正ボタンをクリックした際実行されます。<br/>
     * グリッド内のデータを、住所地特例情報入力Divに受け渡し、編集を行います。
     *
     * @param tajutokuDiv 他市町村住所地特例情報Div
     * @return レスポンス
     */
    public ResponseData onSelectByModifyButton_dgJushochiTokureiRireki(TaskTajutokuTekiyoJohoDiv tajutokuDiv) {
        ResponseData<TaskTajutokuTekiyoJohoDiv> response = new ResponseData<>();

        JutokuJohoInputDiv jutokuJohoInput = tajutokuDiv.getJutokuJohoInput();
        dgJushochiTokureiRireki_Row row = tajutokuDiv.getDgJushochiTokureiRireki().getClickedItem();
        setJutokuJohoInputValue(jutokuJohoInput, row);

        tajutokuDiv.getJutokuJohoInput().setReadOnly(false);

        response.data = tajutokuDiv;
        return response;
    }

    private void setJutokuJohoInputValue(JutokuJohoInputDiv jutokuJohoInput, dgJushochiTokureiRireki_Row row) {

        TekiyoJiyuInputDiv tekiyoJiyuInput = jutokuJohoInput.getTekiyoJiyuInput();
        tekiyoJiyuInput.getTxtTekiyoDate().setValue(row.getTekiyoDate().getValue());
        tekiyoJiyuInput.getTxtTekiyoTodokedeDate().setValue(row.getTekiyoTodokedeDate().getValue());
        tekiyoJiyuInput.getTxtShisetsuNyushoDate().setValue(row.getNyushoDate().getValue());

        SochimotoJohoInputDiv sochimotoJohoInput = jutokuJohoInput.getSochimotoJohoInput();
        sochimotoJohoInput.getTxtSochimotoHihokenshaNo().setValue(row.getSochiHihokenshaNo());
        sochimotoJohoInput.getHokenshaJoho().getTxtHokenshaNo().setValue(row.getSochiHokenshaNo());
        sochimotoJohoInput.getHokenshaJoho().getTxtHokenshaMeisho().setValue(row.getSochiHokenshaMeisho());

        ShisetsuJohoInputDiv shisetsuJohoInput = jutokuJohoInput.getShisetsuJohoInput();
        shisetsuJohoInput.getShisetsuJoho().getTxtShisetsuCode().setValue(row.getShisetsuCode());
        shisetsuJohoInput.getShisetsuJoho().getTxtShisetsuMeisho().setValue(row.getShisetsuMeisho());
    }

    /**
     * 適用届出日の入力が完了してロスとフォーカスした際、適用日と入所日に値が入っていない場合、適用届出日の値をそれぞれに設定します。
     *
     * @param tajutokuDiv 他市町村住所地特例情報Div
     * @return レスポンス
     */
    public ResponseData onBlur_txtShisetsuNyushoDate(TaskTajutokuTekiyoJohoDiv tajutokuDiv) {
        ResponseData<TaskTajutokuTekiyoJohoDiv> response = new ResponseData<>();

        TekiyoJiyuInputDiv tekiyoJiyuInputDiv = tajutokuDiv.getJutokuJohoInput().getTekiyoJiyuInput();

        if (tekiyoJiyuInputDiv.getTxtTekiyoDate().getText().isEmpty()) {
            tekiyoJiyuInputDiv.getTxtTekiyoDate().setValue(tekiyoJiyuInputDiv.getTxtShisetsuNyushoDate().getValue());
        }
        if (tekiyoJiyuInputDiv.getTxtTekiyoTodokedeDate().getText().isEmpty()) {
            tekiyoJiyuInputDiv.getTxtTekiyoTodokedeDate().setValue(tekiyoJiyuInputDiv.getTxtShisetsuNyushoDate().getValue());
        }

        response.data = tajutokuDiv;
        return response;
    }
}
