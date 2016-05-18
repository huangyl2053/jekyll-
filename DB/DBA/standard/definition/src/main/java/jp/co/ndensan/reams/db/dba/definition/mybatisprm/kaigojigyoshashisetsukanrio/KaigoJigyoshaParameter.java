/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護事業者・施設管理のParameterクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KaigoJigyoshaParameter {

    private final boolean 有効開始日フラグ;
    private final RString jigyoshaNo;
    private final RString 事業者種別;
    private final FlexibleDate yukoKaishiYMD;
    private final FlexibleDate yukoShuryoYMD;

    private KaigoJigyoshaParameter(
            boolean 有効開始日フラグ,
            RString jigyoshaNo,
            RString 事業者種別,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD) {
        this.jigyoshaNo = jigyoshaNo;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
        this.事業者種別 = 事業者種別;
        this.有効開始日フラグ = 有効開始日フラグ;
    }

    /**
     * パラメータ設定
     *
     * @param jigyoshaNo RString
     * @param yukoKaishiYMD FlexibleDate
     * @param 事業者種別 RString
     * @param yukoShuryoYMD FlexibleDate
     * @return JigyoshaInputGuideParameter
     */
    public static KaigoJigyoshaParameter createParam(
            RString jigyoshaNo,
            RString 事業者種別,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD) {
        boolean 有効開始日フラグ = true;
        if (yukoKaishiYMD == null) {
            有効開始日フラグ = false;
        }

        return new KaigoJigyoshaParameter(
                有効開始日フラグ,
                jigyoshaNo,
                事業者種別,
                yukoKaishiYMD,
                yukoShuryoYMD);
    }
}
