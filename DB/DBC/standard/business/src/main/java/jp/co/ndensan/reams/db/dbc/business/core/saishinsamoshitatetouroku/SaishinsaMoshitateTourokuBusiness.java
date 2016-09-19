/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import lombok.Getter;

/**
 * 再審査申立のBusinessクラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
@Getter
public class SaishinsaMoshitateTourokuBusiness {

    private final DbT3062SaishinsaMoshitateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 再審査申立のEntity
     */
    public SaishinsaMoshitateTourokuBusiness(DbT3062SaishinsaMoshitateEntity entity) {
        this.entity = entity;
    }

    /**
     * 更新確認を設定します。
     *
     * @param state 更新確認
     */
    public void setState(EntityDataState state) {
        this.entity.setState(state);
    }
}
