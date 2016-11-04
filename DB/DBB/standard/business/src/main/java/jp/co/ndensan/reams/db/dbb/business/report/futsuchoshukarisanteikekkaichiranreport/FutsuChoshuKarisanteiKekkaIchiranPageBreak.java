/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyi
 */
public class FutsuChoshuKarisanteiKekkaIchiranPageBreak extends
        PageBreaker<FutsuChoshuKarisanteiKekkaIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public FutsuChoshuKarisanteiKekkaIchiranPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public FutsuChoshuKarisanteiKekkaIchiranPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> currentRecord,
            ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> nextRecord) {
        boolean flag = false;
        flag = isBreak2(flag, currentRecord, nextRecord);
        return flag;
    }

    private boolean isBreak2(boolean flag, ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> currentRecord,
            ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> nextRecord) {
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.郵便番号.get項目ID())) {
            flag = !currentRecord.getSource().郵便番号.equals(nextRecord.getSource().郵便番号);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.町域コード.get項目ID())) {
            flag = !currentRecord.getSource().町域コード.equals(nextRecord.getSource().町域コード);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().行政区コード.equals(nextRecord.getSource().行政区コード);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.世帯コード.get項目ID())) {
            flag = !currentRecord.getSource().世帯コード.equals(nextRecord.getSource().世帯コード);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.通知書番号.get項目ID())) {
            flag = !currentRecord.getSource().通知書番号.equals(nextRecord.getSource().通知書番号);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.徴収方法.get項目ID())) {
            flag = !currentRecord.getSource().徴収方法.equals(nextRecord.getSource().徴収方法);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.特徴開始月.get項目ID())) {
            flag = !currentRecord.getSource().特徴開始月.equals(nextRecord.getSource().特徴開始月);
        }
        return isBreak1(flag, currentRecord, nextRecord);
    }

    private boolean isBreak1(boolean flag, ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> currentRecord,
            ReportLineRecord<FutsuChoshuKarisanteiKekkaIchiranSource> nextRecord) {
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.識別コード.get項目ID())) {
            flag = !currentRecord.getSource().識別コード.equals(nextRecord.getSource().識別コード);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.氏名５０音カナ.get項目ID())) {
            flag = !currentRecord.getSource().氏名５０音カナ.equals(nextRecord.getSource().氏名５０音カナ);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.生年月日.get項目ID())) {
            flag = !currentRecord.getSource().生年月日.equals(nextRecord.getSource().生年月日);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.性別.get項目ID())) {
            flag = !currentRecord.getSource().性別.equals(nextRecord.getSource().性別);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.市町村コード.get項目ID())) {
            flag = !currentRecord.getSource().市町村コード.equals(nextRecord.getSource().市町村コード);
        }
        if (!flag && this.keys.contains(FutsuChoshuKarisanteiKekkaIchiranOutputOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().被保険者番号.equals(nextRecord.getSource().被保険者番号);
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
