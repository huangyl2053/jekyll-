/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 641 高額合算自己負担額証明書情報のコンフィグ名を表す列挙型です。
 *
 * @author N2810 久保 里史
 */
public enum ConfigKeysKogakugassanJikofutangakuShomeisho implements IConfigKeysKokuhorenTorikomi {

    国保連取込_高額合算自己負担額証明書情報_バッチID,
    国保連取込_高額合算自己負担額証明書情報_一覧表示順,
    国保連取込_高額合算自己負担額証明書情報_交換情報識別番号,
    国保連取込_高額合算自己負担額証明書情報_再処理不可区分,
    国保連取込_高額合算自己負担額証明書情報_処理サイクル区分,
    国保連取込_高額合算自己負担額証明書情報_処理月,
    国保連取込_高額合算自己負担額証明書情報_処理名称,
    国保連取込_高額合算自己負担額証明書情報_排他チェック有り区分,
    国保連取込_高額合算自己負担額証明書情報_有効区分;

    @Override
    public Enum getバッチID() {
        return 国保連取込_高額合算自己負担額証明書情報_バッチID;
    }

    @Override
    public Enum get一覧表示順() {
        return 国保連取込_高額合算自己負担額証明書情報_一覧表示順;
    }

    @Override
    public Enum get交換情報識別番号() {
        return 国保連取込_高額合算自己負担額証明書情報_交換情報識別番号;
    }

    @Override
    public Enum get再処理不可区分() {
        return 国保連取込_高額合算自己負担額証明書情報_再処理不可区分;
    }

    @Override
    public Enum get処理サイクル区分() {
        return 国保連取込_高額合算自己負担額証明書情報_処理サイクル区分;
    }

    @Override
    public Enum get処理月() {
        return 国保連取込_高額合算自己負担額証明書情報_処理月;
    }

    @Override
    public Enum get処理名称() {
        return 国保連取込_高額合算自己負担額証明書情報_処理名称;
    }

    @Override
    public Enum get排他チェック有り区分() {
        return 国保連取込_高額合算自己負担額証明書情報_排他チェック有り区分;
    }

    @Override
    public Enum get有効区分() {
        return 国保連取込_高額合算自己負担額証明書情報_有効区分;
    }

}
