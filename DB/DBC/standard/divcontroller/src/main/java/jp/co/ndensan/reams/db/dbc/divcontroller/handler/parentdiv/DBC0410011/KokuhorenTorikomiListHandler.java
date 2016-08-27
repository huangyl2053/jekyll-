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
    private static final RString アンダーライン = new RString("_");
    private static final RString アステリスク = new RString("*");
    private static final RString 処理状態区分_フォーク = new RString("×");
    private static final RString 処理状態区分_丸い = new RString("○");
    private static final RString 処理状態区分_横線 = new RString("-");

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
        rsb.append(処理年月);
        rsb.append(アンダーライン);
        rsb.append(model.get交換識別番号());
        if (SharedFile.searchSharedFile(rsb.toRString()).isEmpty()) {
            row.setTorikomiFlag(アステリスク);
        } else {
            row.setTorikomiFlag(RString.HALF_SPACE);
        }
        row.setTxtTorikomiJoho(model.get処理名());
        row.setTxtZenZengetsu(get処理状態(model.get前々月処理状態()));
        row.setTxtZengetsu(get処理状態(model.get前月処理状態()));
        if (model.get当月処理状態() != null && ShoriJotaiKubun.toValue(model.get当月処理状態()) != null) {
            row.setTxtTogetsuJotai(ShoriJotaiKubun.toValue(model.get当月処理状態()).get名称());
        }
        row.setTxtShoriNichiji(model.get当月処理日時() != null ? model.get当月処理日時().getDate()
                .wareki().toDateString().concat(RString.HALF_SPACE)
                .concat(model.get当月処理日時().getRDateTime().getTime().toString().substring(0, NUM)) : RString.EMPTY);
        row.setSaishoriFlag(get再処理可否区分(model.is再処理可否区分()));
        row.getIchiranHyojijun().setValue(model.get一覧表示順() != null ? new Decimal(model.get一覧表示順().toString())
                : Decimal.ZERO);
        row.setBatchID(model.getバッチID());
        row.setKokanShikibetsuNo(model.get交換識別番号());
        row.getShoriYM().setValue(new RDate(処理年月.getYearValue(), 処理年月.getMonthValue()));
        if (row.getTorikomiFlag().equals(RString.HALF_SPACE) && row.getTxtTogetsuJotai().equals(処理前)) {
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

        switch (処理状態区分.toString()) {
            case "1":
                return 処理状態区分_フォーク;
            case "3":
                return 処理状態区分_丸い;
            case "9":
                return 処理状態区分_横線;
            default:
                return RString.EMPTY;
        }
    }

    /**
     * getParamterのメソッドます。
     *
     * @param 交換情報識別番号 RString
     * @return RString
     */
    public RString getParamter(RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "111":
                return new RString("39");
            case "112":
                return new RString("19");
            case "114":
                return new RString("27");
            case "121":
                return new RString("16");
            case "122":
                return new RString("17");
            case "151":
                return new RString("12");
            case "152":
                return new RString("13");
            case "161":
                return new RString("20");
            case "162":
                return new RString("38");
            case "171":
                return new RString("21");
            case "172":
                return new RString("22");
            case "175":
                return new RString("37");
            case "221":
                return new RString("28");
            case "222":
                return new RString("29");
            case "331":
                return new RString("30");
            case "351":
                return new RString("31");
            case "386":
                return new RString("34");
            case "533":
                return new RString("26");
            default:
                return getParamter534_741(交換情報識別番号);
        }
    }

    private RString getParamter534_741(RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "534":
                return new RString("45");
            case "537":
                return new RString("46");
            case "631":
                return new RString("14");
            case "641":
                return new RString("25");
            case "651":
                return new RString("23");
            case "652":
                return new RString("24");
            case "741":
                return new RString("15");
            case "163":
                return new RString("50");
            default:
                return getParamterForOthers(交換情報識別番号);
        }
    }

    private RString getParamterForOthers(RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "37H":
                return new RString("33");
            case "37J":
                return new RString("32");
            case "38B":
                return new RString("35");
            case "38P":
                return new RString("36");
            case "5C3":
                return new RString("18");
            case "153":
                return new RString("47");
            case "123":
                return new RString("44");
            case "632":
                return new RString("48");
            case "177":
                return new RString("40");
            case "661":
                return new RString("42");
            case "178":
                return new RString("41");
            case "662":
                return new RString("43");
            case "642":
                return new RString("49");
            case "5C4": // TODO 共同処理用受給者情報一覧("5C4"), 現時点画面がない
                return RString.EMPTY;
            default:
                return RString.EMPTY;
        }
    }
}
