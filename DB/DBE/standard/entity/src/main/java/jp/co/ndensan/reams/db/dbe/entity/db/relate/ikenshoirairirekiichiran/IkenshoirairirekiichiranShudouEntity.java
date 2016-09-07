/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran;

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
 * 主治医意見書作成依頼(手動)一覧のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoirairirekiichiranShudouEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString ikenshoIraiRirekiNo;
    private RString ikenshoIraiKubun;
    private Code ishiKubunCode;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private RString shujiiCode;
    private RString shujiiName;
    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private Code koroshoIfShikibetsuCode;
    private FlexibleDate ninteiShinseiYMD;
    private LasdecCode shichosonCode;

    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaMeisho hihokenshaName;
    private FlexibleDate seinengappiYMD;
    private Code seibetsu;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private YubinNo iryoKikanYubinNo;
    private AtenaJusho iryoKikanJusho;
    private RString daihyoshaName;

    private FlexibleDate iraishoShutsuryokuYMD;
    private RString shichosonMeisho;
    private TelNo telNo;
}
