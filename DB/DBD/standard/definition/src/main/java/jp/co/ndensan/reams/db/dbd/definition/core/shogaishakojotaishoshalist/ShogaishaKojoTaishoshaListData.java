/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.shogaishakojotaishoshalist;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 障がい者控除対象者認定書一括発行リストを表す列挙型です。
 *
 * @reamsid_L DBD-3860-010 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishaKojoTaishoshaListData implements Serializable {

    private RDate 対象年度;
    private Decimal 被保険者番号;
    private RString 氏名;
    private RString 認定区分;
    private RString 認定内容;
    private RString 認知症高齢者の日常生活自立度;
    private RString 障害高齢者の日常生活自立度;
    private RString 障がい者手帳;
    private RString 喪失事由;
    private RDate 喪失日FROM;
    private RDate 喪失日TO;
    private RDate 決定日FROM;
    private RDate 決定日TO;
    private RString 前回非該当者;
    private RDate 交付日;
    private RString 出力順;

}
