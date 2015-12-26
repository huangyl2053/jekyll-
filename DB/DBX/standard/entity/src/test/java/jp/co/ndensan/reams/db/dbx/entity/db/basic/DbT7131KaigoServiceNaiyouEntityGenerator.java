/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoServiceIdoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護サービス内容エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7131KaigoServiceNaiyouEntityGenerator {

    public static final KaigoServiceShuruiCode DEFAULT_サービス種類コード = new KaigoServiceShuruiCode("12");
    public static final RString DEFAULT_サービス項目コード = new RString("Data");
    public static final FlexibleYearMonth DEFAULT_提供開始年月 = new FlexibleYearMonth("199012");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_提供終了年月 = new FlexibleYearMonth("199012");
    public static final RString DEFAULT_サービス名称 = new RString("Data");
    public static final RString DEFAULT_サービス略称 = new RString("Data");
    public static final int DEFAULT_単位数 = 1;
    public static final TanisuShikibetsu DEFAULT_単位数識別 = new TanisuShikibetsu(new Code("0001"));
    public static final TanisuSanteiTani DEFAULT_単位数算定単位 = new TanisuSanteiTani(new Code("0001"));
    public static final KaigoServiceIdoJiyu DEFAULT_異動事由 = new KaigoServiceIdoJiyu(new Code("0001"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7131KaigoServiceNaiyouEntityGenerator() {
    }

    public static DbT7131KaigoServiceNaiyouEntity createDbT7131KaigoServiceNaiyouEntity() {
        DbT7131KaigoServiceNaiyouEntity entity = new DbT7131KaigoServiceNaiyouEntity();
        entity.setServiceShuruiCode(DEFAULT_サービス種類コード);
        entity.setServiceKoumokuCode(DEFAULT_サービス項目コード);
        entity.setTeikyoKaishiYM(DEFAULT_提供開始年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setTeikyoShuryoYM(DEFAULT_提供終了年月);
        entity.setServiceName(DEFAULT_サービス名称);
        entity.setServiceNameRyaku(DEFAULT_サービス略称);
        entity.setTaniSu(DEFAULT_単位数);
        entity.setTanisuShikibetsuCode(DEFAULT_単位数識別);
        entity.setTanisuSanteiTani(DEFAULT_単位数算定単位);
        entity.setIdouJiyuCode(DEFAULT_異動事由);
        return entity;
    }
}
