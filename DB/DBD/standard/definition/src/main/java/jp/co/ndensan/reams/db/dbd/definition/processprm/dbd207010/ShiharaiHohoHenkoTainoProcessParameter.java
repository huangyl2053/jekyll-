/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoHaakuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更滞納者抽出_Processパラメタークラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoTainoProcessParameter implements IBatchProcessParameter {

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
    private Long 出力順ID;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

    /**
     * 支払方法変更滞納者抽出_Processパラメター
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
     * @param 出力順ID 出力順ID
     * @param 帳票分類ID 帳票分類ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public ShiharaiHohoHenkoTainoProcessParameter(FlexibleDate 基準日,
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
            Long 出力順ID,
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
        this.出力順ID = 出力順ID;

        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;

    }

    /**
     * SQL使用されたパラメターを取得します．
     *
     * @param 出力順 出力順
     * @return SQL使用されたパラメター
     */
    public ShiharaiHohoHenkoHaakuMybatisParameter toShiharaiHohoHenkoHaakuMybatisParameter(RString 出力順) {
        return new ShiharaiHohoHenkoHaakuMybatisParameter(基準日,
                被保険者選択,
                被保険者全員の滞納期間,
                受給者全員,
                受給者全員の滞納期間,
                受給認定申請中者,
                受給認定申請中者の滞納期間,
                受給認定日抽出,
                受給認定日抽出の滞納期間,
                受給認定日抽出の開始,
                受給認定日抽出の終了,
                受給申請中者,
                受給申請中者の滞納期間,
                受給支給決定日抽出,
                受給支給決定日抽出の滞納期間,
                受給支給決定日抽出の開始,
                受給支給決定日抽出の終了,
                出力順);
    }
}
