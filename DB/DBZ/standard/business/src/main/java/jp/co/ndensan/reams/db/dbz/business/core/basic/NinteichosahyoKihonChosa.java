/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（基本調査）を管理するクラスです。
 */
public class NinteichosahyoKihonChosa extends
        ModelBase<NinteichosahyoKihonChosaIdentifier, DbT5203NinteichosahyoKihonChosaEntity, NinteichosahyoKihonChosa> implements Serializable {

    private final DbT5203NinteichosahyoKihonChosaEntity entity;
    private final NinteichosahyoKihonChosaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（基本調査）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     */
    public NinteichosahyoKihonChosa(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        this.entity = new DbT5203NinteichosahyoKihonChosaEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        this.id = new NinteichosahyoKihonChosaIdentifier(
                申請書管理番号,
                要介護認定調査履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5203NinteichosahyoKihonChosaEntity}より{@link NinteichosahyoKihonChosa}を生成します。
     *
     * @param entity DBより取得した{@link DbT5203NinteichosahyoKihonChosaEntity}
     */
    public NinteichosahyoKihonChosa(DbT5203NinteichosahyoKihonChosaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）"));
        this.id = new NinteichosahyoKihonChosaIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5203NinteichosahyoKihonChosaEntity}
     * @param id {@link NinteichosahyoKihonChosaIdentifier}
     */
    NinteichosahyoKihonChosa(
            DbT5203NinteichosahyoKihonChosaEntity entity,
            NinteichosahyoKihonChosaIdentifier id
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
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 認定調査_認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査_認知症高齢者の日常生活自立度コード
     */
    public Code get認定調査_認知症高齢者の日常生活自立度コード() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 認定調査_障害高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査_障害高齢者の日常生活自立度コード
     */
    public Code get認定調査_障害高齢者の日常生活自立度コード() {
        return entity.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * {@link DbT5203NinteichosahyoKihonChosaEntity}のクローンを返します。
     *
     * @return {@link DbT5203NinteichosahyoKihonChosaEntity}のクローン
     */
    @Override
    public DbT5203NinteichosahyoKihonChosaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（基本調査）の識別子{@link NinteichosahyoKihonChosaIdentifier}を返します。
     *
     * @return 認定調査票（基本調査）の識別子{@link NinteichosahyoKihonChosaIdentifier}
     */
    @Override
    public NinteichosahyoKihonChosaIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（基本調査）のみを変更対象とします。<br/>
     * {@link DbT5203NinteichosahyoKihonChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoKihonChosa}
     */
    public NinteichosahyoKihonChosa modifiedModel() {
        DbT5203NinteichosahyoKihonChosaEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoKihonChosa(
                modifiedEntity, id);
    }

    /**
     * 保持する認定調査票（基本調査）を削除対象とします。<br/>
     * {@link DbT5203NinteichosahyoKihonChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoKihonChosa}
     */
    @Override
    public NinteichosahyoKihonChosa deleted() {
        DbT5203NinteichosahyoKihonChosaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoKihonChosa(deletedEntity, id);
    }

    /**
     * {@link NinteichosahyoKihonChosa}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoKihonChosa}のシリアライズ形式
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
        private final DbT5203NinteichosahyoKihonChosaEntity entity;
        private final NinteichosahyoKihonChosaIdentifier id;

        private _SerializationProxy(DbT5203NinteichosahyoKihonChosaEntity entity, NinteichosahyoKihonChosaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteichosahyoKihonChosa(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteichosahyoKihonChosaBuilder createBuilderForEdit() {
        return new NinteichosahyoKihonChosaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
