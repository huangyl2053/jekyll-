/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem.ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemManager;
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
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SearchSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoShokaiHandler {

    private final ShujiiIkenshoShokaiDiv div;
    private final RString ファイル名_主治医意見書_表 = new RString("E0001.png");
    private final RString ファイル名_主治医意見書_表BAK = new RString("E0001_BAK.png");
    private final RString ファイル名_主治医意見書_裏 = new RString("E0002.png");
    private final RString ファイル名_主治医意見書_裏BAK = new RString("E0002_BAK.png");

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
//        主治医意見書作成依頼履歴番号 = 4;

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
        List<RString> イメージマスクパスリスト = new ArrayList<>();
        List<RString> 原本タイトルリスト = new ArrayList<>();
        List<RString> マスクタイトルリスト = new ArrayList<>();
        if (イメージ情報 != null) {
            イメージ元本パスリスト = get原本FilePathList(イメージ情報);
            イメージマスクパスリスト = getマスクFilePathList(イメージ情報);
            原本タイトルリスト = getTitleList(イメージ元本パスリスト);
            マスクタイトルリスト = getTitleList(イメージマスクパスリスト);
        }
        div.getCcdChosaTokkiShiryoShokai().initialize(イメージ元本パスリスト, イメージマスクパスリスト, 原本タイトルリスト, マスクタイトルリスト);
    }

    private void set必須５項目_99A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (entity.getRemban() == IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード().toInt()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping99A.短期記憶.getコード().toInt()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping99A.認知能力.getコード().toInt()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping99A.伝達能力.getコード().toInt()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping99A.食事.getコード().toInt()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_02A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (entity.getRemban() == IkenshoKomokuMapping02A.認知症高齢者の日常生活自立度.getコード().toInt()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping02A.短期記憶.getコード().toInt()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping02A.認知能力.getコード().toInt()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping02A.伝達能力.getコード().toInt()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping02A.食事.getコード().toInt()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_06A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (entity.getRemban() == IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード().toInt()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping06A.短期記憶.getコード().toInt()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping06A.認知能力.getコード().toInt()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping06A.伝達能力.getコード().toInt()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping06A.食事行為.getコード().toInt()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_09A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (entity.getRemban() == IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().toInt()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09A.短期記憶.getコード().toInt()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09A.認知能力.getコード().toInt()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09A.伝達能力.getコード().toInt()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09A.食事行為.getコード().toInt()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set必須５項目_09B(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (entity.getRemban() == IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().toInt()) {
                div.getTxtJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09B.短期記憶.getコード().toInt()) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09B.認知能力.getコード().toInt()) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09B.伝達能力.getコード().toInt()) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (entity.getRemban() == IkenshoKomokuMapping09B.食事行為.getコード().toInt()) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private List<RString> get原本FilePathList(Image イメージ情報) {
        List<RString> イメージファイルパス = new ArrayList<>();
        RString イメージパス_表 = RString.EMPTY;
        RString イメージパス_裏 = RString.EMPTY;

        SearchSharedFileOpts 検索条件 = new SearchSharedFileOpts();
        検索条件.sharedFilePat(ファイル名_主治医意見書_表BAK);
        List<UzT0885SharedFileEntryEntity> ShareFileList = SharedFile.searchSharedFile(検索条件);
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                if (イメージ情報.getイメージ共有ファイルID().equals(ShareFile.getSharedFileId())) {
                    イメージパス_表 = getFilePath(イメージ情報, ファイル名_主治医意見書_表BAK);
                }
            }
        }
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            ShareFileList.clear();
        }
        if (RString.isNullOrEmpty(イメージパス_表)) {
            検索条件.sharedFilePat(ファイル名_主治医意見書_表);
            ShareFileList = SharedFile.searchSharedFile(検索条件);
            if (ShareFileList != null && !ShareFileList.isEmpty()) {
                for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                    if (ShareFile.getSharedFileId().equals(イメージ情報.getイメージ共有ファイルID())) {
                        イメージパス_表 = getFilePath(イメージ情報, ファイル名_主治医意見書_表);
                    }
                }
            }
        }
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            ShareFileList.clear();
        }
        イメージファイルパス.add(イメージパス_表);

        検索条件.sharedFilePat(ファイル名_主治医意見書_裏BAK);
        ShareFileList = SharedFile.searchSharedFile(検索条件);
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                if (イメージ情報.getイメージ共有ファイルID().equals(ShareFile.getSharedFileId())) {
                    イメージパス_裏 = getFilePath(イメージ情報, ファイル名_主治医意見書_裏BAK);
                }
            }
        }        
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            ShareFileList.clear();
        }
        if (RString.isNullOrEmpty(イメージパス_裏)){
            検索条件.sharedFilePat(ファイル名_主治医意見書_裏);
            ShareFileList = SharedFile.searchSharedFile(検索条件);
            if (ShareFileList != null && !ShareFileList.isEmpty()) {
                for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                    if (イメージ情報.getイメージ共有ファイルID().equals(ShareFile.getSharedFileId())) {
                        イメージパス_裏 = getFilePath(イメージ情報, ファイル名_主治医意見書_裏);
                    }
                }
            }
        }
        イメージファイルパス.add(イメージパス_裏);

        return イメージファイルパス;
    }

    private List<RString> getマスクFilePathList(Image イメージ情報) {
        List<RString> イメージファイルパス = new ArrayList<>();
        RString イメージパス_表 = RString.EMPTY;
        RString イメージパス_裏 = RString.EMPTY;

        SearchSharedFileOpts 検索条件 = new SearchSharedFileOpts();
        検索条件.sharedFilePat(ファイル名_主治医意見書_表BAK);
        List<UzT0885SharedFileEntryEntity> ShareFileList = SharedFile.searchSharedFile(検索条件);
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                if (イメージ情報.getイメージ共有ファイルID().equals(ShareFile.getSharedFileId())) {
                    イメージパス_表 = getFilePath(イメージ情報, ファイル名_主治医意見書_表);
                }
            }
        }
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            ShareFileList.clear();
        }
        イメージファイルパス.add(イメージパス_表);

        検索条件.sharedFilePat(ファイル名_主治医意見書_裏BAK);
        ShareFileList = SharedFile.searchSharedFile(検索条件);
        if (ShareFileList != null && !ShareFileList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity ShareFile : ShareFileList) {
                if (イメージ情報.getイメージ共有ファイルID().equals(ShareFile.getSharedFileId())) {
                    イメージパス_裏 = getFilePath(イメージ情報, ファイル名_主治医意見書_裏);
                }
            }
        }
        イメージファイルパス.add(イメージパス_裏);

        return イメージファイルパス;

