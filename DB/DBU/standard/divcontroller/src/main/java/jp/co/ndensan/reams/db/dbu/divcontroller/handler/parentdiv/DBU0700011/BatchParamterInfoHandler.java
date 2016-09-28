/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0700011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050020.DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist.KouikiTenkyoResultListBatchParameterSakusei;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kouikitenkyoresultlist.KouikiTenkyoResultListSakuseiParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 広域内転居結果一覧表Handlerクラスです。
 *
 * @reamsid_L DBU-1150-010 gongliang
 */
public class BatchParamterInfoHandler {

    private static final RString 市町村DDL1件目コード = new RString("000000");
    private static final RString 市町村DDL1件目名称 = new RString("全市町村");
    private static final RString 市町村DDL1件目キー = new RString("0");

    private final BatchParamterInfoDiv div;

    /**
     * 広域内転居結果一覧表Handler
     *
     * @param div BatchParamterInfoDiv
     */
    public BatchParamterInfoHandler(BatchParamterInfoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化onLoad Handler処理
     *
     * @param 市町村List SearchResult<KoikiZenShichosonJoho>
     */
    public void onLoad(SearchResult<KoikiZenShichosonJoho> 市町村List) {
        List<KeyValueDataSource> 市町村DDL = new ArrayList<>();
        RStringBuilder 一件目名称 = new RStringBuilder();
        一件目名称.append(市町村DDL1件目コード);
        一件目名称.append(RString.HALF_SPACE);
        一件目名称.append(市町村DDL1件目名称);
        市町村DDL.add(new KeyValueDataSource(市町村DDL1件目キー, 一件目名称.toRString()));
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
        div.getDdlshichosonshitei().setSelectedKey(市町村DDL1件目キー);
        div.getTxtkaishihi().setValue(FlexibleDate.getNowDate());
        div.getTxtshohi().setValue(FlexibleDate.getNowDate());
    }

    /**
     * バッチパラメータを取得
     *
     * @return DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter
     */
    public DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter setBatchParamter() {
        DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter paramter = new DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter();

        KouikiTenkyoResultListSakuseiParameter param1 = new KouikiTenkyoResultListSakuseiParameter();
        param1.setKaishihi(div.getTxtkaishihi().getValue());
        param1.setShichosonshitei(div.getDdlshichosonshitei().getSelectedValue());
        param1.setShohi(div.getTxtshohi().getValue());

        KouikiTenkyoResultListBatchParameterSakusei param2 = KouikiTenkyoResultListBatchParameterSakusei
                .getKouikiTenkyoResultListBatchParameter(param1);
        paramter.set市町村コード(new LasdecCode(param2.get市町村コード()));
        paramter.set市町村名称(param2.get市町村名称());
        paramter.set日付From(param2.get日付FROM());
        paramter.set日付To(param2.get日付TO());
        return paramter;
    }
}
