/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 対象者一次特定一時テーブルのEntityクラスです
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaIchijiTokuteiTableEntity extends DbTableEntityBase<TaishoshaIchijiTokuteiTableEntity> implements IDbAccessable {

    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("gemmenGengakuTaishoShaHanteiYoukonSakuseiTaishoShaTemp");
    }
    private HihokenshaNo hihokenshaNo;
    private FlexibleDate kijunYMD;

}
