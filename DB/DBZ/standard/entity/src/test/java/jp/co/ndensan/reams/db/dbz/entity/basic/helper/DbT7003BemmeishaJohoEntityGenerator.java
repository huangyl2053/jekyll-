/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 弁明者情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7003BemmeishaJohoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("010101");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_原処分被保険者番号 = new HihokenshaNo("010101");
    public static final FlexibleDate DEFAULT_審査請求届出日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_弁明書作成日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_弁明者枝番 = new Decimal(0);
    public static final Code DEFAULT_職員コード = new Code();
    public static final BushoCode DEFAULT_部署コード = new BushoCode("0001");
    public static final RString DEFAULT_役職名 = new RString("Data");
    public static final AtenaMeisho DEFAULT_弁明者氏名 = new AtenaMeisho("");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7003BemmeishaJohoEntityGenerator() {
    }

    public static DbT7003BemmeishaJohoEntity createDbT7003BemmeishaJohoEntity() {
        DbT7003BemmeishaJohoEntity entity = new DbT7003BemmeishaJohoEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setGenshobunHihokenshaNo(DEFAULT_原処分被保険者番号);
        entity.setShinsaseikyuTodokedeYMD(DEFAULT_審査請求届出日);
        entity.setBemmeishoSakuseiYMD(DEFAULT_弁明書作成日);
        entity.setBemmeishaEdaban(DEFAULT_弁明者枝番.intValue());
        return entity;
    }
}
