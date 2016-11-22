/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710020.DBC710020_HanyoListShokanbaraiJokyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.KetteiJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShiharaiHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvKensakuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.dgYoshikiNo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.dvshokanbaraijoho.DvShokanbaraiJohoManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト出力(償還払い状況)のHandlerです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJohoHandler {

    private final DvShokanbaraiJohoDiv div;
    private static final RString カンマ = new RString(",");
    private static final RString すべて = new RString("すべて");
    private static final RString 介護_1 = new RString("1");
    private static final RString 予防_2 = new RString("2");
    private static final RString 介護 = new RString("介護");
    private static final RString 予防 = new RString("予防");
    private static final RString 広域 = new RString("広域");
    private static final RString 単一 = new RString("単一");
    private static final RString 項目名 = new RString("1");
    private static final RString 連番 = new RString("2");
    private static final RString 日付スラッシュ = new RString("3");
    private static final RString すべて_1 = new RString("1");
    private static final RString 部分_2 = new RString("2");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString 窓口払い = new RString("窓口払い");
    private static final ReportId REPORTID = new ReportId("DBC701002_HanyoListShokanbaraiJokyo");
    private static final int INDEX_0 = 0;
    private static final int INDEX_4 = 4;
    private static final RString KEY_サービス提供年月開始 = new RString("サービス提供年月From");
    private static final RString KEY_サービス提供年月終了 = new RString("サービス提供年月To");
    private static final RString KEY_処理状況 = new RString("処理状況");
    private static final RString KEY_決定情報 = new RString("決定情報");
    private static final RString KEY_支払方法 = new RString("支払方法");
    private static final RString KEY_金融機関コード = new RString("金融機関コード");
    private static final RString KEY_金融機関名称 = new RString("金融機関名称");
    private static final RString KEY_申請日開始 = new RString("申請日From");
    private static final RString KEY_申請日終了 = new RString("申請日To");
    private static final RString KEY_住宅改修支給届出日開始 = new RString("住宅改修支給届出日From");
    private static final RString KEY_住宅改修支給届出日終了 = new RString("住宅改修支給届出日To");
    private static final RString KEY_決定日開始 = new RString("決定日From");
    private static final RString KEY_決定日終了 = new RString("決定日To");
    private static final RString KEY_国保連送付年月開始 = new RString("国保連送付年月From");
    private static final RString KEY_国保連送付年月終了 = new RString("国保連送付年月To");
    private static final RString KEY_様式番号 = new RString("様式番号");
    private static final RString KEY_保険者コード = new RString("保険者コード");
    private static final RString KEY_保険者名 = new RString("保険者名");
    private static final RString KEY_項目名付加 = new RString("項目名付加");
    private static final RString KEY_連番付加 = new RString("連番付加");
    private static final RString KEY_日付スラッシュ付加 = new RString("日付スラッシュ付加");
    private static final RString KEY_出力順 = new RString("出力順");
    private static final RString KEY_KINYUKIKANSHITENCODE = new RString("kinyuKikanShitenCode");

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
     *
     * @return 市町村判定 RString
     */
    public RString initialize抽出条件パネル() {
        ShichosonSecurityJoho 市町村セキュリティ情報
                = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        DvShokanChushutsuJokenDiv panel = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken();
        RString 市町村判定 = 単一;
        if (市町村セキュリティ情報 == null || KaigoDonyuKubun.未導入.code().equals(市町村セキュリティ情報.get介護導入区分().code())) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (市町村セキュリティ情報.get導入形態コード() != null
                && 市町村セキュリティ情報.get導入形態コード().is広域()) {
            市町村判定 = 広域;
            panel.getCcdShokanHokenshaList().loadHokenshaList();
        } else {
            panel.getCcdShokanHokenshaList().setDisabled(true);
            panel.getCcdShokanHokenshaList().setDisplayNone(true);
        }
        List<ShikibetsuNoKanri> 様式番号一覧 = DvShokanbaraiJohoManager.createInstance().select様式名称とコード();
        set様式番号一覧(様式番号一覧);
        List<RString> selectedItems = new ArrayList<>();
        selectedItems.add(項目名);
        selectedItems.add(日付スラッシュ);
        div.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(selectedItems);
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setIsTriggerEventOnMultiRow(true);
        panel.getDdlShokanShoriJokyo().setDataSource(get処理状況リスト());
        panel.getDdlShokanKetteiJoho().setDataSource(get決定状況リスト());
        panel.getRadKogakuShiharaisaki().setDataSource(get支払方法リスト());
        panel.getDdlShokanShoriJokyo().setSelectedValue(すべて);
        panel.getDdlShokanKetteiJoho().setSelectedValue(すべて);
        panel.getRadKogakuShiharaisaki().setSelectedValue(すべて);
        panel.getCcdKogakuKinyuKikan().setMode_State(KinyuKikanInputDiv.State.入力);
        return 市町村判定;
    }

    /**
     * 「介護」ボタンのonClickメソッドHandlerです。
     */
    public void onClick_介護() {
        setSelectedItems(介護);
    }

    /**
     * 「予防」ボタンのonClickメソッドHandlerです。
     */
    public void onClick_予防() {
        setSelectedItems(予防);
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
     * @param 市町村判定 RString
     * @return バッチ用パラメータ
     */
    public DBC710020_HanyoListShokanbaraiJokyoParameter setBatchParamter(RString 市町村判定) {
        DBC710020_HanyoListShokanbaraiJokyoParameter parameter = new DBC710020_HanyoListShokanbaraiJokyoParameter();
        DvKensakuJokenDiv panel = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken();
        RDate サービス提供年月F = panel.getTxtShokanServiceTeikyoYM().getFromValue();
        RDate サービス提供年月T = panel.getTxtShokanServiceTeikyoYM().getToValue();
        FlexibleYearMonth サービス提供年月From = サービス提供年月F == null
                ? FlexibleYearMonth.EMPTY : new FlexibleYearMonth(サービス提供年月F.getYearMonth().toString());
        FlexibleYearMonth サービス提供年月To = サービス提供年月T == null
                ? FlexibleYearMonth.EMPTY : new FlexibleYearMonth(サービス提供年月T.getYearMonth().toString());
        RString 処理状況 = panel.getDdlShokanShoriJokyo().getSelectedKey();
        RString 決定情報 = panel.getDdlShokanKetteiJoho().getSelectedKey();
        RString 支払方法 = panel.getRadKogakuShiharaisaki().getSelectedKey();
        RString 金融機関コード = panel.getCcdKogakuKinyuKikan().getKinyuKikanCode()
                == null ? RString.EMPTY : panel.getCcdKogakuKinyuKikan().getKinyuKikanCode().getColumnValue();
        RString 金融機関名称 = panel.getCcdKogakuKinyuKikan().get金融機関()
                == null ? RString.EMPTY : panel.getCcdKogakuKinyuKikan().get金融機関().get金融機関名称();
        RDate 申請日F = panel.getTxtShokanShinseiDate().getFromValue();
        RDate 申請日T = panel.getTxtShokanShinseiDate().getToValue();
        FlexibleDate 申請日From = 申請日F == null ? FlexibleDate.EMPTY : new FlexibleDate(申請日F.toString());
        FlexibleDate 申請日To = 申請日T == null ? FlexibleDate.EMPTY : new FlexibleDate(申請日T.toString());
        RDate 住宅改修支給届出日F = panel.getTxtShokanHokenshaKetteiDate().getFromValue();
        RDate 住宅改修支給届出日T = panel.getTxtShokanHokenshaKetteiDate().getToValue();
        FlexibleDate 住宅改修支給届出日From = 住宅改修支給届出日F == null ? FlexibleDate.EMPTY : new FlexibleDate(住宅改修支給届出日F.toString());
        FlexibleDate 住宅改修支給届出日To = 住宅改修支給届出日T == null ? FlexibleDate.EMPTY : new FlexibleDate(住宅改修支給届出日T.toString());
        RDate 決定日F = panel.getTxtShokanKetteiDate().getFromValue();
        RDate 決定日T = panel.getTxtShokanKetteiDate().getToValue();
        FlexibleDate 決定日From = 決定日F == null ? FlexibleDate.EMPTY : new FlexibleDate(決定日F.toString());
        FlexibleDate 決定日To = 決定日T == null ? FlexibleDate.EMPTY : new FlexibleDate(決定日T.toString());
        RDate 国保連送付年月F = panel.getTxtShokanKokuhorenSofuYM().getFromValue();
        RDate 国保連送付年月T = panel.getTxtShokanKokuhorenSofuYM().getToValue();
        FlexibleYearMonth 国保連送付年月From = 国保連送付年月F == null ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(国保連送付年月F.getYearMonth().toString());
        FlexibleYearMonth 国保連送付年月To = 国保連送付年月T == null ? FlexibleYearMonth.EMPTY
                : new FlexibleYearMonth(国保連送付年月T.getYearMonth().toString());
        RString 様式番号選択 = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getTotalRecords()
                == div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getSelectedItems().size() ? すべて_1 : 部分_2;
        List<dgYoshikiNo_Row> rowLists = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getSelectedItems();
        RStringBuilder builder = get様式番号Builder(rowLists);
        RString 様式番号 = builder.length() == 0 ? RString.EMPTY : builder.substring(0, builder.length() - 1);
        List<RString> 保険者DDL = get保険者DDL(市町村判定);
        RString 保険者コード = 保険者DDL.get(0);
        RString 保険者名 = 保険者DDL.get(1);
        boolean 項目名付加 = div.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(項目名);
        boolean 連番付加 = div.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(連番);
        boolean 日付スラッシュ付加 = div.getDvShokanbaraiParam()
                .getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys().contains(日付スラッシュ);
        long 出力順 = div.getDvShokanbaraiParam().getCcdShokanShutsuryokujun().get出力順ID() == null
                ? 0 : div.getDvShokanbaraiParam().getCcdShokanShutsuryokujun().get出力順ID();
        ReportId 帳票ID = div.getDvShokanbaraiParam().getCcdShokanShutsuryokujun().get帳票ID() == null
                ? null : div.getDvShokanbaraiParam().getCcdShokanShutsuryokujun().get帳票ID();
        parameter.setサービス提供年月From(サービス提供年月From);
        parameter.setサービス提供年月To(サービス提供年月To);
        parameter.set住宅改修支給届出日From(住宅改修支給届出日From);
        parameter.set住宅改修支給届出日To(住宅改修支給届出日To);
        parameter.set保険者コード(保険者コード);
        parameter.set保険者名(保険者名);
        parameter.set処理状況(処理状況);
        parameter.set出力順(出力順);
        parameter.set国保連送付年月From(国保連送付年月From);
        parameter.set国保連送付年月To(国保連送付年月To);
        parameter.set帳票ID(帳票ID);
        parameter.set支払方法(支払方法);
        parameter.set日付スラッシュ付加(日付スラッシュ付加);
        parameter.set様式番号(様式番号);
        parameter.set様式番号選択(様式番号選択);
        parameter.set決定情報(決定情報);
        parameter.set決定日From(決定日From);
        parameter.set決定日To(決定日To);
        parameter.set申請日From(申請日From);
        parameter.set申請日To(申請日To);
        parameter.set連番付加(連番付加);
        parameter.set金融機関コード(金融機関コード);
        parameter.set金融機関名称(金融機関名称);
        parameter.set項目名付加(項目名付加);
        parameter.setReamsLoginId(ControlDataHolder.getUserId());
        return parameter;
    }

    private RStringBuilder get様式番号Builder(List<dgYoshikiNo_Row> rowLists) {
        RStringBuilder builder = new RStringBuilder();
        for (dgYoshikiNo_Row row : rowLists) {
            builder.append(row.getYoshikiNo());
            builder.append(カンマ);
        }
        return builder;
    }

    private List<RString> get保険者DDL(RString 市町村判定) {
        List<RString> 保険者DDL = new ArrayList<>();
        if (広域.equals(市町村判定)) {
            HokenshaSummary 保険者DDLSelected = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getCcdShokanHokenshaList().getSelectedItem();
            if (!全市町村.equals(保険者DDLSelected.get市町村名称())) {
                保険者DDL.add(保険者DDLSelected.get市町村コード() == null ? RString.EMPTY : 保険者DDLSelected.get市町村コード().getColumnValue());
                保険者DDL.add(保険者DDLSelected.get市町村名称());
            }
        }
        保険者DDL.add(RString.EMPTY);
        保険者DDL.add(RString.EMPTY);
        return 保険者DDL;
    }

    private void setSelectedItems(RString 抽出条件) {
        List<dgYoshikiNo_Row> dataSources = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getDataSource();
        List<dgYoshikiNo_Row> lists_介護 = new ArrayList<>();
        List<dgYoshikiNo_Row> lists_予防 = new ArrayList<>();
        for (dgYoshikiNo_Row row : dataSources) {
            if (介護_1.equals(row.getKyufuBunruiKubun())) {
                lists_介護.add(row);
            } else if (予防_2.equals(row.getKyufuBunruiKubun())) {
                lists_予防.add(row);
            } else {
                lists_介護.add(row);
                lists_予防.add(row);
            }
        }
        if (介護.equals(抽出条件)) {
            div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setSelectedItems(lists_介護);
        } else if (予防.equals(抽出条件)) {
            div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setSelectedItems(lists_予防);
        }
    }

    private void set様式番号一覧(List<ShikibetsuNoKanri> 様式番号一覧) {
        List<dgYoshikiNo_Row> rowList = new ArrayList<>();
        for (ShikibetsuNoKanri 様式番号 : 様式番号一覧) {
            dgYoshikiNo_Row row = new dgYoshikiNo_Row();
            row.setYoshikiName(様式番号.get略称());
            row.setYoshikiNo(様式番号.get識別番号());
            row.setKyufuBunruiKubun(様式番号.get給付分類区分());
            rowList.add(row);
        }
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setDataSource(rowList);
        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setSelectedItems(rowList);
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

    /**
     * 条件を復元するボタンのメソッドです。
     *
     * @param 市町村判定 RString
     */
    public void pamaRestore(RString 市町村判定) {

        BatchParameterMap restoreBatchParameterMap = div.getBtnShokanParamRestore().getRestoreBatchParameterMap();
        restoreClear(市町村判定);
        FlexibleYearMonth サービス提供年月F = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_サービス提供年月開始);
        if (サービス提供年月F != null && !サービス提供年月F.isEmpty()) {
            div.getTxtShokanServiceTeikyoYM().setFromValue(new RDate(サービス提供年月F.getYearValue(), サービス提供年月F.getMonthValue(), サービス提供年月F.getLastDay()));
        }
        FlexibleYearMonth サービス提供年月T = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_サービス提供年月終了);
        if (サービス提供年月T != null && !サービス提供年月T.isEmpty()) {
            div.getTxtShokanServiceTeikyoYM().setToValue(new RDate(サービス提供年月T.getYearValue(), サービス提供年月T.getMonthValue(), サービス提供年月T.getLastDay()));
        }
        RString 処理状況 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_処理状況);
        if (処理状況 != null && !処理状況.isEmpty()) {
            div.getDdlShokanShoriJokyo().setSelectedKey(処理状況);
        }
        RString 決定情報 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_決定情報);
        if (決定情報 != null && !決定情報.isEmpty()) {
            div.getDdlShokanKetteiJoho().setSelectedKey(決定情報);
        }
        RString 支払方法 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_支払方法);
        if (支払方法 != null && !支払方法.isEmpty()) {
            div.getRadKogakuShiharaisaki().setSelectedKey(支払方法);
        }
        RString 金融機関コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_金融機関コード);
        RString 金融機関名称 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_金融機関名称);
        KinyuKikanShitenCode 支店コード = restoreBatchParameterMap.getParameterValue(KinyuKikanShitenCode.class, KEY_KINYUKIKANSHITENCODE);
        if (!RString.isNullOrEmpty(金融機関コード) && !RString.isNullOrEmpty(金融機関名称)) {
            set金融機関(金融機関コード, 支店コード);
        }

        pamaRestorePart2(restoreBatchParameterMap);
    }

    private void restoreClear(RString 市町村判定) {
        if (広域.equals(市町村判定)) {
            div.getCcdShokanHokenshaList().loadHokenshaList();
        } else {
            div.getCcdShokanHokenshaList().setDisabled(true);
            div.getCcdShokanHokenshaList().setDisplayNone(true);
        }
        div.getTxtShokanServiceTeikyoYM().clearFromValue();
        div.getTxtShokanServiceTeikyoYM().clearToValue();
        div.getCcdKogakuKinyuKikan().clear();
        div.getTxtShokanShinseiDate().clearFromValue();
        div.getTxtShokanShinseiDate().clearToValue();
        div.getTxtShokanHokenshaKetteiDate().clearFromValue();
        div.getTxtShokanHokenshaKetteiDate().clearToValue();
        div.getTxtShokanKetteiDate().clearFromValue();
        div.getTxtShokanKetteiDate().clearToValue();
        div.getTxtShokanKokuhorenSofuYM().clearFromValue();
        div.getTxtShokanKokuhorenSofuYM().clearToValue();
    }

    private void pamaRestorePart2(BatchParameterMap restoreBatchParameterMap) {

        FlexibleDate 申請日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_申請日開始);
        if (申請日From != null && !申請日From.isEmpty()) {
            div.getTxtShokanShinseiDate().setFromValue(new RDate(申請日From.toString()));
        }
        FlexibleDate 申請日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_申請日終了);
        if (申請日To != null && !申請日To.isEmpty()) {
            div.getTxtShokanShinseiDate().setToValue(new RDate(申請日To.toString()));
        }
        FlexibleDate 住宅改修支給届出日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_住宅改修支給届出日開始);
        if (住宅改修支給届出日From != null && !住宅改修支給届出日From.isEmpty()) {
            div.getTxtShokanHokenshaKetteiDate().setFromValue(new RDate(住宅改修支給届出日From.toString()));
        }
        FlexibleDate 住宅改修支給届出日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_住宅改修支給届出日終了);
        if (住宅改修支給届出日To != null && !住宅改修支給届出日To.isEmpty()) {
            div.getTxtShokanHokenshaKetteiDate().setToValue(new RDate(住宅改修支給届出日To.toString()));
        }
        FlexibleDate 決定日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_決定日開始);
        if (決定日From != null && !決定日From.isEmpty()) {
            div.getTxtShokanKetteiDate().setFromValue(new RDate(決定日From.toString()));
        }
        FlexibleDate 決定日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, KEY_決定日終了);
        if (決定日To != null && !決定日To.isEmpty()) {
            div.getTxtShokanKetteiDate().setToValue(new RDate(決定日To.toString()));
        }

        FlexibleYearMonth 国保連送付年月From = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_国保連送付年月開始);
        if (国保連送付年月From != null && !国保連送付年月From.isEmpty()) {
            div.getTxtShokanKokuhorenSofuYM().setFromValue(new RDate(国保連送付年月From.getYearValue(), 国保連送付年月From.getMonthValue(), 国保連送付年月From.getLastDay()));
        }
        FlexibleYearMonth 国保連送付年月To = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, KEY_国保連送付年月終了);
        if (国保連送付年月To != null && !国保連送付年月To.isEmpty()) {
            div.getTxtShokanKokuhorenSofuYM().setToValue(new RDate(国保連送付年月To.getYearValue(), 国保連送付年月To.getMonthValue(), 国保連送付年月To.getLastDay()));
        }
        pamaRestorePart3(restoreBatchParameterMap);
        onChange支払先RDB();
    }

    private void pamaRestorePart3(BatchParameterMap restoreBatchParameterMap) {

        RString 様式番号 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_様式番号);
        List<dgYoshikiNo_Row> 様式番号選択リスト = new ArrayList<>();
        if (様式番号 != null && !様式番号.isEmpty()) {
            List<RString> 識別番号リスト = 様式番号.split(カンマ.toString());
            if (識別番号リスト != null && !識別番号リスト.isEmpty()) {
                get様式番号選択(識別番号リスト, 様式番号選択リスト);
            }
        }
        if (!様式番号選択リスト.isEmpty()) {
            div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().setSelectedItems(様式番号選択リスト);
        }
        RString 保険者コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_保険者コード);
        if (保険者コード != null && !保険者コード.isEmpty()) {
            div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getCcdShokanHokenshaList()
                    .setSelectedShichosonIfExist(new LasdecCode(保険者コード));
        }
        RString 保険者名 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_保険者名);
        if (保険者名 != null && !保険者名.isEmpty()) {
            div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getCcdShokanHokenshaList()
                    .setSelectedShoKisaiHokenshaNoIfExist(new ShoKisaiHokenshaNo(保険者名));
        }
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_項目名付加);
        if (項目名付加) {
            csv編集方法リスト.add(項目名);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_連番付加);
        if (連番付加) {
            csv編集方法リスト.add(連番);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_日付スラッシュ付加);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(日付スラッシュ);
        }
        div.getDvShokanbaraiParam().getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        RString 出力順 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_出力順);
        if (出力順 != null && !出力順.isEmpty()) {
            div.getDvShokanbaraiParam().getCcdShokanShutsuryokujun().load(SubGyomuCode.DBC介護給付, REPORTID,
                    Long.valueOf(出力順.toString()));
        }
    }

    private void set金融機関(RString 金融機関コード, KinyuKikanShitenCode 支店コード) {
        if (支店コード != null && !支店コード.isEmpty()) {
            div.getCcdKogakuKinyuKikan().search(new KinyuKikanCode(金融機関コード),
                    支店コード, FlexibleDate.getNowDate());
        } else {
            KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
            KinyuKikan 金融機関 = kinyuKikanManager.getValidKinyuKikanOn(FlexibleDate.getNowDate(), 金融機関コード.substring(INDEX_0, INDEX_4));
            if (金融機関 != null) {
                div.getCcdKogakuKinyuKikan().set金融機関(金融機関);
            }
        }
    }

    private void get様式番号選択(List<RString> 識別番号リスト, List<dgYoshikiNo_Row> 様式番号選択リスト) {
        List<dgYoshikiNo_Row> 様式番号リスト = div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo().getDataSource();
        for (dgYoshikiNo_Row 様式番号 : 様式番号リスト) {
            for (RString 識別番号 : 識別番号リスト) {
                set様式番号選択リスト(様式番号選択リスト, 様式番号, 識別番号);
            }
        }

    }

    private void set様式番号選択リスト(List<dgYoshikiNo_Row> 様式番号選択リスト, dgYoshikiNo_Row 様式番号, RString 識別番号) {
        if (様式番号.getYoshikiNo().equals(識別番号)) {
            様式番号選択リスト.add(様式番号);
        }
    }

}
