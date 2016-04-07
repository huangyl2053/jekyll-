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

    private final RString jigyoshaNo;
    private final RString 事業者種別;
    private final FlexibleDate yukoKaishiYMD;
    private final FlexibleDate yukoShuryoYMD;

    private KaigoJigyoshaParameter(
            RString jigyoshaNo,
            RString 事業者種別,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD) {
        this.jigyoshaNo = jigyoshaNo;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
        this.事業者種別 = 事業者種別;
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
            FlexibleDate yukoKaishiYMD,
            RString 事業者種別,
            FlexibleDate yukoShuryoYMD) {

        return new KaigoJigyoshaParameter(
                jigyoshaNo,
                事業者種別,
                yukoKaishiYMD,
                yukoShuryoYMD);
    }
}
