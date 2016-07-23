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
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 審査会委員報酬入力のHandlerクラスです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public class ShinsakaiIinHoshuNyuryokuHandler {

    private static final RString 銀行振込_する = new RString("する");
    private static final RString 銀行振込_しない = new RString("しない");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString SHINCHAKAI = new RString("審査会");
    private static final RString SONOTA = new RString("その他（研修等）");
    private final ShinsakaiIinHoshuNyuryokuDiv div;
    private static final Decimal HYAKU = new Decimal("100");
    private static final RString 振込_出力済 = new RString("出力済");
    private static final RString 振込_出力未 = new RString("出力未");
    private static final RString 前方一致 = new RString("前方一致");
    private static final RString コンマ = new RString(",");
    private static final RString ZIEO_ZIEO = new RString("00");
    private static final int ZIEO = 0;
    private static final int TWO = 2;
    private static final int FOUR = 4;
    private static final RString COLON = new RString(":");

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
        div.getTextBoxNum().clearValue();
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
            if (shinsakaiIinJoho.is廃止フラグ()) {
                廃止フラグ = IsHaishi.廃止.get名称();
            } else {
                廃止フラグ = IsHaishi.有効.get名称();
            }
            dgShinsakaiIin_Row row = new dgShinsakaiIin_Row(
                    shinsakaiIinJoho.getコード(),
                    shinsakaiIinJoho.get氏名().value(),
                    shinsakaiIinJoho.getカナ().value(),
                    Sikaku.toValue(shinsakaiIinJoho.get資格コード().getKey()).get名称(),
                    dateFormat(new RString(shinsakaiIinJoho.get開始年月日().toString())),
                    dateFormat(new RString(shinsakaiIinJoho.get終了年月日().toString())),
                    廃止フラグ);
            rowList.add(row);
        }
        div.getShinsakaiIin().getDgShinsakaiIin().setDataSource(rowList);
    }

    /**
     * 審査会実績一覧情報を取得します。
     *
     * @param shinsakaiIinHoshuNyuryoku List<ShinsakaiIinJoho>
     * @param isNULL boolean
     */
    public void set審査会実績(List<ShinsakaiIinJoho> shinsakaiIinHoshuNyuryoku, boolean isNULL) {
        RString 出欠;
        RString 振込;
        RString 区分;
        RString 合議体長区分;
        RString 実施日;
        div.getShinsakaiJisseki().getTxtShisakaiIinCode().setValue(div.getDgShinsakaiIin().getSelectedItems().get(0).getCode());
        div.getShinsakaiJisseki().getTxtShisakaiIinName().setValue(div.getDgShinsakaiIin().getSelectedItems().get(0).getChosainShimei());
        List<dgShinsakaiJisseki_Row> rowList = new ArrayList();
        if (isNULL) {
            div.getShinsakaiJisseki().setDisplayNone(false);
            div.getDgShinsakaiJisseki().setVisible(false);
            div.getShinsakaiJissekiMeisai().setVisible(false);
        } else {
            div.getShinsakaiJisseki().setDisplayNone(false);
            div.getDgShinsakaiJisseki().setVisible(true);
            div.getShinsakaiJissekiMeisai().setVisible(true);
            for (ShinsakaiIinJoho shinsakaiIinJoho : shinsakaiIinHoshuNyuryoku) {
                if (shinsakaiIinJoho.get実施日() == null) {
                    実施日 = RString.EMPTY;
                } else {
                    実施日 = dateFormat(new RString(shinsakaiIinJoho.get実施日().toString()));
                }
                if (shinsakaiIinJoho.get区分() == null) {
                    区分 = RString.EMPTY;
                } else if (ShinsakaiIinHoshukubun.審査報酬.getコード().equals(shinsakaiIinJoho.get区分().value())) {
                    区分 = ShinsakaiIinHoshukubun.審査報酬.get名称();
                } else {
                    区分 = ShinsakaiIinHoshukubun.その他報酬.get名称();
                }
                if (shinsakaiIinJoho.is出欠()) {
                    出欠 = IsShusseki.出席.get名称();
                } else {
                    出欠 = IsShusseki.欠席.get名称();
                }
                if (shinsakaiIinJoho.is振込()) {
                    振込 = IsGinkoFurikomiShutsuryoku.出力済.get名称();
                } else {
                    振込 = IsGinkoFurikomiShutsuryoku.出力未.get名称();
                }
                if (GogitaichoKubunCode.通常.getコード().equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                    合議体長区分 = GogitaichoKubunCode.通常.get名称();
                } else if (GogitaichoKubunCode.副合議体長.getコード().equals(shinsakaiIinJoho.get合議体長区分().getKey())) {
                    合議体長区分 = GogitaichoKubunCode.副合議体長.get名称();
                } else {
                    合議体長区分 = GogitaichoKubunCode.合議体長.get名称();
                }
                dgShinsakaiJisseki_Row row = new dgShinsakaiJisseki_Row(
                        RString.EMPTY,
                        実施日,
                        区分,
                        shinsakaiIinJoho.get開催結果開催番号(),
                        new RString(String.valueOf(shinsakaiIinJoho.get合議体番号())),
                        合議体長区分,
                        出欠,
                        toTime(shinsakaiIinJoho.get出席()),
                        toTime(shinsakaiIinJoho.get退席()),
                        DecimalFormatter.toコンマ区切りRString(new Decimal(shinsakaiIinJoho.get審査報酬額()), 0),
                        DecimalFormatter.toコンマ区切りRString(new Decimal(shinsakaiIinJoho.getその他報酬額()), 0),
                        new RString(String.valueOf(shinsakaiIinJoho.get税率())),
                        DecimalFormatter.toコンマ区切りRString(new Decimal(shinsakaiIinJoho.get交通費等()), 0),
                        DecimalFormatter.toコンマ区切りRString(new Decimal(shinsakaiIinJoho.get控除税額()), 0),
                        DecimalFormatter.toコンマ区切りRString(new Decimal(shinsakaiIinJoho.get税引後支払額()), 0),
                        shinsakaiIinJoho.get支払メモ(),
                        振込,
                        new RString(String.valueOf(shinsakaiIinJoho.get連番())),
                        shinsakaiIinJoho.get開催結果開催番号()
                );
                rowList.add(row);
                if (shinsakaiIinJoho.get連番() == 0) {
                    row.setDeleteButtonState(DataGridButtonState.Disabled);
                    row.setSelectButtonState(DataGridButtonState.Enabled);
                } else {
                    row.setDeleteButtonState(DataGridButtonState.Enabled);
                    row.setSelectButtonState(DataGridButtonState.Enabled);
                }
            }
            div.getDgShinsakaiJisseki().setDataSource(rowList);
        }
    }

    /**
     * 審査会実績明細一覧情報を修正する。
     *
     */
    public void set修正() {
        div.setHiddenColumnState(状態_修正);
        div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setDisabled(true);
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(toFlexibleDate(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setDisabled(true);
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setDisabled(true);
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku()));
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setDisabled(false);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setDisabled(true);
        }
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku()));
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(true);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(false);
        }
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(new Decimal(
                Integer.valueOf(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu().toString())));
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setDisabled(false);
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito()));
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setDisabled(false);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku()));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku()));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setDisabled(false);
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi())) {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        } else {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        }
        div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setDisabled(false);
    }

    /**
     * 審査会実績明細一覧情報を追加する。
     *
     */
    public void set追加() {
        boolean is新追加 = false;
        if (div.getHiddenColumnState().isNullOrEmpty()) {
            is新追加 = true;
        }
        div.setHiddenColumnState(状態_追加);
        div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setDisabled(false);
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else if (ShinsakaiIinHoshukubun.その他報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setDisabled(false);
        if (div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi().isNullOrEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(FlexibleDate.getNowDate());
        } else {
            div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(
                    toFlexibleDate(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        }
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setDisabled(true);
        if (div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isNullOrEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(null);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(
                    new RTime(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        if (div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isNullOrEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(null);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(
                    new RTime(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku()));
        //TODO 追加状態,審査報酬額未実装。
        //TODO 追加状態,交通費等未実装。
        edit実施日();
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(true);
            div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setDisabled(true);
            div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setDisabled(true);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(false);
            div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setDisabled(false);
            div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setDisabled(false);
        }
        if (!is新追加) {
            div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(
                    toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu()));
        }
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito()));
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku()));
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku()));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku()));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setDisabled(false);
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setDisabled(false);
        if (振込_出力未.equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi())) {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        } else {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        }

    }

    /**
     * 審査会実績明細一覧情報の削除です。
     *
     */
    public void get削除() {
        div.setHiddenColumnState(状態_削除);
        div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setDisabled(true);
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKubun())) {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SHINCHAKAI);
        } else {
            div.getShinsakaiJissekiMeisai().getRadHoshuKubun().setSelectedValue(SONOTA);
        }
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setValue(toFlexibleDate(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getJisshiNengappi()));
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsakaiKaisaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaiBango());
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getGogitaichoKubun());
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtShukketsu().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShukketsu());
        div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setDisabled(true);
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShusseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setDisabled(true);
        if (!div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki().isEmpty()) {
            div.getShinsakaiJissekiMeisai().getTxtTaisekiJikan().setValue(new RTime(
                    div.getDgShinsakaiJisseki().getSelectedItems().get(0).getTaiseki()));
        }
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShinsaHoshukaku()));
        div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getSonotaHoshukaku()));
        div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeiritsu()));
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKotsuhito()));
        div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getKojozeigaku()));
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setDisabled(true);
        div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(
                toDecimal(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getZeibikigoShiharaigaku()));
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setValue(
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).getShiharaiMemo());
        div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().setDisabled(true);
        if (IsGinkoFurikomiShutsuryoku.出力済.get名称().equals(div.getDgShinsakaiJisseki().getSelectedItems().get(0).getFurikomi())) {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_する);
        } else {
            div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setSelectedValue(銀行振込_しない);
        }
        div.getShinsakaiJissekiMeisai().getRadGinkoFurikomi().setDisabled(true);
    }

    /**
     * 報酬税率のonBlurです。
     *
     */
    public void set報酬税率() {
        Decimal 報酬税率_審査報酬額 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue());
        Decimal 報酬税率_交通費等 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue());
        Decimal 報酬税率_報酬税率 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue());
        Decimal 報酬税率_その他報酬 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue());
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal 報酬税率_控除税額 = (報酬税率_審査報酬額.add(報酬税率_交通費等)).multiply(報酬税率_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(報酬税率_控除税額.roundUpTo(0));
            Decimal 報酬税率_税引後支払額 = (報酬税率_審査報酬額.add(報酬税率_交通費等)).subtract(報酬税率_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(報酬税率_税引後支払額);
        } else {
            Decimal 報酬税率_控除税額 = (報酬税率_その他報酬.add(報酬税率_交通費等)).multiply(報酬税率_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(報酬税率_控除税額.roundUpTo(0));
            Decimal 報酬税率_税引後支払額 = (報酬税率_その他報酬.add(報酬税率_交通費等)).subtract(報酬税率_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(報酬税率_税引後支払額);
        }
    }

    /**
     * 審査報酬額のonBlurです。
     *
     */
    public void set審査報酬額() {
        Decimal 審査報酬額_審査報酬額 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue());
        Decimal 審査報酬額_交通費等 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue());
        Decimal 審査報酬額_報酬税率 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue());
        Decimal 審査報酬額_その他報酬 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue());
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal 審査報酬額_控除税額 = (審査報酬額_審査報酬額.add(審査報酬額_交通費等)).multiply(審査報酬額_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(審査報酬額_控除税額.roundUpTo(0));
            Decimal 審査報酬額_税引後支払額 = (審査報酬額_審査報酬額.add(審査報酬額_交通費等)).subtract(審査報酬額_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(審査報酬額_税引後支払額);
        } else {
            Decimal 審査報酬額_控除税額 = (審査報酬額_その他報酬.add(審査報酬額_交通費等)).multiply(審査報酬額_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(審査報酬額_控除税額.roundUpTo(0));
            Decimal 審査報酬額_税引後支払額 = (審査報酬額_その他報酬.add(審査報酬額_交通費等)).subtract(審査報酬額_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(審査報酬額_税引後支払額);
        }
    }

    /**
     * その他報酬のonBlurです。
     *
     */
    public void setその他報酬() {
        Decimal その他報酬_審査報酬額 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue());
        Decimal その他報酬_交通費等 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue());
        Decimal その他報酬_報酬税率 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue());
        Decimal その他報酬_その他報酬 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue());
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal その他報酬_控除税額 = (その他報酬_審査報酬額.add(その他報酬_交通費等)).multiply(その他報酬_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(その他報酬_控除税額.roundUpTo(0));
            Decimal その他報酬_税引後支払額 = (その他報酬_審査報酬額.add(その他報酬_交通費等)).subtract(その他報酬_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(その他報酬_税引後支払額);
        } else {
            Decimal その他報酬_控除税額 = (その他報酬_その他報酬.add(その他報酬_交通費等)).multiply(その他報酬_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(その他報酬_控除税額.roundUpTo(0));
            Decimal その他報酬_税引後支払額 = (その他報酬_その他報酬.add(その他報酬_交通費等)).subtract(その他報酬_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(その他報酬_税引後支払額);
        }
    }

    /**
     * その他報酬のonBlurです。
     *
     */
    public void set交通費等() {
        Decimal 交通費等_審査報酬額 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue());
        Decimal 交通費等_交通費等 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue());
        Decimal 交通費等_報酬税率 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue());
        Decimal 交通費等_その他報酬 = to_Decimal(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue());
        if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
            Decimal 交通費等_控除税額 = (交通費等_審査報酬額.add(交通費等_交通費等)).multiply(交通費等_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(交通費等_控除税額.roundUpTo(0));
            Decimal 交通費等_税引後支払額 = (交通費等_審査報酬額.add(交通費等_交通費等)).subtract(交通費等_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(交通費等_税引後支払額);
        } else {
            Decimal 交通費等_控除税額 = (交通費等_その他報酬.add(交通費等_交通費等)).multiply(交通費等_報酬税率).divide(HYAKU);
            div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().setValue(交通費等_控除税額.roundUpTo(0));
            Decimal 交通費等_税引後支払額 = (交通費等_その他報酬.add(交通費等_交通費等)).subtract(交通費等_控除税額.roundUpTo(0));
            div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().setValue(交通費等_税引後支払額);
        }
    }

    /**
     * 登録するのボタンです。
     *
     */
    public void set登録する() {
        if (!状態_削除.equals(div.getHiddenColumnState())) {
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setColumnState(div.getHiddenColumnState());
            if (SHINCHAKAI.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKubun(ShinsakaiIinHoshukubun.審査報酬.get名称());
            } else if (SONOTA.equals(div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue())) {
                div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKubun(ShinsakaiIinHoshukubun.その他報酬.get名称());
            }
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShinsakaiKaisaiBango(
                    div.getShinsakaiJissekiMeisai().getTxtShinsakaiKaisaiBango().getValue());
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setGogitaiBango(
                    div.getShinsakaiJissekiMeisai().getTxtGogitaiBango().getValue());
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setGogitaichoKubun(
                    div.getShinsakaiJissekiMeisai().getTxtGogitaichoKubun().getValue());
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShukketsu(
                    div.getShinsakaiJissekiMeisai().getTxtShukketsu().getValue());
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setJisshiNengappi(
                    dateFormat(new RString(div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().getValue().toString())));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShusseki(
                    toTime(div.getShinsakaiJissekiMeisai().getTxtShussekiJikan().getText()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setTaiseki(
                    toTime(div.getTxtTaisekiJikan().getText()));
            //TODO 状態_追加、審査会実績一覧選択行の審査報酬額に審査報酬額が未実装。
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShinsaHoshukaku(
                    DecimalFormatter.toコンマ区切りRString(to_Decimal(div.getShinsakaiJissekiMeisai().getTxtShinsaHoshugaku().getValue()), 0));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setSonotaHoshukaku(
                    DecimalFormatter.toコンマ区切りRString(to_Decimal(div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().getValue()), 0));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setZeiritsu(
                    new RString(to_Decimal(div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().getValue()).toString()));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKotsuhito(
                    DecimalFormatter.toコンマ区切りRString(to_Decimal(div.getShinsakaiJissekiMeisai().getTxtKotsuhito().getValue()), 0));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setShiharaiMemo(div.getShinsakaiJissekiMeisai().getTxtShiharaiMemo().getValue());
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setKojozeigaku(
                    DecimalFormatter.toコンマ区切りRString(to_Decimal(div.getShinsakaiJissekiMeisai().getTxtKojozeikaku().getValue()), 0));
            div.getDgShinsakaiJisseki().getSelectedItems().get(0).setZeibikigoShiharaigaku(
                    DecimalFormatter.toコンマ区切りRString(to_Decimal(div.getShinsakaiJissekiMeisai().getTxtZeibikigoShiharaigaku().getValue()), 0));
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
     * 「報酬区分」onChangeです。
     *
     */
    public void edit報酬区分() {
        RString 報酬区分 = div.getShinsakaiJissekiMeisai().getRadHoshuKubun().getSelectedValue();
        if (SHINCHAKAI.equals(報酬区分)) {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(true);
            div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setDisabled(true);
            div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setDisabled(true);
        } else {
            div.getShinsakaiJissekiMeisai().getTxtSonotaHoshu().setDisabled(false);
            edit実施日();
            div.getShinsakaiJissekiMeisai().getTxtKotsuhito().setDisabled(false);
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
        ShinsakaiIinHoshuJissekiJohoIdentifier key = getKey(row);
        ShinsakaiIinHoshuJissekiJoho shinasa = models.get(key);
        ShinsakaiIinHoshuJissekiJohoBuilder build = shinasa.createBuilderForEdit();
        build.set介護認定審査会報酬税率(Integer.valueOf(row.getZeiritsu().toString()));
        build.set介護認定審査報酬(toDecimal(row.getShinsaHoshukaku()).intValue());
        build.set介護認定審査その他報酬(toDecimal(row.getSonotaHoshukaku()).intValue());
        build.set介護認定審査交通費等(toDecimal(row.getKotsuhito()).intValue());
        build.set介護認定審査控除税額(toDecimal(row.getKojozeigaku()).intValue());
        build.set介護認定審査報酬合計(toDecimal(row.getZeibikigoShiharaigaku()).intValue());
        build.set介護認定審査報酬支払メモ(row.getShiharaiMemo());
        if (振込_出力済.equals(row.getFurikomi())) {
            build.set銀行振込出力フラグ(true);
        } else if (振込_出力未.equals(row.getFurikomi())) {
            build.set銀行振込出力フラグ(false);
        }
        return build;
    }

    /**
     * Keyの取得する。
     *
     * @param row dgShinsakaiJisseki_Row
     * @return ShinsakaiIinHoshuJissekiJohoIdentifier
     */
    public ShinsakaiIinHoshuJissekiJohoIdentifier getKey(dgShinsakaiJisseki_Row row) {
        RString kuBun = RString.EMPTY;
        RString 審査会委員報酬区分 = div.getShinsakaiJisseki().getTxtShisakaiIinCode().getValue();
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(row.getKubun())) {
            kuBun = ShinsakaiIinHoshukubun.審査報酬.getコード();
        } else if (ShinsakaiIinHoshukubun.その他報酬.get名称().equals(row.getKubun())) {
            kuBun = ShinsakaiIinHoshukubun.その他報酬.getコード();
        }
        ShinsakaiIinHoshuJissekiJohoIdentifier key = new ShinsakaiIinHoshuJissekiJohoIdentifier(
                審査会委員報酬区分,
                new Code(kuBun.toString()),
                toFlexibleDate(row.getJisshiNengappi()),
                Integer.valueOf(row.getRemban().toString()));
        return key;
    }

    /**
     * 追加の場合下、値を得到する。
     *
     * @param row 審査会委員一覧情報
     * @param maxRemBan maxRemBan
     * @return ShinsakaiIinHoshuJissekiJohoBuilder
     */
    public ShinsakaiIinHoshuJissekiJohoBuilder getValues(dgShinsakaiJisseki_Row row, int maxRemBan) {
        RString kuBun = getKubun(row);
        ShinsakaiIinHoshuJissekiJoho shinsakaiIinHoshuJissekiJoho = new ShinsakaiIinHoshuJissekiJoho(
                div.getShinsakaiJisseki().getTxtShisakaiIinCode().getValue(),
                new Code(kuBun.toString()),
                toFlexibleDate(row.getJisshiNengappi()),
                maxRemBan
        );
        ShinsakaiIinHoshuJissekiJohoBuilder build = shinsakaiIinHoshuJissekiJoho.createBuilderForEdit();
        build.set介護認定審査会開催番号(row.getShinsakaiKaisaiBango());
        build.set介護認定審査会報酬税率(toDecimal(row.getZeiritsu()).intValue());
        build.set介護認定審査報酬(toDecimal(row.getShinsaHoshukaku()).intValue());
        build.set介護認定審査その他報酬(toDecimal(row.getSonotaHoshukaku()).intValue());
        build.set介護認定審査交通費等(toDecimal(row.getKotsuhito()).intValue());
        build.set介護認定審査控除税額(toDecimal(row.getKojozeigaku()).intValue());
        build.set介護認定審査報酬合計(toDecimal(row.getZeibikigoShiharaigaku()).intValue());
        build.set介護認定審査報酬支払年月日(FlexibleDate.EMPTY);
        build.set介護認定審査報酬支払メモ(row.getShiharaiMemo());
        if (振込_出力済.equals(row.getFurikomi())) {
            build.set銀行振込出力フラグ(true);
        } else {
            build.set銀行振込出力フラグ(false);
        }
        return build;
    }

    /**
     * 実施日のonChange、報酬税率が値の設立です。
     *
     */
    public void edit実施日() {
        boolean 実施日Flag = false;
        Decimal 税率;
        List<UzT0007CodeEntity> entity = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.控除税率.getコード(), FlexibleDate.getNowDate());
        if (entity == null || entity.isEmpty() || entity.get(0).getコード名称().isNullOrEmpty()) {
            税率 = new Decimal(ZIEO);
        } else {
            税率 = new Decimal(entity.get(0).getコード名称().toString());
            for (UzT0007CodeEntity tity : entity) {
                実施日Flag = div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().getValue().isBeforeOrEquals(tity.get有効開始年月日());
            }
        }
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setValue(税率);
        div.getShinsakaiJissekiMeisai().getTxtJissekiNengappi().getValue();
        div.getShinsakaiJissekiMeisai().getTxtHoshuZeiritsu().setDisabled(実施日Flag);
    }

    /**
     * 区分の取得です。
     *
     * @param row dgShinsakaiJisseki_Row
     * @return 区分
     */
    public RString getKubun(dgShinsakaiJisseki_Row row) {
        RString kuBun = RString.EMPTY;
        if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(row.getKubun())) {
            kuBun = ShinsakaiIinHoshukubun.審査報酬.getコード();
        } else if (ShinsakaiIinHoshukubun.その他報酬.get名称().equals(row.getKubun())) {
            kuBun = ShinsakaiIinHoshukubun.その他報酬.getコード();
        }
        return kuBun;
    }

    private RString dateFormat(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new FlexibleDate(obj).wareki().toDateString();
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }

    private Decimal toDecimal(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return Decimal.ZERO;
        } else {
            return new Decimal(obj.replace(コンマ, RString.EMPTY).toString());
        }
    }

    private RString toTime(RString obj) {
        if (obj.isNullOrEmpty()) {
            return RString.EMPTY;
        }
        RString hour = obj.substring(ZIEO, TWO);
        RString min = obj.substring(TWO, FOUR);
        return hour.concat(COLON).concat(min).concat(COLON).concat(ZIEO_ZIEO);
    }

    private Decimal to_Decimal(Decimal obj) {
        if (obj == null) {
            return Decimal.ZERO;
        }
        return obj;
    }
}
