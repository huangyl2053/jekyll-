/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.setai;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 * 世帯員取得のMyBatisパラメータクラスです。
 *
 * @reamsid_L DBB-1750-030 sunhui
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiinParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    /**
     * コンストラクス
     *
     * @param key key
     */
    public SetaiinParameter(IShikibetsuTaishoPSMSearchKey key) {
        super(key);
    }
}
