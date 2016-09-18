/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc010020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200013.JuryoIninShoninKakuninshoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
public class KogakuServicehiJuryoininKeiyakuShoninKakuninshoPageBreak extends PageBreaker<JuryoIninShoninKakuninshoIchiranSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public KogakuServicehiJuryoininKeiyakuShoninKakuninshoPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public KogakuServicehiJuryoininKeiyakuShoninKakuninshoPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JuryoIninShoninKakuninshoIchiranSource> currentRecord,
            ReportLineRecord<JuryoIninShoninKakuninshoIchiranSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(KogakuServicehiJuryoininKeiyakuShoninKakuninshoOutputOrder.契約決定年月日.get項目ID())) {
            flag = !currentRecord.getSource().ListLower_3.equals(nextRecord.getSource().ListLower_3);
        }
        if (!flag && this.keys.contains(KogakuServicehiJuryoininKeiyakuShoninKakuninshoOutputOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().ListUpper_2.equals(nextRecord.getSource().ListUpper_2);
        }
        if (!flag && this.keys.contains(KogakuServicehiJuryoininKeiyakuShoninKakuninshoOutputOrder.承認期間_開始.get項目ID())) {
            flag = !currentRecord.getSource().ListUpper_6.equals(nextRecord.getSource().ListUpper_6);
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
