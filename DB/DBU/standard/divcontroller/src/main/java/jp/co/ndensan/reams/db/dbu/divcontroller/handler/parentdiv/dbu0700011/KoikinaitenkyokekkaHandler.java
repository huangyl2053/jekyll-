/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0700011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist.KouikiTenkyoResultListSakuseiParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist.KouikiTenkyoResultListBatchParameterSakusei;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.koikinaitenkyokekkaDiv;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
public class KoikinaitenkyokekkaHandler {
    
    private static final RString 市町村DDL1件目コード = new RString("000000");
    private static final RString 市町村DDL1件目名称 = new RString("全市町村");
    
    private final koikinaitenkyokekkaDiv div;

    public KoikinaitenkyokekkaHandler(koikinaitenkyokekkaDiv div) {
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
        div.getBatchParamterInfo().getDdlshichosonshitei().setDataSource(市町村DDL);
        div.getBatchParamterInfo().getDdlshichosonshitei().setSelectedKey(市町村DDL1件目コード);
        div.getBatchParamterInfo().getTxtkaishihi().setValue(FlexibleDate.getNowDate());
        div.getBatchParamterInfo().getTxtshohi().setValue(FlexibleDate.getNowDate());
    }

    public void is入力チェック() {
        FlexibleDate kaishihiValue = div.getBatchParamterInfo().getTxtkaishihi().getValue();
        FlexibleDate shohiValue = div.getBatchParamterInfo().getTxtshohi().getValue();
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
    public KouikiTenkyoResultListSakuseiParameter click実行() {
        KouikiTenkyoResultListSakuseiParameter param = new KouikiTenkyoResultListSakuseiParameter();
        param.setKaishihi(div.getBatchParamterInfo().getTxtkaishihi().getValue());
        param.setShohi(div.getBatchParamterInfo().getTxtshohi().getValue());
        param.setShichosonshitei(div.getBatchParamterInfo().getDdlshichosonshitei().getSelectedValue());
        KouikiTenkyoResultListBatchParameterSakusei batchParam =
                KouikiTenkyoResultListBatchParameterSakusei.getKouikiTenkyoResultListBatchParameter(param);
        // TODO バッチを起動する
        return param;
    }
}
