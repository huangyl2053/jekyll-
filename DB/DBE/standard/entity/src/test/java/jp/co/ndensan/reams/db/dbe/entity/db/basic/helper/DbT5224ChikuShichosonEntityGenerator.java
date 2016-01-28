/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 地区市町村エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5224ChikuShichosonEntityGenerator {

    public static final Code DEFAULT_調査地区コード = new Code("1");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final int DEFAULT_優先番号 =  1 ;
    public static final boolean DEFAULT_自地区フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5224ChikuShichosonEntityGenerator() {
    }

    public static DbT5224ChikuShichosonEntity createDbT5224ChikuShichosonEntity() {
        DbT5224ChikuShichosonEntity entity = new DbT5224ChikuShichosonEntity();
        entity.setChosaChikuCode(DEFAULT_調査地区コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setYusenNo(DEFAULT_優先番号);
        entity.setJiChikuFlag(DEFAULT_自地区フラグ);
        return entity;
    }
}
