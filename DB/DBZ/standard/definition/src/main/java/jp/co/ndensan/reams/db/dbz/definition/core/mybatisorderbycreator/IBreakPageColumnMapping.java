/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 改頁用を生成するクラスです。
 *
 * @reamsid_L DBZ-9999-021 duanzhanli
 */
public interface IBreakPageColumnMapping extends Serializable {

    /**
     * テーブルのカラム物理名を返します。
     *
     * @return カラム物理名
     */
    RString getColumn();

    /**
     * テーブルのカラム論理名を返します。
     *
     * @return カラム論理名
     */
    RString getItem();

    /**
     * 改頁名を返します。
     *
     * @return 改頁名
     */
    RString getBreakPageName();

    /**
     * 指定された項目名の改頁名を返します。
     *
     * @param column カラム物理名
     * @return 改頁用enum
     */
    IBreakPageColumnMapping toValue(RString column);

}
