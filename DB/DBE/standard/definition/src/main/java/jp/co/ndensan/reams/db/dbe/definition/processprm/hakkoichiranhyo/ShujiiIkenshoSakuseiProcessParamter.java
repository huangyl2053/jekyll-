/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoSakuseiMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書作成依頼発行一覧表ですためのProcess用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenshoSakuseiProcessParamter implements IBatchProcessParameter {

    private final RString iraiFromYMD;
    private final RString iraiToYMD;
    private final RString hihokenshaNo;
    private final RString shujiiIkenshoSakuseiIraisho;
    private final RString shujiiIkensho;
    private final List<RString> shujiiIryokikanCodeList;
    private final List<RString> shujiiCodeList;

    /**
     * コンストラクタです。
     *
     * @param 依頼日From 依頼日From
     * @param 依頼日To 依頼日To
     * @param 保険者番号 保険者番号
     * @param 主治医意見書作成依頼書 主治医意見書作成依頼書
     * @param 主治医意見書 主治医意見書
     * @param 主治医医療機関コードリスト 主治医医療機関コードリスト
     * @param 主治医コードリスト 主治医コードリスト
     */
    public ShujiiIkenshoSakuseiProcessParamter(RString 依頼日From,
            RString 依頼日To,
            RString 保険者番号,
            RString 主治医意見書作成依頼書,
            RString 主治医意見書,
            List<RString> 主治医医療機関コードリスト,
            List<RString> 主治医コードリスト) {
        this.iraiFromYMD = 依頼日From;
        this.iraiToYMD = 依頼日To;
        this.hihokenshaNo = 保険者番号;
        this.shujiiIkenshoSakuseiIraisho = 主治医意見書作成依頼書;
        this.shujiiIkensho = 主治医意見書;
        this.shujiiIryokikanCodeList = 主治医医療機関コードリスト;
        this.shujiiCodeList = 主治医コードリスト;

    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiMybitisParamter
     */
    public ShujiiIkenshoSakuseiMybitisParamter toShujiiIkenshoSakuseiMybitisParamter() {
        return ShujiiIkenshoSakuseiMybitisParamter.createSelectByKeyParam(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                shujiiIkenshoSakuseiIraisho,
                shujiiIkensho,
                shujiiIryokikanCodeList,
                shujiiCodeList);
    }
}
