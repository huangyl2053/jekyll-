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
public final class KaigoJigyoshaShisetsuKanriMapperParameter {

    private final RString jigyoshaNo;
    private final FlexibleDate yukoKaishiYMD;
    private final RString 事業者種別;
    private final RString サービス種類コード;
    private final FlexibleDate yukoShuryoYMD;

    private KaigoJigyoshaShisetsuKanriMapperParameter(
            RString jigyoshaNo,
            FlexibleDate yukoKaishiYMD,
            RString 事業者種別,
            RString サービス種類コード,
            FlexibleDate yukoShuryoYMD) {
        this.jigyoshaNo = jigyoshaNo;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.事業者種別 = 事業者種別;
        this.サービス種類コード = サービス種類コード;
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * パラメータ設定
     *
     * @param jigyoshaNo RString
     * @param yukoKaishiYMD FlexibleDate
     * @param 事業者種別 RString
     * @param サービス種類コード RString
     * @param yukoShuryoYMD FlexibleDate
     * @return JigyoshaInputGuideParameter
     */
    public static KaigoJigyoshaShisetsuKanriMapperParameter createParam(
            RString jigyoshaNo,
            FlexibleDate yukoKaishiYMD,
            RString 事業者種別,
            RString サービス種類コード,
            FlexibleDate yukoShuryoYMD) {

        return new KaigoJigyoshaShisetsuKanriMapperParameter(
                jigyoshaNo,
                yukoKaishiYMD,
                事業者種別,
                サービス種類コード,
                yukoShuryoYMD);
    }
}
