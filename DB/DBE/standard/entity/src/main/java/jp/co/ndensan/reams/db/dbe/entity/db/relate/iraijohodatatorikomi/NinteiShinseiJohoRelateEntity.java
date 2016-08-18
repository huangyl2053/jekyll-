/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼情報データ受取（オルカ）のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private Code koroshoIfShikibetsuCode;
    private ShujiiIryokikanCode shujiiIryokikanCode;
    private ShujiiCode shujiiCode;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private FlexibleDate ninteiShinseiYMD;
    private FlexibleDate seinengappiYMD;
    private Code seibetsu;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private int ikenshoIraiRirekiNo;
}
