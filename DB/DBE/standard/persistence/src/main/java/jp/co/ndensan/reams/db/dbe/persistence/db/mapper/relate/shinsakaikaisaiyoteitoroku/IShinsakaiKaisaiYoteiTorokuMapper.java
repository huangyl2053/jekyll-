/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteitoroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催予定登録1のマッパーインタフェースです。
 */
public interface IShinsakaiKaisaiYoteiTorokuMapper {

    /**
     * count数を取得します。
     *
     * @param 開催番号 開催番号
     * @return count数
     */
    int getDbT5511Count(RString 開催番号);

    /**
     * count数を取得します。
     *
     * @param 開催番号 開催番号
     * @return count数
     */
    int getDbT5501Count(RString 開催番号);
}
