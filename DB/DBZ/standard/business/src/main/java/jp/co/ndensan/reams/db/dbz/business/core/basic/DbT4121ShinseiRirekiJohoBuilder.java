/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * {@link DbT4121ShinseiRirekiJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBZ-9999-011 zuotao
 */
public class DbT4121ShinseiRirekiJohoBuilder {

    private final DbT4121ShinseiRirekiJohoEntity entity;
    private final DbT4121ShinseiRirekiJohoIdentifier id;

    /**
     * {@link DbT4121ShinseiRirekiJohoEntity}より{@link DbT4121ShinseiRirekiJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT4121ShinseiRirekiJohoEntity}
     * @param id {@link DbT4121ShinseiRirekiJohoIdentifier}
     *
     */
    DbT4121ShinseiRirekiJohoBuilder(
            DbT4121ShinseiRirekiJohoEntity entity,
            DbT4121ShinseiRirekiJohoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 前回申請管理番号を設定します。
     *
     * @param 前回申請管理番号 前回申請管理番号
     * @return {@link DbT4121ShinseiRirekiJohoBuilder}
     */
    public DbT4121ShinseiRirekiJohoBuilder set前回申請管理番号(ShinseishoKanriNo 前回申請管理番号) {
        requireNonNull(前回申請管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("前回申請管理番号"));
        entity.setZenkaiShinseishoKanriNo(前回申請管理番号);
        return this;
    }

    /**
     * {@link DbT4121ShinseiRirekiJoho}のインスタンスを生成します。
     *
     * @return {@link DbT4121ShinseiRirekiJoho}のインスタンス
     */
    public DbT4121ShinseiRirekiJoho build() {
        return new DbT4121ShinseiRirekiJoho(entity, id);
    }
}
