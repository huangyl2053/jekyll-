/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 異動データ取得トリガEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IdouDetaToriGaTempEntity extends DbTableEntityBase<IdouDetaToriGaTempEntity> implements IDbAccessable {

    private FlexibleDate 異動年月日;
    private HihokenshaNo 被保険者番号;
}
