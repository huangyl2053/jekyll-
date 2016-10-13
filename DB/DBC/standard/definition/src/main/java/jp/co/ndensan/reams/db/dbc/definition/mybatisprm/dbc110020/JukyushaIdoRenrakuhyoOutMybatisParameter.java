/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110020;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 受給者異動連絡票作成MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2720-030 chenhui
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaIdoRenrakuhyoOutMybatisParameter implements IMyBatisParameter {

    private RYearMonth 処理年月;
    private RString 再処理区分;
    private RString 抽出条件;
    private RString ファイル名;
}
