/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.iryohokenkanyujokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * dgIryohokenIchiran_Row のクラスファイル。
 */
public class IryohokenRirekiCommonChildDivDate implements Comparable<IryohokenRirekiCommonChildDivDate> {

    private RString defaultDataName2;
    private RString defaultDataName3;
    private RString defaultDataName4;

    public IryohokenRirekiCommonChildDivDate() {
        super();

        this.defaultDataName2 = RString.EMPTY;
        this.defaultDataName3 = RString.EMPTY;
        this.defaultDataName4 = RString.EMPTY;
    }

    /**
     *
     * @param defaultDataName2
     * @param defaultDataName3
     * @param defaultDataName4
     */
    public IryohokenRirekiCommonChildDivDate(RString defaultDataName2, RString defaultDataName3, RString defaultDataName4) {
        this.defaultDataName2 = defaultDataName2;
        this.defaultDataName3 = defaultDataName3;
        this.defaultDataName4 = defaultDataName4;

    }

    /**
     * コードのgetメソッドです
     *
     * @return コード
     */
    public RString getDefaultDataName2() {
        return defaultDataName2;
    }

    /**
     * 医療保険加入年月日をgetメソッドです。
     *
     * @return 療保険加入年月日
     */
    public RString getDefaultDataName3() {
        return defaultDataName3;
    }

    /**
     * 医療保険脱退年月日をgetメソッドです。
     *
     * @return 療医療保険脱退年月日
     */
    public RString getDefaultDataName4() {
        return defaultDataName4;
    }

    /**
     * コードのsetメソッドです
     *
     * @param defaultDataName2 コード
     */
    public void setDefaultDataName2(RString defaultDataName2) {
        this.defaultDataName2 = defaultDataName2;
    }

    /**
     * 医療保険加入年月日をsetメソッドです。
     *
     * @param defaultDataName3 医療保険加入年月日
     */
    public void setDefaultDataName3(RString defaultDataName3) {
        this.defaultDataName3 = defaultDataName3;
    }

    /**
     * 医療保険脱退年月日をsetメソッドです。
     *
     * @param defaultDataName4 医療保険脱退年月日
     */
    public void setDefaultDataName4(RString defaultDataName4) {
        this.defaultDataName4 = defaultDataName4;
    }

    /**
     *
     * @param iryohoken
     * @return
     */
    @Override
    public int compareTo(IryohokenRirekiCommonChildDivDate iryohoken) {
        return this.defaultDataName3.compareTo(iryohoken.defaultDataName3);
    }
}
