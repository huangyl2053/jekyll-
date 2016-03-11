/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020009;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.ChikuShichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.JiKanKanRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.JiMuSyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo.ChosaSchedulehyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo.ChosaSchedulehyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinHeadItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020009.MainPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 認定調査スケジュール登録9のクラス。
 */
public class MainPanelHandler {

    private final MainPanelDiv div;
    private final RString 全て = new RString("0");
    private static final CodeShubetsu コード種別 = new CodeShubetsu("5002");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * 認定調査スケジュール登録9の初期化を設定します。
     *
     * @param 地区コード 地区コード
     * @param chikuShichosonList 市町村リスト
     */
    public void load(RString 地区コード, List<ChikuShichosonBusiness> chikuShichosonList) {

        div.getPrintConditionPanel().getDdlTaishoChiku().setDataSource(調査地区ドロップダウンリスト());
        div.getPrintConditionPanel().getDdlTaishoChiku().setSelectedKey(地区コード);
        市町村リストの設定(chikuShichosonList);
    }

    /**
     * 市町村リストロップダウンリストを設定します。
     *
     * @param chikuShichosonList 市町村リスト
     */
    public void 市町村リストの設定(List<ChikuShichosonBusiness> chikuShichosonList) {

        div.getPrintConditionPanel().getDdlTaishoShichoson().
                setDataSource(市町村リストロップダウンリスト(chikuShichosonList));
    }

    /**
     * 対象認定調査員所属機関ロップダウンリストを設定します。
     *
     * @param 対象認定調査員所属機関 対象認定調査員所属機関リスト
     */
    public void 対象認定調査員所属機関の設定(List<NinteichosaItakusakiJoho> 対象認定調査員所属機関) {

        div.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan().
                setDataSource(対象認定調査員所属機関ロップダウンリスト(対象認定調査員所属機関));
    }

    /**
     * 対象認定調査員ロップダウンリストを設定します。
     *
     * @param 対象認定調査員 対象認定調査員リスト
     */
    public void 対象認定調査員の設定(List<ChosainJoho> 対象認定調査員) {

        div.getPrintConditionPanel().getDdlTaishoNinteiChosain().
                setDataSource(対象認定調査員ロップダウンリスト(対象認定調査員));
    }

    /**
     * 条件をクリアします。
     *
     */
    public void 条件をクリア() {

        div.getPrintConditionPanel().getDdlTaishoChiku().setSelectedKey(RString.EMPTY);
        List<KeyValueDataSource> dataSource = new ArrayList();
        div.getPrintConditionPanel().getDdlTaishoShichoson().setDataSource(dataSource);
        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDFrom().clearValue();
        div.getPrintConditionPanel().getTxtNinteiChosaYoteiYMDTo().clearValue();
        div.getPrintConditionPanel().getDdlTaishoNinteiChosainShozokuKikan().setDataSource(dataSource);
        div.getPrintConditionPanel().getDdlTaishoNinteiChosain().setDataSource(dataSource);
        div.getPrintConditionPanel().getRadJokyo().setSelectedKey(全て);
    }

