/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.tashichosonjushochitokureisyaidoteisei;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 他市町村住所地特例者異動の訂正のパラメータクラスです。
 *
 * @reamsid_L DBA-0401-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class TaShichosonJushochiTokureisyaIdoTeiseiParamter {

    private final List<ShisetsuNyutaishoData> 入退所データリスト;
    private final List<TekiyouJouhou> 適用情報グリッド;

    /**
     * コンストラクタです。
     *
     * @param 入退所データリスト 入退所データリスト
     * @param 適用情報グリッド 適用情報グリッド
     */
    public TaShichosonJushochiTokureisyaIdoTeiseiParamter(List<ShisetsuNyutaishoData> 入退所データリスト,
            List<TekiyouJouhou> 適用情報グリッド) {
        this.入退所データリスト = 入退所データリスト;
        this.適用情報グリッド = 適用情報グリッド;
    }
}
