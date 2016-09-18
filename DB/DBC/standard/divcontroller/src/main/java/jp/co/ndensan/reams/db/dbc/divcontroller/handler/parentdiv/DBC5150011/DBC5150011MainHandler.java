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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011.dgServiceShuruiList_Row;
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
    private static final int INT_1 = 0;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_3 = new RString("3");
    private static final RString サービスコード一覧表 = new RString("サービスコード一覧表");
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
        List<dgServiceShuruiList_Row> rowList = new ArrayList<>();
        dgServiceShuruiList_Row row;
        for (ServiceBunrui サービス分類 : ServiceBunrui.values()) {
            row = new dgServiceShuruiList_Row();
            row.setHdnServiceBunrui(new RString(サービス分類.toString()));
            rowList.add(row);
        }
        div.getDgServiceShuruiList().setDataSource(rowList);
        div.getTxtTitle().setValue(サービスコード一覧表);
        List<KeyValueDataSource> radDataSource = new ArrayList<>();
        for (ChushutsuJokenKubun 抽出条件区分 : ChushutsuJokenKubun.values()) {
            radDataSource.add(new KeyValueDataSource(抽出条件区分.getコード(), 抽出条件区分.get名称()));
        }
        div.getRadMeisaiGokeiOut().setDataSource(radDataSource);
        div.getRadMeisaiGokeiOut().setSelectedIndex(INT_0);
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
        if (div.getRadMeisaiGokeiOut().getSelectedValue().equals(ChushutsuJokenKubun.すべて.get名称())) {
            set抽出条件エリア状態();
            div.getTxtKijyouDate().setRequired(true);
            div.getDgServiceShuruiList().setDisabled(true);
            div.getDgServiceShuruiList().setSelectedItems(Collections.EMPTY_LIST);
        } else if (div.getRadMeisaiGokeiOut().getSelectedValue().equals(ChushutsuJokenKubun.サービスコードを指定.get名称())) {
            div.getBtnServiceCode().setDisabled(false);
            div.getTxtKijyouDate().setRequired(false);
            div.getTxtSyuruiCode().setRequired(false);
            div.getTxtServiceCode().setDisabled(false);
            div.getTxtSyuruiCode().setDisabled(false);
            div.getDgServiceShuruiList().setDisabled(true);
            div.getDgServiceShuruiList().setSelectedItems(Collections.EMPTY_LIST);
        } else if (div.getRadMeisaiGokeiOut().getSelectedValue().equals(ChushutsuJokenKubun.サービス分類を指定.get名称())) {
            set抽出条件エリア状態();
            div.getTxtKijyouDate().setRequired(false);
            div.getDgServiceShuruiList().setDisabled(false);
        }
    }

    /**
     * 出力方法CBLをonChangeです。
     *
     */
    public void onChanged_chkShutsuryokuTaisho() {
        List<RString> selectValues = div.getChkShutsuryokuTaisho().getSelectedValues();
        if (selectValues.isEmpty()) {
            div.getTxtTitle().setDisabled(true);
            div.getTxtTitle().setRequired(false);
            div.getChkMeisaiCsvEdit().setDisabled(true);
        } else {
            if (selectValues.contains(ShutsuryokuHoho.帳票で出力.get名称())) {
                div.getTxtTitle().setDisabled(false);
                div.getTxtTitle().setRequired(true);
            } else {
                div.getTxtTitle().setDisabled(true);
                div.getTxtTitle().setRequired(false);
            }
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
        if (div.getTxtKijyouDate().getValue() != null) {
            parameter.set基準年月(new FlexibleYearMonth(div.getTxtKijyouDate().getValue().getYearMonth().toDateString()));
        }
        parameter.set抽出条件区分(div.getRadMeisaiGokeiOut().getSelectedValue());
        if (div.getRadMeisaiGokeiOut().getSelectedValue().equals(ChushutsuJokenKubun.サービスコードを指定.get名称())) {
            parameter.setサービス種類コード(new ServiceShuruiCode(div.getTxtSyuruiCode().getValue()));
            parameter.setサービス項目コード(div.getTxtServiceCode().getValue());
        }
        if (div.getRadMeisaiGokeiOut().getSelectedValue().equals(ChushutsuJokenKubun.サービス分類を指定.get名称())) {
            List<Code> サービス分類List = new ArrayList<>();
            List<dgServiceShuruiList_Row> rowList = div.getDgServiceShuruiList().getSelectedItems();
            for (dgServiceShuruiList_Row row : rowList) {
                setサービス分類List(サービス分類List, row);
            }
            parameter.setサービス分類s(サービス分類List);
        }
        List<RString> selectValues = div.getChkShutsuryokuTaisho().getSelectedValues();
        if (selectValues.contains(ShutsuryokuHoho.帳票で出力.get名称())) {
            parameter.set帳票で出力(true);
            parameter.set表題(div.getTxtTitle().getValue());
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

    private void setサービス分類List(List<Code> サービス分類List, dgServiceShuruiList_Row row) {
        for (ServiceBunrui サービス分類 : ServiceBunrui.values()) {
            if (row.getHdnServiceBunrui().equals(new RString(サービス分類.toString()))) {
                サービス分類List.add(new Code(サービス分類.getコード().length() == INT_1
                        ? RSTRING_0.concat(サービス分類.getコード()) : サービス分類.getコード()));
            }
        }
    }

    private void set抽出条件エリア状態() {
        div.getBtnServiceCode().setDisabled(true);
        div.getTxtServiceCode().setDisabled(true);
        div.getTxtServiceCode().setValue(RString.EMPTY);
        div.getTxtSyuruiCode().setDisabled(true);
        div.getTxtSyuruiCode().setValue(RString.EMPTY);
        div.getTxtSyuruiCode().setRequired(false);
    }
}
