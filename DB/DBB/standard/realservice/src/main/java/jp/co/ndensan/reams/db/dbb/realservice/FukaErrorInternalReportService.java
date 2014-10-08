/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItemList;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.model.FukaErrorModel;
import jp.co.ndensan.reams.db.dbb.persistence.basic.FukaErrorListDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.business.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.IInternalReportService;
import jp.co.ndensan.reams.ur.urz.realservice.internalreport.InternalReportServiceFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 賦課エラー一覧内部帳票の情報を取得するサービスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorInternalReportService {

    private final FukaErrorListDac dac;
    private final IInternalReportService service;

    private static final SubGyomuCode サブ業務コード;
    private static final RString 内部帳票ID;

    static {
        サブ業務コード = SubGyomuCode.DBB介護賦課;
        内部帳票ID = new RString("FukaErrorList");
    }

    /**
     * デフォルトコンストラクタです。
     */
    public FukaErrorInternalReportService() {
        dac = InstanceProvider.create(FukaErrorListDac.class);
        service = InternalReportServiceFactory.getInternalReportService();
    }

    /**
     * テスト用コンストラクタです。引数からモックを受け取ります。
     *
     * @param dac テスト用モックDac
     * @param reportInfoService 内部帳票情報サービス
     * @param batchInfoService 内部帳票バッチ情報サービス
     */
    FukaErrorInternalReportService(FukaErrorListDac dac, IInternalReportService service) {
        this.dac = dac;
        this.service = service;
    }

    /**
     * 直近の作成日時を指定して、賦課エラー一覧の情報を取得します。
     *
     * @return 賦課エラー一覧
     */
    public FukaErrorInternalReport getFukaErrorInternalReport() {
        RDateTime creationDateTime = service.getCreationDateTime(サブ業務コード, 内部帳票ID);
        return getFukaErrorInternalReport(creationDateTime);
    }

    /**
     * 賦課エラー一覧の内部帳票が作成された日時を指定して、賦課エラー一覧の情報を取得します。
     *
     * @param reportCreationDateTime 内部帳票作成日時
     * @return 賦課エラー一覧
     */
    public FukaErrorInternalReport getFukaErrorInternalReport(RDateTime reportCreationDateTime) {
        List<DbT2010FukaErrorListEntity> entityList = dac.select(reportCreationDateTime);

        DbT2010FukaErrorListEntity representativeEntity = getRepresentativeEntity(entityList);
        IInternalReportCommon commonInfo = getCommon(representativeEntity);

        List<FukaErrorInternalReportItem> entityToBusinessList = new ArrayList<>();
        for (DbT2010FukaErrorListEntity entity : entityList) {
            FukaErrorModel model = new FukaErrorModel(entity);
            entityToBusinessList.add(new FukaErrorInternalReportItem(model));
        }
        FukaErrorInternalReportItemList itemList = new FukaErrorInternalReportItemList(entityToBusinessList);

        return new FukaErrorInternalReport(commonInfo, itemList);
    }

    /**
     * 引数から賦課年度と通知書番号を受け取り、指定した引数に該当する賦課エラー情報を1件返します。
     *
     * @param fukaNendo 賦課年度
     * @param tsuchishoNo 通知書番号
     * @return 現在修正可能（内部帳票の処理区分が未処理である場合）はtrue
     */
    public FukaErrorInternalReportItem getFukaErrorInternalReportItem(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        DbT2010FukaErrorListEntity entity = dac.select(fukaNendo, tsuchishoNo);
        return new FukaErrorInternalReportItem(new FukaErrorModel(entity));
    }

    private DbT2010FukaErrorListEntity getRepresentativeEntity(List<DbT2010FukaErrorListEntity> entityList) {
        if (entityList.isEmpty()) {
            return null;
        }
        return entityList.get(0);
    }

    private IInternalReportCommon getCommon(DbT2010FukaErrorListEntity representativeEntity) {
        if (representativeEntity == null) {
            return null;
        }
        return service.createInternalReportCommonForReport(new FukaErrorModel(representativeEntity));
    }

    /**
     * 賦課エラー一覧と、その中の項目を1行指定して、その情報を保存します。
     *
     * @param internalReportItem 賦課エラー情報
     * @return 保存に成功したらtrue
     */
    public boolean save(FukaErrorInternalReportItem internalReportItem) {
        DbT2010FukaErrorListEntity entity = internalReportItem.toModel().getEntity();
        return dac.update(entity) == 1;
    }

    /**
     * 賦課エラー一覧と、その中の項目を一行指定して、その情報を削除します。
     *
     * @param internalReportItem 賦課エラー情報
     * @return 削除に成功したらtrue
     */
    public boolean remove(FukaErrorInternalReportItem internalReportItem) {
        DbT2010FukaErrorListEntity entity = internalReportItem.toModel().getEntity();
        return dac.delete(entity) == 1;
    }
}
