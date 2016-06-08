/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link TandokuJoseikinKyufuKettei}の編集を行うビルダークラスです。
 */
public class TandokuJoseikinKyufuKetteiBuilder {

    private final DbT3097TandokuJoseikinKyufuKetteiEntity entity;
    private final TandokuJoseikinKyufuKetteiIdentifier id;

    /**
     * {@link DbT3097TandokuJoseikinKyufuKetteiEntity}より{@link TandokuJoseikinKyufuKettei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3097TandokuJoseikinKyufuKetteiEntity}
     * @param id {@link TandokuJoseikinKyufuKetteiIdentifier}
     *
     */
    TandokuJoseikinKyufuKetteiBuilder(
            DbT3097TandokuJoseikinKyufuKetteiEntity entity,
            TandokuJoseikinKyufuKetteiIdentifier id
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
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 有効期限を設定します。
     *
     * @param 有効期限 有効期限
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set有効期限(FlexibleDate 有効期限) {
        requireNonNull(有効期限, UrSystemErrorMessages.値がnull.getReplacedMessage("有効期限"));
        entity.setYukoKigenYMD(有効期限);
        return this;
    }

    /**
     * 利用者負担_決定区分を設定します。
     *
     * @param 利用者負担_決定区分 利用者負担_決定区分
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set利用者負担_決定区分(RString 利用者負担_決定区分) {
        requireNonNull(利用者負担_決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担_決定区分"));
        entity.setRiyoshaFutan_KetteiKubun(利用者負担_決定区分);
        return this;
    }

    /**
     * 利用者負担_不承認理由を設定します。
     *
     * @param 利用者負担_不承認理由 利用者負担_不承認理由
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set利用者負担_不承認理由(RString 利用者負担_不承認理由) {
        requireNonNull(利用者負担_不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担_不承認理由"));
        entity.setRiyoshaFutan_FuShoninRiyu(利用者負担_不承認理由);
        return this;
    }

    /**
     * 公費受給者番号を設定します。
     *
     * @param 公費受給者番号 公費受給者番号
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set公費受給者番号(RString 公費受給者番号) {
        requireNonNull(公費受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費受給者番号"));
        entity.setKohi_JukyushaNo(公費受給者番号);
        return this;
    }

    /**
     * 公費負担者番号を設定します。
     *
     * @param 公費負担者番号 公費負担者番号
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set公費負担者番号(RString 公費負担者番号) {
        requireNonNull(公費負担者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費負担者番号"));
        entity.setKohi_FutanshaNo(公費負担者番号);
        return this;
    }

    /**
     * 給付率を設定します。
     *
     * @param 給付率 給付率
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set給付率(HokenKyufuRitsu 給付率) {
        requireNonNull(給付率, UrSystemErrorMessages.値がnull.getReplacedMessage("給付率"));
        entity.setKyufuRitsu(給付率);
        return this;
    }

    /**
     * 受給者番号を設定します。
     *
     * @param 受給者番号 受給者番号
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set受給者番号(RString 受給者番号) {
        requireNonNull(受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者番号"));
        entity.setJukyushaNo(受給者番号);
        return this;
    }

    /**
     * 経過措置を設定します。
     *
     * @param 経過措置 経過措置
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set経過措置(RString 経過措置) {
        requireNonNull(経過措置, UrSystemErrorMessages.値がnull.getReplacedMessage("経過措置"));
        entity.setKeikaSochiKubun(経過措置);
        return this;
    }

    /**
     * 国軽減を設定します。
     *
     * @param 国軽減 国軽減
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set国軽減(RString 国軽減) {
        requireNonNull(国軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("国軽減"));
        entity.setKuniKeigenKubun(国軽減);
        return this;
    }

    /**
     * 社会福祉法人軽減を設定します。
     *
     * @param 社会福祉法人軽減 社会福祉法人軽減
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set社会福祉法人軽減(RString 社会福祉法人軽減) {
        requireNonNull(社会福祉法人軽減, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減"));
        entity.setShakaiFukushiHojinKeigenKubun(社会福祉法人軽減);
        return this;
    }

    /**
     * 特別地域加算を設定します。
     *
     * @param 特別地域加算 特別地域加算
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set特別地域加算(RString 特別地域加算) {
        requireNonNull(特別地域加算, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算"));
        entity.setTokubetsuChiikiKasanKubun(特別地域加算);
        return this;
    }

    /**
     * 保留区分_滞納を設定します。
     *
     * @param 保留区分_滞納 保留区分_滞納
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set保留区分_滞納(RString 保留区分_滞納) {
        requireNonNull(保留区分_滞納, UrSystemErrorMessages.値がnull.getReplacedMessage("保留区分_滞納"));
        entity.setTaino_HoryuKubun(保留区分_滞納);
        return this;
    }

    /**
     * 保留区分_認定申請中を設定します。
     *
     * @param 保留区分_認定申請中 保留区分_認定申請中
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set保留区分_認定申請中(RString 保留区分_認定申請中) {
        requireNonNull(保留区分_認定申請中, UrSystemErrorMessages.値がnull.getReplacedMessage("保留区分_認定申請中"));
        entity.setNinteiShinseichu_HoryuKubun(保留区分_認定申請中);
        return this;
    }

    /**
     * 保留区分_認定有効期限切れを設定します。
     *
     * @param 保留区分_認定有効期限切れ 保留区分_認定有効期限切れ
     * @return {@link TandokuJoseikinKyufuKetteiBuilder}
     */
    public TandokuJoseikinKyufuKetteiBuilder set保留区分_認定有効期限切れ(RString 保留区分_認定有効期限切れ) {
        requireNonNull(保留区分_認定有効期限切れ, UrSystemErrorMessages.値がnull.getReplacedMessage("保留区分_認定有効期限切れ"));
        entity.setNinteiKigenGire_HoryuKubun(保留区分_認定有効期限切れ);
        return this;
    }

    /**
     * {@link TandokuJoseikinKyufuKettei}のインスタンスを生成します。
     *
     * @return {@link TandokuJoseikinKyufuKettei}のインスタンス
     */
    public TandokuJoseikinKyufuKettei build() {
        return new TandokuJoseikinKyufuKettei(entity, id);
    }
}
