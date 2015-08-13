/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧医療機関主治医番号変換テーブルを管理するクラスです。
 */
public class ShinKyuIryoKikanShujiiNoHenkan extends ParentModelBase<ShinKyuIryoKikanShujiiNoHenkanIdentifier, DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity, ShinKyuIryoKikanShujiiNoHenkan> implements Serializable {

    private final DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity;
    private final ShinKyuIryoKikanShujiiNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 新旧医療機関主治医番号変換テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧医療機関番号 旧医療機関番号
     * @param 旧主治医番号 旧主治医番号
     */
    public ShinKyuIryoKikanShujiiNoHenkan(LasdecCode 市町村コード,
            RString 旧医療機関番号,
            RString 旧主治医番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号"));
        requireNonNull(旧主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号"));
        this.entity = new DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setKyuIryoKikanNo(旧医療機関番号);
        this.entity.setKyuShujiiNo(旧主治医番号);
        this.id = new ShinKyuIryoKikanShujiiNoHenkanIdentifier(
                市町村コード,
                旧医療機関番号,
                旧主治医番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}より{@link ShinKyuIryoKikanShujiiNoHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}
     */
    public ShinKyuIryoKikanShujiiNoHenkan(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧医療機関主治医番号変換テーブル"));
        this.id = new ShinKyuIryoKikanShujiiNoHenkanIdentifier(
                entity.getShichosonCode(),
                entity.getKyuIryoKikanNo(),
                entity.getKyuShujiiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}
     * @param id {@link ShinKyuIryoKikanShujiiNoHenkanIdentifier}
     */
    ShinKyuIryoKikanShujiiNoHenkan(
            DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity,
            ShinKyuIryoKikanShujiiNoHenkanIdentifier id
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
     * 新医療機関番号を返します。
     *
     * @return 新医療機関番号
     */
    public RString get新医療機関番号() {
        return entity.getShinIryoKikanNo();
    }

    /**
     * 新主治医番号を返します。
     *
     * @return 新主治医番号
     */
    public RString get新主治医番号() {
        return entity.getShinShujiiNo();
    }

    /**
     * 旧医療機関番号を返します。
     *
     * @return 旧医療機関番号
     */
    public RString get旧医療機関番号() {
        return entity.getKyuIryoKikanNo();
    }

    /**
     * 旧主治医番号を返します。
     *
     * @return 旧主治医番号
     */
    public RString get旧主治医番号() {
        return entity.getKyuShujiiNo();
    }

    /**
     * 市町村コード２を返します。
     *
     * @return 市町村コード２
     */
    public LasdecCode get市町村コード２() {
        return entity.getShichosonCode2();
    }

    /**
     * 旧医療機関番号２を返します。
     *
     * @return 旧医療機関番号２
     */
    public RString get旧医療機関番号２() {
        return entity.getKyuIryoKikanNo2();
    }

    /**
     * 旧主治医番号２を返します。
     *
     * @return 旧主治医番号２
     */
    public RString get旧主治医番号２() {
        return entity.getKyuShujiiNo2();
    }

    /**
     * {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}のクローン
     */
    @Override
    public DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 新旧医療機関主治医番号変換テーブルの識別子{@link ShinKyuIryoKikanShujiiNoHenkanIdentifier}を返します。
     *
     * @return 新旧医療機関主治医番号変換テーブルの識別子{@link ShinKyuIryoKikanShujiiNoHenkanIdentifier}
     */
    @Override
    public ShinKyuIryoKikanShujiiNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 新旧医療機関主治医番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinKyuIryoKikanShujiiNoHenkan}
     */
    @Override
    public ShinKyuIryoKikanShujiiNoHenkan modifiedModel() {
        DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinKyuIryoKikanShujiiNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する新旧医療機関主治医番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinKyuIryoKikanShujiiNoHenkan}
     */
    @Override
    public ShinKyuIryoKikanShujiiNoHenkan deleted() {
        DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinKyuIryoKikanShujiiNoHenkan(deletedEntity, id);
    }

    /**
     * {@link ShinKyuIryoKikanShujiiNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link ShinKyuIryoKikanShujiiNoHenkan}のシリアライズ形式
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
        private final DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity;
        private final ShinKyuIryoKikanShujiiNoHenkanIdentifier id;

        private _SerializationProxy(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity, ShinKyuIryoKikanShujiiNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinKyuIryoKikanShujiiNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinKyuIryoKikanShujiiNoHenkanBuilder createBuilderForEdit() {
        return new ShinKyuIryoKikanShujiiNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
