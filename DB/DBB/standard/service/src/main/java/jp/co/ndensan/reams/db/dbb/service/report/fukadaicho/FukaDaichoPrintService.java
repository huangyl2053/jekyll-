/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.fukadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedHonSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FukaDaichoItem;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FukaDaichoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FukaDaichoReport;
import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 賦課台帳（本算定）帳票PrintService
 */
public class FukaDaichoPrintService {

    public SourceDataCollection print(EditedHonSanteiFukaDaichoJoho entity) {
        FukaDaichoProperty property = new FukaDaichoProperty();
        List<FukaDaichoItem> targets = setItems(entity);
        return new Printer<FukaDaichoSource>().spool(property, toReports(targets));
    }

    private static List<FukaDaichoReport> toReports(List<FukaDaichoItem> targets) {
        List<FukaDaichoReport> list = new ArrayList<>();
        list.add(FukaDaichoReport.createForm(targets));
        return list;
    }

    private List<FukaDaichoItem> setItems(EditedHonSanteiFukaDaichoJoho entity) {
        List<FukaDaichoItem> targets = new ArrayList<>();
        Integer pageAll = 1;
        if (entity != null) {
            if (!entity.get世帯員情報リスト().isEmpty()) {
               pageAll = (entity.get世帯員情報リスト().size() - 1) / 8 + 1;
            }
            for (int pageNow = 1; pageNow <= pageAll; pageNow++) {
                if (pageNow <= 1) {
                    FukaDaichoItem item = new FukaDaichoItem();
                    item.setKozaMeiginin(entity.get口座名義人());
                    item.setBankName(entity.get金融機関名());
                    item.setBankNo(entity.get金融機関番号());
                    item.setChoteiJiyu1(entity.get調定事由1());
                    item.setChoteiJiyu2(entity.get調定事由2());
                    item.setChoteiJiyu3(entity.get調定事由3());
                    item.setChoteiJiyu4(entity.get調定事由4());
                    item.setChoteiNendo(entity.get調定年度());
                    item.setDainoninJusho(entity.get代納人住所());
                    item.setDainoninName(entity.get代納人名称());
                    item.setDainoninNameKana(entity.get代納人名称カナ());
                    item.setDainoninRenrakuSaki1(entity.get代納人連絡先１());
                    item.setDainoninRenrakuSaki2(entity.get代納人連絡先２());
                    item.setDainoninyubinNo(entity.get代納人郵便NO());
                    item.setFukaNendo(entity.get賦課年度());
                    item.setHenkoJiyu1(entity.get変更事由1());
                    item.setHenkoJiyu2(entity.get変更事由2());
                    item.setHenkoJiyu3(entity.get変更事由3());
                    item.setHenkoJiyu4(entity.get変更事由4());
                    item.setHihokenshaNo(entity.get被保険者番号().value());
                    item.setHokenshaName(entity.get保険者名称());
                    item.setHokenshaNo(entity.get保険者番号().value());
                    item.setHoninBirthYMD(entity.get本人生年月日());
                    item.setHoninJusho(entity.get本人住所());
                    item.setHoninName(entity.get本人名称());
                    item.setHoninNameKana(entity.get本人名称カナ());
                    item.setHoninRenrakuSaki1(entity.get本人連絡先１());
                    item.setHoninRenrakuSaki2(entity.get本人連絡先２());
                    item.setHoninSeibetsu(entity.get本人性別());
                    item.setHoninShotokuDankaiHenko(entity.get本人所得段階変更());
                    item.setHoninTokuchoGimusha(entity.get本人特徴義務者());
                    item.setHoninTokuchoTaishoNenkin(entity.get本人特徴対象年金());
                    item.setHoninyubinNo(entity.get本人郵便番号());
                    item.setHyojicode1(entity.get表示コード１());
                    item.setHyojicode2(entity.get表示コード２());
                    item.setHyojicode3(entity.get表示コード３());
                    item.setHyojicodeName1(entity.get表示コード名称１());
                    item.setHyojicodeName2(entity.get表示コード名称２());
                    item.setHyojicodeName3(entity.get表示コード名称３());
                    item.setJukyuJoho(entity.get受給情報());
                    item.setKazeiHikazei(entity.get課税区分());
                    item.setKozaNo(entity.get口座NO());
                    item.setKozaShurui(entity.get口座種類());
                    item.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後所得段階().get_4月分所得段階());
                    item.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正後所得段階().get_5月分所得段階());
                    item.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正後所得段階().get_6月分所得段階());
                    item.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正後所得段階().get_7月分所得段階());
                    item.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正後所得段階().get_8月分所得段階());
                    item.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正後所得段階().get_9月分所得段階());
                    item.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正後所得段階().get_9月分所得段階());
                    item.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正後所得段階().get_10月分所得段階());
                    item.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正後所得段階().get_11月分所得段階());
                    item.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正後所得段階().get_1月分所得段階());
                    item.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正後所得段階().get_2月分所得段階());
                    item.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正後所得段階().get_3月分所得段階());
                    item.setListFutsuChoshu_10(entity.get普通徴収収入額().get普徴金額５());
                    item.setListFutsuChoshu_11(entity.get普通徴収収入額().get普徴金額６());
                    item.setListFutsuChoshu_12(entity.get普通徴収収入額().get普徴金額７());
                    item.setListFutsuChoshu_13(entity.get普通徴収収入額().get普徴金額８());
                    item.setListFutsuChoshu_14(entity.get普通徴収収入額().get普徴金額９());
                    item.setListFutsuChoshu_15(entity.get普通徴収収入額().get普徴金額１０());
                    item.setListFutsuChoshu_16(entity.get普通徴収収入額().get普徴金額１１());
                    item.setListFutsuChoshu_17(entity.get普通徴収収入額().get普徴金額１２());
                    item.setListFutsuChoshu_18(entity.get普通徴収収入額().get普徴金額１３());
                    item.setListFutsuChoshu_19(entity.get普通徴収収入額().get普徴金額１４());
                    item.setListFutsuChoshu_20(entity.get普通徴収収入額().get調整額歳出還付());
                    item.setListFutsuChoshu_6(entity.get普通徴収収入額().get普徴金額１());
                    item.setListFutsuChoshu_7(entity.get普通徴収収入額().get普徴金額２());
                    item.setListFutsuChoshu_8(entity.get普通徴収収入額().get普徴金額３());
                    item.setListFutsuChoshu_9(entity.get普通徴収収入額().get普徴金額４());
                    item.setListTokuChoshu_10(entity.get特別徴収収入額().get特徴金額５());
                    item.setListTokuChoshu_11(entity.get特別徴収収入額().get特徴金額６());
                    item.setListTokuChoshu_12(entity.get特別徴収収入額().get特徴金額７());
                    item.setListTokuChoshu_13(entity.get特別徴収収入額().get特徴金額８());
                    item.setListTokuChoshu_14(entity.get特別徴収収入額().get特徴金額９());
                    item.setListTokuChoshu_15(entity.get特別徴収収入額().get特徴金額１０());
                    item.setListTokuChoshu_16(entity.get特別徴収収入額().get特徴金額１１());
                    item.setListTokuChoshu_17(entity.get特別徴収収入額().get特徴金額１２());
                    item.setListTokuChoshu_18(entity.get特別徴収収入額().get特徴金額１３());
                    item.setListTokuChoshu_19(entity.get特別徴収収入額().get特徴金額１４());
                    item.setListTokuChoshu_20(entity.get特別徴収収入額().get調整額歳出還付());
                    item.setListTokuChoshu_6(entity.get特別徴収収入額().get特徴金額１());
                    item.setListTokuChoshu_7(entity.get特別徴収収入額().get特徴金額２());
                    item.setListTokuChoshu_8(entity.get特別徴収収入額().get特徴金額３());
                    item.setListTokuChoshu_9(entity.get特別徴収収入額().get特徴金額４());

                    FukaDaichoItem item2 = new FukaDaichoItem();
                    item2.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正前().get本人合計所得金額());
                    item2.setListFukaUchiwake1_2(entity.get本算定賦課内訳１更正前().get本人公的年金収入額());
                    item2.setListFukaUchiwake1_3(entity.get本算定賦課内訳１更正前().get本人課税区分());
                    item2.setListFukaUchiwake1_4(entity.get本算定賦課内訳１更正前().get世帯課税区分());
                    item2.setListFukaUchiwake1_5(entity.get本算定賦課内訳１更正前().get本人算出保険料額());
                    item2.setListFukaUchiwake1_6(entity.get本算定賦課内訳１更正前().get本人減免額());
                    item2.setListFukaUchiwake1_7(entity.get本算定賦課内訳１更正前().get確定年額保険料());
                    item2.setListFukaUchiwake1_8(entity.get本算定賦課内訳１更正前().get賦課基準日());
                    item2.setListFukaUchiwake1_9(entity.get本算定賦課内訳１更正前().get調定年月日());
                    item2.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正前年額保険料().get_4月分保険料額());
                    item2.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正前年額保険料().get_1月分保険料額());
                    item2.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正前年額保険料().get_2月分保険料額());
                    item2.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正前年額保険料().get_3月分保険料額());
                    item2.setListFukaUchiwake2_13(entity.get本算定賦課内訳２更正前年額保険料().get_12ヶ月分年度加算額());
                    item2.setListFukaUchiwake2_14(entity.get本算定賦課内訳２更正前年額保険料().get公式());
                    item2.setListFukaUchiwake2_15(entity.get本算定賦課内訳２更正前年額保険料().get月割年額保険料額());
                    item2.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正前年額保険料().get_5月分保険料額());
                    item2.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正前年額保険料().get_6月分保険料額());
                    item2.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正前年額保険料().get_7月分保険料額());
                    item2.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正前年額保険料().get_8月分保険料額());
                    item2.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正前年額保険料().get_9月分保険料額());
                    item2.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正前年額保険料().get_10月分保険料額());
                    item2.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正前年額保険料().get_11月分保険料額());
                    item2.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正前年額保険料().get_12月分保険料額());
                    item2.setListFutsuChoshu_1(entity.get普通徴収更正前().get普徴調定月());
                    item2.setListFutsuChoshu_10(entity.get普通徴収更正前().get普徴金額５());
                    item2.setListFutsuChoshu_11(entity.get普通徴収更正前().get普徴金額６());
                    item2.setListFutsuChoshu_12(entity.get普通徴収更正前().get普徴金額７());
                    item2.setListFutsuChoshu_13(entity.get普通徴収更正前().get普徴金額８());
                    item2.setListFutsuChoshu_14(entity.get普通徴収更正前().get普徴金額９());
                    item2.setListFutsuChoshu_15(entity.get普通徴収更正前().get普徴金額１０());
                    item2.setListFutsuChoshu_16(entity.get普通徴収更正前().get普徴金額１１());
                    item2.setListFutsuChoshu_17(entity.get普通徴収更正前().get普徴金額１２());
                    item2.setListFutsuChoshu_18(entity.get普通徴収更正前().get普徴金額１３());
                    item2.setListFutsuChoshu_19(entity.get普通徴収更正前().get普徴金額１４());
                    item2.setListFutsuChoshu_2(entity.get普通徴収更正前().get普徴調定月の期());
                    item2.setListFutsuChoshu_20(entity.get普通徴収更正前().get調整額歳出還付());
                    item2.setListFutsuChoshu_3(entity.get普通徴収更正前().get普徴確定年額保険料());
                    item2.setListFutsuChoshu_4(entity.get普通徴収更正前().get普徴納付済額());
                    item2.setListFutsuChoshu_5(entity.get普通徴収更正前().get普徴今後納付すべき額());
                    item2.setListFutsuChoshu_6(entity.get普通徴収更正前().get普徴金額１());
                    item2.setListFutsuChoshu_7(entity.get普通徴収更正前().get普徴金額２());
                    item2.setListFutsuChoshu_8(entity.get普通徴収更正前().get普徴金額３());
                    item2.setListFutsuChoshu_9(entity.get普通徴収更正前().get普徴金額４());
                    item2.setListHonin1_1(entity.get本人更正前().get本人資格取得日());
                    item2.setListHonin1_2(entity.get本人更正前().get本人取得事由());
                    item2.setListHonin1_3(entity.get本人更正前().get本人資格喪失日());
                    item2.setListHonin1_4(entity.get本人更正前().get本人喪失事由());
                    item2.setListHonin1_6(entity.get本人更正前().get本人生活保護開始年月日());
                    item2.setListHonin1_7(entity.get本人更正前().get本人生活保護終了年月日());
                    item2.setListHonin1_8(entity.get本人更正前().get本人老齢年金開始年月日());
                    item2.setListHonin1_9(entity.get本人更正前().get本人老齢年金終了年月日());
                    item2.setListHonin2_1(entity.get本人更正前().get本人識別コード());
                    item2.setListHonin2_2(entity.get本人更正前().get本人氏名());
                    item2.setListHonin2_3(entity.get本人更正前().get本人性別());
                    item2.setListHonin2_4(entity.get本人更正前().get本人生年月日());
                    item2.setListHonin2_5(entity.get本人更正前().get本人続柄());
                    item2.setListTokuChoshu_1(entity.get特別徴収更正前().get特徴調定月());
                    item2.setListTokuChoshu_10(entity.get特別徴収更正前().get特徴金額５());
                    item2.setListTokuChoshu_11(entity.get特別徴収更正前().get特徴金額６());
                    item2.setListTokuChoshu_12(entity.get特別徴収更正前().get特徴金額７());
                    item2.setListTokuChoshu_13(entity.get特別徴収更正前().get特徴金額８());
                    item2.setListTokuChoshu_14(entity.get特別徴収更正前().get特徴金額９());
                    item2.setListTokuChoshu_15(entity.get特別徴収更正前().get特徴金額１０());
                    item2.setListTokuChoshu_16(entity.get特別徴収更正前().get特徴金額１１());
                    item2.setListTokuChoshu_17(entity.get特別徴収更正前().get特徴金額１２());
                    item2.setListTokuChoshu_18(entity.get特別徴収更正前().get特徴金額１３());
                    item2.setListTokuChoshu_19(entity.get特別徴収更正前().get特徴金額１４());
                    item2.setListTokuChoshu_20(entity.get特別徴収更正前().get調整額歳出還付());
                    item2.setListTokuChoshu_2(entity.get特別徴収更正前().get特徴調定月の期());
                    item2.setListTokuChoshu_3(entity.get特別徴収更正前().get特徴確定年額保険料());
                    item2.setListTokuChoshu_4(entity.get特別徴収更正前().get特徴納付済額());
                    item2.setListTokuChoshu_5(entity.get特別徴収更正前().get特徴今後納付すべき額());
                    item2.setListTokuChoshu_6(entity.get特別徴収更正前().get特徴金額１());
                    item2.setListTokuChoshu_7(entity.get特別徴収更正前().get特徴金額２());
                    item2.setListTokuChoshu_8(entity.get特別徴収更正前().get特徴金額３());
                    item2.setListTokuChoshu_9(entity.get特別徴収更正前().get特徴金額４());
                    item2.setListTokuchoKi_1(entity.get特徴期().get特徴期１());
                    item2.setListTokuchoKi_10(entity.get特徴期().get特徴期１０());
                    item2.setListTokuchoKi_11(entity.get特徴期().get特徴期１１());
                    item2.setListTokuchoKi_12(entity.get特徴期().get特徴期１２());
                    item2.setListTokuchoKi_13(entity.get特徴期().get特徴期１３());
                    item2.setListTokuchoKi_14(entity.get特徴期().get特徴期１４());
                    item2.setListTokuchoKi_2(entity.get特徴期().get特徴期２());
                    item2.setListTokuchoKi_3(entity.get特徴期().get特徴期３());
                    item2.setListTokuchoKi_4(entity.get特徴期().get特徴期４());
                    item2.setListTokuchoKi_5(entity.get特徴期().get特徴期５());
                    item2.setListTokuchoKi_6(entity.get特徴期().get特徴期６());
                    item2.setListTokuchoKi_7(entity.get特徴期().get特徴期７());
                    item2.setListTokuchoKi_8(entity.get特徴期().get特徴期８());
                    item2.setListTokuchoKi_9(entity.get特徴期().get特徴期９());
                    item2.setListTokuchoTsuki_1(entity.get特徴月().get特徴月１());
                    item2.setListTokuchoTsuki_10(entity.get特徴月().get特徴月１０());
                    item2.setListTokuchoTsuki_11(entity.get特徴月().get特徴月１１());
                    item2.setListTokuchoTsuki_12(entity.get特徴月().get特徴月１２());
                    item2.setListTokuchoTsuki_13(entity.get特徴月().get特徴月１３());
                    item2.setListTokuchoTsuki_14(entity.get特徴月().get特徴月１４());
                    item2.setListTokuchoTsuki_2(entity.get特徴月().get特徴月２());
                    item2.setListTokuchoTsuki_3(entity.get特徴月().get特徴月３());
                    item2.setListTokuchoTsuki_4(entity.get特徴月().get特徴月４());
                    item2.setListTokuchoTsuki_5(entity.get特徴月().get特徴月５());
                    item2.setListTokuchoTsuki_6(entity.get特徴月().get特徴月６());
                    item2.setListTokuchoTsuki_7(entity.get特徴月().get特徴月７());
                    item2.setListTokuchoTsuki_8(entity.get特徴月().get特徴月８());
                    item2.setListTokuchoTsuki_9(entity.get特徴月().get特徴月９());
                    item2.setListFuchoKi_1(entity.get普徴期().get普徴期１());
                    item2.setListFuchoKi_2(entity.get普徴期().get普徴期２());
                    item2.setListFuchoKi_3(entity.get普徴期().get普徴期３());
                    item2.setListFuchoKi_4(entity.get普徴期().get普徴期４());
                    item2.setListFuchoKi_5(entity.get普徴期().get普徴期５());
                    item2.setListFuchoKi_6(entity.get普徴期().get普徴期６());
                    item2.setListFuchoKi_7(entity.get普徴期().get普徴期７());
                    item2.setListFuchoKi_8(entity.get普徴期().get普徴期８());
                    item2.setListFuchoKi_9(entity.get普徴期().get普徴期９());
                    item2.setListFuchoKi_10(entity.get普徴期().get普徴期１０());
                    item2.setListFuchoKi_11(entity.get普徴期().get普徴期１１());
                    item2.setListFuchoKi_12(entity.get普徴期().get普徴期１２());
                    item2.setListFuchoKi_13(entity.get普徴期().get普徴期１３());
                    item2.setListFuchoKi_14(entity.get普徴期().get普徴期１４());
                    item2.setListFuchoTsuki_1(entity.get普徴月().get普徴月１());
                    item2.setListFuchoTsuki_2(entity.get普徴月().get普徴月２());
                    item2.setListFuchoTsuki_3(entity.get普徴月().get普徴月３());
                    item2.setListFuchoTsuki_4(entity.get普徴月().get普徴月４());
                    item2.setListFuchoTsuki_5(entity.get普徴月().get普徴月５());
                    item2.setListFuchoTsuki_6(entity.get普徴月().get普徴月６());
                    item2.setListFuchoTsuki_7(entity.get普徴月().get普徴月７());
                    item2.setListFuchoTsuki_8(entity.get普徴月().get普徴月８());
                    item2.setListFuchoTsuki_9(entity.get普徴月().get普徴月９());
                    item2.setListFuchoTsuki_10(entity.get普徴月().get普徴月１０());
                    item2.setListFuchoTsuki_11(entity.get普徴月().get普徴月１１());
                    item2.setListFuchoTsuki_12(entity.get普徴月().get普徴月１２());
                    item2.setListFuchoTsuki_13(entity.get普徴月().get普徴月１３());
                    item2.setListFuchoTsuki_14(entity.get普徴月().get普徴月１４());
                    item2.setListFuchoZuiji_1(entity.get普徴随時().get普徴随時１());
                    item2.setListFuchoZuiji_2(entity.get普徴随時().get普徴随時２());
                    item2.setListFuchoZuiji_3(entity.get普徴随時().get普徴随時３());
                    item2.setListFuchoZuiji_4(entity.get普徴随時().get普徴随時４());
                    item2.setListFuchoZuiji_5(entity.get普徴随時().get普徴随時５());
                    item2.setListFuchoZuiji_6(entity.get普徴随時().get普徴随時６());
                    item2.setListFuchoZuiji_7(entity.get普徴随時().get普徴随時７());
                    item2.setListFuchoZuiji_8(entity.get普徴随時().get普徴随時８());
                    item2.setListFuchoZuiji_9(entity.get普徴随時().get普徴随時９());
                    item2.setListFuchoZuiji_10(entity.get普徴随時().get普徴随時１０());
                    item2.setListFuchoZuiji_11(entity.get普徴随時().get普徴随時１１());
                    item2.setListFuchoZuiji_12(entity.get普徴随時().get普徴随時１２());
                    item2.setListFuchoZuiji_13(entity.get普徴随時().get普徴随時１３());
                    item2.setListFuchoZuiji_14(entity.get普徴随時().get普徴随時１４());

                    FukaDaichoItem item3 = new FukaDaichoItem();
                    item3.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正後().get本人合計所得金額());
                    item3.setListFukaUchiwake1_2(entity.get本算定賦課内訳１更正後().get本人公的年金収入額());
                    item3.setListFukaUchiwake1_3(entity.get本算定賦課内訳１更正後().get本人課税区分());
                    item3.setListFukaUchiwake1_4(entity.get本算定賦課内訳１更正後().get世帯課税区分());
                    item3.setListFukaUchiwake1_5(entity.get本算定賦課内訳１更正後().get本人算出保険料額());
                    item3.setListFukaUchiwake1_6(entity.get本算定賦課内訳１更正後().get本人減免額());
                    item3.setListFukaUchiwake1_7(entity.get本算定賦課内訳１更正後().get確定年額保険料());
                    item3.setListFukaUchiwake1_8(entity.get本算定賦課内訳１更正後().get賦課基準日());
                    item3.setListFukaUchiwake1_9(entity.get本算定賦課内訳１更正後().get調定年月日());
                    item3.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正後().get本人合計所得金額());
                    item3.setListFukaUchiwake1_2(entity.get本算定賦課内訳１更正後().get本人公的年金収入額());
                    item3.setListFukaUchiwake1_5(entity.get本算定賦課内訳１更正後().get本人算出保険料額());
                    item3.setListFukaUchiwake1_6(entity.get本算定賦課内訳１更正後().get本人減免額());
                    item3.setListFukaUchiwake1_7(entity.get本算定賦課内訳１更正後().get確定年額保険料());
                    item3.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後所得段階().get_4月分所得段階());
                    item3.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正後所得段階().get_5月分所得段階());
                    item3.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正後所得段階().get_6月分所得段階());
                    item3.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正後所得段階().get_7月分所得段階());
                    item3.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正後所得段階().get_8月分所得段階());
                    item3.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正後所得段階().get_9月分所得段階());
                    item3.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正後所得段階().get_9月分所得段階());
                    item3.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正後所得段階().get_10月分所得段階());
                    item3.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正後所得段階().get_11月分所得段階());
                    item3.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正後所得段階().get_1月分所得段階());
                    item3.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正後所得段階().get_2月分所得段階());
                    item3.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正後所得段階().get_3月分所得段階());
                    item3.setListFutsuChoshu_1(entity.get普通徴収更正後().get普徴調定月());
                    item3.setListFutsuChoshu_10(entity.get普通徴収更正後().get普徴金額５());
                    item3.setListFutsuChoshu_11(entity.get普通徴収更正後().get普徴金額６());
                    item3.setListFutsuChoshu_12(entity.get普通徴収更正後().get普徴金額７());
                    item3.setListFutsuChoshu_13(entity.get普通徴収更正後().get普徴金額８());
                    item3.setListFutsuChoshu_14(entity.get普通徴収更正後().get普徴金額９());
                    item3.setListFutsuChoshu_15(entity.get普通徴収更正後().get普徴金額１０());
                    item3.setListFutsuChoshu_16(entity.get普通徴収更正後().get普徴金額１１());
                    item3.setListFutsuChoshu_17(entity.get普通徴収更正後().get普徴金額１２());
                    item3.setListFutsuChoshu_18(entity.get普通徴収更正後().get普徴金額１３());
                    item3.setListFutsuChoshu_19(entity.get普通徴収更正後().get普徴金額１４());
                    item3.setListFutsuChoshu_2(entity.get普通徴収更正後().get普徴調定月の期());
                    item3.setListFutsuChoshu_20(entity.get普通徴収更正後().get調整額歳出還付());
                    item3.setListFutsuChoshu_3(entity.get普通徴収更正後().get普徴確定年額保険料());
                    item3.setListFutsuChoshu_4(entity.get普通徴収更正後().get普徴納付済額());
                    item3.setListFutsuChoshu_5(entity.get普通徴収更正後().get普徴今後納付すべき額());
                    item3.setListFutsuChoshu_6(entity.get普通徴収更正後().get普徴金額１());
                    item3.setListFutsuChoshu_7(entity.get普通徴収更正後().get普徴金額２());
                    item3.setListFutsuChoshu_8(entity.get普通徴収更正後().get普徴金額３());
                    item3.setListFutsuChoshu_9(entity.get普通徴収更正後().get普徴金額４());
                    item3.setListHonin1_1(entity.get本人更正後().get本人資格取得日());
                    item3.setListHonin1_2(entity.get本人更正後().get本人取得事由());
                    item3.setListHonin1_3(entity.get本人更正後().get本人資格喪失日());
                    item3.setListHonin1_4(entity.get本人更正後().get本人喪失事由());
                    item3.setListHonin1_5(entity.get本人更正後().get本人住所地特例());
                    item3.setListHonin1_6(entity.get本人更正後().get本人生活保護開始年月日());
                    item3.setListHonin1_7(entity.get本人更正後().get本人生活保護終了年月日());
                    item3.setListHonin1_8(entity.get本人更正後().get本人老齢年金開始年月日());
                    item3.setListHonin1_9(entity.get本人更正後().get本人老齢年金終了年月日());
                    item3.setListHonin1_10(entity.get本人更正後().get本人限界層該当開始年月日());
                    item3.setListHonin1_11(entity.get本人更正後().get本人限界層該当終了年月日());
                    item3.setListHonin2_1(entity.get本人更正後().get本人識別コード());
                    item3.setListHonin2_2(entity.get本人更正後().get本人氏名());
                    item3.setListHonin2_3(entity.get本人更正後().get本人性別());
                    item3.setListHonin2_4(entity.get本人更正後().get本人生年月日());
                    item3.setListHonin2_5(entity.get本人更正後().get本人続柄());
                    item3.setListTokuChoshu_1(entity.get特別徴収更正後().get特徴調定月());
                    item3.setListTokuChoshu_10(entity.get特別徴収更正後().get特徴金額５());
                    item3.setListTokuChoshu_11(entity.get特別徴収更正後().get特徴金額６());
                    item3.setListTokuChoshu_12(entity.get特別徴収更正後().get特徴金額７());
                    item3.setListTokuChoshu_13(entity.get特別徴収更正後().get特徴金額８());
                    item3.setListTokuChoshu_14(entity.get特別徴収更正後().get特徴金額９());
                    item3.setListTokuChoshu_15(entity.get特別徴収更正後().get特徴金額１０());
                    item3.setListTokuChoshu_16(entity.get特別徴収更正後().get特徴金額１１());
                    item3.setListTokuChoshu_17(entity.get特別徴収更正後().get特徴金額１２());
                    item3.setListTokuChoshu_18(entity.get特別徴収更正後().get特徴金額１３());
                    item3.setListTokuChoshu_19(entity.get特別徴収更正後().get特徴金額１４());
                    item3.setListTokuChoshu_20(entity.get特別徴収更正後().get調整額歳出還付());
                    item3.setListTokuChoshu_2(entity.get特別徴収更正後().get特徴調定月の期());
                    item3.setListTokuChoshu_3(entity.get特別徴収更正後().get特徴確定年額保険料());
                    item3.setListTokuChoshu_4(entity.get特別徴収更正後().get特徴納付済額());
                    item3.setListTokuChoshu_5(entity.get特別徴収更正後().get特徴今後納付すべき額());
                    item3.setListTokuChoshu_6(entity.get特別徴収更正後().get特徴金額１());
                    item3.setListTokuChoshu_7(entity.get特別徴収更正後().get特徴金額２());
                    item3.setListTokuChoshu_8(entity.get特別徴収更正後().get特徴金額３());
                    item3.setListTokuChoshu_9(entity.get特別徴収更正後().get特徴金額４());

                    FukaDaichoItem item4 = new FukaDaichoItem();
                    item4.setListFukaUchiwake1_1(entity.get本算定賦課内訳１増減額().get本人合計所得金額());
                    item4.setListFukaUchiwake1_2(entity.get本算定賦課内訳１増減額().get本人公的年金収入額());
                    item4.setListFukaUchiwake1_5(entity.get本算定賦課内訳１増減額().get本人算出保険料額());
                    item4.setListFukaUchiwake1_6(entity.get本算定賦課内訳１増減額().get本人減免額());
                    item4.setListFukaUchiwake1_7(entity.get本算定賦課内訳１増減額().get確定年額保険料());
                    item4.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後年額保険料().get_4月分保険料額());
                    item4.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正後年額保険料().get_1月分保険料額());
                    item4.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正後年額保険料().get_2月分保険料額());
                    item4.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正後年額保険料().get_3月分保険料額());
                    item4.setListFukaUchiwake2_13(entity.get本算定賦課内訳２更正後年額保険料().get_12ヶ月分年度加算額());
                    item4.setListFukaUchiwake2_14(entity.get本算定賦課内訳２更正後年額保険料().get公式());
                    item4.setListFukaUchiwake2_15(entity.get本算定賦課内訳２更正後年額保険料().get月割年額保険料額());
                    item4.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正後年額保険料().get_5月分保険料額());
                    item4.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正後年額保険料().get_6月分保険料額());
                    item4.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正後年額保険料().get_7月分保険料額());
                    item4.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正後年額保険料().get_8月分保険料額());
                    item4.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正後年額保険料().get_9月分保険料額());
                    item4.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正後年額保険料().get_10月分保険料額());
                    item4.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正後年額保険料().get_11月分保険料額());
                    item4.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正後年額保険料().get_12月分保険料額());
                    item4.setListFutsuChoshu_1(entity.get普通徴収増減額().get普徴調定月());
                    item4.setListFutsuChoshu_10(entity.get普通徴収増減額().get普徴金額５());
                    item4.setListFutsuChoshu_11(entity.get普通徴収増減額().get普徴金額６());
                    item4.setListFutsuChoshu_12(entity.get普通徴収増減額().get普徴金額７());
                    item4.setListFutsuChoshu_13(entity.get普通徴収増減額().get普徴金額８());
                    item4.setListFutsuChoshu_14(entity.get普通徴収増減額().get普徴金額９());
                    item4.setListFutsuChoshu_15(entity.get普通徴収増減額().get普徴金額１０());
                    item4.setListFutsuChoshu_16(entity.get普通徴収増減額().get普徴金額１１());
                    item4.setListFutsuChoshu_17(entity.get普通徴収増減額().get普徴金額１２());
                    item4.setListFutsuChoshu_18(entity.get普通徴収増減額().get普徴金額１３());
                    item4.setListFutsuChoshu_19(entity.get普通徴収増減額().get普徴金額１４());
                    item4.setListFutsuChoshu_2(entity.get普通徴収増減額().get普徴調定月の期());
                    item4.setListFutsuChoshu_20(entity.get普通徴収増減額().get調整額歳出還付());
                    item4.setListFutsuChoshu_3(entity.get普通徴収増減額().get調整額歳出還付());
                    item4.setListFutsuChoshu_4(entity.get普通徴収増減額().get調整額歳出還付());
                    item4.setListFutsuChoshu_5(entity.get普通徴収増減額().get普徴確定年額保険料());
                    item4.setListFutsuChoshu_6(entity.get普通徴収増減額().get普徴納付済額());
                    item4.setListFutsuChoshu_7(entity.get普通徴収増減額().get普徴今後納付すべき額());
                    item4.setListFutsuChoshu_8(entity.get普通徴収増減額().get普徴金額３());
                    item4.setListFutsuChoshu_9(entity.get普通徴収増減額().get普徴金額４());
                    item4.setListTokuChoshu_1(entity.get特別徴収増減額().get特徴調定月());
                    item4.setListTokuChoshu_10(entity.get特別徴収増減額().get特徴金額５());
                    item4.setListTokuChoshu_11(entity.get特別徴収増減額().get特徴金額６());
                    item4.setListTokuChoshu_12(entity.get特別徴収増減額().get特徴金額７());
                    item4.setListTokuChoshu_13(entity.get特別徴収増減額().get特徴金額８());
                    item4.setListTokuChoshu_14(entity.get特別徴収増減額().get特徴金額９());
                    item4.setListTokuChoshu_15(entity.get特別徴収増減額().get特徴金額１０());
                    item4.setListTokuChoshu_16(entity.get特別徴収増減額().get特徴金額１１());
                    item4.setListTokuChoshu_17(entity.get特別徴収増減額().get特徴金額１２());
                    item4.setListTokuChoshu_18(entity.get特別徴収増減額().get特徴金額１３());
                    item4.setListTokuChoshu_19(entity.get特別徴収増減額().get特徴金額１４());
                    item4.setListTokuChoshu_20(entity.get特別徴収増減額().get調整額歳出還付());
                    item4.setListTokuChoshu_2(entity.get特別徴収増減額().get特徴調定月の期());
                    item4.setListTokuChoshu_3(entity.get特別徴収増減額().get特徴確定年額保険料());
                    item4.setListTokuChoshu_4(entity.get特別徴収増減額().get特徴納付済額());
                    item4.setListTokuChoshu_5(entity.get特別徴収増減額().get特徴今後納付すべき額());
                    item4.setListTokuChoshu_6(entity.get特別徴収増減額().get特徴金額１());
                    item4.setListTokuChoshu_7(entity.get特別徴収増減額().get特徴金額２());
                    item4.setListTokuChoshu_8(entity.get特別徴収増減額().get特徴金額３());
                    item4.setListTokuChoshu_9(entity.get特別徴収増減額().get特徴金額４());

                    if (entity.get世帯員情報リスト().size() > 0) {
                        item2.setListSetaiin_1(entity.get世帯員情報リスト().get(0).get世帯員識別コード());
                        item2.setListSetaiin_2(entity.get世帯員情報リスト().get(0).get世帯員氏名());
                        item2.setListSetaiin_3(entity.get世帯員情報リスト().get(0).get世帯員性別());
                        item2.setListSetaiin_4(entity.get世帯員情報リスト().get(0).get世帯員生年月日());
                        item2.setListSetaiin_5(entity.get世帯員情報リスト().get(0).get世帯員続柄());
                        item2.setListSetaiin_6(entity.get世帯員情報リスト().get(0).get世帯員合計取得金額());
                        item2.setListSetaiin_7(entity.get世帯員情報リスト().get(0).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 1) {
                        item2.setListSetaiin_8(entity.get世帯員情報リスト().get(1).get世帯員識別コード());
                        item2.setListSetaiin_9(entity.get世帯員情報リスト().get(1).get世帯員氏名());
                        item2.setListSetaiin_10(entity.get世帯員情報リスト().get(1).get世帯員性別());
                        item2.setListSetaiin_11(entity.get世帯員情報リスト().get(1).get世帯員生年月日());
                        item2.setListSetaiin_12(entity.get世帯員情報リスト().get(1).get世帯員続柄());
                        item2.setListSetaiin_13(entity.get世帯員情報リスト().get(1).get世帯員合計取得金額());
                        item2.setListSetaiin_14(entity.get世帯員情報リスト().get(1).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 2) {
                        item3.setListSetaiin_1(entity.get世帯員情報リスト().get(2).get世帯員識別コード());
                        item3.setListSetaiin_2(entity.get世帯員情報リスト().get(2).get世帯員氏名());
                        item3.setListSetaiin_3(entity.get世帯員情報リスト().get(2).get世帯員性別());
                        item3.setListSetaiin_4(entity.get世帯員情報リスト().get(2).get世帯員生年月日());
                        item3.setListSetaiin_5(entity.get世帯員情報リスト().get(2).get世帯員続柄());
                        item3.setListSetaiin_6(entity.get世帯員情報リスト().get(2).get世帯員合計取得金額());
                        item3.setListSetaiin_7(entity.get世帯員情報リスト().get(2).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 3) {
                        item3.setListSetaiin_8(entity.get世帯員情報リスト().get(3).get世帯員識別コード());
                        item3.setListSetaiin_9(entity.get世帯員情報リスト().get(3).get世帯員氏名());
                        item3.setListSetaiin_10(entity.get世帯員情報リスト().get(3).get世帯員性別());
                        item3.setListSetaiin_11(entity.get世帯員情報リスト().get(3).get世帯員生年月日());
                        item3.setListSetaiin_12(entity.get世帯員情報リスト().get(3).get世帯員続柄());
                        item3.setListSetaiin_13(entity.get世帯員情報リスト().get(3).get世帯員合計取得金額());
                        item3.setListSetaiin_14(entity.get世帯員情報リスト().get(3).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 4) {
                        item4.setListSetaiin_1(entity.get世帯員情報リスト().get(4).get世帯員識別コード());
                        item4.setListSetaiin_2(entity.get世帯員情報リスト().get(4).get世帯員氏名());
                        item4.setListSetaiin_3(entity.get世帯員情報リスト().get(4).get世帯員性別());
                        item4.setListSetaiin_4(entity.get世帯員情報リスト().get(4).get世帯員生年月日());
                        item4.setListSetaiin_5(entity.get世帯員情報リスト().get(4).get世帯員続柄());
                        item4.setListSetaiin_6(entity.get世帯員情報リスト().get(4).get世帯員合計取得金額());
                        item4.setListSetaiin_7(entity.get世帯員情報リスト().get(4).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 5) {
                        item4.setListSetaiin_8(entity.get世帯員情報リスト().get(5).get世帯員識別コード());
                        item4.setListSetaiin_9(entity.get世帯員情報リスト().get(5).get世帯員氏名());
                        item4.setListSetaiin_10(entity.get世帯員情報リスト().get(5).get世帯員性別());
                        item4.setListSetaiin_11(entity.get世帯員情報リスト().get(5).get世帯員生年月日());
                        item4.setListSetaiin_12(entity.get世帯員情報リスト().get(5).get世帯員続柄());
                        item4.setListSetaiin_13(entity.get世帯員情報リスト().get(5).get世帯員合計取得金額());
                        item4.setListSetaiin_14(entity.get世帯員情報リスト().get(5).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 6) {
                        item.setListSetaiin_1(entity.get世帯員情報リスト().get(6).get世帯員識別コード());
                        item.setListSetaiin_2(entity.get世帯員情報リスト().get(6).get世帯員氏名());
                        item.setListSetaiin_3(entity.get世帯員情報リスト().get(6).get世帯員性別());
                        item.setListSetaiin_4(entity.get世帯員情報リスト().get(6).get世帯員生年月日());
                        item.setListSetaiin_5(entity.get世帯員情報リスト().get(6).get世帯員続柄());
                        item.setListSetaiin_6(entity.get世帯員情報リスト().get(6).get世帯員合計取得金額());
                        item.setListSetaiin_7(entity.get世帯員情報リスト().get(6).get世帯員課税区分());
                    }
                    if (entity.get世帯員情報リスト().size() > 7) {
                        item.setListSetaiin_8(entity.get世帯員情報リスト().get(7).get世帯員識別コード());
                        item.setListSetaiin_9(entity.get世帯員情報リスト().get(7).get世帯員氏名());
                        item.setListSetaiin_10(entity.get世帯員情報リスト().get(7).get世帯員性別());
                        item.setListSetaiin_11(entity.get世帯員情報リスト().get(7).get世帯員生年月日());
                        item.setListSetaiin_12(entity.get世帯員情報リスト().get(7).get世帯員続柄());
                        item.setListSetaiin_13(entity.get世帯員情報リスト().get(7).get世帯員合計取得金額());
                        item.setListSetaiin_14(entity.get世帯員情報リスト().get(7).get世帯員課税区分());
                    }
                    item.setPageNo(new RString(new Integer(pageNow).toString()));
                    item.setPageNoAll(new RString(pageAll.toString()));
                    item.setPrintTimeStamp(entity.get印刷日時());
                    item.setSetaiCode(entity.get世帯コード());
                    item.setTitle(entity.getタイトル());
                    item.setTsuchishoNo(entity.get通知書NO());

                    targets.add(item2);
                    targets.add(item3);
                    targets.add(item4);
                    targets.add(item);
                } else {
                    int start = (pageNow - 1) * 8;
                    int end = Math.min(entity.get世帯員情報リスト().size(), pageNow * 8 - 1);
                    for (int i = start; i < end; i++) {
                        FukaDaichoItem newRecord = new FukaDaichoItem();
                        newRecord.setTitle(entity.getタイトル());
                        newRecord.setChoteiNendo(entity.get調定年度());
                        newRecord.setFukaNendo(entity.get賦課年度());
                        newRecord.setPrintTimeStamp(entity.get印刷日時());
                        newRecord.setPageNo(new RString(new Integer(pageNow).toString()));
                        newRecord.setPageNoAll(new RString(pageAll.toString()));
                        newRecord.setHokenshaNo(entity.get保険者番号().value());
                        newRecord.setHokenshaName(entity.get保険者名称());
                        newRecord.setTsuchishoNo(entity.get通知書NO());
                        newRecord.setHihokenshaNo(entity.get被保険者番号().value());
                        newRecord.setSetaiCode(entity.get世帯コード());
                        newRecord.setListSetaiin_1(entity.get世帯員情報リスト().get(i).get世帯員識別コード());
                        newRecord.setListSetaiin_2(entity.get世帯員情報リスト().get(i).get世帯員氏名());
                        newRecord.setListSetaiin_3(entity.get世帯員情報リスト().get(i).get世帯員性別());
                        newRecord.setListSetaiin_4(entity.get世帯員情報リスト().get(i).get世帯員生年月日());
                        newRecord.setListSetaiin_5(entity.get世帯員情報リスト().get(i).get世帯員続柄());
                        newRecord.setListSetaiin_6(entity.get世帯員情報リスト().get(i).get世帯員合計取得金額());
                        newRecord.setListSetaiin_7(entity.get世帯員情報リスト().get(i).get世帯員課税区分());
                        if (entity.get世帯員情報リスト().size() > ++i) {
                            newRecord.setListSetaiin_8(entity.get世帯員情報リスト().get(i).get世帯員識別コード());
                            newRecord.setListSetaiin_9(entity.get世帯員情報リスト().get(i).get世帯員氏名());
                            newRecord.setListSetaiin_10(entity.get世帯員情報リスト().get(i).get世帯員性別());
                            newRecord.setListSetaiin_11(entity.get世帯員情報リスト().get(i).get世帯員生年月日());
                            newRecord.setListSetaiin_12(entity.get世帯員情報リスト().get(i).get世帯員続柄());
                            newRecord.setListSetaiin_13(entity.get世帯員情報リスト().get(i).get世帯員合計取得金額());
                            newRecord.setListSetaiin_14(entity.get世帯員情報リスト().get(i).get世帯員課税区分());
                        }
                        targets.add(newRecord);
                    }
                }
            }
        } else {
            FukaDaichoItem item = new FukaDaichoItem();
            targets.add(item);
        }

        return targets;
    }
}
