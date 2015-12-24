/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給住宅改修事前申請エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_申請理由 = new RString("Data");
    public static final RString DEFAULT_申請者区分 = new RString("Data");
    public static final RString DEFAULT_申請者氏名 = new RString("Data");
    public static final RString DEFAULT_申請者氏名カナ = new RString("Data");
    public static final YubinNo DEFAULT_申請者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_申請者住所 = new RString("Data");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("Data");
    public static final JigyoshaNo DEFAULT_申請事業者番号 = new JigyoshaNo("1");
    public static final FlexibleDate DEFAULT_理由書作成日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_理由書作成者 = new RString("Data");
    public static final RString DEFAULT_理由書作成者カナ = new RString("Data");
    public static final JigyoshaNo DEFAULT_理由書作成事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_支払方法区分コード = new RString("Data");
    public static final RString DEFAULT_支払場所 = new RString("Data");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_支払窓口開始時間 = new RString("Data");
    public static final RString DEFAULT_支払窓口終了時間 = new RString("Data");
    public static final long DEFAULT_口座ID = 1L;
    public static final RString DEFAULT_受領委任契約番号 = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final RString DEFAULT_住宅所有者 = new RString("Data");
    public static final RString DEFAULT_被保険者との関係 = new RString("Data");
    public static final boolean DEFAULT_要介護状態３段階変更 = false;
    public static final boolean DEFAULT_住宅住所変更 = false;
    public static final FlexibleDate DEFAULT_判定決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_判定区分 = new RString("Data");
    public static final RString DEFAULT_承認条件 = new RString("Data");
    public static final RString DEFAULT_不承認理由 = new RString("Data");
    public static final int DEFAULT_給付額等_費用額合計 = 1;
    public static final int DEFAULT_給付額等_保険対象費用額 = 1;
    public static final int DEFAULT_給付額等_利用者自己負担額 = 1;
    public static final int DEFAULT_給付額等_保険給付費額 = 1;
    public static final FlexibleDate DEFAULT_事前申請決定通知発行日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_住宅改修申請区分 = new RString("Data");
    public static final RString DEFAULT_住宅改修申請取消事由コード = new RString("Data");
    public static final HokenKyufuRitsu DEFAULT_保険給付率 = new HokenKyufuRitsu(Decimal.ZERO);
    public static final FlexibleDate DEFAULT_施工完了予定年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3035ShokanJutakuKaishuJizenShinseiEntityGenerator() {
    }

    public static DbT3035ShokanJutakuKaishuJizenShinseiEntity createDbT3035ShokanJutakuKaishuJizenShinseiEntity() {
        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShinseiRiyu(DEFAULT_申請理由);
        entity.setShinseishaKubun(DEFAULT_申請者区分);
        entity.setShinseishaNameKanji(DEFAULT_申請者氏名);
        entity.setShinseishaNameKana(DEFAULT_申請者氏名カナ);
        entity.setShinseishaYubinNo(DEFAULT_申請者郵便番号);
        entity.setShinseishaJusho(DEFAULT_申請者住所);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseiJigyoshaNo(DEFAULT_申請事業者番号);
        entity.setRiyushoSakuseiYMD(DEFAULT_理由書作成日);
        entity.setRiyushoSakuseishaName(DEFAULT_理由書作成者);
        entity.setRiyushoSakuseishaKanaName(DEFAULT_理由書作成者カナ);
        entity.setRiyushoSakuseiJigyoshaNo(DEFAULT_理由書作成事業者番号);
        entity.setShiharaiHohoKubunCode(DEFAULT_支払方法区分コード);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setShiharaiKaishiTime(DEFAULT_支払窓口開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払窓口終了時間);
        entity.setKozaID(DEFAULT_口座ID);
        entity.setJuryoininKeiyakuNo(DEFAULT_受領委任契約番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setJutakuShoyusha(DEFAULT_住宅所有者);
        entity.setHihokenshaKankei(DEFAULT_被保険者との関係);
        entity.setYokaigo3DankaiHenko(DEFAULT_要介護状態３段階変更);
        entity.setJutakuJushoHenko(DEFAULT_住宅住所変更);
        entity.setHanteiKetteiYMD(DEFAULT_判定決定年月日);
        entity.setHanteiKubun(DEFAULT_判定区分);
        entity.setShoninJoken(DEFAULT_承認条件);
        entity.setFushoninRiyu(DEFAULT_不承認理由);
        entity.setKyufugakuHiyogakuTotal(DEFAULT_給付額等_費用額合計);
        entity.setKyufugakuHokenTaishoHiyogaku(DEFAULT_給付額等_保険対象費用額);
        entity.setKyufugakuRiyoshaJikofutangaku(DEFAULT_給付額等_利用者自己負担額);
        entity.setKyufugakuHokenkyufuhigaku(DEFAULT_給付額等_保険給付費額);
        entity.setKetteitsuchishoHakkoYMD(DEFAULT_事前申請決定通知発行日);
        entity.setKaishushinseiKubun(DEFAULT_住宅改修申請区分);
        entity.setKaishuShinseiTorikeshijiyuCode(DEFAULT_住宅改修申請取消事由コード);
        entity.setHokenKyufuritsu(DEFAULT_保険給付率);
        entity.setSekoKanryoYoteiYMD(DEFAULT_施工完了予定年月日);
        return entity;
    }
}
