/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5110011;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150020.DBC150020_NenreikaikyuRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011.RiyojokyoTokeihyoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC5110011_年齢階級別利用状況作成Handlerクラスです。
 *
 * @reamsid_L DBC-3470-010 xuyongchao
 */
public class RiyojokyoTokeihyoHandler {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString SELECT_KEY2 = new RString("key2");
    private static final int 桁_0 = 0;
    private static final int 桁_6 = 6;
    private final RiyojokyoTokeihyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public RiyojokyoTokeihyoHandler(RiyojokyoTokeihyoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        div.getChikushichosonSelect().initialize();
    }

    /**
     * バッチ用パラメータクラスを作成します。
     *
     * @return ninteichosaYoteiMiteiBatchParamter
     */
    public DBC150020_NenreikaikyuRiyojokyoParameter setBatchParameter() {
        DBC150020_NenreikaikyuRiyojokyoParameter batchParamter = new DBC150020_NenreikaikyuRiyojokyoParameter();
        FlexibleDate tmpFlexibleDate = FlexibleDate.EMPTY;
        if (null != div.getTasyoNengetu().getValue()) {
            tmpFlexibleDate = new FlexibleDate(div.getTasyoNengetu().getValue().toDateString().substring(桁_0, 桁_6));
        }
        if (div.getRadTaishoYM().getSelectedKey().equals(SELECT_KEY0)) {
            batchParamter.setServiceTeikyoYM(tmpFlexibleDate);
            batchParamter.setSinsaYM(FlexibleDate.EMPTY);
        } else {
            batchParamter.setSinsaYM(tmpFlexibleDate);
            batchParamter.setServiceTeikyoYM(FlexibleDate.EMPTY);
        }
        if (div.getNenreSansyutuKijyun().getSelectedKey().equals(SELECT_KEY0)) {
            RDate tmpDate = div.getTasyoNengetu().getValue().plusMonth(1);
            batchParamter.setNenreiSansyutuKijyubi(new FlexibleDate(tmpDate.toString().substring(桁_0, 桁_6) + "01"));
        } else if (div.getNenreSansyutuKijyun().getSelectedKey().equals(SELECT_KEY1)) {
            batchParamter.setNenreiSansyutuKijyubi(new FlexibleDate(div.getTasyoNengetu().getValue().toString().substring(桁_0, 桁_6) + "01"));
        } else {
            batchParamter.setNenreiSansyutuKijyubi(new FlexibleDate(div.getTasyoNengetu().getValue().toString()));
        }
        if (DonyuKeitaiCode.事務単一.getCode().equals(div.getChikushichosonSelect().get導入形態コード())) {
            batchParamter.setSentakuTaisyoKubun(div.getChikushichosonSelect().get選択対象());
            batchParamter.setSentakuTaisyoMap(div.getChikushichosonSelect().get選択結果());
            batchParamter.setShichosonCode(Code.EMPTY);
            batchParamter.setShichosonMeisho(RString.EMPTY);
            batchParamter.setKyoShichosonCode(Code.EMPTY);
            batchParamter.setKyoShichosonMeisho(RString.EMPTY);
        }
        if (DonyuKeitaiCode.事務広域.getCode().equals(div.getChikushichosonSelect().get導入形態コード())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(div.getChikushichosonSelect().get導入形態コード())) {
            batchParamter.setSentakuTaisyoKubun(RString.EMPTY);
            Map<RString, RString> map = new HashMap<>();
            map.put(RString.EMPTY, RString.EMPTY);
            batchParamter.setSentakuTaisyoMap(map);
            batchParamter.setShichosonCode(new Code(div.getChikushichosonSelect().get市町村コード()));
            batchParamter.setShichosonMeisho(div.getChikushichosonSelect().get市町村名称());
            batchParamter.setKyoShichosonCode(new Code(div.getChikushichosonSelect().get旧市町村コード()));
            batchParamter.setKyoShichosonMeisho(div.getChikushichosonSelect().get旧市町村名称());
        }
        return batchParamter;
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        FlexibleDate サービス提供年月 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("serviceTeikyoYM"));
        if (サービス提供年月 != null && !サービス提供年月.isEmpty()) {
            div.getTasyoNengetu().setValue(new RDate(サービス提供年月.toString()));
            div.getRadTaishoYM().setSelectedKey(SELECT_KEY0);
        }
        FlexibleDate 審査年月 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("sinsaYM"));
        if (審査年月 != null && !審査年月.isEmpty()) {
            div.getTasyoNengetu().setValue(new RDate(審査年月.toString()));
            div.getRadTaishoYM().setSelectedKey(SELECT_KEY1);
        }
        RDate tmpDate = div.getTasyoNengetu().getValue();
        FlexibleDate 年齢算出基準日 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("nenreiSansyutuKijyubi"));
        if (年齢算出基準日 != null && !年齢算出基準日.isEmpty()) {
            if (new FlexibleDate(tmpDate.plusMonth(1).toString().substring(桁_0, 桁_6) + "01").equals(年齢算出基準日)) {
                div.getNenreSansyutuKijyun().setSelectedKey(SELECT_KEY0);
            } else if (new FlexibleDate(tmpDate.toString().substring(桁_0, 桁_6) + "01").equals(年齢算出基準日)) {
                div.getNenreSansyutuKijyun().setSelectedKey(SELECT_KEY1);
            } else {
                div.getNenreSansyutuKijyun().setSelectedKey(SELECT_KEY2);
            }
        }
        RString 選択対象区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("sentakuTaisyoKubun"));
        if (!RString.isNullOrEmpty(選択対象区分)) {
            div.getChikushichosonSelect().set選択対象(選択対象区分);
            div.getChikushichosonSelect().onChange_選択対象DDL();
        }
        Code 市町村コード = restoreBatchParameterMap.getParameterValue(Code.class, new RString("shichosonCode"));
        if (市町村コード != null && !市町村コード.isEmpty()) {
            div.getChikushichosonSelect().set市町村コード(市町村コード.value());
        }
        Code 旧市町村コード = restoreBatchParameterMap.getParameterValue(Code.class, new RString("kyoShichosonCode"));
        if (旧市町村コード != null && !旧市町村コード.isEmpty()) {
            div.getChikushichosonSelect().set旧市町村コード(旧市町村コード.value());
        }
        Map<RString, RString> 選択結果 = restoreBatchParameterMap.getParameterValue(Map.class, new RString("sentakuKekkaList"));
        if (選択結果 != null && !選択結果.isEmpty()) {
            div.getChikushichosonSelect().set選択結果(選択結果);
        }
    }
}
