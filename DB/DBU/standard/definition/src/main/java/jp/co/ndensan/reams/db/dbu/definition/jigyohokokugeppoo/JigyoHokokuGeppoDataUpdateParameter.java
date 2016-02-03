/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sunhui
 */
@Getter
@Setter
public class JigyoHokokuGeppoDataUpdateParameter {

    private final Code 集計単位;
    private final Decimal 集計結果値;
    private final FlexibleYear 報告年;
    private final RString 報告月;
    private final FlexibleYear 集計対象年;
    private final RString 集計対象月;
    private final RString 統計対象区分;
    private final LasdecCode 市町村コード;
    private final Code 表番号;
    private final Code 集計番号;
    private final Decimal 縦番号;
    private final Decimal 横番号;
    private final RString 縦項目コード;
    private final RString 横項目コード;

    public JigyoHokokuGeppoDataUpdateParameter(Code 集計単位, Decimal 集計結果値, FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年, RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号, Decimal 縦番号, Decimal 横番号, RString 縦項目コード, RString 横項目コード) {
        this.集計単位 = 集計単位;
        this.集計結果値 = 集計結果値;
        this.報告年 = 報告年;
        this.報告月 = 報告月;
        this.集計対象年 = 集計対象年;
        this.集計対象月 = 集計対象月;
        this.統計対象区分 = 統計対象区分;
        this.市町村コード = 市町村コード;
        this.表番号 = 表番号;
        this.集計番号 = 集計番号;
        this.縦番号 = 縦番号;
        this.横番号 = 横番号;
        this.縦項目コード = 縦項目コード;
        this.横項目コード = 横項目コード;
    }


    public static JigyoHokokuGeppoDataUpdateParameter createParameterForJigyoHokokuGeppoData(Code 集計単位, Decimal 集計結果値, FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年, RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号, Decimal 縦番号, Decimal 横番号, RString 縦項目コード, RString 横項目コード) {
        return new JigyoHokokuGeppoDataUpdateParameter(集計単位, 集計結果値, 報告年, 報告月, 集計対象年, 集計対象月, 統計対象区分, 市町村コード, 表番号, 集計番号, 縦番号, 横番号,縦項目コード,横項目コード);
    }
}
