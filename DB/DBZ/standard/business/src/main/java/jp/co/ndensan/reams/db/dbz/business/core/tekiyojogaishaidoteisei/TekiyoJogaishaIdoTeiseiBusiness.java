/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.tekiyojogaishaidoteisei;

import jp.co.ndensan.reams.db.dbz.entity.information.InformationEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 適用除外情報です。
 *
 * @reamsid_L DBD-3660-030 wangjie2
 */
public class TekiyoJogaishaIdoTeiseiBusiness {

    private final InformationEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 適用除外情報
     */
    public TekiyoJogaishaIdoTeiseiBusiness(InformationEntity entity) {
        this.entity = entity;
    }

    /**
     * 適用日を返します。
     *
     * @return 適用日
     */
    public FlexibleDate get適用日() {
        return entity.get適用日();
    }

    /**
     * 解除日を返します。
     *
     * @return 解除日
     */
    public FlexibleDate get解除日() {
        return entity.get解除日();
    }

    /**
     * 状態を返します。
     *
     * @return 状態
     */
    public RString get状態() {
        return entity.get状態();
    }

}
