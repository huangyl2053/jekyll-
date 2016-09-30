/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 集計キーごとに、要介護別集計を、日数_回数、単位数を取得するEntityクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaniSuNissuKaisuEntity {

    private RString サービス種類コード;
    private RString ソート用サービス項目コード;
    private RString 要介護状態区分コード;
    private Decimal 日数_回数集計値;
    private Decimal 単位数集計値;

}
