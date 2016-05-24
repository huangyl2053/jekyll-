/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nenreitotatsushikakuidochoshuhohokoshin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 65歳年齢到達資格異動徴収方法更新 MybatisParameter
 *
 * @reamsid_L DBB-9210-010 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam implements IMyBatisParameter {

    private RString 被保険者区分コード;
    private FlexibleDate 対象開始年月日;
    private FlexibleDate 対象終了年月日;
    private RString 異動事由コード;

    /**
     * コンストラクタです。
     */
    public NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam() {
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者区分コード RString
     * @param 対象開始年月日 FlexibleDate
     * @param 対象終了年月日 FlexibleDate
     * @param 異動事由コード RString
     */
    NenreitotatsuShikakuIdoChoshuhohoKoshinMybatisParam(RString 被保険者区分コード,
            FlexibleDate 対象開始年月日,
            FlexibleDate 対象終了年月日,
            RString 異動事由コード) {
        this.被保険者区分コード = 被保険者区分コード;
        this.対象開始年月日 = 対象開始年月日;
        this.対象終了年月日 = 対象終了年月日;
        this.異動事由コード = 異動事由コード;
    }
}
