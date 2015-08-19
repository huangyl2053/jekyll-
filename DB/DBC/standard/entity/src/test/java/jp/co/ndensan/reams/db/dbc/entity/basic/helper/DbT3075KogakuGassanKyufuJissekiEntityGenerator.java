/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算給付実績エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3075KogakuGassanKyufuJissekiEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo("012340123400001");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_支給申請書整理番号 = new RString("Data");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_自己負担額証明書整理番号 = new RString("Data");
    public static final RString DEFAULT_保険制度コード = new RString("Data");
    public static final RString DEFAULT_給付実績作成区分コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final RString DEFAULT_国保_被保険者証記号 = new RString("Data");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_自己負担総額 = new Decimal(0);
    public static final Decimal DEFAULT_支給額 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_処理年月 = new FlexibleYearMonth("199001");
    public static final FlexibleYearMonth DEFAULT_受取年月 = new FlexibleYearMonth("199001");
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_データ区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3075KogakuGassanKyufuJissekiEntityGenerator() {
    }

    public static DbT3075KogakuGassanKyufuJissekiEntity createDbT3075KogakuGassanKyufuJissekiEntity() {
        DbT3075KogakuGassanKyufuJissekiEntity entity = new DbT3075KogakuGassanKyufuJissekiEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikyuShinseiSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setJikoFutanSeiriNo(DEFAULT_自己負担額証明書整理番号);
        entity.setHokenSeidoCode(DEFAULT_保険制度コード);
        entity.setKyufuJissekiSakuseiKubunCode(DEFAULT_給付実績作成区分コード);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setKokuho_HihokenshaShoKigo(DEFAULT_国保_被保険者証記号);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setJikoFutanSogaku(DEFAULT_自己負担総額);
        entity.setShikyuGaku(DEFAULT_支給額);
        entity.setShoriYM(DEFAULT_処理年月);
        entity.setUketoriYM(DEFAULT_受取年月);
        entity.setSofuYM(DEFAULT_送付年月);
        entity.setDataKubun(DEFAULT_データ区分);
        return entity;
    }
}
