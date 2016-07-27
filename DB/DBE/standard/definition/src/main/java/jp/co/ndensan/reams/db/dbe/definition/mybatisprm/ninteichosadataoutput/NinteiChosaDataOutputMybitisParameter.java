/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 認定調査データ出力（モバイル）ですためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class NinteiChosaDataOutputMybitisParameter implements IMyBatisParameter {

    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();
    private final RString ninteichosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final Decimal maxCount;
    private final RString shichosonCode;
    private final boolean isNinteichosaItakusakiCode;
    private final boolean isNinteiChosainCode;
    private final boolean isShichoson;

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 最大表示件数 最大表示件数
     * @param 市町村コード 市町村コード
     * @param is認定調査委託先コード is認定調査委託先コード
     * @param is認定調査員コード is認定調査員コード
     * @param is全市町村 is全市町村
     */
    private NinteiChosaDataOutputMybitisParameter(RString 認定調査委託先コード,
            RString 認定調査員コード,
            Decimal 最大表示件数,
            RString 市町村コード,
            boolean is認定調査委託先コード,
            boolean is認定調査員コード,
            boolean is全市町村) {
        this.ninteichosaItakusakiCode = 認定調査委託先コード;
        this.ninteiChosainCode = 認定調査員コード;
        this.maxCount = 最大表示件数;
        this.shichosonCode = 市町村コード;
        this.isNinteichosaItakusakiCode = is認定調査委託先コード;
        this.isNinteiChosainCode = is認定調査員コード;
        this.isShichoson = is全市町村;
    }

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 最大表示件数 最大表示件数
     * @param 市町村コード 市町村コード
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public static NinteiChosaDataOutputMybitisParameter createSelectByKeyParam(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            Decimal 最大表示件数,
            RString 市町村コード) {

        boolean is認定調査委託先コード = false;
        boolean is認定調査員コード = false;
        boolean is全市町村 = false;

        if (!RString.isNullOrEmpty(認定調査委託先コード)) {
            is認定調査委託先コード = true;
        }
        if (!RString.isNullOrEmpty(認定調査委託先コード) && !RString.isNullOrEmpty(認定調査員コード)) {
            is認定調査員コード = true;
        }
        if (RString.isNullOrEmpty(市町村コード)) {
            is全市町村 = true;
        }
        return new NinteiChosaDataOutputMybitisParameter(認定調査委託先コード,
                認定調査員コード,
                最大表示件数,
                市町村コード,
                is認定調査委託先コード,
                is認定調査員コード,
                is全市町村);
    }
}
