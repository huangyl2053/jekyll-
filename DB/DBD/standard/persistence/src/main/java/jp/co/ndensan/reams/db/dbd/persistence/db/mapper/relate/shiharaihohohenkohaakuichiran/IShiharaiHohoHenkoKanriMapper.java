/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd207010.ShiharaiHohoHenkoKanriMybatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更管理リストクラスです．
 *
 * @reamsid_L DBD-36500-040 x_lilh
 */
public interface IShiharaiHohoHenkoKanriMapper {

    /**
     * 支払方法変更管理リスト情報を取得します．
     *
     * @param parameter パラメター
     * @return 支払方法変更管理リスト情報
     */
    List<RString> get支払方法変更管理対象者(ShiharaiHohoHenkoKanriMybatisParameter parameter);

}
