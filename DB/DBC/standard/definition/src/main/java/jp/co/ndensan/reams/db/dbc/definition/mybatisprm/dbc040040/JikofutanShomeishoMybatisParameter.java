/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040040;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 自己負担額証明書作成（括）のMybatisパラメータです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JikofutanShomeishoMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 申請開始年月日;
    private FlexibleDate 申請終了年月日;
    private FlexibleYearMonth 受取年月;
    private RString 抽出対象;

    private RString 出力順;
    private RString 対象年度区分;
    private LasdecCode 市町村コード;

}
