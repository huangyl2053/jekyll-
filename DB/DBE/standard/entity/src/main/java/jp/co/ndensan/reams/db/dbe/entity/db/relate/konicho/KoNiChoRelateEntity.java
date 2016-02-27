/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.konicho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 * {KoNiChoRelateEntity}です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoNiChoRelateEntity {

    @PrimaryKey
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    @PrimaryKey
    private ChosainCode ninteiChosainNo;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    @PrimaryKey
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString seibetsu;
    private RString chikuCode;
    private RString chosainShikaku;

    private int chosaKanoNinzuPerMonth;
    private boolean jokyoFlag;

    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;
}
