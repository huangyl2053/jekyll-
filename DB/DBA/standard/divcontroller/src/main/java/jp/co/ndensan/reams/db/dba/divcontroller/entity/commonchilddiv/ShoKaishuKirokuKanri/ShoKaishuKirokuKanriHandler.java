/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.service.core.shokofukaishujoho.ShoKofuKaishuJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 証交付回収情報の取得するクラスです。
 *
 * @reamsid_L DBA-1070-010 lizhuoxuan
 */
public class ShoKaishuKirokuKanriHandler {

    private final ShoKaishuKirokuKanriDiv div;
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_更新 = new RString("更新");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 被保険者証 = new RString("被保険者証");
    private static final RString CODESHUBETSU_001 = new RString("001");
    private static final RString CODESHUBETSU_0002 = new RString("0002");
    private static final RString CODESHUBETSU_0003 = new RString("0003");
    private static final RString CODESHUBETSU_0004 = new RString("0004");
    private static final RString CODESHUBETSU_0005 = new RString("0005");
    private static final RString CODESHUBETSU_0006 = new RString("0006");
    private static final RString 追加 = new RString("追加");
    private static final RString 更新 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 証交付回収情報パネル
     */
    public ShoKaishuKirokuKanriHandler(ShoKaishuKirokuKanriDiv div) {
        this.div = div;
    }

