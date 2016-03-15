/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbx.definition.core.koseishichosonselector;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 構成市町村の検索のパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KoseiShiChosonSelectorParamter {
    
    private final RString systemDate;
    
    private KoseiShiChosonSelectorParamter(RString systemDate) {
        this.systemDate = systemDate;
    }
    
    /**
     * 構成市町村の検索のパラメータを作成します。
     * @return 構成市町村の検索のパラメータ
     */
    public static KoseiShiChosonSelectorParamter createParam() {
        return new KoseiShiChosonSelectorParamter(new RString(RDate.getNowDate().toString()));
    }
}
