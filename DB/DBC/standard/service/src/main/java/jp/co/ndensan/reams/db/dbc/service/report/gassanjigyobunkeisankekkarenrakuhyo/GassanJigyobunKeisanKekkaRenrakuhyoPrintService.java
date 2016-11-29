/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassanjigyobunkeisankekkarenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakukeisankkarenrakuhyopanel.JigyobunShikyugakuKeisanResultEntity;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjigyobunkeisankekkarenrakuhyo.GassanJigyobunKeisanKekkaRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 事業分計算結果連絡票PrintServiceクラスです。
 *
 * @reamsid_L DBC-4840-030 wangxingpeng
 */
public class GassanJigyobunKeisanKekkaRenrakuhyoPrintService {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_12 = 12;
    private static final RString INT_5 = new RString("5");

    /**
     * print
     *
     * @param entityList List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity>
     * @param 宛名データ IShikibetsuTaisho
     * @param 作成日 FlexibleDate
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<JigyobunShikyugakuKeisanResultEntity> entityList,
            IShikibetsuTaisho 宛名データ,
            FlexibleDate 作成日) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printSingle(entityList, 宛名データ, 作成日, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printSingle
     *
     * @param entityList List<JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelEntity>
     * @param 宛名データ IShikibetsuTaisho
     * @param 作成日 FlexibleDate
     * @param reportManager ReportManager
     */
    public void printSingle(List<JigyobunShikyugakuKeisanResultEntity> entityList,
            IShikibetsuTaisho 宛名データ,
            FlexibleDate 作成日,
            ReportManager reportManager) {
        GassanJigyobunKeisanKekkaRenrakuhyoProperty property = new GassanJigyobunKeisanKekkaRenrakuhyoProperty();
        try (ReportAssembler<GassanJigyobunKeisanKekkaRenrakuhyoSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanJigyobunKeisanKekkaRenrakuhyoSource> reportSourceWriter = new ReportSourceWriter(assembler);
            RString 通知書定型文1 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100204.getReportId(),
                    KamokuCode.EMPTY, INDEX_1).get(INDEX_1);
            RString 通知書定型文2 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100204.getReportId(),
                    KamokuCode.EMPTY, INDEX_1).get(INDEX_2);
            RString 通知書定型文3 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100204.getReportId(),
                    KamokuCode.EMPTY, INDEX_1).get(INDEX_3);
            NinshoshaSource 認証者 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100204.getReportId(),
                    作成日, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);

            boolean flag = false;
            boolean isBreak = false;
            Decimal overFutangaku = Decimal.ZERO;
            Decimal overShikyugaku = Decimal.ZERO;
            Decimal uederFutangaku = Decimal.ZERO;
            Decimal underShikyugaku = Decimal.ZERO;
            Decimal futangakuDec = Decimal.ZERO;
            Decimal shikyugakuDec = Decimal.ZERO;
            Decimal overFutangaku2 = Decimal.ZERO;
            Decimal overShikyugaku2 = Decimal.ZERO;
            Decimal uederFutangaku2 = Decimal.ZERO;
            Decimal underShikyugaku2 = Decimal.ZERO;
            Decimal futangakuDec2 = Decimal.ZERO;
            Decimal shikyugakuDec2 = Decimal.ZERO;

            DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity mutiEntity = new DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity singleEntity = new DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
            JigyobunShikyugakuKeisanResultEntity panelEntity1 = new JigyobunShikyugakuKeisanResultEntity();
            JigyobunShikyugakuKeisanResultEntity panelEntity2 = new JigyobunShikyugakuKeisanResultEntity();

            for (int j = INDEX_0; j < entityList.size(); j++) {
                if (null == entityList.get(j) || null == entityList.get(j).getDbt3173Entity()) {
                    continue;
                }
                DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity dbt3173Entity = entityList.get(j).getDbt3173Entity();
                DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity dbt3172Entity = entityList.get(j).getDbt3172Entity();
                RString 保険制度コード = entityList.get(j).getHokenSeidoCode();
                if (null == 保険制度コード) {
                    continue;
                }
                if (!保険制度コード.equals(INT_5)) {
                    RString over70Futangaku = dbt3173Entity.getOver70_Futangaku();
                    if (over70Futangaku != null) {
                        overFutangaku = overFutangaku.add(new Decimal(over70Futangaku.toString()));
                    }
                    RString over70Shikyugaku = dbt3173Entity.getOver70_Shikyugaku();
                    if (over70Shikyugaku != null) {
                        overShikyugaku = overShikyugaku.add(new Decimal(over70Shikyugaku.toString()));
                    }
                    RString under70Futangaku = dbt3173Entity.getUnder70_Futangaku();
                    if (under70Futangaku != null) {
                        uederFutangaku = uederFutangaku.add(new Decimal(under70Futangaku.toString()));
                    }
                    RString under70Shikyugaku = dbt3173Entity.getUnder70_Shikyugaku();
                    if (under70Shikyugaku != null) {
                        underShikyugaku = underShikyugaku.add(new Decimal(under70Shikyugaku.toString()));
                    }
                    RString futangaku = dbt3173Entity.getFutangaku();
                    if (futangaku != null) {
                        futangakuDec = futangakuDec.add(new Decimal(futangaku.toString()));
                    }
                    RString shikyugaku = dbt3173Entity.getShikyugaku();
                    if (shikyugaku != null) {
                        shikyugakuDec = shikyugakuDec.add(new Decimal(shikyugaku.toString()));
                    }
                    mutiEntity.setOver70_Futangaku(decimal_to_string(overFutangaku));
                    mutiEntity.setOver70_Shikyugaku(decimal_to_string(overShikyugaku));
                    mutiEntity.setUnder70_Futangaku(decimal_to_string(uederFutangaku));
                    mutiEntity.setUnder70_Shikyugaku(decimal_to_string(underShikyugaku));
                    mutiEntity.setFutangaku(decimal_to_string(futangakuDec));
                    mutiEntity.setShikyugaku(decimal_to_string(shikyugakuDec));
                    panelEntity1.setDbt3172Entity(dbt3172Entity);
                    panelEntity1.setDbt3173Entity(mutiEntity);

                }
                if (保険制度コード.equals(INT_5)) {
                    RString over70Futangaku = dbt3173Entity.getOver70_Futangaku();
                    if (over70Futangaku != null) {
                        overFutangaku2 = overFutangaku2.add(new Decimal(over70Futangaku.toString()));
                    }
                    RString over70Shikyugaku = dbt3173Entity.getOver70_Shikyugaku();
                    if (over70Shikyugaku != null) {
                        overShikyugaku2 = overShikyugaku2.add(new Decimal(over70Shikyugaku.toString()));
                    }
                    RString under70Futangaku = dbt3173Entity.getUnder70_Futangaku();
                    if (under70Futangaku != null) {
                        uederFutangaku2 = uederFutangaku2.add(new Decimal(under70Futangaku.toString()));
                    }
                    RString under70Shikyugaku = dbt3173Entity.getUnder70_Shikyugaku();
                    if (under70Shikyugaku != null) {
                        underShikyugaku2 = underShikyugaku2.add(new Decimal(under70Shikyugaku.toString()));
                    }
                    RString futangaku = dbt3173Entity.getFutangaku();
                    if (futangaku != null) {
                        futangakuDec2 = futangakuDec2.add(new Decimal(futangaku.toString()));
                    }
                    RString shikyugaku = dbt3173Entity.getShikyugaku();
                    if (shikyugaku != null) {
                        shikyugakuDec2 = shikyugakuDec2.add(new Decimal(shikyugaku.toString()));
                    }
                    singleEntity.setOver70_Futangaku(decimal_to_string(overFutangaku2));
                    singleEntity.setOver70_Shikyugaku(decimal_to_string(overShikyugaku2));
                    singleEntity.setUnder70_Futangaku(decimal_to_string(uederFutangaku2));
                    singleEntity.setUnder70_Shikyugaku(decimal_to_string(underShikyugaku2));
                    singleEntity.setFutangaku(decimal_to_string(futangakuDec2));
                    singleEntity.setShikyugaku(decimal_to_string(shikyugakuDec2));
                    panelEntity2.setDbt3173Entity(singleEntity);
                    panelEntity2.setDbt3172Entity(dbt3172Entity);
                }
                int count = editCount(entityList);
                printOrder(保険制度コード, entityList, j, 通知書定型文1, 通知書定型文2,
                        panelEntity1, 認証者, 宛名データ, 通知書定型文3, flag, reportSourceWriter, panelEntity2, isBreak, count);

            }

        }
    }

    private int editCount(List<JigyobunShikyugakuKeisanResultEntity> entityList) {
        int count = entityList.size() / INDEX_12;
        if (entityList.size() % INDEX_12 != 0) {
            count = count + 1;
        }
        return count;
    }

    private void printOrder(RString 保険制度コード, List<JigyobunShikyugakuKeisanResultEntity> entityList,
            int j, RString 通知書定型文1, RString 通知書定型文2, JigyobunShikyugakuKeisanResultEntity panelEntity1,
            NinshoshaSource 認証者,
            IShikibetsuTaisho 宛名データ, RString 通知書定型文3, boolean flag,
            ReportSourceWriter<GassanJigyobunKeisanKekkaRenrakuhyoSource> reportSourceWriter,
            JigyobunShikyugakuKeisanResultEntity panelEntity2, boolean isBreak, int count) {

        if (保険制度コード.equals(INT_5)
                && !(j - 1 < INDEX_0)
                && !保険制度コード.equals(entityList.get(j - 1).getHokenSeidoCode())) {
            isBreak = true;
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, panelEntity1, 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);
            isBreak = false;
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, entityList.get(j), 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);

        } else if (j == entityList.size() - INDEX_1
                && !保険制度コード.equals(INT_5)) {
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, entityList.get(j), 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);
            flag = true;
            isBreak = true;
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, panelEntity1, 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);

        } else if (j == entityList.size() - INDEX_1
                && 保険制度コード.equals(INT_5)) {
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, entityList.get(j), 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);
            flag = true;
            isBreak = true;
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, panelEntity2, 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);

        } else {
            new GassanJigyobunKeisanKekkaRenrakuhyoReport(通知書定型文1, 通知書定型文2, entityList.get(j), 認証者,
                    宛名データ, 通知書定型文3, flag, isBreak, count).writeBy(reportSourceWriter);

        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
