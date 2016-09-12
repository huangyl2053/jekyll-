/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojohoprint;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書情報印刷情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-1390-090 lijia
 */
@lombok.Getter
@lombok.Setter
public class IkenshoJohoPrintRelateEntity implements Serializable {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private RString hihokenshaKana;
    private RString hihokenshaName;
    private Code seibetsu;
    private FlexibleDate seinengappiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString shichosonMeisho;
    private RString iryoKikanMeisho;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoKinyuYMD;
    private FlexibleDate ikenshoReadYMD;
    private RString ikenshoSakuseiryo;
    private RString ikenshoBettoShinryohi;
    private FlexibleDate hoshuShiharaiYMD;
    private ShinseishoKanriNo zenkaiShinseishoKanriNo;
    private int ikenshoIraiRirekiNo;
    private RString shujiiName;
    private RString iryoKikanMeisho2;
    private RString shujiiName2;
    private RString iryoKikanMeisho3;
    private RString shujiiName3;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoSakuseiIraiYoteiYMD;
    private FlexibleDate ikenshoSakuseiTokusokuYMD;
    private RString ikenshoTokusokuKaisu;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private FlexibleDate seikyushoShutsuryokuYMD;
    private Code koroshoIfShikibetsuCode;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString gogitaiNo;
    private RString remban;
    private RString ikenItem;
}
