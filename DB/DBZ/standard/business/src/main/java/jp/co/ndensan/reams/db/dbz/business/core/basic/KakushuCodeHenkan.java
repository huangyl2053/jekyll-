/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 各種コード変換テーブルを管理するクラスです。
 */
public class KakushuCodeHenkan extends ParentModelBase<KakushuCodeHenkanIdentifier, DbT7027KakushuCodeHenkanEntity, KakushuCodeHenkan> implements Serializable {

    private final DbT7027KakushuCodeHenkanEntity entity;
    private final KakushuCodeHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 各種コード変換テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param コード区分 コード区分
     * @param 外部コード 外部コード
     */
    public KakushuCodeHenkan(LasdecCode 市町村コード,
            RString コード区分,
            RString 外部コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        requireNonNull(外部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード"));
        this.entity = new DbT7027KakushuCodeHenkanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setCodeKubun(コード区分);
        this.entity.setGaibuCode(外部コード);
        this.id = new KakushuCodeHenkanIdentifier(
                市町村コード,
                コード区分,
                外部コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7027KakushuCodeHenkanEntity}より{@link KakushuCodeHenkan}を生成します。
     *
     * @param entity DBより取得した{@link DbT7027KakushuCodeHenkanEntity}
     */
    public KakushuCodeHenkan(DbT7027KakushuCodeHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("各種コード変換テーブル"));
        this.id = new KakushuCodeHenkanIdentifier(
                entity.getShichosonCode(),
                entity.getCodeKubun(),
                entity.getGaibuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7027KakushuCodeHenkanEntity}
     * @param id {@link KakushuCodeHenkanIdentifier}
     */
    KakushuCodeHenkan(
            DbT7027KakushuCodeHenkanEntity entity,
            KakushuCodeHenkanIdentifier id
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
     * コード区分を返します。
     *
     * @return コード区分
     */
    public RString getコード区分() {
        return entity.getCodeKubun();
    }

    /**
     * 内部コードを返します。
     *
     * @return 内部コード
     */
    public RString get内部コード() {
        return entity.getNaibuCode();
    }

    /**
     * 内部番号を返します。
     *
     * @return 内部番号
     */
    public RString get内部番号() {
        return entity.getNaibuNo();
    }

    /**
     * 外部コードを返します。
     *
     * @return 外部コード
     */
    public RString get外部コード() {
        return entity.getGaibuCode();
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
     * 外部コード２を返します。
     *
     * @return 外部コード２
     */
    public RString get外部コード２() {
        return entity.getGaibuCode2();
    }

    /**
     * {@link DbT7027KakushuCodeHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7027KakushuCodeHenkanEntity}のクローン
     */
    @Override
    public DbT7027KakushuCodeHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 各種コード変換テーブルの識別子{@link KakushuCodeHenkanIdentifier}を返します。
     *
     * @return 各種コード変換テーブルの識別子{@link KakushuCodeHenkanIdentifier}
     */
    @Override
    public KakushuCodeHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 各種コード変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7027KakushuCodeHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KakushuCodeHenkan}
     */
    @Override
    public KakushuCodeHenkan modifiedModel() {
        DbT7027KakushuCodeHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KakushuCodeHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する各種コード変換テーブルを削除対象とします。<br/>
     * {@link DbT7027KakushuCodeHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KakushuCodeHenkan}
     */
    @Override
    public KakushuCodeHenkan deleted() {
        DbT7027KakushuCodeHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KakushuCodeHenkan(deletedEntity, id);
    }

    /**
     * {@link KakushuCodeHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link KakushuCodeHenkan}のシリアライズ形式
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
        private final DbT7027KakushuCodeHenkanEntity entity;
        private final KakushuCodeHenkanIdentifier id;

        private _SerializationProxy(DbT7027KakushuCodeHenkanEntity entity, KakushuCodeHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KakushuCodeHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KakushuCodeHenkanBuilder createBuilderForEdit() {
        return new KakushuCodeHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
