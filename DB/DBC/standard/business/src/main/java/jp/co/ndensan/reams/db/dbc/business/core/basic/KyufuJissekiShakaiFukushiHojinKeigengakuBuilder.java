/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuJissekiShakaiFukushiHojinKeigengaku}の編集を行うビルダークラスです。
 */
public class KyufuJissekiShakaiFukushiHojinKeigengakuBuilder {

    private final DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity;
    private final KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier id;

    /**
     * {@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}より{@link KyufuJissekiShakaiFukushiHojinKeigengaku}の編集用Builderクラスを生成します。
     *
     * @param entity
     * {@link DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity}
     * @param id {@link KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier}
     *
     */
    KyufuJissekiShakaiFukushiHojinKeigengakuBuilder(
            DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity,
            KyufuJissekiShakaiFukushiHojinKeigengakuIdentifier id
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
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 軽減率を設定します。
     *
     * @param 軽減率 軽減率
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set軽減率(Decimal 軽減率) {
        requireNonNull(軽減率, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率"));
        entity.setKeigenritsu(軽減率);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceSyuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 受領すべき利用者負担の総額を設定します。
     *
     * @param 受領すべき利用者負担の総額 受領すべき利用者負担の総額
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set受領すべき利用者負担の総額(Decimal 受領すべき利用者負担の総額) {
        requireNonNull(受領すべき利用者負担の総額, UrSystemErrorMessages.値がnull.getReplacedMessage("受領すべき利用者負担の総額"));
        entity.setRiyoshaFutanTotal(受領すべき利用者負担の総額);
        return this;
    }

    /**
     * 軽減額を設定します。
     *
     * @param 軽減額 軽減額
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set軽減額(Decimal 軽減額) {
        requireNonNull(軽減額, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減額"));
        entity.setKeigengaku(軽減額);
        return this;
    }

    /**
     * 軽減後利用者負担額を設定します。
     *
     * @param 軽減後利用者負担額 軽減後利用者負担額
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set軽減後利用者負担額(Decimal 軽減後利用者負担額) {
        requireNonNull(軽減後利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減後利用者負担額"));
        entity.setKeigengoRiyoshaFutangaku(軽減後利用者負担額);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 後_受領すべき利用者負担の総額を設定します。
     *
     * @param 後_受領すべき利用者負担の総額 後_受領すべき利用者負担の総額
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set後_受領すべき利用者負担の総額(Decimal 後_受領すべき利用者負担の総額) {
        requireNonNull(後_受領すべき利用者負担の総額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_受領すべき利用者負担の総額"));
        entity.setAtoRiyoshaFutanTotal(後_受領すべき利用者負担の総額);
        return this;
    }

    /**
     * 後_軽減額を設定します。
     *
     * @param 後_軽減額 後_軽減額
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set後_軽減額(Decimal 後_軽減額) {
        requireNonNull(後_軽減額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_軽減額"));
        entity.setAtoKeigengaku(後_軽減額);
        return this;
    }

    /**
     * 後_軽減後利用者負担額を設定します。
     *
     * @param 後_軽減後利用者負担額 後_軽減後利用者負担額
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set後_軽減後利用者負担額(Decimal 後_軽減後利用者負担額) {
        requireNonNull(後_軽減後利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_軽減後利用者負担額"));
        entity.setAtoKeigengoRiyoshaFutangaku(後_軽減後利用者負担額);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufuJissekiShakaiFukushiHojinKeigengaku}のインスタンスを生成します。
     *
     * @return {@link KyufuJissekiShakaiFukushiHojinKeigengaku}のインスタンス
     */
    public KyufuJissekiShakaiFukushiHojinKeigengaku build() {
        return new KyufuJissekiShakaiFukushiHojinKeigengaku(entity, id);
    }
}
