/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票_基本調査_調査項目を管理するクラスです。
 */
public class NinteichosahyoChosaItem extends
        ModelBase<NinteichosahyoChosaItemIdentifier, DbT5211NinteichosahyoChosaItemEntity, NinteichosahyoChosaItem> implements Serializable {

    private final DbT5211NinteichosahyoChosaItemEntity entity;
    private final NinteichosahyoChosaItemIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票_基本調査_調査項目の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     */
    public NinteichosahyoChosaItem(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5211NinteichosahyoChosaItemEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        this.entity.setRemban(連番);
        this.id = new NinteichosahyoChosaItemIdentifier(
                申請書管理番号,
                要介護認定調査履歴番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5211NinteichosahyoChosaItemEntity}より{@link NinteichosahyoChosaItem}を生成します。
     *
     * @param entity DBより取得した{@link DbT5211NinteichosahyoChosaItemEntity}
     */
    public NinteichosahyoChosaItem(DbT5211NinteichosahyoChosaItemEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査_調査項目"));
        this.id = new NinteichosahyoChosaItemIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo(),
                entity.getRemban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5211NinteichosahyoChosaItemEntity}
     * @param id {@link NinteichosahyoChosaItemIdentifier}
     */
    NinteichosahyoChosaItem(
            DbT5211NinteichosahyoChosaItemEntity entity,
            NinteichosahyoChosaItemIdentifier id
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
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public RString get調査項目() {
        return entity.getResearchItem();
    }

    /**
     * {@link DbT5211NinteichosahyoChosaItemEntity}のクローンを返します。
     *
     * @return {@link DbT5211NinteichosahyoChosaItemEntity}のクローン
     */
    @Override
    public DbT5211NinteichosahyoChosaItemEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票_基本調査_調査項目の識別子{@link NinteichosahyoChosaItemIdentifier}を返します。
     *
     * @return 認定調査票_基本調査_調査項目の識別子{@link NinteichosahyoChosaItemIdentifier}
     */
    @Override
    public NinteichosahyoChosaItemIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票_基本調査_調査項目のみを変更対象とします。<br/>
     * {@link DbT5211NinteichosahyoChosaItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoChosaItem}
     */
    public NinteichosahyoChosaItem modifiedModel() {
        DbT5211NinteichosahyoChosaItemEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoChosaItem(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票_基本調査_調査項目を削除対象とします。<br/>
     * {@link DbT5211NinteichosahyoChosaItemEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoChosaItem}
     */
    @Override
    public NinteichosahyoChosaItem deleted() {
        DbT5211NinteichosahyoChosaItemEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoChosaItem(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoChosaItem}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoChosaItem}のシリアライズ形式
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
        private final DbT5211NinteichosahyoChosaItemEntity entity;
        private final NinteichosahyoChosaItemIdentifier id;

        private _SerializationProxy(DbT5211NinteichosahyoChosaItemEntity entity, NinteichosahyoChosaItemIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoChosaItem(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoChosaItemBuilder createBuilderForEdit() {
        return new NinteichosahyoChosaItemBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
