/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更把握リストSQL使用されたパラメタークラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShiharaiHohoHenkoHaakuMybatisParameter implements IMyBatisParameter {

    private static final RString 被保険者選択_被保険者全員 = new RString("0");

    private static final RString 選択_チェックオン = new RString("0");

    private RDate 基準日;
    private RString 出力順;

    private boolean is被保険者選択_被保険者全員_0;
    private boolean is被保険者選択_被保険者全員以外_1;

    private boolean is受給者全員;
    private boolean is受給認定申請中者;
    private boolean is受給認定日抽出;
    private boolean is受給申請中者;
    private boolean is受給支給決定日抽出;

    private int 被保険者全員の滞納期間;
    private int 受給者全員の滞納期間;
    private int 受給認定申請中者の滞納期間;
    private int 受給認定日抽出の滞納期間;
    private FlexibleDate 受給認定日抽出の開始;
    private FlexibleDate 受給認定日抽出の終了;
    private int 償還申請中者の滞納期間;
    private int 償還支給決定日抽出の滞納期間;
    private FlexibleDate 受給支給決定日抽出の開始;
    private FlexibleDate 受給支給決定日抽出の終了;

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
     * @param 出力順 出力順
     */
    public ShiharaiHohoHenkoHaakuMybatisParameter(FlexibleDate 基準日,
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
            RString 出力順) {

        if (基準日 != null) {
            this.基準日 = new RDate(基準日.toString());
        }

        this.出力順 = 出力順;
        this.受給認定日抽出の開始 = 受給認定日抽出の開始;
        this.受給認定日抽出の終了 = 受給認定日抽出の終了;
        this.受給支給決定日抽出の開始 = 受給支給決定日抽出の開始;
        this.受給支給決定日抽出の終了 = 受給支給決定日抽出の終了;

        this.被保険者全員の滞納期間 = 被保険者全員の滞納期間;
        this.受給者全員の滞納期間 = 受給者全員の滞納期間;
        this.受給認定申請中者の滞納期間 = 受給認定申請中者の滞納期間;
        this.受給認定日抽出の滞納期間 = 受給認定日抽出の滞納期間;

        this.償還申請中者の滞納期間 = 受給申請中者の滞納期間;
        this.償還支給決定日抽出の滞納期間 = 受給支給決定日抽出の滞納期間;

        set被保険者選択について(被保険者選択);
        set選択_受給者全員(受給者全員);
        set選択_受給認定申請中者(受給認定申請中者);
        set選択_受給認定日抽出(受給認定日抽出);
        set選択_受給申請中者(受給申請中者);
        set選択_受給支給決定日抽出(受給支給決定日抽出);
    }

    private void set被保険者選択について(RString 被保険者選択) {
        if (被保険者選択_被保険者全員.equals(被保険者選択)) {
            is被保険者選択_被保険者全員_0 = true;
        } else {
            is被保険者選択_被保険者全員以外_1 = true;
        }
    }

    private void set選択_受給者全員(RString 受給者全員) {

        if (選択_チェックオン.equals(受給者全員)) {
            is受給者全員 = true;
        }
    }

    private void set選択_受給認定申請中者(RString 受給認定申請中者) {
        if (選択_チェックオン.equals(受給認定申請中者)) {
            is受給認定申請中者 = true;
        }
    }

    private void set選択_受給認定日抽出(RString 受給認定日抽出) {
        if (選択_チェックオン.equals(受給認定日抽出)) {
            is受給認定日抽出 = true;
        }
    }

    private void set選択_受給申請中者(RString 受給申請中者) {
        if (選択_チェックオン.equals(受給申請中者)) {
            is受給申請中者 = true;
        }
    }

    private void set選択_受給支給決定日抽出(RString 受給支給決定日抽出) {
        if (選択_チェックオン.equals(受給支給決定日抽出)) {
            is受給支給決定日抽出 = true;
        }
    }
}
