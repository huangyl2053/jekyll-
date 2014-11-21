/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 住宅改修理由書作成手数料請求決定のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class JutakuKaishuRiyushoTesuryoKetteiModel implements Serializable {

    private DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity;

    /**
     * コンストラクタです。
     */
    public JutakuKaishuRiyushoTesuryoKetteiModel() {
        entity = new DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity
     */
    public JutakuKaishuRiyushoTesuryoKetteiModel(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityを返します。
     *
     * @return DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity
     */
    public DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityを設定します。
     *
     * @param entity DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity
     */
    public void setEntity(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護住宅改修理由書作成事業者番号を返します。
     *
     * @return 介護住宅改修理由書作成事業者番号
     */
    public JigyoshaNo get介護住宅改修理由書作成事業者番号() {
        return entity.getRiyushoSakuseiJigyoshaNo();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
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
     * 支給_不支給決定年月日を返します。
     *
     * @return 支給_不支給決定年月日
     */
    public FlexibleDate get支給_不支給決定年月日() {
        return entity.getShikyu_FushikyuKetteiYMD();
    }

    /**
     * 支給_不支給区分を返します。
     *
     * @return 支給_不支給区分
     */
    public RString get支給_不支給区分() {
        return entity.getShikyu_FushikyuKubun();
    }

    /**
     * 償還不支給理由等を返します。
     *
     * @return 償還不支給理由等
     */
    public RString get償還不支給理由等() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 住宅改修理由書作成手数料支払予定日を返します。
     *
     * @return 住宅改修理由書作成手数料支払予定日
     */
    public FlexibleDate get住宅改修理由書作成手数料支払予定日() {
        return entity.getTesuryoShiharaiYoteiYMD();
    }

    /**
     * 介護住宅改修理由書作成事業者番号を設定します。
     *
     * @param 介護住宅改修理由書作成事業者番号 介護住宅改修理由書作成事業者番号
     */
    public void set介護住宅改修理由書作成事業者番号(JigyoshaNo 介護住宅改修理由書作成事業者番号) {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     */
    public void set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
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
     * 支給_不支給決定年月日を設定します。
     *
     * @param 支給_不支給決定年月日 支給_不支給決定年月日
     */
    public void set支給_不支給決定年月日(FlexibleDate 支給_不支給決定年月日) {
        requireNonNull(支給_不支給決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("支給_不支給決定年月日"));
        entity.setShikyu_FushikyuKetteiYMD(支給_不支給決定年月日);
    }

    /**
     * 支給_不支給区分を設定します。
     *
     * @param 支給_不支給区分 支給_不支給区分
     */
    public void set支給_不支給区分(RString 支給_不支給区分) {
        requireNonNull(支給_不支給区分, UrSystemErrorMessages.値がnull.getReplacedMessage("支給_不支給区分"));
        entity.setShikyu_FushikyuKubun(支給_不支給区分);
    }

    /**
     * 償還不支給理由等を設定します。
     *
     * @param 償還不支給理由等 償還不支給理由等
     */
    public void set償還不支給理由等(RString 償還不支給理由等) {
        requireNonNull(償還不支給理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("償還不支給理由等"));
        entity.setFushikyuRiyu(償還不支給理由等);
    }

    /**
     * 住宅改修理由書作成手数料支払予定日を設定します。
     *
     * @param 住宅改修理由書作成手数料支払予定日 住宅改修理由書作成手数料支払予定日
     */
    public void set住宅改修理由書作成手数料支払予定日(FlexibleDate 住宅改修理由書作成手数料支払予定日) {
        requireNonNull(住宅改修理由書作成手数料支払予定日, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料支払予定日"));
        entity.setTesuryoShiharaiYoteiYMD(住宅改修理由書作成手数料支払予定日);
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
