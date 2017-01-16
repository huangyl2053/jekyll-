/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
import static jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode.認定ｿﾌﾄ99;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 ** {@link IServiceJokyoFlag}に関連する処理をまとめたクラスです。
 */
public class ServiceJokyoFlags {

    /**
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 指定の厚労省IF識別コードに対応する{@link IServiceJokyoFlag}の{@link Set}を返します。
     */
    public static Set<IServiceJokyoFlag> valuesOf(RString 厚労省IF識別コード) {
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード)) {
            case 認定ｿﾌﾄ2009_SP3:
                return new HashSet<IServiceJokyoFlag>(Arrays.asList(ServiceJokyoFlag09B.values()));
            case 認定ｿﾌﾄ2009:
                return new HashSet<IServiceJokyoFlag>(Arrays.asList(ServiceJokyoFlag09A.values()));
            case 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用:
                return new HashSet<IServiceJokyoFlag>(Arrays.asList(ServiceJokyoFlag06A.values()));
            case 認定ｿﾌﾄ2002:
                return new HashSet<IServiceJokyoFlag>(Arrays.asList(ServiceJokyoFlag02A.values()));
            case 認定ｿﾌﾄ99:
                return new HashSet<IServiceJokyoFlag>(Arrays.asList(ServiceJokyoFlag99A.values()));
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append("指定の厚労省IF識別コードは不正です。：'")
                        .append(厚労省IF識別コード)
                        .append("'")
                        .toString());
        }
    }
}
