/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.ikenshoprint;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenshoHoshuTankaEntity {

    private Code zaitakuShisetsuKubun;
    private Code ikenshoSakuseiKaisuKubun;
    private FlexibleYearMonth kaishiYM;
    private FlexibleYearMonth shuryoYM;
    private Decimal tanka;
}
