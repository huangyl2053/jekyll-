/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2016FukinitsuNokiKanriEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 不均一納期を管理するクラスです。
 *
 * @reamsid_L DBB-9999-012 cuilin
 */
public class FukinitsuNokiKanri extends ParentModelBase<FukinitsuNokiKanriIdentifier, DbT2016FukinitsuNokiKanriEntity, FukinitsuNokiKanri>
        implements Serializable {

    private final DbT2016FukinitsuNokiKanriEntity entity;
    private final FukinitsuNokiKanriIdentifier id;
    private static final RString 調定年度メッセージ = new RString("調定年度");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 不均一納期管理 = new RString("不均一納期管理");

    /**
     * コンストラクタです。<br/>
     * 不均一納期管理の新規作成時に使用します。
     *
     * @param 調定年度 調定年度
     * @param 市町村コード 市町村コード
     */
    public FukinitsuNokiKanri(FlexibleYear 調定年度,
            LasdecCode 市町村コード) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage(調定年度メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        this.entity = new DbT2016FukinitsuNokiKanriEntity();
        this.entity.setChoteiNendo(調定年度);
        this.entity.setShichosonCode(市町村コード);
        this.id = new FukinitsuNokiKanriIdentifier(
                調定年度,
                市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT2016FukinitsuNokiKanriEntity}より{@link FukinitsuNokiKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT2016FukinitsuNokiKanriEntity}
     */
    public FukinitsuNokiKanri(DbT2016FukinitsuNokiKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(不均一納期管理.toString()));
        this.id = new FukinitsuNokiKanriIdentifier(
                entity.getChoteiNendo(),
                entity.getShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT2016FukinitsuNokiKanriEntity}
     * @param id {@link FukinitsuNokiKanriIdentifier}
     */
    FukinitsuNokiKanri(
            DbT2016FukinitsuNokiKanriEntity entity,
            FukinitsuNokiKanriIdentifier id
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * {@link DbT2016FukinitsuNokiKanriEntity}のクローンを返します。
     *
     * @return {@link DbT2016FukinitsuNokiKanriEntity}のクローン
     */
    @Override
    public DbT2016FukinitsuNokiKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 不均一納期管理の識別子{@link FukinitsuNokiKanriIdentifier}を返します。
     *
     * @return 不均一納期管理の識別子{@link FukinitsuNokiKanriIdentifier}
     */
    @Override
    public FukinitsuNokiKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 不均一納期管理のみを変更対象とします。<br/>
     * {@link DbT2016FukinitsuNokiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FukinitsuNokiKanri}
     */
    @Override
    public FukinitsuNokiKanri modifiedModel() {
        DbT2016FukinitsuNokiKanriEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FukinitsuNokiKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する不均一納期管理を削除対象とします。<br/>
     * {@link DbT2016FukinitsuNokiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FukinitsuNokiKanri}
     */
    @Override
    public FukinitsuNokiKanri deleted() {
        DbT2016FukinitsuNokiKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FukinitsuNokiKanri(deletedEntity, id);
    }

    /**
     * {@link FukinitsuNokiKanri}のシリアライズ形式を提供します。
     *
     * @return {@link FukinitsuNokiKanri}のシリアライズ形式
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
        private final DbT2016FukinitsuNokiKanriEntity entity;
        private final FukinitsuNokiKanriIdentifier id;

        private _SerializationProxy(DbT2016FukinitsuNokiKanriEntity entity, FukinitsuNokiKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new FukinitsuNokiKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FukinitsuNokiKanriBuilder createBuilderForEdit() {
        return new FukinitsuNokiKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
