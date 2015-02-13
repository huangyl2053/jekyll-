/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 *
 * @author N2810 久保 里史
 */
public interface IConfigKeysKokuhorenTorikomi {

    public Enum get処理名称();

    public Enum get交換情報識別番号();

    public Enum getバッチID();

    public Enum get一覧表示順();

    public Enum get有効区分();

    public Enum get処理サイクル区分();

    public Enum get処理月();

    public Enum get再処理不可区分();

    public Enum get排他チェック有り区分();

}
