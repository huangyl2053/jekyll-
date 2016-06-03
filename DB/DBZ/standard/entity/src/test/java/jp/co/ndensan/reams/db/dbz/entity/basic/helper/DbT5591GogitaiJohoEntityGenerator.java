/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5591GogitaiJohoEntityGenerator {

    public static final int DEFAULT_合議体番号 = 1;
    public static final RString DEFAULT_合議体名称 = new RString("1");
    public static final FlexibleDate DEFAULT_合議体有効期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_合議体有効期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_合議体開始予定時刻 = new RString("1");
    public static final RString DEFAULT_合議体終了予定時刻 = new RString("1");
    public static final RString DEFAULT_介護認定審査会開催場所コード = new RString("1");
    public static final int DEFAULT_介護認定審査会予定定員 = 1;
    public static final int DEFAULT_介護認定審査会自動割当定員 = 1;
    public static final int DEFAULT_介護認定審査会委員定員 = 1;
    public static final boolean DEFAULT_合議体精神科医存在フラグ = false;
    public static final boolean DEFAULT_合議体ダミーフラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5591GogitaiJohoEntityGenerator() {
    }

    public static DbT5591GogitaiJohoEntity createDbT5591GogitaiJohoEntity() {
        DbT5591GogitaiJohoEntity entity = new DbT5591GogitaiJohoEntity();
        entity.setGogitaiNo(DEFAULT_合議体番号);
        entity.setGogitaiMei(DEFAULT_合議体名称);
        entity.setGogitaiYukoKikanKaishiYMD(DEFAULT_合議体有効期間開始年月日);
        entity.setGogitaiYukoKikanShuryoYMD(DEFAULT_合議体有効期間終了年月日);
        entity.setGogitaiKaishiYoteiTime(DEFAULT_合議体開始予定時刻);
        entity.setGogitaiShuryoYoteiTime(DEFAULT_合議体終了予定時刻);
        entity.setShinsakaiKaisaiBashoCode(DEFAULT_介護認定審査会開催場所コード);
        entity.setShinsakaiYoteiTeiin(DEFAULT_介護認定審査会予定定員);
        entity.setShinsakaiJidoWariateTeiin(DEFAULT_介護認定審査会自動割当定員);
        entity.setShinsakaiIinTeiin(DEFAULT_介護認定審査会委員定員);
        entity.setGogitaiSeishinkaSonzaiFlag(DEFAULT_合議体精神科医存在フラグ);
        entity.setGogitaiDummyFlag(DEFAULT_合議体ダミーフラグ);
        return entity;
    }
}
