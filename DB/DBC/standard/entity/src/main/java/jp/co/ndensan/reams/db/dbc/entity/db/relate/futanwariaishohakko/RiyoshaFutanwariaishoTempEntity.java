/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合証TempのEntityです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanwariaishoTempEntity {

    private DbT3113RiyoshaFutanWariaiEntity 利用者負担割合;
    private DbT1001HihokenshaDaichoEntity 被保台帳;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private RString 事業対象者受給者区分;
    private FutanWariKikanTempEntity 負担割合期間;
    private LasdecCode 証記載保険者番号;
    private DbT7037ShoKofuKaishuEntity 証交付回収;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutanwariaishoTempEntity() {
        this.利用者負担割合 = new DbT3113RiyoshaFutanWariaiEntity();
        this.被保台帳 = new DbT1001HihokenshaDaichoEntity();
        this.宛名 = new UaFt200FindShikibetsuTaishoEntity();
        this.宛先 = new UaFt250FindAtesakiEntity();
        this.負担割合期間 = new FutanWariKikanTempEntity();
    }

}
