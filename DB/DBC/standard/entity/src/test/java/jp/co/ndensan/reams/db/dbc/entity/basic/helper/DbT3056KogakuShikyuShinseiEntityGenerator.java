/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費支給申請エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3056KogakuShikyuShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_申請理由 = new RString("Data");
    public static final RString DEFAULT_申請者区分 = new RString("Data");
    public static final AtenaMeisho DEFAULT_申請者氏名 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_申請者氏名カナ = new AtenaKanaMeisho("");
    public static final RString DEFAULT_申請者住所 = new RString("Data");
    public static final TelNo DEFAULT_申請者電話番号 = new TelNo("08011112222");
    public static final JigyoshaNo DEFAULT_申請事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_支払方法区分コード = new RString("Data");
    public static final RString DEFAULT_支払場所 = new RString("Data");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_閉庁内容 = new RString("Data");
    public static final RString DEFAULT_支払窓口開始時間 = new RString("Data");
    public static final RString DEFAULT_支払窓口終了時間 = new RString("Data");
    public static final long DEFAULT_口座ID = 1L;
    public static final RString DEFAULT_受領委任契約番号 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3056KogakuShikyuShinseiEntityGenerator() {
    }

    public static DbT3056KogakuShikyuShinseiEntity createDbT3056KogakuShikyuShinseiEntity() {
        DbT3056KogakuShikyuShinseiEntity entity = new DbT3056KogakuShikyuShinseiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShinseiRiyu(DEFAULT_申請理由);
        entity.setShinseishaKubun(DEFAULT_申請者区分);
        entity.setShinseishaShimei(DEFAULT_申請者氏名);
        entity.setShinseishaShimeiKana(DEFAULT_申請者氏名カナ);
        entity.setShinseishaJusho(DEFAULT_申請者住所);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseiJigyoshaNo(DEFAULT_申請事業者番号);
        entity.setShiharaiHohoKubunCode(DEFAULT_支払方法区分コード);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setHeichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiKaishiTime(DEFAULT_支払窓口開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払窓口終了時間);
        entity.setKozaID(DEFAULT_口座ID);
        entity.setJuryoininKeiyakuNo(DEFAULT_受領委任契約番号);
        return entity;
    }
}
