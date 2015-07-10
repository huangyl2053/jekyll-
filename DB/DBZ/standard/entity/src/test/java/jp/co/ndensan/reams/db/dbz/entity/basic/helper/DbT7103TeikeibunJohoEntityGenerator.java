/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7103TeikeibunJohoEntityGenerator {

    public static final RString DEFAULT_定型区分 = new RString("1");
    public static final RString DEFAULT_種別 = new RString("1");
    public static final RString DEFAULT_定型文コード = new RString("1");
    public static final RString DEFAULT_定型文内容 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7103TeikeibunJohoEntityGenerator() {
    }

    public static DbT7103TeikeibunJohoEntity createDbT7103TeikeibunJohoEntity() {
        DbT7103TeikeibunJohoEntity entity = new DbT7103TeikeibunJohoEntity();
        entity.setTeikeiKubun(DEFAULT_定型区分);
        entity.setShubetsu(DEFAULT_種別);
        entity.setTeikeibunCd(DEFAULT_定型文コード);
        entity.setTeikeibunNaiyo(DEFAULT_定型文内容);
        return entity;
    }
}
