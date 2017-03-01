/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoShokai.ShujiiIkenshoShokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshojohoshokai.ShujiiIkenshoJohoShokaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.kanri.ImageFileName;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem.ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshojohoshokai.ShujiiIkenshoJohoShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoShokaiHandler {

    private final ShujiiIkenshoShokaiDiv div;

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
        List<ShujiiIkenshoIkenItemEntity> entityList = ShujiiIkenshoIkenItemManager.createInstance().select主治医意見書(申請書管理番号, 主治医意見書作成依頼履歴番号);
        RString 厚労省IF識別コード = RString.EMPTY;
        if (entityList != null && !entityList.isEmpty()) {
            厚労省IF識別コード = entityList.get(0).getKoroshoIfShikibetsuCode().value();
        }
        List<ShujiiIkenshoJohoShokaiBusiness> shujiiIkenshoJohoShokaiBusinessList = ShujiiIkenshoJohoShokaiFinder.createInstance()
                .select主治医意見書(申請書管理番号, 主治医意見書作成依頼履歴番号).records();
        set主治医医療機関主治医(shujiiIkenshoJohoShokaiBusinessList);
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード)) {
            set主治医意見書項目_99A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード)) {
            set主治医意見書項目_02A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード)) {
            set主治医意見書項目_06A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(厚労省IF識別コード)) {
            set主治医意見書項目_09A(entityList);
        } else if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード)) {
            set主治医意見書項目_09B(entityList);
        }

        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(申請書管理番号);
        List<RString> イメージ原本バイナリリスト = new ArrayList<>();
        List<RString> イメージマスクバイナリリスト = new ArrayList<>();
        List<RString> 原本タイトルリスト = new ArrayList<>();
        List<RString> マスクタイトルリスト = new ArrayList<>();
        if (イメージ情報 != null) {
            RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
            RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class);
            RString 共有ファイル名 = 証記載保険者番号.concat(被保険者番号);
            RString 出力イメージフォルダパス = DBEImageUtil.copySharedFiles(イメージ情報.getイメージ共有ファイルID(), 共有ファイル名);
            List<RString> イメージ原本パスリスト = new ArrayList<>();
            イメージ原本パスリスト.add(DBEImageUtil.getOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.主治医意見書表.getImageFileName()));
            イメージ原本パスリスト.add(DBEImageUtil.getOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.主治医意見書裏.getImageFileName()));
            List<RString> イメージマスクパスリスト = new ArrayList<>();
            イメージマスクパスリスト.add(DBEImageUtil.getMaskImageFilePath(出力イメージフォルダパス, ImageFileName.主治医意見書表.getImageFileName()));
            イメージマスクパスリスト.add(DBEImageUtil.getMaskImageFilePath(出力イメージフォルダパス, ImageFileName.主治医意見書裏.getImageFileName()));

            イメージ原本バイナリリスト = createImageBinaryList(イメージ原本パスリスト);
            イメージマスクバイナリリスト = createImageBinaryList(イメージマスクパスリスト);
            原本タイトルリスト = getTitleList(イメージ原本パスリスト);
            マスクタイトルリスト = getTitleList(イメージマスクパスリスト);
        } else {
            div.getCcdChosaTokkiShiryoShokai().setDisplayNone(true);
        }

        div.getCcdChosaTokkiShiryoShokai().initialize(イメージ原本バイナリリスト, イメージマスクバイナリリスト, 原本タイトルリスト, マスクタイトルリスト);
    }

    private void set主治医意見書項目_99A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (RString.isNullOrEmpty(entity.getIkenItem())) {
                continue;
            }
            if (IkenshoKomokuMapping99A.寝たきり度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShogaiJiritsudo().setValue(IkenKomoku02.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchishoJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping99A.短期記憶.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping99A.認知能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping99A.伝達能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping99A.食事.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set主治医意見書項目_02A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (RString.isNullOrEmpty(entity.getIkenItem())) {
                continue;
            }
            if (IkenshoKomokuMapping02A.寝たきり度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShogaiJiritsudo().setValue(IkenKomoku02.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping02A.認知症高齢者の日常生活自立度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchishoJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping02A.短期記憶.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping02A.認知能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping02A.伝達能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping02A.食事.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set主治医意見書項目_06A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (RString.isNullOrEmpty(entity.getIkenItem())) {
                continue;
            }
            if (IkenshoKomokuMapping06A.寝たきり度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShogaiJiritsudo().setValue(IkenKomoku02.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping06A.認知症高齢者の日常生活自立度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchishoJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping06A.短期記憶.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping06A.認知能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping06A.伝達能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping06A.食事行為.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set主治医意見書項目_09A(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (RString.isNullOrEmpty(entity.getIkenItem())) {
                continue;
            }
            if (IkenshoKomokuMapping09A.寝たきり度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShogaiJiritsudo().setValue(IkenKomoku02.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchishoJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09A.短期記憶.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09A.認知能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09A.伝達能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09A.食事行為.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private void set主治医意見書項目_09B(List<ShujiiIkenshoIkenItemEntity> entityList) {
        for (ShujiiIkenshoIkenItemEntity entity : entityList) {
            if (RString.isNullOrEmpty(entity.getIkenItem())) {
                continue;
            }
            if (IkenshoKomokuMapping09B.寝たきり度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShogaiJiritsudo().setValue(IkenKomoku02.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchishoJiritsudo().setValue(IkenKomoku03.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09B.短期記憶.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtTankiKioku().setValue(IkenKomoku04.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09B.認知能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtNinchiNoryoku().setValue(IkenKomoku05.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09B.伝達能力.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtDentatsuNoryoku().setValue(IkenKomoku06.toValue(entity.getIkenItem()).get名称());
            } else if (IkenshoKomokuMapping09B.食事行為.getコード().equals(new RString(entity.getRemban()))) {
                div.getTxtShokujiKoi().setValue(IkenKomoku14.toValue(entity.getIkenItem()).get名称());
            }
        }
    }

    private List<RString> getTitleList(List<RString> 表示イメージ) {
        List<RString> titleList = new ArrayList<>();
        for (int index = 1; index <= 表示イメージ.size(); index++) {
            titleList.add(new RString(index).concat("枚目"));
        }
        return titleList;
    }

    private List<RString> createImageBinaryList(List<RString> imagePathList) {
        List<RString> imageBinaryList = new ArrayList<>();
        for (RString imagePath : imagePathList) {
            imageBinaryList.add(DBEImageUtil.sanitizePath(imagePath));
        }
        return imageBinaryList;
    }

    private void set主治医医療機関主治医(List<ShujiiIkenshoJohoShokaiBusiness> shujiiIkenshoJohoShokaiBusinessList) {
        div.getTxtShujiiIryoKikanCode().setValue(shujiiIkenshoJohoShokaiBusinessList.get(0).getShujiiCode());
        div.getTxtShujiiIryoKikanName().setValue(shujiiIkenshoJohoShokaiBusinessList.get(0).getIryoKikanMeisho());
        div.getTxtShujiiCode().setValue(shujiiIkenshoJohoShokaiBusinessList.get(0).getShujiiCode());
        div.getTxtShujiiName().setValue(shujiiIkenshoJohoShokaiBusinessList.get(0).getShujiiName());
    }
}
