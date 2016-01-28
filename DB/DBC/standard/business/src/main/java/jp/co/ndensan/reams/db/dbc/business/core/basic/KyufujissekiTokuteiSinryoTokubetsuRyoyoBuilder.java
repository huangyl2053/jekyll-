/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
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
 * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}の編集を行うビルダークラスです。
 */
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder {

    private final DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity;
    private final KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id;

    /**
     * {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}より{@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}の編集用Builderクラスを生成します。
     *
     * @param entity
     * {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}
     * @param id {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier}
     *
     */
    KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder(
            DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity,
            KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id
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
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 特定診療情報レコード順次番号を設定します。
     *
     * @param 特定診療情報レコード順次番号 特定診療情報レコード順次番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set特定診療情報レコード順次番号(RString 特定診療情報レコード順次番号) {
        requireNonNull(特定診療情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療情報レコード順次番号"));
        entity.setRecodeJunjiNo(特定診療情報レコード順次番号);
        return this;
    }

    /**
     * 傷病名を設定します。
     *
     * @param 傷病名 傷病名
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set傷病名(RString 傷病名) {
        requireNonNull(傷病名, UrSystemErrorMessages.値がnull.getReplacedMessage("傷病名"));
        entity.setShobyoName(傷病名);
        return this;
    }

    /**
     * 識別番号を設定します。
     *
     * @param 識別番号 識別番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set識別番号(RString 識別番号) {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        entity.setShikibetsuNo(識別番号);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 保険_回数を設定します。
     *
     * @param 保険_回数 保険_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set保険_回数(Decimal 保険_回数) {
        requireNonNull(保険_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_回数"));
        entity.setHokenKaisu(保険_回数);
        return this;
    }

    /**
     * 保険_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 保険_ｻｰﾋﾞｽ単位数 保険_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set保険_ｻｰﾋﾞｽ単位数(int 保険_ｻｰﾋﾞｽ単位数) {
        requireNonNull(保険_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_ｻｰﾋﾞｽ単位数"));
        entity.setHokenServiceTanisu(保険_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 保険_合計単位数を設定します。
     *
     * @param 保険_合計単位数 保険_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set保険_合計単位数(int 保険_合計単位数) {
        requireNonNull(保険_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_合計単位数"));
        entity.setHokenTotalTanisu(保険_合計単位数);
        return this;
    }

    /**
     * 公費１_回数を設定します。
     *
     * @param 公費１_回数 公費１_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費１_回数(Decimal 公費１_回数) {
        requireNonNull(公費１_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_回数"));
        entity.setKohi1Kaisu(公費１_回数);
        return this;
    }

    /**
     * 公費１_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費１_ｻｰﾋﾞｽ単位数 公費１_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費１_ｻｰﾋﾞｽ単位数(int 公費１_ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費１_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_ｻｰﾋﾞｽ単位数"));
        entity.setKohi1ServiceTanisu(公費１_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 公費１_合計単位数を設定します。
     *
     * @param 公費１_合計単位数 公費１_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費１_合計単位数(int 公費１_合計単位数) {
        requireNonNull(公費１_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_合計単位数"));
        entity.setKohi1TotalTanisu(公費１_合計単位数);
        return this;
    }

    /**
     * 公費２_回数を設定します。
     *
     * @param 公費２_回数 公費２_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費２_回数(Decimal 公費２_回数) {
        requireNonNull(公費２_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_回数"));
        entity.setKohi2Kaisu(公費２_回数);
        return this;
    }

    /**
     * 公費２_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費２_ｻｰﾋﾞｽ単位数 公費２_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費２_ｻｰﾋﾞｽ単位数(int 公費２_ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費２_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_ｻｰﾋﾞｽ単位数"));
        entity.setKohi2ServiceTanisu(公費２_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 公費２_合計単位数を設定します。
     *
     * @param 公費２_合計単位数 公費２_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費２_合計単位数(int 公費２_合計単位数) {
        requireNonNull(公費２_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_合計単位数"));
        entity.setKohi2TotalTanisu(公費２_合計単位数);
        return this;
    }

    /**
     * 公費３_回数を設定します。
     *
     * @param 公費３_回数 公費３_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費３_回数(Decimal 公費３_回数) {
        requireNonNull(公費３_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_回数"));
        entity.setKohi3Kaisu(公費３_回数);
        return this;
    }

    /**
     * 公費３_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費３_ｻｰﾋﾞｽ単位数 公費３_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費３_ｻｰﾋﾞｽ単位数(int 公費３_ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費３_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_ｻｰﾋﾞｽ単位数"));
        entity.setKohi3ServiceTanisu(公費３_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 公費３_合計単位数を設定します。
     *
     * @param 公費３_合計単位数 公費３_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費３_合計単位数(int 公費３_合計単位数) {
        requireNonNull(公費３_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_合計単位数"));
        entity.setKohi3TotalTanisu(公費３_合計単位数);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 後_単位数を設定します。
     *
     * @param 後_単位数 後_単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_単位数(Decimal 後_単位数) {
        requireNonNull(後_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数"));
        entity.setAtoTanisu(後_単位数);
        return this;
    }

    /**
     * 後_保険_回数を設定します。
     *
     * @param 後_保険_回数 後_保険_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_保険_回数(Decimal 後_保険_回数) {
        requireNonNull(後_保険_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_回数"));
        entity.setAtoHokenKaisu(後_保険_回数);
        return this;
    }

    /**
     * 後_保険_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_保険_ｻｰﾋﾞｽ単位数 後_保険_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_保険_ｻｰﾋﾞｽ単位数(int 後_保険_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_保険_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_ｻｰﾋﾞｽ単位数"));
        entity.setAtoHokenServiceTanisu(後_保険_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後_保険_合計単位数を設定します。
     *
     * @param 後_保険_合計単位数 後_保険_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_保険_合計単位数(int 後_保険_合計単位数) {
        requireNonNull(後_保険_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_合計単位数"));
        entity.setAtoHokenTotalTanisu(後_保険_合計単位数);
        return this;
    }

    /**
     * 後_公費１_回数を設定します。
     *
     * @param 後_公費１_回数 後_公費１_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費１_回数(Decimal 後_公費１_回数) {
        requireNonNull(後_公費１_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_回数"));
        entity.setAtoKohi1Kaisu(後_公費１_回数);
        return this;
    }

    /**
     * 後_公費１_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_公費１_ｻｰﾋﾞｽ単位数 後_公費１_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費１_ｻｰﾋﾞｽ単位数(int 後_公費１_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_公費１_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi1ServiceTanisu(後_公費１_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後_公費１_合計単位数を設定します。
     *
     * @param 後_公費１_合計単位数 後_公費１_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費１_合計単位数(int 後_公費１_合計単位数) {
        requireNonNull(後_公費１_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_合計単位数"));
        entity.setAtoKohi1TotalTanisu(後_公費１_合計単位数);
        return this;
    }

    /**
     * 後_公費２_回数を設定します。
     *
     * @param 後_公費２_回数 後_公費２_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費２_回数(Decimal 後_公費２_回数) {
        requireNonNull(後_公費２_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_回数"));
        entity.setAtoKohi2Kaisu(後_公費２_回数);
        return this;
    }

    /**
     * 後_公費２_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_公費２_ｻｰﾋﾞｽ単位数 後_公費２_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費２_ｻｰﾋﾞｽ単位数(int 後_公費２_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_公費２_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi2ServiceTanisu(後_公費２_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後_公費２_合計単位数を設定します。
     *
     * @param 後_公費２_合計単位数 後_公費２_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費２_合計単位数(int 後_公費２_合計単位数) {
        requireNonNull(後_公費２_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_合計単位数"));
        entity.setAtoKohi2TotalTanisu(後_公費２_合計単位数);
        return this;
    }

    /**
     * 後_公費３_回数を設定します。
     *
     * @param 後_公費３_回数 後_公費３_回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費３_回数(Decimal 後_公費３_回数) {
        requireNonNull(後_公費３_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_回数"));
        entity.setAtoKohi3Kaisu(後_公費３_回数);
        return this;
    }

    /**
     * 後_公費３_ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後_公費３_ｻｰﾋﾞｽ単位数 後_公費３_ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費３_ｻｰﾋﾞｽ単位数(int 後_公費３_ｻｰﾋﾞｽ単位数) {
        requireNonNull(後_公費３_ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi3ServiceTanisu(後_公費３_ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後_公費３_合計単位数を設定します。
     *
     * @param 後_公費３_合計単位数 後_公費３_合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後_公費３_合計単位数(int 後_公費３_合計単位数) {
        requireNonNull(後_公費３_合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_合計単位数"));
        entity.setAtoKohi3TotalTanisu(後_公費３_合計単位数);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}のインスタンス
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyo build() {
        return new KyufujissekiTokuteiSinryoTokubetsuRyoyo(entity, id);
    }
}
