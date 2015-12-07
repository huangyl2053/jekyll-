package jp.co.ndensan.reams.db.dba.definition.core.shinseishoshurui;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書帳票種類を表す列挙型です。
 *
 */
public enum ShinseishoChohyoShurui {

    /**
     * コード:DBA800001_ShikakushutokuIdoSoshitsuTodoke 名称:介護保険資格取得・異動・喪失届 略称:定義なし
     */
    介護保険資格取得_異動_喪失届("DBA800001_ShikakushutokuIdoSoshitsuTodoke", "介護保険資格取得・異動・喪失届"),
    /**
     * コード:DBA800003_HihokehsnashoSaikoufuShinseisho 名称:介護保険被保険者証等再交付申請書 略称:定義なし
     */
    介護保険被保険者証等再交付申請書("DBA800003_HihokehsnashoSaikoufuShinseisho", "介護保険被保険者証等再交付申請書"),
    /**
     * コード:DBA800004_HihokehsnashoSaikoufuShinseisho2gou 名称:介護保険被保険者証交付申請書（第2号被保険者） 略称:定義なし
     */
    介護保険被保険者証交付申請書_第2号被保険者("DBA800004_HihokehsnashoSaikoufuShinseisho2gou", "介護保険被保険者証交付申請書（第2号被保険者）"),
    /**
     * コード:DBA800002_JyushochiTokureiTekiyoHenkoShuryoTodoke 名称:介護保険住所地特例適用・変更・終了届 略称:定義なし
     */
    介護保険住所地特例適用_変更_終了届("DBA800002_JyushochiTokureiTekiyoHenkoShuryoTodoke", "介護保険住所地特例適用・変更・終了届"),
    /**
     * コード:DBD800011_JukyuShikakuShomeishokoufuShinseisho 名称:介護保険受給資格証明書交付申請書 略称:定義なし
     */
    介護保険受給資格証明書交付申請書("DBD800011_JukyuShikakuShomeishokoufuShinseisho", "介護保険受給資格証明書交付申請書"),
    /**
     * コード:DBB800001_HokenryoGenmenShinseisho 名称:介護保険料減免申請書 略称:定義なし
     */
    介護保険料減免申請書("DBB800001_HokenryoGenmenShinseisho", "介護保険料減免申請書"),
    /**
     * コード:DBB800002_HokenryoChoshuYoyuShinseisho 名称:介護保険料徴収猶予申請書 略称:定義なし
     */
    介護保険料徴収猶予申請書("DBB800002_HokenryoChoshuYoyuShinseisho", "介護保険料徴収猶予申請書"),
    /**
     * コード:DBB800003_NofugakuShomeishoKofuShinseisho 名称:介護保険料納付額証明書交付申請書 略称:定義なし
     */
    介護保険料納付額証明書交付申請書("DBB800003_NofugakuShomeishoKofuShinseisho", "介護保険料納付額証明書交付申請書"),
    /**
     * コード:DBD800001_FutangendogakuNinteiShinseisho 名称:介護保険負担限度額認定申請書 略称:定義なし
     */
    介護保険負担限度額認定申請書("DBD800001_FutangendogakuNinteiShinseisho", "介護保険負担限度額認定申請書"),
    /**
     * コード:DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho 名称:介護保険利用者負担額減額・免除申請書 略称:定義なし
     */
    介護保険利用者負担額減額_免除申請書("DBD800002_RiyoshaFutangakuGengakuMenjyoShinseisho", "介護保険利用者負担額減額・免除申請書"),
    /**
     * コード:DBD800003_RiyoshaFutangakuGengakuMenjyoShinseishoKyusochisha 名称:介護保険利用者負担額減額・免除申請書(旧措置者用） 略称:定義なし
     */
    介護保険利用者負担額減額_免除申請書_旧措置者用("DBD800003_RiyoshaFutangakuGengakuMenjyoShinseishoKyusochisha", "介護保険利用者負担額減額・免除申請書(旧措置者用）"),
    /**
     * コード:DBD800004_TokuteiFutangendogakuShinseisho 名称:介護保険特定負担限度額申請書 略称:定義なし
     */
    介護保険特定負担限度額申請書("DBD800004_TokuteiFutangendogakuShinseisho", "介護保険特定負担限度額申請書"),
    /**
     * コード:DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho 名称:訪問介護利用者負担額減額申請書 略称:定義なし
     */
    訪問介護利用者負担額減額申請書("DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho", "訪問介護利用者負担額減額申請書"),
    /**
     * コード:DBD800006_ShakaifukushihojinRiyoshaFutangakuKeigentaishoShinseisho 名称:社会福祉法人等利用者負担軽減対象確認申請書 略称:定義なし
     */
    社会福祉法人等利用者負担軽減対象確認申請書("DBD800006_ShakaifukushihojinRiyoshaFutangakuKeigentaishoShinseisho", "社会福祉法人等利用者負担軽減対象確認申請書"),
    /**
     * コード:DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho 名称:特別地域加算減免・訪問介護等利用者負担減額対象確認申請書 略称:定義なし
     */
    特別地域加算減免_訪問介護等利用者負担減額対象確認申請書("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho", "特別地域加算減免・訪問介護等利用者負担減額対象確認申請書"),
    /**
     * コード:DBD800008_TokubetsuChiikiKasanGenmenTaishoShinseisho 名称:給付額減額免除申請書 略称:定義なし
     */
    給付額減額免除申請書("DBD800008_TokubetsuChiikiKasanGenmenTaishoShinseisho", "給付額減額免除申請書"),
    /**
     * コード:DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseisho 名称:支払方法変更（償還払い化）終了申請書 略称:定義なし
     */
    支払方法変更_償還払い化_終了申請書("DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseisho", "支払方法変更（償還払い化）終了申請書"),
    /**
     * コード:DBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseisho 名称:介護保険受領委任払い取扱事業者登録申請書 略称:定義なし
     */
    介護保険受領委任払い取扱事業者登録申請書("DBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseisho", "介護保険受領委任払い取扱事業者登録申請書"),
    /**
     * コード:DBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYogu 名称:介護保険受領委任払い契約申請書(福祉用具） 略称:定義なし
     */
    介護保険受領委任払い契約申請書_福祉用具("DBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYogu", "介護保険受領委任払い契約申請書(福祉用具）"),
    /**
     * コード:DBC800003_JuryoIninharaiKeiyakuShinseishoJutakuKaishu 名称:介護保険受領委任払い契約申請書(住宅改修） 略称:定義なし
     */
    介護保険受領委任払い契約申請書_住宅改修("DBC800003_JuryoIninharaiKeiyakuShinseishoJutakuKaishu", "介護保険受領委任払い契約申請書(住宅改修）"),
    /**
     * コード:DBC800004_ItakuServiceKeikaluSakuseiIraiTodokedesho 名称:居宅（介護予防）サービス計画作成依頼（変更）届出書 略称:定義なし
     */
    居宅_介護予防_サービス計画作成依頼_変更_届出書("DBC800004_ItakuServiceKeikaluSakuseiIraiTodokedesho", "居宅（介護予防）サービス計画作成依頼（変更）届出書"),
    /**
     * コード:DBC800008_ItakuKaigoServiceKeikakuJikoSakusei 名称:介護保険居宅介護サービス計画の作成（自己作成） 略称:定義なし
     */
    介護保険居宅介護サービス計画の作成_自己作成("DBC800008_ItakuKaigoServiceKeikakuJikoSakusei", "介護保険居宅介護サービス計画の作成（自己作成）"),
    /**
     * コード:DBC800005_FukushiYoguKonyuhiShinseisho 名称:福祉用具購入費申請書 略称:定義なし
     */
    福祉用具購入費申請書("DBC800005_FukushiYoguKonyuhiShinseisho", "福祉用具購入費申請書"),
    /**
     * コード:DBC800006_JutakuKaishuhiShikyuShinseishoJizen 名称:住宅改修費事前支給申請書 略称:定義なし
     */
    住宅改修費事前支給申請書("DBC800006_JutakuKaishuhiShikyuShinseishoJizen", "住宅改修費事前支給申請書"),
    /**
     * コード:DBC800007_JutakuKaishuhiShikyuShinseisho 名称:住宅改修費支給申請書 略称:定義なし
     */
    住宅改修費支給申請書("DBC800007_JutakuKaishuhiShikyuShinseisho", "住宅改修費支給申請書"),
    /**
     * コード:DBC800009_ShokanharaiShikyuShinseisho 名称:介護保険償還払支給申請書 略称:定義なし
     */
    介護保険償還払支給申請書("DBC800009_ShokanharaiShikyuShinseisho", "介護保険償還払支給申請書"),
    /**
     * コード:DBC800010_ShokanharaiJuryoIninShinseisho 名称:介護保険償還払受領委任払申請書 略称:定義なし
     */
    介護保険償還払受領委任払申請書("DBC800010_ShokanharaiJuryoIninShinseisho", "介護保険償還払受領委任払申請書"),
    /**
     * コード:DBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHarai 名称:介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書 略称:定義なし
     */
    介護保険居宅介護_予防_住宅改修費事前_受領委任払_申請書("DBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHarai", "介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書"),
    /**
     * コード:DBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHarai 名称:介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書 略称:定義なし
     */
    介護保険居宅介護_予防_住宅改修費支給_受領委任払_申請書("DBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHarai", "介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書"),
    /**
     * コード:DBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHarai 名称:介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書 略称:定義なし
     */
    介護保険居宅介護_予防_福祉用具購入費支給_受領委任払_申請書("DBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHarai", "介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書"),
    /**
     * コード:DBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseisho 名称:軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書 略称:定義なし
     */
    軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書("DBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseisho", "軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書"),
    /**
     * コード:DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo 名称:介護保険高額介護（予防）サービス費支給（受領委任払）申請書 略称:定義なし
     */
    介護保険高額介護_予防_サービス費支給_受領委任払_申請書("DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo", "介護保険高額介護（予防）サービス費支給（受領委任払）申請書"),
    /**
     * コード:DBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseisho 名称:高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書 略称:定義なし
     */
    高額医療合算介護_介護予防_サービス費支給兼自己負担額証明書交付申請書("DBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseisho", "高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書"),
    /**
     * コード:DBC800017_JoseikinKyufuShinseisho 名称:介護保険助成金給付申請書 略称:定義なし
     */
    介護保険助成金給付申請書("DBC800017_JoseikinKyufuShinseisho", "介護保険助成金給付申請書"),
    /**
     * コード:DBC800018_kyufuhiKariireiShinseisho 名称:介護保険給付費借入申請書 略称:定義なし
     */
    介護保険給付費借入申請書("DBC800018_kyufuhiKariireiShinseisho", "介護保険給付費借入申請書"),
    /**
     * コード:DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho 名称:介護保険給付費貸付金償還期限延長申請書 略称:定義なし
     */
    介護保険給付費貸付金償還期限延長申請書("DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho", "介護保険給付費貸付金償還期限延長申請書"),
    /**
     * コード:DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo 名称:第三者行為による被害届（介護保険用） 略称:定義なし
     */
    第三者行為による被害届_介護保険用("DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo", "第三者行為による被害届（介護保険用）"),
    /**
     * コード:DBD800010_ShiharaiShobunBenmeisho 名称:介護保険給付の支払処分弁明書 略称:定義なし
     */
    介護保険給付の支払処分弁明書("DBD800010_ShiharaiShobunBenmeisho", "介護保険給付の支払処分弁明書");

    private final RString code;
    private final RString fullName;

    private ShinseishoChohyoShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請書帳票種類のコードを返します。
     *
     * @return 申請書帳票種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請書帳票種類の名称を返します。
     *
     * @return 申請書帳票種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請書帳票種類のコードと一致する内容を探します。
     *
     * @param code 申請書帳票種類のコード
     * @return {@code code} に対応する申請書帳票種類
     */
    public static ShinseishoChohyoShurui toValue(RString code) {
        for (ShinseishoChohyoShurui shinseishoChohyoShurui : ShinseishoChohyoShurui.values()) {
            if (shinseishoChohyoShurui.code.equals(code)) {
                return shinseishoChohyoShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請書帳票種類"));
    }
}
