/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *　
 * 認定調査督促対象者一覧表作成_バッチ処理クラスパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter implements IBatchProcessParameter {
    
    private RString temp_保険者コード;
    private RString temp_保険者名称;
    private RString temp_認定調査委託先コード;
    private RString temp_認定調査員コード;
    private FlexibleDate temp_基準日;
    private Decimal temp_認定調査督促期限日数;
    private RString temp_印刷済対象者;
    private RDate temp_印刷期間開始日;
    private RDate temp_印刷期間終了日;
    private RString temp_出力順;
    private RString temp_改頁;
    
    /**
     * 認定調査督促対象者一覧表のMybatisパラメータを作成します。
     * 
     * @return 認定調査督促対象者一覧表のMybatisパラメータ
     */ 
    public NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter toNinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter() {
        return new NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter(this.temp_基準日,
            this.temp_認定調査督促期限日数,
            this.temp_印刷済対象者,
            this.temp_保険者コード,
            this.temp_認定調査委託先コード,
            this.temp_認定調査員コード,
            this.temp_印刷期間開始日,
            this.temp_印刷期間終了日,
            this.temp_出力順);
    }
    
}
