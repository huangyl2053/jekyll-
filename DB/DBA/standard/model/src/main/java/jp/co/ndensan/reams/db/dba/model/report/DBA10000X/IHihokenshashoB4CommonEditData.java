/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.model.report.DBA10000X;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証の帳票ソースが持つ、B4版で共通な情報を取得・設定できることを示すインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IHihokenshashoB4CommonEditData extends IHihokenshashoCommonEditData {

    /**
     * 帳票ソースを取得します。
     *
     * @return 帳票ソース
     */
    public HihokenshashoB4 getEditData();

    /**
     * @return the umareMeiji1
     */
    RString getUmareMeiji1();

    /**
     * @param umareMeiji1 the umareMeiji1 to set
     */
    void setUmareMeiji1(RString umareMeiji1);

    /**
     * @return the umareTaisho1
     */
    RString getUmareTaisho1();

    /**
     * @param umareTaisho1 the umareTaisho1 to set
     */
    void setUmareTaisho1(RString umareTaisho1);

    /**
     * @return the umareShowa1
     */
    RString getUmareShowa1();

    /**
     * @param umareShowa1 the umareShowa1 to set
     */
    void setUmareShowa1(RString umareShowa1);

    /**
     * @return the umareYy1
     */
    RString getUmareYy1();

    /**
     * @param umareYy1 the umareYy1 to set
     */
    void setUmareYy1(RString umareYy1);

    /**
     * @return the umareMm1
     */
    RString getUmareMm1();

    /**
     * @param umareMm1 the umareMm1 to set
     */
    void setUmareMm1(RString umareMm1);

    /**
     * @return the umareDd1
     */
    RString getUmareDd1();

    /**
     * @param umareDd1 the umareDd1 to set
     */
    void setUmareDd1(RString umareDd1);

    /**
     * @return the umareYyyy1
     */
    RString getUmareYyyy1();

    /**
     * @param umareYyyy1 the umareYyyy1 to set
     */
    void setUmareYyyy1(RString umareYyyy1);

    /**
     * @return the umareMmS1
     */
    RString getUmareMmS1();

    /**
     * @param umareMmS1 the umareMmS1 to set
     */
    void setUmareMmS1(RString umareMmS1);

    /**
     * @return the umareDdS1
     */
    RString getUmareDdS1();

    /**
     * @param umareDdS1 the umareDdS1 to set
     */
    void setUmareDdS1(RString umareDdS1);

    /**
     * @return the seibetsuMan1
     */
    RString getSeibetsuMan1();

    /**
     * @param seibetsuMan1 the seibetsuMan1 to set
     */
    void setSeibetsuMan1(RString seibetsuMan1);

    /**
     * @return the seibetsuWoman1
     */
    RString getSeibetsuWoman1();

    /**
     * @param seibetsuWoman1 the seibetsuWoman1 to set
     */
    void setSeibetsuWoman1(RString seibetsuWoman1);
}
