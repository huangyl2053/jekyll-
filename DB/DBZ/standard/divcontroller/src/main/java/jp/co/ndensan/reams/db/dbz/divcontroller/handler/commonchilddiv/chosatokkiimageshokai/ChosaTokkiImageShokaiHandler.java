/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosatokkiimageshokai;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaTokkiImageShokai.ChosaTokkiImageShokaiDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.util._Base64Converter;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author n3423
 */
public class ChosaTokkiImageShokaiHandler {

    private enum TokkiJikoFileName {

        /**
         * 特記資料1, ファイル名称: "C4101.png"。
         */
        特記資料1(new RString("C4101.png")),
        /**
         * 特記資料2, ファイル名称: "C4102.png"。
         */
        特記資料2(new RString("C4102.png")),
        /**
         * 特記資料3, ファイル名称: "C4103.png"。
         */
        特記資料3(new RString("C4103.png")),
        /**
         * 特記資料4, ファイル名称: "C4104.png"。
         */
        特記資料4(new RString("C4104.png")),
        /**
         * 特記資料5, ファイル名称: "C4105.png"。
         */
        特記資料5(new RString("C4105.png")),
        /**
         * 特記資料6, ファイル名称: "C4106.png"。
         */
        特記資料6(new RString("C4106.png")),
        /**
         * 特記資料7, ファイル名称: "C4107.png"。
         */
        特記資料7(new RString("C4107.png")),
        /**
         * 特記資料8, ファイル名称: "C4108.png"。
         */
        特記資料8(new RString("C4108.png"));

        private final RString fileName;

        private TokkiJikoFileName(RString fileName) {
            this.fileName = fileName;
        }

        /**
         * ファイル名称を返します。
         *
         * @return コード
         */
        public RString getfileName() {
            return this.fileName;
        }
    }

    private final ChosaTokkiImageShokaiDiv div;
    private static final RString Title特記資料 = new RString("特記資料");
    private static final RString 特記資料1 = new RString("T001");
    private static final RString 特記資料2 = new RString("T002");
    private static final RString 特記資料3 = new RString("T003");
    private static final RString 特記資料4 = new RString("T004");
    private static final RString 特記資料5 = new RString("T005");
    private static final RString 特記資料6 = new RString("T006");
    private static final RString 特記資料7 = new RString("T007");
    private static final RString 特記資料8 = new RString("T008");

    /**
     * コンストラクタです。
     *
     * @param div 調査特記事項イメージ照会Div
     */
    public ChosaTokkiImageShokaiHandler(ChosaTokkiImageShokaiDiv div) {
        this.div = div;
    }

