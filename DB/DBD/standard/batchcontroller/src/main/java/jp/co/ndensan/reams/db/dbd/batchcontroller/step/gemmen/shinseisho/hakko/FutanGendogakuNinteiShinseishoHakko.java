/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmen.shinseisho.hakko.Ddb102020MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoBodyItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800004.TokuteiFutangendogakuShinseishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800004.TokuteiFutangendogakuShinseishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.FutanGendogakuNinteiShinseishoHakkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800001.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800004.TokuteiFutangendogakuShinseishoReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDBZ12021_4_介護保険負担限度額認定申請書_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class FutanGendogakuNinteiShinseishoHakko extends BatchProcessBase<FutanGendogakuNinteiShinseishoHakkoEntity> {

    private static final RString HAKKONICHI = new RString("【発行日】");
    private static final RString SHUTSURYOKUJUN = new RString("【出力順】");
    private static final RString なし = new RString("なし");
    private static final RString COMMA = new RString(",");
    private static final RString 種別コード = new RString("0001");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IFutanGendogakuNinteiShinseishoHakkoMapper.get出力対象者情報");
    private static final ReportId ID = new ReportId("DBD800001_FutangendogakuNinteiShinseisho");
    private static final ReportId REPORTID = new ReportId("DBD800004_TokuteiFutangendogakuShinseisho");
    private static final int STARTINDEX = 9;
    private ShinseishoHakkoProcessParameter processParamter;
    private RString 導入団体コード;
    private RString 市町村名;
    private RString reamsLoginID;
    @BatchWriter
    private BatchReportWriter<FutangendogakuNinteiShinseishoReportSource> batchReportWrite;
    private ReportSourceWriter<FutangendogakuNinteiShinseishoReportSource> reportSourceWriter;
    @BatchWriter
    private BatchReportWriter<TokuteiFutangendogakuShinseishoReportSource> reportWrtye;
    private ReportSourceWriter<TokuteiFutangendogakuShinseishoReportSource> sourceWriter;
    private Association association;
    private Ninshosha ninshosha;
    private IOutputOrder order;
    private RString 出力順;
    private List<RString> 通知書定型文;
    private HokenshaList hokenshaList;
    private boolean is旧措置者;
    private boolean isNot旧措置者;
    private int i = 0;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ninshosha = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード);
        導入団体コード = association.getLasdecCode_().value();
        市町村名 = association.get市町村名();
        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        通知書定型文 = new ArrayList();
        hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, processParamter.get帳票ID(), KamokuCode.EMPTY, 1);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, processParamter.get帳票ID());
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity entity : 通知書定型文List) {
            int 項目番号 = entity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(entity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
        reportWrtye = BatchReportFactory.createBatchReportWriter(REPORTID.value(), SubGyomuCode.DBD介護受給).create();
        sourceWriter = new ReportSourceWriter<>(reportWrtye);
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.get帳票ID().value().equals(ID.value())) {
            order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, ID, reamsLoginID,
                    processParamter.get改頁出力順ID());
        } else {
            order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, REPORTID, reamsLoginID,
                    processParamter.get改頁出力順ID());
        }
        if (order != null) {
            出力順 = Ddb102020MyBatisOrderByClauseCreator.create(FutangendogakuNinteiShinseishoOrderKey.class, order);
            if (processParamter.is出力フラグ()) {
                出力順 = COMMA.concat(出力順.substring(STARTINDEX, 出力順.length()));
            }
        } else {
            出力順 = RString.EMPTY;
        }
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void process(FutanGendogakuNinteiShinseishoHakkoEntity entity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        if (entity.is旧措置者フラグ()) {
            RString 郵便番号;
            RString 電話番号;
            RString 事業者住所;
            RString 事業者名称;
            if (entity.get郵便番号() == null || entity.get郵便番号().isEmpty()) {
                郵便番号 = RString.EMPTY;
            } else {
                郵便番号 = entity.get郵便番号().value();
            }
            if (entity.get電話番号() == null || entity.get郵便番号().isEmpty()) {
                電話番号 = RString.EMPTY;
            } else {
                電話番号 = entity.get電話番号().value();
            }
            if (entity.get事業者住所() == null || entity.get事業者住所().isEmpty()) {
                事業者住所 = RString.EMPTY;
            } else {
                事業者住所 = entity.get事業者住所().value();
            }
            if (entity.get事業者名称() == null || entity.get事業者名称().isEmpty()) {
                事業者名称 = RString.EMPTY;
            } else {
                事業者名称 = entity.get事業者名称().value();
            }
            TokuteiFutangendogakuShinseishoItem item = new TokuteiFutangendogakuShinseishoItem(
                    get認証者(),
                    kojin.get名称().getKana().value(),
                    kojin.get名称().getName().value(),
                    get保険者番号(entity),
                    entity.get被保険者番号().value(),
                    get被保険者生年月日(kojin),
                    kojin.get性別().getName().getShortJapanese(),
                    kojin.get住所().get郵便番号().getEditedYubinNo(),
                    kojin.get住所().get住所(),
                    kojin.get連絡先１().value(),
                    郵便番号,
                    事業者住所,
                    事業者名称,
                    電話番号,
                    new RString(i++)
            );
            TokuteiFutangendogakuShinseishoReport report = TokuteiFutangendogakuShinseishoReport.createFrom(item);
            report.writeBy(sourceWriter);
            is旧措置者 = true;
        } else {
            FutangendogakuNinteiShinseishoBodyItem bodyItem = new FutangendogakuNinteiShinseishoBodyItem(
                    通知書定型文.get(1),
                    kojin.get名称().getKana().value(),
                    entity.get被保険者番号().value(),
                    kojin.get名称().getName().value(),
                    kojin.get性別().getName().getShortJapanese(),
                    get被保険者生年月日(kojin),
                    kojin.get連絡先１().value(),
                    kojin.get住所().get郵便番号().getEditedYubinNo(),
                    kojin.get住所().get住所(),
                    通知書定型文.get(2),
                    get認証者()
            );
            FutangendogakuNinteiShinseishoReport report = FutangendogakuNinteiShinseishoReport.createReport(bodyItem);
            report.writeBy(reportSourceWriter);
            isNot旧措置者 = true;
        }
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(RString.HALF_SPACE);
        builder.append(JobContextHolder.getJobId());
        RString ジョブ番号 = builder.toRString();
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
        for (RString 帳票名 : get帳票名()) {
            ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                    processParamter.get帳票ID().value(), 導入団体コード, 市町村名, ジョブ番号,
                    帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
            IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
            printer.print();
        }
    }

    private RString get被保険者生年月日(IKojin kojin) {
        if (kojin.is日本人()) {
            return kojin.get生年月日().toFlexibleDate().wareki().toDateString();
        } else {
            return kojin.get生年月日().toFlexibleDate().seireki().toDateString();
        }
    }

    private RString get認証者() {
        RDate 発行日 = RDate.getNowDate();
        if (!processParamter.get発行日().isEmpty()) {
            発行日 = new RDate(
                    processParamter.get発行日().getYearValue(),
                    processParamter.get発行日().getMonthValue(),
                    processParamter.get発行日().getDayValue());
        }
        return NinshoshaSourceBuilderFactory.createInstance(
                ninshosha,
                association,
                reportSourceWriter.getImageFolderPath(),
                発行日)
                .buildSource().ninshoshaYakushokuMei;
    }

    private List<RString> get帳票名() {
        List<RString> 帳票名List = new ArrayList<>();
        帳票名List.add(ReportIdDBD.DBD800001.getReportName());
        帳票名List.add(ReportIdDBD.DBD800004.getReportName());
        return 帳票名List;
    }

    private RString get保険者番号(FutanGendogakuNinteiShinseishoHakkoEntity entity) {
        if (entity.get広住特措置元市町村コード() != null && !entity.get広住特措置元市町村コード().isEmpty()) {
            return hokenshaList.get(entity.get広住特措置元市町村コード()).get証記載保険者番号().value();
        } else {
            return hokenshaList.get(entity.get市町村コード()).get証記載保険者番号().value();
        }
    }
}
