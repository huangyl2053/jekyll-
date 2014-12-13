/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護賦課減免のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class GemmenModel implements Serializable {

    private DbT2004GemmenEntity entity;

    /**
     * コンストラクタです。
     */
    public GemmenModel() {
        entity = new DbT2004GemmenEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2004GemmenEntity
     */
    public GemmenModel(DbT2004GemmenEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2004GemmenEntityを返します。
     *
     * @return DbT2004GemmenEntity
     */
    public DbT2004GemmenEntity getEntity() {
        return entity;
    }

    /**
     * DbT2004GemmenEntityを設定します。
     *
     * @param entity DbT2004GemmenEntity
     */
    public void setEntity(DbT2004GemmenEntity entity) {
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
     * 減免申請年月日を返します。
     *
     * @return 減免申請年月日
     */
    public FlexibleDate get減免申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 減免決定年月日を返します。
     *
     * @return 減免決定年月日
     */
    public FlexibleDate get減免決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 減免取消年月日を返します。
     *
     * @return 減免取消年月日
     */
    public FlexibleDate get減免取消年月日() {
        return entity.getTorikeshiYMD();
    }

    /**
     * 減免状態区分を返します。
     *
     * @return 減免状態区分
     */
    public RString get減免状態区分() {
        return entity.getJotaiKubun();
    }

    /**
     * 減免作成区分を返します。
     *
     * @return 減免作成区分
     */
    public RString get減免作成区分() {
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
     * 減免事由ｺｰﾄﾞを返します。
     *
     * @return 減免事由ｺｰﾄﾞ
     */
    public Code get減免事由ｺｰﾄﾞ() {
        return entity.getGemmenJiyuCode();
    }

    /**
     * 減免事由を返します。
     *
     * @return 減免事由
     */
    public RString get減免事由() {
        return entity.getGemmenJiyu();
    }

    /**
     * 減免取消事由ｺｰﾄﾞを返します。
     *
     * @return 減免取消事由ｺｰﾄﾞ
     */
    public Code get減免取消事由ｺｰﾄﾞ() {
        return entity.getGemmenTorikeshiJiyuCode();
    }

    /**
     * 減免取消事由を返します。
     *
     * @return 減免取消事由
     */
    public RString get減免取消事由() {
        return entity.getGemmenTorikeshiJiyu();
    }

    /**
     * 申請減免額を返します。
     *
     * @return 申請減免額
     */
    public Decimal get申請減免額() {
        return entity.getShinseiGemmenGaku();
    }

    /**
     * 決定減免額を返します。
     *
     * @return 決定減免額
     */
    public Decimal get決定減免額() {
        return entity.getKetteiGemmenGaku();
    }

    /**
     * 取消減免額を返します。
     *
     * @return 取消減免額
     */
    public Decimal get取消減免額() {
        return entity.getTorikeshiGemmenGaku();
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
     * 減免申請年月日を設定します。
     *
     * @param 減免申請年月日 減免申請年月日
     */
    public void set減免申請年月日(FlexibleDate 減免申請年月日) {
        requireNonNull(減免申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免申請年月日"));
        entity.setShinseiYMD(減免申請年月日);
    }

    /**
     * 減免決定年月日を設定します。
     *
     * @param 減免決定年月日 減免決定年月日
     */
    public void set減免決定年月日(FlexibleDate 減免決定年月日) {
        requireNonNull(減免決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免決定年月日"));
        entity.setKetteiYMD(減免決定年月日);
    }

    /**
     * 減免取消年月日を設定します。
     *
     * @param 減免取消年月日 減免取消年月日
     */
    public void set減免取消年月日(FlexibleDate 減免取消年月日) {
        requireNonNull(減免取消年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消年月日"));
        entity.setTorikeshiYMD(減免取消年月日);
    }

    /**
     * 減免状態区分を設定します。
     *
     * @param 減免状態区分 減免状態区分
     */
    public void set減免状態区分(RString 減免状態区分) {
        requireNonNull(減免状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免状態区分"));
        entity.setJotaiKubun(減免状態区分);
    }

    /**
     * 減免作成区分を設定します。
     *
     * @param 減免作成区分 減免作成区分
     */
    public void set減免作成区分(RString 減免作成区分) {
        requireNonNull(減免作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("減免作成区分"));
        entity.setSakuseiKubun(減免作成区分);
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
     * 減免事由ｺｰﾄﾞを設定します。
     *
     * @param 減免事由ｺｰﾄﾞ 減免事由ｺｰﾄﾞ
     */
    public void set減免事由ｺｰﾄﾞ(Code 減免事由ｺｰﾄﾞ) {
        requireNonNull(減免事由ｺｰﾄﾞ, UrSystemErrorMessages.値がnull.getReplacedMessage("減免事由ｺｰﾄﾞ"));
        entity.setGemmenJiyuCode(減免事由ｺｰﾄﾞ);
    }

    /**
     * 減免事由を設定します。
     *
     * @param 減免事由 減免事由
     */
    public void set減免事由(RString 減免事由) {
        requireNonNull(減免事由, UrSystemErrorMessages.値がnull.getReplacedMessage("減免事由"));
        entity.setGemmenJiyu(減免事由);
    }

    /**
     * 減免取消事由ｺｰﾄﾞを設定します。
     *
     * @param 減免取消事由ｺｰﾄﾞ 減免取消事由ｺｰﾄﾞ
     */
    public void set減免取消事由ｺｰﾄﾞ(Code 減免取消事由ｺｰﾄﾞ) {
        requireNonNull(減免取消事由ｺｰﾄﾞ, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消事由ｺｰﾄﾞ"));
        entity.setGemmenTorikeshiJiyuCode(減免取消事由ｺｰﾄﾞ);
    }

    /**
     * 減免取消事由を設定します。
     *
     * @param 減免取消事由 減免取消事由
     */
    public void set減免取消事由(RString 減免取消事由) {
        requireNonNull(減免取消事由, UrSystemErrorMessages.値がnull.getReplacedMessage("減免取消事由"));
        entity.setGemmenTorikeshiJiyu(減免取消事由);
    }

    /**
     * 申請減免額を設定します。
     *
     * @param 申請減免額 申請減免額
     */
    public void set申請減免額(Decimal 申請減免額) {
        requireNonNull(申請減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("申請減免額"));
        entity.setShinseiGemmenGaku(申請減免額);
    }

    /**
     * 決定減免額を設定します。
     *
     * @param 決定減免額 決定減免額
     */
    public void set決定減免額(Decimal 決定減免額) {
        requireNonNull(決定減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("決定減免額"));
        entity.setKetteiGemmenGaku(決定減免額);
    }

    /**
     * 取消減免額を設定します。
     *
     * @param 取消減免額 取消減免額
     */
    public void set取消減免額(Decimal 取消減免額) {
        requireNonNull(取消減免額, UrSystemErrorMessages.値がnull.getReplacedMessage("取消減免額"));
        entity.setTorikeshiGemmenGaku(取消減免額);
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
