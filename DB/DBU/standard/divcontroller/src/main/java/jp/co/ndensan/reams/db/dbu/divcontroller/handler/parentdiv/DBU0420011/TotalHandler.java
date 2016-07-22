/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0420011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.KyufuseigenBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.NyushoShisetsuBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuBusiness;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashoa4.HihokenshashoA4BodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashob4.HihokenshashoB4Item;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.shikakushasho.ShikakushashoBodyItem;
import jp.co.ndensan.reams.db.dbu.business.core.hihokenshashochohyo.HihokenshashoChoBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.jukyushikakushomeisho.JukyuShikakuShomeishoKaiKo;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.KaigoHokenShikakushashoDataBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.ShienJigyoshaBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.ShikakushashoHakkoBusiness;
import jp.co.ndensan.reams.db.dbu.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoData;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.HihokenshashoChohyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.JushochitokureiTekiParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.NyutaiShoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.ShiteiServiceParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo.ShutokuTodokedeParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0420011.TotalDiv;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshashochohyo.HihokenshashoChohyoFinder;
import jp.co.ndensan.reams.db.dbu.service.core.jukyushikakushomeisho.JukyuShikakuShomeishoFinder;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokenshikakushasho.KaigoHokenShikakushasho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko.dgShuruiShikyuGendoKijunGaku_Row;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

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
    private static final RString 事業対象者 = new RString("事業対象者");
    private static final RString 文字_1 = new RString("1");
    private static final RString 文字_2 = new RString("2");

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
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void onLoad(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        if (MENUID_DBUMN12001.equals(ResponseHolder.getMenuID())) {
            div.getShikakuShaShoHakko().getBtnTainoInfo().setVisible(false);
            div.getShikakuShaShoHakko().getBtnGengakuInfo().setVisible(false);
            div.getAtenaShikakuInfo().getCcdKaigoAtenaInfo().initialize(識別コード);
            div.getAtenaShikakuInfo().getCcdKaigoShikakuKihon().initialize(被保険者番号);
            div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().initialize(被保険者番号, MENUID_DBUMN12001, 識別コード);
        }
        if (MENUID_DBUMN12002.equals(ResponseHolder.getMenuID())) {
            div.getShikakuShaShoHakko().getBtnTainoInfo().setVisible(false);
            div.getShikakuShaShoHakko().getBtnGengakuInfo().setVisible(false);
            div.getAtenaShikakuInfo().getCcdKaigoAtenaInfo().initialize(識別コード);
            div.getAtenaShikakuInfo().getCcdKaigoShikakuKihon().initialize(被保険者番号);
            div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().initialize(被保険者番号, MENUID_DBUMN12002, 識別コード);
        }
        if (MENUID_DBUMN12003.equals(ResponseHolder.getMenuID())) {
            div.getAtenaShikakuInfo().getCcdKaigoAtenaInfo().initialize(識別コード);
            div.getAtenaShikakuInfo().getCcdKaigoShikakuKihon().initialize(被保険者番号);
            div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko().initialize(被保険者番号.getColumnValue());
        }
    }

    /**
     * 帳票設計介護保険被保険者証（A4版）処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @return List<HihokenshashoA4BodyItem>
     */
    public List<HihokenshashoA4BodyItem> hihokenshashoA4(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        List<HihokenshashoA4BodyItem> bodyItemlist = new ArrayList<>();
        List<HihokenshashoChohyoParameter> hihoken = new ArrayList<>();
        hihoken.add(paramter(識別コード, 被保険者番号));
        List<HihokenshashoChoBusiness> business = HihokenshashoChohyoFinder.createInstance().createHihokenshashoChohyo(hihoken).records();
        for (HihokenshashoChoBusiness item : business) {
            HihokenshashoA4BodyItem bodyItem = new HihokenshashoA4BodyItem(item.get有効期限1(), item.get有効期限2(), item.get被保険者番号(),
                    item.get郵便番号(), item.get行政区1(), item.get行政区2(), item.get住所(), item.get氏名カナ(), item.get氏名(), item.get年号(),
                    item.get西暦年(), item.get和暦年(), item.get月(), item.get日(), item.get性別(), item.get交付年月日(), item.get再交付(),
                    item.get保険者NO1(), item.get保険者NO2(), item.get保険者NO3(), item.get保険者NO4(), item.get保険者NO5(), item.get保険者NO6(),
                    item.get要介護認定区分(), item.get認定年月日(), item.get認定有効期間開始年月日(), item.get有効期間波線(),
                    item.get認定有効期間終了年月日(), item.get訪問期間開始年月日(), item.get訪問期間波線(), item.get訪問期間終了年月日(),
                    item.getサービス(), item.get点数(), item.getサービス種類1(), item.getサービス種類2(), item.getサービス種類3(),
                    item.getサービス種類4(), item.getサービス種類5(), item.getサービス種類6(), item.getサービス種類1つ目の限度額(),
                    item.getサービス種類2つ目の限度額(), item.getサービス種類3つ目の限度額(), item.getサービス種類4つ目の限度額(),
                    item.getサービス種類5つ目の限度額(), item.getサービス種類6つ目の限度額(), item.get点数1(), item.get点数2(), item.get点数3(),
                    item.get点数4(), item.get点数5(), item.get点数6(), item.get認定審査会意見等(), item.get再交付2(), item.get給付制限1(),
                    item.get給付制限長1(), item.get給付制限2(), item.get給付制限長2(), item.get給付制限3(), item.get給付制限長3(),
                    item.get給付制限4(), item.get給付制限長4(), item.get給付制限5(), item.get給付制限長5(), item.get給付制限6(),
                    item.get給付制限長6(), item.get給付制限開始年月日1(), item.get給付制限終了年月日1(), item.get給付制限開始年月日2(),
                    item.get給付制限終了年月日2(), item.get給付制限開始年月日3(), item.get給付制限終了年月日3(), item.get居宅介護事業者1(),
                    item.get届出年月日1(), item.get居宅介護事業者2(), item.get居宅介護事業者星2(), item.get居宅介護事業者取消2(),
                    item.get届出年月日2(), item.get届出年月日星2(), item.get届出年月日取消2(), item.get居宅介護事業者3(),
                    item.get居宅介護事業者星3(), item.get届出年月日3(), item.get居宅介護事業者取消3(), item.get施設種類11(),
                    item.get届出年月日星3(), item.get届出年月日取消3(), item.get施設名1(), item.get入所チェック1(), item.get入院チェック1(),
                    item.get退所チェック1(), item.get退院チェック1(), item.get入所年月日1(), item.get退院年月日1(), item.get施設種類2(),
                    item.get施設名2(), item.get入所チェック2(), item.get入院チェック2(), item.get退所チェック2(), item.get退院チェック2(),
                    item.get入所年月日2(), item.get退院年月日2(), item.get連番(), item.get性障害1(), item.get性障害2(), item.get構成性別1(),
                    item.get構成性別2(), item.get居宅介護事業者長1(), item.get居宅介護事業者長2(), item.get居宅介護事業者長星2(),
                    item.get居宅介護事業者長取消2(), item.get居宅介護事業者長3(), item.get居宅介護事業者長星3(), item.get居宅介護事業者長取消3(),
                    item.get複合コントロール());
            bodyItemlist.add(bodyItem);
        }
        return bodyItemlist;
    }

    private HihokenshashoChohyoParameter paramter(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        HihokenshashoChohyoParameter para = new HihokenshashoChohyoParameter();
        para.set被保険者番号(被保険者番号.getColumnValue());
        para.set識別コード(識別コード);
        if (事業対象者.equals(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo().getTxtYokaigodo().getValue())) {
            para.set対象区分(文字_2);
        } else {
            para.set対象区分(文字_1);
        }
        para.set交付日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtKofuDate().getValue());
        para.set保険者(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtHokensha().getValue());
        para.set要介護認定状態区分コード(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo().getTxtYokaigodo().getValue());
        para.set認定年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo().getTxtNinteiYMD().getValue());
        para.set認定有効期間開始年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo().getTxtNinteiYukoFromYMD().getValue());
        para.set認定有効期間終了年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo().getTxtNinteiYukoToYMD().getValue());
        para.set支給限度有効開始年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai().getTblGendoGaku()
                .getKubunGendoGaku().getTxtYukoFromYMD().getValue());
        para.set支給限度有効終了年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai().getTblGendoGaku()
                .getKubunGendoGaku().getTxtYukoToYMD().getValue());
        para.set支給限度単位数(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai().getTblGendoGaku()
                .getKubunGendoGaku().getTxtKubunShikyuGendoKijunGaku().getValue());
        List<dgShuruiShikyuGendoKijunGaku_Row> rowList = div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTblGendoGaku().getShuruiShikyuGendoKijungaku().getDgShuruiShikyuGendoKijunGaku().getDataSource();
        List<ShiteiServiceParameter> list = new ArrayList<>();
        for (dgShuruiShikyuGendoKijunGaku_Row row : rowList) {
            ShiteiServiceParameter shitei = new ShiteiServiceParameter();
            shitei.setサービス種類限度額(row.getGendoGaku());
            shitei.set指定サービス種類(row.getServiceShurui());
            list.add(shitei);
        }
        para.set指定サービス種類(list);
        para.set介護認定審査会意見(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai().getTplShinsakaiIken()
                .getTxtShinsakaiIken().getValue());
        List<JushochitokureiTekiParameter> jushoList = new ArrayList<>();
        JushochitokureiTekiParameter jusho1 = new JushochitokureiTekiParameter();
        jusho1.set給付制限内容(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenNaiyo1().getValue());
        jusho1.set適用開始年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan1().getFromValue());
        jusho1.set適用終了年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan1().getToValue());
        jushoList.add(jusho1);
        JushochitokureiTekiParameter jusho2 = new JushochitokureiTekiParameter();
        jusho2.set給付制限内容(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenNaiyo2().getValue());
        jusho2.set適用開始年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan2().getFromValue());
        jusho2.set適用終了年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan2().getToValue());
        jushoList.add(jusho2);
        JushochitokureiTekiParameter jusho3 = new JushochitokureiTekiParameter();
        jusho3.set給付制限内容(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenNaiyo3().getValue());
        jusho3.set適用開始年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan3().getFromValue());
        jusho3.set適用終了年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan3().getToValue());
        jushoList.add(jusho3);
        para.set適用年月日(jushoList);
        List<ShutokuTodokedeParameter> shutoList = new ArrayList<>();
        ShutokuTodokedeParameter shuto1 = new ShutokuTodokedeParameter();
        shuto1.set届出年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTodokedeYMD1().getValue());
        shuto1.set計画事業者番号(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtJigyosha1().getValue());
        shuto1.set適用終了日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTekiyoStYMD1().getValue());
        ShutokuTodokedeParameter shuto2 = new ShutokuTodokedeParameter();
        shuto2.set届出年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTodokedeYMD2().getValue());
        shuto2.set計画事業者番号(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtJigyosha2().getValue());
        shuto2.set適用終了日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTekiyoStYMD2().getValue());
        ShutokuTodokedeParameter shuto3 = new ShutokuTodokedeParameter();
        shuto3.set届出年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTodokedeYMD3().getValue());
        shuto3.set計画事業者番号(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtJigyosha3().getValue());
        shuto3.set適用終了日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTekiyoStYMD3().getValue());
        shutoList.add(shuto1);
        shutoList.add(shuto2);
        shutoList.add(shuto3);
        para.set届出年月日(shutoList);
        List<NyutaiShoParameter> nyutaiList = new ArrayList<>();
        NyutaiShoParameter nyutai1 = new NyutaiShoParameter();
        nyutai1.set入所年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate1().getValue());
        nyutai1.set退所年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate1().getValue());
        nyutai1.set入所施設コード(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden入所施設コード１());
        nyutai1.set入所施設種類(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden入所施設種類１());
        NyutaiShoParameter nyutai2 = new NyutaiShoParameter();
        nyutai2.set入所年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate2().getValue());
        nyutai2.set退所年月日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate2().getValue());
        nyutai2.set入所施設コード(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden入所施設コード２());
        nyutai2.set入所施設種類(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden入所施設種類２());
        nyutaiList.add(nyutai1);
        nyutaiList.add(nyutai2);
        para.set入退所年月日(nyutaiList);
        return para;
    }

    /**
     * 帳票設計介護保険被保険者証（B4版）処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @return List<HihokenshashoB4Item>
     */
    public List<HihokenshashoB4Item> hihokenshashoB4(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        List<HihokenshashoB4Item> items = new ArrayList<>();
        List<HihokenshashoChohyoParameter> hihoken = new ArrayList<>();
        hihoken.add(paramter(識別コード, 被保険者番号));
        List<HihokenshashoChoBusiness> business = HihokenshashoChohyoFinder.createInstance().createHihokenshashoChohyo(hihoken).records();
        for (HihokenshashoChoBusiness item : business) {
            HihokenshashoB4Item bodyItem = new HihokenshashoB4Item(item.get有効期限1(), item.get被保険者番号(), item.get郵便番号(),
                    item.get行政区1(), item.get行政区2(), item.get住所(), item.get氏名カナ(), item.get氏名(), item.get明治(),
                    item.get大正(), item.get昭和(), item.get和暦年(), item.get月(),
                    item.get日(), item.get西暦年(), item.get月(), item.get日(), item.get男(), item.get女(),
                    item.get交付年月日(), item.get再交付(), item.get保険者NO1(), item.get保険者NO2(), item.get保険者NO3(),
                    item.get保険者NO4(), item.get保険者NO5(), item.get保険者NO6(), item.get要介護認定区分(), item.get認定年月日(),
                    item.get認定有効期間開始年月日(), item.get認定有効期間終了年月日(), item.get訪問期間開始年月日(), item.get訪問期間終了年月日(),
                    item.getサービス単位(), item.getサービス(), item.get点数(), item.getサービス種類1(), item.getサービス種類2(),
                    item.getサービス種類3(), item.getサービス種類4(), item.getサービス種類5(), item.getサービス種類6(),
                    item.getサービス種類1つ目の限度額(), item.getサービス種類2つ目の限度額(), item.getサービス種類3つ目の限度額(),
                    item.getサービス種類4つ目の限度額(), item.getサービス種類5つ目の限度額(), item.getサービス種類6つ目の限度額(),
                    item.get点数1(), item.get点数2(), item.get点数3(), item.get点数4(), item.get点数5(), item.get点数6(), item.get認定審査会意見等(),
                    item.get再交付2(), item.get給付制限1(), item.get給付制限長1(), item.get給付制限2(), item.get給付制限長2(), item.get給付制限3(),
                    item.get給付制限長3(), item.get給付制限4(), item.get給付制限長4(), item.get給付制限5(), item.get給付制限長5(),
                    item.get給付制限6(), item.get給付制限長6(), item.get給付制限開始年月日1(), item.get給付制限終了年月日1(),
                    item.get給付制限開始年月日2(), item.get給付制限終了年月日2(), item.get給付制限開始年月日3(), item.get給付制限終了年月日3(),
                    item.get居宅介護事業者1(), item.get届出年月日1(), item.get居宅介護事業者2(), item.get居宅介護事業者星2(),
                    item.get居宅介護事業者取消2(), item.get届出年月日2(), item.get届出年月日星2(), item.get届出年月日取消2(),
                    item.get居宅介護事業者3(), item.get居宅介護事業者長星3(), item.get居宅介護事業者取消3(), item.get届出年月日3(),
                    item.get届出年月日星3(), item.get届出年月日取消3(), item.get施設種類11(), item.get施設名1(), item.get入所チェック1(),
                    item.get入院チェック1(), item.get退所チェック1(), item.get退院チェック1(), item.get入所年月日1(), item.get退院年月日1(),
                    item.get施設種類2(), item.get施設名2(), item.get入所チェック2(), item.get入院チェック2(), item.get退所チェック2(),
                    item.get退所チェック2(), item.get入所年月日2(), item.get退院年月日2(), item.get連番(), item.get性障害1(), item.get性障害2(),
                    item.get構成性別1(), item.get構成性別2(), item.get居宅介護事業者長1(), item.get居宅介護事業者長2(),
                    item.get居宅介護事業者長星2(), item.get居宅介護事業者長取消2(), item.get居宅介護事業者長3(),
                    item.get居宅介護事業者長星3(), item.get居宅介護事業者長取消3());
            items.add(bodyItem);
        }
        return items;
    }

    /**
     * 帳票設計介護保険資格者証処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @return List<ShikakushashoBodyItem>
     */
    public List<ShikakushashoBodyItem> shikakushasho(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        List<ShikakushashoBodyItem> items = new ArrayList<>();
        KaigoHokenShikakushashoDataBusiness business = KaigoHokenShikakushasho.createInstance()
                .setKaigoHokenShikakushasho(shikaku(識別コード, 被保険者番号));
        ShikakushashoBodyItem item = new ShikakushashoBodyItem(business.getSubTitle(), business.getYukoKigen(), business.getHihokenshaNo(),
                business.getJusho(), business.getHihokenshaNameKana(), business.getHihokenshaName(), business.getBirthGengoMeiji(),
                business.getBirthGengoTaisho(), business.getBirthGengoShowa(), business.getSeibetsu(), business.getBirthYMD(),
                business.getKofuYMD(), business.getYokaigoJotaiKubun(), business.getNinteiYMD(), business.getYukoKaishiYMD(),
                business.getYukoShuryoYMD(), business.getKizyunngaku(), business.getKubunShikyuYukoKaishiYMD(), business.getKubunShikyuYukoShuryoYMD(),
                business.getTaniShurui(), business.getTani(), business.getShikyuGendoKizyungakuList(), business.getServiceShitei(),
                business.getKyufuseigenDataList(), business.getJigyoshaName1(), business.getTodokedeYMD1(), business.getJigyoshaName2(),
                business.getJigyoshaName2Asutarisuku(), business.getJigyoshaName2Masshosen(), business.getTodokedeYMD2(),
                business.getTodokedeYMD2Asutarisuku(), business.getTodokedeYMD2Masshosen(), business.getJigyoshaName3Asutarisuku(),
                business.getJigyoshaName3(), business.getJigyoshaName3Masshosen(), business.getTodokedeYMD3(),
                business.getTodokedeYMD3Asutarisuku(), business.getTodokedeYMD3Masshosen(), business.getNyushoShisetsuDataList(),
                business.getShisetsuNyusho(), business.getShisetsuNyuin(), business.getShisetsuTaisho(), business.getShisetsuTaiin(),
                business.getHokenshaNo(), business.getHokenshaJusho(), business.getHokenshaName(), business.getHokenshaTelno(),
                business.getRemban(), business.getDenshiKoin());
        items.add(item);
        return items;
    }

    private ShikakushashoHakkoBusiness shikaku(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ShikakushashoHakkoBusiness shikaku = new ShikakushashoHakkoBusiness();
        shikaku.set交付日(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko()
                .getYukoKigenInfo().getTxtKofuDate().getValue().toString()));
        shikaku.set保険者番号(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtHokensha().getValue());
        shikaku.set保険者名称(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo().getTxtHokensha().getValue());
        shikaku.set有効期限(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getYukoKigenInfo()
                .getTxtYukoKigen().getValue().toDateString());
        shikaku.set被保番号(被保険者番号.getColumnValue());
        shikaku.set介護状態(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo().getTxtYokaigodo().getValue());
        shikaku.set認定日(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo()
                .getTxtNinteiYMD().getValue().toDateString());
        shikaku.set有効期間の開始日付(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo()
                .getTxtNinteiYukoFromYMD().getValue().toDateString());
        shikaku.set有効期間の終了日付(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getNinteiInfo()
                .getTxtNinteiYukoToYMD().getValue().toDateString());
        shikaku.set区分支給限度額の有効開始日付(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko()
                .getTabHihokenshaShikakuShosai().getTblGendoGaku().getKubunGendoGaku().getTxtYukoFromYMD().getValue().toDateString());
        shikaku.set区分支給限度額の有効終了日付(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko()
                .getTabHihokenshaShikakuShosai().getTblGendoGaku().getKubunGendoGaku().getTxtYukoToYMD().getValue().toDateString());
        shikaku.set区分支給限度額の基準額(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTblGendoGaku().getKubunGendoGaku().getTxtKubunShikyuGendoKijunGaku().getValue().toString()));
        List<dgShuruiShikyuGendoKijunGaku_Row> rowList = div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTblGendoGaku().getShuruiShikyuGendoKijungaku().getDgShuruiShikyuGendoKijunGaku().getDataSource();
        List<ShuruiShikyuGendoKizyunngakuBusiness> list = new ArrayList<>();
        for (dgShuruiShikyuGendoKijunGaku_Row row : rowList) {
            ShuruiShikyuGendoKizyunngakuBusiness shurui = new ShuruiShikyuGendoKizyunngakuBusiness();
            shurui.setShuruiShikyuKizyunngaku(row.getGendoGaku());
            shurui.setServiceShurui(row.getServiceShurui());
            list.add(shurui);
        }
        shikaku.setうち種類支給限度基準額の情報(list);
        shikaku.set種類の指定(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai().getTplShinsakaiIken()
                .getTxtShinsakaiIken().getValue());
        List<KyufuseigenBusiness> jushoList = new ArrayList<>();
        KyufuseigenBusiness jusho1 = new KyufuseigenBusiness();
        jusho1.setKyufuseigenNaiyo(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenNaiyo1().getValue());
        jusho1.setKyufuseigenKaishiYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan1().getFromValue().toDateString());
        jusho1.setKyufuseigenShuryoYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan1().getToValue().toDateString());
        jushoList.add(jusho1);
        KyufuseigenBusiness jusho2 = new KyufuseigenBusiness();
        jusho2.setKyufuseigenNaiyo(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenNaiyo2().getValue());
        jusho2.setKyufuseigenKaishiYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan2().getFromValue().toDateString());
        jusho2.setKyufuseigenShuryoYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan2().getToValue().toDateString());
        jushoList.add(jusho2);
        KyufuseigenBusiness jusho3 = new KyufuseigenBusiness();
        jusho3.setKyufuseigenNaiyo(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenNaiyo3().getValue());
        jusho3.setKyufuseigenKaishiYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan3().getFromValue().toDateString());
        jusho3.setKyufuseigenShuryoYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplKyufuSeigen().getTxtKyufuSeigenKikan3().getToValue().toDateString());
        jushoList.add(jusho3);
        shikaku.set給付制限の情報(jushoList);
        List<ShienJigyoshaBusiness> shutoList = new ArrayList<>();
        ShienJigyoshaBusiness shuto1 = new ShienJigyoshaBusiness();
        shuto1.setTodokedeYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTodokedeYMD1().getValue().toString()));
        shuto1.setJigyosha(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtJigyosha1().getValue());
        shuto1.setTekiyoKaishiYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTekiyoStYMD1().getValue().toString()));
        shuto1.setTekiyoShuryoYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden適用終了日１());
        ShienJigyoshaBusiness shuto2 = new ShienJigyoshaBusiness();
        shuto2.setTodokedeYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTodokedeYMD2().getValue().toString()));
        shuto2.setJigyosha(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtJigyosha2().getValue());
        shuto2.setTekiyoKaishiYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTekiyoStYMD2().getValue().toString()));
        shuto2.setTekiyoShuryoYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden適用終了日２());
        ShienJigyoshaBusiness shuto3 = new ShienJigyoshaBusiness();
        shuto3.setTodokedeYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTodokedeYMD3().getValue().toString()));
        shuto3.setJigyosha(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtJigyosha3().getValue());
        shuto3.setTekiyoKaishiYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShienJigyosha().getTxtTekiyoStYMD3().getValue().toString()));
        shuto3.setTekiyoShuryoYMD(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getHidden適用終了日３());
        shutoList.add(shuto1);
        shutoList.add(shuto2);
        shutoList.add(shuto3);
        shikaku.set支援事業者の情報(shutoList);
        List<NyushoShisetsuBusiness> nyutaiList = new ArrayList<>();
        NyushoShisetsuBusiness nyutai1 = new NyushoShisetsuBusiness();
        nyutai1.setShisetsuNyushoYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate1().getValue().toString()));
        nyutai1.setShisetsuTaishoYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate1().getValue().toString()));
        nyutai1.setNyushoShisetsuName(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtNyushoShisetsu1().getValue());
        NyushoShisetsuBusiness nyutai2 = new NyushoShisetsuBusiness();
        nyutai2.setShisetsuNyushoYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate2().getValue().toString()));
        nyutai2.setShisetsuTaishoYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate2().getValue().toString()));
        nyutai2.setNyushoShisetsuName(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtNyushoShisetsu2().getValue());
        NyushoShisetsuBusiness nyutai3 = new NyushoShisetsuBusiness();
        nyutai3.setShisetsuNyushoYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuNyushoDate2().getValue().toString()));
        nyutai3.setShisetsuTaishoYMD(new RString(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtShisetsuTaishoDate2().getValue().toString()));
        nyutai3.setNyushoShisetsuName(div.getShikakuShaShoHakko().getCcdHihokenshaShikakuHakko().getTabHihokenshaShikakuShosai()
                .getTplShisetsuNyutaisho().getTxtNyushoShisetsu3().getValue());
        nyutaiList.add(nyutai1);
        nyutaiList.add(nyutai2);
        nyutaiList.add(nyutai3);
        shikaku.set介護保険施設等の情報(nyutaiList);
        shikaku.set識別コード(識別コード.getColumnValue());
        return shikaku;
    }

    /**
     * 帳票設計受給資格証明書処理です。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @return List<JukyuShikakuShomeishoBodyItem>
     */
    public List<JukyuShikakuShomeishoBodyItem> jukyuShikakuShomeisho(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        List<JukyuShikakuShomeishoBodyItem> items = new ArrayList<>();
        JukyuShikakuShomeishoKaiKo param = new JukyuShikakuShomeishoKaiKo();
        param.set交付日(RString.isNullOrEmpty(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtKofubi().getValue()) ? null
                : div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko().getJukyuSikakuShomeishoHakkoDiv()
                .getPnlJukyushaJoho1().getTxtKofubi().getValue());
        param.set住所を印字(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getCblInji().isAllSelected());
        param.set備考(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho2().getTbmBiko().getValue());
        param.set有効期間の終了年月日(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtdrYukokikan().getToValue() == null
                ? null : div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtdrYukokikan().getToValue().toDateString());
        param.set有効期間の開始年月日(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtdrYukokikan().getFromValue() == null
                ? null : div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtdrYukokikan().getFromValue().toDateString());
        param.set申請日(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtShinsebi().getValue());
        param.set異動予定日(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtIdoYotebi().getValue());
        param.set要介護状態区分(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtYokaigoJotaiKubun().getValue());
        param.set認定審査会の意見等(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho2().getTbmShinsakaiYikan().getValue());
        param.set被保険者番号(被保険者番号);
        param.set識別コード(識別コード);
        param.set負担割合(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtfutanWariaiKubun().getValue());
        param.set負担割該当(div.getJukyuSikakuShomeiHakko().getCcdJukyuSikakuShomeishoHakko()
                .getJukyuSikakuShomeishoHakkoDiv().getPnlJukyushaJoho1().getTxtfutanWariai().getValue());
        JukyuShikakuShomeishoFinder finder = JukyuShikakuShomeishoFinder.createInstance();
        JukyuShikakuShomeishoData business = finder.setJukyuShikakuShomeisho(param);
        JukyuShikakuShomeishoBodyItem item = new JukyuShikakuShomeishoBodyItem(business.get被保険者番号().getColumnValue(), business.get被保険者フリガナ().value(),
                business.get被保険者氏名().value(), business.get年号_明治(), business.get年号_大正(),
                business.get年号_昭和(), business.get被保険者生年月日(), business.get被保険者性別(), business.get被保険者住所_転出前(),
                business.get被保険者住所_転出先予定(), business.get被保険者異動予定日(), business.get保険者番号(), business.get発行日(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, business.get申請状況(), business.get申請年月日(),
                business.get要介護状態区分(), business.get認定年月日(), business.get認定の有効期間の開始年月日(),
                business.get認定の有効期間の終了年月日(), business.get認定審査会の意見等(), business.get備考(), business.get連番(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        items.add(item);
        return items;
    }

    /**
     * 入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs detaCheck() {
        return createValidationHandler(div).validateCheck();
    }

    private TotalValidationHandler createValidationHandler(TotalDiv div) {
        return new TotalValidationHandler(div);
    }
}
