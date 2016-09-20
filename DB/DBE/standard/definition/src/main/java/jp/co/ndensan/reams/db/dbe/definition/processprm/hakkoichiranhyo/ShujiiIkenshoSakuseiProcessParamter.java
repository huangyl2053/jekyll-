/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoSakuseiMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼発行一覧表ですためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0080-150 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenshoSakuseiProcessParamter implements IBatchProcessParameter {

    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString shujiiIkenshoSakuseiIraisho;
    private final RString shujiiIkensho;
    private final List<GridParameter> shujiiIkenshoSakuseiIraiList;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 主治医意見書作成依頼書 主治医意見書作成依頼書
     * @param 主治医意見書 主治医意見書
     * @param 主治医意見書作成依頼リスト 主治医意見書作成依頼リスト
     */
    public ShujiiIkenshoSakuseiProcessParamter(RString 依頼日From,
            RString 依頼日To,
            RString 主治医意見書作成依頼書,
            RString 主治医意見書,
            List<GridParameter> 主治医意見書作成依頼リスト) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.shujiiIkenshoSakuseiIraisho = 主治医意見書作成依頼書;
        this.shujiiIkensho = 主治医意見書;
        this.shujiiIkenshoSakuseiIraiList = 主治医意見書作成依頼リスト;

    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public ShujiiIkenshoSakuseiMybitisParamter toShujiiIkenshoSakuseiMybitisParamter() {
        return ShujiiIkenshoSakuseiMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                shujiiIkenshoSakuseiIraisho,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList);
    }
}
