/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.sougoujigyoujyohou;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業情報のプロセスクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SougouJigyouJyohouProcessParameter implements IBatchProcessParameter {

    private final RString 新規異動区分;
    private final RDateTime 対象開始日時;
    private final RDateTime 対象終了日時;
    private final RString 連携先団体内統合宛名_連携方式;
    private final List<RString> 提供要否List;
    private final RString 個人番号付替対象者被保険者番号;
    private final RString 版番号;

    /**
     * コンストラクタです。
     *
     * @param 新規異動区分 新規異動区分
     * @param 対象開始日時 対象開始日時
     * @param 対象終了日時 対象終了日時
     * @param 連携先団体内統合宛名_連携方式 連携先団体内統合宛名_連携方式
     * @param 提供要否List 提供要否List
     * @param 個人番号付替対象者被保険者番号 個人番号付替対象者被保険者番号
     * @param 版番号 版番号
     */
    public SougouJigyouJyohouProcessParameter(
            RString 新規異動区分,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString 連携先団体内統合宛名_連携方式,
            List<RString> 提供要否List,
            RString 個人番号付替対象者被保険者番号,
            RString 版番号) {
        this.新規異動区分 = 新規異動区分;
        this.対象開始日時 = 対象開始日時;
        this.対象終了日時 = 対象終了日時;
        this.連携先団体内統合宛名_連携方式 = 連携先団体内統合宛名_連携方式;
        this.提供要否List = 提供要否List;
        this.個人番号付替対象者被保険者番号 = 個人番号付替対象者被保険者番号;
        this.版番号 = 版番号;
    }

}
