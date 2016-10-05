/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD102020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmen.shinseisho.hakko.Ddb102020MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800005.HomonKaigoRiyoshaFutangakuGengakuShinseishoOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800005.HomonkaigoRiyoushaFutangakuGengakuShinseishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800005.HomonkaigoRiyoushaFutangakuGengakuShinseishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.RiyoshaFutangakuGemmenShinseishoHakkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800005.HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDBZ12021_4_訪問介護利用者負担額減額申請書_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class HomonRiyoshaFutanGengakuShinseishoHakko extends BatchProcessBase<RiyoshaFutangakuGemmenShinseishoHakkoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IRiyoshaFutangakuGemmenShinseishoHakkoMapper.get出力対象者情報");
    private static final int STARTINDEX = 9;
    private static final RString COMMA = new RString(",");
    private static final RString HAKKONICHI = new RString("【発行日】");
    private static final RString SHUTSURYOKUJUN = new RString("【出力順】");
    private static final RString なし = new RString("なし");
    private static final RString 種別コード = new RString("0001");
    private ShinseishoHakkoProcessParameter processParamter;
    private Association association;
    private Ninshosha ninshosha;
    private HokenshaList hokenshaList;
    private RString 導入団体コード;
    private RString 市町村名;
    private int i = 0;
    private List<RString> 通知書定型文;
    private RString 出力順;
    @BatchWriter
    private BatchReportWriter<HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource> batchReportWriter;
    private ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        ninshosha = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード);
        hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        導入団体コード = association.getLasdecCode_().value();
        市町村名 = association.get市町村名();
        通知書定型文 = new ArrayList();
        出力順 = RString.EMPTY;
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, processParamter.get帳票ID(),
                KamokuCode.EMPTY, 1);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, processParamter.get帳票ID());
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity entity : 通知書定型文List) {
            int 項目番号 = entity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(entity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
    }

    @Override
    protected IBatchReader createReader() {
        IOutputOrder order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                processParamter.get帳票ID(),
                processParamter.get改頁出力順ID());
        if (order != null) {
            出力順 = Ddb102020MyBatisOrderByClauseCreator.create(HomonKaigoRiyoshaFutangakuGengakuShinseishoOrderKey.class, order);
            if (processParamter.is出力フラグ()) {
                出力順 = COMMA.concat(出力順.substring(STARTINDEX, 出力順.length()));
            }
        }
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(processParamter.get帳票ID().value(), SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(RiyoshaFutangakuGemmenShinseishoHakkoEntity entity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        HomonkaigoRiyoushaFutangakuGengakuShinseishoItem item = new HomonkaigoRiyoushaFutangakuGengakuShinseishoItem(
                kojin.get名称().getKana().value(),
                get保険者番号(entity),
                kojin.get名称().getName().value(),
                entity.get被保険者番号().value(),
                kojin.get性別().getName().getShortJapanese(),
                get被保険者生年月日(kojin),
                kojin.get住所().get郵便番号().getEditedYubinNo(),
                kojin.get連絡先１().value(),
                kojin.get住所().get住所(),
                通知書定型文.get(1),
                new RString(i++),
                get認証者()
        );
        HomonkaigoRiyoushaFutangakuGengakuShinseishoReport report = HomonkaigoRiyoushaFutangakuGengakuShinseishoReport.createReport(item);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
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

    private RString get被保険者生年月日(IKojin kojin) {
        if (kojin.is日本人()) {
            return kojin.get生年月日().toFlexibleDate().wareki().toDateString();
        } else {
            return kojin.get生年月日().toFlexibleDate().seireki().toDateString();
        }
    }

    private RString get保険者番号(RiyoshaFutangakuGemmenShinseishoHakkoEntity entity) {
        if (entity.get広住特措置元市町村コード() != null && !entity.get広住特措置元市町村コード().isEmpty()) {
            return hokenshaList.get(entity.get広住特措置元市町村コード()).get証記載保険者番号().value();
        } else {
            return hokenshaList.get(entity.get市町村コード()).get証記載保険者番号().value();
        }
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
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append(HAKKONICHI);
        builder2.append(processParamter.get発行日().wareki().toDateString());
        出力条件.add(builder2.toRString());
        RStringBuilder buidler3 = new RStringBuilder();
        buidler3.append(SHUTSURYOKUJUN);
        buidler3.append(出力順);
        出力条件.add(buidler3.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                processParamter.get帳票ID().value(), 導入団体コード, 市町村名, ジョブ番号,
                ReportIdDBD.DBD800005.getReportName(), 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }
}
