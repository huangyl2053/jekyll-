/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5610001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新対象者抽出(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
@lombok.Getter

@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinTaishoshaKanriMyBatisParameter implements IMyBatisParameter {

    private final boolean 前回以降の未処理分;
    private final boolean 有効期間終了日を範囲指定する;
    private final FlexibleDate 有効期間終了日From;
    private final FlexibleDate 有効期間終了日To;
    private final RString 対象月;
    private final RString shoriJotaiKubun;

    /**
     *
     * @param 前回以降の未処理分 前回以降の未処理分
     * @param 有効期間終了日を範囲指定する 有効期間終了日を範囲指定する
     * @param 有効期間終了日From 有効期間終了日From
     * @param 有効期間終了日To 有効期間終了日To
     * @param 対象月 対象月
     * @param shoriJotaiKubun shoriJotaiKubun
     */
    public KoshinTaishoshaKanriMyBatisParameter(boolean 前回以降の未処理分,
            boolean 有効期間終了日を範囲指定する, FlexibleDate 有効期間終了日From, FlexibleDate 有効期間終了日To, RString 対象月, RString shoriJotaiKubun) {
        this.前回以降の未処理分 = 前回以降の未処理分;
        this.有効期間終了日を範囲指定する = 有効期間終了日を範囲指定する;
        this.有効期間終了日From = 有効期間終了日From;
        this.有効期間終了日To = 有効期間終了日To;
        this.対象月 = 対象月;
        this.shoriJotaiKubun = shoriJotaiKubun;
    }

}
