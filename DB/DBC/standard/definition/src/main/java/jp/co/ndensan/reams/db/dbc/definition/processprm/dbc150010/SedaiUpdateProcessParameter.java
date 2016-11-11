/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 利用状況統計表（明細リスト）作成_世帯コード登録のProcessParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SedaiUpdateProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth サービス提供年月;
}
