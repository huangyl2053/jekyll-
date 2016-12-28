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
import jp.co.ndensan.reams.db.dbe.business.report.iintokkitext.IinTokkiTextA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iintokkitext.IinTokkiTextA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
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
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 委員用特記事項と一次判定結果票情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 wangxiaodong
 */
public class IinTokkiJikouItiziHanteiDataSakuseiA3Process extends BatchKeyBreakBase<ItiziHanteiEntity> {

    private static final RString SELECT_NINTEIJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getTokkiJikouItiziHantei");
    private static final List<RString> PAGE_BREAK_KEYS_A3 = Collections.unmodifiableList(Arrays.asList(
            new RString(IinTokkiTextA3ReportSource.ReportSourceFields.tokkiText1.name()),
            new RString(IinTokkiTextA3ReportSource.ReportSourceFields.tokkiImg1.name())));
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IShiryoShinsakaiIinMapper mapper;
    private List<ShinsakaiSiryoKyotsuEntity> 共通情報;
    private IchijihanteikekkahyoA3Entity item;
    private int データ件数;

    @BatchWriter
    private BatchReportWriter<IinTokkiTextA3ReportSource> batchWriteA3;
    private ReportSourceWriter<IinTokkiTextA3ReportSource> reportSourceWriterA3;

    @Override
    protected void initialize() {
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        共通情報 = mapper.getShinsakaiSiryoKyotsu(myBatisParameter);
        データ件数 = mapper.getTokkiJikouItiziHanteiCount(myBatisParameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEIJOHO, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriteA3 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517085.getReportId().value())
                .addBreak(new BreakerCatalog<IinTokkiTextA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS_A3))
                .addBreak(new BreakerCatalog<IinTokkiTextA3ReportSource>().new SimpleLayoutBreaker(

                    IinTokkiTextA3ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<IinTokkiTextA3ReportSource> occuredBreak(ReportLineRecord<IinTokkiTextA3ReportSource> currentRecord,
                            ReportLineRecord<IinTokkiTextA3ReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                        int layout = currentRecord.getSource().layout;
                        currentRecord.setFormGroupIndex(layout);
                        if (nextRecord != null && nextRecord.getSource() != null) {
                            layout = nextRecord.getSource().layout;
                            nextRecord.setFormGroupIndex(layout);
                        }
                        return currentRecord;
                    }
                })
                .create();
        reportSourceWriterA3 = new ReportSourceWriter<>(batchWriteA3);
    }

    @Override
    protected void keyBreakProcess(ItiziHanteiEntity t) {
    }

    @Override
    protected void usualProcess(ItiziHanteiEntity entity) {
        item = new IchijihanteikekkahyoA3Entity();
        myBatisParameter.setShinseishoKanri(entity.getShinseishoKanriNo());
        myBatisParameter.setNinteichosaRirekiNo(entity.getNinteichosaIraiRirekiNo());
        myBatisParameter.setShinseishoKanriZ(entity.getZShinseishoKanriNo());
        myBatisParameter.setIkenshoIraiRirekiNo(entity.getIkenshoIraiRirekiNo());
        List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
        List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
        DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            予防給付サービス利用状況 = mapper.getYoboService(myBatisParameter);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
            介護給付サービス利用状況 = mapper.getKaigoService(myBatisParameter);
        } else {
            サービス状況フラグ = mapper.getServiceJokyoFlag(myBatisParameter);
        }
        List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項 = mapper.getTokkijiko(myBatisParameter);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書 = mapper.getIkenshoIkenItem(myBatisParameter);
        List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目 = mapper.getChosahyoChosaItem(myBatisParameter);
        List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目 = mapper.getZenkaiChosahyoChosaItem(myBatisParameter);
        List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.getZenkaiIkenshoIkenItem(myBatisParameter);
        List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報 = new ArrayList<>();
        if (get共通情報(共通情報, entity.getShinseishoKanriNo()) != null) {
            特記情報 = get特記情報(get共通情報(共通情報, entity.getShinseishoKanriNo()));
        }
        item = new IchijihanteikekkahyoItemSetteiA3().set項目(entity, 特記事項,
                調査票調査項目, 前回調査票調査項目, 主治医意見書,
                前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, データ件数,
                get共通情報(共通情報, entity.getShinseishoKanriNo()), 主治医意見書, new RString(paramter.getGogitaiNo()),
                特記情報, batchWriteA3.getImageFolderPath());
        item.setServiceKubunCode(entity.getServiceKubunCode());
        IinTokkiTextA3Report report = new IinTokkiTextA3Report(item);
        report.writeBy(reportSourceWriterA3);
    }

    @Override
    protected void afterExecute() {
    }

    private ShinsakaiSiryoKyotsuEntity get共通情報(List<ShinsakaiSiryoKyotsuEntity> 共通情報,
            ShinseishoKanriNo 申請書管理番号) {
        for (ShinsakaiSiryoKyotsuEntity 共通情報Entity : 共通情報) {
            if (申請書管理番号.equals(共通情報Entity.getShinseishoKanriNo())) {
                return 共通情報Entity;
            }
        }
        return null;
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        myBatisParameter.setGenponMaskKubun(GenponMaskKubun.原本.getコード());
        myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(myBatisParameter);
    }

}
