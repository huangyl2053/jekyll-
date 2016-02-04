/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import java.util.List;

/**
 * 合計後用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class Gokeigo {

    private final List<KibetsuGokeigo> kibetsuGokeigoList;
    private final List<DankaiGokeigo> dankaiGokeigoList;

    /**
     * コンストラクタです。
     *
     * @param 期別合計後リスト 期別合計後リスト
     * @param 段階合計後リスト 段階合計後リスト
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private Gokeigo(
            List<KibetsuGokeigo> 期別合計後リスト,
            List<DankaiGokeigo> 段階合計後リスト) {

        this.kibetsuGokeigoList = 期別合計後リスト;
        this.dankaiGokeigoList = 段階合計後リスト;
    }

    /**
     * 合計後用パラメータを生成します。
     *
     * @param 期別合計後リスト 期別合計後リスト
     * @param 段階合計後リスト 段階合計後リスト
     * @return 合計後用パラメータ
     */
    public static Gokeigo createParam(
            List<KibetsuGokeigo> 期別合計後リスト,
            List<DankaiGokeigo> 段階合計後リスト
    ) {
        return new Gokeigo(期別合計後リスト, 段階合計後リスト);
    }

}
