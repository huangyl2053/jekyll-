/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL用パラメタークラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShiharaiHohoHenkoHaakuFiveMybatisParameter implements IMyBatisParameter {

    private FlexibleDate 基準日;
    private FlexibleYear 業務コンフィグ_日付関連_調定年度;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     */
    public ShiharaiHohoHenkoHaakuFiveMybatisParameter(FlexibleDate 基準日) {
        this.基準日 = 基準日;
        set業務コンフィグ_日付関連_調定年度について();
    }

    private void set業務コンフィグ_日付関連_調定年度について() {
        RString configValue = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FlexibleYear 調定年度 = new FlexibleYear(configValue);
        業務コンフィグ_日付関連_調定年度 = 調定年度.minusYear(2);
    }
}
