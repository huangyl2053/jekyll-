/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績種類詳細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV3016KyufujissekiShuruiDetailEntityGenerator {

    public static final ShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final ShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("000001");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000000001");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199010");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("12345");
    public static final RString DEFAULT_通し番号 = new RString("Data");
    public static final ServiceShuruiCode DEFAULT_サービス種類コード = new ServiceShuruiCode("01");
    public static final int DEFAULT_保険_利用者負担額 = 1;
    public static final int DEFAULT_後_単位数合計 = 1;
    public static final RString DEFAULT_後_保険請求分請求額 = new RString("Data");
    public static final int DEFAULT_後_保険_出来高単位数合計 = 1;
    public static final ServiceCode DEFAULT_サービスコード = new ServiceCode("000001");
    public static final int DEFAULT_後_サービス単位数合計 = 1;
    public static final int DEFAULT_後_単位数 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV3016KyufujissekiShuruiDetailEntityGenerator() {
    }

    public static DbV3016KyufujissekiShuruiDetailEntity createDbV3016KyufujissekiShuruiDetailEntity() {
        DbV3016KyufujissekiShuruiDetailEntity entity = new DbV3016KyufujissekiShuruiDetailEntity();
        entity.setKokanShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setToshiNo(DEFAULT_通し番号);
        entity.setServiceSyuruiCode(DEFAULT_サービス種類コード);
        entity.setHokenRiyoshaFutangaku(DEFAULT_保険_利用者負担額);
        entity.setAtoHokenTanisuTotal(DEFAULT_後_単位数合計);
        entity.setAtoHokenSeikyugaku(DEFAULT_後_保険請求分請求額);
        entity.setAtoHokenDekidakaTanisuTotal(DEFAULT_後_保険_出来高単位数合計);
        entity.setServiceCode(DEFAULT_サービスコード);
        entity.setAtoServiceTanisuTotal(DEFAULT_後_サービス単位数合計);
        entity.setAtotanisu(DEFAULT_後_単位数);
        return entity;
    }
}
