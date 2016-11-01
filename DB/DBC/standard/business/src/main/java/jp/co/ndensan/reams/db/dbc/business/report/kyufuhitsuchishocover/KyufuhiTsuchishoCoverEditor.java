/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishocover;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishocover.KyufuhiTsuchishoCoverEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishocover.KyufuhiTsuchishoCoverReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書のEditorです。
 *
 * @reamsid_L DBC-2280-040 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoCoverEditor implements IKyufuhiTsuchishoCoverEditor {

    private final KyufuhiTsuchishoCoverEntity item;
    private int index;
    private static final int PAGECOUNT = 15;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiTsuchishoCoverEntity}
     */
    protected KyufuhiTsuchishoCoverEditor(KyufuhiTsuchishoCoverEntity item) {
        this.item = item;
    }

    @Override
    public KyufuhiTsuchishoCoverReportSource edit(KyufuhiTsuchishoCoverReportSource source) {
        return editSource(source);
    }

    private KyufuhiTsuchishoCoverReportSource editSource(KyufuhiTsuchishoCoverReportSource source) {
        source.bunshoNo = item.getBunshoNo();
        source.hokenshaNo = item.getHokenshaNo();
        source.hihokenshaName = item.getHihokenshaName();
        source.shukeiserviceSTYM = new FlexibleYearMonth(item.getShukeiserviceSTYM()).
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString();
        source.shukeiserviceEDYM = new FlexibleYearMonth(item.getShukeiserviceEDYM()).
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString();
        source.toiawasesakiTitle = item.getToiawasesakiTitle();
        source.listServiceIchiranUpper_1 = new FlexibleYearMonth(item.getListServiceIchiranUpper_1()).
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString();
        source.listServiceIchiranUpper_2 = item.getListServiceIchiranUpper_2();
        source.listServiceIchiranUpper_3 = item.getListServiceIchiranUpper_3();
        source.listServiceIchiranUpper_4 = item.getListServiceIchiranUpper_4();
        source.listServiceIchiranUpper_5
                = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getListServiceIchiranUpper_5().toString()), 0).concat("円");
        source.listServiceIchiranUpper_6
                = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getListServiceIchiranUpper_6().toString()), 0).concat("円");
        source.listServiceIchiranLower_1 = item.getListServiceIchiranLower_1();
        source.listServiceIchiranLower_2 = item.getListServiceIchiranLower_2();
        source.tsuchibun1 = item.getTsuchibun1();
        source.tsuchibun2 = item.getTsuchibun2();
        source.pageBunshi = new RString(item.getPageBunshi());
        source.pageBunbo = new RString(item.getPageBunbo());
        source.denshiKoin = item.getDenshiKoin();
        source.hakkoYMD = item.getHakkoYMD();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinShoryaku = item.getKoinShoryaku();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.yubinNo = item.getYubinNo();
        source.gyoseiku1 = item.getGyoseiku();
        source.jusho4 = item.getJusho4();
        source.jushoText = item.getJushoText();
        source.jusho5 = item.getJusho5();
        source.jusho6 = item.getJusho6();
        source.katagakiText = item.getKatagakiText();
        source.katagaki3 = item.getKatagaki3();
        source.katagaki4 = item.getKatagaki4();
        source.katagakiSmall1 = item.getKatagakiSmall1();
        source.katagakiSmall2 = item.getKatagakiSmall2();
        source.dainoKubunMei = item.getDainoKubunMei();
        source.shimeiText = item.getShimeiText();
        source.shimei5 = item.getShimei5();
        source.shimei6 = item.getShimei6();
        source.shimeiSmall1 = item.getShimeiSmall1();
        source.shimeiSmall2 = item.getShimeiSmall2();
        source.samabunShimeiText = item.getSamabunShimeiText();
        source.samabunShimei1 = item.getSamabunShimei1();
        source.samabunShimei2 = item.getSamabunShimei2();
        source.samabunShimeiSmall1 = item.getSamabunShimeiSmall1();
        source.samabunShimeiSmall2 = item.getSamabunShimeiSmall2();
        source.meishoFuyo1 = item.getMeishoFuyo1();
        source.meishoFuyo2 = item.getMeishoFuyo2();
        source.samaBun1 = item.getSamaBun1();
        source.samaBun2 = item.getSamaBun2();
        source.kakkoLeft1 = item.getKakkoLeft1();
        source.kakkoLeft2 = item.getKakkoLeft2();
        source.kakkoRight1 = item.getKakkoRight1();
        source.kakkoRight2 = item.getKakkoRight2();
        source.customerBarCode = item.getCustomerBarCode();
        source.yubinBango = item.getYubinBango();
        source.shozaichi = item.getShozaichi();
        source.choshaBushoName = item.getChoshaBushoName();
        source.tantoName = item.getTantoName();
        source.telNo = item.getTelNo();
        source.naisenLabel = item.getNaisenLabel();
        source.naisenNo = item.getNaisenNo();
        if (PAGECOUNT < index) {
            source.hihokenshaName = item.getHihokenshaName();
            source.hokenshaNo = item.getHokenshaNo();
            source.shukeiserviceSTYM = new FlexibleYearMonth(item.getShukeiserviceSTYM()).
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                    .toDateString();
            source.shukeiserviceEDYM = new FlexibleYearMonth(item.getShukeiserviceEDYM()).
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                    .toDateString();
            source.listServiceIchiranUpper_1 = new FlexibleYearMonth(item.getListServiceIchiranUpper_1()).
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK)
                    .toDateString();
            source.listServiceIchiranUpper_2 = item.getListServiceIchiranUpper_2();
            source.listServiceIchiranUpper_3 = item.getListServiceIchiranUpper_3();
            source.listServiceIchiranUpper_4 = item.getListServiceIchiranUpper_4();
            source.listServiceIchiranUpper_5
                    = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getListServiceIchiranUpper_5().toString()), 0).concat("円");
            source.listServiceIchiranUpper_6
                    = DecimalFormatter.toコンマ区切りRString(new Decimal(item.getListServiceIchiranUpper_6().toString()), 0).concat("円");
            source.listServiceIchiranLower_1 = item.getListServiceIchiranLower_1();
            source.listServiceIchiranLower_2 = item.getListServiceIchiranLower_2();
            source.tsuchibun1 = item.getTsuchibun1();
            source.tsuchibun2 = item.getTsuchibun2();
            source.pageBunshi = new RString(item.getPageBunshi());
            source.pageBunbo = new RString(item.getPageBunbo());
            source.listServiceIchiranLower_2 = item.getListServiceIchiranLower_2();
        }
        return source;
    }
}
