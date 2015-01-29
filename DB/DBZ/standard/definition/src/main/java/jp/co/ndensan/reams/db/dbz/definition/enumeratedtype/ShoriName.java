/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタの処理名の列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum ShoriName implements IRStringConvertable {

    /**
     * 納付額データ作成
     */
    納付額データ作成,
    /**
     * 特徴対象者情報取込
     */
    特徴対象者情報取込,
    /**
     * 特徴依頼情報作成
     */
    特徴依頼情報作成,
    /**
     * 特徴依頼処理結果情報取込
     */
    特徴依頼処理結果情報取込,
    /**
     * 特徴結果情報取込
     */
    特徴結果情報取込,
    /**
     * 特徴異動情報作成
     */
    特徴異動情報作成,
    /**
     * 特徴対象者同定
     */
    特徴対象者同定,
    /**
     * 特徴依頼金額計算
     */
    特徴依頼金額計算,
    /**
     * 特徴暫定賦課
     */
    特徴暫定賦課,
    /**
     * 普徴暫定賦課
     */
    普徴暫定賦課,
    /**
     * 暫定異動賦課
     */
    暫定異動賦課,
    /**
     * 特徴暫定平準化計算_6月分
     */
    特徴暫定平準化計算_6月分,
    /**
     * 特徴暫定平準化計算_8月分
     */
    特徴暫定平準化計算_8月分,
    /**
     * 当初所得引出
     */
    当初所得引出,
    /**
     * 本算定賦課
     */
    本算定賦課,
    /**
     * 異動賦課
     */
    異動賦課,
    /**
     * 過年度賦課
     */
    過年度賦課,
    /**
     * 特徴暫定平準化_6月分_確定
     */
    特徴暫定平準化_6月分_確定,
    /**
     * 特徴暫定平準化_8月分_確定
     */
    特徴暫定平準化_8月分_確定,
    /**
     * 過年度賦課確定
     */
    過年度賦課確定,
    /**
     * 賦課確定
     */
    賦課確定,
    /**
     * 所得引出
     */
    所得引出,
    /**
     * 調定簿作成
     */
    調定簿作成,
    /**
     * 新年度管理情報作成
     */
    新年度管理情報作成,
    /**
     * 年度切替
     */
    年度切替;

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
