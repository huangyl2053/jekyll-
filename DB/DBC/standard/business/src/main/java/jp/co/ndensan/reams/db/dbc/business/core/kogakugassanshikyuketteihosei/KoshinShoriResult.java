/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.KogakuGassanShikyuGakuKeisanKekkaUpdateParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-030 quxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinShoriResult {

    private KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定Entity;
    private KogakuGassanKyufuJisseki 高額合算給付実績Entity;
    private KogakuGassanShikyuGakuKeisanKekkaUpdateParameter update合算給付実績パラメータ;
    private RString wkモード;
    private RString 更新方法;
    private RString 作成区分;

}
