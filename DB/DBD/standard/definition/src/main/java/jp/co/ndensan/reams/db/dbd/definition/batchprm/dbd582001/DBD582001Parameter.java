/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd582001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd582001.DBD582001ProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class DBD582001Parameter extends BatchParameterBase {

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
    private final RString 基準0 = new RString("0");
    private final RString 基準1 = new RString("1");

    /**
     * バッチProcessパラメターを取得します．
     *
     * @return DBD582001ProcessParameter
     */
    public DBD582001ProcessParameter toDBD582001ProcessParameter() {
        FlexibleDate 基準年月日 = FlexibleDate.EMPTY;
        if (基準フラグ.equals(基準0)) {
            if (RDate.getNowDate().getMonthValue() >= 4 && RDate.getNowDate().getMonthValue() <= 12) {
                基準年月日 = new FlexibleDate(対象年度.getYear().toDateString()
                        .concat(RDate.getNowDate().toDateString().substring(4, 6))
                        .concat(基準日));
            } else {
                基準年月日 = new FlexibleDate(対象年度.getYear().plusYear(1).toDateString()
                        .concat(RDate.getNowDate().toDateString().substring(4, 6))
                        .concat(基準日));
            }
        }
        RString 基準年月 = RString.EMPTY;
        if (基準フラグ.equals(基準1)) {
            if (RDate.getNowDate().getMonthValue() >= 4 && RDate.getNowDate().getMonthValue() <= 12) {
                基準年月 = 対象年度.getYear().toDateString().concat(new RString(RDate.getNowDate().getMonthValue()));
            } else {
                基準年月 = 対象年度.getYear().plusYear(1).toDateString().concat(new RString(RDate.getNowDate().getMonthValue()));
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
