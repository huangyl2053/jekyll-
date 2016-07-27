/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.KozaSearchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（過年度）（バッチ）の賦課計算用パラメータです。
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class CalculateFukaParameter extends KozaSearchParameter implements IMyBatisParameter {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;

    private final FlexibleYear 調定年度;
    private final YMDHMS 調定日時;

    private final FlexibleYear 調定年度minus1;
    private final FlexibleYear 調定年度minus2;
    private final RString 年度サイクル;

    private final boolean hasValidKamoku;

    /**
     * コンストラクタです。
     *
     * @param key キー
     * @param kamokuList 科目コード
     * @param 調定年度 調定年度
     * @param 調定日時 調定日時
     */
    public CalculateFukaParameter(IKozaSearchKey key, List<KamokuCode> kamokuList, FlexibleYear 調定年度, YMDHMS 調定日時) {
        super(key, kamokuList);
        this.hasValidKamoku = super.has権限有科目();
        this.調定年度 = 調定年度;
        this.調定日時 = 調定日時;
        this.調定年度minus1 = 調定年度.minusYear(INT_1);
        this.調定年度minus2 = 調定年度.minusYear(INT_2);
        this.年度サイクル = DbBusinessConfig.get(ConfigNameDBB.日付関連_年度サイクル, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
    }
}
