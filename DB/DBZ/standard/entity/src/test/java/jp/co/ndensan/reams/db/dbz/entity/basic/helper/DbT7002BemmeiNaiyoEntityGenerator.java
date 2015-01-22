/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 弁明内容エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7002BemmeiNaiyoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("02"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final HihokenshaNo DEFAULT_原処分被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_審査請求届出日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_弁明書作成日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_審査請求に係る処分内容 = new RString("123");
    public static final RString DEFAULT_弁明内容 = new RString("123");
    public static final FlexibleDate DEFAULT_弁明書作成日提出日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7002BemmeiNaiyoEntityGenerator() {
    }

    public static DbT7002BemmeiNaiyoEntity createDbT7002BemmeiNaiyoEntity() {
        DbT7002BemmeiNaiyoEntity entity = new DbT7002BemmeiNaiyoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setGenshobunHihokenshaNo(DEFAULT_原処分被保険者番号);
        entity.setShinsaseikyuTodokedeYMD(DEFAULT_審査請求届出日);
        entity.setBemmeishoSakuseiYMD(DEFAULT_弁明書作成日);
        entity.setShinsaseikyuKankeiShobunNaiyo(DEFAULT_審査請求に係る処分内容);
        entity.setBemmeiNaiyo(DEFAULT_弁明内容);
        entity.setBemmeishoSakuseiTeishutsuYMD(DEFAULT_弁明書作成日提出日);
        return entity;
    }
}
