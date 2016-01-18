/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者台帳管理Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV1003TashichosonJushochiTokureiEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final FlexibleDate DEFAULT_異動日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_枝番 = new RString("Data");
    public static final RString DEFAULT_異動事由コード = new RString("Data");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_他市町村住所地特例適用事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_適用受付年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_他市町村住所地特例解除事由コード = new RString("Data");
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_解除受付年月日 = new FlexibleDate("19900101");
    public static final ShoKisaiHokenshaNo DEFAULT_措置保険者番号 = new ShoKisaiHokenshaNo("209007");
    public static final HihokenshaNo DEFAULT_措置被保険者番号 = new HihokenshaNo("0123400001");
    public static final FlexibleDate DEFAULT_他特例連絡票発行年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_施設退所通知発行年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_施設変更通知発行年月日 = new FlexibleDate("19900101");
    public static final boolean DEFAULT_論理削除フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV1003TashichosonJushochiTokureiEntityGenerator() {
    }

    public static DbV1003TashichosonJushochiTokureiEntity createDbV1003TashichosonJushochiTokureiEntity() {
        DbV1003TashichosonJushochiTokureiEntity entity = new DbV1003TashichosonJushochiTokureiEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setIdoYMD(DEFAULT_異動日);
        entity.setEdaNo(DEFAULT_枝番);
        entity.setIdoJiyuCode(DEFAULT_異動事由コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setTekiyoJiyuCode(DEFAULT_他市町村住所地特例適用事由コード);
        entity.setTekiyoYMD(DEFAULT_適用年月日);
        entity.setTekiyoTodokedeYMD(DEFAULT_適用届出年月日);
        entity.setTekiyoUketsukeYMD(DEFAULT_適用受付年月日);
        entity.setKaijoJiyuCode(DEFAULT_他市町村住所地特例解除事由コード);
        entity.setKaijoYMD(DEFAULT_解除年月日);
        entity.setKaijoTodokedeYMD(DEFAULT_解除届出年月日);
        entity.setKaijoUketsukeYMD(DEFAULT_解除受付年月日);
        entity.setSochiHokenshaNo(DEFAULT_措置保険者番号);
        entity.setSochiHihokenshaNo(DEFAULT_措置被保険者番号);
        entity.setTatokuRenrakuhyoHakkoYMD(DEFAULT_他特例連絡票発行年月日);
        entity.setShisetsuTaishoTsuchiHakkoYMD(DEFAULT_施設退所通知発行年月日);
        entity.setShisetsuHenkoTsuchiHakkoYMD(DEFAULT_施設変更通知発行年月日);
        entity.setLogicalDeletedFlag(DEFAULT_論理削除フラグ);
        return entity;
    }
}
