/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.RiyoshaFutangakuGemmenShinseishoHakkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDBZ12021_4_利用者負担額免除申請書_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class RiyoshaFutangakuGemmenShinseishoHakko extends BatchProcessBase<RiyoshaFutangakuGemmenShinseishoHakkoEntity> {

    private static final RString TITLE = new RString("（特別療養老人ホームの要介護旧措置入所者に関する認定申請）");
    private static final RString JOBNO_NAME = new RString("【ジョブ番号】");
    private static final RString HAKKONICHI = new RString("【発行日】");
    private static final RString SHUTSURYOKUJUN = new RString("【出力順】");
    private static final RString なし = new RString("なし");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IRiyoshaFutangakuGemmenShinseishoHakkoMapper.get出力対象者情報");
    private ShinseishoHakkoProcessParameter processParamter;
    private static final ReportId ID = new ReportId("DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho");
    private RString 導入団体コード;
    private RString 市町村名;
    @BatchWriter
    private BatchReportWriter<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> batchReportWrite;
    private ReportSourceWriter<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> reportSourceWriter;
    private Association association;
    private Ninshosha ninshosha;
    private HokenshaList hokenshaList;
    private RString 出力順;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ninshosha = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, RString.EMPTY);
        hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        導入団体コード = association.getLasdecCode_().value();
        市町村名 = association.get市町村名();
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected IBatchReader createReader() {
        IOutputOrder order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                processParamter.get帳票ID(),
                processParamter.get改頁出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(RiyoshaFutangakuGengakuMenjyoShinseishoOrderKey.class, order);
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void process(RiyoshaFutangakuGemmenShinseishoHakkoEntity entity) {
        ShoKisaiHokenshaNo 保険者番号 = ShoKisaiHokenshaNo.EMPTY;
        if (null == entity.get広住特措置元市町村コード() || entity.get広住特措置元市町村コード().isEmpty()) {
            保険者番号 = hokenshaList.get(entity.get市町村コード()).get証記載保険者番号();
        } else {
            保険者番号 = hokenshaList.get(entity.get広住特措置元市町村コード()).get証記載保険者番号();
        }
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem bodyItem = new RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem(
                get認証者(),
                entity.is旧措置者フラグ() ? TITLE : RString.EMPTY,
                entity.get被保険者番号().value(),
                kojin.get名称().getKana().value(),
                保険者番号.value(),
                kojin.get名称().getName().value(),
                get被保険者生年月日(kojin),
                kojin.get性別().getName().getShortJapanese(),
                kojin.get住所().get郵便番号().getEditedYubinNo(),
                kojin.get住所().get住所(),
                kojin.get連絡先１().value()
        );
        RiyoshaFutangakuGengakuMenjyoShinseishoReport report = RiyoshaFutangakuGengakuMenjyoShinseishoReport.createReport(bodyItem);
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
        RString 帳票名 = ReportIdDBD.DBD800002.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
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

    private RString get被保険者生年月日(IKojin kojin) {
        if (kojin.is日本人()) {
            return kojin.get生年月日().toFlexibleDate().wareki().toDateString();
        } else {
            return kojin.get生年月日().toFlexibleDate().seireki().toDateString();
        }
    }

    private RString get認証者() {
        return NinshoshaSourceBuilderFactory.createInstance(
                ninshosha,
                association,
                reportSourceWriter.getImageFolderPath(),
                new RDate(
                        processParamter.get発行日().getYearValue(),
                        processParamter.get発行日().getMonthValue(),
                        processParamter.get発行日().getDayValue()))
                .buildSource().ninshoshaYakushokuMei;
    }

}
