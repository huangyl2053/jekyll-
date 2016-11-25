/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanrenrakuhyosofuichiran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200025.ShokanRenrakuhyoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票における改頁処理クラスです。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
public class ShokanRenrakuhyoSofuIchiranPageBreak extends PageBreaker<ShokanRenrakuhyoSofuIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public ShokanRenrakuhyoSofuIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public ShokanRenrakuhyoSofuIchiranPageBreak(RString key, RString... any) {
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
    public boolean isBreak(ReportLineRecord<ShokanRenrakuhyoSofuIchiranSource> currentRecord,
            ReportLineRecord<ShokanRenrakuhyoSofuIchiranSource> nextRecord) {
        boolean flag;
        if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.保険者番号.get項目ID())
                && checkNull(currentRecord.getSource().hokenshaNo).equals(nextRecord.getSource().hokenshaNo)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.郵便番号.get項目ID())
                && checkNull(currentRecord.getSource().yubinNo).equals(nextRecord.getSource().yubinNo)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.町域コード.get項目ID())
                && checkNull(currentRecord.getSource().choikiCode).equals(nextRecord.getSource().choikiCode)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.行政区コード.get項目ID())
                && checkNull(currentRecord.getSource().gyoseikuCode).equals(nextRecord.getSource().gyoseikuCode)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.氏名５０音カナ.get項目ID())
                && checkNull(currentRecord.getSource().shimei50onKana).equals(nextRecord.getSource().shimei50onKana)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.市町村コード.get項目ID())
                && checkNull(currentRecord.getSource().shichosonCode).equals(nextRecord.getSource().shichosonCode)) {
            flag = true;
        } else {
            flag = isSourceBreak(currentRecord, nextRecord);
        }
        return flag;
    }

    private boolean isSourceBreak(ReportLineRecord<ShokanRenrakuhyoSofuIchiranSource> currentRecord,
            ReportLineRecord<ShokanRenrakuhyoSofuIchiranSource> nextRecord) {
        boolean flag = false;
        if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.被保険者番号.get項目ID())
                && checkNull(currentRecord.getSource().list_5).equals(nextRecord.getSource().list_5)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.サービス提供年月.get項目ID())
                && checkNull(currentRecord.getSource().list_3).equals(nextRecord.getSource().list_3)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.整理番号.get項目ID())
                && checkNull(currentRecord.getSource().list_2).equals(nextRecord.getSource().list_2)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.償還払申請日.get項目ID())
                && checkNull(currentRecord.getSource().shinseiYMD).equals(nextRecord.getSource().shinseiYMD)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.指定事業者番号.get項目ID())
                && checkNull(currentRecord.getSource().jigyoshaNo).equals(nextRecord.getSource().jigyoshaNo)) {
            flag = true;
        } else if (this.keys.contains(ShokanRenrakuhyoSofuIchiranOrder.様式番号.get項目ID())
                && checkNull(currentRecord.getSource().list_14).equals(nextRecord.getSource().list_14)) {
            flag = true;
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
