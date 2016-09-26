/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5150011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160020.DBC160020_ServicecodeIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.servicecodeichiran.ChushutsuJokenKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011.DBC5150011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011.dgServiceBunruiList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.ShutsuryokuHoho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMNJ2006_サービスコード一覧表のハンドラクラスです。
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class DBC5150011MainHandler {

    private final DBC5150011MainDiv div;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_3 = new RString("3");
    private static final RString 項目名付加 = new RString("項目名付加");
    private static final RString 連番付加 = new RString("連番付加");
    private static final RString 日付編集 = new RString("日付’／’編集");

    /**
     * コンストラクタです。
     *
     * @param div DBC5150011MainDiv
     */
    public DBC5150011MainHandler(DBC5150011MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void initialize() {
        List<dgServiceBunruiList_Row> rowList = new ArrayList<>();
        dgServiceBunruiList_Row row;
        for (ServiceBunrui サービス分類 : ServiceBunrui.values()) {
            row = new dgServiceBunruiList_Row();
            row.setHdnServiceBunrui(new RString(サービス分類.toString()));
            rowList.add(row);
        }
        div.getDgServiceBunruiList().setDataSource(rowList);
        List<KeyValueDataSource> radDataSource = new ArrayList<>();
        for (ChushutsuJokenKubun 抽出条件区分 : ChushutsuJokenKubun.values()) {
            if (抽出条件区分.getコード().equals(RSTRING_0)) {
                radDataSource.add(new KeyValueDataSource(抽出条件区分.getコード(), 抽出条件区分.get名称()));
                div.getRadChushutsuJokenAll().setDataSource(radDataSource);
                radDataSource.clear();
            } else if (抽出条件区分.getコード().equals(RSTRING_1)) {
                radDataSource.add(new KeyValueDataSource(抽出条件区分.getコード(), 抽出条件区分.get名称()));
                div.getRadChushutsuJokenServiceCode().setDataSource(radDataSource);
                radDataSource.clear();
            } else {
                radDataSource.add(new KeyValueDataSource(抽出条件区分.getコード(), 抽出条件区分.get名称()));
                div.getRadChushutsuJokenServiceBunrui().setDataSource(radDataSource);
                radDataSource.clear();
            }
        }
        div.getCcdServiceCodeInput().initialize();
        div.getRadChushutsuJokenAll().setSelectedIndex(INT_0);
        List<KeyValueDataSource> chkDataSource = new ArrayList<>();
        for (ShutsuryokuHoho 出力方法 : ShutsuryokuHoho.values()) {
            chkDataSource.add(new KeyValueDataSource(出力方法.getコード(), 出力方法.get名称()));
        }
        div.getChkShutsuryokuTaisho().setDataSource(chkDataSource);
        List<RString> keyList = new ArrayList<>();
        keyList.add(KEY_1);
        keyList.add(KEY_3);
        div.getChkMeisaiCsvEdit().setSelectedItemsByKey(keyList);
    }

    /**
     * 抽出条件区分RBTをonChangeです。
     *
     */
    public void onChanged_radMeisaiGokeiOut() {
        if (div.getRadChushutsuJokenAll().getSelectedKey() != null && !div.getRadChushutsuJokenAll().getSelectedKey().isEmpty()) {
            set抽出条件エリア状態();
            div.getTxtKijunYM().setRequired(true);
            div.getDgServiceBunruiList().setDisabled(true);
            div.getDgServiceBunruiList().setSelectedItems(Collections.EMPTY_LIST);
        } else if (div.getRadChushutsuJokenServiceCode().getSelectedKey() != null
                && !div.getRadChushutsuJokenServiceCode().getSelectedKey().isEmpty()) {
            div.getCcdServiceCodeInput().setDisabled(false);
            div.getTxtKijunYM().setRequired(false);
            div.getDgServiceBunruiList().setDisabled(true);
            div.getDgServiceBunruiList().setSelectedItems(Collections.EMPTY_LIST);
        } else if (div.getRadChushutsuJokenServiceBunrui().getSelectedKey() != null
                && !div.getRadChushutsuJokenServiceBunrui().getSelectedKey().isEmpty()) {
            set抽出条件エリア状態();
            div.getTxtKijunYM().setRequired(false);
            div.getDgServiceBunruiList().setDisabled(false);
        }
    }

    /**
     * 出力方法CBLをonChangeです。
     *
     */
    public void onChanged_chkShutsuryokuTaisho() {
        List<RString> selectValues = div.getChkShutsuryokuTaisho().getSelectedValues();
        if (selectValues.isEmpty()) {
            div.getChkMeisaiCsvEdit().setDisabled(true);
        } else {
            if (selectValues.contains(ShutsuryokuHoho.ＣＳＶファイルで出力.get名称())) {
                div.getChkMeisaiCsvEdit().setDisabled(false);
            } else {
                div.getChkMeisaiCsvEdit().setDisabled(true);
            }
        }
    }

    /**
     * バッチパラメータの設定のメソッドです。
     *
     * @return DBC160020_ServicecodeIchiranParameter
     */
    public DBC160020_ServicecodeIchiranParameter setParameter() {
        DBC160020_ServicecodeIchiranParameter parameter = new DBC160020_ServicecodeIchiranParameter();
        if (div.getTxtKijunYM().getValue() != null) {
            parameter.set基準年月(new FlexibleYearMonth(div.getTxtKijunYM().getValue().getYearMonth().toDateString()));
        }
        if (div.getRadChushutsuJokenAll().getSelectedKey() != null && !div.getRadChushutsuJokenAll().getSelectedKey().isEmpty()) {
            parameter.set抽出条件区分(div.getRadChushutsuJokenAll().getSelectedValue());
        } else if (div.getRadChushutsuJokenServiceCode().getSelectedKey() != null
                && !div.getRadChushutsuJokenServiceCode().getSelectedKey().isEmpty()) {
            parameter.set抽出条件区分(div.getRadChushutsuJokenServiceCode().getSelectedValue());
            parameter.setサービス種類コード(new ServiceShuruiCode(div.getCcdServiceCodeInput().getサービスコード1()));
            parameter.setサービス項目コード(div.getCcdServiceCodeInput().getサービスコード2());
        } else {
            parameter.set抽出条件区分(div.getRadChushutsuJokenServiceBunrui().getSelectedValue());
            List<Code> サービス分類List = new ArrayList<>();
            List<dgServiceBunruiList_Row> rowList = div.getDgServiceBunruiList().getSelectedItems();
            for (dgServiceBunruiList_Row row : rowList) {
                setサービス分類List(サービス分類List, row);
            }
            parameter.setサービス分類s(サービス分類List);
        }
        List<RString> selectValues = div.getChkShutsuryokuTaisho().getSelectedValues();
        if (selectValues.contains(ShutsuryokuHoho.帳票で出力.get名称())) {
            parameter.set帳票で出力(true);
        } else {
            parameter.set帳票で出力(false);
        }
        if (selectValues.contains(ShutsuryokuHoho.ＣＳＶファイルで出力.get名称())) {
            parameter.setＣＳＶファイルで出力(true);
            List<RString> values = div.getChkMeisaiCsvEdit().getSelectedValues();
            if (values.contains(項目名付加)) {
                parameter.set項目名付加(true);
            } else {
                parameter.set項目名付加(false);
            }
            if (values.contains(連番付加)) {
                parameter.set連番付加(true);
            } else {
                parameter.set連番付加(false);
            }
            if (values.contains(日付編集)) {
                parameter.set日付編集(true);
            } else {
                parameter.set日付編集(false);
            }
        } else {
            parameter.setＣＳＶファイルで出力(false);
        }
        return parameter;
    }

    private void setサービス分類List(List<Code> サービス分類List, dgServiceBunruiList_Row row) {
        for (ServiceBunrui サービス分類 : ServiceBunrui.values()) {
            if (row.getHdnServiceBunrui().equals(new RString(サービス分類.toString()))) {
                サービス分類List.add(new Code(サービス分類.getコード().length() == INT_1
                        ? RSTRING_0.concat(サービス分類.getコード()) : サービス分類.getコード()));
            }
        }
    }

    private void set抽出条件エリア状態() {
        div.getCcdServiceCodeInput().setDisabled(true);
        div.getCcdServiceCodeInput().setサービス名称(RString.EMPTY);
    }
}