    /**
     * onLoad処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 特記事項番号リスト 特記事項番号リスト
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, List<RString> 特記事項番号リスト) {
        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(申請書管理番号);
        NinteichosahyoTokkijikoManager tokkiManager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        List<NinteichosahyoTokkijiko> 認定調査特記事項EntityList = tokkiManager.get調査特記事項(申請書管理番号, 認定調査依頼履歴番号, 特記事項番号リスト);

        RString 前回認定調査特記事項番号 = RString.EMPTY;
        int 前回認定調査特記事項連番 = 0;
        RString path原本 = RString.EMPTY;
        RString pathマスク = RString.EMPTY;
        List<RString> imgGenponPathList = new ArrayList<>();
        List<RString> imgMaskPathList = new ArrayList<>();
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class);
        RString 共有ファイル名 = 証記載保険者番号.concat(被保険者番号);
        RString ローカルファイル名 = new RString("IMG");
        RString 出力イメージフォルダパス = RString.EMPTY;
        if (イメージ情報 != null) {
            出力イメージフォルダパス = copySharedFiles(イメージ情報, 共有ファイル名);
        }

        for (NinteichosahyoTokkijiko 認定調査特記事項Entity : 認定調査特記事項EntityList) {
            if (!RString.isNullOrEmpty(前回認定調査特記事項番号)
                    && (!前回認定調査特記事項番号.equals(認定調査特記事項Entity.get認定調査特記事項番号())
                    || 前回認定調査特記事項連番 != 認定調査特記事項Entity.get認定調査特記事項連番())) {
                imgGenponPathList.add(path原本);
                imgMaskPathList.add(pathマスク);
                path原本 = RString.EMPTY;
                pathマスク = RString.EMPTY;
            }

            if (GenponMaskKubun.マスク.getコード().equals(認定調査特記事項Entity.get原本マスク区分().value())) {
                pathマスク = getImagePath(出力イメージフォルダパス,
                        認定調査特記事項Entity.get認定調査特記事項番号(), false);
                if (!RString.isNullOrEmpty(path原本)) {
                    path原本 = getImagePath(出力イメージフォルダパス,
                            認定調査特記事項Entity.get認定調査特記事項番号(), true);
                }
            } else {
                if (RString.isNullOrEmpty(pathマスク)) {
                    path原本 = getImagePath(出力イメージフォルダパス,
                            認定調査特記事項Entity.get認定調査特記事項番号(), false);
                } else {
                    path原本 = getImagePath(出力イメージフォルダパス,
                            認定調査特記事項Entity.get認定調査特記事項番号(), true);
                }
            }

            前回認定調査特記事項番号 = 認定調査特記事項Entity.get認定調査特記事項番号();
            前回認定調査特記事項連番 = 認定調査特記事項Entity.get認定調査特記事項連番();
        }
        if (RString.isNullOrEmpty(出力イメージフォルダパス)) {
            imgGenponPathList.add(sanitizePath(path原本, 出力イメージフォルダパス));
            imgMaskPathList.add(sanitizePath(pathマスク, 出力イメージフォルダパス));
        }

        List<RString> tabTitleGenponList = getTitleList(imgGenponPathList);
        List<RString> tabTitleMaskList = getTitleList(imgMaskPathList);

        div.getCcdChosaTokkiShiryoShokai().initialize(imgGenponPathList, imgMaskPathList, tabTitleGenponList, tabTitleMaskList);
    }

    private RString sanitizePath(RString imagePath, RString 出力イメージフォルダパス) {
        RString DATAURI_BMP = new RString("data:image/png;base64,");
        return !imagePath.isEmpty() ? DATAURI_BMP.concat(base64encode(出力イメージフォルダパス, imagePath)) : RString.EMPTY;
    }

    private RString base64encode(RString 出力イメージフォルダパス, RString イメージパス) {
        RString imgBase64 = RString.EMPTY;
        try {
            imgBase64 = _Base64Converter.encodeBase64RString(Files.readAllBytes(Paths.get(Path.combinePath(出力イメージフォルダパス).toString(), イメージパス.toString())));
        } catch (IOException ex) {
        }
        return imgBase64;
    }

    private RString getImagePath(RString 出力イメージフォルダパス,
            RString 特記事項番号, boolean isExistマスク) {
        if (特記資料1.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料1.getfileName(), isExistマスク));
        } else if (特記資料2.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料2.getfileName(), isExistマスク));
        } else if (特記資料3.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料3.getfileName(), isExistマスク));
        } else if (特記資料4.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料4.getfileName(), isExistマスク));
        } else if (特記資料5.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料5.getfileName(), isExistマスク));
        } else if (特記資料6.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料6.getfileName(), isExistマスク));
        } else if (特記資料7.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料7.getfileName(), isExistマスク));
        } else if (特記資料8.equals(特記事項番号)) {
            return getFilePath(出力イメージフォルダパス, replaceShareFileName(
                    TokkiJikoFileName.特記資料8.getfileName(), isExistマスク));
        }
        return RString.EMPTY;
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private RString copySharedFiles(Image イメージ情報, RString 共有ファイル名) {
        RString 出力イメージフォルダパス = Directory.createTmpDirectory();
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有ファイル名),
                        イメージ情報.getイメージ共有ファイルID());
        deleteIMGDirecotry(出力イメージフォルダパス, 共有ファイル名);
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
    }

    private void deleteIMGDirecotry(RString 出力イメージパス, RString ローカルファイル名) {
        Directory.deleteIfExists(Path.combinePath(出力イメージパス, ローカルファイル名));
    }

    private RString 共有ファイルを引き出す(Image イメージ情報, RString ファイル名) {
        RString imagePath = RString.EMPTY;
        if (イメージ情報 != null) {
            imagePath = getFilePath(イメージ情報.getイメージ共有ファイルID(), ファイル名);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbz/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName), sharedFileId);
        RString filePath = SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath)).toRString();
        return getImageSrc(Path.combinePath(filePath, sharedFileName));
    }

    private RString replaceShareFileName(RString sharedFileName, boolean isExistマスク) {
        if (isExistマスク) {
            return sharedFileName.replace(".png", "_BAK.png");
        }
        return sharedFileName;
    }

    private RString getImageSrc(RString path) {
        return Path.combinePath(new RString(File.separator + "db"), new RString("dbz"), path.substring(path.indexOf("image")));
    }

    private List<RString> getTitleList(List<RString> 表示イメージ) {
        List<RString> titleList = new ArrayList<>();
        for (int index = 1; index <= 表示イメージ.size(); index++) {
            titleList.add(new RString(index).concat("枚目"));
        }
        return titleList;
    }

}
