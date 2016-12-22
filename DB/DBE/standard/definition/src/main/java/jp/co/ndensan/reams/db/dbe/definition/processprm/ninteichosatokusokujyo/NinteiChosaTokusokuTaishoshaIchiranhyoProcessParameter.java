/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促対象者一覧表作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter implements IBatchProcessParameter {

    private RString temp_保険者コード;
    private RString temp_認定調査委託先コード;
    private RString temp_認定調査員コード;
    private FlexibleDate temp_印刷期間開始日;
    private FlexibleDate temp_印刷期間終了日;
    private boolean csv出力_選択された;

    /**
     * 認定調査督促対象者一覧表のMybatisパラメータを作成します。
     *
     * @return 認定調査督促対象者一覧表のMybatisパラメータ
     */
    public NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter toNinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter() {
        return new NinteiChosaTokusokuTaishoshaIchiranhyoMybatisParameter(
                this.temp_保険者コード,
                this.temp_認定調査委託先コード,
                this.temp_認定調査員コード,
                this.temp_印刷期間開始日,
                this.temp_印刷期間終了日);
    }

}
