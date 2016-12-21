/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.imagemasking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageJohoMaskingDaialog.ImageJohoMaskingDialogDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.image.mask.DefaultMaskData;
import jp.co.ndensan.reams.uz.uza.image.mask.Mask;
import jp.co.ndensan.reams.uz.uza.image.mask.MaskColor;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
public class ImageJohoMaskingDialog {

    private static final int 判定用終端文字数 = 8;
    private static final int TOP_10 = 10;
    private static final int TOP_300 = 300;
    private static final int TOP_400 = 400;
    private static final int TOP_500 = 500;
    private static final int LEFT_20 = 20;
    private static final int LEFT_100 = 100;
    private static final int LEFT_200 = 200;
    private static final int LEFT_400 = 400;
    private static final int WIDTH_200 = 200;
    private static final int WIDTH_100 = 100;
    private static final int WIDTH_300 = 300;
    private static final int WIDTH_600 = 600;
    private static final int HEIGHT_100 = 100;
    private static final int HEIGHT_200 = 200;
    private static RString imagePath;

    /**
     * 画面起動時に呼ばれるイベント
     *
     * @param div イメージ情報マスキングダイアログ
     * @return ResponseData<イメージ情報マスキングダイアログ>
     */
    public ResponseData<ImageJohoMaskingDialogDiv> onLoad(ImageJohoMaskingDialogDiv div) {
        imagePath = div.getHiddenImagePath();
        div.getCcdImageMasking().initialize();
        div.getCcdImageMasking().setDefaultMaskSource(getMaskData());
        div.getCcdImageMasking().setImageSource(getImageSource(imagePath));
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタン押下時のイベント
     *
     * @param div イメージ情報マスキングダイアログ
     * @return ResponseData<イメージ情報マスキングダイアログ>
     */
    public ResponseData<ImageJohoMaskingDialogDiv> onClick_btnHozon(ImageJohoMaskingDialogDiv div) {

        RString imageSavePath = get保存先();

        File file = new File(imageSavePath.toString());
        byte[] binary = div.getCcdImageMasking().getEditedImageBinary();
        try (FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(binary);
            bos.flush();
        } catch (IOException ex) {
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        div.setHiddenImagePath(imageSavePath);
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 取消ボタン押下時のイベント
     *
     * @param div イメージ情報マスキングダイアログ
     * @return ResponseData<イメージ情報マスキングダイアログ>
     */
    public ResponseData<ImageJohoMaskingDialogDiv> onClick_btnTorikeshi(ImageJohoMaskingDialogDiv div) {
        return ResponseData.of(div).respond();
    }

    private RString get保存先() {
        RString newImagePath;
        RString imagePathEnd = imagePath.substring(imagePath.length() - 判定用終端文字数, imagePath.length());
        if (imagePathEnd.equals(new RString("_NEW.png"))) {
            newImagePath = imagePath;
        } else if (imagePathEnd.equals(new RString("_BAK.png"))) {
            newImagePath = imagePath.replace(new RString("_BAK.png"), new RString("_NEW.png"));
        } else {
            newImagePath = imagePath.replace(new RString(".png"), new RString("_NEW.png"));
        }
        return newImagePath;
    }

    private byte[] getImageSource(RString imagePath) {
        File file = new File(imagePath.toString());
        byte[] imageSource = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis)) {
            bis.read(imageSource);
        } catch (IOException ex) {
            return new byte[0];
        }
        return imageSource;
    }

    private List<DefaultMaskData> getMaskData() {
        List<DefaultMaskData> defaultMasks = new ArrayList<>();
        DefaultMaskData defaultMask1 = new DefaultMaskData();
        defaultMask1.setKey(new RString("1"));
        defaultMask1.setText(new RString("mask1"));
        List<Mask> maskList1 = new ArrayList();
        Mask mask1 = new Mask();
        mask1.setTop(TOP_10);
        mask1.setLeft(LEFT_20);
        mask1.setWidth(WIDTH_200);
        mask1.setHeight(HEIGHT_100);
        mask1.setColor(MaskColor.Black);
        maskList1.add(mask1);

        Mask mask2 = new Mask();
        mask2.setTop(TOP_300);
        mask2.setLeft(LEFT_400);
        mask2.setWidth(WIDTH_300);
        mask2.setHeight(HEIGHT_200);
        mask2.setColor(MaskColor.Black);
        maskList1.add(mask2);

        defaultMask1.setMask(maskList1);
        defaultMasks.add(defaultMask1);

        DefaultMaskData defaultMask2 = new DefaultMaskData();
        List<Mask> maskList2 = new ArrayList();
        defaultMask2.setKey(new RString("2"));
        defaultMask2.setText(new RString("mask2"));

        Mask mask3 = new Mask();
        mask3.setTop(TOP_400);
        mask3.setLeft(LEFT_200);
        mask3.setWidth(WIDTH_100);
        mask3.setHeight(HEIGHT_200);
        mask3.setColor(MaskColor.Black);
        maskList2.add(mask3);

        Mask mask4 = new Mask();
        mask4.setTop(TOP_500);
        mask4.setLeft(LEFT_100);
        mask4.setWidth(WIDTH_600);
        mask4.setHeight(HEIGHT_100);
        mask4.setColor(MaskColor.White);
        maskList2.add(mask4);

        defaultMask2.setMask(maskList2);
        defaultMasks.add(defaultMask2);
        return defaultMasks;
    }
}
