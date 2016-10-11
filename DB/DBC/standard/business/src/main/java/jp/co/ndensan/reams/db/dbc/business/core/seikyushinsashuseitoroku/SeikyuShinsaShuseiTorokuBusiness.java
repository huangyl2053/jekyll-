/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoShukei;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyuShinsaShuseiTorokuBusiness implements Serializable {

    private static final long serialVersionUID = 1L;
    private JutakuKaishuRiyushoTesuryoKettei dbT3094;
    private JutakuKaishuRiyushoTesuryoMeisai dbT3095;
    private JutakuKaishuRiyushoTesuryoShukei dbT3096;
}
