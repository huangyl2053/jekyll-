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

    protected static RString checkNullForRString(RString rs) {
        if (rs == null) {
            return RString.EMPTY;
        }
        return rs;
    }

    protected static Code checkNullForCode(Code code) {
        if (code == null) {
            return Code.EMPTY;
        }
        return code;
    }

    protected static ShinseishoKanriNo checkNullForShinseishoKanriNo(ShinseishoKanriNo kanriNo) {
        if (kanriNo == null) {
            return ShinseishoKanriNo.EMPTY;
        }
        return kanriNo;
    }

    protected static ShoKisaiHokenshaNo checkNullForShoKisaiHokenshaNo(ShoKisaiHokenshaNo hokenshaNo) {
        if (hokenshaNo == null) {
            return ShoKisaiHokenshaNo.EMPTY;
        }
        return hokenshaNo;
    }

    protected static AtenaMeisho checkNullForAtenaMeisho(AtenaMeisho atenaMeisho) {
        if (atenaMeisho == null) {
            return AtenaMeisho.EMPTY;
        }
        return atenaMeisho;
    }

    protected static AtenaKanaMeisho checkNullForAtenaKanaMeisho(AtenaKanaMeisho kanaMeisho) {
        if (kanaMeisho == null) {
            return AtenaKanaMeisho.EMPTY;
        }
        return kanaMeisho;
    }

    protected static FlexibleDate checkNullForFlexibleDate(FlexibleDate date) {
        if (date == null) {
            return FlexibleDate.EMPTY;
        }
        return date;
    }
}
