/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.Daicho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.Shisetsu;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入退所エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n3317 塚田萌
 */
public final class DbV1004HihokenshaShisetsuNyutaishoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("0000000001");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20140901083000");
    public static final RString DEFAULT_台帳種別 = new RString("1");
    public static final RString DEFAULT_入所施設種類 = new RString("11");
    public static final KaigoJigyoshaNo DEFAULT_入所施設コード = new KaigoJigyoshaNo("1234567890");
    public static final FlexibleDate DEFAULT_入所日 = new FlexibleDate("20101010");
    public static final FlexibleDate DEFAULT_退所日 = new FlexibleDate("20111010");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV1004HihokenshaShisetsuNyutaishoEntityGenerator() {
    }

    public static DbV1004HihokenshaShisetsuNyutaishoEntity createDbV1004HihokenshaShisetsuNyutaishoEntity() {
        DbV1004HihokenshaShisetsuNyutaishoEntity entity = new DbV1004HihokenshaShisetsuNyutaishoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
//        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setDaichoShubetsu(DEFAULT_台帳種別);
        entity.setNyushoShisetsuShurui(DEFAULT_入所施設種類);
        entity.setNyushoShisetsuCode(DEFAULT_入所施設コード);
        entity.setNyushoYMD(DEFAULT_入所日);
        entity.setTaishoYMD(DEFAULT_退所日);
        return entity;
    }
}
