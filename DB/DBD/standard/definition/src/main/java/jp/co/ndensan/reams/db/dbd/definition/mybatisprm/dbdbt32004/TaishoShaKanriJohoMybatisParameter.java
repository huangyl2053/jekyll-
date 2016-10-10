/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32004;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist.TaishoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.taino.MinoKannoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者管理情報の取得MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoShaKanriJohoMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 基準日;
    private FlexibleDate 基準日の2年前;
    private boolean is通知書未発行者抽出;
    private boolean is減額適用中者抽出;
    private FlexibleDate 減額適用中者抽出基準日;
    private boolean is減額終了日抽出;
    private FlexibleDate 減額終了日範囲From;
    private FlexibleDate 減額終了日範囲To;
    private boolean is保険料完納者出力;
    private boolean is対象区分_全登録者以外;
    private RString 未納完納区分_未納あり;
    private FlexibleDate システム日付;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 対象区分 対象区分
     * @param 通知書未発行者抽出 通知書未発行者抽出
     * @param 減額適用中者抽出 減額適用中者抽出
     * @param 減額適用中者抽出基準日 減額適用中者抽出基準日
     * @param 減額終了日抽出 減額終了日抽出
     * @param 減額終了日範囲From 減額終了日範囲From
     * @param 減額終了日範囲To 減額終了日範囲To
     * @param 保険料完納者出力 保険料完納者出力
     * @param システム日付 システム日付
     */
    public TaishoShaKanriJohoMybatisParameter(FlexibleDate 基準日,
            TaishoKubun 対象区分,
            boolean 通知書未発行者抽出,
            boolean 減額適用中者抽出,
            FlexibleDate 減額適用中者抽出基準日,
            boolean 減額終了日抽出,
            FlexibleDate 減額終了日範囲From,
            FlexibleDate 減額終了日範囲To,
            boolean 保険料完納者出力,
            RDate システム日付) {
        this.基準日 = 基準日;
        if (基準日 != null && 基準日.isWareki()) {
            this.基準日の2年前 = 基準日.minusYear(2);
        } else {
            this.基準日の2年前 = FlexibleDate.EMPTY;
        }
        this.is通知書未発行者抽出 = 通知書未発行者抽出;
        this.is減額適用中者抽出 = 減額適用中者抽出;
        this.減額適用中者抽出基準日 = 減額適用中者抽出基準日;
        this.is減額終了日抽出 = 減額終了日抽出;
        this.減額終了日範囲From = 減額終了日範囲From;
        this.減額終了日範囲To = 減額終了日範囲To;
        this.is保険料完納者出力 = 保険料完納者出力;
        this.システム日付 = new FlexibleDate(システム日付.toDateString());
        this.未納完納区分_未納あり = MinoKannoKubun.未納あり.getコード();
        is対象区分_全登録者以外 = TaishoKubun.全登録者以外.equals(対象区分);
    }
}
