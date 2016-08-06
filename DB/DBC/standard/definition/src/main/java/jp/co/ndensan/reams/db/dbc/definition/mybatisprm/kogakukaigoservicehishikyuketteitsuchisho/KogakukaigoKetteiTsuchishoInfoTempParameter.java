/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 高額サービス費支給（不支給）決定通知書作成のバッチのパラメータです
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakukaigoKetteiTsuchishoInfoTempParameter implements IMyBatisParameter {

    private RString 抽出モード;
    private RString 印書;
    private RString 高額自動償還;
    private RDate 抽出条件日付From;
    private RDate 抽出条件日付To;
    private RDate 決定者受付年月;

    /**
     * コンストラクタ
     *
     * @param 抽出モード RString
     * @param 印書 RString
     * @param 高額自動償還 RString
     * @param 抽出条件日付From RDate
     * @param 抽出条件日付To RDate
     * @param 決定者受付年月 RDate
     */
    public KogakukaigoKetteiTsuchishoInfoTempParameter(RString 抽出モード,
            RString 印書,
            RString 高額自動償還,
            RDate 抽出条件日付From,
            RDate 抽出条件日付To,
            RDate 決定者受付年月) {
        this.抽出モード = 抽出モード;
        this.印書 = 印書;
        this.高額自動償還 = 高額自動償還;
        this.抽出条件日付From = 抽出条件日付From;
        this.抽出条件日付To = 抽出条件日付To;
        this.決定者受付年月 = 決定者受付年月;
    }
}
