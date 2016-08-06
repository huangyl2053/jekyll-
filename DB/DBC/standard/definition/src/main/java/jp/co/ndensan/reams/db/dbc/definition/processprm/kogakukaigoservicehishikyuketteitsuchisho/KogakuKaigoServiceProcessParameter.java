/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 高額サービス費支給（不支給）決定通知書作成のバッチのパラメータです
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServiceProcessParameter implements IBatchProcessParameter {

    private RString 抽出モード;
    private RDate 抽出条件日付From;
    private RDate 抽出条件日付To;
    private RDate 決定者受付年月;
    private RString 印書;
    private RString 高額自動償還;
    private RDate 発行日;
    private RDate 支払い予定日;
    private RString 文書番号;
    private RString テスト出力フラグ;
    private RString 決定日一括更新区分;
    private RDate 決定日;
    private RString 利用者向け決定通知書フラグ;
    private RString 受領委任者向け決定通知書フラグ;
    private RDate 振込予定日;
    private RString 支払場所;
    private RDate 支払期間From;
    private RDate 支払期間To;
    private RTime 開始時間;
    private RTime 終了時間;
    private long 出力順ID;

    /**
     * コンストラクタ
     *
     * @param 抽出モード RString
     * @param 抽出条件日付From RDate
     * @param 抽出条件日付To RDate
     * @param 決定者受付年月 RDate
     * @param 印書 RString
     * @param 高額自動償還 RString
     * @param 発行日 RDate
     * @param 支払い予定日 RDate
     * @param 文書番号 RString
     * @param テスト出力フラグ RString
     * @param 決定日一括更新区分 RString
     * @param 決定日 RDate
     * @param 利用者向け決定通知書フラグ RString
     * @param 受領委任者向け決定通知書フラグ RString
     * @param 振込予定日 RDate
     * @param 支払場所 RString
     * @param 支払期間From RDate
     * @param 支払期間To RDate
     * @param 開始時間 RTime
     * @param 終了時間 RTime
     * @param 出力順ID long
     */
    public KogakuKaigoServiceProcessParameter(RString 抽出モード,
            RDate 抽出条件日付From,
            RDate 抽出条件日付To,
            RDate 決定者受付年月,
            RString 印書,
            RString 高額自動償還,
            RDate 発行日,
            RDate 支払い予定日,
            RString 文書番号,
            RString テスト出力フラグ,
            RString 決定日一括更新区分,
            RDate 決定日,
            RString 利用者向け決定通知書フラグ,
            RString 受領委任者向け決定通知書フラグ,
            RDate 振込予定日,
            RString 支払場所,
            RDate 支払期間From,
            RDate 支払期間To,
            RTime 開始時間,
            RTime 終了時間,
            long 出力順ID) {
        this.抽出モード = 抽出モード;
        this.抽出条件日付From = 抽出条件日付From;
        this.抽出条件日付To = 抽出条件日付To;
        this.決定者受付年月 = 決定者受付年月;
        this.印書 = 印書;
        this.高額自動償還 = 高額自動償還;
        this.発行日 = 発行日;
        this.支払い予定日 = 支払い予定日;
        this.文書番号 = 文書番号;
        this.テスト出力フラグ = テスト出力フラグ;
        this.決定日一括更新区分 = 決定日一括更新区分;
        this.決定日 = 決定日;
        this.利用者向け決定通知書フラグ = 利用者向け決定通知書フラグ;
        this.受領委任者向け決定通知書フラグ = 受領委任者向け決定通知書フラグ;
        this.振込予定日 = 振込予定日;
        this.支払場所 = 支払場所;
        this.支払期間From = 支払期間From;
        this.支払期間To = 支払期間To;
        this.開始時間 = 開始時間;
        this.終了時間 = 終了時間;
        this.出力順ID = 出力順ID;
    }
}
