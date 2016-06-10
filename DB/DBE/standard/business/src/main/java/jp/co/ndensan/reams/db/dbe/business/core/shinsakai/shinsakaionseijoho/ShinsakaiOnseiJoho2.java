/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会音声情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiOnseiJoho2
        extends ModelBase<ShinsakaiOnseiJoho2Identifier, DbT5512ShinsakaiOnseiJohoEntity, ShinsakaiOnseiJoho2>
        implements Serializable {

    private final DbT5512ShinsakaiOnseiJohoEntity entity;
    private final ShinsakaiOnseiJoho2Identifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会音声情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     */
    public ShinsakaiOnseiJoho2(RString 介護認定審査会開催番号,
            int 連番) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5512ShinsakaiOnseiJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.entity.setRenban(連番);
        this.id = new ShinsakaiOnseiJoho2Identifier(
                介護認定審査会開催番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5512ShinsakaiOnseiJohoEntity}より{@link ShinsakaiOnseiJoho2}を生成します。
     *
     * @param entity DBより取得した{@link DbT5512ShinsakaiOnseiJohoEntity}
     */
    public ShinsakaiOnseiJoho2(DbT5512ShinsakaiOnseiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会音声情報"));
        this.id = new ShinsakaiOnseiJoho2Identifier(
                entity.getShinsakaiKaisaiNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5512ShinsakaiOnseiJohoEntity}
     * @param id {@link ShinsakaiOnseiJoho2Identifier}
     */
    ShinsakaiOnseiJoho2(
            DbT5512ShinsakaiOnseiJohoEntity entity,
            ShinsakaiOnseiJoho2Identifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
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
    @SuppressWarnings("checkstyle:illegaltoken")
    public byte[] get審査会音声ファイル() {
        return (entity.getShinsakaiOnseiFile());
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
     * 介護認定審査会音声情報の識別子{@link ShinsakaiOnseiJoho2Identifier}を返します。
     *
     * @return 介護認定審査会音声情報の識別子{@link ShinsakaiOnseiJoho2Identifier}
     */
    @Override
    public ShinsakaiOnseiJoho2Identifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会音声情報のみを変更対象とします。<br/>
     * {@link DbT5512ShinsakaiOnseiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiOnseiJoho2}
     */
    public ShinsakaiOnseiJoho2 modifiedModel() {
        DbT5512ShinsakaiOnseiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiOnseiJoho2(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会音声情報を削除対象とします。<br/>
     * {@link DbT5512ShinsakaiOnseiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiOnseiJoho2}
     */
    @Override
    public ShinsakaiOnseiJoho2 deleted() {
        DbT5512ShinsakaiOnseiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiOnseiJoho2(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiOnseiJoho2}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiOnseiJoho2}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {
        private static final long serialVersionUID = -5086517189704801195L;

        private final DbT5512ShinsakaiOnseiJohoEntity entity;
        private final ShinsakaiOnseiJoho2Identifier id;

        private _SerializationProxy(DbT5512ShinsakaiOnseiJohoEntity entity, ShinsakaiOnseiJoho2Identifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiOnseiJoho2(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiOnseiJoho2Builder createBuilderForEdit() {
        return new ShinsakaiOnseiJoho2Builder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShinsakaiOnseiJoho2 other = (ShinsakaiOnseiJoho2) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
