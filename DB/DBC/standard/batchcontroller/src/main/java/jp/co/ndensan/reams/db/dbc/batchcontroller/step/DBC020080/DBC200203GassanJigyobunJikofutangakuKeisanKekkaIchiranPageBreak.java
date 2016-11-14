/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran.GassanJigyobunJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
public class DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranPageBreak extends
        PageBreaker<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> nextRecord) {
        boolean flag = false;
        flag = isBreak2(flag, currentRecord, nextRecord);
        return flag;
    }

    private boolean isBreak2(boolean flag, ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> nextRecord) {
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().list_1.equals(nextRecord.getSource().list_1);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.申請年月日.get項目ID())) {
            flag = !currentRecord.getSource().list_6.equals(nextRecord.getSource().list_6);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.対象年度.get項目ID())) {
            flag = !currentRecord.getSource().list_7.equals(nextRecord.getSource().list_7);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.申請書整理番号.get項目ID())) {
            flag = !currentRecord.getSource().list_5.equals(nextRecord.getSource().list_5);
        }
        return isBreak1(flag, currentRecord, nextRecord);
    }

    private boolean isBreak1(boolean flag, ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJigyobunJikofutangakuKeisanKekkaIchiranSource> nextRecord) {
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.郵便番号.get項目ID())) {
            flag = !currentRecord.getSource().yubinNo.equals(nextRecord.getSource().yubinNo);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.町域コード.get項目ID())) {
            flag = !currentRecord.getSource().choikiCode.equals(nextRecord.getSource().choikiCode);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().gyoseikuCode.equals(nextRecord.getSource().gyoseikuCode);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.氏名５０音カナ.get項目ID())) {
            flag = !currentRecord.getSource().list_2.equals(nextRecord.getSource().list_2);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.市町村コード.get項目ID())) {
            flag = !currentRecord.getSource().shichosonCode.equals(nextRecord.getSource().shichosonCode);
        }
        if (!flag && this.keys.contains(DBC200203GassanJigyobunJikofutangakuKeisanKekkaIchiranOutputOrder.証記載保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().hokenshaNo.equals(nextRecord.getSource().hokenshaNo);
        }
        return flag;
    }

    private static List<RString> createBreakKeys(RString key, RString... any) {
        List<RString> list = new ArrayList<>();
        list.add(Objects.requireNonNull(key));
        list.addAll(Arrays.asList(any));
        return list;
    }

}
