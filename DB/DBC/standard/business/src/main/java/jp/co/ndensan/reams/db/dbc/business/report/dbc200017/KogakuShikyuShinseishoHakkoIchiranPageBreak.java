/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票における改頁処理クラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class KogakuShikyuShinseishoHakkoIchiranPageBreak extends PageBreaker<KogakuShikyuShinseishoHakkoIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public KogakuShikyuShinseishoHakkoIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public KogakuShikyuShinseishoHakkoIchiranPageBreak(RString key, RString... any) {
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
    public boolean isBreak(ReportLineRecord<KogakuShikyuShinseishoHakkoIchiranSource> currentRecord,
            ReportLineRecord<KogakuShikyuShinseishoHakkoIchiranSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_5.equals(nextRecord.getSource().listHakkoTaishosha_5);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.町域コード.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_6.equals(nextRecord.getSource().listHakkoTaishosha_6);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_7.equals(nextRecord.getSource().listHakkoTaishosha_7);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
            flag = !currentRecord.getSource().氏名カナ.equals(nextRecord.getSource().氏名カナ);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.市町村コード.get項目ID())) {
            flag = !currentRecord.getSource().shichosonNo.equals(nextRecord.getSource().shichosonNo);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().shichosonNo.equals(nextRecord.getSource().shichosonNo);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_2.equals(nextRecord.getSource().listHakkoTaishosha_2);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.サービス年月.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_3.equals(nextRecord.getSource().listHakkoTaishosha_3);
        }
        if (!flag && this.keys.contains(KogakuShikyuShinseishoHakkoIchiranOrder.サービス分類.get項目ID())) {
            flag = !currentRecord.getSource().サービス種類.equals(nextRecord.getSource().サービス種類);
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
