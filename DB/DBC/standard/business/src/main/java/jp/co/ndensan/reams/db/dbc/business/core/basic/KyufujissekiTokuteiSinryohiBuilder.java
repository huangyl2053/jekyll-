/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiTokuteiSinryohi}の編集を行うビルダークラスです。
 */
public class KyufujissekiTokuteiSinryohiBuilder {

    private final DbT3020KyufujissekiTokuteiSinryohiEntity entity;
    private final KyufujissekiTokuteiSinryohiIdentifier id;

    /**
     * {@link DbT3020KyufujissekiTokuteiSinryohiEntity}より{@link KyufujissekiTokuteiSinryohi}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3020KyufujissekiTokuteiSinryohiEntity}
     * @param id {@link KyufujissekiTokuteiSinryohiIdentifier}
     *
     */
    KyufujissekiTokuteiSinryohiBuilder(
            DbT3020KyufujissekiTokuteiSinryohiEntity entity,
            KyufujissekiTokuteiSinryohiIdentifier id
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
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 特定診療情報レコード順次番号を設定します。
     *
     * @param 特定診療情報レコード順次番号 特定診療情報レコード順次番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set特定診療情報レコード順次番号(RString 特定診療情報レコード順次番号) {
        requireNonNull(特定診療情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療情報レコード順次番号"));
        entity.setRecodeJunjiNo(特定診療情報レコード順次番号);
        return this;
    }

    /**
     * 傷病名を設定します。
     *
     * @param 傷病名 傷病名
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set傷病名(RString 傷病名) {
        requireNonNull(傷病名, UrSystemErrorMessages.値がnull.getReplacedMessage("傷病名"));
        entity.setShobyoName(傷病名);
        return this;
    }

    /**
     * 保険_指導管理料等を設定します。
     *
     * @param 保険_指導管理料等 保険_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set保険_指導管理料等(int 保険_指導管理料等) {
        requireNonNull(保険_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_指導管理料等"));
        entity.setHokenShidoKanriryo(保険_指導管理料等);
        return this;
    }

    /**
     * 保険_単純エックス線を設定します。
     *
     * @param 保険_単純エックス線 保険_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set保険_単純エックス線(int 保険_単純エックス線) {
        requireNonNull(保険_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_単純エックス線"));
        entity.setHokenTanjunXsen(保険_単純エックス線);
        return this;
    }

    /**
     * 保険_リハビリテーションを設定します。
     *
     * @param 保険_リハビリテーション 保険_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set保険_リハビリテーション(int 保険_リハビリテーション) {
        requireNonNull(保険_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_リハビリテーション"));
        entity.setHokenRehabilitation(保険_リハビリテーション);
        return this;
    }

    /**
     * 保険_精神科専門療法を設定します。
     *
     * @param 保険_精神科専門療法 保険_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set保険_精神科専門療法(int 保険_精神科専門療法) {
        requireNonNull(保険_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_精神科専門療法"));
        entity.setHokenSeishinkaSemmonRyoho(保険_精神科専門療法);
        return this;
    }

    /**
     * 保険_合計単位数を設定します。
     *
     * @param 保険_合計単位数 保険_合計単位数
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set保険_合計単位数(int 保険_合計単位数) {
        requireNonNull(保険_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_合計単位数"));
        entity.setHokenTotalTanisu(保険_合計単位数);
        return this;
    }

    /**
     * 公費１_指導管理料等を設定します。
     *
     * @param 公費１_指導管理料等 公費１_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費１_指導管理料等(int 公費１_指導管理料等) {
        requireNonNull(公費１_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_指導管理料等"));
        entity.setKohi1ShidoKanriryo(公費１_指導管理料等);
        return this;
    }

    /**
     * 公費１_単純エックス線を設定します。
     *
     * @param 公費１_単純エックス線 公費１_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費１_単純エックス線(int 公費１_単純エックス線) {
        requireNonNull(公費１_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_単純エックス線"));
        entity.setKohi1TanjunXsen(公費１_単純エックス線);
        return this;
    }

    /**
     * 公費１_リハビリテーションを設定します。
     *
     * @param 公費１_リハビリテーション 公費１_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費１_リハビリテーション(int 公費１_リハビリテーション) {
        requireNonNull(公費１_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_リハビリテーション"));
        entity.setKohi1Rehabilitation(公費１_リハビリテーション);
        return this;
    }

    /**
     * 公費１_精神科専門療法を設定します。
     *
     * @param 公費１_精神科専門療法 公費１_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費１_精神科専門療法(int 公費１_精神科専門療法) {
        requireNonNull(公費１_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_精神科専門療法"));
        entity.setKohi1SeishinkaSemmonRyoho(公費１_精神科専門療法);
        return this;
    }

    /**
     * 公費１_合計単位数を設定します。
     *
     * @param 公費１_合計単位数 公費１_合計単位数
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費１_合計単位数(int 公費１_合計単位数) {
        requireNonNull(公費１_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_合計単位数"));
        entity.setKohi1TotalTanisu(公費１_合計単位数);
        return this;
    }

    /**
     * 公費２_指導管理料等を設定します。
     *
     * @param 公費２_指導管理料等 公費２_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費２_指導管理料等(int 公費２_指導管理料等) {
        requireNonNull(公費２_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_指導管理料等"));
        entity.setKohi2ShidoKanriryo(公費２_指導管理料等);
        return this;
    }

    /**
     * 公費２_単純エックス線を設定します。
     *
     * @param 公費２_単純エックス線 公費２_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費２_単純エックス線(int 公費２_単純エックス線) {
        requireNonNull(公費２_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_単純エックス線"));
        entity.setKohi2TanjunXsen(公費２_単純エックス線);
        return this;
    }

    /**
     * 公費２_リハビリテーションを設定します。
     *
     * @param 公費２_リハビリテーション 公費２_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費２_リハビリテーション(int 公費２_リハビリテーション) {
        requireNonNull(公費２_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_リハビリテーション"));
        entity.setKohi2Rehabilitation(公費２_リハビリテーション);
        return this;
    }

    /**
     * 公費２_精神科専門療法を設定します。
     *
     * @param 公費２_精神科専門療法 公費２_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費２_精神科専門療法(int 公費２_精神科専門療法) {
        requireNonNull(公費２_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_精神科専門療法"));
        entity.setKohi2SeishinkaSemmonRyoho(公費２_精神科専門療法);
        return this;
    }

    /**
     * 公費２_合計単位数を設定します。
     *
     * @param 公費２_合計単位数 公費２_合計単位数
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費２_合計単位数(int 公費２_合計単位数) {
        requireNonNull(公費２_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_合計単位数"));
        entity.setKohi2TotalTanisu(公費２_合計単位数);
        return this;
    }

    /**
     * 公費３_指導管理料等を設定します。
     *
     * @param 公費３_指導管理料等 公費３_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費３_指導管理料等(int 公費３_指導管理料等) {
        requireNonNull(公費３_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_指導管理料等"));
        entity.setKohi3ShidoKanriryo(公費３_指導管理料等);
        return this;
    }

    /**
     * 公費３_単純エックス線を設定します。
     *
     * @param 公費３_単純エックス線 公費３_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費３_単純エックス線(int 公費３_単純エックス線) {
        requireNonNull(公費３_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_単純エックス線"));
        entity.setKohi3TanjunXsen(公費３_単純エックス線);
        return this;
    }

    /**
     * 公費３_リハビリテーションを設定します。
     *
     * @param 公費３_リハビリテーション 公費３_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費３_リハビリテーション(int 公費３_リハビリテーション) {
        requireNonNull(公費３_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_リハビリテーション"));
        entity.setKohi3Rehabilitation(公費３_リハビリテーション);
        return this;
    }

    /**
     * 公費３_精神科専門療法を設定します。
     *
     * @param 公費３_精神科専門療法 公費３_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費３_精神科専門療法(int 公費３_精神科専門療法) {
        requireNonNull(公費３_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_精神科専門療法"));
        entity.setKohi3SeishinkaSemmonRyoho(公費３_精神科専門療法);
        return this;
    }

    /**
     * 公費３_合計単位数を設定します。
     *
     * @param 公費３_合計単位数 公費３_合計単位数
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set公費３_合計単位数(int 公費３_合計単位数) {
        requireNonNull(公費３_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_合計単位数"));
        entity.setKohi3TotalTanisu(公費３_合計単位数);
        return this;
    }

    /**
     * 摘要１を設定します。
     *
     * @param 摘要１ 摘要１
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１(RString 摘要１) {
        requireNonNull(摘要１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１"));
        entity.setTekiyo1(摘要１);
        return this;
    }

    /**
     * 摘要２を設定します。
     *
     * @param 摘要２ 摘要２
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要２(RString 摘要２) {
        requireNonNull(摘要２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２"));
        entity.setTekiyo2(摘要２);
        return this;
    }

    /**
     * 摘要３を設定します。
     *
     * @param 摘要３ 摘要３
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要３(RString 摘要３) {
        requireNonNull(摘要３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要３"));
        entity.setTekiyo3(摘要３);
        return this;
    }

    /**
     * 摘要４を設定します。
     *
     * @param 摘要４ 摘要４
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要４(RString 摘要４) {
        requireNonNull(摘要４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要４"));
        entity.setTekiyo4(摘要４);
        return this;
    }

    /**
     * 摘要５を設定します。
     *
     * @param 摘要５ 摘要５
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要５(RString 摘要５) {
        requireNonNull(摘要５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要５"));
        entity.setTekiyo5(摘要５);
        return this;
    }

    /**
     * 摘要６を設定します。
     *
     * @param 摘要６ 摘要６
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要６(RString 摘要６) {
        requireNonNull(摘要６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要６"));
        entity.setTekiyo6(摘要６);
        return this;
    }

    /**
     * 摘要７を設定します。
     *
     * @param 摘要７ 摘要７
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要７(RString 摘要７) {
        requireNonNull(摘要７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要７"));
        entity.setTekiyo7(摘要７);
        return this;
    }

    /**
     * 摘要８を設定します。
     *
     * @param 摘要８ 摘要８
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要８(RString 摘要８) {
        requireNonNull(摘要８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要８"));
        entity.setTekiyo8(摘要８);
        return this;
    }

    /**
     * 摘要９を設定します。
     *
     * @param 摘要９ 摘要９
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要９(RString 摘要９) {
        requireNonNull(摘要９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要９"));
        entity.setTekiyo9(摘要９);
        return this;
    }

    /**
     * 摘要１０を設定します。
     *
     * @param 摘要１０ 摘要１０
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１０(RString 摘要１０) {
        requireNonNull(摘要１０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１０"));
        entity.setTekiyo10(摘要１０);
        return this;
    }

    /**
     * 摘要１１を設定します。
     *
     * @param 摘要１１ 摘要１１
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１１(RString 摘要１１) {
        requireNonNull(摘要１１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１１"));
        entity.setTekiyo11(摘要１１);
        return this;
    }

    /**
     * 摘要１２を設定します。
     *
     * @param 摘要１２ 摘要１２
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１２(RString 摘要１２) {
        requireNonNull(摘要１２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１２"));
        entity.setTekiyo12(摘要１２);
        return this;
    }

    /**
     * 摘要１３を設定します。
     *
     * @param 摘要１３ 摘要１３
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１３(RString 摘要１３) {
        requireNonNull(摘要１３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１３"));
        entity.setTekiyo13(摘要１３);
        return this;
    }

    /**
     * 摘要１４を設定します。
     *
     * @param 摘要１４ 摘要１４
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１４(RString 摘要１４) {
        requireNonNull(摘要１４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１４"));
        entity.setTekiyo14(摘要１４);
        return this;
    }

    /**
     * 摘要１５を設定します。
     *
     * @param 摘要１５ 摘要１５
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１５(RString 摘要１５) {
        requireNonNull(摘要１５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１５"));
        entity.setTekiyo15(摘要１５);
        return this;
    }

    /**
     * 摘要１６を設定します。
     *
     * @param 摘要１６ 摘要１６
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１６(RString 摘要１６) {
        requireNonNull(摘要１６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１６"));
        entity.setTekiyo16(摘要１６);
        return this;
    }

    /**
     * 摘要１７を設定します。
     *
     * @param 摘要１７ 摘要１７
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１７(RString 摘要１７) {
        requireNonNull(摘要１７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１７"));
        entity.setTekiyo17(摘要１７);
        return this;
    }

    /**
     * 摘要１８を設定します。
     *
     * @param 摘要１８ 摘要１８
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１８(RString 摘要１８) {
        requireNonNull(摘要１８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１８"));
        entity.setTekiyo18(摘要１８);
        return this;
    }

    /**
     * 摘要１９を設定します。
     *
     * @param 摘要１９ 摘要１９
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要１９(RString 摘要１９) {
        requireNonNull(摘要１９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１９"));
        entity.setTekiyo19(摘要１９);
        return this;
    }

    /**
     * 摘要２０を設定します。
     *
     * @param 摘要２０ 摘要２０
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set摘要２０(RString 摘要２０) {
        requireNonNull(摘要２０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２０"));
        entity.setTekiyo20(摘要２０);
        return this;
    }

    /**
     * 後_保険_指導管理料等を設定します。
     *
     * @param 後_保険_指導管理料等 後_保険_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_保険_指導管理料等(int 後_保険_指導管理料等) {
        requireNonNull(後_保険_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_指導管理料等"));
        entity.setAtoHokenShidoKanriryo(後_保険_指導管理料等);
        return this;
    }

    /**
     * 後_保険_単純エックス線を設定します。
     *
     * @param 後_保険_単純エックス線 後_保険_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_保険_単純エックス線(int 後_保険_単純エックス線) {
        requireNonNull(後_保険_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_単純エックス線"));
        entity.setAtoHokenTanjunXsen(後_保険_単純エックス線);
        return this;
    }

    /**
     * 後_保険_リハビリテーションを設定します。
     *
     * @param 後_保険_リハビリテーション 後_保険_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_保険_リハビリテーション(int 後_保険_リハビリテーション) {
        requireNonNull(後_保険_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_リハビリテーション"));
        entity.setAtoHokenRehabilitation(後_保険_リハビリテーション);
        return this;
    }

    /**
     * 後_保険_精神科専門療法を設定します。
     *
     * @param 後_保険_精神科専門療法 後_保険_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_保険_精神科専門療法(int 後_保険_精神科専門療法) {
        requireNonNull(後_保険_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_精神科専門療法"));
        entity.setAtoHokenSeishinkaSemmonRyoho(後_保険_精神科専門療法);
        return this;
    }

    /**
     * 後_公費１_指導管理料等を設定します。
     *
     * @param 後_公費１_指導管理料等 後_公費１_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費１_指導管理料等(int 後_公費１_指導管理料等) {
        requireNonNull(後_公費１_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_指導管理料等"));
        entity.setAtoKohi1ShidoKanriryo(後_公費１_指導管理料等);
        return this;
    }

    /**
     * 後_公費１_単純エックス線を設定します。
     *
     * @param 後_公費１_単純エックス線 後_公費１_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費１_単純エックス線(int 後_公費１_単純エックス線) {
        requireNonNull(後_公費１_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_単純エックス線"));
        entity.setAtoKohi1TanjunXsen(後_公費１_単純エックス線);
        return this;
    }

    /**
     * 後_公費１_リハビリテーションを設定します。
     *
     * @param 後_公費１_リハビリテーション 後_公費１_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費１_リハビリテーション(int 後_公費１_リハビリテーション) {
        requireNonNull(後_公費１_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_リハビリテーション"));
        entity.setAtoKohi1Rehabilitation(後_公費１_リハビリテーション);
        return this;
    }

    /**
     * 後_公費１_精神科専門療法を設定します。
     *
     * @param 後_公費１_精神科専門療法 後_公費１_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費１_精神科専門療法(int 後_公費１_精神科専門療法) {
        requireNonNull(後_公費１_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_精神科専門療法"));
        entity.setAtoKohi1SeishinkaSemmonRyoho(後_公費１_精神科専門療法);
        return this;
    }

    /**
     * 後_公費２_指導管理料等を設定します。
     *
     * @param 後_公費２_指導管理料等 後_公費２_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費２_指導管理料等(int 後_公費２_指導管理料等) {
        requireNonNull(後_公費２_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_指導管理料等"));
        entity.setAtoKohi2ShidoKanriryo(後_公費２_指導管理料等);
        return this;
    }

    /**
     * 後_公費２_単純エックス線を設定します。
     *
     * @param 後_公費２_単純エックス線 後_公費２_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費２_単純エックス線(int 後_公費２_単純エックス線) {
        requireNonNull(後_公費２_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_単純エックス線"));
        entity.setAtoKohi2TanjunXsen(後_公費２_単純エックス線);
        return this;
    }

    /**
     * 後_公費２_リハビリテーションを設定します。
     *
     * @param 後_公費２_リハビリテーション 後_公費２_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費２_リハビリテーション(int 後_公費２_リハビリテーション) {
        requireNonNull(後_公費２_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_リハビリテーション"));
        entity.setAtoKohi2Rehabilitation(後_公費２_リハビリテーション);
        return this;
    }

    /**
     * 後_公費２_精神科専門療法を設定します。
     *
     * @param 後_公費２_精神科専門療法 後_公費２_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費２_精神科専門療法(int 後_公費２_精神科専門療法) {
        requireNonNull(後_公費２_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_精神科専門療法"));
        entity.setAtoKohi2SeishinkaSemmonRyoho(後_公費２_精神科専門療法);
        return this;
    }

    /**
     * 後_公費３_指導管理料等を設定します。
     *
     * @param 後_公費３_指導管理料等 後_公費３_指導管理料等
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費３_指導管理料等(int 後_公費３_指導管理料等) {
        requireNonNull(後_公費３_指導管理料等, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_指導管理料等"));
        entity.setAtoKohi3ShidoKanriryo(後_公費３_指導管理料等);
        return this;
    }

    /**
     * 後_公費３_単純エックス線を設定します。
     *
     * @param 後_公費３_単純エックス線 後_公費３_単純エックス線
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費３_単純エックス線(int 後_公費３_単純エックス線) {
        requireNonNull(後_公費３_単純エックス線, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_単純エックス線"));
        entity.setAtoKohi3TanjunXsen(後_公費３_単純エックス線);
        return this;
    }

    /**
     * 後_公費３_リハビリテーションを設定します。
     *
     * @param 後_公費３_リハビリテーション 後_公費３_リハビリテーション
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費３_リハビリテーション(int 後_公費３_リハビリテーション) {
        requireNonNull(後_公費３_リハビリテーション, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_リハビリテーション"));
        entity.setAtoKohi3Rehabilitation(後_公費３_リハビリテーション);
        return this;
    }

    /**
     * 後_公費３_精神科専門療法を設定します。
     *
     * @param 後_公費３_精神科専門療法 後_公費３_精神科専門療法
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set後_公費３_精神科専門療法(int 後_公費３_精神科専門療法) {
        requireNonNull(後_公費３_精神科専門療法, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_精神科専門療法"));
        entity.setAtoKohi3SeishinkaSemmonRyoho(後_公費３_精神科専門療法);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiTokuteiSinryohiBuilder}
     */
    public KyufujissekiTokuteiSinryohiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiTokuteiSinryohi}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiTokuteiSinryohi}のインスタンス
     */
    public KyufujissekiTokuteiSinryohi build() {
        return new KyufujissekiTokuteiSinryohi(entity, id);
    }
}
