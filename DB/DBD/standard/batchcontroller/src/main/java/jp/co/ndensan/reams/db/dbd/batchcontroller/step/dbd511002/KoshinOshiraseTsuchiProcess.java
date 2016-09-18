/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd511002;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.ninshiuupdateshohakko.NinshiuUpdateProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501001.YokaigoNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.business.report.dbd511001.KoshinShinseiOshiraseTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd511002.KoshinOshiraseTsuchiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseTsuchiUpdateEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.RenZhengzheEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShufaxingEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定更新お知らせ通知書発行作成の処理です。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public class KoshinOshiraseTsuchiProcess extends BatchProcessBase<KoshinOshiraseTsuchiUpdateEntity> {

    private KoshinOshiraseTsuchiProcessParameter parameter;
    private static final ReportIdDBD 帳票11 = ReportIdDBD.DBD511001;
    private static final ReportIdDBD 帳票01 = ReportIdDBD.DBD501001;
    private static final ReportIdDBD 帳票12 = ReportIdDBD.DBD511002;
    private static Association association;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private NinshoshaSource ninshoshaSource;
    private static IAtesaki 宛先;
    private static final RString カラ = new RString("～");
    private static final RString カあ = new RString("-");
    private static final RString まる = new RString("○");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final String 明治 = "明治";
    private static final String 昭和 = "昭和";
    private static final String 大正 = "大正";
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private int index = 0;
    private static final RString ゼロ = new RString("0");
    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int NUM5 = 5;
    private static boolean 帳票ID01TF;
    private static boolean 帳票ID11TF;
    private static boolean 帳票ID12TF;
    private IOutputOrder outputOrder;
    @BatchWriter
    private BatchReportWriter<YokaigoNinteiShinseishoReportSource> batchReportWrite01;
    private ReportSourceWriter<YokaigoNinteiShinseishoReportSource> reportSourceWriter01;
    @BatchWriter
    private BatchReportWriter<KoshinShinseiOshiraseTshuchishoReportSource> batchReportWrite11;
    private ReportSourceWriter<KoshinShinseiOshiraseTshuchishoReportSource> reportSourceWriter11;
    @BatchWriter
    private BatchReportWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> batchReportWrite112;
    private ReportSourceWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> reportSourceWriter112;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshinoshirasetsuchi."
                    + "IKoshinOshiraseTsuchiMapper.get帳票出力用情報取得");

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());
        帳票ID01TF = false;
        帳票ID11TF = false;
        帳票ID12TF = false;
    }

    @Override
    protected void beforeExecute() {
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票11.getReportId(),
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter11);

        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票11.getReportId());
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票11.getReportId());

    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, 帳票12.getReportId(), Long.parseLong(parameter.get出力順().toString()));
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                    create(NinshiuUpdateProperty.DBD511002_ResultListEnum.class, outputOrder), NUM5);
        }
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinshiuUpdateMyBatisParameter(出力順));

    }
    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbT4101EntityWriter;

    @Override
    protected void createWriter() {
        batchReportWrite01 = BatchReportFactory.createBatchReportWriter(帳票01.getReportId().getColumnValue()).create();
        reportSourceWriter01 = new ReportSourceWriter<>(batchReportWrite01);
        batchReportWrite11 = BatchReportFactory.createBatchReportWriter(帳票01.getReportId().getColumnValue()).create();
        reportSourceWriter11 = new ReportSourceWriter<>(batchReportWrite11);
        batchReportWrite112 = BatchReportFactory.createBatchReportWriter(帳票12.getReportId().getColumnValue()).create();
        reportSourceWriter112 = new ReportSourceWriter<>(batchReportWrite112);
        dbT4101EntityWriter = new BatchPermanentTableWriter(DbT4101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void process(KoshinOshiraseTsuchiUpdateEntity ninshi) {
        RenZhengzheEntity entity = new RenZhengzheEntity();
        TongzhiShufaxingEntity twonin = new TongzhiShufaxingEntity();
        ShinseiShoEntity entity2 = new ShinseiShoEntity();
        RenZhengzheEntity renEntity = shikonShinseNinshi(entity, ninshi);
        if (ゼロ.equals(parameter.get出力対象区分())) {
            帳票ID11TF = true;
            帳票ID12TF = true;
            KoshinShinseiOshiraseTshuchishoReport find11 = new KoshinShinseiOshiraseTshuchishoReport(ninshoshaSource, 宛先,
                    new ChohyoSeigyoKyotsu(帳票制御共通), association, 帳票制御汎用, renEntity);
            find11.writeBy(reportSourceWriter11);
            KoshinShinseiTsuchishoHakkoIchiranhyoReport find112 = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(oshiraseNinshi(twonin, ninshi));
            find112.writeBy(reportSourceWriter112);
        } else if (一.equals(parameter.get出力対象区分())) {
            帳票ID01TF = true;
            帳票ID12TF = true;
            YokaigoNinteiShinseishoReport find01 = YokaigoNinteiShinseishoReport.createReport(koshinShinseNinshi(entity2, ninshi));
            find01.writeBy(reportSourceWriter01);
            KoshinShinseiTsuchishoHakkoIchiranhyoReport find112 = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(oshiraseNinshi(twonin, ninshi));
            find112.writeBy(reportSourceWriter112);
        } else if (二.equals(parameter.get出力対象区分())) {
            帳票ID01TF = true;
            帳票ID12TF = true;
            帳票ID11TF = true;
            YokaigoNinteiShinseishoReport find01 = YokaigoNinteiShinseishoReport.createReport(koshinShinseNinshi(entity2, ninshi));
            find01.writeBy(reportSourceWriter01);
            KoshinShinseiTsuchishoHakkoIchiranhyoReport find112 = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(oshiraseNinshi(twonin, ninshi));
            find112.writeBy(reportSourceWriter112);
            KoshinShinseiOshiraseTshuchishoReport find11 = new KoshinShinseiOshiraseTshuchishoReport(ninshoshaSource, 宛先,
                    new ChohyoSeigyoKyotsu(帳票制御共通), association, 帳票制御汎用, renEntity);
            find11.writeBy(reportSourceWriter11);
        }
    }

    protected void afterProcess(DbT4101NinteiShinseiJohoEntity entity) {
        if (ゼロ.equals(parameter.get出力対象区分())
                && 二.equals(parameter.get出力対象区分())) {
            dbT4101EntityWriter.update(update要介護認定申請情報テーブ(entity));
        }
    }

    private DbT4101NinteiShinseiJohoEntity update要介護認定申請情報テーブ(DbT4101NinteiShinseiJohoEntity entity) {
        entity.setKoshinTsuchiHakkoYMD(parameter.get通知書発行日());
        return entity;
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();

    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().getColumnValue();
        RString 市町村名 = association.get市町村名();
        ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = カあ;
        RStringBuilder builder = new RStringBuilder();
        List<RString> 出力条件 = new ArrayList<>();
        builder.append(parameter.get申請書管理番号リスト());
        出力条件.add(builder.toRString());
        builder.append(parameter.get抽出対象期間_開始());
        出力条件.add(builder.toRString());
        builder.append(parameter.get出力対象区分());
        出力条件.add(builder.toRString());
        builder.append(parameter.get出力順());
        出力条件.add(builder.toRString());
        builder.append(parameter.get抽出対象期間_終了());
        出力条件.add(builder.toRString());
        builder.append(parameter.get通知書発行日());
        出力条件.add(builder.toRString());
        if (帳票ID01TF == true) {
            RString 帳票ID = 帳票01.getReportId().getColumnValue();
            RString 帳票名 = 帳票01.getReportName();
            RString 出力ページ数 = new RString(String.valueOf(batchReportWrite01.getPageCount()));
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    帳票ID,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    帳票名,
                    出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        }
        if (帳票ID11TF == true) {
            RString 帳票ID = 帳票11.getReportId().getColumnValue();
            RString 帳票名 = 帳票11.getReportName();
            RString 出力ページ数 = new RString(String.valueOf(batchReportWrite11.getPageCount()));
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    帳票ID,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    帳票名,
                    出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        }
        if (帳票ID12TF == true) {
            RString 帳票ID = 帳票12.getReportId().getColumnValue();
            RString 帳票名 = 帳票12.getReportName();
            RString 出力ページ数 = new RString(String.valueOf(batchReportWrite112.getPageCount()));
            ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                    帳票ID,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    帳票名,
                    出力ページ数,
                    csv出力有無,
                    csvファイル名,
                    出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
            printer.print();
        }

    }

    private RenZhengzheEntity shikonShinseNinshi(RenZhengzheEntity entity, KoshinOshiraseTsuchiUpdateEntity ninshi) {
        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票11.getReportId(),
                KamokuCode.EMPTY, 1);
        entity.set通知文1(map.get(1));
        entity.set通知文2(map.get(2));
        entity.set文書番号(ReportUtil.get文書番号(SubGyomuCode.DBD介護受給, 帳票11.getReportId(), parameter.get通知書発行日()));
        entity.set被保険者氏名フリガナ(ninshi.getHihokenshaKana().getColumnValue());
        entity.set被保険者番号1(ninshi.getHihokenshaNo().substring(ZERO, ONE));
        entity.set被保険者番号2(ninshi.getHihokenshaNo().substring(ONE, TWO));
        entity.set被保険者番号3(ninshi.getHihokenshaNo().substring(TWO, THREE));
        entity.set被保険者番号4(ninshi.getHihokenshaNo().substring(THREE, FOUR));
        entity.set被保険者番号5(ninshi.getHihokenshaNo().substring(FOUR, FIVE));
        entity.set被保険者番号6(ninshi.getHihokenshaNo().substring(FIVE, SIX));
        entity.set被保険者番号7(ninshi.getHihokenshaNo().substring(SIX, SEVEN));
        entity.set被保険者番号8(ninshi.getHihokenshaNo().substring(SEVEN, EIGHT));
        entity.set被保険者番号9(ninshi.getHihokenshaNo().substring(EIGHT, NINE));
        entity.set被保険者番号10(ninshi.getHihokenshaNo().substring(NINE, TEN));
        entity.set被保険者氏名(ninshi.getHihokenshaName().getColumnValue());
        entity.set要介護認定開始日(ninshi.getNinteiYukoKikanKaishiYMD().wareki().separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        entity.set要介護認定終了日(ninshi.getNinteiYukoKikanShuryoYMD().wareki().separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("99A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun99.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("02A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun02.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("06A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun06.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09B"))
                || ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun09.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        }

        return entity;
    }

    private TongzhiShufaxingEntity oshiraseNinshi(TongzhiShufaxingEntity twonin, KoshinOshiraseTsuchiUpdateEntity ninshi) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(parameter.get抽出対象期間_開始().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        builder.append(カラ);
        builder.append(parameter.get抽出対象期間_終了().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        twonin.set抽出対象期間(builder.toRString());
        twonin.set市町村コード(ninshi.getShichosonCode().getColumnValue());
        twonin.set市町村名称(ninshi.getShichosonMeisho());
        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(outputOrder);
        if (出力順Map.get(LISTINDEX_0) != null) {
            twonin.set並び順1(出力順Map.get(LISTINDEX_0).get項目名());
        }
        if (出力順Map.get(LISTINDEX_1) != null) {
            twonin.set並び順2(出力順Map.get(LISTINDEX_1).get項目名());
        }
        if (出力順Map.get(LISTINDEX_2) != null) {
            twonin.set並び順3(出力順Map.get(LISTINDEX_2).get項目名());
        }
        if (出力順Map.get(LISTINDEX_3) != null) {
            twonin.set並び順4(出力順Map.get(LISTINDEX_3).get項目名());
        }
        if (出力順Map.get(LISTINDEX_4) != null) {
            twonin.set並び順4(出力順Map.get(LISTINDEX_4).get項目名());
        }
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        twonin.set印刷時間(new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + timeFormat + (RString.HALF_SPACE) + (new RString("作成"))));
        index++;
        set通知書発行一覧(twonin, ninshi, index);

        return twonin;
    }

    private void set通知書発行一覧(TongzhiShufaxingEntity twonin, KoshinOshiraseTsuchiUpdateEntity ninshi, int index) {
        TongzhiShuEntity entity = new TongzhiShuEntity();
        entity.set被保険者番号(ninshi.getHihokenshaNo());
        entity.set被保険者氏名(ninshi.getHihokenshaName().getColumnValue());
        if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("99A"))) {
            entity.set要介護度(YokaigoJotaiKubun99.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("02A"))) {
            entity.set要介護度(YokaigoJotaiKubun02.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("06A"))) {
            entity.set要介護度(YokaigoJotaiKubun06.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        } else if (ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09B"))
                || ninshi.getKoroshoIfShikibetsuCode().getColumnValue().equals(new RString("09A"))) {
            entity.set要介護度(YokaigoJotaiKubun09.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get名称());
        }
        entity.set受給申請日(ninshi.getNinteiShinseiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set認定日(ninshi.getNinteiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set認定開始日(ninshi.getNinteiYukoKikanKaishiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set認定終了日(ninshi.getNinteiYukoKikanShuryoYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set受給申請事由(ninshi.getNinteiShinseiRiyu());
        entity.set申請区分_申請時(NinteiShinseiShinseijiKubunCode.toValue(ninshi.getNinteiShinseiShinseijiKubunCode().getColumnValue()).get名称());
        entity.set申請区分_法令(NinteiShinseiHoreiCode.toValue(ninshi.getNinteiShinseiHoreiKubunCode().getColumnValue()).get名称());
        entity.set居宅支援事業者コード(ninshi.getJigyoshaNo().getColumnValue());
        entity.set居宅支援事業者名称(ninshi.getJigyoshaMeisho());
        entity.set入所施設事業者コード(ninshi.getNyushoShisetsuCode().getColumnValue());
        entity.set入所施設事業者名称(ninshi.getJigyoshaName().getColumnValue());
        entity.set連番(index);
        twonin.setTongzhiShu(entity);
    }

    private ShinseiShoEntity koshinShinseNinshi(ShinseiShoEntity entity, KoshinOshiraseTsuchiUpdateEntity ninshi) {
        entity.set市町村名称(ninshi.getShichosonMeisho());
        entity.set被保険者番号第1桁(ninshi.getHihokenshaNo().substring(ZERO, ONE));
        entity.set被保険者番号第2桁(ninshi.getHihokenshaNo().substring(ONE, TWO));
        entity.set被保険者番号第3桁(ninshi.getHihokenshaNo().substring(TWO, THREE));
        entity.set被保険者番号第4桁(ninshi.getHihokenshaNo().substring(THREE, FOUR));
        entity.set被保険者番号第5桁(ninshi.getHihokenshaNo().substring(FOUR, FIVE));
        entity.set被保険者番号第6桁(ninshi.getHihokenshaNo().substring(FIVE, SIX));
        entity.set被保険者番号第7桁(ninshi.getHihokenshaNo().substring(SIX, SEVEN));
        entity.set被保険者番号第8桁(ninshi.getHihokenshaNo().substring(SEVEN, EIGHT));
        entity.set被保険者番号第9桁(ninshi.getHihokenshaNo().substring(EIGHT, NINE));
        entity.set被保険者番号第10桁(ninshi.getHihokenshaNo().substring(NINE, TEN));
        String nianhao = ninshi.getSeinengappiYMD().wareki().eraType(EraType.KANJI).getEra().toString();
        if (nianhao.startsWith(明治)) {
            entity.set出生元号明治(まる);
            entity.set出生元号大正(RString.EMPTY);
            entity.set出生元号明治(RString.EMPTY);
        } else if (nianhao.startsWith(大正)) {
            entity.set出生元号明治(RString.EMPTY);
            entity.set出生元号大正(まる);
            entity.set出生元号明治(RString.EMPTY);
        } else if (nianhao.startsWith(昭和)) {
            entity.set出生元号明治(RString.EMPTY);
            entity.set出生元号大正(RString.EMPTY);
            entity.set出生元号明治(まる);
        }
        entity.set被保険者名称カナ(ninshi.getHihokenshaKana().getColumnValue());
        entity.set出生年YYYY(RString.EMPTY);
        entity.set生まれYY(ninshi.getSeinengappiYMD().wareki().getYear());
        entity.set出生月MM(ninshi.getSeinengappiYMD().wareki().getMonth());
        entity.set出生日DD(ninshi.getSeinengappiYMD().wareki().getDay());
        entity.set被保険者名称(ninshi.getHihokenshaName().getColumnValue());
        if (Seibetsu.男.getコード().equals(ninshi.getSeibetsu().getColumnValue())) {
            entity.set性別男(まる);
            entity.set性別女(RString.EMPTY);
        } else if (Seibetsu.女.getコード().equals(ninshi.getSeibetsu().getColumnValue())) {
            entity.set性別男(RString.EMPTY);
            entity.set性別女(まる);
        }
        entity.set電話番号(ninshi.getTelNo().getColumnValue());
        entity.set郵便番号(ninshi.getYubinNo().getColumnValue());
        entity.set住所(ninshi.getJusho().getColumnValue());
        Code eCode = ninshi.getYokaigoJotaiKubunCode();
        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票11.getReportId(),
                KamokuCode.EMPTY, 1);
        entity.set通知文(map.get(1));
        if (ninshi.getKoroshoIfShikibetsuCode().equals(new Code("99A"))) {
            entity = shichoson(entity, eCode);
        } else if (ninshi.getKoroshoIfShikibetsuCode().equals(new Code("02A"))) {
            entity = prtKaigo(entity, eCode);
        } else if (ninshi.getKoroshoIfShikibetsuCode().equals(new Code("06A"))) {
            entity = Kanri(entity, eCode);
        } else if (ninshi.getKoroshoIfShikibetsuCode().equals(new Code("09B"))
                || ninshi.getKoroshoIfShikibetsuCode().equals(new Code("09A"))) {
            entity = sakusei(entity, eCode);
        }

        entity.set有効開始年YYYY(ninshi.getNinteiYukoKikanKaishiYMD().wareki().getYear());
        entity.set有効開始月MM(ninshi.getNinteiYukoKikanKaishiYMD().wareki().getMonth());
        entity.set有効開始日DD(ninshi.getNinteiYukoKikanKaishiYMD().wareki().getDay());
        entity.set有効終了年YYYY(ninshi.getNinteiYukoKikanShuryoYMD().wareki().getYear());
        entity.set有効終了月MM(ninshi.getNinteiYukoKikanShuryoYMD().wareki().getMonth());
        entity.set有効終了日DD(ninshi.getNinteiYukoKikanShuryoYMD().wareki().getDay());

        return entity;
    }

    /**
     * 送付物宛先情報の取得。
     *
     * @return AtesakiPSMSearchKeyBuilder AtesakiPSMSearchKeyBuilder
     */
    public static AtesakiPSMSearchKeyBuilder get送付物宛先情報() {
        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        return builder;

    }

    private ShinseiShoEntity shichoson(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        }
        return entity;
    }

    private ShinseiShoEntity prtKaigo(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        }
        return entity;
    }

    private ShinseiShoEntity Kanri(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要支援1.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, まる, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要支援2.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, まる);
        }
        return entity;
    }

    private ShinseiShoEntity sakusei(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護1.getコード())) {
            set要介護(entity, まる, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護2.getコード())) {
            set要介護(entity, RString.EMPTY, まる, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護3.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, まる, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護4.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, まる,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護5.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    まる, RString.EMPTY, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要支援1.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, まる, RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要支援2.getコード())) {
            set要介護(entity, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, まる);
        }
        return entity;
    }

    private void set要介護(ShinseiShoEntity entity, RString 要介護状態区分1, RString 要介護状態区分2,
            RString 要介護状態区分3, RString 要介護状態区分4, RString 要介護状態区分5, RString 要支援状態区分1,
            RString 要支援状態区分2) {
        entity.set要介護状態区分1(要介護状態区分1);
        entity.set要介護状態区分2(要介護状態区分2);
        entity.set要介護状態区分3(要介護状態区分3);
        entity.set要介護状態区分4(要介護状態区分4);
        entity.set要介護状態区分5(要介護状態区分5);
        entity.set要支援状態区分1(要支援状態区分1);
        entity.set要支援状態区分2(要支援状態区分2);
    }

}
