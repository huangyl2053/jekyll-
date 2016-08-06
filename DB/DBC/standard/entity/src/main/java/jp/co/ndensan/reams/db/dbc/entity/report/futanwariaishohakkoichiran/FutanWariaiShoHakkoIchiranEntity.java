/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishohakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合証発行一覧表Entity
 *
 * @reamsid_L DBC-4990-031 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class FutanWariaiShoHakkoIchiranEntity {

    private RString 年度;
    private RString 条件;
    private RString 抽出対象期間開始;
    private RString 抽出対象期間終了;
    private RString 発行区分;
    private RString 交付日;
    private RString 保険者番号;
    private RString 保険者名;
    private RString ソート順１;
    private RString ソート順２;
    private RString ソート順３;
    private RString ソート順４;
    private RString ソート順５;
    private RString ページ;
    private RString 作成日時;
    private RString 連番;
    private RString 被保険者番号;
    private RString 送付先住所;
    private RString 被保険者氏名;
    private RString 判定日;
    private RString 開始年月日;
    private RString 終了年月日;
    private RString 負担割合;
    private RString 判定区分;
    private RString 発行済;

}
