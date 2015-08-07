/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業高額介護サービス費支給判定結果エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_本人支払額 = new Decimal(0);
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final Decimal DEFAULT_支給金額 = new Decimal(0);
    public static final RString DEFAULT_不支給理由 = new RString("Data");
    public static final RString DEFAULT_審査方法区分 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_判定結果送付年月 = new FlexibleYear("1990");
    public static final boolean DEFAULT_再送付フラグ = false;
    public static final boolean DEFAULT_判定結果送付不要フラグ = false;
    public static final RString DEFAULT_審査結果反映区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_決定通知書作成年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_振込明細書作成年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator() {
    }

    public static DbT3111JigyoKogakuShikyuHanteiKekkaEntity createDbT3111JigyoKogakuShikyuHanteiKekkaEntity() {
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity = new DbT3111JigyoKogakuShikyuHanteiKekkaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setHonninShiharaiGaku(DEFAULT_本人支払額);
        entity.setShiharaiKubunCode(DEFAULT_支給区分コード);
        entity.setShiharaiKingaku(DEFAULT_支給金額);
        entity.setFushikyuRiyu(DEFAULT_不支給理由);
        entity.setShinsaHohoKubun(DEFAULT_審査方法区分);
        entity.setHanteiKekkaSofuYM(DEFAULT_判定結果送付年月);
        entity.setSaiSofuFlag(DEFAULT_再送付フラグ);
        entity.setHanteiKekkaSofuFuyoFlag(DEFAULT_判定結果送付不要フラグ);
        entity.setShinsaKekkaHaneiKubun(DEFAULT_審査結果反映区分);
        entity.setKetteiTsuchishoSakuseiYMD(DEFAULT_決定通知書作成年月日);
        entity.setFurikomiMeisaishoSakuseiYMD(DEFAULT_振込明細書作成年月日);
        return entity;
    }
}
