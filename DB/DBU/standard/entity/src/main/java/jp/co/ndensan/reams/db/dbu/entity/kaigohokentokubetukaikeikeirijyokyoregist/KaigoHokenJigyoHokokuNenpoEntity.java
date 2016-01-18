/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 事業報告集計一覧データEntity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenJigyoHokokuNenpoEntity {

    private FlexibleYear 報告年;
    private RString 報告月;
    private FlexibleYear 集計対象年;
    private RString 集計対象月;
    private RString 統計対象区分;
    private LasdecCode 市町村コード;
    private Code 表番号;
    private Code 集計番号;
    private Code 集計単位;
    private Decimal 縦番号;
    private Decimal 横番号;
    private Decimal 集計結果値;
    private RString 集計項目名称;
    private Code 縦項目コード;
    private Code 横項目コード;
    Map<RString, Decimal> 詳細データエリア = new HashMap<>();
}
