/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧他特例施設番号変換テーブルを管理するクラスです。
 */
public class ShinKyuTaTokureiShisetsuNoHenkan extends ParentModelBase<ShinKyuTaTokureiShisetsuNoHenkanIdentifier, DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity, ShinKyuTaTokureiShisetsuNoHenkan> implements Serializable {

    private final DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity;
    private final ShinKyuTaTokureiShisetsuNoHenkanIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 新旧他特例施設番号変換テーブルの新規作成時に使用します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧他特例施設番号 旧他特例施設番号
     */
    public ShinKyuTaTokureiShisetsuNoHenkan(LasdecCode 市町村コード,
            RString 旧他特例施設番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号"));
        this.entity = new DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity();
        this.entity.setShichosonCode(市町村コード);
        this.entity.setKyuTaTokureiShisetsuNo(旧他特例施設番号);
        this.id = new ShinKyuTaTokureiShisetsuNoHenkanIdentifier(
                市町村コード,
                旧他特例施設番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}より{@link ShinKyuTaTokureiShisetsuNoHenkan}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}
     */
    public ShinKyuTaTokureiShisetsuNoHenkan(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧他特例施設番号変換テーブル"));
        this.id = new ShinKyuTaTokureiShisetsuNoHenkanIdentifier(
                entity.getShichosonCode(),
                entity.getKyuTaTokureiShisetsuNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}
     * @param id {@link ShinKyuTaTokureiShisetsuNoHenkanIdentifier}
     */
    ShinKyuTaTokureiShisetsuNoHenkan(
            DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity,
            ShinKyuTaTokureiShisetsuNoHenkanIdentifier id
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
     * 新他特例施設番号を返します。
     *
     * @return 新他特例施設番号
     */
    public RString get新他特例施設番号() {
        return entity.getShinTaTokureiShisetsuNo();
    }

    /**
     * 旧他特例施設番号を返します。
     *
     * @return 旧他特例施設番号
     */
    public RString get旧他特例施設番号() {
        return entity.getKyuTaTokureiShisetsuNo();
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
     * 旧他特例施設番号２を返します。
     *
     * @return 旧他特例施設番号２
     */
    public RString get旧他特例施設番号２() {
        return entity.getKyuTaTokureiShisetsuNo2();
    }

    /**
     * {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}のクローンを返します。
     *
     * @return {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}のクローン
     */
    @Override
    public DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 新旧他特例施設番号変換テーブルの識別子{@link ShinKyuTaTokureiShisetsuNoHenkanIdentifier}を返します。
     *
     * @return
     * 新旧他特例施設番号変換テーブルの識別子{@link ShinKyuTaTokureiShisetsuNoHenkanIdentifier}
     */
    @Override
    public ShinKyuTaTokureiShisetsuNoHenkanIdentifier identifier() {
        return this.id;
    }

    /**
     * 新旧他特例施設番号変換テーブルのみを変更対象とします。<br/>
     * {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinKyuTaTokureiShisetsuNoHenkan}
     */
    @Override
    public ShinKyuTaTokureiShisetsuNoHenkan modifiedModel() {
        DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinKyuTaTokureiShisetsuNoHenkan(
                modifiedEntity, id);
    }

    /**
     * 保持する新旧他特例施設番号変換テーブルを削除対象とします。<br/>
     * {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinKyuTaTokureiShisetsuNoHenkan}
     */
    @Override
    public ShinKyuTaTokureiShisetsuNoHenkan deleted() {
        DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinKyuTaTokureiShisetsuNoHenkan(deletedEntity, id);
    }

    /**
     * {@link ShinKyuTaTokureiShisetsuNoHenkan}のシリアライズ形式を提供します。
     *
     * @return {@link ShinKyuTaTokureiShisetsuNoHenkan}のシリアライズ形式
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
        private final DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity;
        private final ShinKyuTaTokureiShisetsuNoHenkanIdentifier id;

        private _SerializationProxy(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity, ShinKyuTaTokureiShisetsuNoHenkanIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinKyuTaTokureiShisetsuNoHenkan(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinKyuTaTokureiShisetsuNoHenkanBuilder createBuilderForEdit() {
        return new ShinKyuTaTokureiShisetsuNoHenkanBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
