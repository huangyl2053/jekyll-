/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.rirekishusei;

import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特殊修正の受給者台帳更新のBusinessクラスです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RirekiShuseiJukyushaBusiness {

    private JukyushaDaicho 受給者台帳;
    private RString kubun;
    private RString rirekiNo;
    private int updateCount;
}
