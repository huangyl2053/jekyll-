/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定主治医意見書報酬単価情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator {

    public static final FlexibleDate DEFAULT_報酬単価適用開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_報酬単価適用終了年月日 = new FlexibleDate("20140402");
    public static final Code DEFAULT_医師区分 = new Code("3");
    public static final int DEFAULT_意見書作成回数 = 1;
    public static final RString DEFAULT_意見書作成料種別 = new RString("1");
    public static final int DEFAULT_主治医意見書作成料単価 = 1;
    public static final RString DEFAULT_課税非課税区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7108ShujiiIkenshoHoshuTanakaJohoEntityGenerator() {
    }

    public static DbT7108ShujiiIkenshoHoshuTanakaJohoEntity createDbT7108ShujiiIkenshoHoshuTanakaJohoEntity() {
        DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity = new DbT7108ShujiiIkenshoHoshuTanakaJohoEntity();
        entity.setHoshuTankaTekiyoKaishiYMD(DEFAULT_報酬単価適用開始年月日);
        entity.setHoshuTankaTekiyoShuryoYMD(DEFAULT_報酬単価適用終了年月日);
        entity.setIshiKubunCode(DEFAULT_医師区分);
        entity.setIkenshoSakuseiKaisu(DEFAULT_意見書作成回数);
        entity.setIkenshoSakuseiryoShubetsu(DEFAULT_意見書作成料種別);
        entity.setShujiiIkenshoSakuseiryoTanka(DEFAULT_主治医意見書作成料単価);
        entity.setKazeiHikazeiKubun(DEFAULT_課税非課税区分);
        return entity;
    }
}
