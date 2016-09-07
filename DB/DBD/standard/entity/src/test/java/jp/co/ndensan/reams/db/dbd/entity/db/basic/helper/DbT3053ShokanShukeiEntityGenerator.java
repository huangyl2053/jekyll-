/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求集計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3053ShokanShukeiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_様式番号 = new RString("Data");
//    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final RString DEFAULT_明細番号 = new RString("Data");
    public static final RString DEFAULT_連番 = new RString("0");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("1");
    public static final int DEFAULT_サービス実日数 = 0;
    public static final int DEFAULT_計画単位数 = 1;
    public static final int DEFAULT_限度額管理対象単位数 = 1;
    public static final int DEFAULT_限度額管理対象外単位数 = 1;
    public static final int DEFAULT_短期入所計画日数 = 0;
    public static final int DEFAULT_短期入所実日数 = 0;
    public static final int DEFAULT_単位数合計 = 1;
    public static final Decimal DEFAULT_単位数単価 = new Decimal(0);
    public static final Decimal DEFAULT_請求額 = new Decimal(0);
    public static final int DEFAULT_利用者負担額 = 1;
    public static final int DEFAULT_出来高医療費単位数合計 = 1;
    public static final Decimal DEFAULT_出来高医療費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_出来高医療費利用者負担額 = new Decimal(0);
    public static final RString DEFAULT_審査方法区分コード = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final int DEFAULT_点数_金額 = 1;
    public static final int DEFAULT_支払金額 = 1;
    public static final int DEFAULT_増減点 = 1;
    public static final int DEFAULT_請求額差額金額 = 1;
    public static final int DEFAULT_出来高請求額差額金額 = 1;
    public static final RString DEFAULT_増減理由等 = new RString("Data");
    public static final RString DEFAULT_不支給理由等 = new RString("Data");
    public static final RString DEFAULT_購入_改修履歴等 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3053ShokanShukeiEntityGenerator() {
    }

    public static DbT3053ShokanShukeiEntity createDbT3053ShokanShukeiEntity() {
        DbT3053ShokanShukeiEntity entity = new DbT3053ShokanShukeiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setMeisaiNo(DEFAULT_明細番号);
        entity.setRenban(DEFAULT_連番);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceJitsunissu(DEFAULT_サービス実日数);
        entity.setPlanTanisu(DEFAULT_計画単位数);
        entity.setGendogakuKanriTaishoTanisu(DEFAULT_限度額管理対象単位数);
        entity.setGendogakuKanriTaishogaiTanisu(DEFAULT_限度額管理対象外単位数);
        entity.setTankiNyushoPlanNissu(DEFAULT_短期入所計画日数);
        entity.setTankiNyushoJitsunissu(DEFAULT_短期入所実日数);
        entity.setTanisuTotal(DEFAULT_単位数合計);
        entity.setTanisuTanka(DEFAULT_単位数単価);
        entity.setSeikyugaku(DEFAULT_請求額);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setDekidakaIryohiTanisuTotal(DEFAULT_出来高医療費単位数合計);
        entity.setDekidakaIryohiSeikyugaku(DEFAULT_出来高医療費請求額);
        entity.setDekidakaIryohiRiyoshaFutangaku(DEFAULT_出来高医療費利用者負担額);
        entity.setShinsaHohoKubunCode(DEFAULT_審査方法区分コード);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数_金額);
        entity.setShikyuKingaku(DEFAULT_支払金額);
        entity.setZougenten(DEFAULT_増減点);
        entity.setSeikyugakuSagakuKingaku(DEFAULT_請求額差額金額);
        entity.setDekidakaSeikyugakuSagaku(DEFAULT_出来高請求額差額金額);
        entity.setZougenRiyu(DEFAULT_増減理由等);
        entity.setHushikyuRiyu(DEFAULT_不支給理由等);
        entity.setKounyuKaishuRireki(DEFAULT_購入_改修履歴等);
        return entity;
    }
}
