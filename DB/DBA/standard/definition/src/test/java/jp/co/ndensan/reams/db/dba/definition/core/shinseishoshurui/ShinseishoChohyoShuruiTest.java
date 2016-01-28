package jp.co.ndensan.reams.db.dba.definition.core.shinseishoshurui;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 申請書帳票種類のテストクラスです。
 *
 */
public class ShinseishoChohyoShuruiTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinseishoChohyoShurui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinseishoChohyoShurui.toValue(new RString("99999"));
    }

    @Test
    public void 引数にDBA800001_ShikakushutokuIdoSoshitsuTodokeを指定した場合_toValueは_介護保険資格取得_異動_喪失届を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBA800001_ShikakushutokuIdoSoshitsuTodoke")), is(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届));
    }

    @Test
    public void 引数にDBA800003_HihokehsnashoSaikoufuShinseishoを指定した場合_toValueは_介護保険被保険者証等再交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBA800003_HihokehsnashoSaikoufuShinseisho")), is(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書));
    }

    @Test
    public void 引数にDBA800004_HihokehsnashoSaikoufuShinseisho2gouを指定した場合_toValueは_介護保険被保険者証交付申請書_第2号被保険者を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBA800004_HihokehsnashoSaikoufuShinseisho2gou")), is(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者));
    }

    @Test
    public void 引数にDBA800002_JyushochiTokureiTekiyoHenkoShuryoTodokeを指定した場合_toValueは_介護保険住所地特例適用_変更_終了届を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBA800002_JyushochiTokureiTekiyoHenkoShuryoTodoke")), is(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届));
    }

    @Test
    public void 引数にDBD800011_JukyuShikakuShomeishokoufuShinseishoを指定した場合_toValueは_介護保険受給資格証明書交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800011_JukyuShikakuShomeishokoufuShinseisho")), is(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書));
    }

    @Test
    public void 引数にDBB800001_HokenryoGenmenShinseishoを指定した場合_toValueは_介護保険料減免申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBB800001_HokenryoGenmenShinseisho")), is(ShinseishoChohyoShurui.介護保険料減免申請書));
    }

    @Test
    public void 引数にDBB800002_HokenryoChoshuYoyuShinseishoを指定した場合_toValueは_介護保険料徴収猶予申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBB800002_HokenryoChoshuYoyuShinseisho")), is(ShinseishoChohyoShurui.介護保険料徴収猶予申請書));
    }

    @Test
    public void 引数にDBB800003_NofugakuShomeishoKofuShinseishoを指定した場合_toValueは_介護保険料納付額証明書交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBB800003_NofugakuShomeishoKofuShinseisho")), is(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書));
    }

    @Test
    public void 引数にDBD800001_FutangendogakuNinteiShinseishoを指定した場合_toValueは_介護保険負担限度額認定申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800001_FutangendogakuNinteiShinseisho")), is(ShinseishoChohyoShurui.介護保険負担限度額認定申請書));
    }

    @Test
    public void 引数にDBD800002_RiyoshaFutangakuGengakuMenjyoShinseishoを指定した場合_toValueは_介護保険利用者負担額減額_免除申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho")), is(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書));
    }

    @Test
    public void 引数にDBD800003_RiyoshaFutangakuGengakuMenjyoShinseishoKyusochishaを指定した場合_toValueは_介護保険利用者負担額減額_免除申請書_旧措置者用を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800003_RiyoshaFutangakuGengakuMenjyoShinseishoKyusochisha")), is(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書_旧措置者用));
    }

    @Test
    public void 引数にDBD800004_TokuteiFutangendogakuShinseishoを指定した場合_toValueは_介護保険特定負担限度額申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800004_TokuteiFutangendogakuShinseisho")), is(ShinseishoChohyoShurui.介護保険特定負担限度額申請書));
    }

    @Test
    public void 引数にDBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseishoを指定した場合_toValueは_訪問介護利用者負担額減額申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho")), is(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書));
    }

    @Test
    public void 引数にDBD800006_ShakaifukushihojinRiyoshaFutangakuKeigentaishoShinseishoを指定した場合_toValueは_社会福祉法人等利用者負担軽減対象確認申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800006_ShakaifukushihojinRiyoshaFutangakuKeigentaishoShinseisho")), is(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書));
    }

    @Test
    public void 引数にDBD800007_TokubetsuChiikiKasanGenmenTaishoShinseishoを指定した場合_toValueは_特別地域加算減免_訪問介護等利用者負担減額対象確認申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho")), is(ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書));
    }

    @Test
    public void 引数にDBD800008_TokubetsuChiikiKasanGenmenTaishoShinseishoを指定した場合_toValueは_給付額減額免除申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800008_TokubetsuChiikiKasanGenmenTaishoShinseisho")), is(ShinseishoChohyoShurui.給付額減額免除申請書));
    }

    @Test
    public void 引数にDBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseishoを指定した場合_toValueは_支払方法変更_償還払い化_終了申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseisho")), is(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書));
    }

    @Test
    public void 引数にDBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoを指定した場合_toValueは_介護保険受領委任払い取扱事業者登録申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseisho")), is(ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書));
    }

    @Test
    public void 引数にDBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYoguを指定した場合_toValueは_介護保険受領委任払い契約申請書_福祉用具を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYogu")), is(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_福祉用具));
    }

    @Test
    public void 引数にDBC800003_JuryoIninharaiKeiyakuShinseishoJutakuKaishuを指定した場合_toValueは_介護保険受領委任払い契約申請書_住宅改修を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800003_JuryoIninharaiKeiyakuShinseishoJutakuKaishu")), is(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_住宅改修));
    }

    @Test
    public void 引数にDBC800004_ItakuServiceKeikaluSakuseiIraiTodokedeshoを指定した場合_toValueは_居宅_介護予防_サービス計画作成依頼_変更_届出書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800004_ItakuServiceKeikaluSakuseiIraiTodokedesho")), is(ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書));
    }

    @Test
    public void 引数にDBC800008_ItakuKaigoServiceKeikakuJikoSakuseiを指定した場合_toValueは_介護保険居宅介護サービス計画の作成_自己作成を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800008_ItakuKaigoServiceKeikakuJikoSakusei")), is(ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成));
    }

    @Test
    public void 引数にDBC800005_FukushiYoguKonyuhiShinseishoを指定した場合_toValueは_福祉用具購入費申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800005_FukushiYoguKonyuhiShinseisho")), is(ShinseishoChohyoShurui.福祉用具購入費申請書));
    }

    @Test
    public void 引数にDBC800006_JutakuKaishuhiShikyuShinseishoJizenを指定した場合_toValueは_住宅改修費事前支給申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800006_JutakuKaishuhiShikyuShinseishoJizen")), is(ShinseishoChohyoShurui.住宅改修費事前支給申請書));
    }

    @Test
    public void 引数にDBC800007_JutakuKaishuhiShikyuShinseishoを指定した場合_toValueは_住宅改修費支給申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800007_JutakuKaishuhiShikyuShinseisho")), is(ShinseishoChohyoShurui.住宅改修費支給申請書));
    }

    @Test
    public void 引数にDBC800009_ShokanharaiShikyuShinseishoを指定した場合_toValueは_介護保険償還払支給申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800009_ShokanharaiShikyuShinseisho")), is(ShinseishoChohyoShurui.介護保険償還払支給申請書));
    }

    @Test
    public void 引数にDBC800010_ShokanharaiJuryoIninShinseishoを指定した場合_toValueは_介護保険償還払受領委任払申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800010_ShokanharaiJuryoIninShinseisho")), is(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書));
    }

    @Test
    public void 引数にDBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHaraiを指定した場合_toValueは_介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHarai")), is(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書));
    }

    @Test
    public void 引数にDBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHaraiを指定した場合_toValueは_介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHarai")), is(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書));
    }

    @Test
    public void 引数にDBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHaraiを指定した場合_toValueは_介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHarai")), is(ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書));
    }

    @Test
    public void 引数にDBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseishoを指定した場合_toValueは_軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseisho")), is(ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書));
    }

    @Test
    public void 引数にDBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoを指定した場合_toValueは_介護保険高額介護_予防_サービス費支給_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo")), is(ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書));
    }

    @Test
    public void 引数にDBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseishoを指定した場合_toValueは_高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseisho")), is(ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書));
    }

    @Test
    public void 引数にDBC800017_JoseikinKyufuShinseishoを指定した場合_toValueは_介護保険助成金給付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800017_JoseikinKyufuShinseisho")), is(ShinseishoChohyoShurui.介護保険助成金給付申請書));
    }

    @Test
    public void 引数にDBC800018_kyufuhiKariireiShinseishoを指定した場合_toValueは_介護保険給付費借入申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800018_kyufuhiKariireiShinseisho")), is(ShinseishoChohyoShurui.介護保険給付費借入申請書));
    }

    @Test
    public void 引数にDBC800019_KyufuKashitsukekinShokanKigenEnchoShinseishoを指定した場合_toValueは_介護保険給付費貸付金償還期限延長申請書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho")), is(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書));
    }

    @Test
    public void 引数にDBC800020_DaisanshaKouiHigaitodokeKaigoHokenyoを指定した場合_toValueは_第三者行為による被害届_介護保険用を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo")), is(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用));
    }

    @Test
    public void 引数にDBD800010_ShiharaiShobunBenmeishoを指定した場合_toValueは_介護保険給付の支払処分弁明書を返す() {
        assertThat(ShinseishoChohyoShurui.toValue(new RString("DBD800010_ShiharaiShobunBenmeisho")), is(ShinseishoChohyoShurui.介護保険給付の支払処分弁明書));
    }

    @Test
    public void 介護保険資格取得_異動_喪失届を指定した場合_getコードは_DBA800001_ShikakushutokuIdoSoshitsuTodokeを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.getコード(), is(new RString("DBA800001_ShikakushutokuIdoSoshitsuTodoke")));
    }

    @Test
    public void 介護保険被保険者証等再交付申請書を指定した場合_getコードは_DBA800003_HihokehsnashoSaikoufuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.getコード(), is(new RString("DBA800003_HihokehsnashoSaikoufuShinseisho")));
    }

    @Test
    public void 介護保険被保険者証交付申請書_第2号被保険者を指定した場合_getコードは_DBA800004_HihokehsnashoSaikoufuShinseisho2gouを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.getコード(), is(new RString("DBA800004_HihokehsnashoSaikoufuShinseisho2gou")));
    }

    @Test
    public void 介護保険住所地特例適用_変更_終了届を指定した場合_getコードは_DBA800002_JyushochiTokureiTekiyoHenkoShuryoTodokeを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.getコード(), is(new RString("DBA800002_JyushochiTokureiTekiyoHenkoShuryoTodoke")));
    }

    @Test
    public void 介護保険受給資格証明書交付申請書を指定した場合_getコードは_DBD800011_JukyuShikakuShomeishokoufuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.getコード(), is(new RString("DBD800011_JukyuShikakuShomeishokoufuShinseisho")));
    }

    @Test
    public void 介護保険料減免申請書を指定した場合_getコードは_DBB800001_HokenryoGenmenShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険料減免申請書.getコード(), is(new RString("DBB800001_HokenryoGenmenShinseisho")));
    }

    @Test
    public void 介護保険料徴収猶予申請書を指定した場合_getコードは_DBB800002_HokenryoChoshuYoyuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.getコード(), is(new RString("DBB800002_HokenryoChoshuYoyuShinseisho")));
    }

    @Test
    public void 介護保険料納付額証明書交付申請書を指定した場合_getコードは_DBB800003_NofugakuShomeishoKofuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.getコード(), is(new RString("DBB800003_NofugakuShomeishoKofuShinseisho")));
    }

    @Test
    public void 介護保険負担限度額認定申請書を指定した場合_getコードは_DBD800001_FutangendogakuNinteiShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.getコード(), is(new RString("DBD800001_FutangendogakuNinteiShinseisho")));
    }

    @Test
    public void 介護保険利用者負担額減額_免除申請書を指定した場合_getコードは_DBD800002_RiyoshaFutangakuGengakuMenjyoShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.getコード(), is(new RString("DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho")));
    }

    @Test
    public void 介護保険利用者負担額減額_免除申請書_旧措置者用を指定した場合_getコードは_DBD800003_RiyoshaFutangakuGengakuMenjyoShinseishoKyusochishaを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書_旧措置者用.getコード(), is(new RString("DBD800003_RiyoshaFutangakuGengakuMenjyoShinseishoKyusochisha")));
    }

    @Test
    public void 介護保険特定負担限度額申請書を指定した場合_getコードは_DBD800004_TokuteiFutangendogakuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.getコード(), is(new RString("DBD800004_TokuteiFutangendogakuShinseisho")));
    }

    @Test
    public void 訪問介護利用者負担額減額申請書を指定した場合_getコードは_DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.getコード(), is(new RString("DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho")));
    }

    @Test
    public void 社会福祉法人等利用者負担軽減対象確認申請書を指定した場合_getコードは_DBD800006_ShakaifukushihojinRiyoshaFutangakuKeigentaishoShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.getコード(), is(new RString("DBD800006_ShakaifukushihojinRiyoshaFutangakuKeigentaishoShinseisho")));
    }

    @Test
    public void 特別地域加算減免_訪問介護等利用者負担減額対象確認申請書を指定した場合_getコードは_DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.getコード(), is(new RString("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho")));
    }

    @Test
    public void 給付額減額免除申請書を指定した場合_getコードは_DBD800008_TokubetsuChiikiKasanGenmenTaishoShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.給付額減額免除申請書.getコード(), is(new RString("DBD800008_TokubetsuChiikiKasanGenmenTaishoShinseisho")));
    }

    @Test
    public void 支払方法変更_償還払い化_終了申請書を指定した場合_getコードは_DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.getコード(), is(new RString("DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseisho")));
    }

    @Test
    public void 介護保険受領委任払い取扱事業者登録申請書を指定した場合_getコードは_DBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.getコード(), is(new RString("DBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseisho")));
    }

    @Test
    public void 介護保険受領委任払い契約申請書_福祉用具を指定した場合_getコードは_DBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYoguを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_福祉用具.getコード(), is(new RString("DBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYogu")));
    }

    @Test
    public void 介護保険受領委任払い契約申請書_住宅改修を指定した場合_getコードは_DBC800003_JuryoIninharaiKeiyakuShinseishoJutakuKaishuを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_住宅改修.getコード(), is(new RString("DBC800003_JuryoIninharaiKeiyakuShinseishoJutakuKaishu")));
    }

    @Test
    public void 居宅_介護予防_サービス計画作成依頼_変更_届出書を指定した場合_getコードは_DBC800004_ItakuServiceKeikaluSakuseiIraiTodokedeshoを返す() {
        assertThat(ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.getコード(), is(new RString("DBC800004_ItakuServiceKeikaluSakuseiIraiTodokedesho")));
    }

    @Test
    public void 介護保険居宅介護サービス計画の作成_自己作成を指定した場合_getコードは_DBC800008_ItakuKaigoServiceKeikakuJikoSakuseiを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成.getコード(), is(new RString("DBC800008_ItakuKaigoServiceKeikakuJikoSakusei")));
    }

    @Test
    public void 福祉用具購入費申請書を指定した場合_getコードは_DBC800005_FukushiYoguKonyuhiShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.福祉用具購入費申請書.getコード(), is(new RString("DBC800005_FukushiYoguKonyuhiShinseisho")));
    }

    @Test
    public void 住宅改修費事前支給申請書を指定した場合_getコードは_DBC800006_JutakuKaishuhiShikyuShinseishoJizenを返す() {
        assertThat(ShinseishoChohyoShurui.住宅改修費事前支給申請書.getコード(), is(new RString("DBC800006_JutakuKaishuhiShikyuShinseishoJizen")));
    }

    @Test
    public void 住宅改修費支給申請書を指定した場合_getコードは_DBC800007_JutakuKaishuhiShikyuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.住宅改修費支給申請書.getコード(), is(new RString("DBC800007_JutakuKaishuhiShikyuShinseisho")));
    }

    @Test
    public void 介護保険償還払支給申請書を指定した場合_getコードは_DBC800009_ShokanharaiShikyuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険償還払支給申請書.getコード(), is(new RString("DBC800009_ShokanharaiShikyuShinseisho")));
    }

    @Test
    public void 介護保険償還払受領委任払申請書を指定した場合_getコードは_DBC800010_ShokanharaiJuryoIninShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.getコード(), is(new RString("DBC800010_ShokanharaiJuryoIninShinseisho")));
    }

    @Test
    public void 介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書を指定した場合_getコードは_DBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHaraiを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.getコード(), is(new RString("DBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHarai")));
    }

    @Test
    public void 介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書を指定した場合_getコードは_DBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHaraiを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.getコード(), is(new RString("DBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHarai")));
    }

    @Test
    public void 介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書を指定した場合_getコードは_DBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHaraiを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.getコード(), is(new RString("DBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHarai")));
    }

    @Test
    public void 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書を指定した場合_getコードは_DBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.getコード(), is(new RString("DBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseisho")));
    }

    @Test
    public void 介護保険高額介護_予防_サービス費支給_受領委任払_申請書を指定した場合_getコードは_DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.getコード(), is(new RString("DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo")));
    }

    @Test
    public void 高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書を指定した場合_getコードは_DBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.getコード(), is(new RString("DBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseisho")));
    }

    @Test
    public void 介護保険助成金給付申請書を指定した場合_getコードは_DBC800017_JoseikinKyufuShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険助成金給付申請書.getコード(), is(new RString("DBC800017_JoseikinKyufuShinseisho")));
    }

    @Test
    public void 介護保険給付費借入申請書を指定した場合_getコードは_DBC800018_kyufuhiKariireiShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険給付費借入申請書.getコード(), is(new RString("DBC800018_kyufuhiKariireiShinseisho")));
    }

    @Test
    public void 介護保険給付費貸付金償還期限延長申請書を指定した場合_getコードは_DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.getコード(), is(new RString("DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho")));
    }

    @Test
    public void 第三者行為による被害届_介護保険用を指定した場合_getコードは_DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyoを返す() {
        assertThat(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.getコード(), is(new RString("DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo")));
    }

    @Test
    public void 介護保険給付の支払処分弁明書を指定した場合_getコードは_DBD800010_ShiharaiShobunBenmeishoを返す() {
        assertThat(ShinseishoChohyoShurui.介護保険給付の支払処分弁明書.getコード(), is(new RString("DBD800010_ShiharaiShobunBenmeisho")));
    }

    @Test
    public void 介護保険資格取得_異動_喪失届を指定した場合_get名称は_介護保険資格取得_異動_喪失届を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険資格取得_異動_喪失届.get名称(), is(new RString("介護保険資格取得・異動・喪失届")));
    }

    @Test
    public void 介護保険被保険者証等再交付申請書を指定した場合_get名称は_介護保険被保険者証等再交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険被保険者証等再交付申請書.get名称(), is(new RString("介護保険被保険者証等再交付申請書")));
    }

    @Test
    public void 介護保険被保険者証交付申請書_第2号被保険者を指定した場合_get名称は_介護保険被保険者証交付申請書_第2号被保険者を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険被保険者証交付申請書_第2号被保険者.get名称(), is(new RString("介護保険被保険者証交付申請書（第2号被保険者）")));
    }

    @Test
    public void 介護保険住所地特例適用_変更_終了届を指定した場合_get名称は_介護保険住所地特例適用_変更_終了届を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険住所地特例適用_変更_終了届.get名称(), is(new RString("介護保険住所地特例適用・変更・終了届")));
    }

    @Test
    public void 介護保険受給資格証明書交付申請書を指定した場合_get名称は_介護保険受給資格証明書交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受給資格証明書交付申請書.get名称(), is(new RString("介護保険受給資格証明書交付申請書")));
    }

    @Test
    public void 介護保険料減免申請書を指定した場合_get名称は_介護保険料減免申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険料減免申請書.get名称(), is(new RString("介護保険料減免申請書")));
    }

    @Test
    public void 介護保険料徴収猶予申請書を指定した場合_get名称は_介護保険料徴収猶予申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険料徴収猶予申請書.get名称(), is(new RString("介護保険料徴収猶予申請書")));
    }

    @Test
    public void 介護保険料納付額証明書交付申請書を指定した場合_get名称は_介護保険料納付額証明書交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険料納付額証明書交付申請書.get名称(), is(new RString("介護保険料納付額証明書交付申請書")));
    }

    @Test
    public void 介護保険負担限度額認定申請書を指定した場合_get名称は_介護保険負担限度額認定申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険負担限度額認定申請書.get名称(), is(new RString("介護保険負担限度額認定申請書")));
    }

    @Test
    public void 介護保険利用者負担額減額_免除申請書を指定した場合_get名称は_介護保険利用者負担額減額_免除申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書.get名称(), is(new RString("介護保険利用者負担額減額・免除申請書")));
    }

    @Test
    public void 介護保険利用者負担額減額_免除申請書_旧措置者用を指定した場合_get名称は_介護保険利用者負担額減額_免除申請書_旧措置者用を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険利用者負担額減額_免除申請書_旧措置者用.get名称(), is(new RString("介護保険利用者負担額減額・免除申請書(旧措置者用）")));
    }

    @Test
    public void 介護保険特定負担限度額申請書を指定した場合_get名称は_介護保険特定負担限度額申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険特定負担限度額申請書.get名称(), is(new RString("介護保険特定負担限度額申請書")));
    }

    @Test
    public void 訪問介護利用者負担額減額申請書を指定した場合_get名称は_訪問介護利用者負担額減額申請書を返す() {
        assertThat(ShinseishoChohyoShurui.訪問介護利用者負担額減額申請書.get名称(), is(new RString("訪問介護利用者負担額減額申請書")));
    }

    @Test
    public void 社会福祉法人等利用者負担軽減対象確認申請書を指定した場合_get名称は_社会福祉法人等利用者負担軽減対象確認申請書を返す() {
        assertThat(ShinseishoChohyoShurui.社会福祉法人等利用者負担軽減対象確認申請書.get名称(), is(new RString("社会福祉法人等利用者負担軽減対象確認申請書")));
    }

    @Test
    public void 特別地域加算減免_訪問介護等利用者負担減額対象確認申請書を指定した場合_get名称は_特別地域加算減免_訪問介護等利用者負担減額対象確認申請書を返す() {
        assertThat(ShinseishoChohyoShurui.特別地域加算減免_訪問介護等利用者負担減額対象確認申請書.get名称(), is(new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書")));
    }

    @Test
    public void 給付額減額免除申請書を指定した場合_get名称は_給付額減額免除申請書を返す() {
        assertThat(ShinseishoChohyoShurui.給付額減額免除申請書.get名称(), is(new RString("給付額減額免除申請書")));
    }

    @Test
    public void 支払方法変更_償還払い化_終了申請書を指定した場合_get名称は_支払方法変更_償還払い化_終了申請書を返す() {
        assertThat(ShinseishoChohyoShurui.支払方法変更_償還払い化_終了申請書.get名称(), is(new RString("支払方法変更（償還払い化）終了申請書")));
    }

    @Test
    public void 介護保険受領委任払い取扱事業者登録申請書を指定した場合_get名称は_介護保険受領委任払い取扱事業者登録申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受領委任払い取扱事業者登録申請書.get名称(), is(new RString("介護保険受領委任払い取扱事業者登録申請書")));
    }

    @Test
    public void 介護保険受領委任払い契約申請書_福祉用具を指定した場合_get名称は_介護保険受領委任払い契約申請書_福祉用具を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_福祉用具.get名称(), is(new RString("介護保険受領委任払い契約申請書(福祉用具）")));
    }

    @Test
    public void 介護保険受領委任払い契約申請書_住宅改修を指定した場合_get名称は_介護保険受領委任払い契約申請書_住宅改修を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険受領委任払い契約申請書_住宅改修.get名称(), is(new RString("介護保険受領委任払い契約申請書(住宅改修）")));
    }

    @Test
    public void 居宅_介護予防_サービス計画作成依頼_変更_届出書を指定した場合_get名称は_居宅_介護予防_サービス計画作成依頼_変更_届出書を返す() {
        assertThat(ShinseishoChohyoShurui.居宅_介護予防_サービス計画作成依頼_変更_届出書.get名称(), is(new RString("居宅（介護予防）サービス計画作成依頼（変更）届出書")));
    }

    @Test
    public void 介護保険居宅介護サービス計画の作成_自己作成を指定した場合_get名称は_介護保険居宅介護サービス計画の作成_自己作成を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護サービス計画の作成_自己作成.get名称(), is(new RString("介護保険居宅介護サービス計画の作成（自己作成）")));
    }

    @Test
    public void 福祉用具購入費申請書を指定した場合_get名称は_福祉用具購入費申請書を返す() {
        assertThat(ShinseishoChohyoShurui.福祉用具購入費申請書.get名称(), is(new RString("福祉用具購入費申請書")));
    }

    @Test
    public void 住宅改修費事前支給申請書を指定した場合_get名称は_住宅改修費事前支給申請書を返す() {
        assertThat(ShinseishoChohyoShurui.住宅改修費事前支給申請書.get名称(), is(new RString("住宅改修費事前支給申請書")));
    }

    @Test
    public void 住宅改修費支給申請書を指定した場合_get名称は_住宅改修費支給申請書を返す() {
        assertThat(ShinseishoChohyoShurui.住宅改修費支給申請書.get名称(), is(new RString("住宅改修費支給申請書")));
    }

    @Test
    public void 介護保険償還払支給申請書を指定した場合_get名称は_介護保険償還払支給申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険償還払支給申請書.get名称(), is(new RString("介護保険償還払支給申請書")));
    }

    @Test
    public void 介護保険償還払受領委任払申請書を指定した場合_get名称は_介護保険償還払受領委任払申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険償還払受領委任払申請書.get名称(), is(new RString("介護保険償還払受領委任払申請書")));
    }

    @Test
    public void 介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書を指定した場合_get名称は_介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書.get名称(), is(new RString("介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書")));
    }

    @Test
    public void 介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書を指定した場合_get名称は_介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書.get名称(), is(new RString("介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書")));
    }

    @Test
    public void 介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書を指定した場合_get名称は_介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書.get名称(), is(new RString("介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書")));
    }

    @Test
    public void 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書を指定した場合_get名称は_軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書を返す() {
        assertThat(ShinseishoChohyoShurui.軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書.get名称(), is(new RString("軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書")));
    }

    @Test
    public void 介護保険高額介護_予防_サービス費支給_受領委任払_申請書を指定した場合_get名称は_介護保険高額介護_予防_サービス費支給_受領委任払_申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険高額介護_予防_サービス費支給_受領委任払_申請書.get名称(), is(new RString("介護保険高額介護（予防）サービス費支給（受領委任払）申請書")));
    }

    @Test
    public void 高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書を指定した場合_get名称は_高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書.get名称(), is(new RString("高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書")));
    }

    @Test
    public void 介護保険助成金給付申請書を指定した場合_get名称は_介護保険助成金給付申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険助成金給付申請書.get名称(), is(new RString("介護保険助成金給付申請書")));
    }

    @Test
    public void 介護保険給付費借入申請書を指定した場合_get名称は_介護保険給付費借入申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険給付費借入申請書.get名称(), is(new RString("介護保険給付費借入申請書")));
    }

    @Test
    public void 介護保険給付費貸付金償還期限延長申請書を指定した場合_get名称は_介護保険給付費貸付金償還期限延長申請書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険給付費貸付金償還期限延長申請書.get名称(), is(new RString("介護保険給付費貸付金償還期限延長申請書")));
    }

    @Test
    public void 第三者行為による被害届_介護保険用を指定した場合_get名称は_第三者行為による被害届_介護保険用を返す() {
        assertThat(ShinseishoChohyoShurui.第三者行為による被害届_介護保険用.get名称(), is(new RString("第三者行為による被害届（介護保険用）")));
    }

    @Test
    public void 介護保険給付の支払処分弁明書を指定した場合_get名称は_介護保険給付の支払処分弁明書を返す() {
        assertThat(ShinseishoChohyoShurui.介護保険給付の支払処分弁明書.get名称(), is(new RString("介護保険給付の支払処分弁明書")));
    }

}
