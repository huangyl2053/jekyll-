package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * １特記事項項目のイメージを扱う共有子Divです。
 */
public interface ITokkiImagesPerKomokuDiv extends ICommonChildDivBaseProperties {

    /**
     * @param directoryPath イメージを展開したディレクトリのパス
     * @param nts 全特記事項
     * @param tokkiJiko 特記事項
     * @param op 処理内容
     */
    void initialize(RString directoryPath, NinteichosahyoTokkijikos nts, NinteiChosaTokkiJikou tokkiJiko, Operation op);

    /**
     * @return 変更有りの場合、{@code true}.
     */
    boolean isDirty();
}
