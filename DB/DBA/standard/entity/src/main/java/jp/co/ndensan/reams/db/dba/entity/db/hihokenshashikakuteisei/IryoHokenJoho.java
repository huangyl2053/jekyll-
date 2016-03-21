/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療保険情報
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IryoHokenJoho {

    private ShikibetsuCode 識別コード;
    private int 履歴番号;
    private LasdecCode 市町村コード;
    private RString 医療保険種別コード;
    private RString 医療保険者番号;
    private RString 医療保険者名称;
    private RString 医療保険記号番号;
    private FlexibleDate 医療保険加入年月日;
    private FlexibleDate 医療保険脱退年月日;

    /**
     * 医療保険チェック処理用。
     *
     * @return 医療保険情報
     */
    public RString toRString() {
        StringBuilder builder = new StringBuilder();
        builder.append(識別コード.toString());
        builder.append(String.valueOf(履歴番号));
        builder.append(市町村コード.toString());
        builder.append(医療保険種別コード.toString());
        builder.append(医療保険者番号.toString());
        builder.append(医療保険者名称.toString());
        builder.append(医療保険記号番号.toString());
        builder.append(医療保険加入年月日.toString());
        builder.append(医療保険脱退年月日.toString());
        return new RString(builder.toString());
    }
}
