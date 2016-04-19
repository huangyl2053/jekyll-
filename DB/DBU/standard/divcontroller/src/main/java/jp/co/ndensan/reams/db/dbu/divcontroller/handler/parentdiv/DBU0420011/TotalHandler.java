/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0420011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Item;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoBodyItem;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashochohyo.HihokenshashoChohyoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.KaigoHokenShikakushashoDataBusiness;
import jp.co.ndensan.reams.db.dbu.business.jukyushikakushomeisho.JukyuShikakuShomeishoData;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.HihokenshashoChohyoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011.TotalDiv;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashochohyo.HihokenshashoChohyoFinder;
import jp.co.ndensan.reams.db.dbu.service.core.jukyushikakushomeisho.JukyuShikakuShomeishoFinder;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokenshikakushasho.KaigoHokenShikakushasho;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 境界層該当者台帳管理Handlerクラスです。
 *
 * @reamsid_L DBU-0490-010 zhangzhiming
 */
public class TotalHandler {

    private final TotalDiv div;
    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");
    private static final RString MENUID_DBUMN12003 = new RString("DBUMN12003");

    /**
     * コンストラクタです。
     *
     * @param div 被保険者証・資格者証Div
     */
    public TotalHandler(TotalDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        if (MENUID_DBUMN12001.equals(ResponseHolder.getMenuID())) {
            div.getAtenaShikakuInfo().getCcdKaigoAtenaInfo().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
            div.getAtenaShikakuInfo().getCcdKaigoShikakuKihon().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class)
                    .get被保険者番号());
            div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().initialize(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class)
                    .get被保険者番号(), MENUID_DBUMN12001);
        }
        if (MENUID_DBUMN12002.equals(ResponseHolder.getMenuID())) {
            div.getAtenaShikakuInfo().getCcdKaigoAtenaInfo().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
            div.getAtenaShikakuInfo().getCcdKaigoShikakuKihon().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class)
                    .get被保険者番号());
            div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().initialize(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class)
                    .get被保険者番号(), MENUID_DBUMN12002);
        }
        if (MENUID_DBUMN12003.equals(ResponseHolder.getMenuID())) {
            div.getAtenaShikakuInfo().getCcdKaigoAtenaInfo().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
            div.getAtenaShikakuInfo().getCcdKaigoShikakuKihon().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class)
                    .get被保険者番号());
            div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko().initialize(ViewStateHolder.get(ViewStateKey.資格対象者,
                    TaishoshaKey.class).get被保険者番号().getColumnValue());
        }
    }

    /**
     * 帳票設計介護保険被保険者証（A4版）処理です。
     *
     * @return List<HihokenshashoA4BodyItem>
     */
    public List<HihokenshashoA4BodyItem> hihokenshashoA4() {
        List<HihokenshashoA4BodyItem> bodyItemlist = new ArrayList<>();
        List<HihokenshashoChohyoParameter> hihoken = new ArrayList<>();
        HihokenshashoChohyoParameter parameter = new HihokenshashoChohyoParameter();
        // TODO QA1050 パラメタ不明
        hihoken.add(parameter);
        List<HihokenshashoChohyoBusiness> business = HihokenshashoChohyoFinder.createInstance().createHihokenshashoChohyo(hihoken).records();
        for (HihokenshashoChohyoBusiness item : business) {
            HihokenshashoA4BodyItem bodyItem = new HihokenshashoA4BodyItem(item.getYukokigen1(), item.getYukokigen2(), item.getHihokenshanno(),
                    item.getYubinno(), item.getGyoseiku1(), item.getGyoseiku2(), item.getHihojusho(), item.getHihokana(), item.getHihoname(),
                    item.getUmareMm(), item.getUmareMm(), item.getUmareMm(),
                    item.getKofuymd(), item.getKofuymd(), item.getKofuymd(), item.getSeibetsuMan1(), item.getSaikofu1(),
                    item.getHokenshano1(), item.getHokenshano2(), item.getHokenshano3(), item.getHokenshano4(), item.getHokenshano5(),
                    item.getHokenshano6(), item.getKaigokbn(), item.getNinteiymd(), item.getYukokikanst(), item.getYukokikannamisen(),
                    item.getYukokikaned(), item.getHomonkikanst(), item.getYukokikannamisen(), item.getHomonkikaned(), item.getService(),
                    item.getTen0(), item.getShurui1(), item.getShurui2(), item.getShurui3(), item.getShurui4(), item.getShurui5(),
                    item.getShurui6(), item.getShuruigendo1(), item.getShuruigendo2(), item.getShuruigendo3(), item.getShuruigendo4(),
                    item.getShuruigendo5(), item.getShuruigendo6(), item.getTen1(), item.getTen2(), item.getTen3(), item.getTen4(), item.getTen5(),
                    item.getTen6(), item.getRyui(), item.getSaikofu2(), item.getSeigen1(), item.getSeigenLong1(), item.getSeigen2(),
                    item.getSeigenLong2(), item.getSeigen3(), item.getSeigenLong3(), item.getSeigen4(), item.getSeigenLong4(), item.getSeigen5(),
                    item.getSeigenLong5(), item.getSeigen6(), item.getSeigenLong6(), item.getSeigenSt1(), item.getSeigenEd1(),
                    item.getSeigenSt2(), item.getSeigenEd2(), item.getSeigenSt3(), item.getSeigenEd3(), item.getGyosha1(), item.getTodokeYmd1(),
                    item.getGyosha2(), item.getGyosha2Asa(), item.getGyosha2Massho(), item.getTodokeYmd2(), item.getTodokeYmd3Asa(),
                    item.getTodokeYmd3Massho(), item.getGyosha3(), item.getGyosha3Asa(), item.getTodokeYmd3(), item.getGyosha3Massho(),
                    item.getShisetsuSyu1(), item.getTodokeYmd3Asa(), item.getTodokeYmd3Massho(), item.getShisetsuname1(), item.getNyushochk1(),
                    item.getNyuinchk1(), item.getTaishochk1(), item.getTaiinchk1(), item.getNyushoymd1(), item.getTaiinymd1(), item.getShisetsuSyu2(),
                    item.getShisetsuname2(), item.getNyushochk2(), item.getNyuinchk2(), item.getTaishochk2(), item.getTaiinchk2(),
                    item.getNyushoymd2(), item.getTaiinymd2(), item.getRenban(), item.getSeiShogai1(), item.getSeiShogai2(),
                    item.getKosekiSeibetsu1(), item.getKosekiSeibetsu2(), item.getItakuGyosha1(), item.getItakuGyosha2(), item.getItakuGyosha2Asa(),
                    item.getItakuGyosha2Massho(), item.getItakuGyosha3(), item.getItakuGyosha3Asa(), item.getItakuGyosha3Massho(),
                    item.getImageField1());
            bodyItemlist.add(bodyItem);
        }
        return bodyItemlist;
    }

    /**
     * 帳票設計介護保険被保険者証（B4版）処理です。
     *
     * @return List<HihokenshashoB4Item>
     */
    public List<HihokenshashoB4Item> hihokenshashoB4() {
        List<HihokenshashoB4Item> items = new ArrayList<>();
        List<HihokenshashoChohyoParameter> hihoken = new ArrayList<>();
        HihokenshashoChohyoParameter parameter = new HihokenshashoChohyoParameter();
        // TODO QA1050 パラメタ不明
        hihoken.add(parameter);
        List<HihokenshashoChohyoBusiness> business = HihokenshashoChohyoFinder.createInstance().createHihokenshashoChohyo(hihoken).records();
        for (HihokenshashoChohyoBusiness item : business) {
            HihokenshashoB4Item bodyItem = new HihokenshashoB4Item(item.getYukokigen1(), item.getHihokenshanno(), item.getYubinno(),
                    item.getGyoseiku1(), item.getGyoseiku2(), item.getHihojusho(), item.getHihokana(), item.getHihoname(), item.getUmareMeiji1(),
                    item.getUmareTaisho1(), item.getUmareShowa1(), item.getUmareMm(), item.getSeibetsuMan1(), item.getSeibetsuWoman1(),
                    item.getKofuymd(), item.getSaikofu1(), item.getHokenshano1(), item.getHokenshano2(), item.getHokenshano3(),
                    item.getHokenshano4(), item.getHokenshano5(), item.getHokenshano6(), item.getKaigokbn(), item.getNinteiymd(),
                    item.getYukokikanst(), item.getYukokikaned(), item.getHomonkikanst(), item.getHomonkikaned(), item.getService0(),
                    item.getService(), item.getTen0(), item.getShurui1(), item.getShurui2(), item.getShurui3(), item.getShurui4(), item.getShurui5(),
                    item.getShurui6(), item.getShuruigendo1(), item.getShuruigendo2(), item.getShuruigendo3(), item.getShuruigendo4(),
                    item.getShuruigendo5(), item.getShuruigendo6(), item.getTen1(), item.getTen2(), item.getTen3(), item.getTen4(), item.getTen5(),
                    item.getTen6(), item.getRyui(), item.getSaikofu2(), item.getSeigen1(), item.getSeigenLong1(), item.getSeigen2(),
                    item.getSeigenLong2(), item.getSeigen3(), item.getSeigenLong3(), item.getSeigen4(), item.getSeigenLong4(), item.getSeigen5(),
                    item.getSeigenLong5(), item.getSeigen6(), item.getSeigenLong6(), item.getSeigenSt1(), item.getSeigenEd1(), item.getSeigenSt2(),
                    item.getSeigenEd2(), item.getSeigenSt3(), item.getSeigenEd3(), item.getGyosha1(), item.getTodokeYmd1(), item.getGyosha2(),
                    item.getGyosha2Asa(), item.getGyosha2Massho(), item.getTodokeYmd2(), item.getTodokeYmd2Asa(), item.getTodokeYmd2Massho(),
                    item.getGyosha3(), item.getGyosha3Asa(), item.getGyosha3Massho(), item.getTodokeYmd3(), item.getTodokeYmd3Asa(),
                    item.getTodokeYmd3Massho(), item.getShisetsuSyu1(), item.getShisetsuname1(), item.getNyushochk1(), item.getNyuinchk1(),
                    item.getTaishochk1(), item.getTaiinchk1(), item.getNyushoymd1(), item.getTaiinymd1(),
                    item.getShisetsuSyu2(), item.getShisetsuname2(), item.getNyushochk2(), item.getNyuinchk2(), item.getTaishochk2(),
                    item.getTaiinchk2(), item.getNyushoymd2(), item.getTaiinymd2(), item.getRenban(), item.getSeiShogai1(), item.getSeiShogai2(),
                    item.getKosekiSeibetsu1(), item.getKosekiSeibetsu2(), item.getItakuGyosha1(), item.getItakuGyosha2(), item.getItakuGyosha2Asa(),
                    item.getItakuGyosha2Massho(), item.getItakuGyosha3(), item.getItakuGyosha3Asa(), item.getItakuGyosha3Massho());
            items.add(bodyItem);
        }
        return items;
    }

    /**
     * 帳票設計介護保険資格者証処理です。
     *
     * @return List<ShikakushashoBodyItem>
     */
    public List<ShikakushashoBodyItem> shikakushasho() {
        List<ShikakushashoBodyItem> items = new ArrayList<>();
        // TODO QA1050 パラメタ不明
        KaigoHokenShikakushashoDataBusiness business = KaigoHokenShikakushasho.createInstance().setKaigoHokenShikakushasho(null);
        ShikakushashoBodyItem item = new ShikakushashoBodyItem(business.getサーブタイトル(), business.get有効期限(), business.get被保険者番号(),
                business.get被保険者住所(), business.get被保険者フリガナ(), business.get被保険者氏名(), business.get明治(), business.get大正(),
                business.get昭和(), business.get被保険者性別(), business.get被保険者生年月日(), business.get交付年月日(), business.get要介護状態区分等(),
                business.get認定年月日(), business.get認定の有効期間開始年月日(), business.get認定の有効期間終了年月日(),
                business.get居宅サービス等の単位(), business.get居宅サービス等の区分支給限度開始年月日(),
                business.get居宅サービス等の区分支給限度終了年月日(), business.get居宅サービス等の単位種類(), business.get居宅サービス等の単位(),
                business.getうち種類支給限度基準額の情報(), business.get認定審査会の意見及びサービスの種類の指定(), business.get給付制限の情報(),
                business.get支援事業者情報の名称の内容1(), business.get支援事業者情報の名称の届出年月日1(), business.get支援事業者情報の名称の内容2(),
                business.get支援事業者情報の名称の内容アスタリスク2(), business.get支援事業者情報の名称の内容取消2(),
                business.get支援事業者情報の名称の届出年月日2(), business.get支援事業者情報の名称の届出年月日アスタリスク2(),
                business.get支援事業者情報の名称の届出年月日取消2(), business.get支援事業者情報の名称の内容アスタリスク3(),
                business.get支援事業者情報の名称の内容3(), business.get支援事業者情報の名称の内容取消3(), business.get支援事業者情報の名称の届出年月日3(),
                business.get支援事業者情報の名称の届出年月日アスタリスク3(), business.get支援事業者情報の名称の届出年月日取消3(),
                business.get介護保険施設等の情報(), business.get施設入所(), business.get施設入院(), business.get施設退所(), business.get施設退院(),
                business.get保険者番号及びに保険者の名称及び印の保険者番号(), business.get保険者番号及びに保険者の名称及び印の住所(),
                business.get保険者番号及びに保険者の名称及び印の保険者名称(), business.get保険者番号及びに保険者の名称及び印の電話番号(),
                business.get連番(), business.get保険者番号及びに保険者の名称及び印の印字編集());
        items.add(item);
        return items;
    }

    /**
     * 帳票設計受給資格証明書処理です。
     *
     * @return List<JukyuShikakuShomeishoBodyItem>
     */
    public List<JukyuShikakuShomeishoBodyItem> jukyuShikakuShomeisho() {
        List<JukyuShikakuShomeishoBodyItem> items = new ArrayList<>();
        // TODO QA1050 パラメタ不明
        JukyuShikakuShomeishoFinder finder = new JukyuShikakuShomeishoFinder();
        JukyuShikakuShomeishoData business = finder.setJukyuShikakuShomeisho(null);
        JukyuShikakuShomeishoBodyItem item = new JukyuShikakuShomeishoBodyItem(business.get保険者番号(), business.get被保険者フリガナ().value(),
                business.get被保険者氏名().value(), business.get年号_明治(), business.get年号_大正(),
                business.get年号_昭和(), business.get被保険者生年月日(), business.get被保険者性別(), business.get被保険者住所_転出前(),
                business.get被保険者住所_転出先予定(), business.get被保険者異動予定日(), business.get保険者番号(), business.get発行日(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, business.get申請状況(), business.get申請年月日(),
                business.get要介護状態区分(), business.get認定年月日(), business.get認定の有効期間の開始年月日(),
                business.get認定の有効期間の終了年月日(), business.get認定審査会の意見等(), business.get備考(), business.get連番());
        items.add(item);
        return items;
    }
}
