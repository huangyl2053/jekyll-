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
 * {@link KyufujissekiMeisaiJushochiTokurei}の編集を行うビルダークラスです。
 */
public class KyufujissekiMeisaiJushochiTokureiBuilder {

    private final DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity;
    private final KyufujissekiMeisaiJushochiTokureiIdentifier id;

    /**
     * {@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}より{@link KyufujissekiMeisaiJushochiTokurei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3106KyufujissekiMeisaiJushochiTokureiEntity}
     * @param id {@link KyufujissekiMeisaiJushochiTokureiIdentifier}
     *
     */
    KyufujissekiMeisaiJushochiTokureiBuilder(
            DbT3106KyufujissekiMeisaiJushochiTokureiEntity entity,
            KyufujissekiMeisaiJushochiTokureiIdentifier id
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
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set交換情報識別番号(KokanShikibetsuCode 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set入力識別番号(NyuryokuShikibetsuCode 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 日数・回数を設定します。
     *
     * @param 日数・回数 日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set日数・回数(Decimal 日数・回数) {
        requireNonNull(日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数・回数"));
        entity.setNissuKaisu(日数・回数);
        return this;
    }

    /**
     * 公費１対象日数・回数を設定します。
     *
     * @param 公費１対象日数・回数 公費１対象日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set公費１対象日数・回数(Decimal 公費１対象日数・回数) {
        requireNonNull(公費１対象日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象日数・回数"));
        entity.setKohi1TaishoNissuKaisu(公費１対象日数・回数);
        return this;
    }

    /**
     * 公費２対象日数・回数を設定します。
     *
     * @param 公費２対象日数・回数 公費２対象日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set公費２対象日数・回数(Decimal 公費２対象日数・回数) {
        requireNonNull(公費２対象日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象日数・回数"));
        entity.setKohi2TaishoNissuKaisu(公費２対象日数・回数);
        return this;
    }

    /**
     * 公費３対象日数・回数を設定します。
     *
     * @param 公費３対象日数・回数 公費３対象日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set公費３対象日数・回数(Decimal 公費３対象日数・回数) {
        requireNonNull(公費３対象日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象日数・回数"));
        entity.setKohi3TaishoNissuKaisu(公費３対象日数・回数);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * 公費１対象サービス単位数を設定します。
     *
     * @param 公費１対象サービス単位数 公費１対象サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set公費１対象サービス単位数(int 公費１対象サービス単位数) {
        requireNonNull(公費１対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象サービス単位数"));
        entity.setKohi1TaishoServiceTanisu(公費１対象サービス単位数);
        return this;
    }

    /**
     * 公費２対象サービス単位数を設定します。
     *
     * @param 公費２対象サービス単位数 公費２対象サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set公費２対象サービス単位数(int 公費２対象サービス単位数) {
        requireNonNull(公費２対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象サービス単位数"));
        entity.setKohi2TaishoServiceTanisu(公費２対象サービス単位数);
        return this;
    }

    /**
     * 公費３対象サービス単位数を設定します。
     *
     * @param 公費３対象サービス単位数 公費３対象サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set公費３対象サービス単位数(int 公費３対象サービス単位数) {
        requireNonNull(公費３対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象サービス単位数"));
        entity.setKohi3TaishoServiceTanisu(公費３対象サービス単位数);
        return this;
    }

    /**
     * 施設所在保険者番号を設定します。
     *
     * @param 施設所在保険者番号 施設所在保険者番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set施設所在保険者番号(ShoKisaiHokenshaNo 施設所在保険者番号) {
        requireNonNull(施設所在保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("施設所在保険者番号"));
        entity.setShisetsuShozaiHokenshaNo(施設所在保険者番号);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 後・単位数を設定します。
     *
     * @param 後・単位数 後・単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・単位数(Decimal 後・単位数) {
        requireNonNull(後・単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・単位数"));
        entity.setAtoTanisu(後・単位数);
        return this;
    }

    /**
     * 後・日数・回数を設定します。
     *
     * @param 後・日数・回数 後・日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・日数・回数(Decimal 後・日数・回数) {
        requireNonNull(後・日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・日数・回数"));
        entity.setAtoNissuKaisu(後・日数・回数);
        return this;
    }

    /**
     * 後・公費１対象日数・回数を設定します。
     *
     * @param 後・公費１対象日数・回数 後・公費１対象日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・公費１対象日数・回数(Decimal 後・公費１対象日数・回数) {
        requireNonNull(後・公費１対象日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１対象日数・回数"));
        entity.setAtoKohi1TaishoNissuKaisu(後・公費１対象日数・回数);
        return this;
    }

    /**
     * 後・公費２対象日数・回数を設定します。
     *
     * @param 後・公費２対象日数・回数 後・公費２対象日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・公費２対象日数・回数(Decimal 後・公費２対象日数・回数) {
        requireNonNull(後・公費２対象日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２対象日数・回数"));
        entity.setAtoKohi2TaishoNissukaisu(後・公費２対象日数・回数);
        return this;
    }

    /**
     * 後・公費３対象日数・回数を設定します。
     *
     * @param 後・公費３対象日数・回数 後・公費３対象日数・回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・公費３対象日数・回数(Decimal 後・公費３対象日数・回数) {
        requireNonNull(後・公費３対象日数・回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３対象日数・回数"));
        entity.setAtoKohi3TaishoNissuKaisu(後・公費３対象日数・回数);
        return this;
    }

    /**
     * 後・サービス単位数を設定します。
     *
     * @param 後・サービス単位数 後・サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・サービス単位数(int 後・サービス単位数) {
        requireNonNull(後・サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・サービス単位数"));
        entity.setAtoServiceTanisu(後・サービス単位数);
        return this;
    }

    /**
     * 後・公費１対象サービス単位数を設定します。
     *
     * @param 後・公費１対象サービス単位数 後・公費１対象サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・公費１対象サービス単位数(int 後・公費１対象サービス単位数) {
        requireNonNull(後・公費１対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費１対象サービス単位数"));
        entity.setAtoKohi1TaishoServiceTanisu(後・公費１対象サービス単位数);
        return this;
    }

    /**
     * 後・公費２対象サービス単位数を設定します。
     *
     * @param 後・公費２対象サービス単位数 後・公費２対象サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・公費２対象サービス単位数(int 後・公費２対象サービス単位数) {
        requireNonNull(後・公費２対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費２対象サービス単位数"));
        entity.setAtoKohi2TaishoServiceTanisu(後・公費２対象サービス単位数);
        return this;
    }

    /**
     * 後・公費３対象サービス単位数を設定します。
     *
     * @param 後・公費３対象サービス単位数 後・公費３対象サービス単位数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set後・公費３対象サービス単位数(int 後・公費３対象サービス単位数) {
        requireNonNull(後・公費３対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後・公費３対象サービス単位数"));
        entity.setAtoKohi3TaishoServiceTanisu(後・公費３対象サービス単位数);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiMeisaiJushochiTokureiBuilder}
     */
    public KyufujissekiMeisaiJushochiTokureiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiMeisaiJushochiTokurei}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiMeisaiJushochiTokurei}のインスタンス
     */
    public KyufujissekiMeisaiJushochiTokurei build() {
        return new KyufujissekiMeisaiJushochiTokurei(entity, id);
    }
}
