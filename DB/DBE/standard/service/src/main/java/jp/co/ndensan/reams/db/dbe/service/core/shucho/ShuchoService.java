/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shucho;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.shucho.Shuchos;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 構成市町村の首長について取り扱います。
 */
public final class ShuchoService {

    private ShuchoService() {
    }

    /**
     * @return 構成市町村の現在の首長
     */
    public static Shuchos findShuchos() {
        return findShuchosAt(RDate.getNowDate());
    }

    /**
     * @param date 指定日
     * @return 構成市町村の指定日時点の首長
     */
    public static Shuchos findShuchosAt(RDate date) {
        Map<RString, RString> map = new HashMap<>();
        for (KoikiZenShichosonJoho o : KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records()) {
            RString name = BusinessConfig.get(ConfigNameDBE.首長名, date, SubGyomuCode.DBE認定支援, o.get市町村コード().value());
            if (RString.isNullOrEmpty(name)) {
                continue;
            }
            map.put(o.get証記載保険者番号().value(), name);
        }
        return new Shuchos(map);
    }

}
