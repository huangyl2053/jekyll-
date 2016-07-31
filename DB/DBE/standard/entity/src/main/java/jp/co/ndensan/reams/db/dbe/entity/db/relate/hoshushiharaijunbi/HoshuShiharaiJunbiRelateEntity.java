/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBE621001_報酬支払い通知書請求書・確認書Entityクラスです
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HoshuShiharaiJunbiRelateEntity implements Serializable {

    private static final long serialVersionUID = -1244659535082903837L;
    private RString shujiiIryoKikanCode;
    private YubinNo yubinNo;
    private RString jusho;
    private RString iryoKikanMeisho;
    private RString daihyoshaName;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private AtenaJusho t5101jusho;
    private int ikenshoSakuseiryo;
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private Code ninteiChosaKubunCode;
    private Code chosaJisshiBashoCode;
    private int chosaItakuryo;
    private Decimal tanka;
    private RString shichosonMeisho;
    private RString ninteichosainCode;
    private RString chosainShimei;
    private FlexibleDate seinengappiYMD;
    private FlexibleDate ninteichosaJisshiYMD;
    private Code chosaKubun;
    private Code homonShubetsu;
    private Code ikenshoSakuseiKaisuKubun;
    private Code zaitakuShisetsuKubun;
    private int ikenshoBettoShinryohi;
    private RString shujiiCode;
    private RString shujiiName;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoReadYMD;
    private RString shinsakaiIinCode;
    private RString t5911_daihyoshaName;
    private RString ninteiChosainNo;
    private RString sonotaKikanCode;
    private RString kikanMeisho;
    private AtenaMeisho shinsakaiIinShimei;
    private int x5603_count;
    private int shinsakaiKotsuhi;
    private int shinsakaiKojoZeigaku;
    private RString x5595_shinsakaiIinCode;
    private FlexibleDate shinsakaiKaisaiYMD;
    private int hoshu;
    private int shinsakaiHoshuGokei;

}
