/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0700011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hiroshimadomain.HiroshimaDomainBatchParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist.KouikiTenkyoResultListSakuseiParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist.KouikiTenkyoResultListBatchParameterSakusei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
/**
 * 広域内転居結果一覧表Handlerクラスです。
 * 
 * @author きょう亮
 */
public class BatchParamterInfoHandler {
    
    private static final RString 市町村DDL1件目コード = new RString("000000");
    private static final RString 市町村DDL1件目名称 = new RString("全市町村");
    
    private final BatchParamterInfoDiv div;

    public BatchParamterInfoHandler(BatchParamterInfoDiv div) {
        this.div = div;
    }

    public void onLoad(SearchResult<KoikiZenShichosonJoho> 市町村List) {
        List<KeyValueDataSource> 市町村DDL = new ArrayList<>();
        RStringBuilder 一件目名称 = new RStringBuilder();
        一件目名称.append(市町村DDL1件目コード);
        一件目名称.append(RString.HALF_SPACE);
        一件目名称.append(市町村DDL1件目名称);
        市町村DDL.add(new KeyValueDataSource(市町村DDL1件目コード, 一件目名称.toRString()));
        if (市町村List != null) {
            for (int i = 0; i < 市町村List.records().size(); i++) {
                RStringBuilder 二件目名称 = new RStringBuilder();
                二件目名称.append(市町村List.records().get(i).get市町村コード().getColumnValue());
                二件目名称.append(RString.HALF_SPACE);
                二件目名称.append(市町村List.records().get(i).get市町村名称());
                市町村DDL.add(new KeyValueDataSource(new RString(String.valueOf(i + 1)), 二件目名称.toRString()));
            }
        }
        div.getDdlshichosonshitei().setDataSource(市町村DDL);
        div.getDdlshichosonshitei().setSelectedKey(市町村DDL1件目コード);
        div.getTxtkaishihi().setValue(FlexibleDate.getNowDate());
        div.getTxtshohi().setValue(FlexibleDate.getNowDate());
    }

    public void is入力チェック() {
        FlexibleDate kaishihiValue = div.getTxtkaishihi().getValue();
        FlexibleDate shohiValue = div.getTxtshohi().getValue();
        if (null == kaishihiValue || kaishihiValue.isEmpty()
                    || shohiValue == null || shohiValue.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }else if (shohiValue.isBefore(kaishihiValue)) {
                throw new ApplicationException(UrErrorMessages.期間が不正.getMessage());
        }
    }

    /**
     * 「実行する」ボタンを押下
     * @return KoikinaiTenkyoBatchParameter
     */
//    public KouikiTenkyoResultListSakuseiParameter click実行() {
//        HiroshimaDomainBatchParameter paramter = new HiroshimaDomainBatchParameter();
//        KouikiTenkyoResultListSakuseiParameter param = new KouikiTenkyoResultListSakuseiParameter();
//        param.setKaishihi(div.getTxtkaishihi().getValue());
//        param.setShohi(div.getTxtshohi().getValue());
//        param.setShichosonshitei(new RString(市町村[0]));
//        String[] 市町村 = div.getDdlshichosonshitei().getSelectedValue().toString().split(" ");
//        paramter.set市町村コード(new LasdecCode(市町村[0]));
//        paramter.set市町村名称(new RString(市町村[1]));
//        KouikiTenkyoResultListBatchParameterSakusei batchParam =
//                KouikiTenkyoResultListBatchParameterSakusei.getKouikiTenkyoResultListBatchParameter(param);
//        // TODO バッチを起動する
//        return param;
//    }
}
