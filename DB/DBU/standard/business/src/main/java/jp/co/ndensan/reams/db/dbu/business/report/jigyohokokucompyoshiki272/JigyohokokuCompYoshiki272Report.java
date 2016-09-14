/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のレーポトです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272Report extends Report<JigyohokokuCompYoshiki272ReportSource> {

    private final JigyohokokuCompYoshiki272Entity data;
    private static final Decimal 縦番号_1 = new Decimal("1");
    private static final Decimal 縦番号_2 = new Decimal("2");
    private static final RString 月報 = new RString("月報");
    private static final RString 年報 = new RString("年報");
    private static final RString 月報_1 = new RString("1");
    private static final RString 年報_2 = new RString("2");
    private static final RString 過去集計分旧市町村区分_旧 = new RString("1");

    /**
     * インスタンスを生成します。
     *
     * @param data 帳票発行のdataList
     */
    public JigyohokokuCompYoshiki272Report(JigyohokokuCompYoshiki272Entity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki272ReportSource> writer) {
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
            for (JigyohokokuCompYoshiki272Change change : getData(key)) {
                IJigyohokokuCompYoshiki272Editor bodyeditor = new JigyohokokuCompYoshiki272BodyEditor(change);
                IJigyohokokuCompYoshiki272Builder builder = new JigyohokokuCompYoshiki272Builder(bodyeditor);
                writer.writeLine(builder);
            }
        }
    }

    private List<JigyohokokuCompYoshiki272Change> getData(List<DbT7021JigyoHokokuTokeiDataEntity> keyList) {
        List<JigyohokokuCompYoshiki272Change> dataList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis = keyList;
        List<DbT7021JigyoHokokuTokeiDataEntity> 現役並み所得者 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 一般 = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 低所得者Ⅱ = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 低所得者Ⅰ = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> 合計 = new ArrayList<>();
        for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : jigyohokokutokeis) {
            if (ShukeiNo.現役並み所得者.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                現役並み所得者.add(jigyohokokutokei);
            }
            if (ShukeiNo.一般.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                一般.add(jigyohokokutokei);
            }
            if (ShukeiNo.低所得者Ⅱ.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                低所得者Ⅱ.add(jigyohokokutokei);
            }
            if (ShukeiNo.低所得者Ⅰ.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                低所得者Ⅰ.add(jigyohokokutokei);
            }
            if (ShukeiNo.合計_08.getコード().equals(jigyohokokutokei.getShukeiNo().value())) {
                合計.add(jigyohokokutokei);
            }
        }
        dataList.add(setDataChange(現役並み所得者));
        dataList.add(setDataChange(一般));
        dataList.add(setDataChange(低所得者Ⅱ));
        dataList.add(setDataChange(低所得者Ⅰ));
        dataList.add(setDataChange(合計));
        return dataList;
    }

    private RString set件数(DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei) {
        RString 件数 = RString.EMPTY;
        if (縦番号_1.equals(jigyohokokutokei.getTateNo())) {
            件数 = new RString(jigyohokokutokei.getShukeiKekkaAtai().toString());
        }
        return 件数;
    }

    private RString set給付額(DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei) {
        RString 給付額 = RString.EMPTY;
        if (縦番号_2.equals(jigyohokokutokei.getTateNo())) {
            給付額 = new RString(jigyohokokutokei.getShukeiKekkaAtai().toString());
        }
        return 給付額;
    }

    private JigyohokokuCompYoshiki272Change setDataChange(List<DbT7021JigyoHokokuTokeiDataEntity> list) {
        RString 件数 = RString.EMPTY;
        RString 給付額 = RString.EMPTY;
        RString 保険者番号 = RString.EMPTY;
        RString 保険者名 = RString.EMPTY;
        for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : list) {
            件数 = set件数(jigyohokokutokei);
            給付額 = set給付額(jigyohokokutokei);
            保険者番号 = jigyohokokutokei.getShichosonCode().value();
            保険者名 = jigyohokokutokei.getShukeiKomokuMeisho();
        }
        if (保険者名 != null && 過去集計分旧市町村区分_旧.equals(data.get過去集計分旧市町村区分())) {
            保険者名 = 保険者名.concat(new RString("旧"));
        }
        return new JigyohokokuCompYoshiki272Change(件数,
                給付額,
                data.get作成日時(),
                set集計範囲(data),
                set年報月報(data.get年報月報区分()),
                保険者番号,
                保険者名
        );

    }

    private RString set集計範囲(JigyohokokuCompYoshiki272Entity entity) {
        RStringBuilder 集計範囲_SB = new RStringBuilder();
        if (月報_1.equals(entity.get年報月報区分())) {
            集計範囲_SB.append("（");
            集計範囲_SB.append(entity.get集計年月());
            集計範囲_SB.append("分）");
        }
        if (年報_2.equals(entity.get年報月報区分())) {
            集計範囲_SB.append("（");
            集計範囲_SB.append(entity.get集計年度());
            集計範囲_SB.append("分）");
            集計範囲_SB.append(entity.get集計期間FROM());
            集計範囲_SB.append(" ～ ");
            集計範囲_SB.append(entity.get集計期間TO());
        }
        return 集計範囲_SB.toRString();
    }

    private RString set年報月報(RString 年報月報区分) {
        if (月報_1.equals(年報月報区分)) {
            return 月報;
        } else if (年報_2.equals(年報月報区分)) {
            return 年報;
        }
        return RString.EMPTY;
    }
}
