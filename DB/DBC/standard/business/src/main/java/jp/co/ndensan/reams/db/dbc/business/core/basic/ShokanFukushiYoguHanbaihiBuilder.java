/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShokanFukushiYoguHanbaihi}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-1020-050 chenaoqi
 */
public class ShokanFukushiYoguHanbaihiBuilder {

    private final DbT3048ShokanFukushiYoguHanbaihiEntity entity;
    private final ShokanFukushiYoguHanbaihiIdentifier id;

    /**
     * {@link DbT3048ShokanFukushiYoguHanbaihiEntity}より{@link ShokanFukushiYoguHanbaihi}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3048ShokanFukushiYoguHanbaihiEntity}
     * @param id {@link ShokanFukushiYoguHanbaihiIdentifier}
     *
     */
    ShokanFukushiYoguHanbaihiBuilder(
            DbT3048ShokanFukushiYoguHanbaihiEntity entity,
            ShokanFukushiYoguHanbaihiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 福祉用具販売年月日を設定します。
     *
     * @param 福祉用具販売年月日 福祉用具販売年月日
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set福祉用具販売年月日(FlexibleDate 福祉用具販売年月日) {
//        requireNonNull(福祉用具販売年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具販売年月日"));
        entity.setFukushiYoguHanbaiYMD(福祉用具販売年月日);
        return this;
    }

    /**
     * 福祉用具商品名を設定します。
     *
     * @param 福祉用具商品名 福祉用具商品名
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set福祉用具商品名(RString 福祉用具商品名) {
//        requireNonNull(福祉用具商品名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具商品名"));
        entity.setFukushiYoguShohinName(福祉用具商品名);
        return this;
    }

    /**
     * 福祉用具種目コードを設定します。
     *
     * @param 福祉用具種目コード 福祉用具種目コード
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set福祉用具種目コード(RString 福祉用具種目コード) {
        requireNonNull(福祉用具種目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具種目コード"));
        entity.setFukushiYoguShumokuCode(福祉用具種目コード);
        return this;
    }

    /**
     * 福祉用具製造事業者名を設定します。
     *
     * @param 福祉用具製造事業者名 福祉用具製造事業者名
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set福祉用具製造事業者名(RString 福祉用具製造事業者名) {
//        requireNonNull(福祉用具製造事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具製造事業者名"));
        entity.setFukushiYoguSeizoJigyoshaName(福祉用具製造事業者名);
        return this;
    }

    /**
     * 福祉用具販売事業者名を設定します。
     *
     * @param 福祉用具販売事業者名 福祉用具販売事業者名
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set福祉用具販売事業者名(RString 福祉用具販売事業者名) {
//        requireNonNull(福祉用具販売事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("福祉用具販売事業者名"));
        entity.setFukushiYoguHanbaiJigyoshaName(福祉用具販売事業者名);
        return this;
    }

    /**
     * 購入金額を設定します。
     *
     * @param 購入金額 購入金額
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set購入金額(int 購入金額) {
        requireNonNull(購入金額, UrSystemErrorMessages.値がnull.getReplacedMessage("購入金額"));
        entity.setKounyuKingaku(購入金額);
        return this;
    }

    /**
     * 品目コードを設定します。
     *
     * @param 品目コード 品目コード
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set品目コード(RString 品目コード) {
//        requireNonNull(品目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("品目コード"));
        entity.setHinmokuCode(品目コード);
        return this;
    }

    /**
     * 審査方法区分コードを設定します。
     *
     * @param 審査方法区分コード 審査方法区分コード
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set審査方法区分コード(RString 審査方法区分コード) {
//        requireNonNull(審査方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分コード"));
        entity.setShinsaHohoKubunCode(審査方法区分コード);
        return this;
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     * @return {@link ShokanFukushiYoguHanbaihiBuilder}
     */
    public ShokanFukushiYoguHanbaihiBuilder set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
        return this;
    }

    /**
     * {@link ShokanFukushiYoguHanbaihi}のインスタンスを生成します。
     *
     * @return {@link ShokanFukushiYoguHanbaihi}のインスタンス
     */
    public ShokanFukushiYoguHanbaihi build() {
        return new ShokanFukushiYoguHanbaihi(entity, id);
    }
}
