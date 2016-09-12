/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyumikonyujyoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBU0600051_総合照会_住民固有情報クラスです。
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JyuMiKoNyuJyoHoParameter {

    private final RString 識別コード;
    private final RString 業務コード;
    private final RString 被保険者番号;

    private JyuMiKoNyuJyoHoParameter(
            RString 識別コード,
            RString 業務コード,
            RString 被保険者番号) {
        this.識別コード = 識別コード;
        this.業務コード = 業務コード;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 識別コード RString
     * @param 業務コード RString
     * @param 被保険者番号 RString
     * @return JyuMiKoNyuJyoHoParameter
     */
    public static JyuMiKoNyuJyoHoParameter createParameter(
            RString 識別コード,
            RString 業務コード,
            RString 被保険者番号) {
        return new JyuMiKoNyuJyoHoParameter(
                識別コード,
                業務コード,
                被保険者番号);
    }
}
