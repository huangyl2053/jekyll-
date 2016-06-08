/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * {@link KoseiShichosonShishoMaster}の編集を行うビルダークラスです。
 */
public class KoseiShichosonShishoMasterBuilder {

    private final DbT5052KoseiShichosonShishoMasterEntity entity;
    private final KoseiShichosonShishoMasterIdentifier id;

    /**
     * {@link DbT5052KoseiShichosonShishoMasterEntity}より{@link KoseiShichosonShishoMaster}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5052KoseiShichosonShishoMasterEntity}
     * @param id {@link KoseiShichosonShishoMasterIdentifier}
     *
     */
    KoseiShichosonShishoMasterBuilder(
            DbT5052KoseiShichosonShishoMasterEntity entity,
            KoseiShichosonShishoMasterIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link KoseiShichosonShishoMasterBuilder}
     */
    public KoseiShichosonShishoMasterBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 支所コードを設定します。
     *
     * @param 支所コード 支所コード
     * @return {@link KoseiShichosonShishoMasterBuilder}
     */
    public KoseiShichosonShishoMasterBuilder set支所コード(ShishoCode 支所コード) {
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        entity.setShishoCode(支所コード);
        return this;
    }

    /**
     * {@link KoseiShichosonShishoMaster}のインスタンスを生成します。
     *
     * @return {@link KoseiShichosonShishoMaster}のインスタンス
     */
    public KoseiShichosonShishoMaster build() {
        return new KoseiShichosonShishoMaster(entity, id);
    }
}
