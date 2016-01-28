/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoServiceJokyo}の編集を行うビルダークラスです。
 */
public class NinteichosahyoServiceJokyoBuilder {

    private final DbT5207NinteichosahyoServiceJokyoEntity entity;
    private final NinteichosahyoServiceJokyoIdentifier id;

    /**
     * {@link DbT5207NinteichosahyoServiceJokyoEntity}より{@link NinteichosahyoServiceJokyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5207NinteichosahyoServiceJokyoEntity}
     * @param id {@link NinteichosahyoServiceJokyoIdentifier}
     *
     */
    NinteichosahyoServiceJokyoBuilder(
            DbT5207NinteichosahyoServiceJokyoEntity entity,
            NinteichosahyoServiceJokyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoServiceJokyoBuilder}
     */
    public NinteichosahyoServiceJokyoBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * サービスの状況を設定します。
     *
     * @param サービスの状況 サービスの状況
     * @return {@link NinteichosahyoServiceJokyoBuilder}
     */
    public NinteichosahyoServiceJokyoBuilder setサービスの状況(int サービスの状況) {
        requireNonNull(サービスの状況, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスの状況"));
        entity.setServiceJokyo(サービスの状況);
        return this;
    }

    /**
     * {@link NinteichosahyoServiceJokyo}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoServiceJokyo}のインスタンス
     */
    public NinteichosahyoServiceJokyo build() {
        return new NinteichosahyoServiceJokyo(entity, id);
    }
}
