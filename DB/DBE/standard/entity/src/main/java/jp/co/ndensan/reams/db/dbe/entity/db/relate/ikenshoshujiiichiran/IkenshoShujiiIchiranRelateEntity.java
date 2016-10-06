/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoshujiiichiran;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療機関・主治医一覧表RelateEntityクラスです。
 *
 * @reamsid_L DBE-0260-030 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranRelateEntity {

    private RString shichosonCode;
    private RString shichosonMeisho;
    private RString iryokikanCode;
    private RString iryoKikanMeishoKana;
    private RString iryoKikanMeisho;
    private RString daihyoshaNameKana;
    private AtenaMeisho daihyoshaName;
    private YubinNo yubinNo;
    private TelNo telNo;
    private RString jusho;
    private boolean iryokikanJokyoFlag;

    private RString shujiiCode;
    private AtenaKanaMeisho shujiiKana;
    private AtenaMeisho shujiiName;
    private Code seibetsu;
    private RString shinryokaName;
    private boolean shujiiJokyoFlag;
}
