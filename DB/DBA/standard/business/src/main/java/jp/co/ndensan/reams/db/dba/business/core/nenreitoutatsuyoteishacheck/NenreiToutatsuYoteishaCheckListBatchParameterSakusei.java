/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.nenreitoutatsuyoteishacheck;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA120010.DBA120010_NenreitotatsuYoteishaListParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 年齢到達予定者チェックリスト_バッチパラメータ作成します。
 *
 * @reamsid_L DBA-0580-040 yaodongsheng
 */
public class NenreiToutatsuYoteishaCheckListBatchParameterSakusei {

    private static final RString CHERADIO_KEY0 = new RString("key0");
    private static final RString CHERADIO_KEY1 = new RString("key1");
    private static final RString CHERADIO_KEY2 = new RString("key2");
    private static final RString CHECKBOX_KEY0 = new RString("key0");
    private static final RString CHECKBOX_KEY1 = new RString("key1");
    private static final RString CHECKBOX_KEY2 = new RString("key2");
    private static final RString 出力対象_1 = new RString("1");
    private static final RString 出力対象_2 = new RString("2");
    private static final RString 住民種別_1 = new RString("1");
    private static final RString 住民種別_2 = new RString("2");
    private static final RString 住民種別_3 = new RString("3");

    /**
     * 年齢到達予定者チェックリスト_バッチパラメータ作成。
     *
     * @param 出力対象 出力対象
     * @param 住民種別 住民種別
     * @param 今回開始日 今回開始日
     * @param 今回終了日 今回終了日
     * @param 編集方法 編集方法
     * @param 出力順ID 出力順ID
     * @return DBA120010_NenreitotatsuYoteishaListParameter
     */
    public DBA120010_NenreitotatsuYoteishaListParameter getNenreiToutatsuYoteishaCheckListBatchParameter(
            RString 出力対象, RString 住民種別, FlexibleDate 今回開始日, FlexibleDate 今回終了日, List<RString> 編集方法,
            Long 出力順ID) {
        if (今回開始日 == null || 今回開始日.isEmpty() || 今回終了日 == null || 今回終了日.isEmpty()) {
            throw new IllegalArgumentException();
        }
        boolean 項目名付加フラグ = false;
        boolean 連番付加フラグ = false;
        boolean 日付編集フラグ = false;
        if (CHERADIO_KEY0.equals(出力対象)) {
            出力対象 = 出力対象_1;
        } else if (CHERADIO_KEY1.equals(出力対象)) {
            出力対象 = 出力対象_2;
        }
        if (CHERADIO_KEY0.equals(住民種別)) {
            住民種別 = 住民種別_1;
        } else if (CHERADIO_KEY1.equals(住民種別)) {
            住民種別 = 住民種別_2;
        } else if (CHERADIO_KEY2.equals(住民種別)) {
            住民種別 = 住民種別_3;
        }
        for (RString key : 編集方法) {
            if (CHECKBOX_KEY0.equals(key)) {
                項目名付加フラグ = true;
            } else if (CHECKBOX_KEY1.equals(key)) {
                連番付加フラグ = true;
            } else if (CHECKBOX_KEY2.equals(key)) {
                日付編集フラグ = true;
            }
        }
        return new DBA120010_NenreitotatsuYoteishaListParameter(出力対象, 項目名付加フラグ, 連番付加フラグ,
                日付編集フラグ, 住民種別, 今回開始日, 今回終了日, 出力順ID);
    }
}
