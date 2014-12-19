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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績福祉用具販売費のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiFukushiYoguHanbaihiModel implements Serializable {

    private DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiFukushiYoguHanbaihiModel() {
        entity = new DbT3026KyufujissekiFukushiYoguHanbaihiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3026KyufujissekiFukushiYoguHanbaihiEntity
     */
    public KyufujissekiFukushiYoguHanbaihiModel(DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3026KyufujissekiFukushiYoguHanbaihiEntityを返します。
     *
     * @return DbT3026KyufujissekiFukushiYoguHanbaihiEntity
     */
    public DbT3026KyufujissekiFukushiYoguHanbaihiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3026KyufujissekiFukushiYoguHanbaihiEntityを設定します。
     *
     * @param entity DbT3026KyufujissekiFukushiYoguHanbaihiEntity
     */
    public void setEntity(DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity) {
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
     * 福祉用具販売年月日を返します。
     *
     * @return 福祉用具販売年月日
     */
    public FlexibleDate get福祉用具販売年月日() {
        return entity.getFukushiyoguHanbaiYMD();
    }

    /**
     * 福祉用具商品名を返します。
     *
     * @return 福祉用具商品名
     */
    public RString get福祉用具商品名() {
        return entity.getFukushiyoguShohinName();
    }

    /**
     * 福祉用具種目コードを返します。
     *
     * @return 福祉用具種目コード
     */
    public RString get福祉用具種目コード() {
        return entity.getFukushiyoguSyumokuCode();
    }

    /**
     * 福祉用具製造事業者名を返します。
     *
     * @return 福祉用具製造事業者名
     */
    public RString get福祉用具製造事業者名() {
        return entity.getFukushiyoguSeizoJigyoshaName();
    }

    /**
     * 福祉用具販売事業者名を返します。
     *
     * @return 福祉用具販売事業者名
     */
    public RString get福祉用具販売事業者名() {
        return entity.getFukushiyoguHanbaiJigyoshaName();
    }

    /**
     * 販売金額を返します。
     *
     * @return 販売金額
     */
    public int get販売金額() {
        return entity.getHanbaiKingaku();
    }

    /**
     * 摘要_品目コードを返します。
     *
     * @return 摘要_品目コード
     */
    public RString get摘要_品目コード() {
        return entity.getTekiyo();
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
     * 福祉用具販売年月日を設定します。
     *
     * @param 福祉用具販売年月日 福祉用具販売年月日
     */
    public void set福祉用具販売年月日(FlexibleDate 福祉用具販売年月日) {
        requireNonNull(福祉用具販売年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具販売年月日"));
        entity.setFukushiyoguHanbaiYMD(福祉用具販売年月日);
    }

    /**
     * 福祉用具商品名を設定します。
     *
     * @param 福祉用具商品名 福祉用具商品名
     */
    public void set福祉用具商品名(RString 福祉用具商品名) {
        requireNonNull(福祉用具商品名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名"));
        entity.setFukushiyoguShohinName(福祉用具商品名);
    }

    /**
     * 福祉用具種目コードを設定します。
     *
     * @param 福祉用具種目コード 福祉用具種目コード
     */
    public void set福祉用具種目コード(RString 福祉用具種目コード) {
        requireNonNull(福祉用具種目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具種目コード"));
        entity.setFukushiyoguSyumokuCode(福祉用具種目コード);
    }

    /**
     * 福祉用具製造事業者名を設定します。
     *
     * @param 福祉用具製造事業者名 福祉用具製造事業者名
     */
    public void set福祉用具製造事業者名(RString 福祉用具製造事業者名) {
        requireNonNull(福祉用具製造事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具製造事業者名"));
        entity.setFukushiyoguSeizoJigyoshaName(福祉用具製造事業者名);
    }

    /**
     * 福祉用具販売事業者名を設定します。
     *
     * @param 福祉用具販売事業者名 福祉用具販売事業者名
     */
    public void set福祉用具販売事業者名(RString 福祉用具販売事業者名) {
        requireNonNull(福祉用具販売事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具販売事業者名"));
        entity.setFukushiyoguHanbaiJigyoshaName(福祉用具販売事業者名);
    }

    /**
     * 販売金額を設定します。
     *
     * @param 販売金額 販売金額
     */
    public void set販売金額(int 販売金額) {
        requireNonNull(販売金額, UrSystemErrorMessages.値がnull.getReplacedMessage("販売金額"));
        entity.setHanbaiKingaku(販売金額);
    }

    /**
     * 摘要_品目コードを設定します。
     *
     * @param 摘要_品目コード 摘要_品目コード
     */
    public void set摘要_品目コード(RString 摘要_品目コード) {
        requireNonNull(摘要_品目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要_品目コード"));
        entity.setTekiyo(摘要_品目コード);
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
