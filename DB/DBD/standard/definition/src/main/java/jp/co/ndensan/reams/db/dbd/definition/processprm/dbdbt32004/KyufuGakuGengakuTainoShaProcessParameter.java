/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32004;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32004.KyufuGakuGengakuTainoShaMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付額減額滞納者把握情報取得_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGakuGengakuTainoShaProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private TaishoKubun 対象区分;
    private boolean 通知書未発行者抽出;
    private boolean 減額適用中者抽出;
    private FlexibleDate 減額適用中者抽出基準日;
    private boolean 減額終了日抽出;
    private FlexibleDate 減額終了日範囲From;
    private FlexibleDate 減額終了日範囲To;
    private boolean 保険料完納者出力;
    private Long 改頁出力順ID;
    private ReportId 帳票ID;
    private RDateTime 帳票作成日時;

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
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    public KyufuGakuGengakuTainoShaProcessParameter(FlexibleDate 基準日,
            TaishoKubun 対象区分,
            boolean 通知書未発行者抽出,
            boolean 減額適用中者抽出,
            FlexibleDate 減額適用中者抽出基準日,
            boolean 減額終了日抽出,
            FlexibleDate 減額終了日範囲From,
            FlexibleDate 減額終了日範囲To,
            boolean 保険料完納者出力,
            Long 改頁出力順ID,
            ReportId 帳票ID,
            RDateTime 帳票作成日時) {
        this.基準日 = 基準日;
        this.対象区分 = 対象区分;
        this.通知書未発行者抽出 = 通知書未発行者抽出;
        this.減額適用中者抽出 = 減額適用中者抽出;
        this.減額適用中者抽出基準日 = 減額適用中者抽出基準日;
        this.減額終了日抽出 = 減額終了日抽出;
        this.減額終了日範囲From = 減額終了日範囲From;
        this.減額終了日範囲To = 減額終了日範囲To;
        this.保険料完納者出力 = 保険料完納者出力;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @param 出力順 出力順
     * @return ＳＱＬ使用された情報を作成します．
     */
    public KyufuGakuGengakuTainoShaMybatisParameter toTaishoShaKanriJohoMybatisParameter(RString 出力順) {
        return new KyufuGakuGengakuTainoShaMybatisParameter(出力順);
    }

}
