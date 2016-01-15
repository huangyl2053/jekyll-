/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.FukushiyoguShohin;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogushohin.FukushiyoguShohinInputGuideManager;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 *
 * 福祉用具商品名入力ガイドの取得するクラスです。
 */
public class FukushiyoguShohinInputGuideHandler {

    private final FukushiyoguShohinGuideDiv div;
    private boolean False;
    private static final RString 初期状態 = new RString("初期状態");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div 福祉用具商品名入力ガイド
     */
    public FukushiyoguShohinInputGuideHandler(FukushiyoguShohinGuideDiv div) {
        this.div = div;
    }

    /**
     * 福祉用具商品名入力ガイド初期処理する。
     */
    public void initialize() {

        if (初期状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getDgFukushiyoguShohin().setDataSource(setDataSourcre());
            div.getPanInput().setVisible(false);
            div.getBtnSave().setVisible(False);
        }
    }

    private List<dgFukushiyoguShohin_Row> setDataSourcre() {
        div.getTxtKijunDay().setValue(RDate.getNowDate());
        List<FukushiyoguShohin> businessList = FukushiyoguShohinInputGuideManager.createInstance()
                .getFukushiyoguShohinList(FlexibleDate.getNowDate()).records();
        List<dgFukushiyoguShohin_Row> dgFukushiyoguShohinList = new ArrayList();
        if (businessList != null && !businessList.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.福祉用具商品名入力ガイド検索結果, Models.create(businessList));
            for (FukushiyoguShohin jigyoshaInput : businessList) {
                dgFukushiyoguShohin_Row dgFukushiyoguShohin = new dgFukushiyoguShohin_Row();
                dgFukushiyoguShohin.setShohinNo(nullToEmpty(jigyoshaInput.get商品番号()));
                if (jigyoshaInput.get管理開始年月日() != null) {
                    dgFukushiyoguShohin.getKanriKaishiYMD().setValue(new RDate(jigyoshaInput.get管理開始年月日().toString()));
                }
                if (jigyoshaInput.get管理終了年月日() != null) {
                    dgFukushiyoguShohin.getKanriShuryoYMD().setValue(new RDate(jigyoshaInput.get管理終了年月日().toString()));
                }
                dgFukushiyoguShohin.setShohinmei(nullToEmpty(jigyoshaInput.get商品名()));
                dgFukushiyoguShohin.setSeizoJigyoshamei(nullToEmpty(jigyoshaInput.get製造事業者名()));
                dgFukushiyoguShohin.setHinmokuCode(nullToEmpty(jigyoshaInput.get品目コード()));
                dgFukushiyoguShohinList.add(dgFukushiyoguShohin);
            }
        }
        return dgFukushiyoguShohinList;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 福祉用具商品名入力ガイド検索処理する。
     */
    public void kennsaku() {
        List<dgFukushiyoguShohin_Row> dgFukushiyoguShohinList = new ArrayList();
        if (div.getTxtKijunDay().getValue() != null && !div.getTxtKijunDay().getValue().equals(RString.EMPTY)) {
            List<FukushiyoguShohin> businessList = FukushiyoguShohinInputGuideManager.createInstance()
                    .getFukushiyoguShohinList(new FlexibleDate(div.getTxtKijunDay().getValue().toDateString())).records();
            ViewStateHolder.put(ViewStateKeys.福祉用具商品名入力ガイド検索結果, Models.create(businessList));
            if (businessList != null && !businessList.isEmpty()) {
                for (FukushiyoguShohin jigyoshaInput : businessList) {
                    dgFukushiyoguShohin_Row dgFukushiyoguShohin = new dgFukushiyoguShohin_Row();
                    dgFukushiyoguShohin.setShohinNo(jigyoshaInput.get商品番号());
                    dgFukushiyoguShohin.getKanriKaishiYMD().setValue(new RDate(jigyoshaInput.get管理開始年月日().toString()));
                    if (jigyoshaInput.get管理終了年月日() != null) {
                        dgFukushiyoguShohin.getKanriShuryoYMD().setValue(new RDate(jigyoshaInput.get管理終了年月日().toString()));
                    }
                    dgFukushiyoguShohin.setShohinmei(nullToEmpty(jigyoshaInput.get商品名()));
                    dgFukushiyoguShohin.setSeizoJigyoshamei(nullToEmpty(jigyoshaInput.get製造事業者名()));
                    dgFukushiyoguShohin.setHinmokuCode(nullToEmpty(jigyoshaInput.get品目コード()));
                    dgFukushiyoguShohinList.add(dgFukushiyoguShohin);
                }
            }
        }
        div.getDgFukushiyoguShohin().setDataSource(dgFukushiyoguShohinList);
    }
}
