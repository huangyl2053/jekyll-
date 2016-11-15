/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.DBB200023MeisaiIchiranEnum;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 *
 * @author SE709-WIN7-JP
 */
public class PrtMeisaiIchiranProcessPageBreak extends PageBreaker<TokubetsuChoshuIraikingakuMeisaiIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public PrtMeisaiIchiranProcessPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public PrtMeisaiIchiranProcessPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuIraikingakuMeisaiIchiranSource> currentRecord,
            ReportLineRecord<TokubetsuChoshuIraikingakuMeisaiIchiranSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(DBB200023MeisaiIchiranEnum.町域コード.get項目ID())) {
            flag = !currentRecord.getSource().choikiCode.equals(nextRecord.getSource().choikiCode);
        }
        if (!flag && this.keys.contains(DBB200023MeisaiIchiranEnum.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_3.equals(nextRecord.getSource().listUpper_3);
        }
        if (!flag && this.keys.contains(DBB200023MeisaiIchiranEnum.世帯コード.get項目ID())) {
            flag = !currentRecord.getSource().listLower_2.equals(nextRecord.getSource().listLower_2);
        }
        if (!flag && this.keys.contains(DBB200023MeisaiIchiranEnum.識別コード.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_2.equals(nextRecord.getSource().listUpper_2);
        }
        if (!flag && this.keys.contains(DBB200023MeisaiIchiranEnum.市町村コード.get項目ID())) {
            flag = !currentRecord.getSource().shichosonCode.equals(nextRecord.getSource().shichosonCode);
        }
        if (!flag && this.keys.contains(DBB200023MeisaiIchiranEnum.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().listLower_1.equals(nextRecord.getSource().listLower_1);
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
