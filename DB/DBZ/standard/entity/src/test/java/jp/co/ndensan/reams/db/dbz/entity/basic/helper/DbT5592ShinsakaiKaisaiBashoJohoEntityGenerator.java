/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催場所情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催場所コード = new RString("1");
    public static final RString DEFAULT_介護認定審査会開催場所名称 = new RString("1");
    public static final Code DEFAULT_介護認定審査会開催地区コード = new Code("1");
    public static final RString DEFAULT_介護認定審査会開催場所住所 = new RString("1");
    public static final TelNo DEFAULT_介護認定審査会開催場所電話番号 = new TelNo("1234567890");
    public static final boolean DEFAULT_介護認定審査会開催場所状況 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5592ShinsakaiKaisaiBashoJohoEntityGenerator() {
    }

    public static DbT5592ShinsakaiKaisaiBashoJohoEntity createDbT5592ShinsakaiKaisaiBashoJohoEntity() {
        DbT5592ShinsakaiKaisaiBashoJohoEntity entity = new DbT5592ShinsakaiKaisaiBashoJohoEntity();
        entity.setShinsakaiKaisaiBashoCode(DEFAULT_介護認定審査会開催場所コード);
        entity.setShinsakaiKaisaiBashoName(DEFAULT_介護認定審査会開催場所名称);
        entity.setShinsakaiKaisaiChikuCode(DEFAULT_介護認定審査会開催地区コード);
        entity.setShinsakaiKaisaiBashoJusho(DEFAULT_介護認定審査会開催場所住所);
        entity.setShinsakaiKaisaiBashoTelNo(DEFAULT_介護認定審査会開催場所電話番号);
        entity.setShinsakaiKaisaiBashoJokyo(DEFAULT_介護認定審査会開催場所状況);
        return entity;
    }
}
