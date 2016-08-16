/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票における改頁処理クラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun TODO KogakuJigyoShikyuShinseishoYuchoSource 不正
 */
public class KogakuJigyoShinseishoHakkoIchiranPageBreak extends PageBreaker<KogakuJigyoShinseishoHakkoIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public KogakuJigyoShinseishoHakkoIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public KogakuJigyoShinseishoHakkoIchiranPageBreak(RString key, RString... any) {
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
    public boolean isBreak(ReportLineRecord<KogakuJigyoShinseishoHakkoIchiranSource> currentRecord,
            ReportLineRecord<KogakuJigyoShinseishoHakkoIchiranSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().shichosonNo.equals(nextRecord.getSource().shichosonNo);
        }
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_4.equals(nextRecord.getSource().listHakkoTaishosha_4);
        }
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_6.equals(nextRecord.getSource().listHakkoTaishosha_6);
        }
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_3.equals(nextRecord.getSource().listHakkoTaishosha_3);
        }
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_1.equals(nextRecord.getSource().listHakkoTaishosha_1);
        }
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.サービス提供年月.get項目ID())) {
            flag = !currentRecord.getSource().listHakkoTaishosha_2.equals(nextRecord.getSource().listHakkoTaishosha_2);
        }
        if (!flag && this.keys.contains(KogakuJigyoShinseishoHakkoIchiranOrder.通知書番号.get項目ID())) {
            flag = !currentRecord.getSource().tsuchishoNo.equals(nextRecord.getSource().tsuchishoNo);
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
