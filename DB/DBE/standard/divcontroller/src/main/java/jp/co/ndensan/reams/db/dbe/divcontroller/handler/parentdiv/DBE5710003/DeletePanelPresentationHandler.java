/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710003;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileNames;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.DeletionMethod;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigoninteiimagekanri.ImageFilesPresentState;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710001.Yokaigoninteiimagekanri;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710003.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;

/**
 * DeletePanelDivへのプレゼンテーションをハンドリングします。
 */
public class DeletePanelPresentationHandler {

    private final DeletePanelDiv div;

    /**
     * インスタンスを生成します。
     *
     * @param div {@link DeletePanelDiv}
     */
    public DeletePanelPresentationHandler(DeletePanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化します。
     *
     * @param imageKanriJoho イメージ管理情報
     */
    public void initialize(ImagekanriJoho imageKanriJoho) {
        ImageFileNames imageFiles = imageKanriJoho.collectImageNames();
        ChosahyoDivPresenter.initialize(div.getChosahyo(), imageFiles.confirmChosahyoImagesPresent());
        GaikyoTokkiDivPresenter.initialize(div.getGaikyoTokki(), imageFiles.confirmGaikyoTokkiImagesPresent());
        IkenshoDivPresenter.initialize(div.getIkensho(), imageFiles.confirmIkenshoImagesPresent());
        SonotaDivPresenter.initialize(div.getSonota(), imageFiles.confirmSonotaShiryoImagesPresent());
    }

    private static class ChosahyoDivPresenter {

        private ChosahyoDivPresenter() {
        }

        private static void initialize(ChosahyoDiv div, ImageFilesPresentState chosaImages) {
            if (!chosaImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadChosahyoDeleteTarget().setDataSource(
                    KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap(chosaImages.hasMasked()))
            );
            div.getRadChosahyoDeleteTarget().setSelectedIndex(0);
        }
    }

    private static class GaikyoTokkiDivPresenter {

        private GaikyoTokkiDivPresenter() {
        }

        private static void initialize(GaikyoTokkiDiv div, ImageFilesPresentState gaikyoTokkiImages) {
            if (!Yokaigoninteiimagekanri.uses概況特記() || !gaikyoTokkiImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadGaikyoTokkiDeleteTarget().setDataSource(
                    KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap(gaikyoTokkiImages.hasMasked()))
            );
            div.getRadGaikyoTokkiDeleteTarget().setSelectedIndex(0);
        }
    }

    private static class IkenshoDivPresenter {

        private IkenshoDivPresenter() {
        }

        private static void initialize(IkenshoDiv div, ImageFilesPresentState ikenshoImages) {
            if (!ikenshoImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadIkenshoDeleteTarget().setDataSource(
                    KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap(ikenshoImages.hasMasked()))
            );
            div.getRadIkenshoDeleteTarget().setSelectedIndex(0);
        }
    }

    private static class SonotaDivPresenter {

        private SonotaDivPresenter() {
        }

        private static void initialize(SonotaDiv div, ImageFilesPresentState sonotaImages) {
            if (!sonotaImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadSonotaDeleteTarget().setDataSource(
                    KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap(sonotaImages.hasMasked()))
            );
            div.getRadSonotaDeleteTarget().setSelectedIndex(0);
        }
    }
}
