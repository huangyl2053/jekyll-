/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link Kibetsu}の編集を行うビルダークラスです。
 */
public class KibetsuBuilder {

    private final DbT2003KibetsuEntity entity;
    private final KibetsuIdentifier id;

    /**
     * {@link DbT2003KibetsuEntity}より{@link Kibetsu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2003KibetsuEntity}
     * @param id {@link KibetsuIdentifier}
     *
     */
    KibetsuBuilder(
            DbT2003KibetsuEntity entity,
            KibetsuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 調定IDを設定します。
     *
     * @param 調定ID 調定ID
     * @return {@link KibetsuBuilder}
     */
    public KibetsuBuilder set調定ID(Decimal 調定ID) {
        requireNonNull(調定ID, UrSystemErrorMessages.値がnull.getReplacedMessage("調定ID"));
        entity.setChoteiId(調定ID);
        return this;
    }

    /**
     * {@link Kibetsu}のインスタンスを生成します。
     *
     * @return {@link Kibetsu}のインスタンス
     */
    public Kibetsu build() {
        return new Kibetsu(entity, id);
    }
}
