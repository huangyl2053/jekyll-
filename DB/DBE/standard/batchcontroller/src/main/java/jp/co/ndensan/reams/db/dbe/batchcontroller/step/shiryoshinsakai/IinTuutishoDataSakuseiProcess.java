/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTuutishoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.PsmJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinCodeEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 審査会資料一括作成（委員）の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTuutishoDataSakuseiProcess extends BatchKeyBreakBase<ShinsakaiIinCodeEntity> {

    private static final RString SELECT_IINCODE = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiIinCode");
    private IinTuutishoProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinTuutishoMyBatisParameter myBatisParameter;
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(ShinsakaiKaisaiOshiraseTsuchiReportSource.ReportSourceFields.gogitaiNo.name())));
    private ShinsakaiKaisaiOshiraseTsuchiItem item;
    @BatchWriter
    private BatchReportWriter<ShinsakaiKaisaiOshiraseTsuchiReportSource> batchWrite;
    private ReportSourceWriter<ShinsakaiKaisaiOshiraseTsuchiReportSource> reportSourceWriter;
    private static final int パターン番号 = 1;
    private static final int 項目番号 = 3;

    @Override
    protected void initialize() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toIinTuutishoMyBatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_IINCODE, myBatisParameter);
    }

    @Override
    protected void usualProcess(ShinsakaiIinCodeEntity entity) {
        myBatisParameter.setShinsakaiIinCode(entity.getShinsakaiIinCode());
        List<ShinsakaiYoteiJohoEntity> 委員情報 = mapper.getShinsakaiYoteiJoho(myBatisParameter);
        DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity dbT5595Entity = mapper.get宛先情報(myBatisParameter);
        PsmJohoEntity psmJohoEntity = new PsmJohoEntity();
        if (dbT5595Entity != null) {
            if (!RString.isNullOrEmpty(dbT5595Entity.getShujiiCode())) {
                myBatisParameter.setShujiiIryokikanCode(dbT5595Entity.getShujiiIryokikanCode());
                myBatisParameter.setShujiiCode(dbT5595Entity.getShujiiCode());
                myBatisParameter.setShoKisaiHokenshaNo(dbT5595Entity.getShoKisaiHokenshaNo());
                psmJohoEntity = mapper.get主治医宛名情報(myBatisParameter);
            } else if (!RString.isNullOrEmpty(dbT5595Entity.getNinteiChosainNo())) {
                myBatisParameter.setNinteiChosaItakusakiCode(dbT5595Entity.getNinteichosaItakusakiCode());
                myBatisParameter.setNinteiChosainCode(dbT5595Entity.getNinteiChosainNo());
                myBatisParameter.setShoKisaiHokenshaNo(dbT5595Entity.getShoKisaiHokenshaNo());
                psmJohoEntity = mapper.get認定調査員宛名情報(myBatisParameter);
            } else if (!RString.isNullOrEmpty(dbT5595Entity.getSonotaKikanCode())) {
                myBatisParameter.setSonotaKikanCode(dbT5595Entity.getSonotaKikanCode());
                myBatisParameter.setShoKisaiHokenshaNo(dbT5595Entity.getShoKisaiHokenshaNo());
                psmJohoEntity = mapper.getその他宛名情報(myBatisParameter);
            }
        }
        for (ShinsakaiYoteiJohoEntity 情報 : 委員情報) {
            item = new ShinsakaiKaisaiOshiraseTsuchiItem();
            通知文設定(情報, psmJohoEntity);
            ShinsakaiKaisaiOshiraseTsuchiReport report = new ShinsakaiKaisaiOshiraseTsuchiReport(item);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE515001.getReportId().value())
                .addBreak(new BreakerCatalog<ShinsakaiKaisaiOshiraseTsuchiReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void 通知文設定(ShinsakaiYoteiJohoEntity 委員情報, PsmJohoEntity psmJohoEntity) {
        FlexibleDate 基準日 = new FlexibleDate(RDate.getNowDate().toDateString());
        NinshoshaSource 認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE515001.getReportId(),
                基準日, NinshoshaDenshikoinshubetsuCode.認定用印, reportSourceWriter);
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE515001.getReportId(), 基準日);
        RDate 発行日 = RDate.getNowDate();
        item.set電子公印(認証者情報.denshiKoin);
        item.set電子公印文字列(認証者情報.koinMojiretsu);
        item.set電子公印省略(認証者情報.koinShoryaku);
        item.set認証者氏名公印掛けない(認証者情報.ninshoshaShimeiKakenai);
        item.set認証者氏名公印掛ける(認証者情報.ninshoshaShimeiKakeru);
        item.set認証者役職名(認証者情報.ninshoshaYakushokuMei);
        item.set認証者役職名1行目(認証者情報.ninshoshaYakushokuMei1);
        item.set認証者役職名2行目(認証者情報.ninshoshaYakushokuMei2);
        item.set帳票名(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会開催のお知らせ, 発行日, SubGyomuCode.DBE認定支援));
        item.set文書番号(文書番号);
        item.setページ番号(RString.EMPTY);
        item.setカスタマーバーコード(ReportUtil.getCustomerBarCode(psmJohoEntity.getYubinNo(), psmJohoEntity.getJusho()));
        item.set宛名郵便番号(psmJohoEntity.getYubinNo());
        item.set宛名住所(psmJohoEntity.getJusho());
        item.set宛名機関名(psmJohoEntity.getKikanMeisho());
        item.set宛名名称付与(DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称, 発行日, SubGyomuCode.DBE認定支援));
        item.set発行日(発行日);
        item.set通知文1(ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE515001.getReportId(), KamokuCode.EMPTY, パターン番号).get(パターン番号));
        item.set通知文2(ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE515001.getReportId(), KamokuCode.EMPTY, パターン番号).get(2));
        item.set開催予定年月日(paramter.getShinsakaiKaisaiYoteiYMD());
        item.set予定時刻(paramter.getShinsakaiKaishiYoteiTime());
        item.set開催会場(paramter.getShinsakaiKaisaiBashoName());
        item.set合議体(new RString(paramter.getGogitaiNo()));
        if (委員情報 != null) {
            if (委員情報.getShinsakaiIinShimei() != null && !委員情報.getShinsakaiIinShimei().isEmpty()) {
                item.set宛名氏名(委員情報.getShinsakaiIinShimei().getColumnValue());
            }
            item.set開催番号(委員情報.getShinsakaiKaisaiNo());
            item.set開催日(委員情報.getShinsakaiKaisaiYoteiYMD());
            item.set開催時刻(委員情報.getShinsakaiKaishiYoteiTime());
            item.set合議体番号(new RString(委員情報.getGogitaiNo()));
            item.set会場(委員情報.getShinsakaiKaisaiBashoName());
            item.set住所(委員情報.getShinsakaiKaisaiBashoJusho());
            if (委員情報.getShinsakaiKaisaiBashoTelNo() != null && !委員情報.getShinsakaiKaisaiBashoTelNo().isEmpty()) {
                item.set電話番号(委員情報.getShinsakaiKaisaiBashoTelNo().getColumnValue());
            }
        }
        item.set通知文3(ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE515001.getReportId(), KamokuCode.EMPTY, パターン番号).get(項目番号));
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE515001.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("介護認定審査会開催のお知らせ"),
                new RString("1"),
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    @Override
    protected void keyBreakProcess(ShinsakaiIinCodeEntity current) {
        hasBrek(getBefore(), current);
    }

    private boolean hasBrek(ShinsakaiIinCodeEntity before, ShinsakaiIinCodeEntity current) {
        return !before.getShinsakaiIinCode().equals(current.getShinsakaiIinCode());
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【介護認定審査会開催番号】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiNo());
        list.add(builder.toRString());
        return list;
    }
}
