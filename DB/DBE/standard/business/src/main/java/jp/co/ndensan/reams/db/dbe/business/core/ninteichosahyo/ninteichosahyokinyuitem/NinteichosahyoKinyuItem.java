/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（概況調査）記入項目を管理するクラスです。
 */
public class NinteichosahyoKinyuItem extends ModelBase<NinteichosahyoKinyuItemIdentifier, DbT5209NinteichosahyoKinyuItemEntity, NinteichosahyoKinyuItem> implements Serializable {

    private final DbT5209NinteichosahyoKinyuItemEntity entity;
    private final NinteichosahyoKinyuItemIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（概況調査）記入項目の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     */
    public NinteichosahyoKinyuItem(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5209NinteichosahyoKinyuItemEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(認定調査依頼履歴番号);
        this.entity.setRemban(連番);
        this.id = new NinteichosahyoKinyuItemIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5209NinteichosahyoKinyuItemEntity}より{@link NinteichosahyoKinyuItem}を生成します。
     *
     * @param entity DBより取得した{@link DbT5209NinteichosahyoKinyuItemEntity}
     */
    public NinteichosahyoKinyuItem(DbT5209NinteichosahyoKinyuItemEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）記入項目"));
        this.id = new NinteichosahyoKinyuItemIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5209NinteichosahyoKinyuItemEntity}
     * @param id {@link NinteichosahyoKinyuItemIdentifier}
     */
    NinteichosahyoKinyuItem(
            DbT5209NinteichosahyoKinyuItemEntity entity,
            NinteichosahyoKinyuItemIdentifier id
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
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * サービスの状況記入を返します。
     *
     * @return サービスの状況記入
     */
    public RString getサービスの状況記入() {
        return entity.getServiceJokyoKinyu();
    }

    /**
     * サービスの状況イメージ共有ファイルIDを返します。
     *
     * @return サービスの状況イメージ共有ファイルID
     */
    public RDateTime getサービスの状況イメージ共有ファイルID() {
        return entity.getServiceJokyoImageSharedFileId();
    }

    /**
     * {@link DbT5209NinteichosahyoKinyuItemEntity}のクローンを返します。
     *
     * @return {@link DbT5209NinteichosahyoKinyuItemEntity}のクローン
     */
    @Override
    public DbT5209NinteichosahyoKinyuItemEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（概況調査）記入項目の識別子{@link NinteichosahyoKinyuItemIdentifier}を返します。
     *
     * @return 認定調査票（概況調査）記入項目の識別子{@link NinteichosahyoKinyuItemIdentifier}
     */
    @Override
    public NinteichosahyoKinyuItemIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（概況調査）記入項目のみを変更対象とします。<br/>
     * {@link DbT5209NinteichosahyoKinyuItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoKinyuItem}
     */
    public NinteichosahyoKinyuItem modifiedModel() {
        DbT5209NinteichosahyoKinyuItemEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoKinyuItem(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票（概況調査）記入項目を削除対象とします。<br/>
     * {@link DbT5209NinteichosahyoKinyuItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoKinyuItem}
     */
    @Override
    public NinteichosahyoKinyuItem deleted() {
        DbT5209NinteichosahyoKinyuItemEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoKinyuItem(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoKinyuItem}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoKinyuItem}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -6307294066258862797L;
        private final DbT5209NinteichosahyoKinyuItemEntity entity;
        private final NinteichosahyoKinyuItemIdentifier id;

        private _SerializationProxy(DbT5209NinteichosahyoKinyuItemEntity entity, NinteichosahyoKinyuItemIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoKinyuItem(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosahyoKinyuItemBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoKinyuItemBuilder createBuilderForEdit() {
        return new NinteichosahyoKinyuItemBuilder(entity, id);
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
        final NinteichosahyoKinyuItem other = (NinteichosahyoKinyuItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
