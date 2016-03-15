/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5511ShinsakaiKaisaiKekkaJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催番号 = new RString("1");
    public static final int DEFAULT_合議体番号 = 1;
    public static final FlexibleDate DEFAULT_介護認定審査会開催年月日 = new FlexibleDate("20150402");
    public static final RString DEFAULT_介護認定審査会開始時刻 = new RString("1");
    public static final RString DEFAULT_介護認定審査会終了時刻 = new RString("1");
    public static final RString DEFAULT_介護認定審査会開催場所コード = new RString("1");
    public static final int DEFAULT_所要時間合計 = 1;
    public static final int DEFAULT_介護認定審査会実施人数 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5511ShinsakaiKaisaiKekkaJohoEntityGenerator() {
    }

    public static DbT5511ShinsakaiKaisaiKekkaJohoEntity createDbT5511ShinsakaiKaisaiKekkaJohoEntity() {
        DbT5511ShinsakaiKaisaiKekkaJohoEntity entity = new DbT5511ShinsakaiKaisaiKekkaJohoEntity();
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setGogitaiNo(DEFAULT_合議体番号);
        entity.setShinsakaiKaisaiYMD(DEFAULT_介護認定審査会開催年月日);
        entity.setShinsakaiKaishiTime(DEFAULT_介護認定審査会開始時刻);
        entity.setShinsakaiShuryoTime(DEFAULT_介護認定審査会終了時刻);
        entity.setShinsakaiKaisaiBashoCode(DEFAULT_介護認定審査会開催場所コード);
        entity.setShoyoJikanGokei(DEFAULT_所要時間合計);
        entity.setShinsakaiJisshiNinzu(DEFAULT_介護認定審査会実施人数);
        return entity;
    }
}
