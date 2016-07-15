/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 対象者データTempEntity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuchoHeijunkaRokuBatchTaishogaiIchiran {

    private TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外;
    private Decimal 今年度保険料率;
    private Decimal 調整金額;

    /**
     * コンストラクタです。
     *
     * @param 特徴平準化結果対象外 TokuchoHeijyunkaTaishogaiEntity
     * @param 今年度保険料率 Decimal
     * @param 調整金額 Decimal
     */
    public TokuchoHeijunkaRokuBatchTaishogaiIchiran(TokuchoHeijyunkaTaishogaiEntity 特徴平準化結果対象外,
            Decimal 今年度保険料率, Decimal 調整金額) {
        this.特徴平準化結果対象外 = 特徴平準化結果対象外;
        this.今年度保険料率 = 今年度保険料率;
        this.調整金額 = 調整金額;
    }
}
