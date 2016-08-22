/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmen.shinseisho.hakko.Ddb102020MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.NinteiKoshinTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.NinteiKoshinTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.FutanGendogakuOshiraseTsuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko.IFutanGendogakuOshiraseTsuchiHakkoMapper;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * DBDBZ12021_4_負担限度額認定お知らせ通知書発行_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class FutanGendogakuOshiraseTsuchiHakko extends BatchProcessBase<FutanGendogakuOshiraseTsuchiHakkoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IFutanGendogakuOshiraseTsuchiHakkoMapper.get出力対象者情報");
    private ShinseishoHakkoProcessParameter processParamter;
    private static final ReportId ID = new ReportId("DBD100008_FutanGendogakuNinteiKoshinTsuchisho");
    private static final RString 種別コード = new RString("DBD100008");
    private static final RString GENERICKEY = new RString("負担限度額認定更新のお知らせ通知書");
    private static final RString JOBNO_NAME = new RString("【ジョブ番号】");
    private static final RString HAKKONICHI = new RString("【発行日】");
    private static final RString SHUTSURYOKUJUN = new RString("【出力順】");
    private static final RString なし = new RString("なし");
    private static final int 項目番号_1 = 1;
    private static final int 項目番号_11 = 11;
    private static final int 項目番号_21 = 21;
    private RString 導入団体コード;
    private RString 市町村名;
    @BatchWriter
    private BatchReportWriter<NinteiKoshinTsuchishoReportSource> batchReportWrite;
    private ReportSourceWriter<NinteiKoshinTsuchishoReportSource> reportSourceWriter;
    private Association association;
    private Ninshosha ninshosha;
    private RString 文書番号;
    private IFutanGendogakuOshiraseTsuchiHakkoMapper mapper;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private RString 出力順;
    private int 旧措置者人数;
    private int 非旧措置者人数;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ninshosha = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード);
        導入団体コード = association.getLasdecCode_().value();
        市町村名 = association.get市町村名();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(ID);
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(ID);
        IOutputOrder order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                processParamter.get帳票ID(),
                processParamter.get改頁出力順ID());
        出力順 = Ddb102020MyBatisOrderByClauseCreator.create(FutangendogakuNinteiShinseishoOrderKey.class, order);
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IFutanGendogakuOshiraseTsuchiHakkoMapper.class);
        List<FutanGendogakuOshiraseTsuchiHakkoEntity> 減免減額申請書情報 = mapper.get出力対象者情報(
                processParamter.toFutanGendogakuMybatisParameter(出力順));
        for (FutanGendogakuOshiraseTsuchiHakkoEntity entity : 減免減額申請書情報) {
            if (entity.is旧措置者フラグ()) {
                旧措置者人数++;
            } else {
                非旧措置者人数++;
            }
        }
    }

    @Override
    protected void process(FutanGendogakuOshiraseTsuchiHakkoEntity entity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        IAtesaki atesaki = AtesakiFactory.createInstance(entity.get宛先());
        List<RString> 通知書定型文 = init通知書定型文(entity);
        set文書番号(entity);
        NinteiKoshinTsuchishoItem item = new NinteiKoshinTsuchishoItem(
                null,
                kojin,
                atesaki,
                new ChohyoSeigyoKyotsu(帳票制御共通),
                帳票制御汎用,
                association,
                new RDate(
                        processParamter.get発行日().getYearValue(),
                        processParamter.get発行日().getMonthValue(),
                        processParamter.get発行日().getDayValue()),
                文書番号,
                通知書定型文,
                processParamter.get帳票ID(),
                ninshosha
        );
        item.set編集後宛先(JushoHenshu.create編集後宛先(atesaki, association, new ChohyoSeigyoKyotsu(帳票制御共通)));
        NinteiKoshinTsuchishoReport report = new NinteiKoshinTsuchishoReport(item);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(JOBNO_NAME);
        builder.append(RString.HALF_SPACE);
        builder.append(JobContextHolder.getJobId());
        RString ジョブ番号 = builder.toRString();
        RString 帳票名 = ReportIdDBD.DBDPR12002_1_1.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        builder = new RStringBuilder();
        builder.append(HAKKONICHI);
        builder.append(processParamter.get発行日().wareki().toDateString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUTSURYOKUJUN);
        builder.append(出力順);
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ID.value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private List<RString> init通知書定型文(FutanGendogakuOshiraseTsuchiHakkoEntity entity) {
        List<RString> 通知書定型文 = new ArrayList();
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, processParamter.get帳票ID());
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo;
        if (!entity.is更新認定フラグ()) {
            tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, ID, KamokuCode.EMPTY, 項目番号_11);
        } else if (entity.is旧措置者フラグ()) {
            tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, ID, KamokuCode.EMPTY, 項目番号_21);
        } else {
            tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, ID, KamokuCode.EMPTY, 項目番号_1);
        }
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibunEntity : tsuchishoTeikeibunInfo.get通知書定型文List()) {
            int 項目番号 = tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(tsuchishoTeikeibunEntity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
        return 通知書定型文;
    }

    private void set文書番号(FutanGendogakuOshiraseTsuchiHakkoEntity entity) {
        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
        BunshoNo bunshoNo = finder.get文書番号管理(processParamter.get帳票ID(), processParamter.get基準日());
        文書番号 = bunshoNo.edit文書番号();
        CountedItem countedItem;
        if (BunshoNoHatsubanHoho.自動採番.getCode().equals(bunshoNo.get文書番号発番方法())) {
            if (entity.is旧措置者フラグ()) {
                countedItem = Saiban.get(SubGyomuCode.DBD介護受給, GENERICKEY, FlexibleDate.getNowDate().getNendo(), 旧措置者人数);
            } else {
                countedItem = Saiban.get(SubGyomuCode.DBD介護受給, GENERICKEY, FlexibleDate.getNowDate().getNendo(), 非旧措置者人数);
            }
            文書番号 = new RString(String.valueOf(countedItem.next()));
        } else if (BunshoNoHatsubanHoho.手入力.getCode().equals(bunshoNo.get文書番号発番方法())) {
            throw new SystemException("文書番号の採番方法は手入力、採番できないので処理中止。");
        }
    }
}
