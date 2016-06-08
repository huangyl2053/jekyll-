/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回認定調査結果との比較表のRelateEntityクラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ChosahyoSaiCheckhyoRelateEntity {

    private RString 申請書管理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 前回一次判定結果;
    private RString 前回二次判定結果;
    private RString 前回二次判定日;
    private RString 生年月日;
    private RString 年齢;
    private RString 今回一次判定結果;
    private RString 審査会日;
    private RString 合議体番号;
    private RString 前回認知症高齢者自立度;
    private RString 前回障害高齢者自立度;
    private RString 今回障害高齢者自立度;
    private RString 今回認知症高齢者自立度;

}
