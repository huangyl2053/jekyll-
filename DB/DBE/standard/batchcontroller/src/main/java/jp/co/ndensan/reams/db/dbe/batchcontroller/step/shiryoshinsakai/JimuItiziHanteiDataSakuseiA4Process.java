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
import jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4.IchijihanteikekkahyoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ZenzenkayiJyohouEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
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
 * 事務局用一次判定結果票の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuItiziHanteiDataSakuseiA4Process extends BatchKeyBreakBase<ItiziHanteiEntity> {

    private static final RString SELECT_JIMUNINTEITIZIHANTEI = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getJimuItiziHantei");
    private static final List<RString> PAGE_BREAK_KEYS_A4 = Collections.unmodifiableList(Arrays.asList(
            new RString(IchijihanteikekkahyoA4ReportSource.ReportSourceFields.shinseiCount.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IchijihanteikekkahyoEntity item;
    private IShiryoShinsakaiIinMapper mapper;
    List<ItiziHanteiEntity> itiziHanteiEntityList;
    private JimuTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    @BatchWriter
    private BatchReportWriter<IchijihanteikekkahyoA4ReportSource> batchWriteA4;
    private ReportSourceWriter<IchijihanteikekkahyoA4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        itiziHanteiEntityList = new ArrayList<>();
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        itiziHanteiEntityList = mapper.getJimuItiziHantei(myBatisParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUNINTEITIZIHANTEI, myBatisParameter);
    }

    @Override
    protected void usualProcess(ItiziHanteiEntity entity) {
        int 申請書管理番号の個数 = mapper.getJimu申請書管理番号の個数(myBatisParameter);
        myBatisParameter.setShinseishoKanri(entity.getDbt5502_shinseishoKanriNo());
        ShinseishoKanriNo 前回申請管理番号 = mapper.getJimuZenShinseishoKanriNo(myBatisParameter);
        myBatisParameter.setShinseishoKanri(前回申請管理番号);
        ShinseishoKanriNo 前々回の申請書管理番号 = mapper.getJimuZenShinseishoKanriNo(myBatisParameter);
        myBatisParameter.setNinteichosaRirekiNo(entity.getDbT5203_ninteichosaRirekiNo());
        myBatisParameter.setGenponKubun(GenponMaskKubun.原本.getコード());
        List<NinteichosahyoTokkijikoEntity> 特記事項情報 = mapper.getJimuNinteichosahyoTokkijiko(myBatisParameter);
        myBatisParameter.setShinseishoKanri(前回申請管理番号);
        List<DbT5211NinteichosahyoChosaItemEntity> entityList = mapper.getJimu前回結果(myBatisParameter);
        DbT5116IchijiHanteiKekkaJohoEntity dbT5116Entity = mapper.getJimu前回の要介護認定一次判定結果情報(myBatisParameter);
        myBatisParameter.setShinseishoKanri(前々回の申請書管理番号);
        ZenzenkayiJyohouEntity dbT5102Entity = mapper.getJimu前々回情報(myBatisParameter);
        myBatisParameter.setShoKisaiHokenshaNo(entity.getDbt5101_shoKisaiHokenshaNo());
        DbT7051KoseiShichosonMasterEntity dbT705Entity = mapper.getJimu市町村名(myBatisParameter);
        myBatisParameter.setShichosonCode(dbT705Entity.getShichosonCode());
        myBatisParameter.setNinteichosaItakusakiCode(entity.getDbt5202_chosaItakusakiCode());
        DbT5910NinteichosaItakusakiJohoEntity dbT5910Entity = mapper.getJimu事業者名(myBatisParameter);
        myBatisParameter.setNinteiChosainCode(entity.getDbt5202_ninteiChosaKubunCode());
        DbT5913ChosainJohoEntity dbT5913Entity = mapper.getJimu調査員情報(myBatisParameter);
        myBatisParameter.setShujiiIryokikanCode(entity.getDbt5302_shujiiIryoKikanCode());
        DbT5911ShujiiIryoKikanJohoEntity dbT5911Entity = mapper.getJimu医療機関名称(myBatisParameter);
        myBatisParameter.setShujiiCode(entity.getDbt5302_shujiiCode());
        DbT5912ShujiiJohoEntity dbT5912Entity = mapper.getJimu主治医氏名(myBatisParameter);
        myBatisParameter.setShinseishoKanri(前回申請管理番号);
        List<DbT5304ShujiiIkenshoIkenItemEntity> dbT5304EntityList = mapper.getJimu前回要介護認定主治医意見書意見項目情報(myBatisParameter);
        IchijihanteikekkahyoItemSettei itemSettei = new IchijihanteikekkahyoItemSettei();
        item = itemSettei.set項目(entity, 特記事項情報, paramter, itiziHanteiEntityList,
                entityList, dbT5116Entity, dbT5102Entity, 申請書管理番号の個数);
        item = itemSettei.set事務局用項目(item, entity, dbT705Entity, dbT5910Entity, dbT5913Entity, dbT5911Entity,
                itiziHanteiEntityList, dbT5912Entity, dbT5116Entity, dbT5304EntityList);
        // TODO IchijihanteikekkahyoA4Report
        IchijihanteikekkahyoA4Entity a4Entity = new IchijihanteikekkahyoA4Entity();
        IchijihanteikekkahyoA4Report report = new IchijihanteikekkahyoA4Report(a4Entity);
        report.writeBy(reportSourceWriterA4);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517181.getReportId().value())
                .addBreak(new BreakerCatalog<IchijihanteikekkahyoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A4))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ItiziHanteiEntity t) {
        hasBrek(getBefore(), t);
    }

    private boolean hasBrek(ItiziHanteiEntity before, ItiziHanteiEntity current) {
        return before.getDbt5502_shinsakaiOrder() != current.getDbt5502_shinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        RString id = ReportIdDBE.DBE517181.getReportId().getColumnValue();
        RString 総ページ数 = new RString(batchWriteA4.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("認定情報　(事務局用）"),
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder1 = new RStringBuilder();
        builder1.append("【介護認定審査会開催番号】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiNo());
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append("【開始資料番号】")
                .append(" ")
                .append(paramter.getBangoStart());
        RStringBuilder builder3 = new RStringBuilder();
        builder3.append("【終了資料番号】")
                .append(" ")
                .append(paramter.getBangoEnd());
        list.add(builder1.toRString());
        return list;
    }
}
