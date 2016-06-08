/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催番号 = new RString("1");
    public static final FlexibleDate DEFAULT_介護認定審査会開催予定年月日 = new FlexibleDate("20150402");
    public static final RString DEFAULT_介護認定審査会開始予定時刻 = new RString("1");
    public static final RString DEFAULT_介護認定審査会終了予定時刻 = new RString("1");
    public static final RString DEFAULT_介護認定審査会開催予定場所コード = new RString("1");
    public static final int DEFAULT_合議体番号 = 1;
    public static final int DEFAULT_介護認定審査会予定定員 = 1;
    public static final int DEFAULT_介護認定審査会最大定員 = 1;
    public static final int DEFAULT_介護認定審査会自動割当定員 = 1;
    public static final int DEFAULT_介護認定審査会委員定員 = 1;
    public static final FlexibleDate DEFAULT_介護認定審査会資料作成年月日 = new FlexibleDate("20150402");
    public static final Code DEFAULT_介護認定審査会進捗状況 = new Code("1");
    public static final int DEFAULT_介護認定審査会割当済み人数 = 1;
    public static final boolean DEFAULT_資料作成済フラグ = false;
    public static final FlexibleDate DEFAULT_モバイルデータ出力年月日 = new FlexibleDate("20150402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5501ShinsakaiKaisaiYoteiJohoEntityGenerator() {
    }

    public static DbT5501ShinsakaiKaisaiYoteiJohoEntity createDbT5501ShinsakaiKaisaiYoteiJohoEntity() {
        DbT5501ShinsakaiKaisaiYoteiJohoEntity entity = new DbT5501ShinsakaiKaisaiYoteiJohoEntity();
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setShinsakaiKaisaiYoteiYMD(DEFAULT_介護認定審査会開催予定年月日);
        entity.setShinsakaiKaishiYoteiTime(DEFAULT_介護認定審査会開始予定時刻);
        entity.setShinsakaiShuryoYoteiTime(DEFAULT_介護認定審査会終了予定時刻);
        entity.setShinsakaiKaisaiYoteiBashoCode(DEFAULT_介護認定審査会開催予定場所コード);
        entity.setGogitaiNo(DEFAULT_合議体番号);
        entity.setShinsakaiYoteiTeiin(DEFAULT_介護認定審査会予定定員);
        entity.setShinsakaiSaidaiTeiin(DEFAULT_介護認定審査会最大定員);
        entity.setShinsakaiJidoWariateTeiin(DEFAULT_介護認定審査会自動割当定員);
        entity.setShinsakaiIinTeiin(DEFAULT_介護認定審査会委員定員);
        entity.setShinsakaiShiryoSakuseiYMD(DEFAULT_介護認定審査会資料作成年月日);
        entity.setShinsakaiShinchokuJokyo(DEFAULT_介護認定審査会進捗状況);
        entity.setShinsakaiWariateZumiNinzu(DEFAULT_介護認定審査会割当済み人数);
        entity.setShiryoSakuseiZumiFlag(DEFAULT_資料作成済フラグ);
        entity.setMobileDataOutputYMD(DEFAULT_モバイルデータ出力年月日);
        return entity;
    }
}
