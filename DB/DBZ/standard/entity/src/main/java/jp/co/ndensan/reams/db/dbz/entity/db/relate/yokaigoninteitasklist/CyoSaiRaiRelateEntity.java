/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆申請履歴情報＆ 要介護認定申請情報＆要介護認定完了情報＆構成市町村マスタ＆認定調査依頼情報＆ 介護事業者＆認定調査委託先情報＆認定調査委託先情報＆調査員情報＆ 認定調査委託先情報＆RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CyoSaiRaiRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private FlexibleDate ninteiShinseiYMD;
    private Code shinseijiKubunCode;
    private int saiChosaIraiKaisu;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private JigyoshaNo nyushoShisetsuCode;
    private Code shoriJotaiKubun;
    private RString shichosonMeisho;
    private RString shoKisaiHokenshaNo;
    private AtenaMeisho jigyoshaName;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate chosahyoTouShutsuryokuYMD;
    private FlexibleDate ninteichosaKigenYMD;
    private Code ninteichosaIraiKubunCode;
    private FlexibleDate ninteichosaTokusokuYMD;
    private RString ninteichosaTokusokuHoho;
    private int ninteichosaTokusokuKaisu;
    private int ninteichosaIraiKaisu;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private RString before_jigyoshaMeisho;
    private RString before_chosainShimei;
    private RString before_before_jigyoshaMeisho;
    private RString before_before_chosainShimei;
    private RString chikuCode;
    private int ninteichosaIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
}
