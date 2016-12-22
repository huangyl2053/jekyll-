/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 要介護認定調査督促状のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaTokusokujoMybatisParameter implements IMyBatisParameter {

    private final FlexibleDate temp_認定調査督促期限;
    private final boolean is印刷済対象者対象外;
    private final RString temp_保険者コード;
    private final RString temp_認定調査委託先コード;
    private final RString temp_認定調査員コード;
    private final LasdecCode temp_市町村コード;

    /**
     * コンストラクタです。
     *
     * @param temp_基準日 基準日
     * @param temp_認定調査督促期限日数 認定調査督促期限日数
     * @param temp_印刷済対象者 印刷済対象者
     * @param temp_保険者コード 保険者コード
     * @param temp_認定調査委託先コード 認定調査委託先コード
     * @param temp_認定調査員コード 認定調査員コード
     * @param temp_市町村コード 市町村コード
     */
    public NinteiChosaTokusokujoMybatisParameter(FlexibleDate temp_基準日,
            Decimal temp_認定調査督促期限日数,
            RString temp_印刷済対象者,
            RString temp_保険者コード,
            RString temp_認定調査委託先コード,
            RString temp_認定調査員コード,
            LasdecCode temp_市町村コード
    ) {
        if (temp_基準日 != null && temp_認定調査督促期限日数 != null) {
            this.temp_認定調査督促期限 = temp_基準日.minusDay(temp_認定調査督促期限日数.intValue());
        } else {
            this.temp_認定調査督促期限 = null;
        }
        this.is印刷済対象者対象外 = temp_印刷済対象者 != null && temp_印刷済対象者.equals(new RString("1"));
        this.temp_保険者コード = temp_保険者コード;
        this.temp_認定調査委託先コード = temp_認定調査委託先コード;
        this.temp_認定調査員コード = temp_認定調査員コード;
        this.temp_市町村コード = temp_市町村コード;
    }

}
