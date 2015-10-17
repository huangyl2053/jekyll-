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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 原因疾患を管理するクラスです。
 */
public class GeninShikkan extends ParentModelBase<GeninShikkanIdentifier, DbT5300GeninShikkanEntity, GeninShikkan> implements Serializable {

    private final DbT5300GeninShikkanEntity entity;
    private final GeninShikkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 原因疾患の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     */
    public GeninShikkan(ShinseishoKanriNo 申請書管理番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5300GeninShikkanEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setRemban(連番);
        this.id = new GeninShikkanIdentifier(
                申請書管理番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5300GeninShikkanEntity}より{@link GeninShikkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT5300GeninShikkanEntity}
     */
    public GeninShikkan(DbT5300GeninShikkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("原因疾患"));
        this.id = new GeninShikkanIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5300GeninShikkanEntity}
     * @param id {@link GeninShikkanIdentifier}
     */
    GeninShikkan(
            DbT5300GeninShikkanEntity entity,
            GeninShikkanIdentifier id
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
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRemban();
    }

    /**
     * 主たる原因疾患フラグを返します。
     *
     * @return 主たる原因疾患フラグ
     */
    public boolean get主たる原因疾患フラグ() {
        return entity.getIsShutaruGeninShikkan();
    }

    /**
     * 原因疾患コードを返します。
     *
     * @return 原因疾患コード
     */
    public Code get原因疾患コード() {
        return entity.getGeninShikkanCode();
    }

    /**
     * {@link DbT5300GeninShikkanEntity}のクローンを返します。
     *
     * @return {@link DbT5300GeninShikkanEntity}のクローン
     */
    @Override
    public DbT5300GeninShikkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 原因疾患の識別子{@link GeninShikkanIdentifier}を返します。
     *
     * @return 原因疾患の識別子{@link GeninShikkanIdentifier}
     */
    @Override
    public GeninShikkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 原因疾患のみを変更対象とします。<br/>
     * {@link DbT5300GeninShikkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GeninShikkan}
     */
    @Override
    public GeninShikkan modifiedModel() {
        DbT5300GeninShikkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GeninShikkan(
                modifiedEntity, id);
    }

    /**
     * 保持する原因疾患を削除対象とします。<br/>
     * {@link DbT5300GeninShikkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GeninShikkan}
     */
    @Override
    public GeninShikkan deleted() {
        DbT5300GeninShikkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GeninShikkan(deletedEntity, id);
    }

    /**
     * {@link GeninShikkan}のシリアライズ形式を提供します。
     *
     * @return {@link GeninShikkan}のシリアライズ形式
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
        private final DbT5300GeninShikkanEntity entity;
        private final GeninShikkanIdentifier id;

        private _SerializationProxy(DbT5300GeninShikkanEntity entity, GeninShikkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GeninShikkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GeninShikkanBuilder createBuilderForEdit() {
        return new GeninShikkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
