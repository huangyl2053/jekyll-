/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KokuhorenJohoTorikomi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenTorikomiJohoModel;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.relate.KokuhorenTorikomiManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * {@link KokuhorenTorikomiListDiv}のHandlerクラスです。
 */
public class KokuhorenTorikomiListHandler {

    private final KokuhorenTorikomiListDiv div;
    private final RString グリッドソート条件１ = new RString("ichiranHyojijun");

    /**
     * コンストラクタです。
     *
     * @param div 国保連取込リストDiv
     */
    public KokuhorenTorikomiListHandler(KokuhorenTorikomiListDiv div) {
        this.div = div;
    }

    /**
     * 処理年月テキストボックス変更時にリストを更新します。
     *
     * @param panel 国保連取込情報リストDiv
     * @param 処理年月 処理年月
     */
    public void load(KokuhorenTorikomiListDiv panel, RYearMonth 処理年月) {

        KokuhorenTorikomiManager realservice = new KokuhorenTorikomiManager();
        List<KokuhorenTorikomiJohoModel> KokuhorenTorikomiJoho = realservice.get国保連取込情報(処理年月);
        List<dgKokuhorenTorikomiList_Row> KokuhorenTorikomiListDataSource = new ArrayList<>();

        for (KokuhorenTorikomiJohoModel model : KokuhorenTorikomiJoho) {
            KokuhorenTorikomiListDataSource.add(createKokuhorenTorikomiRow(model));
        }
        panel.getDgKokuhorenTorikomiList().setDataSource(KokuhorenTorikomiListDataSource);

        panel.getDgKokuhorenTorikomiList().setSortOrder(グリッドソート条件１);

    }

    private dgKokuhorenTorikomiList_Row createKokuhorenTorikomiRow(KokuhorenTorikomiJohoModel model) {
        dgKokuhorenTorikomiList_Row row = new dgKokuhorenTorikomiList_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxNum(), new TextBoxDate(), RString.EMPTY);
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
        row.setTxtTogetsuJotai(model.get当月処理状態());
        row.setTxtShoriNichiji(model.get当月処理日時() != null ? model.get当月処理日時().getDate().wareki().toDateString().concat(RString.FULL_SPACE)
                .concat(model.get当月処理日時().getRDateTime().getTime().toString().substring(0, 8)) : RString.EMPTY);
        row.setSaishoriFlag(business.get再処理可否区分(model.get再処理可否区分()));
        row.getIchiranHyojijun().setValue(model.get一覧表示順() != null ? new Decimal(model.get一覧表示順().toString()) : Decimal.ZERO);
        row.setBatchID(model.getバッチID());
        row.setKokanShikibetsuNo(model.get交換識別番号());
        //TODO n3317塚田　画面遷移させるために一時的に処理を修正
        row.setSelectButtonState(business.get選択ボタン状態(row.getTorikomiFlag(), row.getTxtTogetsuJotai()));
        return row;
    }
}
