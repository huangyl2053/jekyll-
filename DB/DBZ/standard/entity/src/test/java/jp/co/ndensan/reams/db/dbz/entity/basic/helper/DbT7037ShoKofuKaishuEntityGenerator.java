/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証交付回収エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7037ShoKofuKaishuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000000001");
    public static final RString DEFAULT_交付証種類 = new RString("1");
    public static final int DEFAULT_履歴番号 = 1;
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleDate DEFAULT_交付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_有効期限 = new FlexibleDate("19900101");
    public static final RString DEFAULT_交付事由 = new RString("1");
    public static final RString DEFAULT_交付理由 = new RString("1");
    public static final FlexibleDate DEFAULT_回収年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_回収事由 = new RString("1");
    public static final RString DEFAULT_回収理由 = new RString("1");
    public static final boolean DEFAULT_単票発行有無フラグ = false;
    public static final YMDHMS DEFAULT_発行処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_新様式印書済区分コード = new RString("1");
    public static final RString DEFAULT_証様式区分コード = new RString("1");
    public static final boolean DEFAULT_論理削除フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7037ShoKofuKaishuEntityGenerator() {
    }

    public static DbT7037ShoKofuKaishuEntity createDbT7037ShoKofuKaishuEntity() {
        DbT7037ShoKofuKaishuEntity entity = new DbT7037ShoKofuKaishuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKofuShoShurui(DEFAULT_交付証種類);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setKofuYMD(DEFAULT_交付年月日);
        entity.setYukoKigenYMD(DEFAULT_有効期限);
        entity.setKofuJiyu(DEFAULT_交付事由);
        entity.setKofuRiyu(DEFAULT_交付理由);
        entity.setKaishuYMD(DEFAULT_回収年月日);
        entity.setKaishuJiyu(DEFAULT_回収事由);
        entity.setKaishuRiyu(DEFAULT_回収理由);
        entity.setTanpyoHakkoUmuFlag(DEFAULT_単票発行有無フラグ);
        entity.setHakkoShoriTimestamp(DEFAULT_発行処理日時);
        entity.setShinYoshikiSumiKubunCode(DEFAULT_新様式印書済区分コード);
        entity.setShoYoshikiKubunCode(DEFAULT_証様式区分コード);
        entity.setLogicalDeletedFlag(DEFAULT_論理削除フラグ);
        return entity;
    }
}
