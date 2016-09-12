/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼RelateEntityクラスです
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiikenshosakuseiiraiRelateEntity {

    private RString hihokenshaNo;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private Code koroshoIfShikibetsuCode;
    private AtenaMeisho hihokenshaName;
    private AtenaKanaMeisho hihokenshaKana;
    private FlexibleDate seinengappiYMD;
    private int age;
    private Code seibetsu;
    private FlexibleDate ninteiShinseiYMD;
    private AtenaJusho jusho;
    private YubinNo yubinNo;
    private TelNo telNo;
    private RString shujiiIryokikanCode;
    private RString shujiiCode;
    private RString shichosonMeisho;
    private LasdecCode shichosonCode;
    private RString iryoKikanMeisho;
    private RString iryoKikanJusho;
    private TelNo iryoKikanTelNo;
    private RString iryoKikanFaxNo;
    private AtenaMeisho shujiiName;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private FlexibleDate seikyushoShutsuryokuYMD;
    private RString ikenshoIraiKubun;
    private RString preIryoKikanMeisho;
    private AtenaMeisho preShujiiName;
    private Code genzainoJokyoCode;
    private Code shinseiShinseijiKubunCode;
    private int rirekiNo;
    private int preRirekiNo;
    private boolean shisetsuNyushoFlag;
    private YubinNo iryoKikanYubinNo;
    private RString daihyoshaName;
}
