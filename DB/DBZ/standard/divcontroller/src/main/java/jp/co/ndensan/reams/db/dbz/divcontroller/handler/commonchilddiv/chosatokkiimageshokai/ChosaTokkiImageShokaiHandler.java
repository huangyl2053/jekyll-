/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosatokkiimageshokai;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author n3423
 */
public class ChosaTokkiImageShokaiHandler {

    private enum TokkiJikoNo {

        /**
         * 特記資料1, コード: "T0001", ファイル名称: "C4101.png", ファイルbak名称: "C4101_BAK.png"。
         */
        特記資料1(new RString("T0001"), new RString("C4101.png"), new RString("C4101_BAK.png")),
        /**
         * 特記資料2, コード: "T0002", ファイル名称: "C4102.png", ファイルbak名称: "C4102_BAK.png"。
         */
        特記資料2(new RString("T0002"), new RString("C4102.png"), new RString("C4102_BAK.png")),
        /**
         * 特記資料3, コード: "T0003", ファイル名称: "C4103.png", ファイルbak名称: "C4103_BAK.png"。
         */
        特記資料3(new RString("T0003"), new RString("C4103.png"), new RString("C4103_BAK.png")),
        /**
         * 特記資料4, コード: "T0004", ファイル名称: "C4104.png", ファイルbak名称: "C4104_BAK.png"。
         */
        特記資料4(new RString("T0004"), new RString("C4104.png"), new RString("C4104_BAK.png")),
        /**
         * 特記資料5, コード: "T0005", ファイル名称: "C4105.png", ファイルbak名称: "C4105_BAK.png"。
         */
        特記資料5(new RString("T0005"), new RString("C4105.png"), new RString("C4105_BAK.png")),
        /**
         * 特記資料6, コード: "T0006", ファイル名称: "C4106.png", ファイルbak名称: "C4106_BAK.png"。
         */
        特記資料6(new RString("T0006"), new RString("C4106.png"), new RString("C4106_BAK.png")),
        /**
         * 特記資料7, コード: "T0007", ファイル名称: "C4107.png", ファイルbak名称: "C4107_BAK.png"。
         */
        特記資料7(new RString("T0007"), new RString("C4107.png"), new RString("C4107_BAK.png")),
        /**
         * 特記資料8, コード: "T0008", ファイル名称: "C4108.png", ファイルbak名称: "C4108_BAK.png"。
         */
        特記資料8(new RString("T0008"), new RString("C4108.png"), new RString("C4108_BAK.png"));

        private final RString code;
        private final RString fileName;
        private final RString fileNameBAK;

        private TokkiJikoNo(RString code, RString fileName, RString fileNameBAK) {
            this.code = code;
            this.fileName = fileName;
            this.fileNameBAK = fileNameBAK;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return this.code;
        }

        /**
         * ファイル名称を返します。
         *
         * @return コード
         */
        public RString getfileName() {
            return this.fileName;
        }

        /**
         * ファイルbak名称を返します。
         *
         * @return コード
         */
        public RString getfileNameBAK() {
            return this.fileNameBAK;
        }
    }

    private final ChosaTokkiImageShokaiDiv div;
    private static final RString Title特記資料 = new RString("特記資料");
    private static final RString IMAGEFILENAME_特記資料1 = new RString("C4101.png");
    private static final RString IMAGEFILENAME_特記資料2 = new RString("C4102.png");
    private static final RString IMAGEFILENAME_特記資料3 = new RString("C4103.png");
    private static final RString IMAGEFILENAME_特記資料4 = new RString("C4104.png");
    private static final RString IMAGEFILENAME_特記資料5 = new RString("C4105.png");
    private static final RString IMAGEFILENAME_特記資料6 = new RString("C4106.png");
    private static final RString IMAGEFILENAME_特記資料7 = new RString("C4107.png");
    private static final RString IMAGEFILENAME_特記資料8 = new RString("C4108.png");
    private static final RString IMAGEFILENAME_特記資料1_原本 = new RString("C4101_BAK.png");
    private static final RString IMAGEFILENAME_特記資料2_原本 = new RString("C4102_BAK.png");
    private static final RString IMAGEFILENAME_特記資料3_原本 = new RString("C4103_BAK.png");
    private static final RString IMAGEFILENAME_特記資料4_原本 = new RString("C4104_BAK.png");
    private static final RString IMAGEFILENAME_特記資料5_原本 = new RString("C4105_BAK.png");
    private static final RString IMAGEFILENAME_特記資料6_原本 = new RString("C4106_BAK.png");
    private static final RString IMAGEFILENAME_特記資料7_原本 = new RString("C4107_BAK.png");
    private static final RString IMAGEFILENAME_特記資料8_原本 = new RString("C4108_BAK.png");

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
                pathマスク = getImagePath(イメージ情報, 認定調査特記事項Entity.get認定調査特記事項番号(), false);
                if (!RString.isNullOrEmpty(path原本)) {
                    path原本 = getImagePath(イメージ情報, 認定調査特記事項Entity.get認定調査特記事項番号(), true);
                }
            } else {
                if (RString.isNullOrEmpty(pathマスク)) {
                    path原本 = getImagePath(イメージ情報, 認定調査特記事項Entity.get認定調査特記事項番号(), false);
                } else {
                    path原本 = getImagePath(イメージ情報, 認定調査特記事項Entity.get認定調査特記事項番号(), true);
                }
            }

            前回認定調査特記事項番号 = 認定調査特記事項Entity.get認定調査特記事項番号();
            前回認定調査特記事項連番 = 認定調査特記事項Entity.get認定調査特記事項連番();
        }
        imgGenponPathList.add(path原本);
        imgMaskPathList.add(pathマスク);
        
        List<RString> tabTitleGenponList = getTitleList(imgGenponPathList);
        List<RString> tabTitleMaskList = getTitleList(imgMaskPathList);

        div.getCcdChosaTokkiShiryoShokai().initialize(imgGenponPathList, imgMaskPathList, tabTitleGenponList, tabTitleMaskList);
    }

    private RString getImagePath(Image イメージ情報, RString 特記事項番号, boolean isExistマスク) {
        TokkiJikoNo 特記事項 = TokkiJikoNo.valueOf(特記事項番号.toString());
        return 共有ファイルを引き出す(イメージ情報, replaceShareFileName(特記事項.getfileName(), isExistマスク));
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
            titleList.add(Title特記資料.concat(new RString(index)).concat("枚目"));
        }
        return titleList;
    }

}
