/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoin;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT1121KyufuKanrihyoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票一時データ/事業者名称追加。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoJigyoshaEntity {

    private RString 事業者名称;
    private DbWT1121KyufuKanrihyoTempEntity 給付管理票;

}
