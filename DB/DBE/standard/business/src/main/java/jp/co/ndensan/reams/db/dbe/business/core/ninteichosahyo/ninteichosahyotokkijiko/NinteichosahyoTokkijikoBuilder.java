/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link NinteichosahyoTokkijiko}の編集を行うビルダークラスです。
 */
public class NinteichosahyoTokkijikoBuilder {

    private final DbT5205NinteichosahyoTokkijikoEntity entity;
    private final NinteichosahyoTokkijikoIdentifier id;

    /**
     * {@link DbT5205NinteichosahyoTokkijikoEntity}より{@link NinteichosahyoTokkijiko}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5205NinteichosahyoTokkijikoEntity}
     * @param id {@link NinteichosahyoTokkijikoIdentifier}
     *
     */
    NinteichosahyoTokkijikoBuilder(
            DbT5205NinteichosahyoTokkijikoEntity entity,
            NinteichosahyoTokkijikoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 認定調査特記事項番号を設定します。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return {@link NinteichosahyoTokkijikoBuilder}
     */
    public NinteichosahyoTokkijikoBuilder set認定調査特記事項番号(RString 認定調査特記事項番号) {
        requireNonNull(認定調査特記事項番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項番号"));
        entity.setNinteichosaTokkijikoNo(認定調査特記事項番号);
        return this;
    }

    /**
     * 認定調査特記事項連番を設定します。
     *
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @return {@link NinteichosahyoTokkijikoBuilder}
     */
    public NinteichosahyoTokkijikoBuilder set認定調査特記事項連番(RString 認定調査特記事項連番) {
        requireNonNull(認定調査特記事項連番, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査特記事項連番"));
        entity.setNinteichosaTokkijikoRenban(認定調査特記事項連番);
        return this;
    }

    /**
     * 特記事項テキスト・イメージ区分を設定します。
     *
     * @param 特記事項テキスト_イメージ区分 特記事項テキスト_イメージ区分
     * @return {@link NinteichosahyoTokkijikoBuilder}
     */
    public NinteichosahyoTokkijikoBuilder set特記事項テキスト_イメージ区分(RString 特記事項テキスト_イメージ区分) {
        requireNonNull(特記事項テキスト_イメージ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項テキスト・イメージ区分"));
        entity.setTokkijikoTextImageKubun(特記事項テキスト_イメージ区分);
        return this;
    }

    /**
     * 原本マスク区分を設定します。
     *
     * @param 原本マスク区分 原本マスク区分
     * @return {@link NinteichosahyoTokkijikoBuilder}
     */
    public NinteichosahyoTokkijikoBuilder set原本マスク区分(Code 原本マスク区分) {
        requireNonNull(原本マスク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("原本マスク区分"));
        entity.setGenponMaskKubun(原本マスク区分);
        return this;
    }

    /**
     * 特記事項を設定します。
     *
     * @param 特記事項 特記事項
     * @return {@link NinteichosahyoTokkijikoBuilder}
     */
    public NinteichosahyoTokkijikoBuilder set特記事項(RString 特記事項) {
        requireNonNull(特記事項, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項"));
        entity.setTokkiJiko(特記事項);
        return this;
    }

    /**
     * 特記事項イメージ共有ファイルIDを設定します。
     *
     * @param 特記事項イメージ共有ファイルID 特記事項イメージ共有ファイルID
     * @return {@link NinteichosahyoTokkijikoBuilder}
     */
    public NinteichosahyoTokkijikoBuilder set特記事項イメージ共有ファイルID(RDateTime 特記事項イメージ共有ファイルID) {
        requireNonNull(特記事項イメージ共有ファイルID, UrSystemErrorMessages.値がnull.getReplacedMessage("特記事項イメージ共有ファイルID"));
        entity.setTokkiJikoImageSharedFileId(特記事項イメージ共有ファイルID);
        return this;
    }

    /**
     * {@link NinteichosahyoTokkijiko}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoTokkijiko}のインスタンス
     */
    public NinteichosahyoTokkijiko build() {
        return new NinteichosahyoTokkijiko(entity, id);
    }
}
