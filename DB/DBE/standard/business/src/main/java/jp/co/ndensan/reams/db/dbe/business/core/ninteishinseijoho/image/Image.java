/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * イメージ情報を管理するクラスです。
 */
public class Image extends ModelBase<ImageIdentifier, DbT5115ImageEntity, Image> implements Serializable {

    private final DbT5115ImageEntity entity;
    private final ImageIdentifier id;

    /**
     * コンストラクタです。<br/>
     * イメージ情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param イメージ共有ファイルID イメージ共有ファイルID
     */
    public Image(ShinseishoKanriNo 申請書管理番号,
            RDateTime イメージ共有ファイルID) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ共有ファイルID"));
        this.entity = new DbT5115ImageEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setImageSharedFileId(イメージ共有ファイルID);
        this.id = new ImageIdentifier(
                申請書管理番号,
                イメージ共有ファイルID
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5115ImageEntity}より{@link Image}を生成します。
     *
     * @param entity DBより取得した{@link DbT5115ImageEntity}
     */
    public Image(DbT5115ImageEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ情報"));
        this.id = new ImageIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getImageSharedFileId());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5115ImageEntity}
     * @param id {@link ImageIdentifier}
     */
    Image(
            DbT5115ImageEntity entity,
            ImageIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * イメージ共有ファイルIDを返します。
     *
     * @return イメージ共有ファイルID
     */
    public RDateTime getイメージ共有ファイルID() {
        return entity.getImageSharedFileId();
    }

    /**
     * {@link DbT5115ImageEntity}のクローンを返します。
     *
     * @return {@link DbT5115ImageEntity}のクローン
     */
    @Override
    public DbT5115ImageEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * イメージ情報の識別子{@link ImageIdentifier}を返します。
     *
     * @return イメージ情報の識別子{@link ImageIdentifier}
     */
    @Override
    public ImageIdentifier identifier() {
        return this.id;
    }

    /**
     * イメージ情報のみを変更対象とします。<br/> {@link DbT5115ImageEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Image}
     */
    public Image modifiedModel() {
        DbT5115ImageEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Image(
                modifiedEntity, id);
    }

    /**
     * 保持するイメージ情報を削除対象とします。<br/> {@link DbT5115ImageEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link Image}
     */
    @Override
    public Image deleted() {
        DbT5115ImageEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new Image(deletedEntity, id);
    }

    /**
     * {@link Image}のシリアライズ形式を提供します。
     *
     * @return {@link Image}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5115ImageEntity entity;
        private final ImageIdentifier id;

        private _SerializationProxy(DbT5115ImageEntity entity, ImageIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new Image(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ImageBuilder createBuilderForEdit() {
        return new ImageBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Image other = (Image) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
