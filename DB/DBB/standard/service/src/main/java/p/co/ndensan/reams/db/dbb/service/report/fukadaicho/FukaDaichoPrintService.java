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
 *賦課台帳（本算定）帳票PrintService
 */
public class FukaDaichoPrintService {
    
    public SourceDataCollection print(EditedHonSanteiFukaDaichoJoho entity) {
        FukaDaichoProperty property = new FukaDaichoProperty();
        List<FukaDaichoItem> targets =  setItems(entity);
        return new Printer<FukaDaichoSource>().spool(property, toReports(targets));
    }
    
    private static List<FukaDaichoReport> toReports(List<FukaDaichoItem> targets) {
        List<FukaDaichoReport> list = new ArrayList<>();
        list.add(FukaDaichoReport.createForm(targets));
        return list;
    }
    
    private List<FukaDaichoItem> setItems(EditedHonSanteiFukaDaichoJoho entity) {
        List<FukaDaichoItem> targets = new ArrayList<>();
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
        item.setHyojicode2(entity.get表示コード３());
        item.setHyojicodeName1(entity.get表示コード名称１());
        item.setHyojicodeName2(entity.get表示コード名称２());
        item.setHyojicodeName3(entity.get表示コード名称３());
        item.setJukyuJoho(entity.get受給情報());
        item.setKazeiHikazei(entity.get課税区分());
        item.setKozaNo(entity.get口座NO());
        item.setKozaShurui(entity.get口座種類());
        item.setListFuchoKi_1(entity.get普徴期().get普徴期１());
        item.setListFuchoKi_2(entity.get普徴期().get普徴期２());
        item.setListFuchoKi_3(entity.get普徴期().get普徴期３());
        item.setListFuchoKi_4(entity.get普徴期().get普徴期４());
        item.setListFuchoKi_5(entity.get普徴期().get普徴期５());
        item.setListFuchoKi_6(entity.get普徴期().get普徴期６());
        item.setListFuchoKi_7(entity.get普徴期().get普徴期７());
        item.setListFuchoKi_8(entity.get普徴期().get普徴期８());
        item.setListFuchoKi_9(entity.get普徴期().get普徴期９());
        item.setListFuchoKi_10(entity.get普徴期().get普徴期１０());
        item.setListFuchoKi_11(entity.get普徴期().get普徴期１１());
        item.setListFuchoKi_12(entity.get普徴期().get普徴期１２());
        item.setListFuchoKi_13(entity.get普徴期().get普徴期１３());
        item.setListFuchoKi_14(entity.get普徴期().get普徴期１４());
        item.setListFuchoTsuki_1(entity.get普徴月().get普徴月１());
        item.setListFuchoTsuki_2(entity.get普徴月().get普徴月２());
        item.setListFuchoTsuki_3(entity.get普徴月().get普徴月３());
        item.setListFuchoTsuki_4(entity.get普徴月().get普徴月４());
        item.setListFuchoTsuki_5(entity.get普徴月().get普徴月５());
        item.setListFuchoTsuki_6(entity.get普徴月().get普徴月６());
        item.setListFuchoTsuki_7(entity.get普徴月().get普徴月７());
        item.setListFuchoTsuki_8(entity.get普徴月().get普徴月８());
        item.setListFuchoTsuki_9(entity.get普徴月().get普徴月９());
        item.setListFuchoTsuki_10(entity.get普徴月().get普徴月１０());
        item.setListFuchoTsuki_11(entity.get普徴月().get普徴月１１());
        item.setListFuchoTsuki_12(entity.get普徴月().get普徴月１２());
        item.setListFuchoTsuki_13(entity.get普徴月().get普徴月１３());
        item.setListFuchoTsuki_14(entity.get普徴月().get普徴月１４());
        item.setListFuchoZuiji_1(entity.get普徴随時().get普徴随時１());
        item.setListFuchoZuiji_2(entity.get普徴随時().get普徴随時２());
        item.setListFuchoZuiji_3(entity.get普徴随時().get普徴随時３());
        item.setListFuchoZuiji_4(entity.get普徴随時().get普徴随時４());
        item.setListFuchoZuiji_5(entity.get普徴随時().get普徴随時５());
        item.setListFuchoZuiji_6(entity.get普徴随時().get普徴随時６());
        item.setListFuchoZuiji_7(entity.get普徴随時().get普徴随時７());
        item.setListFuchoZuiji_8(entity.get普徴随時().get普徴随時８());
        item.setListFuchoZuiji_9(entity.get普徴随時().get普徴随時９());
        item.setListFuchoZuiji_10(entity.get普徴随時().get普徴随時１０());
        item.setListFuchoZuiji_11(entity.get普徴随時().get普徴随時１１());
        item.setListFuchoZuiji_12(entity.get普徴随時().get普徴随時１２());
        item.setListFuchoZuiji_13(entity.get普徴随時().get普徴随時１３());
        item.setListFuchoZuiji_14(entity.get普徴随時().get普徴随時１４());

        //TODO  本人合計所得金額
        item.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正前().get本人合計所得金額());
        FukaDaichoItem 本人合計所得金額更正後 = new FukaDaichoItem();
        本人合計所得金額更正後.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正後().get本人合計所得金額());
        targets.add(本人合計所得金額更正後);
        FukaDaichoItem 本人合計所得金額増減額 = new FukaDaichoItem();
        本人合計所得金額増減額.setListFukaUchiwake1_1(entity.get本算定賦課内訳１増減額().get本人合計所得金額());
        targets.add(本人合計所得金額増減額);

        item.setListFukaUchiwake1_2(entity.get本算定賦課内訳１更正前().get本人公的年金収入額());
        item.setListFukaUchiwake1_3(entity.get本算定賦課内訳１更正前().get本人課税区分());
        item.setListFukaUchiwake1_4(entity.get本算定賦課内訳１更正前().get世帯課税区分());
        item.setListFukaUchiwake1_5(entity.get本算定賦課内訳１更正前().get本人算出保険料額());
        item.setListFukaUchiwake1_6(entity.get本算定賦課内訳１更正前().get本人減免額());
        item.setListFukaUchiwake1_7(entity.get本算定賦課内訳１更正前().get確定年額保険料());
        item.setListFukaUchiwake1_8(entity.get本算定賦課内訳１更正前().get賦課基準日());
        item.setListFukaUchiwake1_9(entity.get本算定賦課内訳１更正前().get調定年月日());

        //TODO  4月分保険料額
        item.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正前年額保険料().get_4月分保険料額());
        FukaDaichoItem _4月分保険料額更正前所得段階 = new FukaDaichoItem();
        _4月分保険料額更正前所得段階.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正前所得段階().get_4月分所得段階());
        targets.add(_4月分保険料額更正前所得段階);
        FukaDaichoItem _4月分保険料額更正後年額保険料 = new FukaDaichoItem();
        _4月分保険料額更正後年額保険料.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後年額保険料().get_4月分保険料額());
        targets.add(_4月分保険料額更正後年額保険料);
        FukaDaichoItem _4月分保険料額更正後所得段階 = new FukaDaichoItem();
        _4月分保険料額更正後所得段階.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後所得段階().get_4月分所得段階());
        targets.add(_4月分保険料額更正後所得段階);

        item.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正前年額保険料().get_1月分保険料額());
        item.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正前年額保険料().get_2月分保険料額());
        item.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正前年額保険料().get_3月分保険料額());
        item.setListFukaUchiwake2_13(entity.get本算定賦課内訳２更正前年額保険料().get_12ヶ月分年度加算額());
        item.setListFukaUchiwake2_14(entity.get本算定賦課内訳２更正前年額保険料().get公式());
        item.setListFukaUchiwake2_15(entity.get本算定賦課内訳２更正前年額保険料().get月割年額保険料額());
        item.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正前年額保険料().get_5月分保険料額());
        item.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正前年額保険料().get_6月分保険料額());
        item.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正前年額保険料().get_7月分保険料額());
        item.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正前年額保険料().get_8月分保険料額());
        item.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正前年額保険料().get_9月分保険料額());
        item.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正前年額保険料().get_10月分保険料額());
        item.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正前年額保険料().get_11月分保険料額());
        item.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正前年額保険料().get_12月分保険料額());

        //TODO 普徴調定月
        item.setListFutsuChoshu_1(entity.get普通徴収更正前().get普徴調定月());
        FukaDaichoItem 普徴調定月更正後 = new FukaDaichoItem();
        普徴調定月更正後.setListFukaUchiwake2_1(entity.get普通徴収更正後().get普徴調定月());
        targets.add(普徴調定月更正後);
        FukaDaichoItem 普徴調定月増減額 = new FukaDaichoItem();
        普徴調定月増減額.setListFukaUchiwake2_1(entity.get普通徴収増減額().get普徴調定月());
        targets.add(普徴調定月増減額);
        FukaDaichoItem 普徴調定月収入額 = new FukaDaichoItem();
        普徴調定月収入額.setListFukaUchiwake2_1(entity.get普通徴収収入額().get普徴調定月());
        targets.add(普徴調定月収入額);

        item.setListFutsuChoshu_10(entity.get普通徴収更正前().get普徴金額５());
        item.setListFutsuChoshu_11(entity.get普通徴収更正前().get普徴金額６());
        item.setListFutsuChoshu_12(entity.get普通徴収更正前().get普徴金額７());
        item.setListFutsuChoshu_13(entity.get普通徴収更正前().get普徴金額８());
        item.setListFutsuChoshu_14(entity.get普通徴収更正前().get普徴金額９());
        item.setListFutsuChoshu_15(entity.get普通徴収更正前().get普徴金額１０());
        item.setListFutsuChoshu_16(entity.get普通徴収更正前().get普徴金額１１());
        item.setListFutsuChoshu_17(entity.get普通徴収更正前().get普徴金額１２());
        item.setListFutsuChoshu_18(entity.get普通徴収更正前().get普徴金額１３());
        item.setListFutsuChoshu_19(entity.get普通徴収更正前().get普徴金額１４());
        item.setListFutsuChoshu_2(entity.get普通徴収更正前().get普徴調定月の期());
        item.setListFutsuChoshu_20(entity.get普通徴収更正前().get調整額歳出還付());
        item.setListFutsuChoshu_3(entity.get普通徴収更正前().get普徴確定年額保険料());
        item.setListFutsuChoshu_4(entity.get普通徴収更正前().get普徴納付済額());
        item.setListFutsuChoshu_5(entity.get普通徴収更正前().get普徴今後納付すべき額());
        item.setListFutsuChoshu_6(entity.get普通徴収更正前().get普徴金額１());
        item.setListFutsuChoshu_7(entity.get普通徴収更正前().get普徴金額２());
        item.setListFutsuChoshu_8(entity.get普通徴収更正前().get普徴金額３());
        item.setListFutsuChoshu_9(entity.get普通徴収更正前().get普徴金額４());

        //TODO
        item.setListHonin1_1(entity.get本人更正前().get本人資格取得日());
        FukaDaichoItem 本人更正後 = new FukaDaichoItem();
        本人更正後.setListFukaUchiwake2_1(entity.get本人更正後().get本人資格取得日());
        targets.add(本人更正後);

        item.setListHonin1_10(entity.get本人更正前().get本人限界層該当開始年月日());
        item.setListHonin1_11(entity.get本人更正前().get本人限界層該当終了年月日());
        item.setListHonin1_2(entity.get本人更正前().get本人取得事由());
        item.setListHonin1_3(entity.get本人更正前().get本人資格喪失日());
        item.setListHonin1_4(entity.get本人更正前().get本人喪失事由());
        item.setListHonin1_5(entity.get本人更正前().get本人住所地特例());
        item.setListHonin1_6(entity.get本人更正前().get本人生活保護開始年月日());
        item.setListHonin1_7(entity.get本人更正前().get本人生活保護終了年月日());
        item.setListHonin1_8(entity.get本人更正前().get本人老齢年金開始年月日());
        item.setListHonin1_9(entity.get本人更正前().get本人老齢年金終了年月日());
        item.setListHonin2_1(entity.get本人更正前().get本人識別コード());
        item.setListHonin2_2(entity.get本人更正前().get本人氏名());
        item.setListHonin2_3(entity.get本人更正前().get本人性別());
        item.setListHonin2_4(entity.get本人更正前().get本人生年月日());
        item.setListHonin2_5(entity.get本人更正前().get本人続柄());

        //TODO 世帯員
        for (int i = 0; i < entity.get世帯員情報リスト().size(); i++) {
            FukaDaichoItem 世帯員情報 = new FukaDaichoItem();
            世帯員情報.setListSetaiin_1(entity.get世帯員情報リスト().get(i).get世帯員識別コード());
            世帯員情報.setListSetaiin_10(entity.get世帯員情報リスト().get(i).get世帯員性別());
            世帯員情報.setListSetaiin_11(entity.get世帯員情報リスト().get(i).get世帯員生年月日());
            世帯員情報.setListSetaiin_12(entity.get世帯員情報リスト().get(i).get世帯員続柄());
            世帯員情報.setListSetaiin_13(entity.get世帯員情報リスト().get(i).get世帯員合計取得金額());
            世帯員情報.setListSetaiin_14(entity.get世帯員情報リスト().get(i).get世帯員課税区分());
            世帯員情報.setListSetaiin_2(entity.get世帯員情報リスト().get(i).get世帯員氏名());
            if (++i < entity.get世帯員情報リスト().size()) {
                世帯員情報.setListSetaiin_3(entity.get世帯員情報リスト().get(i).get世帯員性別());
                世帯員情報.setListSetaiin_4(entity.get世帯員情報リスト().get(i).get世帯員生年月日());
                世帯員情報.setListSetaiin_5(entity.get世帯員情報リスト().get(i).get世帯員続柄());
                世帯員情報.setListSetaiin_6(entity.get世帯員情報リスト().get(i).get世帯員合計取得金額());
                世帯員情報.setListSetaiin_7(entity.get世帯員情報リスト().get(i).get世帯員課税区分());
                世帯員情報.setListSetaiin_8(entity.get世帯員情報リスト().get(i).get世帯員識別コード());
                世帯員情報.setListSetaiin_8(entity.get世帯員情報リスト().get(i).get世帯員氏名());
                
            }
            targets.add(世帯員情報);
        }

        //TODO 特徴調定月
        item.setListTokuChoshu_1(entity.get特別徴収更正前().get特徴調定月());
        FukaDaichoItem 特別徴収更正後 = new FukaDaichoItem();
        特別徴収更正後.setListFukaUchiwake2_1(entity.get特別徴収更正後().get特徴調定月());
        targets.add(特別徴収更正後);
        FukaDaichoItem 特別徴収増減額 = new FukaDaichoItem();
        特別徴収増減額.setListFukaUchiwake2_1(entity.get特別徴収増減額().get特徴調定月());
        targets.add(特別徴収増減額);
        FukaDaichoItem 特別徴収収入額 = new FukaDaichoItem();
        特別徴収収入額.setListFukaUchiwake2_1(entity.get特別徴収収入額().get特徴調定月());
        targets.add(特別徴収収入額);

        item.setListTokuChoshu_10(entity.get特別徴収更正前().get特徴金額５());
        item.setListTokuChoshu_11(entity.get特別徴収更正前().get特徴金額６());
        item.setListTokuChoshu_12(entity.get特別徴収更正前().get特徴金額７());
        item.setListTokuChoshu_13(entity.get特別徴収更正前().get特徴金額８());
        item.setListTokuChoshu_14(entity.get特別徴収更正前().get特徴金額９());
        item.setListTokuChoshu_15(entity.get特別徴収更正前().get特徴金額１０());
        item.setListTokuChoshu_16(entity.get特別徴収更正前().get特徴金額１１());
        item.setListTokuChoshu_17(entity.get特別徴収更正前().get特徴金額１２());
        item.setListTokuChoshu_18(entity.get特別徴収更正前().get特徴金額１３());
        item.setListTokuChoshu_19(entity.get特別徴収更正前().get特徴金額１４());
        item.setListTokuChoshu_20(entity.get特別徴収更正前().get調整額歳出還付());
        item.setListTokuChoshu_3(entity.get特別徴収更正前().get特徴確定年額保険料());
        item.setListTokuChoshu_4(entity.get特別徴収更正前().get特徴納付済額());
        item.setListTokuChoshu_5(entity.get特別徴収更正前().get特徴今後納付すべき額());
        item.setListTokuChoshu_6(entity.get特別徴収更正前().get特徴金額１());
        item.setListTokuChoshu_7(entity.get特別徴収更正前().get特徴金額２());
        item.setListTokuChoshu_8(entity.get特別徴収更正前().get特徴金額３());
        item.setListTokuChoshu_9(entity.get特別徴収更正前().get特徴金額４());
        item.setListTokuchoKi_1(entity.get特徴期().get特徴期１());
        item.setListTokuchoKi_10(entity.get特徴期().get特徴期１０());
        item.setListTokuchoKi_11(entity.get特徴期().get特徴期１１());
        item.setListTokuchoKi_12(entity.get特徴期().get特徴期１２());
        item.setListTokuchoKi_13(entity.get特徴期().get特徴期１３());
        item.setListTokuchoKi_14(entity.get特徴期().get特徴期１４());
        item.setListTokuchoKi_2(entity.get特徴期().get特徴期２());
        item.setListTokuchoKi_3(entity.get特徴期().get特徴期３());
        item.setListTokuchoKi_4(entity.get特徴期().get特徴期４());
        item.setListTokuchoKi_5(entity.get特徴期().get特徴期５());
        item.setListTokuchoKi_6(entity.get特徴期().get特徴期６());
        item.setListTokuchoKi_7(entity.get特徴期().get特徴期７());
        item.setListTokuchoKi_8(entity.get特徴期().get特徴期８());
        item.setListTokuchoKi_9(entity.get特徴期().get特徴期９());
        item.setListTokuchoTsuki_1(entity.get特徴月().get特徴月１());
        item.setListTokuchoTsuki_10(entity.get特徴月().get特徴月１０());
        item.setListTokuchoTsuki_11(entity.get特徴月().get特徴月１１());
        item.setListTokuchoTsuki_12(entity.get特徴月().get特徴月１２());
        item.setListTokuchoTsuki_13(entity.get特徴月().get特徴月１３());
        item.setListTokuchoTsuki_14(entity.get特徴月().get特徴月１４());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月２());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月３());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月４());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月５());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月６());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月７());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月８());
        item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月９());

        //TODO ページ数 総ページ数
        item.setPageNo(new RString("1"));
        Integer pageNoAll = entity.get世帯員情報リスト().size() / 8 + 1;
        item.setPageNoAll(new RString(pageNoAll.toString()));

        item.setPrintTimeStamp(entity.get印刷日時());
        item.setSetaiCode(entity.get世帯コード());
        item.setTitle(entity.getタイトル());
        item.setTsuchishoNo(entity.get通知書NO());

        
        return targets;
    }
}
