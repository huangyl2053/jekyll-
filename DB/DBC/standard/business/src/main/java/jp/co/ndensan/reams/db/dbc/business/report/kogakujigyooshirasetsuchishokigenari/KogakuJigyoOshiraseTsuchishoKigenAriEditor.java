/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigenari;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishoKigenAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishopaParameterEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額総合事業サービス費給付お知らせ通知書（提出期限あり）Editorクラスです。
 *
 * @reamsid_L DBC-4770-100 wangxingpeng
 */
public class KogakuJigyoOshiraseTsuchishoKigenAriEditor implements IKogakuJigyoOshiraseTsuchishoKigenAriEditor {

    private final KogakuJigyoOshiraseTsuchishopaParameterEntity entity;
    private final RString 調整金額 = new RString("調整(予定)金額");
    private final RString 支給金額 = new RString("支給(予定)金額");
    private static final int ゼロ = 0;

    /**
     * コンストラクタです
     *
     * @param entity KogakuJigyoOshiraseTsuchishopaParameterEntity
     *
     */
    public KogakuJigyoOshiraseTsuchishoKigenAriEditor(KogakuJigyoOshiraseTsuchishopaParameterEntity entity) {
        this.entity = entity;

    }

    @Override
    public KogakuJigyoOshiraseTsuchishoKigenAriSource edit(KogakuJigyoOshiraseTsuchishoKigenAriSource source) {

        source.title = entity.getタイトル();
        source.tsuchibun1 = entity.get通知文1();
        source.tsuchibun2 = entity.get通知文2();
        source.bunshoNo = entity.get文書番号文字列();
        if (entity.get申請書提出期限() != null) {
            source.kigenYMD = entity.get申請書提出期限().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }

        if (entity.get申請情報帳票発行一時() != null) {
            source.hihokenshaNameKana = entity.get申請情報帳票発行一時().getShimeikanaChohyo().value();
            source.hihokenshaName = entity.get申請情報帳票発行一時().getMeishoChohyo().value();
            source.seibetsu = entity.get申請情報帳票発行一時().getSeibetsuCodeChohyo();
            source.birthYMD = entity.get申請情報帳票発行一時().getSeinengappiYMDChohyo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.hokensha_no = entity.get申請情報帳票発行一時().getShoKisaiHokenshaNoChohyo().value();
            source.hihokenshaNo = entity.get申請情報帳票発行一時().getHihokenshaNoChohyo().value();
            source.taishoYM = entity.get申請情報帳票発行一時().getServiceTeikyoYMChohyo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            source.zikoFutanGaku = DecimalFormatter.toコンマ区切りRString(entity.get申請情報帳票発行一時().getRiyoshaFutanGakuGokeiChohyo(), 0);

            if (entity.get申請情報帳票発行一時().getGokeiKogakuShikyuGakuChohyo().compareTo(Decimal.ZERO) < ゼロ) {
                source.ketteiGaku = 調整金額;
            } else {
                source.ketteiGaku = 支給金額;
            }

            source.shikyuGaku = DecimalFormatter.toコンマ区切りRString(entity.get申請情報帳票発行一時().getGokeiKogakuShikyuGakuChohyo(), 0);

        }
        if (entity.get認証者() != null) {
            source.denshiKoin = entity.get認証者().denshiKoin;
            source.hakkoYMD = entity.get認証者().hakkoYMD;
            source.koinMojiretsu = entity.get認証者().koinMojiretsu;
            source.koinShoryaku = entity.get認証者().koinShoryaku;
            source.ninshoshaShimeiKakenai = entity.get認証者().ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = entity.get認証者().ninshoshaShimeiKakeru;
            source.ninshoshaYakushokuMei = entity.get認証者().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = entity.get認証者().ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = entity.get認証者().ninshoshaYakushokuMei2;

        }
        if (entity.get送付別宛先() != null) {
            source.customerBarCode = entity.get送付別宛先().customerBarCode;
            source.dainoKubunMei = entity.get送付別宛先().dainoKubunMei;
            source.gyoseiku = entity.get送付別宛先().gyoseiku;
            source.jusho1 = entity.get送付別宛先().jusho1;
            source.jusho2 = entity.get送付別宛先().jusho2;
            source.jusho3 = entity.get送付別宛先().jusho3;
            source.jushoText = entity.get送付別宛先().jushoText;
            source.kakkoLeft1 = entity.get送付別宛先().kakkoLeft1;
            source.kakkoLeft2 = entity.get送付別宛先().kakkoLeft2;
            source.kakkoRight1 = entity.get送付別宛先().kakkoRight1;
            source.kakkoRight2 = entity.get送付別宛先().kakkoRight2;
            source.katagaki1 = entity.get送付別宛先().katagaki1;
            source.katagaki2 = entity.get送付別宛先().katagaki2;
            source.katagakiSmall1 = entity.get送付別宛先().katagakiSmall1;
            source.katagakiSmall2 = entity.get送付別宛先().katagakiSmall2;
            source.katagakiText = entity.get送付別宛先().katagakiText;
            source.meishoFuyo1 = entity.get送付別宛先().meishoFuyo1;
            source.meishoFuyo2 = entity.get送付別宛先().meishoFuyo2;
            source.samaBun1 = entity.get送付別宛先().samaBun1;
            source.samaBun2 = entity.get送付別宛先().samaBun2;
            source.samabunShimei1 = entity.get送付別宛先().samabunShimei1;
            source.samabunShimei2 = entity.get送付別宛先().samabunShimei2;
            source.samabunShimeiSmall1 = entity.get送付別宛先().samabunShimeiSmall1;
            source.samabunShimeiSmall2 = entity.get送付別宛先().samabunShimeiSmall2;
            source.samabunShimeiText = entity.get送付別宛先().samabunShimeiText;
            source.shimei1 = entity.get送付別宛先().shimei1;
            source.shimei2 = entity.get送付別宛先().shimei2;
            source.shimeiSmall1 = entity.get送付別宛先().shimeiSmall1;
            source.shimeiSmall2 = entity.get送付別宛先().shimeiSmall2;
            source.shimeiText = entity.get送付別宛先().shimeiText;
            source.yubinNo = entity.get送付別宛先().yubinNo;

        }
        return source;

    }

}
