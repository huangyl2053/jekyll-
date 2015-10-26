/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体割当委員情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5593GogitaiWariateIinJohoEntityGenerator {

    public static final int DEFAULT_合議体番号 = 1;
    public static final FlexibleDate DEFAULT_合議体有効期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_合議体有効期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_介護認定審査会委員コード = new RString("1");
    public static final Code DEFAULT_合議体長区分コード = new Code("1");
    public static final boolean DEFAULT_補欠 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5593GogitaiWariateIinJohoEntityGenerator() {
    }

    public static DbT5593GogitaiWariateIinJohoEntity createDbT5593GogitaiWariateIinJohoEntity() {
        DbT5593GogitaiWariateIinJohoEntity entity = new DbT5593GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(DEFAULT_合議体番号);
        entity.setGogitaiYukoKikanKaishiYMD(DEFAULT_合議体有効期間開始年月日);
        entity.setGogitaiYukoKikanShuryoYMD(DEFAULT_合議体有効期間終了年月日);
        entity.setShinsakaiIinCode(DEFAULT_介護認定審査会委員コード);
        entity.setGogitaichoKubunCode(DEFAULT_合議体長区分コード);
        entity.setSubstituteFlag(DEFAULT_補欠);
        return entity;
    }
}
