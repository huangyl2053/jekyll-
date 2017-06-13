/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目に関する処理を扱います。
 */
public final class NinteichosaKomokus {

    private NinteichosaKomokus() {
    }

    /**
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 特記事項項目番号 特記事項項目番号（3桁）
     * @return 該当する認定調査項目. 存在しない場合は、{@link NinteichosaKomokuDummy#EMPTY}.
     */
    public static INinteichosaKomoku toValueFromTokkiJikoNo(RString 厚労省IF識別コード, RString 特記事項項目番号) {
        if (NinteichosaKomokuDummy.概況特記.get特記事項番号().equals(特記事項項目番号)) {
            return NinteichosaKomokuDummy.概況特記;
        }
        if (RString.isNullOrEmpty(特記事項項目番号)) {
            return NinteichosaKomokuDummy.EMPTY;
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09B.getAllBy調査特記事項番(特記事項項目番号);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
            return NinteichosaKomoku09A.getAllBy調査特記事項番(特記事項項目番号);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            return NinteichosaKomoku06A.getAllBy調査特記事項番(特記事項項目番号);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
            return NinteichosaKomoku02A.getAllBy調査特記事項番(特記事項項目番号);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            return NinteichosaKomoku99A.getAllBy調査特記事項番(特記事項項目番号);
        }
        return NinteichosaKomokuDummy.EMPTY;
    }

}
