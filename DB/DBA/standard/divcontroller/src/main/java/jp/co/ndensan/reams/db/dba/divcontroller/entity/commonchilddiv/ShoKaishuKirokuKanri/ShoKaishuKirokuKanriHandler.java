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
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_更新 = new RString("更新");
    private static final RString CODESHUBETSU_0014 = new RString("0014");
    private static final RString CODESHUBETSU_0015 = new RString("0015");
    private static final RString CODESHUBETSU_0116 = new RString("0116");

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
     */
    public void initialize() {

        div.getPanelInput().getDdlKoufuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0116)));
        div.getPanelInput().getDdlKaisyuJiyu().setDataSource(getCode(new CodeShubetsu(CODESHUBETSU_0015)));
        if (状態_照会.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<ShoKofuKaishuJohoModel> businessList = ShoKofuKaishuJohoManager.createInstance()
                    .getShoKofuKaishuJohoList(new HihokenshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class)), False).records();
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (businessList != null && !businessList.isEmpty()) {

                for (ShoKofuKaishuJohoModel jigyoshaInput : businessList) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0014), new Code(jigyoshaInput.get交付証種類コード())));
                    dgJigyoshaItiran.setKoufuDate(jigyoshaInput.get交付年月日().wareki().toDateString());
                    dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0116), new Code(jigyoshaInput.get交付事由コード())));
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    dgJigyoshaItiran.setKaishuDate((jigyoshaInput.get回収年月日().wareki().toDateString()));
                    dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0015), new Code(jigyoshaInput.get回収事由コード())));
                    dgJigyoshaItiran.setYukoKigen((jigyoshaInput.get有効期限().wareki().toDateString()));
                    dgJigyoshaItiran.setKaishuRiyu(jigyoshaInput.get回収理由());
                    dgKoufuKaishuList.add(dgJigyoshaItiran);
                }
                div.getDgKoufuKaishu().setDataSource(dgKoufuKaishuList);
            }
            div.getPanelInput().setVisible(False);
            div.getDgKoufuKaishu().getGridSetting().getColumn(new RString("status")).setVisible(False);
            div.getDgKoufuKaishu().getGridSetting().setIsShowDeleteButtonColumn(False);
            div.getDgKoufuKaishu().getGridSetting().setIsShowModifyButtonColumn(False);
            div.getDgKoufuKaishu().getGridSetting().setIsShowRowState(False);
        }
        if (状態_更新.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            List<ShoKofuKaishuJohoModel> businessList = ShoKofuKaishuJohoManager.createInstance().
                    getShoKofuKaishuJohoList(new HihokenshaNo(ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class)), False).records();
            List<dgKoufuKaishu_Row> dgKoufuKaishuList = new ArrayList();
            if (businessList != null && !businessList.isEmpty()) {

                for (ShoKofuKaishuJohoModel jigyoshaInput : businessList) {
                    dgKoufuKaishu_Row dgJigyoshaItiran = new dgKoufuKaishu_Row();
                    dgJigyoshaItiran.setKoufuType(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0014), new Code(jigyoshaInput.get交付証種類コード())));
                    dgJigyoshaItiran.setKoufuDate(jigyoshaInput.get交付年月日().wareki().toDateString());
                    dgJigyoshaItiran.setKoufuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0116), new Code(jigyoshaInput.get交付事由コード())));
                    dgJigyoshaItiran.setKofuRiyu(jigyoshaInput.get交付理由());
                    dgJigyoshaItiran.setKaishuDate((jigyoshaInput.get回収年月日().wareki().toDateString()));
                    dgJigyoshaItiran.setKaishuJiyu(CodeMaster.getCodeMeisho(new CodeShubetsu(CODESHUBETSU_0015), new Code(jigyoshaInput.get回収事由コード())));
                    dgJigyoshaItiran.setYukoKigen((jigyoshaInput.get有効期限().wareki().toDateString()));
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

    private List<KeyValueDataSource> getCode(CodeShubetsu codeShubetsu) {

        List<UzT0007CodeEntity> codeValueList = CodeMaster.getCode(codeShubetsu);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (UzT0007CodeEntity codeValueObject : codeValueList) {
            dataSourceList.add(new KeyValueDataSource(codeValueObject.getコード().getKey(), codeValueObject.getコード名称()));
        }
        return dataSourceList;
    }
}
