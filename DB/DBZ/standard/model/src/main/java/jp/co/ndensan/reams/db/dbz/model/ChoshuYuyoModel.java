/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課徴収猶予のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class ChoshuYuyoModel implements Serializable {

    private DbT2006ChoshuYuyoEntity entity;

    /**
     * コンストラクタです。
     */
    public ChoshuYuyoModel() {
        entity = new DbT2006ChoshuYuyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2006ChoshuYuyoEntity
     */
    public ChoshuYuyoModel(DbT2006ChoshuYuyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2006ChoshuYuyoEntityを返します。
     *
     * @return DbT2006ChoshuYuyoEntity
     */
    public DbT2006ChoshuYuyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT2006ChoshuYuyoEntityを設定します。
     *
     * @param entity DbT2006ChoshuYuyoEntity
     */
    public void setEntity(DbT2006ChoshuYuyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public RDateTime get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 徴収猶予申請年月日を返します。
     *
     * @return 徴収猶予申請年月日
     */
    public FlexibleDate get徴収猶予申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 徴収猶予決定年月日を返します。
     *
     * @return 徴収猶予決定年月日
     */
    public FlexibleDate get徴収猶予決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 徴収猶予取消年月日を返します。
     *
     * @return 徴収猶予取消年月日
     */
    public FlexibleDate get徴収猶予取消年月日() {
        return entity.getTorikeshiYMD();
    }

    /**
     * 徴収猶予状態区分を返します。
     *
     * @return 徴収猶予状態区分
     */
    public RString get徴収猶予状態区分() {
        return entity.getJotaiKubun();
    }

    /**
     * 徴収猶予作成区分を返します。
     *
     * @return 徴収猶予作成区分
     */
    public RString get徴収猶予作成区分() {
        return entity.getSakuseiKubun();
    }

    /**
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 徴収猶予事由ｺｰﾄﾞを返します。
     *
     * @return 徴収猶予事由ｺｰﾄﾞ
     */
    public Code get徴収猶予事由ｺｰﾄﾞ() {
        return entity.getYuyoJiyuCode();
    }

    /**
     * 徴収猶予事由を返します。
     *
     * @return 徴収猶予事由
     */
    public RString get徴収猶予事由() {
        return entity.getYuyoJiyu();
    }

    /**
     * 徴収猶予取消事由ｺｰﾄﾞを返します。
     *
     * @return 徴収猶予取消事由ｺｰﾄﾞ
     */
    public Code get徴収猶予取消事由ｺｰﾄﾞ() {
        return entity.getYuyoTorikeshiJiyuCode();
    }

    /**
     * 徴収猶予取消事由を返します。
     *
     * @return 徴収猶予取消事由
     */
    public RString get徴収猶予取消事由() {
        return entity.getYuyoTorikeshiJiyu();
    }

    /**
     * 調定年度を設定します。
     *
     * @param 調定年度 調定年度
     */
    public void set調定年度(FlexibleYear 調定年度) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        entity.setChoteiNendo(調定年度);
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     */
    public void set通知書番号(TsuchishoNo 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(RDateTime 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 徴収猶予申請年月日を設定します。
     *
     * @param 徴収猶予申請年月日 徴収猶予申請年月日
     */
    public void set徴収猶予申請年月日(FlexibleDate 徴収猶予申請年月日) {
        requireNonNull(徴収猶予申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予申請年月日"));
        entity.setShinseiYMD(徴収猶予申請年月日);
    }

    /**
     * 徴収猶予決定年月日を設定します。
     *
     * @param 徴収猶予決定年月日 徴収猶予決定年月日
     */
    public void set徴収猶予決定年月日(FlexibleDate 徴収猶予決定年月日) {
        requireNonNull(徴収猶予決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予決定年月日"));
        entity.setKetteiYMD(徴収猶予決定年月日);
    }

    /**
     * 徴収猶予取消年月日を設定します。
     *
     * @param 徴収猶予取消年月日 徴収猶予取消年月日
     */
    public void set徴収猶予取消年月日(FlexibleDate 徴収猶予取消年月日) {
        requireNonNull(徴収猶予取消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消年月日"));
        entity.setTorikeshiYMD(徴収猶予取消年月日);
    }

    /**
     * 徴収猶予状態区分を設定します。
     *
     * @param 徴収猶予状態区分 徴収猶予状態区分
     */
    public void set徴収猶予状態区分(RString 徴収猶予状態区分) {
        requireNonNull(徴収猶予状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予状態区分"));
        entity.setJotaiKubun(徴収猶予状態区分);
    }

    /**
     * 徴収猶予作成区分を設定します。
     *
     * @param 徴収猶予作成区分 徴収猶予作成区分
     */
    public void set徴収猶予作成区分(RString 徴収猶予作成区分) {
        requireNonNull(徴収猶予作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予作成区分"));
        entity.setSakuseiKubun(徴収猶予作成区分);
    }

    /**
     * 申請事由を設定します。
     *
     * @param 申請事由 申請事由
     */
    public void set申請事由(RString 申請事由) {
        requireNonNull(申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("申請事由"));
        entity.setShinseiJiyu(申請事由);
    }

    /**
     * 徴収猶予事由ｺｰﾄﾞを設定します。
     *
     * @param 徴収猶予事由ｺｰﾄﾞ 徴収猶予事由ｺｰﾄﾞ
     */
    public void set徴収猶予事由ｺｰﾄﾞ(Code 徴収猶予事由ｺｰﾄﾞ) {
        requireNonNull(徴収猶予事由ｺｰﾄﾞ, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予事由ｺｰﾄﾞ"));
        entity.setYuyoJiyuCode(徴収猶予事由ｺｰﾄﾞ);
    }

    /**
     * 徴収猶予事由を設定します。
     *
     * @param 徴収猶予事由 徴収猶予事由
     */
    public void set徴収猶予事由(RString 徴収猶予事由) {
        requireNonNull(徴収猶予事由, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予事由"));
        entity.setYuyoJiyu(徴収猶予事由);
    }

    /**
     * 徴収猶予取消事由ｺｰﾄﾞを設定します。
     *
     * @param 徴収猶予取消事由ｺｰﾄﾞ 徴収猶予取消事由ｺｰﾄﾞ
     */
    public void set徴収猶予取消事由ｺｰﾄﾞ(Code 徴収猶予取消事由ｺｰﾄﾞ) {
        requireNonNull(徴収猶予取消事由ｺｰﾄﾞ, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消事由ｺｰﾄﾞ"));
        entity.setYuyoTorikeshiJiyuCode(徴収猶予取消事由ｺｰﾄﾞ);
    }

    /**
     * 徴収猶予取消事由を設定します。
     *
     * @param 徴収猶予取消事由 徴収猶予取消事由
     */
    public void set徴収猶予取消事由(RString 徴収猶予取消事由) {
        requireNonNull(徴収猶予取消事由, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予取消事由"));
        entity.setYuyoTorikeshiJiyu(徴収猶予取消事由);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
