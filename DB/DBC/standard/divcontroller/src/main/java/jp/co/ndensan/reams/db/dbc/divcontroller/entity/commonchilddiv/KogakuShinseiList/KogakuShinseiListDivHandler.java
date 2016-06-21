/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouEntityResult;
import jp.co.ndensan.reams.db.dbc.service.core.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyou;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 画面設計_DBCKD00005_高額申請一覧共有子Div
 *
 * @reamsid_L DBC-2020-010 quxiaodong
 */
public class KogakuShinseiListDivHandler {

    private final KogakuShinseiListDiv div;
    private static final RString 高額サービス費支給申請書登録 = new RString("DBCMN42001");
    private static final RString 高額介護サービス費照会 = new RString("DBCMN11004");
    private static final RString 審査年月 = new RString("審査年月");
    private static final RString 登録年月日 = new RString("登録年月日");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final int THREE = 3;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuShinseiListDivHandler(KogakuShinseiListDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KogakuKyufuTaishoListDiv
     */
    public static KogakuShinseiListDivHandler of(KogakuShinseiListDiv div) {
        return new KogakuShinseiListDivHandler(div);
    }

    /**
     * 画面初期化
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 導入形態コード RString
     */
    public void 画面初期化(RString メニューID, HihokenshaNo 被保険者番号, RString 導入形態コード) {
        FlexibleYearMonth サービス年月 = FlexibleDate.getNowDate().
                getYearMonth().minusMonth(THREE);
        div.getTxtServiceYM().setDomain(new RYearMonth(サービス年月.wareki().toString()));
        set証記載保険者番号(被保険者番号, サービス年月, 導入形態コード);
        if (高額介護サービス費照会.equals(メニューID)) {
            set照会モード();
        }
    }

    /**
     * set証記載保険者番号
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 導入形態コード RString
     */
    public void set証記載保険者番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, RString 導入形態コード) {
        ShoKisaiHokenshaNo 証記載保険者番号 = KougakuShinseiIchiranJohyou.createInstance().
                getShoKisaiHokenBangou(被保険者番号, サービス年月, 導入形態コード);
        if (証記載保険者番号 != null) {
            div.getTxtShokisai().setValue(証記載保険者番号.value());
        }
    }

    /**
     * 検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @param メニューID RString
     */
    public void 検索一覧(HihokenshaNo 被保険者番号, RString メニューID) {
        FlexibleYearMonth サービス年月From = null;
        FlexibleYearMonth サービス年月To = null;
        if (div.getTxtServiceYMFrom().getDomain() != null) {
            サービス年月From = new FlexibleYearMonth(div.getTxtServiceYMFrom().getDomain().toString());
        }
        if (div.getTxtServiceYMTo().getDomain() != null) {
            サービス年月To = new FlexibleYearMonth(div.getTxtServiceYMTo().getDomain().toString());
        }
        if (高額サービス費支給申請書登録.equals(メニューID)) {
            List<KougakuShinseiIchiranJohyouEntityResult> kogaList = KougakuShinseiIchiranJohyou.createInstance().
                    getKogakuKyuufuTaishouList(被保険者番号, サービス年月From, サービス年月To);
            set高額申請一覧情報(kogaList);
        } else if (高額介護サービス費照会.equals(メニューID)) {
            List<KougakuShinseiIchiranJohyouEntityResult> jishList = KougakuShinseiIchiranJohyou.createInstance().
                    getJigyouKougakuShinseiIchiranJohyou(被保険者番号, サービス年月From, サービス年月To);
            set高額申請一覧情報(jishList);
        }
    }

    /**
     * 高額申請一覧情報を抽出する
     *
     * @param kogaList List<KougakuShinseiIchiranJohyouEntityResult>
     */
    public void set高額申請一覧情報(List<KougakuShinseiIchiranJohyouEntityResult> kogaList) {
        List<dgShinseiJoho_Row> rowList = new ArrayList<>();
        dgShinseiJoho_Row row = new dgShinseiJoho_Row();
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        for (KougakuShinseiIchiranJohyouEntityResult koga : kogaList) {
            if (koga.getEntity().getサービス年月() != null) {
                row.setData1(koga.getEntity().getサービス年月().wareki().toDateString());
            }
            row.setData2(koga.getEntity().get管理番号());
            row.getData3().setValue(koga.getEntity().get利用者負担額合計());
            row.getData4().setValue(koga.getEntity().get算定基準額());
            row.getData5().setValue(koga.getEntity().get支払済額合計());
            row.getData6().setValue(koga.getEntity().get高額支給額());
            row.getData7().setValue(koga.getEntity().get決定支給額());
            row.setData8(koga.getEntity().get支給区分());
            if (受託区分.equals(TWO)) {
                if (koga.getEntity().get対象取込年月() != null) {
                    row.setData9(koga.getEntity().get対象取込年月().wareki().toDateString());
                }
                if (koga.getEntity().get判定送付年月() != null) {
                    row.setData10(koga.getEntity().get判定送付年月().wareki().toDateString());
                }
                if (koga.getEntity().get判定取込年月() != null) {
                    row.setData11(koga.getEntity().get判定取込年月().wareki().toDateString());
                }
            } else if (受託区分.equals(ONE)) {
                div.getDgShinseiJoho().getGridSetting().getColumns().get(EIGHT).setVisible(false);
                div.getDgShinseiJoho().getGridSetting().getColumns().get(NINE).setColumnName(審査年月);
                div.getDgShinseiJoho().getGridSetting().getColumns().get(TEN).setColumnName(登録年月日);
                if (koga.getEntity().get判定送付年月() != null) {
                    row.setData10(koga.getEntity().get判定送付年月().wareki().toDateString());
                    //TODO  QA881
                }
                if (koga.getEntity().get判定取込年月() != null) {
                    row.setData11(koga.getEntity().get判定取込年月().wareki().toDateString());
                    //TODO QA881  
                }
            }
            if (koga.getEntity().get証記載番号() != null && !koga.getEntity().get証記載番号().isEmpty()) {
                row.setData12(koga.getEntity().get証記載番号().value());
            }
            rowList.add(row);
        }
        div.getDgShinseiJoho().setDataSource(rowList);
    }

    /**
     * set照会モード
     */
    public void set照会モード() {
        div.getTxtServiceYM().setDisplayNone(true);
        div.getTxtShokisai().setDisplayNone(true);
        div.getBtnShinseiJohoTsuika().setDisplayNone(true);
        div.getBtnTaishosyaJoho().setDisplayNone(true);
    }
}
