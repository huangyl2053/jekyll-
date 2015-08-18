/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 帳票制御汎用を管理するクラスです。
 */
public class ChohyoSeigyoHanyo extends ModelBase<ChohyoSeigyoHanyoIdentifier, DbT7067ChohyoSeigyoHanyoEntity, ChohyoSeigyoHanyo> implements Serializable {

    private final DbT7067ChohyoSeigyoHanyoEntity entity;
    private final ChohyoSeigyoHanyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 帳票制御汎用の新規作成時に使用します。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 項目名 項目名
     */
    public ChohyoSeigyoHanyo(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID,
            RString 項目名) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        requireNonNull(項目名, UrSystemErrorMessages.値がnull.getReplacedMessage("項目名"));
        this.entity = new DbT7067ChohyoSeigyoHanyoEntity();
        this.entity.setSubGyomuCode(サブ業務コード);
        this.entity.setChohyoBunruiID(帳票分類ID);
        this.entity.setKomokuName(項目名);
        this.id = new ChohyoSeigyoHanyoIdentifier(
                サブ業務コード,
                帳票分類ID,
                項目名
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7067ChohyoSeigyoHanyoEntity}より{@link ChohyoSeigyoHanyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT7067ChohyoSeigyoHanyoEntity}
     */
    public ChohyoSeigyoHanyo(DbT7067ChohyoSeigyoHanyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御汎用"));
        this.id = new ChohyoSeigyoHanyoIdentifier(
                entity.getSubGyomuCode(),
                entity.getChohyoBunruiID(),
                entity.getKomokuName());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7067ChohyoSeigyoHanyoEntity}
     * @param id {@link ChohyoSeigyoHanyoIdentifier}
     */
    ChohyoSeigyoHanyo(
            DbT7067ChohyoSeigyoHanyoEntity entity,
            ChohyoSeigyoHanyoIdentifier id
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
     * 帳票分類IDを返します。
     *
     * @return 帳票分類ID
     */
    public ReportId get帳票分類ID() {
        return entity.getChohyoBunruiID();
    }

    /**
     * 項目名を返します。
     *
     * @return 項目名
     */
    public RString get項目名() {
        return entity.getKomokuName();
    }

    /**
     * 設定値を返します。
     *
     * @return 設定値
     */
    public RString get設定値() {
        return entity.getKomokuValue();
    }

    /**
     * 説明を返します。
     *
     * @return 説明
     */
    public RString get説明() {
        return entity.getKomokuSetsumei();
    }

    /**
     * 変更可否を返します。
     *
     * @return 変更可否
     */
    public boolean get変更可否() {
        return entity.getHenkoKahi();
    }

    /**
     * コードマスタサブ業務コードを返します。
     *
     * @return コードマスタサブ業務コード
     */
    public SubGyomuCode getコードマスタサブ業務コード() {
        return entity.getCodeMasterSubGyomuCode();
    }

    /**
     * コードマスタコード種別を返します。
     *
     * @return コードマスタコード種別
     */
    public CodeShubetsu getコードマスタコード種別() {
        return entity.getCodeMasterCodeShubetsu();
    }

    /**
     * {@link DbT7067ChohyoSeigyoHanyoEntity}のクローンを返します。
     *
     * @return {@link DbT7067ChohyoSeigyoHanyoEntity}のクローン
     */
    @Override
    public DbT7067ChohyoSeigyoHanyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 帳票制御汎用の識別子{@link ChohyoSeigyoHanyoIdentifier}を返します。
     *
     * @return 帳票制御汎用の識別子{@link ChohyoSeigyoHanyoIdentifier}
     */
    @Override
    public ChohyoSeigyoHanyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する帳票制御汎用を削除対象とします。<br/>
     * {@link DbT7067ChohyoSeigyoHanyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChohyoSeigyoHanyo}
     */
    @Override
    public ChohyoSeigyoHanyo deleted() {
        DbT7067ChohyoSeigyoHanyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ChohyoSeigyoHanyo(deletedEntity, id);
    }

    /**
     * {@link ChohyoSeigyoHanyo}のシリアライズ形式を提供します。
     *
     * @return {@link ChohyoSeigyoHanyo}のシリアライズ形式
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

        private final DbT7067ChohyoSeigyoHanyoEntity entity;
        private final ChohyoSeigyoHanyoIdentifier id;

        private _SerializationProxy(DbT7067ChohyoSeigyoHanyoEntity entity, ChohyoSeigyoHanyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ChohyoSeigyoHanyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ChohyoSeigyoHanyoBuilder createBuilderForEdit() {
        return new ChohyoSeigyoHanyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
