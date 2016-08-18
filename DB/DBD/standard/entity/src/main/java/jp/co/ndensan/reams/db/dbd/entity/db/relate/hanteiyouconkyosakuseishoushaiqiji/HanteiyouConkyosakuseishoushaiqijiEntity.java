/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanteiyouconkyosakuseishoushaiqiji;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 減免減額対象者判定用根拠作成対象者一時のEntity
 *
 * @reamsid_L DBD-3830-050 tianyh
 */
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public final class HanteiyouConkyosakuseishoushaiqijiEntity extends DbTableEntityBase<HanteiyouConkyosakuseishoushaiqijiEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("gemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTemp"));
    }
    private HihokenshaNo hihokenshaNo;
    private FlexibleDate kijunYMD;

}
