/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KyufujissekiKogakuKaigoServicehi}の編集を行うビルダークラスです。
 */
public class KyufujissekiKogakuKaigoServicehiBuilder {

    private final DbT3028KyufujissekiKogakuKaigoServicehiEntity entity;
    private final KyufujissekiKogakuKaigoServicehiIdentifier id;

    /**
     * {@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}より{@link KyufujissekiKogakuKaigoServicehi}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}
     * @param id {@link KyufujissekiKogakuKaigoServicehiIdentifier}
     *
     */
    KyufujissekiKogakuKaigoServicehiBuilder(
            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity,
            KyufujissekiKogakuKaigoServicehiIdentifier id
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
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 給付実績情報作成区分コードを設定します。
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set給付実績情報作成区分コード(RString 給付実績情報作成区分コード) {
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        return this;
    }

    /**
     * 給付実績区分コードを設定します。
     *
     * @param 給付実績区分コード 給付実績区分コード
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set給付実績区分コード(RString 給付実績区分コード) {
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        entity.setKyufuJissekiKubunCode(給付実績区分コード);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 公費１負担番号を設定します。
     *
     * @param 公費１負担番号 公費１負担番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費１負担番号(RString 公費１負担番号) {
        requireNonNull(公費１負担番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１負担番号"));
        entity.setKohi1FutanNo(公費１負担番号);
        return this;
    }

    /**
     * 公費２負担番号を設定します。
     *
     * @param 公費２負担番号 公費２負担番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費２負担番号(RString 公費２負担番号) {
        requireNonNull(公費２負担番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２負担番号"));
        entity.setKohi2FutanNo(公費２負担番号);
        return this;
    }

    /**
     * 公費３負担番号を設定します。
     *
     * @param 公費３負担番号 公費３負担番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費３負担番号(RString 公費３負担番号) {
        requireNonNull(公費３負担番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３負担番号"));
        entity.setKohi3FutanNo(公費３負担番号);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * 公費１負担額を設定します。
     *
     * @param 公費１負担額 公費１負担額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費１負担額(int 公費１負担額) {
        requireNonNull(公費１負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１負担額"));
        entity.setKohi1Futangaku(公費１負担額);
        return this;
    }

    /**
     * 公費２負担額を設定します。
     *
     * @param 公費２負担額 公費２負担額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費２負担額(int 公費２負担額) {
        requireNonNull(公費２負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２負担額"));
        entity.setKohi2Futangaku(公費２負担額);
        return this;
    }

    /**
     * 公費３負担額を設定します。
     *
     * @param 公費３負担額 公費３負担額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費３負担額(int 公費３負担額) {
        requireNonNull(公費３負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３負担額"));
        entity.setKohi3Futangaku(公費３負担額);
        return this;
    }

    /**
     * 支給額を設定します。
     *
     * @param 支給額 支給額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set支給額(int 支給額) {
        requireNonNull(支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給額"));
        entity.setShikyugaku(支給額);
        return this;
    }

    /**
     * 公費１支給額を設定します。
     *
     * @param 公費１支給額 公費１支給額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費１支給額(int 公費１支給額) {
        requireNonNull(公費１支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１支給額"));
        entity.setKohi1Shikyugaku(公費１支給額);
        return this;
    }

    /**
     * 公費２支給額を設定します。
     *
     * @param 公費２支給額 公費２支給額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費２支給額(int 公費２支給額) {
        requireNonNull(公費２支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２支給額"));
        entity.setKohi2Shikyugaku(公費２支給額);
        return this;
    }

    /**
     * 公費３支給額を設定します。
     *
     * @param 公費３支給額 公費３支給額
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set公費３支給額(int 公費３支給額) {
        requireNonNull(公費３支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３支給額"));
        entity.setKohi3Shikyugaku(公費３支給額);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * 作成区分を設定します。
     *
     * @param 作成区分 作成区分
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set作成区分(RString 作成区分) {
        requireNonNull(作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("作成区分"));
        entity.setSakuseiKubun(作成区分);
        return this;
    }

    /**
     * 管理番号を設定します。
     *
     * @param 管理番号 管理番号
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set管理番号(RString 管理番号) {
        requireNonNull(管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理番号"));
        entity.setKanriNo(管理番号);
        return this;
    }

    /**
     * 保険者保有給付実績情報削除済フラグを設定します。
     *
     * @param 保険者保有給付実績情報削除済フラグ 保険者保有給付実績情報削除済フラグ
     * @return {@link KyufujissekiKogakuKaigoServicehiBuilder}
     */
    public KyufujissekiKogakuKaigoServicehiBuilder set保険者保有給付実績情報削除済フラグ(boolean 保険者保有給付実績情報削除済フラグ) {
        requireNonNull(保険者保有給付実績情報削除済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者保有給付実績情報削除済フラグ"));
        entity.setHokenshaHoyuKyufujissekiJohoSakujoZumiFlag(保険者保有給付実績情報削除済フラグ);
        return this;
    }

    /**
     * {@link KyufujissekiKogakuKaigoServicehi}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiKogakuKaigoServicehi}のインスタンス
     */
    public KyufujissekiKogakuKaigoServicehi build() {
        return new KyufujissekiKogakuKaigoServicehi(entity, id);
    }
}