    private List<KeyValueDataSource> 市町村リストロップダウンリスト(List<ChikuShichosonBusiness> chikuShichosonList) {

        List<KeyValueDataSource> dataSource = new ArrayList();
        for (ChikuShichosonBusiness chikuShichosonBusiness : chikuShichosonList) {

            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(chikuShichosonBusiness.get市町村コード().value());
            keyValue.setValue(chikuShichosonBusiness.get市町村名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> 調査地区ドロップダウンリスト() {

        List<KeyValueDataSource> dataSource = new ArrayList();
        List<UzT0007CodeEntity> 指定調査地区 = CodeMaster.getCode(SubGyomuCode.DBE認定支援, コード種別);
        for (UzT0007CodeEntity entity : 指定調査地区) {

            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().value());
            keyValue.setValue(entity.getコード名称());

            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> 対象認定調査員所属機関ロップダウンリスト(List<NinteichosaItakusakiJoho> 対象認定調査員所属機関) {

        List<KeyValueDataSource> dataSource = new ArrayList();

        for (NinteichosaItakusakiJoho entity : 対象認定調査員所属機関) {

            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.get認定調査委託先コード());
            keyValue.setValue(entity.get事業者名称());

            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private List<KeyValueDataSource> 対象認定調査員ロップダウンリスト(List<ChosainJoho> 対象認定調査員) {

        List<KeyValueDataSource> dataSource = new ArrayList();

        for (ChosainJoho entity : 対象認定調査員) {

            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.get認定調査員コード().value());
            keyValue.setValue(entity.get調査員氏名());

            dataSource.add(keyValue);
        }
        return dataSource;
    }

    /**
     * 調査員で帳票印刷用のBodyを設定します。
     *
     * @param businessList List<NinteichosaScheduleBusiness>
     * @return List<ChosaSchedulehyoTyousayinBodyItem>
     */
    public List<ChosaSchedulehyoTyousayinBodyItem> createBodyItem_調査員(List<NinteichosaScheduleBusiness> businessList) {
        List<ChosaSchedulehyoTyousayinBodyItem> itemList = new ArrayList<>();
        for (NinteichosaScheduleBusiness bnusiness : businessList) {

            itemList.add(new ChosaSchedulehyoTyousayinBodyItem(
                    bnusiness.get認定調査予定開始時間() == null ? RString.EMPTY : bnusiness.get認定調査予定開始時間(),
                    bnusiness.get認定調査予定終了時間() == null ? RString.EMPTY : bnusiness.get認定調査予定終了時間(),
                    // TODO No QA内部番号810
                    RString.EMPTY,
                    bnusiness.get認定調査員コード() == null ? RString.EMPTY : bnusiness.get認定調査員コード(),
                    bnusiness.get調査員氏名() == null ? RString.EMPTY : bnusiness.get調査員氏名(),
                    bnusiness.get認定調査予約日() == null ? RString.EMPTY : new RString(bnusiness.get認定調査予約日().toString()),
                    bnusiness.get予約状況() == null ? RString.EMPTY : bnusiness.get予約状況().value(),
                    bnusiness.get被保険者番号() == null ? RString.EMPTY : bnusiness.get被保険者番号(),
                    bnusiness.get被保険者氏名() == null ? RString.EMPTY : bnusiness.get被保険者氏名().value(),
                    bnusiness.get被保険者住所() == null ? RString.EMPTY : bnusiness.get被保険者住所().value(),
                    bnusiness.get場所() == null ? RString.EMPTY : bnusiness.get場所(),
                    bnusiness.get立会者1() == null ? RString.EMPTY : bnusiness.get立会者1(),
                    bnusiness.get立会者2() == null ? RString.EMPTY : bnusiness.get立会者2(),
                    bnusiness.get連絡先１() == null ? RString.EMPTY : bnusiness.get連絡先１().value(),
                    bnusiness.get連絡先2() == null ? RString.EMPTY : bnusiness.get連絡先2().value()
            ));
        }
        return itemList;
    }

    /**
     * 調査員で帳票印刷用のHeadを設定します。
     *
     * @param businessList List<NinteichosaScheduleBusiness>
     * @return List<ChosaSchedulehyoTyousayinBodyItem>
     */
    public ChosaSchedulehyoTyousayinHeadItem createHeadItemItem_調査員(List<NinteichosaScheduleBusiness> businessList) {
        if (businessList != null && !businessList.isEmpty()) {

            NinteichosaScheduleBusiness business = businessList.get(0);
            return new ChosaSchedulehyoTyousayinHeadItem(business.get認定調査委託先コード() == null
                    ? RString.EMPTY : business.get認定調査委託先コード(),
                    business.get事務所名() == null ? RString.EMPTY : business.get認定調査委託先コード());
        }
        return new ChosaSchedulehyoTyousayinHeadItem(RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事務所で帳票印刷用のHeadを設定します。
     *
     * @param businessList List<JiMuSyoBusiness>
     * @return ChosaSchedulehyoHeadItem
     */
    public ChosaSchedulehyoHeadItem createHeadItemItem_事務所(List<JiMuSyoBusiness> businessList) {

        if (businessList != null && !businessList.isEmpty()) {

            //JiMuSyoBusiness business = businessList.get(0);
        }
        // TODO 引数が不正です。QA内部番号810
        return new ChosaSchedulehyoHeadItem(RString.EMPTY, RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * 時間管理で帳票印刷用のHeadを設定します。
     *
     * @param businessList List<JiKanKanRiBusiness>
     * @return List<ChosaSchedulehyoTyousayinBodyItem>
     */
    public ChosaSchedulehyoJikankanriHeadItem createHeadItemItem_時間管理(List<JiKanKanRiBusiness> businessList) {

        if (businessList != null && !businessList.isEmpty()) {

            JiKanKanRiBusiness business = businessList.get(0);
            return new ChosaSchedulehyoJikankanriHeadItem(business.get認定調査委託先コード() == null
                    ? RString.EMPTY : business.get認定調査委託先コード(),
                    business.get事業者名称() == null ? RString.EMPTY : business.get事業者名称());
        }
        return new ChosaSchedulehyoJikankanriHeadItem(RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事務所で帳票印刷用のBodyを設定します。
     *
     * @param businessList List<JiMuSyoBusiness>
     * @return List<ChosaSchedulehyoBodyItem>
     */
    public List<ChosaSchedulehyoBodyItem> createBodyItem_事務所(List<JiMuSyoBusiness> businessList) {

        List<ChosaSchedulehyoBodyItem> itemList = new ArrayList<>();
        for (JiMuSyoBusiness business : businessList) {

            itemList.add(new ChosaSchedulehyoBodyItem(
                    business.get認定調査予定日() == null ? RString.EMPTY
                    : new RString(String.valueOf(business.get認定調査予定日().getDayValue())),
                    business.get認定調査予定日() == null ? RString.EMPTY
                    : new RString(business.get認定調査予定日().getDayOfWeek().getMiddleTerm().toString()),
                    business.get空きの午前イメージ() == null ? RString.EMPTY : business.get空きの午前イメージ(),
                    new RString(String.valueOf(business.get空きの午前件数())),
                    business.get空きの午後イメージ() == null ? RString.EMPTY : business.get空きの午後イメージ(),
                    new RString(String.valueOf(business.get空きの午後件数())),
                    business.get仮予約の午前イメージ() == null ? RString.EMPTY : business.get仮予約の午前イメージ(),
                    new RString(String.valueOf(business.get仮予約の午前件数())),
                    business.get仮予約の午後イメージ() == null ? RString.EMPTY : business.get仮予約の午後イメージ(),
                    new RString(String.valueOf(business.get仮予約の午後件数())),
                    business.get確定の午前イメージ() == null ? RString.EMPTY : business.get確定の午前イメージ(),
                    new RString(String.valueOf(business.get確定の午前件数())),
                    business.get確定の午後イメージ() == null ? RString.EMPTY : business.get確定の午後イメージ(),
                    new RString(String.valueOf(business.get確定の午後件数()))
            ));
        }
        return itemList;
    }

    /**
     * 時間管理で帳票印刷用のBodyを設定します。
     *
     * @param businessList List<JiKanKanRiBusiness>
     * @return List<ChosaSchedulehyoTyousayinBodyItem>
     */
    public List<ChosaSchedulehyoJikankanriBodyItem> createBodyItem_時間管理(List<JiKanKanRiBusiness> businessList) {

        List<ChosaSchedulehyoJikankanriBodyItem> itemList = new ArrayList<>();
        for (JiKanKanRiBusiness business : businessList) {

            itemList.add(new ChosaSchedulehyoJikankanriBodyItem(
                    business.get認定調査委託先コード() == null ? RString.EMPTY : business.get認定調査委託先コード(),
                    business.get調査員氏名() == null ? RString.EMPTY : business.get調査員氏名(),
                    business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号(),
                    business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value(),
                    business.get連絡先1() == null ? RString.EMPTY : business.get連絡先1().value(),
                    business.get連絡先2() == null ? RString.EMPTY : business.get連絡先2().value(),
                    //TODO 認定調査予定開始時間 QA内部番号810
                    RString.EMPTY,
                    //TODO 認定調査予定終了時間 QA内部番号810
                    RString.EMPTY,
                    business.get予約状況() == null ? RString.EMPTY : business.get予約状況().value()
            ));
        }
        return itemList;
    }
}
