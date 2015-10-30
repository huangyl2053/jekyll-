/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域番号発番テーブルを管理するクラスです。
 */
public class KoikiNoHatsuban extends 
        ParentModelBase<KoikiNoHatsubanIdentifier, 
        DbT7025KoikiNoHatsubanEntity, KoikiNoHatsuban> implements Serializable {

    private final DbT7025KoikiNoHatsubanEntity entity;
    private final KoikiNoHatsubanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 広域番号発番テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param コード区分 コード区分
     */
    public KoikiNoHatsuban(LasdecCode 市町村コード,
            RString コード区分) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        this.entity = new DbT7025KoikiNoHatsubanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setCodeKubun(コード区分);
        this.id = new KoikiNoHatsubanIdentifier(
                市町村コード,
                コード区分
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7025KoikiNoHatsubanEntity}より{@link KoikiNoHatsuban}を生成します。
     *
     * @param entity DBより取得した{@link DbT7025KoikiNoHatsubanEntity}
     */
    public KoikiNoHatsuban(DbT7025KoikiNoHatsubanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("広域番号発番テーブル"));
        this.id = new KoikiNoHatsubanIdentifier(
                entity.getShichosonCode(),
                entity.getCodeKubun());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7025KoikiNoHatsubanEntity}
     * @param id {@link KoikiNoHatsubanIdentifier}
     */
    KoikiNoHatsuban(
            DbT7025KoikiNoHatsubanEntity entity,
            KoikiNoHatsubanIdentifier id
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
     * 番号を返します。
     *
     * @return 番号
     */
    public RString get番号() {
        return entity.getNo();
    }

    /**
     * {@link DbT7025KoikiNoHatsubanEntity}のクローンを返します。
     *
     * @return {@link DbT7025KoikiNoHatsubanEntity}のクローン
     */
    @Override
    public DbT7025KoikiNoHatsubanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 広域番号発番テーブルの識別子{@link KoikiNoHatsubanIdentifier}を返します。
     *
     * @return 広域番号発番テーブルの識別子{@link KoikiNoHatsubanIdentifier}
     */
    @Override
    public KoikiNoHatsubanIdentifier identifier() {
        return this.id;
    }

    /**
     * 広域番号発番テーブルのみを変更対象とします。<br/>
     * {@link DbT7025KoikiNoHatsubanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KoikiNoHatsuban}
     */
    @Override
    public KoikiNoHatsuban modifiedModel() {
        DbT7025KoikiNoHatsubanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KoikiNoHatsuban(
                modifiedEntity, id);
    }

    /**
     * 保持する広域番号発番テーブルを削除対象とします。<br/>
     * {@link DbT7025KoikiNoHatsubanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KoikiNoHatsuban}
     */
    @Override
    public KoikiNoHatsuban deleted() {
        DbT7025KoikiNoHatsubanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KoikiNoHatsuban(deletedEntity, id);
    }

    /**
     * {@link KoikiNoHatsuban}のシリアライズ形式を提供します。
     *
     * @return {@link KoikiNoHatsuban}のシリアライズ形式
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
        private final DbT7025KoikiNoHatsubanEntity entity;
        private final KoikiNoHatsubanIdentifier id;

        private _SerializationProxy(DbT7025KoikiNoHatsubanEntity entity, KoikiNoHatsubanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KoikiNoHatsuban(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KoikiNoHatsubanBuilder createBuilderForEdit() {
        return new KoikiNoHatsubanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
