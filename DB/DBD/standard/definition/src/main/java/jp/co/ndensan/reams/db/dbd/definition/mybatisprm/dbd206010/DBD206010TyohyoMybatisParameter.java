/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd206010;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のMybatisパラメータクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD206010TyohyoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private IShikibetsuTaishoPSMSearchKey searchKey;
    private RString 出力順;

    /**
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param orderBy RString
     */
    public DBD206010TyohyoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey, RString orderBy) {
        super(searchKey);
        this.出力順 = orderBy;
    }
}
