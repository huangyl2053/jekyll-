/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定外部データ出力履歴登録(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsNinteiGaibuDataOutputHistoryMybitsParameter implements IMyBatisParameter {

    private final RString 出力データ区分;
    private final FlexibleDate システム日付;

    /**
     * コンストラクタ。
     *
     * @param 出力データ区分 RString
     */
    public InsNinteiGaibuDataOutputHistoryMybitsParameter(RString 出力データ区分) {
        this.出力データ区分 = 出力データ区分;
        this.システム日付 = FlexibleDate.getNowDate();
    }

}
