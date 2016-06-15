/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.KetteiJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShiharaiHoho;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan.ShoriJokyo;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoBatchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvKensakuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanChushutsuJokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.dgYoshikiNo_Row;
import jp.co.ndensan.reams.db.dbc.service.core.dvshokanbaraijoho.DvShokanbaraiJohoManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
        if (市町村セキュリティ情報 == null) {
            throw new SystemException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (市町村セキュリティ情報.get導入形態コード() != null
                && 市町村セキュリティ情報.get導入形態コード().is広域()) {
            市町村判定 = 広域;
            panel.getCcdShokanHokenshaList().loadHokenshaList();
        } else {
            panel.getCcdShokanHokenshaList().setDisabled(true);
            panel.getCcdShokanHokenshaList().setVisible(false);
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
    public HanyoListShokanbaraiJokyoBatchParameter setBatchParamter(RString 市町村判定) {
        HanyoListShokanbaraiJokyoBatchParameter parameter = new HanyoListShokanbaraiJokyoBatchParameter();
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

}
