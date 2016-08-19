/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd582001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定月別受給者数状況表（統計表）(バッチ)SQLのパラメータクラス
 *
 * @reamsid_L DBD-1771-033 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiTsukibetsuJukyushaMybatisParameter implements IMyBatisParameter {

    private boolean is基準フラグ0;
    private boolean is基準フラグ1;
    private FlexibleDate 年齢基準日;
    private FlexibleDate 基準年月日;
    private RString 基準年月;
    private FlexibleDate 生年月日From;
    private FlexibleDate 生年月日To;
    private FlexibleDate 生年月日From2;
    private FlexibleDate 生年月日To2;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 集計単位;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param 基準フラグ 基準フラグ
     * @param 年齢基準日 年齢基準日
     * @param 基準年月日 基準年月日
     * @param 基準年月 基準年月
     * @param 生年月日From 生年月日From
     * @param 生年月日To 生年月日To
     * @param 地区区分 地区区分
     * @param 開始地区コード 開始地区コード
     * @param 終了地区コード 終了地区コード
     * @param 集計単位 集計単位
     * @param 年齢From 年齢From
     * @param 年齢To 年齢To
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public YokaigoNinteiTsukibetsuJukyushaMybatisParameter(
            RString 基準フラグ,
            FlexibleDate 年齢基準日,
            FlexibleDate 基準年月日,
            RString 基準年月,
            FlexibleDate 生年月日From,
            FlexibleDate 生年月日To,
            RString 地区区分,
            Code 開始地区コード,
            Code 終了地区コード,
            RString 集計単位,
            int 年齢From,
            int 年齢To,
            RString psmShikibetsuTaisho) {
        if (基準フラグ.equals(new RString("0"))) {
            this.is基準フラグ0 = true;
        } else if (基準フラグ.equals(new RString("1"))) {
            this.is基準フラグ1 = true;
        }
        this.年齢基準日 = 年齢基準日;
        this.基準年月日 = 基準年月日;
        this.基準年月 = 基準年月;
        this.生年月日From = 生年月日From;
        this.生年月日To = 生年月日To;
        this.生年月日From2 = 年齢基準日.minusYear(年齢From);
        this.生年月日To2 = 年齢基準日.minusYear(年齢To);
        this.地区区分 = 地区区分;
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.集計単位 = 集計単位;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
