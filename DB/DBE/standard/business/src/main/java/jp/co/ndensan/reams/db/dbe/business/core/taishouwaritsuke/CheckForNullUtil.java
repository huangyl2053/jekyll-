/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * NullをCheckのツール
 */
public class CheckForNullUtil {

    /**
     * コンストラクタ
     */
    private CheckForNullUtil() {
    }

    /**
     * checkNullForRString
     *
     * @param rs RString
     * @return isRStringNull
     */
    protected static RString checkNullForRString(RString rs) {
        if (rs == null) {
            return RString.EMPTY;
        }
        return rs;
    }

    /**
     * checkNullForCode
     *
     * @param code Code
     * @return isCodeNull
     */
    protected static Code checkNullForCode(Code code) {
        if (code == null) {
            return Code.EMPTY;
        }
        return code;
    }

    /**
     * checkNullForShinseishoKanriNo
     *
     * @param kanriNo ShinseishoKanriNo
     * @return isShinseishoKanriNoNull
     */
    protected static ShinseishoKanriNo checkNullForShinseishoKanriNo(ShinseishoKanriNo kanriNo) {
        if (kanriNo == null) {
            return ShinseishoKanriNo.EMPTY;
        }
        return kanriNo;
    }

    /**
     * checkNullForShoKisaiHokenshaNo
     *
     * @param hokenshaNo ShoKisaiHokenshaNo
     * @return isShoKisaiHokenshaNoNull
     */
    protected static ShoKisaiHokenshaNo checkNullForShoKisaiHokenshaNo(ShoKisaiHokenshaNo hokenshaNo) {
        if (hokenshaNo == null) {
            return ShoKisaiHokenshaNo.EMPTY;
        }
        return hokenshaNo;
    }

    /**
     * checkNullForAtenaMeisho
     *
     * @param atenaMeisho AtenaMeisho
     * @return isAtenaMeishoNull
     */
    protected static AtenaMeisho checkNullForAtenaMeisho(AtenaMeisho atenaMeisho) {
        if (atenaMeisho == null) {
            return AtenaMeisho.EMPTY;
        }
        return atenaMeisho;
    }

    /**
     * checkNullForRString
     *
     * @param kanaMeisho AtenaKanaMeisho
     * @return isRStringNull
     */
    protected static AtenaKanaMeisho checkNullForAtenaKanaMeisho(AtenaKanaMeisho kanaMeisho) {
        if (kanaMeisho == null) {
            return AtenaKanaMeisho.EMPTY;
        }
        return kanaMeisho;
    }

    /**
     * checkNullForFlexibleDate
     *
     * @param date FlexibleDate
     * @return isFlexibleDateNull
     */
    protected static FlexibleDate checkNullForFlexibleDate(FlexibleDate date) {
        if (date == null) {
            return FlexibleDate.EMPTY;
        }
        return date;
    }
}
