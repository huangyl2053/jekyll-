/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給申請エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3034ShokanShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final int DEFAULT_履歴番号 = 0;
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_申請理由 = new RString("Data");
    public static final RString DEFAULT_申請者区分 = new RString("Data");
    public static final RString DEFAULT_申請者氏名 = new RString("Data");
    public static final RString DEFAULT_申請者氏名カナ = new RString("Data");
    public static final RString DEFAULT_申請者住所 = new RString("Data");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("Data");
    public static final JigyoshaNo DEFAULT_申請事業者コード = new JigyoshaNo("Data");
    public static final Decimal DEFAULT_支払金額合計 = new Decimal(0);
    public static final int DEFAULT_保険給付額 = 1;
    public static final int DEFAULT_利用者負担額 = 1;
    public static final RString DEFAULT_支給申請審査区分 = new RString("Data");
    public static final RString DEFAULT_審査方法区分 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_支払方法区分コード = new RString("Data");
    public static final RString DEFAULT_支払場所 = new RString("Data");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("19900101");
//    public static final RString DEFAULT_閉庁内容 = new RString("Data");
    public static final RString DEFAULT_支払窓口開始時間 = new RString("Data");
    public static final RString DEFAULT_支払窓口終了時間 = new RString("Data");
    public static final long DEFAULT_口座ID = 1L;
    public static final RString DEFAULT_受領委任契約番号 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3034ShokanShinseiEntityGenerator() {
    }

    public static DbT3034ShokanShinseiEntity createDbT3034ShokanShinseiEntity() {
        DbT3034ShokanShinseiEntity entity = new DbT3034ShokanShinseiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
//        entity.set(DEFAULT_履歴番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShinseiRiyu(DEFAULT_申請理由);
        entity.setShinseishaKubun(DEFAULT_申請者区分);
        entity.setShinseishaNameKanji(DEFAULT_申請者氏名);
        entity.setShinseishaNameKana(DEFAULT_申請者氏名カナ);
        entity.setShinseishaAddress(DEFAULT_申請者住所);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseiJigyoshaNo(DEFAULT_申請事業者コード);
        entity.setShiharaiKingakuTotal(DEFAULT_支払金額合計);
        entity.setHokenKyufugaku(DEFAULT_保険給付額);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setShikyuShinseiShinsaKubun(DEFAULT_支給申請審査区分);
        entity.setShinsaHohoKubun(DEFAULT_審査方法区分);
        entity.setSofuYM(DEFAULT_送付年月);
        entity.setShiharaiHohoKubunCode(DEFAULT_支払方法区分コード);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
//        entity.setHeichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiKaishiTime(DEFAULT_支払窓口開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払窓口終了時間);
        entity.setKozaID(DEFAULT_口座ID);
        entity.setJuryoininKeiyakuNo(DEFAULT_受領委任契約番号);
        return entity;
    }
}
