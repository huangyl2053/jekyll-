/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchotaishoshadotei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 特徴対象者同定（一括）のバッチ起動時に設定される<br>
 * 同定情報を取得するパラメータ
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GetDoteiJohoProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 処理年度;
    private RString 開始月;
    private RDateTime 処理日時;

    /**
     * コンストラクタです。
     *
     *
     * @param 処理年度 FlexibleYear
     * @param 開始月 RString
     * @param 処理日時 RDateTime
     */
    public GetDoteiJohoProcessParameter(FlexibleYear 処理年度, RString 開始月, RDateTime 処理日時) {
        this.処理年度 = 処理年度;
        this.開始月 = 開始月;
        this.処理日時 = 処理日時;
    }

    /**
     * コンストラクタです。
     *
     *
     */
    public GetDoteiJohoProcessParameter() {
    }

}
