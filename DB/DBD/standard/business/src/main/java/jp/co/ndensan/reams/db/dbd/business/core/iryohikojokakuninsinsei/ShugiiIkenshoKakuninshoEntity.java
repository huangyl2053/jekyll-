/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書確認書Entityクラスです。
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShugiiIkenshoKakuninshoEntity implements Serializable {

    private SofubutsuAtesakiSource 送付物宛先;
    private NinshoshaSource 認証者;
    private Chohyokoyujoho 帳票固有情報;
}
