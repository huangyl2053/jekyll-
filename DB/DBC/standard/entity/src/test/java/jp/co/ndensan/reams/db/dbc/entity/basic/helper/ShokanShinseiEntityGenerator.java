/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author chenaoqi
 */
public class ShokanShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0001");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("200501");
    public static final RString DEFAULT_整理番号 = new RString("0000000003");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("0000000003");
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final RString DEFAULT_氏名 = new RString("Data");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_保険給付額 = new Decimal("50");
    public static final Decimal DEFAULT_利用者負担額 = new Decimal("20");
    public static final Decimal DEFAULT_支払金額合計 = new Decimal("21");
    public static final Decimal DEFAULT_保険対象費用額 = new Decimal("33");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("Data");
    public static final RString DEFAULT_審査結果 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShokanShinseiEntityGenerator() {
    }

    public static ShokanShinseiEntity createShokanShinseiEntity() {
        ShokanShinseiEntity entity = new ShokanShinseiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setMeisaiNo(DEFAULT_順次番号);
        entity.set氏名(DEFAULT_氏名);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setShiharaiKingakuTotal(DEFAULT_支払金額合計);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setHokenTaishoHiyogaku(DEFAULT_保険対象費用額);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHokenKyufugaku(DEFAULT_保険給付額);
        entity.setShinsaKekka(DEFAULT_審査結果);

        return entity;
    }
}
