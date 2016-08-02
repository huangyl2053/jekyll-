/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定結果通知書の一覧Entityです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiKekkaTsuchishoEntity {

    private RString bunshoNo;
    private RString title;
    private RString tsuchibun1;
    private RString hihokenshaName;
    private RString hihokenshaNo1;
    private RString hihokenshaNo2;
    private RString hihokenshaNo3;
    private RString hihokenshaNo4;
    private RString hihokenshaNo5;
    private RString hihokenshaNo6;
    private RString hihokenshaNo7;
    private RString hihokenshaNo8;
    private RString hihokenshaNo9;
    private RString hihokenshaNo10;
    private RString kekkaKosho;
    private RString kekkaName;
    private RString kekkaYMDKosho;
    private FlexibleDate kekkaYMD;
    private RString riyu;
    private RString serviceShurui1;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private RString tsuchibun2;
    private RString tsuchibun3;
    private RString tsuchibun4;
    private RString tsuchibun5;
    private RString tsuchibun6;
    private RString tsuchibun7;
    private RString yubinNo;
    private RString gyoseiku;
    private RString jushoText;
    private RString jusho1;
    private RString jusho2;
    private RString jusho3;
    private RString katagakiText;
    private RString katagaki1;
    private RString katagaki2;
    private RString katagakiSmall1;
    private RString katagakiSmall2;
    private RString dainoKubunMei;
    private RString shimeiText;
    private RString shimei1;
    private RString shimei2;
    private RString shimeiSmall1;
    private RString shimeiSmall2;
    private RString samabunShimeiText;
    private RString samabunShimei1;
    private RString samabunShimei2;
    private RString samabunShimeiSmall1;
    private RString samabunShimeiSmall2;
    private RString meishoFuyo1;
    private RString meishoFuyo2;
    private RString samaBun1;
    private RString samaBun2;
    private RString kakkoLeft1;
    private RString kakkoLeft2;
    private RString kakkoRight1;
    private RString kakkoRight2;
    private RString customerBarCode;

}
