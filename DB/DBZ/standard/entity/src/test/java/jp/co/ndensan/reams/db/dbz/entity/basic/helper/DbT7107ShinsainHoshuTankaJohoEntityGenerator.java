/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定審査員報酬単価情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7107ShinsainHoshuTankaJohoEntityGenerator {

    public static final FlexibleDate DEFAULT_報酬単価適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_報酬単価適用終了年月日 = new FlexibleDate("20140402");
    public static final Code DEFAULT_合議体長区分 = new Code("3");
    public static final int DEFAULT_介護認定審査報酬単価 = 1;
    public static final RString DEFAULT_課税非課税区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7107ShinsainHoshuTankaJohoEntityGenerator() {
    }

    public static DbT7107ShinsainHoshuTankaJohoEntity createDbT7107ShinsainHoshuTankaJohoEntity() {
        DbT7107ShinsainHoshuTankaJohoEntity entity = new DbT7107ShinsainHoshuTankaJohoEntity();
        entity.setHoshuTankaTekiyoKaishiYMD(DEFAULT_報酬単価適用開始年月日);
        entity.setHoshuTankaTekiyoShuryoYMD(DEFAULT_報酬単価適用終了年月日);
        entity.setGogitaiChoKubunCode(DEFAULT_合議体長区分);
        entity.setNinteiShinsaHoshuTanka(DEFAULT_介護認定審査報酬単価);
        entity.setKazeiHikazeiKubun(DEFAULT_課税非課税区分);
        return entity;
    }
}
