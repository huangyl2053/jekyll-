/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.hanyolist;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 汎用リスト出力(利用者負担額減免)のRelateEntityクラスです
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListEntity {

    private RString 郵便番号;
    private RString 町域コード;
    private RString 番地コード;
    private RString 行政区コード;
    private RString 地区１;
    private RString 地区２;
    private RString 世帯コード;
    private RString 識別コード;
    private RString 氏名５０音カナ;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 市町村コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 資格区分;
    private RString 受給申請区分;
    private FlexibleDate 受給申請日;
    private RString 要介護度;
    private FlexibleDate 認定開始日;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;

}
