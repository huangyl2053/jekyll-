/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC200029GassanKekkaIchiranPageBreak extends PageBreaker<GassanJikofutangakuKeisanKekkaIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public DBC200029GassanKekkaIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public DBC200029GassanKekkaIchiranPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> nextRecord) {
        boolean flag = false;
        flag = isBreak1(flag, currentRecord, nextRecord);
        flag = isBreak2(flag, currentRecord, nextRecord);
        return flag;
    }

    private boolean isBreak2(boolean flag, ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> nextRecord) {
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().list_1.equals(nextRecord.getSource().list_1);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.申請年月日.get項目ID())) {
            flag = !currentRecord.getSource().list_6.equals(nextRecord.getSource().list_6);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.対象年度.get項目ID())) {
            flag = !currentRecord.getSource().list_7.equals(nextRecord.getSource().list_7);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.申請書整理番号.get項目ID())) {
            flag = !currentRecord.getSource().list_5.equals(nextRecord.getSource().list_5);
        }
        return flag;
    }

    private boolean isBreak1(boolean flag, ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJikofutangakuKeisanKekkaIchiranSource> nextRecord) {
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.郵便番号.get項目ID())) {
            flag = !currentRecord.getSource().yubinNo.equals(nextRecord.getSource().yubinNo);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.町域コード.get項目ID())) {
            flag = !currentRecord.getSource().choikiCode.equals(nextRecord.getSource().choikiCode);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().gyoseikuCode.equals(nextRecord.getSource().gyoseikuCode);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.氏名５０音カナ.get項目ID())) {
            flag = !currentRecord.getSource().list_2.equals(nextRecord.getSource().list_2);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.市町村コード.get項目ID())) {
            flag = !currentRecord.getSource().shichosonCode.equals(nextRecord.getSource().shichosonCode);
        }
        if (!flag && this.keys.contains(DBC200029GassanKekkaIchiranOutputOrder.証記載保険者番号.get項目ID())) {
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
