/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuKyufuTaishoshaGokei}の編集を行うビルダークラスです。
 */
public class KogakuKyufuTaishoshaGokeiBuilder {

    private final DbT3055KogakuKyufuTaishoshaGokeiEntity entity;
    private final KogakuKyufuTaishoshaGokeiIdentifier id;

    /**
     * {@link DbT3055KogakuKyufuTaishoshaGokeiEntity}より{@link KogakuKyufuTaishoshaGokei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3055KogakuKyufuTaishoshaGokeiEntity}
     * @param id {@link KogakuKyufuTaishoshaGokeiIdentifier}
     *
     */
    KogakuKyufuTaishoshaGokeiBuilder(
            DbT3055KogakuKyufuTaishoshaGokeiEntity entity,
            KogakuKyufuTaishoshaGokeiIdentifier id
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
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービス費用合計額合計を設定します。
     *
     * @param サービス費用合計額合計 サービス費用合計額合計
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder setサービス費用合計額合計(Decimal サービス費用合計額合計) {
        requireNonNull(サービス費用合計額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス費用合計額合計"));
        entity.setServiceHiyoGokeiGakuGokei(サービス費用合計額合計);
        return this;
    }

    /**
     * 利用者負担額合計を設定します。
     *
     * @param 利用者負担額合計 利用者負担額合計
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set利用者負担額合計(Decimal 利用者負担額合計) {
        requireNonNull(利用者負担額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額合計"));
        entity.setRiyoshaFutanGakuGokei(利用者負担額合計);
        return this;
    }

    /**
     * 算定基準額を設定します。
     *
     * @param 算定基準額 算定基準額
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set算定基準額(Decimal 算定基準額) {
        requireNonNull(算定基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("算定基準額"));
        entity.setSanteiKijunGaku(算定基準額);
        return this;
    }

    /**
     * 支払済金額合計を設定します。
     *
     * @param 支払済金額合計 支払済金額合計
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set支払済金額合計(Decimal 支払済金額合計) {
        requireNonNull(支払済金額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("支払済金額合計"));
        entity.setShiharaiSumiKingakuGokei(支払済金額合計);
        return this;
    }

    /**
     * 高額支給額を設定します。
     *
     * @param 高額支給額 高額支給額
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set高額支給額(Decimal 高額支給額) {
        requireNonNull(高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額支給額"));
        entity.setKogakuShikyuGaku(高額支給額);
        return this;
    }

    /**
     * 対象者受取年月を設定します。
     *
     * @param 対象者受取年月 対象者受取年月
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set対象者受取年月(FlexibleYearMonth 対象者受取年月) {
        requireNonNull(対象者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者受取年月"));
        entity.setTashoshaUketoriYM(対象者受取年月);
        return this;
    }

    /**
     * 対象者判定審査年月を設定します。
     *
     * @param 対象者判定審査年月 対象者判定審査年月
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set対象者判定審査年月(FlexibleYearMonth 対象者判定審査年月) {
        requireNonNull(対象者判定審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象者判定審査年月"));
        entity.setTaishoshaHanteiShinsaYM(対象者判定審査年月);
        return this;
    }

    /**
     * 世帯集約番号を設定します。
     *
     * @param 世帯集約番号 世帯集約番号
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set世帯集約番号(RString 世帯集約番号) {
        requireNonNull(世帯集約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯集約番号"));
        entity.setSetaiShuyakuNo(世帯集約番号);
        return this;
    }

    /**
     * 境界層対象者フラグを設定します。
     *
     * @param 境界層対象者フラグ 境界層対象者フラグ
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set境界層対象者フラグ(boolean 境界層対象者フラグ) {
        requireNonNull(境界層対象者フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層対象者フラグ"));
        entity.setKyokaisoTaishoshaFlag(境界層対象者フラグ);
        return this;
    }

    /**
     * 社会福祉法人軽減対象フラグを設定します。
     *
     * @param 社会福祉法人軽減対象フラグ 社会福祉法人軽減対象フラグ
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set社会福祉法人軽減対象フラグ(boolean 社会福祉法人軽減対象フラグ) {
        requireNonNull(社会福祉法人軽減対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減対象フラグ"));
        entity.setHojinKeigenTaishoFlag(社会福祉法人軽減対象フラグ);
        return this;
    }

    /**
     * 高額対象外フラグを設定します。
     *
     * @param 高額対象外フラグ 高額対象外フラグ
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set高額対象外フラグ(boolean 高額対象外フラグ) {
        requireNonNull(高額対象外フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("高額対象外フラグ"));
        entity.setKogakuTaishoGaiFlag(高額対象外フラグ);
        return this;
    }

    /**
     * 自動償還対象フラグを設定します。
     *
     * @param 自動償還対象フラグ 自動償還対象フラグ
     * @return {@link KogakuKyufuTaishoshaGokeiBuilder}
     */
    public KogakuKyufuTaishoshaGokeiBuilder set自動償還対象フラグ(boolean 自動償還対象フラグ) {
        requireNonNull(自動償還対象フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("自動償還対象フラグ"));
        entity.setJidoShokanTaishoFlag(自動償還対象フラグ);
        return this;
    }

    /**
     * {@link KogakuKyufuTaishoshaGokei}のインスタンスを生成します。
     *
     * @return {@link KogakuKyufuTaishoshaGokei}のインスタンス
     */
    public KogakuKyufuTaishoshaGokei build() {
        return new KogakuKyufuTaishoshaGokei(entity, id);
    }
}
