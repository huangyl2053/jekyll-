/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519002;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 要介護認定関連データ作成SQLパラメータクラスです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RenekeiDataSakuseiMyBatisParameter implements IMyBatisParameter {

    private RDateTime 今回処理日時開始日時の年月日時分秒;
    private RDateTime 今回処理日時終了日時の年月日時分秒;
    private Code 外部出力データ区分;

    /**
     * コンストラクタです。
     *
     * @param 今回処理日時開始日時の年月日時分秒 今回処理日時開始日時の年月日時分秒
     * @param 今回処理日時終了日時の年月日時分秒 今回処理日時終了日時の年月日時分秒
     */
    public RenekeiDataSakuseiMyBatisParameter(RDateTime 今回処理日時開始日時の年月日時分秒, RDateTime 今回処理日時終了日時の年月日時分秒) {
        this.今回処理日時開始日時の年月日時分秒 = 今回処理日時開始日時の年月日時分秒;
        this.今回処理日時終了日時の年月日時分秒 = 今回処理日時終了日時の年月日時分秒;
    }

    /**
     * コンストラクタです。
     *
     * @param 外部出力データ区分 外部出力データ区分
     */
    public RenekeiDataSakuseiMyBatisParameter(Code 外部出力データ区分) {
        this.外部出力データ区分 = 外部出力データ区分;
    }

}
