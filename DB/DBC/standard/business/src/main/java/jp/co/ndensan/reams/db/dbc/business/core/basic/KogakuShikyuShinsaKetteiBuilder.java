/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KogakuShikyuShinsaKettei}の編集を行うビルダークラスです。
 */
public class KogakuShikyuShinsaKetteiBuilder {

    private final DbT3112KogakuShikyuShinsaKetteiEntity entity;
    private final KogakuShikyuShinsaKetteiIdentifier id;

    /**
     * {@link DbT3112KogakuShikyuShinsaKetteiEntity}より{@link KogakuShikyuShinsaKettei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3112KogakuShikyuShinsaKetteiEntity}
     * @param id {@link KogakuShikyuShinsaKetteiIdentifier}
     *
     */
    KogakuShikyuShinsaKetteiBuilder(
            DbT3112KogakuShikyuShinsaKetteiEntity entity,
            KogakuShikyuShinsaKetteiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 決定者受取年月を設定します。
     *
     * @param 決定者受取年月 決定者受取年月
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set決定者受取年月(FlexibleYearMonth 決定者受取年月) {
        requireNonNull(決定者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定者受取年月"));
        entity.setKetteishaUketoriYM(決定者受取年月);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set通知書番号(RString 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 決定年月を設定します。
     *
     * @param 決定年月 決定年月
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set決定年月(FlexibleYearMonth 決定年月) {
        requireNonNull(決定年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月"));
        entity.setKetteiYM(決定年月);
        return this;
    }

    /**
     * 事業高額支給額を設定します。
     *
     * @param 事業高額支給額 事業高額支給額
     * @return {@link KogakuShikyuShinsaKetteiBuilder}
     */
    public KogakuShikyuShinsaKetteiBuilder set事業高額支給額(Decimal 事業高額支給額) {
        requireNonNull(事業高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額支給額"));
        entity.setJigyoKogakuShikyuGaku(事業高額支給額);
        return this;
    }

    /**
     * {@link KogakuShikyuShinsaKettei}のインスタンスを生成します。
     *
     * @return {@link KogakuShikyuShinsaKettei}のインスタンス
     */
    public KogakuShikyuShinsaKettei build() {
        return new KogakuShikyuShinsaKettei(entity, id);
    }
}
