/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd581001.YokaigoJissiJyokyohyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定実施状況表（統計表）のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoJissiJyokyohyoParameter extends BatchParameterBase {

    private RString 出力帳票;
    private FlexibleDate 対象年度;
    private RString 集計単位;
    private int 年齢From;
    private int 年齢To;
    private FlexibleDate 年齢基準日;
    private FlexibleDate 生年月日From;
    private FlexibleDate 生年月日To;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 基準フラグ;
    private RString 基準日;

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return YokaigoJissiJyokyohyoProcessParameter
     */
    public YokaigoJissiJyokyohyoProcessParameter toYokaigoJissiJyokyohyoProcessParameter() {
        FlexibleDate 対象年月日From = new FlexibleDate(new RString(対象年度.getYearValue()).concat(new RString("0401")));
        FlexibleDate 対象年月日To = new FlexibleDate(new RString(対象年度.plusYear(1).getYearValue()).concat(new RString("0331")));
        return new YokaigoJissiJyokyohyoProcessParameter(
                出力帳票,
                対象年月日From,
                対象年月日To,
                年齢基準日,
                年齢From,
                年齢To,
                生年月日From,
                生年月日To,
                地区区分,
                開始地区コード,
                終了地区コード,
                集計単位);
    }
}
