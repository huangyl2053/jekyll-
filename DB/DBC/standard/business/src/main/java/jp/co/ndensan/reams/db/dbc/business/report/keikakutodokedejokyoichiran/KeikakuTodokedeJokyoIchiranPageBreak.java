/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.keikakutodokedejokyoichiran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票における改頁処理クラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
public class KeikakuTodokedeJokyoIchiranPageBreak extends PageBreaker<KyotakuServiceKeikakuSakuseiSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public KeikakuTodokedeJokyoIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public KeikakuTodokedeJokyoIchiranPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));
    }

    /**
     * 改頁キーを取得します。
     *
     * @return 改頁キー
     */
    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    /**
     * 改頁キーより、改頁の判断します。
     *
     * @param currentRecord currentレコード
     * @param nextRecord nextレコード
     * @return 改頁判断結果、true：改頁；false：改頁なし
     */
    @Override
    public boolean isBreak(ReportLineRecord<KyotakuServiceKeikakuSakuseiSource> currentRecord,
            ReportLineRecord<KyotakuServiceKeikakuSakuseiSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.郵便番号.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().yubinNo).equals(nextRecord.getSource().yubinNo);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.町域コード.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().choikiCode).equals(nextRecord.getSource().choikiCode);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.番地コード1.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().banchiCode1).equals(nextRecord.getSource().banchiCode1);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.番地コード2.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().banchiCode2).equals(nextRecord.getSource().banchiCode2);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.番地コード3.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().banchiCode3).equals(nextRecord.getSource().banchiCode3);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.番地コード4.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().banchiCode4).equals(nextRecord.getSource().banchiCode4);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.行政区コード.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList1_4).equals(nextRecord.getSource().listList1_4);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.識別コード.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList2_1).equals(nextRecord.getSource().listList2_1);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.氏名５０音カナ.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().kanaMeisho).equals(nextRecord.getSource().kanaMeisho);
        }

        return isBreak2(currentRecord, nextRecord, flag);
    }

    private boolean isBreak2(ReportLineRecord<KyotakuServiceKeikakuSakuseiSource> currentRecord,
            ReportLineRecord<KyotakuServiceKeikakuSakuseiSource> nextRecord, boolean flag) {
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.生年月日.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList3_1).equals(nextRecord.getSource().listList3_1);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.性別.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().seibetsuCode).equals(nextRecord.getSource().seibetsuCode);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.市町村コード.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().shichosonCode).equals(nextRecord.getSource().shichosonCode);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.被保険者番号.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList1_1).equals(nextRecord.getSource().listList1_1);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.計画届出日.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList1_9).equals(nextRecord.getSource().listList1_9);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.指定事業者番号.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList2_8).equals(nextRecord.getSource().listList2_8);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.受給申請日.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList1_6).equals(nextRecord.getSource().listList1_6);
        }
        if (!flag && this.keys.contains(KeikakuTodokedeJokyoIchiranOrder.認定日.get項目ID())) {
            flag = !checkNull(currentRecord.getSource().listList2_7).equals(nextRecord.getSource().listList2_7);
        }
        return flag;
    }

    private RString checkNull(RString rstring) {
        if (rstring == null) {
            return RString.EMPTY;
        } else {
            return rstring;
        }
    }

    private static List<RString> createBreakKeys(RString key, RString... any) {
        List<RString> list = new ArrayList<>();
        list.add(Objects.requireNonNull(key));
        list.addAll(Arrays.asList(any));
        return list;
    }
}
