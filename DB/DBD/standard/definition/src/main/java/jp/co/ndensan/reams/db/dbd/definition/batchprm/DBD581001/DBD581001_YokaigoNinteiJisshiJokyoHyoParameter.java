/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD581001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd581001.YokaigoJissiJyokyohyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
public class DBD581001_YokaigoNinteiJisshiJokyoHyoParameter extends BatchParameterBase {

    @BatchParameter(key = "出力帳票", name = "出力帳票")
    private RString 出力帳票;
    @BatchParameter(key = "対象年度", name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = "集計単位", name = "集計単位")
    private RString 集計単位;
    @BatchParameter(key = "年齢From", name = "年齢From")
    private int 年齢From;
    @BatchParameter(key = "年齢To", name = "年齢To")
    private int 年齢To;
    @BatchParameter(key = "年齢基準日", name = "年齢基準日")
    private FlexibleDate 年齢基準日;
    @BatchParameter(key = "生年月日From", name = "生年月日From")
    private FlexibleDate 生年月日From;
    @BatchParameter(key = "生年月日To", name = "生年月日To")
    private FlexibleDate 生年月日To;
    @BatchParameter(key = "地区区分", name = "地区区分")
    private RString 地区区分;
    @BatchParameter(key = "開始地区コード", name = "開始地区コード")
    private Code 開始地区コード;
    @BatchParameter(key = "終了地区コード", name = "終了地区コード")
    private Code 終了地区コード;
    @BatchParameter(key = "基準フラグ", name = "基準フラグ")
    private RString 基準フラグ;
    @BatchParameter(key = "基準日", name = "基準日")
    private RString 基準日;
    private static final RString 月日FROM = new RString("0401");
    private static final RString 月日TO = new RString("0331");

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return YokaigoJissiJyokyohyoProcessParameter
     */
    public YokaigoJissiJyokyohyoProcessParameter toYokaigoJissiJyokyohyoProcessParameter() {
        FlexibleDate 対象年月日From = new FlexibleDate(new RString(対象年度.getYearValue()).concat(月日FROM));
        FlexibleDate 対象年月日To = new FlexibleDate(new RString(対象年度.plusYear(1).getYearValue()).concat(月日TO));
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
                集計単位,
                基準日,
                対象年度);
    }
}
