/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1003TashichosonJushochiTokureiEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_他市町村住所地特例適用事由コード = new RString("1");
    public static final FlexibleDate DEFAULT_適用年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用届出年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_適用受付年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_他市町村住所地特例解除事由コード = new RString("1");
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_解除届出年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_解除受付年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_措置保険者番号 = new RString("1");
    public static final RString DEFAULT_措置被保険者番号 = new RString("1");
    public static final FlexibleDate DEFAULT_他特例連絡票発行年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_施設退所通知発行年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_施設変更通知発行年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1003TashichosonJushochiTokureiEntityGenerator() {
    }

    public static DbT1003TashichosonJushochiTokureiEntity createDbT1003TashichosonJushochiTokureiEntity() {
        DbT1003TashichosonJushochiTokureiEntity entity = new DbT1003TashichosonJushochiTokureiEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShoriTimeStamp(DEFAULT_処理日時);
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
