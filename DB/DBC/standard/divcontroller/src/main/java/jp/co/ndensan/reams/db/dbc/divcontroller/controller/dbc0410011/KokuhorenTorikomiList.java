/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KokuhorenJohoTorikomi;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewStateHolderName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.model.relate.KokuhorenJohoTorikomiBatchKidoModel;
import jp.co.ndensan.reams.db.dbc.model.relate.KokuhorenTorikomiJohoModel;
import jp.co.ndensan.reams.db.dbc.realservice.KokuhorenTorikomiJohoManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenTorikomiList {

    private final RString グリッドソート条件１ = new RString("ichiranHyojijun");

    public ResponseData<KokuhorenTorikomiListDiv> onLoad(KokuhorenTorikomiListDiv panel) {

        KokuhorenTorikomiJohoManager realservice = new KokuhorenTorikomiJohoManager();
        RYearMonth max処理年月 = realservice.get国保連IF管理Max処理年月();

        panel.getTxtShoriYM().setValue(new RDate(max処理年月.getYearValue(), max処理年月.getMonthValue()));

        ResponseData<KokuhorenTorikomiListDiv> response = new ResponseData<>();
        response.data = loadGrid(panel, max処理年月);
        return response;

    }

    /**
     * 処理年月テキストボックス変更時にリストを更新します。
     *
     * @param panel KokuhorenTorikomiListDiv
     * @return response
     */
    public ResponseData<KokuhorenTorikomiListDiv> onChange_txtShoriYM(KokuhorenTorikomiListDiv panel) {
        ResponseData<KokuhorenTorikomiListDiv> response = new ResponseData<>();
        response.data = loadGrid(panel, panel.getTxtShoriYM().getValue().getYearMonth());
        return response;
    }

    private KokuhorenTorikomiListDiv loadGrid(KokuhorenTorikomiListDiv panel, RYearMonth 処理年月) {

        KokuhorenTorikomiJohoManager realservice = new KokuhorenTorikomiJohoManager();

        List<KokuhorenTorikomiJohoModel> KokuhorenTorikomiJoho = realservice.get国保連取込情報(処理年月);

        List<dgKokuhorenTorikomiList_Row> KokuhorenTorikomiListDataSource = new ArrayList<>();

        for (KokuhorenTorikomiJohoModel model : KokuhorenTorikomiJoho) {
            KokuhorenTorikomiListDataSource.add(createKokuhorenTorikomiRow(model));
        }

        panel.getDgKokuhorenTorikomiList().setDataSource(KokuhorenTorikomiListDataSource);

        panel.getDgKokuhorenTorikomiList().setSortOrder(グリッドソート条件１);
        return panel;
    }

    public ResponseData<KokuhorenTorikomiListDiv> onSelect_dgKokuhorenTorikomiList_Row(KokuhorenTorikomiListDiv panel) {

        dgKokuhorenTorikomiList_Row row = panel.getDgKokuhorenTorikomiList().getSelectedItems().get(0);
        KokuhorenJohoTorikomiBatchKidoModel viewStateHolder = new KokuhorenJohoTorikomiBatchKidoModel();
        viewStateHolder.setバッチID(row.getBatchID());
        viewStateHolder.set交換識別番号(row.getKokanShikibetsuNo());
        viewStateHolder.set再処理フラグ(row.getSaishoriFlag());
        viewStateHolder.set処理名(row.getTxtTorikomiJoho());
        viewStateHolder.set処理年月(panel.getTxtShoriYM().getValue().seireki().separator(Separator.NONE).getYearMonth());
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, viewStateHolder);

        ResponseData<KokuhorenTorikomiListDiv> response = new ResponseData<>();
        response.data = panel;
        return response;
    }

    private dgKokuhorenTorikomiList_Row createKokuhorenTorikomiRow(KokuhorenTorikomiJohoModel model) {

        dgKokuhorenTorikomiList_Row row = new dgKokuhorenTorikomiList_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxNum(), new TextBoxDate(), RString.EMPTY);
        KokuhorenJohoTorikomi business = new KokuhorenJohoTorikomi();
        RStringBuilder rsb = new RStringBuilder();

        row.setTorikomiFlag(business.get取込フラグ(model.get処理名()));
        rsb.append("[");
        rsb.append(model.get交換識別番号());
        rsb.append("]");
        rsb.append(model.get処理名());
        row.setTxtTorikomiJoho(rsb.toRString());

        row.setTxtZenZengetsu(business.get処理状態(model.get前々月処理状態()));
        row.setTxtZengetsu(business.get処理状態(model.get前月処理状態()));
        row.setTxtTogetsuJotai(business.get当月処理状態(model));
        row.setTxtShoriNichiji(business.get当月処理日時(model));

        row.setSaishoriFlag(business.get再処理フラグ(model));
        row.getIchiranHyojijun().setValue(new Decimal(model.get一覧表示順().toString()));
        row.setBatchID(model.getバッチID());
        row.setKokanShikibetsuNo(model.get交換識別番号());
        row.setSelectButtonState(business.get選択ボタン状態(row.getTorikomiFlag(), row.getTxtTogetsuJotai()));
        return row;
    }
}
