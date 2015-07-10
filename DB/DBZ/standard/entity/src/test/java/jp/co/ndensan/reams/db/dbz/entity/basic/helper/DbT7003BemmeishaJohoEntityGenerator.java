/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明者情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7003BemmeishaJohoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("02"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final HihokenshaNo DEFAULT_原処分被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_審査請求届出日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_弁明書作成日 = new FlexibleDate("20140402");
    public static final int DEFAULT_弁明者枝番 = 1;
    public static final Code DEFAULT_職員コード = new Code("3");
    public static final BushoCode DEFAULT_部署コード = new BushoCode(new RString("02"));
    public static final RString DEFAULT_役職名 = new RString("123");
    public static final AtenaMeisho DEFAULT_弁明者氏名 = new AtenaMeisho("電算太郎");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7003BemmeishaJohoEntityGenerator() {
    }

    public static DbT7003BemmeishaJohoEntity createDbT7003BemmeishaJohoEntity() {
        DbT7003BemmeishaJohoEntity entity = new DbT7003BemmeishaJohoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setGenshobunHihokenshaNo(DEFAULT_原処分被保険者番号);
        entity.setShinsaseikyuTodokedeYMD(DEFAULT_審査請求届出日);
        entity.setBemmeishoSakuseiYMD(DEFAULT_弁明書作成日);
        entity.setBemmeishaEdaban(DEFAULT_弁明者枝番);
        entity.setShokuinCode(DEFAULT_職員コード);
        entity.setBushoCode(DEFAULT_部署コード);
        entity.setYakushoskuName(DEFAULT_役職名);
        entity.setBemmeishaShimei(DEFAULT_弁明者氏名);
        return entity;
    }
}
