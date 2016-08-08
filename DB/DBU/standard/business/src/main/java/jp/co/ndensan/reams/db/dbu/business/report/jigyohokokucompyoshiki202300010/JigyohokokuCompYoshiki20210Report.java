/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki202300010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki202300010.JigyohokokuCompYoshiki20210Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki202300010.JigyohokokuCompYoshiki20210ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告年報（様式2-3）のReportです。
 *
 * @reamsid_L DBU-5600-230 wangrenze
 */
public class JigyohokokuCompYoshiki20210Report extends Report<JigyohokokuCompYoshiki20210ReportSource> {

    private final JigyohokokuCompYoshiki20210Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行
     */
    public JigyohokokuCompYoshiki20210Report(JigyohokokuCompYoshiki20210Entity data) {
        this.data = data;
    }

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompYoshiki20210Entity
     * @return JigyohokokuCompYoshiki20210Report
     */
    public static JigyohokokuCompYoshiki20210Report createReport(JigyohokokuCompYoshiki20210Entity entity) {
        return new JigyohokokuCompYoshiki20210Report(entity);
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki20210ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki20210BodyData dataBody : getBodyData()) {
            IJigyohokokuCompYoshiki20210Editor editor = new JigyohokokuCompYoshiki20210Editor(data);
            IJigyohokokuCompYoshiki20210Editor bodyEditor = new JigyohokokuCompYoshiki20210BodyEditor(dataBody);
            IJigyohokokuCompYoshiki20210Builder builder = new JigyohokokuCompYoshiki20210Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki20210BodyData> getBodyData() {
        List<JigyohokokuCompYoshiki20210BodyData> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get居宅_介護予防_サービス_要支援１(),
                data.get居宅_介護予防_サービス_要支援２(),
                data.get居宅_介護予防_サービス_予防計(),
                data.get居宅_介護予防_サービス_非該当(),
                data.get居宅_介護予防_サービス_経過的要介護(),
                data.get居宅_介護予防_サービス_要介護１(),
                data.get居宅_介護予防_サービス_要介護２(),
                data.get居宅_介護予防_サービス_要介護３(),
                data.get居宅_介護予防_サービス_要介護４(),
                data.get居宅_介護予防_サービス_要介護５(),
                data.get居宅_介護予防_サービス_介護計(),
                data.get居宅_介護予防_サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get訪問サービス_要支援１(),
                data.get訪問サービス_要支援２(),
                data.get訪問サービス_予防計(),
                data.get訪問サービス_非該当(),
                data.get訪問サービス_経過的要介護(),
                data.get訪問サービス_要介護１(),
                data.get訪問サービス_要介護２(),
                data.get訪問サービス_要介護３(),
                data.get訪問サービス_要介護４(),
                data.get訪問サービス_要介護５(),
                data.get訪問サービス_介護計(),
                data.get訪問サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get訪問介護_要支援１(),
                data.get訪問介護_要支援２(),
                data.get訪問介護_予防計(),
                data.get訪問介護_非該当(),
                data.get訪問介護_経過的要介護(),
                data.get訪問介護_要介護１(),
                data.get訪問介護_要介護２(),
                data.get訪問介護_要介護３(),
                data.get訪問介護_要介護４(),
                data.get訪問介護_要介護５(),
                data.get訪問介護_介護計(),
                data.get訪問介護_合計()));

        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get訪問入浴介護_要支援１(),
                data.get訪問入浴介護_要支援２(),
                data.get訪問入浴介護_予防計(),
                data.get訪問入浴介護_非該当(),
                data.get訪問入浴介護_経過的要介護(),
                data.get訪問入浴介護_要介護１(),
                data.get訪問入浴介護_要介護２(),
                data.get訪問入浴介護_要介護３(),
                data.get訪問入浴介護_要介護４(),
                data.get訪問入浴介護_要介護５(),
                data.get訪問入浴介護_介護計(),
                data.get訪問入浴介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get訪問看護_要支援１(),
                data.get訪問看護_要支援２(),
                data.get訪問看護_予防計(),
                data.get訪問看護_非該当(),
                data.get訪問看護_経過的要介護(),
                data.get訪問看護_要介護１(),
                data.get訪問看護_要介護２(),
                data.get訪問看護_要介護３(),
                data.get訪問看護_要介護４(),
                data.get訪問看護_要介護５(),
                data.get訪問看護_介護計(),
                data.get訪問看護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get訪問リハビリテーション_要支援１(),
                data.get訪問リハビリテーション_要支援２(),
                data.get訪問リハビリテーション_予防計(),
                data.get訪問リハビリテーション_非該当(),
                data.get訪問リハビリテーション_経過的要介護(),
                data.get訪問リハビリテーション_要介護１(),
                data.get訪問リハビリテーション_要介護２(),
                data.get訪問リハビリテーション_要介護３(),
                data.get訪問リハビリテーション_要介護４(),
                data.get訪問リハビリテーション_要介護５(),
                data.get訪問リハビリテーション_介護計(),
                data.get訪問リハビリテーション_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get居宅療養管理指導_要支援１(),
                data.get居宅療養管理指導_要支援２(),
                data.get居宅療養管理指導_予防計(),
                data.get居宅療養管理指導_非該当(),
                data.get居宅療養管理指導_経過的要介護(),
                data.get居宅療養管理指導_要介護１(),
                data.get居宅療養管理指導_要介護２(),
                data.get居宅療養管理指導_要介護３(),
                data.get居宅療養管理指導_要介護４(),
                data.get居宅療養管理指導_要介護５(),
                data.get居宅療養管理指導_介護計(),
                data.get居宅療養管理指導_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get通所サービス_要支援１(),
                data.get通所サービス_要支援２(),
                data.get通所サービス_予防計(),
                data.get通所サービス_非該当(),
                data.get通所サービス_経過的要介護(),
                data.get通所サービス_要介護１(),
                data.get通所サービス_要介護２(),
                data.get通所サービス_要介護３(),
                data.get通所サービス_要介護４(),
                data.get通所サービス_要介護５(),
                data.get通所サービス_介護計(),
                data.get通所サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get通所介護_要支援１(),
                data.get通所介護_要支援２(),
                data.get通所介護_予防計(),
                data.get通所介護_非該当(),
                data.get通所介護_経過的要介護(),
                data.get通所介護_要介護１(),
                data.get通所介護_要介護２(),
                data.get通所介護_要介護３(),
                data.get通所介護_要介護４(),
                data.get通所介護_要介護５(),
                data.get通所介護_介護計(),
                data.get通所介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get通所リハビリテーション_要支援１(),
                data.get通所リハビリテーション_要支援２(),
                data.get通所リハビリテーション_予防計(),
                data.get通所リハビリテーション_非該当(),
                data.get通所リハビリテーション_経過的要介護(),
                data.get通所リハビリテーション_要介護１(),
                data.get通所リハビリテーション_要介護２(),
                data.get通所リハビリテーション_要介護３(),
                data.get通所リハビリテーション_要介護４(),
                data.get通所リハビリテーション_要介護５(),
                data.get通所リハビリテーション_介護計(),
                data.get通所リハビリテーション_合計()));
        return getBodyData1(dataBodyList);
    }

    private List<JigyohokokuCompYoshiki20210BodyData> getBodyData1(List<JigyohokokuCompYoshiki20210BodyData> dataBodyList) {
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get短期入所サービス_要支援１(),
                data.get短期入所サービス_要支援２(),
                data.get短期入所サービス_予防計(),
                data.get短期入所サービス_非該当(),
                data.get短期入所サービス_経過的要介護(),
                data.get短期入所サービス_要介護１(),
                data.get短期入所サービス_要介護２(),
                data.get短期入所サービス_要介護３(),
                data.get短期入所サービス_要介護４(),
                data.get短期入所サービス_要介護５(),
                data.get短期入所サービス_介護計(),
                data.get短期入所サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get短期入所生活介護_要支援１(),
                data.get短期入所生活介護_要支援２(),
                data.get短期入所生活介護_予防計(),
                data.get短期入所生活介護_非該当(),
                data.get短期入所生活介護_経過的要介護(),
                data.get短期入所生活介護_要介護１(),
                data.get短期入所生活介護_要介護２(),
                data.get短期入所生活介護_要介護３(),
                data.get短期入所生活介護_要介護４(),
                data.get短期入所生活介護_要介護５(),
                data.get短期入所生活介護_介護計(),
                data.get短期入所生活介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get短期入所療養介護_介護老人保健施設_要支援１(),
                data.get短期入所療養介護_介護老人保健施設_要支援２(),
                data.get短期入所療養介護_介護老人保健施設_予防計(),
                data.get短期入所療養介護_介護老人保健施設_非該当(),
                data.get短期入所療養介護_介護老人保健施設_経過的要介護(),
                data.get短期入所療養介護_介護老人保健施設_要介護１(),
                data.get短期入所療養介護_介護老人保健施設_要介護２(),
                data.get短期入所療養介護_介護老人保健施設_要介護３(),
                data.get短期入所療養介護_介護老人保健施設_要介護４(),
                data.get短期入所療養介護_介護老人保健施設_要介護５(),
                data.get短期入所療養介護_介護老人保健施設_介護計(),
                data.get短期入所療養介護_介護老人保健施設_合計()));
        return getBodyData2(dataBodyList);
    }

    private List<JigyohokokuCompYoshiki20210BodyData> getBodyData2(List<JigyohokokuCompYoshiki20210BodyData> dataBodyList) {
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get短期入所療養介護_介護療養型医療施設等_要支援１(),
                data.get短期入所療養介護_介護療養型医療施設等_要支援２(),
                data.get短期入所療養介護_介護療養型医療施設等_予防計(),
                data.get短期入所療養介護_介護療養型医療施設等_非該当(),
                data.get短期入所療養介護_介護療養型医療施設等_経過的要介護(),
                data.get短期入所療養介護_介護療養型医療施設等_要介護１(),
                data.get短期入所療養介護_介護療養型医療施設等_要介護２(),
                data.get短期入所療養介護_介護療養型医療施設等_要介護３(),
                data.get短期入所療養介護_介護療養型医療施設等_要介護４(),
                data.get短期入所療養介護_介護療養型医療施設等_要介護５(),
                data.get短期入所療養介護_介護療養型医療施設等_介護計(),
                data.get短期入所療養介護_介護療養型医療施設等_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get福祉用具_住宅改修サービス_要支援１(),
                data.get福祉用具_住宅改修サービス_要支援２(),
                data.get福祉用具_住宅改修サービス_予防計(),
                data.get福祉用具_住宅改修サービス_非該当(),
                data.get福祉用具_住宅改修サービス_経過的要介護(),
                data.get福祉用具_住宅改修サービス_要介護１(),
                data.get福祉用具_住宅改修サービス_要介護２(),
                data.get福祉用具_住宅改修サービス_要介護３(),
                data.get福祉用具_住宅改修サービス_要介護４(),
                data.get福祉用具_住宅改修サービス_要介護５(),
                data.get福祉用具_住宅改修サービス_介護計(),
                data.get福祉用具_住宅改修サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get福祉用具貸与_要支援１(),
                data.get福祉用具貸与_要支援２(),
                data.get福祉用具貸与_予防計(),
                data.get福祉用具貸与_非該当(),
                data.get福祉用具貸与_経過的要介護(),
                data.get福祉用具貸与_要介護１(),
                data.get福祉用具貸与_要介護２(),
                data.get福祉用具貸与_要介護３(),
                data.get福祉用具貸与_要介護４(),
                data.get福祉用具貸与_要介護５(),
                data.get福祉用具貸与_介護計(),
                data.get福祉用具貸与_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get福祉用具購入費_要支援１(),
                data.get福祉用具購入費_要支援２(),
                data.get福祉用具購入費_予防計(),
                data.get福祉用具購入費_非該当(),
                data.get福祉用具購入費_経過的要介護(),
                data.get福祉用具購入費_要介護１(),
                data.get福祉用具購入費_要介護２(),
                data.get福祉用具購入費_要介護３(),
                data.get福祉用具購入費_要介護４(),
                data.get福祉用具購入費_要介護５(),
                data.get福祉用具購入費_介護計(),
                data.get福祉用具購入費_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get住宅改修費_要支援１(),
                data.get住宅改修費_要支援２(),
                data.get住宅改修費_予防計(),
                data.get住宅改修費_非該当(),
                data.get住宅改修費_経過的要介護(),
                data.get住宅改修費_要介護１(),
                data.get住宅改修費_要介護２(),
                data.get住宅改修費_要介護３(),
                data.get住宅改修費_要介護４(),
                data.get住宅改修費_要介護５(),
                data.get住宅改修費_介護計(),
                data.get住宅改修費_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get特定施設入居者生活介護_要支援１(),
                data.get特定施設入居者生活介護_要支援２(),
                data.get特定施設入居者生活介護_予防計(),
                data.get特定施設入居者生活介護_非該当(),
                data.get特定施設入居者生活介護_経過的要介護(),
                data.get特定施設入居者生活介護_要介護１(),
                data.get特定施設入居者生活介護_要介護２(),
                data.get特定施設入居者生活介護_要介護３(),
                data.get特定施設入居者生活介護_要介護４(),
                data.get特定施設入居者生活介護_要介護５(),
                data.get特定施設入居者生活介護_介護計(),
                data.get特定施設入居者生活介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get介護予防支援_居宅介護支援_要支援１(),
                data.get介護予防支援_居宅介護支援_要支援２(),
                data.get介護予防支援_居宅介護支援_予防計(),
                data.get介護予防支援_居宅介護支援_非該当(),
                data.get介護予防支援_居宅介護支援_経過的要介護(),
                data.get介護予防支援_居宅介護支援_要介護１(),
                data.get介護予防支援_居宅介護支援_要介護２(),
                data.get介護予防支援_居宅介護支援_要介護３(),
                data.get介護予防支援_居宅介護支援_要介護４(),
                data.get介護予防支援_居宅介護支援_要介護５(),
                data.get介護予防支援_居宅介護支援_介護計(),
                data.get介護予防支援_居宅介護支援_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get地域密着型_介護予防_サービス_要支援１(),
                data.get地域密着型_介護予防_サービス_要支援２(),
                data.get地域密着型_介護予防_サービス_予防計(),
                data.get地域密着型_介護予防_サービス_非該当(),
                data.get地域密着型_介護予防_サービス_経過的要介護(),
                data.get地域密着型_介護予防_サービス_要介護１(),
                data.get地域密着型_介護予防_サービス_要介護２(),
                data.get地域密着型_介護予防_サービス_要介護３(),
                data.get地域密着型_介護予防_サービス_要介護４(),
                data.get地域密着型_介護予防_サービス_要介護５(),
                data.get地域密着型_介護予防_サービス_介護計(),
                data.get地域密着型_介護予防_サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get定期巡回_随時対応型訪問介護看護_要支援１(),
                data.get定期巡回_随時対応型訪問介護看護_要支援２(),
                data.get定期巡回_随時対応型訪問介護看護_予防計(),
                data.get定期巡回_随時対応型訪問介護看護_非該当(),
                data.get定期巡回_随時対応型訪問介護看護_経過的要介護(),
                data.get定期巡回_随時対応型訪問介護看護_要介護１(),
                data.get定期巡回_随時対応型訪問介護看護_要介護２(),
                data.get定期巡回_随時対応型訪問介護看護_要介護３(),
                data.get定期巡回_随時対応型訪問介護看護_要介護４(),
                data.get定期巡回_随時対応型訪問介護看護_要介護５(),
                data.get定期巡回_随時対応型訪問介護看護_介護計(),
                data.get定期巡回_随時対応型訪問介護看護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get夜間対応型訪問介護_要支援１(),
                data.get夜間対応型訪問介護_要支援２(),
                data.get夜間対応型訪問介護_予防計(),
                data.get夜間対応型訪問介護_非該当(),
                data.get夜間対応型訪問介護_経過的要介護(),
                data.get夜間対応型訪問介護_要介護１(),
                data.get夜間対応型訪問介護_要介護２(),
                data.get夜間対応型訪問介護_要介護３(),
                data.get夜間対応型訪問介護_要介護４(),
                data.get夜間対応型訪問介護_要介護５(),
                data.get夜間対応型訪問介護_介護計(),
                data.get夜間対応型訪問介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get地域密着型通所介護_要支援１(),
                data.get地域密着型通所介護_要支援２(),
                data.get地域密着型通所介護_予防計(),
                data.get地域密着型通所介護_非該当(),
                data.get地域密着型通所介護_経過的要介護(),
                data.get地域密着型通所介護_要介護１(),
                data.get地域密着型通所介護_要介護２(),
                data.get地域密着型通所介護_要介護３(),
                data.get地域密着型通所介護_要介護４(),
                data.get地域密着型通所介護_要介護５(),
                data.get地域密着型通所介護_介護計(),
                data.get地域密着型通所介護_合計()));
        return getBodyData3(dataBodyList);
    }

    private List<JigyohokokuCompYoshiki20210BodyData> getBodyData3(List<JigyohokokuCompYoshiki20210BodyData> dataBodyList) {
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get認知症対応型通所介護_要支援１(),
                data.get認知症対応型通所介護_要支援２(),
                data.get認知症対応型通所介護_予防計(),
                data.get認知症対応型通所介護_非該当(),
                data.get認知症対応型通所介護_経過的要介護(),
                data.get認知症対応型通所介護_要介護１(),
                data.get認知症対応型通所介護_要介護２(),
                data.get認知症対応型通所介護_要介護３(),
                data.get認知症対応型通所介護_要介護４(),
                data.get認知症対応型通所介護_要介護５(),
                data.get認知症対応型通所介護_介護計(),
                data.get認知症対応型通所介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get小規模多機能型居宅介護_要支援１(),
                data.get小規模多機能型居宅介護_要支援２(),
                data.get小規模多機能型居宅介護_予防計(),
                data.get小規模多機能型居宅介護_非該当(),
                data.get小規模多機能型居宅介護_経過的要介護(),
                data.get小規模多機能型居宅介護_要介護１(),
                data.get小規模多機能型居宅介護_要介護２(),
                data.get小規模多機能型居宅介護_要介護３(),
                data.get小規模多機能型居宅介護_要介護４(),
                data.get小規模多機能型居宅介護_要介護５(),
                data.get小規模多機能型居宅介護_介護計(),
                data.get小規模多機能型居宅介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get認知症対応型共同生活介護_要支援１(),
                data.get認知症対応型共同生活介護_要支援２(),
                data.get認知症対応型共同生活介護_予防計(),
                data.get認知症対応型共同生活介護_非該当(),
                data.get認知症対応型共同生活介護_経過的要介護(),
                data.get認知症対応型共同生活介護_要介護１(),
                data.get認知症対応型共同生活介護_要介護２(),
                data.get認知症対応型共同生活介護_要介護３(),
                data.get認知症対応型共同生活介護_要介護４(),
                data.get認知症対応型共同生活介護_要介護５(),
                data.get認知症対応型共同生活介護_介護計(),
                data.get認知症対応型共同生活介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get地域密着型特定施設入居者生活介護_要支援１(),
                data.get地域密着型特定施設入居者生活介護_要支援２(),
                data.get地域密着型特定施設入居者生活介護_予防計(),
                data.get地域密着型特定施設入居者生活介護_非該当(),
                data.get地域密着型特定施設入居者生活介護_経過的要介護(),
                data.get地域密着型特定施設入居者生活介護_要介護１(),
                data.get地域密着型特定施設入居者生活介護_要介護２(),
                data.get地域密着型特定施設入居者生活介護_要介護３(),
                data.get地域密着型特定施設入居者生活介護_要介護４(),
                data.get地域密着型特定施設入居者生活介護_要介護５(),
                data.get地域密着型特定施設入居者生活介護_介護計(),
                data.get地域密着型特定施設入居者生活介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get地域密着型介護老人福祉施設入居者生活介護_要支援１(),
                data.get地域密着型介護老人福祉施設入居者生活介護_要支援２(),
                data.get地域密着型介護老人福祉施設入居者生活介護_予防計(),
                data.get地域密着型介護老人福祉施設入居者生活介護_非該当(),
                data.get地域密着型介護老人福祉施設入居者生活介護_経過的要介護(),
                data.get地域密着型介護老人福祉施設入居者生活介護_要介護１(),
                data.get地域密着型介護老人福祉施設入居者生活介護_要介護２(),
                data.get地域密着型介護老人福祉施設入居者生活介護_要介護３(),
                data.get地域密着型介護老人福祉施設入居者生活介護_要介護４(),
                data.get地域密着型介護老人福祉施設入居者生活介護_要介護５(),
                data.get地域密着型介護老人福祉施設入居者生活介護_介護計(),
                data.get地域密着型介護老人福祉施設入居者生活介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get複合型サービス_看護小規模多機能型居宅介護_要支援１(),
                data.get複合型サービス_看護小規模多機能型居宅介護_要支援２(),
                data.get複合型サービス_看護小規模多機能型居宅介護_予防計(),
                data.get複合型サービス_看護小規模多機能型居宅介護_非該当(),
                data.get複合型サービス_看護小規模多機能型居宅介護_経過的要介護(),
                data.get複合型サービス_看護小規模多機能型居宅介護_要介護１(),
                data.get複合型サービス_看護小規模多機能型居宅介護_要介護２(),
                data.get複合型サービス_看護小規模多機能型居宅介護_要介護３(),
                data.get複合型サービス_看護小規模多機能型居宅介護_要介護４(),
                data.get複合型サービス_看護小規模多機能型居宅介護_要介護５(),
                data.get複合型サービス_看護小規模多機能型居宅介護_介護計(),
                data.get複合型サービス_看護小規模多機能型居宅介護_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get施設介護サービス_要支援１(),
                data.get施設介護サービス_要支援２(),
                data.get施設介護サービス_予防計(),
                data.get施設介護サービス_非該当(),
                data.get施設介護サービス_経過的要介護(),
                data.get施設介護サービス_要介護１(),
                data.get施設介護サービス_要介護２(),
                data.get施設介護サービス_要介護３(),
                data.get施設介護サービス_要介護４(),
                data.get施設介護サービス_要介護５(),
                data.get施設介護サービス_介護計(),
                data.get施設介護サービス_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get介護老人福祉施設_要支援１(),
                data.get介護老人福祉施設_要支援２(),
                data.get介護老人福祉施設_予防計(),
                data.get介護老人福祉施設_非該当(),
                data.get介護老人福祉施設_経過的要介護(),
                data.get介護老人福祉施設_要介護１(),
                data.get介護老人福祉施設_要介護２(),
                data.get介護老人福祉施設_要介護３(),
                data.get介護老人福祉施設_要介護４(),
                data.get介護老人福祉施設_要介護５(),
                data.get介護老人福祉施設_介護計(),
                data.get介護老人福祉施設_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get介護老人保健施設_要支援１(),
                data.get介護老人保健施設_要支援２(),
                data.get介護老人保健施設_予防計(),
                data.get介護老人保健施設_非該当(),
                data.get介護老人保健施設_経過的要介護(),
                data.get介護老人保健施設_要介護１(),
                data.get介護老人保健施設_要介護２(),
                data.get介護老人保健施設_要介護３(),
                data.get介護老人保健施設_要介護４(),
                data.get介護老人保健施設_要介護５(),
                data.get介護老人保健施設_介護計(),
                data.get介護老人保健施設_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get介護療養型医療施設_要支援１(),
                data.get介護療養型医療施設_要支援２(),
                data.get介護療養型医療施設_予防計(),
                data.get介護療養型医療施設_非該当(),
                data.get介護療養型医療施設_経過的要介護(),
                data.get介護療養型医療施設_要介護１(),
                data.get介護療養型医療施設_要介護２(),
                data.get介護療養型医療施設_要介護３(),
                data.get介護療養型医療施設_要介護４(),
                data.get介護療養型医療施設_要介護５(),
                data.get介護療養型医療施設_介護計(),
                data.get介護療養型医療施設_合計()));
        dataBodyList.add(new JigyohokokuCompYoshiki20210BodyData(
                data.get総計_要支援１(),
                data.get総計_要支援２(),
                data.get総計_予防計(),
                data.get総計_非該当(),
                data.get総計_経過的要介護(),
                data.get総計_要介護１(),
                data.get総計_要介護２(),
                data.get総計_要介護３(),
                data.get総計_要介護４(),
                data.get総計_要介護５(),
                data.get総計_介護計(),
                data.get総計_合計()));
        return dataBodyList;
    }
}
