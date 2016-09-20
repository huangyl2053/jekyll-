/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511003;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 更新未申請者把握リスト作成のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD511003_KoshinMiShinseishaHaakuParameter extends BatchParameterBase {

    private RString 印刷範囲指定;
    private RYearMonth 認定有効期間_終了月;
    private RYearMonth 認定有効期間_終了月_From;
    private RYearMonth 認定有効期間_終了月_To;

}
