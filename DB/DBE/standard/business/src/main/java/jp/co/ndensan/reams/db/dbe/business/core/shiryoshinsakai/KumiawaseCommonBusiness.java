/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import com.sun.xml.ws.security.opt.api.reference.DirectReference;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public class KumiawaseCommonBusiness {

    private final List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private final List<ShinsakaiSiryoKyotsuEntity> shinsakaiShiryoCommonEntityList;
    private final List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaishoshaJohoEntityList;
    private final int count;
    private static final RString ファイルID_E0001 = new RString("E0001");
    private static final RString ファイルID_E0002 = new RString("E0002");
    RString imageFilePath;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiShiryoCommonEntityList
     * @param shinsakaiIinJohoList
     * @param shinsakaiTaishoshaJohoEntityList
     * @param count
     */
    public KumiawaseCommonBusiness(List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList,
            List<ShinsakaiSiryoKyotsuEntity> shinsakaiShiryoCommonEntityList,
            List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaishoshaJohoEntityList,
            int count) {
        this.shinsakaiShiryoCommonEntityList = shinsakaiShiryoCommonEntityList;
        this.shinsakaiIinJohoList = shinsakaiIinJohoList;
        this.shinsakaiTaishoshaJohoEntityList = shinsakaiTaishoshaJohoEntityList;
        this.count = count;
    }

    /**
     * 当クラスにて使用するイメージファイルパスを設定します。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setImageFilePath(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiShiryoCommonEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                Directory.createDirectories(imageFilePath);
                imageFilePath = copySharedFiles(entity.getImageSharedFileId(),
                        entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo()));
                break;
            }
        }
    }
    
    /**
     * 当クラスにて使用するイメージファイルパスを設定します。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     * @param batchImageFolderPath イメージ格納用パス
     */
    public void setImageFilePath2(ShinseishoKanriNo shinseishoKanriNo, RString batchImageFolderPath) {
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiShiryoCommonEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                imageFilePath = copySharedFilesBatch(entity.getImageSharedFileId(),
                        entity.getShoKisaiHokenshaNo().concat(entity.getHihokenshaNo()),
                        batchImageFolderPath);
                break;
            }
        }
    }

    /**
     * 主治医意見書情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param isJimu 事務局用
     * @return JimuShinsakaiWariateJohoBusiness
     */
    public JimuShinsakaiWariateJohoBusiness getOpinionFileInfo(ShinseishoKanriNo shinseishoKanriNo, boolean isJimu) {
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiShiryoCommonEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setJimukyoku(isJimu);
                JimuShinsakaiWariateJohoBusiness business = new JimuShinsakaiWariateJohoBusiness(entity);
                if (isJimu) {
                    business.set主治医意見書イメージ１(DBEImageUtil.getOriginalImageFilePath(imageFilePath, ファイルID_E0001));
                    business.set主治医意見書イメージ２(DBEImageUtil.getOriginalImageFilePath(imageFilePath, ファイルID_E0002));
                } else {
                    business.set主治医意見書イメージ１(DBEImageUtil.getMaskOrOriginalImageFilePath(imageFilePath, ファイルID_E0001));
                    business.set主治医意見書イメージ２(DBEImageUtil.getMaskOrOriginalImageFilePath(imageFilePath, ファイルID_E0002));
                }
                return business;
            }
        }
        return null;
    }

    /**
     * その他資料情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param isJimu 事務局用
     * @return JimuSonotashiryoBusiness
     */
    public JimuSonotashiryoBusiness getOtherFileInfo(ShinseishoKanriNo shinseishoKanriNo, boolean isJimu) {
        JimuSonotashiryoBusiness business = null;
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiShiryoCommonEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                if (!isJimu) {
                    entity.setHihokenshaName(AtenaMeisho.EMPTY);
                }
                entity.setJimukyoku(isJimu);
                List<RString> イメージファイルリスト = getその他資料(entity.getImageSharedFileId(), ImageFileItem.getOtherFileImageFileList_Mask(), isJimu);
                if (イメージファイルリスト != null && !イメージファイルリスト.isEmpty()) {
                    business = new JimuSonotashiryoBusiness(entity, イメージファイルリスト);
                }
            }
        }
        return business;
    }

    /**
     * 審査会追加資料情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param paramter IinShinsakaiIinJohoProcessParameter
     * @param 通知文 通知文(ReportIdDBE.DBE517009)
     * @return JimuTuikaSiryoBusiness
     */
    public JimuTuikaSiryoBusiness getAdditionalFileInfo(ShinseishoKanriNo shinseishoKanriNo,
            IinShinsakaiIinJohoProcessParameter paramter,
            RString 通知文) {
        JimuTuikaSiryoBusiness 審査会追加資料 = null;
        for (ShinsakaiTaiyosyaJohoEntity entity : shinsakaiTaishoshaJohoEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                審査会追加資料 = new JimuTuikaSiryoBusiness(entity, shinsakaiIinJohoList, paramter, count, 通知文);
            }
        }
        return 審査会追加資料;
    }

    /**
     * 審査会資料の共通情報を取得します。
     *
     * @param ShinsakaiSiryoKyotsuEntityList 審査会資料共通情報リスト
     * @param shinseishoKanriNo 申請書管理番号
     * @param isJimu 事務局用
     * @return ShinsakaiSiryoKyotsuEntity
     */
    public ShinsakaiSiryoKyotsuEntity getCommonInfo(List<ShinsakaiSiryoKyotsuEntity> ShinsakaiSiryoKyotsuEntityList,
            ShinseishoKanriNo shinseishoKanriNo,
            boolean isJimu) {
        for (ShinsakaiSiryoKyotsuEntity ShinsakaiSiryoKyotsuEntity : ShinsakaiSiryoKyotsuEntityList) {
            if (shinseishoKanriNo.equals(ShinsakaiSiryoKyotsuEntity.getShinseishoKanriNo())) {
                ShinsakaiSiryoKyotsuEntity.setJimukyoku(isJimu);
                return ShinsakaiSiryoKyotsuEntity;
            }
        }
        return null;
    }

    /**
     * 一次判定結果情報から申請書管理番号リストを設定します。
     *
     * @param 申請書管理番号List List<ShinseishoKanriNo>
     * @param 一次判定EntityList List<ItiziHanteiEntity>
     */
    public void set申請書管理番号リスト_一次判定結果(List<ShinseishoKanriNo> 申請書管理番号List, List<ItiziHanteiEntity> 一次判定EntityList) {
        for (ItiziHanteiEntity entity : 一次判定EntityList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
    }

    /**
     * 共通情報から申請書管理番号リストを取得します。
     *
     * @param 申請書管理番号List List<ShinseishoKanriNo>
     */
    public void set申請書管理番号リスト_共通情報(List<ShinseishoKanriNo> 申請書管理番号List) {
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiShiryoCommonEntityList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
    }

    /**
     * その他資料を取得します。
     *
     * @param sharedFileId 共有ファイルID
     * @param ファイル名List イメージファイルリスト
     * @param isJimu 事務局用
     * @return その他資料
     */
    private List<RString> getその他資料(RDateTime sharedFileId, List<RString> ファイル名List, boolean isJimu) {
        List<RString> ファイルPathList = new ArrayList<>();
        if (sharedFileId == null) {
            return ファイルPathList;
        }
        for (RString ファイル名 : ファイル名List) {
            if (!RString.isNullOrEmpty(imageFilePath)) {
                RString fileFullPath;
                if (isJimu) {
                    fileFullPath = DBEImageUtil.getOriginalImageFilePath(imageFilePath, ファイル名);
                } else {
                    fileFullPath = DBEImageUtil.getMaskOrOriginalImageFilePath(imageFilePath, ファイル名);
                }
                if (!RString.isNullOrEmpty(fileFullPath)) {
                    ファイルPathList.add(fileFullPath);
                }
            }
        }
        return ファイルPathList;
    }

    private RString copySharedFiles(RDateTime sharedFileId, RString sharedFileName) {
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        try {
            return DBEImageUtil.copySharedFiles(sharedFileId, sharedFileName);
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }
    
    private RString copySharedFilesBatch(RDateTime sharedFileId, RString sharedFileName, RString batchImageFolderPath) {
        if (sharedFileId == null || RString.isNullOrEmpty(sharedFileName)) {
            return RString.EMPTY;
        }
        try {
            RString localCopyPath = Directory.createDirectories(Path.combinePath(batchImageFolderPath, sharedFileName));
            return DBEImageUtil.copySharedFilesBatch(sharedFileId, sharedFileName, localCopyPath);
        } catch (Exception e) {
            return RString.EMPTY;
        }
    }

}
