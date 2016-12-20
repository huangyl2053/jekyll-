/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.jimukyokuyouichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.business.core.jimukyokuyouichijihanteikekkahyoa4.IchijihanteikekkahyoA4Data;
import jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4.IchijihanteikekkahyoA4Property;
import jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4.IchijihanteikekkahyoA4Report;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 事務局用一次判定結果票A4のPrintServiceクラスです。
 *
 * @reamsid_L DBE-0150-400 lishengli
 */
public class IchijihanteikekkahyoA4PrintService {

    /**
     * 事務局用一次判定結果票A4を印刷します。
     *
     * @param data IchijihanteikekkahyoA4Data
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(IchijihanteikekkahyoA4Data data) {
        IchijihanteikekkahyoA4Property property = new IchijihanteikekkahyoA4Property();
        return new Printer<IchijihanteikekkahyoReportSource>().spool(property, toReports(getEntity(data)));
    }

    private static IchijihanteikekkahyoA4Report toReports(IchijihanteikekkahyoA4Entity item) {
        return new IchijihanteikekkahyoA4Report(item);
    }

    private IchijihanteikekkahyoA4Entity getEntity(IchijihanteikekkahyoA4Data data) {
        IchijihanteikekkahyoA4Entity entity = new IchijihanteikekkahyoA4Entity();
        entity.set合議体番号(data.get合議体番号());
        entity.set審査順(data.get審査順());
        entity.set被保険者区分(data.get被保険者区分());
        entity.set申請区分(data.get申請区分());
        entity.set年齢(data.get年齢());
        entity.set性別(data.get性別());
        entity.set現在の状況(data.get現在の状況());
        entity.set前々回要介護度(data.get前々回要介護度());
        entity.set前々回認定有効期間(data.get前々回認定有効期間());
        entity.set前々回認定有効期間開始年月日(data.get前々回認定有効期間開始年月日());
        entity.set前々回認定有効期間終了年月日(data.get前々回認定有効期間終了年月日());
        entity.set前回要介護度(data.get前回要介護度());
        entity.set前回認定有効期間(data.get前回認定有効期間());
        entity.set前回認定有効期間開始年月日(data.get前回認定有効期間開始年月日());
        entity.set前回認定有効期間終了年月日(data.get前回認定有効期間終了年月日());
        entity.set前回認定日(data.get前回認定日());
        entity.set前回状態像(data.get前回状態像());
        entity.set管理番号(data.get管理番号());
        entity.set審査会資料作成年月日(data.get審査会資料作成年月日());
        entity.set今回認定申請年月日(data.get今回認定申請年月日());
        entity.set今回認定調査実施年月日(data.get今回認定調査実施年月日());
        entity.set今回認定審査年月日(data.get今回認定審査年月日());
        entity.set被保険者氏名(data.get被保険者氏名());
        entity.set被保険者番号(data.get被保険者番号());
        entity.set保険者番号(data.get保険者番号());
        entity.set支所名(data.get支所名());
        entity.set市町村名(data.get市町村名());
        entity.set事業者番号(data.get事業者番号());
        entity.set事業者名(data.get事業者名());
        entity.set認定調査員番号(data.get認定調査員番号());
        entity.set認定調査員氏名(data.get認定調査員氏名());
        entity.set調査員資格(data.get調査員資格());
        entity.set医療機関番号(data.get医療機関番号());
        entity.set医療機関名称(data.get医療機関名称());
        entity.set主治医番号(data.get主治医番号());
        entity.set主治医氏名(data.get主治医氏名());
        entity.set一次判定結果(data.get一次判定結果());
        entity.set特定疾病名(data.get特定疾病名());
        entity.set状態像名称(data.get状態像名称());
        entity.set要介護認定等基準時間(data.get要介護認定等基準時間());
        entity.set基準時間の積み上げグラフ(data.get基準時間の積み上げグラフ());
        entity.set要介護認定等基準時間_食事(data.get要介護認定等基準時間_食事());
        entity.set要介護認定等基準時間_排泄(data.get要介護認定等基準時間_排泄());
        entity.set要介護認定等基準時間_移動(data.get要介護認定等基準時間_移動());
        entity.set要介護認定等基準時間_清潔保持(data.get要介護認定等基準時間_清潔保持());
        entity.set要介護認定等基準時間_間接(data.get要介護認定等基準時間_間接());
        entity.set要介護認定等基準時間_BPSD関連(data.get要介護認定等基準時間_BPSD関連());
        entity.set要介護認定等基準時間_機能訓練(data.get要介護認定等基準時間_機能訓練());
        entity.set要介護認定等基準時間_医療関連(data.get要介護認定等基準時間_医療関連());
        entity.set要介護認定等基準時間_認知症加算(data.get要介護認定等基準時間_認知症加算());
        entity.set警告コード(data.get警告コード());
        entity.set中間評価リスト(data.get中間評価リスト());
        entity.set日常生活自立度リスト(data.get日常生活自立度リスト());
        entity.set認定調査結果認知症高齢者自立度(data.get認定調査結果認知症高齢者自立度());
        entity.set意見書認知症高齢者自立度(data.get意見書認知症高齢者自立度());
        entity.set認知症自立度Ⅱ以上の蓋然性(data.get認知症自立度Ⅱ以上の蓋然性());
        entity.set状態の安定性(data.get状態の安定性());
        entity.set給付区分(data.get給付区分());
        entity.setSabisuKubun(data.getSabisuKubun());
        entity.setSabisuName1(data.getSabisuName1());
        entity.setSabisuKaisu1(data.getSabisuKaisu1());
        entity.setSabisuName2(data.getSabisuName2());
        entity.setSabisuKaisu2(data.getSabisuKaisu1());
        entity.setSabisuName3(data.getSabisuName3());
        entity.setSabisuKaisu3(data.getSabisuKaisu1());
        entity.setSabisuName4(data.getSabisuName4());
        entity.setSabisuKaisu4(data.getSabisuKaisu1());
        entity.setSabisuName5(data.getSabisuName5());
        entity.setSabisuKaisu5(data.getSabisuKaisu1());
        entity.setSabisuName6(data.getSabisuName6());
        entity.setSabisuKaisu6(data.getSabisuKaisu1());
        entity.setSabisuName7(data.getSabisuName7());
        entity.setSabisuKaisu7(data.getSabisuKaisu1());
        entity.setSabisuName8(data.getSabisuName8());
        entity.setSabisuKaisu8(data.getSabisuKaisu1());
        entity.setSabisuName9(data.getSabisuName9());
        entity.setSabisuKaisu9(data.getSabisuKaisu1());
        entity.setSabisuName10(data.getSabisuName10());
        entity.setSabisuKaisu10(data.getSabisuKaisu1());
        entity.setSabisuName11(data.getSabisuName11());
        entity.setSabisuKaisu11(data.getSabisuKaisu1());
        entity.setSabisuName12(data.getSabisuName12());
        entity.setSabisuKaisu12(data.getSabisuKaisu1());
        entity.setSabisuName13(data.getSabisuName13());
        entity.setSabisuKaisu13(data.getSabisuKaisu1());
        entity.setSabisuName14(data.getSabisuName14());
        entity.setSabisuKaisu14(data.getSabisuKaisu1());
        entity.setSabisuName15(data.getSabisuName15());
        entity.setSabisuKaisu15(data.getSabisuKaisu1());
        entity.setSabisuName16(data.getSabisuName16());
        entity.setSabisuKaisu16(data.getSabisuKaisu1());
        entity.setSabisuName17(data.getSabisuName17());
        entity.setSabisuKaisu17(data.getSabisuKaisu1());
        entity.setSabisuName18(data.getSabisuName18());
        entity.setSabisuKaisu18(data.getSabisuKaisu1());
        entity.setSabisuName19(data.getSabisuName19());
        entity.setSabisuKaisu19(data.getSabisuKaisu1());
        entity.setSabisuName20(data.getSabisuName20());
        entity.setSabisuKaisu20(data.getSabisuKaisu1());
        entity.setSabisuName21(data.getSabisuName21());
        entity.setSabisuKaisu21(data.getSabisuKaisu1());
        entity.set特記リスト１(data.get特記リスト１());
        entity.set第１群リスト(data.get第１群リスト());
        entity.set特記リスト２(data.get特記リスト２());
        entity.set第２群リスト(data.get第２群リスト());
        entity.set特記リスト３(data.get特記リスト３());
        entity.set第３群リスト(data.get第３群リスト());
        entity.set特記リスト４(data.get特記リスト４());
        entity.set第４群リスト(data.get第４群リスト());
        entity.set特記リスト５(data.get特記リスト５());
        entity.set第５群リスト(data.get第５群リスト());
        entity.set特記リスト６(data.get特記リスト６());
        entity.set特別な医療リスト１(data.get特別な医療リスト１());
        entity.set特記リスト７(data.get特記リスト７());
        entity.set特別な医療リスト２(data.get特別な医療リスト２());
        entity.set主治医意見書(data.get主治医意見書());
        entity.set申請書管理番号(data.get申請書管理番号());
        return entity;
    }
}
