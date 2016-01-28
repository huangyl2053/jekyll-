/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiMeisai}の編集を行うビルダークラスです。
 */
public class KyufujissekiMeisaiBuilder {

    private final DbT3018KyufujissekiMeisaiEntity entity;
    private final KyufujissekiMeisaiIdentifier id;

    /**
     * {@link DbT3018KyufujissekiMeisaiEntity}より{@link KyufujissekiMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3018KyufujissekiMeisaiEntity}
     * @param id {@link KyufujissekiMeisaiIdentifier}
     *
     */
    KyufujissekiMeisaiBuilder(
            DbT3018KyufujissekiMeisaiEntity entity,
            KyufujissekiMeisaiIdentifier id
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
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 日数_回数を設定します。
     *
     * @param 日数_回数 日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set日数_回数(Decimal 日数_回数) {
        requireNonNull(日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数_回数"));
        entity.setNissuKaisu(日数_回数);
        return this;
    }

    /**
     * 公費１対象日数_回数を設定します。
     *
     * @param 公費１対象日数_回数 公費１対象日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set公費１対象日数_回数(Decimal 公費１対象日数_回数) {
        requireNonNull(公費１対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象日数_回数"));
        entity.setKohi1TaishoNissuKaisu(公費１対象日数_回数);
        return this;
    }

    /**
     * 公費２対象日数_回数を設定します。
     *
     * @param 公費２対象日数_回数 公費２対象日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set公費２対象日数_回数(Decimal 公費２対象日数_回数) {
        requireNonNull(公費２対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象日数_回数"));
        entity.setKohi2TaishoNissuKaisu(公費２対象日数_回数);
        return this;
    }

    /**
     * 公費３対象日数_回数を設定します。
     *
     * @param 公費３対象日数_回数 公費３対象日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set公費３対象日数_回数(Decimal 公費３対象日数_回数) {
        requireNonNull(公費３対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象日数_回数"));
        entity.setKohi3TaishoNissuKaisu(公費３対象日数_回数);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder setサービス単位数(Decimal サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * 公費１対象サービス単位数を設定します。
     *
     * @param 公費１対象サービス単位数 公費１対象サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set公費１対象サービス単位数(Decimal 公費１対象サービス単位数) {
        requireNonNull(公費１対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象サービス単位数"));
        entity.setKohi1TaishoServiceTanisu(公費１対象サービス単位数);
        return this;
    }

    /**
     * 公費２対象サービス単位数を設定します。
     *
     * @param 公費２対象サービス単位数 公費２対象サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set公費２対象サービス単位数(Decimal 公費２対象サービス単位数) {
        requireNonNull(公費２対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象サービス単位数"));
        entity.setKohi2TaishoServiceTanisu(公費２対象サービス単位数);
        return this;
    }

    /**
     * 公費３対象サービス単位数を設定します。
     *
     * @param 公費３対象サービス単位数 公費３対象サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set公費３対象サービス単位数(Decimal 公費３対象サービス単位数) {
        requireNonNull(公費３対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象サービス単位数"));
        entity.setKohi3TaishoServiceTanisu(公費３対象サービス単位数);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 後_単位数を設定します。
     *
     * @param 後_単位数 後_単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_単位数(Decimal 後_単位数) {
        requireNonNull(後_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数"));
        entity.setAtoTanisu(後_単位数);
        return this;
    }

    /**
     * 後_日数_回数を設定します。
     *
     * @param 後_日数_回数 後_日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_日数_回数(Decimal 後_日数_回数) {
        requireNonNull(後_日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_日数_回数"));
        entity.setAtoNissuKaisu(後_日数_回数);
        return this;
    }

    /**
     * 後_公費１対象日数_回数を設定します。
     *
     * @param 後_公費１対象日数_回数 後_公費１対象日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_公費１対象日数_回数(Decimal 後_公費１対象日数_回数) {
        requireNonNull(後_公費１対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１対象日数_回数"));
        entity.setAtoKohi1TaishoNissuKaisu(後_公費１対象日数_回数);
        return this;
    }

    /**
     * 後_公費２対象日数_回数を設定します。
     *
     * @param 後_公費２対象日数_回数 後_公費２対象日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_公費２対象日数_回数(Decimal 後_公費２対象日数_回数) {
        requireNonNull(後_公費２対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２対象日数_回数"));
        entity.setAtoKohi2TaishoNissukaisu(後_公費２対象日数_回数);
        return this;
    }

    /**
     * 後_公費３対象日数_回数を設定します。
     *
     * @param 後_公費３対象日数_回数 後_公費３対象日数_回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_公費３対象日数_回数(Decimal 後_公費３対象日数_回数) {
        requireNonNull(後_公費３対象日数_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３対象日数_回数"));
        entity.setAtoKohi3TaishoNissuKaisu(後_公費３対象日数_回数);
        return this;
    }

    /**
     * 後_サービス単位数を設定します。
     *
     * @param 後_サービス単位数 後_サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_サービス単位数(Decimal 後_サービス単位数) {
        requireNonNull(後_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数"));
        entity.setAtoServiceTanisu(後_サービス単位数);
        return this;
    }

    /**
     * 後_公費１対象サービス単位数を設定します。
     *
     * @param 後_公費１対象サービス単位数 後_公費１対象サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_公費１対象サービス単位数(Decimal 後_公費１対象サービス単位数) {
        requireNonNull(後_公費１対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１対象サービス単位数"));
        entity.setAtoKohi1TaishoServiceTanisu(後_公費１対象サービス単位数);
        return this;
    }

    /**
     * 後_公費２対象サービス単位数を設定します。
     *
     * @param 後_公費２対象サービス単位数 後_公費２対象サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_公費２対象サービス単位数(Decimal 後_公費２対象サービス単位数) {
        requireNonNull(後_公費２対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２対象サービス単位数"));
        entity.setAtoKohi2TaishoServiceTanisu(後_公費２対象サービス単位数);
        return this;
    }

    /**
     * 後_公費３対象サービス単位数を設定します。
     *
     * @param 後_公費３対象サービス単位数 後_公費３対象サービス単位数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set後_公費３対象サービス単位数(Decimal 後_公費３対象サービス単位数) {
        requireNonNull(後_公費３対象サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３対象サービス単位数"));
        entity.setAtoKohi3TaishoServiceTanisu(後_公費３対象サービス単位数);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiMeisaiBuilder}
     */
    public KyufujissekiMeisaiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiMeisai}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiMeisai}のインスタンス
     */
    public KyufujissekiMeisai build() {
        return new KyufujissekiMeisai(entity, id);
    }
}
