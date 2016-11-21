/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb021051;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb021051.DBB021051MyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のプロセスパラメタークラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBB021051ProcessParameter implements IBatchProcessParameter {

    private static final RString EMPTYCODE = new RString("000000");
    private static final RString FULLYEAR = new RString("0000");
    private static final RString FULLMONTH = new RString("00");
    private RString 抽出対象者;
    private RYearMonth 基準年月;
    private RString 資格区分;
    private RString 市町村指定;
    private RString 最優先住所;
    private RString 敬称;
    private RString 被保番号表示;
    private RString 宛先住所設定;
    private long 出力順ID;
    private RString 業務コード;

    private RString 市町村指定に市町村コード;
    private RString 市町村指定に市町村名称;
    private RString 市町村名称;
    private RString 都道府県名称;
    private RString 郡名称;

    /**
     * DBB021051MyBatisParameterのメソッドです。
     *
     * @param 出力順 RString
     * @return DBB021051MyBatisParameter
     */
    public DBB021051MyBatisParameter toDBB021051MyBatisParameter(RString 出力順) {
        DBB021051MyBatisParameter param = new DBB021051MyBatisParameter();
        param.set抽出対象者(抽出対象者);
        param.set資格区分(資格区分);
        param.set市町村指定(市町村指定);
        param.set市町村指定に市町村コード(EMPTYCODE.equals(市町村指定に市町村コード) ? null : 市町村指定に市町村コード);
        param.set基準年月の年(formatYearFull(基準年月.getYearValue()));
        param.set基準年月の月(formatMonthFull(基準年月.getMonthValue()));
        param.set最優先住所(最優先住所);
        param.set出力順(出力順);
        return param;
    }

    private RString formatYearFull(Integer year) {
        if (year == null) {
            return RString.EMPTY;
        }
        return new RString(new Decimal(year).toString(FULLYEAR.toString()));
    }

    private RString formatMonthFull(Integer month) {
        if (month == null) {
            return RString.EMPTY;
        }
        return new RString(new Decimal(month).toString(FULLMONTH.toString()));
    }

}
