/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会事前審査結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5508ShinsakaiJizenKekkaJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催番号 = new RString("1");
    public static final RString DEFAULT_介護認定審査会委員コード = new RString("名称");
    public static final int DEFAULT_介護認定審査会審査順 = 1;
    public static final RString DEFAULT_一次判定結果変更理由 = new RString("名称");
    public static final Code DEFAULT_二次判定結果コード = new Code("01");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5508ShinsakaiJizenKekkaJohoEntityGenerator() {
    }

    public static DbT5508ShinsakaiJizenKekkaJohoEntity createDbT5508ShinsakaiJizenKekkaJohoEntity() {
        DbT5508ShinsakaiJizenKekkaJohoEntity entity = new DbT5508ShinsakaiJizenKekkaJohoEntity();
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setShinsakaiIinCode(DEFAULT_介護認定審査会委員コード);
        entity.setShinsakaiOrder(DEFAULT_介護認定審査会審査順);
        entity.setIchijiHanteiHenkoRiyu(DEFAULT_一次判定結果変更理由);
        entity.setNijiHanteiKekkaCode(DEFAULT_二次判定結果コード);
        return entity;
    }
}
