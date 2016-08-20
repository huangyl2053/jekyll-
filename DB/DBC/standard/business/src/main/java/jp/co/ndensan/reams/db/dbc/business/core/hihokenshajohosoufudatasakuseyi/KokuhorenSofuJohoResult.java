/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.hihokenshajohosoufudatasakuseyi;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報送付データ作成
 *
 * @reamsid_L DBC-3300-170 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenSofuJohoResult {

    private FlexibleYearMonth 処理年月;
    private RString 交換情報識別番号;
    private RString 処理状態区分;
    private RString 前月処理状態区分;
    private RString 前々月処理状態区分;
    private YMDHMS 当月処理実施日時;
    private boolean 再処理可能区分;
}
