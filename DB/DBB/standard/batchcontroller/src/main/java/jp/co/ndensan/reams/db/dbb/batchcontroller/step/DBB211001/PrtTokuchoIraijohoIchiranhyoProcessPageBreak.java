/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran.DBB200019_TokubetsuChoshuIraiJohoIchiranEnum;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuiraijohoichiran.TokubetsuChoshuIraiJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class PrtTokuchoIraijohoIchiranhyoProcessPageBreak extends PageBreaker<TokubetsuChoshuIraiJohoIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public PrtTokuchoIraijohoIchiranhyoProcessPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public PrtTokuchoIraijohoIchiranhyoProcessPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<TokubetsuChoshuIraiJohoIchiranSource> currentRecord,
            ReportLineRecord<TokubetsuChoshuIraiJohoIchiranSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.行政区コード.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_5.equals(nextRecord.getSource().listUpper_5);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.識別コード.get項目ID())) {
            flag = !currentRecord.getSource().listLower_1.equals(nextRecord.getSource().listLower_1);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.氏名５０音カナ.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_3.equals(nextRecord.getSource().listUpper_3);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.生年月日.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_4.equals(nextRecord.getSource().listUpper_4);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.性別.get項目ID())) {
            flag = !currentRecord.getSource().listLower_4.equals(nextRecord.getSource().listLower_4);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.市町村コード.get項目ID())) {
            flag = !currentRecord.getSource().shichosonCode.equals(nextRecord.getSource().shichosonCode);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_1.equals(nextRecord.getSource().listUpper_1);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.年金コード.get項目ID())) {
            flag = !currentRecord.getSource().listLower_2.equals(nextRecord.getSource().listLower_2);
        }
        if (!flag && this.keys.contains(DBB200019_TokubetsuChoshuIraiJohoIchiranEnum.年金番号.get項目ID())) {
            flag = !currentRecord.getSource().listUpper_2.equals(nextRecord.getSource().listUpper_2);
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
