/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD581000;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD581001.DBD581001_YokaigoNinteiJisshiJokyoHyoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD582001.DBD582001_YokaigoNinteiTsukibetsuJukyushaSuJokyoHyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
public class DBD581000_TokeiHyoHakkoParameter extends BatchParameterBase {

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

    /**
     * 要介護認定実施状況表（統計表）のバッチパラメターを取得します．
     *
     * @return parameter YokaigoJissiJyokyohyoParameter
     */
    public DBD581001_YokaigoNinteiJisshiJokyoHyoParameter toDBD581001Parameter() {
        DBD581001_YokaigoNinteiJisshiJokyoHyoParameter parameter = new DBD581001_YokaigoNinteiJisshiJokyoHyoParameter();
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
    public DBD582001_YokaigoNinteiTsukibetsuJukyushaSuJokyoHyoParameter toDBD582001Parameter() {
        DBD582001_YokaigoNinteiTsukibetsuJukyushaSuJokyoHyoParameter parameter = new DBD582001_YokaigoNinteiTsukibetsuJukyushaSuJokyoHyoParameter();
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
