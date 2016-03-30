/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（仮算定）帳票 シーラタイプ連帳Report
 */
public class TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> {

    private static final RString NENDO = new RString("年度");

    private final KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報;
    private final TokubetsuChoshuKaishiTsuchishoKariSealerItem target;

    /**
     * コンストラクタです
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     */
    public TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報) {
        this.仮算定特徴開始通知書情報 = 仮算定特徴開始通知書情報;
        target = new TokubetsuChoshuKaishiTsuchishoKariSealerItem();
    }

    /**
     * createFormメソッド
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @return TokubetsuChoshuKaishiTsuchishoKariB5Report
     */
    public static TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport createForm(
            @NonNull KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報) {
        return new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(仮算定特徴開始通知書情報);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> writer) {
        setItem();
        ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor editor = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoEditor(target);
        ITokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder builder = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoBuilder(editor);
        writer.writeLine(builder);
    }

    /**
     * setItemメソッド
     */
    private void setItem() {
        target.set年度２(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO));
        target.set年度３(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO));
        target.set通知書番号(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get通知書番号().value());
        target.set世帯コード(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯コード().value());
        target.set年度４(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO));
        target.set保険料合計(DecimalFormatter.toコンマ区切りRString(
                仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額01()
                .add(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額02())
                .add(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特徴期別金額03()),
                0));
        target.set被保険者氏名(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get名称().getName().value());
        target.set年度５(new FlexibleYear(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get前年度情報().get前年度賦課年度())
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO));
        target.set年度６(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO));
        target.set被保険者住所１(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後宛先().get編集後住所());
        target.set保険料額前10月(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get前年度情報().get前年度特徴期別金額04(), 0));
        target.set保険料額4月2(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get更正後().get更正後特徴期別金額01(), 0));
        target.set被保険者方書１(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get方書().value());
        target.set保険料額前12月(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get前年度情報().get前年度特徴期別金額05(), 0));
        // TODO 保険料額6月２
        target.set保険料額6月2(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get更正後().get更正後特徴期別金額02(), 0));
        target.set保険料額前2月(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get前年度情報().get前年度最終期特徴期別介護保険料(), 0));
        target.set保険料額8月2(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get更正後().get更正後特徴期別金額03(), 0));
        target.set生年月日(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get生年月日());
        target.set性別(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get性別());
        target.set世帯主名(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後個人().get世帯主名().value());
        target.set年度７(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        target.set年度８(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        target.set特徴義務者名称(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収義務者());
        target.set特徴対象年金名称(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get更正後().get更正後特別徴収対象年金());
        target.set年度９(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        target.set年度(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get調定年度().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString().concat(NENDO));
        target.set表示コード名称１(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード１名());
        target.set表示コード名称２(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード２名());
        target.set表示コード名称３(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード３名());
        target.set保険料額4月1(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get更正後().get更正後特徴期別金額01(), 0));
        target.set保険料額6月1(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get更正後().get更正後特徴期別金額02(), 0));
        target.set保険料額8月1(DecimalFormatter.toコンマ区切りRString(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報()
                .get更正後().get更正後特徴期別金額03(), 0));
        target.set表示コード１(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード1());
        target.set表示コード２(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード２());
        target.set表示コード３(仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get表示コード３());

        // TODO 处理详细2 雛形部品CompSofubutsuAtesakiを作成する
        //EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(), 仮算定特徴開始通知書情報.get地方公共団体(),
        //        仮算定特徴開始通知書情報.get帳票制御共通())；
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
//        target.set郵便番号１(sofubutsuAtesakiSource.yubinNo);
//        target.set行政区１(sofubutsuAtesakiSource.gyoseiku);
//        target.set住所３(sofubutsuAtesakiSource.jusho3);
//        target.set住所(sofubutsuAtesakiSource.jushoText);
//        target.set住所１(sofubutsuAtesakiSource.jusho1);
//        target.set住所２(sofubutsuAtesakiSource.jusho2);
//        target.set方書(sofubutsuAtesakiSource.katagakiText);
//        target.set方書２(sofubutsuAtesakiSource.katagaki2);
//        target.set方書小２(sofubutsuAtesakiSource.katagakiSmall2);
//        target.set方書１(sofubutsuAtesakiSource.katagaki1);
//        target.set方書小１(sofubutsuAtesakiSource.katagakiSmall1);
//        target.set氏名２(sofubutsuAtesakiSource.shimei2);
//        target.set氏名小２(sofubutsuAtesakiSource.shimeiSmall2);
//        target.set氏名text(sofubutsuAtesakiSource.shimeiText);
//        target.set名称不要２(sofubutsuAtesakiSource.meishoFuyo2);
//        target.set氏名小1(sofubutsuAtesakiSource.shimeiSmall1);
//        target.set代納区分名(sofubutsuAtesakiSource.dainoKubunMei);
//        target.set氏名1(sofubutsuAtesakiSource.shimei1);
//        target.set名称不要1(sofubutsuAtesakiSource.meishoFuyo1);
//        target.setSamabunShimeiText(sofubutsuAtesakiSource.samabunShimeiText);
//        target.setSamabunShimeiSmall2(sofubutsuAtesakiSource.samabunShimeiSmall2);
//        target.setSamaBun2(sofubutsuAtesakiSource.samaBun2);
//        target.setKakkoLeft2(sofubutsuAtesakiSource.kakkoLeft2);
//        target.setSamabunShimei2(sofubutsuAtesakiSource.samabunShimei2);
//        target.setKakkoRight2(sofubutsuAtesakiSource.kakkoRight2);
//        target.setKakkoLeft1(sofubutsuAtesakiSource.kakkoLeft1);
//        target.setSamabunShimei1(sofubutsuAtesakiSource.samabunShimei1);
//        target.setSamaBun1(sofubutsuAtesakiSource.samaBun1);
//        target.setKakkoRight1(sofubutsuAtesakiSource.kakkoRight1);
//        target.setSamabunShimeiSmall1(sofubutsuAtesakiSource.samabunShimeiSmall1);
//        target.setCustomerBarCode(sofubutsuAtesakiSource.customerBarCode);
//        // TODO 世帯主名
//        // TODO 様方
        // TODO 処理詳細の[雛形部品CompNinshoshaを作成する」
        INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
        INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, RString.EMPTY);
        NinshoshaSource ninshoshaSource = ninshoshaSourceBuilder.buildSource();
        target.set電子公印(ninshoshaSource.denshiKoin);
        target.set署名発行年月日(ninshoshaSource.hakkoYMD);
        // TODO 市町村名
        // TODO 市長名
        target.set公印省略(ninshoshaSource.koinShoryaku);

    }
}
