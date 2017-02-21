/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料（その他資料）の事務局用、委員用の共通処理クラスです。
 * 
 * @author n3423
 */
public class SonotaShiryoCommonBusiness {

    /**
     * 審査会資料（その他資料）にて使用するBusinessクラスを作成します。
     *
     * @param entity ShinsakaiShiryoKyotsuEntity
     * @param imageFolderPath 指定コピー先
     * @return JimuSonotashiryoBusiness
     */
    public static JimuSonotashiryoBusiness createBusiness(ShinsakaiSiryoKyotsuEntity entity, RString imageFolderPath) {
        JimuSonotashiryoBusiness business = null;
        RString sharedFileName = entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo());
        KumiawaseCommonBusiness kumiawaseCommonBusiness = new KumiawaseCommonBusiness(null, null, null, 0);
        kumiawaseCommonBusiness.setImageFilePath(entity.getImageSharedFileId(), sharedFileName, imageFolderPath);
        List<RString> イメージファイルリスト = kumiawaseCommonBusiness.getOtherFilePath(
                entity.getImageSharedFileId(), ImageFileItem.getOtherFileImageFileList_Mask(), entity.isJimukyoku());
        if (イメージファイルリスト != null && !イメージファイルリスト.isEmpty()) {
            business = new JimuSonotashiryoBusiness(entity, イメージファイルリスト);
        }
        return business;
    }
}
