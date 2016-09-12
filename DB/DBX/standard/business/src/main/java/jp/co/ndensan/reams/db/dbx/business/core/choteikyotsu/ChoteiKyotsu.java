/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.choteikyotsu;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調定共通のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChoteiKyotsu implements Serializable {

    private UrT0705ChoteiKyotsuEntity entity;

    /**
     * コンストラクタです。
     */
    public ChoteiKyotsu() {
        entity = new UrT0705ChoteiKyotsuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity UrT0705ChoteiKyotsuEntity
     */
    public ChoteiKyotsu(UrT0705ChoteiKyotsuEntity entity) {
        this.entity = entity;
    }

    /**
     * UrT0705ChoteiKyotsuEntityを返します。
     *
     * @return UrT0705ChoteiKyotsuEntity
     */
    public UrT0705ChoteiKyotsuEntity getEntity() {
        return entity;
    }

    /**
     * UrT0705ChoteiKyotsuEntityを設定します。
     *
     * @param entity UrT0705ChoteiKyotsuEntity
     */
    public void setEntity(UrT0705ChoteiKyotsuEntity entity) {
        this.entity = entity;
    }

    /**
     * 調定IDを返します。
     *
     * @return 調定ID
     */
    public Long get調定ID() {
        return entity.getChoteiId();
    }

    /**
     * 収納IDを返します。
     *
     * @return 収納ID
     */
    public Long get収納ID() {
        return entity.getShunoId();
    }

    /**
     * 会計年度を返します。
     *
     * @return 会計年度
     */
    public RYear get会計年度() {
        return entity.getKaikeiNendo();
    }

    /**
     * 処理年度を返します。
     *
     * @return 処理年度
     */
    public RYear get処理年度() {
        return entity.getShoriNendo();
    }

    /**
     * 処理番号を返します。
     *
     * @return 処理番号
     */
    public int get処理番号() {
        return entity.getShoriNo();
    }

    /**
     * 更正回数を返します。
     *
     * @return 更正回数
     */
    public int get更正回数() {
        return entity.getKoseiKaisu();
    }

    /**
     * 調定事由コードを返します。
     *
     * @return 調定事由コード
     */
    public ChoteiJiyuCode get調定事由コード() {
        return new ChoteiJiyuCode(entity.getChoteiJiyuCode());
    }

    /**
     * 調定日を返します。
     *
     * @return 調定日
     */
    public RDate get調定日() {
        return entity.getChoteiYMD();
    }

    /**
     * 調定額を返します。
     *
     * @return 調定額
     */
    public Decimal get調定額() {
        return entity.getChoteigaku();
    }

    /**
     * 消費税額を返します。
     *
     * @return 消費税額
     */
    public Decimal get消費税額() {
        return entity.getShohizei();
    }

    /**
     * 納期限を返します。
     *
     * @return 納期限
     */
    public RDate get納期限() {
        return entity.getNokigenYMD();
    }

    /**
     * 法定納期限等を返します。
     *
     * @return 法定納期限等
     */
    public RDate get法定納期限等() {
        return entity.getHoteiNokigenToYMD();
    }

    /**
     * 賦課側が確定した調定かどうかを返します。
     *
     * @return 確定した調定の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is賦課側確定() {
        return entity.getFukaShoriJokyo();
    }

    /**
     * 調定IDを設定します。
     *
     * @param 調定ID 調定ID
     */
    public void set調定ID(Long 調定ID) {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        entity.setChoteiId(調定ID);
    }

    /**
     * 収納IDを設定します。
     *
     * @param 収納ID 収納ID
     */
    public void set収納ID(Long 収納ID) {
        requireNonNull(収納ID, UrSystemErrorMessages.値がnull.getReplacedMessage("収納ID"));
        entity.setShunoId(収納ID);
    }

    /**
     * 会計年度を設定します。
     *
     * @param 会計年度 会計年度
     */
    public void set会計年度(RYear 会計年度) {
        requireNonNull(会計年度, UrSystemErrorMessages.値がnull.getReplacedMessage("会計年度"));
        entity.setKaikeiNendo(会計年度);
    }

    /**
     * 処理年度を設定します。
     *
     * @param 処理年度 処理年度
     */
    public void set処理年度(RYear 処理年度) {
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        entity.setShoriNendo(処理年度);
    }

    /**
     * 処理番号を設定します。
     *
     * @param 処理番号 処理番号
     */
    public void set処理番号(int 処理番号) {
        requireNonNull(処理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("処理番号"));
        entity.setShoriNo(処理番号);
    }

    /**
     * 更正回数を設定します。
     *
     * @param 更正回数 更正回数
     */
    public void set更正回数(int 更正回数) {
        requireNonNull(更正回数, UrSystemErrorMessages.値がnull.getReplacedMessage("更正回数"));
        entity.setKoseiKaisu(更正回数);
    }

    /**
     * 調定事由コードを設定します。
     *
     * @param 調定事由コード 調定事由コード
     */
    public void set調定事由コード(ChoteiJiyuCode 調定事由コード) {
        requireNonNull(調定事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調定事由コード"));
        entity.setChoteiJiyuCode(調定事由コード.getColumnValue());
    }

    /**
     * 調定日を設定します。
     *
     * @param 調定日 調定日
     */
    public void set調定日(RDate 調定日) {
        requireNonNull(調定日, UrSystemErrorMessages.値がnull.getReplacedMessage("調定日"));
        entity.setChoteiYMD(調定日);
    }

    /**
     * 調定額を設定します。
     *
     * @param 調定額 調定額
     */
    public void set調定額(Decimal 調定額) {
        requireNonNull(調定額, UrSystemErrorMessages.値がnull.getReplacedMessage("調定額"));
        entity.setChoteigaku(調定額);
    }

    /**
     * 消費税額を設定します。
     *
     * @param 消費税額 消費税額
     */
    public void set消費税額(Decimal 消費税額) {
        requireNonNull(消費税額, UrSystemErrorMessages.値がnull.getReplacedMessage("消費税額"));
        entity.setShohizei(消費税額);
    }

    /**
     * 納期限を設定します。
     *
     * @param 納期限 納期限
     */
    public void set納期限(RDate 納期限) {
        requireNonNull(納期限, UrSystemErrorMessages.値がnull.getReplacedMessage("納期限"));
        entity.setNokigenYMD(納期限);
    }

    /**
     * 法定納期限等を設定します。
     *
     * @param 法定納期限等 法定納期限等
     */
    public void set法定納期限等(RDate 法定納期限等) {
        requireNonNull(法定納期限等, UrSystemErrorMessages.値がnull.getReplacedMessage("法定納期限等"));
        entity.setHoteiNokigenToYMD(法定納期限等);
    }

    /**
     * 賦課処理状況を設定します。
     *
     * @param 賦課処理状況 賦課処理状況
     */
    public void set賦課処理状況(boolean 賦課処理状況) {
        requireNonNull(賦課処理状況, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課処理状況"));
        entity.setFukaShoriJokyo(賦課処理状況);
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
