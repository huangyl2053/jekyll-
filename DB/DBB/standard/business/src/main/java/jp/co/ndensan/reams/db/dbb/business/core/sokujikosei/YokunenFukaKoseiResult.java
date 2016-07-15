/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.sokujikosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoFuka;

/**
 * 翌年度賦課更正処理情報のクラスです。
 *
 * @reamsid_L DBB-0660-020 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokunenFukaKoseiResult {

    private List<KoseiZengoFuka> 更正前後賦課のリスト;
    private KoseiZengoChoshuHoho 更正前後徴収方法;
}
