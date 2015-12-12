/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
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
 * {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}の編集を行うビルダークラスです。
 */
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder {

    private final DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity;
    private final KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier id;

    /**
     * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}より{@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}の編集用Builderクラスを生成します。
     *
     * @param entity
     * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}
     * @param id {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier}
     *
     */
    KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder(
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity,
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifier id
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
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 特定入所者介護サービス費用情報レコード順次番号を設定します。
     *
     * @param 特定入所者介護サービス費用情報レコード順次番号 特定入所者介護サービス費用情報レコード順次番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set特定入所者介護サービス費用情報レコード順次番号(RString 特定入所者介護サービス費用情報レコード順次番号) {
        requireNonNull(特定入所者介護サービス費用情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定入所者介護サービス費用情報レコード順次番号"));
        entity.setRecodeJunjiNo(特定入所者介護サービス費用情報レコード順次番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceSyuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス項目コードを設定します。
     *
     * @param サービス項目コード サービス項目コード
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder setサービス項目コード(ServiceKomokuCode サービス項目コード) {
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        entity.setServiceKomokuCode(サービス項目コード);
        return this;
    }

    /**
     * 費用単価を設定します。
     *
     * @param 費用単価 費用単価
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set費用単価(Decimal 費用単価) {
        requireNonNull(費用単価, UrSystemErrorMessages.値がnull.getReplacedMessage("費用単価"));
        entity.setHiyoTanka(費用単価);
        return this;
    }

    /**
     * 負担限度額を設定します。
     *
     * @param 負担限度額 負担限度額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set負担限度額(Decimal 負担限度額) {
        requireNonNull(負担限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("負担限度額"));
        entity.setFutanGendogaku(負担限度額);
        return this;
    }

    /**
     * 日数を設定します。
     *
     * @param 日数 日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set日数(Decimal 日数) {
        requireNonNull(日数, UrSystemErrorMessages.値がnull.getReplacedMessage("日数"));
        entity.setNissu(日数);
        return this;
    }

    /**
     * 公費１日数を設定します。
     *
     * @param 公費１日数 公費１日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費１日数(Decimal 公費１日数) {
        requireNonNull(公費１日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１日数"));
        entity.setKohi1Nissu(公費１日数);
        return this;
    }

    /**
     * 公費２日数を設定します。
     *
     * @param 公費２日数 公費２日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費２日数(Decimal 公費２日数) {
        requireNonNull(公費２日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２日数"));
        entity.setKohi2Nissu(公費２日数);
        return this;
    }

    /**
     * 公費３日数を設定します。
     *
     * @param 公費３日数 公費３日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費３日数(Decimal 公費３日数) {
        requireNonNull(公費３日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３日数"));
        entity.setKohi3Nissu(公費３日数);
        return this;
    }

    /**
     * 費用額を設定します。
     *
     * @param 費用額 費用額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set費用額(Decimal 費用額) {
        requireNonNull(費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額"));
        entity.setHiyogaku(費用額);
        return this;
    }

    /**
     * 保険分請求額を設定します。
     *
     * @param 保険分請求額 保険分請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set保険分請求額(Decimal 保険分請求額) {
        requireNonNull(保険分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分請求額"));
        entity.setHokenbunSeikyugaku(保険分請求額);
        return this;
    }

    /**
     * 公費１負担額_明細を設定します。
     *
     * @param 公費１負担額_明細 公費１負担額_明細
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費１負担額_明細(Decimal 公費１負担額_明細) {
        requireNonNull(公費１負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１負担額_明細"));
        entity.setKohi1Futangaku(公費１負担額_明細);
        return this;
    }

    /**
     * 公費２負担額_明細を設定します。
     *
     * @param 公費２負担額_明細 公費２負担額_明細
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費２負担額_明細(Decimal 公費２負担額_明細) {
        requireNonNull(公費２負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２負担額_明細"));
        entity.setKohi2Futangaku(公費２負担額_明細);
        return this;
    }

    /**
     * 公費３負担額_明細を設定します。
     *
     * @param 公費３負担額_明細 公費３負担額_明細
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費３負担額_明細(Decimal 公費３負担額_明細) {
        requireNonNull(公費３負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３負担額_明細"));
        entity.setKohi3Futangaku(公費３負担額_明細);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * 費用額合計を設定します。
     *
     * @param 費用額合計 費用額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set費用額合計(Decimal 費用額合計) {
        requireNonNull(費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額合計"));
        entity.setHiyogakuTotal(費用額合計);
        return this;
    }

    /**
     * 保険分請求額合計を設定します。
     *
     * @param 保険分請求額合計 保険分請求額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set保険分請求額合計(Decimal 保険分請求額合計) {
        requireNonNull(保険分請求額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険分請求額合計"));
        entity.setHokenbunSeikyugakuTotal(保険分請求額合計);
        return this;
    }

    /**
     * 利用者負担額合計を設定します。
     *
     * @param 利用者負担額合計 利用者負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set利用者負担額合計(Decimal 利用者負担額合計) {
        requireNonNull(利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額合計"));
        entity.setRiyoshaFutangakuTotal(利用者負担額合計);
        return this;
    }

    /**
     * 公費１_負担額合計を設定します。
     *
     * @param 公費１_負担額合計 公費１_負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費１_負担額合計(Decimal 公費１_負担額合計) {
        requireNonNull(公費１_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_負担額合計"));
        entity.setKohi1FutangakuTotal(公費１_負担額合計);
        return this;
    }

    /**
     * 公費１_請求額を設定します。
     *
     * @param 公費１_請求額 公費１_請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費１_請求額(Decimal 公費１_請求額) {
        requireNonNull(公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_請求額"));
        entity.setKohi1Seikyugaku(公費１_請求額);
        return this;
    }

    /**
     * 公費１_本人負担月額を設定します。
     *
     * @param 公費１_本人負担月額 公費１_本人負担月額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費１_本人負担月額(Decimal 公費１_本人負担月額) {
        requireNonNull(公費１_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_本人負担月額"));
        entity.setKohi1HonninFutanGetsugaku(公費１_本人負担月額);
        return this;
    }

    /**
     * 公費２_負担額合計を設定します。
     *
     * @param 公費２_負担額合計 公費２_負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費２_負担額合計(Decimal 公費２_負担額合計) {
        requireNonNull(公費２_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_負担額合計"));
        entity.setKohi2FutangakuTotal(公費２_負担額合計);
        return this;
    }

    /**
     * 公費２_請求額を設定します。
     *
     * @param 公費２_請求額 公費２_請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費２_請求額(Decimal 公費２_請求額) {
        requireNonNull(公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_請求額"));
        entity.setKohi2Seikyugaku(公費２_請求額);
        return this;
    }

    /**
     * 公費２_本人負担月額を設定します。
     *
     * @param 公費２_本人負担月額 公費２_本人負担月額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費２_本人負担月額(Decimal 公費２_本人負担月額) {
        requireNonNull(公費２_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_本人負担月額"));
        entity.setKohi2HonninFutanGetsugaku(公費２_本人負担月額);
        return this;
    }

    /**
     * 公費３_負担額合計を設定します。
     *
     * @param 公費３_負担額合計 公費３_負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費３_負担額合計(Decimal 公費３_負担額合計) {
        requireNonNull(公費３_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_負担額合計"));
        entity.setKohi3FutangakuTotal(公費３_負担額合計);
        return this;
    }

    /**
     * 公費３_請求額を設定します。
     *
     * @param 公費３_請求額 公費３_請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費３_請求額(Decimal 公費３_請求額) {
        requireNonNull(公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_請求額"));
        entity.setKohi3Seikyugaku(公費３_請求額);
        return this;
    }

    /**
     * 公費３_本人負担月額を設定します。
     *
     * @param 公費３_本人負担月額 公費３_本人負担月額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set公費３_本人負担月額(Decimal 公費３_本人負担月額) {
        requireNonNull(公費３_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_本人負担月額"));
        entity.setKohi3HonninFutanGetsugaku(公費３_本人負担月額);
        return this;
    }

    /**
     * 後_費用単価を設定します。
     *
     * @param 後_費用単価 後_費用単価
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_費用単価(Decimal 後_費用単価) {
        requireNonNull(後_費用単価, UrSystemErrorMessages.値がnull.getReplacedMessage("後_費用単価"));
        entity.setAtoHiyoTanka(後_費用単価);
        return this;
    }

    /**
     * 後_日数を設定します。
     *
     * @param 後_日数 後_日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_日数(Decimal 後_日数) {
        requireNonNull(後_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_日数"));
        entity.setAtoNissu(後_日数);
        return this;
    }

    /**
     * 後_公費１日数を設定します。
     *
     * @param 後_公費１日数 後_公費１日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費１日数(Decimal 後_公費１日数) {
        requireNonNull(後_公費１日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１日数"));
        entity.setAtoKohi1Nissu(後_公費１日数);
        return this;
    }

    /**
     * 後_公費２日数を設定します。
     *
     * @param 後_公費２日数 後_公費２日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費２日数(Decimal 後_公費２日数) {
        requireNonNull(後_公費２日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２日数"));
        entity.setAtoKohi2Nissu(後_公費２日数);
        return this;
    }

    /**
     * 後_公費３日数を設定します。
     *
     * @param 後_公費３日数 後_公費３日数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費３日数(Decimal 後_公費３日数) {
        requireNonNull(後_公費３日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３日数"));
        entity.setAtoKohi3Nissu(後_公費３日数);
        return this;
    }

    /**
     * 後_費用額を設定します。
     *
     * @param 後_費用額 後_費用額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_費用額(Decimal 後_費用額) {
        requireNonNull(後_費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_費用額"));
        entity.setAtoHiyogaku(後_費用額);
        return this;
    }

    /**
     * 後_保険分請求額を設定します。
     *
     * @param 後_保険分請求額 後_保険分請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_保険分請求額(Decimal 後_保険分請求額) {
        requireNonNull(後_保険分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険分請求額"));
        entity.setAtoHokenbunSeikyugaku(後_保険分請求額);
        return this;
    }

    /**
     * 後_公費１負担額_明細を設定します。
     *
     * @param 後_公費１負担額_明細 後_公費１負担額_明細
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費１負担額_明細(Decimal 後_公費１負担額_明細) {
        requireNonNull(後_公費１負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１負担額_明細"));
        entity.setAtoKohi1Futangaku(後_公費１負担額_明細);
        return this;
    }

    /**
     * 後_公費２負担額_明細を設定します。
     *
     * @param 後_公費２負担額_明細 後_公費２負担額_明細
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費２負担額_明細(Decimal 後_公費２負担額_明細) {
        requireNonNull(後_公費２負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２負担額_明細"));
        entity.setAtoKohi2Futangaku(後_公費２負担額_明細);
        return this;
    }

    /**
     * 後_公費３負担額_明細を設定します。
     *
     * @param 後_公費３負担額_明細 後_公費３負担額_明細
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費３負担額_明細(Decimal 後_公費３負担額_明細) {
        requireNonNull(後_公費３負担額_明細, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３負担額_明細"));
        entity.setAtoKohi3Futangaku(後_公費３負担額_明細);
        return this;
    }

    /**
     * 後_利用者負担額を設定します。
     *
     * @param 後_利用者負担額 後_利用者負担額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_利用者負担額(Decimal 後_利用者負担額) {
        requireNonNull(後_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_利用者負担額"));
        entity.setAtoRiyoshaFutangaku(後_利用者負担額);
        return this;
    }

    /**
     * 後_費用額合計を設定します。
     *
     * @param 後_費用額合計 後_費用額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_費用額合計(Decimal 後_費用額合計) {
        requireNonNull(後_費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_費用額合計"));
        entity.setAtoHiyogakuTotal(後_費用額合計);
        return this;
    }

    /**
     * 後_保険分請求額合計を設定します。
     *
     * @param 後_保険分請求額合計 後_保険分請求額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_保険分請求額合計(Decimal 後_保険分請求額合計) {
        requireNonNull(後_保険分請求額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険分請求額合計"));
        entity.setAtoHokenbunSeikyugakuTotal(後_保険分請求額合計);
        return this;
    }

    /**
     * 後_利用者負担額合計を設定します。
     *
     * @param 後_利用者負担額合計 後_利用者負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_利用者負担額合計(Decimal 後_利用者負担額合計) {
        requireNonNull(後_利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_利用者負担額合計"));
        entity.setAtoRiyoshaFutangakuTotal(後_利用者負担額合計);
        return this;
    }

    /**
     * 後_公費１_負担額合計を設定します。
     *
     * @param 後_公費１_負担額合計 後_公費１_負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費１_負担額合計(Decimal 後_公費１_負担額合計) {
        requireNonNull(後_公費１_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_負担額合計"));
        entity.setAtoKohi1FutangakuTotal(後_公費１_負担額合計);
        return this;
    }

    /**
     * 後_公費１_請求額を設定します。
     *
     * @param 後_公費１_請求額 後_公費１_請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費１_請求額(Decimal 後_公費１_請求額) {
        requireNonNull(後_公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_請求額"));
        entity.setAtoKohi1Seikyugaku(後_公費１_請求額);
        return this;
    }

    /**
     * 後_公費１_本人負担月額を設定します。
     *
     * @param 後_公費１_本人負担月額 後_公費１_本人負担月額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費１_本人負担月額(Decimal 後_公費１_本人負担月額) {
        requireNonNull(後_公費１_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_本人負担月額"));
        entity.setAtoKohi1HonninFutanGetsugaku(後_公費１_本人負担月額);
        return this;
    }

    /**
     * 後_公費２_負担額合計を設定します。
     *
     * @param 後_公費２_負担額合計 後_公費２_負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費２_負担額合計(Decimal 後_公費２_負担額合計) {
        requireNonNull(後_公費２_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_負担額合計"));
        entity.setAtoKohi2FutangakuTotal(後_公費２_負担額合計);
        return this;
    }

    /**
     * 後_公費２_請求額を設定します。
     *
     * @param 後_公費２_請求額 後_公費２_請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費２_請求額(Decimal 後_公費２_請求額) {
        requireNonNull(後_公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_請求額"));
        entity.setAtoKohi2Seikyugaku(後_公費２_請求額);
        return this;
    }

    /**
     * 後_公費２_本人負担月額を設定します。
     *
     * @param 後_公費２_本人負担月額 後_公費２_本人負担月額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費２_本人負担月額(Decimal 後_公費２_本人負担月額) {
        requireNonNull(後_公費２_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_本人負担月額"));
        entity.setAtoKohi2HonninFutanGetsugaku(後_公費２_本人負担月額);
        return this;
    }

    /**
     * 後_公費３_負担額合計を設定します。
     *
     * @param 後_公費３_負担額合計 後_公費３_負担額合計
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費３_負担額合計(Decimal 後_公費３_負担額合計) {
        requireNonNull(後_公費３_負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_負担額合計"));
        entity.setAtoKohi3FutangakuTotal(後_公費３_負担額合計);
        return this;
    }

    /**
     * 後_公費３_請求額を設定します。
     *
     * @param 後_公費３_請求額 後_公費３_請求額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費３_請求額(Decimal 後_公費３_請求額) {
        requireNonNull(後_公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_請求額"));
        entity.setAtoKohi3Seikyugaku(後_公費３_請求額);
        return this;
    }

    /**
     * 後_公費３_本人負担月額を設定します。
     *
     * @param 後_公費３_本人負担月額 後_公費３_本人負担月額
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set後_公費３_本人負担月額(Decimal 後_公費３_本人負担月額) {
        requireNonNull(後_公費３_本人負担月額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_本人負担月額"));
        entity.setAtoKohi3HonninFutanGetsugaku(後_公費３_本人負担月額);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}のインスタンス
     */
    public KyufujissekiTokuteiNyushosyaKaigoServiceHiyo build() {
        return new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(entity, id);
    }
}
