/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求福祉用具販売費のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanFukushiYoguHanbaihiModel implements Serializable {

    private DbT3048ShokanFukushiYoguHanbaihiEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanFukushiYoguHanbaihiModel() {
        entity = new DbT3048ShokanFukushiYoguHanbaihiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3048ShokanFukushiYoguHanbaihiEntity
     */
    public ShokanFukushiYoguHanbaihiModel(DbT3048ShokanFukushiYoguHanbaihiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3048ShokanFukushiYoguHanbaihiEntityを返します。
     *
     * @return DbT3048ShokanFukushiYoguHanbaihiEntity
     */
    public DbT3048ShokanFukushiYoguHanbaihiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3048ShokanFukushiYoguHanbaihiEntityを設定します。
     *
     * @param entity DbT3048ShokanFukushiYoguHanbaihiEntity
     */
    public void setEntity(DbT3048ShokanFukushiYoguHanbaihiEntity entity) {
        this.entity = entity;
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
    }

    /**
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
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
        return entity.getFukushiYoguHanbaiYMD();
    }

    /**
     * 福祉用具商品名を返します。
     *
     * @return 福祉用具商品名
     */
    public RString get福祉用具商品名() {
        return entity.getFukushiYoguShohinName();
    }

    /**
     * 福祉用具種目コードを返します。
     *
     * @return 福祉用具種目コード
     */
    public RString get福祉用具種目コード() {
        return entity.getFukushiYoguShumokuCode();
    }

    /**
     * 福祉用具製造事業者名を返します。
     *
     * @return 福祉用具製造事業者名
     */
    public RString get福祉用具製造事業者名() {
        return entity.getFukushiYoguSeizoJigyoshaName();
    }

    /**
     * 福祉用具販売事業者名を返します。
     *
     * @return 福祉用具販売事業者名
     */
    public RString get福祉用具販売事業者名() {
        return entity.getFukushiYoguHanbaiJigyoshaName();
    }

    /**
     * 購入金額を返します。
     *
     * @return 購入金額
     */
    public int get購入金額() {
        return entity.getKounyuKingaku();
    }

    /**
     * 品目コードを返します。
     *
     * @return 品目コード
     */
    public RString get品目コード() {
        return entity.getHinmokuCode();
    }

    /**
     * 審査方法区分コードを返します。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return entity.getShinsaHohoKubunCode();
    }

    /**
     * 差額金額を返します。
     *
     * @return 差額金額
     */
    public int get差額金額() {
        return entity.getSagakuKingaku();
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
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    public void set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     */
    public void set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
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
        entity.setFukushiYoguHanbaiYMD(福祉用具販売年月日);
    }

    /**
     * 福祉用具商品名を設定します。
     *
     * @param 福祉用具商品名 福祉用具商品名
     */
    public void set福祉用具商品名(RString 福祉用具商品名) {
        requireNonNull(福祉用具商品名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名"));
        entity.setFukushiYoguShohinName(福祉用具商品名);
    }

    /**
     * 福祉用具種目コードを設定します。
     *
     * @param 福祉用具種目コード 福祉用具種目コード
     */
    public void set福祉用具種目コード(RString 福祉用具種目コード) {
        requireNonNull(福祉用具種目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具種目コード"));
        entity.setFukushiYoguShumokuCode(福祉用具種目コード);
    }

    /**
     * 福祉用具製造事業者名を設定します。
     *
     * @param 福祉用具製造事業者名 福祉用具製造事業者名
     */
    public void set福祉用具製造事業者名(RString 福祉用具製造事業者名) {
        requireNonNull(福祉用具製造事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具製造事業者名"));
        entity.setFukushiYoguSeizoJigyoshaName(福祉用具製造事業者名);
    }

    /**
     * 福祉用具販売事業者名を設定します。
     *
     * @param 福祉用具販売事業者名 福祉用具販売事業者名
     */
    public void set福祉用具販売事業者名(RString 福祉用具販売事業者名) {
        requireNonNull(福祉用具販売事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具販売事業者名"));
        entity.setFukushiYoguHanbaiJigyoshaName(福祉用具販売事業者名);
    }

    /**
     * 購入金額を設定します。
     *
     * @param 購入金額 購入金額
     */
    public void set購入金額(int 購入金額) {
        requireNonNull(購入金額, UrSystemErrorMessages.値がnull.getReplacedMessage("購入金額"));
        entity.setKounyuKingaku(購入金額);
    }

    /**
     * 品目コードを設定します。
     *
     * @param 品目コード 品目コード
     */
    public void set品目コード(RString 品目コード) {
        requireNonNull(品目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("品目コード"));
        entity.setHinmokuCode(品目コード);
    }

    /**
     * 審査方法区分コードを設定します。
     *
     * @param 審査方法区分コード 審査方法区分コード
     */
    public void set審査方法区分コード(RString 審査方法区分コード) {
        requireNonNull(審査方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分コード"));
        entity.setShinsaHohoKubunCode(審査方法区分コード);
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     */
    public void set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
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
