/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5033ShinsakaiIinHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShinsakaiIinHoshuTanka}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class ShinsakaiIinHoshuTankaBuilder {

    private final DbT5033ShinsakaiIinHoshuTankaEntity entity;
    private final ShinsakaiIinHoshuTankaIdentifier id;

    /**
     * {@link DbT5033ShinsakaiIinHoshuTankaEntity}より{@link ShinsakaiIinHoshuTanka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5033ShinsakaiIinHoshuTankaEntity}
     * @param id {@link ShinsakaiIinHoshuTankaIdentifier}
     *
     */
    ShinsakaiIinHoshuTankaBuilder(
            DbT5033ShinsakaiIinHoshuTankaEntity entity,
            ShinsakaiIinHoshuTankaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     * @return {@link ShinsakaiIinHoshuTankaBuilder}
     */
    public ShinsakaiIinHoshuTankaBuilder set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
        return this;
    }

    /**
     * {@link ShinsakaiIinHoshuTanka}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiIinHoshuTanka}のインスタンス
     */
    public ShinsakaiIinHoshuTanka build() {
        return new ShinsakaiIinHoshuTanka(entity, id);
    }
}
