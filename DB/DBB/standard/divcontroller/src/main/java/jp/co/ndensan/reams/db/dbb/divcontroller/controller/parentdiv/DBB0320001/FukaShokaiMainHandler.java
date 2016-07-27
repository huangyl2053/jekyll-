/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input.FukaHikakuInput;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001KihonJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaRirekiAllPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.dgFukaRirekiFukaRireki_Row;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.util.ConversionUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * {@link FukaShokaiMainDiv}に対する処理をハンドリングします。
 */
public class FukaShokaiMainHandler {

    private final FukaShokaiMainDiv div;

    /**
     * 指定の{@link FukaShokaiMainDiv}を操作するインスタンスを生成します。
     *
     * @param div {@link FukaShokaiMainDiv}
     */
    public FukaShokaiMainHandler(FukaShokaiMainDiv div) {
        this.div = div;
    }

    /**
     * 初期化します。
     *
     * @return 初期化時の状態を返却します。
     */
    public DBB0320001StateName initialize() {
        FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        initializeHeader(this.div.getDBB0320001KihonJoho(), taishoshaKey);
        if (!taishoshaKey.get賦課年度().isValid()) {
            div.getCcdFukaRirekiAll().load(taishoshaKey.get被保険者番号());
            return DBB0320001StateName.賦課履歴;
        } else {
            new FukakonkyoAndKiwariPresenter(this.div.getFukaShokaiControl(), this.div.getFukakonkyoAndKiwari())
                    .set賦課(taishoshaKey);
            return DBB0320001StateName.賦課根拠期割;
        }
    }

    private static void initializeHeader(DBB0320001KihonJohoDiv div, FukaTaishoshaKey key) {
        div.getCcdKaigoAtenaInfo().initialize(key.get識別コード());
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(
                key.get通知書番号(),
                key.get賦課年度(),
                key.get市町村コード(),
                key.get識別コード()).build();
        div.getCcdKaigoFukaKihon().load(searchKey);
    }

    /**
     * 全賦課履歴を表示します。
     */
    public void show全賦課履歴() {
        if (!div.getCcdFukaRirekiAll().hasLoaded()) {
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            this.div.getCcdFukaRirekiAll().load(taishoshaKey.get被保険者番号());
        } else {
//            FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
//            div.getCcdFukaRirekiAll().reload(key.get通知書番号());
        }
    }

    /**
     * 賦課履歴一覧を表示します。
     */
    public void show賦課履歴一覧() {
        IItemList<Fuka> selectedRows = this.div.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All().reversed();
        new FukaRirekiPanelPresenter(this.div.getFukaRirekiPanel())
                .set賦課履歴(selectedRows);
    }

    /**
     * 履歴一覧中で選択された項目の賦課根拠・期割額を表示します。
     */
    public void show賦課根拠期割() {
        new FukakonkyoAndKiwariPresenter(this.div.getFukaShokaiControl(), this.div.getFukakonkyoAndKiwari())
                .set賦課Nullable(clicked賦課(this.div).orElse(null));
    }

    private static Optional<Fuka> clicked賦課(FukaShokaiMainDiv div) {
        dgFukaRirekiFukaRireki_Row clicked = div.getDgFukaRirekiFukaRireki().getClickedItem();
        FukaNendo fukaNendo = new FukaNendo(div.getTxtFukaNendoFukaRireki().getDomain());
        ChoteiNendo choteiNendo = new ChoteiNendo(clicked.getTxtChoteiNendoHidden().toString());
        TsuchishoNo tsuchishoNo = new TsuchishoNo(clicked.getTxtTsuchishoNo());
        int rirekiNo = ConversionUtil.toIntOrDefualt(clicked.getRirekiNo(), -1);
        return div.getCcdFukaRirekiAll().get賦課履歴()
                .get賦課履歴(fukaNendo, choteiNendo, tsuchishoNo, rirekiNo);
    }

    /**
     * 前履歴との比較をします。
     */
    public void compareWith前履歴() {
        Fuka atoFuka = clicked賦課(div).get();
        FukaShokaiKey atoRireki = ViewStateKeyCreator.createFukaShokaiKey(atoFuka, new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        ViewStateHolder.put(ViewStateKeys.賦課照会キー, atoRireki);

        final FukaManager manager = new FukaManager();
        FukaShokaiKey maeRireki = ViewStateKeyCreator.createFukaShokaiKey(
                manager.get介護賦課For任意対象比較(atoFuka.get調定年度(), atoFuka.get賦課年度(), atoFuka.get通知書番号(), atoFuka.get履歴番号()).get(),
                new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        ViewStateHolder.put(ViewStateKeys.賦課比較キー, FukaHikakuInput.createFor前履歴との比較(atoRireki, maeRireki));
    }
}
