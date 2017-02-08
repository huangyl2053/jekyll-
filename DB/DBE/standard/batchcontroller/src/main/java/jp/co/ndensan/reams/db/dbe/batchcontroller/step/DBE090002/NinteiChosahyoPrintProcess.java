/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo02.NinteiChosaJohohyo02EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo02.NinteiChosaJohohyo02Report;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo12EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo12.NinteiChosaJohohyo12Report;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo22.NinteiChosaJohohyo22EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo22.NinteiChosaJohohyo22Report;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo32.NinteiChosaJohohyo32EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo32.NinteiChosaJohohyo32Report;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42.NinteiChosaJohohyo42EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42.NinteiChosaJohohyo42Report;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo52EntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo52.NinteiChosaJohohyo52Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteiChosaJohohyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo02ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo12ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo22ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo32ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo42ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo52ReportSource;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 * 認定調査票出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosahyoPrintProcess extends BatchProcessBase<YokaigoNinteiJohoTeikyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    private YokaigoNinteiJohoTeikyoFinder finder;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo02ReportSource> batchWrite02;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo12ReportSource> batchWrite12;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo22ReportSource> batchWrite22;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo32ReportSource> batchWrite32;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo42ReportSource> batchWrite42;
    @BatchWriter
    private BatchReportWriter<NinteiChosaJohohyo52ReportSource> batchWrite52;
    private ReportSourceWriter<NinteiChosaJohohyo02ReportSource> reportSourceWriter02;
    private ReportSourceWriter<NinteiChosaJohohyo12ReportSource> reportSourceWriter12;
    private ReportSourceWriter<NinteiChosaJohohyo22ReportSource> reportSourceWriter22;
    private ReportSourceWriter<NinteiChosaJohohyo32ReportSource> reportSourceWriter32;
    private ReportSourceWriter<NinteiChosaJohohyo42ReportSource> reportSourceWriter42;
    private ReportSourceWriter<NinteiChosaJohohyo52ReportSource> reportSourceWriter52;

    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 認定調査票チェックフラグ = new RString("【認定調査票】");
    private static final RString 特記事項チェックフラグ = new RString("【特記事項】");
    private static final RString 主治医意見書チェックフラグ = new RString("【主治医意見書】");
    private static final RString その他資料チェックフラグ = new RString("【その他資料】");
    private static final RString 一次判定結果チェックフラグ = new RString("【一次判定結果】");
    private static final RString 出力する = new RString("出力する");
    private static final RString 出力しない = new RString("出力しない");
    private static final RString 総合事業開始区分 = new RString("【総合事業開始区分】");
    private static final RString 総合事業開始区分_未実施 = new RString("1");
    private static final RString 総合事業開始区分_実施済 = new RString("2");
    private static final RString 総合事業未実施 = new RString("総合事業未実施");
    private static final RString 総合事業実施済 = new RString("総合事業実施済");

    @Override
    protected void initialize() {
        finder = YokaigoNinteiJohoTeikyoFinder.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processPrm.toYokaigoBatchMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite02 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091002.getReportId().value()).create();
        reportSourceWriter02 = new ReportSourceWriter(batchWrite02);
        batchWrite12 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091012.getReportId().value()).create();
        reportSourceWriter12 = new ReportSourceWriter(batchWrite12);
        batchWrite22 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091022.getReportId().value()).create();
        reportSourceWriter22 = new ReportSourceWriter(batchWrite22);
        batchWrite32 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091032.getReportId().value()).create();
        reportSourceWriter32 = new ReportSourceWriter(batchWrite32);
        batchWrite42 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091042.getReportId().value()).create();
        reportSourceWriter42 = new ReportSourceWriter(batchWrite42);
        batchWrite52 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE091052.getReportId().value()).create();
        reportSourceWriter52 = new ReportSourceWriter(batchWrite52);
    }

    @Override
    protected void process(YokaigoNinteiJohoTeikyoEntity entity) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(entity.get申請書管理番号());
        List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List = finder.get認定調査票サービス状況(申請書管理番号);
        List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList = finder.get認定調査票サービス状況フラグ(申請書管理番号);
        List<NinteichosahyoChosaItem> 認定調査票調査項目List = finder.get認定調査票調査項目List(申請書管理番号);
        List<NinteichosahyoKinyuItem> 認定調査票記入項目List = finder.get認定調査票記入項目List(申請書管理番号);
        RDateTime イメージ共有ファイルID = finder.getイメージ共有ファイルID(申請書管理番号);
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())
                && 総合事業実施済.equals(processPrm.get総合事業開始区分())) {
            NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                    = NinteiChosaJohohyo02EntityEditor.edit(
                            entity,
                            認定調査票サービス状況List,
                            認定調査票サービス状況フラグList,
                            認定調査票調査項目List,
                            認定調査票記入項目List,
                            イメージ共有ファイルID,
                            processPrm.get認定調査票マスキング区分(),
                            processPrm.get主治医意見書マスキング区分());
            NinteiChosaJohohyo02Report report = new NinteiChosaJohohyo02Report(ninteiChosaJohohyoEntity);
            report.writeBy(reportSourceWriter02);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())
                && 総合事業未実施.equals(processPrm.get総合事業開始区分())) {
            NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                    = NinteiChosaJohohyo12EntityEditor.edit(
                            entity,
                            認定調査票サービス状況List,
                            認定調査票サービス状況フラグList,
                            認定調査票調査項目List,
                            認定調査票記入項目List,
                            イメージ共有ファイルID,
                            processPrm.get認定調査票マスキング区分(),
                            processPrm.get主治医意見書マスキング区分());
            NinteiChosaJohohyo12Report report = new NinteiChosaJohohyo12Report(ninteiChosaJohohyoEntity);
            report.writeBy(reportSourceWriter12);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())) {
            NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                    = NinteiChosaJohohyo22EntityEditor.edit(
                            entity,
                            認定調査票サービス状況List,
                            認定調査票サービス状況フラグList,
                            認定調査票調査項目List,
                            認定調査票記入項目List,
                            イメージ共有ファイルID,
                            processPrm.get認定調査票マスキング区分(),
                            processPrm.get主治医意見書マスキング区分());
            NinteiChosaJohohyo22Report report = new NinteiChosaJohohyo22Report(ninteiChosaJohohyoEntity);
            report.writeBy(reportSourceWriter22);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
            NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                    = NinteiChosaJohohyo32EntityEditor.edit(
                            entity,
                            認定調査票サービス状況List,
                            認定調査票サービス状況フラグList,
                            認定調査票調査項目List,
                            認定調査票記入項目List,
                            イメージ共有ファイルID,
                            processPrm.get認定調査票マスキング区分(),
                            processPrm.get主治医意見書マスキング区分());
            NinteiChosaJohohyo32Report report = new NinteiChosaJohohyo32Report(ninteiChosaJohohyoEntity);
            report.writeBy(reportSourceWriter32);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
            NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                    = NinteiChosaJohohyo42EntityEditor.edit(
                            entity,
                            認定調査票サービス状況List,
                            認定調査票サービス状況フラグList,
                            認定調査票調査項目List,
                            認定調査票記入項目List,
                            イメージ共有ファイルID,
                            processPrm.get認定調査票マスキング区分(),
                            processPrm.get主治医意見書マスキング区分());
            NinteiChosaJohohyo42Report report = new NinteiChosaJohohyo42Report(ninteiChosaJohohyoEntity);
            report.writeBy(reportSourceWriter42);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
            NinteiChosaJohohyoEntity ninteiChosaJohohyoEntity
                    = NinteiChosaJohohyo52EntityEditor.edit(
                            entity,
                            認定調査票サービス状況List,
                            認定調査票サービス状況フラグList,
                            認定調査票調査項目List,
                            認定調査票記入項目List,
                            イメージ共有ファイルID,
                            processPrm.get認定調査票マスキング区分(),
                            processPrm.get主治医意見書マスキング区分());
            NinteiChosaJohohyo52Report report = new NinteiChosaJohohyo52Report(ninteiChosaJohohyoEntity);
            report.writeBy(reportSourceWriter52);
        }
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(認定調査票チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is認定調査票出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(特記事項チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is特記事項出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(主治医意見書チェックフラグ);
        builder.append(get帳票発行有無(processPrm.is主治医意見書出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(その他資料チェックフラグ);
        builder.append(get帳票発行有無(processPrm.isその他資料出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(一次判定結果チェックフラグ);
        builder.append(get帳票発行有無(processPrm.isその他資料出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(get総合事業開始区分名称(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE091052.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091052.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter52.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }

    private RString get帳票発行有無(boolean 帳票発行フラグ) {
        if (帳票発行フラグ) {
            return 出力する;
        } else {
            return 出力しない;
        }
    }

    private RString get総合事業開始区分名称(RString 総合事業開始区分) {
        if (総合事業開始区分.equals(総合事業開始区分_未実施)) {
            return 総合事業未実施;
        } else if (総合事業開始区分.equals(総合事業開始区分_実施済)) {
            return 総合事業実施済;
        }
        return RString.EMPTY;
    }
}
