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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;

/**
 * DeletePanelDivへのプレゼンテーションをハンドリングします。
 */
public class DeletePanelPresentationHandler {

    private static final RString NONE_DELETABLE = new RString("削除可能なイメージ情報なし");
    private static final RString DELETION_TARGET = new RString("削除対象");
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
    public boolean initialize(ImagekanriJoho imageKanriJoho) {
        ImageFileNames imageFiles = imageKanriJoho.collectImageNames();
        if (imageFiles.isEmpty()) {
            div.getLblTargetImage().setText(NONE_DELETABLE);
            div.getBtnDelete().setDisabled(true);
            div.getChosahyo().setDisplayNone(true);
            div.getGaikyoTokki().setDisplayNone(true);
            div.getIkensho().setDisplayNone(true);
            div.getSonota().setDisplayNone(true);
            return false;
        }
        div.getLblTargetImage().setText(DELETION_TARGET);
        div.getBtnDelete().setDisabled(false);
        new ChosahyoDivPresenter(div.getChosahyo()).initialize(imageFiles.confirmChosahyoImagesPresent());
        new GaikyoTokkiDivPresenter(div.getGaikyoTokki()).initialize(imageFiles.confirmGaikyoTokkiImagesPresent());
        new IkenshoDivPresenter(div.getIkensho()).initialize(imageFiles.confirmIkenshoImagesPresent());
        new SonotaDivPresenter(div.getSonota()).initialize(imageFiles.confirmSonotaShiryoImagesPresent());
        return true;
    }

    /**
     * chkChosahyo の状態により、Div上のメッセージの表示/非表示、内容等を変更します。
     */
    public void displayMessageByChosahyosState() {
        new ChosahyoDivPresenter(div.getChosahyo()).displayMessageByState();
    }

    /**
     * chkGaikyo の状態により、Div上のメッセージの表示/非表示、内容等を変更します。
     */
    public void displayMessageByGaikyoTokkisState() {
        new GaikyoTokkiDivPresenter(div.getGaikyoTokki()).displayMessageByState();
    }

    /**
     * chkkIkensho の状態により、Div上のメッセージの表示/非表示、内容等を変更します。
     */
    public void displayMessageByIkenshosState() {
        new IkenshoDivPresenter(div.getIkensho()).displayMessageByState();
    }

    /**
     * chkhkSonota の状態により、Div上のメッセージの表示/非表示、内容等を変更します。
     */
    public void displayMessageBySonotasState() {
        new SonotaDivPresenter(div.getSonota()).displayMessageByState();
    }

    private static class ChosahyoDivPresenter {

        private final ChosahyoDiv div;

        private ChosahyoDivPresenter(ChosahyoDiv div) {
            this.div = div;
        }

        private void initialize(ImageFilesPresentState chosaImages) {
            if (!chosaImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadChosahyoDeleteTarget().setDataSource(KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap()));
            div.getRadChosahyoDeleteTarget().setSelectedIndex(0);
            div.getRadChosahyoDeleteTarget().setVisible(chosaImages.hasMasked());
        }

        private void displayMessageByState() {
            boolean isOn = !div.getChkChosahyo().getSelectedKeys().isEmpty();
            if (!isOn) {
                div.getChosahyoMessage1().setDisplayNone(true);
                div.getChosahyoMessage2().setDisplayNone(true);
                return;
            }
            boolean deletesMaskedOnly = willDeletesMaskedOnly();
            div.getChosahyoMessage1().setDisplayNone(deletesMaskedOnly);
            div.getChosahyoMessage2().setDisplayNone(!deletesMaskedOnly);
        }

        private boolean willDeletesMaskedOnly() {
            return DeletionMethod.マスクのみを削除.key().equals(div.getRadChosahyoDeleteTarget().getSelectedKey());
        }
    }

    private static class GaikyoTokkiDivPresenter {

        private final GaikyoTokkiDiv div;

        private GaikyoTokkiDivPresenter(GaikyoTokkiDiv div) {
            this.div = div;
        }

        private void initialize(ImageFilesPresentState gaikyoTokkiImages) {
            if (!Yokaigoninteiimagekanri.uses概況特記() || !gaikyoTokkiImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadGaikyoTokkiDeleteTarget().setDataSource(KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap()));
            div.getRadGaikyoTokkiDeleteTarget().setSelectedIndex(0);
        }

        private void displayMessageByState() {
            boolean isOn = !div.getChkGaikyoTokki().getSelectedKeys().isEmpty();
            if (!isOn) {
                div.getGaikyoTokkiMessage1().setDisplayNone(true);
                return;
            }
            div.getGaikyoTokkiMessage1().setDisplayNone(false);
        }
    }

    private static class IkenshoDivPresenter {

        private final IkenshoDiv div;

        private IkenshoDivPresenter(IkenshoDiv div) {
            this.div = div;
        }

        private void initialize(ImageFilesPresentState ikenshoImages) {
            if (!ikenshoImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadIkenshoDeleteTarget().setDataSource(KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap()));
            div.getRadIkenshoDeleteTarget().setSelectedIndex(0);
            div.getRadIkenshoDeleteTarget().setVisible(ikenshoImages.hasMasked());
        }

        private void displayMessageByState() {
            boolean isOn = !div.getChkIkensho().getSelectedKeys().isEmpty();
            if (!isOn) {
                div.getIkenshoMessage1().setDisplayNone(true);
                div.getIkenshoMessage2().setDisplayNone(true);
                return;
            }
            boolean delelesMaskedOnly = willDeletesMaskedOnly();
            div.getIkenshoMessage1().setDisplayNone(delelesMaskedOnly);
            div.getIkenshoMessage2().setDisplayNone(!delelesMaskedOnly);
        }

        private boolean willDeletesMaskedOnly() {
            return DeletionMethod.マスクのみを削除.key().equals(div.getRadIkenshoDeleteTarget().getSelectedKey());
        }
    }

    private static class SonotaDivPresenter {

        private final SonotaDiv div;

        private SonotaDivPresenter(SonotaDiv div) {
            this.div = div;
        }

        private void initialize(ImageFilesPresentState sonotaImages) {
            if (!sonotaImages.exists()) {
                div.setDisplayNone(true);
                return;
            }
            div.getRadSonotaDeleteTarget().setDataSource(KeyValueDataSourceConverter.getDataSource(DeletionMethod.toMap()));
            div.getRadSonotaDeleteTarget().setSelectedIndex(0);
            div.getRadSonotaDeleteTarget().setVisible(sonotaImages.hasMasked());
        }

        private void displayMessageByState() {
            boolean isOn = !div.getChkSonota().getSelectedKeys().isEmpty();
            if (!isOn) {
                div.getSonotaMessage1().setDisplayNone(true);
                div.getSonotaMessage2().setDisplayNone(true);
                return;
            }
            boolean delelesMaskedOnly = willDeletesMaskedOnly();
            div.getSonotaMessage1().setDisplayNone(delelesMaskedOnly);
            div.getSonotaMessage2().setDisplayNone(!delelesMaskedOnly);
        }

        private boolean willDeletesMaskedOnly() {
            return DeletionMethod.マスクのみを削除.key().equals(div.getRadSonotaDeleteTarget().getSelectedKey());
        }
    }
}
