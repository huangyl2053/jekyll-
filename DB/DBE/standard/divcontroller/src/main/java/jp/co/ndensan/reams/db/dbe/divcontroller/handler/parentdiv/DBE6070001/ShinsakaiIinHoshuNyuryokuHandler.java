/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6070001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinhoshunyuryoku.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.dgShinsakaiJisseki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 審査会委員報酬入力のHandlerクラスです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public class ShinsakaiIinHoshuNyuryokuHandler {

    private static final RString 銀行振込_する = new RString("する");
    private static final RString 銀行振込_しない = new RString("しない");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString SHINCHAKAI = new RString("審査会");
    private static final RString SONOTA = new RString("その他（研修等）");
    private static final RString 審査会 = new RString("1");
    private static final RString その他研修等 = new RString("2");
    private final ShinsakaiIinHoshuNyuryokuDiv div;
    private RString 廃止フラグ;
    private RString 出欠;
    private RString 振込;
    private RString 区分;
    private RString 合議体長区分;
    private RString 資格;
    private RString 報酬区分;
    private RString 銀行振込;
    private Decimal 審査報酬額;
    private Decimal 交通費等;
    private Decimal 報酬税率;
    private Decimal その他報酬;
    private Decimal 控除税額;
    private Decimal 税引後支払額;
    private RString 状態;
    private RString 審査会開催番号;
    private RString 審査会委員報酬区分;
    private static final Decimal HYAKU = new Decimal("100");
    private static final RString 振込_出力済 = new RString("出力済");
    private static final RString 振込_出力未 = new RString("出力未");
    private static final RString 区分_審査報酬 = new RString("審査報酬");
    private static final RString 区分_その他報酬 = new RString("その他報酬");

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiIinHoshuNyuryokuDiv
     */
    public ShinsakaiIinHoshuNyuryokuHandler(ShinsakaiIinHoshuNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * 審査会委員報酬入力の初期化です。
     *
     */
    public void onLoad() {
        div.getShinsakaiIinKensakuJoken().getTxtMaxCount().setValue(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
    }

    /**
     * 条件をクリア です。
     *
     */
    public void get条件をクリア() {
        div.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei().clearValue();
        div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().clearFromValue();
        div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().clearToValue();
        div.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType().setSelectedValue(new RString("前方一致"));
        div.getShinsakaiIinKensakuJoken().getTxtMaxCount().clearValue();
    }

    /**
     * 審査会委員一覧情報を取得します。
     *
     * @param shinsakaiIinHoshuNyuryoku List<ShinsakaiIinJoho>
     */
    public void edit審査会委員一覧情報(List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku) {
        List<dgShinsakaiIin_Row> rowList = new ArrayList();
        for (ShinsakaiIinJoho shinsakaiIinJoho : shinsakaiIinHoshuNyuryoku) {
            if (shinsakaiIinJoho.get廃止フラグ()) {
                廃止フラグ = new RString("有効");
            } else {
                廃止フラグ = new RString("無効");
            }
            資格 = get資格(shinsakaiIinJoho.get資格コード().getKey());
            dgShinsakaiIin_Row row = new dgShinsakaiIin_Row(
                    shinsakaiIinJoho.getコード(),
                    shinsakaiIinJoho.get氏名().value(),
                    shinsakaiIinJoho.getカナ().value(),
                    資格,
                    new RString(shinsakaiIinJoho.get開始年月日().toString()),
                    new RString(shinsakaiIinJoho.get終了年月日().toString()),
                    廃止フラグ);
            rowList.add(row);
        }
        div.getShinsakaiIin().getDgShinsakaiIin().setDataSource(rowList);
    }

    /**
     * 審査会実績一覧情報を取得します。
     *
     * @param shinsakaiIinHoshuNyuryoku List<ShinsakaiIinJoho>
     */
    public void set審査会実績(List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku) {
        div.getShinsakaiJisseki().getTxtShisakaiIinCode().setValue(div.getDgShinsakaiIin().getSelectedItems().get(0).getCode());
        div.getShinsakaiJisseki().getTxtShisakaiIinName().setValue(div.getDgShinsakaiIin().getSelectedItems().get(0).getChosainShimei());
        List<dgShinsakaiJisseki_Row> rowList = new ArrayList();
        for (ShinsakaiIinJoho shinsakaiIinJoho : shinsakaiIinHoshuNyuryoku) {
            if (shinsakaiIinJoho.get出欠()) {
                出欠 = new RString("出席");
            } else {
                出欠 = new RString("欠席");
            }
            if (shinsakaiIinJoho.get振込()) {
                振込 = 振込_出力済;
            } else {
                振込 = 振込_出力未;
            }
            if (new RString("1").equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                区分 = 区分_審査報酬;
            } else {
                区分 = 区分_その他報酬;
            }
            if (new RString("0").equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                合議体長区分 = new RString("通常");
            } else if (new RString("1").equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                合議体長区分 = new RString("副合議体長");
            } else {
                合議体長区分 = new RString("合議体長");
            }
            dgShinsakaiJisseki_Row row = new dgShinsakaiJisseki_Row(
                    null,
                    new RString(shinsakaiIinJoho.get実施日().toString()),
                    区分,
                    shinsakaiIinJoho.get審査会開催番号(),
                    new RString(String.valueOf(shinsakaiIinJoho.get合議体番号())),
                    合議体長区分,
                    出欠,
                    shinsakaiIinJoho.get出席(),
                    shinsakaiIinJoho.get退席(),
                    new RString(String.valueOf(shinsakaiIinJoho.get審査報酬額())),
                    new RString(String.valueOf(shinsakaiIinJoho.getその他報酬額())),
                    new RString(String.valueOf(shinsakaiIinJoho.get税率())),
                    new RString(String.valueOf(shinsakaiIinJoho.get交通費等())),
                    new RString(String.valueOf(shinsakaiIinJoho.get控除税額())),
                    new RString(String.valueOf(shinsakaiIinJoho.get税引後支払額())),
                    shinsakaiIinJoho.get支払メモ(),
                    振込,
                    new RString(String.valueOf(shinsakaiIinJoho.get連番())),
                    shinsakaiIinJoho.get開催結果開催番号()
            );
            rowList.add(row);
        }
        div.getDgShinsakaiJisseki().setDataSource(rowList);
    }

    /**
     * 審査会実績明細一覧情報を設立する。
     *
     */
    public void set審査会実績明細() {
        div.setHiddenColumnState(状態_修正);
        div.getShinsakaiIinKensakuJoken().getTxtMaxCount().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getRemban());
        div.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKekkaKaisaiBango());
        報酬区分 = div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun();
        if (区分_審査報酬.equals(報酬区分)) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(new FlexibleDate(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(new RTime(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(new RTime(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku().toString())));
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setReadOnly(false);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setReadOnly(true);
        }
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku().toString())));
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setReadOnly(true);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setReadOnly(false);
        }
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu().toString())));
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setReadOnly(false);
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito().toString())));
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setReadOnly(false);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setReadOnly(false);
        銀行振込 = div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi();
        if (振込_出力済.equals(銀行振込)) {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        } else {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        }
        div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setReadOnly(false);
    }

    private RString get資格(RString ゴート) {
        if (new RString("01").equals(ゴート)) {
            資格 = new RString("医師");
            return 資格;
        } else if (new RString("02").equals(ゴート)) {
            資格 = new RString("歯科医師");
            return 資格;
        } else if (new RString("03").equals(ゴート)) {
            資格 = new RString("薬剤師");
            return 資格;
        } else if (new RString("04").equals(ゴート)) {
            資格 = new RString("保健師");
            return 資格;
        } else if (new RString("05").equals(ゴート)) {
            資格 = new RString("助産師");
            return 資格;
        } else if (new RString("06").equals(ゴート)) {
            資格 = new RString("（洵）看護師");
            return 資格;
        } else if (new RString("07").equals(ゴート)) {
            資格 = new RString("理学療法士");
            return 資格;
        } else if (new RString("08").equals(ゴート)) {
            資格 = new RString("作業療法士");
            return 資格;
        } else if (new RString("09").equals(ゴート)) {
            資格 = new RString("社会福祉士");
            return 資格;
        } else if (new RString("10").equals(ゴート)) {
            資格 = new RString("介護福祉士");
            return 資格;
        } else if (new RString("11").equals(ゴート)) {
            資格 = new RString("ソーシャルワーカー");
            return 資格;
        } else if (new RString("12").equals(ゴート)) {
            資格 = new RString("福祉事務所現業員等");
            return 資格;
        } else if (new RString("13").equals(ゴート)) {
            資格 = new RString("ホームヘルパー");
            return 資格;
        } else if (new RString("14").equals(ゴート)) {
            資格 = new RString("介護職員");
            return 資格;
        } else if (new RString("15").equals(ゴート)) {
            資格 = new RString("その他福祉関係者");
            return 資格;
        } else if (new RString("16").equals(ゴート)) {
            資格 = new RString("行政関係者");
            return 資格;
        } else {
            資格 = new RString("その他");
            return 資格;
        }
    }

    /**
     * 審査会実績明細一覧情報の削除です。
     *
     */
    public void get削除() {
        div.setHiddenColumnState(状態_削除);
        報酬区分 = div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun();
        if (区分_審査報酬.equals(報酬区分)) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(new FlexibleDate(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(new RTime(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(new RTime(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu().toString())));
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito().toString())));
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setReadOnly(true);
        銀行振込 = div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi();
        if (振込_出力済.equals(銀行振込)) {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        } else {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        }
        div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setReadOnly(true);
    }

    /**
     * 報酬税率のonBlurです。
     *
     */
    public void set報酬税率() {
        報酬区分 = div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue();
        審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(報酬区分)) {
            控除税額 = (審査報酬額.add(報酬税率)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (審査報酬額.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        } else {
            控除税額 = (その他報酬.add(交通費等)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (その他報酬.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        }
    }

    /**
     * 審査報酬額のonBlurです。
     *
     */
    public void set審査報酬額() {
        報酬区分 = div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue();
        審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(報酬区分)) {
            控除税額 = (審査報酬額.add(報酬税率)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (審査報酬額.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        } else {
            控除税額 = (その他報酬.add(交通費等)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (その他報酬.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        }
    }

    /**
     * その他報酬のonBlurです。
     *
     */
    public void setその他報酬() {
        報酬区分 = div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue();
        審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(報酬区分)) {
            控除税額 = (審査報酬額.add(報酬税率)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (審査報酬額.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        } else {
            控除税額 = (その他報酬.add(交通費等)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (その他報酬.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        }
    }

    /**
     * その他報酬のonBlurです。
     *
     */
    public void set交通費等() {
        報酬区分 = div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue();
        審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(報酬区分)) {
            控除税額 = (審査報酬額.add(報酬税率)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (審査報酬額.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        } else {
            控除税額 = (その他報酬.add(交通費等)).multiply(報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(控除税額);
            税引後支払額 = (その他報酬.add(交通費等)).subtract(控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(税引後支払額);
        }
    }

    /**
     * 登録するのボタンです。
     *
     */
    public void set登録する() {
        状態 = div.getHiddenColumnState();
        審査会開催番号 = div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango();
        if (!審査会開催番号.isEmpty() && 状態_修正.equals(状態)) {
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setColumnState(状態);
            審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
            その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
            報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
            交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
            RString 支払メモ = div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().getValue();
            銀行振込 = div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().getSelectedValue();
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShinsaHoshukaku(new RString(審査報酬額.toString()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setSonotaHoshukaku(new RString(その他報酬.toString()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setZeiritsu(new RString(報酬税率.toString()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKotsuhito(new RString(交通費等.toString()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShiharaiMemo(支払メモ);
            if (銀行振込_する.equals(銀行振込)) {
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).setFurikomi(振込_出力済);
            } else {
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).setFurikomi(振込_出力未);
            }
        }
        if (状態_削除.equals(状態)) {
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setColumnState(状態);
        }
    }

    /**
     * 「保存する」ボタンを押下し、更新処理を続けます。
     *
     * @param models 審査会委員情報
     * @param row 審査会委員一覧情報
     * @return ShinsakaiIinHoshuJissekiJohoBuilder
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder onClick_Update(Models<ShinsakaiIinHoshuJissekiJohoIdentifier, ShinsakaiIinHoshuJissekiJoho> models,
            dgShinsakaiJisseki_Row row) {
        審査会委員報酬区分 = div.getShinsakaiJisseki().getTxtShisakaiIinCode().getValue();
        if (SHINCHAKAI.equals(審査会委員報酬区分)) {
            審査会委員報酬区分 = 審査会;
        } else if (SONOTA.equals(審査会委員報酬区分)) {
            審査会委員報酬区分 = その他研修等;
        }
        ShinsakaiIinHoshuJissekiJohoIdentifier key = new ShinsakaiIinHoshuJissekiJohoIdentifier(
                審査会委員報酬区分,
                new Code(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun().toString()),
                new FlexibleDate(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()),
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getRemban().toString()));
        ShinsakaiIinHoshuJissekiJoho shinasa = models.get(key);
        ShinsakaiIinHoshuJissekiJohoBuilder build = shinasa.createBuilderForEdit();
        build.set介護認定審査会報酬税率(Integer.valueOf(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().toString()));
        build.set介護認定審査報酬(Integer.valueOf(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().toString()));
        build.set介護認定審査その他報酬(Integer.valueOf(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().toString()));
        build.set介護認定審査交通費等(Integer.valueOf(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().toString()));
        build.set介護認定審査控除税額(Integer.valueOf(div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().toString()));
        build.set介護認定審査報酬合計(Integer.valueOf(div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().toString()));
        build.set介護認定審査報酬支払メモ(div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().getValue());
        if (銀行振込_する.equals(div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().getSelectedValue())) {
            build.set銀行振込出力フラグ(true);
        } else if (銀行振込_しない.equals(div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().getSelectedValue())) {
            build.set銀行振込出力フラグ(false);
        }
        shinasa.toEntity().setState(EntityDataState.Modified);
        return build;
    }

}
