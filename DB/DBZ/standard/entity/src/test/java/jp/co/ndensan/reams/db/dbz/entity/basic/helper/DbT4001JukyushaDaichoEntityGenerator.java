/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者台帳エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8187 久保田 英男
 */
public final class DbT4001JukyushaDaichoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("123456");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("012345");
    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20140101102030");
    public static final ShishoCode DEFAULT_支所コード = new ShishoCode("001");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("123456");
    public static final ChikuCode DEFAULT_地区コード = new ChikuCode("20");
    public static final FlexibleDate DEFAULT_喪失年月日 = new FlexibleDate("20150102");
    public static final Code DEFAULT_2号特定疾病コード = new Code("1");
    public static final FlexibleDate DEFAULT_直近異動年月日 = new FlexibleDate("20140102");
    public static final Code DEFAULT_直近異動事由コード = new Code("1");
    public static final Decimal DEFAULT_支給限度単位数 = Decimal.TEN;
    public static final FlexibleDate DEFAULT_支給限度有効開始年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_支給限度有効終了年月日 = new FlexibleDate("20140102");
    public static final int DEFAULT_短期入所支給限度日数 = 1;
    public static final FlexibleDate DEFAULT_短期入所支給限度開始年月日 = new FlexibleDate("20140102");
    public static final FlexibleDate DEFAULT_短期入所支給限度終了年月日 = new FlexibleDate("20140102");
    public static final RString DEFAULT_自動割当除外者区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4001JukyushaDaichoEntityGenerator() {
    }

    public static DbT4001JukyushaDaichoEntity createDbT4001JukyushaDaichoEntity() {
        DbT4001JukyushaDaichoEntity entity = new DbT4001JukyushaDaichoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShoriTimeStamp(DEFAULT_処理日時);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setChikuCode(DEFAULT_地区コード);
        entity.setSoshitsuYMD(DEFAULT_喪失年月日);
        entity.setNigouTokuteiShippeiCode(DEFAULT_2号特定疾病コード);
        entity.setChokkinIdoYMD(DEFAULT_直近異動年月日);
        entity.setChokkinIdoJiyuCode(DEFAULT_直近異動事由コード);
        entity.setShikyuGendoTanisu(DEFAULT_支給限度単位数);
        entity.setShikyuGendoKaishiYMD(DEFAULT_支給限度有効開始年月日);
        entity.setShikyuGendoShuryoYMD(DEFAULT_支給限度有効終了年月日);
        entity.setTankiSikyuGendoNissu(DEFAULT_短期入所支給限度日数);
        entity.setTankiShikyuGendoKaishiYMD(DEFAULT_短期入所支給限度開始年月日);
        entity.setTankiShikyuGendoShuryoYMD(DEFAULT_短期入所支給限度終了年月日);
        entity.setJidoWariateJogaishaKubun(DEFAULT_自動割当除外者区分);
        return entity;
    }
}
