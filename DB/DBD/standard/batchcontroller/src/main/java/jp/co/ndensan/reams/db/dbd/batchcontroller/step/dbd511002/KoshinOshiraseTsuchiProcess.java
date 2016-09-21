/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd511002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninshiuupdateshohakko.NinshiuUpdateProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501001.YokaigoNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd511001.KoshinShinseiOshiraseTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd511002.KoshinOshiraseTsuchiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseCommonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseTsuchiUpdateEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.koshinoshirasetsuchi.KoshinOshiraseTsuchiService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
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
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定更新お知らせ通知書発行作成の処理です。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public class KoshinOshiraseTsuchiProcess extends BatchProcessBase<KoshinOshiraseTsuchiUpdateEntity> {

    private KoshinOshiraseTsuchiProcessParameter parameter;

    private NinshoshaSource ninshoshaSource;
    private static IAtesaki 宛先;
    private static Association association;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private KoshinOshiraseTsuchiService service;
    private IOutputOrder outputOrder;
    private int index;
    private static final ReportIdDBD 帳票11 = ReportIdDBD.DBD511001;
    private static final ReportIdDBD 帳票01 = ReportIdDBD.DBD501001;
    private static final ReportIdDBD 帳票12 = ReportIdDBD.DBD511002;
    private static final RString NUM0 = new RString("0");
    private static final RString NUM1 = new RString("1");
    private static final RString NUM2 = new RString("2");
    private static final int NUM5 = 5;
    private static boolean 帳票ID01TF;
    private static boolean 帳票ID11TF;
    private static boolean 帳票ID12TF;

    @BatchWriter
    private BatchReportWriter<YokaigoNinteiShinseishoReportSource> batchReportWrite01;
    private ReportSourceWriter<YokaigoNinteiShinseishoReportSource> reportSourceWriter01;
    @BatchWriter
    private BatchReportWriter<KoshinShinseiOshiraseTshuchishoReportSource> batchReportWrite11;
    private ReportSourceWriter<KoshinShinseiOshiraseTshuchishoReportSource> reportSourceWriter11;
    @BatchWriter
    private BatchReportWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> batchReportWrite112;
    private ReportSourceWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> reportSourceWriter112;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbT4101EntityWriter;

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshinoshirasetsuchi."
            + "IKoshinOshiraseTsuchiMapper.get帳票出力用情報取得");

    @Override
    protected void initialize() {
        service = KoshinOshiraseTsuchiService.createInstance();
        index = 0;
        帳票ID01TF = false;
        帳票ID11TF = false;
        帳票ID12TF = false;
    }

    @Override
    protected void beforeExecute() {
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票11.getReportId(),
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter11);

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
        association = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票11.getReportId());
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票11.getReportId());
    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (parameter.get出力順() != null && !parameter.get出力順().isEmpty()) {
            outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, 帳票12.getReportId(), Long.parseLong(parameter.get出力順().toString()));
        }
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                    create(NinshiuUpdateProperty.DBD511002_ResultListEnum.class, outputOrder), NUM5);
        }
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinshiuUpdateMyBatisParameter(出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWrite01 = BatchReportFactory.createBatchReportWriter(帳票01.getReportId().getColumnValue()).create();
        reportSourceWriter01 = new ReportSourceWriter<>(batchReportWrite01);
        batchReportWrite11 = BatchReportFactory.createBatchReportWriter(帳票11.getReportId().getColumnValue()).create();
        reportSourceWriter11 = new ReportSourceWriter<>(batchReportWrite11);
        batchReportWrite112 = BatchReportFactory.createBatchReportWriter(帳票12.getReportId().getColumnValue())
                .addBreak(new BreakerCatalog<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource>().
                        simplePageBreaker(KoshinShinseiTsuchishoHakkoIchiranhyoReportSource.改頁_市町村コード)).create();
        reportSourceWriter112 = new ReportSourceWriter<>(batchReportWrite112);
        dbT4101EntityWriter = new BatchPermanentTableWriter(DbT4101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void process(KoshinOshiraseTsuchiUpdateEntity koshinOshiraseEntity) {

        if (NUM0.equals(parameter.get出力対象区分())) {
            帳票ID11TF = true;
            帳票ID12TF = true;
            KoshinOshiraseCommonEntity commonEntity = service.認定更新お知らせ通知書データ編集(parameter.get通知書発行日(), koshinOshiraseEntity);
            KoshinShinseiOshiraseTshuchishoReport tshuchishoReport = new KoshinShinseiOshiraseTshuchishoReport(ninshoshaSource, 宛先,
                    new ChohyoSeigyoKyotsu(帳票制御共通), association, 帳票制御汎用, commonEntity);
            tshuchishoReport.writeBy(reportSourceWriter11);

            KoshinShinseiTsuchishoHakkoIchiranhyoReport ichiranhyoReport = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(
                    service.発行一覧表データ編集(parameter, outputOrder, koshinOshiraseEntity, index));
            ichiranhyoReport.writeBy(reportSourceWriter112);

        } else if (NUM1.equals(parameter.get出力対象区分())) {
            帳票ID01TF = true;
            帳票ID12TF = true;
            YokaigoNinteiShinseishoReport yokaigoNinteiShinseishoReport = YokaigoNinteiShinseishoReport.
                    createReport(service.要介護認定申請書データ編集(koshinOshiraseEntity));
            yokaigoNinteiShinseishoReport.writeBy(reportSourceWriter01);

            KoshinShinseiTsuchishoHakkoIchiranhyoReport ichiranhyoReport = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(
                    service.発行一覧表データ編集(parameter, outputOrder, koshinOshiraseEntity, index));
            ichiranhyoReport.writeBy(reportSourceWriter112);

        } else if (NUM2.equals(parameter.get出力対象区分())) {
            帳票ID01TF = true;
            帳票ID12TF = true;
            帳票ID11TF = true;
            YokaigoNinteiShinseishoReport yokaigoNinteiShinseishoReport = YokaigoNinteiShinseishoReport.
                    createReport(service.要介護認定申請書データ編集(koshinOshiraseEntity));
            yokaigoNinteiShinseishoReport.writeBy(reportSourceWriter01);

            KoshinShinseiTsuchishoHakkoIchiranhyoReport ichiranhyoReport = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(
                    service.発行一覧表データ編集(parameter, outputOrder, koshinOshiraseEntity, index));
            ichiranhyoReport.writeBy(reportSourceWriter112);

            KoshinOshiraseCommonEntity commonEntity = service.認定更新お知らせ通知書データ編集(parameter.get通知書発行日(), koshinOshiraseEntity);
            KoshinShinseiOshiraseTshuchishoReport tshuchishoReport = new KoshinShinseiOshiraseTshuchishoReport(ninshoshaSource, 宛先,
                    new ChohyoSeigyoKyotsu(帳票制御共通), association, 帳票制御汎用, commonEntity);
            tshuchishoReport.writeBy(reportSourceWriter11);
        }
        index++;

        if (NUM0.equals(parameter.get出力対象区分()) && NUM2.equals(parameter.get出力対象区分())) {
            dbT4101EntityWriter.update(service.update要介護認定申請情報(parameter, koshinOshiraseEntity.getDbt4101Entity()));
        }
    }

    @Override
    protected void afterExecute() {
        RString 帳票ID01出力ページ数 = RString.EMPTY;
        RString 帳票ID11出力ページ数 = RString.EMPTY;
        RString 帳票ID12出力ページ数 = RString.EMPTY;

        if (帳票ID01TF) {
            帳票ID01出力ページ数 = new RString(String.valueOf(batchReportWrite01.getPageCount()));
        }
        if (帳票ID11TF) {
            帳票ID11出力ページ数 = new RString(String.valueOf(batchReportWrite11.getPageCount()));
        }
        if (帳票ID12TF) {
            帳票ID12出力ページ数 = new RString(String.valueOf(batchReportWrite112.getPageCount()));
        }
        service.バッチ出力条件リストの出力(association, parameter, 帳票ID01出力ページ数, 帳票ID11出力ページ数, 帳票ID12出力ページ数,
                帳票ID01TF, 帳票ID11TF, 帳票ID12TF);
    }
}
