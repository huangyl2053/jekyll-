/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（基本調査素点項目）を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScoreItem extends ModelBase<NinteichosahyoKihonChosaScoreItemIdentifier, DbT5212NinteichosahyoKihonChosaScoreItemEntity, NinteichosahyoKihonChosaScoreItem> implements Serializable {

    private final DbT5212NinteichosahyoKihonChosaScoreItemEntity entity;
    private final NinteichosahyoKihonChosaScoreItemIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（基本調査素点項目）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     */
    public NinteichosahyoKihonChosaScoreItem(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5212NinteichosahyoKihonChosaScoreItemEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        this.entity.setRemban(連番);
        this.id = new NinteichosahyoKihonChosaScoreItemIdentifier(
                申請書管理番号,
                要介護認定調査履歴番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}より{@link NinteichosahyoKihonChosaScoreItem}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}
     */
    public NinteichosahyoKihonChosaScoreItem(DbT5212NinteichosahyoKihonChosaScoreItemEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点項目）"));
        this.id = new NinteichosahyoKihonChosaScoreItemIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}
     * @param id {@link NinteichosahyoKihonChosaScoreItemIdentifier}
     */
    NinteichosahyoKihonChosaScoreItem(
            DbT5212NinteichosahyoKihonChosaScoreItemEntity entity,
            NinteichosahyoKihonChosaScoreItemIdentifier id
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
     * 要介護認定調査履歴番号を返します。
     *
     * @return 要介護認定調査履歴番号
     */
    public int get要介護認定調査履歴番号() {
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
     * 素点項目を返します。
     *
     * @return 素点項目
     */
    public int get素点項目() {
        return entity.getReserchItem01();
    }

    /**
     * {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}のクローンを返します。
     *
     * @return {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}のクローン
     */
    @Override
    public DbT5212NinteichosahyoKihonChosaScoreItemEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（基本調査素点項目）の識別子{@link NinteichosahyoKihonChosaScoreItemIdentifier}を返します。
     *
     * @return
     * 認定調査票（基本調査素点項目）の識別子{@link NinteichosahyoKihonChosaScoreItemIdentifier}
     */
    @Override
    public NinteichosahyoKihonChosaScoreItemIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（基本調査素点項目）のみを変更対象とします。<br/>
     * {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoKihonChosaScoreItem}
     */
    public NinteichosahyoKihonChosaScoreItem modifiedModel() {
        DbT5212NinteichosahyoKihonChosaScoreItemEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoKihonChosaScoreItem(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票（基本調査素点項目）を削除対象とします。<br/>
     * {@link DbT5212NinteichosahyoKihonChosaScoreItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoKihonChosaScoreItem}
     */
    @Override
    public NinteichosahyoKihonChosaScoreItem deleted() {
        DbT5212NinteichosahyoKihonChosaScoreItemEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoKihonChosaScoreItem(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoKihonChosaScoreItem}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoKihonChosaScoreItem}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -6048140315875246112L;
        private final DbT5212NinteichosahyoKihonChosaScoreItemEntity entity;
        private final NinteichosahyoKihonChosaScoreItemIdentifier id;

        private _SerializationProxy(DbT5212NinteichosahyoKihonChosaScoreItemEntity entity, NinteichosahyoKihonChosaScoreItemIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoKihonChosaScoreItem(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosahyoKihonChosaScoreItemBuilder.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoKihonChosaScoreItemBuilder createBuilderForEdit() {
        return new NinteichosahyoKihonChosaScoreItemBuilder(entity, id);
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
        final NinteichosahyoKihonChosaScoreItem other = (NinteichosahyoKihonChosaScoreItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
