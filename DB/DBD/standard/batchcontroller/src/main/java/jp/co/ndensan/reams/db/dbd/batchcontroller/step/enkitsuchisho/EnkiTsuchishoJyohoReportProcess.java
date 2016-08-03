/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.enkitsuchisho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.report.dbd522001.YokaigoNinteiEnkiTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.YokaigoNinteiEnkiTshuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522001.YokaigoNinteiEnkiTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 延期通知書情報の作成_process処理クラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public class EnkiTsuchishoJyohoReportProcess extends BatchProcessBase<YokaigoNinteiEnkiTshuchishoEntity> {

    private static final ReportId REPORT_DBD522001 = ReportIdDBD.DBD522001.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.enkitsuchisho."
                    + "IEnkiTsuchishoMapper.selectBy申請書管理番号リスト");

    @BatchWriter
    private BatchReportWriter<YokaigoNinteiEnkiTshuchishoReportSource> batchReportWriter;
    private ReportSourceWriter<YokaigoNinteiEnkiTshuchishoReportSource> reportSourceWriter;
    private EnkiTsuchishohakenIchiranhyoJyohoProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbT4101TableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toEnkiTsuchishoJyohoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD522001.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
        dbT4101TableWriter = new BatchPermanentTableWriter<>(DbT4101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    @Override
    protected void process(YokaigoNinteiEnkiTshuchishoEntity entity) {
        if (entity == null) {
        } else {
            YokaigoNinteiEnkiTshuchishoReport report = new YokaigoNinteiEnkiTshuchishoReport(entity);
            //TODO 送付物宛先情報の取得
            entity.set文書番号(ReportUtil.get文書番号(SubGyomuCode.DBD介護受給, REPORT_DBD522001, parameter.get通知書発行日()));
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                    SubGyomuCode.DBD介護受給,
                    REPORT_DBD522001,
                    parameter.get通知書発行日(),
                    NinshoshaDenshikoinshubetsuCode.toValue(NinshoshaDenshikoinshubetsuCode.保険者印.getコード()),
                    reportSourceWriter);
            entity.set電子公印(ninshoshaSource.denshiKoin);
            entity.set発行日(ninshoshaSource.hakkoYMD);
            entity.set認証者役職名(ninshoshaSource.ninshoshaYakushokuMei);
            entity.set認証者役職名1(ninshoshaSource.ninshoshaYakushokuMei1);
            entity.set認証者役職名2(ninshoshaSource.ninshoshaYakushokuMei2);
            entity.set認証者氏名公印に掛けない(ninshoshaSource.ninshoshaShimeiKakenai);
            entity.set認証者氏名公印に掛ける(ninshoshaSource.ninshoshaShimeiKakeru);
            entity.set公印省略(ninshoshaSource.koinShoryaku);
            entity.set公印文字列(ninshoshaSource.koinMojiretsu);
            Map<Integer, RString> map = ReportUtil.get通知文(
                    SubGyomuCode.DBD介護受給,
                    REPORT_DBD522001,
                    KamokuCode.EMPTY,
                    1);
            entity.set通知文1(map.get(1));
            entity.set通知文2(map.get(2));
            map = ReportUtil.get通知文(
                    SubGyomuCode.DBD介護受給,
                    REPORT_DBD522001,
                    KamokuCode.EMPTY,
                    2);
            entity.setフフォント大(map.get(2));
            map = ReportUtil.get通知文(
                    SubGyomuCode.DBD介護受給,
                    REPORT_DBD522001,
                    KamokuCode.EMPTY,
                    3);
            entity.setフォント混在_1(map.get(2));
            entity.setフォント混在_2(map.get(3));
            map = ReportUtil.get通知文(
                    SubGyomuCode.DBD介護受給,
                    REPORT_DBD522001,
                    KamokuCode.EMPTY,
                    4);
            entity.setフォント混在2_1(map.get(2));
            entity.setフォント混在2_2(map.get(3));
            report.writeBy(reportSourceWriter);

            entity.getEntity().setEnkiTsuchiHakkoYMD(parameter.get通知書発行日());
            entity.getEntity().setEnkiTsuchiHakkoKaisu(entity.getEntity().getEnkiTsuchiHakkoKaisu() + 1);
            dbT4101TableWriter.update(entity.getEntity());
        }
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString id = ReportIdDBD.DBD522001.getReportId().getColumnValue();
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("要介護認定延期通知書タイトル"),
                ページ数,
                new RString("無し"),
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("処理見込み日From"), parameter.get処理見込み日From().wareki().toDateString()));
        出力条件.add(条件(new RString("処理見込み日To"), parameter.get処理見込み日To().wareki().toDateString()));
        出力条件.add(条件(new RString("通知書発行日"), parameter.get通知書発行日().wareki().toDateString()));
        出力条件.add(条件(new RString("申請書管理番号リスト"), new RString("有り")));
        return 出力条件;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("【"));
        条件.append(バッチパラメータ名);
        条件.append(new RString("】"));
        条件.append(値);
        return 条件.toRString();
    }

}
