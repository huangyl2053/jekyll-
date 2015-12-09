/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * {@link NinteichosahyoServiceJokyoFlag}の編集を行うビルダークラスです。
 */
public class NinteichosahyoServiceJokyoFlagBuilder {

    private final DbT5208NinteichosahyoServiceJokyoFlagEntity entity;
    private final NinteichosahyoServiceJokyoFlagIdentifier id;

    /**
     * {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}より{@link NinteichosahyoServiceJokyoFlag}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5208NinteichosahyoServiceJokyoFlagEntity}
     * @param id {@link NinteichosahyoServiceJokyoFlagIdentifier}
     *
     */
    NinteichosahyoServiceJokyoFlagBuilder(
            DbT5208NinteichosahyoServiceJokyoFlagEntity entity,
            NinteichosahyoServiceJokyoFlagIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 厚労省IF識別コードを設定します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return {@link NinteichosahyoServiceJokyoFlagBuilder}
     */
    public NinteichosahyoServiceJokyoFlagBuilder set厚労省IF識別コード(Code 厚労省IF識別コード) {
        requireNonNull(厚労省IF識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("厚労省IF識別コード"));
        entity.setKoroshoIfShikibetsuCode(厚労省IF識別コード);
        return this;
    }

    /**
     * サービスの状況フラグを設定します。
     *
     * @param サービスの状況フラグ サービスの状況フラグ
     * @return {@link NinteichosahyoServiceJokyoFlagBuilder}
     */
    public NinteichosahyoServiceJokyoFlagBuilder setサービスの状況フラグ(boolean サービスの状況フラグ) {
        requireNonNull(サービスの状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスの状況フラグ"));
        entity.setServiceJokyoFlag(サービスの状況フラグ);
        return this;
    }

    /**
     * {@link NinteichosahyoServiceJokyoFlag}のインスタンスを生成します。
     *
     * @return {@link NinteichosahyoServiceJokyoFlag}のインスタンス
     */
    public NinteichosahyoServiceJokyoFlag build() {
        return new NinteichosahyoServiceJokyoFlag(entity, id);
    }
}
