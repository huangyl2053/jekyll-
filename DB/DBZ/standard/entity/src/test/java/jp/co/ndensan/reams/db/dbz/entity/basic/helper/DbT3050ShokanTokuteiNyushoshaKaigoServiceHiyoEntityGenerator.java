/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求特定入所者介護サービス費用エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final RString DEFAULT_順次番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode(new RString("2"));
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode(new RString("2"));
    public static final int DEFAULT_費用単価 = 1;
    public static final int DEFAULT_負担限度額 = 1;
    public static final int DEFAULT_日数 = 1;
    public static final int DEFAULT_費用額 = 1;
    public static final int DEFAULT_保険分請求額 = 1;
    public static final int DEFAULT_利用者負担額 = 1;
    public static final int DEFAULT_費用額合計 = 1;
    public static final int DEFAULT_保険分請求額合計 = 1;
    public static final int DEFAULT_利用者負担額合計 = 1;
    public static final RString DEFAULT_支給区分コード = new RString("1");
    public static final int DEFAULT_点数金額 = 1;
    public static final int DEFAULT_支給金額 = 1;
    public static final int DEFAULT_増減点 = 1;
    public static final int DEFAULT_差額金額 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator() {
    }

    public static DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity() {
        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setHiyoTanka(DEFAULT_費用単価);
        entity.setFutanGendogaku(DEFAULT_負担限度額);
        entity.setNissu(DEFAULT_日数);
        entity.setHiyogaku(DEFAULT_費用額);
        entity.setHokenbunSeikyugaku(DEFAULT_保険分請求額);
        entity.setRiyoshaFutangaku(DEFAULT_利用者負担額);
        entity.setHiyogakuTotal(DEFAULT_費用額合計);
        entity.setHokenbunSeikyugakuTotal(DEFAULT_保険分請求額合計);
        entity.setRiyoshaFutangakuTotal(DEFAULT_利用者負担額合計);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setTensuKingaku(DEFAULT_点数金額);
        entity.setShikyuKingaku(DEFAULT_支給金額);
        entity.setZougenten(DEFAULT_増減点);
        entity.setSagakuKingaku(DEFAULT_差額金額);
        return entity;
    }
}
