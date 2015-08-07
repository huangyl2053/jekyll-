/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
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
 * 償還払請求明細・住所地特例エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3107ShokanMeisaiJushochiTokureiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYear("1990");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo();
    public static final RString DEFAULT_様式番号 = new RString("Data");
    public static final RString DEFAULT_順次番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode();
    public static final ServiceKomokuCode DEFAULT_サービス項目コード = new ServiceKomokuCode();
    public static final Decimal DEFAULT_単位数 = new Decimal(0);
    public static final Decimal DEFAULT_日数・回数 = new Decimal(0);
    public static final int DEFAULT_サービス単位数 = 1;
    public static final ShoKisaiHokenshaNo DEFAULT_施設所在保険者番号 = new ShoKisaiHokenshaNo();
    public static final RString DEFAULT_摘要 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3107ShokanMeisaiJushochiTokureiEntityGenerator() {
    }

    public static DbT3107ShokanMeisaiJushochiTokureiEntity createDbT3107ShokanMeisaiJushochiTokureiEntity() {
        DbT3107ShokanMeisaiJushochiTokureiEntity entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNp(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKomokuCode(DEFAULT_サービス項目コード);
        entity.setTanisu(DEFAULT_単位数);
        entity.setNissuKaisu(DEFAULT_日数・回数);
        entity.setServiceTanisu(DEFAULT_サービス単位数);
        entity.setShisetsuShozaiHokenshaNo(DEFAULT_施設所在保険者番号);
        entity.setTekiyo(DEFAULT_摘要);
        return entity;
    }
}
