/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype;

/**
 *
 * @author N2810 久保 里史
 */
public interface IConfigKeysKokuhorenTorikomi {

    Enum get処理名称();

    Enum get交換情報識別番号();

    Enum getバッチID();

    Enum get一覧表示順();

    Enum get有効区分();

    Enum get処理サイクル区分();

    Enum get処理月();

    Enum get再処理不可区分();

    Enum get排他チェック有り区分();

}
