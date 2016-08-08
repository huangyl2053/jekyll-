/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShinsakaiIinBetsuTanka}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class ShinsakaiIinBetsuTankaBuilder {

    private final DbT5034ShinsakaiIinBetsuTankaEntity entity;
    private final ShinsakaiIinBetsuTankaIdentifier id;

    /**
     * {@link DbT5034ShinsakaiIinBetsuTankaEntity}より{@link ShinsakaiIinBetsuTanka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5034ShinsakaiIinBetsuTankaEntity}
     * @param id {@link ShinsakaiIinBetsuTankaIdentifier}
     *
     */
    ShinsakaiIinBetsuTankaBuilder(
            DbT5034ShinsakaiIinBetsuTankaEntity entity,
            ShinsakaiIinBetsuTankaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     * @return {@link ShinsakaiIinBetsuTankaBuilder}
     */
    public ShinsakaiIinBetsuTankaBuilder set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
        return this;
    }

    /**
     * その他単価を設定します。
     *
     * @param その他単価 その他単価
     * @return {@link ShinsakaiIinBetsuTankaBuilder}
     */
    public ShinsakaiIinBetsuTankaBuilder setその他単価(Decimal その他単価) {
        requireNonNull(その他単価, UrSystemErrorMessages.値がnull.getReplacedMessage("その他単価"));
        entity.setTanka(その他単価);
        return this;
    }

    /**
     * {@link ShinsakaiIinBetsuTanka}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiIinBetsuTanka}のインスタンス
     */
    public ShinsakaiIinBetsuTanka build() {
        return new ShinsakaiIinBetsuTanka(entity, id);
    }
}
