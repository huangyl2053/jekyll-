/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費支給判定結果エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3057KogakuShikyuHanteiKekkaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_本人支払額 = new Decimal(1);
    public static final RString DEFAULT_支給区分コード = new RString("1");
    public static final Decimal DEFAULT_支給金額 = new Decimal(1);
    public static final RString DEFAULT_不支給理由 = new RString("1");
    public static final RString DEFAULT_支払方法区分コード = new RString("1");
    public static final RString DEFAULT_支払場所 = new RString("1");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_閉庁内容 = new RString("1");
    public static final RString DEFAULT_支払窓口開始時間 = new RString("1");
    public static final RString DEFAULT_支払窓口終了時間 = new RString("1");
    public static final RString DEFAULT_受領委任契約番号 = new RString("1");
    public static final RString DEFAULT_審査方法区分 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_判定結果送付年月 = new FlexibleYearMonth(new RString("201406"));
    public static final boolean DEFAULT_再送付フラグ = false;
    public static final boolean DEFAULT_判定結果送付不要フラグ = false;
    public static final RString DEFAULT_審査結果反映区分 = new RString("1");
    public static final FlexibleDate DEFAULT_決定通知書作成年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_振込明細書作成年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3057KogakuShikyuHanteiKekkaEntityGenerator() {
    }

    public static DbT3057KogakuShikyuHanteiKekkaEntity createDbT3057KogakuShikyuHanteiKekkaEntity() {
        DbT3057KogakuShikyuHanteiKekkaEntity entity = new DbT3057KogakuShikyuHanteiKekkaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setHonninShiharaiGaku(DEFAULT_本人支払額);
        entity.setShiharaiKubunCode(DEFAULT_支給区分コード);
        entity.setShiharaiKingaku(DEFAULT_支給金額);
        entity.setFushikyuRiyu(DEFAULT_不支給理由);
        entity.setShiharaiHohoKubunCode(DEFAULT_支払方法区分コード);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setHeichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiKaishiTime(DEFAULT_支払窓口開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払窓口終了時間);
        entity.setJuryoIninKeiyakuNo(DEFAULT_受領委任契約番号);
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
