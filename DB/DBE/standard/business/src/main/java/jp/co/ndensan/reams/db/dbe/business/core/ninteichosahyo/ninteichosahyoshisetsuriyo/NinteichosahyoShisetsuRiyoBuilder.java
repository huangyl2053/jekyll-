/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoShisetsuRiyo}の編集を行うビルダークラスです。
 */
public class NinteichosahyoShisetsuRiyoBuilder {

    private final DbT5210NinteichosahyoShisetsuRiyoEntity entity;
    private final NinteichosahyoShisetsuRiyoIdentifier id;

    /**
     * {@link DbT5210NinteichosahyoShisetsuRiyoEntity}より{@link NinteichosahyoShisetsuRiyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5210NinteichosahyoShisetsuRiyoEntity}
     * @param id {@link NinteichosahyoShisetsuRiyoIdentifier}
     *
     */
    NinteichosahyoShisetsuRiyoBuilder(
            DbT5210NinteichosahyoShisetsuRiyoEntity entity,
            NinteichosahyoShisetsuRiyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * 施設利用フラグを設定します。
     *
     * @param 施設利用フラグ 施設利用フラグ
     * @return {@link NinteichosahyoShisetsuRiyoBuilder}
     */
    public NinteichosahyoShisetsuRiyoBuilder set施設利用フラグ(boolean 施設利用フラグ) {
        requireNonNull(施設利用フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("施設利用フラグ"));
        entity.setShisetsuRiyoFlag(施設利用フラグ);
        return this;
    }

    /**
     * {@link NinteichosahyoShisetsuRiyo}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoShisetsuRiyo}のインスタンス
     */
    public NinteichosahyoShisetsuRiyo build() {
        return new NinteichosahyoShisetsuRiyo(entity, id);
    }
}
