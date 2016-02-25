/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 訪問調査依頼書発行ですためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class HomonChosaIraishoMybitisParamter implements IMyBatisParameter {

    private static final RString 未印刷 = new RString("1");
    private static final RString 印刷済 = new RString("2");
    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hihokenshaNo;
    private final RString ninteiChosaIraisyo;
    private final RString ninteiChosahyo;
    private final List<RString> ninteiChosaItakusakiCodeList;
    private final List<RString> ninteiChosainNoList;
    private final boolean is認定調査依頼書未印刷;
    private final boolean is認定調査依頼書印刷済;
    private final boolean is認定調査票未印刷;
    private final boolean is認定調査票印刷済;
    private final boolean is依頼日From;
    private final boolean is依頼日To;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 被保険者番号 被保険者番号
     * @param 認定調査依頼書 認定調査依頼書
     * @param 認定調査票 認定調査票
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param is認定調査依頼書未印刷 is認定調査依頼書未印刷
     * @param is認定調査依頼書印刷済 is認定調査依頼書印刷済
     * @param is認定調査票未印刷 is認定調査票未印刷
     * @param is認定調査票印刷済 is認定調査票印刷済
     */
    private HomonChosaIraishoMybitisParamter(RString 依頼日From,
            RString 依頼日To,
            RString 被保険者番号,
            RString 認定調査依頼書,
            RString 認定調査票,
            List<RString> 認定調査委託先コード,
            List<RString> 認定調査員コード,
            boolean is認定調査依頼書未印刷,
            boolean is認定調査依頼書印刷済,
            boolean is認定調査票未印刷,
            boolean is認定調査票印刷済,
            boolean is依頼日From,
            boolean is依頼日To) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.hihokenshaNo = 被保険者番号;
        this.ninteiChosaIraisyo = 認定調査依頼書;
        this.ninteiChosahyo = 認定調査票;
        this.ninteiChosaItakusakiCodeList = 認定調査委託先コード;
        this.ninteiChosainNoList = 認定調査員コード;
        this.is認定調査依頼書未印刷 = is認定調査依頼書未印刷;
        this.is認定調査依頼書印刷済 = is認定調査依頼書印刷済;
        this.is認定調査票未印刷 = is認定調査票未印刷;
        this.is認定調査票印刷済 = is認定調査票印刷済;
        this.is依頼日From = is依頼日From;
        this.is依頼日To = is依頼日To;
    }

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 被保険者番号 被保険者番号
     * @param 認定調査依頼書 認定調査依頼書
     * @param 認定調査票 認定調査票
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public static HomonChosaIraishoMybitisParamter createSelectByKeyParam(RString 依頼日From,
            RString 依頼日To,
            RString 被保険者番号,
            RString 認定調査依頼書,
            RString 認定調査票,
            List<RString> 認定調査委託先コード,
            List<RString> 認定調査員コード) {

        boolean is依頼書未印刷 = false;
        boolean is依頼書印刷済 = false;
        boolean is未印刷 = false;
        boolean is印刷済 = false;
        boolean is依頼日From = false;
        boolean is依頼日To = false;

        if (!RString.isNullOrEmpty(依頼日From)) {
            is依頼日From = true;
        }
        if (!RString.isNullOrEmpty(依頼日To)) {
            is依頼日To = true;
        }
        if (!RString.isNullOrEmpty(認定調査依頼書) && 認定調査依頼書.equals(未印刷)) {
            is依頼書未印刷 = true;
        }
        if (!RString.isNullOrEmpty(認定調査依頼書) && 認定調査依頼書.equals(印刷済)) {
            is依頼書印刷済 = true;
        }
        if (!RString.isNullOrEmpty(認定調査票) && 認定調査票.equals(未印刷)) {
            is未印刷 = true;
        }
        if (!RString.isNullOrEmpty(認定調査票) && 認定調査票.equals(印刷済)) {
            is印刷済 = true;
        }
        return new HomonChosaIraishoMybitisParamter(依頼日From,
                依頼日To,
                被保険者番号,
                認定調査依頼書,
                認定調査票,
                認定調査委託先コード,
                認定調査員コード,
                is依頼書未印刷,
                is依頼書印刷済,
                is未印刷,
                is印刷済,
                is依頼日From,
                is依頼日To);
    }
}
