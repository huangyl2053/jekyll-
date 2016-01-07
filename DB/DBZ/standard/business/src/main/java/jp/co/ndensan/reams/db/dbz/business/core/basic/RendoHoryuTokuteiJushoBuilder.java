/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RendoHoryuTokuteiJusho}の編集を行うビルダークラスです。
 */
public class RendoHoryuTokuteiJushoBuilder {

    private final DbT7023RendoHoryuTokuteiJushoEntity entity;
    private final RendoHoryuTokuteiJushoIdentifier id;

    /**
     * {@link DbT7023RendoHoryuTokuteiJushoEntity}より{@link RendoHoryuTokuteiJusho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7023RendoHoryuTokuteiJushoEntity}
     * @param id {@link RendoHoryuTokuteiJushoIdentifier}
     *
     */
    RendoHoryuTokuteiJushoBuilder(
            DbT7023RendoHoryuTokuteiJushoEntity entity,
            RendoHoryuTokuteiJushoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 住所コードを設定します。
     *
     * @param 住所コード 住所コード
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set住所コード(ChoikiCode 住所コード) {
        requireNonNull(住所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("住所コード"));
        entity.setJushoCode(住所コード);
        return this;
    }

    /**
     * 住所を設定します。
     *
     * @param 住所 住所
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set住所(AtenaJusho 住所) {
        requireNonNull(住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住所"));
        entity.setJusho(住所);
        return this;
    }

    /**
     * 番地コード１を設定します。
     *
     * @param 番地コード１ 番地コード１
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set番地コード１(BanchiCode 番地コード１) {
        requireNonNull(番地コード１, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード１"));
        entity.setBanchiCode1(番地コード１);
        return this;
    }

    /**
     * 番地コード２を設定します。
     *
     * @param 番地コード２ 番地コード２
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set番地コード２(BanchiCode 番地コード２) {
        requireNonNull(番地コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード２"));
        entity.setBanchiCode2(番地コード２);
        return this;
    }

    /**
     * 番地コード３を設定します。
     *
     * @param 番地コード３ 番地コード３
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set番地コード３(BanchiCode 番地コード３) {
        requireNonNull(番地コード３, UrSystemErrorMessages.値がnull.getReplacedMessage("番地コード３"));
        entity.setBanchiCode3(番地コード３);
        return this;
    }

    /**
     * 番地を設定します。
     *
     * @param 番地 番地
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set番地(AtenaBanchi 番地) {
        requireNonNull(番地, UrSystemErrorMessages.値がnull.getReplacedMessage("番地"));
        entity.setBanchi(番地);
        return this;
    }

    /**
     * 施設種類を設定します。
     *
     * @param 施設種類 施設種類
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set施設種類(RString 施設種類) {
        requireNonNull(施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("施設種類"));
        entity.setShisetsuShurui(施設種類);
        return this;
    }

    /**
     * 施設コードを設定します。
     *
     * @param 施設コード 施設コード
     * @return {@link RendoHoryuTokuteiJushoBuilder}
     */
    public RendoHoryuTokuteiJushoBuilder set施設コード(RString 施設コード) {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        entity.setShisetsuCode(施設コード);
        return this;
    }

    /**
     * {@link RendoHoryuTokuteiJusho}のインスタンスを生成します。
     *
     * @return {@link RendoHoryuTokuteiJusho}のインスタンス
     */
    public RendoHoryuTokuteiJusho build() {
        return new RendoHoryuTokuteiJusho(entity, id);
    }
}
