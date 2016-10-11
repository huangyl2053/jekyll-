/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbb014001.FuchoKarisanteiFukaMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 普徴仮算定賦課のProcessパラメータクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FuchoKarisanteiFukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 出力順ID;

    private RDateTime バッチ起動日時;

    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final int NUM_1 = 1;
    private static final int NUM_3 = 3;
    private static final int NUM_31 = 31;

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return {@link FuchoKarisanteiFukaMybatisParameter}
     */
    public FuchoKarisanteiFukaMybatisParameter toMybatisParameter() {
        FuchoKarisanteiFukaMybatisParameter param = new FuchoKarisanteiFukaMybatisParameter();
        param.set調定前年度(調定年度.minusYear(NUM_1));
        param.set調定年度(調定年度);
        param.set賦課前年度(賦課年度.minusYear(NUM_1));
        param.set賦課年度(賦課年度);
        param.set調定前年度終了日(new FlexibleDate(調定年度.getYearValue(), NUM_3, NUM_31));
        if (new FlexibleDate(バッチ起動日時.getDate().toDateString()).isBefore(param.get調定前年度終了日())) {
            param.set処理日付区分(定数_1);
        } else {
            param.set処理日付区分(定数_2);
        }
        param.set作成処理名(ShoriName.普徴仮算定賦課.get名称());
        return param;
    }
}
