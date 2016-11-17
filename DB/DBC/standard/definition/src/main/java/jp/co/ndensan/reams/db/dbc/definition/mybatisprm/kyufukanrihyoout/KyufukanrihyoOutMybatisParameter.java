/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成のMYBATIS用パラメータクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufukanrihyoOutMybatisParameter implements IMyBatisParameter {

    private final FlexibleYearMonth 処理年月;
    private final boolean is再処理区分;
    private final RString 出力順ID;
    private final FlexibleDate 最終更新年月日;
    private final RString 制度改正施行日支給限度額一本化の年月;
    private final RString 居宅サービス区分短期入所のコード;
    private final boolean has出力順1;
    private final boolean has出力順2;
    private final RString 出力順;

    private KyufukanrihyoOutMybatisParameter(FlexibleYearMonth 処理年月,
            boolean is再処理区分,
            RString 出力順ID,
            FlexibleDate 最終更新年月日,
            RString 制度改正施行日支給限度額一本化の年月,
            RString 居宅サービス区分短期入所のコード,
            boolean has出力順1,
            boolean has出力順2,
            RString 出力順) {
        this.処理年月 = 処理年月;
        this.is再処理区分 = is再処理区分;
        this.出力順ID = 出力順ID;
        this.最終更新年月日 = 最終更新年月日;
        this.制度改正施行日支給限度額一本化の年月 = 制度改正施行日支給限度額一本化の年月;
        this.居宅サービス区分短期入所のコード = 居宅サービス区分短期入所のコード;
        this.has出力順1 = has出力順1;
        this.has出力順2 = has出力順2;
        this.出力順 = 出力順;
    }

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param is再処理区分 is再処理区分
     * @param 出力順ID 出力順ID
     * @param 最終更新年月日 最終更新年月日
     */
    public static KyufukanrihyoOutMybatisParameter createParam(
            FlexibleYearMonth 処理年月,
            boolean is再処理区分,
            RString 出力順ID,
            FlexibleDate 最終更新年月日,
            RString 出力順,
            RString 制度改正施行日支給限度額一本化の年月,
            RString 居宅サービス区分短期入所のコード) {
        return new KyufukanrihyoOutMybatisParameter(処理年月,
                is再処理区分,
                出力順ID,
                最終更新年月日,
                制度改正施行日支給限度額一本化の年月,
                居宅サービス区分短期入所のコード,
                !RString.isNullOrEmpty(出力順),
                RString.isNullOrEmpty(出力順),
                出力順);
    }
}
