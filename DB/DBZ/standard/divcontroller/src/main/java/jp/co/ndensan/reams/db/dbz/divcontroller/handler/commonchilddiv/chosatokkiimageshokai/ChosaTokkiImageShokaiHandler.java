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
         * 特記資料1, コード: "T0001", ファイル名称: "C4101.png"。
         */
        特記資料1(new RString("T0001"), new RString("C4101.png")),
        /**
         * 特記資料2, コード: "T0002", ファイル名称: "C4102.png"。
         */
        特記資料2(new RString("T0002"), new RString("C4102.png")),
        /**
         * 特記資料3, コード: "T0003", ファイル名称: "C4103.png"。
         */
        特記資料3(new RString("T0003"), new RString("C4103.png")),
        /**
         * 特記資料4, コード: "T0004", ファイル名称: "C4104.png"。
         */
        特記資料4(new RString("T0004"), new RString("C4104.png")),
        /**
         * 特記資料5, コード: "T0005", ファイル名称: "C4105.png"。
         */
        特記資料5(new RString("T0005"), new RString("C4105.png")),
        /**
         * 特記資料6, コード: "T0006", ファイル名称: "C4106.png"。
         */
        特記資料6(new RString("T0006"), new RString("C4106.png")),
        /**
         * 特記資料7, コード: "T0007", ファイル名称: "C4107.png"。
         */
        特記資料7(new RString("T0007"), new RString("C4107.png")),
        /**
         * 特記資料8, コード: "T0008", ファイル名称: "C4108.png"。
         */
        特記資料8(new RString("T0008"), new RString("C4108.png"));

        private final RString code;
        private final RString fileName;

        private TokkiJikoNo(RString code, RString fileName) {
            this.code = code;
            this.fileName = fileName;
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
         * コードを返します。
         *
         * @return コード
         */
        public RString getfileName() {
            return this.fileName;
        }
    }

    private final ChosaTokkiImageShokaiDiv div;
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

        List<RString> imgGenponPathList = new ArrayList<>();
        List<RString> imgMaskPathList = new ArrayList<>();
        List<RString> isMaskTokkiNoList = new ArrayList<>();

        for (NinteichosahyoTokkijiko 認定調査特記事項Entity : 認定調査特記事項EntityList) {
            if (GenponMaskKubun.原本.getコード().equals(new RString(認定調査特記事項Entity.get原本マスク区分().toString()))) {
                imgGenponPathList = createImagePathList(イメージ情報, 認定調査特記事項Entity);
            } else {
                imgMaskPathList = createImagePathList(イメージ情報, 認定調査特記事項Entity);
                isMaskTokkiNoList.add(認定調査特記事項Entity.get認定調査特記事項番号());
            }
        }
        for (RString maskTokkiNo : isMaskTokkiNoList) {
            for (RString imgGenponPath : imgGenponPathList) {
                replaceFileName(maskTokkiNo, imgGenponPath);
            }
        }
        
        List<RString> tabTitleGenponList = getTitleList(imgGenponPathList);
        List<RString> tabTitleMaskList = getTitleList(imgMaskPathList);

        div.getCcdChosaTokkiShiryoShokai().initialize(imgGenponPathList, imgMaskPathList, tabTitleGenponList, tabTitleMaskList);
    }

    private void replaceFileName(RString マスク特記事項番号, RString imgGenponPath) {
        if (TokkiJikoNo.特記資料1.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料1, IMAGEFILENAME_特記資料1_原本);
        } else if (TokkiJikoNo.特記資料2.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料2, IMAGEFILENAME_特記資料2_原本);
        } else if (TokkiJikoNo.特記資料3.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料3, IMAGEFILENAME_特記資料3_原本);
        } else if (TokkiJikoNo.特記資料4.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料4, IMAGEFILENAME_特記資料4_原本);
        } else if (TokkiJikoNo.特記資料5.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料5, IMAGEFILENAME_特記資料5_原本);
        } else if (TokkiJikoNo.特記資料6.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料6, IMAGEFILENAME_特記資料6_原本);
        } else if (TokkiJikoNo.特記資料7.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料7, IMAGEFILENAME_特記資料7_原本);
        } else if (TokkiJikoNo.特記資料8.getCode().equals(マスク特記事項番号)) {
            imgGenponPath.replace(IMAGEFILENAME_特記資料8, IMAGEFILENAME_特記資料8_原本);
        }
    }

    private List<RString> createImagePathList(Image イメージ情報, NinteichosahyoTokkijiko 認定調査特記事項) {
        List<RString> imagePathList = new ArrayList<>();
        RString imagePath = RString.EMPTY;
        if (TokkiJikoNo.特記資料1.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料1);
        } else if (TokkiJikoNo.特記資料2.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料2);
        } else if (TokkiJikoNo.特記資料3.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料3);
        } else if (TokkiJikoNo.特記資料4.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料4);
        } else if (TokkiJikoNo.特記資料5.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料5);
        } else if (TokkiJikoNo.特記資料6.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料6);
        } else if (TokkiJikoNo.特記資料7.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料7);
        } else if (TokkiJikoNo.特記資料8.getCode().equals(認定調査特記事項.get認定調査特記事項番号())) {
            imagePath = 共有ファイルを引き出す(イメージ情報, IMAGEFILENAME_特記資料8);
        }
        imagePathList.add(imagePath);
        return imagePathList;
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
        return getImageSrc(Path.combinePath(filePath, replaceShareFileName(sharedFileName, true)));
    }

    private RString replaceShareFileName(RString sharedFileName, boolean isイメージ原本) {
        if (!isイメージ原本) {
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
