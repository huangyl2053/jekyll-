/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sonotakikanguide;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報の取得するクラスです。
 *
 * @reamsid_L DBE-3000-050 wangkun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SoNoTaKikanGuideParameter {

    private final RString 証記載保険者番号;
    private boolean is証記載保険者番号Flag;
    private final RString その他機関コードFrom;
    private boolean isその他機関コードFromFlag;
    private final RString その他機関コードTo;
    private boolean isその他機関コードToFlag;
    private boolean is含まない;
    private final RString その他機関名称;
    private boolean isその他機関名称Flag;
    private final RString 調査委託先区分;
    private boolean is調査委託先区分Flag;
    private int 最大表示件数 = 0;

    private SoNoTaKikanGuideParameter(
            RString 証記載保険者番号,
            RString その他機関コードFrom,
            RString その他機関コードTo,
            boolean is含まない,
            RString その他機関名称,
            RString 調査委託先区分,
            int 最大表示件数) {

        if (!証記載保険者番号.isEmpty()) {
            this.is証記載保険者番号Flag = true;
        }
        if (!その他機関コードFrom.isEmpty()) {
            this.isその他機関コードFromFlag = true;
        }
        if (!その他機関コードTo.isEmpty()) {
            this.isその他機関コードToFlag = true;
        }
        if (!その他機関名称.isEmpty()) {
            this.isその他機関名称Flag = true;
        }
        if (!調査委託先区分.isEmpty()) {
            this.is調査委託先区分Flag = true;
        }

        this.証記載保険者番号 = 証記載保険者番号;
        this.その他機関コードFrom = その他機関コードFrom;
        this.その他機関コードTo = その他機関コードTo;
        this.is含まない = is含まない;
        this.その他機関名称 = その他機関名称;
        this.調査委託先区分 = 調査委託先区分;
        this.最大表示件数 = 最大表示件数;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 証記載保険者番号 RString
     * @param その他機関コードFrom RString
     * @param その他機関コードTo RString
     * @param is含まない RString
     * @param その他機関名称 RString
     * @param 調査委託先区分 RString
     * @param 最大表示件数 int
     * @return SoNoTaKikanGuideParameter
     */
    public static SoNoTaKikanGuideParameter createその他機関情報の取得キー作成(
            RString 証記載保険者番号,
            RString その他機関コードFrom,
            RString その他機関コードTo,
            boolean is含まない,
            RString その他機関名称,
            RString 調査委託先区分,
            int 最大表示件数) {
        return new SoNoTaKikanGuideParameter(
                証記載保険者番号,
                その他機関コードFrom,
                その他機関コードTo,
                is含まない,
                その他機関名称,
                調査委託先区分,
                最大表示件数);
    }
}
