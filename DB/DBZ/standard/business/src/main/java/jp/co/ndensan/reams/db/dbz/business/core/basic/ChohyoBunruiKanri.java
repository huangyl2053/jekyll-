/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 帳票分類管理を管理するクラスです。
 */
public class ChohyoBunruiKanri extends ParentModelBase<ChohyoBunruiKanriIdentifier, DbT7068ChohyoBunruiKanriEntity, ChohyoBunruiKanri> implements Serializable {

    private final DbT7068ChohyoBunruiKanriEntity entity;
    private final ChohyoBunruiKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 帳票分類管理の新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票ID 帳票ID
     */
    public ChohyoBunruiKanri(SubGyomuCode サブ業務コード,
            ReportId 帳票ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        this.entity = new DbT7068ChohyoBunruiKanriEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setReportID(帳票ID);
        this.id = new ChohyoBunruiKanriIdentifier(
                サブ業務コード,
                帳票ID
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7068ChohyoBunruiKanriEntity}より{@link ChohyoBunruiKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT7068ChohyoBunruiKanriEntity}
     */
    public ChohyoBunruiKanri(DbT7068ChohyoBunruiKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類管理"));
        this.id = new ChohyoBunruiKanriIdentifier(
                entity.getSubGyomuCode(),
                entity.getReportID());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7068ChohyoBunruiKanriEntity}
     * @param id {@link ChohyoBunruiKanriIdentifier}
     */
    ChohyoBunruiKanri(
            DbT7068ChohyoBunruiKanriEntity entity,
            ChohyoBunruiKanriIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * サブ業務コードを返します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID
     */
    public ReportId get帳票ID() {
        return entity.getReportID();
    }

    /**
     * 帳票分類IDを返します。
     *
     * @return 帳票分類ID
     */
    public ReportId get帳票分類ID() {
        return entity.getChohyoBunruiID();
    }

    /**
     * {@link DbT7068ChohyoBunruiKanriEntity}のクローンを返します。
     *
     * @return {@link DbT7068ChohyoBunruiKanriEntity}のクローン
     */
    @Override
    public DbT7068ChohyoBunruiKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 帳票分類管理の識別子{@link ChohyoBunruiKanriIdentifier}を返します。
     *
     * @return 帳票分類管理の識別子{@link ChohyoBunruiKanriIdentifier}
     */
    @Override
    public ChohyoBunruiKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 帳票分類管理のみを変更対象とします。<br/>
     * {@link DbT7068ChohyoBunruiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ChohyoBunruiKanri}
     */
    @Override
    public ChohyoBunruiKanri modifiedModel() {
        DbT7068ChohyoBunruiKanriEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ChohyoBunruiKanri(
                modifiedEntity, id);
    }

    /**
     * 保持する帳票分類管理を削除対象とします。<br/>
     * {@link DbT7068ChohyoBunruiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChohyoBunruiKanri}
     */
    @Override
    public ChohyoBunruiKanri deleted() {
        DbT7068ChohyoBunruiKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChohyoBunruiKanri(deletedEntity, id);
    }

    /**
     * {@link ChohyoBunruiKanri}のシリアライズ形式を提供します。
     *
     * @return {@link ChohyoBunruiKanri}のシリアライズ形式
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
        private final DbT7068ChohyoBunruiKanriEntity entity;
        private final ChohyoBunruiKanriIdentifier id;

        private _SerializationProxy(DbT7068ChohyoBunruiKanriEntity entity, ChohyoBunruiKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChohyoBunruiKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChohyoBunruiKanriBuilder createBuilderForEdit() {
        return new ChohyoBunruiKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
