/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jukyushikakushomeisho;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import lombok.Getter;

/**
 *
 * 広域内住所地特例者一覧表のMyBatisパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JukyuShikakuShomeishoMyBatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    public JukyuShikakuShomeishoMyBatisParameter(IShikibetsuTaishoPSMSearchKey key) {
        super(key);
    }
}
