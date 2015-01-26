/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * マッパーID管理用enumクラスです。
 *
 * @author N8156 宮本 康
 */
public enum DbcMapperInterfaces {

    給付管理票取込_一時データ全取得("IKyufukanrihyoDataTempTableMapper.selectAll"),
    国保連ＩＦ管理_データ取得byキー("IKokuhorenInterfaceKanriMapper.selectbyKey"),
    国保連ＩＦ管理_取込処理更新("IKokuhorenInterfaceKanriMapper.torikomiShoriUpdater"),
    給付管理票取込_一時データ取得("IKyufukanrihyoDataTempTableMapper.getTempData");

    private final RString fullPath;

    private DbcMapperInterfaces(String interfaceName) {
        this.fullPath = new RString("jp.co.ndensan.reams.db.dbc.persistence.mappers." + interfaceName);
    }

    /**
     * マッパーIDのフルパスを取得します。
     *
     * @return マッパーIDのフルパス
     */
    public RString getFullPath() {
        return fullPath;
    }
}
