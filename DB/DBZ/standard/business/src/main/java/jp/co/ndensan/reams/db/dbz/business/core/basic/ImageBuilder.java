/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 申請書管理番号を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return {@link ImageBuilder}
     */
    public ImageBuilder set申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        entity.setShinseishoKanriNo(申請書管理番号);
        return this;
    }

    /**
     * 取込ページ番号を設定します。
     *
     * @param 取込ページ番号 取込ページ番号
     * @return {@link ImageBuilder}
     */
    public ImageBuilder set取込ページ番号(int 取込ページ番号) {
        requireNonNull(取込ページ番号, UrSystemErrorMessages.値がnull.getReplacedMessage("取込ページ番号"));
        entity.setTorikomiPageNo(取込ページ番号);
        return this;
    }

    /**
     * 原本マスク分を設定します。
     *
     * @param 原本マスク分 原本マスク分
     * @return {@link ImageBuilder}
     */
    public ImageBuilder set原本マスク分(Code 原本マスク分) {
        requireNonNull(原本マスク分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク分"));
        entity.setGenponMaskKubun(原本マスク分);
        return this;
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
