/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

/**
 *
 * @author N2810
 */
class HokenryoDankai {

    private String hokenryoDankai;
    private boolean tokureiTaisho;

    /**
     * @return the hokenryoDankai
     */
    public String getHokenryoDankai() {
        return hokenryoDankai;
    }

    /**
     * @param hokenryoDankai the hokenryoDankai to set
     */
    public void setHokenryoDankai(String hokenryoDankai) {
        this.hokenryoDankai = hokenryoDankai;
    }

    /**
     * @return the tokureiTaisho
     */
    public boolean isTokureiTaisho() {
        return tokureiTaisho;
    }

    /**
     * @param tokureiTaisho the tokureiTaisho to set
     */
    public void setTokureiTaisho(boolean tokureiTaisho) {
        this.tokureiTaisho = tokureiTaisho;
    }
}
