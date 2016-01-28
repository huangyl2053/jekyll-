/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanServicePlan200904}の編集を行うビルダークラスです。
 */
public class ShokanServicePlan200904Builder {

    private final DbT3047ShokanServicePlan200904Entity entity;
    private final ShokanServicePlan200904Identifier id;

    /**
     * {@link DbT3047ShokanServicePlan200904Entity}より{@link ShokanServicePlan200904}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3047ShokanServicePlan200904Entity}
     * @param id {@link ShokanServicePlan200904Identifier}
     *
     */
    ShokanServicePlan200904Builder(
            DbT3047ShokanServicePlan200904Entity entity,
            ShokanServicePlan200904Identifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNp(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 指定_基準該当事業者区分コードを設定します。
     *
     * @param 指定_基準該当事業者区分コード 指定_基準該当事業者区分コード
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set指定_基準該当事業者区分コード(RString 指定_基準該当事業者区分コード) {
        requireNonNull(指定_基準該当事業者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定_基準該当事業者区分コード"));
        entity.setShiteiKijunGaitoJigyoshaKubunCode(指定_基準該当事業者区分コード);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 居宅サービス計画作成依頼届出年月日を設定します。
     *
     * @param 居宅サービス計画作成依頼届出年月日 居宅サービス計画作成依頼届出年月日
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set居宅サービス計画作成依頼届出年月日(FlexibleDate 居宅サービス計画作成依頼届出年月日) {
        requireNonNull(居宅サービス計画作成依頼届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成依頼届出年月日"));
        entity.setKyotakuServiceSakuseiIraiYMD(居宅サービス計画作成依頼届出年月日);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set単位数(int 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 回数を設定します。
     *
     * @param 回数 回数
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set回数(int 回数) {
        requireNonNull(回数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数"));
        entity.setKaisu(回数);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTanisuTanka(単位数単価);
        return this;
    }

    /**
     * サービス単位数合計を設定します。
     *
     * @param サービス単位数合計 サービス単位数合計
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder setサービス単位数合計(int サービス単位数合計) {
        requireNonNull(サービス単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数合計"));
        entity.setServiceTanisuTotal(サービス単位数合計);
        return this;
    }

    /**
     * 請求金額を設定します。
     *
     * @param 請求金額 請求金額
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set請求金額(int 請求金額) {
        requireNonNull(請求金額, UrSystemErrorMessages.値がnull.getReplacedMessage("請求金額"));
        entity.setSeikyuKingaku(請求金額);
        return this;
    }

    /**
     * 担当介護支援専門員番号を設定します。
     *
     * @param 担当介護支援専門員番号 担当介護支援専門員番号
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set担当介護支援専門員番号(RString 担当介護支援専門員番号) {
        requireNonNull(担当介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("担当介護支援専門員番号"));
        entity.setTantokangoshienSemmoninNo(担当介護支援専門員番号);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * 審査方法区分コードを設定します。
     *
     * @param 審査方法区分コード 審査方法区分コード
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set審査方法区分コード(RString 審査方法区分コード) {
        requireNonNull(審査方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分コード"));
        entity.setShinsaHohoKubunCode(審査方法区分コード);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 点数_金額を設定します。
     *
     * @param 点数_金額 点数_金額
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set点数_金額(int 点数_金額) {
        requireNonNull(点数_金額, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_金額"));
        entity.setTensuKingaku(点数_金額);
        return this;
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set支給金額(int 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShikyuKingaku(支給金額);
        return this;
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenTen(増減点);
        return this;
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
        return this;
    }

    /**
     * 増減理由等を設定します。
     *
     * @param 増減理由等 増減理由等
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set増減理由等(RString 増減理由等) {
        requireNonNull(増減理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("増減理由等"));
        entity.setZougenRiyu(増減理由等);
        return this;
    }

    /**
     * 不支給理由等を設定します。
     *
     * @param 不支給理由等 不支給理由等
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set不支給理由等(RString 不支給理由等) {
        requireNonNull(不支給理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("不支給理由等"));
        entity.setFushikyuRiyu(不支給理由等);
        return this;
    }

    /**
     * 購入_改修履歴等を設定します。
     *
     * @param 購入_改修履歴等 購入_改修履歴等
     * @return {@link ShokanServicePlan200904Builder}
     */
    public ShokanServicePlan200904Builder set購入_改修履歴等(RString 購入_改修履歴等) {
        requireNonNull(購入_改修履歴等, UrSystemErrorMessages.値がnull.getReplacedMessage("購入_改修履歴等"));
        entity.setKounyuKaishuRireki(購入_改修履歴等);
        return this;
    }

    /**
     * {@link ShokanServicePlan200904}のインスタンスを生成します。
     *
     * @return {@link ShokanServicePlan200904}のインスタンス
     */
    public ShokanServicePlan200904 build() {
        return new ShokanServicePlan200904(entity, id);
    }
}
