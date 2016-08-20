/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaTokuteiMyBatisParameter implements IMyBatisParameter {

    private boolean is旧措置区分_旧措置者;
    private boolean is旧措置区分_旧措置者以外;
    private boolean is新規更新区分_新規;
    private boolean is新規更新区分_更新;
    private boolean is施設入所区分_入所者のみ;
    private boolean is施設入所区分_入所者以外;

    private FlexibleDate 基準日;
    private RString 旧措置区分;
    private RString 新規更新区分;
    private RString 施設入所区分;
    private GemmenGengakuShurui 減免減額種類;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;

    /**
     *
     * @param 新規更新区分 RString
     * @param 減免減額種類 GemmenGengakuShurui
     * @param 旧措置区分 RString
     * @param 施設入所区分 RString
     * @param 基準日 FlexibleDate
     * @param 前年度の開始日 FlexibleDate
     * @param 前年度の終了日 FlexibleDate
     */
    public HanteiTaishoshaTokuteiMyBatisParameter(RString 新規更新区分, GemmenGengakuShurui 減免減額種類,
            RString 旧措置区分, RString 施設入所区分, FlexibleDate 基準日,
            FlexibleDate 前年度の開始日, FlexibleDate 前年度の終了日) {
        this.基準日 = 基準日;
        this.減免減額種類 = 減免減額種類;
        this.新規更新区分 = 新規更新区分;
        this.施設入所区分 = 施設入所区分;
        this.旧措置区分 = 旧措置区分;
        this.前年度の開始日 = 前年度の開始日;
        this.前年度の終了日 = 前年度の終了日;
        set旧措置区分について(旧措置区分);
        set新規更新区分について(新規更新区分);
        set施設入所区分について(施設入所区分);
    }

    /**
     *
     * @param 新規更新区分 RString
     * @param 旧措置区分 RString
     * @param 施設入所区分 RString
     * @param 基準日 FlexibleDate
     * @param 前年度の開始日 FlexibleDate
     * @param 前年度の終了日 FlexibleDate
     */
    public HanteiTaishoshaTokuteiMyBatisParameter(FlexibleDate 基準日, RString 旧措置区分, RString 新規更新区分, RString 施設入所区分,
            FlexibleDate 前年度の開始日, FlexibleDate 前年度の終了日) {
        this.基準日 = 基準日;
        set旧措置区分について(旧措置区分);
        set新規更新区分について(新規更新区分);
        set施設入所区分について(施設入所区分);
        this.前年度の開始日 = 前年度の開始日;
        this.前年度の終了日 = 前年度の終了日;
    }

    private void set旧措置区分について(RString 旧措置区分) {
        RString 旧措置区分_旧措置者 = new RString("旧措置者");
        RString 旧措置区分_旧措置者以外 = new RString("旧措置者以外");
        if (旧措置区分_旧措置者.equals(旧措置区分)) {
            is旧措置区分_旧措置者 = true;
        } else {
            is旧措置区分_旧措置者 = false;
        }
        if (旧措置区分_旧措置者以外.equals(旧措置区分)) {
            is旧措置区分_旧措置者以外 = true;
        } else {
            is旧措置区分_旧措置者以外 = false;
        }
    }

    private void set新規更新区分について(RString 新規更新区分) {
        RString 新規更新区分_新規 = new RString("新規");
        RString 新規更新区分_更新 = new RString("更新");
        if (新規更新区分_新規.equals(新規更新区分)) {
            is新規更新区分_新規 = true;
        } else {
            is新規更新区分_新規 = false;
        }
        if (新規更新区分_更新.equals(新規更新区分)) {
            is新規更新区分_更新 = true;
        } else {
            is新規更新区分_更新 = false;
        }
    }

    private void set施設入所区分について(RString 施設入所区分) {
        RString 施設入所区分_入所者のみ = new RString("入所者のみ");
        RString 施設入所区分_入所者以外 = new RString("入所者以外");
        if (施設入所区分_入所者のみ.equals(施設入所区分)) {
            is施設入所区分_入所者のみ = true;
        } else {
            is施設入所区分_入所者のみ = false;
        }
        if (施設入所区分_入所者以外.equals(施設入所区分)) {
            is施設入所区分_入所者以外 = true;
        } else {
            is施設入所区分_入所者以外 = false;
        }
    }

}
