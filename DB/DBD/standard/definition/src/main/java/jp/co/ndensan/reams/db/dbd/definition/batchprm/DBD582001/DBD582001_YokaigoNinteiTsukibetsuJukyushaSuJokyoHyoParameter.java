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
    private static final RString MONTH_4 = new RString("04");
    private static final RString MONTH_5 = new RString("05");
    private static final RString MONTH_6 = new RString("06");
    private static final RString MONTH_7 = new RString("07");
    private static final RString MONTH_8 = new RString("08");
    private static final RString MONTH_9 = new RString("09");
    private static final RString MONTH_10 = new RString("10");
    private static final RString MONTH_11 = new RString("11");
    private static final RString MONTH_12 = new RString("12");
    private static final RString MONTH_1 = new RString("01");
    private static final RString MONTH_2 = new RString("02");
    private static final RString MONTH_3 = new RString("03");

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return DBD582001ProcessParameter
     */
    public DBD582001ProcessParameter toDBD582001ProcessParameter() {
        FlexibleDate 基準年月日04 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日05 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日06 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日07 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日08 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日09 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日10 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日11 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日12 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日01 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日02 = FlexibleDate.EMPTY;
        FlexibleDate 基準年月日03 = FlexibleDate.EMPTY;
        if (基準フラグ.equals(基準0)) {
            基準年月日04 = new FlexibleDate(対象年度.toDateString().concat(MONTH_4).concat(基準日));
            基準年月日05 = new FlexibleDate(対象年度.toDateString().concat(MONTH_5).concat(基準日));
            基準年月日06 = new FlexibleDate(対象年度.toDateString().concat(MONTH_6).concat(基準日));
            基準年月日07 = new FlexibleDate(対象年度.toDateString().concat(MONTH_7).concat(基準日));
            基準年月日08 = new FlexibleDate(対象年度.toDateString().concat(MONTH_8).concat(基準日));
            基準年月日09 = new FlexibleDate(対象年度.toDateString().concat(MONTH_9).concat(基準日));
            基準年月日10 = new FlexibleDate(対象年度.toDateString().concat(MONTH_10).concat(基準日));
            基準年月日11 = new FlexibleDate(対象年度.toDateString().concat(MONTH_11).concat(基準日));
            基準年月日12 = new FlexibleDate(対象年度.toDateString().concat(MONTH_12).concat(基準日));
            基準年月日01 = new FlexibleDate(対象年度.plusYear(1).toDateString().concat(MONTH_1).concat(基準日));
            基準年月日02 = new FlexibleDate(対象年度.plusYear(1).toDateString().concat(MONTH_2).concat(基準日));
            基準年月日03 = new FlexibleDate(対象年度.plusYear(1).toDateString().concat(MONTH_3).concat(基準日));
        }
        RString 基準年月04 = RString.EMPTY;
        RString 基準年月05 = RString.EMPTY;
        RString 基準年月06 = RString.EMPTY;
        RString 基準年月07 = RString.EMPTY;
        RString 基準年月08 = RString.EMPTY;
        RString 基準年月09 = RString.EMPTY;
        RString 基準年月10 = RString.EMPTY;
        RString 基準年月11 = RString.EMPTY;
        RString 基準年月12 = RString.EMPTY;
        RString 基準年月01 = RString.EMPTY;
        RString 基準年月02 = RString.EMPTY;
        RString 基準年月03 = RString.EMPTY;
        if (基準フラグ.equals(基準1)) {
            基準年月04 = 対象年度.toDateString().concat(MONTH_4);
            基準年月05 = 対象年度.toDateString().concat(MONTH_5);
            基準年月06 = 対象年度.toDateString().concat(MONTH_6);
            基準年月07 = 対象年度.toDateString().concat(MONTH_7);
            基準年月08 = 対象年度.toDateString().concat(MONTH_8);
            基準年月09 = 対象年度.toDateString().concat(MONTH_9);
            基準年月10 = 対象年度.toDateString().concat(MONTH_10);
            基準年月11 = 対象年度.toDateString().concat(MONTH_11);
            基準年月12 = 対象年度.toDateString().concat(MONTH_12);
            基準年月01 = 対象年度.plusYear(1).toDateString().concat(MONTH_1);
            基準年月02 = 対象年度.plusYear(1).toDateString().concat(MONTH_2);
            基準年月03 = 対象年度.plusYear(1).toDateString().concat(MONTH_3);
        }
        return new DBD582001ProcessParameter(
                基準フラグ,
                年齢基準日,
                基準年月日04,
                基準年月日05,
                基準年月日06,
                基準年月日07,
                基準年月日08,
                基準年月日09,
                基準年月日10,
                基準年月日11,
                基準年月日12,
                基準年月日01,
                基準年月日02,
                基準年月日03,
                基準年月04,
                基準年月05,
                基準年月06,
                基準年月07,
                基準年月08,
                基準年月09,
                基準年月10,
                基準年月11,
                基準年月12,
                基準年月01,
                基準年月02,
                基準年月03,
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
