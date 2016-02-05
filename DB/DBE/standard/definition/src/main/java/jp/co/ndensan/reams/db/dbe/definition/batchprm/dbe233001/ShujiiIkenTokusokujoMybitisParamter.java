/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 主治医意見書督促状発行を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShujiiIkenTokusokujoMybitisParamter implements IMyBatisParameter {

    private final FlexibleDate temp_基準日;
    private final RString temp_印刷済対象者;
    private final RString temp_保険者コード;
    private final RString temp_主治医医療機関コード;
    private final RString temp_主治医コード;

    /**
     * コンストラクタです。
     *
     * @param temp_基準日
     * @param temp_印刷済対象者
     * @param temp_保険者コード
     * @param temp_主治医医療機関コード
     * @param temp_主治医コード
     */
    public ShujiiIkenTokusokujoMybitisParamter(
            FlexibleDate temp_基準日,
            RString temp_印刷済対象者,
            RString temp_保険者コード,
            RString temp_主治医医療機関コード,
            RString temp_主治医コード) {
        this.temp_基準日 = temp_基準日;
        this.temp_印刷済対象者 = temp_印刷済対象者;
        this.temp_保険者コード = temp_保険者コード;
        this.temp_主治医医療機関コード = temp_主治医医療機関コード;
        this.temp_主治医コード = temp_主治医コード;
    }
}
