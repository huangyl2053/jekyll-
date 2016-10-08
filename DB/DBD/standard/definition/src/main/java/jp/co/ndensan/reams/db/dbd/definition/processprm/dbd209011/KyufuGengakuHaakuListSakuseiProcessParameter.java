/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd209011.KyufuGengakuHaakuListSakuseiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額滞納者把握情報の取得_Process処理パラメタークラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGengakuHaakuListSakuseiProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private RString 時効起算日登録者の選択;
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
    private Long 改頁出力順ID;
    private ReportId 帳票ID;
    private RString 帳票作成日時;

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
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public KyufuGengakuHaakuListSakuseiProcessParameter(FlexibleDate 基準日,
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
            RString 保険料完納者も出力,
            Long 改頁出力順ID,
            ReportId 帳票ID,
            RString 帳票作成日時) {
        this.基準日 = 基準日;
        this.時効起算日登録者の選択 = 時効起算日登録者の選択;
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
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param 出力順 出力順
     * @return ＳＱＬ使用されたパラメター
     */
    public KyufuGengakuHaakuListSakuseiMybatisParameter toKyufuGengakuHaakuListSakuseiMybatisParameter(RString 出力順) {
        return new KyufuGengakuHaakuListSakuseiMybatisParameter(出力順);
    }
}
