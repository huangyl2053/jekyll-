/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5190002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.kaigoninteihokaiseikanri.HokaiseiShikoYMDToKoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT7202KaigoNinteiHokaiseiKanriDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定関連データを管理するクラスです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class RenekeiDataSakuseiFourMasterManager {

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
     * @return 法改正施行年月日と厚労省IF識別コード
     */
    public HokaiseiShikoYMDToKoroshoIfShikibetsuCode get法改正施行年月日と厚労省IF識別コード() {
        FlexibleDate 法改正施行年月日 = FlexibleDate.getNowDate();
        List<DbT7202KaigoNinteiHokaiseiKanriEntity> 介護認定法改正管理情報リスト = dac_7202.get介護認定法改正管理情報();
        if (!介護認定法改正管理情報リスト.isEmpty()) {
            法改正施行年月日 = 介護認定法改正管理情報リスト.get(0).getHokaiseiShikoYMD();
            for (DbT7202KaigoNinteiHokaiseiKanriEntity 介護認定法改正管理情報 : 介護認定法改正管理情報リスト) {
                if (介護認定法改正管理情報.getHokaiseiShikoYMD().isBefore(FlexibleDate.getNowDate())) {
                    return new HokaiseiShikoYMDToKoroshoIfShikibetsuCode(法改正施行年月日, 介護認定法改正管理情報.getKoroshoIfShikibetsuCode());
                }
            }
        }
        return new HokaiseiShikoYMDToKoroshoIfShikibetsuCode(法改正施行年月日, RString.EMPTY);
    }

}
