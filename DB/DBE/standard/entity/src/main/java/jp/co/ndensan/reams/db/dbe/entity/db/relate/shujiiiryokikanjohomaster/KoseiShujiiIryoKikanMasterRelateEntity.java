/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiiryokikanjohomaster;

import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報検索用RelateEntityクラスです。
 *
 * @reamsid_L DBE-0240-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KoseiShujiiIryoKikanMasterRelateEntity {

    private int totalCount;
    private LasdecCode shichosonCode;
    private RString shujiiIryokikanCode;
    private IryoKikanCode iryokikanCode;
    private RString iryoKikanMeisho;
    private RString iryoKikanMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString daihyoshaName;
    private RString daihyoshaNameKana;
    private boolean jokyoFlag;
    private RString shichosonMeisho;
}
