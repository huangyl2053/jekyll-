/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請情報＆申請履歴情報＆要介護認定完了情報＆構成市町村マスタ＆認定調査依頼情報＆認定調査票（概況調査）＆
 * 認定調査委託先情報＆調査員情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenSyoNyuSyuRelateEntity {

    private RString jyotai;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code shoriJotaiKubun;
    private Code shinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private RString shichosonMeisho;
    private FlexibleDate ikenshoSakuseiTokusokuYMD;
    private RString ikenshoSakuseiTokusokuHoho;
    private int ikenshoTokusokuKaisu;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private int ikenshoIraiRirekiNo;
    private Code ikenshoSakuseiKaisuKubun;
    private FlexibleDate ikenshoKinyuYMD;
    private FlexibleDate ikenshoReadYMD;
    private RString iryoKikanMeisho;
    private RString shujiiName;
}
