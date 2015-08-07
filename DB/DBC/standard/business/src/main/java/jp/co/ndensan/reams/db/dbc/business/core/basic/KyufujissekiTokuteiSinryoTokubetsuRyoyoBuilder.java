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
 * {@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}の編集を行うビルダークラスです。
 */
public class KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder {

    private final DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity;
    private final KyufujissekiTokuteiSinryoTokubetsuRyoyoIdentifier id;

    /**
     * {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}より{@link KyufujissekiTokuteiSinryoTokubetsuRyoyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity}
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
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set交換情報識別番号(KokanShikibetsuCode 交換情報識別番号) {
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
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set入力識別番号(NyuryokuShikibetsuCode 入力識別番号) {
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
     * 保険・回数を設定します。
     *
     * @param 保険・回数 保険・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set保険・回数(Decimal 保険・回数) {
        requireNonNull(保険・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険・回数"));
        entity.setHokenKaisu(保険・回数);
        return this;
    }

    /**
     * 保険・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 保険・ｻｰﾋﾞｽ単位数 保険・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set保険・ｻｰﾋﾞｽ単位数(int 保険・ｻｰﾋﾞｽ単位数) {
        requireNonNull(保険・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険・ｻｰﾋﾞｽ単位数"));
        entity.setHokenServiceTanisu(保険・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 保険・合計単位数を設定します。
     *
     * @param 保険・合計単位数 保険・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set保険・合計単位数(int 保険・合計単位数) {
        requireNonNull(保険・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("保険・合計単位数"));
        entity.setHokenTotalTanisu(保険・合計単位数);
        return this;
    }

    /**
     * 公費１・回数を設定します。
     *
     * @param 公費１・回数 公費１・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費１・回数(Decimal 公費１・回数) {
        requireNonNull(公費１・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１・回数"));
        entity.setKohi1Kaisu(公費１・回数);
        return this;
    }

    /**
     * 公費１・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費１・ｻｰﾋﾞｽ単位数 公費１・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費１・ｻｰﾋﾞｽ単位数(int 公費１・ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費１・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１・ｻｰﾋﾞｽ単位数"));
        entity.setKohi1ServiceTanisu(公費１・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 公費１・合計単位数を設定します。
     *
     * @param 公費１・合計単位数 公費１・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費１・合計単位数(int 公費１・合計単位数) {
        requireNonNull(公費１・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１・合計単位数"));
        entity.setKohi1TotalTanisu(公費１・合計単位数);
        return this;
    }

    /**
     * 公費２・回数を設定します。
     *
     * @param 公費２・回数 公費２・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費２・回数(Decimal 公費２・回数) {
        requireNonNull(公費２・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２・回数"));
        entity.setKohi2Kaisu(公費２・回数);
        return this;
    }

    /**
     * 公費２・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費２・ｻｰﾋﾞｽ単位数 公費２・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費２・ｻｰﾋﾞｽ単位数(int 公費２・ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費２・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２・ｻｰﾋﾞｽ単位数"));
        entity.setKohi2ServiceTanisu(公費２・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 公費２・合計単位数を設定します。
     *
     * @param 公費２・合計単位数 公費２・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費２・合計単位数(int 公費２・合計単位数) {
        requireNonNull(公費２・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２・合計単位数"));
        entity.setKohi2TotalTanisu(公費２・合計単位数);
        return this;
    }

    /**
     * 公費３・回数を設定します。
     *
     * @param 公費３・回数 公費３・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費３・回数(Decimal 公費３・回数) {
        requireNonNull(公費３・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３・回数"));
        entity.setKohi3Kaisu(公費３・回数);
        return this;
    }

    /**
     * 公費３・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 公費３・ｻｰﾋﾞｽ単位数 公費３・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費３・ｻｰﾋﾞｽ単位数(int 公費３・ｻｰﾋﾞｽ単位数) {
        requireNonNull(公費３・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３・ｻｰﾋﾞｽ単位数"));
        entity.setKohi3ServiceTanisu(公費３・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 公費３・合計単位数を設定します。
     *
     * @param 公費３・合計単位数 公費３・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set公費３・合計単位数(int 公費３・合計単位数) {
        requireNonNull(公費３・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３・合計単位数"));
        entity.setKohi3TotalTanisu(公費３・合計単位数);
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
     * 後・単位数を設定します。
     *
     * @param 後・単位数 後・単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・単位数(Decimal 後・単位数) {
        requireNonNull(後・単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・単位数"));
        entity.setAtoTanisu(後・単位数);
        return this;
    }

    /**
     * 後・保険・回数を設定します。
     *
     * @param 後・保険・回数 後・保険・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・保険・回数(Decimal 後・保険・回数) {
        requireNonNull(後・保険・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・回数"));
        entity.setAtoHokenKaisu(後・保険・回数);
        return this;
    }

    /**
     * 後・保険・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後・保険・ｻｰﾋﾞｽ単位数 後・保険・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・保険・ｻｰﾋﾞｽ単位数(int 後・保険・ｻｰﾋﾞｽ単位数) {
        requireNonNull(後・保険・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・ｻｰﾋﾞｽ単位数"));
        entity.setAtoHokenServiceTanisu(後・保険・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後・保険・合計単位数を設定します。
     *
     * @param 後・保険・合計単位数 後・保険・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・保険・合計単位数(int 後・保険・合計単位数) {
        requireNonNull(後・保険・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・保険・合計単位数"));
        entity.setAtoHokenTotalTanisu(後・保険・合計単位数);
        return this;
    }

    /**
     * 後・公費１・回数を設定します。
     *
     * @param 後・公費１・回数 後・公費１・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費１・回数(Decimal 後・公費１・回数) {
        requireNonNull(後・公費１・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・回数"));
        entity.setAtoKohi1Kaisu(後・公費１・回数);
        return this;
    }

    /**
     * 後・公費１・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後・公費１・ｻｰﾋﾞｽ単位数 後・公費１・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費１・ｻｰﾋﾞｽ単位数(int 後・公費１・ｻｰﾋﾞｽ単位数) {
        requireNonNull(後・公費１・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi1ServiceTanisu(後・公費１・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後・公費１・合計単位数を設定します。
     *
     * @param 後・公費１・合計単位数 後・公費１・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費１・合計単位数(int 後・公費１・合計単位数) {
        requireNonNull(後・公費１・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１・合計単位数"));
        entity.setAtoKohi1TotalTanisu(後・公費１・合計単位数);
        return this;
    }

    /**
     * 後・公費２・回数を設定します。
     *
     * @param 後・公費２・回数 後・公費２・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費２・回数(Decimal 後・公費２・回数) {
        requireNonNull(後・公費２・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・回数"));
        entity.setAtoKohi2Kaisu(後・公費２・回数);
        return this;
    }

    /**
     * 後・公費２・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後・公費２・ｻｰﾋﾞｽ単位数 後・公費２・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費２・ｻｰﾋﾞｽ単位数(int 後・公費２・ｻｰﾋﾞｽ単位数) {
        requireNonNull(後・公費２・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi2ServiceTanisu(後・公費２・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後・公費２・合計単位数を設定します。
     *
     * @param 後・公費２・合計単位数 後・公費２・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費２・合計単位数(int 後・公費２・合計単位数) {
        requireNonNull(後・公費２・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２・合計単位数"));
        entity.setAtoKohi2TotalTanisu(後・公費２・合計単位数);
        return this;
    }

    /**
     * 後・公費３・回数を設定します。
     *
     * @param 後・公費３・回数 後・公費３・回数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費３・回数(Decimal 後・公費３・回数) {
        requireNonNull(後・公費３・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・回数"));
        entity.setAtoKohi3Kaisu(後・公費３・回数);
        return this;
    }

    /**
     * 後・公費３・ｻｰﾋﾞｽ単位数を設定します。
     *
     * @param 後・公費３・ｻｰﾋﾞｽ単位数 後・公費３・ｻｰﾋﾞｽ単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費３・ｻｰﾋﾞｽ単位数(int 後・公費３・ｻｰﾋﾞｽ単位数) {
        requireNonNull(後・公費３・ｻｰﾋﾞｽ単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・ｻｰﾋﾞｽ単位数"));
        entity.setAtoKohi3ServiceTanisu(後・公費３・ｻｰﾋﾞｽ単位数);
        return this;
    }

    /**
     * 後・公費３・合計単位数を設定します。
     *
     * @param 後・公費３・合計単位数 後・公費３・合計単位数
     * @return {@link KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder}
     */
    public KyufujissekiTokuteiSinryoTokubetsuRyoyoBuilder set後・公費３・合計単位数(int 後・公費３・合計単位数) {
        requireNonNull(後・公費３・合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３・合計単位数"));
        entity.setAtoKohi3TotalTanisu(後・公費３・合計単位数);
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
