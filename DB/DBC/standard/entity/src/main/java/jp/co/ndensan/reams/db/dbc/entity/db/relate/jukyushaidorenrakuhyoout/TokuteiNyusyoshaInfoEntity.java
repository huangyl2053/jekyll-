/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 特定入所者の情報エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiNyusyoshaInfoEntity {

    private RString 減免_減額種類;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private Decimal 食費負担限度額;
    private Decimal ユニット型個室;
    private Decimal ユニット型準個室;
    private Decimal 従来型個室_特養等;
    private Decimal 従来型個室_老健_療養等;
    private Decimal 多床室;
    private RString 旧措置者区分;
    private RString 特例減額措置区分;
    private RString 決定区分;
    private FlexibleDate 申請日;
    private HihokenshaNo 被保険者番号;

}
