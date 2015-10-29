/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 地区市町村を管理するクラスです。
 */
public class ChikuShichoson extends
        ParentModelBase<ChikuShichosonIdentifier, DbT5224ChikuShichosonEntity, ChikuShichoson>
        implements Serializable {

    private final DbT5224ChikuShichosonEntity entity;
    private final ChikuShichosonIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 地区市町村の新規作成時に使用します。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     */
    public ChikuShichoson(Code 調査地区コード,
            LasdecCode 市町村コード) {
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.entity = new DbT5224ChikuShichosonEntity();
        this.entity.setChosaChikuCode(調査地区コード);
        this.entity.setShichosonCode(市町村コード);
        this.id = new ChikuShichosonIdentifier(
                調査地区コード,
                市町村コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5224ChikuShichosonEntity}より{@link ChikuShichoson}を生成します。
     *
     * @param entity DBより取得した{@link DbT5224ChikuShichosonEntity}
     */
    public ChikuShichoson(DbT5224ChikuShichosonEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地区市町村"));
        this.id = new ChikuShichosonIdentifier(
                entity.getChosaChikuCode(),
                entity.getShichosonCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5224ChikuShichosonEntity}
     * @param id {@link ChikuShichosonIdentifier}
     */
    ChikuShichoson(
            DbT5224ChikuShichosonEntity entity,
            ChikuShichosonIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 調査地区コードを返します。
     *
     * @return 調査地区コード
     */
    public Code get調査地区コード() {
        return entity.getChosaChikuCode();
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
     * 優先番号を返します。
     *
     * @return 優先番号
     */
    public int get優先番号() {
        return entity.getYusenNo();
    }

    /**
     * 自地区フラグを返します。
     *
     * @return 自地区フラグ
     */
    public boolean is自地区フラグ() {
        return entity.getJiChikuFlag();
    }

    /**
     * {@link DbT5224ChikuShichosonEntity}のクローンを返します。
     *
     * @return {@link DbT5224ChikuShichosonEntity}のクローン
     */
    @Override
    public DbT5224ChikuShichosonEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 地区市町村の識別子{@link ChikuShichosonIdentifier}を返します。
     *
     * @return 地区市町村の識別子{@link ChikuShichosonIdentifier}
     */
    @Override
    public ChikuShichosonIdentifier identifier() {
        return this.id;
    }

    /**
     * 地区市町村のみを変更対象とします。<br/>
     * {@link DbT5224ChikuShichosonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChikuShichoson}
     */
    @Override
    public ChikuShichoson modifiedModel() {
        DbT5224ChikuShichosonEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChikuShichoson(
                modifiedEntity, id);
    }

    /**
     * 保持する地区市町村を削除対象とします。<br/>
     * {@link DbT5224ChikuShichosonEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChikuShichoson}
     */
    @Override
    public ChikuShichoson deleted() {
        DbT5224ChikuShichosonEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChikuShichoson(deletedEntity, id);
    }

    /**
     * {@link ChikuShichoson}のシリアライズ形式を提供します。
     *
     * @return {@link ChikuShichoson}のシリアライズ形式
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
        private final DbT5224ChikuShichosonEntity entity;
        private final ChikuShichosonIdentifier id;

        private _SerializationProxy(DbT5224ChikuShichosonEntity entity, ChikuShichosonIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChikuShichoson(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChikuShichosonBuilder createBuilderForEdit() {
        return new ChikuShichosonBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
