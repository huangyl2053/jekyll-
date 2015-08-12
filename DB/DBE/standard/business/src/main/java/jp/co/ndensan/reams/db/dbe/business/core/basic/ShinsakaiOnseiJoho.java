/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会音声情報を管理するクラスです。
 */
public class ShinsakaiOnseiJoho extends ParentModelBase<ShinsakaiOnseiJohoIdentifier, DbT5512ShinsakaiOnseiJohoEntity, ShinsakaiOnseiJoho> implements Serializable {

    private final DbT5512ShinsakaiOnseiJohoEntity entity;
    private final ShinsakaiOnseiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会音声情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     */
    public ShinsakaiOnseiJoho(int 介護認定審査会開催番号,
            int 連番) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5512ShinsakaiOnseiJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.entity.setRenban(連番);
        this.id = new ShinsakaiOnseiJohoIdentifier(
                介護認定審査会開催番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5512ShinsakaiOnseiJohoEntity}より{@link ShinsakaiOnseiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5512ShinsakaiOnseiJohoEntity}
     */
    public ShinsakaiOnseiJoho(DbT5512ShinsakaiOnseiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会音声情報"));
        this.id = new ShinsakaiOnseiJohoIdentifier(
                entity.getShinsakaiKaisaiNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5512ShinsakaiOnseiJohoEntity}
     * @param id {@link ShinsakaiOnseiJohoIdentifier}
     */
    ShinsakaiOnseiJoho(
            DbT5512ShinsakaiOnseiJohoEntity entity,
            ShinsakaiOnseiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public int get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 審査会音声ファイルを返します。
     *
     * @return 審査会音声ファイル
     */
    public byte[] get審査会音声ファイル() {
        return entity.getShinsakaiOnseiFile();
    }

    /**
     * {@link DbT5512ShinsakaiOnseiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5512ShinsakaiOnseiJohoEntity}のクローン
     */
    @Override
    public DbT5512ShinsakaiOnseiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会音声情報の識別子{@link ShinsakaiOnseiJohoIdentifier}を返します。
     *
     * @return 介護認定審査会音声情報の識別子{@link ShinsakaiOnseiJohoIdentifier}
     */
    @Override
    public ShinsakaiOnseiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会音声情報のみを変更対象とします。<br/>
     * {@link DbT5512ShinsakaiOnseiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiOnseiJoho}
     */
    @Override
    public ShinsakaiOnseiJoho modifiedModel() {
        DbT5512ShinsakaiOnseiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiOnseiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会音声情報を削除対象とします。<br/>
     * {@link DbT5512ShinsakaiOnseiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiOnseiJoho}
     */
    @Override
    public ShinsakaiOnseiJoho deleted() {
        DbT5512ShinsakaiOnseiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiOnseiJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiOnseiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiOnseiJoho}のシリアライズ形式
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
        private final DbT5512ShinsakaiOnseiJohoEntity entity;
        private final ShinsakaiOnseiJohoIdentifier id;

        private _SerializationProxy(DbT5512ShinsakaiOnseiJohoEntity entity, ShinsakaiOnseiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiOnseiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiOnseiJohoBuilder createBuilderForEdit() {
        return new ShinsakaiOnseiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
