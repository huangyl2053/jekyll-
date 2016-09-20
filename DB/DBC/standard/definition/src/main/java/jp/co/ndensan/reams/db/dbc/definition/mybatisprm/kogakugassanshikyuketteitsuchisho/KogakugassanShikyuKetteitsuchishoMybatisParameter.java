/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給決定通知書（一括）のMYBATIS用パラメータクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KogakugassanShikyuKetteitsuchishoMybatisParameter implements IMyBatisParameter {

    private RString 日付選択区分;
    private RString 印書区分;
    private FlexibleYearMonth 受取年月;
    private FlexibleDate 受取年月_01;
    private FlexibleDate 申請開始年月日;
    private FlexibleDate 申請終了年月日;
    private FlexibleDate 決定開始年月日;
    private FlexibleDate 決定終了年月日;
    private long 口座ID;
    private SubGyomuCode サブ業務コード;
    private LasdecCode 市町村コード;
    private RString 処理名;
    private RString 処理枝番;
    private RString 出力順;
    private FlexibleDate 基準年月日;
}
