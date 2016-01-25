/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiShukei}の編集を行うビルダークラスです。
 */
public class KyufujissekiShukeiBuilder {

    private final DbT3033KyufujissekiShukeiEntity entity;
    private final KyufujissekiShukeiIdentifier id;

    /**
     * {@link DbT3033KyufujissekiShukeiEntity}より{@link KyufujissekiShukei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3033KyufujissekiShukeiEntity}
     * @param id {@link KyufujissekiShukeiIdentifier}
     *
     */
    KyufujissekiShukeiBuilder(
            DbT3033KyufujissekiShukeiEntity entity,
            KyufujissekiShukeiIdentifier id
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
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceSyuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス実日数を設定します。
     *
     * @param サービス実日数 サービス実日数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder setサービス実日数(Decimal サービス実日数) {
        requireNonNull(サービス実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス実日数"));
        entity.setServiceJitsunissu(サービス実日数);
        return this;
    }

    /**
     * 計画単位数を設定します。
     *
     * @param 計画単位数 計画単位数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set計画単位数(Decimal 計画単位数) {
        requireNonNull(計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("計画単位数"));
        entity.setPlanTanisu(計画単位数);
        return this;
    }

    /**
     * 限度額管理対象単位数を設定します。
     *
     * @param 限度額管理対象単位数 限度額管理対象単位数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set限度額管理対象単位数(Decimal 限度額管理対象単位数) {
        requireNonNull(限度額管理対象単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象単位数"));
        entity.setGendogakuKanriTaishoTanisu(限度額管理対象単位数);
        return this;
    }

    /**
     * 限度額管理対象外単位数を設定します。
     *
     * @param 限度額管理対象外単位数 限度額管理対象外単位数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set限度額管理対象外単位数(Decimal 限度額管理対象外単位数) {
        requireNonNull(限度額管理対象外単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象外単位数"));
        entity.setGendogakuKanritaishogaiTanisu(限度額管理対象外単位数);
        return this;
    }

    /**
     * 短期入所計画日数を設定します。
     *
     * @param 短期入所計画日数 短期入所計画日数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set短期入所計画日数(Decimal 短期入所計画日数) {
        requireNonNull(短期入所計画日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所計画日数"));
        entity.setTankiNyushoPlanNissu(短期入所計画日数);
        return this;
    }

    /**
     * 短期入所実日数を設定します。
     *
     * @param 短期入所実日数 短期入所実日数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set短期入所実日数(Decimal 短期入所実日数) {
        requireNonNull(短期入所実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所実日数"));
        entity.setTankiNyushoJitsunissu(短期入所実日数);
        return this;
    }

    /**
     * 保険_単位数合計を設定します。
     *
     * @param 保険_単位数合計 保険_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_単位数合計(Decimal 保険_単位数合計) {
        requireNonNull(保険_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_単位数合計"));
        entity.setHokenTanisuTotal(保険_単位数合計);
        return this;
    }

    /**
     * 保険_単位数単価を設定します。
     *
     * @param 保険_単位数単価 保険_単位数単価
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_単位数単価(Decimal 保険_単位数単価) {
        requireNonNull(保険_単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_単位数単価"));
        entity.setHokenTanisuTani(保険_単位数単価);
        return this;
    }

    /**
     * 保険_請求額を設定します。
     *
     * @param 保険_請求額 保険_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_請求額(Decimal 保険_請求額) {
        requireNonNull(保険_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_請求額"));
        entity.setHokenSeikyugaku(保険_請求額);
        return this;
    }

    /**
     * 保険_利用者負担額を設定します。
     *
     * @param 保険_利用者負担額 保険_利用者負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_利用者負担額(Decimal 保険_利用者負担額) {
        requireNonNull(保険_利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_利用者負担額"));
        entity.setHokenRiyoshaFutangaku(保険_利用者負担額);
        return this;
    }

    /**
     * 公費１_単位数合計を設定します。
     *
     * @param 公費１_単位数合計 公費１_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費１_単位数合計(Decimal 公費１_単位数合計) {
        requireNonNull(公費１_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_単位数合計"));
        entity.setKohi1TanisuTotal(公費１_単位数合計);
        return this;
    }

    /**
     * 公費１_請求額を設定します。
     *
     * @param 公費１_請求額 公費１_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費１_請求額(Decimal 公費１_請求額) {
        requireNonNull(公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_請求額"));
        entity.setKohi1Seikyugaku(公費１_請求額);
        return this;
    }

    /**
     * 公費１_本人負担額を設定します。
     *
     * @param 公費１_本人負担額 公費１_本人負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費１_本人負担額(Decimal 公費１_本人負担額) {
        requireNonNull(公費１_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_本人負担額"));
        entity.setKohi1HonninFutangaku(公費１_本人負担額);
        return this;
    }

    /**
     * 公費２_単位数合計を設定します。
     *
     * @param 公費２_単位数合計 公費２_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費２_単位数合計(Decimal 公費２_単位数合計) {
        requireNonNull(公費２_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_単位数合計"));
        entity.setKohi2TanisuTotal(公費２_単位数合計);
        return this;
    }

    /**
     * 公費２_請求額を設定します。
     *
     * @param 公費２_請求額 公費２_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費２_請求額(Decimal 公費２_請求額) {
        requireNonNull(公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_請求額"));
        entity.setKohi2Seikyugaku(公費２_請求額);
        return this;
    }

    /**
     * 公費２_本人負担額を設定します。
     *
     * @param 公費２_本人負担額 公費２_本人負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費２_本人負担額(Decimal 公費２_本人負担額) {
        requireNonNull(公費２_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_本人負担額"));
        entity.setKohi2HonninFutangaku(公費２_本人負担額);
        return this;
    }

    /**
     * 公費３_単位数合計を設定します。
     *
     * @param 公費３_単位数合計 公費３_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費３_単位数合計(Decimal 公費３_単位数合計) {
        requireNonNull(公費３_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_単位数合計"));
        entity.setKohi3TanisuTotal(公費３_単位数合計);
        return this;
    }

    /**
     * 公費３_請求額を設定します。
     *
     * @param 公費３_請求額 公費３_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費３_請求額(Decimal 公費３_請求額) {
        requireNonNull(公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_請求額"));
        entity.setKohi3Seikyugaku(公費３_請求額);
        return this;
    }

    /**
     * 公費３_本人負担額を設定します。
     *
     * @param 公費３_本人負担額 公費３_本人負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費３_本人負担額(Decimal 公費３_本人負担額) {
        requireNonNull(公費３_本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_本人負担額"));
        entity.setKohi3HonninFutangaku(公費３_本人負担額);
        return this;
    }

    /**
     * 保険_出来高単位数合計を設定します。
     *
     * @param 保険_出来高単位数合計 保険_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_出来高単位数合計(Decimal 保険_出来高単位数合計) {
        requireNonNull(保険_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_出来高単位数合計"));
        entity.setHokenDekidakaTanisuTotal(保険_出来高単位数合計);
        return this;
    }

    /**
     * 保険_出来高請求額を設定します。
     *
     * @param 保険_出来高請求額 保険_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_出来高請求額(Decimal 保険_出来高請求額) {
        requireNonNull(保険_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_出来高請求額"));
        entity.setHokenDekidakaSeikyugaku(保険_出来高請求額);
        return this;
    }

    /**
     * 保険_出来高医療費利用者負担額を設定します。
     *
     * @param 保険_出来高医療費利用者負担額 保険_出来高医療費利用者負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set保険_出来高医療費利用者負担額(Decimal 保険_出来高医療費利用者負担額) {
        requireNonNull(保険_出来高医療費利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険_出来高医療費利用者負担額"));
        entity.setHokenDekidakaIryohiRiyoshaFutangaku(保険_出来高医療費利用者負担額);
        return this;
    }

    /**
     * 公費１_出来高単位数合計を設定します。
     *
     * @param 公費１_出来高単位数合計 公費１_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費１_出来高単位数合計(Decimal 公費１_出来高単位数合計) {
        requireNonNull(公費１_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_出来高単位数合計"));
        entity.setKohi1DekidakaTanisuTotal(公費１_出来高単位数合計);
        return this;
    }

    /**
     * 公費１_出来高請求額を設定します。
     *
     * @param 公費１_出来高請求額 公費１_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費１_出来高請求額(Decimal 公費１_出来高請求額) {
        requireNonNull(公費１_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_出来高請求額"));
        entity.setKohi1DekidakaSeikyugaku(公費１_出来高請求額);
        return this;
    }

    /**
     * 公費１_出来高医療費利用者負担額を設定します。
     *
     * @param 公費１_出来高医療費利用者負担額 公費１_出来高医療費利用者負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費１_出来高医療費利用者負担額(Decimal 公費１_出来高医療費利用者負担額) {
        requireNonNull(公費１_出来高医療費利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１_出来高医療費利用者負担額"));
        entity.setKohi1DekidakaIryohiRiyoshaFutangaku(公費１_出来高医療費利用者負担額);
        return this;
    }

    /**
     * 公費２_出来高単位数合計を設定します。
     *
     * @param 公費２_出来高単位数合計 公費２_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費２_出来高単位数合計(Decimal 公費２_出来高単位数合計) {
        requireNonNull(公費２_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_出来高単位数合計"));
        entity.setKohi2DekidakaTanisuTotal(公費２_出来高単位数合計);
        return this;
    }

    /**
     * 公費２_出来高請求額を設定します。
     *
     * @param 公費２_出来高請求額 公費２_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費２_出来高請求額(Decimal 公費２_出来高請求額) {
        requireNonNull(公費２_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_出来高請求額"));
        entity.setKohi2DekidakaSeikyugaku(公費２_出来高請求額);
        return this;
    }

    /**
     * 公費２_出来高医療費本人負担額を設定します。
     *
     * @param 公費２_出来高医療費本人負担額 公費２_出来高医療費本人負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費２_出来高医療費本人負担額(Decimal 公費２_出来高医療費本人負担額) {
        requireNonNull(公費２_出来高医療費本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２_出来高医療費本人負担額"));
        entity.setKohi2DekidakaIryohiRiyoshaFutangaku(公費２_出来高医療費本人負担額);
        return this;
    }

    /**
     * 公費３_出来高単位数合計を設定します。
     *
     * @param 公費３_出来高単位数合計 公費３_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費３_出来高単位数合計(Decimal 公費３_出来高単位数合計) {
        requireNonNull(公費３_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_出来高単位数合計"));
        entity.setKohi3DekidakaTanisuTotal(公費３_出来高単位数合計);
        return this;
    }

    /**
     * 公費３_出来高請求額を設定します。
     *
     * @param 公費３_出来高請求額 公費３_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費３_出来高請求額(Decimal 公費３_出来高請求額) {
        requireNonNull(公費３_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_出来高請求額"));
        entity.setKohi3DekidakaSeikyugaku(公費３_出来高請求額);
        return this;
    }

    /**
     * 公費３_出来高医療費本人負担額を設定します。
     *
     * @param 公費３_出来高医療費本人負担額 公費３_出来高医療費本人負担額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set公費３_出来高医療費本人負担額(Decimal 公費３_出来高医療費本人負担額) {
        requireNonNull(公費３_出来高医療費本人負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３_出来高医療費本人負担額"));
        entity.setKohi3DekidakaIryohiRiyoshaFutangaku(公費３_出来高医療費本人負担額);
        return this;
    }

    /**
     * 後_短期入所実日数を設定します。
     *
     * @param 後_短期入所実日数 後_短期入所実日数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_短期入所実日数(Decimal 後_短期入所実日数) {
        requireNonNull(後_短期入所実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_短期入所実日数"));
        entity.setAtoTankiNyushoJitsunissu(後_短期入所実日数);
        return this;
    }

    /**
     * 後_単位数合計を設定します。
     *
     * @param 後_単位数合計 後_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_単位数合計(Decimal 後_単位数合計) {
        requireNonNull(後_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数合計"));
        entity.setAtoHokenTanisuTotal(後_単位数合計);
        return this;
    }

    /**
     * 後_保険請求分請求額を設定します。
     *
     * @param 後_保険請求分請求額 後_保険請求分請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_保険請求分請求額(Decimal 後_保険請求分請求額) {
        requireNonNull(後_保険請求分請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険請求分請求額"));
        entity.setAtoHokenSeikyugaku(後_保険請求分請求額);
        return this;
    }

    /**
     * 後_公費１_単位数合計を設定します。
     *
     * @param 後_公費１_単位数合計 後_公費１_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費１_単位数合計(Decimal 後_公費１_単位数合計) {
        requireNonNull(後_公費１_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_単位数合計"));
        entity.setAtoKohi1TanisuTotal(後_公費１_単位数合計);
        return this;
    }

    /**
     * 後_公費１_請求額を設定します。
     *
     * @param 後_公費１_請求額 後_公費１_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費１_請求額(Decimal 後_公費１_請求額) {
        requireNonNull(後_公費１_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_請求額"));
        entity.setAtoKohi1Seikyugaku(後_公費１_請求額);
        return this;
    }

    /**
     * 後_公費２_単位数合計を設定します。
     *
     * @param 後_公費２_単位数合計 後_公費２_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費２_単位数合計(Decimal 後_公費２_単位数合計) {
        requireNonNull(後_公費２_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_単位数合計"));
        entity.setAtoKohi2TanisuTotal(後_公費２_単位数合計);
        return this;
    }

    /**
     * 後_公費２_請求額を設定します。
     *
     * @param 後_公費２_請求額 後_公費２_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費２_請求額(Decimal 後_公費２_請求額) {
        requireNonNull(後_公費２_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_請求額"));
        entity.setAtoKohi2Seikyugaku(後_公費２_請求額);
        return this;
    }

    /**
     * 後_公費３_単位数合計を設定します。
     *
     * @param 後_公費３_単位数合計 後_公費３_単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費３_単位数合計(Decimal 後_公費３_単位数合計) {
        requireNonNull(後_公費３_単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_単位数合計"));
        entity.setAtoKohi3TanisuTotal(後_公費３_単位数合計);
        return this;
    }

    /**
     * 後_公費３_請求額を設定します。
     *
     * @param 後_公費３_請求額 後_公費３_請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費３_請求額(Decimal 後_公費３_請求額) {
        requireNonNull(後_公費３_請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_請求額"));
        entity.setAtoKohi3Seikyugaku(後_公費３_請求額);
        return this;
    }

    /**
     * 後_保険_出来高単位数合計を設定します。
     *
     * @param 後_保険_出来高単位数合計 後_保険_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_保険_出来高単位数合計(Decimal 後_保険_出来高単位数合計) {
        requireNonNull(後_保険_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_出来高単位数合計"));
        entity.setAtoHokenDekidakaTanisuTotal(後_保険_出来高単位数合計);
        return this;
    }

    /**
     * 後_保険_出来高請求額を設定します。
     *
     * @param 後_保険_出来高請求額 後_保険_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_保険_出来高請求額(Decimal 後_保険_出来高請求額) {
        requireNonNull(後_保険_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_保険_出来高請求額"));
        entity.setAtoHokenDekidakaSeikyugaku(後_保険_出来高請求額);
        return this;
    }

    /**
     * 後_公費１_出来高単位数合計を設定します。
     *
     * @param 後_公費１_出来高単位数合計 後_公費１_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費１_出来高単位数合計(Decimal 後_公費１_出来高単位数合計) {
        requireNonNull(後_公費１_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_出来高単位数合計"));
        entity.setAtoKohi1DekidakaTanisuTotal(後_公費１_出来高単位数合計);
        return this;
    }

    /**
     * 後_公費１_出来高請求額を設定します。
     *
     * @param 後_公費１_出来高請求額 後_公費１_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費１_出来高請求額(Decimal 後_公費１_出来高請求額) {
        requireNonNull(後_公費１_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費１_出来高請求額"));
        entity.setAtoKohi1DekidakaSeikyugaku(後_公費１_出来高請求額);
        return this;
    }

    /**
     * 後_公費２_出来高単位数合計を設定します。
     *
     * @param 後_公費２_出来高単位数合計 後_公費２_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費２_出来高単位数合計(Decimal 後_公費２_出来高単位数合計) {
        requireNonNull(後_公費２_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_出来高単位数合計"));
        entity.setAtoKohi2DekidakaTanisuTotal(後_公費２_出来高単位数合計);
        return this;
    }

    /**
     * 後_公費２_出来高請求額を設定します。
     *
     * @param 後_公費２_出来高請求額 後_公費２_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費２_出来高請求額(Decimal 後_公費２_出来高請求額) {
        requireNonNull(後_公費２_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費２_出来高請求額"));
        entity.setAtoKohi2DekidakaSeikyugaku(後_公費２_出来高請求額);
        return this;
    }

    /**
     * 後_公費３_出来高単位数合計を設定します。
     *
     * @param 後_公費３_出来高単位数合計 後_公費３_出来高単位数合計
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費３_出来高単位数合計(Decimal 後_公費３_出来高単位数合計) {
        requireNonNull(後_公費３_出来高単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_出来高単位数合計"));
        entity.setAtoKohi3DekidakaTanisuTotal(後_公費３_出来高単位数合計);
        return this;
    }

    /**
     * 後_公費３_出来高請求額を設定します。
     *
     * @param 後_公費３_出来高請求額 後_公費３_出来高請求額
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set後_公費３_出来高請求額(Decimal 後_公費３_出来高請求額) {
        requireNonNull(後_公費３_出来高請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_公費３_出来高請求額"));
        entity.setAtoKohi3DekidakaSeikyugaku(後_公費３_出来高請求額);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiShukeiBuilder}
     */
    public KyufujissekiShukeiBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiShukei}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiShukei}のインスタンス
     */
    public KyufujissekiShukei build() {
        return new KyufujissekiShukei(entity, id);
    }
}
