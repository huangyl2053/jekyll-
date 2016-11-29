/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * バッチ設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のProcessパラメタークラスです。
 *
 * @reamsid_L DBC-4790-030 pengxingyis
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080JigyobunKogakuGassanJikofutangakuKeisanProcessParameter implements IBatchProcessParameter {

    private RDateTime 処理日時;
    private FlexibleYearMonth 受取年月;
    private LasdecCode 市町村コード;
}
