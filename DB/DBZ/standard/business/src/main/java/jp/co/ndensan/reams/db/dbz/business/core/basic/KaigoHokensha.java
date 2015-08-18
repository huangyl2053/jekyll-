/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険者を管理するクラスです。
 */
public class KaigoHokensha extends ParentModelBase<KaigoHokenshaIdentifier, DbT7050KaigoHokenshaEntity, KaigoHokensha> implements Serializable {

    private final DbT7050KaigoHokenshaEntity entity;
    private final KaigoHokenshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護保険者の新規作成時に使用します。
     *
     * @param 広域保険者市町村コード 広域保険者市町村コード
     */
    public KaigoHokensha(LasdecCode 広域保険者市町村コード) {
        requireNonNull(広域保険者市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広域保険者市町村コード"));
        this.entity = new DbT7050KaigoHokenshaEntity();
        this.entity.setKoikiHokenshaShichosonCode(広域保険者市町村コード);
        this.id = new KaigoHokenshaIdentifier(
                広域保険者市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7050KaigoHokenshaEntity}より{@link KaigoHokensha}を生成します。
     *
     * @param entity DBより取得した{@link DbT7050KaigoHokenshaEntity}
     */
    public KaigoHokensha(DbT7050KaigoHokenshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険者"));
        this.id = new KaigoHokenshaIdentifier(
                entity.getKoikiHokenshaShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7050KaigoHokenshaEntity}
     * @param id {@link KaigoHokenshaIdentifier}
     */
    KaigoHokensha(
            DbT7050KaigoHokenshaEntity entity,
            KaigoHokenshaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 広域保険者市町村コードを返します。
     *
     * @return 広域保険者市町村コード
     */
    public LasdecCode get広域保険者市町村コード() {
        return entity.getKoikiHokenshaShichosonCode();
    }

    /**
     * 広域保険者番号を返します。
     *
     * @return 広域保険者番号
     */
    public ShoKisaiHokenshaNo get広域保険者番号() {
        return entity.getKoikiHokenshaNo();
    }

    /**
     * {@link DbT7050KaigoHokenshaEntity}のクローンを返します。
     *
     * @return {@link DbT7050KaigoHokenshaEntity}のクローン
     */
    @Override
    public DbT7050KaigoHokenshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護保険者の識別子{@link KaigoHokenshaIdentifier}を返します。
     *
     * @return 介護保険者の識別子{@link KaigoHokenshaIdentifier}
     */
    @Override
    public KaigoHokenshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護保険者のみを変更対象とします。<br/>
     * {@link DbT7050KaigoHokenshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KaigoHokensha}
     */
    @Override
    public KaigoHokensha modifiedModel() {
        DbT7050KaigoHokenshaEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KaigoHokensha(
                modifiedEntity, id);
    }

    /**
     * 保持する介護保険者を削除対象とします。<br/>
     * {@link DbT7050KaigoHokenshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoHokensha}
     */
    @Override
    public KaigoHokensha deleted() {
        DbT7050KaigoHokenshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoHokensha(deletedEntity, id);
    }

    /**
     * {@link KaigoHokensha}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoHokensha}のシリアライズ形式
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
        private final DbT7050KaigoHokenshaEntity entity;
        private final KaigoHokenshaIdentifier id;

        private _SerializationProxy(DbT7050KaigoHokenshaEntity entity, KaigoHokenshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoHokensha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoHokenshaBuilder createBuilderForEdit() {
        return new KaigoHokenshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
