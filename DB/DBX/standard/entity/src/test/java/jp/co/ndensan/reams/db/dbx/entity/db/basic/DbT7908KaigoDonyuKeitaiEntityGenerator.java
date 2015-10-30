/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護導入形態エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7908KaigoDonyuKeitaiEntityGenerator {

    public static final RString DEFAULT_業務分類 = new RString("Data");
    public static final Code DEFAULT_導入形態コード = new Code("1");
    public static final boolean DEFAULT_支所管理有無フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7908KaigoDonyuKeitaiEntityGenerator() {
    }

    public static DbT7908KaigoDonyuKeitaiEntity createDbT7908KaigoDonyuKeitaiEntity() {
        DbT7908KaigoDonyuKeitaiEntity entity = new DbT7908KaigoDonyuKeitaiEntity();
        entity.setGyomuBunrui(DEFAULT_業務分類);
        entity.setDonyuKeitaiCode(DEFAULT_導入形態コード);
        entity.setShishoKanriUmuFlag(DEFAULT_支所管理有無フラグ);
        return entity;
    }
}
