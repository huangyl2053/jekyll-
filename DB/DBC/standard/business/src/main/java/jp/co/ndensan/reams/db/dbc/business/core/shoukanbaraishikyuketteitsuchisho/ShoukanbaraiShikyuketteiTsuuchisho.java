/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給決定通知書Entityクラスです。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanbaraiShikyuketteiTsuuchisho {

    private SofubutsuAtesakiSource 送付物宛先;
    private RString 文書番号;
    private FlexibleDate 発行日;
    private RString title;
    private RString title2;
    private RString title221;
    private RString title222;
    private RString title231;
    private RString title232;
    private RString title24;
    private RString 通知文1;
    private RString 被保険者氏名;
    private RString 被保険者番号1;
    private RString 被保険者番号2;
    private RString 被保険者番号3;
    private RString 被保険者番号4;
    private RString 被保険者番号5;
    private RString 被保険者番号6;
    private RString 被保険者番号7;
    private RString 被保険者番号8;
    private RString 被保険者番号9;
    private RString 被保険者番号10;

    private FlexibleDate uketsukeYMD;
    private FlexibleDate ketteiYMD;
    private Decimal shiharaiKingakuRiyoshabun;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString 給付の種類1;
    private RString 給付の種類2;
    private RString 給付の種類3;
    private RString shikyuHushikyuKetteiKubun;
    private Decimal shiharaiKingaku;
    private RString 増減の理由Title;
    private RString 増減の理由1;
    private RString 増減の理由2;
    private RString 増減の理由3;
    private RString torikeshi1;
    private RString torikeshi2;
    private RString torikeshiMochimono1;
    private RString torikeshiMochimono2;
    private RString mochimono1;
    private RString mochimono2;
    private RString mochimono3;
    private RString torikeshiShiharaibasho;
    private RString shiharaiBasho;
    private RString torikeshiShiharaikikan;
    private RString shiharaiStartYMD;
    private RString shiharaiEndYMD;
    private RString shiharaiStart;
    private RString karaFugo;
    private RString shiharaiEnd;

    private RString bankName;
    private RString branchBankName;
    private RString shumokuTitle;
    private RString kouzaShu;
    private RString bangoTitle;
    private RString kouzaNo;
    private RString kouzaMeigi;
    private IKoza 口座情報;
    private FlexibleDate 支払予定日;
    private RString 通知文2;
    private RString 通知文3;
    private RString 通知文4;
    private RString 通知文5;
    private RString 通知文6;
    private RString 通知文7;
    private RString seirino;
    private RString tsuchino;
    private RString 通番;

    private RString yubinNo;
    private RString gyoseiku2;
    private RString jusho4;
    private RString jushoText;
    private RString jusho5;
    private RString jusho6;
    private RString katagakiText;
    private RString katagaki3;
    private RString katagakiSmall2;
    private RString katagaki4;
    private RString katagakiSmall1;
    private RString shimei5;
    private RString shimeiSmall2;
    private RString shimeiText;
    private RString meishoFuyo2;
    private RString shimeiSmall1;
    private RString dainoKubunMei;
    private RString shimei6;
    private RString meishoFuyo1;
    private RString samabunShimeiText;
    private RString kakkoLeft2;
    private RString samabunShimei2;
    private RString samabunShimeiSmall2;
    private RString samaBun2;
    private RString kakkoRight2;
    private RString kakkoLeft1;
    private RString samabunShimei1;
    private RString samaBun1;
    private RString kakkoRight1;
    private RString samabunShimeiSmall1;
    private RString customerBarCode;
}
