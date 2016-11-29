/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0410011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KokuhorenTorikomiJohoInfo;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.IryoHokenRirekiManager;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * {@link KokuhorenTorikomiListDiv}のHandlerクラスです。
 *
 * @reamsid_L DBC-0980-460 wangkanglei
 */
public class KokuhorenTorikomiListHandler {

    private final KokuhorenTorikomiListDiv div;
    private static final RString グリッドソート条件１ = new RString("ichiranHyojijun");
    private static final int NUM = 8;
    private static final RString 再処理可能 = new RString("再処理可能");
    private static final RString 再処理不可 = new RString("再処理不可");
    private static final RString 処理前 = new RString("処理前");
    private static final RString アステリスク = new RString("*");
    private static final RString 処理状態区分_フォーク = new RString("×");
    private static final RString 処理状態区分_丸い = new RString("○");
    private static final RString 処理状態区分_横線 = new RString("-");
    private final RString searchSharedFile = new RString("1\\_");
    private final RString パーセント = new RString("%");


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
     * @param 処理年月 RYearMonth
     */
    public void load(RYearMonth 処理年月) {
        List<KokuhorenTorikomiJohoInfo> kokuhorenTorikomiJohoList = new ArrayList<>();
        for (ConfigKeysKokuhorenTorikomi 交換識別番号 : ConfigKeysKokuhorenTorikomi.values()) {
            KokuhorenTorikomiJohoInfo result = new KokuhorenTorikomiJohoInfo();
            KokuhorenTorikomiJoho kokuhorenTorikomiJoho = IryoHokenRirekiManager.createInstance()
                    .getKokuhorenTorikomiJoho(new FlexibleYearMonth(処理年月.toDateString()), 交換識別番号.getコード());
            if (kokuhorenTorikomiJoho != null) {
                result.set国保連取込管理エンティティ(kokuhorenTorikomiJoho.toEntity());
                result.setバッチID(RString.EMPTY);
                result.set一覧表示順(交換識別番号.get一覧表示順());
                result.set処理名(交換識別番号.get略称());
                result.set交換識別番号(交換識別番号.getコード());
                kokuhorenTorikomiJohoList.add(result);
            }
        }
        List<dgKokuhorenTorikomiList_Row> kokuhorenTorikomiListDataSource = new ArrayList<>();
        for (KokuhorenTorikomiJohoInfo model : kokuhorenTorikomiJohoList) {
            kokuhorenTorikomiListDataSource.add(createKokuhorenTorikomiRow(model, 処理年月));
        }
        div.getDgKokuhorenTorikomiList().setDataSource(kokuhorenTorikomiListDataSource);
        div.getDgKokuhorenTorikomiList().setSortOrder(グリッドソート条件１);
    }

    private dgKokuhorenTorikomiList_Row createKokuhorenTorikomiRow(
            KokuhorenTorikomiJohoInfo model,
            RYearMonth 処理年月) {
        dgKokuhorenTorikomiList_Row row = new dgKokuhorenTorikomiList_Row();
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(searchSharedFile);
        rsb.append(model.get交換識別番号());
        rsb.append(パーセント);
        if (SharedFile.searchSharedFile(rsb.toRString()).isEmpty()) {
            row.setTorikomiFlag(アステリスク);
        } else {
            row.setTorikomiFlag(RString.HALF_SPACE);
        }
        row.setTxtTorikomiJoho(model.get処理名());
        row.setTxtZenZengetsu(get処理状態(model.get前々月処理状態()));
        row.setTxtZengetsu(get処理状態(model.get前月処理状態()));
        if (model.get当月処理状態() != null && !model.get当月処理状態().isEmpty()
                && ShoriJotaiKubun.toValue(model.get当月処理状態()) != null) {
            row.setTxtTogetsuJotai(ShoriJotaiKubun.toValue(model.get当月処理状態()).get名称());
        }
        row.setTxtShoriNichiji(model.get当月処理日時() != null && !model.get当月処理日時().isEmpty()
                ? model.get当月処理日時().getDate().wareki().toDateString().concat(RString.HALF_SPACE)
                .concat(model.get当月処理日時().getRDateTime().getTime().toString().substring(0, NUM)) : RString.EMPTY);
        row.setSaishoriFlag(get再処理可否区分(model.is再処理可否区分()));
        row.getIchiranHyojijun().setValue(model.get一覧表示順() != null && !model.get一覧表示順().isEmpty()
                ? new Decimal(model.get一覧表示順().toString()) : Decimal.ZERO);
        row.setBatchID(model.getバッチID());
        row.setKokanShikibetsuNo(model.get交換識別番号());
        row.getShoriYM().setValue(new RDate(処理年月.getYearValue(), 処理年月.getMonthValue()));
        if (row.getTorikomiFlag().equals(RString.HALF_SPACE)
                && (ShoriJotaiKubun.処理前.getコード().equals(model.get当月処理状態())
                || ShoriJotaiKubun.再処理前.getコード().equals(model.get当月処理状態()))) {
            row.setSelectButtonState(DataGridButtonState.Enabled);
        } else {
            row.setSelectButtonState(DataGridButtonState.Disabled);
        }
        return row;
    }

    private RString get再処理可否区分(boolean 再処理可否) {
        if (再処理可否) {
            return 再処理可能;
        } else {
            return 再処理不可;
        }
    }

    private RString get処理状態(RString 処理状態区分) {
        if (処理状態区分 == null) {
            return RString.EMPTY;
        }
        if (ShoriJotaiKubun.再処理前.getコード().equals(処理状態区分) || ShoriJotaiKubun.処理前.getコード().equals(処理状態区分)) {
            return 処理状態区分_フォーク;
        } else if (ShoriJotaiKubun.終了.getコード().equals(処理状態区分)) {
            return 処理状態区分_丸い;
        } else if (ShoriJotaiKubun.処理なし.getコード().equals(処理状態区分)) {
            return 処理状態区分_横線;
        }
        return RString.EMPTY;
    }
}
