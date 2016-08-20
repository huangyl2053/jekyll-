/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581000;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581001.DBD581001Parameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd582001.DBD582001Parameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 統計表発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1771-032 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD581000Parameter extends BatchParameterBase {

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
     * 要介護認定実施状況表（統計表）のバッチパラメターを取得します．
     *
     * @return parameter YokaigoJissiJyokyohyoParameter
     */
    public DBD581001Parameter toDBD581001Parameter() {
        DBD581001Parameter parameter = new DBD581001Parameter();
        parameter.set出力帳票(出力帳票);
        parameter.set対象年度(対象年度);
        parameter.set集計単位(集計単位);
        parameter.set年齢From(年齢From);
        parameter.set年齢To(年齢To);
        parameter.set年齢基準日(年齢基準日);
        parameter.set生年月日From(生年月日From);
        parameter.set生年月日To(生年月日To);
        parameter.set地区区分(地区区分);
        parameter.set開始地区コード(開始地区コード);
        parameter.set終了地区コード(終了地区コード);
        parameter.set基準フラグ(基準フラグ);
        parameter.set基準日(基準日);
        return parameter;
    }

    /**
     * 要介護認定月別受給者数状況表（統計表）のバッチパラメターを取得します．
     *
     * @return parameter DBD582001Parameter
     */
    public DBD582001Parameter toDBD582001Parameter() {
        DBD582001Parameter parameter = new DBD582001Parameter();
        parameter.set出力帳票(出力帳票);
        parameter.set対象年度(対象年度);
        parameter.set集計単位(集計単位);
        parameter.set年齢From(年齢From);
        parameter.set年齢To(年齢To);
        parameter.set年齢基準日(年齢基準日);
        parameter.set生年月日From(生年月日From);
        parameter.set生年月日To(生年月日To);
        parameter.set地区区分(地区区分);
        parameter.set開始地区コード(開始地区コード);
        parameter.set終了地区コード(終了地区コード);
        parameter.set基準フラグ(基準フラグ);
        parameter.set基準日(基準日);
        return parameter;
    }
}
