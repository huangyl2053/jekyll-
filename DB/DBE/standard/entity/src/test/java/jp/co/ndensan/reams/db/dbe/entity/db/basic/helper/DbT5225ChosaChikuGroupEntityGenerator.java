/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査地区グループマスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5225ChosaChikuGroupEntityGenerator {

    public static final Code DEFAULT_調査地区グループコード = new Code("1");
    public static final Code DEFAULT_調査地区コード = new Code("1");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final RString DEFAULT_調査地区グループ名称 = new RString("1");
    public static final int DEFAULT_優先番号 =  1 ;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5225ChosaChikuGroupEntityGenerator() {
    }

    public static DbT5225ChosaChikuGroupEntity createDbT5225ChosaChikuGroupEntity() {
        DbT5225ChosaChikuGroupEntity entity = new DbT5225ChosaChikuGroupEntity();
        entity.setChosaChikuGroupCode(DEFAULT_調査地区グループコード);
        entity.setChosachikucode(DEFAULT_調査地区コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setChosachikugroupname(DEFAULT_調査地区グループ名称);
        entity.setYusenNo(DEFAULT_優先番号);
        return entity;
    }
}
