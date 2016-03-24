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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 賦課納期取得のクラスです。
 */
public class FukaNokiResearcher {

    private final NokiManager nokiManager;
    private final RYear 調定年度;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     */
    public FukaNokiResearcher(RYear 調定年度) {
        this.nokiManager = InstanceProvider.create(NokiManager.class);
        this.調定年度 = 調定年度 != null ? 調定年度 : new RYear(BusinessConfig
                .get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課));
    }

    /**
     * コンストラクタです。
     */
    FukaNokiResearcher() {
        this.nokiManager = InstanceProvider.create(NokiManager.class);
        this.調定年度 = new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課));
    }

    /**
     * コンストラクタです。
     *
     * @param nokiManager NokiManager
     * @param 調定年度 調定年度
     */
    FukaNokiResearcher(NokiManager nokiManager, RYear 調定年度) {
        this.nokiManager = nokiManager;
        this.調定年度 = 調定年度;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaNokiResearcher}のインスタンスを返します。
     *
     * @return FukaNokiResearcher
     */
    public static FukaNokiResearcher createInstance() {
        return InstanceProvider.create(FukaNokiResearcher.class);
    }

    /**
     * パラメータの期のNokiを取得します。
     *
     * @param 期 期
     * @return 特徴納期
     * @throws IllegalArgumentException,ApplicationException
     */
    public Noki get特徴納期(int 期) {

        if (期 < 0) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("期").toString());
        }
        Noki 特徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_特別徴収,
                this.調定年度, GennenKanen.現年度, 期);
        if (特徴納期 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            return 特徴納期;
        }
    }

    /**
     * パラメータの期のNokiを取得します。
     *
     * @param 期 期
     * @return 普徴納期
     * @throws IllegalArgumentException,ApplicationException
     */
    public Noki get普徴納期(int 期) {

        if (期 < 0) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("期").toString());
        }
        Noki 普徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                this.調定年度, GennenKanen.現年度, 期);
        if (普徴納期 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            return 普徴納期;
        }
    }

    /**
     * 期を指定しなくて、すべてのNoki(URC)を取得します。
     *
     * @return List<Noki>
     * @throws ApplicationException
     */
    public List<Noki> get普徴納期ALL() {

        List<Noki> 普徴納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                this.調定年度, GennenKanen.現年度);
        if (普徴納期 == null || 普徴納期.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            return 普徴納期;
        }
    }

    /**
     * パラメータの期のNokiを取得します。
     *
     * @param 期 期
     * @return 過年度納期
     * @throws IllegalArgumentException,ApplicationException
     */
    public Noki get過年度納期(int 期) {

        if (期 < 0) {
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("期").toString());
        }
        Noki 過年度納期 = nokiManager.get納期(ShunoKamokuShubetsu.介護保険料_普通徴収,
                this.調定年度, GennenKanen.過年度, 期);
        if (過年度納期 == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            return 過年度納期;
        }
    }
}
