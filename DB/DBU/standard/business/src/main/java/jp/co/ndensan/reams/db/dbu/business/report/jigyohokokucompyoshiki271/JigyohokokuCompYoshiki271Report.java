/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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
        Map<RString, List<DbT7021JigyoHokokuTokeiDataEntity>> data_map = new HashMap<>();
        for (DbT7021JigyoHokokuTokeiDataEntity entity : data.get事業報告統計データ()) {
            if (data_map.containsKey(entity.getShichosonCode().value())) {
                List<DbT7021JigyoHokokuTokeiDataEntity> map = data_map.get(entity.getShichosonCode().value());
                map.add(entity);
            } else {
                List<DbT7021JigyoHokokuTokeiDataEntity> map = new ArrayList<>();
                map.add(entity);
                data_map.put(entity.getShichosonCode().value(), map);
            }
        }
        for (List<DbT7021JigyoHokokuTokeiDataEntity> key : data_map.values()) {
            for (JigyohokokuCompYoshiki271Change change : getData(key)) {
                change.set保険者番号(key.get(0).getShichosonCode().value());
                change.set保険者名(key.get(0).getShukeiKomokuMeisho());
                IJigyohokokuCompYoshiki271Editor bodyeditor = new JigyohokokuCompYoshiki271BodyEditor(change);
                IJigyohokokuCompYoshiki271Builder builder = new JigyohokokuCompYoshiki271Builder(bodyeditor);
                writer.writeLine(builder);
            }
        }
    }

    private Iterable<JigyohokokuCompYoshiki271Change> getData(List<DbT7021JigyoHokokuTokeiDataEntity> keyList) {
        List<JigyohokokuCompYoshiki271Change> dataList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis = keyList;
        List<DbT7021JigyoHokokuTokeiDataEntity> 第五段階 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 第四段階 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 第三段階 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 第二段階 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 第一段階 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 合計 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 再掲利用者負担第三段階 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 再掲利用者負担第二段階 = new ArrayList<>();
        for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : jigyohokokutokeis) {
            if (ShukeiNo.利用者負担第五段階_0700.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                第五段階.add(jigyohokokutokei);
            }
            if (ShukeiNo.利用者負担第四段階_0701.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                第四段階.add(jigyohokokutokei);
            }
            if (ShukeiNo.利用者負担第三段階_0702.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                第三段階.add(jigyohokokutokei);
            }
            if (ShukeiNo.利用者負担第二段階_0703.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                第二段階.add(jigyohokokutokei);
            }
            if (ShukeiNo.利用者負担第一段階_0704.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                第一段階.add(jigyohokokutokei);
            }
            if (ShukeiNo.合計_07.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                合計.add(jigyohokokutokei);
            }
            if (ShukeiNo.利用者負担第三段階_0706.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                再掲利用者負担第三段階.add(jigyohokokutokei);
            }
            if (ShukeiNo.利用者負担第二段階_0707.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                再掲利用者負担第二段階.add(jigyohokokutokei);
            }
        }
        dataList.add(setDataChange(第五段階));
        dataList.add(setDataChange(第四段階));
        dataList.add(setDataChange(第三段階));
        dataList.add(setDataChange(第二段階));
        dataList.add(setDataChange(第一段階));
        dataList.add(setDataChange(合計));
        dataList.add(setDataChange(再掲利用者負担第三段階));
        dataList.add(setDataChange(再掲利用者負担第二段階));
        return dataList;
    }

    private JigyohokokuCompYoshiki271Change setDataChange(List<DbT7021JigyoHokokuTokeiDataEntity> entity) {
        Decimal 件数世帯合算 = Decimal.ZERO;
        Decimal 件数その他 = Decimal.ZERO;
        Decimal 給付額世帯合算 = Decimal.ZERO;
        Decimal 給付額その他 = Decimal.ZERO;
        RString 保険者番号 = RString.EMPTY;
        RString 保険者名 = RString.EMPTY;
        for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : entity) {
            件数世帯合算 = 件数世帯合算.add(set件数世帯合算(jigyohokokutokei));
            件数その他 = 件数その他.add(set件数その他(jigyohokokutokei));
            給付額世帯合算 = 給付額世帯合算.add(set給付額世帯合算(jigyohokokutokei));
            給付額その他 = 給付額その他.add(set給付額その他(jigyohokokutokei));
            保険者番号 = jigyohokokutokei.getShichosonCode().value();
            保険者名 = jigyohokokutokei.getShukeiKomokuMeisho();
        }
        return new JigyohokokuCompYoshiki271Change(new RString(件数世帯合算.toString()),
                new RString(件数その他.toString()),
                new RString(set件数計(件数世帯合算, 件数その他).toString()),
                new RString(給付額世帯合算.toString()),
                new RString(給付額その他.toString()),
                new RString(set給付額計(給付額世帯合算, 給付額その他).toString()),
                data.get作成日時(),
                data.get年報月報区分(),
                set範囲(data.get集計年月()),
                保険者番号,
                保険者名
        );
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

    private RString set範囲(RString 集計年月) {
        RStringBuilder 範囲_SB = new RStringBuilder();
        範囲_SB.append("（");
        範囲_SB.append(new FlexibleDate(集計年月).getYearMonth().wareki()
                .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        範囲_SB.append("分）");
        return 範囲_SB.toRString();
    }
}
