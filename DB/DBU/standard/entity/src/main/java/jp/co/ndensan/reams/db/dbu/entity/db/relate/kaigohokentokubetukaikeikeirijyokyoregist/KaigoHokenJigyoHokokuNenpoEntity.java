/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokentokubetukaikeikeirijyokyoregist;

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
 *
 * @reamsid_L DBU-1130-050 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenJigyoHokokuNenpoEntity {

    /**
     * コンストラクタです。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 表番号 表番号
     * @param 集計対象月 集計対象月
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 集計番号 集計番号
     * @param 集計単位 集計単位
     * @param 集計項目名称 集計項目名称
     * @param 縦項目コード 縦項目コード
     * @param 横項目コード 横項目コード
     * @param 詳細データエリア 詳細データエリア
     */
    public KaigoHokenJigyoHokokuNenpoEntity(FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年,
            RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号,
            Code 集計単位, RString 集計項目名称, Code 縦項目コード, Code 横項目コード, Map<RString, Decimal> 詳細データエリア) {
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
        this.詳細データエリア = 詳細データエリア;
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
    private Map<RString, Decimal> 詳細データエリア = new HashMap<>();
}
