/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 特別徴収平準化計算（特別徴収8月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranPageBreak extends PageBreaker<TokubetsuChoshuHeijunkaKeisanIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public TokubetsuChoshuHeijunkaKeisanIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public TokubetsuChoshuHeijunkaKeisanIchiranPageBreak(RString key, RString... any) {
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
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuHeijunkaKeisanIchiranSource> currentRecord,
            ReportLineRecord<TokubetsuChoshuHeijunkaKeisanIchiranSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(DBB200005_HeijunkaKeisanIchiran.行政区コード.get項目ID())
                && !currentRecord.getSource().listUpper_3.equals(nextRecord.getSource().listUpper_3)) {
            flag = true;
        } else if (!flag && this.keys.contains(DBB200005_HeijunkaKeisanIchiran.世帯コード.get項目ID())
                && !currentRecord.getSource().listLower_2.equals(nextRecord.getSource().listLower_2)) {
            flag = true;
        } else if (!flag && this.keys.contains(DBB200005_HeijunkaKeisanIchiran.識別コード.get項目ID())
                && !currentRecord.getSource().listUpper_2.equals(nextRecord.getSource().listUpper_2)) {
            flag = true;
        } else if (!flag && this.keys.contains(DBB200005_HeijunkaKeisanIchiran.被保険者番号.get項目ID())
                && !currentRecord.getSource().listLower_1.equals(nextRecord.getSource().listLower_1)) {
            flag = true;
        } else if (!flag && this.keys.contains(DBB200005_HeijunkaKeisanIchiran.町域コード.get項目ID())
                && !currentRecord.getSource().listLower_3.equals(nextRecord.getSource().listLower_3)) {
            flag = true;
        } else if (!flag && this.keys.contains(DBB200005_HeijunkaKeisanIchiran.市町村コード.get項目ID())
                && !currentRecord.getSource().hokenshacd.equals(nextRecord.getSource().hokenshacd)) {
            flag = true;
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
