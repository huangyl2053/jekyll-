/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 老人保健受給者情報を管理するクラスです。
 */
public class RojinHokenJukyushaJoho extends
        ModelBase<RojinHokenJukyushaJohoIdentifier, DbT7005RojinHokenJukyushaJohoEntity, RojinHokenJukyushaJoho> implements Serializable {

    private static final long serialVersionUID = -1645423049256158209L;
    private final DbT7005RojinHokenJukyushaJohoEntity entity;
    private final RojinHokenJukyushaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 老人保健受給者情報の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     */
    public RojinHokenJukyushaJoho(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.entity = new DbT7005RojinHokenJukyushaJohoEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.id = new RojinHokenJukyushaJohoIdentifier(
                識別コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7005RojinHokenJukyushaJohoEntity}より{@link RojinHokenJukyushaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT7005RojinHokenJukyushaJohoEntity}
     */
    public RojinHokenJukyushaJoho(DbT7005RojinHokenJukyushaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者情報"));
        this.id = new RojinHokenJukyushaJohoIdentifier(
                entity.getShikibetsuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7005RojinHokenJukyushaJohoEntity}
     * @param id {@link RojinHokenJukyushaJohoIdentifier}
     */
    RojinHokenJukyushaJoho(
            DbT7005RojinHokenJukyushaJohoEntity entity,
            RojinHokenJukyushaJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 老人保健市町村コードを返します。
     *
     * @return 老人保健市町村コード
     */
    public LasdecCode get老人保健市町村コード() {
        return entity.getRojinHokenShichosonCode();
    }

    /**
     * 老人保健受給者番号を返します。
     *
     * @return 老人保健受給者番号
     */
    public RString get老人保健受給者番号() {
        return entity.getRojinHokenJukyushaNo();
    }

    /**
     * {@link DbT7005RojinHokenJukyushaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT7005RojinHokenJukyushaJohoEntity}のクローン
     */
    @Override
    public DbT7005RojinHokenJukyushaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 老人保健受給者情報の識別子{@link RojinHokenJukyushaJohoIdentifier}を返します。
     *
     * @return 老人保健受給者情報の識別子{@link RojinHokenJukyushaJohoIdentifier}
     */
    @Override
    public RojinHokenJukyushaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 老人保健受給者情報のみを変更対象とします。<br/> {@link DbT7005RojinHokenJukyushaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RojinHokenJukyushaJoho}
     */
    public RojinHokenJukyushaJoho modifiedModel() {
        DbT7005RojinHokenJukyushaJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RojinHokenJukyushaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する老人保健受給者情報を削除対象とします。<br/> {@link DbT7005RojinHokenJukyushaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RojinHokenJukyushaJoho}
     */
    @Override
    public RojinHokenJukyushaJoho deleted() {
        DbT7005RojinHokenJukyushaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RojinHokenJukyushaJoho(deletedEntity, id);
    }

    /**
     * {@link RojinHokenJukyushaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link RojinHokenJukyushaJoho}のシリアライズ形式
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
        private final DbT7005RojinHokenJukyushaJohoEntity entity;
        private final RojinHokenJukyushaJohoIdentifier id;

        private _SerializationProxy(DbT7005RojinHokenJukyushaJohoEntity entity, RojinHokenJukyushaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RojinHokenJukyushaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RojinHokenJukyushaJohoBuilder createBuilderForEdit() {
        return new RojinHokenJukyushaJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final RojinHokenJukyushaJoho other = (RojinHokenJukyushaJoho) obj;
        return Objects.equals(this.id, other.id);
    }
}
