/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link ShinseiRirekiJoho}の編集を行うビルダークラスです。
 */
public class ShinseiRirekiJohoBuilder {

    private final DbT5121ShinseiRirekiJohoEntity entity;
    private final ShinseiRirekiJohoIdentifier id;

    /**
     * {@link DbT5121ShinseiRirekiJohoEntity}より{@link ShinseiRirekiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5121ShinseiRirekiJohoEntity}
     * @param id {@link ShinseiRirekiJohoIdentifier}
     *
     */
    ShinseiRirekiJohoBuilder(
            DbT5121ShinseiRirekiJohoEntity entity,
            ShinseiRirekiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 前回申請管理番号を設定します。
     *
     * @param 前回申請管理番号 前回申請管理番号
     * @return {@link ShinseiRirekiJohoBuilder}
     */
    public ShinseiRirekiJohoBuilder set前回申請管理番号(ShinseishoKanriNo 前回申請管理番号) {
        requireNonNull(前回申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("前回申請管理番号"));
        entity.setZenkaiShinseishoKanriNo(前回申請管理番号);
        return this;
    }

    /**
     * {@link ShinseiRirekiJoho}のインスタンスを生成します。
     *
     * @return {@link ShinseiRirekiJoho}のインスタンス
     */
    public ShinseiRirekiJoho build() {
        return new ShinseiRirekiJoho(entity, id);
    }
}
