/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書意見項目を管理するクラスです。
 */
public class ShujiiIkenshoIkenItem extends ModelBase<ShujiiIkenshoIkenItemIdentifier, DbT5304ShujiiIkenshoIkenItemEntity, ShujiiIkenshoIkenItem> implements Serializable {

    private static final long serialVersionUID = 7941628879047051321L;

    private final DbT5304ShujiiIkenshoIkenItemEntity entity;
    private final ShujiiIkenshoIkenItemIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定主治医意見書意見項目の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 連番 連番
     */
    public ShujiiIkenshoIkenItem(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5304ShujiiIkenshoIkenItemEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.entity.setRemban(連番);
        this.id = new ShujiiIkenshoIkenItemIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5304ShujiiIkenshoIkenItemEntity}より{@link ShujiiIkenshoIkenItem}を生成します。
     *
     * @param entity DBより取得した{@link DbT5304ShujiiIkenshoIkenItemEntity}
     */
    public ShujiiIkenshoIkenItem(DbT5304ShujiiIkenshoIkenItemEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書意見項目"));
        this.id = new ShujiiIkenshoIkenItemIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getIkenshoIraiRirekiNo(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5304ShujiiIkenshoIkenItemEntity}
     * @param id {@link ShujiiIkenshoIkenItemIdentifier}
     */
    ShujiiIkenshoIkenItem(
            DbT5304ShujiiIkenshoIkenItemEntity entity,
            ShujiiIkenshoIkenItemIdentifier id
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
     * 意見項目を返します。
     *
     * @return 意見項目
     */
    public RString get意見項目() {
        return entity.getIkenItem();
    }

    /**
     * {@link DbT5304ShujiiIkenshoIkenItemEntity}のクローンを返します。
     *
     * @return {@link DbT5304ShujiiIkenshoIkenItemEntity}のクローン
     */
    @Override
    public DbT5304ShujiiIkenshoIkenItemEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定主治医意見書意見項目の識別子{@link ShujiiIkenshoIkenItemIdentifier}を返します。
     *
     * @return 要介護認定主治医意見書意見項目の識別子{@link ShujiiIkenshoIkenItemIdentifier}
     */
    @Override
    public ShujiiIkenshoIkenItemIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定主治医意見書意見項目のみを変更対象とします。<br/>
     * {@link DbT5304ShujiiIkenshoIkenItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoIkenItem}
     */
    public ShujiiIkenshoIkenItem modifiedModel() {
        DbT5304ShujiiIkenshoIkenItemEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoIkenItem(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定主治医意見書意見項目を削除対象とします。<br/>
     * {@link DbT5304ShujiiIkenshoIkenItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoIkenItem}
     */
    @Override
    public ShujiiIkenshoIkenItem deleted() {
        DbT5304ShujiiIkenshoIkenItemEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoIkenItem(deletedEntity, id);
    }

    /**
     * {@link ShujiiIkenshoIkenItem}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoIkenItem}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1716150765905891068L;

        private final DbT5304ShujiiIkenshoIkenItemEntity entity;
        private final ShujiiIkenshoIkenItemIdentifier id;

        private _SerializationProxy(DbT5304ShujiiIkenshoIkenItemEntity entity, ShujiiIkenshoIkenItemIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIkenshoIkenItem(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIkenshoIkenItemBuilder createBuilderForEdit() {
        return new ShujiiIkenshoIkenItemBuilder(entity, id);
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
        final ShujiiIkenshoIkenItem other = (ShujiiIkenshoIkenItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
