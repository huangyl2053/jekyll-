/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyufujissekiKihonAlive}の編集を行うビルダークラスです。
 */
public class KyufujissekiKihonAliveBuilder {

    private final DbV3017KyufujissekiKihonEntity entity;
    private final KyufujissekiKihonAliveIdentifier id;

    /**
     * {@link DbV3017KyufujissekiKihonEntity}より{@link KyufujissekiKihonAlive}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbV3017KyufujissekiKihonEntity}
     * @param id {@link KyufujissekiKihonAliveIdentifier}
     *
     */
    KyufujissekiKihonAliveBuilder(
            DbV3017KyufujissekiKihonEntity entity,
            KyufujissekiKihonAliveIdentifier id
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
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set交換情報識別番号(ShikibetsuCode 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set入力識別番号(ShikibetsuCode 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 給付実績情報作成区分コードを設定します。
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set給付実績情報作成区分コード(RString 給付実績情報作成区分コード) {
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        return this;
    }

    /**
     * 給付実績区分コードを設定します。
     *
     * @param 給付実績区分コード 給付実績区分コード
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set給付実績区分コード(RString 給付実績区分コード) {
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        entity.setKyufuJissekiKubunCode(給付実績区分コード);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiKihonAliveBuilder}
     */
    public KyufujissekiKihonAliveBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * {@link KyufujissekiKihonAlive}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiKihonAlive}のインスタンス
     */
    public KyufujissekiKihonAlive build() {
        return new KyufujissekiKihonAlive(entity, id);
    }
}
