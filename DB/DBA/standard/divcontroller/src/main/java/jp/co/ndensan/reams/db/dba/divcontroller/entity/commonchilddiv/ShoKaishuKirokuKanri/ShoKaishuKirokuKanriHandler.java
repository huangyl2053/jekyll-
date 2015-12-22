/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.ShoKofuKaishuJohoModel;
import jp.co.ndensan.reams.db.dba.service.core.shokofukaishujoho.ShoKofuKaishuJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 証交付回収情報の取得するクラスです。
 */
public class ShoKaishuKirokuKanriHandler {

    private final ShoKaishuKirokuKanriDiv div;
    private boolean False;

    /**
     * コンストラクタです。
     *
     * @param div 証交付回収情報パネル
     */
    public ShoKaishuKirokuKanriHandler(ShoKaishuKirokuKanriDiv div) {
        this.div = div;
    }

    /**
     * 対象事業者を検索する。
     */
    public void initialize() {

        List<UzT0007CodeEntity> 交付事由CodeValueList = CodeMaster.getCode(new CodeShubetsu("0014"));
        List<KeyValueDataSource> 交付事由 = new ArrayList<>();
        for (UzT0007CodeEntity codeValueObject : 交付事由CodeValueList) {
            交付事由.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード名称()));
        }
        div.getPanelInput().getDdlKoufuJiyu().setDataSource(交付事由);
        List<UzT0007CodeEntity> 回収事由CodeValueList = CodeMaster.getCode(new CodeShubetsu("0015"));
        List<KeyValueDataSource> 回収事由 = new ArrayList<>();
        for (UzT0007CodeEntity codeValueObject : 回収事由CodeValueList) {
            回収事由.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード名称()));
        }
        div.getPanelInput().getDdlKaisyuJiyu().setDataSource(回収事由);
        if (new RString("照会").equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<ShoKofuKaishuJohoModel> businessList = ShoKofuKaishuJohoManager.createInstance().getShoKofuKaishuJohoList(new HihokenshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class)), False).records();
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (businessList != null && !businessList.isEmpty()) {

                for (ShoKofuKaishuJohoModel jigyoshaInput : businessList) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu("0014"), new Code(jigyoshaInput.get交付証種類コード())));
                    dgJigyoshaItiran.setKoufuDate(new RString(jigyoshaInput.get交付年月日().toString()));
                    dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0116"), new Code(jigyoshaInput.get交付事由コード())));
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    dgJigyoshaItiran.setKaishuDate(new RString(jigyoshaInput.get回収年月日().toString()));
                    dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0015"), new Code(jigyoshaInput.get回収事由コード())));
                    dgJigyoshaItiran.setYukoKigen(new RString(jigyoshaInput.get有効期限().toString()));
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            }
            div.getPanelInput().setVisible(False);
            div.getDgKoufuKaishu().getGridSetting().setIsShowDeleteButtonColumn(False);
            div.getDgKoufuKaishu().getGridSetting().setIsShowModifyButtonColumn(False);
            div.getDgKoufuKaishu().getGridSetting().setIsShowRowState(False);
        }
        if (new RString("更新").equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<ShoKofuKaishuJohoModel> businessList = ShoKofuKaishuJohoManager.createInstance().getShoKofuKaishuJohoList(new HihokenshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class)), False).records();
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (businessList != null && !businessList.isEmpty()) {

                for (ShoKofuKaishuJohoModel jigyoshaInput : businessList) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu("0014"), new Code(jigyoshaInput.get交付証種類コード())));
                    dgJigyoshaItiran.setKoufuDate(new RString(jigyoshaInput.get交付年月日().toString()));
                    dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0116"), new Code(jigyoshaInput.get交付事由コード())));
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    dgJigyoshaItiran.setKaishuDate(new RString(jigyoshaInput.get回収年月日().toString()));
                    dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu("0015"), new Code(jigyoshaInput.get回収事由コード())));
                    dgJigyoshaItiran.setYukoKigen(new RString(jigyoshaInput.get有効期限().toString()));
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            }
            div.getDgKoufuKaishu().getGridSetting().setIsShowSelectButtonColumn(False);
            div.getPanelInput().getBtnCancel().setDisabled(true);
            div.getPanelInput().getBtnConfirm().setDisabled(true);
        }
    }
}
