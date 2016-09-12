/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不整合Entityクラスです。
 *
 * @reamsid_L DBE-0150-330 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TiyosaKekka {

    private RString 調査結果;
    private RString 調査結果コード;
    private RString 段階改善フラグ;
    private RString 段階改善値;
    private RString 前回結果;
    private RString 認定調査と主治医意見書の結果比較;
    private RString 特記事項有無;
}
