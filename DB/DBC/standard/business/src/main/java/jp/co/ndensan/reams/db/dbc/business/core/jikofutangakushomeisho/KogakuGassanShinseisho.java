/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeisho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 自己負担額証明書作成のBusinessクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseisho implements Serializable {

    private FlexibleYear 対象年度;
    private RString 整理番号;
    private RString 支給申請書整理番号;
    private Decimal 履歴番号;
    private RString 再計算区分;
}
