/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.basic.ikenshoShujiiIchiran;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療機関・主治医一覧表RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoShujiiIchiranRelateEntity {

    private IryoKikanCode iryokikanCode;
    private RString iryoKikanMeishoKana;
    private RString iryoKikanMeisho;
    private RString daihyoshaNameKana;
    private AtenaMeisho daihyoshaName;
    private YubinNo yubinNo;
    private TelNo telNo;
    private RString jusho;
    private boolean iryokikanJokyoFlag;
    
    private ShujiiCode shujiiCode;
    private AtenaKanaMeisho shujiiKana;
    private AtenaMeisho shujiiName;
    private Code seibetsu;
    private RString shinryokaName;
    private boolean shujiiJokyoFlag;
}
