/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票_概況調査_サービスの状況フラグを管理するクラスです。
 */
public class NinteichosahyoServiceJokyoFlag extends
        ModelBase<NinteichosahyoServiceJokyoFlagIdentifier, DbT5208NinteichosahyoServiceJokyoFlagEntity, NinteichosahyoServiceJokyoFlag>
        implements Serializable {

    private final DbT5208NinteichosahyoServiceJokyoFlagEntity entity;
    private final NinteichosahyoServiceJokyoFlagIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票_概況調査_サービスの状況フラグの新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     */
    public NinteichosahyoServiceJokyoFlag(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.entity.setRemban(連番);
        this.id = new NinteichosahyoServiceJokyoFlagIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5208NinteichosahyoServiceJokyoFlagEntity}より{@link NinteichosahyoServiceJokyoFlag}を生成します。
     *
     * @param entity DBより取得した{@link DbT5208NinteichosahyoServiceJokyoFlagEntity}
     */
    public NinteichosahyoServiceJokyoFlag(DbT5208NinteichosahyoServiceJokyoFlagEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_サービスの状況フラグ"));
        this.id = new NinteichosahyoServiceJokyoFlagIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}
     * @param id {@link NinteichosahyoServiceJokyoFlagIdentifier}
     */
    NinteichosahyoServiceJokyoFlag(
            DbT5208NinteichosahyoServiceJokyoFlagEntity entity,
            NinteichosahyoServiceJokyoFlagIdentifier id
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
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaRirekiNo();
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
     * サービスの状況フラグを返します。
     *
     * @return サービスの状況フラグ
     */
    public boolean isサービスの状況フラグ() {
        return entity.getServiceJokyoFlag();
    }

    /**
     * {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}のクローンを返します。
     *
     * @return {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}のクローン
     */
    @Override
    public DbT5208NinteichosahyoServiceJokyoFlagEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票_概況調査_サービスの状況フラグの識別子{@link NinteichosahyoServiceJokyoFlagIdentifier}を返します。
     *
     * @return
     * 認定調査票_概況調査_サービスの状況フラグの識別子{@link NinteichosahyoServiceJokyoFlagIdentifier}
     */
    @Override
    public NinteichosahyoServiceJokyoFlagIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票_概況調査_サービスの状況フラグのみを変更対象とします。<br/>
     * {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoServiceJokyoFlag}
     */
    public NinteichosahyoServiceJokyoFlag modifiedModel() {
        DbT5208NinteichosahyoServiceJokyoFlagEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoServiceJokyoFlag(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票_概況調査_サービスの状況フラグを削除対象とします。<br/>
     * {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoServiceJokyoFlag}
     */
    @Override
    public NinteichosahyoServiceJokyoFlag deleted() {
        DbT5208NinteichosahyoServiceJokyoFlagEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoServiceJokyoFlag(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoServiceJokyoFlag}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoServiceJokyoFlag}のシリアライズ形式
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
        private final DbT5208NinteichosahyoServiceJokyoFlagEntity entity;
        private final NinteichosahyoServiceJokyoFlagIdentifier id;

        private _SerializationProxy(DbT5208NinteichosahyoServiceJokyoFlagEntity entity, NinteichosahyoServiceJokyoFlagIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoServiceJokyoFlag(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoServiceJokyoFlagBuilder createBuilderForEdit() {
        return new NinteichosahyoServiceJokyoFlagBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
