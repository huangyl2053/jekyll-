/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.NinteichosaIraiUpdateMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼情報更新_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteichosaIraiJohoUpdateProcessParameter implements IBatchProcessParameter {

    private List<RString> 申請書管理番号;
    private RString temp_督促日;
    private RString temp_督促方法;
    private RString temp_督促メモ;

    /**
     * 認定調査依頼情報更新のMybatisパラメータを作成します。
     *
     * @return 認定調査依頼情報更新のMybatisパラメータ
     */
    public NinteichosaIraiUpdateMybatisParameter toNinteiChosaTokusokujoMybatisParameter() {
        return new NinteichosaIraiUpdateMybatisParameter(申請書管理番号,
                this.temp_督促日,
                this.temp_督促方法,
                this.temp_督促メモ);
    }
}
