/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Data;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7-1）のReportクラスです。
 *
 * @reamsid_L DBU-5580-040 wanghuafeng
 */
public class JigyohokokuCompYoshiki271Report extends Report<JigyohokokuCompYoshiki271ReportSource> {

    private final JigyohokokuCompYoshiki271Data data;
    private static final Decimal 縦番号1 = new Decimal("1");
    private static final Decimal 縦番号2 = new Decimal("2");
    private static final Decimal 横番号1 = new Decimal("1");
    private static final Decimal 横番号2 = new Decimal("2");

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki271Data
     */
    public JigyohokokuCompYoshiki271Report(JigyohokokuCompYoshiki271Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki271ReportSource> writer) {
        for (JigyohokokuCompYoshiki271Change change : getData()) {
            IJigyohokokuCompYoshiki271Editor headeditor = new JigyohokokuCompYoshiki271HeadEditor(data);
            IJigyohokokuCompYoshiki271Editor bodyeditor = new JigyohokokuCompYoshiki271BodyEditor(change);
            IJigyohokokuCompYoshiki271Builder builder = new JigyohokokuCompYoshiki271Builder(headeditor, bodyeditor);
            writer.writeLine(builder);
        }
    }

    private Iterable<JigyohokokuCompYoshiki271Change> getData() {
        List<JigyohokokuCompYoshiki271Change> dataList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis = data.get事業報告統計データ();
        for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : jigyohokokutokeis) {
            Decimal 件数世帯合算 = set件数世帯合算(jigyohokokutokei);
            Decimal 件数その他 = set件数その他(jigyohokokutokei);
            Decimal 給付額世帯合算 = set給付額世帯合算(jigyohokokutokei);
            Decimal 給付額その他 = set給付額その他(jigyohokokutokei);
            dataList.add(new JigyohokokuCompYoshiki271Change(new RString(件数世帯合算.toString()),
                    new RString(件数その他.toString()),
                    new RString(set件数計(件数世帯合算, 件数その他).toString()),
                    new RString(給付額世帯合算.toString()),
                    new RString(給付額その他.toString()),
                    new RString(set給付額計(給付額世帯合算, 給付額その他).toString())));
        }

        return dataList;
    }

    private Decimal set件数世帯合算(DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei) {
        Decimal 件数世帯合算 = Decimal.ZERO;
        if (縦番号1.equals(jigyohokokutokei.getTateNo()) && 横番号1.equals(jigyohokokutokei.getYokoNo())) {
            件数世帯合算 = jigyohokokutokei.getShukeiKekkaAtai();
        }
        return 件数世帯合算;
    }

    private Decimal set件数その他(DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei) {
        Decimal 件数その他 = Decimal.ZERO;
        if (縦番号1.equals(jigyohokokutokei.getTateNo()) && 横番号2.equals(jigyohokokutokei.getYokoNo())) {
            件数その他 = jigyohokokutokei.getShukeiKekkaAtai();
        }
        return 件数その他;
    }

    private Decimal set件数計(Decimal 件数世帯合算, Decimal 件数その他) {
        return 件数世帯合算.add(件数その他);
    }

    private Decimal set給付額世帯合算(DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei) {
        Decimal 給付額世帯合算 = Decimal.ZERO;
        if (縦番号2.equals(jigyohokokutokei.getTateNo()) && 横番号1.equals(jigyohokokutokei.getYokoNo())) {
            給付額世帯合算 = jigyohokokutokei.getShukeiKekkaAtai();
        }
        return 給付額世帯合算;
    }

    private Decimal set給付額その他(DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei) {
        Decimal 給付額その他 = Decimal.ZERO;
        if (縦番号2.equals(jigyohokokutokei.getTateNo()) && 横番号2.equals(jigyohokokutokei.getYokoNo())) {
            給付額その他 = jigyohokokutokei.getShukeiKekkaAtai();
        }
        return 給付額その他;
    }

    private Decimal set給付額計(Decimal 給付額世帯合算, Decimal 給付額その他) {
        return 給付額世帯合算.add(給付額その他);
    }
}
