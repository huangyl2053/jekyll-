/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区認定調査員エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5223ChikuNinteiChosainEntityGenerator {

    public static final Code DEFAULT_調査地区コード = new Code("1");
    public static final RString DEFAULT_認定調査委託先コード = new RString("1");
    public static final RString DEFAULT_認定調査員コード = new RString("1");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final int DEFAULT_優先番号 = 1;
    public static final RString DEFAULT_備考 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5223ChikuNinteiChosainEntityGenerator() {
    }

    public static DbT5223ChikuNinteiChosainEntity createDbT5223ChikuNinteiChosainEntity() {
        DbT5223ChikuNinteiChosainEntity entity = new DbT5223ChikuNinteiChosainEntity();
        entity.setChosaChikuCode(DEFAULT_調査地区コード);
        entity.setNinteiChosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainCode(DEFAULT_認定調査員コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setYusenNo(DEFAULT_優先番号);
        entity.setBiko(DEFAULT_備考);
        return entity;
    }
}
