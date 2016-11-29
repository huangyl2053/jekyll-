/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5190002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.kaigoninteihokaiseikanri.HokaiseiShikoYMDToKoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7202KaigoNinteiHokaiseiKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定関連データを管理するクラスです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class RenekeiDataSakuseiFourMasterManager {

    private static final int INDEX_旧 = 0;
    private static final int INDEX_新 = 1;

    private final DbT7202KaigoNinteiHokaiseiKanriDac dac_7202;

    /**
     * コンストラクタです。
     */
    RenekeiDataSakuseiFourMasterManager() {
        this.dac_7202 = InstanceProvider.create(DbT7202KaigoNinteiHokaiseiKanriDac.class);
    }

    RenekeiDataSakuseiFourMasterManager(DbT7202KaigoNinteiHokaiseiKanriDac dac_7202) {
        this.dac_7202 = dac_7202;
    }

    /**
     * NinteiShinseiTorokuUketsukeManagerのインスタンス化。
     *
     * @return NinteiShinseiTorokuUketsukeManager
     */
    public static RenekeiDataSakuseiFourMasterManager createInstance() {
        return InstanceProvider.create(RenekeiDataSakuseiFourMasterManager.class);
    }

    /**
     * 法改正施行年月日と厚労省IF識別コードの取得。
     *
     * @return 旧法改正施行年月日と厚労省IF識別コード
     */
    public List<HokaiseiShikoYMDToKoroshoIfShikibetsuCode> get法改正施行年月日と厚労省IF識別コード() {
        List<DbT7202KaigoNinteiHokaiseiKanriEntity> 介護認定法改正管理情報リスト = dac_7202.get介護認定法改正管理情報();
        List<HokaiseiShikoYMDToKoroshoIfShikibetsuCode> 法改正施行年月日と厚労省IF識別コード = new ArrayList<>();
        法改正施行年月日と厚労省IF識別コード.add(new HokaiseiShikoYMDToKoroshoIfShikibetsuCode(FlexibleDate.EMPTY, RString.EMPTY));
        法改正施行年月日と厚労省IF識別コード.add(new HokaiseiShikoYMDToKoroshoIfShikibetsuCode(FlexibleDate.EMPTY, RString.EMPTY));
        FlexibleDate 現在の年月日 = FlexibleDate.getNowDate();
        if (!介護認定法改正管理情報リスト.isEmpty()) {
            for (DbT7202KaigoNinteiHokaiseiKanriEntity 介護認定法改正管理情報 : 介護認定法改正管理情報リスト) {
                if (介護認定法改正管理情報.getHokaiseiShikoYMD().isBeforeOrEquals(現在の年月日)) {
                    法改正施行年月日と厚労省IF識別コード.get(INDEX_旧).set厚労省IF識別コード(介護認定法改正管理情報.getKoroshoIfShikibetsuCode());
                    return 法改正施行年月日と厚労省IF識別コード;
                }
                法改正施行年月日と厚労省IF識別コード.get(INDEX_新).set法改正施行年月日(介護認定法改正管理情報.getHokaiseiShikoYMD());
                法改正施行年月日と厚労省IF識別コード.get(INDEX_新).set厚労省IF識別コード(介護認定法改正管理情報.getKoroshoIfShikibetsuCode());
            }
            return 法改正施行年月日と厚労省IF識別コード;
        }
        return 法改正施行年月日と厚労省IF識別コード;
    }
}
