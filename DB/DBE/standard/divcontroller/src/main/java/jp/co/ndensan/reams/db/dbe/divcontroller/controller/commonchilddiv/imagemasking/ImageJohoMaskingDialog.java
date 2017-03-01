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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageJohoMaskingDaialog.ImageJohoMaskingDialogDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
public class ImageJohoMaskingDialog {

    private static final int 判定用終端文字数 = 8;

    /**
     * 画面起動時に呼ばれるイベント
     *
     * @param div イメージ情報マスキングダイアログ
     * @return ResponseData<イメージ情報マスキングダイアログ>
     */
    public ResponseData<ImageJohoMaskingDialogDiv> onLoad(ImageJohoMaskingDialogDiv div) {
        RString imagePath = div.getHiddenImagePath();
        div.getCcdImageMasking().initialize();
        div.getCcdImageMasking().setMaskManageable(new RString("イメージ情報マスキング"));
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

        RString imagePath = div.getHiddenImagePath();
        RString imageSavePath = get保存先(imagePath);

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

    private RString get保存先(RString imagePath) {
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
}
