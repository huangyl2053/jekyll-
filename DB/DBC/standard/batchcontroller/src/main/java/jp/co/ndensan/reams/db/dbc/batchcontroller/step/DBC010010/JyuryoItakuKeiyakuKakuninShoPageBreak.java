/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc100029.JyuryoItakuKeiyakuKakuninShoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 改頁クラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public class JyuryoItakuKeiyakuKakuninShoPageBreak extends PageBreaker<JyuryoItakuKeiyakuKakuninShoSource> {

    private final List<RString> keys;

    /**
     * 指定されたキーのリストを確定します。
     *
     * @param keys キーリスト
     */
    public JyuryoItakuKeiyakuKakuninShoPageBreak(List<RString> keys) {
        this.keys = Collections.unmodifiableList(keys);
    }

    /**
     * 指定されたキー、キー配列のリストを作成し確定します。
     *
     * @param key キー
     * @param any キー配列
     */
    public JyuryoItakuKeiyakuKakuninShoPageBreak(RString key, RString... any) {
        this.keys = Collections.unmodifiableList(createBreakKeys(key, any));

    }

    @Override
    public List<RString> breakKeys() {
        return this.keys;
    }

    @Override
    public boolean isBreak(ReportLineRecord<JyuryoItakuKeiyakuKakuninShoSource> currentRecord,
            ReportLineRecord<JyuryoItakuKeiyakuKakuninShoSource> nextRecord) {
        boolean flag = false;
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.契約サービス種類.get項目ID())) {
            flag = !currentRecord.getSource().kyufuShurui.equals(nextRecord.getSource().kyufuShurui);
        }
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.契約決定年月日.get項目ID())) {
            flag = !currentRecord.getSource().shoninYMD.equals(nextRecord.getSource().shoninYMD);
        }
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.被保険者番号.get項目ID())) {
            flag = !currentRecord.getSource().hihokenshaNo.equals(nextRecord.getSource().hihokenshaNo);
        }
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.受領委任契約番号.get項目ID())) {
            flag = !currentRecord.getSource().受領委任契約番号.equals(nextRecord.getSource().受領委任契約番号);
        }
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.契約事業者番号.get項目ID())) {
            flag = !currentRecord.getSource().契約事業者番号.equals(nextRecord.getSource().契約事業者番号);
        }
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.契約申請年月日.get項目ID())) {
            flag = !currentRecord.getSource().契約申請年月日.equals(nextRecord.getSource().契約申請年月日);
        }
        if (!flag && this.keys.contains(JuryoininKeiyakuShoninKakuninshoOutputOrder.承認期間_開始.get項目ID())) {
            flag = !currentRecord.getSource().承認期間_開始.equals(nextRecord.getSource().承認期間_開始);
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
