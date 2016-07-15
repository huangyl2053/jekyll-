/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link DbT3058KogakuShikyuShinsaKettei}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT3058KogakuShikyuShinsaKetteiBuilder {

    private final DbT3058KogakuShikyuShinsaKetteiEntity entity;
    private final DbT3058KogakuShikyuShinsaKetteiIdentifier id;

    /**
     * {@link DbT3058KogakuShikyuShinsaKetteiEntity}より{@link DbT3058KogakuShikyuShinsaKettei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3058KogakuShikyuShinsaKetteiEntity}
     * @param id {@link DbT3058KogakuShikyuShinsaKetteiIdentifier}
     *
     */
    DbT3058KogakuShikyuShinsaKetteiBuilder(
            DbT3058KogakuShikyuShinsaKetteiEntity entity,
            DbT3058KogakuShikyuShinsaKetteiIdentifier id
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
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 決定者受取年月を設定します。
     *
     * @param 決定者受取年月 決定者受取年月
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set決定者受取年月(FlexibleYearMonth 決定者受取年月) {
        requireNonNull(決定者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定者受取年月"));
        entity.setKetteishaUketoriYM(決定者受取年月);
        return this;
    }

    /**
     * 通知書番号を設定します。
     *
     * @param 通知書番号 通知書番号
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set通知書番号(RString 通知書番号) {
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        entity.setTsuchishoNo(通知書番号);
        return this;
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 決定年月を設定します。
     *
     * @param 決定年月 決定年月
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set決定年月(FlexibleYearMonth 決定年月) {
        requireNonNull(決定年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月"));
        entity.setKetteiYM(決定年月);
        return this;
    }

    /**
     * 高額支給額を設定します。
     *
     * @param 高額支給額 高額支給額
     * @return {@link DbT3058KogakuShikyuShinsaKetteiBuilder}
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder set高額支給額(Decimal 高額支給額) {
        requireNonNull(高額支給額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額支給額"));
        entity.setKogakuShikyuGaku(高額支給額);
        return this;
    }

    /**
     * {@link DbT3058KogakuShikyuShinsaKettei}のインスタンスを生成します。
     *
     * @return {@link DbT3058KogakuShikyuShinsaKettei}のインスタンス
     */
    public DbT3058KogakuShikyuShinsaKettei build() {
        return new DbT3058KogakuShikyuShinsaKettei(entity, id);
    }
}
