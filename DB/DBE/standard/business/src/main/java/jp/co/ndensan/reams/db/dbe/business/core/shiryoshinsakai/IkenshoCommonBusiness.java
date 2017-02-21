/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料（主治医意見書）の事務局用、委員用の共通処理クラスです。
 * 
 * @author n3423
 */
public class IkenshoCommonBusiness {

    /**
     * 審査会資料（主治医意見書）にて使用するBusinessクラスを作成します。
     *
     * @param entity ShinsakaiShiryoKyotsuEntity
     * @param imageFolderPath 指定コピー先
     * @return JimuShinsakaiWariateJohoBusiness
     */
    public static JimuShinsakaiWariateJohoBusiness createBusiness(ShinsakaiSiryoKyotsuEntity entity, RString imageFolderPath) {
        JimuShinsakaiWariateJohoBusiness business = new JimuShinsakaiWariateJohoBusiness(entity);
        RString sharedFileName = entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo());
        KumiawaseCommonBusiness kumiawaseCommonBusiness = new KumiawaseCommonBusiness(null, null, null, 0);
        kumiawaseCommonBusiness.setImageFilePath(entity.getImageSharedFileId(), sharedFileName, imageFolderPath);
        List<RString> opinionFilePath = kumiawaseCommonBusiness.getOpinionFilePath(entity.isJimukyoku());
        business.set主治医意見書イメージ１(opinionFilePath.get(0));
        business.set主治医意見書イメージ２(opinionFilePath.get(1));
        return business;
    }
}
