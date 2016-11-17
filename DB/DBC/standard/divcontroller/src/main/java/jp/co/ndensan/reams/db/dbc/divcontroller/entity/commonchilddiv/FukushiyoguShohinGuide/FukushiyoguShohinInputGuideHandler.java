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
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 *
 * 福祉用具商品名入力ガイドの取得するクラスです。
 *
 * @reamsid_L DBC-0970-020 lizhuoxuan
 */
public class FukushiyoguShohinInputGuideHandler {

    private final FukushiyoguShohinGuideDiv div;
    private boolean False;
    private static final RString 初期状態 = new RString("初期状態");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");

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

        初期状態.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class));
        div.getDgFukushiyoguShohin().setDataSource(setDataSourcre());
        div.getPanInput().setVisible(false);
        div.getBtnSave().setVisible(False);
    }

    private List<dgFukushiyoguShohin_Row> setDataSourcre() {
        div.getTxtKijunDay().setValue(RDate.getNowDate());
        return setShohinSourcre(FlexibleDate.getNowDate());
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 福祉用具商品名入力ガイド状態処理する。
     *
     * @param 状態 福祉用具商品名入力ガイド
     */
    public void 状態の調整(RString 状態) {
        if (!div.getPanInput().getState().equals(追加)) {
            dgFukushiyoguShohin_Row dgfukushiyogushohinRow = div.getDgFukushiyoguShohin().getSelectedItems().get(0);

            div.getPanInput().setShohinNo(dgfukushiyogushohinRow.getShohinNo());
            div.getPanInput().getTxtKanriKaishiDay().setValue(dgfukushiyogushohinRow.getKanriKaishiYMD().getValue());
            div.getPanInput().getTxtKanriShuryoDay().setValue(dgfukushiyogushohinRow.getKanriShuryoYMD().getValue());
            div.getPanInput().getTxtShohinmei().setValue(dgfukushiyogushohinRow.getShohinmei());
            div.getPanInput().getTxtSeizoJigyoshamei().setValue(dgfukushiyogushohinRow.getSeizoJigyoshamei());
            div.getPanInput().getTxtHinmokuCode().setValue(dgfukushiyogushohinRow.getHinmokuCode());
            div.getPanInput().setKanriKaishiDay(dgfukushiyogushohinRow.getKanriKaishiYMD().getValue().toDateString());
        } else {
            div.getPanInput().setShohinNo(RString.EMPTY);
            div.getPanInput().getTxtKanriKaishiDay().clearValue();
            div.getPanInput().getTxtKanriShuryoDay().clearValue();
            div.getPanInput().getTxtShohinmei().clearValue();
            div.getPanInput().getTxtSeizoJigyoshamei().clearValue();
            div.getPanInput().getTxtHinmokuCode().clearValue();
        }
        if (追加.equals(状態) || 修正.equals(状態)) {
            div.getPanInput().getTxtKanriKaishiDay().setReadOnly(false);
            div.getPanInput().getTxtKanriShuryoDay().setReadOnly(false);
            div.getPanInput().getTxtShohinmei().setReadOnly(false);
            div.getPanInput().getTxtSeizoJigyoshamei().setReadOnly(false);
            div.getPanInput().getTxtHinmokuCode().setReadOnly(false);
        } else {
            div.getPanInput().getTxtKanriKaishiDay().setReadOnly(true);
            div.getPanInput().getTxtKanriShuryoDay().setReadOnly(true);
            div.getPanInput().getTxtShohinmei().setReadOnly(true);
            div.getPanInput().getTxtSeizoJigyoshamei().setReadOnly(true);
            div.getPanInput().getTxtHinmokuCode().setReadOnly(true);
        }
    }

    /**
     * 福祉用具商品名入力ガイド検索処理する。
     */
    public void kennsaku() {
        List<dgFukushiyoguShohin_Row> dgFukushiyoguShohinList = new ArrayList();
        if (div.getTxtKijunDay().getValue() != null && !div.getTxtKijunDay().getValue().toDateString().equals(RString.EMPTY)) {
            dgFukushiyoguShohinList.addAll(setShohinSourcre(new FlexibleDate(div.getTxtKijunDay().getValue().toDateString())));
        }
        div.getDgFukushiyoguShohin().setDataSource(dgFukushiyoguShohinList);
    }

    private List<dgFukushiyoguShohin_Row> setShohinSourcre(FlexibleDate date) {

        List<FukushiyoguShohin> businessList = FukushiyoguShohinInputGuideManager.createInstance()
                .getFukushiyoguShohinList(date).records();
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
        } else {
            div.getDgFukushiyoguShohin().getDataSource().clear();
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
        return dgFukushiyoguShohinList;
    }
}
