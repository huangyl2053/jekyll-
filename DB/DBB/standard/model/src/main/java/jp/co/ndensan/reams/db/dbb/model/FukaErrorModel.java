/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.model;

import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
//TODO n8235 船山洋介　InternalReportCommonMode がなくなっているためコメントアウト
//import jp.co.ndensan.reams.ur.urz.model.IInternalReportCommonModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 内部帳票である賦課エラー一覧のModelクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorModel /* implements IInternalReportCommonModel*/ {

    private DbT2010FukaErrorListEntity entity;

    /**
     * Modelのインスタンスを生成します。Modelが持つEntityには、必要最低限の初期値を設定します。
     */
    public FukaErrorModel() {
        entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setInternalReportId(RString.EMPTY);
        entity.setFukaNendo(FlexibleYear.MIN);
        entity.setTsuchishoNo(new TsuchishoNo(RString.EMPTY));
        entity.setInternalReportCreationDateTime(RDateTime.MIN);
        entity.setBatchId(RString.EMPTY);
        entity.setBatchStartingDateTime(RDateTime.MIN);
        entity.setErrorCode(Code.EMPTY);
        entity.setHihokenshaNo(HihokenshaNo.EMPTY);
        entity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        entity.setShoriKubunCode(InternalReportShoriKubun.処理無し.getCode());
    }

    /**
     * 引数から賦課エラー一覧のエンティティを受け取り、インスタンスを生成します。
     *
     * @param entity
     */
    public FukaErrorModel(DbT2010FukaErrorListEntity entity) {
        this.entity = entity;
    }

    /**
     * 永続化用の賦課エラー一覧Entityを返します。
     *
     * @return 賦課エラー一覧Entity
     */
    public DbT2010FukaErrorListEntity getEntity() {
        return entity;
    }

    /**
     * 永続化用の賦課エラー一覧Entityを設定します。
     *
     * @param entity 賦課エラー一覧Entity
     */
    public void setEntity(DbT2010FukaErrorListEntity entity) {
        this.entity = entity;
    }
//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override

    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }
//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override

    public RString get内部帳票Id() {
        return entity.getInternalReportId();
    }
//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override

    public RDateTime get内部帳票作成日時() {
        return entity.getInternalReportCreationDateTime();
    }
//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override

    public RString getバッチId() {
        return entity.getBatchId();
    }
//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override

    public RDateTime getバッチ起動日時() {
        return entity.getBatchStartingDateTime();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * エラーコードを返します。
     *
     * @return エラーコード
     */
    public Code getエラーコード() {
        return entity.getErrorCode();
    }

    /**
     * エラーコードに対応する内容を返します。
     *
     * @return エラー内容
     */
    public RString getエラー名称() {
        return entity.getErrorCodeMeisho();
    }

    /**
     * エラー内容を略した文字列を返します。
     *
     * @return エラー内容略
     */
    public RString getエラー略称() {
        return entity.getErrorCodeRyakusho();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 処理区分を返します。
     *
     * @return 処理区分
     */
    public InternalReportShoriKubun get処理区分() {
        return InternalReportShoriKubun.toValue(entity.getShoriKubunCode());
    }

//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override
    public void setサブ業務コード(SubGyomuCode サブ業務コード) {
        entity.setSubGyomuCode(サブ業務コード);
    }

//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override
    public void set内部帳票Id(RString 内部帳票Id) {
        entity.setInternalReportId(内部帳票Id);
    }

//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override
    public void set内部帳票作成日時(RDateTime 内部帳票作成日時) {
        entity.setInternalReportCreationDateTime(内部帳票作成日時);
    }

//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override
    public void setバッチId(RString バッチId) {
        entity.setBatchId(バッチId);
    }

//IInternalReportCommonModelをコメントアウトしたため、@Overrideもコメントアウト
//    @Override
    public void setバッチ起動日時(RDateTime バッチ起動日時) {
        entity.setBatchStartingDateTime(バッチ起動日時);
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FlexibleYear 賦課年度) {
        entity.setFukaNendo(賦課年度);
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     */
    public void set通知書番号(TsuchishoNo 通知書番号) {
        entity.setTsuchishoNo(通知書番号);
    }

    /**
     * エラーコードを設定します。
     *
     * @param エラーコード エラーコード
     */
    public void setエラーコード(Code エラーコード) {
        entity.setErrorCode(エラーコード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 処理区分を設定します。
     *
     * @param 処理区分 処理区分
     */
    public void set処理区分(InternalReportShoriKubun 処理区分) {
        entity.setShoriKubunCode(処理区分.getCode());
    }
}
