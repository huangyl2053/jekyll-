/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE592001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.itakusakichosainichiran.ItakusakiChosainIchiranHead;
import jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran.ItakusakiChosainIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.JyoukyouType;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.NarabiJunType;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.NextPageType;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itakusakichosainichiran.ItakusakiChosainIchiranQueryProcessParemeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.itakusakichosainichiran.ItakusakiChosainIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;

/**
 *
 * 調査員一覧情報の取得バッチクラスです。
 *
 * @reamsid_L DBE-0290-030 dongyabin
 */
public class ItakusakiChosainIchiranQueryProcess extends BatchKeyBreakBase<ItakusakiChosainIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.itakusakichosainichiran."
                    + "IItakusakiChosainIchiranMapper.getNinteiChoSain");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE592001.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ItakusakiChosainIchiranReportSource.ReportSourceFields.listIchiranhyoUpper_1.name())));
    private ItakusakiChosainIchiranQueryProcessParemeter paramter;
    @BatchWriter
    private BatchReportWriter<ItakusakiChosainIchiranReportSource> batchWrite;
    private ReportSourceWriter<ItakusakiChosainIchiranReportSource> retortWrite;
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static final RString 市町村コード = new RString("【市町村コード】");
    private static final RString 市町村名 = new RString("【市町村名】");
    private static final RString 委託先コードFROM = new RString("【委託先コードFrom】");
    private static final RString 委託先コードTO = new RString("【委託先コードTo】");
    private static final RString 調査員コードFrom = new RString("【調査員コードFrom】");
    private static final RString 調査員コードTo = new RString("【調査員コードTo】");
    private static final RString 状況 = new RString("【状況】");
    private static final RString 並び順 = new RString("【並び順】");
    private static final RString 改頁 = new RString("【改頁】");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParameter());
    }

    @Override
    protected void createWriter() {
        if (NextPageType.なし.code().equals(paramter.getNextPage())) {
            batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        } else {
            batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                    .addBreak(new BreakerCatalog<ItakusakiChosainIchiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                    .create();
        }
        retortWrite = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
    }

    private ItakusakiChosainIchiranHead setBodyItemm(ItakusakiChosainIchiranRelateEntity entity) {
        RString dDbT5910_YubinNo = RString.EMPTY;
        RString dbT5910_TelNo = RString.EMPTY;
        if (entity.getDbT5910_YubinNo() != null) {
            dDbT5910_YubinNo = entity.getDbT5910_YubinNo().value();
        }
        if (entity.getDbT5910_TelNo() != null) {
            dbT5910_TelNo = entity.getDbT5910_TelNo().value();
        }

        return new ItakusakiChosainIchiranHead(paramter.getItakusakiCodeFrom(),
                paramter.getItakusakiCodeTo(),
                paramter.getChosainNoFrom(),
                paramter.getChosainNoTo(),
                paramter.getJyoukyou(),
                entity.getDbT7051_ShichosonCode(),
                entity.getDbT7051_ShichosonMeisho(),
                paramter.getNarabiJun(),
                paramter.getNextPage(),
                entity.getDbT5910_NinteichosaItakusakiCode(),
                entity.getDbT5910_JigyoshaMeishoKana(),
                entity.getDbT5910_DaihyoshaNameKana(),
                dDbT5910_YubinNo,
                dbT5910_TelNo,
                entity.isDbT5910_JokyoFlag(),
                entity.getDbT5913_NinteiChosainNo(),
                entity.getDbT5913_ChosainKanaShimei(),
                entity.getDbT5913_ChosainShikaku(),
                entity.getDbT5913_ChosainShikaku(),
                entity.isDbT5913_JokyoFlag(),
                entity.getDbT5910_JigyoshaMeisho(),
                entity.getDbT5910_Jusho(),
                entity.getDbT5910_DaihyoshaName(),
                entity.getDbT5913_ChosainShimei(),
                entity.getDbT5913_Seibetsu(),
                entity.getDbT5913_ShozokuKikanName());
    }

    @Override
    protected void keyBreakProcess(ItakusakiChosainIchiranRelateEntity current) {
        if (hasBrek(getBefore(), current)) {
            ItakusakiChosainIchiranReport report = new ItakusakiChosainIchiranReport(setBodyItemm(current));
            report.writeBy(retortWrite);
        }
    }

    private boolean hasBrek(ItakusakiChosainIchiranRelateEntity before, ItakusakiChosainIchiranRelateEntity current) {
        return !before.getDbT5910_NinteichosaItakusakiCode().equals(current.getDbT5910_NinteichosaItakusakiCode());
    }

    @Override
    protected void usualProcess(ItakusakiChosainIchiranRelateEntity entity) {
        ItakusakiChosainIchiranReport report = new ItakusakiChosainIchiranReport(setBodyItemm(entity));
        report.writeBy(retortWrite);
    }
    
    private void set出力条件表() {
        List<RString> 出力条件 = new ArrayList();
        RStringBuilder builder = new RStringBuilder();
        builder.append(市町村コード);
        builder.append(paramter.getShichosonCode());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(市町村名);
        builder.append(paramter.getShichosonMeisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(委託先コードFROM);
        builder.append(paramter.getItakusakiCodeFrom());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(委託先コードTO);
        builder.append(paramter.getItakusakiCodeTo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(調査員コードFrom);
        builder.append(paramter.getChosainNoFrom());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(調査員コードTo);
        builder.append(paramter.getChosainNoTo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(状況);
        builder.append(JyoukyouType.toValue(paramter.getJyoukyou()).toRString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(並び順);
        builder.append(NarabiJunType.toValue(paramter.getNarabiJun()).toRString());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(改頁);
        builder.append(NextPageType.toValue(paramter.getNextPage()).toRString());
        出力条件.add(builder.toRString());

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        ReportIdDBE.DBE592001.getReportId().value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        ジョブ番号.concat(String.valueOf(JobContextHolder.getJobId())),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE592001.getReportId().value()),
                        new RString(String.valueOf(retortWrite.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
