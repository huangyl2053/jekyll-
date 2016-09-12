/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hihokenshaatena;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshaatenafinder.HihokenshaAtenaResult;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBUMN00000_被保険者・宛名情報取得。
 *
 * @reamsid_L DBC-0980-590 yangchenbing
 */
public class HihokenshaAtenaFinder {

    private DbV1001HihokenshaDaichoAliveDac 被保険者台帳管理dac;

    /**
     * 直近の被保険者台帳情報および宛名情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 宛名データ IShikibetsuTaisho
     */
    public HihokenshaAtenaResult getHihokenshaAtena(HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null) {
            return null;
        }
        被保険者台帳管理dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        DbV1001HihokenshaDaichoEntity entity = 被保険者台帳管理dac.get最新の被保険者台帳情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
        IShikibetsuTaisho 識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                entity.getShikibetsuCode(), KensakuYusenKubun.住登外優先);
        if (識別対象 == null) {
            return null;
        } else {
            return new HihokenshaAtenaResult(entity, 識別対象);
        }
    }
}
