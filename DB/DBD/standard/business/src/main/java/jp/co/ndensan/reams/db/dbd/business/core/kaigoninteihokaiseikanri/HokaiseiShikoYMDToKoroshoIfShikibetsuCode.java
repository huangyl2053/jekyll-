/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.kaigoninteihokaiseikanri;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 法改正施行年月日と厚労省IF識別コードを管理するクラスです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class HokaiseiShikoYMDToKoroshoIfShikibetsuCode {

    private static final long serialVersionUID = 4062737819988412697L;
    private FlexibleDate hokaiseiShikoYMD;
    private RString koroshoIfShikibetsuCode;

    /**
     * 法改正施行年月日と厚労省IF識別コードを生成します。
     *
     * @param hokaiseiShikoYMD 法改正施行年月日
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public HokaiseiShikoYMDToKoroshoIfShikibetsuCode(FlexibleDate hokaiseiShikoYMD, RString koroshoIfShikibetsuCode) {
        this.hokaiseiShikoYMD = hokaiseiShikoYMD;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 法改正施行年月日を取得します。
     *
     * @return 法改正施行年月日
     */
    public FlexibleDate get法改正施行年月日() {
        return hokaiseiShikoYMD;
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return koroshoIfShikibetsuCode;
    }
}
