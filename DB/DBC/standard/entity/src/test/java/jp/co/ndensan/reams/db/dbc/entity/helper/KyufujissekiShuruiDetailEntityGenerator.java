/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績種類明細エンティティのテスト用インスタンスを作成するhelperクラスです。
 *
 * @author N3317 塚田 萌
 */
public final class KyufujissekiShuruiDetailEntityGenerator {

    public static final KokanShikibetsuNo 交換識別番号 = new KokanShikibetsuNo(new RString("1137"));
    public static final RString 入力識別番号 = new RString("7131");
    public static final RString レコード種別コード = new RString("01");
    public static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("00135985"));
    public static final KaigoHihokenshaNo 被保険者番号 = new KaigoHihokenshaNo(new RString("0000000019"));
    public static final ServiceTeikyoYM サービス提供年月 = new ServiceTeikyoYM(new FlexibleYearMonth("201407"));
    public static final JigyoshaNo 事業者番号 = new JigyoshaNo(new RString("1258743695"));
    public static final ToshiNo 通番 = new ToshiNo(new RString("568"));
    public static final ServiceShuruiCode サービス種類コード = new ServiceShuruiCode(new RString("11"));
    public static final Decimal 保険利用負担額 = new Decimal(5000);
    public static final Decimal 保険対象合計 = new Decimal(5000);
    public static final Decimal 保険請求額 = new Decimal(5000);
    public static final Decimal 保険出来高単位数合計 = new Decimal(5000);
    public static final ServiceCode サービスコード = new ServiceCode(new RString("113137"));
    public static final Decimal サービス計画費単位数合計 = new Decimal(5000);
    public static final Decimal ケアマネジメント費単位数 = new Decimal(5000);

    private KyufujissekiShuruiDetailEntityGenerator() {
    }

    public static DbV3016KyufujissekiShuruiDetailEntity createDbV3016KyufujissekiShuruiDetailEntity() {
        DbV3016KyufujissekiShuruiDetailEntity entity = new DbV3016KyufujissekiShuruiDetailEntity();

        entity.setKokanShikibetsuNo(交換識別番号);
        entity.setInputShikibetsuNo(入力識別番号);
        entity.setRecodeShubetsuCode(レコード種別コード);
        entity.setHokenshaNo(証記載保険者番号);
        entity.setHiHokenshaNo(被保険者番号);
        entity.setServiceTeikyoYM(サービス提供年月);
        entity.setJigyoshoNo(事業者番号);
        entity.setToshiNo(通番);
        entity.setServiceSyuruiCode(サービス種類コード);
        entity.setHokenRiyoshaFutangaku(保険利用負担額);
        entity.setAtoHokenTanisuTotal(保険対象合計);
        entity.setAtoHokenSeikyugaku(保険請求額);
        entity.setAtoHokenDekidakaTanisuTotal(保険出来高単位数合計);
        entity.setServiceCode(サービスコード);
        entity.setAtoServiceTanisuTotal(サービス計画費単位数合計);
        entity.setAtotanisu(ケアマネジメント費単位数);

        return entity;
    }

    public static List<DbV3016KyufujissekiShuruiDetailEntity> createDbV3016KyufujissekiShuruiDetailEntities(int listSize) {

        List<DbV3016KyufujissekiShuruiDetailEntity> entities = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            entities.add(createDbV3016KyufujissekiShuruiDetailEntity());
        }
        return entities;
    }
}
