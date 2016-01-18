/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告年報詳細データの更新処理のMyBatisパラメタークラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuNenpoUpdateParameter {

    private final FlexibleYear hokokuYSeireki;
    private final RString hokokuM;
    private final FlexibleYear shukeiTaishoYSeireki;
    private final RString shukeiTaishoM;
    private final RString toukeiTaishoKubun;
    private final LasdecCode shichosonCode;
    private final Code hyoNo;
    private final Code shukeiNo;
    private final Code shukeiTani;
    private final Decimal tateNo;
    private final Decimal yokoNo;
    private final Decimal shukeiKekkaAtai;

    private JigyoHokokuNenpoUpdateParameter(FlexibleYear hokokuYSeireki, RString hokokuM, FlexibleYear shukeiTaishoYSeireki, RString shukeiTaishoM, RString toukeiTaishoKubun, LasdecCode shichosonCode, Code hyoNo, Code shukeiNo, Code shukeiTani, Decimal tateNo, Decimal yokoNo, Decimal shukeiKekkaAtai) {
        this.hokokuYSeireki = hokokuYSeireki;
        this.hokokuM = hokokuM;
        this.shukeiTaishoYSeireki = shukeiTaishoYSeireki;
        this.shukeiTaishoM = shukeiTaishoM;
        this.toukeiTaishoKubun = toukeiTaishoKubun;
        this.shichosonCode = shichosonCode;
        this.hyoNo = hyoNo;
        this.shukeiNo = shukeiNo;
        this.shukeiTani = shukeiTani;
        this.tateNo = tateNo;
        this.yokoNo = yokoNo;
        this.shukeiKekkaAtai = shukeiKekkaAtai;
    }

    /**
     * 事業報告年報詳細データの更新処理のパラメターを生成します。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 集計対象月 集計対象月
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 集計単位 集計単位
     * @param 縦番号 縦番号
     * @param 横番号 横番号
     * @param 集計結果値 集計結果値
     * @return JigyoHokokuNenpoUpdateParameter 事業報告年報詳細データの更新処理のパラメター
     */
    public static JigyoHokokuNenpoUpdateParameter createParameterForJigyoHokokuNenpo(
            FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年, RString 集計対象月, RString 統計対象区分, LasdecCode 市町村コード, Code 表番号, Code 集計番号, Code 集計単位, Decimal 縦番号, Decimal 横番号, Decimal 集計結果値) {
        return new JigyoHokokuNenpoUpdateParameter(報告年, 報告月, 集計対象年, 集計対象月, 統計対象区分, 市町村コード, 表番号, 集計番号, 集計単位, 縦番号, 横番号, 集計結果値);
    }
}
