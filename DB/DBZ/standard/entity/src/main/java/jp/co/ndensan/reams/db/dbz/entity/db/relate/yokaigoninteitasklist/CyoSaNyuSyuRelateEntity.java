/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請情報＆申請履歴情報＆要介護認定完了情報＆構成市町村マスタ＆認定調査依頼情報＆認定調査票（概況調査）＆
 * 認定調査委託先情報＆調査員情報＆認定調査票（基本調査）＆認定調査票（特記事項）＆認定調査票（概況特記）RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CyoSaNyuSyuRelateEntity {

    private ShinseishoKanriNo dbt5101ShinseishoKanriNo;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private AtenaMeisho hihokenshaKana;
    private FlexibleDate ninteiShinseiYMD;
    private Code shinseijiKubunCode;
    private int saiChosaIraiKaisu;
    private Code shoriJotaiKubun;
    private RString shichosonMeisho;
    private AtenaMeisho jigyoshaName;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ninteichosaTokusokuYMD;
    private RString ninteichosaTokusokuHoho;
    private int ninteichosaTokusokuKaisu;
    private FlexibleDate ninteichosaKigenYMD;
    private FlexibleDate ninteichosaJisshiYMD;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private RString chikuCode;
    private int ninteichosaIraiRirekiNo;
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    private ChosainCode ninteiChosainCode;
    private ShinseishoKanriNo dbt5203ShinseishoKanriNo;
    private ShinseishoKanriNo dbt5205ShinseishoKanriNo;
    private ShinseishoKanriNo dbt5206ShinseishoKanriNo;
}
