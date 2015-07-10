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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績高額介護サービス費のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiKogakuKaigoServicehiModel implements Serializable {

    private DbT3028KyufujissekiKogakuKaigoServicehiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiKogakuKaigoServicehiModel() {
        entity = new DbT3028KyufujissekiKogakuKaigoServicehiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3028KyufujissekiKogakuKaigoServicehiEntity
     */
    public KyufujissekiKogakuKaigoServicehiModel(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3028KyufujissekiKogakuKaigoServicehiEntityを返します。
     *
     * @return DbT3028KyufujissekiKogakuKaigoServicehiEntity
     */
    public DbT3028KyufujissekiKogakuKaigoServicehiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3028KyufujissekiKogakuKaigoServicehiEntityを設定します。
     *
     * @param entity DbT3028KyufujissekiKogakuKaigoServicehiEntity
     */
    public void setEntity(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        this.entity = entity;
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
    }

    /**
     * 給付実績情報作成区分コードを返します。
     *
     * @return 給付実績情報作成区分コード
     */
    public RString get給付実績情報作成区分コード() {
        return entity.getKyufuSakuseiKubunCode();
    }

    /**
     * 給付実績区分コードを返します。
     *
     * @return 給付実績区分コード
     */
    public RString get給付実績区分コード() {
        return entity.getKyufuJissekiKubunCode();
    }

    /**
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 公費１負担番号を返します。
     *
     * @return 公費１負担番号
     */
    public RString get公費１負担番号() {
        return entity.getKohi1FutanNo();
    }

    /**
     * 公費２負担番号を返します。
     *
     * @return 公費２負担番号
     */
    public RString get公費２負担番号() {
        return entity.getKohi2FutanNo();
    }

    /**
     * 公費３負担番号を返します。
     *
     * @return 公費３負担番号
     */
    public RString get公費３負担番号() {
        return entity.getKohi3FutanNo();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 公費１負担額を返します。
     *
     * @return 公費１負担額
     */
    public int get公費１負担額() {
        return entity.getKohi1Futangaku();
    }

    /**
     * 公費２負担額を返します。
     *
     * @return 公費２負担額
     */
    public int get公費２負担額() {
        return entity.getKohi2Futangaku();
    }

    /**
     * 公費３負担額を返します。
     *
     * @return 公費３負担額
     */
    public int get公費３負担額() {
        return entity.getKohi3Futangaku();
    }

    /**
     * 支給額を返します。
     *
     * @return 支給額
     */
    public int get支給額() {
        return entity.getShikyugaku();
    }

    /**
     * 公費１支給額を返します。
     *
     * @return 公費１支給額
     */
    public int get公費１支給額() {
        return entity.getKohi1Shikyugaku();
    }

    /**
     * 公費２支給額を返します。
     *
     * @return 公費２支給額
     */
    public int get公費２支給額() {
        return entity.getKohi2Shikyugaku();
    }

    /**
     * 公費３支給額を返します。
     *
     * @return 公費３支給額
     */
    public int get公費３支給額() {
        return entity.getKohi3Shikyugaku();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * 作成区分を返します。
     *
     * @return 作成区分
     */
    public RString get作成区分() {
        return entity.getSakuseiKubun();
    }

    /**
     * 管理番号を返します。
     *
     * @return 管理番号
     */
    public RString get管理番号() {
        return entity.getKanriNo();
    }

    /**
     * 保険者保有給付実績情報削除済フラグを返します。
     *
     * @return 保険者保有給付実績情報削除済フラグ
     */
    public boolean get保険者保有給付実績情報削除済フラグ() {
        return entity.getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag();
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     */
    public void set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     */
    public void setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     */
    public void set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
    }

    /**
     * 給付実績情報作成区分コードを設定します。
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     */
    public void set給付実績情報作成区分コード(RString 給付実績情報作成区分コード) {
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
    }

    /**
     * 給付実績区分コードを設定します。
     *
     * @param 給付実績区分コード 給付実績区分コード
     */
    public void set給付実績区分コード(RString 給付実績区分コード) {
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        entity.setKyufuJissekiKubunCode(給付実績区分コード);
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
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
     * 公費１負担番号を設定します。
     *
     * @param 公費１負担番号 公費１負担番号
     */
    public void set公費１負担番号(RString 公費１負担番号) {
        requireNonNull(公費１負担番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１負担番号"));
        entity.setKohi1FutanNo(公費１負担番号);
    }

    /**
     * 公費２負担番号を設定します。
     *
     * @param 公費２負担番号 公費２負担番号
     */
    public void set公費２負担番号(RString 公費２負担番号) {
        requireNonNull(公費２負担番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２負担番号"));
        entity.setKohi2FutanNo(公費２負担番号);
    }

    /**
     * 公費３負担番号を設定します。
     *
     * @param 公費３負担番号 公費３負担番号
     */
    public void set公費３負担番号(RString 公費３負担番号) {
        requireNonNull(公費３負担番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３負担番号"));
        entity.setKohi3FutanNo(公費３負担番号);
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     */
    public void set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
    }

    /**
     * 公費１負担額を設定します。
     *
     * @param 公費１負担額 公費１負担額
     */
    public void set公費１負担額(int 公費１負担額) {
        requireNonNull(公費１負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１負担額"));
        entity.setKohi1Futangaku(公費１負担額);
    }

    /**
     * 公費２負担額を設定します。
     *
     * @param 公費２負担額 公費２負担額
     */
    public void set公費２負担額(int 公費２負担額) {
        requireNonNull(公費２負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２負担額"));
        entity.setKohi2Futangaku(公費２負担額);
    }

    /**
     * 公費３負担額を設定します。
     *
     * @param 公費３負担額 公費３負担額
     */
    public void set公費３負担額(int 公費３負担額) {
        requireNonNull(公費３負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３負担額"));
        entity.setKohi3Futangaku(公費３負担額);
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     */
    public void set支給額(int 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyugaku(支給額);
    }

    /**
     * 公費１支給額を設定します。
     *
     * @param 公費１支給額 公費１支給額
     */
    public void set公費１支給額(int 公費１支給額) {
        requireNonNull(公費１支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１支給額"));
        entity.setKohi1Shikyugaku(公費１支給額);
    }

    /**
     * 公費２支給額を設定します。
     *
     * @param 公費２支給額 公費２支給額
     */
    public void set公費２支給額(int 公費２支給額) {
        requireNonNull(公費２支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２支給額"));
        entity.setKohi2Shikyugaku(公費２支給額);
    }

    /**
     * 公費３支給額を設定します。
     *
     * @param 公費３支給額 公費３支給額
     */
    public void set公費３支給額(int 公費３支給額) {
        requireNonNull(公費３支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３支給額"));
        entity.setKohi3Shikyugaku(公費３支給額);
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     */
    public void set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     */
    public void set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     */
    public void set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
    }

    /**
     * 作成区分を設定します。
     *
     * @param 作成区分 作成区分
     */
    public void set作成区分(RString 作成区分) {
        requireNonNull(作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("作成区分"));
        entity.setSakuseiKubun(作成区分);
    }

    /**
     * 管理番号を設定します。
     *
     * @param 管理番号 管理番号
     */
    public void set管理番号(RString 管理番号) {
        requireNonNull(管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理番号"));
        entity.setKanriNo(管理番号);
    }

    /**
     * 保険者保有給付実績情報削除済フラグを設定します。
     *
     * @param 保険者保有給付実績情報削除済フラグ 保険者保有給付実績情報削除済フラグ
     */
    public void set保険者保有給付実績情報削除済フラグ(boolean 保険者保有給付実績情報削除済フラグ) {
        requireNonNull(保険者保有給付実績情報削除済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者保有給付実績情報削除済フラグ"));
        entity.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(保険者保有給付実績情報削除済フラグ);
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
