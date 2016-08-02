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

    private final JigyohokokuCompYoshiki272Entity data;
    private static final Decimal 縦番号_1 = new Decimal("1");
    private static final Decimal 縦番号_2 = new Decimal("2");

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
        for (JigyohokokuCompYoshiki272Change change : getData()) {
            IJigyohokokuCompYoshiki272Editor editor = new JigyohokokuCompYoshiki272Editor(data, change);
            IJigyohokokuCompYoshiki272Builder builder = new JigyohokokuCompYoshiki272Builder(editor);
            writer.writeLine(builder);
        }

    }

    private Iterable<JigyohokokuCompYoshiki272Change> getData() {
        List<JigyohokokuCompYoshiki272Change> dataList = new ArrayList<>();
        List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis = data.get事業報告統計データ();
        dataList.add(new JigyohokokuCompYoshiki272Change(set件数(jigyohokokutokeis),
                set給付額(jigyohokokutokeis)));
        return dataList;
    }

    private RString set件数(List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis) {
        RString 件数 = RString.EMPTY;
        if (jigyohokokutokeis != null) {
            for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : jigyohokokutokeis) {
                if (縦番号_1.equals(jigyohokokutokei.getTateNo())) {
                    件数 = new RString(jigyohokokutokei.getShukeiKekkaAtai().toString());
                }
            }
        }
        return 件数;
    }

    private RString set給付額(List<DbT7021JigyoHokokuTokeiDataEntity> jigyohokokutokeis) {
        RString 給付額 = RString.EMPTY;
        if (jigyohokokutokeis != null) {
            for (DbT7021JigyoHokokuTokeiDataEntity jigyohokokutokei : jigyohokokutokeis) {
                if (縦番号_2.equals(jigyohokokutokei.getTateNo())) {
                    給付額 = new RString(jigyohokokutokei.getShukeiKekkaAtai().toString());
                }
            }
        }
        return 給付額;
    }

}
