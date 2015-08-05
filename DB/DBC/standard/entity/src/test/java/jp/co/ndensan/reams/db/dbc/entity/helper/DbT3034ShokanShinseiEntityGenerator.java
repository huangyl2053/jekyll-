/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給申請エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3034ShokanShinseiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_申請理由 = new RString("1");
    public static final RString DEFAULT_申請者区分 = new RString("1");
    public static final RString DEFAULT_申請者氏名 = new RString("1");
    public static final RString DEFAULT_申請者氏名カナ = new RString("1");
    public static final RString DEFAULT_申請者住所 = new RString("1");
    public static final RString DEFAULT_申請者電話番号 = new RString("1");
    public static final RString DEFAULT_申請事業者コード = new RString("1");
    public static final Decimal DEFAULT_支払金額合計 = new Decimal(1);
    public static final int DEFAULT_保険給付額 = 1;
    public static final int DEFAULT_利用者負担額 = 1;
    public static final RString DEFAULT_支給申請審査区分 = new RString("1");
    public static final RString DEFAULT_審査方法区分 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3034ShokanShinseiEntityGenerator() {
    }

    public static DbT3034ShokanShinseiEntity createDbT3034ShokanShinseiEntity() {
        DbT3034ShokanShinseiEntity entity = new DbT3034ShokanShinseiEntity();
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
        entity.setShinseishaAddress(DEFAULT_申請者住所);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseiJigyoshaCode(DEFAULT_申請事業者コード);
        entity.setShiharaiKingakuTotal(DEFAULT_支払金額合計);
        entity.setHokenKyufuritsu(DEFAULT_保険給付額);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setShikyuShinseiShinsaKubun(DEFAULT_支給申請審査区分);
        entity.setShinsaHohoKubun(DEFAULT_審査方法区分);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
