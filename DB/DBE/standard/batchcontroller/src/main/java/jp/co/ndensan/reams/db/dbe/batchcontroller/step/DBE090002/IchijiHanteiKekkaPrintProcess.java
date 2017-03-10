/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoEntityEditor;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 * 一次判定結果出力プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class IchijiHanteiKekkaPrintProcess extends BatchProcessBase<YokaigoNinteiJohoTeikyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo."
            + "IYokaigoNinteiJohoTeikyoMapper.get要介護認定申請者");
    private YokaigoBatchProcessParamter processPrm;
    private YokaigoNinteiJohoTeikyoFinder finder;
    @BatchWriter
    private BatchReportWriter<IchijihanteikekkahyoReportSource> batchWrite;
    private ReportSourceWriter<IchijihanteikekkahyoReportSource> reportSourceWriter;

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

    static {
        System.setProperty("java.awt.headless", "true");
    }

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
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517181.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(YokaigoNinteiJohoTeikyoEntity entity) {
        ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo(entity.get申請書管理番号());
        List<NinteichosahyoServiceJokyo> 認定調査票サービス状況List = finder.get認定調査票サービス状況(申請書管理番号);
        List<NinteichosahyoServiceJokyoFlag> 認定調査票サービス状況フラグList = finder.get認定調査票サービス状況フラグ(申請書管理番号);
        List<RString> 認定調査特記事項番号List = finder.get認定調査特記事項番号(申請書管理番号);
        List<NinteichosahyoChosaItem> 認定調査票調査項目List = finder.get認定調査票調査項目List(申請書管理番号);
        List<NinteichosahyoChosaItem> 前回認定調査票調査項目List = finder.get前回認定調査票調査項目List(申請書管理番号);
        List<ShujiiIkenshoIkenItem> 主治医意見書意見項目List = finder.get主治医意見書意見項目List(申請書管理番号);
        List<ShujiiIkenshoIkenItem> 前回主治医意見書意見項目List = finder.get前回主治医意見書意見項目List(申請書管理番号);

        IchijihanteikekkahyoEntity ichijihanteikekkahyoEntity
                = IchijihanteikekkahyoEntityEditor.edit(entity, 認定調査特記事項番号List, 認定調査票サービス状況List,
                        認定調査票サービス状況フラグList, 認定調査票調査項目List, 前回認定調査票調査項目List,
                        主治医意見書意見項目List, 前回主治医意見書意見項目List, processPrm.get特記事項符号印刷有無(), processPrm.get正常選択肢印刷有無(),
                        processPrm.get前回との結果比較印刷有無(), processPrm.get認定調査前回結果印刷有無(),
                        processPrm.get前回正常選択肢印刷有無(), processPrm.get一次判定結果マスキング区分());
        IchijihanteikekkahyoReport report = new IchijihanteikekkahyoReport(ichijihanteikekkahyoEntity);
        report.writeBy(reportSourceWriter);
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
        builder.append(get帳票発行有無(processPrm.is一次判定結果出力()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(総合事業開始区分);
        builder.append(get総合事業開始区分名称(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援)));
        出力条件.add(builder.toRString());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE517181.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString(JobContextHolder.getJobId()),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517181.getReportId().value()),
                        new RString(String.valueOf(reportSourceWriter.pageCount().value())),
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
