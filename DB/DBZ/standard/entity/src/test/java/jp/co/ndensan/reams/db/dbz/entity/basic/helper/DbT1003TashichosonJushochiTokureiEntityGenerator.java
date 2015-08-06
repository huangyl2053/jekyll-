/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8178 城間篤人
 */
public final class DbT1003TashichosonJushochiTokureiEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("000220");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000010000100001");
    public static final FlexibleDate DEFAULT_異動日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_枝番 = new RString("1");
    public static final RString DEFAULT_異動事由コード = new RString("1");
    public static final KaigoTatokuTekiyoJiyu DEFAULT_他市町村住所地特例適用事由コード = new KaigoTatokuTekiyoJiyu(new Code("21"));
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("20180712");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("20180712");
    public static final FlexibleDate DEFAULT_適用受付年月日 = new FlexibleDate("20180712");
    public static final KaigoTatokuKaijoJiyu DEFAULT_他市町村住所地特例解除事由コード = new KaigoTatokuKaijoJiyu(new Code("71"));
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20190130");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("20190130");
    public static final FlexibleDate DEFAULT_解除受付年月日 = new FlexibleDate("20190130");
    public static final ShoKisaiHokenshaNo DEFAULT_措置保険者番号 = new ShoKisaiHokenshaNo("000010");
    public static final HihokenshaNo DEFAULT_措置被保険者番号 = new HihokenshaNo("0000200001");
    public static final FlexibleDate DEFAULT_他特例連絡票発行年月日 = new FlexibleDate("20180713");
    public static final FlexibleDate DEFAULT_施設退所通知発行年月日 = new FlexibleDate("20190202");
    public static final FlexibleDate DEFAULT_施設変更通知発行年月日 = new FlexibleDate("20181201");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1003TashichosonJushochiTokureiEntityGenerator() {
    }

    public static DbT1003TashichosonJushochiTokureiEntity createDbT1003TashichosonJushochiTokureiEntity() {
        DbT1003TashichosonJushochiTokureiEntity entity = new DbT1003TashichosonJushochiTokureiEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setIdoYMD(DEFAULT_異動日);
        entity.setEdaNo(DEFAULT_枝番);
        entity.setIdoJiyuCode(DEFAULT_異動事由コード);
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
        return entity;
    }
}
