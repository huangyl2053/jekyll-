/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa3;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用一次判定結果票A3のReportです。
 *
 * @reamsid_L DBE-0150-130 lishengli
 */
public class IchijihanteikekkahyoA3Report extends Report<IchijihanteikekkahyoA3ReportSource> {

    private final IchijihanteikekkahyoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 委員用一次判定結果票Entity
     */
    public IchijihanteikekkahyoA3Report(IchijihanteikekkahyoItem item) {
        this.item = item;
    }

    /**
     * 委員用一次判定結果票A3を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IchijihanteikekkahyoA3ReportSource> reportSourceWriter) {
        IIchijihanteikekkahyoA3Editor headerEditor = new IchijihanteikekkahyoA3Editor(item);
        for (IchijihanteikekkahyoA3Body body : getBodyList()) {
            IIchijihanteikekkahyoA3Editor bodyEditor = new IchijihanteikekkahyoA3BodyEditor(body);
            IIchijihanteikekkahyoA3Builder builder = new IchijihanteikekkahyoA3Builder(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<IchijihanteikekkahyoA3Body> getBodyList() {
        List<IchijihanteikekkahyoA3Body> bodyList = new ArrayList<>();
        bodyList.add(getBody1());
        bodyList.add(getBody2());
        bodyList.add(getBody3());
        bodyList.add(getBody4());
        bodyList.add(getBody5());
        bodyList.add(getBody6());
        bodyList.add(getBody7());
        bodyList.add(getBody8());
        bodyList.add(getBody9());
        bodyList.add(getBody10());
        bodyList.add(getBody11());
        bodyList.add(getBody12());
        bodyList.add(getBody13());
        bodyList.add(getBody14());
        bodyList.add(getBody15());
        bodyList.add(getBody16());
        bodyList.add(getBody17());
        bodyList.add(getBody18());
        bodyList.add(getBody19());
        bodyList.add(getBody20());
        return bodyList;
    }

    private IchijihanteikekkahyoA3Body getBody1() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListSeikatsujiritsu_1(item.get障害高齢者自立度());
        body.setListSeikatsujiritsu_2(item.get障害高齢者自立度_ある());
        body.setYobo_listYobokyufu_1(item.get介護予防訪問介護_ﾎｰﾑﾍﾙﾌﾟ_訪問型ｻｰﾋﾞｽ());
        body.setYobo_listYobokyufu1_1(item.get介護予防認知症対応型通所介護());
        body.setKaigo_listKaigokyufu_1(item.get訪問介護_ホームヘルプサービス());
        body.setKaigo_listKaigokyufu1_1(item.get認知症対応型通所介護());
        body.setListChukanhyoka_1(item.get中間評価項目得点表第1群());
        body.setListChukanhyoka_2(item.get中間評価項目得点表第2群());
        body.setListChukanhyoka_3(item.get中間評価項目得点表第3群());
        body.setListChukanhyoka_4(item.get中間評価項目得点表第4群());
        body.setListChukanhyoka_5(item.get中間評価項目得点表第5群());
        body.setListFuseigo1_1(item.get結果比較_麻痺_左_上肢());
        body.setListFuseigo3_1(item.get結果比較_意思の伝達());
        body.setListFuseigo4_1(item.get結果比較_被害的());
        body.setListFuseigo1_2(item.get調査結果_麻痺_左_上肢_ある());
        body.setListIchigun_1(item.get調査結果_麻痺_左_上肢());
        body.setListIchigun_2(get段階改善1(item.get段階改善_麻痺_左_上肢()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_麻痺_左_上肢()));
        body.setListIchigun_4(item.get前回結果_麻痺_左_上肢());
        body.setListFuseigo2_2(item.get調査結果_移乗_ある());
        body.setListNigun_1(item.get調査結果_移乗());
        body.setListNigun_2(get段階改善1(item.get段階改善_移乗()));
        body.setListNigun_3(get段階改善2(item.get段階改善_移乗()));
        body.setListNigun_4(item.get前回結果_移乗());
        body.setListFuseigo3_2(item.get調査結果_意思の伝達_ある());
        body.setListSangun_1(item.get調査結果_意思の伝達());
        body.setListSangun_2(get段階改善1(item.get段階改善_意思の伝達()));
        body.setListSangun_3(get段階改善2(item.get段階改善_意思の伝達()));
        body.setListSangun_4(item.get前回結果_意思の伝達());
        body.setListFuseigo4_2(item.get調査結果_被害的_ある());
        body.setListYongun_1(item.get調査結果_被害的());
        body.setListYongun_2(get段階改善1(item.get段階改善_被害的()));
        body.setListYongun_3(get段階改善2(item.get段階改善_被害的()));
        body.setListYongun_4(item.get前回結果_被害的());
        body.setListFuseigo5_2(item.get調査結果_薬の内服_ある());
        body.setListGogun_1(item.get調査結果_薬の内服());
        body.setListGogun_2(get段階改善1(item.get段階改善_薬の内服()));
        body.setListGogun_3(get段階改善2(item.get段階改善_薬の内服()));
        body.setListGogun_4(item.get前回結果_薬の内服());
        body.setListtokubetsunaIryo1_1(item.get調査結果_点滴の管理());
        body.setListtokubetsunaIryo1_2(item.get結果比較_点滴の管理());
        body.setListtokubetsunaIryo1_3(item.get調査結果_点滴の管理_ある());
        body.setListtokubetsunaIryo1_4(item.get段階改善_点滴の管理());
        body.setListtokubetsunaIryo2_1(item.get調査結果_気管切開の処置());
        body.setListtokubetsunaIryo2_2(item.get結果比較_気管切開の処置());
        body.setListtokubetsunaIryo2_3(item.get調査結果_気管切開の処置_ある());
        body.setListtokubetsunaIryo2_4(item.get段階改善_気管切開の処置());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody2() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListSeikatsujiritsu_1(item.get認知症高齢者自立度());
        body.setListSeikatsujiritsu_2(item.get認知症高齢者自立度_ある());
        body.setYobo_listYobokyufu_1(item.get介護予防訪問入浴介護());
        body.setYobo_listYobokyufu1_1(item.get介護予防小規模多機能型居宅介護());
        body.setKaigo_listKaigokyufu_1(item.get訪問入浴介護());
        body.setKaigo_listKaigokyufu1_1(item.get小規模多機能型居宅介護());
        body.setListChukanhyoka_1(item.get前回中間評価項目得点表第1群());
        body.setListChukanhyoka_2(item.get前回中間評価項目得点表第2群());
        body.setListChukanhyoka_3(item.get前回中間評価項目得点表第3群());
        body.setListChukanhyoka_4(item.get前回中間評価項目得点表第4群());
        body.setListChukanhyoka_5(item.get前回中間評価項目得点表第5群());
        body.setListFuseigo1_1(item.get結果比較_麻痺_右_上肢());
        body.setListFuseigo1_2(item.get調査結果_麻痺_右_上肢_ある());
        body.setListIchigun_1(item.get調査結果_麻痺_右_上肢());
        body.setListIchigun_2(get段階改善1(item.get段階改善_麻痺_右_上肢()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_麻痺_右_上肢()));
        body.setListIchigun_4(item.get前回結果_麻痺_右_上肢());
        body.setListFuseigo2_2(item.get調査結果_移動_ある());
        body.setListNigun_1(item.get調査結果_移動());
        body.setListNigun_2(get段階改善1(item.get段階改善_移動()));
        body.setListNigun_3(get段階改善2(item.get段階改善_移動()));
        body.setListNigun_4(item.get前回結果_移動());
        body.setListFuseigo3_2(item.get調査結果_毎日の日課を理解_ある());
        body.setListSangun_1(item.get調査結果_毎日の日課を理解());
        body.setListSangun_2(get段階改善1(item.get段階改善_毎日の日課を理解()));
        body.setListSangun_3(get段階改善2(item.get段階改善_毎日の日課を理解()));
        body.setListSangun_4(item.get前回結果_毎日の日課を理解());
        body.setListFuseigo4_2(item.get調査結果_作話_ある());
        body.setListYongun_1(item.get調査結果_作話());
        body.setListYongun_2(get段階改善1(item.get段階改善_作話()));
        body.setListYongun_3(get段階改善2(item.get段階改善_作話()));
        body.setListYongun_4(item.get前回結果_作話());
        body.setListFuseigo5_2(item.get調査結果_金銭の管理_ある());
        body.setListGogun_1(item.get調査結果_金銭の管理());
        body.setListGogun_2(get段階改善1(item.get段階改善_金銭の管理()));
        body.setListGogun_3(get段階改善2(item.get段階改善_金銭の管理()));
        body.setListGogun_4(item.get前回結果_金銭の管理());
        body.setListtokubetsunaIryo1_1(item.get調査結果_中心静脈栄養());
        body.setListtokubetsunaIryo1_2(item.get結果比較_中心静脈栄養());
        body.setListtokubetsunaIryo1_3(item.get調査結果_中心静脈栄養_ある());
        body.setListtokubetsunaIryo1_4(item.get段階改善_中心静脈栄養());
        body.setListtokubetsunaIryo2_1(item.get調査結果_疼痛の看護());
        body.setListtokubetsunaIryo2_2(item.get結果比較_疼痛の看護());
        body.setListtokubetsunaIryo2_3(item.get調査結果_疼痛の看護_ある());
        body.setListtokubetsunaIryo2_4(item.get段階改善_疼痛の看護());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody3() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防訪問看護());
        body.setYobo_listYobokyufu1_1(item.get介護予防認知症対応型共同生活介護_グループホーム());
        body.setKaigo_listKaigokyufu_1(item.get訪問看護());
        body.setKaigo_listKaigokyufu1_1(item.get認知症対応型共同生活介護_グループホーム());
        body.setListFuseigo1_1(item.get結果比較_麻痺_左_下肢());
        body.setListFuseigo5_1(item.get結果比較_日常の意思決定());
        body.setListFuseigo1_2(item.get調査結果_麻痺_左_下肢_ある());
        body.setListIchigun_1(item.get調査結果_麻痺_左_下肢());
        body.setListIchigun_2(get段階改善1(item.get段階改善_麻痺_左_下肢()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_麻痺_左_下肢()));
        body.setListIchigun_4(item.get前回結果_麻痺_左_下肢());
        body.setListFuseigo2_2(item.get調査結果_えん下_ある());
        body.setListNigun_1(item.get調査結果_えん下());
        body.setListNigun_2(get段階改善1(item.get段階改善_えん下()));
        body.setListNigun_3(get段階改善2(item.get段階改善_えん下()));
        body.setListNigun_4(item.get前回結果_えん下());
        body.setListFuseigo3_2(item.get調査結果_生年月日をいう_ある());
        body.setListSangun_1(item.get調査結果_生年月日をいう());
        body.setListSangun_2(get段階改善1(item.get段階改善_生年月日をいう()));
        body.setListSangun_3(get段階改善2(item.get段階改善_生年月日をいう()));
        body.setListSangun_4(item.get前回結果_生年月日をいう());
        body.setListFuseigo4_2(item.get調査結果_感情が不安定_ある());
        body.setListYongun_1(item.get調査結果_感情が不安定());
        body.setListYongun_2(get段階改善1(item.get段階改善_感情が不安定()));
        body.setListYongun_3(get段階改善2(item.get段階改善_感情が不安定()));
        body.setListYongun_4(item.get前回結果_感情が不安定());
        body.setListFuseigo5_2(item.get調査結果_日常の意思決定_ある());
        body.setListGogun_1(item.get調査結果_日常の意思決定());
        body.setListGogun_2(get段階改善1(item.get段階改善_日常の意思決定()));
        body.setListGogun_3(get段階改善2(item.get段階改善_日常の意思決定()));
        body.setListGogun_4(item.get前回結果_日常の意思決定());
        body.setListtokubetsunaIryo1_1(item.get調査結果_透析());
        body.setListtokubetsunaIryo1_2(item.get結果比較_透析());
        body.setListtokubetsunaIryo1_3(item.get調査結果_透析_ある());
        body.setListtokubetsunaIryo1_4(item.get段階改善_透析());
        body.setListtokubetsunaIryo2_1(item.get調査結果_経管栄養());
        body.setListtokubetsunaIryo2_2(item.get結果比較_経管栄養());
        body.setListtokubetsunaIryo2_3(item.get調査結果_経管栄養_ある());
        body.setListtokubetsunaIryo2_4(item.get段階改善_経管栄養());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody4() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防訪問リハビリテーション());
        body.setKaigo_listKaigokyufu_1(item.get訪問リハビリテーション());
        body.setKaigo_listKaigokyufu1_1(item.get地域密着型特定施設入居者生活介護());
        body.setListFuseigo1_1(item.get結果比較_麻痺_右_下肢());
        body.setListFuseigo2_1(item.get結果比較_食事摂取());
        body.setListFuseigo3_1(item.get結果比較_短期記憶());
        body.setListFuseigo4_1(item.get結果比較_昼夜逆転());
        body.setListFuseigo1_2(item.get調査結果_麻痺_右_下肢_ある());
        body.setListIchigun_1(item.get調査結果_麻痺_右_下肢());
        body.setListIchigun_2(get段階改善1(item.get段階改善_麻痺_右_下肢()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_麻痺_右_下肢()));
        body.setListIchigun_4(item.get前回結果_麻痺_右_下肢());
        body.setListFuseigo2_2(item.get調査結果_食事摂取_ある());
        body.setListNigun_1(item.get調査結果_食事摂取());
        body.setListNigun_2(get段階改善1(item.get段階改善_食事摂取()));
        body.setListNigun_3(get段階改善2(item.get段階改善_食事摂取()));
        body.setListNigun_4(item.get前回結果_食事摂取());
        body.setListFuseigo3_2(item.get調査結果_短期記憶_ある());
        body.setListSangun_1(item.get調査結果_短期記憶());
        body.setListSangun_2(get段階改善1(item.get段階改善_短期記憶()));
        body.setListSangun_3(get段階改善2(item.get段階改善_短期記憶()));
        body.setListSangun_4(item.get前回結果_短期記憶());
        body.setListFuseigo4_2(item.get調査結果_昼夜逆転_ある());
        body.setListYongun_1(item.get調査結果_昼夜逆転());
        body.setListYongun_2(get段階改善1(item.get段階改善_昼夜逆転()));
        body.setListYongun_3(get段階改善2(item.get段階改善_昼夜逆転()));
        body.setListYongun_4(item.get前回結果_昼夜逆転());
        body.setListFuseigo5_2(item.get調査結果_集団への不適応_ある());
        body.setListGogun_1(item.get調査結果_集団への不適応());
        body.setListGogun_2(get段階改善1(item.get段階改善_集団への不適応()));
        body.setListGogun_3(get段階改善2(item.get段階改善_集団への不適応()));
        body.setListGogun_4(item.get前回結果_集団への不適応());
        body.setListtokubetsunaIryo1_1(item.get調査結果_ストーマの処置());
        body.setListtokubetsunaIryo1_2(item.get結果比較_ストーマの処置());
        body.setListtokubetsunaIryo1_3(item.get調査結果_ストーマの処置_ある());
        body.setListtokubetsunaIryo1_4(item.get段階改善_ストーマの処置());
        body.setListtokubetsunaIryo2_1(item.get調査結果_モニター測定());
        body.setListtokubetsunaIryo2_2(item.get結果比較_モニター測定());
        body.setListtokubetsunaIryo2_3(item.get調査結果_モニター測定_ある());
        body.setListtokubetsunaIryo2_4(item.get段階改善_モニター測定());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody5() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防居宅療養管理指導());
        body.setKaigo_listKaigokyufu_1(item.get居宅療養管理指導());
        body.setKaigo_listKaigokyufu1_1(item.get地域密着型介護老人福祉施設入所者生活介護());
        body.setListFuseigo1_1(item.get結果比較_麻痺_その他());
        body.setListFuseigo1_2(item.get調査結果_麻痺_その他_ある());
        body.setListIchigun_1(item.get調査結果_麻痺_その他());
        body.setListIchigun_2(get段階改善1(item.get段階改善_麻痺_その他()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_麻痺_その他()));
        body.setListIchigun_4(item.get前回結果_麻痺_その他());
        body.setListFuseigo2_2(item.get調査結果_排尿_ある());
        body.setListNigun_1(item.get調査結果_排尿());
        body.setListNigun_2(get段階改善1(item.get段階改善_排尿()));
        body.setListNigun_3(get段階改善2(item.get段階改善_排尿()));
        body.setListNigun_4(item.get前回結果_排尿());
        body.setListFuseigo3_2(item.get調査結果_自分の名前をいう_ある());
        body.setListSangun_1(item.get調査結果_自分の名前をいう());
        body.setListSangun_2(get段階改善1(item.get段階改善_自分の名前をいう()));
        body.setListSangun_3(get段階改善2(item.get段階改善_自分の名前をいう()));
        body.setListSangun_4(item.get前回結果_自分の名前をいう());
        body.setListFuseigo4_2(item.get調査結果_同じ話をする_ある());
        body.setListYongun_1(item.get調査結果_同じ話をする());
        body.setListYongun_2(get段階改善1(item.get段階改善_同じ話をする()));
        body.setListYongun_3(get段階改善2(item.get段階改善_同じ話をする()));
        body.setListYongun_4(item.get前回結果_同じ話をする());
        body.setListFuseigo5_2(item.get調査結果_買い物_ある());
        body.setListGogun_1(item.get調査結果_買い物());
        body.setListGogun_2(get段階改善1(item.get段階改善_買い物()));
        body.setListGogun_3(get段階改善2(item.get段階改善_買い物()));
        body.setListGogun_4(item.get前回結果_買い物());
        body.setListtokubetsunaIryo1_1(item.get調査結果_酸素療法());
        body.setListtokubetsunaIryo1_2(item.get結果比較_酸素療法());
        body.setListtokubetsunaIryo1_3(item.get調査結果_酸素療法_ある());
        body.setListtokubetsunaIryo1_4(item.get段階改善_酸素療法());
        body.setListtokubetsunaIryo2_1(item.get調査結果_じょくそうの処置());
        body.setListtokubetsunaIryo2_2(item.get結果比較_じょくそうの処置());
        body.setListtokubetsunaIryo2_3(item.get調査結果_じょくそうの処置_ある());
        body.setListtokubetsunaIryo2_4(item.get段階改善_じょくそうの処置());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody6() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防通所介護_ﾃﾞｲｻｰﾋﾞｽ_通所型ｻｰﾋﾞｽ());
        body.setKaigo_listKaigokyufu_1(item.get通所介護_デイサービス());
        body.setKaigo_listKaigokyufu1_1(item.get定期巡回_随時対応型訪問介護看護());
        body.setListFuseigo1_1(item.get結果比較_拘縮_肩関節());
        body.setListFuseigo1_2(item.get調査結果_拘縮_肩関節_ある());
        body.setListIchigun_1(item.get調査結果_拘縮_肩関節());
        body.setListIchigun_2(get段階改善1(item.get段階改善_拘縮_肩関節()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_拘縮_肩関節()));
        body.setListIchigun_4(item.get前回結果_拘縮_肩関節());
        body.setListFuseigo2_2(item.get調査結果_排便_ある());
        body.setListNigun_1(item.get調査結果_排便());
        body.setListNigun_2(get段階改善1(item.get段階改善_排便()));
        body.setListNigun_3(get段階改善2(item.get段階改善_排便()));
        body.setListNigun_4(item.get前回結果_排便());
        body.setListFuseigo3_2(item.get調査結果_今の季節を理解_ある());
        body.setListSangun_1(item.get調査結果_今の季節を理解());
        body.setListSangun_2(get段階改善1(item.get段階改善_今の季節を理解()));
        body.setListSangun_3(get段階改善2(item.get段階改善_今の季節を理解()));
        body.setListSangun_4(item.get前回結果_今の季節を理解());
        body.setListFuseigo4_2(item.get調査結果_大声を出す_ある());
        body.setListYongun_1(item.get調査結果_大声を出す());
        body.setListYongun_2(get段階改善1(item.get段階改善_大声を出す()));
        body.setListYongun_3(get段階改善2(item.get段階改善_大声を出す()));
        body.setListYongun_4(item.get前回結果_大声を出す());
        body.setListFuseigo5_2(item.get調査結果_簡単な調理_ある());
        body.setListGogun_1(item.get調査結果_簡単な調理());
        body.setListGogun_2(get段階改善1(item.get段階改善_簡単な調理()));
        body.setListGogun_3(get段階改善2(item.get段階改善_簡単な調理()));
        body.setListGogun_4(item.get前回結果_簡単な調理());
        body.setListtokubetsunaIryo1_1(item.get調査結果_レスピレーター());
        body.setListtokubetsunaIryo1_2(item.get結果比較_レスピレーター());
        body.setListtokubetsunaIryo1_3(item.get調査結果_レスピレーター_ある());
        body.setListtokubetsunaIryo1_4(item.get段階改善_レスピレーター());
        body.setListtokubetsunaIryo2_1(item.get調査結果_カテーテル());
        body.setListtokubetsunaIryo2_2(item.get結果比較_カテーテル());
        body.setListtokubetsunaIryo2_3(item.get調査結果_カテーテル_ある());
        body.setListtokubetsunaIryo2_4(item.get段階改善_カテーテル());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody7() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防通所リハビリテーション());
        body.setKaigo_listKaigokyufu_1(item.get通所リハビリテーション());
        body.setKaigo_listKaigokyufu1_1(item.get看護小規模多機能型居宅介護());
        body.setListFuseigo4_1(item.get結果比較_介護に抵抗());
        body.setListFuseigo1_2(item.get調査結果_拘縮_股関節_ある());
        body.setListIchigun_1(item.get調査結果_拘縮_股関節());
        body.setListIchigun_2(get段階改善1(item.get段階改善_拘縮_股関節()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_拘縮_股関節()));
        body.setListIchigun_4(item.get前回結果_拘縮_股関節());
        body.setListFuseigo2_2(item.get調査結果_口腔清潔_ある());
        body.setListNigun_1(item.get調査結果_口腔清潔());
        body.setListNigun_2(get段階改善1(item.get段階改善_口腔清潔()));
        body.setListNigun_3(get段階改善2(item.get段階改善_口腔清潔()));
        body.setListNigun_4(item.get前回結果_口腔清潔());
        body.setListFuseigo3_2(item.get調査結果_場所の理解_ある());
        body.setListSangun_1(item.get調査結果_場所の理解());
        body.setListSangun_2(get段階改善1(item.get段階改善_場所の理解()));
        body.setListSangun_3(get段階改善2(item.get段階改善_場所の理解()));
        body.setListSangun_4(item.get前回結果_場所の理解());
        body.setListFuseigo4_2(item.get調査結果_介護に抵抗_ある());
        body.setListYongun_1(item.get調査結果_介護に抵抗());
        body.setListYongun_2(get段階改善1(item.get段階改善_介護に抵抗()));
        body.setListYongun_3(get段階改善2(item.get段階改善_介護に抵抗()));
        body.setListYongun_4(item.get前回結果_介護に抵抗());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody8() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防短期入所生活介護_ショートステイ());
        body.setKaigo_listKaigokyufu_1(item.get短期入所生活介護_ショートステイ());
        body.setListFuseigo3_1(item.get結果比較_徘徊());
        body.setListFuseigo1_2(item.get調査結果_拘縮_膝関節_ある());
        body.setListIchigun_1(item.get調査結果_拘縮_膝関節());
        body.setListIchigun_2(get段階改善1(item.get段階改善_拘縮_膝関節()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_拘縮_膝関節()));
        body.setListIchigun_4(item.get前回結果_拘縮_膝関節());
        body.setListFuseigo2_2(item.get調査結果_洗顔_ある());
        body.setListNigun_1(item.get調査結果_洗顔());
        body.setListNigun_2(get段階改善1(item.get段階改善_洗顔()));
        body.setListNigun_3(get段階改善2(item.get段階改善_洗顔()));
        body.setListNigun_4(item.get前回結果_洗顔());
        body.setListFuseigo3_2(item.get調査結果_徘徊_ある());
        body.setListSangun_1(item.get調査結果_徘徊());
        body.setListSangun_2(get段階改善1(item.get段階改善_徘徊()));
        body.setListSangun_3(get段階改善2(item.get段階改善_徘徊()));
        body.setListSangun_4(item.get前回結果_徘徊());
        body.setListFuseigo4_2(item.get調査結果_落ち着きなし_ある());
        body.setListYongun_1(item.get調査結果_落ち着きなし());
        body.setListYongun_2(get段階改善1(item.get段階改善_落ち着きなし()));
        body.setListYongun_3(get段階改善2(item.get段階改善_落ち着きなし()));
        body.setListYongun_4(item.get前回結果_落ち着きなし());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody9() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防短期入所療養介護());
        body.setKaigo_listKaigokyufu_1(item.get短期入所療養介護());
        body.setListFuseigo1_2(item.get調査結果_拘縮_その他_ある());
        body.setListIchigun_1(item.get調査結果_拘縮_その他());
        body.setListIchigun_2(get段階改善1(item.get段階改善_拘縮_その他()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_拘縮_その他()));
        body.setListIchigun_4(item.get前回結果_拘縮_その他());
        body.setListFuseigo2_2(item.get調査結果_整髪_ある());
        body.setListNigun_1(item.get調査結果_整髪());
        body.setListNigun_2(get段階改善1(item.get段階改善_整髪()));
        body.setListNigun_3(get段階改善2(item.get段階改善_整髪()));
        body.setListNigun_4(item.get前回結果_整髪());
        body.setListFuseigo3_2(item.get調査結果_外出して戻れない_ある());
        body.setListSangun_1(item.get調査結果_外出して戻れない());
        body.setListSangun_2(get段階改善1(item.get段階改善_外出して戻れない()));
        body.setListSangun_3(get段階改善2(item.get段階改善_外出して戻れない()));
        body.setListSangun_4(item.get前回結果_外出して戻れない());
        body.setListFuseigo4_2(item.get調査結果_一人で出たがる_ある());
        body.setListYongun_1(item.get調査結果_一人で出たがる());
        body.setListYongun_2(get段階改善1(item.get段階改善_一人で出たがる()));
        body.setListYongun_3(get段階改善2(item.get段階改善_一人で出たがる()));
        body.setListYongun_4(item.get前回結果_一人で出たがる());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody10() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防特定施設入居者生活介護());
        body.setKaigo_listKaigokyufu_1(item.get特定施設入居者生活介護());
        body.setListFuseigo1_2(item.get調査結果_寝返り_ある());
        body.setListIchigun_1(item.get調査結果_寝返り());
        body.setListIchigun_2(get段階改善1(item.get段階改善_寝返り()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_寝返り()));
        body.setListIchigun_4(item.get前回結果_寝返り());
        body.setListFuseigo2_2(item.get調査結果_上衣の着脱_ある());
        body.setListNigun_1(item.get調査結果_上衣の着脱());
        body.setListNigun_2(get段階改善1(item.get段階改善_上衣の着脱()));
        body.setListNigun_3(get段階改善2(item.get段階改善_上衣の着脱()));
        body.setListNigun_4(item.get前回結果_上衣の着脱());
        body.setListFuseigo4_2(item.get調査結果_収集癖_ある());
        body.setListYongun_1(item.get調査結果_収集癖());
        body.setListYongun_2(get段階改善1(item.get段階改善_収集癖()));
        body.setListYongun_3(get段階改善2(item.get段階改善_収集癖()));
        body.setListYongun_4(item.get前回結果_収集癖());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody11() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get介護予防福祉用具貸与());
        body.setKaigo_listKaigokyufu_1(item.get福祉用具貸与());
        body.setListFuseigo1_2(item.get調査結果_起き上がり_ある());
        body.setListIchigun_1(item.get調査結果_起き上がり());
        body.setListIchigun_2(get段階改善1(item.get段階改善_起き上がり()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_起き上がり()));
        body.setListIchigun_4(item.get前回結果_起き上がり());
        body.setListFuseigo2_2(item.get調査結果_ズボン等の着脱_ある());
        body.setListNigun_1(item.get調査結果_ズボン等の着脱());
        body.setListNigun_2(get段階改善1(item.get段階改善_ズボン等の着脱()));
        body.setListNigun_3(get段階改善2(item.get段階改善_ズボン等の着脱()));
        body.setListNigun_4(item.get前回結果_ズボン等の着脱());
        body.setListFuseigo4_2(item.get調査結果_物や衣類を壊す_ある());
        body.setListYongun_1(item.get調査結果_物や衣類を壊す());
        body.setListYongun_2(get段階改善1(item.get段階改善_物や衣類を壊す()));
        body.setListYongun_3(get段階改善2(item.get段階改善_物や衣類を壊す()));
        body.setListYongun_4(item.get前回結果_物や衣類を壊す());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody12() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get特定介護予防福祉用具販売());
        body.setKaigo_listKaigokyufu_1(item.get特定福祉用具販売());
        body.setListFuseigo1_2(item.get調査結果_座位保持_ある());
        body.setListIchigun_1(item.get調査結果_座位保持());
        body.setListIchigun_2(get段階改善1(item.get段階改善_座位保持()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_座位保持()));
        body.setListIchigun_4(item.get前回結果_座位保持());
        body.setListFuseigo2_2(item.get調査結果_外出頻度_ある());
        body.setListNigun_1(item.get調査結果_外出頻度());
        body.setListNigun_2(get段階改善1(item.get段階改善_外出頻度()));
        body.setListNigun_3(get段階改善2(item.get段階改善_外出頻度()));
        body.setListNigun_4(item.get前回結果_外出頻度());
        body.setListFuseigo4_2(item.get調査結果_ひどい物忘れ_ある());
        body.setListYongun_1(item.get調査結果_ひどい物忘れ());
        body.setListYongun_2(get段階改善1(item.get段階改善_ひどい物忘れ()));
        body.setListYongun_3(get段階改善2(item.get段階改善_ひどい物忘れ()));
        body.setListYongun_4(item.get前回結果_ひどい物忘れ());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody13() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setYobo_listYobokyufu_1(item.get住宅改修2());
        body.setKaigo_listKaigokyufu_1(item.get住宅改修1());
        body.setListFuseigo1_2(item.get調査結果_両足での立位_ある());
        body.setListIchigun_1(item.get調査結果_両足での立位());
        body.setListIchigun_2(get段階改善1(item.get段階改善_両足での立位()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_両足での立位()));
        body.setListIchigun_4(item.get前回結果_両足での立位());
        body.setListFuseigo4_2(item.get調査結果_独り言_独り笑い_ある());
        body.setListYongun_1(item.get調査結果_独り言_独り笑い());
        body.setListYongun_2(get段階改善1(item.get段階改善_独り言_独り笑い()));
        body.setListYongun_3(get段階改善2(item.get段階改善_独り言_独り笑い()));
        body.setListYongun_4(item.get前回結果_独り言_独り笑い());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody14() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setKaigo_listKaigokyufu_1(item.get夜間対応型訪問介護());
        body.setListFuseigo1_2(item.get調査結果_歩行_ある());
        body.setListIchigun_1(item.get調査結果_歩行());
        body.setListIchigun_2(get段階改善1(item.get段階改善_歩行()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_歩行()));
        body.setListIchigun_4(item.get前回結果_歩行());
        body.setListFuseigo4_2(item.get調査結果_歩行_ある());
        body.setListYongun_1(item.get調査結果_自分勝手に行動する());
        body.setListYongun_2(get段階改善1(item.get段階改善_自分勝手に行動する()));
        body.setListYongun_3(get段階改善2(item.get段階改善_自分勝手に行動する()));
        body.setListYongun_4(item.get前回結果_自分勝手に行動する());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody15() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListFuseigo1_2(item.get調査結果_立ち上がり_ある());
        body.setListIchigun_1(item.get調査結果_立ち上がり());
        body.setListIchigun_2(get段階改善1(item.get段階改善_立ち上がり()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_立ち上がり()));
        body.setListIchigun_4(item.get前回結果_立ち上がり());
        body.setListFuseigo4_2(item.get調査結果_話がまとまらない_ある());
        body.setListYongun_1(item.get調査結果_話がまとまらない());
        body.setListYongun_2(get段階改善1(item.get段階改善_話がまとまらない()));
        body.setListYongun_3(get段階改善2(item.get段階改善_話がまとまらない()));
        body.setListYongun_4(item.get前回結果_話がまとまらない());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody16() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListFuseigo1_2(item.get調査結果_話がまとまらない_ある());
        body.setListIchigun_1(item.get調査結果_片足での立位());
        body.setListIchigun_2(get段階改善1(item.get段階改善_片足での立位()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_片足での立位()));
        body.setListIchigun_4(item.get前回結果_片足での立位());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody17() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListFuseigo1_2(item.get調査結果_洗身_ある());
        body.setListIchigun_1(item.get調査結果_洗身());
        body.setListIchigun_2(get段階改善1(item.get段階改善_洗身()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_洗身()));
        body.setListIchigun_4(item.get前回結果_洗身());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody18() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListFuseigo1_2(item.get調査結果_つめ切り_ある());
        body.setListIchigun_1(item.get調査結果_つめ切り());
        body.setListIchigun_2(get段階改善1(item.get段階改善_つめ切り()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_つめ切り()));
        body.setListIchigun_4(item.get前回結果_つめ切り());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody19() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListFuseigo1_2(item.get調査結果_視力_ある());
        body.setListIchigun_1(item.get調査結果_視力());
        body.setListIchigun_2(get段階改善1(item.get段階改善_視力()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_視力()));
        body.setListIchigun_4(item.get前回結果_視力());
        return body;
    }

    private IchijihanteikekkahyoA3Body getBody20() {
        IchijihanteikekkahyoA3Body body = new IchijihanteikekkahyoA3Body();
        body.setListFuseigo1_2(item.get調査結果_聴力_ある());
        body.setListIchigun_1(item.get調査結果_聴力());
        body.setListIchigun_2(get段階改善1(item.get段階改善_聴力()));
        body.setListIchigun_3(get段階改善2(item.get段階改善_聴力()));
        body.setListIchigun_4(item.get前回結果_聴力());
        return body;
    }

    private RString get段階改善1(RString 段階改善) {
        if (!RString.isNullOrEmpty(段階改善) && 1 < 段階改善.length()) {
            return 段階改善.substring(0, 1);
        }
        return RString.EMPTY;
    }

    private RString get段階改善2(RString 段階改善) {
        if (!RString.isNullOrEmpty(段階改善) && 1 < 段階改善.length()) {
            return 段階改善.substring(1);
        }
        return RString.EMPTY;
    }
}
