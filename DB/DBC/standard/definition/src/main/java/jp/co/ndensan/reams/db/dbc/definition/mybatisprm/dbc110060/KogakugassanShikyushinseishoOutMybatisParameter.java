/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110060;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成のバッチMybatisParameter
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyushinseishoOutMybatisParameter implements IMyBatisParameter {

    private RString 再処理区分;
    private FlexibleYearMonth 処理年月;
    private HokenshaNo 保険者番号;

    /**
     * 送付対象データ取得用DBデータ取得MybatisParameter
     *
     * @param 再処理区分 RString
     * @param 処理年月 FlexibleYearMonth
     */
    public KogakugassanShikyushinseishoOutMybatisParameter(RString 再処理区分, FlexibleYearMonth 処理年月) {
        this.再処理区分 = 再処理区分;
        this.処理年月 = 処理年月;
    }

    /**
     * 送付ファイル作成用DBデータ取得MybatisParameter
     *
     * @param 保険者番号 HokenshaNo
     */
    public KogakugassanShikyushinseishoOutMybatisParameter(HokenshaNo 保険者番号) {
        this.保険者番号 = 保険者番号;
    }

}
