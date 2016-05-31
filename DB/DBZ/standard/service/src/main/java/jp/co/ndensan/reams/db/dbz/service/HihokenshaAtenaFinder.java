/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * ビジネス設計_DBUMN00000_被保険者・宛名情報取得。
 *
 * @reamsid_L DBC-0980-590 yangchenbing
 */
public class HihokenshaAtenaFinder {

    /**
     * 直近の被保険者台帳情報および宛名情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 宛名データ IShikibetsuTaisho
     */
    public IShikibetsuTaisho getHihokenshaAtena(HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null) {
            return null;
        }
        DbV1001HihokenshaDaichoAliveDac dac = new DbV1001HihokenshaDaichoAliveDac();
        DbV1001HihokenshaDaichoEntity entity = dac.get最新の被保険者台帳情報(被保険者番号);
        if (entity == null) {
            return null;
        }
        IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
        IShikibetsuTaisho 識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                new ShikibetsuCode(entity.getHihokenshaNo().value()), KensakuYusenKubun.住登外優先);
        return 識別対象;
    }
}
