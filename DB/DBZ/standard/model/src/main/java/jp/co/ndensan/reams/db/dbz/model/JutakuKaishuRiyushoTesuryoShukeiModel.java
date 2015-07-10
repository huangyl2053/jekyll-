/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 住宅改修理由書作成手数料請求集計のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class JutakuKaishuRiyushoTesuryoShukeiModel implements Serializable {

    private DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity;

    /**
     * コンストラクタです。
     */
    public JutakuKaishuRiyushoTesuryoShukeiModel() {
        entity = new DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity
     */
    public JutakuKaishuRiyushoTesuryoShukeiModel(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityを返します。
     *
     * @return DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity
     */
    public DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityを設定します。
     *
     * @param entity DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity
     */
    public void setEntity(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 集計開始年月を返します。
     *
     * @return 集計開始年月
     */
    public FlexibleYearMonth get集計開始年月() {
        return entity.getShukeiKaishiYM();
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
     * 集計終了年月を返します。
     *
     * @return 集計終了年月
     */
    public FlexibleYearMonth get集計終了年月() {
        return entity.getShukeiShuryoYM();
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
     * 介護住宅改修理由書作成件数を返します。
     *
     * @return 介護住宅改修理由書作成件数
     */
    public Decimal get介護住宅改修理由書作成件数() {
        return entity.getRiyushoSakuseiKensu();
    }

    /**
     * 介護住宅改修理由書作成単価を返します。
     *
     * @return 介護住宅改修理由書作成単価
     */
    public Decimal get介護住宅改修理由書作成単価() {
        return entity.getRiyushoSakuseiTanka();
    }

    /**
     * 介護住宅改修理由書作成請求金額を返します。
     *
     * @return 介護住宅改修理由書作成請求金額
     */
    public Decimal get介護住宅改修理由書作成請求金額() {
        return entity.getRiyushoSakuseiSeikyuKingaku();
    }

    /**
     * 介護住宅改修理由書作成申請年月日を返します。
     *
     * @return 介護住宅改修理由書作成申請年月日
     */
    public FlexibleDate get介護住宅改修理由書作成申請年月日() {
        return entity.getRiyushoSakuseiShinseiYMD();
    }

    /**
     * 介護住宅改修理由書作成受付年月日を返します。
     *
     * @return 介護住宅改修理由書作成受付年月日
     */
    public FlexibleDate get介護住宅改修理由書作成受付年月日() {
        return entity.getRiyushoSakuseiUketsukeYMD();
    }

    /**
     * 介護支払方法区分を返します。
     *
     * @return 介護支払方法区分
     */
    public RString get介護支払方法区分() {
        return entity.getShiharaiHohoKubun();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuNo();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 集計開始年月を設定します。
     *
     * @param 集計開始年月 集計開始年月
     */
    public void set集計開始年月(FlexibleYearMonth 集計開始年月) {
        requireNonNull(集計開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計開始年月"));
        entity.setShukeiKaishiYM(集計開始年月);
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
     * 集計終了年月を設定します。
     *
     * @param 集計終了年月 集計終了年月
     */
    public void set集計終了年月(FlexibleYearMonth 集計終了年月) {
        requireNonNull(集計終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計終了年月"));
        entity.setShukeiShuryoYM(集計終了年月);
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
     * 介護住宅改修理由書作成件数を設定します。
     *
     * @param 介護住宅改修理由書作成件数 介護住宅改修理由書作成件数
     */
    public void set介護住宅改修理由書作成件数(Decimal 介護住宅改修理由書作成件数) {
        requireNonNull(介護住宅改修理由書作成件数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成件数"));
        entity.setRiyushoSakuseiKensu(介護住宅改修理由書作成件数);
    }

    /**
     * 介護住宅改修理由書作成単価を設定します。
     *
     * @param 介護住宅改修理由書作成単価 介護住宅改修理由書作成単価
     */
    public void set介護住宅改修理由書作成単価(Decimal 介護住宅改修理由書作成単価) {
        requireNonNull(介護住宅改修理由書作成単価, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成単価"));
        entity.setRiyushoSakuseiTanka(介護住宅改修理由書作成単価);
    }

    /**
     * 介護住宅改修理由書作成請求金額を設定します。
     *
     * @param 介護住宅改修理由書作成請求金額 介護住宅改修理由書作成請求金額
     */
    public void set介護住宅改修理由書作成請求金額(Decimal 介護住宅改修理由書作成請求金額) {
        requireNonNull(介護住宅改修理由書作成請求金額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成請求金額"));
        entity.setRiyushoSakuseiSeikyuKingaku(介護住宅改修理由書作成請求金額);
    }

    /**
     * 介護住宅改修理由書作成申請年月日を設定します。
     *
     * @param 介護住宅改修理由書作成申請年月日 介護住宅改修理由書作成申請年月日
     */
    public void set介護住宅改修理由書作成申請年月日(FlexibleDate 介護住宅改修理由書作成申請年月日) {
        requireNonNull(介護住宅改修理由書作成申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成申請年月日"));
        entity.setRiyushoSakuseiShinseiYMD(介護住宅改修理由書作成申請年月日);
    }

    /**
     * 介護住宅改修理由書作成受付年月日を設定します。
     *
     * @param 介護住宅改修理由書作成受付年月日 介護住宅改修理由書作成受付年月日
     */
    public void set介護住宅改修理由書作成受付年月日(FlexibleDate 介護住宅改修理由書作成受付年月日) {
        requireNonNull(介護住宅改修理由書作成受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成受付年月日"));
        entity.setRiyushoSakuseiUketsukeYMD(介護住宅改修理由書作成受付年月日);
    }

    /**
     * 介護支払方法区分を設定します。
     *
     * @param 介護支払方法区分 介護支払方法区分
     */
    public void set介護支払方法区分(RString 介護支払方法区分) {
        requireNonNull(介護支払方法区分, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支払方法区分"));
        entity.setShiharaiHohoKubun(介護支払方法区分);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuNo(識別コード);
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
