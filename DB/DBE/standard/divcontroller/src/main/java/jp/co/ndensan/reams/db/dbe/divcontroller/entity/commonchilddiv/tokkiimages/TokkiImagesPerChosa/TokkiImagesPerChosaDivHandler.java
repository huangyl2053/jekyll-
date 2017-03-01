/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public class TokkiImagesPerChosaDivHandler {

    private final TokkiImagesPerChosaDiv div;

    TokkiImagesPerChosaDivHandler(TokkiImagesPerChosaDiv div) {
        this.div = div;
    }

    void initialize() {
        NinteichosahyoTokkijikos nts = find認定調査特記事項s(this.div);
        switch (div.getOperation()) {
            case 修正:
                shusei(div, nts);
                break;
            default:
                shokai(div, nts);
        }
    }

    private static NinteichosahyoTokkijikos find認定調査特記事項s(TokkiImagesPerChosaDiv div) {
        return NinteichosahyoTokkijikoManager
                .createInstance()
                .find特記事項s(
                        div.getShinseishoKanriNo(),
                        div.getNinteichosaIraiRirekiNo(),
                        TokkijikoTextImageKubun.イメージ
                );
    }

    private static void shusei(TokkiImagesPerChosaDiv div, NinteichosahyoTokkijikos nts) {

    }

    private static void shokai(TokkiImagesPerChosaDiv div, NinteichosahyoTokkijikos nts) {
        div.getDdlTokkiJikoNos().setDisplayNone(true);
        div.getBtnSave().setVisible(false);

        RString directoryPath = div.getDirectoryPath();
        for (NinteiChosaTokkiJikou t : NinteiChosaTokkiJikou.values()) {
            NinteichosahyoTokkijikos filterd = nts.tokkiJiko(t);
            if (filterd.isEmpty()) {
                continue;
            }
            ITokkiImagesPerKomokuDiv komoku = div.getRepTokkiJikos().getNewRepeatControlInstance();
            komoku.initialize(directoryPath, nts, t, Operation.照会);
        }
    }
}
