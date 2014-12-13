/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算自己負担額明細のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanJikoFutanGakuMeisaiModel implements Serializable {

    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanJikoFutanGakuMeisaiModel() {
        entity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3071KogakuGassanJikoFutanGakuMeisaiEntity
     */
    public KogakuGassanJikoFutanGakuMeisaiModel(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3071KogakuGassanJikoFutanGakuMeisaiEntityを返します。
     *
     * @return DbT3071KogakuGassanJikoFutanGakuMeisaiEntity
     */
    public DbT3071KogakuGassanJikoFutanGakuMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3071KogakuGassanJikoFutanGakuMeisaiEntityを設定します。
     *
     * @param entity DbT3071KogakuGassanJikoFutanGakuMeisaiEntity
     */
    public void setEntity(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity) {
        this.entity = entity;
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
    }

    /**
     * 対象月を返します。
     *
     * @return 対象月
     */
    public RString get対象月() {
        return entity.getTaishoM();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 自己負担額を返します。
     *
     * @return 自己負担額
     */
    public Decimal get自己負担額() {
        return entity.getJikoFutanGaku();
    }

    /**
     * 70_74自己負担額_内数を返します。
     *
     * @return 70_74自己負担額_内数
     */
    public Decimal get70_74自己負担額_内数() {
        return entity.getUchisu_70_74JikoFutanGaku();
    }

    /**
     * 70未満高額支給額を返します。
     *
     * @return 70未満高額支給額
     */
    public Decimal get70未満高額支給額() {
        return entity.getUnder_70KogakuShikyuGaku();
    }

    /**
     * 70_74高額支給額を返します。
     *
     * @return 70_74高額支給額
     */
    public Decimal get70_74高額支給額() {
        return entity.getOver_70_74KogakuShikyuGaku();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 補正済_自己負担額を返します。
     *
     * @return 補正済_自己負担額
     */
    public Decimal get補正済_自己負担額() {
        return entity.getSumi_JikoFutanGaku();
    }

    /**
     * 補正済_70_74自己負担額_内数を返します。
     *
     * @return 補正済_70_74自己負担額_内数
     */
    public Decimal get補正済_70_74自己負担額_内数() {
        return entity.getSumi_70_74JikoFutanGaku();
    }

    /**
     * 補正済_70未満高額支給額を返します。
     *
     * @return 補正済_70未満高額支給額
     */
    public Decimal get補正済_70未満高額支給額() {
        return entity.getSumi_under_70KogakuShikyuGaku();
    }

    /**
     * 補正済_70_74高額支給額を返します。
     *
     * @return 補正済_70_74高額支給額
     */
    public Decimal get補正済_70_74高額支給額() {
        return entity.getSumi_70_74KogakuShikyuGaku();
    }

    /**
     * 補正済_摘要を返します。
     *
     * @return 補正済_摘要
     */
    public RString get補正済_摘要() {
        return entity.getSumi_Tekiyo();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     */
    public void set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     */
    public void set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
    }

    /**
     * 支給申請書整理番号を設定します。
     *
     * @param 支給申請書整理番号 支給申請書整理番号
     */
    public void set支給申請書整理番号(RString 支給申請書整理番号) {
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
    }

    /**
     * 対象月を設定します。
     *
     * @param 対象月 対象月
     */
    public void set対象月(RString 対象月) {
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        entity.setTaishoM(対象月);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 自己負担額を設定します。
     *
     * @param 自己負担額 自己負担額
     */
    public void set自己負担額(Decimal 自己負担額) {
        requireNonNull(自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額"));
        entity.setJikoFutanGaku(自己負担額);
    }

    /**
     * 70_74自己負担額_内数を設定します。
     *
     * @param _70_74自己負担額_内数 70_74自己負担額_内数
     */
    public void set70_74自己負担額_内数(Decimal _70_74自己負担額_内数) {
        requireNonNull(_70_74自己負担額_内数, UrSystemErrorMessages.値がnull.getReplacedMessage("70_74自己負担額_内数"));
        entity.setUchisu_70_74JikoFutanGaku(_70_74自己負担額_内数);
    }

    /**
     * 70未満高額支給額を設定します。
     *
     * @param _70未満高額支給額 70未満高額支給額
     */
    public void set70未満高額支給額(Decimal _70未満高額支給額) {
        requireNonNull(_70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70未満高額支給額")
        );
        entity.setUnder_70KogakuShikyuGaku(_70未満高額支給額);
    }

    /**
     * 70_74高額支給額を設定します。
     *
     * @param _70_74高額支給額 70_74高額支給額
     */
    public void set70_74高額支給額(Decimal _70_74高額支給額) {
        requireNonNull(_70_74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("70_74高額支給額"));
        entity.setOver_70_74KogakuShikyuGaku(_70_74高額支給額);
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     */
    public void set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
    }

    /**
     * 補正済_自己負担額を設定します。
     *
     * @param 補正済_自己負担額 補正済_自己負担額
     */
    public void set補正済_自己負担額(Decimal 補正済_自己負担額) {
        requireNonNull(補正済_自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_自己負担額"));
        entity.setSumi_JikoFutanGaku(補正済_自己負担額);
    }

    /**
     * 補正済_70_74自己負担額_内数を設定します。
     *
     * @param 補正済_70_74自己負担額_内数 補正済_70_74自己負担額_内数
     */
    public void set補正済_70_74自己負担額_内数(Decimal 補正済_70_74自己負担額_内数) {
        requireNonNull(補正済_70_74自己負担額_内数, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_70_74自己負担額_内数"));
        entity.setSumi_70_74JikoFutanGaku(補正済_70_74自己負担額_内数);
    }

    /**
     * 補正済_70未満高額支給額を設定します。
     *
     * @param 補正済_70未満高額支給額 補正済_70未満高額支給額
     */
    public void set補正済_70未満高額支給額(Decimal 補正済_70未満高額支給額) {
        requireNonNull(補正済_70未満高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_70未満高額支給額"));
        entity.setSumi_under_70KogakuShikyuGaku(補正済_70未満高額支給額);
    }

    /**
     * 補正済_70_74高額支給額を設定します。
     *
     * @param 補正済_70_74高額支給額 補正済_70_74高額支給額
     */
    public void set補正済_70_74高額支給額(Decimal 補正済_70_74高額支給額) {
        requireNonNull(補正済_70_74高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_70_74高額支給額"));
        entity.setSumi_70_74KogakuShikyuGaku(補正済_70_74高額支給額);
    }

    /**
     * 補正済_摘要を設定します。
     *
     * @param 補正済_摘要 補正済_摘要
     */
    public void set補正済_摘要(RString 補正済_摘要) {
        requireNonNull(補正済_摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("補正済_摘要"));
        entity.setSumi_Tekiyo(補正済_摘要);
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
