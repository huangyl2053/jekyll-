/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukaerror;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.business.fukaerror.FukaErrorListReportCommon;
import jp.co.ndensan.reams.db.dbb.business.report.FukaErrorInternalReport;
import jp.co.ndensan.reams.db.dbb.business.report.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.db.dbb.business.report.FukaErrorInternalReportItemList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.IInternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課エラー一覧を管理するクラスです。
 */
public class FukaErrorListService {

    private final DbT2010FukaErrorListDac 賦課エラー一覧dac;

    /**
     * コンストラクタです。
     */
    FukaErrorListService() {
        this.賦課エラー一覧dac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 賦課エラー一覧dac 賦課エラー一覧dac
     */
    FukaErrorListService(DbT2010FukaErrorListDac 賦課エラー一覧dac) {
        this.賦課エラー一覧dac = 賦課エラー一覧dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaErrorListService}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link FukaErrorListService}のインスタンス
     */
    public static FukaErrorListService createInstance() {
        return InstanceProvider.create(FukaErrorListService.class);
    }

    /**
     * リスト作成日時を取得します。
     *
     * @param batchID バッチID
     * @return リスト作成日時
     */
    @Transaction
    public SearchResult<DbT2010FukaErrorListEntity> getCreationDateTimeList(RString batchID) {
        List<DbT2010FukaErrorListEntity> 作成日時リスト = 賦課エラー一覧dac.select作成日時(batchID);
        if (作成日時リスト.isEmpty()) {
            return SearchResult.of(Collections.<RDateTime>emptyList(), 0, false);
        }
        return SearchResult.of(作成日時リスト, 0, false);
    }

    /**
     * 賦課エラーの情報を取得します。
     *
     * @param リスト作成日時 リスト作成日時
     * @return 賦課エラーの情報リスト
     */
    @Transaction
    public SearchResult<FukaErrorList> getFukaErrorList(RDateTime リスト作成日時) {
        List<DbT2010FukaErrorListEntity> 賦課エラー情報リスト = 賦課エラー一覧dac.select賦課エラー情報リスト(リスト作成日時);
        if (賦課エラー情報リスト.isEmpty()) {
            return SearchResult.of(Collections.<FukaErrorList>emptyList(), 0, false);
        }
        List<FukaErrorList> 賦課エラー情報 = new ArrayList<>();
        for (DbT2010FukaErrorListEntity entity : 賦課エラー情報リスト) {
            賦課エラー情報.add(new FukaErrorList(entity));
        }
        return SearchResult.of(賦課エラー情報, 0, false);
    }

    /**
     * 賦課エラーデータの状況を「処理済み」として更新します。
     *
     * @param 賦課エラー情報 賦課エラー情報
     */
    @Transaction
    public void saveAs処理済み(FukaErrorList 賦課エラー情報) {
        DbT2010FukaErrorListEntity entity = 賦課エラー情報.toEntity();
        entity.setShoriKubunCode(InternalReportShoriKubun.処理済.getCode());
        entity.setState(EntityDataState.Modified);
        賦課エラー一覧dac.save(entity);
    }

    /**
     * 賦課エラー一覧の内部帳票を取得します。
     *
     * @param reportCreationDateTime リスト作成日時
     * @return 賦課エラーの情報
     */
    public FukaErrorInternalReport getFukaErrorInternalReport(RDateTime reportCreationDateTime) {
        List<DbT2010FukaErrorListEntity> entityList = 賦課エラー一覧dac.select賦課エラー情報リスト(reportCreationDateTime);

        DbT2010FukaErrorListEntity representativeEntity = getRepresentativeEntity(entityList);
        IInternalReportCommon commonInfo = getCommon(representativeEntity);

        List<FukaErrorInternalReportItem> entityToBusinessList = new ArrayList<>();
        for (DbT2010FukaErrorListEntity entity : entityList) {
            FukaErrorList model = new FukaErrorList(entity);
            entityToBusinessList.add(new FukaErrorInternalReportItem(model));
        }
        FukaErrorInternalReportItemList itemList = new FukaErrorInternalReportItemList(entityToBusinessList);
        return new FukaErrorInternalReport(commonInfo, itemList);
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
        IInternalReportCommon common = new FukaErrorListReportCommon(representativeEntity);
        return common;
    }
}
