/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報　継承エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7011ShujiiIryoKikanJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_介護医療機関コード = new RString("123");
    public static final RString DEFAULT_医療機関コード = new RString("123");
    public static final RString DEFAULT_医療機関の状況 = new RString("1");
    public static final Code DEFAULT_機関の区分コード = new Code("3");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7011ShujiiIryoKikanJohoEntityGenerator() {
    }

    public static DbT7011ShujiiIryoKikanJohoEntity createDbT7011ShujiiIryoKikanJohoEntity() {
        DbT7011ShujiiIryoKikanJohoEntity entity = new DbT7011ShujiiIryoKikanJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setKaigoIryokikanCode(DEFAULT_介護医療機関コード);
        entity.setIryokikanCode(DEFAULT_医療機関コード);
        entity.setIryokikanJokyo(DEFAULT_医療機関の状況);
        entity.setKikanKubunCode(DEFAULT_機関の区分コード);
        return entity;
    }
}
