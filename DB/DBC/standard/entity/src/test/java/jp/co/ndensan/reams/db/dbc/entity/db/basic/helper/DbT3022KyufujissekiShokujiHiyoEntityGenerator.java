/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
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
 * 給付実績食事費用エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3022KyufujissekiShokujiHiyoEntityGenerator {

    public static final KokanShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final NyuryokuShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo();
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final Decimal DEFAULT_基本・提供日数 = new Decimal(0);
    public static final Decimal DEFAULT_基本・提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_基本・提供金額 = new Decimal(0);
    public static final Decimal DEFAULT_特別・提供日数 = new Decimal(0);
    public static final Decimal DEFAULT_特別・提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_特別・提供金額 = new Decimal(0);
    public static final Decimal DEFAULT_食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費１対象食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費２対象食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_公費３対象食事提供延べ日数 = new Decimal(0);
    public static final Decimal DEFAULT_食事提供費合計 = new Decimal(0);
    public static final Decimal DEFAULT_標準負担額（月額） = new Decimal(0);
    public static final Decimal DEFAULT_食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_公費１食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_公費２食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_公費３食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_標準負担額（日額） = new Decimal(0);
    public static final Decimal DEFAULT_後・基本食提供費用提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_後・特別食提供費用提供単価 = new Decimal(0);
    public static final Decimal DEFAULT_後・食事提供費請求額 = new Decimal(0);
    public static final Decimal DEFAULT_再審査回数 = new Decimal(0);
    public static final Decimal DEFAULT_過誤回数 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_審査年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_取込年月 = new FlexibleYear("1990");

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
        entity.setKihonTeikyoNissu(DEFAULT_基本・提供日数);
        entity.setKihonTeikyoTanka(DEFAULT_基本・提供単価);
        entity.setKihonTeikyoKingaku(DEFAULT_基本・提供金額);
        entity.setTokubestuTeikyoNissu(DEFAULT_特別・提供日数);
        entity.setTokubestuTeikyoTanka(DEFAULT_特別・提供単価);
        entity.setTokubestuTeikyoKingaku(DEFAULT_特別・提供金額);
        entity.setSyokujiTeikyoNissu(DEFAULT_食事提供延べ日数);
        entity.setKohi1SyokujiTeikyoNissu(DEFAULT_公費１対象食事提供延べ日数);
        entity.setKohi2SyokujiTeikyoNissu(DEFAULT_公費２対象食事提供延べ日数);
        entity.setKohi3SyokujiTeikyoNissu(DEFAULT_公費３対象食事提供延べ日数);
        entity.setSyokujiTeikyohiTotal(DEFAULT_食事提供費合計);
        entity.setGetsugakuHyojunFutanGaku(DEFAULT_標準負担額（月額）);
        entity.setSyokujiTeikyohiSeikyugaku(DEFAULT_食事提供費請求額);
        entity.setKohi1SyokujiTeikyohiSeikyugaku(DEFAULT_公費１食事提供費請求額);
        entity.setKohi2SyokujiTeikyohiSeikyugaku(DEFAULT_公費２食事提供費請求額);
        entity.setKohi3SyokujiTeikyohiSeikyugaku(DEFAULT_公費３食事提供費請求額);
        entity.setNichigakuHyojunFutanGaku(DEFAULT_標準負担額（日額）);
        entity.setAtoKihonTeikyoTanka(DEFAULT_後・基本食提供費用提供単価);
        entity.setAtoTokubestuTeikyoTanka(DEFAULT_後・特別食提供費用提供単価);
        entity.setAtoSyokujiTeikyohiSeikyugaku(DEFAULT_後・食事提供費請求額);
        entity.setSaishinsaKaisu(DEFAULT_再審査回数);
        entity.setKagoKaisu(DEFAULT_過誤回数);
        entity.setShinsaYM(DEFAULT_審査年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setTorikomiYM(DEFAULT_取込年月);
        return entity;
    }
}
