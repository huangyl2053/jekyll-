/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui.JuryoIninKeiyakuShurui;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenjuryoininharaitoriatsukai.HokenJuryoIninHaraiToriatsukaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBC100032_介護保険受領委任払い取扱事業者登録通知書のEditorです。
 *
 * @reamsid_L DBC-2120-050 sunhui
 */
public class JyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor implements IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor {

    private final HokenJuryoIninHaraiToriatsukaiEntity entity;
    private final NinshoshaSource sourceBuilder;
    private RString 送付先郵便番号;
    private YubinNo 契約事業者郵便番号;
    private static final int THREE = 3;
    private static final int SEVEN = 7;
    private FlexibleDate 契約開始年月日;
    private FlexibleDate 契約終了年月日;
    private final RString 文書番号;
    private final RString 通知書定型文１;
    private final RString 通知書定型文2;
    private final ToiawasesakiSource toiawasesakiSource;

    /**
     * コンストラクタです
     *
     * @param entity HokenJuryoIninHaraiToriatsukaiEntity
     * @param sourceBuilder NinshoshaSource
     * @param toiawasesakiSource ToiawasesakiSource
     * @param 文書番号 RString
     * @param 通知書定型文１ RString
     * @param 通知書定型文2 RString
     */
    public JyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor(
            HokenJuryoIninHaraiToriatsukaiEntity entity,
            NinshoshaSource sourceBuilder,
            ToiawasesakiSource toiawasesakiSource,
            RString 文書番号,
            RString 通知書定型文１,
            RString 通知書定型文2) {
        this.entity = entity;
        this.sourceBuilder = sourceBuilder;
        this.toiawasesakiSource = toiawasesakiSource;
        this.文書番号 = 文書番号;
        this.通知書定型文１ = 通知書定型文１;
        this.通知書定型文2 = 通知書定型文2;
    }

    @Override
    public JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource edit(JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource source) {
        if (entity != null) {
            if (文書番号 != null) {
                source.bunshoNo = 文書番号;
            }

            送付先郵便番号 = entity.get送付先郵便番号().getYubinNo();
            if (送付先郵便番号 != null) {
                source.sofusakiYubinNo = new RString(送付先郵便番号.toString().
                        substring(0, THREE).concat("-").concat(送付先郵便番号.toString().substring(THREE, SEVEN)));
            }

            source.sofusakiJusho = entity.get送付先住所().value();
            source.sofusakiMeisho = entity.get送付先事業者名称().value();
            source.sofusakiBusho = entity.get送付先部署();
            source.barcodeSofusaki = entity.getバーコード情報().getCustomerBarCode();

            if (通知書定型文１ != null) {
                source.tsuchiBun1 = 通知書定型文１;
            }

            source.jigyoshoName = entity.get契約事業者名称().value();
            契約事業者郵便番号 = entity.get契約事業者郵便番号();
            if (契約事業者郵便番号 != null) {
                source.jigyoshoYubinNo = new RString(契約事業者郵便番号.toString().
                        substring(0, THREE).concat("-").concat(契約事業者郵便番号.toString().substring(THREE, SEVEN)));
            }

            source.jigyoshoJusho = entity.get契約事業者住所().value();
            source.jigyoshoTelNo = entity.get契約事業者電話番号().value();
            source.jigyoshoTorokuNo = entity.get受領委任払い取扱事業所登録番号();
            source.serviceShurui = JuryoIninKeiyakuShurui.toValue(entity.get契約種類()).get名称();

            契約開始年月日 = entity.get契約開始年月日();
            if (契約開始年月日 != null) {
                source.keiyakuKikanKaishiYmd = 契約開始年月日.
                        wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }

            source.keiyakuKikanKara = new RString("～");

            契約終了年月日 = entity.get契約終了年月日();
            if (契約終了年月日 == null || 契約終了年月日.isEmpty()) {
                source.keiyakuKikanShuryoYmd = new RString("～");
            } else {
                source.keiyakuKikanShuryoYmd = 契約終了年月日.
                        wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }

            if (通知書定型文2 != null) {
                source.tsuchiBun2 = 通知書定型文2;
            }

            source.hakkoYMD = sourceBuilder.hakkoYMD;
            source.denshiKoin = sourceBuilder.denshiKoin;
            source.koinMojiretsu = sourceBuilder.koinMojiretsu;
            source.koinShoryaku = sourceBuilder.koinShoryaku;
            source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = sourceBuilder.ninshoshaShimeiKakeru;
            source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;

            source.choshaBushoName = toiawasesakiSource.choshaBushoName;
            source.naisenLabel = toiawasesakiSource.naisenLabel;
            source.naisenNo = toiawasesakiSource.naisenNo;
            source.shozaichi = toiawasesakiSource.shozaichi;
            source.tantoName = toiawasesakiSource.tantoName;
            source.telNo = toiawasesakiSource.telNo;
            source.yubinBango = toiawasesakiSource.yubinBango;
        }
        return source;
    }
}
