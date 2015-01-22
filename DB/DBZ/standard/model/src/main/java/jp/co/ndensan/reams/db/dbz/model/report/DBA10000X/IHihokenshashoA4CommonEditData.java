/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.report.DBA10000X;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証の帳票ソースが持つ、A4版で共通な情報を取得・設定できることを示すインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IHihokenshashoA4CommonEditData extends IHihokenshashoCommonEditData {

    /**
     * 帳票ソースを取得します。
     *
     * @return 帳票ソース
     */
    public HihokenshashoA4 getEditData();

    /**
     * @return the umareG
     */
    public RString getUmareG();

    /**
     * @param umareG the umareG to set
     */
    public void setUmareG(RString umareG);

    /**
     * @return the umareYyyy
     */
    public RString getUmareYyyy();

    /**
     * @param umareYyyy the umareYyyy to set
     */
    public void setUmareYyyy(RString umareYyyy);

    /**
     * @return the umareYy
     */
    public RString getUmareYy();

    /**
     * @param umareYy the umareYy to set
     */
    public void setUmareYy(RString umareYy);

    /**
     * @return the umareMm
     */
    public RString getUmareMm();

    /**
     * @param umareMm the umareMm to set
     */
    public void setUmareMm(RString umareMm);

    /**
     * @return the umareDd
     */
    public RString getUmareDd();

    /**
     * @param umareDd the umareDd to set
     */
    public void setUmareDd(RString umareDd);

    /**
     * @return the seibetsu
     */
    public RString getSeibetsu();

    /**
     * @param seibetsu the seibetsu to set
     */
    public void setSeibetsu(RString seibetsu);

    /**
     * @return the yukokikannamisen
     */
    public RString getYukokikannamisen();

    /**
     * @param yukokikannamisen the yukokikannamisen to set
     */
    public void setYukokikannamisen(RString yukokikannamisen);

    /**
     * @return the homonkikannamisen
     */
    public RString getHomonkikannamisen();

    /**
     * @param homonkikannamisen the homonkikannamisen to set
     */
    public void setHomonkikannamisen(RString homonkikannamisen);

}
