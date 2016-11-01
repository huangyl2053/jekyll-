/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbz00001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbz00001.TaishoshaIchijiTokuteiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 負担限度額認定者リスト作成_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaIchijiTokuteiProcessParameter implements IBatchProcessParameter {

    private TargetList 対象リスト;
    private TaishoKikan 対象期間指定;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private FlexibleDate 基準日;
    private FlexibleDate 課税判定等基準日;
    private JukyushaKubun2 受給者区分;
    private KyusochishaJukyushaKubun 旧措置者区分;

    /**
     * コンストラクタです。
     *
     * @param 対象リスト 対象リスト
     * @param 対象期間指定 対象期間指定
     * @param 対象年度の開始年月日 対象年度の開始年月日
     * @param 対象年度の終了年月日 対象年度の終了年月日
     * @param 基準日 基準日
     * @param 課税判定等基準日 課税判定等基準日
     * @param 受給者区分 受給者区分
     * @param 旧措置者区分 旧措置者区分
     */
    public TaishoshaIchijiTokuteiProcessParameter(TargetList 対象リスト,
            TaishoKikan 対象期間指定,
            FlexibleDate 対象年度の開始年月日,
            FlexibleDate 対象年度の終了年月日,
            FlexibleDate 基準日,
            FlexibleDate 課税判定等基準日,
            JukyushaKubun2 受給者区分,
            KyusochishaJukyushaKubun 旧措置者区分) {
        this.対象リスト = 対象リスト;
        this.対象期間指定 = 対象期間指定;
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.基準日 = 基準日;
        this.課税判定等基準日 = 課税判定等基準日;
        this.受給者区分 = 受給者区分;
        this.旧措置者区分 = 旧措置者区分;

    }

    /**
     * 対象者一次特定のパラメターを取得します．
     *
     * @return 対象者一次特定
     */
    public TaishoshaIchijiTokuteiMybatisParameter toTaishoshaIchijiTokuteiMybatisParameter() {
        return new TaishoshaIchijiTokuteiMybatisParameter(対象リスト,
                対象期間指定,
                対象年度の開始年月日,
                対象年度の終了年月日,
                基準日,
                課税判定等基準日,
                受給者区分,
                旧措置者区分);
    }
}
