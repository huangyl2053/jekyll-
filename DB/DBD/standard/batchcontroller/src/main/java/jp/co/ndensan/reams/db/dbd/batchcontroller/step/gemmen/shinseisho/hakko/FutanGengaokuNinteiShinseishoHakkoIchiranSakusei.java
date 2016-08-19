/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.shinseisho.hakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmen.shinseisho.hakko.ShinseishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseishohakkoichiran.FutanGendogakuNinteiShinseishoHakkoIchiran;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.FutanGendogakuNinteiShinseishoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDBZ12021_4_負担限度額認定申請書発行一覧表発行_process処理クラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public class FutanGengaokuNinteiShinseishoHakkoIchiranSakusei extends BatchProcessBase<FutanGendogakuNinteiShinseishoHakkoIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko."
            + "IFutanGengaokuNinteiShinseishoHakkoIchiranSakuseiMapper.get出力対象者情報");
    private static final RString JOBNO_NAME = new RString("【ジョブ番号】");
    private static final RString HAKKONICHI = new RString("【発行日】");
    private static final RString SHUTSURYOKUJUN = new RString("【出力順】");
    private static final RString なし = new RString("なし");
    private static final ReportId ID = new ReportId("DBD200022_FutanGendogakuNinteiShinseishoHakkoIchiran");
    private static final int STARTINDEX = 9;
    private ShinseishoHakkoProcessParameter processParamter;
    private Association association;
    private RString 導入団体コード;
    private RString 市町村名;
    @BatchWriter
    private BatchReportWriter<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> reportSourceWriter;
    private IOutputOrder order;
    private RString 出力順;
    private int i = 0;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = association.getLasdecCode_().value();
        市町村名 = association.get市町村名();
        order = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBD介護受給,
                processParamter.get帳票ID(),
                processParamter.get改頁出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(FutangendogakuNinteiShinseishoOrderKey.class, order);
        if (processParamter.is出力フラグ()) {
            出力順 = 出力順.substring(STARTINDEX, 出力順.length());
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toFutanGendogakuMybatisParameter(出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(ID.value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(FutanGendogakuNinteiShinseishoHakkoIchiranEntity entity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        FutanGendogakuNinteiShinseishoHakkoIchiranReport report = FutanGendogakuNinteiShinseishoHakkoIchiranReport
                .createReport(get帳票情報(entity), association, order, kojin, i++);
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
        RString 帳票名 = ReportIdDBD.DBD200022.getReportName();
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

    private FutanGendogakuNinteiShinseishoHakkoIchiran get帳票情報(FutanGendogakuNinteiShinseishoHakkoIchiranEntity entity) {
        FutanGendogakuNinteiShinseishoHakkoIchiran 帳票情報 = new FutanGendogakuNinteiShinseishoHakkoIchiran();
        帳票情報.setユニット型個室(entity.getユニット型個室());
        帳票情報.setユニット型順個室(entity.getユニット型順個室());
        if (!RString.isNullOrEmpty(entity.get世帯課税())) {
            帳票情報.set世帯課税(SetaiKazeiKubun.toValue(entity.get世帯課税()));
        }
        帳票情報.set住所地特例フラグ(entity.get住所地特例フラグ());
        帳票情報.set住民となった日(entity.get宛名().getTorokuIdoYMD());
        帳票情報.set入所施設コード(entity.get入所施設コード());
        帳票情報.set入所施設名(entity.get入所施設名());
        if (!RString.isNullOrEmpty(entity.get利用者負担段階())) {
            帳票情報.set利用者負担段階(RiyoshaFutanDankai.toValue(entity.get利用者負担段階()));
        }
        帳票情報.set厚労省IF識別コード(entity.get厚労省IF識別コード());
        帳票情報.set合計所得(entity.get合計所得());
        帳票情報.set多床室(entity.get多床室());
        帳票情報.set従来型特養(entity.get従来型特養());
        帳票情報.set従来型老健(entity.get従来型老健());
        if (!RString.isNullOrEmpty(entity.get旧措置())) {
            帳票情報.set旧措置(KyuSochishaKubun.toValue(entity.get旧措置()));
        }
        帳票情報.set旧措置フラグ(entity.is旧措置フラグ());
        帳票情報.set有効期限(entity.get有効期限());
        if (!RString.isNullOrEmpty(entity.get決定区分())) {
            帳票情報.set決定区分(KetteiKubun.toValue(entity.get決定区分()));
        }
        帳票情報.set決定年月日(entity.get決定年月日());
        帳票情報.set生保(entity.is生保());
        帳票情報.set申請年月日(entity.get申請年月日());
        帳票情報.set老齢(entity.is老齢());
        帳票情報.set自己作成(entity.is自己作成());
        帳票情報.set被保番号(entity.get被保険者番号());
        帳票情報.set要介護認定状態区分コード(entity.get要介護認定状態区分コード());
        帳票情報.set計画事業者コード(entity.get計画事業者コード());
        帳票情報.set計画事業者名(entity.get計画事業者名());
        帳票情報.set認定終了日(entity.get認定終了日());
        帳票情報.set認定開始日(entity.get認定開始日());
        if (!RString.isNullOrEmpty(entity.get負担段階())) {
            帳票情報.set負担段階(RiyoshaFutanDankai.toValue(entity.get負担段階()));
        }
        帳票情報.set適用日(entity.get適用日());
        帳票情報.set非課税年金勘案額(entity.get非課税年金勘案額());
        帳票情報.set食費負担額(entity.get食費負担額());
        return 帳票情報;
    }
}
