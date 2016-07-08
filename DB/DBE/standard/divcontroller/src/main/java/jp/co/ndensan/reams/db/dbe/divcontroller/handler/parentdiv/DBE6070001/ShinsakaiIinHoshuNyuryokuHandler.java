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
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.IsGinkoFurikomiShutsuryoku;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinHoshukubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.ShinsakaiIinHoshuNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.dgShinsakaiIin_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6070001.dgShinsakaiJisseki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
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
    private final ShinsakaiIinHoshuNyuryokuDiv div;
    private static final Decimal HYAKU = new Decimal("100");
    private static final RString 振込_出力済 = new RString("出力済");
    private static final RString 振込_出力未 = new RString("出力未");
    private static final RString 前方一致 = new RString("前方一致");

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
        div.getShinsakaiIinKensakuJoken().getTextBoxNum().setValue(new Decimal((DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)).toString()));
    }

    /**
     * 条件をクリア です。
     *
     */
    public void get条件をクリア() {
        div.getShinsakaiIinKensakuJoken().getTxtShinsaIinmei().clearValue();
        div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().clearFromValue();
        div.getShinsakaiIinKensakuJoken().getTxtKensakuNendo().clearToValue();
        div.getShinsakaiIinKensakuJoken().getDdlHihokenshaNameMatchType().setSelectedValue(前方一致);
        div.getShinsakaiIinKensakuJoken().getTextBoxNum().clearValue();
    }

    /**
     * 審査会委員一覧情報を取得します。
     *
     * @param shinsakaiIinHoshuNyuryoku List<ShinsakaiIinJoho>
     */
    public void edit審査会委員一覧情報(List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku) {
        RString 廃止フラグ;
        List<dgShinsakaiIin_Row> rowList = new ArrayList();
        for (ShinsakaiIinJoho shinsakaiIinJoho : shinsakaiIinHoshuNyuryoku) {
            if (shinsakaiIinJoho.get廃止フラグ()) {
                廃止フラグ = IsHaishi.廃止.get名称();
            } else {
                廃止フラグ = IsHaishi.有効.get名称();
            }
            dgShinsakaiIin_Row row = new dgShinsakaiIin_Row(
                    shinsakaiIinJoho.getコード(),
                    shinsakaiIinJoho.get氏名().value(),
                    shinsakaiIinJoho.getカナ().value(),
                    Sikaku.toValue(shinsakaiIinJoho.get資格コード().getKey()).get名称(),
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
        RString 出欠;
        RString 振込;
        RString 区分;
        RString 合議体長区分;
        div.getShinsakaiJisseki().getTxtShisakaiIinCode().setValue(div.getDgShinsakaiIin().getSelectedItems().get(0).getCode());
        div.getShinsakaiJisseki().getTxtShisakaiIinName().setValue(div.getDgShinsakaiIin().getSelectedItems().get(0).getChosainShimei());
        List<dgShinsakaiJisseki_Row> rowList = new ArrayList();
        for (ShinsakaiIinJoho shinsakaiIinJoho : shinsakaiIinHoshuNyuryoku) {
            if (shinsakaiIinJoho.get出欠()) {
                出欠 = IsShusseki.出席.get名称();
            } else {
                出欠 = IsShusseki.欠席.get名称();
            }
            if (shinsakaiIinJoho.get振込()) {
                振込 = IsGinkoFurikomiShutsuryoku.出力済.get名称();
            } else {
                振込 = IsGinkoFurikomiShutsuryoku.出力未.get名称();
            }
            if (ShinsakaiIinHoshukubun.審査報酬.getコード().equals(shinsakaiIinJoho.get区分().value())) {
                区分 = ShinsakaiIinHoshukubun.審査報酬.get名称();
            } else {
                区分 = ShinsakaiIinHoshukubun.その他報酬.get名称();
            }
            if (GogitaichoKubunCode.通常.getコード().equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                合議体長区分 = GogitaichoKubunCode.通常.get名称();
            } else if (GogitaichoKubunCode.副合議体長.getコード().equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                合議体長区分 = GogitaichoKubunCode.副合議体長.get名称();
            } else {
                合議体長区分 = GogitaichoKubunCode.合議体長.get名称();
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
     * @param shinsakaiIinHoshuNyuryoku List<ShinsakaiIinJoho>
     */
    public void set審査会実績明細(List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku) {
        div.setHiddenColumnState(状態_修正);
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(new FlexibleDate(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        if (div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku().toString().isEmpty()) {
            for (ShinsakaiIinJoho entity : shinsakaiIinHoshuNyuryoku) {
                div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(
                        new Decimal(Integer.valueOf(entity.get介護認定審査会委員別単価().toString())));
            }
        } else {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(
                    new Decimal(Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku().toString())));
        }
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setReadOnly(false);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setReadOnly(true);
        }
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(new Decimal(
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku().toString())));
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setReadOnly(true);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setReadOnly(false);
        }
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(new Decimal(
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu().toString())));
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setReadOnly(false);
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(new Decimal(
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito().toString())));
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setReadOnly(false);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(new Decimal(
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(new Decimal(
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setReadOnly(false);
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi())) {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        } else {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        }
        div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setReadOnly(false);
    }

    /**
     * 審査会実績明細一覧情報の削除です。
     *
     */
    public void get削除() {
        div.setHiddenColumnState(状態_削除);
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(new FlexibleDate(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(new Decimal(Integer.valueOf(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(new Decimal(Integer.valueOf(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(new Decimal(Integer.valueOf(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu().toString())));
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(new Decimal(Integer.valueOf(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito().toString())));
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setReadOnly(true);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(new Decimal(Integer.valueOf(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(new Decimal(Integer.valueOf(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku().toString())));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setReadOnly(true);
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi())) {
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
        Decimal 報酬税率_審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        Decimal 報酬税率_交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        Decimal 報酬税率_報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        Decimal 報酬税率_その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal 報酬税率_控除税額 = (報酬税率_審査報酬額.add(報酬税率_交通費等)).multiply(報酬税率_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(報酬税率_控除税額);
            Decimal 報酬税率_税引後支払額 = (報酬税率_審査報酬額.add(報酬税率_交通費等)).subtract(報酬税率_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(報酬税率_税引後支払額);
        } else {
            Decimal 報酬税率_控除税額 = (報酬税率_その他報酬.add(報酬税率_交通費等)).multiply(報酬税率_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(報酬税率_控除税額);
            Decimal 報酬税率_税引後支払額 = (報酬税率_その他報酬.add(報酬税率_交通費等)).subtract(報酬税率_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(報酬税率_税引後支払額);
        }
    }

    /**
     * 審査報酬額のonBlurです。
     *
     */
    public void set審査報酬額() {
        Decimal 審査報酬額_審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        Decimal 審査報酬額_交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        Decimal 審査報酬額_報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        Decimal 審査報酬額_その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal 審査報酬額_控除税額 = (審査報酬額_審査報酬額.add(審査報酬額_交通費等)).multiply(審査報酬額_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(審査報酬額_控除税額);
            Decimal 審査報酬額_税引後支払額 = (審査報酬額_審査報酬額.add(審査報酬額_交通費等)).subtract(審査報酬額_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(審査報酬額_税引後支払額);
        } else {
            Decimal 審査報酬額_控除税額 = (審査報酬額_その他報酬.add(審査報酬額_交通費等)).multiply(審査報酬額_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(審査報酬額_控除税額);
            Decimal 審査報酬額_税引後支払額 = (審査報酬額_その他報酬.add(審査報酬額_交通費等)).subtract(審査報酬額_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(審査報酬額_税引後支払額);
        }
    }

    /**
     * その他報酬のonBlurです。
     *
     */
    public void setその他報酬() {
        Decimal その他報酬_審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        Decimal その他報酬_交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        Decimal その他報酬_報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        Decimal その他報酬_その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal その他報酬_控除税額 = (その他報酬_審査報酬額.add(その他報酬_交通費等)).multiply(その他報酬_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(その他報酬_控除税額);
            Decimal その他報酬_税引後支払額 = (その他報酬_審査報酬額.add(その他報酬_交通費等)).subtract(その他報酬_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(その他報酬_税引後支払額);
        } else {
            Decimal その他報酬_控除税額 = (その他報酬_その他報酬.add(その他報酬_交通費等)).multiply(その他報酬_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(その他報酬_控除税額);
            Decimal その他報酬_税引後支払額 = (その他報酬_その他報酬.add(その他報酬_交通費等)).subtract(その他報酬_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(その他報酬_税引後支払額);
        }
    }

    /**
     * その他報酬のonBlurです。
     *
     */
    public void set交通費等() {
        Decimal 交通費等_審査報酬額 = div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue();
        Decimal 交通費等_交通費等 = div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue();
        Decimal 交通費等_報酬税率 = div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue();
        Decimal 交通費等_その他報酬 = div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue();
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal 交通費等_控除税額 = (交通費等_審査報酬額.add(交通費等_交通費等)).multiply(交通費等_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(交通費等_控除税額);
            Decimal 交通費等_税引後支払額 = (交通費等_審査報酬額.add(交通費等_交通費等)).subtract(交通費等_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(交通費等_税引後支払額);
        } else {
            Decimal 交通費等_控除税額 = (交通費等_その他報酬.add(交通費等_交通費等)).multiply(交通費等_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(交通費等_控除税額);
            Decimal 交通費等_税引後支払額 = (交通費等_その他報酬.add(交通費等_交通費等)).subtract(交通費等_控除税額);
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(交通費等_税引後支払額);
        }
    }

    /**
     * 登録するのボタンです。
     *
     */
    public void set登録する() {
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango().isEmpty()
                && 状態_修正.equals(div.getHiddenColumnState())) {
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setColumnState(div.getHiddenColumnState());
            RString 支払メモ = div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().getValue();
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShinsaHoshukaku(
                    new RString(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue().intValue()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setSonotaHoshukaku(
                    new RString(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue().intValue()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setZeiritsu(
                    new RString(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue().intValue()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKotsuhito(
                    new RString(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue().intValue()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShiharaiMemo(支払メモ);
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKojozeigaku(
                    new RString(div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().getValue().intValue()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setZeibikigoShiharaigaku(
                    new RString(div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().getValue().intValue()));
            if (銀行振込_する.equals(div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().getSelectedValue())) {
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).setFurikomi(IsGinkoFurikomiShutsuryoku.出力済.get名称());
            } else {
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).setFurikomi(IsGinkoFurikomiShutsuryoku.出力未.get名称());
            }
        }
        if (状態_削除.equals(div.getHiddenColumnState())) {
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setColumnState(div.getHiddenColumnState());
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
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().getValue().intValue();
        ShinsakaiIinHoshuJissekiJohoIdentifier key = getKey();
        ShinsakaiIinHoshuJissekiJoho shinasa = models.get(key);
        ShinsakaiIinHoshuJissekiJohoBuilder build = shinasa.createBuilderForEdit();
        build.set介護認定審査会報酬税率(Integer.valueOf(row.getZeiritsu().toString()));
        build.set介護認定審査報酬(Integer.valueOf(row.getShinsaHoshukaku().toString()));
        build.set介護認定審査その他報酬(Integer.valueOf(row.getSonotaHoshukaku().toString()));
        build.set介護認定審査交通費等(Integer.valueOf(row.getKotsuhito().toString()));
        build.set介護認定審査控除税額(Integer.valueOf(row.getKojozeigaku().toString()));
        build.set介護認定審査報酬合計(Integer.valueOf(row.getZeibikigoShiharaigaku().toString()));
        build.set介護認定審査報酬支払メモ(row.getShiharaiMemo());
        if (振込_出力済.equals(row.getGogitaichoKubun())) {
            build.set銀行振込出力フラグ(true);
        } else if (振込_出力未.equals(row.getGogitaichoKubun())) {
            build.set銀行振込出力フラグ(false);
        }
        shinasa.toEntity().setState(EntityDataState.Modified);
        return build;
    }

    /**
     * Keyの取得する。
     *
     * @return ShinsakaiIinHoshuJissekiJohoIdentifier
     */
    public ShinsakaiIinHoshuJissekiJohoIdentifier getKey() {
        RString kuBun = new RString("");
        RString 審査会委員報酬区分 = div.getShinsakaiJisseki().getTxtShisakaiIinCode().getValue();
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            kuBun = ShinsakaiIinHoshukubun.審査報酬.getコード();
        } else if (ShinsakaiIinHoshukubun.その他報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            kuBun = ShinsakaiIinHoshukubun.その他報酬.getコード();
        }
        ShinsakaiIinHoshuJissekiJohoIdentifier key = new ShinsakaiIinHoshuJissekiJohoIdentifier(
                審査会委員報酬区分,
                new Code(kuBun.toString()),
                new FlexibleDate(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()),
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getRemban().toString()));
        return key;
    }
}
