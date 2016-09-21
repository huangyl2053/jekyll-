/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.NinteiChosaIraiMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査依頼発行一覧表ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NinteiChosaIraiProcessParamter implements IBatchProcessParameter {

    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString ninteiChosaIraisyo;
    private final RString ninteiChosahyo;
    private final List<GridParameter> ninteiChosaIraiList;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 認定調査依頼書 認定調査依頼書
     * @param 認定調査票 認定調査票
     * @param 認定調査依頼リスト 認定調査依頼リスト
     */
    public NinteiChosaIraiProcessParamter(RString 依頼日From,
            RString 依頼日To,
            RString 認定調査依頼書,
            RString 認定調査票,
            List<GridParameter> 認定調査依頼リスト) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.ninteiChosaIraisyo = 認定調査依頼書;
        this.ninteiChosahyo = 認定調査票;
        this.ninteiChosaIraiList = 認定調査依頼リスト;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return NinteiChosaIraiMybitisParamter
     */
    public NinteiChosaIraiMybitisParamter toNinteiChosaIraiMybitisParamter() {
        return NinteiChosaIraiMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                ninteiChosaIraisyo,
                ninteiChosahyo,
                ninteiChosaIraiList);
    }
}
