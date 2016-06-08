/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

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
    private final RYearMonth sysDateYM;

    private KaigoJogaiTokureiParameter(
            RString jigyoshaNo,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD,
            RYearMonth sysDateYM) {
        this.jigyoshaNo = jigyoshaNo;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
        this.sysDateYM = sysDateYM;
    }

    /**
     * パラメータ設定
     *
     * @param jigyoshaNo RString
     * @param yukoKaishiYMD FlexibleDate
     * @param yukoShuryoYMD FlexibleDate
     * @param sysDateYM FlexibleDate
     * @return JigyoshaInputGuideParameter
     */
    public static KaigoJogaiTokureiParameter createParam(
            RString jigyoshaNo,
            FlexibleDate yukoKaishiYMD,
            FlexibleDate yukoShuryoYMD,
            RYearMonth sysDateYM) {

        return new KaigoJogaiTokureiParameter(
                jigyoshaNo,
                yukoKaishiYMD,
                yukoShuryoYMD,
                sysDateYM);
    }
}
