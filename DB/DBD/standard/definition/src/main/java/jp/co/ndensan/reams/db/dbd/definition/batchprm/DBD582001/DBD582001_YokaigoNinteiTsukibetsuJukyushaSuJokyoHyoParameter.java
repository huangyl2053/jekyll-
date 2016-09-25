/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD582001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd582001.DBD582001ProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
public class DBD582001_YokaigoNinteiTsukibetsuJukyushaSuJokyoHyoParameter extends BatchParameterBase {

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
    private static final RString 基準0 = new RString("0");
    private static final RString 基準1 = new RString("1");
    private static final int MONTH_4 = 4;
    private static final int MONTH_12 = 12;
    private static final int SUBSTRING_4 = 4;
    private static final int SUBSTRING_6 = 6;

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return DBD582001ProcessParameter
     */
    public DBD582001ProcessParameter toDBD582001ProcessParameter() {
        FlexibleDate 基準年月日 = FlexibleDate.EMPTY;
        if (基準フラグ.equals(基準0)) {
            if (RDate.getNowDate().getMonthValue() >= MONTH_4 && RDate.getNowDate().getMonthValue() <= MONTH_12) {
                基準年月日 = new FlexibleDate(対象年度.toDateString()
                        .concat(RDate.getNowDate().toDateString().substring(SUBSTRING_4, SUBSTRING_6))
                        .concat(基準日));
            } else {
                基準年月日 = new FlexibleDate(対象年度.plusYear(1).toDateString()
                        .concat(RDate.getNowDate().toDateString().substring(SUBSTRING_4, SUBSTRING_6))
                        .concat(基準日));
            }
        }
        RString 基準年月 = RString.EMPTY;
        if (基準フラグ.equals(基準1)) {
            if (RDate.getNowDate().getMonthValue() >= MONTH_4 && RDate.getNowDate().getMonthValue() <= MONTH_12) {
                基準年月 = 対象年度.toDateString().concat(new RString(RDate.getNowDate().getMonthValue()));
            } else {
                基準年月 = 対象年度.plusYear(1).toDateString().concat(new RString(RDate.getNowDate().getMonthValue()));
            }
        }
        return new DBD582001ProcessParameter(
                基準フラグ,
                年齢基準日,
                基準年月日,
                基準年月,
                生年月日From,
                生年月日To,
                地区区分,
                開始地区コード,
                終了地区コード,
                集計単位,
                年齢From,
                年齢To,
                対象年度
        );
    }
}
