/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更把握リストEntiyクラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuEntity {

    private FlexibleDate 基準日;
    private Long 被保険者選択;
    private Long 被保険者全員の滞納期間;
    private Long 受給者全員;
    private Long 受給者全員の滞納期間;
    private Long 受給認定申請中者;
    private Long 受給認定申請中者の滞納期間;
    private Long 受給認定日抽出;
    private Long 受給認定日抽出の滞納期間;
    private FlexibleDate 受給認定日抽出の開始;
    private FlexibleDate 受給認定日抽出の終了;
    private Long 受給申請中者;
    private Long 受給申請中者の滞納期間;
    private Long 受給支給決定日抽出;
    private Long 受給支給決定日抽出の滞納期間;
    private FlexibleDate 受給支給決定日抽出の開始;
    private FlexibleDate 受給支給決定日抽出の終了;
    private Long 改頁出力順ID;
    //private Long 帳票分類ID;
    private ReportId 帳票ID;
    private RString 帳票作成日時;
}
