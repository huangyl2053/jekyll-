/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書記入項目を管理するクラスです。
 */
public class ShujiiIkenshoKinyuItem extends ModelBase<ShujiiIkenshoKinyuItemIdentifier, DbT5303ShujiiIkenshoKinyuItemEntity, ShujiiIkenshoKinyuItem> implements Serializable {

    private static final long serialVersionUID = 3817856119698703295L;

    private final DbT5303ShujiiIkenshoKinyuItemEntity entity;
    private final ShujiiIkenshoKinyuItemIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定主治医意見書記入項目の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 連番 連番
     */
    public ShujiiIkenshoKinyuItem(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.entity.setRemban(連番);
        this.id = new ShujiiIkenshoKinyuItemIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号,
                連番
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
                entity.getIkenshoIraiRirekiNo(),
                entity.getRemban());
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
    public ShujiiIkenshoKinyuItem modifiedModel() {
        DbT5303ShujiiIkenshoKinyuItemEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
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
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -7833460279107078858L;

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
        final ShujiiIkenshoKinyuItem other = (ShujiiIkenshoKinyuItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
