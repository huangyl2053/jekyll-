/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 発番管理情報を表す列挙型です。
 *
 * @author N1013 松本直樹
 */
public enum HatsubanKanriJoho implements IColumnDefinition {

    /**
     * 項目区分
     */
    KOMOKU_KUBUN,
    /**
     * 年度
     */
    NENDO,
    /**
     * 発番番号
     */
    HATSUBAN
}
