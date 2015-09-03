/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績基本Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV3017KyufujissekiKihonEntityGenerator {

    public static final ShikibetsuCode DEFAULT_交換情報識別番号 = new ShikibetsuCode("012340123400001");
    public static final ShikibetsuCode DEFAULT_入力識別番号 = new ShikibetsuCode("012340123400001");
    public static final RString DEFAULT_レコード種別コード = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo("000001");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000000001");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199010");
    public static final JigyoshaNo DEFAULT_事業所番号 = new JigyoshaNo("12345");
    public static final RString DEFAULT_給付実績情報作成区分コード = new RString("Data");
    public static final RString DEFAULT_給付実績区分コード = new RString("Data");
    public static final RString DEFAULT_通し番号 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV3017KyufujissekiKihonEntityGenerator() {
    }

    public static DbV3017KyufujissekiKihonEntity createDbV3017KyufujissekiKihonEntity() {
        DbV3017KyufujissekiKihonEntity entity = new DbV3017KyufujissekiKihonEntity();
        entity.setKokanShikibetsuNo(DEFAULT_交換情報識別番号);
        entity.setInputShikibetsuNo(DEFAULT_入力識別番号);
        entity.setRecodeShubetsuCode(DEFAULT_レコード種別コード);
        entity.setHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setJigyoshoNo(DEFAULT_事業所番号);
        entity.setKyufuSakuseiKubunCode(DEFAULT_給付実績情報作成区分コード);
        entity.setKyufuJissekiKubunCode(DEFAULT_給付実績区分コード);
        entity.setToshiNo(DEFAULT_通し番号);
        return entity;
    }
}
