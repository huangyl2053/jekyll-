/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KoseiShichosonMaster}の編集を行うビルダークラスです。
 */
public class KoseiShichosonMasterBuilder {

    private final DbT5051KoseiShichosonMasterEntity entity;
    private final KoseiShichosonMasterIdentifier id;

    /**
     * {@link DbT5051KoseiShichosonMasterEntity}より{@link KoseiShichosonMaster}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5051KoseiShichosonMasterEntity}
     * @param id {@link KoseiShichosonMasterIdentifier}
     *
     */
    KoseiShichosonMasterBuilder(
            DbT5051KoseiShichosonMasterEntity entity,
            KoseiShichosonMasterIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村識別IDを設定します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return {@link KoseiShichosonMasterBuilder}
     */
    public KoseiShichosonMasterBuilder set市町村識別ID(RString 市町村識別ID) {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        entity.setShichosonShokibetsuID(市町村識別ID);
        return this;
    }

    /**
     * {@link KoseiShichosonMaster}のインスタンスを生成します。
     *
     * @return {@link KoseiShichosonMaster}のインスタンス
     */
    public KoseiShichosonMaster build() {
        return new KoseiShichosonMaster(entity, id);
    }
}
