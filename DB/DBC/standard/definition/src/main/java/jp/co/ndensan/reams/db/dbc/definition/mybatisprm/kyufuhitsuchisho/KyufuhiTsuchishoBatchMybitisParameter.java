/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 給付費通知書作成(一括)のMybatisパラメータクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KyufuhiTsuchishoBatchMybitisParameter implements IMyBatisParameter {

    private final boolean サービス種類フラグ1;
    private final boolean サービス種類フラグ2;
    private final boolean サービス種類フラグ3;
    private final RString サービス種類;
    private final boolean 死亡者分を対象フラグ;
    private final RString 死亡者分を対象としない;
    private final boolean ゼロ査定実績を対象フラグ;
    private final RString ゼロ査定実績を対象としない;
    private final boolean 再審査分を対象フラグ;
    private final RString 再審査分を対象としない;
    private final boolean 過誤分を対象フラグ;
    private final RString 過誤分を対象としない;
    private final boolean 施設分を対象フラグ;
    private final RString 施設分を対象としない;
    private final boolean 特定入所者介護を対象フラグ;
    private final RString 特定入所者介護を対象としない;
    private final boolean 償還分を対象フラグ;
    private final RString 償還分を対象としない;
    private final boolean 福祉用具貸与ページ出力区分フラグ;
    private final RString 福祉用具貸与ページ出力区分;
    private final RString psmAtesaki;
    private final RString サービス年月開始;
    private final RString サービス年月終了;
    private final RString 証記載保険者番号;
    private final RString 要介護度;
    private static final RString 数値_1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param サービス種類フラグ1 サービス種類フラグ1
     * @param サービス種類フラグ2 サービス種類フラグ2
     * @param サービス種類フラグ3 サービス種類フラグ3
     * @param サービス種類 サービス種類
     * @param 死亡者分を対象フラグ 死亡者分を対象フラグ
     * @param 死亡者分を対象としない 死亡者分を対象としない
     * @param ゼロ査定実績を対象フラグ ゼロ査定実績を対象フラグ
     * @param ゼロ査定実績を対象としない ゼロ査定実績を対象としない
     * @param 再審査分を対象フラグ 再審査分を対象フラグ
     * @param 再審査分を対象としない 再審査分を対象としない
     * @param 過誤分を対象フラグ 過誤分を対象フラグ
     * @param 過誤分を対象としない 過誤分を対象としない
     * @param 施設分を対象フラグ 施設分を対象フラグ
     * @param 施設分を対象としない 施設分を対象としない
     * @param 特定入所者介護を対象フラグ 特定入所者介護を対象フラグ
     * @param 特定入所者介護を対象としない 特定入所者介護を対象としない
     * @param 償還分を対象フラグ 償還分を対象フラグ
     * @param 償還分を対象としない 償還分を対象としない
     * @param 福祉用具貸与ページ出力区分フラグ 福祉用具貸与ページ出力区分フラグ
     * @param 福祉用具貸与ページ出力区分 福祉用具貸与ページ出力区分
     * @param psmAtesaki 宛先取得PSM
     * @param サービス年月開始 サービス年月開始
     * @param サービス年月終了 サービス年月終了
     * @param 証記載保険者番号 証記載保険者番号
     * @param 要介護度 要介護度
     */
    protected KyufuhiTsuchishoBatchMybitisParameter(
            boolean サービス種類フラグ1,
            boolean サービス種類フラグ2,
            boolean サービス種類フラグ3,
            RString サービス種類,
            boolean 死亡者分を対象フラグ,
            RString 死亡者分を対象としない,
            boolean ゼロ査定実績を対象フラグ,
            RString ゼロ査定実績を対象としない,
            boolean 再審査分を対象フラグ,
            RString 再審査分を対象としない,
            boolean 過誤分を対象フラグ,
            RString 過誤分を対象としない,
            boolean 施設分を対象フラグ,
            RString 施設分を対象としない,
            boolean 特定入所者介護を対象フラグ,
            RString 特定入所者介護を対象としない,
            boolean 償還分を対象フラグ,
            RString 償還分を対象としない,
            boolean 福祉用具貸与ページ出力区分フラグ,
            RString 福祉用具貸与ページ出力区分,
            RString psmAtesaki,
            RString サービス年月開始,
            RString サービス年月終了,
            RString 証記載保険者番号,
            RString 要介護度) {
        this.サービス種類フラグ1 = サービス種類フラグ1;
        this.サービス種類フラグ2 = サービス種類フラグ2;
        this.サービス種類フラグ3 = サービス種類フラグ3;
        this.サービス種類 = サービス種類;
        this.死亡者分を対象フラグ = 死亡者分を対象フラグ;
        this.死亡者分を対象としない = 死亡者分を対象としない;
        this.ゼロ査定実績を対象フラグ = ゼロ査定実績を対象フラグ;
        this.ゼロ査定実績を対象としない = ゼロ査定実績を対象としない;
        this.再審査分を対象フラグ = 再審査分を対象フラグ;
        this.再審査分を対象としない = 再審査分を対象としない;
        this.過誤分を対象フラグ = 過誤分を対象フラグ;
        this.過誤分を対象としない = 過誤分を対象としない;
        this.施設分を対象フラグ = 施設分を対象フラグ;
        this.施設分を対象としない = 施設分を対象としない;
        this.特定入所者介護を対象フラグ = 特定入所者介護を対象フラグ;
        this.特定入所者介護を対象としない = 特定入所者介護を対象としない;
        this.償還分を対象フラグ = 償還分を対象フラグ;
        this.償還分を対象としない = 償還分を対象としない;
        this.福祉用具貸与ページ出力区分フラグ = 福祉用具貸与ページ出力区分フラグ;
        this.福祉用具貸与ページ出力区分 = 福祉用具貸与ページ出力区分;
        this.psmAtesaki = psmAtesaki;
        this.サービス年月開始 = サービス年月開始;
        this.サービス年月終了 = サービス年月終了;
        this.証記載保険者番号 = 証記載保険者番号;
        this.要介護度 = 要介護度;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param サービス種類 サービス種類
     * @param 死亡者分を対象としない 死亡者分を対象としない
     * @param ゼロ査定実績を対象としない ゼロ査定実績を対象としない
     * @param 再審査分を対象としない 再審査分を対象としない
     * @param 過誤分を対象としない 過誤分を対象としない
     * @param 施設分を対象としない 施設分を対象としない
     * @param 特定入所者介護を対象としない 特定入所者介護を対象としない
     * @param 償還分を対象としない 償還分を対象としない
     * @param 福祉用具貸与ページ出力区分 福祉用具貸与ページ出力区分
     * @param psmAtesaki 宛先取得PSM
     * @param サービス年月開始 サービス年月開始
     * @param サービス年月終了 サービス年月終了
     * @param 証記載保険者番号 証記載保険者番号
     * @param 要介護度 要介護度
     * @return KyufuhiTsuchishoBatchMybitisParameter
     */
    public static KyufuhiTsuchishoBatchMybitisParameter creatParameter(
            RString サービス種類,
            RString 死亡者分を対象としない,
            RString ゼロ査定実績を対象としない,
            RString 再審査分を対象としない,
            RString 過誤分を対象としない,
            RString 施設分を対象としない,
            RString 特定入所者介護を対象としない,
            RString 償還分を対象としない,
            RString 福祉用具貸与ページ出力区分,
            RString psmAtesaki,
            RString サービス年月開始,
            RString サービス年月終了,
            RString 証記載保険者番号,
            RString 要介護度) {
        boolean サービス種類フラグ1 = false;
        boolean サービス種類フラグ2 = false;
        boolean サービス種類フラグ3 = false;
        boolean 死亡者分を対象フラグ = false;
        boolean ゼロ査定実績を対象フラグ = false;
        boolean 再審査分を対象フラグ = false;
        boolean 過誤分を対象フラグ = false;
        boolean 施設分を対象フラグ = false;
        boolean 特定入所者介護を対象フラグ = false;
        boolean 償還分を対象フラグ = false;
        boolean 福祉用具貸与ページ出力区分フラグ = false;
        if (サービス種類.equals(new RString("居宅サービスのみ"))) {
            サービス種類フラグ1 = true;
        }
        if (サービス種類.equals(new RString("施設サービスのみ"))) {
            サービス種類フラグ2 = true;
        }
        if (サービス種類.equals(new RString("居宅サービス・施設サービス混在"))) {
            サービス種類フラグ3 = true;
        }
        if (数値_1.equals(死亡者分を対象としない)) {
            死亡者分を対象フラグ = true;
        }
        if (数値_1.equals(ゼロ査定実績を対象としない)) {
            ゼロ査定実績を対象フラグ = true;
        }
        if (数値_1.equals(再審査分を対象としない)) {
            再審査分を対象フラグ = true;
        }
        if (数値_1.equals(過誤分を対象としない)) {
            過誤分を対象フラグ = true;
        }
        if (数値_1.equals(施設分を対象としない)) {
            施設分を対象フラグ = true;
        }
        if (数値_1.equals(特定入所者介護を対象としない)) {
            特定入所者介護を対象フラグ = true;
        }
        if (数値_1.equals(償還分を対象としない)) {
            償還分を対象フラグ = true;
        }
        if (数値_1.equals(福祉用具貸与ページ出力区分)) {
            福祉用具貸与ページ出力区分フラグ = true;
        }
        return new KyufuhiTsuchishoBatchMybitisParameter(サービス種類フラグ1, サービス種類フラグ2, サービス種類フラグ3, サービス種類, 死亡者分を対象フラグ,
                死亡者分を対象としない, ゼロ査定実績を対象フラグ, ゼロ査定実績を対象としない, 再審査分を対象フラグ, 再審査分を対象としない, 過誤分を対象フラグ,
                過誤分を対象としない, 施設分を対象フラグ, 施設分を対象としない, 特定入所者介護を対象フラグ, 特定入所者介護を対象としない, 償還分を対象フラグ,
                償還分を対象としない, 福祉用具貸与ページ出力区分フラグ, 福祉用具貸与ページ出力区分, psmAtesaki, サービス年月開始, サービス年月終了,
                証記載保険者番号, 要介護度);
    }

}
