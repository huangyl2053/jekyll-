/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 構成市町村支所マスタを管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 sunhaidi
 */
public class KoseiShichosonShishoMaster
        extends ModelBase<KoseiShichosonShishoMasterIdentifier, DbT7052KoseiShichosonShishoMasterEntity, KoseiShichosonShishoMaster>
        implements Serializable {

    private static final long serialVersionUID = -2057959266642078847L;

    private final DbT7052KoseiShichosonShishoMasterEntity entity;
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
        this.entity = new DbT7052KoseiShichosonShishoMasterEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setShishoCode(支所コード);
        this.id = new KoseiShichosonShishoMasterIdentifier(
                市町村コード,
                支所コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7052KoseiShichosonShishoMasterEntity}より{@link KoseiShichosonShishoMaster}を生成します。
     *
     * @param entity DBより取得した{@link DbT7052KoseiShichosonShishoMasterEntity}
     */
    public KoseiShichosonShishoMaster(DbT7052KoseiShichosonShishoMasterEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村支所マスタ"));
        this.id = new KoseiShichosonShishoMasterIdentifier(
                entity.getShichosonCode(),
                entity.getShishoCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7052KoseiShichosonShishoMasterEntity}
     * @param id {@link KoseiShichosonShishoMasterIdentifier}
     */
    KoseiShichosonShishoMaster(
            DbT7052KoseiShichosonShishoMasterEntity entity,
            KoseiShichosonShishoMasterIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

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
     * 支所名を返します。
     *
     * @return 支所名
     */
    public RString get支所名() {
        return entity.getShishoMei();
    }

    /**
     * {@link DbT7052KoseiShichosonShishoMasterEntity}のクローンを返します。
     *
     * @return {@link DbT7052KoseiShichosonShishoMasterEntity}のクローン
     */
    @Override
    public DbT7052KoseiShichosonShishoMasterEntity toEntity() {
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
     * 保持する構成市町村支所マスタを削除対象とします。<br/>
     * {@link DbT7052KoseiShichosonShishoMasterEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KoseiShichosonShishoMaster}
     */
    @Override
    public KoseiShichosonShishoMaster deleted() {
        DbT7052KoseiShichosonShishoMasterEntity deletedEntity = this.toEntity();
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
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7052KoseiShichosonShishoMasterEntity entity;
        private final KoseiShichosonShishoMasterIdentifier id;

        private _SerializationProxy(DbT7052KoseiShichosonShishoMasterEntity entity, KoseiShichosonShishoMasterIdentifier id) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KoseiShichosonShishoMaster other = (KoseiShichosonShishoMaster) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
