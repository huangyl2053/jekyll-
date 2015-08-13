/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 関連被保険者番号を管理するクラスです。
 */
public class KanrenHihokenshaNo extends ParentModelBase<KanrenHihokenshaNoIdentifier, DbT7054KanrenHihokenshaNoEntity, KanrenHihokenshaNo> implements Serializable {

    private final DbT7054KanrenHihokenshaNoEntity entity;
    private final KanrenHihokenshaNoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 関連被保険者番号の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 最新被保険者番号 最新被保険者番号
     */
    public KanrenHihokenshaNo(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 最新被保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(最新被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("最新被保険者番号"));
        this.entity = new DbT7054KanrenHihokenshaNoEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setSaishinHihokenshaNo(最新被保険者番号);
        this.id = new KanrenHihokenshaNoIdentifier(
                証記載保険者番号,
                最新被保険者番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7054KanrenHihokenshaNoEntity}より{@link KanrenHihokenshaNo}を生成します。
     *
     * @param entity DBより取得した{@link DbT7054KanrenHihokenshaNoEntity}
     */
    public KanrenHihokenshaNo(DbT7054KanrenHihokenshaNoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("関連被保険者番号"));
        this.id = new KanrenHihokenshaNoIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getSaishinHihokenshaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7054KanrenHihokenshaNoEntity}
     * @param id {@link KanrenHihokenshaNoIdentifier}
     */
    KanrenHihokenshaNo(
            DbT7054KanrenHihokenshaNoEntity entity,
            KanrenHihokenshaNoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 最新被保険者番号を返します。
     *
     * @return 最新被保険者番号
     */
    public HihokenshaNo get最新被保険者番号() {
        return entity.getSaishinHihokenshaNo();
    }

    /**
     * 旧被保険者番号を返します。
     *
     * @return 旧被保険者番号
     */
    public HihokenshaNo get旧被保険者番号() {
        return entity.getKyuuHihokenshaNo();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * {@link DbT7054KanrenHihokenshaNoEntity}のクローンを返します。
     *
     * @return {@link DbT7054KanrenHihokenshaNoEntity}のクローン
     */
    @Override
    public DbT7054KanrenHihokenshaNoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 関連被保険者番号の識別子{@link KanrenHihokenshaNoIdentifier}を返します。
     *
     * @return 関連被保険者番号の識別子{@link KanrenHihokenshaNoIdentifier}
     */
    @Override
    public KanrenHihokenshaNoIdentifier identifier() {
        return this.id;
    }

    /**
     * 関連被保険者番号のみを変更対象とします。<br/>
     * {@link DbT7054KanrenHihokenshaNoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KanrenHihokenshaNo}
     */
    @Override
    public KanrenHihokenshaNo modifiedModel() {
        DbT7054KanrenHihokenshaNoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KanrenHihokenshaNo(
                modifiedEntity, id);
    }

    /**
     * 保持する関連被保険者番号を削除対象とします。<br/>
     * {@link DbT7054KanrenHihokenshaNoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KanrenHihokenshaNo}
     */
    @Override
    public KanrenHihokenshaNo deleted() {
        DbT7054KanrenHihokenshaNoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KanrenHihokenshaNo(deletedEntity, id);
    }

    /**
     * {@link KanrenHihokenshaNo}のシリアライズ形式を提供します。
     *
     * @return {@link KanrenHihokenshaNo}のシリアライズ形式
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
        private final DbT7054KanrenHihokenshaNoEntity entity;
        private final KanrenHihokenshaNoIdentifier id;

        private _SerializationProxy(DbT7054KanrenHihokenshaNoEntity entity, KanrenHihokenshaNoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KanrenHihokenshaNo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KanrenHihokenshaNoBuilder createBuilderForEdit() {
        return new KanrenHihokenshaNoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
