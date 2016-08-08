/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報登録のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HousholdParameter {

    private FlexibleYear 年度;
    private boolean is年度NotNull;
    private HihokenshaNo 被保険者番号;
    private boolean is被保険者番号NotNull;
    private RString 対象年;
    private boolean is対象年NotNull;
    private RString 年金保険者コード;
    private boolean is年金保険者コードNotNull;
    private RString 基礎年金番号;
    private boolean is基礎年金番号NotNull;
    private RString 年金コード;
    private boolean is年金コードNotNull;

    /**
     * コンストラクタです。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 対象年 対象年
     * @param 年金保険者コード 年金保険者コード
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     */
    public HousholdParameter(FlexibleYear 年度, HihokenshaNo 被保険者番号,
            RString 対象年, RString 年金保険者コード, RString 基礎年金番号, RString 年金コード) {
        this.年度 = 年度;
        this.is年度NotNull = null != 年度;
        this.対象年 = 対象年;
        this.is対象年NotNull = null != 対象年;
        this.被保険者番号 = 被保険者番号;
        this.is被保険者番号NotNull = null != 被保険者番号;
        this.年金保険者コード = 年金保険者コード;
        this.is年金保険者コードNotNull = null != 年金保険者コード;
        this.基礎年金番号 = 基礎年金番号;
        this.is基礎年金番号NotNull = null != 基礎年金番号;
        this.年金コード = 年金コード;
        this.is年金コードNotNull = null != 年金コード;
    }

}
