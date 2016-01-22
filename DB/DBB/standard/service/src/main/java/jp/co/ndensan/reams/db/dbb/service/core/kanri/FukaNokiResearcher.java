/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.noki.nokikanri.NokiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 賦課納期取得のクラスです。
 */
public class FukaNokiResearcher {

    NokiManager nokiManager = new NokiManager();
    private final RYear 調定年度;

    public FukaNokiResearcher(RYear 調定年度) {
        this.調定年度 = 調定年度;
    }

    /**
     * パラメータの期別のNokiを取得します。
     *
     * @param 期別
     * @return 特徴納期
     */
    public Noki get特徴納期(int 期別) {

        if (期別 < 0) {
            throw new IllegalArgumentException(UrErrorMessages.該当データなし.getMessage().getMessage());
        }
        if (this.調定年度 == null) {
            Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_特別徴収, this.調定年度, GennenKanen.現年度, 期別);
            if (特徴納期 == null) {
                throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
            } else {
                return 特徴納期;
            }
        }
        Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_特別徴収,
                new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課)), GennenKanen.現年度, 期別);
        if (特徴納期 == null) {
            throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
        }
        return 特徴納期;
    }

    /**
     * パラメータの期別のNokiを取得します。
     *
     * @param 期別
     * @return 普徴納期
     */
    public Noki get普徴納期(int 期別) {

        if (期別 < 0) {
            throw new IllegalArgumentException(UrErrorMessages.該当データなし.getMessage().getMessage());
        }
        if (this.調定年度 == null) {
            Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収, this.調定年度, GennenKanen.現年度, 期別);
            if (特徴納期 == null) {
                throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
            } else {
                return 特徴納期;
            }
        }
        Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課)), GennenKanen.現年度, 期別);
        if (特徴納期 == null) {
            throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
        }
        return 特徴納期;

    }

    /**
     * すべてのNokiを取得します。
     *
     * @return
     */
    public List<Noki> get普徴納期ALL() {

        if (this.調定年度 == null) {
            List<Noki> 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収, 調定年度, GennenKanen.現年度);
            if (特徴納期 == null || 特徴納期.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
            }
            return 特徴納期;
        }
        List<Noki> 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課)), GennenKanen.現年度);
        if (特徴納期 == null || 特徴納期.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
        }
        return 特徴納期;
    }

    /**
     * パラメータの期別のNokiを取得します。
     *
     * @param 期別
     * @return 過年度納期
     */
    public Noki get過年度納期(int 期別) {

        if (期別 < 0) {
            throw new IllegalArgumentException(UrErrorMessages.該当データなし.getMessage().getMessage());
        }
        if (this.調定年度 == null) {
            Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収, this.調定年度, GennenKanen.過年度, 期別);
            if (特徴納期 == null) {
                throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
            } else {
                return 特徴納期;
            }
        }
        Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課)), GennenKanen.過年度, 期別);
        if (特徴納期 == null) {
            throw new ApplicationException(UrErrorMessages.更新対象のデータがない.getMessage());
        }
        return 特徴納期;
    }
}
