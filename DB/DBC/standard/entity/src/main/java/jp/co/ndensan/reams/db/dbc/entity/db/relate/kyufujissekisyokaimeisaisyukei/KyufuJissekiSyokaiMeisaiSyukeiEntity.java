/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekisyokaimeisaisyukei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績照会_明細集計画面処理RelateEntityクラスです。
 *
 * @reamsid_L DBC-2970-040 zhaoyao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiSyokaiMeisaiSyukeiEntity {

    private RString hokenjaShubetsu;
    private RString hokenjaNo;
    private RString hokenjaName;
}
