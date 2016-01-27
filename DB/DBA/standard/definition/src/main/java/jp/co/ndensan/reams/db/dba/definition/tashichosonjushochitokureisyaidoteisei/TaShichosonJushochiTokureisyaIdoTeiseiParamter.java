/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.definition.tashichosonjushochitokureisyaidoteisei;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 他市町村住所地特例者異動の訂正のパラメータクラスです。
 */
@Setter
@Getter
public class TaShichosonJushochiTokureisyaIdoTeiseiParamter {
    
    private final ShikibetsuCode 識別コード;
    
    private final List<TekiyouJouhou> 適用情報グリッド;
    
    /**
     * コンストラクタです。
     * @param 識別コード 識別コード
     * @param 適用情報グリッド 適用情報グリッド 
     */
    public TaShichosonJushochiTokureisyaIdoTeiseiParamter(ShikibetsuCode 識別コード,
            List<TekiyouJouhou> 適用情報グリッド) {
        this.識別コード = 識別コード;
        this.適用情報グリッド = 適用情報グリッド;
    }
}
