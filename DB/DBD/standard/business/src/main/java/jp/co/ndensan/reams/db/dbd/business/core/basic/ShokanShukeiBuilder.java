/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanShukei}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 yebangqiang
 */
public class ShokanShukeiBuilder {

    private final DbT3053ShokanShukeiEntity entity;
    private final ShokanShukeiIdentifier id;

    /**
     * {@link DbT3053ShokanShukeiEntity}より{@link ShokanShukei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3053ShokanShukeiEntity}
     * @param id {@link ShokanShukeiIdentifier}
     *
     */
    ShokanShukeiBuilder(
            DbT3053ShokanShukeiEntity entity,
            ShokanShukeiIdentifier id
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
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
//        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * サービス実日数を設定します。
     *
     * @param サービス実日数 サービス実日数
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder setサービス実日数(int サービス実日数) {
        requireNonNull(サービス実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス実日数"));
        entity.setServiceJitsunissu(サービス実日数);
        return this;
    }

    /**
     * 計画単位数を設定します。
     *
     * @param 計画単位数 計画単位数
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set計画単位数(int 計画単位数) {
        requireNonNull(計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("計画単位数"));
        entity.setPlanTanisu(計画単位数);
        return this;
    }

    /**
     * 限度額管理対象単位数を設定します。
     *
     * @param 限度額管理対象単位数 限度額管理対象単位数
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set限度額管理対象単位数(int 限度額管理対象単位数) {
        requireNonNull(限度額管理対象単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象単位数"));
        entity.setGendogakuKanriTaishoTanisu(限度額管理対象単位数);
        return this;
    }

    /**
     * 限度額管理対象外単位数を設定します。
     *
     * @param 限度額管理対象外単位数 限度額管理対象外単位数
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set限度額管理対象外単位数(int 限度額管理対象外単位数) {
        requireNonNull(限度額管理対象外単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象外単位数"));
        entity.setGendogakuKanriTaishogaiTanisu(限度額管理対象外単位数);
        return this;
    }

    /**
     * 短期入所計画日数を設定します。
     *
     * @param 短期入所計画日数 短期入所計画日数
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set短期入所計画日数(int 短期入所計画日数) {
        requireNonNull(短期入所計画日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所計画日数"));
        entity.setTankiNyushoPlanNissu(短期入所計画日数);
        return this;
    }

    /**
     * 短期入所実日数を設定します。
     *
     * @param 短期入所実日数 短期入所実日数
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set短期入所実日数(int 短期入所実日数) {
        requireNonNull(短期入所実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所実日数"));
        entity.setTankiNyushoJitsunissu(短期入所実日数);
        return this;
    }

    /**
     * 単位数合計を設定します。
     *
     * @param 単位数合計 単位数合計
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set単位数合計(int 単位数合計) {
        requireNonNull(単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数合計"));
        entity.setTanisuTotal(単位数合計);
        return this;
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set単位数単価(Decimal 単位数単価) {
        entity.setTanisuTanka(単位数単価);
        return this;
    }

    /**
     * 請求額を設定します。
     *
     * @param 請求額 請求額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set請求額(Decimal 請求額) {
        entity.setSeikyugaku(請求額);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
        return this;
    }

    /**
     * 出来高医療費単位数合計を設定します。
     *
     * @param 出来高医療費単位数合計 出来高医療費単位数合計
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set出来高医療費単位数合計(int 出来高医療費単位数合計) {
        requireNonNull(出来高医療費単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("出来高医療費単位数合計"));
        entity.setDekidakaIryohiTanisuTotal(出来高医療費単位数合計);
        return this;
    }

    /**
     * 出来高医療費請求額を設定します。
     *
     * @param 出来高医療費請求額 出来高医療費請求額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set出来高医療費請求額(Decimal 出来高医療費請求額) {
        entity.setDekidakaIryohiSeikyugaku(出来高医療費請求額);
        return this;
    }

    /**
     * 出来高医療費利用者負担額を設定します。
     *
     * @param 出来高医療費利用者負担額 出来高医療費利用者負担額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set出来高医療費利用者負担額(Decimal 出来高医療費利用者負担額) {
        entity.setDekidakaIryohiRiyoshaFutangaku(出来高医療費利用者負担額);
        return this;
    }

    /**
     * 審査方法区分コードを設定します。
     *
     * @param 審査方法区分コード 審査方法区分コード
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set審査方法区分コード(RString 審査方法区分コード) {
        requireNonNull(審査方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分コード"));
        entity.setShinsaHohoKubunCode(審査方法区分コード);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 点数_金額を設定します。
     *
     * @param 点数_金額 点数_金額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set点数_金額(int 点数_金額) {
        requireNonNull(点数_金額, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_金額"));
        entity.setTensuKingaku(点数_金額);
        return this;
    }

    /**
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set支払金額(int 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShikyuKingaku(支払金額);
        return this;
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenten(増減点);
        return this;
    }

    /**
     * 請求額差額金額を設定します。
     *
     * @param 請求額差額金額 請求額差額金額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set請求額差額金額(int 請求額差額金額) {
        requireNonNull(請求額差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("請求額差額金額"));
        entity.setSeikyugakuSagakuKingaku(請求額差額金額);
        return this;
    }

    /**
     * 出来高請求額差額金額を設定します。
     *
     * @param 出来高請求額差額金額 出来高請求額差額金額
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set出来高請求額差額金額(int 出来高請求額差額金額) {
        requireNonNull(出来高請求額差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("出来高請求額差額金額"));
        entity.setDekidakaSeikyugakuSagaku(出来高請求額差額金額);
        return this;
    }

    /**
     * 増減理由等を設定します。
     *
     * @param 増減理由等 増減理由等
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set増減理由等(RString 増減理由等) {
        requireNonNull(増減理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("増減理由等"));
        entity.setZougenRiyu(増減理由等);
        return this;
    }

    /**
     * 不支給理由等を設定します。
     *
     * @param 不支給理由等 不支給理由等
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set不支給理由等(RString 不支給理由等) {
        requireNonNull(不支給理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("不支給理由等"));
        entity.setHushikyuRiyu(不支給理由等);
        return this;
    }

    /**
     * 購入_改修履歴等を設定します。
     *
     * @param 購入_改修履歴等 購入_改修履歴等
     * @return {@link ShokanShukeiBuilder}
     */
    public ShokanShukeiBuilder set購入_改修履歴等(RString 購入_改修履歴等) {
        requireNonNull(購入_改修履歴等, UrSystemErrorMessages.値がnull.getReplacedMessage("購入_改修履歴等"));
        entity.setKounyuKaishuRireki(購入_改修履歴等);
        return this;
    }

    /**
     * {@link ShokanShukei}のインスタンスを生成します。
     *
     * @return {@link ShokanShukei}のインスタンス
     */
    public ShokanShukei build() {
        return new ShokanShukei(entity, id);
    }
}
