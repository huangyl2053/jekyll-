/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBA-9999-021 xuyannan
 */
public enum ReportIdDBA {

    /**
     * 適用除外者台帳の帳票ID。
     */
    DBA100010(new ReportId("DBA100010_TekiyojogaishaDaicho"), new RString("適用除外者台帳")),
    /**
     * 境界層管理マスタリストの帳票ID。
     */
    DBA200005(new ReportId("DBA200005"), new RString("境界層管理マスタリスト")),
    /**
     * 広域内住所地特例者一覧表の帳票ID。
     */
    DBA200013(new ReportId("DBA200013_KoikinaiJushochitokureishaIchiranhyo"), new RString("広域内住所地特例者一覧表")),
    /**
     * 被保険者証発行一覧表の帳票ＩＤです。
     */
    DBA200003(new ReportId("DBA200003_HihokenshashoHakkoIchiranhyo"), new RString("被保険者証発行一覧表")),
    /**
     * 介護保険被保険者証（B4版）の帳票ＩＤです。
     */
    DBA100001(new ReportId("DBA100001_HihokenshashoB4"), new RString("介護保険被保険者証（B4版）")),
    /**
     * 介護保険資格取得・異動・喪失届の帳票ＩＤです。
     */
    DBA800001(new ReportId("DBA800001_ShikakushutokuIdoSoshitsuTodoke"), new RString("介護保険資格取得・異動・喪失届")),
    /**
     * 介護保険被保険者証交付申請書（第2号被保険者）の帳票ＩＤです。
     */
    DBA800004(new ReportId("DBA800004_HihokenshashokoufuShinseisho"), new RString("介護保険被保険者証交付申請書（第2号被保険者）")),
    /**
     * 介護保険被保険者証の帳票ＩＤです。
     */
    DBA100002(new ReportId("DBA100002_HihokenshashoA4"), new RString("介護保険被保険者証")),
    /**
     * 介護保険資格者証の帳票ＩＤです。
     */
    DBA100003(new ReportId("DBA100003_Shikakushasho"), new RString("介護保険資格者証")),
    /**
     * 介護保険資格者証の帳票ＩＤです。
     */
    DBA100004(new ReportId("DBA100004_JukyuShikakuShomeisho"), new RString("介護保険資格者証")),
    /**
     * 介護保険受給資格証明書交付申請書の帳票ＩＤです。
     */
    DBD800011(new ReportId("DBD800011_JukyuShikakuShomeishokoufuShinseisho"), new RString("介護保険受給資格証明書交付申請書")),
    /**
     * 介護保険受領委任払い取扱事業者登録申請書の帳票ＩＤです。
     */
    DBC800001(new ReportId("DBC800001_JuryoIninharaiToriatsukaiJigyoshaTorokuShinseisho"), new RString("介護保険受給資格証明書交付申請書")),
    /**
     * 支払方法変更（償還払い化）終了申請書の帳票ID。
     */
    DBD800009(new ReportId("DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseisho"), new RString("支払方法変更（償還払い化）終了申請書")),
    /**
     * 介護保険住所地特例適用・変更・終了届の帳票ＩＤです。
     */
    DBA800002(new ReportId("DBA800002_JyushochiTokureiTekiyoHenkoShuryoTodoke"), new RString("介護保険受給資格証明書交付申請書")),
    /**
     * 介護保険被保険者証等再交付申請書の帳票ＩＤです。
     */
    DBA800003(new ReportId("DBA800003_HihokenshashoSaikoufuShinseisho"), new RString("介護保険被保険者証等再交付申請書")),
    /**
     * 被保険者証発行管理一覧表の帳票ＩＤです。
     */
    DBA200004(new ReportId("DBA200004_HihokenshashoHakkoKanriIchiranhyo"), new RString("被保険者証発行管理一覧表")),
    /**
     * 介護保険被保険者証等再交付申請書の帳票ＩＤです。
     */
    DBD800001(new ReportId("DBD800001_FutangendogakuNinteiShinseisho"), new RString("介護保険負担限度額認定申請書")),
    /**
     * 介護保険被保険者証交付申請書（第2号被保険者）の帳票ＩＤです。
     */
    DBD800004(new ReportId("DBD800004_TokuteiFutangendogakuShinseisho"), new RString("介護保険特定負担限度額申請書")),
    /**
     * 介護保険給付費貸付金償還期限延長申請書の帳票ＩＤです。
     */
    DBC800011(new ReportId("DBC800011_JutakuKaishuhiJizenShinseishoJuryoIninHarai"),
            new RString("介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書")),
    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書の帳票ＩＤです。
     */
    DBC800014(new ReportId("DBC800014_KeidoshaFukushiYoguTaiyoKakuninShinseisho"),
            new RString("軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書")),
    /**
     * 介護保険助成金給付申請書の帳票ＩＤです。
     */
    DBC800017(new ReportId("DBC800017_JoseikinKyufuShinseisho"), new RString("介護保険助成金給付申請書")),
    /**
     * 介護保険給付費貸付金償還期限延長申請書の帳票ＩＤです。
     */
    DBC800019(new ReportId("DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho"), new RString("介護保険給付費貸付金償還期限延長申請書")),
    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2の帳票ＩＤです。
     */
    DBC800021(new ReportId("DBC800021_KeidoshaFukushiYoguTaiyoKakuninShinseisho2"),
            new RString("軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2")),
    /**
     * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書の帳票ＩＤです。
     */
    DBC800012(new ReportId("DBC800012_JutakuKaishuhiShikyuShinseishoJuryoIninHarai"),
            new RString("介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書")),
    /**
     * 介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書の帳票ＩＤです。
     */
    DBC800013(new ReportId("DBC800013_FukushiYoguKonyuhiShinseishoJuryoIninHarai"),
            new RString("介護保険居宅介護（予防）福祉用具購入費支給（受領委任払）申請書")),
    /**
     * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書の帳票ＩＤです。
     */
    DBC800015(new ReportId("DBC800015_KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyo"),
            new RString("介護保険高額介護（予防）サービス費支給（受領委任払）申請書")),
    /**
     * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書の帳票ＩＤです。
     */
    DBC800016(new ReportId("DBC800016_KogakuGassanKaigoServicehiShikyuKofuShinseisho"),
            new RString("高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書")),
    /**
     * 要介護認定区分変更申請書の帳票ＩＤです。
     */
    DBD501002(new ReportId("DBD501002_yokaigoNinteikbnHenkoShinseisho"),
            new RString("要介護認定区分変更申請書")),
    /**
     * 介護保険料徴収猶予申請書の帳票ＩＤです。
     */
    DBB800002(new ReportId("DBB800002_HokenryoGenmenChoshuYoyuShinseisho"), new RString("介護保険料徴収猶予申請書")),
    /**
     * 介護保険償還払支給申請書の帳票ＩＤです。
     */
    DBC800009(new ReportId("DBC800009_ShokanharaiShikyuShinseisho"), new RString("介護保険償還払支給申請書")),
    /**
     * 介護保険料納付額証明書交付申請書の帳票ＩＤです。
     */
    DBB800003(new ReportId("DBB800003_NofugakuShomeishoKofuShinseisho"), new RString("介護保険料納付額証明書交付申請書")),
    /**
     * 給付額減額免除申請書の帳票ＩＤです。
     */
    DBD800008(new ReportId("DBD800008_KyufugengakuMenjyoShinseisho"), new RString("給付額減額免除申請書")),
    /**
     * 居宅（介護予防）サービス計画作成依頼（変更）届出書の帳票ＩＤです。
     */
    DBC800004(new ReportId("DBC800004_ItakuServiceKeikaluSakuseiIraiTodokedesho"), new RString("居宅（介護予防）サービス計画作成依頼（変更）届出書")),
    /**
     * 介護保険料減免申請書の帳票ＩＤです。
     */
    DBB800001(new ReportId("DBB800001_HokenryoGenmenChoshuYoyuShinseisho"), new RString("介護保険料減免申請書")),
    /**
     * 介護保険償還払受領委任払申請書の帳票ＩＤです。
     */
    DBC800010(new ReportId("DBC800010_ShokanharaiJuryoIninShinseisho"), new RString("介護保険償還払受領委任払申請書")),
    /**
     * 介護保険給付費借入申請書の帳票ＩＤです。
     */
    DBC800018(new ReportId("DBC800018_kyufuhiKariireiShinseisho"), new RString("介護保険給付費借入申請書")),
    /**
     * 第三者行為による被害届（介護保険用）の帳票ＩＤです。
     */
    DBC800020(new ReportId("DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo"), new RString("第三者行為による被害届（介護保険用）")),
    /**
     * 介護保険受領委任払い契約申請書の帳票ＩＤです。
     */
    DBC800002(new ReportId("DBC800002_JuryoIninharaiKeiyakuShinseishoFukushiYogu"), new RString("介護保険受領委任払い契約申請書")),
    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書の帳票ＩＤです。
     */
    DBD800007(new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho"),
            new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書")),
    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書の帳票ＩＤです。
     */
    DBD800007_Back(new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseishoBack"),
            new RString("特別地域加算減免・訪問介護等利用者負担減額対象確認申請書")),
    /**
     * 介護保険住所地特例施設退所通知書の帳票ＩＤです。
     */
    DBA100005(new ReportId("DBA100005_JushochitokureiShisetsuTaishoTsuchisho"), new RString("介護保険住所地特例施設退所通知書")),
    /**
     * 介護保険住所地特例施設変更通知書の帳票ＩＤです。
     */
    DBA100006(new ReportId("DBA100006_JushochitokureiShisetsuHenkoTsuchisho"), new RString("介護保険住所地特例施設変更通知書")),
    /**
     * 介護保険他市町村住所地特例者連絡票の帳票ＩＤです。
     */
    DBA100007(new ReportId("DBA100007_TashichosonJushochitokureishaRenrakuhyo"), new RString("介護保険他市町村住所地特例者連絡票")),
    /**
     * 訪問介護利用者負担額減額申請書の帳票ＩＤです。
     */
    DBD800005(new ReportId("DBD800005_HomonKaigoRiyoshaFutangakuGengakuShinseisho"), new RString("訪問介護利用者負担額減額申請書")),
    /**
     * 年齢到達予定者一覧表の帳票ＩＤです。
     */
    DBA200001(new ReportId("DBA200001_NenreitotatsuYoteishaIchiranhyo"), new RString("年齢到達予定者一覧表")),
    /**
     * 被保険者台帳一覧表の帳票ＩＤです。
     */
    DBA200002(new ReportId("DBA200002_HihokenshaDaichoHakkoIchiranhyo"), new RString("被保険者台帳一覧表")),
    /**
     * 異動チェックリスト帳票の帳票ＩＤです。
     */
    DBA200006(new ReportId("DBA200006_IdoCheckList"), new RString("異動チェックリスト")),
    /**
     * 介護保険　転入・転出未登録一覧表です。
     */
    DBA200014(new ReportId("DBA200014_TennyuTenshutsuMitorokuIchiranhyo"), new RString("介護保険　転入・転出未登録一覧表")),
    /**
     * 被保険者台帳です。
     */
    DBA100009(new ReportId("DBA100009_HihokenshaDaicho"), new RString("被保険者台帳")),
    /**
     * 他市町村住所地特例者台帳の帳票ＩＤです。
     */
    DBA100011(new ReportId("DBA100011_TashichosonJushochitokureishaDaicho"), new RString("他市町村住所地特例者台帳")),
    /**
     * 汎用リスト 被保険者台帳の帳票ＩＤです。
     */
    DBA701001(new ReportId("DBA701001_HanyoListHihokenshaDaicho"), new RString("汎用リスト 被保険者台帳")),
    /**
     * 住基連動登録リストの帳票ＩＤです。
     */
    DBA200007(new ReportId("DBA200007_JukiRendoTorokuList"), new RString("住基連動登録リスト")),
    /**
     * 年齢到達者登録リストの帳票ＩＤです。
     */
    DBA200008(new ReportId("DBA200008_NenreitotatsuKakuninList"), new RString("年齢到達者登録リスト")),
    /**
     * 適用除外者の帳票ＩＤです。
     */
    DBA701003(new ReportId("DBA701003_HanyoListTekiyoJogaisha"), new RString("適用除外者")),
    /**
     * 他市町村住所地特例者の帳票ＩＤです。
     */
    DBA701002(new ReportId("DBA701002_HanyoListTaShichosonJushochiTokureisha"), new RString("他市町村住所地特例者")),
    /**
     * 老齢福祉年金受給者の帳票ＩＤです。
     */
    DBA701004(new ReportId("DBA701004_HanyoListRoreiFukushiNenkinJukyusha"), new RString("老齢福祉年金受給者")),
    /**
     * 生活保護受給者；の帳票ＩＤです。
     */
    DBA701006(new ReportId("DBA701006_HanyoListSeikatsuHogoJukyusha"), new RString("生活保護受給者"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBA(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    /**
     * 帳票ＩＤの取得します。
     *
     * @return 帳票ＩＤ
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票Nameの取得します。
     *
     * @return 帳票Name
     */
    public RString getReportName() {
        return reportName;
    }

}
