/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報のプロセスパラメータクラスです。
 *
 * @reamsid_L DBU-4880-030 zhaoyao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaJohoProcessParameter implements IBatchProcessParameter {

    private RString 新規異動区分;
    private RDateTime 対象開始日時;
    private RDateTime 対象終了日時;
    private RString 連携先団体内統合宛名_連携方式;
    private List<RString> 提供要否List;
    private RString 個人番号付替対象者被保険者番号;
    private RString 版番号;
    private RString 特定個人情報名コード;
    private RString 提供基本情報中間テーブル名;

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
    public HihokenshaJohoProcessParameter(
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
