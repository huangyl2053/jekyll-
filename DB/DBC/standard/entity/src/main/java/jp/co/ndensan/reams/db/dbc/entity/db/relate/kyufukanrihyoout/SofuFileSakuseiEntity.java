/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成csvのEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SofuFileSakuseiEntity {

    private RString 保険者番号;
    private List<KyufukanrihyoOutDoBillOutEntity> 給付管理票送付用EntityList;
    private int レコード件数カウンター;
}
