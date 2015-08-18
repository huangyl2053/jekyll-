/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧適用除外施設番号変換テーブルを管理するクラスです。
 */
public class ShinKyuTekiyoJogaiShisetsuNoHenkan extends ParentModelBase<ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier, DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity, ShinKyuTekiyoJogaiShisetsuNoHenkan> implements Serializable {

    private final DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity;
    private final ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 新旧適用除外施設番号変換テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧適用除外施設番号 旧適用除外施設番号
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkan(LasdecCode 市町村コード,
            RString 旧適用除外施設番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号"));
        this.entity = new DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);
        this.id = new ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier(
                市町村コード,
                旧適用除外施設番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}より{@link ShinKyuTekiyoJogaiShisetsuNoHenkan}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkan(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧適用除外施設番号変換テーブル"));
        this.id = new ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier(
                entity.getShichosonCode(),
                entity.getKyuTekiyoJogaiShisetsuNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}
     * @param id {@link ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier}
     */
    ShinKyuTekiyoJogaiShisetsuNoHenkan(
            DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity,
            ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier id
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
     * 新適用除外施設番号を返します。
     *
     * @return 新適用除外施設番号
     */
    public RString get新適用除外施設番号() {
        return entity.getShinTekiyoJogaiShisetsuNo();
    }

    /**
     * 旧適用除外施設番号を返します。
     *
     * @return 旧適用除外施設番号
     */
    public RString get旧適用除外施設番号() {
        return entity.getKyuTekiyoJogaiShisetsuNo();
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
     * 旧適用除外施設番号２を返します。
     *
     * @return 旧適用除外施設番号２
     */
    public RString get旧適用除外施設番号２() {
        return entity.getKyuTekiyoJogaiShisetsuNo2();
    }

    /**
     * {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}のクローン
     */
    @Override
    public DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 新旧適用除外施設番号変換テーブルの識別子{@link ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier}を返します。
     *
     * @return
     * 新旧適用除外施設番号変換テーブルの識別子{@link ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier}
     */
    @Override
    public ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 新旧適用除外施設番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinKyuTekiyoJogaiShisetsuNoHenkan}
     */
    @Override
    public ShinKyuTekiyoJogaiShisetsuNoHenkan modifiedModel() {
        DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinKyuTekiyoJogaiShisetsuNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する新旧適用除外施設番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinKyuTekiyoJogaiShisetsuNoHenkan}
     */
    @Override
    public ShinKyuTekiyoJogaiShisetsuNoHenkan deleted() {
        DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinKyuTekiyoJogaiShisetsuNoHenkan(deletedEntity, id);
    }

    /**
     * {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}のシリアライズ形式
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
        private final DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity;
        private final ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier id;

        private _SerializationProxy(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity, ShinKyuTekiyoJogaiShisetsuNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinKyuTekiyoJogaiShisetsuNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder createBuilderForEdit() {
        return new ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
