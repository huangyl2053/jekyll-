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
 * 要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆申請履歴情報＆要介護認定申請情報＆要介護認定完了情報＆構成市町村マスタ＆介護事業者＆
 * 主治医意見書作成依頼情報＆要介護認定主治医意見書情報＆主治医医療機関情報＆主治医情報＆主治医医療機関情報＆主治医情報＆RelateEntityクラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IKnSyoiRaiRelateEntity {

    private ShinseishoKanriNo shinseishoKanriNo;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private JigyoshaNo nyushoShisetsuCode;
    private Code shoriJotaiKubun;
    private Code shinseijiKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private int saiSakuseiIraiKaisu;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private AtenaMeisho jigyoshaName;
    private RString shichosonMeisho;
    private FlexibleDate ikenshoSakuseiTokusokuYMD;
    private RString ikenshoSakuseiTokusokuHoho;
    private int ikenshoTokusokuKaisu;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private Code ikenshoSakuseiKaisuKubun;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private RString before_iryoKikanMeisho;
    private RString before_shujiiName;
    private RString before_before_iryoKikanMeisho;
    private RString before_before_shujiiName;
}
