/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehitaishoshaichiransokyubun;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBCMN41003_高額介護サービス費対象者一覧表（遡及分）のEntityクラスです。
 *
 * @reamsid_L DBC-5750-040 kanghongsong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiTaishoshaIchiranSokyubunEntity {

    private RDateTime システムの時間;
    private RString 市町村コード;
    private RString 市町村名;
    private Map<RString, RString> 出力順Map;
    private List<RString> 改頁リスト;
    private ShikibetsuCode 識別コード;
    private RString 連番;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 被保険者名;
    private RString 世帯コード;
    private Decimal 利用者負担額;
    private Decimal 支給_予定_金額;
    private RString 備考;
    private RString マスタの状況;
}
