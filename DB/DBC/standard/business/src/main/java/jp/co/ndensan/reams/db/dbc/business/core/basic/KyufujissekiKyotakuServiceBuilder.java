/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiKyotakuService}の編集を行うビルダークラスです。
 */
public class KyufujissekiKyotakuServiceBuilder {

    private final DbT3025KyufujissekiKyotakuServiceEntity entity;
    private final KyufujissekiKyotakuServiceIdentifier id;

    /**
     * {@link DbT3025KyufujissekiKyotakuServiceEntity}より{@link KyufujissekiKyotakuService}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3025KyufujissekiKyotakuServiceEntity}
     * @param id {@link KyufujissekiKyotakuServiceIdentifier}
     *
     */
    KyufujissekiKyotakuServiceBuilder(
            DbT3025KyufujissekiKyotakuServiceEntity entity,
            KyufujissekiKyotakuServiceIdentifier id
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
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * サービス計画費明細行番号を設定します。
     *
     * @param サービス計画費明細行番号 サービス計画費明細行番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder setサービス計画費明細行番号(RString サービス計画費明細行番号) {
        requireNonNull(サービス計画費明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費明細行番号"));
        entity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
        return this;
    }

    /**
     * 指定_基準該当等事業所区分コードを設定します。
     *
     * @param 指定_基準該当等事業所区分コード 指定_基準該当等事業所区分コード
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set指定_基準該当等事業所区分コード(RString 指定_基準該当等事業所区分コード) {
        requireNonNull(指定_基準該当等事業所区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定_基準該当等事業所区分コード"));
        entity.setShiteiKijunGaitoJigyoshaKubunCode(指定_基準該当等事業所区分コード);
        return this;
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTanisuTanka(単位数単価);
        return this;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日を設定します。
     *
     * @param 居宅サービス計画作成依頼届出年月日 居宅サービス計画作成依頼届出年月日
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set居宅サービス計画作成依頼届出年月日(FlexibleDate 居宅サービス計画作成依頼届出年月日) {
        requireNonNull(居宅サービス計画作成依頼届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成依頼届出年月日"));
        entity.setKyotakuServiceSakuseiIraiYMD(居宅サービス計画作成依頼届出年月日);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 回数を設定します。
     *
     * @param 回数 回数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set回数(Decimal 回数) {
        requireNonNull(回数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数"));
        entity.setKaisu(回数);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder setサービス単位数(Decimal サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * サービス単位数合計を設定します。
     *
     * @param サービス単位数合計 サービス単位数合計
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder setサービス単位数合計(Decimal サービス単位数合計) {
        requireNonNull(サービス単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数合計"));
        entity.setServiceTanisuTotal(サービス単位数合計);
        return this;
    }

    /**
     * 請求金額を設定します。
     *
     * @param 請求金額 請求金額
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set請求金額(Decimal 請求金額) {
        requireNonNull(請求金額, UrSystemErrorMessages.値がnull.getReplacedMessage("請求金額"));
        entity.setSeikyuKingaku(請求金額);
        return this;
    }

    /**
     * 担当介護支援専門員番号を設定します。
     *
     * @param 担当介護支援専門員番号 担当介護支援専門員番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set担当介護支援専門員番号(RString 担当介護支援専門員番号) {
        requireNonNull(担当介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("担当介護支援専門員番号"));
        entity.setTantouKaigoShienSemmoninNo(担当介護支援専門員番号);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 後_単位数を設定します。
     *
     * @param 後_単位数 後_単位数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set後_単位数(Decimal 後_単位数) {
        requireNonNull(後_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数"));
        entity.setAtoTanisu(後_単位数);
        return this;
    }

    /**
     * 後_回数を設定します。
     *
     * @param 後_回数 後_回数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set後_回数(Decimal 後_回数) {
        requireNonNull(後_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_回数"));
        entity.setAtoKaisu(後_回数);
        return this;
    }

    /**
     * 後_サービス単位数を設定します。
     *
     * @param 後_サービス単位数 後_サービス単位数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set後_サービス単位数(Decimal 後_サービス単位数) {
        requireNonNull(後_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数"));
        entity.setAtoServiceTanisu(後_サービス単位数);
        return this;
    }

    /**
     * 後_サービス単位数合計を設定します。
     *
     * @param 後_サービス単位数合計 後_サービス単位数合計
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set後_サービス単位数合計(Decimal 後_サービス単位数合計) {
        requireNonNull(後_サービス単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数合計"));
        entity.setAtoServiceTanisuTotal(後_サービス単位数合計);
        return this;
    }

    /**
     * 後_請求金額を設定します。
     *
     * @param 後_請求金額 後_請求金額
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set後_請求金額(Decimal 後_請求金額) {
        requireNonNull(後_請求金額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_請求金額"));
        entity.setAtoSeikyuKingaku(後_請求金額);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiKyotakuServiceBuilder}
     */
    public KyufujissekiKyotakuServiceBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiKyotakuService}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiKyotakuService}のインスタンス
     */
    public KyufujissekiKyotakuService build() {
        return new KyufujissekiKyotakuService(entity, id);
    }
}
