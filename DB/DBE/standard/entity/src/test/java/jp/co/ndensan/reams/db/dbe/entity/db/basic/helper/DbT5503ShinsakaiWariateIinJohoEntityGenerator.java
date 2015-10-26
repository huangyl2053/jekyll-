/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当委員情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5503ShinsakaiWariateIinJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催番号 = new RString("1");
    public static final RString DEFAULT_介護認定審査会委員コード = new RString("1");
    public static final FlexibleDate DEFAULT_介護認定審査会開催年月日 = new FlexibleDate("20150402");
    public static final Code DEFAULT_介護認定審査会議長区分コード = new Code("1");
    public static final boolean DEFAULT_委員出席 = false;
    public static final boolean DEFAULT_委員遅刻有無 = false;
    public static final RString DEFAULT_委員出席時間 = new RString("1");
    public static final boolean DEFAULT_委員早退有無 = false;
    public static final RString DEFAULT_委員退席時間 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5503ShinsakaiWariateIinJohoEntityGenerator() {
    }

    public static DbT5503ShinsakaiWariateIinJohoEntity createDbT5503ShinsakaiWariateIinJohoEntity() {
        DbT5503ShinsakaiWariateIinJohoEntity entity = new DbT5503ShinsakaiWariateIinJohoEntity();
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setShinsakaiIinCode(DEFAULT_介護認定審査会委員コード);
        entity.setShinsakaiKaisaiYMD(DEFAULT_介護認定審査会開催年月日);
        entity.setKaigoninteiShinsakaiGichoKubunCode(DEFAULT_介護認定審査会議長区分コード);
        entity.setShussekiFlag(DEFAULT_委員出席);
        entity.setExistChikokuFlag(DEFAULT_委員遅刻有無);
        entity.setShussekiTime(DEFAULT_委員出席時間);
        entity.setExistSotaiFlag(DEFAULT_委員早退有無);
        entity.setTaisekiTime(DEFAULT_委員退席時間);
        return entity;
    }
}
