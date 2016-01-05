/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001.NinteiChosaTokusokujoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *　
 * 要介護認定調査督促状作成_バッチ処理クラスパラメータクラスです。
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
    private RString temp_出力順;
        
   /**
     * 要介護認定調査督促状のMybatisパラメータを作成します。
     * 
     * @return 要介護認定調査督促状のMybatisパラメータ
     */
    public NinteiChosaTokusokujoMybatisParameter toNinteiChosaTokusokujoMybatisParameter() {
        this.temp_基準日 = this.temp_基準日.minusDay(Integer.parseInt(temp_認定調査督促期限日数.toString()));
        
        return new NinteiChosaTokusokujoMybatisParameter(this.temp_基準日,
                                    this.temp_認定調査督促期限日数,
                                    this.temp_印刷済対象者,
                                    this.temp_保険者コード,
                                    this.temp_認定調査委託先コード,
                                    this.temp_認定調査員コード,
                                    this.temp_出力順);
    }
}
