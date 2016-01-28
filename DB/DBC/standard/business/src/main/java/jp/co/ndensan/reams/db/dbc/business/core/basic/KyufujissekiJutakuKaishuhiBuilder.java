/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiJutakuKaishuhi}の編集を行うビルダークラスです。
 */
public class KyufujissekiJutakuKaishuhiBuilder {

    private final DbT3027KyufujissekiJutakuKaishuhiEntity entity;
    private final KyufujissekiJutakuKaishuhiIdentifier id;

    /**
     * {@link DbT3027KyufujissekiJutakuKaishuhiEntity}より{@link KyufujissekiJutakuKaishuhi}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3027KyufujissekiJutakuKaishuhiEntity}
     * @param id {@link KyufujissekiJutakuKaishuhiIdentifier}
     *
     */
    KyufujissekiJutakuKaishuhiBuilder(
            DbT3027KyufujissekiJutakuKaishuhiEntity entity,
            KyufujissekiJutakuKaishuhiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 住宅改修着工年月日を設定します。
     *
     * @param 住宅改修着工年月日 住宅改修着工年月日
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set住宅改修着工年月日(FlexibleDate 住宅改修着工年月日) {
        requireNonNull(住宅改修着工年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修着工年月日"));
        entity.setJutakuKaishuchakkoYMD(住宅改修着工年月日);
        return this;
    }

    /**
     * 住宅改修事業者名を設定します。
     *
     * @param 住宅改修事業者名 住宅改修事業者名
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set住宅改修事業者名(RString 住宅改修事業者名) {
        requireNonNull(住宅改修事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修事業者名"));
        entity.setJutakuKaishuJigyoshaName(住宅改修事業者名);
        return this;
    }

    /**
     * 住宅改修住宅住所を設定します。
     *
     * @param 住宅改修住宅住所 住宅改修住宅住所
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set住宅改修住宅住所(RString 住宅改修住宅住所) {
        requireNonNull(住宅改修住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修住宅住所"));
        entity.setJuutakukaishuJyutakuAdress(住宅改修住宅住所);
        return this;
    }

    /**
     * 改修金額を設定します。
     *
     * @param 改修金額 改修金額
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set改修金額(Decimal 改修金額) {
        requireNonNull(改修金額, UrSystemErrorMessages.値がnull.getReplacedMessage("改修金額"));
        entity.setKaishuKingaku(改修金額);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiJutakuKaishuhiBuilder}
     */
    public KyufujissekiJutakuKaishuhiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiJutakuKaishuhi}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiJutakuKaishuhi}のインスタンス
     */
    public KyufujissekiJutakuKaishuhi build() {
        return new KyufujissekiJutakuKaishuhi(entity, id);
    }
}
