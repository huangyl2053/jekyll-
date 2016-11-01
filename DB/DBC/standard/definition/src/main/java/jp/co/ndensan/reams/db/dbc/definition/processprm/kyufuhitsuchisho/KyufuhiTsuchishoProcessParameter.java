/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho.KyufuhiTsuchishoBatchMybitisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険給付費通知書のパラメータクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTsuchishoProcessParameter implements IBatchProcessParameter {

    private RString 処理年月日;
    private RString サービス種類区分;
    private RString サービス年月開始;
    private RString サービス年月終了;
    private RString 福祉用具貸与ページ出力区分;
    private RString 集約区分;
    private RString 保険者構成;
    private RString 証記載保険者番号;
    private RString 要介護度;
    private RString 死亡者分を対象としない;
    private RString ゼロ査定実績を対象としない;
    private RString 再審査分を対象としない;
    private RString 過誤分を対象としない;
    private RString 施設分を対象としない;
    private RString 特定入所者介護を対象としない;
    private RString 償還分を対象としない;
    private RString 出力順ID;
    private RString 文書番号;

    /**
     * コンストラクタ
     *
     * @param サービス年月開始 サービス年月開始
     * @param サービス種類区分 サービス種類区分
     * @param サービス年月終了 サービス年月終了
     * @param 処理年月日 処理年月日
     * @param 要介護度 要介護度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 集約区分 集約区分
     * @param 保険者構成 保険者構成
     * @param 死亡者分を対象としない 死亡者分を対象としない
     * @param ゼロ査定実績を対象としない ゼロ査定実績を対象としない
     * @param 再審査分を対象としない 再審査分を対象としない
     * @param 過誤分を対象としない 過誤分を対象としない
     * @param 施設分を対象としない 施設分を対象としない
     * @param 特定入所者介護を対象としない 特定入所者介護を対象としない
     * @param 償還分を対象としない 償還分を対象としない
     * @param 福祉用具貸与ページ出力区分 福祉用具貸与ページ出力区分
     * @param 文書番号 文書番号
     * @param 出力順ID 出力順ID
     */
    public KyufuhiTsuchishoProcessParameter(
            RString 処理年月日,
            RString サービス種類区分,
            RString サービス年月開始,
            RString サービス年月終了,
            RString 福祉用具貸与ページ出力区分,
            RString 集約区分,
            RString 保険者構成,
            RString 証記載保険者番号,
            RString 要介護度,
            RString 死亡者分を対象としない,
            RString ゼロ査定実績を対象としない,
            RString 再審査分を対象としない,
            RString 過誤分を対象としない,
            RString 施設分を対象としない,
            RString 特定入所者介護を対象としない,
            RString 償還分を対象としない,
            RString 出力順ID,
            RString 文書番号) {
        this.処理年月日 = 処理年月日;
        this.サービス種類区分 = サービス種類区分;
        this.サービス年月開始 = サービス年月開始;
        this.サービス年月終了 = サービス年月終了;
        this.福祉用具貸与ページ出力区分 = 福祉用具貸与ページ出力区分;
        this.集約区分 = 集約区分;
        this.保険者構成 = 保険者構成;
        this.証記載保険者番号 = 証記載保険者番号;
        this.要介護度 = 要介護度;
        this.死亡者分を対象としない = 死亡者分を対象としない;
        this.ゼロ査定実績を対象としない = ゼロ査定実績を対象としない;
        this.再審査分を対象としない = 再審査分を対象としない;
        this.過誤分を対象としない = 過誤分を対象としない;
        this.施設分を対象としない = 施設分を対象としない;
        this.特定入所者介護を対象としない = 特定入所者介護を対象としない;
        this.償還分を対象としない = 償還分を対象としない;
        this.出力順ID = 出力順ID;
        this.文書番号 = 文書番号;
    }

    /**
     * Mybatisパラメータを作成します。
     *
     * @param psmAtesaki 宛先取得PSM
     * @return KyufuhiTsuchishoBatchMybitisParameter Mybatisパラメータ
     */
    public KyufuhiTsuchishoBatchMybitisParameter toKyufuhiTsuchishoBatchMybitisParameter(RString psmAtesaki) {
        return KyufuhiTsuchishoBatchMybitisParameter.creatParameter(サービス種類区分, 死亡者分を対象としない, ゼロ査定実績を対象としない,
                再審査分を対象としない, 過誤分を対象としない, 施設分を対象としない, 特定入所者介護を対象としない, 償還分を対象としない,
                福祉用具貸与ページ出力区分, psmAtesaki, サービス年月開始, サービス年月終了, 証記載保険者番号, 要介護度);
    }
}
