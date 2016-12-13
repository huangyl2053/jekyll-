/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem.ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.uz.uza._Console;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SearchSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.externalcharacter.util._Base64Converter;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoShokaiHandler {

    private final ShujiiIkenshoShokaiDiv div;
    private final RString 共有エントリファイル名 = new RString("test.zip");
    private final RString ファイル名_主治医意見書_表 = new RString("E0001.png");
    private final RString ファイル名_主治医意見書_表BAK = new RString("E0001_BAK.png");
    private final RString ファイル名_主治医意見書_裏 = new RString("/E0002.png");
    private final RString ファイル名_主治医意見書_裏BAK = new RString("/E0002_BAK.png");
    private RString コピー先フォルダ;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoIraiShokaiDiv
     */
    public ShujiiIkenshoShokaiHandler(ShujiiIkenshoShokaiDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書照会画面の項目を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, int 主治医意見書作成依頼履歴番号) {
        申請書管理番号 = new ShinseishoKanriNo(div.getHiddenShinseishoKanriNo());
        主治医意見書作成依頼履歴番号 = Integer.parseInt(div.getHiddenIkenshoIraiRirekiNo().toString());

        List<ShujiiIkenshoIkenItemEntity> entityList = ShujiiIkenshoIkenItemManager.createInstance().select主治医意見書(申請書管理番号, 主治医意見書作成依頼履歴番号);
        RString 厚労省IF識別コード = RString.EMPTY;
        if (entityList != null && !entityList.isEmpty()) {
            厚労省IF識別コード = entityList.get(0).getKoroshoIfShikibetsuCode().value();
        }
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード)) {
            set必須５項目_99A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード)) {
            set必須５項目_02A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード)) {
            set必須５項目_06A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(厚労省IF識別コード)) {
            set必須５項目_09A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード)) {
            set必須５項目_09B(entityList);
        }

        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(申請書管理番号);
        List<RString> イメージ元本パスリスト = new ArrayList<>();
        List<RString> イメージ元本パスリスト_New = new ArrayList<>();
        List<RString> イメージマスクパスリスト = new ArrayList<>();
        List<RString> イメージマスクパスリスト_New = new ArrayList<>();
        List<RString> 原本タイトルリスト = new ArrayList<>();
        List<RString> マスクタイトルリスト = new ArrayList<>();
        if (イメージ情報 != null) {
            RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
            RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class);
            RString 共有ファイル名 = 証記載保険者番号.concat(被保険者番号);
            RString 出力イメージフォルダパス = copySharedFiles(イメージ情報, 共有ファイル名);

            _Console.log(出力イメージフォルダパス.toString());
            //div.getTxtTest().setValue(出力イメージフォルダパス);
            //ImageConverter.convert(厚労省IF識別コード, ローカルファイル名, ImageFileType.PNG);

            イメージ元本パスリスト = get原本FilePathList(出力イメージフォルダパス);
            イメージマスクパスリスト = getマスクFilePathList(出力イメージフォルダパス);
