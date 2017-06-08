/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * センター送信Csvデータ出力情報ビジネスクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionRecord {

    private ApplicationsResultMain csvBusiness;
    private int 枝番;
    private List<ExaminationsPartialResult> 主治医意見書;
    private List<ExaminationsPartialResult> サービスの状況;
    private List<ExaminationsPartialResult> 調査票調査項目;
    private List<ExaminationsPartialResult> 前回調査票調査項目;
    private List<ExaminationsPartialResult> 前回サービスの状況;

    /**
     * @param main {@link ApplicationsResultMain}
     * @param 枝番 枝番
     */
    public CenterTransmissionRecord(ApplicationsResultMain main, int 枝番) {
        this.csvBusiness = main;
        this.枝番 = 枝番;
        this.主治医意見書 = new ArrayList<>();
        this.サービスの状況 = new ArrayList<>();
        this.調査票調査項目 = new ArrayList<>();
        this.前回調査票調査項目 = new ArrayList<>();
        this.前回サービスの状況 = new ArrayList<>();
    }

    /**
     * @return 枝番
     */
    public RString get枝番AsRString() {
        return new RString(this.枝番);
    }

    /**
     * @return 前回の認定が存在する場合、{@code true}.
     */
    public boolean has前回結果() {
        return !RString.isNullOrEmpty(getCsvBusiness().getCreateCsvDataBusiness().get前回結果_申請日());
    }

    /**
     * @return 今回の認定調査結果が存在する場合、{@code true}.
     */
    public boolean has今回調査結果() {
        return !RString.isNullOrEmpty(getCsvBusiness().get現在のサービス区分コード());
    }

    /**
     * @return 前回の認定調査結果が存在する場合、{@code true}.
     */
    public boolean has前回調査結果() {
        return !RString.isNullOrEmpty(getCsvBusiness().getCreateCsvDataBusiness().get前回結果_現在のサービス区分コード());
    }

    /**
     * @return 転入申請の場合、{@code true}.
     */
    public boolean is転入申請() {
        return java.util.Objects.equals(NinteiShinseiShinseijiKubunCode.転入申請.getコード(), getCsvBusiness().get申請区分申請時コード());
    }

}
