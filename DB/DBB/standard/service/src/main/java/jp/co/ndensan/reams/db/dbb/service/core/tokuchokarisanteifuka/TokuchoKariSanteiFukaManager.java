/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HasuChoseiTani;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.GyomuConfigJohoClass;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwari;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariInput;
import jp.co.ndensan.reams.ur.urd.business.core.tokuchokarisanteikiwari.TokuchoKarisanteiKiwariOutput;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ33001_1_特徴仮算定賦課（バッチ）
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
public class TokuchoKariSanteiFukaManager {

    private static final int 整数_1 = 1;
    private static final int 整数_2 = 2;
    private static final int 整数_3 = 3;
    private static final int 整数_4 = 4;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_3 = new RString("3");

    /**
     * コンストラクタです。
     */
    TokuchoKariSanteiFukaManager() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFukaManagerBatch}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFukaManagerBatch}のインスタンス
     */
    public static TokuchoKariSanteiFukaManager createInstance() {
        return InstanceProvider.create(TokuchoKariSanteiFukaManager.class);
    }

    /**
     * get特徴仮算定期割
     *
     * @param 調定年度 FlexibleYear
     * @param 保険料率 Decimal
     * @return TokuchoKarisanteiKiwariOutput
     */
    public TokuchoKarisanteiKiwariOutput get特徴仮算定期割(FlexibleYear 調定年度, Decimal 保険料率) {
        TokuchoKarisanteiKiwari 保険系業務共通 = new TokuchoKarisanteiKiwari();
        TokuchoKarisanteiKiwariInput inputEntity = new TokuchoKarisanteiKiwariInput();
        inputEntity.set前年度最終期別額(Decimal.ZERO);
        inputEntity.set前年度賦課額(保険料率);
        inputEntity.set現在特徴期(整数_2);
        RString 特徴定期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_設定納期数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 特徴仮算定期数 = DbBusinessConfig.get(ConfigNameDBB.特徴期情報_仮算定期数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 特徴仮算定計算区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_6月開始,
                new RDate(調定年度.minusYear(整数_1).toString()), SubGyomuCode.DBB介護賦課);
        RString 端数区分 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_期別端数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        業務コンフィグ情報.set特徴定期数(Integer.valueOf(特徴定期数.toString()));
        業務コンフィグ情報.set特徴仮算定期数(Integer.valueOf(特徴仮算定期数.toString()));
        if (RSTRING_1.equals(特徴仮算定計算区分)) {
            業務コンフィグ情報.set特徴仮算定計算区分(整数_1);
        } else if (RSTRING_3.equals(特徴仮算定計算区分)) {
            業務コンフィグ情報.set特徴仮算定計算区分(整数_2);
        }
        if (HasuChoseiTani._1.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_1);
        } else if (HasuChoseiTani._10.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_2);
        } else if (HasuChoseiTani._100.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_3);
        } else if (HasuChoseiTani._1000.getコード().equals(端数区分)) {
            業務コンフィグ情報.set端数区分特徴仮算定期別額(整数_4);
        }
        inputEntity.set業務コンフィグ情報(業務コンフィグ情報);
        return 保険系業務共通.getTokuchoKarisanteiKibetsuGaku(inputEntity);
    }
}
