/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710001.YokaigoninteiimagekanriDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定イメージ情報管理のハンドラークラスです。
 *
 * @author n3423
 */
public class YokaigoninteiimagekanriHandler {

    private final YokaigoninteiimagekanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定イメージ情報管理div
     */
    public YokaigoninteiimagekanriHandler(YokaigoninteiimagekanriDiv div) {
        this.div = div;
    }

    /**
     * 概況調査のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 調査票概況のイメージファイルが存在する：true、存在しない：false
     */
    public boolean isExistsGaikyoChosaImageFile(List<RString> 存在したイメージファイル名) {
        List<RString> gaikyoChosaImageFileList = ImageFileItem.getGaikyoChosaImageFileList_ALL();
        return isExistsImageFileList(gaikyoChosaImageFileList, 存在したイメージファイル名);
    }

    /**
     * 調査票特記のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 調査票概況のイメージファイルが存在する：true、存在しない：false
     */
    public boolean isExistsChosahyoTokkiImageFile(List<RString> 存在したイメージファイル名) {
        List<RString> chosahyoTokkiImageFileList = ImageFileItem.getChosahyoTokkiImageFileList_ALL();
        return isExistsImageFileList(chosahyoTokkiImageFileList, 存在したイメージファイル名);
    }

    /**
     * 概況特記のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 概況特記のイメージファイルが存在する：true、存在しない：false
     */
    public boolean isExistsGaikyoTokkiImageFile(List<RString> 存在したイメージファイル名) {
        List<RString> gaikyoTokkiImageFileList = ImageFileItem.getGaikyoTokkiImageFileList_ALL();
        return isExistsImageFileList(gaikyoTokkiImageFileList, 存在したイメージファイル名);
    }

    /**
     * 主治医意見書(定型)のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 主治医意見書(定型)のイメージファイルが存在する：true、存在しない：false
     */
    public boolean isExistsOpinionFileTeikeiImageFile(List<RString> 存在したイメージファイル名) {
        List<RString> opinionTeikeiImageFileList = ImageFileItem.getOpinionTeikeiImageFileList_ALL();
        return isExistsImageFileList(opinionTeikeiImageFileList, 存在したイメージファイル名);
    }

    /**
     * 主治医意見書(定型外)のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return 主治医意見書(定型外)のイメージファイルが存在する：true、存在しない：false
     */
    public boolean isExistsOpinionFileTeikeigaiImageFile(List<RString> 存在したイメージファイル名) {
        List<RString> opinionTeikeigaiImageFileList = ImageFileItem.getOpinionTeikeigaiImageFileList_ALL();
        return isExistsImageFileList(opinionTeikeigaiImageFileList, 存在したイメージファイル名);
    }

    /**
     * その他資料のイメージファイル存在チェックを実行します。
     *
     * @param 存在したイメージファイル名 存在したイメージファイル名
     * @return その他資料のイメージファイルが存在する：true、存在しない：false
     */
    public boolean isExistsOtherFileImageFile(List<RString> 存在したイメージファイル名) {
        List<RString> otherFileImageFileList = ImageFileItem.getOtherFileImageFileList_ALL();
        return isExistsImageFileList(otherFileImageFileList, 存在したイメージファイル名);
    }

    private boolean isExistsImageFileList(List<RString> ファイル名リスト, List<RString> 存在したイメージファイル名) {
        for (RString ファイル名 : ファイル名リスト) {
            if (isExistsImageFile(ファイル名, 存在したイメージファイル名)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isExistsImageFile(RString ファイル名, List<RString> 存在したイメージファイル名) {
        for (RString existImageFile : 存在したイメージファイル名) {
            if (existImageFile.contains(ファイル名)) {
                return true;
            }
        }
        return false;
    }
}