//        List<RString> イメージファイルパス = new ArrayList<>();
//
//        RString イメージパス_原本表 = getFilePath(イメージ情報, ファイル名_主治医意見書_表BAK);
//        RString イメージパス_表 = RString.EMPTY;
//        if (!RString.isNullOrEmpty(イメージパス_原本表)) {
//            イメージパス_表 = getFilePath(イメージ情報, ファイル名_主治医意見書_表);
//        }
//        イメージファイルパス.add(イメージパス_表);
//
//        RString イメージパス_原本裏 = getFilePath(イメージ情報, ファイル名_主治医意見書_裏BAK);
//        RString イメージパス_裏 = RString.EMPTY;
//        if (!RString.isNullOrEmpty(イメージパス_原本裏)) {
//            イメージパス_裏 = getFilePath(イメージ情報, ファイル名_主治医意見書_裏);
//        }
//        イメージファイルパス.add(イメージパス_裏);
//
//        return イメージファイルパス;
    }

    private RString getFilePath(Image イメージ情報, RString ファイル) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app"), new RString("webapps"), new RString("db#dbe"),
                new RString("WEB-INF"), new RString("image"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(ファイル),
                        イメージ情報.getイメージ共有ファイルID());
        SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        return Path.combinePath(new RString("/db/dbe/image/"), ファイル);
    }

    private List<RString> getTitleList(List<RString> 表示イメージ) {
        List<RString> TitleList = new ArrayList<>();
        for (int index = 1; index <= 表示イメージ.size(); index++) {
            TitleList.add(new RString(index).concat("枚目"));
        }
        return TitleList;
    }
}
