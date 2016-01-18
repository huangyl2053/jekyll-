/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告年報詳細データの取得処理のMyBatisパラメタークラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuNenpoDetalParameter {

    private final FlexibleYear hokokuYSeireki;
    private final FlexibleYear shukeiTaishoYSeireki;
    private final RString toukeiTaishoKubun;
    private final LasdecCode shichosonCode;
    private final Code hyoNo;
    private final Code shukeiNo;
    private final List<Code> shukeiNoList;
    private boolean useshukeiNo = false;
    private boolean useshukeiNoList = false;

    private JigyoHokokuNenpoDetalParameter(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード,
            Code 表番号, Code 集計番号, List<Code> 集計番号リスト) {
        if (集計番号 != null && !集計番号.isEmpty()) {
            useshukeiNo = true;
        } else {
            useshukeiNoList = true;
        }
        this.hokokuYSeireki = 報告年;
        this.shukeiTaishoYSeireki = 集計対象年;
        this.shichosonCode = 市町村コード;
        this.toukeiTaishoKubun = 統計対象区分;
        this.shukeiNo = 集計番号;
        this.shukeiNoList = 集計番号リスト;
        this.hyoNo = 表番号;
    }

    /**
     * 事業報告年報詳細データの取得処理のパラメターを生成します。
     *
     * @param 報告年 報告年
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 集計番号リスト 集計番号リスト
     * @return JigyoHokokuNenpoDetalParameter 事業報告年報詳細データの取得処理のパラメター
     */
    public static JigyoHokokuNenpoDetalParameter createParameterForJigyoHokokuNenpoDetal(FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード,
            Code 表番号, Code 集計番号, List<Code> 集計番号リスト) {
        return new JigyoHokokuNenpoDetalParameter(報告年, 集計対象年, 統計対象区分, 市町村コード, 表番号, 集計番号, 集計番号リスト);
    }
}
