/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo.NinteiChosaTokusokujoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定調査督促状作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@lombok.Getter
@lombok.Setter
public class NinteiChosaTokusokujoProcessParameter implements IBatchProcessParameter {

    private RString temp_保険者コード;
    private RString temp_認定調査委託先コード;
    private RString temp_認定調査員コード;
    private FlexibleDate temp_基準日;
    private Decimal temp_認定調査督促期限日数;
    private RString temp_印刷済対象者;
    private FlexibleDate temp_督促日;
    private RString temp_督促方法;
    private RString temp_督促メモ;
    private RString temp_文書番号;

    /**
     * 要介護認定調査督促状のMybatisパラメータを作成します。
     *
     * @return 要介護認定調査督促状のMybatisパラメータ
     */
    public NinteiChosaTokusokujoMybatisParameter toNinteiChosaTokusokujoMybatisParameter() {

        return new NinteiChosaTokusokujoMybatisParameter(this.temp_基準日.minusDay(Integer.parseInt(temp_認定調査督促期限日数.toString())),
                this.temp_認定調査督促期限日数,
                this.temp_印刷済対象者,
                this.temp_保険者コード,
                this.temp_認定調査委託先コード,
                this.temp_認定調査員コード,
                null);
    }

    /**
     * 要介護認定調査督促状のMybatisパラメータを作成します。
     *
     * @param temp_市町村コード 市町村コード
     * @return 要介護認定調査督促状のMybatisパラメータ
     */
    public NinteiChosaTokusokujoMybatisParameter toNinteiChosaTokusokujoMybatisParameter(LasdecCode temp_市町村コード) {

        return new NinteiChosaTokusokujoMybatisParameter(this.temp_基準日.minusDay(Integer.parseInt(temp_認定調査督促期限日数.toString())),
                this.temp_認定調査督促期限日数,
                this.temp_印刷済対象者,
                this.temp_保険者コード,
                this.temp_認定調査委託先コード,
                this.temp_認定調査員コード,
                temp_市町村コード);
    }
}
