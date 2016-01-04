/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.nenreitoutatsuyoteishacheck;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitoutatsuyoteisha.INenreiToutatsuYoteishaCheckListBatchParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 年齢到達予定者チェックリスト_バッチパラメータ作成します。
 */
public class NenreiToutatsuYoteishaCheckListBatchParameterSakusei {

    private static final RString CHERADIO_KEY0 = new RString("key0");
    private static final RString CHERADIO_KEY1 = new RString("key1");
    private static final RString CHERADIO_KEY2 = new RString("key2");
    private static final RString CHECKBOX_KEY0 = new RString("key0");
    private static final RString CHECKBOX_KEY1 = new RString("key1");
    private static final RString CHECKBOX_KEY2 = new RString("key2");
    private static final RString CHECKBOX_KEY3 = new RString("key3");

    public INenreiToutatsuYoteishaCheckListBatchParameter getNenreiToutatsuYoteishaCheckListBatchParameter(
            RString 出力対象, RString 住民種別, FlexibleDate 今回開始日, FlexibleDate 今回終了日, List<RString> 編集方法,
            RString 出力順ID) {

        boolean 項目名付加フラグ = false;
        boolean 連番付加フラグ = false;
        boolean 日付編集フラグ = false;
        if (CHERADIO_KEY0.equals(出力対象)) {
            出力対象 = new RString("1");
        } else if (CHERADIO_KEY1.equals(出力対象)) {
            出力対象 = new RString("2");
        }

        if (CHERADIO_KEY0.equals(住民種別)) {
            住民種別 = new RString("1");
        } else if (CHERADIO_KEY1.equals(住民種別)) {
            住民種別 = new RString("2");
        } else if (CHERADIO_KEY2.equals(住民種別)) {
            住民種別 = new RString("3");
        }
        for (RString key : 編集方法) {
            if (CHECKBOX_KEY0.equals(key)) {
                項目名付加フラグ = true;
                連番付加フラグ = true;
                日付編集フラグ = true;
            } else if (CHECKBOX_KEY1.equals(key)) {
                項目名付加フラグ = true;
            } else if (CHECKBOX_KEY2.equals(key)) {
                連番付加フラグ = true;
            } else if (CHECKBOX_KEY3.equals(key)) {
                日付編集フラグ = true;
            }
        }

        return new INenreiToutatsuYoteishaCheckListBatchParameter(出力対象, 項目名付加フラグ, 連番付加フラグ,
                日付編集フラグ, 住民種別, 今回開始日, 今回終了日, 出力順ID);

    }
}
