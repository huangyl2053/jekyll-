/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd209011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象者把握情報の取得ＳＱＬ用パラメタークラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGengakuHaakuListTaishoTokuteiMybatisParameter implements IMyBatisParameter {

    private RDate 基準日;
    private boolean is時効起算日登録者のみ;
    private boolean is時効起算日登録者以外;
    private boolean is被保険者全員以外;
    private boolean is受給認定申請中者チェックオン;
    private boolean is受給認定日抽出チェックオン;
    private boolean is認定有効終了日抽出チェックオン;
    private boolean is保険料完納者も出力チェックオン;

    private RString 被保険者選択;
    private RString 受給者全員;
    private RString 受給認定申請中者;
    private RString 受給認定日抽出;
    private FlexibleDate 受給認定日抽出の開始;
    private FlexibleDate 受給認定日抽出の終了;
    private RString 認定有効終日抽出;
    private FlexibleDate 認定有効終日抽出の開始;
    private FlexibleDate 認定有効終日抽出の終了;
    private RString 保険料完納者も出力;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 時効起算日登録者の選択 時効起算日登録者の選択
     * @param 被保険者選択 被保険者選択
     * @param 受給者全員 受給者全員
     * @param 受給認定申請中者 受給認定申請中者
     * @param 受給認定日抽出 受給認定日抽出
     * @param 受給認定日抽出の開始 受給認定日抽出の開始
     * @param 受給認定日抽出の終了 受給認定日抽出の終了
     * @param 認定有効終日抽出 認定有効終日抽出
     * @param 認定有効終日抽出の開始 認定有効終日抽出の開始
     * @param 認定有効終日抽出の終了 認定有効終日抽出の終了
     * @param 保険料完納者も出力 保険料完納者も出力
     */
    public KyufuGengakuHaakuListTaishoTokuteiMybatisParameter(FlexibleDate 基準日,
            RString 時効起算日登録者の選択,
            RString 被保険者選択,
            RString 受給者全員,
            RString 受給認定申請中者,
            RString 受給認定日抽出,
            FlexibleDate 受給認定日抽出の開始,
            FlexibleDate 受給認定日抽出の終了,
            RString 認定有効終日抽出,
            FlexibleDate 認定有効終日抽出の開始,
            FlexibleDate 認定有効終日抽出の終了,
            RString 保険料完納者も出力) {

        this.基準日 = new RDate(基準日.toString());
        this.is時効起算日登録者のみ = new RString("0").equals(時効起算日登録者の選択);
        this.is時効起算日登録者以外 = new RString("1").equals(時効起算日登録者の選択);
        this.is被保険者全員以外 = new RString("1").equals(被保険者選択);
        this.is受給認定申請中者チェックオン = new RString("0").equals(受給認定申請中者);
        this.is受給認定日抽出チェックオン = new RString("0").equals(受給認定日抽出);
        this.is認定有効終了日抽出チェックオン = new RString("0").equals(認定有効終日抽出);
        this.is保険料完納者も出力チェックオン = new RString("0").equals(保険料完納者も出力);

        this.被保険者選択 = 被保険者選択;
        this.受給者全員 = 受給者全員;
        this.受給認定申請中者 = 受給認定申請中者;
        this.受給認定日抽出 = 受給認定日抽出;
        this.受給認定日抽出の開始 = 受給認定日抽出の開始;
        this.受給認定日抽出の終了 = 受給認定日抽出の終了;
        this.認定有効終日抽出 = 認定有効終日抽出;
        this.認定有効終日抽出の開始 = 認定有効終日抽出の開始;
        this.認定有効終日抽出の終了 = 認定有効終日抽出の終了;
        this.保険料完納者も出力 = 保険料完納者も出力;
    }

}
