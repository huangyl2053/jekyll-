/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShujiiIkenshoHoshuTanka}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class ShujiiIkenshoHoshuTankaBuilder {

    private final DbT5032ShujiiIkenshoHoshuTankaEntity entity;
    private final ShujiiIkenshoHoshuTankaIdentifier id;

    /**
     * {@link DbT5032ShujiiIkenshoHoshuTankaEntity}より{@link ShujiiIkenshoHoshuTanka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5032ShujiiIkenshoHoshuTankaEntity}
     * @param id {@link ShujiiIkenshoHoshuTankaIdentifier}
     *
     */
    ShujiiIkenshoHoshuTankaBuilder(
            DbT5032ShujiiIkenshoHoshuTankaEntity entity,
            ShujiiIkenshoHoshuTankaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 終了年月を設定します。
     *
     * @param 終了年月 終了年月
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set終了年月(FlexibleYearMonth 終了年月) {
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));
        entity.setShuryoYM(終了年月);
        return this;
    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     * @return {@link ShujiiIkenshoHoshuTankaBuilder}
     */
    public ShujiiIkenshoHoshuTankaBuilder set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
        return this;
    }

    /**
     * {@link ShujiiIkenshoHoshuTanka}のインスタンスを生成します。
     *
     * @return {@link ShujiiIkenshoHoshuTanka}のインスタンス
     */
    public ShujiiIkenshoHoshuTanka build() {
        return new ShujiiIkenshoHoshuTanka(entity, id);
    }
}
