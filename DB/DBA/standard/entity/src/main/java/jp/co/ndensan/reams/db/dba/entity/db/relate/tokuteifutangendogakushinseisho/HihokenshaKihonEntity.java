/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者基本情報Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaKihonEntity {

    private RString フリガナ;
    private RString 被保険者氏名;
    private HokenshaNo 保険者番号;
    private RString 保険者名称;
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 続柄;
    private RString 郵便番号;
    private RString 電話番号;
    private RString 住所;
    private RString 住民種別コード;
    private RString 世帯主氏名;
    private RString 生年月日不詳区分;
}
