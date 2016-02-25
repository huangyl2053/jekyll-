/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

/**
 * 534 受給者台帳突合結果情報（随時）_のコンフィグ名を表す列挙型です。
 *
 * @author N2810 久保 里史
 */
public enum ConfigKeysJukyushaDaichoTotsugoKekka implements IConfigKeysKokuhorenTorikomi {

    国保連取込_受給者台帳突合結果情報随時,
    国保連取込_受給者台帳突合結果情報随時_バッチID,
    国保連取込_受給者台帳突合結果情報随時_一覧表示順,
    国保連取込_受給者台帳突合結果情報随時_交換情報識別番号,
    国保連取込_受給者台帳突合結果情報随時_再処理不可区分,
    国保連取込_受給者台帳突合結果情報随時_処理サイクル区分,
    国保連取込_受給者台帳突合結果情報随時_処理月,
    国保連取込_受給者台帳突合結果情報随時_処理名称,
    国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分,
    国保連取込_受給者台帳突合結果情報随時_有効区分;

    @Override
    public Enum getバッチID() {
        return 国保連取込_受給者台帳突合結果情報随時_バッチID;
    }

    @Override
    public Enum get一覧表示順() {
        return 国保連取込_受給者台帳突合結果情報随時_一覧表示順;
    }

    @Override
    public Enum get交換情報識別番号() {
        return 国保連取込_受給者台帳突合結果情報随時_交換情報識別番号;
    }

    @Override
    public Enum get再処理不可区分() {
        return 国保連取込_受給者台帳突合結果情報随時_再処理不可区分;
    }

    @Override
    public Enum get処理サイクル区分() {
        return 国保連取込_受給者台帳突合結果情報随時_処理サイクル区分;
    }

    @Override
    public Enum get処理月() {
        return 国保連取込_受給者台帳突合結果情報随時_処理月;
    }

    @Override
    public Enum get処理名称() {
        return 国保連取込_受給者台帳突合結果情報随時_処理名称;
    }

    @Override
    public Enum get排他チェック有り区分() {
        return 国保連取込_受給者台帳突合結果情報随時_排他チェック有り区分;
    }

    @Override
    public Enum get有効区分() {
        return 国保連取込_受給者台帳突合結果情報随時_有効区分;
    }

    public static IConfigKeysKokuhorenTorikomi getEnum() {
        return 国保連取込_受給者台帳突合結果情報随時;
    }
}
