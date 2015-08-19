/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書記入項目を管理するクラスです。
 */
public class ShujiiIkenshoKinyuItem extends ParentModelBase<ShujiiIkenshoKinyuItemIdentifier, DbT5303ShujiiIkenshoKinyuItemEntity, ShujiiIkenshoKinyuItem> implements Serializable {

    private final DbT5303ShujiiIkenshoKinyuItemEntity entity;
    private final ShujiiIkenshoKinyuItemIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定主治医意見書記入項目の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public ShujiiIkenshoKinyuItem(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        this.entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.id = new ShujiiIkenshoKinyuItemIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5303ShujiiIkenshoKinyuItemEntity}より{@link ShujiiIkenshoKinyuItem}を生成します。
     *
     * @param entity DBより取得した{@link DbT5303ShujiiIkenshoKinyuItemEntity}
     */
    public ShujiiIkenshoKinyuItem(DbT5303ShujiiIkenshoKinyuItemEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書記入項目"));
        this.id = new ShujiiIkenshoKinyuItemIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getIkenshoIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5303ShujiiIkenshoKinyuItemEntity}
     * @param id {@link ShujiiIkenshoKinyuItemIdentifier}
     */
    ShujiiIkenshoKinyuItem(
            DbT5303ShujiiIkenshoKinyuItemEntity entity,
            ShujiiIkenshoKinyuItemIdentifier id
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
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getIkenshoIraiRirekiNo();
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
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 記入項目を返します。
     *
     * @return 記入項目
     */
    public RString get記入項目() {
        return entity.getKinyuItem();
    }

    /**
     * 記入項目イメージ共有ファイルIDを返します。
     *
     * @return 記入項目イメージ共有ファイルID
     */
    public RDateTime get記入項目イメージ共有ファイルID() {
        return entity.getKinyuItemImageSharedFileId();
    }

    /**
     * {@link DbT5303ShujiiIkenshoKinyuItemEntity}のクローンを返します。
     *
     * @return {@link DbT5303ShujiiIkenshoKinyuItemEntity}のクローン
     */
    @Override
    public DbT5303ShujiiIkenshoKinyuItemEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定主治医意見書記入項目の識別子{@link ShujiiIkenshoKinyuItemIdentifier}を返します。
     *
     * @return 要介護認定主治医意見書記入項目の識別子{@link ShujiiIkenshoKinyuItemIdentifier}
     */
    @Override
    public ShujiiIkenshoKinyuItemIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定主治医意見書記入項目のみを変更対象とします。<br/>
     * {@link DbT5303ShujiiIkenshoKinyuItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoKinyuItem}
     */
    @Override
    public ShujiiIkenshoKinyuItem modifiedModel() {
        DbT5303ShujiiIkenshoKinyuItemEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoKinyuItem(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定主治医意見書記入項目を削除対象とします。<br/>
     * {@link DbT5303ShujiiIkenshoKinyuItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoKinyuItem}
     */
    @Override
    public ShujiiIkenshoKinyuItem deleted() {
        DbT5303ShujiiIkenshoKinyuItemEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoKinyuItem(deletedEntity, id);
    }

    /**
     * {@link ShujiiIkenshoKinyuItem}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoKinyuItem}のシリアライズ形式
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
        private final DbT5303ShujiiIkenshoKinyuItemEntity entity;
        private final ShujiiIkenshoKinyuItemIdentifier id;

        private _SerializationProxy(DbT5303ShujiiIkenshoKinyuItemEntity entity, ShujiiIkenshoKinyuItemIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIkenshoKinyuItem(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIkenshoKinyuItemBuilder createBuilderForEdit() {
        return new ShujiiIkenshoKinyuItemBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
