/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * イメージ情報を管理するクラスです。
 */
public class Image extends ParentModelBase<ImageIdentifier, DbT5115ImageEntity, Image> implements Serializable {

    private final DbT5115ImageEntity entity;
    private final ImageIdentifier id;

    /**
     * コンストラクタです。<br/>
     * イメージ情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 取込ページ番号 取込ページ番号
     * @param 原本マスク分 原本マスク分
     */
    public Image(ShinseishoKanriNo 申請書管理番号,
            int 取込ページ番号,
            Code 原本マスク分) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(取込ページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込ページ番号"));
        requireNonNull(原本マスク分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク分"));
        this.entity = new DbT5115ImageEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setTorikomiPageNo(取込ページ番号);
        this.entity.setGenponMaskKubun(原本マスク分);
        this.id = new ImageIdentifier(
                申請書管理番号,
                取込ページ番号,
                原本マスク分
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
                entity.getTorikomiPageNo(),
                entity.getGenponMaskKubun());
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

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 取込ページ番号を返します。
     *
     * @return 取込ページ番号
     */
    public int get取込ページ番号() {
        return entity.getTorikomiPageNo();
    }

    /**
     * 原本マスク分を返します。
     *
     * @return 原本マスク分
     */
    public Code get原本マスク分() {
        return entity.getGenponMaskKubun();
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
     * イメージ情報のみを変更対象とします。<br/>
     * {@link DbT5115ImageEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link Image}
     */
    @Override
    public Image modifiedModel() {
        DbT5115ImageEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new Image(
                modifiedEntity, id);
    }

    /**
     * 保持するイメージ情報を削除対象とします。<br/>
     * {@link DbT5115ImageEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
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

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
