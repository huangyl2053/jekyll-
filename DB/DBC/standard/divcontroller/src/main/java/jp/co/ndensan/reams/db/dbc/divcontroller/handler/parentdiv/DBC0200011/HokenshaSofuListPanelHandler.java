/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KokuhorenSofuJohoInfo;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.HokenshaSofuListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.dgHokenshaSofuList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.hihokenshajohosoufudatasakuseyi.HihokenshaJohoSoufuDataSakuseyi;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * {@link HokenshaSofuListPanel}のHandlerクラスです。
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class HokenshaSofuListPanelHandler {

    private final HokenshaSofuListPanelDiv div;
    private static final RString 再処理可能 = new RString("再処理可能");
    private static final RString 再処理不可 = new RString("再処理不可");
    private static final RString 処理前 = new RString("処理前");
    private static final RString 再処理前 = new RString("再処理前");
    private static final int NUM = 8;
    private static final RString 処理状態区分_フォーク = new RString("×");
    private static final RString 処理状態区分_丸い = new RString("○");
    private static final RString 処理状態区分_横線 = new RString("-");

    /**
     * コンストラクタです。
     *
     * @param div YokaigoninteiJigyotaishoRirekiListDiv
     */
    public HokenshaSofuListPanelHandler(HokenshaSofuListPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param 処理年月 FlexibleYearMonth
     */
    public void initialize(FlexibleYearMonth 処理年月) {
        List<KokuhorenSofuJohoInfo> kokuhorenSofuJohoInfoList = new ArrayList<>();
        HihokenshaJohoSoufuDataSakuseyi 保険者情報送付 = HihokenshaJohoSoufuDataSakuseyi.createInstance();
        List<KokuhorenSofuJohoResult> resultList = 保険者情報送付.getKokuhorenSofuJoho(処理年月);
        for (KokuhorenSofuJohoResult 国保連送付情報 : resultList) {
            KokuhorenSofuJohoInfo kokuhorenSofuJohoInfo = new KokuhorenSofuJohoInfo();
            if (国保連送付情報 != null) {
                kokuhorenSofuJohoInfo.set交換識別番号(国保連送付情報.get交換情報識別番号());
                kokuhorenSofuJohoInfo.set国保連送付情報(国保連送付情報);
                if (ConfigKeysKokuhorenSofu.toValue(国保連送付情報.get交換情報識別番号()) != null) {
                    kokuhorenSofuJohoInfo.set一覧表示順(ConfigKeysKokuhorenSofu.toValue(国保連送付情報.get交換情報識別番号()).get一覧表示順());
                }
                kokuhorenSofuJohoInfo.set処理名(ConfigKeysKokuhorenSofu.toValue(国保連送付情報.get交換情報識別番号()).get略称());
            }
            kokuhorenSofuJohoInfoList.add(kokuhorenSofuJohoInfo);
        }
        List<dgHokenshaSofuList_Row> gHokenshaSofuListDataSource = new ArrayList<>();
        for (KokuhorenSofuJohoInfo model : kokuhorenSofuJohoInfoList) {
            gHokenshaSofuListDataSource.add(createdgHokenshaSofuListRow(model));
        }
        div.getBtnHyojisuru().setDisabled(false);
        div.getDgHokenshaSofuList().setDataSource(gHokenshaSofuListDataSource);
    }

    private dgHokenshaSofuList_Row createdgHokenshaSofuListRow(KokuhorenSofuJohoInfo model) {
        dgHokenshaSofuList_Row row = new dgHokenshaSofuList_Row();
        row.setTxtSofuJoho(model.get処理名());
        row.setTxtZenZengetsu(get処理状態(model.get前々月処理状態()));
        row.setTxtZengetsu(get処理状態(model.get前月処理状態()));
        RString 当月処理状態 = model.get処理状態区分();
        if (当月処理状態 != null && ShoriJotaiKubun.toValue(当月処理状態) != null) {
            row.setTxtTogetsuJotai(ShoriJotaiKubun.toValue(当月処理状態).get名称());
        }
        row.setTxtShoriNichiji(model.get当月処理実施日時() != null ? model.get当月処理実施日時().getDate()
                .wareki().toDateString().concat(RString.HALF_SPACE)
                .concat(model.get当月処理実施日時().getRDateTime().getTime().toString().substring(0, NUM)) : RString.EMPTY);
        row.setSaishoriFlag(get再処理可否区分(model.is再処理可能区分()));
        row.getIchiranHyojijun().setValue(model.get一覧表示順() != null ? new Decimal(model.get一覧表示順().toString())
                : Decimal.ZERO);
        row.getShoriYM().setValue(new RDate(model.get処理年月().toDateString().toString()));
        row.setKokanShikibetsuNo(model.get交換識別番号());
        if (row.getTxtTogetsuJotai().equals(処理前) || row.getTxtTogetsuJotai().equals(再処理前)) {
            row.setSelectButtonState(DataGridButtonState.Enabled);
        } else {
            row.setSelectButtonState(DataGridButtonState.Disabled);
        }
        return row;
    }

    /**
     * get再処理区分
     *
     * @param div HokenshaSofuListPanelDiv
     * @return RString
     */
    public RString get再処理区分(HokenshaSofuListPanelDiv div) {
        dgHokenshaSofuList_Row row = div.getDgHokenshaSofuList().getClickedItem();
        RString 再処理区分 = RString.EMPTY;
        if (再処理可能.equals(row.getSaishoriFlag())) {
            再処理区分 = SaiShoriKubun.再処理.getコード();
        } else if (再処理不可.equals(row.getSaishoriFlag())) {
            再処理区分 = SaiShoriKubun.空白.getコード();
        }
        return 再処理区分;
    }

    /**
     * get処理年月
     *
     * @return FlexibleYearMonth 処理年月
     */
    public FlexibleYearMonth get処理年月() {
        HihokenshaJohoSoufuDataSakuseyi 保険者情報送付 = HihokenshaJohoSoufuDataSakuseyi.createInstance();
        FlexibleYearMonth 処理年月 = 保険者情報送付.getMaxShoriYearMonth();
        if (処理年月 == null || 処理年月.isEmpty()) {
            処理年月 = FlexibleDate.getNowDate().getYearMonth();
        }
        return 処理年月;
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
}
