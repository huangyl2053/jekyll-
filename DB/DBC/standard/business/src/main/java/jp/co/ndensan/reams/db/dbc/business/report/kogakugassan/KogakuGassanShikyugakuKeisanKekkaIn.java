/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120.KogakuGassanShikyugakuKeisanKekkaInfoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給額計算結果連絡票情報出力帳票用データのクラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyugakuKeisanKekkaIn {

    private KogakuGassanShikyugakuKeisanKekkaInfoEntity 帳票用データ;
    private List<RString> 改頁リスト;
    private List<RString> 並び順リスト;
    private RDateTime 作成日時;
    private FlexibleYearMonth 処理年月;
    private int 連番;
    private RString 保険者番号;
    private RString 保険者名;
    private int 計算結果登録件数;
    private int 計算結果明細登録件数;
    private boolean 最終頁flg;

}
