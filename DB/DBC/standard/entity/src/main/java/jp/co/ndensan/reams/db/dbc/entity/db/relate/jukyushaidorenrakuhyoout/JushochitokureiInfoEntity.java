/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 住所地特例の情報エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JushochitokureiInfoEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 住所地特例適用開始日;
    private FlexibleDate 住所地特例適用終了日;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
    private HihokenshaNo 転出先保険者番号;

}
