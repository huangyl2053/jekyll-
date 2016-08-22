/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanteiYoukonSakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter implements IMyBatisParameter {

    private FlexibleYear 所得年度;
    private FlexibleYear 年度;
    private RString 介護賦課;
    private RString 介護保険;

    /**
     *
     * @param 所得年度 FlexibleYear
     */
    public GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter(FlexibleYear 所得年度) {
        this.所得年度 = 所得年度;
        this.年度 = new FlexibleYear(Integer.toString(所得年度.getYearValue() - 1));
        this.介護賦課 = new RString(SubGyomuCode.DBB介護賦課.getGyomuCode().toString());
        this.介護保険 = new RString(GyomuCode.DB介護保険.getColumnValue().toString());
    }
}
