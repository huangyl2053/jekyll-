/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;

/**
 *
 * 主治医意見書登録のビジネスクラスです
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoTorokuJoho implements Serializable {

    private static final long serialVersionUID = -710031961519711799L;

    private ShujiiIkenshoJoho shujiiIkenshoJoho;
    private Image image;
    private NinteiShinseiJoho ninteiShinseiJoho;

}
