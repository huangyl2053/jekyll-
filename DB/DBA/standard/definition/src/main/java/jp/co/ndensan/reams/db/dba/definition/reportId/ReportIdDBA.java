/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.reportId;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票ＩＤの列挙型です。
 */
public enum ReportIdDBA {

    /**
     * 境界層管理マスタリストの帳票ID。
     */
    DBA200005(new ReportId("DBA200005"), new RString("境界層管理マスタリスト")),
    /**
     * 広域内住所地特例者一覧表の帳票ID。
     */
    DBA200013(new ReportId("DBA200013"), new RString("広域内住所地特例者一覧表")),
    /**
     * 被保険者証発行一覧表の帳票ＩＤです。
     */
    DBA200003(new ReportId("DBA200003"), new RString("被保険者証発行一覧表")),
    /**
     * 介護保険被保険者証（B4版）の帳票ＩＤです。
     */
    DBA100001(new ReportId("DBA100001_HihokenshashoB4"), new RString("介護保険被保険者証（B4版）")),
    /**
     * 介護保険資格取得・異動・喪失届の帳票ＩＤです。
     */
    DBA800001(new ReportId("DBA800001_ShikakushutokuIdoSoshitsuTodoke"), new RString("介護保険資格取得・異動・喪失届")),
    /**
     * 介護保険被保険者証の帳票ＩＤです。
     */
    DBA100002(new ReportId("DBA100002_HihokenshashoA4"), new RString("介護保険被保険者証")),
    /**
     * 広域内転居結果一覧表の帳票ID。
     */
    DBA200011(new ReportId("DBA200011_KoikinaiTenkyoKekkaIchiranhyo"), new RString("広域内転居結果一覧表")),
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
     * 介護保険住所地特例適用・変更・終了届の帳票ＩＤです。
     */
    DBA800003(new ReportId("DBA800003_HihokenshashoSaikoufuShinseisho"), new RString("介護保険被保険者証等再交付申請書"));
    
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
