/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko;

import java.io.Serializable;

/**
 *
 * 支払方法変更の情報とIndexのクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class ShiharaiHohoHenkoIndex implements Serializable {

    private ShiharaiHohoHenko shiharaiHohoHenko;
    private int index;

    /**
     * @return the shiharaiHohoHenko
     */
    public ShiharaiHohoHenko getShiharaiHohoHenko() {
        return shiharaiHohoHenko;
    }

    /**
     * @param shiharaiHohoHenko the shiharaiHohoHenko to set
     */
    public void setShiharaiHohoHenko(ShiharaiHohoHenko shiharaiHohoHenko) {
        this.shiharaiHohoHenko = shiharaiHohoHenko;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
