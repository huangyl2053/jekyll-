/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号者台帳エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8211 田辺 紘一
 */
public final class DbT1012Minashi2GoshaDaichoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode(new RString("123456"));
    public static final KaigoHihokenshaNo DEFAULT_被保険者番号 = new KaigoHihokenshaNo(new RString("0000000001"));
    public static final YMDHMS DEFAULT_更新日時 = new YMDHMS("20081106010101");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("00000000000001");
    public static final Code DEFAULT_被保険者区分コード = new Code("1");
    public static final FlexibleDate DEFAULT_登録年月日 = new FlexibleDate("20140401");
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20140501");
    public static final RString DEFAULT_福祉被保険者番号 = new RString("0000000001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1012Minashi2GoshaDaichoEntityGenerator() {
    }

    public static DbT1012Minashi2GoshaDaichoEntity createDbT1012Minashi2GoshaDaichoEntity() {
        DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_更新日時);
        entity.setHihokenshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setMinashi2GoshaTorokuYMD(DEFAULT_登録年月日);
        entity.setMinashi2GoshaKaijoYMD(DEFAULT_解除年月日);
        entity.setFukushiHihokenshaNo(DEFAULT_福祉被保険者番号);
        return entity;
    }
}
