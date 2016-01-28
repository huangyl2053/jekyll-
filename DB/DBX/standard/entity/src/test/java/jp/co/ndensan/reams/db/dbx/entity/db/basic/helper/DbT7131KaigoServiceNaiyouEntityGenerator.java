/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

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

    public static final KaigoServiceShuruiCode DEFAULT_サービス種類コード = new KaigoServiceShuruiCode("01");
    public static final RString DEFAULT_サービス項目コード = new RString("1122");
    public static final FlexibleYearMonth DEFAULT_提供開始年月 = new FlexibleYearMonth("201401");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(1);
    public static final FlexibleYearMonth DEFAULT_提供終了年月 = new FlexibleYearMonth("201401");
    public static final RString DEFAULT_サービス名称 = new RString("あいうえおかきくけこ");
    public static final RString DEFAULT_サービス略称 = new RString("あうおかこ");
    public static final int DEFAULT_単位数 = 1;
    public static final TanisuShikibetsu DEFAULT_単位数識別 = new TanisuShikibetsu(new Code("001"));
    public static final TanisuSanteiTani DEFAULT_単位数算定単位 = new TanisuSanteiTani(new Code("001"));
    public static final KaigoServiceIdoJiyu DEFAULT_異動事由 = new KaigoServiceIdoJiyu(new Code("001"));
    public static final RString DEFAULT_限度額対象外フラグ = new RString("1");
    public static final RString DEFAULT_外部サービス利用型区分 = new RString("1");
    public static final RString DEFAULT_特別地域加算フラグ = new RString("1");
    public static final RString DEFAULT_利用者負担定率_定額区分 = new RString("1");
    public static final RString DEFAULT_更新有無フラグ = new RString("1");
    public static final RString DEFAULT_元点数 = new RString("123456");
    public static final RString DEFAULT_元限度額対象外フラグ = new RString("1");
    public static final RString DEFAULT_元単位数識別コード = new RString("01");
    public static final RString DEFAULT_利用者負担額 = new RString("12345");
    public static final RString DEFAULT_給付率 = new RString("010");
    public static final RString DEFAULT_二次予防事業対象者実施区分_非該当 = new RString("1");
    public static final RString DEFAULT_要支援１受給者実施区分 = new RString("1");
    public static final RString DEFAULT_要支援２受給者実施区分 = new RString("1");
    public static final RString DEFAULT_対象事業者実施区分 = new RString("1");
    public static final RString DEFAULT_総合事業サービス区分 = new RString("1");

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
//        entity.setGendogakuTaishogaiFlag(DEFAULT_限度額対象外フラグ);
//        entity.setGaibuServiceRiyoKataKubun(DEFAULT_外部サービス利用型区分);
//        entity.setTokubetsuChiikiKasanFlag(DEFAULT_特別地域加算フラグ);
//        entity.setRiyosyaFutanTeiritsuTeigakuKubun(DEFAULT_利用者負担定率_定額区分);
//        entity.setKoshinUmuFoag(DEFAULT_更新有無フラグ);
//        entity.setMotoTensu(DEFAULT_元点数);
//        entity.setMotoGendogakuTaishogaiFlag(DEFAULT_元限度額対象外フラグ);
//        entity.setMotoTaniShikibetsuCd(DEFAULT_元単位数識別コード);
//        entity.setRiyoshaFutanGaku(DEFAULT_利用者負担額);
//        entity.setKyufuRitsu(DEFAULT_給付率);
//        entity.setNijiyoboJigyoTaishaJishiKubunHigaito(DEFAULT_二次予防事業対象者実施区分_非該当_);
//        entity.setYoshien1JukyushaJishiKubun(DEFAULT_要支援１受給者実施区分);
//        entity.setYoshien2JukyushaJishiKubun(DEFAULT_要支援２受給者実施区分);
//        entity.setTaishoJigyoJishiKubun(DEFAULT_対象事業者実施区分);
//        entity.setSogoJigyoServiceKubun(DEFAULT_総合事業サービス区分);
        return entity;
    }
}
