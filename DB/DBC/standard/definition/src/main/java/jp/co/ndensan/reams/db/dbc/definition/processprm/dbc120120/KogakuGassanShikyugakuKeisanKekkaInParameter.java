/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120120;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給額計算結果連絡票情報確認リストを出力用パラメータクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyugakuKeisanKekkaInParameter implements IBatchProcessParameter {

    private RString 出力順ID;
    private RDateTime 作成日時;
    private FlexibleYearMonth 処理年月;
    private int 計算結果登録件数;
    private int 計算結果明細登録件数;
    private RString 処理区分;

}
