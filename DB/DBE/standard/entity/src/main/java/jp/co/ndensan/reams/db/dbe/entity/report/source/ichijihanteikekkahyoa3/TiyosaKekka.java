/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3;

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
    private RString 段階改善フラグ;
    private RString 段階改善値;
    private RString 前回結果;
}
