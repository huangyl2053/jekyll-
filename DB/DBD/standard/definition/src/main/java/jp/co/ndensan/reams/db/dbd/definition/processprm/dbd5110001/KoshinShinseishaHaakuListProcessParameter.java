/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5110001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 更新未申請者把握リスト作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinShinseishaHaakuListProcessParameter implements IBatchProcessParameter {

    private RString 印刷範囲指定;
    private RYearMonth 認定有効期間_終了月;
    private RYearMonth 認定有効期間_終了月_From;
    private RYearMonth 認定有効期間_終了月_To;

}
