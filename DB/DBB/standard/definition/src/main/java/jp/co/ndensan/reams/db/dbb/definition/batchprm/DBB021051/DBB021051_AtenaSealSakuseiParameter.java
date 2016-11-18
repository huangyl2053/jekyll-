/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021051;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb021051.DBB021051ProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のバッチパラメタークラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBB021051_AtenaSealSakuseiParameter extends BatchParameterBase {

    @BatchParameter(key = "抽出対象者", name = "抽出対象者")
    private RString 抽出対象者;
    @BatchParameter(key = "基準年月", name = "基準年月")
    private RYearMonth 基準年月;
    @BatchParameter(key = "資格区分", name = "資格区分")
    private RString 資格区分;
    @BatchParameter(key = "市町村指定", name = "市町村指定")
    private RString 市町村指定;
    @BatchParameter(key = "最優先住所", name = "最優先住所")
    private RString 最優先住所;
    @BatchParameter(key = "敬称", name = "敬称")
    private RString 敬称;
    @BatchParameter(key = "被保番号表示", name = "被保番号表示")
    private RString 被保番号表示;
    @BatchParameter(key = "宛先住所設定", name = "宛先住所設定")
    private RString 宛先住所設定;
    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = "業務コード", name = "業務コード")
    private SubGyomuCode 業務コード;

    /**
     * toDBB021051ProcessParameterのメソッドです。
     *
     * @return DBB021051ProcessParameter
     */
    public DBB021051ProcessParameter toDBB021051ProcessParameter() {
        DBB021051ProcessParameter param = new DBB021051ProcessParameter();
        param.set抽出対象者(抽出対象者);
        param.set基準年月(基準年月);
        param.set資格区分(資格区分);
        param.set市町村指定(市町村指定);
        param.set最優先住所(最優先住所);
        param.set敬称(敬称);
        param.set被保番号表示(被保番号表示);
        param.set宛先住所設定(宛先住所設定);
        param.set出力順ID(出力順ID);
        param.set業務コード(業務コード.getColumnValue());
        return param;
    }
}
