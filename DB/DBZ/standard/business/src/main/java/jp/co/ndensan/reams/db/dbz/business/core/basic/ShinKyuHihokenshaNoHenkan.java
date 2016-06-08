/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧被保険者番号変換テーブルを管理するクラスです。
 */
public class ShinKyuHihokenshaNoHenkan extends 
        ParentModelBase<ShinKyuHihokenshaNoHenkanIdentifier, 
        DbT7026ShinKyuHihokenshaNoHenkanEntity, ShinKyuHihokenshaNoHenkan> implements Serializable {

    private final DbT7026ShinKyuHihokenshaNoHenkanEntity entity;
    private final ShinKyuHihokenshaNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 新旧被保険者番号変換テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧番号 旧番号
     */
    public ShinKyuHihokenshaNoHenkan(LasdecCode 市町村コード,
            RString 旧番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));
        this.entity = new DbT7026ShinKyuHihokenshaNoHenkanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setKyuNo(旧番号);
        this.id = new ShinKyuHihokenshaNoHenkanIdentifier(
                市町村コード,
                旧番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7026ShinKyuHihokenshaNoHenkanEntity}より{@link ShinKyuHihokenshaNoHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT7026ShinKyuHihokenshaNoHenkanEntity}
     */
    public ShinKyuHihokenshaNoHenkan(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧被保険者番号変換テーブル"));
        this.id = new ShinKyuHihokenshaNoHenkanIdentifier(
                entity.getShichosonCode(),
                entity.getKyuNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}
     * @param id {@link ShinKyuHihokenshaNoHenkanIdentifier}
     */
    ShinKyuHihokenshaNoHenkan(
            DbT7026ShinKyuHihokenshaNoHenkanEntity entity,
            ShinKyuHihokenshaNoHenkanIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 新番号を返します。
     *
     * @return 新番号
     */
    public RString get新番号() {
        return entity.getShinNo();
    }

    /**
     * 旧番号を返します。
     *
     * @return 旧番号
     */
    public RString get旧番号() {
        return entity.getKyuNo();
    }

    /**
     * 旧市町村コード２を返します。
     *
     * @return 旧市町村コード２
     */
    public LasdecCode get旧市町村コード２() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 旧番号２を返します。
     *
     * @return 旧番号２
     */
    public RString get旧番号２() {
        return entity.getKyuNo2();
    }

    /**
     * {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}のクローン
     */
    @Override
    public DbT7026ShinKyuHihokenshaNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 新旧被保険者番号変換テーブルの識別子{@link ShinKyuHihokenshaNoHenkanIdentifier}を返します。
     *
     * @return 新旧被保険者番号変換テーブルの識別子{@link ShinKyuHihokenshaNoHenkanIdentifier}
     */
    @Override
    public ShinKyuHihokenshaNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 新旧被保険者番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinKyuHihokenshaNoHenkan}
     */
    @Override
    public ShinKyuHihokenshaNoHenkan modifiedModel() {
        DbT7026ShinKyuHihokenshaNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinKyuHihokenshaNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する新旧被保険者番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7026ShinKyuHihokenshaNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinKyuHihokenshaNoHenkan}
     */
    @Override
    public ShinKyuHihokenshaNoHenkan deleted() {
        DbT7026ShinKyuHihokenshaNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinKyuHihokenshaNoHenkan(deletedEntity, id);
    }

    /**
     * {@link ShinKyuHihokenshaNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link ShinKyuHihokenshaNoHenkan}のシリアライズ形式
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
        private final DbT7026ShinKyuHihokenshaNoHenkanEntity entity;
        private final ShinKyuHihokenshaNoHenkanIdentifier id;

        private _SerializationProxy(DbT7026ShinKyuHihokenshaNoHenkanEntity entity, ShinKyuHihokenshaNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinKyuHihokenshaNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinKyuHihokenshaNoHenkanBuilder createBuilderForEdit() {
        return new ShinKyuHihokenshaNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
