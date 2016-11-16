/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 居宅計画の情報エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuEntity {

    private RString 居宅計画種類;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private JigyoshaNo 計画事業者番号;
    private JigyoshaNo 委託先事業者番号;
    private RString 居宅サービス計画作成区分コード;
    private RString 暫定区分;
    private FlexibleDate 届出年月日;
    private RString サービス種類コード;
    private FlexibleDate 有効終了日;
    private int 履歴番号;
    private FlexibleYearMonth taishoYM1;
    private FlexibleYearMonth taishoYM2;
}
