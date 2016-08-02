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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSetteiA3;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa3.IchijihanteikekkahyoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用一次判定結果票の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class JimuItiziHanteiDataSakuseiA3Process extends BatchKeyBreakBase<ItiziHanteiEntity> {

    private static final RString SELECT_JIMUNINTEITIZIHANTEI = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper.get事務局一次判定");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(IchijihanteikekkahyoA3ReportSource.ReportSourceFields.shinseiCount.name())));
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IchijihanteikekkahyoA3Entity item;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiSiryoKyotsuEntity> 共通情報;
    private int データ件数 = 0;
    @BatchWriter
    private BatchReportWriter<IchijihanteikekkahyoA3ReportSource> batchWriteA3;
    private ReportSourceWriter<IchijihanteikekkahyoA3ReportSource> reportSourceWriterA3;

    @Override
    protected void initialize() {
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        データ件数 = mapper.get事務局一次判定件数(myBatisParameter);
        共通情報 = mapper.get共通情報(myBatisParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_JIMUNINTEITIZIHANTEI, myBatisParameter);
    }

    @Override
    protected void usualProcess(ItiziHanteiEntity entity) {
        item = new IchijihanteikekkahyoA3Entity();

        ShinseishoKanriNo 申請書管理番号 = entity.getShinseishoKanriNo();
        ShinseishoKanriNo 前申請書管理番号 = entity.getZShinseishoKanriNo();
        int 認定調査依頼履歴番号 = entity.getNinteichosaIraiRirekiNo();
        myBatisParameter.setShinseishoKanriNo(申請書管理番号);
        myBatisParameter.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        myBatisParameter.setShinseishoKanriNoZ(前申請書管理番号);
        List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
        List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
        DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            予防給付サービス利用状況 = mapper.get予防給付(myBatisParameter);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            介護給付サービス利用状況 = mapper.get介護給付(myBatisParameter);
        } else {
            サービス状況フラグ = mapper.get状況フラグ(myBatisParameter);
        }
        List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項 = mapper.get特記事項(myBatisParameter);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書 = mapper.get主治医意見書(myBatisParameter);
        List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目 = mapper.get調査票項目(myBatisParameter);
        List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目 = mapper.get前回調査票項目(myBatisParameter);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.get前回主治医意見書(myBatisParameter);
        item.set合議体番号(myBatisParameter.getGogitaiNo());

        item = new IchijihanteikekkahyoItemSetteiA3().set項目(entity, 特記事項,
                調査票調査項目, 前回調査票調査項目, 主治医意見書,
                前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, データ件数, get共通情報(共通情報, 申請書管理番号, entity.getShinsakaiOrder()));
        IchijihanteikekkahyoA3Report report = new IchijihanteikekkahyoA3Report(item);
        report.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517085.getReportId().value())
                .addBreak(new BreakerCatalog<IchijihanteikekkahyoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    @Override
    protected void keyBreakProcess(ItiziHanteiEntity t) {
        if (hasBrek(getBefore(), t)) {
            IchijihanteikekkahyoA3Report report = new IchijihanteikekkahyoA3Report(item);
            report.writeBy(reportSourceWriterA3);
        }
    }

    private boolean hasBrek(ItiziHanteiEntity before, ItiziHanteiEntity current) {
        return before.getShinsakaiOrder() != current.getShinsakaiOrder();
    }

    @Override
    protected void afterExecute() {
    }

    private ShinsakaiSiryoKyotsuEntity get共通情報(List<ShinsakaiSiryoKyotsuEntity> 共通情報,
            ShinseishoKanriNo 申請書管理番号, int shinsakaiOrder) {
        for (ShinsakaiSiryoKyotsuEntity 共通情報Entity : 共通情報) {
            if (申請書管理番号.equals(共通情報Entity.getShinseishoKanriNo()) && shinsakaiOrder == 共通情報Entity.getShinsakaiOrder()) {
                return 共通情報Entity;
            }
        }
        return null;
    }
}
