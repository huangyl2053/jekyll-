/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReportItem;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.mapper.FukaErrorListMapper;
import jp.co.ndensan.reams.db.dbb.persistence.basic.FukaErrorListDac;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.IInternalReportBatchInfoService;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.IInternalReportInfoService;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.InternalReportServiceFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課エラー一覧内部帳票の情報を取得するサービスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorReportService {

    private final FukaErrorListDac dac;
    private final IInternalReportInfoService reportInfoService;
    private final IInternalReportBatchInfoService batchInfoService;

    /**
     * デフォルトコンストラクタです。
     */
    public FukaErrorReportService() {
        dac = InstanceProvider.create(FukaErrorListDac.class);
        reportInfoService = InternalReportServiceFactory.getInternalReportInfoService();
        batchInfoService = InternalReportServiceFactory.getInternalReportBatchInfoService();
    }

    /**
     * テスト用コンストラクタです。引数からモックを受け取ります。
     *
     * @param dac テスト用モックDac
     * @param reportInfoService 内部帳票情報サービス
     * @param batchInfoService 内部帳票バッチ情報サービス
     */
    FukaErrorReportService(FukaErrorListDac dac, IInternalReportInfoService reportInfoService,
            IInternalReportBatchInfoService batchInfoService) {
        this.dac = dac;
        this.reportInfoService = reportInfoService;
        this.batchInfoService = batchInfoService;
    }

    /**
     * 賦課エラー一覧の内部帳票が作成された日時を指定して、賦課エラー一覧の情報を取得します。
     *
     * @param reportCreationDateTime 内部帳票作成日時
     * @return 賦課エラー一覧
     */
    public FukaErrorReport getFukaErrorReport(RDateTime reportCreationDateTime) {
        List<DbT2010FukaErrorListEntity> entityList = dac.select(reportCreationDateTime);

        DbT2010FukaErrorListEntity representativeEntity = entityList.get(0);
        InternalReportInfo reportInfo = getReportInfo(representativeEntity);
        InternalReportBatchInfo batchInfo = getBatchInfo(representativeEntity);

        return FukaErrorListMapper.toFukaErrorReport(representativeEntity.getSubGyomuCode(), reportInfo, batchInfo, entityList);
    }

    /**
     * 引数から賦課年度と通知書番号を受け取り、指定した引数に該当する賦課エラーの情報が、現在修正可能か否かを返します。
     *
     * @param fukaNendo 賦課年度
     * @param tsuchishoNo 通知書番号
     * @return 現在修正可能（内部帳票の処理区分が未処理である場合）はtrue
     */
    public boolean canErrorShusei(RYear fukaNendo, RString tsuchishoNo) {
        DbT2010FukaErrorListEntity entity = dac.select(fukaNendo, tsuchishoNo);
        FukaErrorReportItem reportItem = FukaErrorListMapper.toFukaErrorReportItem(entity);

        return reportItem.getShoriKubun().equals(InternalReportShoriKubun.未処理);
    }

    private InternalReportInfo getReportInfo(DbT2010FukaErrorListEntity representativeEntity) {
        return reportInfoService.getInternalReportInfo(representativeEntity.getSubGyomuCode(),
                representativeEntity.getInternalReportId(), representativeEntity.getListCreationDateTime());
    }

    private InternalReportBatchInfo getBatchInfo(DbT2010FukaErrorListEntity representativeEntity) {
        return batchInfoService.getInternalReportBatchInfo(representativeEntity.getSubGyomuCode(),
                representativeEntity.getBatchId(), representativeEntity.getBatchStartingDateTime());
    }

    /**
     * 賦課エラー一覧と、その中の項目を一行指定して、その情報を削除します。
     *
     * @param fukaErrorReport 賦課エラー一覧
     * @param fukaErrorReportItem 賦課エラー一覧の中の一行
     * @return 削除に成功したらtrue
     */
    public boolean remove(FukaErrorReport fukaErrorReport, FukaErrorReportItem fukaErrorReportItem) {
        DbT2010FukaErrorListEntity entity = FukaErrorListMapper.toFukaErrorListEntity(fukaErrorReport, fukaErrorReportItem);
        return dac.delete(entity) == 1;
    }
}
