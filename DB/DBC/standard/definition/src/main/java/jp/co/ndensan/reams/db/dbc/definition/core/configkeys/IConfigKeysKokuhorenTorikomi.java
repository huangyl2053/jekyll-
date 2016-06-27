/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.configkeys;

/**
 *
 * @author N2810 久保 里史
 */
public interface IConfigKeysKokuhorenTorikomi {

    /**
     * 処理名称
     *
     * @return 処理名称
     */
    Enum get処理名称();

    /**
     * 交換情報識別番号
     *
     * @return 交換情報識別番号
     */
    Enum get交換情報識別番号();

    /**
     * バッチID
     *
     * @return バッチID
     */
    Enum getバッチID();

    /**
     * 一覧表示順
     *
     * @return 一覧表示順
     */
    Enum get一覧表示順();

    /**
     * 有効区分
     *
     * @return 有効区分
     */
    Enum get有効区分();

    /**
     * 処理サイクル区分
     *
     * @return 処理サイクル区分
     */
    Enum get処理サイクル区分();

    /**
     * 処理月
     *
     * @return 処理月
     */
    Enum get処理月();

    /**
     * 再処理不可区分
     *
     * @return 再処理不可区分
     */
    Enum get再処理不可区分();

    /**
     * 排他チェック有り区分
     *
     * @return 排他チェック有り区分
     */
    Enum get排他チェック有り区分();

}
