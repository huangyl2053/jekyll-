/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5130011;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150040.DBC150040_HeikinriyogakuTokeihyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5130011.HeikinRiyoGakuTokeihyoDiv;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平均利用額統計表のHandlerクラスです。
 *
 * @reamsid_L DBC-3490-010 sunhaidi
 */
public class HeikinRiyoGakuTokeihyoHandler {

    private final HeikinRiyoGakuTokeihyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HeikinRiyoGakuTokeihyoDiv
     */
    public HeikinRiyoGakuTokeihyoHandler(HeikinRiyoGakuTokeihyoDiv div) {
        this.div = div;
    }

    /**
     * 平均利用額統計表作成のBatchParameterを作成します。
     *
     * @return DBC150040_HeikinriyogakuTokeihyoParameter
     */
    public DBC150040_HeikinriyogakuTokeihyoParameter getBatchParameter() {
        DBC150040_HeikinriyogakuTokeihyoParameter parameter = new DBC150040_HeikinriyogakuTokeihyoParameter();

        RString key = div.getRadTaishoYM().getSelectedKey();
        parameter.setTaishoNendoYM(key);
        RDate fromDate = div.getTxtTaishoYmRange().getFromValue();
        RDate toDate = div.getTxtTaishoYmRange().getToValue();
        if (fromDate != null) {
            parameter.setKaishiYM(fromDate.getYearMonth().toDateString());
        }
        if (toDate != null) {
            parameter.setShuryoYM(toDate.getYearMonth().toDateString());
        }
        RString 地区指定 = div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象();
        parameter.setChikuShitei(地区指定);
        Map<String, String> 選択地区Map = div.getChikuShitei().getCcdChikuShichosonSelect().get選択結果();
        parameter.setSelectorChikulist(選択地区Map);
        parameter.setShichosonCode(div.getChikuShitei().getCcdChikuShichosonSelect().get市町村コード());
        parameter.setShichosonMei(div.getChikuShitei().getCcdChikuShichosonSelect().get市町村名称());
        parameter.setKyuShichosonCode(div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村コード());
        parameter.setKyuShichosonMei(div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村名称());
        parameter.setDonyuKeitaiCode(div.getChikuShitei().getCcdChikuShichosonSelect().get導入形態コード());
        return parameter;
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnBatchParameterRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 対象年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("taishoNendoYM"));
        div.getRadTaishoYM().setSelectedKey(対象年月);
        RString 開始年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kaishiYM"));
        if (!RString.isNullOrEmpty(開始年月)) {
            div.getTxtTaishoYmRange().setFromValue(new RDate(開始年月.toString()));
        } else {
            div.getTxtTaishoYmRange().clearFromValue();
        }

        RString 終了年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shuryoYM"));

        if (!RString.isNullOrEmpty(終了年月)) {
            div.getTxtTaishoYmRange().setToValue(new RDate(終了年月.toString()));
        } else {
            div.getTxtTaishoYmRange().clearToValue();
        }

        RString 地区指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chikuShitei"));
        div.getChikuShitei().getCcdChikuShichosonSelect().set選択対象(地区指定);
        div.getChikuShitei().getCcdChikuShichosonSelect().onChange_選択対象DDL();
        Map<String, String> 選択地区Map = restoreBatchParameterMap.getParameterValue(Map.class, new RString("selectorChikulist"));
        div.getChikuShitei().getCcdChikuShichosonSelect().set選択結果(選択地区Map);
        RString 市町村コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shichosonCode"));
        div.getChikuShitei().getCcdChikuShichosonSelect().set市町村コード(市町村コード);
        RString 旧市町村コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kyuShichosonCode"));
        div.getChikuShitei().getCcdChikuShichosonSelect().set旧市町村コード(旧市町村コード);
    }
}
