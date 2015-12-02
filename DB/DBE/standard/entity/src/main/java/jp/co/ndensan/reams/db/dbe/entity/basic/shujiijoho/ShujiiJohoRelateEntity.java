/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class ShujiiJohoRelateEntity implements IDbAccessable {

    @PrimaryKey
    private LasdecCode shichosonCode;
    private AtenaMeisho shujiiName;
    private AtenaKanaMeisho shujiiKana;
    @PrimaryKey
    private ShujiiCode shujiiCode;
    private RString shinryokaName;
    private boolean shiteiiFlag;
    private boolean jokyoFlag;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private Code seibetsu;
    private RString shichosonMeisho;
    @PrimaryKey
    private ShujiiIryokikanCode shujiiIryokikanCode;
    private RString iryoKikanMeisho;

}
