/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 月別推移表ヘッダのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuSuiihyoHeaderItem {

    public final RString printTimeStamp;
    public final RString gengo;
    public final RString nendo;
    public final RString hokenshaNo;
    public final RString hokenshaName;
    public final RString listTitle_1;
    public final RString choshuHouhouTitle;
    public final RString ninsuGokeiTitle;
    public final RString kingakuGokeiTitle;

    /**
     * インスタンスを生成します。
     *
     * @param printTimeStamp 印刷日時
     * @param gengo 元号
     * @param nendo 年度
     * @param hokenshaNo 保険者番号
     * @param hokenshaName 保険者名称
     * @param listTitle_1 listTitle_1
     * @param choshuHouhouTitle 徴収方法Title
     * @param ninsuGokeiTitle 人数合計Title
     * @param kingakuGokeiTitle 金額合計Title
     */
    public TsukibetsuSuiihyoHeaderItem(
            RString printTimeStamp,
            RString gengo,
            RString nendo,
            RString hokenshaNo,
            RString hokenshaName,
            RString listTitle_1,
            RString choshuHouhouTitle,
            RString ninsuGokeiTitle,
            RString kingakuGokeiTitle) {
        this.printTimeStamp = printTimeStamp;
        this.gengo = gengo;
        this.nendo = nendo;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaName = hokenshaName;
        this.listTitle_1 = listTitle_1;
        this.choshuHouhouTitle = choshuHouhouTitle;
        this.ninsuGokeiTitle = ninsuGokeiTitle;
        this.kingakuGokeiTitle = kingakuGokeiTitle;
    }
}
