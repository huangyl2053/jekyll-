/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.iryohokenkanyujokyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * dgIryohokenIchiran_Row のクラスファイル。
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 *
 */
public class IryohokenRirekiCommonChildDivDate {

    private RString state;
    private FlexibleDate kanyuDate;
    private FlexibleDate dattaiDate;

    /**
     * コンストラクタです.
     *
     */
    public IryohokenRirekiCommonChildDivDate() {
        super();

        this.state = RString.EMPTY;
        this.kanyuDate = FlexibleDate.EMPTY;
        this.dattaiDate = FlexibleDate.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param state コード
     * @param kanyuDate 医療保険加入年月日
     * @param dattaiDate 医療保険脱退年月日
     */
    public IryohokenRirekiCommonChildDivDate(RString state, FlexibleDate kanyuDate, FlexibleDate dattaiDate) {
        this.state = state;
        this.kanyuDate = kanyuDate;
        this.dattaiDate = dattaiDate;

    }

    /**
     * コードのgetメソッドです
     *
     * @return コード
     */
    public RString getState() {
        return state;
    }

    /**
     * 医療保険加入年月日をgetメソッドです。
     *
     * @return 療保険加入年月日
     */
    public FlexibleDate getKanyuDate() {
        return kanyuDate;
    }

    /**
     * 医療保険脱退年月日をgetメソッドです。
     *
     * @return 療医療保険脱退年月日
     */
    public FlexibleDate getDattaiDate() {
        return dattaiDate;
    }

    /**
     * コードのsetメソッドです
     *
     * @param state コード
     */
    public void setState(RString state) {
        this.state = state;
    }

    /**
     * 医療保険加入年月日をsetメソッドです。
     *
     * @param kanyuDate 医療保険加入年月日
     */
    public void setKanyuDate(FlexibleDate kanyuDate) {
        this.kanyuDate = kanyuDate;
    }

    /**
     * 医療保険脱退年月日をsetメソッドです。
     *
     * @param dattaiDate 医療保険脱退年月日
     */
    public void setDattaiDate(FlexibleDate dattaiDate) {
        this.dattaiDate = dattaiDate;
    }

}
