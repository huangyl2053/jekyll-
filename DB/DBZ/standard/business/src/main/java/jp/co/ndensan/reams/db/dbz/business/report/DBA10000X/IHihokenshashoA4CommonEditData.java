/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

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
    HihokenshashoA4 getEditData();

    /**
     * @return the umareG
     */
    RString getUmareG();

    /**
     * @param umareG the umareG to set
     */
    void setUmareG(RString umareG);

    /**
     * @return the umareYyyy
     */
    RString getUmareYyyy();

    /**
     * @param umareYyyy the umareYyyy to set
     */
    void setUmareYyyy(RString umareYyyy);

    /**
     * @return the umareYy
     */
    RString getUmareYy();

    /**
     * @param umareYy the umareYy to set
     */
    void setUmareYy(RString umareYy);

    /**
     * @return the umareMm
     */
    RString getUmareMm();

    /**
     * @param umareMm the umareMm to set
     */
    void setUmareMm(RString umareMm);

    /**
     * @return the umareDd
     */
    RString getUmareDd();

    /**
     * @param umareDd the umareDd to set
     */
    void setUmareDd(RString umareDd);

    /**
     * @return the seibetsu
     */
    RString getSeibetsu();

    /**
     * @param seibetsu the seibetsu to set
     */
    void setSeibetsu(RString seibetsu);

    /**
     * @return the yukokikannamisen
     */
    RString getYukokikannamisen();

    /**
     * @param yukokikannamisen the yukokikannamisen to set
     */
    void setYukokikannamisen(RString yukokikannamisen);

    /**
     * @return the homonkikannamisen
     */
    RString getHomonkikannamisen();

    /**
     * @param homonkikannamisen the homonkikannamisen to set
     */
    void setHomonkikannamisen(RString homonkikannamisen);

}
