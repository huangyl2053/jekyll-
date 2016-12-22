/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査督促対象者一覧表のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter implements IMyBatisParameter {

    private final RString temp_保険者コード;
    private final RString temp_認定調査委託先コード;
    private final RString temp_認定調査員コード;
    private final FlexibleDate temp_印刷期間開始日;
    private final FlexibleDate temp_印刷期間終了日;

    /**
     * コンストラクタです。
     *
     * @param temp_保険者コード 保険者コード
     * @param temp_認定調査委託先コード 認定調査委託先コード
     * @param temp_認定調査員コード 認定調査員コード
     * @param temp_印刷期間開始日 印刷期間開始日
     * @param temp_印刷期間終了日 印刷期間終了日
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter(
            RString temp_保険者コード,
            RString temp_認定調査委託先コード,
            RString temp_認定調査員コード,
            FlexibleDate temp_印刷期間開始日,
            FlexibleDate temp_印刷期間終了日
    ) {
        this.temp_保険者コード = temp_保険者コード;
        this.temp_認定調査委託先コード = temp_認定調査委託先コード;
        this.temp_認定調査員コード = temp_認定調査員コード;
        this.temp_印刷期間開始日 = temp_印刷期間開始日;
        this.temp_印刷期間終了日 = temp_印刷期間終了日;
    }

}
