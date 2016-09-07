/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.taishosetaiinido;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * select基準収入額適用管理のEntityクラスです。
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
@Getter
@Setter
public class TaishoSetaiinIdoEntity {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate shinseishoSakuseiSetaiKijunYMD;
    private int rirekiNo;
}
