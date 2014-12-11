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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績住宅改修費のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiJutakuKaishuhiModel implements Serializable {

    private DbT3027KyufujissekiJutakuKaishuhiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiJutakuKaishuhiModel() {
        entity = new DbT3027KyufujissekiJutakuKaishuhiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3027KyufujissekiJutakuKaishuhiEntity
     */
    public KyufujissekiJutakuKaishuhiModel(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3027KyufujissekiJutakuKaishuhiEntityを返します。
     *
     * @return DbT3027KyufujissekiJutakuKaishuhiEntity
     */
    public DbT3027KyufujissekiJutakuKaishuhiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3027KyufujissekiJutakuKaishuhiEntityを設定します。
     *
     * @param entity DbT3027KyufujissekiJutakuKaishuhiEntity
     */
    public void setEntity(DbT3027KyufujissekiJutakuKaishuhiEntity entity) {
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
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
     * 明細番号を返します。
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return entity.getMeisaiNo();
    }

    /**
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 住宅改修着工年月日を返します。
     *
     * @return 住宅改修着工年月日
     */
    public FlexibleDate get住宅改修着工年月日() {
        return entity.getJutakuKaishuchakkoYMD();
    }

    /**
     * 住宅改修事業者名を返します。
     *
     * @return 住宅改修事業者名
     */
    public RString get住宅改修事業者名() {
        return entity.getJutakuKaishuJigyoshaName();
    }

    /**
     * 住宅改修住宅住所を返します。
     *
     * @return 住宅改修住宅住所
     */
    public RString get住宅改修住宅住所() {
        return entity.getJuutakukaishuJyutakuAdress();
    }

    /**
     * 改修金額を返します。
     *
     * @return 改修金額
     */
    public int get改修金額() {
        return entity.getKaishuKingaku();
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
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
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
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
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
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     */
    public void set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     */
    public void setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
    }

    /**
     * 住宅改修着工年月日を設定します。
     *
     * @param 住宅改修着工年月日 住宅改修着工年月日
     */
    public void set住宅改修着工年月日(FlexibleDate 住宅改修着工年月日) {
        requireNonNull(住宅改修着工年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修着工年月日"));
        entity.setJutakuKaishuchakkoYMD(住宅改修着工年月日);
    }

    /**
     * 住宅改修事業者名を設定します。
     *
     * @param 住宅改修事業者名 住宅改修事業者名
     */
    public void set住宅改修事業者名(RString 住宅改修事業者名) {
        requireNonNull(住宅改修事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修事業者名"));
        entity.setJutakuKaishuJigyoshaName(住宅改修事業者名);
    }

    /**
     * 住宅改修住宅住所を設定します。
     *
     * @param 住宅改修住宅住所 住宅改修住宅住所
     */
    public void set住宅改修住宅住所(RString 住宅改修住宅住所) {
        requireNonNull(住宅改修住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修住宅住所"));
        entity.setJuutakukaishuJyutakuAdress(住宅改修住宅住所);
    }

    /**
     * 改修金額を設定します。
     *
     * @param 改修金額 改修金額
     */
    public void set改修金額(int 改修金額) {
        requireNonNull(改修金額, UrSystemErrorMessages.値がnull.getReplacedMessage("改修金額"));
        entity.setKaishuKingaku(改修金額);
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
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     */
    public void set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
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
