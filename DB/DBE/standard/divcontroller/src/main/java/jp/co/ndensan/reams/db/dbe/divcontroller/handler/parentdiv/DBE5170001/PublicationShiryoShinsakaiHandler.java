
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE517000.DBE517000_ShinsakaiShiryoParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo.ShutsuryokuStyle;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsShiryoSakuseiZumi;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護認定審査会資料作成のコントローラです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakaiHandler {

    private final RString 個別設定 = new RString("2");
    private final RString 選択 = new RString("1");
    private final RString 作成条件_全件 = new RString("key0");
    private final RString 作成条件_範囲指定 = new RString("key1");
    private final RString 印刷帳票_組み合わせ = new RString("0");
    private final RString 印刷帳票_審査会対象者一覧 = new RString("0");
    private final RString 印刷帳票_特記事項 = new RString("1");
    private final RString 印刷帳票_一次判定結果票 = new RString("2");
    private final RString 印刷帳票_特記事項_一次判定 = new RString("3");
    private final RString 印刷帳票_主治医意見書 = new RString("4");
    private final RString 印刷帳票_その他資料 = new RString("5");
    private final RString 印刷帳票_概況特記 = new RString("2");
    private final RString 印刷帳票_審査会開催のお知らせ = new RString("2");
    private final RString 印刷帳票_予備判定記入票 = new RString("3");
    private final RString 印刷帳票_概況特記一覧 = new RString("4");
    private final RString 概況特記出力する = new RString("1");
    private final RString 概況特記一覧出力する = new RString("1");
    private final RString ダミー = new RString("0");
    private final RString 精神科医所属 = new RString("0");
    private final PublicationShiryoShinsakaiDiv div;
    private static final int INT_4 = 4;
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;
    private static final int INT_8 = 8;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会資料作成Div
     */
    public PublicationShiryoShinsakaiHandler(PublicationShiryoShinsakaiDiv div) {
        this.div = div;
    }

    /**
     * 介護認定審査会資料作成の初期化を設定します。
     *
     * @param 開催予定情報 開催予定情報
     */
    public void onLoad(KaisaiYoteiJohoBusiness 開催予定情報) {
        審査会情報の設定(開催予定情報);
        出力条件の設定();
        div.getTxtShiryoNoStart().setDisabled(true);
        div.getTxtSiryoNoEnd().setDisabled(true);
    }

    /**
     * 作成条件ラジオボタンを変更する場合、表示項目を変更する。
     */
    public void onChange作成条件() {
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        List<RString> 印刷帳票_審査会資料組み合わせ = new ArrayList<>();
        List<RString> 印刷帳票_審査会資料以外 = new ArrayList<>();
        List<RString> 印刷帳票_審査会資料 = new ArrayList<>();
        clearChk印刷帳票();
        if (作成条件_全件.equals(作成条件)) {
            set事務局印刷帳票By作成条件_全件(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
            setChk事務局帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
            印刷帳票_審査会資料組み合わせ.clear();
            印刷帳票_審査会資料以外.clear();
            印刷帳票_審査会資料.clear();
            set委員印刷帳票By作成条件_全件(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
            setChk委員帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
            set審査会資料活性制御();
            set各コントロール活性制御By作成条件();
        } else if (作成条件_範囲指定.equals(作成条件)) {
            set事務局印刷帳票By作成条件_範囲追加(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
            setChk事務局帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
            印刷帳票_審査会資料組み合わせ.clear();
            印刷帳票_審査会資料以外.clear();
            印刷帳票_審査会資料.clear();
            set委員印刷帳票By作成条件_範囲追加(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
            setChk委員帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
            set審査会資料活性制御();
            set各コントロール活性制御By作成条件();
        } else {
            set事務局印刷帳票By作成条件_範囲追加(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
            setChk事務局帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
            印刷帳票_審査会資料組み合わせ.clear();
            印刷帳票_審査会資料以外.clear();
            印刷帳票_審査会資料.clear();
            set委員印刷帳票By作成条件_範囲追加(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
            setChk委員帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
            set審査会資料活性制御();
            set各コントロール活性制御By作成条件();
        }
        setCcdBunshoNoInputControl();
    }

    /**
     * 出力スタイルを変更する場合、表示項目を変更する。
     */
    public void onClick_syutuHeDa() {
        List<RString> 印刷帳票_事務局審査会資料 = new ArrayList<>();
        List<RString> 印刷帳票_委員審査会資料 = new ArrayList<>();
        if (!div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_組み合わせ)) {
            印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
        } else {
            if (選択.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            } else {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
                印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            }
        }
        if (!div.getChkPrintChohyoIin().getSelectedKeys().contains(印刷帳票_組み合わせ)) {
            印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
        } else {
            if (選択.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            } else {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
                印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            }
        }
        div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(印刷帳票_事務局審査会資料);
        div.getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(印刷帳票_委員審査会資料);
    }

    /**
     * 事務局用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     */
    public void onClickChk組み合わせ帳票_事務() {
        if (div.getPublishingConditionForJimukyoku().getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_組み合わせ)) {
            div.getPublishingConditionForJimukyoku().getChkPrintChohyoShinsakaiJimu().setSelectedItemsByKey(new ArrayList<RString>());
        }
        set審査会資料活性制御();
    }

    /**
     * 審査会委員用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     */
    public void onClickChk組み合わせ帳票_委員() {
        if (div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys().contains(印刷帳票_組み合わせ)) {
            div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(new ArrayList<RString>());
        }
        set審査会資料活性制御();
    }

    /**
     * 審査会委員用印刷帳票チェックボックス2を変更する場合、表示項目を変更する。
     */
    public void onClickChk審査会資料以外帳票_委員() {
        setCcdBunshoNoInputControl();
    }

    /**
     * バッチパラメータを設定します。
     *
     * @return ShiryoShinsakaiBatchParameter
     */
    public DBE517000_ShinsakaiShiryoParameter onClick_btnKogakuParamSave() {

        RString 事務局審査会資料組み合わせフラグ = new RString("0");
        RString 事務局審査会対象者一覧フラグ = new RString("0");
        RString 事務局特記事項フラグ = new RString("0");
        RString 事務局一次判定結果票フラグ = new RString("0");
        RString 事務局特記事項_一次判定フラグ = new RString("0");
        RString 事務局主治医意見書フラグ = new RString("0");
        RString 事務局その他資料フラグ = new RString("0");
        RString 事務局概況特記フラグ = new RString("0");
        RString 事務局予備判定記入表フラグ = new RString("0");
        RString 事務局概況特記一覧フラグ = new RString("0");
        RString 委員用審査会資料組み合わせフラグ = new RString("0");
        RString 委員用審査会対象者一覧フラグ = new RString("0");
        RString 委員用特記事項フラグ = new RString("0");
        RString 委員用一次判定結果票フラグ = new RString("0");
        RString 委員用特記事項_一次判定フラグ = new RString("0");
        RString 委員用主治医意見書フラグ = new RString("0");
        RString 委員用その他資料フラグ = new RString("0");
        RString 委員用審査会開催通知書フラグ = new RString("0");
        RString 委員用予備判定記入表フラグ = new RString("0");
        RString 合議体ダミーフラグ = new RString("0");

        List<RString> 事務用出力条件組み合わせ = div.getChkPrintChoyoJimu().getSelectedKeys();
        List<RString> 事務用出力条件帳票 = div.getChkPrintChoyoJimu2().getSelectedKeys();
        List<RString> 事務用出力条件資料 = div.getChkPrintChohyoShinsakaiJimu().getSelectedKeys();
        List<RString> 委員用出力条件組み合わせ = div.getChkPrintChohyoIin().getSelectedKeys();
        List<RString> 委員用出力条件帳票 = div.getChkPrintChohyoIin2().getSelectedKeys();
        List<RString> 委員用出力条件資料 = div.getChkPrintChohyoShinsakaiIin().getSelectedKeys();
        if (事務用出力条件帳票.contains(印刷帳票_概況特記)) {
            事務局概況特記フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(印刷帳票_予備判定記入票)) {
            事務局予備判定記入表フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(印刷帳票_概況特記一覧)) {
            事務局概況特記一覧フラグ = new RString("1");
        }
        if (事務用出力条件組み合わせ.contains(印刷帳票_組み合わせ)) {
            事務局審査会資料組み合わせフラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_審査会対象者一覧)) {
            事務局審査会対象者一覧フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_特記事項)) {
            事務局特記事項フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_一次判定結果票)) {
            事務局一次判定結果票フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_特記事項_一次判定)) {
            事務局特記事項_一次判定フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_主治医意見書)) {
            事務局主治医意見書フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_その他資料)) {
            事務局その他資料フラグ = new RString("1");
        }

        if (委員用出力条件帳票.contains(印刷帳票_概況特記)) {
            委員用審査会開催通知書フラグ = new RString("1");
        }
        if (委員用出力条件帳票.contains(印刷帳票_予備判定記入票)) {
            委員用予備判定記入表フラグ = new RString("1");
        }
        if (委員用出力条件組み合わせ.contains(印刷帳票_組み合わせ)) {
            委員用審査会資料組み合わせフラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_審査会対象者一覧)) {
            委員用審査会対象者一覧フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_特記事項)) {
            委員用特記事項フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_一次判定結果票)) {
            委員用一次判定結果票フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_特記事項_一次判定)) {
            委員用特記事項_一次判定フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_主治医意見書)) {
            委員用主治医意見書フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_その他資料)) {
            委員用その他資料フラグ = new RString("1");
        }
        if (!div.getChkGogitaiDummyFlag().getSelectedKeys().isEmpty()) {
            合議体ダミーフラグ = new RString("1");
        }
        return set項目(事務局審査会資料組み合わせフラグ,
                事務局審査会対象者一覧フラグ,
                事務局特記事項フラグ,
                事務局一次判定結果票フラグ,
                事務局特記事項_一次判定フラグ,
                事務局主治医意見書フラグ,
                事務局その他資料フラグ,
                事務局概況特記フラグ,
                事務局予備判定記入表フラグ,
                事務局概況特記一覧フラグ,
                委員用審査会資料組み合わせフラグ,
                委員用審査会対象者一覧フラグ,
                委員用特記事項フラグ,
                委員用一次判定結果票フラグ,
                委員用特記事項_一次判定フラグ,
                委員用主治医意見書フラグ,
                委員用その他資料フラグ,
                委員用審査会開催通知書フラグ,
                委員用予備判定記入表フラグ,
                合議体ダミーフラグ);
    }

    private DBE517000_ShinsakaiShiryoParameter set項目(
            RString 事務局審査会資料組み合わせフラグ,
            RString 事務局審査会対象者一覧フラグ,
            RString 事務局特記事項フラグ,
            RString 事務局一次判定結果票フラグ,
            RString 事務局特記事項_一次判定フラグ,
            RString 事務局主治医意見書フラグ,
            RString 事務局その他資料フラグ,
            RString 事務局概況特記フラグ,
            RString 事務局予備判定記入表フラグ,
            RString 事務局概況特記一覧フラグ,
            RString 委員用審査会資料組み合わせフラグ,
            RString 委員用審査会対象者一覧フラグ,
            RString 委員用特記事項フラグ,
            RString 委員用一次判定結果票フラグ,
            RString 委員用特記事項_一次判定フラグ,
            RString 委員用主治医意見書フラグ,
            RString 委員用その他資料フラグ,
            RString 委員用審査会開催通知書フラグ,
            RString 委員用予備判定記入表フラグ,
            RString 合議体ダミーフラグ) {
        return new DBE517000_ShinsakaiShiryoParameter(
                div.getHdnShinsakaiKaisaiNo().padZeroToLeft(INT_8),
                div.getTxtShinsakaiKaijo().getValue(),
                div.getTxtShinsakaiYoteiDate().getValue(),
                new RString(div.getTxtKaisaiTimeRange().getFromValue().toString()),
                RString.isNullOrEmpty(div.getHdnGogitaiNo()) ? 0 : Integer.parseInt(div.getHdnGogitaiNo().toString()),
                div.getTxtGogitaiName().getValue(),
                div.getTxtShutsuryokuJun().getValue(),
                div.getDdlShutsuryokuStyleZenken().getSelectedKey(),
                div.getRadShutsuryokuStyleZenken().getSelectedKey(),
                div.getRadSakuseiJokenType().getSelectedValue(),
                div.getTxtShiryoNoStart() == null || div.getTxtShiryoNoStart().getValue() == null
                ? 0 : div.getTxtShiryoNoStart().getValue().intValue(),
                div.getTxtSiryoNoEnd() == null || div.getTxtSiryoNoEnd().getValue() == null
                ? 0 : div.getTxtSiryoNoEnd().getValue().intValue(),
                事務局審査会資料組み合わせフラグ,
                事務局審査会対象者一覧フラグ,
                事務局特記事項フラグ,
                事務局一次判定結果票フラグ,
                事務局特記事項_一次判定フラグ,
                事務局主治医意見書フラグ,
                事務局その他資料フラグ,
                事務局概況特記フラグ,
                事務局予備判定記入表フラグ,
                事務局概況特記一覧フラグ,
                委員用審査会資料組み合わせフラグ,
                委員用審査会対象者一覧フラグ,
                委員用特記事項フラグ,
                委員用一次判定結果票フラグ,
                委員用特記事項_一次判定フラグ,
                委員用主治医意見書フラグ,
                委員用その他資料フラグ,
                委員用審査会開催通知書フラグ,
                委員用予備判定記入表フラグ,
                合議体ダミーフラグ,
                div.getCcdBunshoNoInput().get文書番号());
    }

    private void 審査会情報の設定(KaisaiYoteiJohoBusiness 開催予定情報) {
        if (開催予定情報 != null) {
            div.getPublicationTargetShinsakai().getTxtShinsakaiName().setValue(開催予定情報.get審査会開催名称());
            div.getPublicationTargetShinsakai().getTxtGogitaiName().setValue(開催予定情報.get合議体名称());
            div.getPublicationTargetShinsakai().getTxtShinsakaiKaijo().setValue(開催予定情報.get開催場所名称());
            div.getPublicationTargetShinsakai().getTxtShinsakaiChikuCode().setValue(開催予定情報.get開催地区コード());
            div.getPublicationTargetShinsakai().getTxtShinsakaiChikuName().
                    setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(), new Code(開催予定情報.get開催地区コード())));
            div.getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate().setValue(to日期転換(開催予定情報.get予定年月日()));
            if (!RString.isNullOrEmpty(開催予定情報.get開始予定時刻())) {
                div.getPublicationTargetShinsakai().getTxtKaisaiTimeRange().setFromValue(new RTime(開催予定情報.get開始予定時刻()));
            }
            if (!RString.isNullOrEmpty(開催予定情報.get終了予定時刻())) {
                div.getPublicationTargetShinsakai().getTxtKaisaiTimeRange().setToValue(new RTime(開催予定情報.get終了予定時刻()));
            }
            div.getPublicationTargetShinsakai().getTxtShiryoSakusei().setValue(IsShiryoSakuseiZumi.toValue(開催予定情報.is資料作成済フラグ()).get名称());
            div.getPublicationTargetShinsakai().getTxtYoteiTeiin().setValue(new Decimal(開催予定情報.get予定定員()));
            div.getPublicationTargetShinsakai().getTxtWariateNinzu().setValue(new Decimal(開催予定情報.get割当済み人数()));
            div.getLatestPublication().getTxtOperationDate().setValue(to日期転換(開催予定情報.get資料作成年月日()));
            if (開催予定情報.is精神科医所属フラグ()) {
                List<RString> selectKeyList = new ArrayList<>();
                selectKeyList.add(精神科医所属);
                div.getPublicationTargetShinsakai().getChkShinsakaiShurui().setSelectedItemsByKey(selectKeyList);
            }
            if (開催予定情報.is合議体ダミーフラグ()) {
                List<RString> dummy = new ArrayList<>();
                dummy.add(ダミー);
                div.getPublicationTargetShinsakai().getChkGogitaiDummyFlag().setSelectedItemsByKey(dummy);
            }
            div.setHdnShinsakaiKaisaiNo(開催予定情報.get開催番号());
            div.setHdnGogitaiNo(new RString(開催予定情報.get合議体番号()));
        }
    }

    private void 出力条件の設定() {
        List<RString> 印刷帳票_審査会資料組み合わせ = new ArrayList<>();
        List<RString> 印刷帳票_審査会資料以外 = new ArrayList<>();
        List<RString> 印刷帳票_審査会資料 = new ArrayList<>();

        RDate 日期 = RDate.getNowDate();
        RString 出力順 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力順, 日期, SubGyomuCode.DBE認定支援);
        RString 出力スタイル = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力スタイル, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷タイプ, 日期, SubGyomuCode.DBE認定支援);
        div.getTxtShutsuryokuJun().setValue(出力順);
        div.getDdlShutsuryokuStyleZenken().setSelectedKey(出力スタイル);
        div.getRadShutsuryokuStyleZenken().setSelectedKey(印刷タイプ);
        Map<RString, RString> chk審査会資料DataSource = getChk審査会資料DataSource(出力スタイル);

        div.getChkPrintChohyoShinsakaiJimu().setDataSource(KeyValueDataSourceConverter.getDataSource(chk審査会資料DataSource));
        div.getChkPrintChoyoJimu2().setDataSource(KeyValueDataSourceConverter.getDataSource(getChk概況特記DataSource()));
        事務局用印刷帳票の初期化(日期, 出力スタイル, 印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
        setChk事務局帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);

        印刷帳票_審査会資料組み合わせ.clear();
        印刷帳票_審査会資料以外.clear();
        印刷帳票_審査会資料.clear();
        div.getChkPrintChohyoShinsakaiIin().setDataSource(KeyValueDataSourceConverter.getDataSource(chk審査会資料DataSource));
        委員用印刷帳票の初期化(日期, 出力スタイル, 印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);
        setChk委員帳票(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外, 印刷帳票_審査会資料);

        set審査会資料活性制御();
        文書番号管理の初期化();
    }

    private void setChk事務局帳票(List<RString> 印刷帳票_審査会資料組み合わせ, List<RString> 印刷帳票_審査会資料以外, List<RString> 印刷帳票_審査会資料) {
        div.getChkPrintChoyoJimu().setSelectedItemsByKey(印刷帳票_審査会資料組み合わせ);
        div.getChkPrintChohyoShinsakaiJimu().setSelectedItemsByKey(印刷帳票_審査会資料);
        div.getChkPrintChoyoJimu2().setSelectedItemsByKey(印刷帳票_審査会資料以外);
    }

    private void setChk委員帳票(List<RString> 印刷帳票_審査会資料組み合わせ, List<RString> 印刷帳票_審査会資料以外, List<RString> 印刷帳票_審査会資料) {
        div.getChkPrintChohyoIin().setSelectedItemsByKey(印刷帳票_審査会資料組み合わせ);
        div.getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(印刷帳票_審査会資料);
        div.getChkPrintChohyoIin2().setSelectedItemsByKey(印刷帳票_審査会資料以外);
    }

    private void 文書番号管理の初期化() {
        ShichosonSecurityJohoFinder 市町村セキュリティFinder = ShichosonSecurityJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = 市町村セキュリティFinder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            if (DonyuKeitaiCode.認定広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getCode())) {
                div.getCcdBunshoNoInput().initialize(new ReportId(ReportIdDBE.DBE515001.getReportId().value().concat("_")
                        .concat(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))));
            } else {
                div.getCcdBunshoNoInput().initialize(ReportIdDBE.DBE515001.getReportId());
            }
        } else {
            div.getCcdBunshoNoInput().initialize(ReportIdDBE.DBE515001.getReportId());
        }
        setCcdBunshoNoInputControl();
    }

    private void 事務局用印刷帳票の初期化(RDate 日期, RString 出力スタイル, List<RString> 印刷帳票_審査会資料組み合わせ,
            List<RString> 印刷帳票_審査会資料以外, List<RString> 印刷帳票_審査会資料) {
        RString 印刷帳票_事務局 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局, 日期, SubGyomuCode.DBE認定支援);

        if (個別設定.equals(印刷帳票_事務局)) {
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            RString 概況特記一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_概況特記一覧, 日期, SubGyomuCode.DBE認定支援);
            RString 概況特記 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_概況特記, 日期, SubGyomuCode.DBE認定支援);
            RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_審査会資料, 日期, SubGyomuCode.DBE認定支援);
            RString 審査会対象者一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_審査会対象者一覧, 日期, SubGyomuCode.DBE認定支援);
            RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_特記事項, 日期, SubGyomuCode.DBE認定支援);
            RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
            RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
            RString その他資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_その他資料, 日期, SubGyomuCode.DBE認定支援);
            if (is項目を選択(予備判定記入票)) {
                印刷帳票_審査会資料以外.add(印刷帳票_予備判定記入票);
            }
            if (ShutsuryokuStyle.A4縦.getコード().equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())
                    && 概況特記一覧出力する.equals(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料概況特記一覧, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                if (is項目を選択(概況特記一覧)) {
                    印刷帳票_審査会資料以外.add(印刷帳票_概況特記一覧);
                }
            }
            if (概況特記出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                if (is項目を選択(概況特記)) {
                    印刷帳票_審査会資料以外.add(印刷帳票_概況特記);
                }
            }
            審査会資料設定(出力スタイル, 印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料, 審査会資料, 審査会対象者一覧, 特記事項, 一次判定結果票, 主治医意見書, その他資料);
        } else {
            set事務局印刷帳票By作成条件_全件(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
        }
    }

    private void 委員用印刷帳票の初期化(RDate 日期, RString 出力スタイル, List<RString> 印刷帳票_審査会資料組み合わせ,
            List<RString> 印刷帳票_審査会資料以外, List<RString> 印刷帳票_審査会資料) {
        RString 印刷帳票_委員 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員, 日期, SubGyomuCode.DBE認定支援);

        if (個別設定.equals(印刷帳票_委員)) {
            RString 審査会開催通知書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_開催通知書, 日期, SubGyomuCode.DBE認定支援);
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会資料, 日期, SubGyomuCode.DBE認定支援);
            RString 審査会対象者一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会対象者一覧, 日期, SubGyomuCode.DBE認定支援);
            RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項, 日期, SubGyomuCode.DBE認定支援);
            RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
            RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
            RString その他資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_その他資料, 日期, SubGyomuCode.DBE認定支援);
            if (is項目を選択(審査会開催通知書)) {
                印刷帳票_審査会資料以外.add(印刷帳票_審査会開催のお知らせ);
            }
            if (is項目を選択(予備判定記入票)) {
                印刷帳票_審査会資料以外.add(印刷帳票_予備判定記入票);
            }
            審査会資料設定(出力スタイル, 印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料, 審査会資料, 審査会対象者一覧, 特記事項, 一次判定結果票, 主治医意見書, その他資料);
        } else {
            set委員印刷帳票By作成条件_全件(印刷帳票_審査会資料組み合わせ, 印刷帳票_審査会資料以外);
        }
    }

    private Map<RString, RString> getChk概況特記DataSource() {
        Map<RString, RString> map = new LinkedHashMap<>();
        map.put(印刷帳票_予備判定記入票, new RString("予備判定記入表"));
        if (概況特記一覧出力する.equals(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料概況特記一覧, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            map.put(印刷帳票_概況特記一覧, new RString("概況特記一覧"));
        }
        if (概況特記出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            map.put(印刷帳票_概況特記, new RString("概況特記"));
        }
        return map;
    }

    private Map<RString, RString> getChk審査会資料DataSource(RString 出力スタイル) {
        Map<RString, RString> map = new LinkedHashMap<>();
        map.put(印刷帳票_審査会対象者一覧, new RString("審査会対象者一覧"));
        map.put(印刷帳票_主治医意見書, new RString("主治医意見書"));
        map.put(印刷帳票_その他資料, new RString("その他資料"));
        if (ShutsuryokuStyle.A4縦.getコード().equals(出力スタイル)) {
            map.put(印刷帳票_特記事項, new RString("特記事項"));
            map.put(印刷帳票_一次判定結果票, new RString("一次判定結果票"));
        } else {
            map.put(印刷帳票_特記事項_一次判定, new RString("特記事項＋一次判定結果票"));
        }
        return map;
    }

    private void set事務局印刷帳票By作成条件_全件(List<RString> 印刷帳票_審査会資料組み合わせ, List<RString> 印刷帳票_審査会資料以外) {
        印刷帳票_審査会資料以外.add(印刷帳票_予備判定記入票);
        if (ShutsuryokuStyle.A4縦.getコード().equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())
                && 概況特記一覧出力する.equals(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料概況特記一覧, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            印刷帳票_審査会資料以外.add(印刷帳票_概況特記一覧);
        }
        if (概況特記出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            印刷帳票_審査会資料以外.add(印刷帳票_概況特記);
        }
        印刷帳票_審査会資料組み合わせ.add(印刷帳票_組み合わせ);
    }

    private void set委員印刷帳票By作成条件_全件(List<RString> 印刷帳票_審査会資料組み合わせ, List<RString> 印刷帳票_審査会資料以外) {
        印刷帳票_審査会資料以外.add(印刷帳票_審査会開催のお知らせ);
        印刷帳票_審査会資料以外.add(印刷帳票_予備判定記入票);
        印刷帳票_審査会資料組み合わせ.add(印刷帳票_組み合わせ);
    }

    private void set審査会資料活性制御() {
        if (div.getPublishingConditionForJimukyoku().getChkPrintChoyoJimu().getSelectedKeys().isEmpty()) {
            div.getPublishingConditionForJimukyoku().getChkPrintChohyoShinsakaiJimu().setDisabled(false);
        } else {
            div.getPublishingConditionForJimukyoku().getChkPrintChohyoShinsakaiJimu().setDisabled(true);
        }
        if (div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys().isEmpty()) {
            div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabled(false);
        } else {
            div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabled(true);
        }
    }

    private void set各コントロール活性制御By作成条件() {
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        List<RString> disabledKeyList = new ArrayList<>();
        if (作成条件_全件.equals(作成条件)) {
            div.getChkPrintChoyoJimu2().setDisabledItemsByKey(disabledKeyList);
            div.getChkPrintChohyoIin2().setDisabledItemsByKey(disabledKeyList);
            div.getTxtShiryoNoStart().clearValue();
            div.getTxtSiryoNoEnd().clearValue();
            div.getTxtShiryoNoStart().setDisabled(true);
            div.getTxtSiryoNoEnd().setDisabled(true);
        } else if (作成条件_範囲指定.equals(作成条件)) {
            disabledKeyList.add(印刷帳票_予備判定記入票);
            div.getChkPrintChoyoJimu2().setDisabledItemsByKey(disabledKeyList);
            disabledKeyList.add(印刷帳票_審査会開催のお知らせ);
            div.getChkPrintChohyoIin2().setDisabledItemsByKey(disabledKeyList);
            div.getTxtShiryoNoStart().setDisabled(false);
            div.getTxtSiryoNoEnd().setDisabled(false);
        } else {
            disabledKeyList.add(印刷帳票_予備判定記入票);
            div.getChkPrintChoyoJimu2().setDisabledItemsByKey(disabledKeyList);
            disabledKeyList.add(印刷帳票_審査会開催のお知らせ);
            div.getChkPrintChohyoIin2().setDisabledItemsByKey(disabledKeyList);
            div.getTxtShiryoNoStart().clearValue();
            div.getTxtSiryoNoEnd().clearValue();
            div.getTxtShiryoNoStart().setDisabled(true);
            div.getTxtSiryoNoEnd().setDisabled(true);
        }
    }

    private void set事務局印刷帳票By作成条件_範囲追加(List<RString> 印刷帳票_審査会資料組み合わせ, List<RString> 印刷帳票_審査会資料以外) {
        if (ShutsuryokuStyle.A4縦.getコード().equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())
                && 概況特記一覧出力する.equals(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料概況特記一覧, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            印刷帳票_審査会資料以外.add(印刷帳票_概況特記一覧);
        }
        if (概況特記出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            印刷帳票_審査会資料以外.add(印刷帳票_概況特記);
        }
        印刷帳票_審査会資料組み合わせ.add(印刷帳票_組み合わせ);
    }

    private void set委員印刷帳票By作成条件_範囲追加(List<RString> 印刷帳票_審査会資料組み合わせ, List<RString> 印刷帳票_審査会資料以外) {
        印刷帳票_審査会資料組み合わせ.add(印刷帳票_組み合わせ);
    }

    private void clearChk印刷帳票() {
        List<RString> clearList = new ArrayList<>();
        div.getPublishingConditionForJimukyoku().getChkPrintChohyoShinsakaiJimu().setSelectedItemsByKey(clearList);
        div.getPublishingConditionForJimukyoku().getChkPrintChoyoJimu().setSelectedItemsByKey(clearList);
        div.getPublishingConditionForJimukyoku().getChkPrintChoyoJimu2().setSelectedItemsByKey(clearList);
        div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(clearList);
        div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().setSelectedItemsByKey(clearList);
        div.getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin2().setSelectedItemsByKey(clearList);
    }

    private void 審査会資料設定(RString 出力スタイル,
            List<RString> 印刷帳票_審査会資料組み合わせ,
            List<RString> 印刷帳票_審査会資料,
            RString 審査会資料,
            RString 審査会対象者一覧,
            RString 特記事項,
            RString 一次判定結果票,
            RString 主治医意見書,
            RString その他資料) {
        if (個別設定.equals(審査会資料)) {
            if (is項目を選択(審査会対象者一覧)) {
                印刷帳票_審査会資料.add(印刷帳票_審査会対象者一覧);
            }
            if (ShutsuryokuStyle.A4縦.getコード().equals(出力スタイル)) {
                if (is項目を選択(特記事項)) {
                    印刷帳票_審査会資料.add(印刷帳票_特記事項);
                }
                if (is項目を選択(一次判定結果票)) {
                    印刷帳票_審査会資料.add(印刷帳票_一次判定結果票);
                }
            }
            if (is項目を選択(主治医意見書)) {
                印刷帳票_審査会資料.add(印刷帳票_主治医意見書);
            }
            if (is項目を選択(その他資料)) {
                印刷帳票_審査会資料.add(印刷帳票_その他資料);
            }
        } else {
            印刷帳票_審査会資料組み合わせ.add(印刷帳票_組み合わせ);
        }
    }

    private boolean is項目を選択(RString 項目) {
        return 選択.equals(項目);
    }

    private RString to転換(RString 項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 項目;
        }
        return RString.EMPTY;
    }

    private FlexibleDate to日期転換(FlexibleDate 項目) {
        if (項目 != null && !項目.isEmpty()) {
            return 項目;
        }
        return FlexibleDate.EMPTY;
    }

    private void setCcdBunshoNoInputControl() {
        if (div.getChkPrintChohyoIin2().getSelectedKeys().contains(印刷帳票_審査会開催のお知らせ)) {
            div.getCcdBunshoNoInput().setDisabled(false);
        } else {
            div.getCcdBunshoNoInput().setDisabled(true);
        }
    }

}
