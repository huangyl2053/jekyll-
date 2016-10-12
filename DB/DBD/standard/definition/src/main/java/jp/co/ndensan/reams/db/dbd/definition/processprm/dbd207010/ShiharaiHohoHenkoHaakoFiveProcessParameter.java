/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoHaakuFiveMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5パラメタークラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakoFiveProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private RString 被保険者選択;
    private int 被保険者全員の滞納期間;
    private RString 受給者全員;
    private int 受給者全員の滞納期間;
    private RString 受給認定申請中者;
    private int 受給認定申請中者の滞納期間;
    private RString 受給認定日抽出;
    private int 受給認定日抽出の滞納期間;
    private FlexibleDate 受給認定日抽出の開始;
    private FlexibleDate 受給認定日抽出の終了;
    private RString 受給申請中者;
    private int 受給申請中者の滞納期間;
    private RString 受給支給決定日抽出;
    private int 受給支給決定日抽出の滞納期間;
    private FlexibleDate 受給支給決定日抽出の開始;
    private FlexibleDate 受給支給決定日抽出の終了;
    private Long 改頁出力順ID;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 被保険者選択 被保険者選択
     * @param 被保険者全員の滞納期間 被保険者全員の滞納期間
     * @param 受給者全員 受給者全員
     * @param 受給者全員の滞納期間 受給者全員の滞納期間
     * @param 受給認定申請中者 受給認定申請中者
     * @param 受給認定申請中者の滞納期間 受給認定申請中者の滞納期間
     * @param 受給認定日抽出 受給認定日抽出
     * @param 受給認定日抽出の滞納期間 受給認定日抽出の滞納期間
     * @param 受給認定日抽出の開始 受給認定日抽出の開始
     * @param 受給認定日抽出の終了 受給認定日抽出の終了
     * @param 受給申請中者 受給申請中者
     * @param 受給申請中者の滞納期間 受給申請中者の滞納期間
     * @param 受給支給決定日抽出 受給支給決定日抽出
     * @param 受給支給決定日抽出の滞納期間 受給支給決定日抽出の滞納期間
     * @param 受給支給決定日抽出の開始 受給支給決定日抽出の開始
     * @param 受給支給決定日抽出の終了 受給支給決定日抽出の終了
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票分類ID 帳票分類ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public ShiharaiHohoHenkoHaakoFiveProcessParameter(
            FlexibleDate 基準日,
            RString 被保険者選択,
            int 被保険者全員の滞納期間,
            RString 受給者全員,
            int 受給者全員の滞納期間,
            RString 受給認定申請中者,
            int 受給認定申請中者の滞納期間,
            RString 受給認定日抽出,
            int 受給認定日抽出の滞納期間,
            FlexibleDate 受給認定日抽出の開始,
            FlexibleDate 受給認定日抽出の終了,
            RString 受給申請中者,
            int 受給申請中者の滞納期間,
            RString 受給支給決定日抽出,
            int 受給支給決定日抽出の滞納期間,
            FlexibleDate 受給支給決定日抽出の開始,
            FlexibleDate 受給支給決定日抽出の終了,
            Long 改頁出力順ID,
            ReportId 帳票分類ID,
            ReportId 帳票ID,
            RDateTime 帳票作成日時) {
        this.基準日 = 基準日;
        this.被保険者選択 = 被保険者選択;
        this.被保険者全員の滞納期間 = 被保険者全員の滞納期間;
        this.受給者全員 = 受給者全員;
        this.受給者全員の滞納期間 = 受給者全員の滞納期間;
        this.受給認定申請中者 = 受給認定申請中者;
        this.受給認定申請中者の滞納期間 = 受給認定申請中者の滞納期間;
        this.受給認定日抽出 = 受給認定日抽出;
        this.受給認定日抽出の滞納期間 = 受給認定日抽出の滞納期間;
        this.受給認定日抽出の開始 = 受給認定日抽出の開始;
        this.受給認定日抽出の終了 = 受給認定日抽出の終了;
        this.受給申請中者 = 受給申請中者;
        this.受給申請中者の滞納期間 = 受給申請中者の滞納期間;
        this.受給支給決定日抽出 = 受給支給決定日抽出;
        this.受給支給決定日抽出の滞納期間 = 受給支給決定日抽出の滞納期間;
        this.受給支給決定日抽出の開始 = 受給支給決定日抽出の開始;
        this.受給支給決定日抽出の終了 = 受給支給決定日抽出の終了;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL用パラメターを取得します．
     *
     * @return DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5
     */
    public ShiharaiHohoHenkoHaakuFiveMybatisParameter toShiharaiHohoHenkoHaakuFiveMybatisParameter() {
        return new ShiharaiHohoHenkoHaakuFiveMybatisParameter(基準日);
    }
}
