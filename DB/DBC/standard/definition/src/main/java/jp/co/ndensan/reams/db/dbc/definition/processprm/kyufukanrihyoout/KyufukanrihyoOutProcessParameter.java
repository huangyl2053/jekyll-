/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout.KyufukanrihyoOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成のProcess用パラメータです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoOutProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private RString 再処理区分;
    private RString 出力順ID;
    private FlexibleDate 最終更新年月日;
    private int 連番;
    private ReportId 帳票ID;
    private SubGyomuCode サブ業務コード;
    private static final RString 再処理区分_0 = new RString("0");
    private static final RString 再処理区分_1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param 再処理区分 再処理区分
     * @param 出力順ID 出力順ID
     * @param 最終更新年月日 最終更新年月日
     * @param 連番 連番
     */
    public KyufukanrihyoOutProcessParameter(FlexibleYearMonth 処理年月, RString 再処理区分, RString 出力順ID, FlexibleDate 最終更新年月日, int 連番) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順ID = 出力順ID;
        this.最終更新年月日 = 最終更新年月日;
        this.連番 = 連番;
    }

    /**
     * MybatisParameterを作成する。
     *
     * @param 出力順 RString
     * @param 制度改正施行日支給限度額一本化の年月 RString
     * @param 居宅サービス区分短期入所のコード RString
     * @return KyufukanrihyoOutMybatisParameter
     */
    public KyufukanrihyoOutMybatisParameter toKyufukanrihyoOutMybatisParameter(RString 出力順,
            RString 制度改正施行日支給限度額一本化の年月,
            RString 居宅サービス区分短期入所のコード) {
        return KyufukanrihyoOutMybatisParameter.createParam(処理年月, is再処理区分(再処理区分), 出力順ID, 最終更新年月日, 出力順,
                制度改正施行日支給限度額一本化の年月,
                居宅サービス区分短期入所のコード);
    }

    private boolean is再処理区分(RString 再処理区分) {
        boolean is再処理区分 = false;
        if (再処理区分_0.equals(再処理区分)) {
            is再処理区分 = true;
        } else if (再処理区分_1.equals(再処理区分)) {
            is再処理区分 = false;
        }
        return is再処理区分;
    }
}
