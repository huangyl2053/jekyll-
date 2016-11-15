/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者・宛名情報取得のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtenaJohoMybatisParameter implements IMyBatisParameter {

    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;
    private FlexibleYearMonth サービス提供年月;
    private RString psmShikibetsuTaisho;
}
