/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaError;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReport;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReportItem;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 賦課エラー一覧内部帳票の情報をマッピングするクラスです。
 *
 * @author n8178 城間篤人
 */
public final class FukaErrorListMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private FukaErrorListMapper() {

    }

    /**
     * 賦課エラー一覧Entityを受け取り、賦課エラー一覧内部帳票の1行分の項目にマッピングします。<br/>
     * nullが渡された場合、nullが返ります。
     *
     * @param entity 賦課エラー一覧Entity
     * @return 賦課エラー一覧内部帳票の1行分の項目
     */
    public static FukaErrorReportItem toFukaErrorReportItem(DbT2010FukaErrorListEntity entity) {
        if (isNull(entity)) {
            return null;
        }

        return new FukaErrorReportItem(
                new RYear(entity.getFukaNendo().toDateString()),
                entity.getTsuchishoNo(),
                createFukaError(entity),
                entity.getHihokenshaNo(),
                entity.getShikibetsuCode(),
                InternalReportShoriKubun.toValue(entity.getShoriKubunCode()));
    }

    private static FukaError createFukaError(DbT2010FukaErrorListEntity entity) {
        return new FukaError(entity.getErrorCode(), entity.getErrorCodeMeisho(), entity.getErrorCodeRyakusho());
    }

    /**
     * 賦課エラー一覧内部帳票と、その1行分の項目を受け取り、賦課エラー一覧Entityにマッピングします。<br/>
     * 引数のいずれかにnullが渡された場合、nullが返ります。
     *
     * @param report 賦課エラー一覧内部帳票
     * @param reportItem 賦課エラー一覧内部帳票の1行分の項目
     * @return 賦課エラー一覧Entity
     */
    public static DbT2010FukaErrorListEntity toFukaErrorListEntity(FukaErrorReport report, FukaErrorReportItem reportItem) {
        if (isNull(report) || isNull(reportItem)) {
            return null;
        }

        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(report.getSubGyomuCode());
        entity.setInternalReportId(report.getInfo().getInternalReportId());
        entity.setListCreationDateTime(report.getInfo().getReportCreatingDateTime());
        entity.setBatchId(report.getBatchInfo().getBatchId());
        entity.setBatchStartingDateTime(report.getBatchInfo().getBatchStartingDateTime());
        entity.setFukaNendo(new FlexibleYear(reportItem.get賦課年度().toDateString()));
        entity.setTsuchishoNo(reportItem.get通知書番号());
        entity.setErrorCode(reportItem.getエラー内容().getCode());
        entity.setHihokenshaNo(reportItem.get被保険者番号());
        entity.setShikibetsuCode(reportItem.get識別コード());
        return entity;
    }

    /**
     * サブ業務コード、内部帳票の情報、賦課エラー一覧EntityのListを受け取り、賦課エラー一覧を表す内部帳票にマッピングします。<br/>
     * いずれかの引数にnullが渡された場合や、空のListが渡された場合、nullが返ります。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportInfo 内部帳票情報
     * @param batchInfo 内部帳票バッチ情報
     * @param entityList 賦課エラー一覧EntityList
     * @return 賦課エラー一覧内部帳票
     */
    public static FukaErrorReport toFukaErrorReport(SubGyomuCode subGyomuCode, InternalReportInfo reportInfo,
            InternalReportBatchInfo batchInfo, List<DbT2010FukaErrorListEntity> entityList) {

        if (isNull(subGyomuCode) || isNull(reportInfo) || isNull(batchInfo) || isNull(entityList) || entityList.isEmpty()) {
            return null;
        }

        List<FukaErrorReportItem> fukaErrorReportItemList = new ArrayList<>();
        for (DbT2010FukaErrorListEntity entity : entityList) {
            fukaErrorReportItemList.add(toFukaErrorReportItem(entity));
        }

        return new FukaErrorReport(subGyomuCode, reportInfo, batchInfo, fukaErrorReportItemList);
    }

    /**
     * 賦課エラー一覧を表す内部帳票を受け取り、賦課エラー一覧EntityのListにマッピングします。<br/>
     * 賦課エラー一覧内部帳票にnullが渡される、もしくは賦課エラー一覧内部帳票の項目数が0の場合、空のListが返ります。
     *
     * @param report 賦課エラー一覧内部帳票
     * @return 賦課エラー一覧EntityList
     */
    public static List<DbT2010FukaErrorListEntity> toFukaErrorListEntityList(FukaErrorReport report) {
        if (isNull(report) || report.getItemList().isEmpty()) {
            return Collections.<DbT2010FukaErrorListEntity>emptyList();
        }

        List<DbT2010FukaErrorListEntity> entityList = new ArrayList<>();
        for (FukaErrorReportItem reportItem : report.getItemList()) {
            entityList.add(toFukaErrorListEntity(report, reportItem));
        }
        return entityList;
    }

    private static boolean isNull(Object obj) {
        return obj == null;
    }
}
