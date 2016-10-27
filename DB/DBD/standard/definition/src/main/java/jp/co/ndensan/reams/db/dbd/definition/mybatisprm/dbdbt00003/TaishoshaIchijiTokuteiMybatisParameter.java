/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00003;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TaishoKikan;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者一次特定MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaIchijiTokuteiMybatisParameter implements IMyBatisParameter {

    private static final RString 対象リスト_認定者リスト_いち = new RString("1");
    private static final RString 対象リスト_該当者リスト_に = new RString("2");
    private static final RString 受給者区分_受給者_いち = new RString("2");
    private static final RString 受給者区分_事業対象者_に = new RString("3");
    private static final RString 対象期間指定_対象年度_いち = new RString("1");
    private static final RString 対象期間指定_基準日_に = new RString("2");

    private boolean is対象リスト_該当者リスト;
    private boolean is受給者区分_受給者;
    private boolean is対象リスト_認定者リスト;
    private boolean is受給者区分_事業対象者;
    private boolean is対象期間指定_基準日;
    private boolean is対象期間指定_対象年度;
    private boolean is旧措置者区分_旧措置者;
    private boolean is旧措置者区分_旧措置者以外;
    private RString 有効無効区分_有効;
    private RString 決定区分_承認する;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private FlexibleDate 基準日;
    private FlexibleDate 課税判定等基準日;

    /**
     * 対象者一次特定一時テーブル
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
    public TaishoshaIchijiTokuteiMybatisParameter(TargetList 対象リスト,
            TaishoKikan 対象期間指定,
            FlexibleDate 対象年度の開始年月日,
            FlexibleDate 対象年度の終了年月日,
            FlexibleDate 基準日,
            FlexibleDate 課税判定等基準日,
            JukyushaKubun2 受給者区分,
            KyusochishaJukyushaKubun 旧措置者区分) {
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.基準日 = 基準日;
        this.課税判定等基準日 = 課税判定等基準日;
        this.決定区分_承認する = KetteiKubun.承認する.getコード();
        this.有効無効区分_有効 = YukoMukoKubun.有効.getコード();
        edit対象リスト(対象リスト);
        edit受給者区分(受給者区分);
        edit対象期間指定(対象期間指定);
        edit旧措置者区分(旧措置者区分);
    }

    private void edit対象リスト(TargetList 対象リスト) {
        if (対象リスト_認定者リスト_いち.equals(対象リスト.getコード())) {
            is対象リスト_認定者リスト = true;
        }
        if (対象リスト_該当者リスト_に.equals(対象リスト.getコード())) {
            is対象リスト_該当者リスト = true;
        }
    }

    private void edit受給者区分(JukyushaKubun2 受給者区分) {
        if (受給者区分 != null) {
            if (受給者区分_受給者_いち.equals(受給者区分.getコード())) {
                is受給者区分_受給者 = true;
            }
            if (受給者区分_事業対象者_に.equals(受給者区分.getコード())) {
                is受給者区分_事業対象者 = true;
            }
        }
    }

    private void edit旧措置者区分(KyusochishaJukyushaKubun 旧措置者区分) {
        if (旧措置者区分 != null) {
            if (KyusochishaJukyushaKubun.旧措置者以外.equals(旧措置者区分)) {
                is旧措置者区分_旧措置者以外 = true;
            }
            if (KyusochishaJukyushaKubun.旧措置者のみ.equals(旧措置者区分)) {
                is旧措置者区分_旧措置者 = true;
            }
        }
    }

    private void edit対象期間指定(TaishoKikan 対象期間指定) {
        if (対象期間指定 != null) {
            if (対象期間指定_対象年度_いち.equals(対象期間指定.getコード())) {
                is対象期間指定_対象年度 = true;
            }
            if (対象期間指定_基準日_に.equals(対象期間指定.getコード())) {
                is対象期間指定_基準日 = true;
            }
        }
    }

}
