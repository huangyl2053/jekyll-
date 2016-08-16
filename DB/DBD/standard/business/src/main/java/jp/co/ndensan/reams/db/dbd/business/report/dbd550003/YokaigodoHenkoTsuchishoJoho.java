/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護度変更通知書の一覧Entityです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigodoHenkoTsuchishoJoho {

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
    private RString kosho1;
    private RString kosho2;
    private RString beforeYokaigoKubun;
    private RString afterYokaigoKubun;
    private FlexibleDate henkoYmd;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private RString tsuchibun2;
    private RString kigenKosho;
    private FlexibleDate kigenYMD;
    private RString tsuchibun3;
    private RString tsuchibun4;
    private RString tsuchibun5;
    private RString tsuchibun6;
    private RString tsuchibun7;
    private RString tsuchibun8;
    private RString tsuchibun9;
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
    private FlexibleDate hakkoYMD;

    /**
     * 送付物宛先情報の設定します。
     *
     * @param 編集後宛先 EditedAtesaki
     */
    public void set送付物宛先情報(EditedAtesaki 編集後宛先) {
        SofubutsuAtesakiSource 送付物宛先情報;
        try {
            送付物宛先情報 = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            送付物宛先情報 = null;
        }

        if (null != 送付物宛先情報) {
            this.yubinNo = 送付物宛先情報.yubinNo;
            this.gyoseiku = 送付物宛先情報.gyoseiku;
            this.jushoText = 送付物宛先情報.jushoText;
            this.jusho1 = 送付物宛先情報.jusho1;
            this.jusho2 = 送付物宛先情報.jusho2;
            this.jusho3 = 送付物宛先情報.jusho3;
            this.katagakiText = 送付物宛先情報.katagakiText;
            this.katagaki1 = 送付物宛先情報.katagaki1;
            this.katagaki2 = 送付物宛先情報.katagaki2;
            this.katagakiSmall1 = 送付物宛先情報.katagakiSmall1;
            this.katagakiSmall2 = 送付物宛先情報.katagakiSmall2;
            this.dainoKubunMei = 送付物宛先情報.dainoKubunMei;
            this.shimeiText = 送付物宛先情報.shimeiText;
            this.shimei1 = 送付物宛先情報.shimei1;
            this.shimei2 = 送付物宛先情報.shimei2;
            this.shimeiSmall1 = 送付物宛先情報.shimeiSmall1;
            this.shimeiSmall2 = 送付物宛先情報.shimeiSmall2;
            this.samabunShimeiText = 送付物宛先情報.samabunShimeiText;
            this.samabunShimei1 = 送付物宛先情報.samabunShimei1;
            this.samabunShimei2 = 送付物宛先情報.samabunShimei2;
            this.samabunShimeiSmall1 = 送付物宛先情報.samabunShimeiSmall1;
            this.samabunShimeiSmall2 = 送付物宛先情報.samabunShimeiSmall2;
            this.meishoFuyo1 = 送付物宛先情報.meishoFuyo1;
            this.meishoFuyo2 = 送付物宛先情報.meishoFuyo2;
            this.samaBun1 = 送付物宛先情報.samaBun1;
            this.samaBun2 = 送付物宛先情報.samaBun2;
            this.kakkoLeft1 = 送付物宛先情報.kakkoLeft1;
            this.kakkoLeft2 = 送付物宛先情報.kakkoLeft2;
            this.kakkoRight1 = 送付物宛先情報.kakkoRight1;
            this.kakkoRight2 = 送付物宛先情報.kakkoRight2;
            this.customerBarCode = 送付物宛先情報.customerBarCode;
        }
    }
}
