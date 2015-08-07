/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link KyufujissekiKihon}の編集を行うビルダークラスです。
 */
public class KyufujissekiKihonBuilder {

    private final DbT3017KyufujissekiKihonEntity entity;
    private final KyufujissekiKihonIdentifier id;

    /**
     * {@link DbT3017KyufujissekiKihonEntity}より{@link KyufujissekiKihon}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3017KyufujissekiKihonEntity}
     * @param id {@link KyufujissekiKihonIdentifier}
     *
     */
    KyufujissekiKihonBuilder(
            DbT3017KyufujissekiKihonEntity entity,
            KyufujissekiKihonIdentifier id
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
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set交換情報識別番号(KokanShikibetsuCode 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set入力識別番号(NyuryokuShikibetsuCode 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 給付実績情報作成区分コードを設定します。
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set給付実績情報作成区分コード(RString 給付実績情報作成区分コード) {
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 給付実績区分コードを設定します。
     *
     * @param 給付実績区分コード 給付実績区分コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set給付実績区分コード(RString 給付実績区分コード) {
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        entity.setKyufuJissekiKubunCode(給付実績区分コード);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 公費１・負担者番号を設定します。
     *
     * @param 公費１・負担者番号 公費１・負担者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費１・負担者番号(RString 公費１・負担者番号) {
        requireNonNull(公費１・負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１・負担者番号"));
        entity.setKohi1FutanshaNo(公費１・負担者番号);
        return this;
    }

    /**
     * 公費１・受給者番号を設定します。
     *
     * @param 公費１・受給者番号 公費１・受給者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費１・受給者番号(RString 公費１・受給者番号) {
        requireNonNull(公費１・受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１・受給者番号"));
        entity.setKohi1JukyushaNo(公費１・受給者番号);
        return this;
    }

    /**
     * 公費２・負担者番号を設定します。
     *
     * @param 公費２・負担者番号 公費２・負担者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費２・負担者番号(RString 公費２・負担者番号) {
        requireNonNull(公費２・負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２・負担者番号"));
        entity.setKohi2FutanshaNo(公費２・負担者番号);
        return this;
    }

    /**
     * 公費２・受給者番号を設定します。
     *
     * @param 公費２・受給者番号 公費２・受給者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費２・受給者番号(RString 公費２・受給者番号) {
        requireNonNull(公費２・受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２・受給者番号"));
        entity.setKohi2JukyushaNo(公費２・受給者番号);
        return this;
    }

    /**
     * 公費３・負担者番号を設定します。
     *
     * @param 公費３・負担者番号 公費３・負担者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費３・負担者番号(RString 公費３・負担者番号) {
        requireNonNull(公費３・負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３・負担者番号"));
        entity.setKohi3FutanshaNo(公費３・負担者番号);
        return this;
    }

    /**
     * 公費３・受給者番号を設定します。
     *
     * @param 公費３・受給者番号 公費３・受給者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費３・受給者番号(RString 公費３・受給者番号) {
        requireNonNull(公費３・受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３・受給者番号"));
        entity.setKohi3JukyushaNo(公費３・受給者番号);
        return this;
    }

    /**
     * 生年月日を設定します。
     *
     * @param 生年月日 生年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set生年月日(FlexibleDate 生年月日) {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        entity.setUmareYMD(生年月日);
        return this;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set性別コード(RString 性別コード) {
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));
        entity.setSeibetsuCode(性別コード);
        return this;
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set要介護状態区分コード(RString 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYoKaigoJotaiKubunCode(要介護状態区分コード);
        return this;
    }

    /**
     * 旧措置入所者特例コードを設定します。
     *
     * @param 旧措置入所者特例コード 旧措置入所者特例コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set旧措置入所者特例コード(RString 旧措置入所者特例コード) {
        requireNonNull(旧措置入所者特例コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧措置入所者特例コード"));
        entity.setKyuSochiNyushoshaTokureiCode(旧措置入所者特例コード);
        return this;
    }

    /**
     * 認定有効期間・開始年月日を設定します。
     *
     * @param 認定有効期間・開始年月日 認定有効期間・開始年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set認定有効期間・開始年月日(FlexibleDate 認定有効期間・開始年月日) {
        requireNonNull(認定有効期間・開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有効期間・開始年月日"));
        entity.setNinteiYukoKaishiYMD(認定有効期間・開始年月日);
        return this;
    }

    /**
     * 認定有功期間・終了年月日を設定します。
     *
     * @param 認定有功期間・終了年月日 認定有功期間・終了年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set認定有功期間・終了年月日(FlexibleDate 認定有功期間・終了年月日) {
        requireNonNull(認定有功期間・終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定有功期間・終了年月日"));
        entity.setNinteiYukoShuryoYMD(認定有功期間・終了年月日);
        return this;
    }

    /**
     * 老人保健市町村番号を設定します。
     *
     * @param 老人保健市町村番号 老人保健市町村番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set老人保健市町村番号(RString 老人保健市町村番号) {
        requireNonNull(老人保健市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村番号"));
        entity.setRojinHokenShichosonNo(老人保健市町村番号);
        return this;
    }

    /**
     * 老人保健受給者番号を設定します。
     *
     * @param 老人保健受給者番号 老人保健受給者番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set老人保健受給者番号(RString 老人保健受給者番号) {
        requireNonNull(老人保健受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号"));
        entity.setRojinhokenJukyushaNo(老人保健受給者番号);
        return this;
    }

    /**
     * 保険者番号（後期）を設定します。
     *
     * @param 保険者番号（後期） 保険者番号（後期）
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set保険者番号（後期）(RString 保険者番号（後期）) {
        requireNonNull(保険者番号（後期）, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号（後期）"));
        entity.setKokiHokenshaNo(保険者番号（後期）);
        return this;
    }

    /**
     * 被保険者番号（後期）を設定します。
     *
     * @param 被保険者番号（後期） 被保険者番号（後期）
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set被保険者番号（後期）(RString 被保険者番号（後期）) {
        requireNonNull(被保険者番号（後期）, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号（後期）"));
        entity.setKokiHiHokenshaNo(被保険者番号（後期）);
        return this;
    }

    /**
     * 保険者番号（国保）を設定します。
     *
     * @param 保険者番号（国保） 保険者番号（国保）
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set保険者番号（国保）(RString 保険者番号（国保）) {
        requireNonNull(保険者番号（国保）, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号（国保）"));
        entity.setKokuhoHokenshaNo(保険者番号（国保）);
        return this;
    }

    /**
     * 被保険者証番号（国保）を設定します。
     *
     * @param 被保険者証番号（国保） 被保険者証番号（国保）
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set被保険者証番号（国保）(RString 被保険者証番号（国保）) {
        requireNonNull(被保険者証番号（国保）, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者証番号（国保）"));
        entity.setKokuhoHiHokenshashoNo(被保険者証番号（国保）);
        return this;
    }

    /**
     * 個人番号（国保）を設定します。
     *
     * @param 個人番号（国保） 個人番号（国保）
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set個人番号（国保）(RString 個人番号（国保）) {
        requireNonNull(個人番号（国保）, UrSystemErrorMessages.値がnull.getReplacedMessage("個人番号（国保）"));
        entity.setKokuhoKojinNo(個人番号（国保）);
        return this;
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        requireNonNull(居宅サービス計画作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成区分コード"));
        entity.setKyotakuServiceSakuseiKubunCode(居宅サービス計画作成区分コード);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setKyotakuKaigoShienJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
        return this;
    }

    /**
     * 中止年月日を設定します。
     *
     * @param 中止年月日 中止年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set中止年月日(FlexibleDate 中止年月日) {
        requireNonNull(中止年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("中止年月日"));
        entity.setChushiYMD(中止年月日);
        return this;
    }

    /**
     * 中止理由・入所（院）前の状況コードを設定します。
     *
     * @param 中止理由・入所（院）前の状況コード 中止理由・入所（院）前の状況コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set中止理由・入所（院）前の状況コード(RString 中止理由・入所（院）前の状況コード) {
        requireNonNull(中止理由・入所（院）前の状況コード, UrSystemErrorMessages.値がnull.getReplacedMessage("中止理由・入所（院）前の状況コード"));
        entity.setChushiRiyuNyushomaeJyokyoCode(中止理由・入所（院）前の状況コード);
        return this;
    }

    /**
     * 入所（院）年月日を設定します。
     *
     * @param 入所（院）年月日 入所（院）年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set入所（院）年月日(FlexibleDate 入所（院）年月日) {
        requireNonNull(入所（院）年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所（院）年月日"));
        entity.setNyushoYMD(入所（院）年月日);
        return this;
    }

    /**
     * 退所（院）年月日を設定します。
     *
     * @param 退所（院）年月日 退所（院）年月日
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set退所（院）年月日(FlexibleDate 退所（院）年月日) {
        requireNonNull(退所（院）年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所（院）年月日"));
        entity.setTaishoYMD(退所（院）年月日);
        return this;
    }

    /**
     * 入所（院）実日数を設定します。
     *
     * @param 入所（院）実日数 入所（院）実日数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set入所（院）実日数(Decimal 入所（院）実日数) {
        requireNonNull(入所（院）実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("入所（院）実日数"));
        entity.setNyushoJitsunissu(入所（院）実日数);
        return this;
    }

    /**
     * 外泊日数を設定します。
     *
     * @param 外泊日数 外泊日数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set外泊日数(Decimal 外泊日数) {
        requireNonNull(外泊日数, UrSystemErrorMessages.値がnull.getReplacedMessage("外泊日数"));
        entity.setGaihakuNissu(外泊日数);
        return this;
    }

    /**
     * 退所（院）後の状態コードを設定します。
     *
     * @param 退所（院）後の状態コード 退所（院）後の状態コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set退所（院）後の状態コード(RString 退所（院）後の状態コード) {
        requireNonNull(退所（院）後の状態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("退所（院）後の状態コード"));
        entity.setTaishogoJotaiCode(退所（院）後の状態コード);
        return this;
    }

    /**
     * 保険給付率を設定します。
     *
     * @param 保険給付率 保険給付率
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set保険給付率(HokenKyufuRitsu 保険給付率) {
        requireNonNull(保険給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付率"));
        entity.setHokenKyufuritsu(保険給付率);
        return this;
    }

    /**
     * 公費１給付率を設定します。
     *
     * @param 公費１給付率 公費１給付率
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費１給付率(HokenKyufuRitsu 公費１給付率) {
        requireNonNull(公費１給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１給付率"));
        entity.setKohi1Kyufuritsu(公費１給付率);
        return this;
    }

    /**
     * 公費２給付率を設定します。
     *
     * @param 公費２給付率 公費２給付率
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費２給付率(HokenKyufuRitsu 公費２給付率) {
        requireNonNull(公費２給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２給付率"));
        entity.setKohi2Kyufuritsu(公費２給付率);
        return this;
    }

    /**
     * 公費３給付率を設定します。
     *
     * @param 公費３給付率 公費３給付率
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set公費３給付率(HokenKyufuRitsu 公費３給付率) {
        requireNonNull(公費３給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３給付率"));
        entity.setKohi3Kyufuritsu(公費３給付率);
        return this;
    }

    /**
     * 前・保険・サービス単位数を設定します。
     *
     * @param 前・保険・サービス単位数 前・保険・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・保険・サービス単位数(int 前・保険・サービス単位数) {
        requireNonNull(前・保険・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前・保険・サービス単位数"));
        entity.setMaeHokenServiceTanisu(前・保険・サービス単位数);
        return this;
    }

    /**
     * 前・保険・請求額を設定します。
     *
     * @param 前・保険・請求額 前・保険・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・保険・請求額(Decimal 前・保険・請求額) {
        requireNonNull(前・保険・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・保険・請求額"));
        entity.setMaeHokenSeikyugaku(前・保険・請求額);
        return this;
    }

    /**
     * 前・保険・利用者負担額を設定します。
     *
     * @param 前・保険・利用者負担額 前・保険・利用者負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・保険・利用者負担額(int 前・保険・利用者負担額) {
        requireNonNull(前・保険・利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・保険・利用者負担額"));
        entity.setMaeHokenRiyoshaFutangaku(前・保険・利用者負担額);
        return this;
    }

    /**
     * 前・保険・緊急時施設療養費請求額を設定します。
     *
     * @param 前・保険・緊急時施設療養費請求額 前・保険・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・保険・緊急時施設療養費請求額(Decimal 前・保険・緊急時施設療養費請求額) {
        requireNonNull(前・保険・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・保険・緊急時施設療養費請求額"));
        entity.setMaeHokenKinkyuShisetsuRyoyoSeikyugaku(前・保険・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 前・保険・特定診療費請求額を設定します。
     *
     * @param 前・保険・特定診療費請求額 前・保険・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・保険・特定診療費請求額(Decimal 前・保険・特定診療費請求額) {
        requireNonNull(前・保険・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・保険・特定診療費請求額"));
        entity.setMaeHokenTokuteiShinryohiSeikyugaku(前・保険・特定診療費請求額);
        return this;
    }

    /**
     * 前・保険・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前・保険・特定入所者介護サービス費等請求額 前・保険・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・保険・特定入所者介護サービス費等請求額(int 前・保険・特定入所者介護サービス費等請求額) {
        requireNonNull(前・保険・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・保険・特定入所者介護サービス費等請求額"));
        entity.setMaeHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(前・保険・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 前・公費１・サービス単位数を設定します。
     *
     * @param 前・公費１・サービス単位数 前・公費１・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費１・サービス単位数(int 前・公費１・サービス単位数) {
        requireNonNull(前・公費１・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費１・サービス単位数"));
        entity.setMaeKohi1ServiceTanisu(前・公費１・サービス単位数);
        return this;
    }

    /**
     * 前・公費１・請求額を設定します。
     *
     * @param 前・公費１・請求額 前・公費１・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費１・請求額(int 前・公費１・請求額) {
        requireNonNull(前・公費１・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費１・請求額"));
        entity.setMaeKohi1Seikyugaku(前・公費１・請求額);
        return this;
    }

    /**
     * 前・公費１・本人負担額を設定します。
     *
     * @param 前・公費１・本人負担額 前・公費１・本人負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費１・本人負担額(int 前・公費１・本人負担額) {
        requireNonNull(前・公費１・本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費１・本人負担額"));
        entity.setMaeKohi1RiyoshaFutangaku(前・公費１・本人負担額);
        return this;
    }

    /**
     * 前・公費１・緊急時施設療養費請求額を設定します。
     *
     * @param 前・公費１・緊急時施設療養費請求額 前・公費１・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費１・緊急時施設療養費請求額(int 前・公費１・緊急時施設療養費請求額) {
        requireNonNull(前・公費１・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費１・緊急時施設療養費請求額"));
        entity.setMaeKohi1KinkyuShisetsuRyoyoSeikyugaku(前・公費１・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 前・公費１・特定診療費請求額を設定します。
     *
     * @param 前・公費１・特定診療費請求額 前・公費１・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費１・特定診療費請求額(int 前・公費１・特定診療費請求額) {
        requireNonNull(前・公費１・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費１・特定診療費請求額"));
        entity.setMaeKohi1TokuteiShinryohiSeikyugaku(前・公費１・特定診療費請求額);
        return this;
    }

    /**
     * 前・公費１・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前・公費１・特定入所者介護サービス費等請求額 前・公費１・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費１・特定入所者介護サービス費等請求額(int 前・公費１・特定入所者介護サービス費等請求額) {
        requireNonNull(前・公費１・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費１・特定入所者介護サービス費等請求額"));
        entity.setMaeKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(前・公費１・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 前・公費２・サービス単位数を設定します。
     *
     * @param 前・公費２・サービス単位数 前・公費２・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費２・サービス単位数(int 前・公費２・サービス単位数) {
        requireNonNull(前・公費２・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費２・サービス単位数"));
        entity.setMaeKohi2ServiceTanisu(前・公費２・サービス単位数);
        return this;
    }

    /**
     * 前・公費２・請求額を設定します。
     *
     * @param 前・公費２・請求額 前・公費２・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費２・請求額(int 前・公費２・請求額) {
        requireNonNull(前・公費２・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費２・請求額"));
        entity.setMaeKohi2Seikyugaku(前・公費２・請求額);
        return this;
    }

    /**
     * 前・公費２・本人負担額を設定します。
     *
     * @param 前・公費２・本人負担額 前・公費２・本人負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費２・本人負担額(int 前・公費２・本人負担額) {
        requireNonNull(前・公費２・本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費２・本人負担額"));
        entity.setMaeKohi2RiyoshaFutangaku(前・公費２・本人負担額);
        return this;
    }

    /**
     * 前・公費２・緊急時施設療養費請求額を設定します。
     *
     * @param 前・公費２・緊急時施設療養費請求額 前・公費２・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費２・緊急時施設療養費請求額(int 前・公費２・緊急時施設療養費請求額) {
        requireNonNull(前・公費２・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費２・緊急時施設療養費請求額"));
        entity.setMaeKohi2KinkyuShisetsuRyoyoSeikyugaku(前・公費２・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 前・公費２・特定診療費請求額を設定します。
     *
     * @param 前・公費２・特定診療費請求額 前・公費２・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費２・特定診療費請求額(int 前・公費２・特定診療費請求額) {
        requireNonNull(前・公費２・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費２・特定診療費請求額"));
        entity.setMaeKohi2TokuteiShinryohiSeikyugaku(前・公費２・特定診療費請求額);
        return this;
    }

    /**
     * 前・公費２・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前・公費２・特定入所者介護サービス費等請求額 前・公費２・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費２・特定入所者介護サービス費等請求額(int 前・公費２・特定入所者介護サービス費等請求額) {
        requireNonNull(前・公費２・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費２・特定入所者介護サービス費等請求額"));
        entity.setMaeKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(前・公費２・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 前・公費３・サービス単位数を設定します。
     *
     * @param 前・公費３・サービス単位数 前・公費３・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費３・サービス単位数(int 前・公費３・サービス単位数) {
        requireNonNull(前・公費３・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費３・サービス単位数"));
        entity.setMaeKohi3ServiceTanisu(前・公費３・サービス単位数);
        return this;
    }

    /**
     * 前・公費３・請求額を設定します。
     *
     * @param 前・公費３・請求額 前・公費３・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費３・請求額(int 前・公費３・請求額) {
        requireNonNull(前・公費３・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費３・請求額"));
        entity.setMaeKohi3Seikyugaku(前・公費３・請求額);
        return this;
    }

    /**
     * 前・公費３・本人負担額を設定します。
     *
     * @param 前・公費３・本人負担額 前・公費３・本人負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費３・本人負担額(int 前・公費３・本人負担額) {
        requireNonNull(前・公費３・本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費３・本人負担額"));
        entity.setMaeKohi3RiyoshaFutangaku(前・公費３・本人負担額);
        return this;
    }

    /**
     * 前・公費３・緊急時施設療養費請求額を設定します。
     *
     * @param 前・公費３・緊急時施設療養費請求額 前・公費３・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費３・緊急時施設療養費請求額(int 前・公費３・緊急時施設療養費請求額) {
        requireNonNull(前・公費３・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費３・緊急時施設療養費請求額"));
        entity.setMaeKohi3KinkyuShisetsuRyoyoSeikyugaku(前・公費３・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 前・公費３・特定診療費請求額を設定します。
     *
     * @param 前・公費３・特定診療費請求額 前・公費３・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費３・特定診療費請求額(int 前・公費３・特定診療費請求額) {
        requireNonNull(前・公費３・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費３・特定診療費請求額"));
        entity.setMaeKohi3TokuteiShinryohiSeikyugaku(前・公費３・特定診療費請求額);
        return this;
    }

    /**
     * 前・公費３・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 前・公費３・特定入所者介護サービス費等請求額 前・公費３・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set前・公費３・特定入所者介護サービス費等請求額(int 前・公費３・特定入所者介護サービス費等請求額) {
        requireNonNull(前・公費３・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("前・公費３・特定入所者介護サービス費等請求額"));
        entity.setMaeKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(前・公費３・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 後・保険・サービス単位数を設定します。
     *
     * @param 後・保険・サービス単位数 後・保険・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・保険・サービス単位数(int 後・保険・サービス単位数) {
        requireNonNull(後・保険・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・サービス単位数"));
        entity.setAtoHokenServiceTanisu(後・保険・サービス単位数);
        return this;
    }

    /**
     * 後・保険・請求額を設定します。
     *
     * @param 後・保険・請求額 後・保険・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・保険・請求額(Decimal 後・保険・請求額) {
        requireNonNull(後・保険・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・請求額"));
        entity.setAtoHokenSeikyugaku(後・保険・請求額);
        return this;
    }

    /**
     * 後・保険・利用者負担額を設定します。
     *
     * @param 後・保険・利用者負担額 後・保険・利用者負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・保険・利用者負担額(int 後・保険・利用者負担額) {
        requireNonNull(後・保険・利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・利用者負担額"));
        entity.setAtoHokenRiyoshaFutangaku(後・保険・利用者負担額);
        return this;
    }

    /**
     * 後・緊急時施設療養費請求額を設定します。
     *
     * @param 後・緊急時施設療養費請求額 後・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・緊急時施設療養費請求額(Decimal 後・緊急時施設療養費請求額) {
        requireNonNull(後・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・緊急時施設療養費請求額"));
        entity.setAtoHokenKinkyuShisetsuRyoyoSeikyugaku(後・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 後・保険・特定診療費請求額を設定します。
     *
     * @param 後・保険・特定診療費請求額 後・保険・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・保険・特定診療費請求額(Decimal 後・保険・特定診療費請求額) {
        requireNonNull(後・保険・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・特定診療費請求額"));
        entity.setAtoHokenTokuteiShinryohiSeikyugaku(後・保険・特定診療費請求額);
        return this;
    }

    /**
     * 後・保険・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後・保険・特定入所者介護サービス費等請求額 後・保険・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・保険・特定入所者介護サービス費等請求額(int 後・保険・特定入所者介護サービス費等請求額) {
        requireNonNull(後・保険・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・特定入所者介護サービス費等請求額"));
        entity.setAtoHokenTokuteiNyushoshaKaigoServiceHiSeikyugaku(後・保険・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 後・公費１・サービス単位数を設定します。
     *
     * @param 後・公費１・サービス単位数 後・公費１・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費１・サービス単位数(int 後・公費１・サービス単位数) {
        requireNonNull(後・公費１・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・サービス単位数"));
        entity.setAtoKohi1ServiceTanisu(後・公費１・サービス単位数);
        return this;
    }

    /**
     * 後・公費１・請求額を設定します。
     *
     * @param 後・公費１・請求額 後・公費１・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費１・請求額(int 後・公費１・請求額) {
        requireNonNull(後・公費１・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・請求額"));
        entity.setAtoKohi1Seikyugaku(後・公費１・請求額);
        return this;
    }

    /**
     * 後・公費１・本人負担額を設定します。
     *
     * @param 後・公費１・本人負担額 後・公費１・本人負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費１・本人負担額(int 後・公費１・本人負担額) {
        requireNonNull(後・公費１・本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・本人負担額"));
        entity.setAtoKohi1RiyoshaFutangaku(後・公費１・本人負担額);
        return this;
    }

    /**
     * 後・公費１・緊急時施設療養費請求額を設定します。
     *
     * @param 後・公費１・緊急時施設療養費請求額 後・公費１・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費１・緊急時施設療養費請求額(int 後・公費１・緊急時施設療養費請求額) {
        requireNonNull(後・公費１・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・緊急時施設療養費請求額"));
        entity.setAtoKohi1KinkyuShisetsuRyoyoSeikyugaku(後・公費１・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 後・公費１・特定診療費請求額を設定します。
     *
     * @param 後・公費１・特定診療費請求額 後・公費１・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費１・特定診療費請求額(int 後・公費１・特定診療費請求額) {
        requireNonNull(後・公費１・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・特定診療費請求額"));
        entity.setAtoKohi1TokuteiShinryohiSeikyugaku(後・公費１・特定診療費請求額);
        return this;
    }

    /**
     * 後・公費１・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後・公費１・特定入所者介護サービス費等請求額 後・公費１・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費１・特定入所者介護サービス費等請求額(int 後・公費１・特定入所者介護サービス費等請求額) {
        requireNonNull(後・公費１・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・特定入所者介護サービス費等請求額"));
        entity.setAtoKohi1TokuteiNyushoshaKaigoServiceHiSeikyugaku(後・公費１・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 後・公費２・サービス単位数を設定します。
     *
     * @param 後・公費２・サービス単位数 後・公費２・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費２・サービス単位数(int 後・公費２・サービス単位数) {
        requireNonNull(後・公費２・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・サービス単位数"));
        entity.setAtoKohi2ServiceTanisu(後・公費２・サービス単位数);
        return this;
    }

    /**
     * 後・公費２・請求額を設定します。
     *
     * @param 後・公費２・請求額 後・公費２・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費２・請求額(int 後・公費２・請求額) {
        requireNonNull(後・公費２・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・請求額"));
        entity.setAtoKohi2Seikyugaku(後・公費２・請求額);
        return this;
    }

    /**
     * 後・公費２・利用者負担額を設定します。
     *
     * @param 後・公費２・利用者負担額 後・公費２・利用者負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費２・利用者負担額(int 後・公費２・利用者負担額) {
        requireNonNull(後・公費２・利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・利用者負担額"));
        entity.setAtoKohi2RiyoshaFutangaku(後・公費２・利用者負担額);
        return this;
    }

    /**
     * 後・公費２・緊急時施設療養費請求額を設定します。
     *
     * @param 後・公費２・緊急時施設療養費請求額 後・公費２・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費２・緊急時施設療養費請求額(int 後・公費２・緊急時施設療養費請求額) {
        requireNonNull(後・公費２・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・緊急時施設療養費請求額"));
        entity.setAtoKohi2KinkyuShisetsuRyoyoSeikyugaku(後・公費２・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 後・公費２・特定診療費請求額を設定します。
     *
     * @param 後・公費２・特定診療費請求額 後・公費２・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費２・特定診療費請求額(int 後・公費２・特定診療費請求額) {
        requireNonNull(後・公費２・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・特定診療費請求額"));
        entity.setAtoKohi2TokuteiShinryohiSeikyugaku(後・公費２・特定診療費請求額);
        return this;
    }

    /**
     * 後・公費２・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後・公費２・特定入所者介護サービス費等請求額 後・公費２・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費２・特定入所者介護サービス費等請求額(int 後・公費２・特定入所者介護サービス費等請求額) {
        requireNonNull(後・公費２・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・特定入所者介護サービス費等請求額"));
        entity.setAtoKohi2TokuteiNyushoshaKaigoServiceHiSeikyugaku(後・公費２・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 後・公費３・サービス単位数を設定します。
     *
     * @param 後・公費３・サービス単位数 後・公費３・サービス単位数
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費３・サービス単位数(int 後・公費３・サービス単位数) {
        requireNonNull(後・公費３・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・サービス単位数"));
        entity.setAtoKohi3ServiceTanisu(後・公費３・サービス単位数);
        return this;
    }

    /**
     * 後・公費３・請求額を設定します。
     *
     * @param 後・公費３・請求額 後・公費３・請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費３・請求額(int 後・公費３・請求額) {
        requireNonNull(後・公費３・請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・請求額"));
        entity.setAtoKohi3Seikyugaku(後・公費３・請求額);
        return this;
    }

    /**
     * 後・公費３・利用者負担額を設定します。
     *
     * @param 後・公費３・利用者負担額 後・公費３・利用者負担額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費３・利用者負担額(int 後・公費３・利用者負担額) {
        requireNonNull(後・公費３・利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・利用者負担額"));
        entity.setAtoKohi3RiyoshaFutangaku(後・公費３・利用者負担額);
        return this;
    }

    /**
     * 後・公費３・緊急時施設療養費請求額を設定します。
     *
     * @param 後・公費３・緊急時施設療養費請求額 後・公費３・緊急時施設療養費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費３・緊急時施設療養費請求額(int 後・公費３・緊急時施設療養費請求額) {
        requireNonNull(後・公費３・緊急時施設療養費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・緊急時施設療養費請求額"));
        entity.setAtoKohi3KinkyuShisetsuRyoyoSeikyugaku(後・公費３・緊急時施設療養費請求額);
        return this;
    }

    /**
     * 後・公費３・特定診療費請求額を設定します。
     *
     * @param 後・公費３・特定診療費請求額 後・公費３・特定診療費請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費３・特定診療費請求額(int 後・公費３・特定診療費請求額) {
        requireNonNull(後・公費３・特定診療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・特定診療費請求額"));
        entity.setAtoKohi3TokuteiShinryohiSeikyugaku(後・公費３・特定診療費請求額);
        return this;
    }

    /**
     * 後・公費３・特定入所者介護サービス費等請求額を設定します。
     *
     * @param 後・公費３・特定入所者介護サービス費等請求額 後・公費３・特定入所者介護サービス費等請求額
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set後・公費３・特定入所者介護サービス費等請求額(int 後・公費３・特定入所者介護サービス費等請求額) {
        requireNonNull(後・公費３・特定入所者介護サービス費等請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・特定入所者介護サービス費等請求額"));
        entity.setAtoKohi3TokuteiNyushoshaKaigoServiceHiSeikyugaku(後・公費３・特定入所者介護サービス費等請求額);
        return this;
    }

    /**
     * 警告区分コードを設定します。
     *
     * @param 警告区分コード 警告区分コード
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set警告区分コード(RString 警告区分コード) {
        requireNonNull(警告区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("警告区分コード"));
        entity.setKeikaiKubunCode(警告区分コード);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 送付年月を設定します。
     *
     * @param 送付年月 送付年月
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set送付年月(FlexibleYearMonth 送付年月) {
        requireNonNull(送付年月, UrSystemErrorMessages.値がnull.getReplacedMessage("送付年月"));
        entity.setSofuYM(送付年月);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * 独自作成区分を設定します。
     *
     * @param 独自作成区分 独自作成区分
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set独自作成区分(RString 独自作成区分) {
        requireNonNull(独自作成区分, UrSystemErrorMessages.値がnull.getReplacedMessage("独自作成区分"));
        entity.setDokujiSakuseiKubun(独自作成区分);
        return this;
    }

    /**
     * 保険者保有給付実績情報削除済フラグを設定します。
     *
     * @param 保険者保有給付実績情報削除済フラグ 保険者保有給付実績情報削除済フラグ
     * @return {@link KyufujissekiKihonBuilder}
     */
    public KyufujissekiKihonBuilder set保険者保有給付実績情報削除済フラグ(boolean 保険者保有給付実績情報削除済フラグ) {
        requireNonNull(保険者保有給付実績情報削除済フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者保有給付実績情報削除済フラグ"));
        entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(保険者保有給付実績情報削除済フラグ);
        return this;
    }

    /**
     * {@link KyufujissekiKihon}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiKihon}のインスタンス
     */
    public KyufujissekiKihon build() {
        return new KyufujissekiKihon(entity, id);
    }
}
