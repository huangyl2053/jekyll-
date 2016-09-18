/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 対象者情報一時テーブルEntity
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoShaKanriJohoTableEntity extends DbTableEntityBase<TaishoShaKanriJohoTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("KyufuGengakuKanriListTaishoTokutei");
    }
    private HihokenshaNo hihokenshaNo;
}
