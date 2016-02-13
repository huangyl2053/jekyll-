/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績食事費用エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3022KyufujissekiShokujiHiyoEntityGenerator {

    public static final KokanShikibetsuNo DEFAULT_交換情報識別番号 = new KokanShikibetsuNo("012340123400001");
    public static final NyuryokuShikibetsuNo DEFAULT_入力識別番号 = new NyuryokuShikibetsuNo("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("1");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final Decimal DEFAULT_基本_提供日数 = new Decimal(0);
    public static final Decimal DEFAULT_基本_提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_基本_提供金額 = new Decimal(0);
    public static final Decimal DEFAULT_特別_提供日数 = new Decimal(0);
    public static final Decimal DEFAULT_特別_提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_特別_提供金額 = new Decimal(0);
    public static final Decimal DEFAULT_食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費１対象食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費２対象食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費３対象食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_食事提供費合計 = new Decimal(0);
    public static final Decimal DEFAULT_標準負担額_月額 = new Decimal(0);
    public static final Decimal DEFAULT_食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_公費１食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_公費２食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_公費３食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_標準負担額_日額 = new Decimal(0);
    public static final Decimal DEFAULT_後_基本食提供費用提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_後_特別食提供費用提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_後_食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3022KyufujissekiShokujiHiyoEntityGenerator() {
    }

    public static DbT3022KyufujissekiShokujiHiyoEntity createDbT3022KyufujissekiShokujiHiyoEntity() {
        DbT3022KyufujissekiShokujiHiyoEntity entity = new DbT3022KyufujissekiShokujiHiyoEntity();
        entity.setKokanJohoShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setShokisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setKihonTeikyoNissu(DEFAULT_基本_提供日数);
        entity.setKihonTeikyoTanka(DEFAULT_基本_提供単価);
        entity.setKihonTeikyoKingaku(DEFAULT_基本_提供金額);
        entity.setTokubestuTeikyoNissu(DEFAULT_特別_提供日数);
        entity.setTokubestuTeikyoTanka(DEFAULT_特別_提供単価);
        entity.setTokubestuTeikyoKingaku(DEFAULT_特別_提供金額);
        entity.setSyokujiTeikyoNissu(DEFAULT_食事提供延べ日数);
        entity.setKohi1SyokujiTeikyoNissu(DEFAULT_公費１対象食事提供延べ日数);
        entity.setKohi2SyokujiTeikyoNissu(DEFAULT_公費２対象食事提供延べ日数);
        entity.setKohi3SyokujiTeikyoNissu(DEFAULT_公費３対象食事提供延べ日数);
        entity.setSyokujiTeikyohiTotal(DEFAULT_食事提供費合計);
        entity.setGetsugakuHyojunFutanGaku(DEFAULT_標準負担額_月額);
        entity.setSyokujiTeikyohiSeikyugaku(DEFAULT_食事提供費請求額);
        entity.setKohi1SyokujiTeikyohiSeikyugaku(DEFAULT_公費１食事提供費請求額);
        entity.setKohi2SyokujiTeikyohiSeikyugaku(DEFAULT_公費２食事提供費請求額);
        entity.setKohi3SyokujiTeikyohiSeikyugaku(DEFAULT_公費３食事提供費請求額);
        entity.setNichigakuHyojunFutanGaku(DEFAULT_標準負担額_日額);
        entity.setAtoKihonTeikyoTanka(DEFAULT_後_基本食提供費用提供単価);
        entity.setAtoTokubestuTeikyoTanka(DEFAULT_後_特別食提供費用提供単価);
        entity.setAtoSyokujiTeikyohiSeikyugaku(DEFAULT_後_食事提供費請求額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
