/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.rirekishusei;

import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4201NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4202NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4301ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4302ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特殊修正更新のBusinessクラスです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RirekiShuseiUpdBusiness {

    private DbT4101NinteiShinseiJoho 要介護認定申請情報;
    private JukyushaDaicho 受給者台帳;
    private DbT4102NinteiKekkaJoho 要介護認定結果情報;
    private DbT4101NinteiShinseiJoho 要介護認定申請情報次回行;
    private IchijiHanteiKekkaJoho 要介護認定一次判定結果情報;
    private DbT4120ShinseitodokedeJoho 申請届出情報;
    private DbT4121ShinseiRirekiJoho 申請履歴情報更新行;
    private DbT4121ShinseiRirekiJoho 申請履歴情報次回行;
    private DbT4123NinteiKeikakuJoho 要介護認定計画情報;
    private DbT4201NinteichosaIraiJoho 認定調査依頼情報;
    private DbT4202NinteichosahyoGaikyoChosa 認定調査票_概況調査;
    private DbT4301ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報;
    private DbT4302ShujiiIkenshoJoho 要介護認定主治医意見書情報;
    private RString kubun;
    private boolean tsuikaKubun;
    private RString maeGoKubun;
}
