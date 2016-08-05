/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link NinteiChosaHoshuTanka}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
public class NinteiChosaHoshuTankaBuilder {

    private final DbT5031NinteiChosaHoshuTankaEntity entity;
    private final NinteiChosaHoshuTankaIdentifier id;

    /**
     * {@link DbT5031NinteiChosaHoshuTankaEntity}より{@link NinteiChosaHoshuTanka}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5031NinteiChosaHoshuTankaEntity}
     * @param id {@link NinteiChosaHoshuTankaIdentifier}
     *
     */
    NinteiChosaHoshuTankaBuilder(
            DbT5031NinteiChosaHoshuTankaEntity entity,
            NinteiChosaHoshuTankaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 単価を設定します。
     *
     * @param 単価 単価
     * @return {@link NinteiChosaHoshuTankaBuilder}
     */
    public NinteiChosaHoshuTankaBuilder set単価(Decimal 単価) {
        requireNonNull(単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単価"));
        entity.setTanka(単価);
        return this;
    }

    /**
     * {@link NinteiChosaHoshuTanka}のインスタンスを生成します。
     *
     * @return {@link NinteiChosaHoshuTanka}のインスタンス
     */
    public NinteiChosaHoshuTanka build() {
        return new NinteiChosaHoshuTanka(entity, id);
    }
}
