/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMaster extends ParentModelBase<KoseiShichosonMasterIdentifier, DbT5051KoseiShichosonMasterEntity, KoseiShichosonMaster> implements Serializable {

    private final DbT5051KoseiShichosonMasterEntity entity;
    private final KoseiShichosonMasterIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 構成市町村マスタの新規作成時に使用します。
     *
     * @param 市町村識別ID 市町村識別ID
     */
    public KoseiShichosonMaster(RString 市町村識別ID) {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        this.entity = new DbT5051KoseiShichosonMasterEntity();
        this.entity.setShichosonShokibetsuID(市町村識別ID);
        this.id = new KoseiShichosonMasterIdentifier(市町村識別ID);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5051KoseiShichosonMasterEntity}より{@link KoseiShichosonMaster}を生成します。
     *
     * @param entity DBより取得した{@link DbT5051KoseiShichosonMasterEntity}
     */
    public KoseiShichosonMaster(DbT5051KoseiShichosonMasterEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ"));
        this.id = new KoseiShichosonMasterIdentifier(entity.getShichosonShokibetsuID());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5051KoseiShichosonMasterEntity}
     * @param id {@link KoseiShichosonMasterIdentifier}
     */
    KoseiShichosonMaster(
            DbT5051KoseiShichosonMasterEntity entity,
            KoseiShichosonMasterIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    public RString get市町村識別ID() {
        return entity.getShichosonShokibetsuID();
    }

    /**
     * {@link DbT5051KoseiShichosonMasterEntity}のクローンを返します。
     *
     * @return {@link DbT5051KoseiShichosonMasterEntity}のクローン
     */
    @Override
    public DbT5051KoseiShichosonMasterEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 構成市町村マスタの識別子{@link KoseiShichosonMasterIdentifier}を返します。
     *
     * @return 構成市町村マスタの識別子{@link KoseiShichosonMasterIdentifier}
     */
    @Override
    public KoseiShichosonMasterIdentifier identifier() {
        return this.id;
    }

    /**
     * 構成市町村マスタのみを変更対象とします。<br/>
     * {@link DbT5051KoseiShichosonMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KoseiShichosonMaster}
     */
    @Override
    public KoseiShichosonMaster modifiedModel() {
        DbT5051KoseiShichosonMasterEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KoseiShichosonMaster(
                modifiedEntity, id);
    }

    /**
     * 保持する構成市町村マスタを削除対象とします。<br/>
     * {@link DbT5051KoseiShichosonMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KoseiShichosonMaster}
     */
    @Override
    public KoseiShichosonMaster deleted() {
        DbT5051KoseiShichosonMasterEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KoseiShichosonMaster(deletedEntity, id);
    }

    /**
     * {@link KoseiShichosonMaster}のシリアライズ形式を提供します。
     *
     * @return {@link KoseiShichosonMaster}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT5051KoseiShichosonMasterEntity entity;
        private final KoseiShichosonMasterIdentifier id;

        private _SerializationProxy(DbT5051KoseiShichosonMasterEntity entity, KoseiShichosonMasterIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KoseiShichosonMaster(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KoseiShichosonMasterBuilder createBuilderForEdit() {
        return new KoseiShichosonMasterBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
