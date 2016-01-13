/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RojinHokenJukyushaJoho}の編集を行うビルダークラスです。
 */
public class RojinHokenJukyushaJohoBuilder {

    private final DbT7005RojinHokenJukyushaJohoEntity entity;
    private final RojinHokenJukyushaJohoIdentifier id;

    /**
     * {@link DbT7005RojinHokenJukyushaJohoEntity}より{@link RojinHokenJukyushaJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7005RojinHokenJukyushaJohoEntity}
     * @param id {@link RojinHokenJukyushaJohoIdentifier}
     *
     */
    RojinHokenJukyushaJohoBuilder(
            DbT7005RojinHokenJukyushaJohoEntity entity,
            RojinHokenJukyushaJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link RojinHokenJukyushaJohoBuilder}
     */
    public RojinHokenJukyushaJohoBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link RojinHokenJukyushaJohoBuilder}
     */
    public RojinHokenJukyushaJohoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 老人保健市町村コードを設定します。
     *
     * @param 老人保健市町村コード 老人保健市町村コード
     * @return {@link RojinHokenJukyushaJohoBuilder}
     */
    public RojinHokenJukyushaJohoBuilder set老人保健市町村コード(LasdecCode 老人保健市町村コード) {
        requireNonNull(老人保健市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村コード"));
        entity.setRojinHokenShichosonCode(老人保健市町村コード);
        return this;
    }

    /**
     * 老人保健受給者番号を設定します。
     *
     * @param 老人保健受給者番号 老人保健受給者番号
     * @return {@link RojinHokenJukyushaJohoBuilder}
     */
    public RojinHokenJukyushaJohoBuilder set老人保健受給者番号(RString 老人保健受給者番号) {
        requireNonNull(老人保健受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号"));
        entity.setRojinHokenJukyushaNo(老人保健受給者番号);
        return this;
    }

    /**
     * {@link RojinHokenJukyushaJoho}のインスタンスを生成します。
     *
     * @return {@link RojinHokenJukyushaJoho}のインスタンス
     */
    public RojinHokenJukyushaJoho build() {
        return new RojinHokenJukyushaJoho(entity, id);
    }
}
