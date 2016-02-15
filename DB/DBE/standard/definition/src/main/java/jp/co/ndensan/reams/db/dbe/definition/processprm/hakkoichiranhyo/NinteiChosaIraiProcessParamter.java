/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.NinteiChosaIraiMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査依頼発行一覧表ですためのProcess用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NinteiChosaIraiProcessParamter implements IBatchProcessParameter {

    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hihokenshaNo;
    private final RString ninteiChosaIraisyo;
    private final RString ninteiChosahyo;
    private final List<RString> ninteiChosaItakusakiCodeList;
    private final List<RString> ninteiChosainNoList;

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
     */
    public NinteiChosaIraiProcessParamter(RString 依頼日From,
            RString 依頼日To,
            RString 被保険者番号,
            RString 認定調査依頼書,
            RString 認定調査票,
            List<RString> 認定調査委託先コード,
            List<RString> 認定調査員コード) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.hihokenshaNo = 被保険者番号;
        this.ninteiChosaIraisyo = 認定調査依頼書;
        this.ninteiChosahyo = 認定調査票;
        this.ninteiChosaItakusakiCodeList = 認定調査委託先コード;
        this.ninteiChosainNoList = 認定調査員コード;

    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaIraiMybitisParamter
     */
    public NinteiChosaIraiMybitisParamter toNinteiChosaIraiMybitisParamter() {
        return NinteiChosaIraiMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                ninteiChosaIraisyo,
                ninteiChosahyo,
                ninteiChosaItakusakiCodeList,
                ninteiChosainNoList);
    }
}
