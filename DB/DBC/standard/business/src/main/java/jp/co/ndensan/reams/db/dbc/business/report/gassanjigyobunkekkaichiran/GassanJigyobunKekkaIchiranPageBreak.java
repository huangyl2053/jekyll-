/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業分支給額計算結果一覧表改頁クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class GassanJigyobunKekkaIchiranPageBreak extends PageBreaker<GassanJigyobunKekkaIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public GassanJigyobunKekkaIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<GassanJigyobunKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJigyobunKekkaIchiranSource> nextRecord) {
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.証記載保険者番号.get項目ID())
                && !currentRecord.getSource().shoKisaiHokenshaNo.equals(nextRecord.getSource().shoKisaiHokenshaNo)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.郵便番号.get項目ID())
                && !currentRecord.getSource().yubinNo.equals(nextRecord.getSource().yubinNo)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.町域コード.get項目ID())
                && !currentRecord.getSource().jushoCode.equals(nextRecord.getSource().jushoCode)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.行政区コード.get項目ID())
                && !currentRecord.getSource().gyoseiCode.equals(nextRecord.getSource().gyoseiCode)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.氏名５０音カナ.get項目ID())
                && !currentRecord.getSource().List1_2.equals(nextRecord.getSource().List1_2)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.市町村コード.get項目ID())
                && !currentRecord.getSource().shichosonCode.equals(nextRecord.getSource().shichosonCode)) {
            return true;
        }
        return isBreak2(currentRecord, nextRecord);
    }

    private boolean isBreak2(ReportLineRecord<GassanJigyobunKekkaIchiranSource> currentRecord,
            ReportLineRecord<GassanJigyobunKekkaIchiranSource> nextRecord) {
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.被保険者番号.get項目ID())
                && !currentRecord.getSource().List1_1.equals(nextRecord.getSource().List1_1)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.支払方法.get項目ID())
                && !currentRecord.getSource().List1_14.equals(nextRecord.getSource().List1_14)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.対象年度.get項目ID())
                && !currentRecord.getSource().taishoNendo.equals(nextRecord.getSource().taishoNendo)) {
            return true;
        }
        if (this.keys.contains(GassanJigyobunKekkaIchiranOrder.支給区分コード.get項目ID())
                && !currentRecord.getSource().List1_4.equals(nextRecord.getSource().List1_4)) {
            return true;
        }
        return this.keys.contains(GassanJigyobunKekkaIchiranOrder.申請書整理番号.get項目ID())
                && !currentRecord.getSource().List1_3.equals(nextRecord.getSource().List1_3);
    }
}
