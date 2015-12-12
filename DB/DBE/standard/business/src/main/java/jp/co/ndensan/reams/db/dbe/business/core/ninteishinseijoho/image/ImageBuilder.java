/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.image;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * {@link Image}の編集を行うビルダークラスです。
 */
public class ImageBuilder {

    private final DbT5115ImageEntity entity;
    private final ImageIdentifier id;

    /**
     * {@link DbT5115ImageEntity}より{@link Image}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5115ImageEntity}
     * @param id {@link ImageIdentifier}
     *
     */
    ImageBuilder(
            DbT5115ImageEntity entity,
            ImageIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * イメージ共有ファイルIDを設定します。
     *
     * @param イメージ共有ファイルID イメージ共有ファイルID
     * @return {@link ImageBuilder}
     */
    public ImageBuilder setイメージ共有ファイルID(RDateTime イメージ共有ファイルID) {
        requireNonNull(イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("イメージ共有ファイルID"));
        entity.setImageSharedFileId(イメージ共有ファイルID);
        return this;
    }

    /**
     * {@link Image}のインスタンスを生成します。
     *
     * @return {@link Image}のインスタンス
     */
    public Image build() {
        return new Image(entity, id);
    }
}
