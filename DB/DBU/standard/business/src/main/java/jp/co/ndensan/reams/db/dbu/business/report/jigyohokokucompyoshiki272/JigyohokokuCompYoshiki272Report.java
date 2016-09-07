/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・保険給付決定状況（様式2-7） のレーポトです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272Report extends Report<JigyohokokuCompYoshiki272ReportSource> {

    private final JigyohokokuCompYoshiki272Entity entity;
    private static final Decimal 縦番号_1 = new Decimal("1");
    private static final Decimal 縦番号_2 = new Decimal("2");

    /**
     * インスタンスを生成します。
     *
     * @param entity 帳票発行のdataList
     */
    public JigyohokokuCompYoshiki272Report(JigyohokokuCompYoshiki272Entity entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki272ReportSource> writer) {
        for (int i = 0; i < getData().size(); i++) {
            IJigyohokokuCompYoshiki272Editor headeditor = new JigyohokokuCompYoshiki272HeadEditor(entity, i);
            IJigyohokokuCompYoshiki272Editor bodyeditor = new JigyohokokuCompYoshiki272BodyEditor(getData().get(i));
            IJigyohokokuCompYoshiki272Builder builder = new JigyohokokuCompYoshiki272Builder(headeditor, bodyeditor);
            writer.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki272Change> getData() {
        List<JigyohokokuCompYoshiki272Change> dataList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis = entity.get事業報告統計データ();
        for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : jigyohokokutokeis) {
            dataList.add(new JigyohokokuCompYoshiki272Change(set件数(jigyohokokutokei),
                    set給付額(jigyohokokutokei)));
        }
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

}
