/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会音声情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5512ShinsakaiOnseiJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催番号 = new RString("1");
    public static final int DEFAULT_連番 = 1;
    public static final byte[] DEFAULT_審査会音声ファイル = null;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5512ShinsakaiOnseiJohoEntityGenerator() {
    }

    public static DbT5512ShinsakaiOnseiJohoEntity createDbT5512ShinsakaiOnseiJohoEntity() {
        DbT5512ShinsakaiOnseiJohoEntity entity = new DbT5512ShinsakaiOnseiJohoEntity();
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setRenban(DEFAULT_連番);
        entity.setShinsakaiOnseiFile(DEFAULT_審査会音声ファイル);
        return entity;
    }
}
