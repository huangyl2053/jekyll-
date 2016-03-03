/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請履歴情報を管理するクラスです。
 */
public class ShinseiRirekiJoho extends ModelBase<ShinseiRirekiJohoIdentifier, DbT5121ShinseiRirekiJohoEntity, ShinseiRirekiJoho> implements Serializable {

    private final DbT5121ShinseiRirekiJohoEntity entity;
    private final ShinseiRirekiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 申請履歴情報の新規作成時に使用します。
     *
     * @param 申請管理番号 申請管理番号
     */
    public ShinseiRirekiJoho(ShinseishoKanriNo 申請管理番号) {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));
        this.entity = new DbT5121ShinseiRirekiJohoEntity();
        this.entity.setShinseishoKanriNo(申請管理番号);
        this.id = new ShinseiRirekiJohoIdentifier(
                申請管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5121ShinseiRirekiJohoEntity}より{@link ShinseiRirekiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5121ShinseiRirekiJohoEntity}
     */
    public ShinseiRirekiJoho(DbT5121ShinseiRirekiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請履歴情報"));
        this.id = new ShinseiRirekiJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5121ShinseiRirekiJohoEntity}
     * @param id {@link ShinseiRirekiJohoIdentifier}
     */
    ShinseiRirekiJoho(
            DbT5121ShinseiRirekiJohoEntity entity,
            ShinseiRirekiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 申請管理番号を返します。
     *
     * @return 申請管理番号
     */
    public ShinseishoKanriNo get申請管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 前回申請管理番号を返します。
     *
     * @return 前回申請管理番号
     */
    public ShinseishoKanriNo get前回申請管理番号() {
        return entity.getZenkaiShinseishoKanriNo();
    }

    /**
     * {@link DbT5121ShinseiRirekiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5121ShinseiRirekiJohoEntity}のクローン
     */
    @Override
    public DbT5121ShinseiRirekiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 申請履歴情報の識別子{@link ShinseiRirekiJohoIdentifier}を返します。
     *
     * @return 申請履歴情報の識別子{@link ShinseiRirekiJohoIdentifier}
     */
    @Override
    public ShinseiRirekiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 申請履歴情報のみを変更対象とします。<br/>
     * {@link DbT5121ShinseiRirekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinseiRirekiJoho}
     */
    public ShinseiRirekiJoho modifiedModel() {
        DbT5121ShinseiRirekiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinseiRirekiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する申請履歴情報を削除対象とします。<br/>
     * {@link DbT5121ShinseiRirekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinseiRirekiJoho}
     */
    @Override
    public ShinseiRirekiJoho deleted() {
        DbT5121ShinseiRirekiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinseiRirekiJoho(deletedEntity, id);
    }

    /**
     * {@link ShinseiRirekiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinseiRirekiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5121ShinseiRirekiJohoEntity entity;
        private final ShinseiRirekiJohoIdentifier id;

        private _SerializationProxy(DbT5121ShinseiRirekiJohoEntity entity, ShinseiRirekiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinseiRirekiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinseiRirekiJohoBuilder createBuilderForEdit() {
        return new ShinseiRirekiJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final ShinseiRirekiJoho other = (ShinseiRirekiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
