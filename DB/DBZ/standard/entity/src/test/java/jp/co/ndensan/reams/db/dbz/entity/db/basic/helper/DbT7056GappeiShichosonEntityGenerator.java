/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7056GappeiShichosonEntityGenerator {

    public static final FlexibleDate DEFAULT_合併年月日 = new FlexibleDate("20141216");
    public static final RString DEFAULT_地域番号 = new RString("01");
    public static final LasdecCode DEFAULT_旧市町村コード = new LasdecCode("123456");
    public static final FlexibleDate DEFAULT_運用開始年月日 = new FlexibleDate("20141216");
    public static final FlexibleDate DEFAULT_運用終了年月日 = new FlexibleDate("20141216");
    public static final HokenshaNo DEFAULT_旧保険者番号 = new HokenshaNo("209007");
    public static final RString DEFAULT_旧市町村名称 = new RString("あいうえおか");
    public static final RString DEFAULT_都道府県名称 = new RString("1234");
    public static final RString DEFAULT_郡名称 = new RString("あいうえ");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("111-1111");
    public static final TelNo DEFAULT_電話番号 = new TelNo("111-222-3344");
    public static final RString DEFAULT_老人保健市町村番号 = new RString("あいうえ");
    public static final RString DEFAULT_老人保健受給者番号体系 = new RString("1");
    public static final RString DEFAULT_表示有無 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7056GappeiShichosonEntityGenerator() {
    }

    public static DbT7056GappeiShichosonEntity createDbT7056GappeiShichosonEntity() {
        DbT7056GappeiShichosonEntity entity = new DbT7056GappeiShichosonEntity();
        entity.setGappeiYMD(DEFAULT_合併年月日);
        entity.setChiikiNo(DEFAULT_地域番号);
        entity.setKyuShichosonCode(DEFAULT_旧市町村コード);
        entity.setUnyoKaishiYMD(DEFAULT_運用開始年月日);
        entity.setUnyoShuryoYMD(DEFAULT_運用終了年月日);
        entity.setKyuHokenshaNo(DEFAULT_旧保険者番号);
        entity.setKyuShichosonMeisho(DEFAULT_旧市町村名称);
        entity.setTodofukenMeisho(DEFAULT_都道府県名称);
        entity.setGunMeisho(DEFAULT_郡名称);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setRojinhokenShichosonNo(DEFAULT_老人保健市町村番号);
        entity.setRokenJukyushaNoTaikei(DEFAULT_老人保健受給者番号体系);
        entity.setHyojiUmu(DEFAULT_表示有無);
        return entity;
    }
}
