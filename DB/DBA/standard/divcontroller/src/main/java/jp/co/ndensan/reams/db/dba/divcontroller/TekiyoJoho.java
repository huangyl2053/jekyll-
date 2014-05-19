/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.JutokuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.ShisetsuJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SochimotoJohoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJiyuInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.helper.JutokuJohoValueSetter;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 適用情報の履歴を表示するタブの、コントローラです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJoho {

    /**
     * 適用情報登録ボタンを押下した際に動作するメソッドです。<br/>
     * 入力された適用情報を、グリッドの行に挿入します。
     *
     * @param tekiyoJohoDiv TekiyoInfoDiv
     * @return レスポンスデータ
     */
    public ResponseData onClick_btnTekiyoJohoToroku(TekiyoJohoDiv tekiyoJohoDiv) {
        ResponseData<TekiyoJohoDiv> response = new ResponseData<>();

        JutokuJohoInputDiv jutokuJohoInputDiv = tekiyoJohoDiv.getJutokuJohoInput();
        insertTekiyoJoho(tekiyoJohoDiv.getDgJushochiTokureiRireki(), jutokuJohoInputDiv);
        JutokuJohoValueSetter.clear(jutokuJohoInputDiv);

        response.data = tekiyoJohoDiv;
        return response;
    }

    private void insertTekiyoJoho(DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki, JutokuJohoInputDiv jutokuJohoInputDiv) {
        List<dgJushochiTokureiRireki_Row> list = new ArrayList<>();
        list.add(0, toDgJushochiTokureiRireki_Row(jutokuJohoInputDiv));
        dgJushochiTokureiRireki.setDataSource(list);
    }

    private dgJushochiTokureiRireki_Row toDgJushochiTokureiRireki_Row(JutokuJohoInputDiv jutokuJohoInputDiv) {
        dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row(RString.EMPTY, new Button(), RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.HALF_SPACE, RString.EMPTY, RString.HALF_SPACE, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), new TextBoxFlexibleDate());

        row.setAddType(new RString("追加"));

        TekiyoJiyuInputDiv 適用事由 = jutokuJohoInputDiv.getTekiyoJiyuInput();
        row.setTekiyoJiyu(適用事由.getDdlTekiyoJiyu().getSelectedValue());
        row.getTekiyoDate().setValue(適用事由.getTxtTekiyoDate().getValue());
        row.getTekiyoTodokedeDate().setValue(適用事由.getTxtTekiyoTodokedeDate().getValue());

        row.setKaijoJiyu(RString.EMPTY);
        row.getKaijoDate().setValue(FlexibleDate.EMPTY);
        row.getKaijoTodokedeDate().setValue(FlexibleDate.EMPTY);

        SochimotoJohoInputDiv 措置元情報 = jutokuJohoInputDiv.getSochimotoJohoInput();
        row.setSochiHihokenshaNo(措置元情報.getTxtSochimotoHihokenshaNo().getValue());
        row.setSochiHokenshaNo(措置元情報.getTxtSochimotoHokenshaNo().getValue());
        row.setSochiHokenshaMeisho(措置元情報.getTxtSochimotoHokenshaMeisho().getValue());

        ShisetsuJohoInputDiv 施設情報 = jutokuJohoInputDiv.getShisetsuJohoInput();
        row.getNyushoDate().setValue(適用事由.getTxtShisetsuNyushoDate().getValue());
        row.getTaishoDate().setValue(FlexibleDate.EMPTY);
        row.setShisetsuShurui(施設情報.getRadShisetsuShurui().getSelectedValue());
        row.setShisetsuCode(施設情報.getTxtShisetsuCode().getValue());
        row.setShisetsuMeisho(施設情報.getTxtShisetsuMeisho().getValue());
        row.setNyushoShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));

        row.getRenrakuhyoHakkoDate().setValue(FlexibleDate.EMPTY);
        row.getShisetsuHenkoTuchiHakkoDate().setValue(FlexibleDate.EMPTY);
        row.getShisetuTaishoTuchiHakkoDate().setValue(FlexibleDate.EMPTY);

        return row;
    }

    /**
     * グリッドに値が追加された後に、修正ボタンをクリックした際実行されます。<br/>
     * グリッド内のデータを、住所地特例情報入力Divに受け渡し、編集を行います。
     *
     * @param div TekiyoJohoDiv
     * @return レスポンス
     */
    public ResponseData onClick_btnShusei(TekiyoJohoDiv div) {
        ResponseData<TekiyoJohoDiv> response = new ResponseData<>();

        JutokuJohoInputDiv jutokuJohoInput = div.getJutokuJohoInput();
        DataGrid<dgJushochiTokureiRireki_Row> grid = div.getDgJushochiTokureiRireki();
        setJutokuJohoInputValue(jutokuJohoInput, grid);

        response.data = div;
        return response;
    }

    private void setJutokuJohoInputValue(JutokuJohoInputDiv jutokuJohoInput, DataGrid<dgJushochiTokureiRireki_Row> grid) {
        dgJushochiTokureiRireki_Row row = grid.getClickedItem();

        TekiyoJiyuInputDiv tekiyoJiyuInput = jutokuJohoInput.getTekiyoJiyuInput();
        tekiyoJiyuInput.getTxtTekiyoDate().setValue(row.getTekiyoDate().getValue());
        tekiyoJiyuInput.getTxtTekiyoTodokedeDate().setValue(row.getTekiyoTodokedeDate().getValue());
        tekiyoJiyuInput.getTxtShisetsuNyushoDate().setValue(row.getNyushoDate().getValue());

        SochimotoJohoInputDiv sochimotoJohoInput = jutokuJohoInput.getSochimotoJohoInput();
        sochimotoJohoInput.getTxtSochimotoHihokenshaNo().setValue(row.getSochiHihokenshaNo());
        sochimotoJohoInput.getTxtSochimotoHokenshaNo().setValue(row.getSochiHokenshaNo());
        sochimotoJohoInput.getTxtSochimotoHokenshaMeisho().setValue(row.getSochiHokenshaMeisho());

        ShisetsuJohoInputDiv shisetsuJohoInput = jutokuJohoInput.getShisetsuJohoInput();
        shisetsuJohoInput.getTxtShisetsuCode().setValue(row.getShisetsuCode());
        shisetsuJohoInput.getTxtShisetsuMeisho().setValue(row.getShisetsuMeisho());
    }
}
