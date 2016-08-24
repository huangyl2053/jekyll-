/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請履歴情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-011 zuotao
 */
public class DbT4121ShinseiRirekiJoho
        extends ParentModelBase<DbT4121ShinseiRirekiJohoIdentifier, DbT4121ShinseiRirekiJohoEntity, DbT4121ShinseiRirekiJoho>
        implements Serializable {

    private static final long serialVersionUID = -8780705874230630829L;
    private final DbT4121ShinseiRirekiJohoEntity entity;
    private final DbT4121ShinseiRirekiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 申請履歴情報の新規作成時に使用します。
     *
     * @param 申請管理番号 申請管理番号
     */
    public DbT4121ShinseiRirekiJoho(ShinseishoKanriNo 申請管理番号) {
        requireNonNull(申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請管理番号"));
        this.entity = new DbT4121ShinseiRirekiJohoEntity();
        this.entity.setShinseishoKanriNo(申請管理番号);
        this.id = new DbT4121ShinseiRirekiJohoIdentifier(
                申請管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4121ShinseiRirekiJohoEntity}より{@link DbT4121ShinseiRirekiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4121ShinseiRirekiJohoEntity}
     */
    public DbT4121ShinseiRirekiJoho(DbT4121ShinseiRirekiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請履歴情報"));
        this.id = new DbT4121ShinseiRirekiJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4121ShinseiRirekiJohoEntity}
     * @param id {@link DbT4121ShinseiRirekiJohoIdentifier}
     */
    DbT4121ShinseiRirekiJoho(
            DbT4121ShinseiRirekiJohoEntity entity,
            DbT4121ShinseiRirekiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * {@link DbT4121ShinseiRirekiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4121ShinseiRirekiJohoEntity}のクローン
     */
    @Override
    public DbT4121ShinseiRirekiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 申請履歴情報の識別子{@link DbT4121ShinseiRirekiJohoIdentifier}を返します。
     *
     * @return 申請履歴情報の識別子{@link DbT4121ShinseiRirekiJohoIdentifier}
     */
    @Override
    public DbT4121ShinseiRirekiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 申請履歴情報のみを変更対象とします。<br/>
     * {@link DbT4121ShinseiRirekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT4121ShinseiRirekiJoho}
     */
    @Override
    public DbT4121ShinseiRirekiJoho modifiedModel() {
        DbT4121ShinseiRirekiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT4121ShinseiRirekiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する申請履歴情報を削除対象とします。<br/>
     * {@link DbT4121ShinseiRirekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT4121ShinseiRirekiJoho}
     */
    @Override
    public DbT4121ShinseiRirekiJoho deleted() {
        DbT4121ShinseiRirekiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT4121ShinseiRirekiJoho(deletedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * {@link DbT4121ShinseiRirekiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link DbT4121ShinseiRirekiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4121ShinseiRirekiJohoEntity entity;
        private final DbT4121ShinseiRirekiJohoIdentifier id;

        private _SerializationProxy(DbT4121ShinseiRirekiJohoEntity entity, DbT4121ShinseiRirekiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT4121ShinseiRirekiJoho(this.entity, this.id);
        }
        private static final long serialVersionUID = 2469449052638583798L;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT4121ShinseiRirekiJohoBuilder createBuilderForEdit() {
        return new DbT4121ShinseiRirekiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
