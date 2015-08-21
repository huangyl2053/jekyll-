/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村支所マスタを管理するクラスです。
 */
public class KoseiShichosonShishoMaster extends ParentModelBase<KoseiShichosonShishoMasterIdentifier, DbT5052KoseiShichosonShishoMasterEntity, KoseiShichosonShishoMaster> implements Serializable {

    private final DbT5052KoseiShichosonShishoMasterEntity entity;
    private final KoseiShichosonShishoMasterIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 構成市町村支所マスタの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     */
    public KoseiShichosonShishoMaster(LasdecCode 市町村コード,
            ShishoCode 支所コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));
        this.entity = new DbT5052KoseiShichosonShishoMasterEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setShishoCode(支所コード);
        this.id = new KoseiShichosonShishoMasterIdentifier(
                市町村コード,
                支所コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5052KoseiShichosonShishoMasterEntity}より{@link KoseiShichosonShishoMaster}を生成します。
     *
     * @param entity DBより取得した{@link DbT5052KoseiShichosonShishoMasterEntity}
     */
    public KoseiShichosonShishoMaster(DbT5052KoseiShichosonShishoMasterEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村支所マスタ"));
        this.id = new KoseiShichosonShishoMasterIdentifier(
                entity.getShichosonCode(),
                entity.getShishoCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5052KoseiShichosonShishoMasterEntity}
     * @param id {@link KoseiShichosonShishoMasterIdentifier}
     */
    KoseiShichosonShishoMaster(
            DbT5052KoseiShichosonShishoMasterEntity entity,
            KoseiShichosonShishoMasterIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    public ShishoCode get支所コード() {
        return entity.getShishoCode();
    }

    /**
     * {@link DbT5052KoseiShichosonShishoMasterEntity}のクローンを返します。
     *
     * @return {@link DbT5052KoseiShichosonShishoMasterEntity}のクローン
     */
    @Override
    public DbT5052KoseiShichosonShishoMasterEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 構成市町村支所マスタの識別子{@link KoseiShichosonShishoMasterIdentifier}を返します。
     *
     * @return 構成市町村支所マスタの識別子{@link KoseiShichosonShishoMasterIdentifier}
     */
    @Override
    public KoseiShichosonShishoMasterIdentifier identifier() {
        return this.id;
    }

    /**
     * 構成市町村支所マスタのみを変更対象とします。<br/>
     * {@link DbT5052KoseiShichosonShishoMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KoseiShichosonShishoMaster}
     */
    @Override
    public KoseiShichosonShishoMaster modifiedModel() {
        DbT5052KoseiShichosonShishoMasterEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KoseiShichosonShishoMaster(
                modifiedEntity, id);
    }

    /**
     * 保持する構成市町村支所マスタを削除対象とします。<br/>
     * {@link DbT5052KoseiShichosonShishoMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KoseiShichosonShishoMaster}
     */
    @Override
    public KoseiShichosonShishoMaster deleted() {
        DbT5052KoseiShichosonShishoMasterEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KoseiShichosonShishoMaster(deletedEntity, id);
    }

    /**
     * {@link KoseiShichosonShishoMaster}のシリアライズ形式を提供します。
     *
     * @return {@link KoseiShichosonShishoMaster}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L; // TODO serialVersionUIDを生成してください
        private final DbT5052KoseiShichosonShishoMasterEntity entity;
        private final KoseiShichosonShishoMasterIdentifier id;

        private _SerializationProxy(DbT5052KoseiShichosonShishoMasterEntity entity, KoseiShichosonShishoMasterIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KoseiShichosonShishoMaster(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KoseiShichosonShishoMasterBuilder createBuilderForEdit() {
        return new KoseiShichosonShishoMasterBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
