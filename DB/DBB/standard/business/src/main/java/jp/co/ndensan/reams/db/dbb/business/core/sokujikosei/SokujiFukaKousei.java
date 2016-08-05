/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.sokujikosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;

/**
 * 即時賦課更正保存処理のクラスです。
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokujiFukaKousei {

    private List<FukaJoho> 賦課の情報リスト;
    private ChoshuHoho 更正後徴収方法;
    private List<Gemmen> 減免の情報リスト;
}
