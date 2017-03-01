package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITokkiImagesPerKomokuDiv extends ICommonChildDivBaseProperties {

    /**
     * @param directoryPath
     * @param nts
     * @param tokkiJiko
     * @param op
     */
    void initialize(RString directoryPath, NinteichosahyoTokkijikos nts, NinteiChosaTokkiJikou tokkiJiko, Operation op);

    boolean isDirty();
}
