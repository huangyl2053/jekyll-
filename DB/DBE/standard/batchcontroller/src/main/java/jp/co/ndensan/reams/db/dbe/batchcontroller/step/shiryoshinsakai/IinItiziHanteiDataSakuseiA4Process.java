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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSettei;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa4.IchijihanteikekkahyoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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
 * 委員用一次判定結果票の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinItiziHanteiDataSakuseiA4Process extends BatchKeyBreakBase<ItiziHanteiEntity> {

    private static final RString SELECT_NINTEITIZIHANTEI = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getItiziHantei");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(IchijihanteikekkahyoA4ReportSource.ReportSourceFields.shinseiCount.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IchijihanteikekkahyoA4Entity item;
    private IShiryoShinsakaiIinMapper mapper;
    @BatchWriter
    private BatchReportWriter<IchijihanteikekkahyoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<IchijihanteikekkahyoA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEITIZIHANTEI, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517181.getReportId().value())
                .addBreak(new BreakerCatalog<IchijihanteikekkahyoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ItiziHanteiEntity entity) {
        hasBrek(getBefore(), entity);
    }

    @Override
    protected void usualProcess(ItiziHanteiEntity entity) {
        IinTokkiJikouItiziHanteiMyBatisParameter parameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        parameter.setShinseishoKanri(entity.getShinseishoKanriNo());
        parameter.setNinteichosaRirekiNo(entity.getNinteichosaIraiRirekiNo());
        List<DbT5207NinteichosahyoServiceJokyoEntity> サービス利用状況 = getサービス利用状況(entity, parameter);
        DbT5208NinteichosahyoServiceJokyoFlagEntity サービスの状況フラグ = mapper.getServiceJokyoFlag(parameter);
        DbT5210NinteichosahyoShisetsuRiyoEntity 現在の状況 = mapper.getGenzaiJokyo(parameter);
        List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項情報 = mapper.getTokkijiko(parameter);
        List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目情報 = mapper.getChosahyoChosaItem(parameter);
        parameter.setIkenshoIraiRirekiNo(entity.getIkenshoIraiRirekiNo());
        List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書項目情報 = mapper.getIkenshoIkenItem(parameter);
        parameter.setShinseishoKanri(entity.getZShinseishoKanriNo());
        List<DbT5211NinteichosahyoChosaItemEntity> 前回調査項目情報 = mapper.getZenkaiChosahyoChosaItem(parameter);
        item = new IchijihanteikekkahyoItemSettei().set項目(entity, 特記事項情報, 調査票調査項目情報, 前回調査項目情報, 主治医意見書項目情報, null,
                サービス利用状況, サービス利用状況, サービスの状況フラグ, 現在の状況, new RString(paramter.getGogitaiNo()));
        IchijihanteikekkahyoA4Report report = new IchijihanteikekkahyoA4Report(item);
        report.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private List<DbT5207NinteichosahyoServiceJokyoEntity> getサービス利用状況(ItiziHanteiEntity entity,
            IinTokkiJikouItiziHanteiMyBatisParameter parameter) {
        List<DbT5207NinteichosahyoServiceJokyoEntity> サービス利用状況 = new ArrayList<>();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            サービス利用状況 = mapper.getYoboService(parameter);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            サービス利用状況 = mapper.getKaigoService(parameter);
        }
        return サービス利用状況;
    }

    private boolean hasBrek(ItiziHanteiEntity before, ItiziHanteiEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE517181.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBE.DBE517181.getReportName(),
                new RString(batchWriteA4.getPageCount()),
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
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
}
