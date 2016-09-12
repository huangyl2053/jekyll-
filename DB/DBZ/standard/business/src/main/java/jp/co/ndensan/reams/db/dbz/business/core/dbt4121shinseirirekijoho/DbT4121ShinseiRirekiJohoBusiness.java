/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.dbt4121shinseirirekijoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;

/**
 * 申請履歴情報クラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class DbT4121ShinseiRirekiJohoBusiness {

    private final DbT4121ShinseiRirekiJohoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 申請履歴情報Entity
     */
    public DbT4121ShinseiRirekiJohoBusiness(DbT4121ShinseiRirekiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 前回申請管理番号を取得します。
     *
     * @return 前回申請管理番号
     */
    public ShinseishoKanriNo get前回申請管理番号() {
        return entity.getZenkaiShinseishoKanriNo();
    }

}
