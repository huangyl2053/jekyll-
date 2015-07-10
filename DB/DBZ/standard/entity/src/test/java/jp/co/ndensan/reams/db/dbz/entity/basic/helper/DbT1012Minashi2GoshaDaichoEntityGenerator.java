/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号者台帳エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1012Minashi2GoshaDaichoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final RString DEFAULT_被保険者区分コード = new RString("1");
    public static final FlexibleDate DEFAULT_登録年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_解除年月日 = new FlexibleDate("20140402");
    public static final HihokenshaNo DEFAULT_福祉被保険者番号 = new HihokenshaNo(new RString("2"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1012Minashi2GoshaDaichoEntityGenerator() {
    }

    public static DbT1012Minashi2GoshaDaichoEntity createDbT1012Minashi2GoshaDaichoEntity() {
        DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaKubunCode(DEFAULT_被保険者区分コード);
        entity.setMinashi2GoshaTorokuYMD(DEFAULT_登録年月日);
        entity.setMinashi2GoshaKaijoYMD(DEFAULT_解除年月日);
        entity.setFukushiHihokenshaNo(DEFAULT_福祉被保険者番号);
        return entity;
    }
}
