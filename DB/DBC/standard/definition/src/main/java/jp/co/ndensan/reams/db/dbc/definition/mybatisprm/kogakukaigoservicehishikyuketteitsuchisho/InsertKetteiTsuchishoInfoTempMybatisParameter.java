/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 高額サービス費支給（不支給）決定通知書作成のバッチのパラメータです
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsertKetteiTsuchishoInfoTempMybatisParameter implements IMyBatisParameter {

    private RString 抽出モード;
    private FlexibleDate 抽出条件日付From;
    private FlexibleDate 抽出条件日付To;
    private FlexibleYearMonth 決定者受付年月;
    private RString 印書;
    private RString 高額自動償還;

    /**
     * コンストラクタです。
     *
     * @param 抽出モード RString
     * @param 抽出条件日付From FlexibleDate
     * @param 抽出条件日付To FlexibleDate
     * @param 決定者受付年月 FlexibleYearMonth
     * @param 印書 RString
     * @param 高額自動償還 RString
     */
    public InsertKetteiTsuchishoInfoTempMybatisParameter(RString 抽出モード,
            FlexibleDate 抽出条件日付From,
            FlexibleDate 抽出条件日付To,
            FlexibleYearMonth 決定者受付年月,
            RString 印書,
            RString 高額自動償還) {
        this.抽出モード = 抽出モード;
        this.抽出条件日付From = 抽出条件日付From;
        this.抽出条件日付To = 抽出条件日付To;
        this.決定者受付年月 = 決定者受付年月;
        this.印書 = 印書;
        this.高額自動償還 = 高額自動償還;
    }
}
