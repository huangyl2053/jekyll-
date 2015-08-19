/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufuKanrihyo200604}の編集を行うビルダークラスです。
 */
public class KyufuKanrihyo200604Builder {

    private final DbT3015KyufuKanrihyo200604Entity entity;
    private final KyufuKanrihyo200604Identifier id;

    /**
     * {@link DbT3015KyufuKanrihyo200604Entity}より{@link KyufuKanrihyo200604}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3015KyufuKanrihyo200604Entity}
     * @param id {@link KyufuKanrihyo200604Identifier}
     *
     */
    KyufuKanrihyo200604Builder(
            DbT3015KyufuKanrihyo200604Entity entity,
            KyufuKanrihyo200604Identifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 居宅支援事業所番号を設定します。
     *
     * @param 居宅支援事業所番号 居宅支援事業所番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set居宅支援事業所番号(JigyoshaNo 居宅支援事業所番号) {
        requireNonNull(居宅支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅支援事業所番号"));
        entity.setKyotakushienJigyoshoNo(居宅支援事業所番号);
        return this;
    }

    /**
     * 給付管理票情報作成区分コードを設定します。
     *
     * @param 給付管理票情報作成区分コード 給付管理票情報作成区分コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set給付管理票情報作成区分コード(RString 給付管理票情報作成区分コード) {
        requireNonNull(給付管理票情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票情報作成区分コード"));
        entity.setKyufuSakuseiKubunCode(給付管理票情報作成区分コード);
        return this;
    }

    /**
     * 給付管理票作成年月日を設定します。
     *
     * @param 給付管理票作成年月日 給付管理票作成年月日
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set給付管理票作成年月日(FlexibleDate 給付管理票作成年月日) {
        requireNonNull(給付管理票作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票作成年月日"));
        entity.setKyufuSakuseiYMD(給付管理票作成年月日);
        return this;
    }

    /**
     * 給付管理票種別区分コードを設定します。
     *
     * @param 給付管理票種別区分コード 給付管理票種別区分コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set給付管理票種別区分コード(RString 給付管理票種別区分コード) {
        requireNonNull(給付管理票種別区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票種別区分コード"));
        entity.setKyufuShubetsuKubunCode(給付管理票種別区分コード);
        return this;
    }

    /**
     * 給付管理票明細行番号を設定します。
     *
     * @param 給付管理票明細行番号 給付管理票明細行番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set給付管理票明細行番号(RString 給付管理票明細行番号) {
        requireNonNull(給付管理票明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票明細行番号"));
        entity.setKyufuMeisaiLineNo(給付管理票明細行番号);
        return this;
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 被保険者生年月日を設定します。
     *
     * @param 被保険者生年月日 被保険者生年月日
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set被保険者生年月日(FlexibleDate 被保険者生年月日) {
        requireNonNull(被保険者生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者生年月日"));
        entity.setHiHokenshaUmareYMD(被保険者生年月日);
        return this;
    }

    /**
     * 性別コードを設定します。
     *
     * @param 性別コード 性別コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set性別コード(RString 性別コード) {
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));
        entity.setSeibetsuCode(性別コード);
        return this;
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set要介護状態区分コード(RString 要介護状態区分コード) {
        requireNonNull(要介護状態区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分コード"));
        entity.setYoKaigoJotaiKubunCode(要介護状態区分コード);
        return this;
    }

    /**
     * 限度額適用開始年月を設定します。
     *
     * @param 限度額適用開始年月 限度額適用開始年月
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set限度額適用開始年月(FlexibleYearMonth 限度額適用開始年月) {
        requireNonNull(限度額適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額適用開始年月"));
        entity.setGendogakuTekiyoKaishiYM(限度額適用開始年月);
        return this;
    }

    /**
     * 限度額適用終了年月を設定します。
     *
     * @param 限度額適用終了年月 限度額適用終了年月
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set限度額適用終了年月(FlexibleYearMonth 限度額適用終了年月) {
        requireNonNull(限度額適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額適用終了年月"));
        entity.setGendogakuTekiyoShuryoYM(限度額適用終了年月);
        return this;
    }

    /**
     * 居宅・介護予防支給限度額を設定します。
     *
     * @param 居宅・介護予防支給限度額 居宅・介護予防支給限度額
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set居宅_介護予防支給限度額(int 居宅_介護予防支給限度額) {
        requireNonNull(居宅_介護予防支給限度額, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅・介護予防支給限度額"));
        entity.setKyotakuKaigoYoboShikyuGendogaku(居宅_介護予防支給限度額);
        return this;
    }

    /**
     * 居宅サービス計画作成区分コードを設定します。
     *
     * @param 居宅サービス計画作成区分コード 居宅サービス計画作成区分コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set居宅サービス計画作成区分コード(RString 居宅サービス計画作成区分コード) {
        requireNonNull(居宅サービス計画作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成区分コード"));
        entity.setKyotakuServicePlanSakuseiKubunCode(居宅サービス計画作成区分コード);
        return this;
    }

    /**
     * サービス事業所番号を設定します。
     *
     * @param サービス事業所番号 サービス事業所番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder setサービス事業所番号(JigyoshaNo サービス事業所番号) {
        requireNonNull(サービス事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス事業所番号"));
        entity.setServiceJigyoshoNo(サービス事業所番号);
        return this;
    }

    /**
     * 指定/基準該当/地域密着型サービス識別コードを設定します。
     *
     * @param 指定_基準該当_地域密着型サービス識別コード 指定/基準該当/地域密着型サービス識別コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set指定_基準該当_地域密着型サービス識別コード(RString 指定_基準該当_地域密着型サービス識別コード) {
        requireNonNull(指定_基準該当_地域密着型サービス識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定/基準該当/地域密着型サービス識別コード"));
        entity.setShiteiKijungaitoChiikimitchakuServiceShikibetsuCode(指定_基準該当_地域密着型サービス識別コード);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 給付計画単位数／日数を設定します。
     *
     * @param 給付計画単位数／日数 給付計画単位数／日数
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set給付計画単位数_日数(int 給付計画単位数_日数) {
        requireNonNull(給付計画単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画単位数／日数"));
        entity.setKyufuKeikakuTanisuNissu(給付計画単位数_日数);
        return this;
    }

    /**
     * 限度額管理期間における前月までの給付計画日数を設定します。
     *
     * @param 限度額管理期間における前月までの給付計画日数 限度額管理期間における前月までの給付計画日数
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set限度額管理期間における前月までの給付計画日数(Decimal 限度額管理期間における前月までの給付計画日数) {
        requireNonNull(限度額管理期間における前月までの給付計画日数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理期間における前月までの給付計画日数"));
        entity.setKyufuKeikakuNissu(限度額管理期間における前月までの給付計画日数);
        return this;
    }

    /**
     * 指定サービス分小計を設定します。
     *
     * @param 指定サービス分小計 指定サービス分小計
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set指定サービス分小計(int 指定サービス分小計) {
        requireNonNull(指定サービス分小計, UrSystemErrorMessages.値がnull.getReplacedMessage("指定サービス分小計"));
        entity.setShiteiServiceSubTotal(指定サービス分小計);
        return this;
    }

    /**
     * 基準該当サービス分小計を設定します。
     *
     * @param 基準該当サービス分小計 基準該当サービス分小計
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set基準該当サービス分小計(int 基準該当サービス分小計) {
        requireNonNull(基準該当サービス分小計, UrSystemErrorMessages.値がnull.getReplacedMessage("基準該当サービス分小計"));
        entity.setKijyunGaitoServiceSubTotal(基準該当サービス分小計);
        return this;
    }

    /**
     * 給付計画合計単位数/日数を設定します。
     *
     * @param 給付計画合計単位数/日数 給付計画合計単位数/日数
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set給付計画合計単位数_日数(int 給付計画合計単位数_日数) {
        requireNonNull(給付計画合計単位数_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画合計単位数/日数"));
        entity.setKyufuKeikakuTotalTanisuNissu(給付計画合計単位数_日数);
        return this;
    }

    /**
     * 担当介護支援専門員番号を設定します。
     *
     * @param 担当介護支援専門員番号 担当介護支援専門員番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set担当介護支援専門員番号(RString 担当介護支援専門員番号) {
        requireNonNull(担当介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("担当介護支援専門員番号"));
        entity.setTantoKaigoShienSemmoninNo(担当介護支援専門員番号);
        return this;
    }

    /**
     * 委託先の居宅介護支援事業所番号を設定します。
     *
     * @param 委託先の居宅介護支援事業所番号 委託先の居宅介護支援事業所番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set委託先の居宅介護支援事業所番号(JigyoshaNo 委託先の居宅介護支援事業所番号) {
        requireNonNull(委託先の居宅介護支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("委託先の居宅介護支援事業所番号"));
        entity.setKaigoShienJigyoshaNo(委託先の居宅介護支援事業所番号);
        return this;
    }

    /**
     * 委託先の担当介護支援専門員番号を設定します。
     *
     * @param 委託先の担当介護支援専門員番号 委託先の担当介護支援専門員番号
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set委託先の担当介護支援専門員番号(RString 委託先の担当介護支援専門員番号) {
        requireNonNull(委託先の担当介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("委託先の担当介護支援専門員番号"));
        entity.setItakusakiTantoKaigoShienSemmoninNo(委託先の担当介護支援専門員番号);
        return this;
    }

    /**
     * 当初登録年月日を設定します。
     *
     * @param 当初登録年月日 当初登録年月日
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set当初登録年月日(FlexibleDate 当初登録年月日) {
        requireNonNull(当初登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当初登録年月日"));
        entity.setToshoTorokuYMD(当初登録年月日);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufuKanrihyo200604Builder}
     */
    public KyufuKanrihyo200604Builder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufuKanrihyo200604}のインスタンスを生成します。
     *
     * @return {@link KyufuKanrihyo200604}のインスタンス
     */
    public KyufuKanrihyo200604 build() {
        return new KyufuKanrihyo200604(entity, id);
    }
}
