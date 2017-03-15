/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.DeletionMethod;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.ImageType;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.OperationTargets;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003.DeletePanelDiv;

/**
 * DeletePanelDivの操作をハンドリングします。
 */
public class DeletePanelHandler {

    private final DeletePanelDiv div;

    /**
     * @param div {@link DeletePanelDiv}
     */
    public DeletePanelHandler(DeletePanelDiv div) {
        this.div = div;
    }

    /**
     * @return 処理対象
     */
    public OperationTargets toOperationTargets() {
        OperationTargets.Builder builder = new OperationTargets.Builder();
        if (!div.getChkChosahyo().getSelectedKeys().isEmpty()) {
            builder.add(ImageType.調査票, DeletionMethod.toValue(div.getRadChosahyoDeleteTarget().getSelectedKey()));
        }
        if (!div.getChkGaikyoTokki().getSelectedKeys().isEmpty()) {
            builder.add(ImageType.概況特記, DeletionMethod.toValue(div.getRadGaikyoTokkiDeleteTarget().getSelectedKey()));
        }
        if (!div.getChkIkensho().getSelectedKeys().isEmpty()) {
            builder.add(ImageType.意見書, DeletionMethod.toValue(div.getRadIkenshoDeleteTarget().getSelectedKey()));
        }
        if (!div.getChkSonota().getSelectedKeys().isEmpty()) {
            builder.add(ImageType.その他資料, DeletionMethod.toValue(div.getRadSonotaDeleteTarget().getSelectedKey()));
        }
        return builder.build();
    }
}
