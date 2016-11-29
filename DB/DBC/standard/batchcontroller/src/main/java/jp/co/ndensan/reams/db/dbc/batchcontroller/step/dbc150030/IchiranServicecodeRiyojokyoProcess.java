/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoReport;
import jp.co.ndensan.reams.db.dbc.business.report.servicecoderiyojokyo.ServicecodeRiyojokyoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecoderiyojokyo.ServicecodeRiyojokyoReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.servicecodebetsuriyojokyo.ServiceCodeBetsuRiyoJokyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票出力対象データ取得Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class IchiranServicecodeRiyojokyoProcess
        extends BatchKeyBreakBase<DbWT3470chohyouShutsuryokuyouEntity> {

    private KyufuJissekiMeisaiGetProcessParameter parameter;
    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.get帳票出力用一時TBL出力順");

    private static final RString 帳票出力順 = new RString("ORDER BY "
            + "\"DbWT3470chohyouShutsuryokuyou\".\"serviceShuruiCode\" ASC"
            + ", \"DbWT3470chohyouShutsuryokuyou\".\"sortYouKomokuCode\" ASC");
    private static final RString 対象年月指定_サービス対象年月 = new RString("00");
    private static final RString 対象年月指定_審査年月 = new RString("01");
    private static final RString サービス種類_00 = new RString("00");
    private static final RString サービス種類_すべて = new RString("すべて");
    private static final RString 選択対象_全て = new RString("全て");
    private static final RString 提供月 = new RString("提供月：");
    private static final RString 審査月 = new RString("審査月：");
    private static final RString 選択対象_町域 = new RString("町域");
    private static final RString 選択対象_地区１ = new RString("地区１");
    private static final RString 選択対象_地区２ = new RString("地区２");
    private static final RString 選択対象_地区３ = new RString("地区３");
    private static final RString 選択対象_行政区 = new RString("行政区");
    private static final RString 町域 = new RString("町域：");
    private static final RString 地区１ = new RString("地区１：");
    private static final RString 地区２ = new RString("地区２：");
    private static final RString 地区３ = new RString("地区３：");
    private static final RString 行政区 = new RString("行政区：");
    private static final RString 旧市町村名 = new RString("旧市町村名：");
    private static final RString 旧市町村情報_000000 = new RString("000000");
    private static final RString 接続 = new RString("ー");
    private static final RString 波線 = new RString("～");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_15 = 15;
    private static final int INT_16 = 16;
    private static final int INT_30 = 30;
    private static final RString 要介護状態区分コード_01 = new RString("01");
    private static final RString 要介護状態区分コード_12 = new RString("12");
    private static final RString 要介護状態区分コード_13 = new RString("13");
    private static final RString 要介護状態区分コード_11 = new RString("11");
    private static final RString 要介護状態区分コード_21 = new RString("21");
    private static final RString 要介護状態区分コード_22 = new RString("22");
    private static final RString 要介護状態区分コード_23 = new RString("23");
    private static final RString 要介護状態区分コード_24 = new RString("24");
    private static final RString 要介護状態区分コード_25 = new RString("25");
    private static final RString 合計 = new RString("合計");
    private static final RString タイトル_59 = new RString("上段：日数　下段：費用額");
    private static final RString タイトル_59以外 = new RString("上段：回数　下段：単位");
    private RString beforeサービス種類スコード;
    private RString currentサービス種類スコード;
    private RString beforeソート用サービス項目コード;
    private RString currentソート用サービス項目コード;
    private RString サービス種類名称;
    private DbWT3470chohyouShutsuryokuyouTempEntity beforeEntity;
    private DbWT3470chohyouShutsuryokuyouTempEntity currentEntity;
    private Decimal nissuKaisuSyukeichi_01;
    private Decimal nissuKaisuSyukeichi_12;
    private Decimal nissuKaisuSyukeichi_13;
    private Decimal nissuKaisuSyukeichi_11;
    private Decimal nissuKaisuSyukeichi_21;
    private Decimal nissuKaisuSyukeichi_22;
    private Decimal nissuKaisuSyukeichi_23;
    private Decimal nissuKaisuSyukeichi_24;
    private Decimal nissuKaisuSyukeichi_25;
    private Decimal taniSuSyukeichi_01;
    private Decimal taniSuSyukeichi_12;
    private Decimal taniSuSyukeichi_13;
    private Decimal taniSuSyukeichi_11;
    private Decimal taniSuSyukeichi_21;
    private Decimal taniSuSyukeichi_22;
    private Decimal taniSuSyukeichi_23;
    private Decimal taniSuSyukeichi_24;
    private Decimal taniSuSyukeichi_25;
    List<RString> 改頁項目リスト;
    @BatchWriter
    private BatchReportWriter<ServiceCodeBetsuRiyoJokyoSource> batchReportWriter;
    private ReportSourceWriter<ServiceCodeBetsuRiyoJokyoSource> reportSourceWriter;
    private int count;

    private ServicecodeRiyojokyoReport reportEntity;

    private boolean 改頁Flag;

    @Override
    protected void initialize() {
        改頁Flag = false;
        count = INT_0;
        parameter.set出力順(帳票出力順);
        nissuKaisuSyukeichi_01 = Decimal.ZERO;
        nissuKaisuSyukeichi_12 = Decimal.ZERO;
        nissuKaisuSyukeichi_13 = Decimal.ZERO;
        nissuKaisuSyukeichi_11 = Decimal.ZERO;
        nissuKaisuSyukeichi_21 = Decimal.ZERO;
        nissuKaisuSyukeichi_22 = Decimal.ZERO;
        nissuKaisuSyukeichi_23 = Decimal.ZERO;
        nissuKaisuSyukeichi_24 = Decimal.ZERO;
        nissuKaisuSyukeichi_25 = Decimal.ZERO;
        taniSuSyukeichi_01 = Decimal.ZERO;
        taniSuSyukeichi_12 = Decimal.ZERO;
        taniSuSyukeichi_13 = Decimal.ZERO;
        taniSuSyukeichi_11 = Decimal.ZERO;
        taniSuSyukeichi_21 = Decimal.ZERO;
        taniSuSyukeichi_22 = Decimal.ZERO;
        taniSuSyukeichi_23 = Decimal.ZERO;
        taniSuSyukeichi_24 = Decimal.ZERO;
        taniSuSyukeichi_25 = Decimal.ZERO;
        改頁項目リスト = new ArrayList<>();
        改頁項目リスト.add(new RString(
                ServiceCodeBetsuRiyoJokyoSource.DBC300002ServiceCodeBetsuRiyoJokyoFields.breakKey.name()));

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        PageBreaker<ServiceCodeBetsuRiyoJokyoSource> breaker = new ServiceCodeBetsuRiyoJokyoPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC300002.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected void usualProcess(DbWT3470chohyouShutsuryokuyouEntity entity) {
        サービス種類名称 = entity.getサービス種類名称();
        currentEntity = entity.get帳票出力();
        currentサービス種類スコード = currentEntity.getServiceShuruiCode();
        currentソート用サービス項目コード = currentEntity.getSortYouKomokuCode();
        count = count + INT_1;
        if (null != getBefore()) {
            beforeEntity = getBefore().get帳票出力();
            if (beforeEntity != null) {
                beforeサービス種類スコード = beforeEntity.getServiceShuruiCode();
                beforeソート用サービス項目コード = beforeEntity.getSortYouKomokuCode();
                集計判定();
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (count != INT_0) {
            非集計(currentEntity, true);
            集計(currentEntity);
        }

    }

    @Override
    protected void keyBreakProcess(DbWT3470chohyouShutsuryokuyouEntity t) {
    }

    private void set明細(DbWT3470chohyouShutsuryokuyouTempEntity entity) {
        ServicecodeRiyojokyoReportEntity meisaiEntity;
        if (reportEntity.get明細リスト() != null) {
            meisaiEntity = reportEntity.get明細リスト();
        } else {
            meisaiEntity = new ServicecodeRiyojokyoReportEntity();
        }
        meisaiEntity.set種類コード(entity.getServiceShuruiCode());
        meisaiEntity.set項目コード(entity.getSortYouKomokuCode());
        if (entity.getServiceRyakushou() != null && !entity.getServiceRyakushou().isEmpty()) {
            meisaiEntity.setサービス略称_上(entity.getServiceRyakushou().substringEmptyOnError(INT_0, INT_15));
            meisaiEntity.setサービス略称_下(entity.getServiceRyakushou().substringEmptyOnError(INT_16, INT_30));
        }
        if (要介護状態区分コード_01.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set非該当日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set非該当単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_01 = nissuKaisuSyukeichi_01.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_01 = taniSuSyukeichi_01.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_12.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要支援１日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要支援１単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_12 = nissuKaisuSyukeichi_12.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_12 = taniSuSyukeichi_12.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_13.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要支援２日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要支援２単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_13 = nissuKaisuSyukeichi_13.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_13 = taniSuSyukeichi_13.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_11.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set経過的要介護日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set経過的要介護単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_11 = nissuKaisuSyukeichi_11.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_11 = taniSuSyukeichi_11.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_21.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要介護１日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要介護１単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_21 = nissuKaisuSyukeichi_21.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_21 = taniSuSyukeichi_21.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_22.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要介護２日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要介護２単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_22 = nissuKaisuSyukeichi_22.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_22 = taniSuSyukeichi_22.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_23.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要介護３日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要介護３単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_23 = nissuKaisuSyukeichi_23.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_23 = taniSuSyukeichi_23.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_24.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要介護４日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要介護４単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_24 = nissuKaisuSyukeichi_24.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_24 = taniSuSyukeichi_24.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        } else if (要介護状態区分コード_25.equals(entity.getYoKaigoJotaiKubunCode())) {
            meisaiEntity.set要介護５日数_回数集計値(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            meisaiEntity.set要介護５単位数集計値(getDecimalVaule(entity.getTaniSuSyukeichi()));
            nissuKaisuSyukeichi_25 = nissuKaisuSyukeichi_25.add(getDecimalVaule(entity.getNissuKaisuSyukeichi()));
            taniSuSyukeichi_25 = taniSuSyukeichi_25.add(getDecimalVaule(entity.getTaniSuSyukeichi()));
        }
        reportEntity.set明細リスト(meisaiEntity);
    }

    private RString get条件１(RString 条件) {
        RString 条件１ = new RString("");
        条件１ = 条件１.concat(条件);
        RString 年月範囲開始 = パターン56(parameter.get年月範囲開始());
        RString 年月範囲終了 = パターン56(parameter.get年月範囲終了());
        if (年月範囲開始.equals(年月範囲終了)) {
            条件１ = 条件１.concat(年月範囲開始);
        } else {
            条件１ = 条件１.concat(年月範囲開始).concat(接続).concat(年月範囲終了);
        }
        return 条件１;
    }

    private RString get条件３(RString 条件) {
        if (parameter.get対象コード().size() == INT_0) {
            return RString.EMPTY;
        }
        RString 条件３ = new RString("");
        条件３ = 条件３.concat(条件);
        if (INT_1 < parameter.get対象コード().size()) {
            条件３ = 条件３.concat(parameter.get対象コード().get(INT_0)).concat(波線).
                    concat(parameter.get対象コード().get(parameter.get対象コード().size() - INT_1));
        } else {
            条件３ = 条件３.concat(parameter.get対象コード().get(INT_0));
        }
        return 条件３;
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private boolean is変換(RString before, RString current) {
        if (before == null) {
            return false;
        }
        return !current.equals(before);
    }

    private void 集計(DbWT3470chohyouShutsuryokuyouTempEntity entity) {
        ServicecodeRiyojokyoReportEntity meisaiEntity = new ServicecodeRiyojokyoReportEntity();
        meisaiEntity.set種類コード(entity.getServiceShuruiCode());
        meisaiEntity.setサービス略称_上(合計);
        meisaiEntity.set非該当日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_01));
        meisaiEntity.set非該当単位数集計値(setDecimalVaule(taniSuSyukeichi_01));
        meisaiEntity.set要支援１日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_12));
        meisaiEntity.set要支援１単位数集計値(setDecimalVaule(taniSuSyukeichi_12));
        meisaiEntity.set要支援２日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_13));
        meisaiEntity.set要支援２単位数集計値(setDecimalVaule(taniSuSyukeichi_13));
        meisaiEntity.set経過的要介護日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_11));
        meisaiEntity.set経過的要介護単位数集計値(setDecimalVaule(taniSuSyukeichi_11));
        meisaiEntity.set要介護１日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_21));
        meisaiEntity.set要介護１単位数集計値(setDecimalVaule(taniSuSyukeichi_21));
        meisaiEntity.set要介護２日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_22));
        meisaiEntity.set要介護２単位数集計値(setDecimalVaule(taniSuSyukeichi_22));
        meisaiEntity.set要介護３日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_23));
        meisaiEntity.set要介護３単位数集計値(setDecimalVaule(taniSuSyukeichi_23));
        meisaiEntity.set要介護４日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_24));
        meisaiEntity.set要介護４単位数集計値(setDecimalVaule(taniSuSyukeichi_24));
        meisaiEntity.set要介護５日数_回数集計値(setDecimalVaule(nissuKaisuSyukeichi_25));
        meisaiEntity.set要介護５単位数集計値(setDecimalVaule(taniSuSyukeichi_25));
        Decimal 集計回数合計値 = Decimal.ZERO;
        Decimal 集計単位数合計値 = Decimal.ZERO;
        get集計合計値(集計回数合計値, 集計単位数合計値, meisaiEntity);
        reportEntity.set明細リスト(meisaiEntity);
        if (対象年月指定_サービス対象年月.equals(parameter.get対象年月指定())) {
            reportEntity.set条件１(get条件１(提供月));
        } else if (対象年月指定_審査年月.equals(parameter.get対象年月指定())) {
            reportEntity.set条件１(get条件１(審査月));
        }
        if (サービス種類_00.equals(parameter.get対象サービス種類())) {
            reportEntity.set条件２(サービス種類_すべて);
        } else {
            reportEntity.set条件２(サービス種類名称);
        }
        if (選択対象_全て.equals(parameter.get選択対象())) {
            reportEntity.set条件３(選択対象_全て);
        }
        if (選択対象_町域.equals(parameter.get選択対象())) {
            reportEntity.set条件３(get条件３(町域));
        } else if (選択対象_地区１.equals(parameter.get選択対象())) {
            reportEntity.set条件３(get条件３(地区１));
        } else if (選択対象_地区２.equals(parameter.get選択対象())) {
            reportEntity.set条件３(get条件３(地区２));
        } else if (選択対象_地区３.equals(parameter.get選択対象())) {
            reportEntity.set条件３(get条件３(地区３));
        } else if (選択対象_行政区.equals(parameter.get選択対象())) {
            reportEntity.set条件３(get条件３(行政区));
        }
        if (!RString.isNullOrEmpty(parameter.get旧市町村コード())
                && !旧市町村情報_000000.equals(parameter.get旧市町村コード())
                && parameter.get旧市町村名() != null) {
            reportEntity.set条件３(new RString("").concat(旧市町村名).concat(parameter.get旧市町村名()));
        }
        reportEntity.set保険者番号(new HihokenshaNo(DbBusinessConfig.
                get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        reportEntity.set保険者名(DbBusinessConfig.
                get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        if (タイトル_59.equals(entity.getYoKaigoJotaiKubunCode())) {
            reportEntity.setタイトル(タイトル_59);
        } else {
            reportEntity.setタイトル(タイトル_59以外);
        }
        ServiceCodeBetsuRiyoJokyoReport report = new ServiceCodeBetsuRiyoJokyoReport(reportEntity, RDateTime.now());
        report.writeBy(reportSourceWriter);
        reportEntity = new ServicecodeRiyojokyoReport();
        改頁Flag = false;
        nissuKaisuSyukeichi_01 = Decimal.ZERO;
        nissuKaisuSyukeichi_12 = Decimal.ZERO;
        nissuKaisuSyukeichi_13 = Decimal.ZERO;
        nissuKaisuSyukeichi_11 = Decimal.ZERO;
        nissuKaisuSyukeichi_21 = Decimal.ZERO;
        nissuKaisuSyukeichi_22 = Decimal.ZERO;
        nissuKaisuSyukeichi_23 = Decimal.ZERO;
        nissuKaisuSyukeichi_24 = Decimal.ZERO;
        nissuKaisuSyukeichi_25 = Decimal.ZERO;
        taniSuSyukeichi_01 = Decimal.ZERO;
        taniSuSyukeichi_12 = Decimal.ZERO;
        taniSuSyukeichi_13 = Decimal.ZERO;
        taniSuSyukeichi_11 = Decimal.ZERO;
        taniSuSyukeichi_21 = Decimal.ZERO;
        taniSuSyukeichi_22 = Decimal.ZERO;
        taniSuSyukeichi_23 = Decimal.ZERO;
        taniSuSyukeichi_24 = Decimal.ZERO;
        taniSuSyukeichi_25 = Decimal.ZERO;
    }

    private void 非集計(DbWT3470chohyouShutsuryokuyouTempEntity entity, boolean 最終flag) {
        if (null == reportEntity) {
            reportEntity = new ServicecodeRiyojokyoReport();
        }
        if (!最終flag && (beforeソート用サービス項目コード == null
                || currentソート用サービス項目コード.equals(beforeソート用サービス項目コード))
                && !改頁Flag) {
            set明細(entity);
        } else {
            if (対象年月指定_サービス対象年月.equals(parameter.get対象年月指定())) {
                reportEntity.set条件１(get条件１(提供月));
            } else if (対象年月指定_審査年月.equals(parameter.get対象年月指定())) {
                reportEntity.set条件１(get条件１(審査月));
            }
            if (サービス種類_00.equals(parameter.get対象サービス種類())) {
                reportEntity.set条件２(サービス種類_すべて);
            } else {
                reportEntity.set条件２(サービス種類名称);
            }
            if (選択対象_全て.equals(parameter.get選択対象())) {
                reportEntity.set条件３(選択対象_全て);
            }
            if (選択対象_町域.equals(parameter.get選択対象())) {
                reportEntity.set条件３(get条件３(町域));
            } else if (選択対象_地区１.equals(parameter.get選択対象())) {
                reportEntity.set条件３(get条件３(地区１));
            } else if (選択対象_地区２.equals(parameter.get選択対象())) {
                reportEntity.set条件３(get条件３(地区２));
            } else if (選択対象_地区３.equals(parameter.get選択対象())) {
                reportEntity.set条件３(get条件３(地区３));
            } else if (選択対象_行政区.equals(parameter.get選択対象())) {
                reportEntity.set条件３(get条件３(行政区));
            }
            if (!RString.isNullOrEmpty(提供月)
                    && !旧市町村情報_000000.equals(parameter.get旧市町村コード())
                    && parameter.get旧市町村名() != null) {
                reportEntity.set条件３(new RString("").concat(旧市町村名).concat(parameter.get旧市町村名()));
            }
            reportEntity.set保険者番号(new HihokenshaNo(DbBusinessConfig.
                    get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
            reportEntity.set保険者名(DbBusinessConfig.
                    get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));

            if (タイトル_59.equals(entity.getYoKaigoJotaiKubunCode())) {
                reportEntity.setタイトル(タイトル_59);
            } else {
                reportEntity.setタイトル(タイトル_59以外);
            }
            set明細(entity);
            Decimal 集計回数合計値 = Decimal.ZERO;
            Decimal 集計単位数合計値 = Decimal.ZERO;
            get合計値(集計回数合計値, 集計単位数合計値, reportEntity.get明細リスト());
            ServiceCodeBetsuRiyoJokyoReport report = new ServiceCodeBetsuRiyoJokyoReport(reportEntity, RDateTime.now());
            report.writeBy(reportSourceWriter);
            reportEntity = new ServicecodeRiyojokyoReport();
        }
    }

    private void get合計値(Decimal 回数合計値, Decimal 単位数合計値, ServicecodeRiyojokyoReportEntity meisaiEntity) {
        回数合計値 = Decimal.ZERO.add(getDecimalVaule(meisaiEntity.get非該当日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要支援１日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要支援２日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護１日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護２日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護３日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護４日数_回数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護５日数_回数集計値()));
        単位数合計値 = Decimal.ZERO.add(getDecimalVaule(meisaiEntity.get非該当単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要支援１単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要支援２単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護１単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護２単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護３単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護４単位数集計値()))
                .add(getDecimalVaule(meisaiEntity.get要介護５単位数集計値()));
        meisaiEntity.set日数_回数合計値(回数合計値);
        meisaiEntity.set単位数合計値(単位数合計値);
    }

    private void get集計合計値(Decimal 集計回数合計値,
            Decimal 集計単位数合計値, ServicecodeRiyojokyoReportEntity meisaiEntity) {
        集計回数合計値 = nissuKaisuSyukeichi_01.add(getDecimalVaule(nissuKaisuSyukeichi_12))
                .add(getDecimalVaule(nissuKaisuSyukeichi_13))
                .add(getDecimalVaule(nissuKaisuSyukeichi_11)).add(getDecimalVaule(nissuKaisuSyukeichi_21))
                .add(getDecimalVaule(nissuKaisuSyukeichi_22))
                .add(getDecimalVaule(nissuKaisuSyukeichi_23))
                .add(getDecimalVaule(nissuKaisuSyukeichi_24))
                .add(getDecimalVaule(nissuKaisuSyukeichi_25));
        集計単位数合計値 = taniSuSyukeichi_01.add(getDecimalVaule(taniSuSyukeichi_12))
                .add(getDecimalVaule(taniSuSyukeichi_13))
                .add(getDecimalVaule(taniSuSyukeichi_11)).add(getDecimalVaule(taniSuSyukeichi_21))
                .add(getDecimalVaule(taniSuSyukeichi_22))
                .add(getDecimalVaule(taniSuSyukeichi_23))
                .add(getDecimalVaule(taniSuSyukeichi_24))
                .add(getDecimalVaule(taniSuSyukeichi_25));
        meisaiEntity.set日数_回数合計値(集計回数合計値);
        meisaiEntity.set単位数合計値(集計単位数合計値);
    }

    private Decimal getDecimalVaule(Decimal 値) {
        if (値 != null) {
            return 値;
        }
        return Decimal.ZERO;
    }

    private Decimal setDecimalVaule(Decimal 値) {
        if (値 == null
                || Decimal.ZERO.compareTo(値) == INT_0) {
            return null;
        }
        return 値;
    }

    private void 集計判定() {
        if (is変換(beforeサービス種類スコード, currentサービス種類スコード)) {
            改頁Flag = true;
            非集計(beforeEntity, false);
            集計(beforeEntity);
        } else {
            非集計(beforeEntity, false);
        }
    }
}
