/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.ninteirirekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 認定履歴一覧（画面) 総合事業対象者情報取得_自己作成Resultオブジェクト
 *
 * @reamsid_L DBC-4350-070 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoJigyouTaisyouSyaJyohoResult {

    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private FlexibleDate 決定日;
    private FlexibleDate チェックリスト実施日;
}
