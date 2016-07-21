/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4050001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking.ImageJohoMaskingParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskShoriTaishosha_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001.ImageJohoMaskingHandler;
import jp.co.ndensan.reams.db.dbe.service.core.imagejohomasking.ImageJohoMaskingFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IkenshoImageJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.IkenshoImageJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * イメージ情報マスキングのコントローラです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMasking {

    private final ImageJohoMaskingFinder finder;
    private final IkenshoImageJohoManager imageJohoManager;
    private final NinteichosahyoTokkijikoManager tokkijikoManager;
// TODO UZI.ImageMaskingにて、フレームワークのバージョンアップ後、予定対応
//    private static final int TOP_10 = 10;
//    private static final int TOP_300 = 300;
//    private static final int TOP_400 = 400;
//    private static final int TOP_500 = 500;
//    private static final int LEFT_20 = 20;
//    private static final int LEFT_100 = 100;
//    private static final int LEFT_200 = 200;
//    private static final int LEFT_400 = 400;
//    private static final int WIDTH_200 = 200;
//    private static final int WIDTH_100 = 100;
//    private static final int WIDTH_300 = 300;
//    private static final int WIDTH_600 = 600;
//    private static final int HEIGHT_100 = 100;
//    private static final int HEIGHT_200 = 200;

    /**
     * コンストラクタです。
     *
     */
    public ImageJohoMasking() {
        this.finder = ImageJohoMaskingFinder.createInstance();
        this.imageJohoManager = IkenshoImageJohoManager.createInstance();
        this.tokkijikoManager = NinteichosahyoTokkijikoManager.createInstance();
    }

    /**
     * イメージ情報マスキング初期化の設定します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onLoad(ImageJohoMaskingDiv div) {
        div.getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);
        if (shinseishoKanriNoList != null) {
            ImageJohoMaskingParameter param = ImageJohoMaskingParameter.createImageJohoMaskingParameter(LasdecCode.EMPTY, FlexibleDate.MAX,
                    FlexibleDate.MAX, RString.EMPTY, shinseishoKanriNoList.getShinseishoKanriNoS());
            List<ImageJohoMaskingResult> resultList = finder.getDataForLoad(param).records();
            getHandler(div).setDataGrid(resultList);
            return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面検索条件より、処理対象者データを取得する
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTaishoKensaku(ImageJohoMaskingDiv div) {
        ImageJohoMaskingParameter param = ImageJohoMaskingParameter.createImageJohoMaskingParameter(
                div.getCcdHokensya().getSelectedItem().get市町村コード(),
                div.getTxtSearchStYMD().getValue(),
                div.getTxtSearchEdYMD().getValue(),
                div.getDdlKensakuTaisho().getSelectedKey(),
                null);
        List<ImageJohoMaskingResult> resultList = finder.getDataForLoad(param).records();
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
    }

    /**
     * 検索条件入力値をクリアする
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnClear(ImageJohoMaskingDiv div) {
        getHandler(div).clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンを押下の場合、イメージ情報パネルが表示する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onSelectBySelectButton_dgImageMaskShoriTaishosha(ImageJohoMaskingDiv div) {
        getHandler(div).setMeisai();
        return ResponseData.of(div).setState(DBE4050001StateName.イメージ情報表示);
    }

    /**
     * その他を選択する場合、イメージ情報パネルの設定が表示する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onChange_rdoIkenshoHyo(ImageJohoMaskingDiv div) {
        getHandler(div).changeImageJoho();
        return ResponseData.of(div).respond();
    }

    /**
     * 「マスク情報を確定する」ボタンを押下の場合、最新の情報を画面で表示する
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnImageToroku(ImageJohoMaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes
                && new RString("0").equals(div.getRdoIkenshoHyo().getSelectedKey())) {
            dgImageMaskShoriTaishosha_Row row = div.getDgImageMaskShoriTaishosha().getClickedItem();
            row.set状態(new RString("修正"));
            div.getDgImageMaskShoriTaishosha().getDataSource().set(div.getDgImageMaskShoriTaishosha().getClickedRowId(), row);
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
    }

    /**
     * マスキングするボタンを選択する場合、マスキング処理を実行します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnMasking(ImageJohoMaskingDiv div) {
        // TODO UZI.ImageMaskingにて、フレームワークのバージョンアップ後、予定対応
//        dgImageMaskShoriTaishosha_Row row = div.getDgImageMaskShoriTaishosha().getClickedItem();
//        div.getCcdImageMasking().setDefaultMaskSource(getMaskData());
//        if (new RString("0").equals(div.getRdoIkenshoHyo().getSelectedKey())) {
//            if (new RString("意見書").equals(row.getイメージ区分())) {
//                if (new RString("301").equals(row.get帳票ID())) {
//                    div.getCcdImageMasking().setImageSource(getShareFile(row.getマスク区分(), new RString("E001"),
//                            RDateTime.parse(row.get共有ファイルID().toString())));
//                } else if (new RString("302").equals(row.get帳票ID())) {
//                    div.getCcdImageMasking().setImageSource(getShareFile(row.getマスク区分(), new RString("E002"),
//                            RDateTime.parse(row.get共有ファイルID().toString())));
//                } else {
//                    if (new RString("1").equals(row.get取込みページ番号())) {
//                        div.getCcdImageMasking().setImageSource(getShareFile(row.getマスク区分(), new RString("E001"),
//                            RDateTime.parse(row.get共有ファイルID().toString())));
//                    }
//                    if (new RString("2").equals(row.get取込みページ番号())) {
//                        div.getCcdImageMasking().setImageSource(getShareFile(row.getマスク区分(), new RString("E002"),
//                            RDateTime.parse(row.get共有ファイルID().toString())));
//                    }
//                }
//            }
//            if (new RString("特記事項").equals(row.getイメージ区分())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(row.getマスク区分(),
//                        new RString("C410").concat(row.get認定調査特記事項連番()),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//        }
//        if (new RString("1").equals(div.getRdoIkenshoHyo().getSelectedKey())) {
//            if (new RString("0").equals(div.getRdoIkenshoUra().getSelectedKey())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(div.getDdlMaskKubun().getSelectedValue(),
//                        new RString("F1401A01"),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//            if (new RString("1").equals(div.getRdoIkenshoUra().getSelectedKey())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(div.getDdlMaskKubun().getSelectedValue(),
//                        new RString("F1401B02"),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//            if (new RString("2").equals(div.getRdoIkenshoUra().getSelectedKey())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(div.getDdlMaskKubun().getSelectedValue(),
//                        new RString("F1401C03"),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//            if (new RString("3").equals(div.getRdoIkenshoUra().getSelectedKey())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(div.getDdlMaskKubun().getSelectedValue(),
//                        new RString("F1401D04"),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//            if (new RString("4").equals(div.getRdoIkenshoUra().getSelectedKey())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(div.getDdlMaskKubun().getSelectedValue(),
//                        new RString("F1401E05"),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//            if (new RString("5").equals(div.getRdoIkenshoUra().getSelectedKey())) {
//                div.getCcdImageMasking().setImageSource(getShareFile(div.getDdlMaskKubun().getSelectedValue(),
//                        new RString("F1401F06"),
//                        RDateTime.parse(row.get共有ファイルID().toString())));
//            }
//        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下の場合、マスクデータを追加する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnUpdate(ImageJohoMaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            for (dgImageMaskShoriTaishosha_Row row : div.getDgImageMaskShoriTaishosha().getDataSource()) {
                if (!RString.isNullOrEmpty(row.get状態())) {
                    saveGamenData(row);
                }
            }
            return ResponseData.of(div).forwardWithEventName(DBE4050001TransitionEventName.完了処理に戻る).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private void saveGamenData(dgImageMaskShoriTaishosha_Row row) {
        if (new RString("意見書").equals(row.getイメージ区分()) && new RString("原本").equals(row.getマスク区分())
                && !finder.has意見書イメージ情報(new ShinseishoKanriNo(row.get申請書管理番号()),
                        Integer.parseInt(row.get主治医意見書作成依頼履歴番号().toString()),
                        new Code(row.get帳票ID()), GenponMaskKubun.マスク.getコード(),
                        Integer.parseInt(row.get取込みページ番号().toString()))) {
            IkenshoImageJoho imageJoho = new IkenshoImageJoho(
                    new ShinseishoKanriNo(row.get申請書管理番号()),
                    Integer.parseInt(row.get主治医意見書作成依頼履歴番号().toString()),
                    new Code(row.get帳票ID()), GenponMaskKubun.マスク.getコード(),
                    Integer.parseInt(row.get取込みページ番号().toString()));
            IkenshoImageJohoBuilder builder = imageJoho.createBuilderForEdit();
            builder.set認定申請年(Integer.parseInt(row.get認定申請年().toString()));
            builder.set共有ファイルID(RDateTime.parse(row.get共有ファイルID().toString()));
            imageJohoManager.save要介護認定意見書イメージ情報(builder.build());
        }
        if (new RString("特記事項").equals(row.getイメージ区分()) && new RString("原本").equals(row.getマスク区分())
                && !finder.has特記情報(new ShinseishoKanriNo(row.get申請書管理番号()),
                        Integer.parseInt(row.get認定調査依頼履歴番号().toString()),
                        row.get認定調査特記事項番号(), Integer.valueOf(row.get認定調査特記事項連番().toString()),
                        TokkijikoTextImageKubun.イメージ.getコード(), new Code(GenponMaskKubun.マスク.getコード()))) {
            NinteichosahyoTokkijiko tokkijiko = new NinteichosahyoTokkijiko(
                    new ShinseishoKanriNo(row.get申請書管理番号()),
                    Integer.parseInt(row.get認定調査依頼履歴番号().toString()),
                    row.get認定調査特記事項番号(), Integer.valueOf(row.get認定調査特記事項連番().toString()),
                    TokkijikoTextImageKubun.イメージ.getコード(),
                    new Code(GenponMaskKubun.マスク.getコード()));
            NinteichosahyoTokkijikoBuilder builder = tokkijiko.createBuilderForEdit();
            builder.set特記事項(row.get特記事項());
            tokkijikoManager.save認定調査票_特記情報(builder.build());
        }

    }

    private ImageJohoMaskingHandler getHandler(ImageJohoMaskingDiv div) {
        return new ImageJohoMaskingHandler(div);
    }
// TODO UZI.ImageMaskingにて、フレームワークのバージョンアップ後、予定対応
//    private List<DefaultMaskData> getMaskData() {
//        List<DefaultMaskData> defaultMasks = new ArrayList<>();
//        DefaultMaskData defaultMask1 = new DefaultMaskData();
//        defaultMask1.setKey(new RString("hoge"));
//        defaultMask1.setText(new RString("hogeMask"));
//        List<Mask> maskList1 = new ArrayList();
//        Mask mask1 = new Mask();
//        mask1.setTop(TOP_10);
//        mask1.setLeft(LEFT_20);
//        mask1.setWidth(WIDTH_200);
//        mask1.setHeight(HEIGHT_100);
//        mask1.setColor(MaskColor.Black);
//        maskList1.add(mask1);
//
//        Mask mask2 = new Mask();
//        mask2.setTop(TOP_300);
//        mask2.setLeft(LEFT_400);
//        mask2.setWidth(WIDTH_300);
//        mask2.setHeight(HEIGHT_200);
//        mask2.setColor(MaskColor.Black);
//        maskList1.add(mask2);
//
//        defaultMask1.setMask(maskList1);
//        defaultMasks.add(defaultMask1);
//
//        DefaultMaskData defaultMask2 = new DefaultMaskData();
//        List<Mask> maskList2 = new ArrayList();
//        defaultMask2.setKey(new RString("fuga"));
//        defaultMask2.setText(new RString("fugaMask"));
//
//        Mask mask3 = new Mask();
//        mask3.setTop(TOP_400);
//        mask3.setLeft(LEFT_200);
//        mask3.setWidth(WIDTH_100);
//        mask3.setHeight(HEIGHT_200);
//        mask3.setColor(MaskColor.Black);
//        maskList2.add(mask3);
//
//        Mask mask4 = new Mask();
//        mask4.setTop(TOP_500);
//        mask4.setLeft(LEFT_100);
//        mask4.setWidth(WIDTH_600);
//        mask4.setHeight(HEIGHT_100);
//        mask4.setColor(MaskColor.White);
//        maskList2.add(mask4);
//
//        defaultMask2.setMask(maskList2);
//        defaultMasks.add(defaultMask2);
//        return defaultMasks;
//    }
//
//    @SuppressWarnings("checkstyle:illegaltoken")
//    private byte[] getShareFile(RString マスク区分, RString sharedFileName, RDateTime sharedFileId) {
//        RString imagePath = Directory.createWorkDirectory(sharedFileName.toString());
//        ReadOnlySharedFileEntryDescriptor descriptor = null;
//        FilesystemPath filePath;
//        if (new RString("原本").equals(マスク区分)) {
//            descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
//                    sharedFileId);
//        }
//        if (new RString("マスク").equals(マスク区分)) {
//            descriptor = new ReadOnlySharedFileEntryDescriptor(
//                    new FilesystemName(sharedFileName.replace(".png", "_BAK.png")), sharedFileId);
//        }
//        try {
//            filePath = SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
//        } catch (Exception e) {
//            return new byte[0];
//        }
//        File file = new File(Path.combinePath(filePath.toRString(), sharedFileName).toString());
//        byte[] ninteiImage = new byte[(int) file.length()];
//        try (FileInputStream fis = new FileInputStream(file);
//                BufferedInputStream bis = new BufferedInputStream(fis)) {
//            if (0 < bis.read(ninteiImage)) {
//                return ninteiImage;
//            }
//        } catch (IOException ex) {
//            return new byte[0];
//        }
//        return ninteiImage;
//    }
}
