/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支援事業者の情報Entity
 */
@lombok.Getter
@lombok.Setter
public class KyotakuKeikakuEntity {

    private RString 事業者;
    private FlexibleDate 届出年月日;
    private FlexibleDate 適用開始年月日;
    private RString 被保険者番号;
    private FlexibleDate 対象年月;
    private RString 履歴番号;
}
