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
 * 事業報告集計一覧データのエンティティです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenJigyoHokokuNenpoEntity {

    public KaigoHokenJigyoHokokuNenpoEntity() {
    }

    public KaigoHokenJigyoHokokuNenpoEntity(FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年,
            RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号,
            Code 集計単位, RString 集計項目名称, Code 縦項目コード, Code 横項目コード) {
        this.報告年 = 報告年;
        this.報告月 = 報告月;
        this.集計対象年 = 集計対象年;
        this.集計対象月 = 集計対象月;
        this.統計対象区分 = 統計対象区分;
        this.市町村コード = 市町村コード;
        this.表番号 = 表番号;
        this.集計番号 = 集計番号;
        this.集計単位 = 集計単位;
        this.集計項目名称 = 集計項目名称;
        this.縦項目コード = 縦項目コード;
        this.横項目コード = 横項目コード;
    }

    private FlexibleYear 報告年;
    private RString 報告月;
    private FlexibleYear 集計対象年;
    private RString 集計対象月;
    private RString 統計対象区分;
    private LasdecCode 市町村コード;
    private Code 表番号;
    private Code 集計番号;
    private Code 集計単位;
    private RString 集計項目名称;
    private Code 縦項目コード;
    private Code 横項目コード;
    Map<RString, Decimal> 詳細データエリア = new HashMap<>();
}
