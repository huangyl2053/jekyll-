/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5110011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150020.DBC150020_NenreikaikyuRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011.RiyojokyoTokeihyoDiv;
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
    private static final RString コード_111 = new RString("111");
    private static final RString コード_120 = new RString("120");
    private static final RString コード_112 = new RString("112");
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
            tmpFlexibleDate = new FlexibleDate(div.getTasyoNengetu().getValue().toDateString());
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

        if (コード_120.equals(div.getChikushichosonSelect().get導入形態コード())) {
            batchParamter.setSentakuTaisyoKubun(div.getChikushichosonSelect().get選択対象());
            batchParamter.setSentakuTaisyoList(div.getChikushichosonSelect().get選択結果());
        }
        if (コード_111.equals(div.getChikushichosonSelect().get導入形態コード())
                || コード_112.equals(div.getChikushichosonSelect().get導入形態コード())) {
            batchParamter.setShichosonCode(new Code(div.getChikushichosonSelect().get市町村コード()));
            batchParamter.setShichosonMeisho(div.getChikushichosonSelect().get市町村名称());
            batchParamter.setKyoShichosonCode(new Code(div.getChikushichosonSelect().get旧市町村コード()));
            batchParamter.setKyoShichosonMeisho(div.getChikushichosonSelect().get旧市町村名称());
        }

        return batchParamter;

    }

}
