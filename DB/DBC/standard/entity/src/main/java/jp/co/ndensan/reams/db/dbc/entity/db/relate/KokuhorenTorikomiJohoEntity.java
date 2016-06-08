/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;

/**
 * 国保連IF管理テーブルと同テーブルの前月前々月をJoinした国保連IF管理のエンティティクラスです。
 *
 * @author N2810 久保 里史
 */
public class KokuhorenTorikomiJohoEntity {

    private DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理当月エンティティ;
    private DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理前月エンティティ;
    private DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理前々月エンティティ;

    /**
     * @return the 国保連インターフェース管理当月エンティティ
     */
    public DbT3104KokuhorenInterfaceKanriEntity get国保連インターフェース管理当月エンティティ() {
        return 国保連インターフェース管理当月エンティティ;
    }

    /**
     * @param 国保連インターフェース管理当月エンティティ the 国保連インターフェース管理当月エンティティ to set
     */
    public void set国保連インターフェース管理当月エンティティ(DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理当月エンティティ) {
        this.国保連インターフェース管理当月エンティティ = 国保連インターフェース管理当月エンティティ;
    }

    /**
     * @return the 国保連インターフェース管理前月エンティティ
     */
    public DbT3104KokuhorenInterfaceKanriEntity get国保連インターフェース管理前月エンティティ() {
        return 国保連インターフェース管理前月エンティティ;
    }

    /**
     * @param 国保連インターフェース管理前月エンティティ the 国保連インターフェース管理前月エンティティ to set
     */
    public void set国保連インターフェース管理前月エンティティ(DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理前月エンティティ) {
        this.国保連インターフェース管理前月エンティティ = 国保連インターフェース管理前月エンティティ;
    }

    /**
     * @return the 国保連インターフェース管理前々月エンティティ
     */
    public DbT3104KokuhorenInterfaceKanriEntity get国保連インターフェース管理前々月エンティティ() {
        return 国保連インターフェース管理前々月エンティティ;
    }

    /**
     * @param 国保連インターフェース管理前々月エンティティ the 国保連インターフェース管理前々月エンティティ to set
     */
    public void set国保連インターフェース管理前々月エンティティ(DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理前々月エンティティ) {
        this.国保連インターフェース管理前々月エンティティ = 国保連インターフェース管理前々月エンティティ;
    }

}
