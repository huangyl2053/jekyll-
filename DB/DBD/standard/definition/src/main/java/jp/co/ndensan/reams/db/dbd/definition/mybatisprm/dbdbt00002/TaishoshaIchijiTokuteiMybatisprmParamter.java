/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00002;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免減額対象者判定用検索条件
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaIchijiTokuteiMybatisprmParamter implements IMyBatisParameter {

    private FlexibleDate 基準日;
    private boolean is認定者リスト = false;
    private boolean is該当者リスト = false;
    private boolean is受給者 = false;
    private boolean is事業対象者 = false;
    private boolean is旧措置者 = false;
    private boolean is旧措置者以外 = false;
    private RString 有効;

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象リスト 対象リスト
     * @param 受給者区分 受給者区分
     * @param 旧措置区分 旧措置区分
     * @param 基準日 基準日
     */
    public TaishoshaIchijiTokuteiMybatisprmParamter(
            TargetList 対象リスト, JukyushaKubun2 受給者区分,
            KyusochishaJukyushaKubun 旧措置区分, FlexibleDate 基準日) {
        this.基準日 = 基準日;
        edit対象リスト(対象リスト);
        edit受給者区分(受給者区分);
        edit旧措置区分(旧措置区分);
        this.有効 = YukoMukoKubun.有効.getコード();
    }

    private void edit対象リスト(TargetList 対象リスト) {

        if (対象リスト != null) {
            if (TargetList.認定者リスト.equals(対象リスト)) {
                is認定者リスト = true;
            } else if (TargetList.該当者リスト.equals(対象リスト)) {
                is該当者リスト = true;
            }
        }
    }

    private void edit受給者区分(JukyushaKubun2 受給者区分) {
        if (受給者区分 != null) {
            if (JukyushaKubun2.受給者.equals(受給者区分)) {
                is受給者 = true;
            } else if (JukyushaKubun2.事業対象者.equals(受給者区分)) {
                is事業対象者 = true;
            }
        }
    }

    private void edit旧措置区分(KyusochishaJukyushaKubun 旧措置区分) {
        if (旧措置区分 != null) {
            if (KyusochishaJukyushaKubun.旧措置者以外.equals(旧措置区分)) {
                is旧措置者以外 = true;
            } else if (KyusochishaJukyushaKubun.旧措置者のみ.equals(旧措置区分)) {
                is旧措置者 = true;
            }
        }
    }

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象リスト 対象リスト
     * @param 受給者区分 受給者区分
     * @param 旧措置区分 旧措置区分
     * @param 基準日 基準日
     * @return TaishoshaIchijiTokuteiMybatisprmParamter
     */
    public TaishoshaIchijiTokuteiMybatisprmParamter ceactTestParmeter(
            TargetList 対象リスト, JukyushaKubun2 受給者区分, KyusochishaJukyushaKubun 旧措置区分, FlexibleDate 基準日) {
        return new TaishoshaIchijiTokuteiMybatisprmParamter(対象リスト, 受給者区分, 旧措置区分, 基準日);
    }
}
