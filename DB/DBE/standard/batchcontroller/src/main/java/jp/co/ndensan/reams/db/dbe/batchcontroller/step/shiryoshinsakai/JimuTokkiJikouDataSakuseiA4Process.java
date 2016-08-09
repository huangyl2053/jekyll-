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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitexta4.TokkiText1A4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4.TokkiText1A4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局特記事項の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuTokkiJikouDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_SHINSAKAISIRYOKYOTSU = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.get共通情報");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(TokkiText1A4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final int 最大表示行数 = 15;
    private IinShinsakaiIinJohoProcessParameter paramter;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private int ページ表示行数;

    @BatchWriter
    private BatchReportWriter<TokkiText1A4ReportSource> batchWriteA4;
    private ReportSourceWriter<TokkiText1A4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517141.getReportId().value())
                .addBreak(new BreakerCatalog<TokkiText1A4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity current) {
        if (hasBrek(getBefore(), current)) {
            ページ表示行数 = 0;
        }
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity kyotsuEntity) {
        kyotsuEntity.setJimukyoku(true);
        List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List = get特記情報(kyotsuEntity);
        TokkiText1A4Business business = new TokkiText1A4Business(false, 1, kyotsuEntity, 特記情報List);
        TokkiText1A4Report report = new TokkiText1A4Report(business);
        report.writeBy(reportSourceWriterA4);
        ページ表示行数 = business.getページ表示行数();
    }

    @Override
    protected void afterExecute() {
        出力条件表(ReportIdDBE.DBE517141.getReportId().value(), new RString("概況調査の特記"));
        出力条件表(ReportIdDBE.DBE517131.getReportId().value(), new RString("特記事項（1枚目）"));
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        myBatisParameter.setGenponMaskKubun(GenponMaskKubun.原本.getコード());
        myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.get事務局特記情報(myBatisParameter);
    }

    private boolean hasBrek(ShinsakaiSiryoKyotsuEntity before, ShinsakaiSiryoKyotsuEntity current) {
        return !(before.getShinsakaiOrder() == current.getShinsakaiOrder()) || ページ表示行数 % 最大表示行数 == 0;
    }

    private void 出力条件表(RString 帳票, RString 帳票名) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                帳票,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                帳票名,
                new RString(reportSourceWriterA4.pageCount().value()),
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("合議体番号"), new RString(paramter.getGogitaiNo())));
        出力条件.add(条件(new RString("介護認定審査会開催予定年月日"), paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString()));
        出力条件.add(条件(new RString("介護認定審査会開催番号"), paramter.getShinsakaiKaisaiNo()));
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

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINSAKAISIRYOKYOTSU, myBatisParameter);
    }
}
