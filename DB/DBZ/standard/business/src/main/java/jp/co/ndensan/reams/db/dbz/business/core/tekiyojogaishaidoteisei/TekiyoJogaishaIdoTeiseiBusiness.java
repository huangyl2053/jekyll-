/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.tekiyojogaishaidoteisei;

import jp.co.ndensan.reams.db.dbz.business.core.tekiyojogaishaidoteisei.param.InformationEntity;
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
     * @param 状態 状態
     * @param 適用日 適用日
     * @param 解除日 解除日
     */
    public TekiyoJogaishaIdoTeiseiBusiness(RString 状態, FlexibleDate 適用日, FlexibleDate 解除日) {
        this.entity = new InformationEntity();
        entity.set状態(状態);
        entity.set解除日(解除日);
        entity.set適用日(適用日);
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
