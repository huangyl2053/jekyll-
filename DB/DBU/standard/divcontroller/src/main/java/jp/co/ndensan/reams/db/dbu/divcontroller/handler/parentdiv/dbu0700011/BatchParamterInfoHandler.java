/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0700011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.hiroshimadomain.HiroshimaDomainBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 広域内転居結果一覧表Handlerクラスです。
 *
 */
public class BatchParamterInfoHandler {

    private static final RString 市町村DDL1件目コード = new RString("000000");
    private static final RString 市町村DDL1件目名称 = new RString("全市町村");
    private List<JuminShubetsu> 住民種別List;
    private List<JuminJotai> 住民状態List;

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

    /**
     * バッチパラメータを取得
     *
     * @return HiroshimaDomainBatchParameter
     */
    public HiroshimaDomainBatchParameter setBatchParamter() {
        HiroshimaDomainBatchParameter paramter = new HiroshimaDomainBatchParameter();

        住民種別List = get住民種別List();
        住民状態List = get住民状態List();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        builder.set住民種別(住民種別List);
        builder.set住民状態(住民状態List);
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        paramter.set宛名検索条件(searchKey);
        paramter.set市町村コード(new LasdecCode(div.getDdlshichosonshitei().getSelectedValue().toString().split(" ")[0]));
        paramter.set市町村名称(new RString(div.getDdlshichosonshitei().getSelectedValue().toString().split(" ")[1]));
        paramter.set日付From(div.getTxtkaishihi().getValue());
        paramter.set日付To(div.getTxtshohi().getValue());
        return paramter;
    }

    private List<JuminShubetsu> get住民種別List() {
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        return 住民種別;
    }

    private List<JuminJotai> get住民状態List() {
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.死亡者);
        return 住民状態;
    }
}
