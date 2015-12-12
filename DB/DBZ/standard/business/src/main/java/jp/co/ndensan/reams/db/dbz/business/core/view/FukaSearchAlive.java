/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 賦課検索Aliveを管理するクラスです。
 */
public class FukaSearchAlive extends ParentModelBase<FukaSearchAliveIdentifier, DbV7902FukaSearchEntity, FukaSearchAlive> implements Serializable {

    private final DbV7902FukaSearchEntity entity;
    private final FukaSearchAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 賦課検索Aliveの新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     */
    public FukaSearchAlive(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.entity = new DbV7902FukaSearchEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setFukaNendo(賦課年度);
        this.entity.setTsuchishoNo(通知書番号);
        this.id = new FukaSearchAliveIdentifier(
                調定年度,
                賦課年度,
                通知書番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV7902FukaSearchEntity}より{@link FukaSearchAlive}を生成します。
     *
     * @param entity DBより取得した{@link DbV7902FukaSearchEntity}
     */
    public FukaSearchAlive(DbV7902FukaSearchEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課検索Alive"));
        this.id = new FukaSearchAliveIdentifier(
                entity.getChoteiNendo(),
                entity.getFukaNendo(),
                entity.getTsuchishoNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV7902FukaSearchEntity}
     * @param id {@link FukaSearchAliveIdentifier}
     */
    FukaSearchAlive(
            DbV7902FukaSearchEntity entity,
            FukaSearchAliveIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 調定年度を返します。
     *
     * @return 調定年度
     */
    public FlexibleYear get調定年度() {
        return entity.getChoteiNendo();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 被保台帳被保険者番号を返します。
     *
     * @return 被保台帳被保険者番号
     */
    public HihokenshaNo get被保台帳被保険者番号() {
        return entity.getHihodaichoHihokenshaNo();
    }

    /**
     * {@link DbV7902FukaSearchEntity}のクローンを返します。
     *
     * @return {@link DbV7902FukaSearchEntity}のクローン
     */
    @Override
    public DbV7902FukaSearchEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 賦課検索Aliveの識別子{@link FukaSearchAliveIdentifier}を返します。
     *
     * @return 賦課検索Aliveの識別子{@link FukaSearchAliveIdentifier}
     */
    @Override
    public FukaSearchAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 賦課検索Aliveのみを変更対象とします。<br/>
     * {@link DbV7902FukaSearchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FukaSearchAlive}
     */
    @Override
    public FukaSearchAlive modifiedModel() {
        DbV7902FukaSearchEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FukaSearchAlive(
                modifiedEntity, id);
    }

    /**
     * 保持する賦課検索Aliveを削除対象とします。<br/>
     * {@link DbV7902FukaSearchEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FukaSearchAlive}
     */
    @Override
    public FukaSearchAlive deleted() {
        DbV7902FukaSearchEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FukaSearchAlive(deletedEntity, id);
    }

    /**
     * {@link FukaSearchAlive}のシリアライズ形式を提供します。
     *
     * @return {@link FukaSearchAlive}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbV7902FukaSearchEntity entity;
        private final FukaSearchAliveIdentifier id;

        private _SerializationProxy(DbV7902FukaSearchEntity entity, FukaSearchAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FukaSearchAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FukaSearchAliveBuilder createBuilderForEdit() {
        return new FukaSearchAliveBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
