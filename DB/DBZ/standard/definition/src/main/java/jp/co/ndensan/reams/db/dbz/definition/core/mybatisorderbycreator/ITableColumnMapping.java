/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.mybatisorderbycreator;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * MyBatis内で使用する、出力順指示用のOrderBy句を生成するクラスです。
 *
 * @reamsid_L DBZ-9999-021 duanzhanli
 */
public interface ITableColumnMapping extends Serializable {

    /**
     * 項目名を返します。
     *
     * @return 項目名
     */
    RString getColumn();

    /**
     * テーブル名を返します。
     *
     * @return テーブル名
     */
    RString getTableName();

    /**
     * テーブル名を返します。
     *
     * @return テーブル名
     */
    RString getItem();

    /**
     * 指定された項目名を返します。
     *
     * @param column 項目名
     * @return 出力順指示用enum
     */
    ITableColumnMapping toValue(RString column);

}
