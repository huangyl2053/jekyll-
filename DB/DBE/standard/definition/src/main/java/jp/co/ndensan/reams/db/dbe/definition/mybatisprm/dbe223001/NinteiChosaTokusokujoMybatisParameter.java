/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 *
 * 要介護認定調査督促状のMybatisパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaTokusokujoMybatisParameter implements IMyBatisParameter {

    private final FlexibleDate temp_基準日;
    private final Decimal temp_認定調査督促期限日数;
    private final RString temp_印刷済対象者;
    private final RString temp_保険者コード;
    private final RString temp_認定調査委託先コード;
    private final RString temp_認定調査員コード;
    private final RString temp_出力順;

    /**
     * コンストラクタです。
     * 
     * @param temp_基準日 基準日
     * @param temp_認定調査督促期限日数 認定調査督促期限日数
     * @param temp_印刷済対象者 印刷済対象者
     * @param temp_保険者コード 保険者コード
     * @param temp_認定調査委託先コード 認定調査委託先コード
     * @param temp_認定調査員コード 認定調査員コード
     * @param temp_出力順 出力順 
     */
    public NinteiChosaTokusokujoMybatisParameter(FlexibleDate temp_基準日,
            Decimal temp_認定調査督促期限日数,
            RString temp_印刷済対象者,
            RString temp_保険者コード,
            RString temp_認定調査委託先コード,
            RString temp_認定調査員コード,
            RString temp_出力順
          ) {
        this.temp_基準日 = temp_基準日;
        this.temp_認定調査督促期限日数 = temp_認定調査督促期限日数;
        this.temp_印刷済対象者 = temp_印刷済対象者;
        this.temp_保険者コード = temp_保険者コード;
        this.temp_認定調査委託先コード = temp_認定調査委託先コード;
        this.temp_認定調査員コード = temp_認定調査員コード;
        this.temp_出力順 = temp_出力順;
    }

}
