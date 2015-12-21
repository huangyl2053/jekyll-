/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainmaster;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員情報検索用RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosainMasterRelateEntity {

    private LasdecCode shichosonCode;
    private ChosainCode ninteiChosainNo;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private RString seibetsu;
    private RString chosainShikaku;
    private RString chikuCode;
    private int chosaKanoNinzuPerMonth;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString shozokuKikanName;
    private boolean jokyoFlag;
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString shichosonMeisho;
}
