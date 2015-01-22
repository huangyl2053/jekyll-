/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8187 久保田 英男
 */
public final class DbT7056GappeiShichosonEntityGenerator {

    public static final FlexibleDate DEFAULT_合併年月日 = new FlexibleDate("20140101");
    public static final RString DEFAULT_地域番号 = new RString("01");
    public static final LasdecCode DEFAULT_旧市町村コード = new LasdecCode("000001");
    public static final FlexibleDate DEFAULT_運用開始年月日 = new FlexibleDate("20140101");
    public static final FlexibleDate DEFAULT_運用終了年月日 = new FlexibleDate("20150101");
    public static final ShoKisaiHokenshaNo DEFAULT_旧保険者番号 = new ShoKisaiHokenshaNo("123456");
    public static final RString DEFAULT_旧市町村名称 = new RString("旧市町村名称");
    public static final RString DEFAULT_都道府県名称 = new RString("都道府県");
    public static final RString DEFAULT_郡名称 = new RString("郡名称");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final TelNo DEFAULT_電話番号 = new TelNo("12345678900");
    public static final RString DEFAULT_老人保健市町村番号 = new RString("02");
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