    /**
     * 証交付回収情報を検索する。
     *
     * @param 状態 状態
     * @param 被保険者番号 被保険者番号
     */
    public void initialize(RString 状態, HihokenshaNo 被保険者番号) {
        ViewStateHolder.put(ViewStateKeys.証交付回収情報_被保番号, 被保険者番号);
        if (状態_照会.equals(状態)) {
            List<ShoKofuKaishu> businessList = ShoKofuKaishuJohoManager.createInstance()
                    .getShoKofuKaishuJohoList(被保険者番号, false).records();
            Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> shoKofuKaishu = Models.create(businessList);
            ViewStateHolder.put(ViewStateKeys.証交付回収情報, shoKofuKaishu);
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (businessList != null && !businessList.isEmpty()) {
                for (ShoKofuKaishu jigyoshaInput : businessList) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0006), new Code(jigyoshaInput.get交付証種類())));
                    if (jigyoshaInput.get交付年月日() != null && jigyoshaInput.get交付年月日().isValid()) {
                        dgJigyoshaItiran.setKoufuDate(jigyoshaInput.get交付年月日().wareki().toDateString());
                    } else {
                        dgJigyoshaItiran.setKoufuDate(RString.EMPTY);
                    }
                    if (CODESHUBETSU_001.equals(jigyoshaInput.get交付証種類())) {
                        dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0002), new Code(jigyoshaInput.get交付事由())));
                    } else {
                        dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0004), new Code(jigyoshaInput.get交付事由())));
                    }
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    if (jigyoshaInput.get回収年月日() != null && jigyoshaInput.get回収年月日().isValid()) {
                        dgJigyoshaItiran.setKaishuDate((jigyoshaInput.get回収年月日().wareki().toDateString()));
                    } else {
                        dgJigyoshaItiran.setKaishuDate(RString.EMPTY);
                    }
                    if (CODESHUBETSU_001.equals(jigyoshaInput.get交付証種類())) {
                        dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0003), new Code(jigyoshaInput.get回収事由())));
                    } else {
                        dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0005), new Code(jigyoshaInput.get回収事由())));
                    }
                    if (jigyoshaInput.get有効期限() != null && jigyoshaInput.get有効期限().isValid()) {
                        dgJigyoshaItiran.setYukoKigen((jigyoshaInput.get有効期限().wareki().toDateString()));
                    } else {
                        dgJigyoshaItiran.setYukoKigen(RString.EMPTY);
                    }
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            }
            div.getPanelInput().setVisible(false);
            div.getDgKoufuKaishu().getGridSetting().getColumn(new RString("status")).setVisible(false);
            div.getDgKoufuKaishu().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgKoufuKaishu().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgKoufuKaishu().getGridSetting().setIsShowRowState(false);
        }
        if (状態_更新.equals(状態)) {
            List<ShoKofuKaishu> businessList = ShoKofuKaishuJohoManager.createInstance().
                    getShoKofuKaishuJohoList(被保険者番号, false).records();
            Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> shoKofuKaishu = Models.create(businessList);
            ViewStateHolder.put(ViewStateKeys.証交付回収情報, shoKofuKaishu);
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (businessList != null && !businessList.isEmpty()) {
                for (ShoKofuKaishu jigyoshaInput : businessList) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0006), new Code(jigyoshaInput.get交付証種類())));
                    if (jigyoshaInput.get交付年月日() != null && jigyoshaInput.get交付年月日().isValid()) {
                        dgJigyoshaItiran.setKoufuDate(jigyoshaInput.get交付年月日().wareki().toDateString());
                    } else {
                        dgJigyoshaItiran.setKoufuDate(RString.EMPTY);
                    }
                    if (CODESHUBETSU_001.equals(jigyoshaInput.get交付証種類())) {
                        dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0002), new Code(jigyoshaInput.get交付事由())));
                    } else {
                        dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0004), new Code(jigyoshaInput.get交付事由())));
                    }
                    dgJigyoshaItiran.setKoufuJiyuNo(jigyoshaInput.get交付事由());
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    if (jigyoshaInput.get回収年月日() != null && jigyoshaInput.get回収年月日().isValid()) {
                        dgJigyoshaItiran.setKaishuDate((jigyoshaInput.get回収年月日().wareki().toDateString()));
                    } else {
                        dgJigyoshaItiran.setKaishuDate(RString.EMPTY);
                    }
                    if (CODESHUBETSU_001.equals(jigyoshaInput.get交付証種類())) {
                        dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0003), new Code(jigyoshaInput.get回収事由())));
                    } else {
                        dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeRyakusho(new CodeShubetsu(CODESHUBETSU_0005), new Code(jigyoshaInput.get回収事由())));
                    }
                    dgJigyoshaItiran.setKaishuJiyuNo(jigyoshaInput.get回収事由());
                    if (jigyoshaInput.get有効期限() != null && jigyoshaInput.get有効期限().isValid()) {
                        dgJigyoshaItiran.setYukoKigen((jigyoshaInput.get有効期限().wareki().toDateString()));
                    } else {
                        dgJigyoshaItiran.setYukoKigen(RString.EMPTY);
                    }
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgJigyoshaItiran.setRirekiNo(new RString(jigyoshaInput.get履歴番号()));
                    dgJigyoshaItiran.setKoufuTypeNo(jigyoshaInput.get交付証種類());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            }
            div.getDgKoufuKaishu().getGridSetting().setIsShowSelectButtonColumn(false);
            div.getPanelInput().getBtnCancel().setDisabled(true);
            div.getPanelInput().getBtnConfirm().setDisabled(true);
        }
    }

    /**
     * 適用情報一覧を取得します。
     *
     * @return 適用情報一覧 適用情報一覧
     */
    public List<dgKoufuKaishu_Row> get証交付回収情報一覧() {
        return div.getDgKoufuKaishu().getDataSource();
    }

    private List<KeyValueDataSource> getCode(CodeShubetsu codeShubetsu) {
        List<UzT0007CodeEntity> codeValueList = CodeMaster.getCode(codeShubetsu);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (UzT0007CodeEntity codeValueObject : codeValueList) {
            dataSourceList.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード略称()));
        }
        return dataSourceList;
    }

    /**
     * 証交付回収情報の共有子DIVの画面内容から、証交付回収情報をDBに反映します。
     */
    public void saveShoKaishuKirokuKanri() {
        Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> 証交付回収情報Model
                = ViewStateHolder.get(ViewStateKeys.証交付回収情報, Models.class);
        List<dgKoufuKaishu_Row> listRow = div.getDgKoufuKaishu().getDataSource();
        for (dgKoufuKaishu_Row dgKoufuKaishu : listRow) {
            ShoKofuKaishuIdentifier key = new ShoKofuKaishuIdentifier(
                    ViewStateHolder.get(ViewStateKeys.証交付回収情報_被保番号, HihokenshaNo.class),
                    dgKoufuKaishu.getKoufuTypeNo(), Integer.valueOf(dgKoufuKaishu.getRirekiNo().toString()));
            ShoKofuKaishu shoKofuKaishu = 証交付回収情報Model.get(key);
            ShoKofuKaishuBuilder builder = shoKofuKaishu.createBuilderForEdit();

            if (追加.equals(dgKoufuKaishu.getStatus())) {
                builder.set交付年月日(new FlexibleDate(new RDate(dgKoufuKaishu.getKoufuDate().toString()).toDateString()));
                builder.set有効期限(new FlexibleDate(new RDate(dgKoufuKaishu.getYukoKigen().toString()).toDateString()));
                builder.set交付事由(dgKoufuKaishu.getKoufuJiyuNo());
                builder.set交付理由(dgKoufuKaishu.getKofuRiyu());
                builder.set回収年月日(new FlexibleDate(new RDate(dgKoufuKaishu.getKaishuDate().toString()).toDateString()));
                builder.set回収事由(dgKoufuKaishu.getKaishuJiyuNo());
                builder.set回収理由(dgKoufuKaishu.getKaishuRiyu());
                builder.set発行処理日時(YMDHMS.now());
                ShoKofuKaishuJohoManager.createInstance().証交付回収情報の追加(builder.build());
            }
            if (更新.equals(dgKoufuKaishu.getStatus())) {
                builder.set交付年月日(new FlexibleDate(new RDate(dgKoufuKaishu.getKoufuDate().toString()).toDateString()));
                builder.set有効期限(new FlexibleDate(new RDate(dgKoufuKaishu.getYukoKigen().toString()).toDateString()));
                builder.set交付事由(dgKoufuKaishu.getKoufuJiyuNo());
                builder.set交付理由(dgKoufuKaishu.getKofuRiyu());
                builder.set回収年月日(new FlexibleDate(new RDate(dgKoufuKaishu.getKaishuDate().toString()).toDateString()));
                builder.set回収事由(dgKoufuKaishu.getKaishuJiyuNo());
                builder.set回収理由(dgKoufuKaishu.getKaishuRiyu());
                builder.set発行処理日時(YMDHMS.now());
                ShoKofuKaishuJohoManager.createInstance().証交付回収情報の更新(builder.build());
            }
            if (削除.equals(dgKoufuKaishu.getStatus())) {
                builder.set論理削除フラグ(true);
                ShoKofuKaishuJohoManager.createInstance().証交付回収情報の削除(builder.build());
            }
        }
    }

    /**
     * 証交付回収情報の共有子DIVの画面内容から、状態の修正に反映します。
     *
     * @param 状態 状態
     */
    public void 状態の修正(RString 状態) {
        dgKoufuKaishu_Row dgKoufuKaishuRow = div.getDgKoufuKaishu().getSelectedItems().get(0);
        if (被保険者証.equals(dgKoufuKaishuRow.getKoufuType())) {
            div.getPanelInput().getDdlKoufuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0002)));
        } else {
            div.getPanelInput().getDdlKoufuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0004)));
        }
        if (被保険者証.equals(dgKoufuKaishuRow.getKoufuType())) {
            div.getPanelInput().getDdlKaisyuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0003)));
        } else {
            div.getPanelInput().getDdlKaisyuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0005)));
        }
        div.getPanelInput().getTxtKoufuType().setValue(dgKoufuKaishuRow.getKoufuType());
        div.getPanelInput().getTxtKoufuDate().setValue(new RDate(dgKoufuKaishuRow.getKoufuDate().toString()));
        div.getPanelInput().getTxtYukouKigen().setValue(new RDate(dgKoufuKaishuRow.getYukoKigen().toString()));
        div.getPanelInput().getDdlKoufuJiyu().setSelectedKey(dgKoufuKaishuRow.getKoufuJiyuNo());
        div.getPanelInput().getTxaKoufuRiyu().setValue(dgKoufuKaishuRow.getKofuRiyu());
        div.getPanelInput().getTxtKaisyuDate().setValue(new RDate(dgKoufuKaishuRow.getKaishuDate().toString()));
        div.getPanelInput().getDdlKaisyuJiyu().setSelectedKey(dgKoufuKaishuRow.getKaishuJiyuNo());
        div.getPanelInput().getTxaKaishuRiyu().setValue(dgKoufuKaishuRow.getKaishuRiyu());
        div.getPanelInput().getBtnConfirm().setDisabled(false);
        div.getPanelInput().getBtnCancel().setDisabled(false);

        if (状態_削除.equals(状態)) {

            div.setMode_DisplayMode(ShoKaishuKirokuKanriDiv.DisplayMode.sakujyo);
        } else {
            div.setMode_DisplayMode(ShoKaishuKirokuKanriDiv.DisplayMode.koshin);
        }
    }
}
