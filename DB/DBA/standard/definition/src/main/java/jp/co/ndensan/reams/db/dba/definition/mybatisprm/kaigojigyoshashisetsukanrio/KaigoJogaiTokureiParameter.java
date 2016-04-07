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
public final class KaigoJogaiTokureiParameter {

    private final RString jigyoshaNo;
    private final FlexibleDate yukoKaishiYMD;
    private final FlexibleDate yukoShuryoYMD;

    private KaigoJogaiTokureiParameter(
            RString jigyoshaNo,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD) {
        this.jigyoshaNo = jigyoshaNo;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * パラメータ設定
     *
     * @param jigyoshaNo RString
     * @param yukoKaishiYMD FlexibleDate
     * @param yukoShuryoYMD FlexibleDate
     * @return JigyoshaInputGuideParameter
     */
    public static KaigoJogaiTokureiParameter createParam(
            RString jigyoshaNo,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD) {

        return new KaigoJogaiTokureiParameter(
                jigyoshaNo,
                yukoKaishiYMD,
                yukoShuryoYMD);
    }
}
