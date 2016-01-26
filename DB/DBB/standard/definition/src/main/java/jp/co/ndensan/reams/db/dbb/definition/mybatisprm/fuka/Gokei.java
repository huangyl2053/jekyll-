/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 合計用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class Gokei {

    private final List<KibetsuShokei> kibetsuShokeiList;
    private final List<DankaiShokei> dankaiShokeiList;

    /**
     * コンストラクタです。
     *
     * @param 期別調定額小計リスト 期別調定額小計リスト
     * @param 段階小計リスト 段階小計リスト
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private Gokei(
            List<KibetsuShokei> 期別調定額小計リスト,
            List<DankaiShokei> 段階小計リスト) {

        this.kibetsuShokeiList = requireNonNull(期別調定額小計リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("期別調定額小計リスト"));
        this.dankaiShokeiList = requireNonNull(段階小計リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("段階小計リスト"));
    }

    /**
     * 合計用パラメータを生成します。
     *
     * @param 期別調定額小計リスト 期別調定額小計リスト
     * @param 段階小計リスト 段階小計リスト
     * @return 合計用パラメータ
     */
    public static Gokei createParam(
            List<KibetsuShokei> 期別調定額小計リスト,
            List<DankaiShokei> 段階小計リスト
    ) {
        return new Gokei(期別調定額小計リスト, 段階小計リスト);
    }

}