//            List<RString> fileList = Arrays.asList(Directory.getFiles(Path.combinePath(出力イメージフォルダパス), new RString("E0001.png"), true));

            //RString imgBase64 = base64encode(出力イメージフォルダパス, イメージ元本パスリスト);
            //div.getTxtTest3().setValue(DATAURI_BMP.concat(imgBase64));
            イメージ元本パスリスト_New.add(sanitizePath(イメージ元本パスリスト, 出力イメージフォルダパス, 0));
            イメージ元本パスリスト_New.add(sanitizePath(イメージ元本パスリスト, 出力イメージフォルダパス, 1));
            イメージマスクパスリスト_New.add(sanitizePath(イメージマスクパスリスト, 出力イメージフォルダパス, 0));
            イメージマスクパスリスト_New.add(sanitizePath(イメージマスクパスリスト, 出力イメージフォルダパス, 1));
            原本タイトルリスト = getTitleList(イメージ元本パスリスト);
            マスクタイトルリスト = getTitleList(イメージマスクパスリスト);
        } else {
            div.getCcdChosaTokkiShiryoShokai().setDisplayNone(true);
        }

        div.getCcdChosaTokkiShiryoShokai().initialize(イメージ元本パスリスト_New, イメージマスクパスリスト_New, 原本タイトルリスト, マスクタイトルリスト);
    }

    private RString sanitizePath(List<RString> イメージ元本パスリスト, RString 出力イメージフォルダパス, int index) {
        RString DATAURI_BMP = new RString("data:image/png;base64,");
        return !イメージ元本パスリスト.get(index).isEmpty() ? DATAURI_BMP.concat(base64encode(出力イメージフォルダパス, イメージ元本パスリスト.get(index))) : RString.EMPTY;
    }

    private RString base64encode(RString 出力イメージフォルダパス, RString イメージ元本パス) {
        RString imgBase64 = RString.EMPTY;
        try {
            imgBase64 = _Base64Converter.encodeBase64RString(Files.readAllBytes(Paths.get(Path.combinePath(出力イメージフォルダパス).toString(), イメージ元本パス.toString())));
        } catch (IOException ex) {
        }
        return imgBase64;
    }

    void convertImage(RString fromPath, RString toPath) {
        try {
            BufferedImage image = ImageIO.read(new File(fromPath.toString()));
            BufferedImage tmp = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D off = tmp.createGraphics();
            off.drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(tmp, "bmp", new File(toPath.toString()));
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }

    private void set必須５項目_99A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (Integer.parseInt(IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード().toString()) == entity.getRemban()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping99A.短期記憶.getコード().toString()) == entity.getRemban()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping99A.認知能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping99A.伝達能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping99A.食事.getコード().toString()) == entity.getRemban()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_02A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (Integer.parseInt(IkenshoKomokuMapping02A.認知症高齢者の日常生活自立度.getコード().toString()) == entity.getRemban()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping02A.短期記憶.getコード().toString()) == entity.getRemban()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping02A.認知能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping02A.伝達能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping02A.食事.getコード().toString()) == entity.getRemban()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_06A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (Integer.parseInt(IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード().toString()) == entity.getRemban()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping06A.短期記憶.getコード().toString()) == entity.getRemban()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping06A.認知能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping06A.伝達能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping06A.食事行為.getコード().toString()) == entity.getRemban()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_09A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (Integer.parseInt(IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().toString()) == entity.getRemban()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09A.短期記憶.getコード().toString()) == entity.getRemban()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09A.認知能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09A.伝達能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09A.食事行為.getコード().toString()) == entity.getRemban()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_09B(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (Integer.parseInt(IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().toString()) == entity.getRemban()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09B.短期記憶.getコード().toString()) == entity.getRemban()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09B.認知能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09B.伝達能力.getコード().toString()) == entity.getRemban()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (Integer.parseInt(IkenshoKomokuMapping09B.食事行為.getコード().toString()) == entity.getRemban()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private List<RString> get原本FilePathList(RString 出力イメージフォルダパス) {
        List<RString> イメージファイルパス = new ArrayList<>();
        RString イメージパス_表;
        RString イメージパス_裏;

        イメージパス_表 = getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_表BAK);
        if (RString.isNullOrEmpty(イメージパス_表)) {
            イメージパス_表 = getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_表);
        }
        イメージファイルパス.add(イメージパス_表);

        イメージパス_裏 = getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_裏BAK);
        if (RString.isNullOrEmpty(イメージパス_裏)) {
            イメージパス_裏 = getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_裏);
        }
        イメージファイルパス.add(イメージパス_裏);

        return イメージファイルパス;
    }

    private List<RString> getマスクFilePathList(RString 出力イメージフォルダパス) {
        List<RString> イメージファイルパス = new ArrayList<>();
        RString イメージパス_表 = RString.EMPTY;
        RString イメージパス_裏 = RString.EMPTY;
        if (!RString.isNullOrEmpty(getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_表BAK))) {
            イメージパス_表 = getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_表);
        }
        イメージファイルパス.add(イメージパス_表);

        if (!RString.isNullOrEmpty(getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_裏BAK))) {
            イメージパス_裏 = getFilePath(出力イメージフォルダパス, ファイル名_主治医意見書_裏);
        }
        イメージファイルパス.add(イメージパス_裏);

        return イメージファイルパス;
    }

    private UzT0885SharedFileEntryEntity get共有ファイルEntity(Image イメージ情報, RString ファイル名) {
        List<UzT0885SharedFileEntryEntity> ShareFileList;
        SearchSharedFileOpts 検索条件 = new SearchSharedFileOpts();
        検索条件.localFilePat(ファイル名);
        ShareFileList = SharedFile.searchSharedFile(検索条件);
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                if (イメージ情報.getイメージ共有ファイルID().equals(ShareFile.getSharedFileId())) {
                    return ShareFile;
                }
            }
        }
        return null;
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        div.getTxtTest2().setValue(Path.combinePath(出力イメージフォルダパス, ファイル名));
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private RString copySharedFiles(Image イメージ情報, RString 共有ファイル名) {
//        RString 出力イメージフォルダパス = Path.combinePath(Path.getUserHomePath(), new RString("app"), new RString("webapps"),
//                new RString("db#dbe"), new RString("WEB-INF"), new RString("image"));
        RString 出力イメージフォルダパス = Directory.createTmpDirectory();
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有ファイル名),
                        イメージ情報.getイメージ共有ファイルID());
        deleteIMGDirecotry(出力イメージフォルダパス, 共有ファイル名);
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
    }

    private List<RString> getTitleList(List<RString> 表示イメージ) {
        List<RString> titleList = new ArrayList<>();
        for (int index = 1; index <= 表示イメージ.size(); index++) {
            titleList.add(new RString(index).concat("枚目"));
        }
        return titleList;
    }

    private void deleteIMGDirecotry(RString 出力イメージパス, RString ローカルファイル名) {
        Directory.deleteIfExists(Path.combinePath(出力イメージパス, ローカルファイル名));
    }
}
