/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別な医療Entityクラスです。
 *
 * @reamsid_L DBE-0150-330 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsunaIryoTiyosaKekka {

    private RString 調査結果;
    private RString 認定調査と主治医意見書の結果比較;
    private RString 特記事項有無;
    private RString 段階改善;

}
