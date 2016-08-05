/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.zenkokuhokenshamasterkoshin;

import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import lombok.Getter;

/**
 * 保険者情報のBusinessクラスです。
 *
 * @reamsid_L　DBU-4230-010 chenxiangyu
 */
@Getter
public class UrT0507HokenjaEntityBusiness {

    private final UrT0507HokenjaEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 保険者情報のEntity
     */
    public UrT0507HokenjaEntityBusiness(UrT0507HokenjaEntity entity) {
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
