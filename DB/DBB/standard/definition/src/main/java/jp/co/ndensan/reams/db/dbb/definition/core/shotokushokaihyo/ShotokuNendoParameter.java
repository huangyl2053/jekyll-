/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 1号被保険者および賦課基準日時点の世帯員の取得のパラメタ
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuNendoParameter {

    private FlexibleDate 処理年度_４月１日;
    private FlexibleDate 処理年度_plus1_４月１日;
    private FlexibleDate 処理年度_minus64_4月１日;
    private FlexibleDate 処理年度_minus18_1月2日;
    private FlexibleDate 処理年度_minus39_4月１日;
    private FlexibleDate 処理年度_plus１_７月３１日;
    private FlexibleDate 処理年度_plus１_３月３１日;
    private FlexibleDate 処理年度_8月１日;
    private FlexibleDate 処理年度_1月２日;
    private FlexibleDate 処理年度_1月１日;
    private FlexibleDate システム日付;
}
