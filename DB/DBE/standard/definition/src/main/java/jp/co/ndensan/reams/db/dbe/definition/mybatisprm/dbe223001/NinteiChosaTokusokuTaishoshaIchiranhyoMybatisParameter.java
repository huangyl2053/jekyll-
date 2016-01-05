/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe223001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 *
 * 認定調査督促対象者一覧表のMybatisパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter implements IMyBatisParameter {

    private final FlexibleDate temp_基準日;
    private final Decimal temp_認定調査督促期限日数;
    private final RString temp_印刷済対象者;
    private final RString temp_保険者コード;
    private final RString temp_認定調査委託先コード;
    private final RString temp_認定調査員コード;
    private final RDate temp_印刷期間開始日;
    private final RDate temp_印刷期間終了日;
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
     * @param temp_印刷期間開始日 印刷期間開始日
     * @param temp_印刷期間終了日 印刷期間終了日
     * @param temp_出力順 出力順 
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter(FlexibleDate temp_基準日,
            Decimal temp_認定調査督促期限日数,
            RString temp_印刷済対象者,
            RString temp_保険者コード,
            RString temp_認定調査委託先コード,
            RString temp_認定調査員コード,
            RDate temp_印刷期間開始日,
            RDate temp_印刷期間終了日,
            RString temp_出力順
          ) {
        this.temp_基準日 = temp_基準日;
        this.temp_認定調査督促期限日数 = temp_認定調査督促期限日数;
        this.temp_印刷済対象者 = temp_印刷済対象者;
        this.temp_保険者コード = temp_保険者コード;
        this.temp_認定調査委託先コード = temp_認定調査委託先コード;
        this.temp_認定調査員コード = temp_認定調査員コード;
        this.temp_印刷期間開始日 = temp_印刷期間開始日;
        this.temp_印刷期間終了日 = temp_印刷期間終了日;
        this.temp_出力順 = temp_出力順;
    }
    
}
