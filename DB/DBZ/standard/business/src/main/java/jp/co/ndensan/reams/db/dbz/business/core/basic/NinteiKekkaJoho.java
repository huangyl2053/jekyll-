/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定結果情報を管理するクラスです。
 */
public class NinteiKekkaJoho extends ParentModelBase<NinteiKekkaJohoIdentifier, DbT5102NinteiKekkaJohoEntity, NinteiKekkaJoho> implements Serializable {

    private final DbT5102NinteiKekkaJohoEntity entity;
    private final NinteiKekkaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定結果情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public NinteiKekkaJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5102NinteiKekkaJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new NinteiKekkaJohoIdentifier(
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5102NinteiKekkaJohoEntity}より{@link NinteiKekkaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5102NinteiKekkaJohoEntity}
     */
    public NinteiKekkaJoho(DbT5102NinteiKekkaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報"));
        this.id = new NinteiKekkaJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5102NinteiKekkaJohoEntity}
     * @param id {@link NinteiKekkaJohoIdentifier}
     */
    NinteiKekkaJoho(
            DbT5102NinteiKekkaJohoEntity entity,
            NinteiKekkaJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * {@link DbT5102NinteiKekkaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5102NinteiKekkaJohoEntity}のクローン
     */
    @Override
    public DbT5102NinteiKekkaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定結果情報の識別子{@link NinteiKekkaJohoIdentifier}を返します。
     *
     * @return 要介護認定結果情報の識別子{@link NinteiKekkaJohoIdentifier}
     */
    @Override
    public NinteiKekkaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定結果情報のみを変更対象とします。<br/>
     * {@link DbT5102NinteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiKekkaJoho}
     */
    @Override
    public NinteiKekkaJoho modifiedModel() {
        DbT5102NinteiKekkaJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteiKekkaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定結果情報を削除対象とします。<br/>
     * {@link DbT5102NinteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteiKekkaJoho}
     */
    @Override
    public NinteiKekkaJoho deleted() {
        DbT5102NinteiKekkaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiKekkaJoho(deletedEntity, id);
    }

    /**
     * {@link NinteiKekkaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiKekkaJoho}のシリアライズ形式
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
        private final DbT5102NinteiKekkaJohoEntity entity;
        private final NinteiKekkaJohoIdentifier id;

        private _SerializationProxy(DbT5102NinteiKekkaJohoEntity entity, NinteiKekkaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteiKekkaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteiKekkaJohoBuilder createBuilderForEdit() {
        return new NinteiKekkaJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
