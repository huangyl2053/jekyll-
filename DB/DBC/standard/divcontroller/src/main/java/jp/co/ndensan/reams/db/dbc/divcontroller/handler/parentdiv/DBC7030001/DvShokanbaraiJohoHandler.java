/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kagoketteihokenshain.KagoKetteiHokenshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.shokan.KetteiJokyo;
import jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.shokan.ShiharaiHoho;
import jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.shokan.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.dgYoshikiNo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.dvshokanbaraijoho.DvShokanbaraiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト出力(償還払い状況)のHandlerです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJohoHandler {

    private final DvShokanbaraiJohoDiv div;
    private static final Code CODE_111 = new Code("111");
//    private static final RString カンマ = new RString(",");
    private static final RString すべて = new RString("すべて");
    private static final RString 介護_1 = new RString("1");
    private static final RString 予防_2 = new RString("2");
    private static final RString 介護 = new RString("介護");
    private static final RString 予防 = new RString("予防");
    private static final RString 広域 = new RString("広域");
    private static final RString 単一 = new RString("単一");
//    private static final RString 項目名 = new RString("1");
//    private static final RString 連番 = new RString("2");
//    private static final RString 日付スラッシュ = new RString("3");
    private static final RString 窓口払い = new RString("窓口払い");
    private static final RString 実行する = new RString("btnExecute");
    private static final RString 識別番号管理 = new RString("識別番号管理");

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト出力(償還払い状況)画面のdiv
     */
    public DvShokanbaraiJohoHandler(DvShokanbaraiJohoDiv div) {
        this.div = div;
    }

    /**
     * 抽出条件パネルの初期化メソッドです。
     */
    public void initialize抽出条件パネル() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        DvShokanChushutsuJokenDiv panel = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken();
        RString 市町村判定 = 単一;
        if (CODE_111.equals(市町村セキュリティ情報.get導入形態コード())) {
            市町村判定 = 広域;
            panel.getCcdShokanHokenshaList().loadHokenshaList();
        } else {
            panel.getCcdShokanHokenshaList().setDisabled(true);
            panel.getCcdShokanHokenshaList().setVisible(false);
        }
        ViewStateHolder.put(ViewStateKeys.市町村判定, 市町村判定);
        List<ShikibetsuNoKanri> 様式番号一覧 = DvShokanbaraiJohoManager.createInstance().select様式名称とコード();
        if (様式番号一覧 == null || 様式番号一覧.isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, true);
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(識別番号管理.toString()));
        }
        ViewStateHolder.put(ViewStateKeys.様式名称_様式コード, (Serializable) 様式番号一覧);
        List<ShikibetsuNoKanri> 様式番号一覧onLoad = get様式番号一覧(介護);
        set様式番号一覧(様式番号一覧onLoad);
        // TODO QARedmine#83481 すべての明細をチェックOnとする
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setIsTriggerEventOnMultiRow(true);
        panel.getDdlShokanShoriJokyo().setDataSource(get処理状況リスト());
        panel.getDdlShokanKetteiJoho().setDataSource(get決定状況リスト());
        panel.getRadKogakuShiharaisaki().setDataSource(get支払方法リスト());
        panel.getDdlShokanShoriJokyo().setSelectedValue(すべて);
        panel.getDdlShokanKetteiJoho().setSelectedValue(すべて);
        panel.getRadKogakuShiharaisaki().setSelectedValue(すべて);
        panel.getCcdKogakuKinyuKikan().setMode_State(KinyuKikanInputDiv.State.入力);
        panel.getDvYoshikiNo().getBtnShokanKaigo().setDisabled(true);
    }

    /**
     * 「介護」ボタンのonClickメソッドHandlerです。
     */
    public void onClick_介護() {
        List<ShikibetsuNoKanri> 様式番号一覧 = get様式番号一覧(介護);
        set様式番号一覧(様式番号一覧);
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnYobo().setDisabled(false);
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnShokanKaigo().setDisabled(true);
    }

    /**
     * 「予防」ボタンのonClickメソッドHandlerです。
     */
    public void onClick_予防() {
        List<ShikibetsuNoKanri> 様式番号一覧 = get様式番号一覧(予防);
        set様式番号一覧(様式番号一覧);
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnYobo().setDisabled(true);
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvYoshikiNo().getBtnShokanKaigo().setDisabled(false);
    }

    /**
     * 支払先RDBのonChangeメソッドHandlerです。
     */
    public void onChange支払先RDB() {
        RString 支払先 = div.getDvShokanbaraiParam().getDvKensakuJoken().getRadKogakuShiharaisaki().getSelectedValue();
        IKinyuKikanInputDiv 金融機関共有子Div = div.getDvShokanbaraiParam().getDvKensakuJoken().getCcdKogakuKinyuKikan();
        if (窓口払い.equals(支払先)) {
            金融機関共有子Div.setDisabled(true);
        } else {
            金融機関共有子Div.setDisabled(false);
        }
    }

    /**
     * バッチパラメータの設定する。
     *
     * @return バッチ用パラメータ
     */
    public KagoKetteiHokenshaInBatchParameter setBatchParamter() {
        KagoKetteiHokenshaInBatchParameter parameter = new KagoKetteiHokenshaInBatchParameter();
        parameter.setShoriYM(FlexibleYearMonth.MIN);
        parameter.setShuturyokuJunn(Long.MIN_VALUE);
        // TODO バッチパラメータの設定 パラメータは実装します。
//        DvKensakuJokenDiv panel = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken();
//        // TODO 年月  not 日
//        RDate サービス提供年月From = panel.getTxtShokanServiceTeikyoYM().getFromValue();
//        RDate サービス提供年月To = panel.getTxtShokanServiceTeikyoYM().getToValue();
//        RString 処理状況 = panel.getDdlShokanShoriJokyo().getSelectedValue();
//        RString 決定情報 = panel.getDdlShokanKetteiJoho().getSelectedValue();
//        RString 支払方法 = panel.getRadKogakuShiharaisaki().getSelectedValue();
//        RString 金融機関コード = panel.getCcdKogakuKinyuKikan().getKinyuKikanCode()
//                == null ? RString.EMPTY : panel.getCcdKogakuKinyuKikan().getKinyuKikanCode().getColumnValue();
//        RString 金融機関名称 = panel.getCcdKogakuKinyuKikan().get金融機関()
//                == null ? RString.EMPTY : panel.getCcdKogakuKinyuKikan().get金融機関().get金融機関名称();
//        RDate 申請日From = panel.getTxtShokanShinseiDate().getFromValue();
//        RDate 申請日To = panel.getTxtShokanShinseiDate().getToValue();
//        RDate 住宅改修支給届出日From = panel.getTxtShokanHokenshaKetteiDate().getFromValue();
//        RDate 住宅改修支給届出日To = panel.getTxtShokanHokenshaKetteiDate().getToValue();
//        RDate 決定日From = panel.getTxtShokanKetteiDate().getFromValue();
//        RDate 決定日To = panel.getTxtShokanKetteiDate().getToValue();
//        RDate 国保連送付年月From = panel.getTxtShokanKokuhorenSofuYM().getFromValue();
//        RDate 国保連送付年月To = panel.getTxtShokanKokuhorenSofuYM().getToValue();
//        // TODO isFiltered様式番号一覧で選択チェックBOXがチェックOFFである行が存在しない場合、「１（すべて）」
//        int 様式番号選択 = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().isFiltered() ? 2 : 1;
//        List<dgYoshikiNo_Row> rowLists = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getSelectedItems();
//        RStringBuilder builder = new RStringBuilder();
//        for (dgYoshikiNo_Row row : rowLists) {
//            builder.append(row.getYoshikiNo());
//            builder.append(カンマ);
//        }
//        RString 様式番号 = builder.length() == 0 ? RString.EMPTY : builder.substring(0, builder.length() - 1);
//        RString 市町村判定 = ViewStateHolder.get(ViewStateKeys.市町村判定, RString.class);
//        HokenshaSummary 保険者DDL = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getCcdShokanHokenshaList().getSelectedItem();
//        TokeiTaishoKubun 保険者コード = 広域.equals(市町村判定) && !HokenshaSummary.EMPTY.equals(保険者DDL)
//                ? 保険者DDL.get保険者区分() : TokeiTaishoKubun.空;
//        boolean 項目名付加 = div.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(項目名);
//        boolean 連番付加 = div.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(連番);
//        boolean 日付スラッシュ付加 = div.getDvShokanbaraiParam()
//                .getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(日付スラッシュ);
        return parameter;
    }

    private List<ShikibetsuNoKanri> get様式番号一覧(RString 抽出条件) {
        List<ShikibetsuNoKanri> 様式番号一覧 = ViewStateHolder.get(ViewStateKeys.様式名称_様式コード, List.class);
        List<ShikibetsuNoKanri> lists_介護 = new ArrayList<>();
        List<ShikibetsuNoKanri> lists_予防 = new ArrayList<>();
        for (ShikibetsuNoKanri 様式番号 : 様式番号一覧) {
            if (介護_1.equals(様式番号.get給付分類区分())) {
                lists_介護.add(様式番号);
            } else if (予防_2.equals(様式番号.get給付分類区分())) {
                lists_予防.add(様式番号);
            } else {
                lists_介護.add(様式番号);
                lists_予防.add(様式番号);
            }
        }
        if (介護.equals(抽出条件)) {
            return lists_介護;
        } else if (予防.equals(抽出条件)) {
            return lists_予防;
        } else {
            return new ArrayList<>();
        }
    }

    private void set様式番号一覧(List<ShikibetsuNoKanri> 様式番号一覧) {
        List<dgYoshikiNo_Row> rowList = new ArrayList<>();
        for (ShikibetsuNoKanri 様式番号 : 様式番号一覧) {
            dgYoshikiNo_Row row = new dgYoshikiNo_Row();
            // TODO QARedmine#83481 給付分類区分.識別番号、略称
            row.setYoshikiName(様式番号.get名称());
//           row.setYoshikiName(様式番号.get);
            rowList.add(row);
        }
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setDataSource(rowList);
    }

    private List<KeyValueDataSource> get処理状況リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShoriJokyo 処理状況 : ShoriJokyo.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(処理状況.getコード(), 処理状況.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get決定状況リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (KetteiJokyo 決定状況 : KetteiJokyo.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(決定状況.getコード(), 決定状況.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get支払方法リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShiharaiHoho 支払方法 : ShiharaiHoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(支払方法.getコード(), 支払方法.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

}
