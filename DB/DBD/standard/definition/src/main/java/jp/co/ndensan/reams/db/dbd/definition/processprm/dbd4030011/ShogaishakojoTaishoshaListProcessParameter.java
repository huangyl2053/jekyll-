/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4030011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 障がい者控除対象者認定書リスト バッチProcess用パラメータクラスです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShogaishakojoTaishoshaListProcessParameter implements IBatchProcessParameter {

    private RString 帳票分類ID;
    private RString 出力順ID;
    private RString 帳票ID;

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
