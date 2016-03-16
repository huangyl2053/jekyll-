/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report;

import java.util.List;

/**
 *
 * 納入通知書関連クラス継承する抽象クラスです。
 */
public interface NonyuTsuchisho {

    /**
     * List<NonyuTsuchisho>を作成すること処理です。
     *
     * @return List<NonyuTsuchisho>
     */
    public List<NonyuTsuchisho> devidedByPage();

}
