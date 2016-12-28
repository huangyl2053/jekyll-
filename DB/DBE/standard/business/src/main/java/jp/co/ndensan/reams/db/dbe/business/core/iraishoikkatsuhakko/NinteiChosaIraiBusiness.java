/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaIraiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.NinteiChosaIraiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * バッチ設計_DBE220003_認定調査依頼発行一覧表のRelateBusinessクラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class NinteiChosaIraiBusiness {

        private static final RString 年号_明治 = new RString("明");
    private static final RString 年号_大正 = new RString("大");
    private static final RString 年号_昭和 = new RString("昭");
    private static final RString 記号_星 = new RString("*");
    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 文字列3 = new RString("3");
    private static final RString 文字列4 = new RString("4");
    private static final RString 文字列5 = new RString("5");
    private static final RString 記号 = new RString("✔");
    private static final RString YOKAIGOJOTAIKUBUN01 = new RString("01");
    private static final RString YOKAIGOJOTAIKUBUN12 = new RString("12");
    private static final RString YOKAIGOJOTAIKUBUN13 = new RString("13");
    private static final RString YOKAIGOJOTAIKUBUN21 = new RString("21");
    private static final RString YOKAIGOJOTAIKUBUN22 = new RString("22");
    private static final RString YOKAIGOJOTAIKUBUN23 = new RString("23");
    private static final RString YOKAIGOJOTAIKUBUN24 = new RString("24");
    private static final RString YOKAIGOJOTAIKUBUN25 = new RString("25");
    private static final RString TITLE = new RString("調査票差異チェック票");
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString NINTEIOCHOSAIRAISHO = new RString("【認定調査依頼書印刷区分】");
    private static final RString NINTEICHOSAHYO = new RString("【認定調査票印刷区分】");
    private static final RString NINTEICHOSAIRAILIST = new RString("【認定調査依頼リスト】");
    private static final RString NINTEICHOSAITAKUSAKICODE = new RString("　　【認定調査委託先コード】");
    private static final RString NINTEICHOSAINCODE = new RString("　　【認定調査員コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString NINTEICHOSAIRAISYO = new RString("【認定調査依頼書出力区分】");
    private static final RString NINTEICHOSADESIGN = new RString("【認定調査票（デザイン用紙）出力区分】");
    private static final RString TOKKIJIKODESIGN = new RString("【特記事項（デザイン用紙）出力区分】");
    private static final RString NINTEICHOSAOCR = new RString("【認定調査票OCR出力区分】");
    private static final RString TOKKIJIKOOCR = new RString("【特記事項OCR出力区分】");
    private static final RString GAIKYOTOKKI = new RString("【概況特記出力区分】");
    private static final RString NINTEICHOSACHECKHYO = new RString("【認定調査差異チェック表出力区分】");
    private static final RString ZENKONINTEICHOSAHYO = new RString("【前回認定調査結果との比較表出力区分】");
    private static final RString TOKKIJIKO_KOMOKUARI = new RString("【特記事項（項目有り）】");
    private static final RString TOKKIJIKO_KOMOKUNASHI = new RString("【特記事項（項目無し）】");
    private static final RString TOKKIJIKO_FREE = new RString("【特記事項（フリータイプ）】");
    private static final RString TENYURYOKU = new RString("【手入力タイプ】");
    private static final RString NINTEICHOSAIRAICHOHYO = new RString("【認定調査依頼一覧表出力区分】");
    private static final RString NINTEICHOSAIRAIRIREKIICHIRAN = new RString("【認定調査依頼履歴一覧出力区分】");
    private static final RString UESANKAKU = new RString("▲");
    private static final RString SHITASANKAKU = new RString("▼");
    
    
    /**
     * 帳票「帳票設計_DBE220003_認定調査依頼発行一覧表」Headerデータを作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return ChosaIraiHakkoIchiranhyoHeadItem
     */
    public ChosaIraiHakkoIchiranhyoHeadItem setHeadItem(NinteiChosaIraiProcessParamter processParamter) {
        ChosaIraiHakkoIchiranhyoHeadItem headItem = new ChosaIraiHakkoIchiranhyoHeadItem();
        headItem.set認定調査依頼書FLG(processParamter.getNinteiChosaIraisyo());
        headItem.set依頼日From(processParamter.getIraiFromYMD());
        headItem.set依頼日To(processParamter.getIraiToYMD());
        return headItem;
    }

    /**
     * 帳票「帳票設計_DBE220003_認定調査依頼発行一覧表」Bodyデータを作成するメッソドです。
     *
     * @param entity entity
     * @return ChosaIraiHakkoIchiranhyoHeadItem
     */
    public ChosaIraiHakkoIchiranhyoBodyItem setBodyItem(NinteiChosaIraiRelateEntity entity) {
        ChosaIraiHakkoIchiranhyoBodyItem bodyItem = new ChosaIraiHakkoIchiranhyoBodyItem();
        bodyItem.set依頼書作成日(entity.getIraishoShutsuryokuYMD());
        bodyItem.set依頼書提出期限(entity.getNinteichosaKigenYMD());
        bodyItem.set市町村コード(entity.getShichosonCode());
        bodyItem.set市町村名称(entity.getShichosonMeisho());
        bodyItem.set被保険者番号(entity.getHihokenshaNo());
        bodyItem.set被保険者氏名(entity.getHihokenshaName());
        bodyItem.set依頼日(entity.getNinteichosaIraiYMD());
        bodyItem.set委託先名(entity.getJigyoshaMeisho());
        bodyItem.set代表者名(entity.getDaihyoshaName());
        bodyItem.set連絡先(entity.getTelNo());
        bodyItem.set調査員名(entity.getChosainShimei());
        return bodyItem;
    }

    /**
     * 出力条件表Listを取得メッソドです。
     *
     * @param processParamter
     * @return List<RString>
     */
    public List<RString> set出力条件(NinteiChosaIraiProcessParamter processParamter) {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(ConvertDate(processParamter.getIraiFromYMD()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(ConvertDate(processParamter.getIraiToYMD()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEIOCHOSAIRAISHO);
        builder.append(get区分(processParamter.getNinteiChosaIraisyo()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYO);
        builder.append(get区分(processParamter.getNinteiChosahyo()));
        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(HAKKOBI);
//        builder.append(ConvertDate(processParamter.getHakkobi()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TEISHUTSUKIGEN);
//        builder.append(get提出期限(processParamter.getTeishutsuKigen()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(KYOTSUHIZUKE);
//        builder.append(ConvertDate(processParamter.getKyotsuHizuke()));
//        出力条件.add(builder.toRString());
//
//        builder = new RStringBuilder();
//        builder.append(NINTEICHOSAIRAISYO);
//        builder.append(get出力可否(processParamter.is認定調査依頼書()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(NINTEICHOSADESIGN);
//        builder.append(get出力可否(processParamter.is認定調査票_デザイン用紙()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TOKKIJIKODESIGN);
//        builder.append(get出力可否(processParamter.is特記事項_デザイン用紙()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(NINTEICHOSAOCR);
//        builder.append(get出力可否(processParamter.is認定調査票OCR()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TOKKIJIKOOCR);
//        builder.append(get出力可否(processParamter.is特記事項OCR()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(GAIKYOTOKKI);
//        builder.append(get出力可否(processParamter.is概況特記()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(NINTEICHOSACHECKHYO);
//        builder.append(get出力可否(processParamter.is認定調査差異チェック票()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(ZENKONINTEICHOSAHYO);
//        builder.append(get出力可否(processParamter.is前回認定調査結果との比較表()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TOKKIJIKO_KOMOKUARI);
//        builder.append(get出力可否(processParamter.is特記事項_項目あり()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TOKKIJIKO_KOMOKUNASHI);
//        builder.append(get出力可否(processParamter.is特記事項_項目無し()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TOKKIJIKO_FREE);
//        builder.append(get出力可否(processParamter.is特記事項_フリータイプ()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TENYURYOKU);
//        builder.append(get出力可否(processParamter.is手入力タイプ()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(NINTEICHOSAIRAICHOHYO);
//        builder.append(get出力可否(processParamter.isNinteiChosaIraiChohyo()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(NINTEICHOSAIRAIRIREKIICHIRAN);
//        builder.append(get出力可否(processParamter.is認定調査依頼履歴一覧()));
//        出力条件.add(builder.toRString());
        return 出力条件;
    }
        private RString get出力可否(boolean 出力可否) {
        return 出力可否 ? new RString("出力する") : new RString("出力しない");
    }

    private RString get提出期限(RString kubun) {
        if (RString.isNullOrEmpty(kubun)) {
            return RString.EMPTY;
        }
        if (kubun.equals(文字列0)) {
            return new RString("申請者別に自動設定");
        } else if (kubun.equals(文字列1)) {
            return new RString("空欄");
        } else if (kubun.equals(文字列2)) {
            return new RString("共通日付");
        } else {
            return RString.EMPTY;
        }
    }

    private RString get区分(RString kubun) {
        if (RString.isNullOrEmpty(kubun)) {
            return RString.EMPTY;
        }
        if (kubun.equals(文字列1)) {
            return new RString("未印刷");
        } else if (kubun.equals(文字列2)) {
            return new RString("印刷済");
        } else if (kubun.equals(文字列3)) {
            return new RString("未印刷　印刷済");
        } else {
            return RString.EMPTY;
        }
    }

    private RString ConvertDate(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (!FlexibleDate.canConvert(date)) {
            return date;
        }
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
    }
}
