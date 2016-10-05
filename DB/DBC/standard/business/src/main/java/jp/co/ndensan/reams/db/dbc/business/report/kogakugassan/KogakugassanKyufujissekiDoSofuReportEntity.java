/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.KogakuGassanKyufuJissekiSofuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報送付一覧表出力帳票用データのクラスです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKyufujissekiDoSofuReportEntity {

    private KogakuGassanKyufuJissekiSofuEntity 帳票用データ;
    private List<RString> 改頁リスト;
    private List<RString> 並び順リスト;
    private RDateTime 作成日時;
    private FlexibleYearMonth 処理年月;
    private int 連番;
    private RString 保険者番号;
    private RString 保険者名;

}
