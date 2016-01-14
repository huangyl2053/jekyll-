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
 * 事業報告年報詳細データの削除処理のMyBatisパラメタークラスです。
 *
 */
@java.lang.SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class JigyoHokokuNenpoDeleteParameter {

    private final FlexibleYear hokokuYSeireki;
    private final FlexibleYear shukeiTaishoYSeireki;
    private final RString toukeiTaishoKubun;
    private final LasdecCode shichosonCode;
    private final Code hyoNo;
    private final List<Code> shukeiNoList;
    private boolean useshukeiNoList = false;

    private JigyoHokokuNenpoDeleteParameter(FlexibleYear hokokuYSeireki, FlexibleYear shukeiTaishoYSeireki, RString toukeiTaishoKubun, LasdecCode shichosonCode, Code hyoNo, List<Code> shukeiNoList) {
        this.hokokuYSeireki = hokokuYSeireki;
        this.shukeiTaishoYSeireki = shukeiTaishoYSeireki;
        this.toukeiTaishoKubun = toukeiTaishoKubun;
        this.shichosonCode = shichosonCode;
        this.hyoNo = hyoNo;
        this.shukeiNoList = shukeiNoList;

        if (shukeiNoList != null && 0 < shukeiNoList.size()) {
            useshukeiNoList = true;
        }
    }

    /**
     * 事業報告年報詳細データの削除処理のパラメターを生成します。
     *
     * @param 報告年 報告年
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号リスト 集計番号リスト
     * @return JigyoHokokuNenpoDeleteParameter 事業報告年報詳細データの削除処理のMyBatisパラメター
     */
    public static JigyoHokokuNenpoDeleteParameter createParameterForJigyoHokokuNenpo(
            FlexibleYear 報告年, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, List<Code> 集計番号リスト) {
        return new JigyoHokokuNenpoDeleteParameter(
                報告年, 集計対象年, 統計対象区分, 市町村コード,
                表番号, 集計番号リスト);
    }
}
