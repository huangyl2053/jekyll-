/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1090011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA340010.DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1090011.MishorishaIchiranSakuseiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1090011.MishorishaIchiranSakuseiHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1090011.MishorishaIchiranSakuseiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 転入転出未登録一覧表です。
 *
 * @reamsid_L DBU-4110-010 yaodongsheng
 */
public class MishorishaIchiranSakusei {

    private static final RString KEY = new RString("000000");

    /**
     * 転入・転出未登録一覧表の初期化。<br/>
     *
     * @param div MishorishaIchiranSakuseiDiv
     * @return ResponseData<MishorishaIchiranSakuseiDiv>
     */
    public ResponseData<MishorishaIchiranSakuseiDiv> onLoad(MishorishaIchiranSakuseiDiv div) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnBatchRegister"), false);
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 転入・転出未登録一覧表の実行。<br/>
     *
     * @param div MishorishaIchiranSakuseiDiv
     * @return ResponseData<MishorishaIchiranSakuseiDiv>
     */
    public ResponseData<MishorishaIchiranSakuseiDiv> onClick_btnCheck(MishorishaIchiranSakuseiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).checkMsg());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 転入転出未登録一覧表の実施button。<br/>
     *
     * @param div MishorishaIchiranSakuseiDiv
     * @return ResponseData<TennyuTensyutsuMiTorokuIchiranhyoBatchParameter>
     */
    public ResponseData<DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter> onClick_btnBatchRegister(
            MishorishaIchiranSakuseiDiv div) {
        return ResponseData.of(setParameter(div)).respond();
    }

    private DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter setParameter(MishorishaIchiranSakuseiDiv div) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        List<LasdecCode> shichosoncode = new ArrayList<>();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            if (KEY.equals(div.getBatchParamterInfo().getDdlShichoson().getSelectedKey())) {
                setShichosoncode(div, shichosoncode);
            } else {
                shichosoncode.add(new LasdecCode(div.getBatchParamterInfo().getDdlShichoson().getSelectedKey()));
            }
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)) {
            shichosoncode.add(AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_());
        }
        List<RString> tensyutsusakuseiJiyucode = new ArrayList<>();
        for (RString tensyutsuKey : div.getBatchParamterInfo().getChkTenshutsuSakuseiJiyu().getSelectedKeys()) {
            tensyutsusakuseiJiyucode.add(tensyutsuKey);
        }
        List<RString> tennyusakuseijiyucode = new ArrayList<>();
        for (RString tennyuKey : div.getBatchParamterInfo().getChkTennyuSakuseiJiyu().getSelectedKeys()) {
            tennyusakuseijiyucode.add(tennyuKey);
        }
        FlexibleDate kaishinichi = div.getBatchParamterInfo().getTxtZenkaiKaishi().getValue();
        FlexibleDate syuryonichi = div.getBatchParamterInfo().getTxtZenkaiKara().getValue();
        Long cyohyosyutsuryokujyunid = div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().get出力順ID();
        return new DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter(shichosoncode, tensyutsusakuseiJiyucode, tennyusakuseijiyucode, kaishinichi,
                syuryonichi, cyohyosyutsuryokujyunid);
    }

    private void setShichosoncode(MishorishaIchiranSakuseiDiv div, List<LasdecCode> shichosoncode) {
        int i = 0;
        for (KeyValueDataSource data : div.getBatchParamterInfo().getDdlShichoson().getDataSource()) {
            if (i != 0) {
                shichosoncode.add(new LasdecCode(data.getKey()));
            }
            i++;
        }
    }

    private MishorishaIchiranSakuseiValidationHandler getValidationHandler(MishorishaIchiranSakuseiDiv requestDiv) {
        return new MishorishaIchiranSakuseiValidationHandler(requestDiv);
    }

    private MishorishaIchiranSakuseiHandler getHandler(MishorishaIchiranSakuseiDiv requestDiv) {
        return new MishorishaIchiranSakuseiHandler(requestDiv);
    }
}
