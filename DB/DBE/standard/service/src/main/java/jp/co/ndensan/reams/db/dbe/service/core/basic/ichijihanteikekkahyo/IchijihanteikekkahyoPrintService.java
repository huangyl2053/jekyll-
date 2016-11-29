/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ichijihanteikekkahyo;

import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijihanteikekkahyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo.IchijihanteikekkahyoReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 一次判定データ出力PrintServiceです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijihanteikekkahyoPrintService {

    /**
     * 事務局用一次判定結果票A4を印刷します。
     *
     * @param data IchijihanteikekkahyoA4Data
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(IchijihanteikekkahyoBusiness data) {
        IchijihanteikekkahyoProperty property = new IchijihanteikekkahyoProperty();
        return new Printer<IchijihanteikekkahyoReportSource>().spool(property, toReports(getEntity(data)));
    }

    private static IchijihanteikekkahyoReport toReports(IchijihanteikekkahyoEntity item) {
        return new IchijihanteikekkahyoReport(item);
    }

    private IchijihanteikekkahyoEntity getEntity(IchijihanteikekkahyoBusiness data) {
        IchijihanteikekkahyoEntity entity = new IchijihanteikekkahyoEntity();
        entity.setタイトル(data.getタイトル());
        entity.set作成日_元号(data.get作成日_元号());
        entity.set作成日_年(data.get作成日_年());
        entity.set作成日_月(data.get作成日_月());
        entity.set作成日_日(data.get作成日_日());
        entity.set申請日_元号(data.get申請日_元号());
        entity.set申請日_年(data.get申請日_年());
        entity.set申請日_月(data.get申請日_月());
        entity.set申請日_日(data.get申請日_日());
        entity.set調査日_元号(data.get調査日_元号());
        entity.set調査日_年(data.get調査日_年());
        entity.set調査日_月(data.get調査日_月());
        entity.set調査日_日(data.get調査日_日());
        entity.set審査日_元号(data.get審査日_元号());
        entity.set審査日_年(data.get審査日_年());
        entity.set審査日_月(data.get審査日_月());
        entity.set審査日_日(data.get審査日_日());
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
        entity.set氏名(data.get氏名());
        entity.set被保険者番号(data.get被保険者番号());
        entity.set保険者番号(data.get保険者番号());
        entity.set所属(data.get所属());
        entity.set市町村名(data.get市町村名());
        entity.set事業者番号(data.get事業者番号());
        entity.set事業者名(data.get事業者名());
        entity.set認定調査員番号(data.get認定調査員番号());
        entity.set認定調査員氏名(data.get認定調査員氏名());
        entity.set認定調査員資格(data.get認定調査員資格());
        entity.set医療機関番号(data.get医療機関番号());
        entity.set医療機関名称(data.get医療機関名称());
        entity.set主治医番号(data.get主治医番号());
        entity.set主治医氏名(data.get主治医氏名());
        entity.set一次判定結果(data.get一次判定結果());
        entity.set二次判定結果(data.get二次判定結果());
        entity.set認定有効期間(data.get認定有効期間());
        entity.set認定有効期間開始年月日(data.get認定有効期間開始年月日());
        entity.set認定有効期間終了年月日(data.get認定有効期間終了年月日());
        entity.set特定疾病名(data.get特定疾病名());
        entity.set状態像名称(data.get状態像名称());
        entity.set要介護認定等基準時間(data.get要介護認定等基準時間());
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
        entity.set中間評価項目得点第1群(data.get中間評価項目得点第1群());
        entity.set中間評価項目得点第2群(data.get中間評価項目得点第2群());
        entity.set中間評価項目得点第3群(data.get中間評価項目得点第3群());
        entity.set中間評価項目得点第4群(data.get中間評価項目得点第4群());
        entity.set中間評価項目得点第5群(data.get中間評価項目得点第5群());
        entity.set高齢者自立度リスト(data.get高齢者自立度リスト());
        entity.set認定調査結果認知症高齢者自立度(data.get認定調査結果認知症高齢者自立度());
        entity.set意見書認知症高齢者自立度(data.get意見書認知症高齢者自立度());
        entity.set認知症自立度Ⅱ以上の蓋然性(data.get認知症自立度Ⅱ以上の蓋然性());
        entity.set状態の安定性(data.get状態の安定性());
        entity.set給付区分(data.get給付区分());
        entity.set現在のサービス利用状況名(data.get現在のサービス利用状況名());
//        entity.set現在のサービス状況(data.get現在のサービス状況());
        entity.set主治医意見書項目1リスト(data.get主治医意見書項目1リスト());
        entity.set主治医意見書項目2リスト(data.get主治医意見書項目2リスト());
        entity.set主治医意見書項目3リスト(data.get主治医意見書項目3リスト());
        entity.set主治医意見書項目4リスト(data.get主治医意見書項目4リスト());
        entity.set身体機能_起居動作リスト(data.get身体機能_起居動作リスト());
        entity.set生活機能リスト(data.get生活機能リスト());
        entity.set認知機能リスト(data.get認知機能リスト());
        entity.set精神_行動障害リスト(data.get精神_行動障害リスト());
        entity.set社会生活への適応リスト(data.get社会生活への適応リスト());
        entity.set特別な医療1リスト(data.get特別な医療1リスト());
        entity.set特別な医療2リスト(data.get特別な医療2リスト());
        entity.set日常生活自立度リスト(data.get日常生活自立度リスト());
        entity.set身体機能_起居動作1リスト(data.get身体機能_起居動作1リスト());
        entity.set身体機能_起居動作2リスト(data.get身体機能_起居動作2リスト());
        entity.set身体機能_起居動作3リスト(data.get身体機能_起居動作3リスト());
        entity.set身体機能_起居動作4リスト(data.get身体機能_起居動作4リスト());
        entity.set生活機能1リスト(data.get生活機能1リスト());
        entity.set生活機能2リスト(data.get生活機能2リスト());
        entity.set生活機能3リスト(data.get生活機能3リスト());
        entity.set生活機能4リスト(data.get生活機能4リスト());
        entity.set認知機能1リスト(data.get認知機能1リスト());
        entity.set認知機能2リスト(data.get認知機能2リスト());
        entity.set認知機能3リスト(data.get認知機能3リスト());
        entity.set認知機能4リスト(data.get認知機能4リスト());
        entity.set精神_行動障害1リスト(data.get精神_行動障害1リスト());
        entity.set精神_行動障害2リスト(data.get精神_行動障害2リスト());
        entity.set精神_行動障害3リスト(data.get精神_行動障害3リスト());
        entity.set精神_行動障害4リスト(data.get精神_行動障害4リスト());
        entity.set社会生活への適応1リスト(data.get社会生活への適応1リスト());
        entity.set社会生活への適応2リスト(data.get社会生活への適応2リスト());
        entity.set社会生活への適応3リスト(data.get社会生活への適応3リスト());
        entity.set社会生活への適応4リスト(data.get社会生活への適応4リスト());
        entity.set特別な医療3_1リスト(data.get特別な医療3_1リスト());
        entity.set特別な医療3_2リスト(data.get特別な医療3_2リスト());
        entity.set特別な医療4_1リスト(data.get特別な医療4_1リスト());
        entity.set特別な医療4_2リスト(data.get特別な医療4_2リスト());
        entity.set厚労省IF識別コード(data.get厚労省IF識別コード());
        return entity;
    }
}
