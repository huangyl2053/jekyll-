/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算支給額計算結果明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("1990");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final RString DEFAULT_支給申請書整理番号 = new RString("Data");
    public static final RString DEFAULT_明細番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_保険制度コード = new RString("Data");
    public static final RString DEFAULT_内訳保険者番号 = new RString("Data");
    public static final RString DEFAULT_国保被保険者証記号 = new RString("Data");
    public static final RString DEFAULT_被保険者_証_番号 = new RString("Data");
    public static final RString DEFAULT_内訳保険者名 = new RString("Data");
    public static final RString DEFAULT_自己負担額証明書整理番号 = new RString("Data");
    public static final RString DEFAULT_対象者氏名_漢字 = new RString("Data");
    public static final RString DEFAULT_70歳以上負担額 = new RString("Data");
    public static final RString DEFAULT_70歳以上按分率 = new RString("Data");
    public static final RString DEFAULT_70歳以上支給額 = new RString("Data");
    public static final RString DEFAULT_70歳未満負担額 = new RString("Data");
    public static final RString DEFAULT_負担額 = new RString("Data");
    public static final RString DEFAULT_按分率 = new RString("Data");
    public static final RString DEFAULT_70歳未満支給額 = new RString("Data");
    public static final RString DEFAULT_支給額 = new RString("Data");
    public static final RString DEFAULT_備考欄記載70歳以上負担額 = new RString("Data");
    public static final RString DEFAULT_備考欄記載70歳未満負担額 = new RString("Data");
    public static final RString DEFAULT_データ区分 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_受取年月 = new FlexibleYearMonth("199001");
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntityGenerator() {
    }

    public static DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity createDbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity() {
        DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = new DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikyuShinseishoSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setMeisanNo(DEFAULT_明細番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHokenSeidoCode(DEFAULT_保険制度コード);
        entity.setUchiwakeHokenshaNo(DEFAULT_内訳保険者番号);
        entity.setKokuho_HihokenshaShoKigo(DEFAULT_国保被保険者証記号);
        entity.setHiHokenshaShoNo(DEFAULT_被保険者_証_番号);
        entity.setUchiwakeHokenshaMei(DEFAULT_内訳保険者名);
        entity.setJikoFutanSeiriNo(DEFAULT_自己負担額証明書整理番号);
        entity.setTaishoshaShimei(DEFAULT_対象者氏名_漢字);
        entity.setOver70_Futangaku(DEFAULT_70歳以上負担額);
        entity.setOver70_AmbunRitsu(DEFAULT_70歳以上按分率);
        entity.setOver70_Shikyugaku(DEFAULT_70歳以上支給額);
        entity.setUnder70_Futangaku(DEFAULT_70歳未満負担額);
        entity.setFutangaku(DEFAULT_負担額);
        entity.setAmbunRitsu(DEFAULT_按分率);
        entity.setUnder70_Shikyugaku(DEFAULT_70歳未満支給額);
        entity.setShikyugaku(DEFAULT_支給額);
        entity.setOver70_Biko(DEFAULT_備考欄記載70歳以上負担額);
        entity.setUnder70_Biko(DEFAULT_備考欄記載70歳未満負担額);
        entity.setDataKubun(DEFAULT_データ区分);
        entity.setUketoriYM(DEFAULT_受取年月);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
