/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.HihokenshaJyuhouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinnteiRiriBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem.ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteiimagekanri.ImagekanriJohoEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IsIkenshoDoiUmu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.IsExistJohoTeikyoDoui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定情報提供Divを制御クラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyoHandler {

    private final YokaigoNinteiJohoTeikyoDiv div;
    private final RString 同意あり = new RString("key0");
    private final RString 同意なし = new RString("key1");
    private final RString なし = new RString("0");
    private final RString あり = new RString("1");
    private final RString 出力方法_一式 = new RString("0");
    private final RString KEY0 = new RString("key0");
    private final RString 検索へ戻るボタン名 = new RString("btnToSearch");
    private final RString 発行するボタン名 = new RString("btnPrint");

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiJohoTeikyoDiv
     */
    public YokaigoNinteiJohoTeikyoHandler(YokaigoNinteiJohoTeikyoDiv div) {
        this.div = div;
    }

    /**
     * 画面情報を設定します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param business 認定申請ビジネスクラス
     */
    public void onLoad(RString 申請書管理番号, NinnteiRiriBusiness business) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(検索へ戻るボタン名, false);
        div.getRadOutputHoho().setSelectedKey(出力方法_一式);
        HihokenshaJyuhouBusiness 被保険者情報 = YokaigoNinteiJohoTeikyoFinder.createInstance().select被保険者情報(申請書管理番号);
        if (被保険者情報 != null) {
            div.getTxtHihokenshaNo().setValue(被保険者情報.get被保険者番号());
            div.getTxtHihokenshaKubun().setValue(HihokenshaKubunCode.toValue(被保険者情報.get区分コード()).get名称());
            div.getTxtHokenshaNo().setValue(new Decimal(被保険者情報.get証記載保険者番号().toString()));
            RString 保険者名称;
            if (被保険者情報.get市町村名称() != null) {
                保険者名称 = 被保険者情報.get市町村名称();
            } else {
                RString 広域連合保険者番号 = DbBusinessConfig.get(ConfigNameDBE.広域連合保険者番号, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
                保険者名称 = (広域連合保険者番号.equals(被保険者情報.get証記載保険者番号()))
                        ? DbBusinessConfig.get(ConfigNameDBE.広域連合名称, RDate.getNowDate(), SubGyomuCode.DBE認定支援)
                        : RString.EMPTY;
            }
            div.getTxtHokenshaName().setValue(保険者名称);
            div.getTxtHihokenshaName().setValue(被保険者情報.get被保険者氏名().getColumnValue());
            div.getTxtHihokenshaKana().setValue(被保険者情報.get被保険者氏名カナ().getColumnValue());
            if (被保険者情報.get生年月日() != null) {
                div.getTxtSeinenYmd().setValue(new RDate(被保険者情報.get生年月日().toString()));
            }
            div.getTxtNenrei().setValue(new Decimal(被保険者情報.get年齢()));
            div.getTxtSeibetsu().setValue(Seibetsu.toValue(被保険者情報.get性別().getColumnValue()).get名称());
            div.getTxtYubibNo().setValue(被保険者情報.get郵便番号());
            div.getTxtjusho().setValue(被保険者情報.get住所().getColumnValue());
            div.getTxtTelNo().setValue(被保険者情報.get電話番号().getColumnValue());
        }

        if (business != null) {
            if (IsExistJohoTeikyoDoui.toValue(business.is情報提供への同意有無()).is同意する()) {
                div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().setSelectedKey(同意あり);
            } else {
                div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().setSelectedKey(同意なし);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(発行するボタン名, true);
            }
            if (IsIkenshoDoiUmu.toValue(business.is意見書同意フラグ()).isしないする()) {
                div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(同意あり);
            } else {
                div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().setSelectedKey(同意なし);
            }
            div.getNinteiKekkaShosai().getTxtShinseibi().setValue(getNull(business.get認定申請日()));
            div.getNinteiKekkaShosai().getTxtShinseiKubunShin().setValue(
                    business.get申請区分_申請時().isEmpty() ? RString.EMPTY
                    : NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分_申請時().getKey()).get名称());
            div.getNinteiKekkaShosai().getTxtShinseiKubun().setValue(
                    business.get申請区分_法令().isEmpty() ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get申請区分_法令().getKey()).get名称());
            div.getNinteiKekkaShosai().getTxtNinteiChosaIraibi().setValue(getNull(business.get認定調査依頼年月日()));
            div.getNinteiKekkaShosai().getTxtNinteiChosaJisshibi().setValue(getNull(business.get認定調査実施年月日()));
            div.getNinteiKekkaShosai().getTxtNinteiChosaJuryobi().setValue(getNull(business.get認定調査受領年月日()));
            div.getCcdChosaItakusakiAndChosainInput().initialize(new RString(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleInputMode.toString()),
                    business.get認定調査委託先コード(), business.get事業者名称(), business.get認定調査員コード(), business.get調査員氏名());
            div.getCcdChosaItakusakiAndChosainInput().setHdnShichosonCode(business.get市町村コード());
            div.getCcdChosaItakusakiAndChosainInput().setHdnShinseishoKanriNo(RString.EMPTY);
            div.getNinteiKekkaShosai().getTxtIkenshoIraibi().setValue(getNull(business.get主治医意見書作成依頼年月日()));
            div.getNinteiKekkaShosai().getTxtIkenshoJuryobi().setValue(getNull(business.get主治医意見書受領年月日()));
            LasdecCode 市町村コード = (business.get市町村コード() != null) ? new LasdecCode(business.get市町村コード()) : LasdecCode.EMPTY;
            div.getCcdShujiiIryoKikanAndShujiiInput().initialize(市町村コード, ShinseishoKanriNo.EMPTY, SubGyomuCode.EMPTY,
                    business.get主治医医療機関コード(), business.get医療機関名称(), business.get主治医コード(), business.get主治医氏名());
            div.getNinteiKekkaShosai().getTxtShinsakaiYoteibi().setValue(getNull(business.get審査会開催予定日()));
            div.getNinteiKekkaShosai().getTxtShinsakaiKaisaibi().setValue(getNull(business.get審査会開催日()));
            set発行する帳票(business);
        }
    }

    /**
     * 発行する帳票に関するコントロールを設定します。
     *
     * @param business NinnteiRiriBusiness
     */
    public void set発行する帳票(NinnteiRiriBusiness business) {
        div.getChkNinteiChosahyo().setDisabled(true);
        div.getChkTokkiJiko().setDisabled(true);
        div.getChkShujiiIkensho().setDisabled(true);
        div.getChkSonotaShiryo().setDisabled(true);
        div.getChkIchijiHanteiKekka().setDisabled(true);
        div.getRadNinteiChosaMasking().setDisabled(true);
        div.getRadTokkiJikoMasking().setDisabled(true);
        div.getRadShujii().setDisabled(true);
        div.getRadSonotaShiryoMasking().setDisabled(true);
        div.getRadIchijiHanteiMasking().setDisabled(true);
        if (同意あり.equals(div.getRadHihokenshaJohoTeikyoDoi().getSelectedKey())) {
            set認定調査票CheckBox(business);
            set特記事項CheckBox(business);
            set主治医意見書CheckBox(business);
            setその他資料CheckBox(business);
            set一次判定結果CheckBox(business);
        }
    }

    /**
     * 認定調査票チェックボックス変更します。
     */
    public void chkNinteiChosahyo() {
        if (div.getChkNinteiChosahyo().getSelectedItems().isEmpty()) {
            div.getRadNinteiChosaMasking().setDisabled(true);
            div.getRadNinteiChosaMasking().setSelectedKey(なし);
        } else {
            div.getRadNinteiChosaMasking().setDisabled(false);
        }
    }

    /**
     * 特記事項チェックボックス変更します。
     */
    public void chkTokkiJiko() {
        if (div.getChkTokkiJiko().getSelectedItems().isEmpty()) {
            div.getRadTokkiJikoMasking().setDisabled(true);
            div.getRadTokkiJikoMasking().setSelectedKey(あり);
        } else {
            div.getRadTokkiJikoMasking().setDisabled(false);
        }
    }

    /**
     * 主治医意見書チェックボックス変更します。
     */
    public void chkShujiiIkensho() {
        if (div.getChkShujiiIkensho().getSelectedItems().isEmpty()) {
            div.getRadShujii().setDisabled(true);
            div.getRadShujii().setSelectedKey(あり);
        } else {
            div.getRadShujii().setDisabled(false);
        }
    }

    /**
     * その他資料チェックボックス変更します。
     */
    public void chkSonotaShiryo() {
        if (div.getChkSonotaShiryo().getSelectedItems().isEmpty()) {
            div.getRadSonotaShiryoMasking().setDisabled(true);
            div.getRadSonotaShiryoMasking().setSelectedKey(あり);
        } else {
            div.getRadSonotaShiryoMasking().setDisabled(false);
        }
    }

    /**
     * 一次判定結果チェックボックス変更します。
     */
    public void chkIchijiHanteikekka() {
        if (div.getChkIchijiHanteiKekka().getSelectedItems().isEmpty()) {
            div.getRadIchijiHanteiMasking().setDisabled(true);
            div.getRadIchijiHanteiMasking().setSelectedKey(なし);
        } else {
            div.getRadIchijiHanteiMasking().setDisabled(false);
        }
    }

    private void set認定調査票CheckBox(NinnteiRiriBusiness business) {
        ChosaKekkaInfoGaikyoFinder finder = ChosaKekkaInfoGaikyoFinder.createInstance();
        ChosaKekkaInfoGaikyoParameter gaikyoParameter = ChosaKekkaInfoGaikyoParameter.
                createGamenParam(business.get申請書管理番号(), business.get認定調査依頼履歴番号(), RString.EMPTY, RString.EMPTY);
        List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList = finder.getChosaKekkaInfoGaikyo(gaikyoParameter).records();
        if (!chosaKekkaInfoGaikyoList.isEmpty()) {
            if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                List<RString> keys = new ArrayList<>();
                keys.add(KEY0);
                div.getChkNinteiChosahyo().setSelectedItemsByKey(keys);
                div.getRadNinteiChosaMasking().setDisabled(false);
            } else {
                div.getChkNinteiChosahyo().setDisabled(false);
                div.getChkNinteiChosahyo().setSelectedItemsByKey(new ArrayList<RString>());
            }
        } else {
            gaikyoParameter = ChosaKekkaInfoGaikyoParameter.createGamenParam(business.get申請書管理番号(), business.get認定調査依頼履歴番号(),
                    TokkijikoTextImageKubun.テキスト.getコード(), TokkijikoTextImageKubun.テキスト.getコード());
            List<RembanServiceJokyoBusiness> serviceJokyos = finder.getRembanServiceJokyo(gaikyoParameter).records();
            List<NinteichosahyoShisetsuRiyo> shisetsuRiyos = finder.get5210NinteichosahyoShisetsu(gaikyoParameter).records();
            if (!serviceJokyos.isEmpty() || !shisetsuRiyos.isEmpty()) {
                if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                    List<RString> keys = new ArrayList<>();
                    keys.add(KEY0);
                    div.getChkNinteiChosahyo().setSelectedItemsByKey(keys);
                    div.getRadNinteiChosaMasking().setDisabled(false);
                } else {
                    div.getChkNinteiChosahyo().setDisabled(false);
                    div.getChkNinteiChosahyo().setSelectedItemsByKey(new ArrayList<RString>());
                }
            }
        }
    }

    private void set特記事項CheckBox(NinnteiRiriBusiness business) {
        List<NinteichosaRelate> 特記事項List
                = YokaigoNinteiJohoTeikyoFinder.createInstance().get特記事項List(new ShinseishoKanriNo(business.get申請書管理番号()), なし);
        if (!特記事項List.isEmpty()) {
            if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                List<RString> keys = new ArrayList<>();
                keys.add(KEY0);
                div.getChkTokkiJiko().setSelectedItemsByKey(keys);
                div.getRadTokkiJikoMasking().setDisabled(false);
            } else {
                div.getChkTokkiJiko().setDisabled(false);
                div.getChkTokkiJiko().setSelectedItemsByKey(new ArrayList<RString>());
            }
        }
    }

    private void set主治医意見書CheckBox(NinnteiRiriBusiness business) {
        if (同意あり.equals(div.getRadShijiiJohoTeikyoDoi().getSelectedKey())) {
            List<ShujiiIkenshoIkenItemEntity> entityList = ShujiiIkenshoIkenItemManager.createInstance()
                    .select主治医意見書(new ShinseishoKanriNo(business.get申請書管理番号()), business.get主治医意見書作成依頼履歴番号());
            if (!entityList.isEmpty()) {
                if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                    List<RString> keys = new ArrayList<>();
                    keys.add(KEY0);
                    div.getChkShujiiIkensho().setSelectedItemsByKey(keys);
                    div.getRadShujii().setDisabled(false);
                } else {
                    div.getChkShujiiIkensho().setDisabled(false);
                    div.getChkShujiiIkensho().setSelectedItemsByKey(new ArrayList<RString>());
                }
            }
        }
    }

    private void setその他資料CheckBox(NinnteiRiriBusiness business) {
        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image imageJoho = imageManager.getイメージ情報(new ShinseishoKanriNo(business.get申請書管理番号()));
        if (imageJoho != null) {
            ImagekanriJohoEntity imageKanriJohoEntity = new ImagekanriJohoEntity();
            imageKanriJohoEntity.setHihokenshaNo(business.get被保険者番号());
            imageKanriJohoEntity.setShoKisaiHokenshaNo(business.get証記載保険者番号());
            imageKanriJohoEntity.setImageSharedFileId(imageJoho.getイメージ共有ファイルID());
            ImagekanriJoho イメージ管理情報 = new ImagekanriJoho(imageKanriJohoEntity);
            RString toCopyPath = DBEImageUtil.copySharedFiles(
                    イメージ管理情報.getイメージ共有ファイルID(), business.get証記載保険者番号().concat(business.get被保険者番号()));
            List<RString> otherFileList = ImageFileItem.getOtherFileImageFileList_Mask();
            for (RString otherFile : otherFileList) {
                if (!RString.isNullOrEmpty(DBEImageUtil.getMaskOrOriginalImageFilePath(toCopyPath, otherFile))) {
                    if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                        List<RString> keys = new ArrayList<>();
                        keys.add(KEY0);
                        div.getChkSonotaShiryo().setSelectedItemsByKey(keys);
                        div.getRadSonotaShiryoMasking().setDisabled(false);
                    } else {
                        div.getChkSonotaShiryo().setDisabled(false);
                        div.getChkSonotaShiryo().setSelectedItemsByKey(new ArrayList<RString>());
                    }
                    break;
                }
            }
        }

    }

    private void set一次判定結果CheckBox(NinnteiRiriBusiness business) {
        IchijiHanteiKekkaJoho 一次判定結果情報
                = YokaigoNinteiJohoTeikyoFinder.createInstance().get一次判定結果情報(new ShinseishoKanriNo(business.get申請書管理番号()));
        if (一次判定結果情報 != null) {
            if (出力方法_一式.equals(div.getRadOutputHoho().getSelectedKey())) {
                List<RString> keys = new ArrayList<>();
                keys.add(KEY0);
                div.getChkIchijiHanteiKekka().setSelectedItemsByKey(keys);
                div.getRadIchijiHanteiMasking().setDisabled(false);
            } else {
                div.getChkIchijiHanteiKekka().setDisabled(false);
                div.getChkIchijiHanteiKekka().setSelectedItemsByKey(new ArrayList<RString>());
            }
        }
    }

    private RDate getNull(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        return new RDate(date.toString());
    }
}
