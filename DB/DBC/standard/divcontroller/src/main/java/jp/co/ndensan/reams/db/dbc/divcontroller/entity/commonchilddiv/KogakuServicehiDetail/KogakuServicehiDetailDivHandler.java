/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyou;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class KogakuServicehiDetailDivHandler {

    private final KogakuServicehiDetailDiv div;
    private static final RString 追加モード = new RString("追加モード");
    private static final RString 送付済モード = new RString("送付済モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 新規 = new RString("新規");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 照会 = new RString("照会");
    private static final RString 高額サービス費支給申請書登録 = new RString("DBCMN42001");
    private static final RString 高額介護サービス費照会 = new RString("DBCMN11004");
    private static final RString 総合事業高額サービス費支給申請書登録 = new RString("DBCMN42002");
    private static final RString 総合事業高額介護サービス費照会 = new RString("DBCMN11016");
    private static final RString 高額自動償還の対象者です = new RString("高額自動償還の対象者です。");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString 不支給 = new RString("不支給");
    private static final RString 支給 = new RString("支給");

    /**
     * コンストラクタです。
     *
     * @param div KogakuKyufuTaishoListDiv
     */
    public KogakuServicehiDetailDivHandler(KogakuServicehiDetailDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KogakuKyufuTaishoListDiv
     */
    public static KogakuServicehiDetailDivHandler of(KogakuServicehiDetailDiv div) {
        return new KogakuServicehiDetailDivHandler(div);
    }

    /**
     * 画面初期化です。
     *
     * @param 画面モード RString
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @param 識別コード ShikibetsuCode
     */
    public void 画面初期化(RString 画面モード, RString メニューID, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号, int 履歴番号, ShikibetsuCode 識別コード) {
        set状態(画面モード);
        KougakuSabisuhiShousaiNaiyouResult result = new KougakuSabisuhiShousaiNaiyouResult();
        if (追加モード.equals(画面モード)) {
            if (サービス年月 != null && !サービス年月.isEmpty()) {
                div.getTxtTeikyoYM().setValue(new RDate(サービス年月.toString()));
            }
            div.getTplShinseisha().getTxtShinseiYMD().setValue(new RDate(RDate.getNowDate().toString()));
            div.getTplShinseisha().getRdbShinseisyaKubun().setSelectedKey(KEY0);
            div.getRdbShikyuKubun().setSelectedKey(KEY0);
            div.getRdbShinsaHohoKubun().setSelectedKey(KEY0);
            if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
                div.getTplShinseisha().getTxtHokenJyaBango().setValue(証記載保険者番号.value());
            }
//            set高額口座情報エリア(追加モード, 識別コード, null);
        } else if (修正モード.equals(画面モード) || 送付済モード.equals(画面モード)
                || 削除モード.equals(画面モード) || 照会モード.equals(画面モード)) {
            result = KougakuSabisuhiShousaiNaiyou.createInstance().
                    getKougakuSabisuhiShousaiNaiyou(画面モード, メニューID,
                            被保険者番号, サービス年月, 証記載保険者番号, 履歴番号);
            if (高額サービス費支給申請書登録.equals(メニューID) || 高額介護サービス費照会.equals(メニューID)) {
                set高額申請情報エリア(result);
                set高額判定結果情報エリア(result);
//                set高額口座情報エリア(画面モード, 識別コード, result);
            } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)
                    || 総合事業高額介護サービス費照会.equals(メニューID)) {
                set事業高額申請情報エリア(result);
                set事業高額判定結果情報エリア(result);
                set事業高額口座情報エリア(画面モード, 識別コード, result);
            }
            div.getTxtKanriBango().setValue(new Decimal(履歴番号));
        }
        if (照会モード.equals(画面モード)) {
            if (高額サービス費支給申請書登録.equals(メニューID) || 高額介護サービス費照会.equals(メニューID)) {
//                set高額決定情報エリア(result);
            } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)
                    || 総合事業高額介護サービス費照会.equals(メニューID)) {
                set事業高額決定情報エリア(result);
            }
        }
        if (result != null) {
            div.setKogakuServicehiDetailEntity(DataPassingConverter.serialize(result));
        }
        div.getCcdKogakuKyufuTaishoList().initialize(メニューID, 照会モード, 被保険者番号, サービス年月, 履歴番号);
        set画面制御(画面モード);
        if (0 == KougakuSabisuhiShousaiNaiyou.createInstance().getTenshutsuNyuuHantei(被保険者番号, サービス年月)) {
            div.getTplShinseisha().getTxtHokenJyaBango().setDisabled(true);
        }
    }

    /**
     * 画面初期化データを取得します。
     *
     * @return RDate
     */
    public KougakuSabisuhiShousaiNaiyouResult get画面初期化データ() {
        KougakuSabisuhiShousaiNaiyouResult entity = DataPassingConverter.deserialize(
                div.getKogakuServicehiDetailEntity(), KougakuSabisuhiShousaiNaiyouResult.class);
        return entity;

    }

    /**
     * 申請日を取得します。
     *
     * @return RDate
     */
    public RDate get申請日() {
        return div.getTxtShinseiYMD().getValue();
    }

    /**
     * 申請者区分を取得します。
     *
     * @return RString
     */
    public RString get申請者区分() {
        return div.getRdbShinseisyaKubun().getSelectedKey();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return HokenshaNo
     */
    public RString get証記載保険者番号() {
        return div.getTxtHokenJyaBango().getValue();
    }

    /**
     * 国保連再送を取得します。
     *
     * @return boolean
     */
    public boolean is国保連再送() {
        return div.getChkKokuhorenSaiso().isAllSelected();
    }

    /**
     * 氏名_漢字を取得します。
     *
     * @return RString
     */
    public RString get氏名_漢字() {
        return div.getTxtShimeiKanji().getValue();
    }

    /**
     * 氏名_カナを取得します。
     *
     * @return RString
     */
    public RString get氏名_カナ() {
        return div.getTxtShimeiKana().getValue();
    }

    /**
     * 電話番号を取得します。
     *
     * @return RString
     */
    public RString get電話番号() {
        return div.getTxtTelNo().getDomain().value();
    }

    /**
     * 申請理由を取得します。
     *
     * @return RString
     */
    public RString get申請理由() {
        return div.getTxtShinseiRiyu().getValue();
    }

    /**
     * 支払金額合計を取得します。
     *
     * @return RString
     */
    public Decimal get支払金額合計() {
        return div.getTxtShiharaiTotalAmount().getValue();
    }

    /**
     * 受付日を取得します。
     *
     * @return RDate
     */
    public RDate get受付日() {
        return div.getTxtUketsukeYMD().getValue();
    }

    /**
     * 本人支払額を取得します。
     *
     * @return Decimal
     */
    public Decimal get本人支払額() {
        return div.getTxtHonninShiharaiGaku().getValue();
    }

    /**
     * 決定日を取得します。
     *
     * @return RDate
     */
    public RDate get決定日() {
        return div.getTxtKetteiYMD().getValue();
    }

    /**
     * 支給区分を取得します。
     *
     * @return RString
     */
    public RString get支給区分() {
        return div.getRdbShikyuKubun().getSelectedKey();
    }

    /**
     * 審査方法区分を取得します。
     *
     * @return RString
     */
    public RString get審査方法区分() {
        return div.getRdbShinsaHohoKubun().getSelectedKey();
    }

    /**
     * 世帯集約番号を取得します。
     *
     * @return RString
     */
    public RString get世帯集約番号() {
        return div.getTxtSetaiSyuyakuBango().getValue();
    }

    /**
     * 支給金額を取得します。
     *
     * @return Decimal
     */
    public Decimal get支給金額() {
        return div.getTxtShikyuKingaku().getValue();
    }

    /**
     * 高額自動償還を取得します。
     *
     * @return RString
     */
    public RString get高額自動償還() {
        return div.getRdbKogakuJidoSyokanTaisyo().getSelectedKey();
    }

    /**
     * 支給しない理由を取得します。
     *
     * @return RString
     */
    public RString get支給しない理由() {
        return div.getTxtShikyusinaiRiyu().getValue();
    }

    private void set画面制御(RString 画面モード) {
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (追加モード.equals(画面モード)) {
            div.getTplShinseisha().getTxtKotei().setVisible(false);
            div.getTxtShikyusinaiRiyu().setDisabled(true);
            div.getRdbKogakuJidoSyokanTaisyo().setSelectedKey(KEY1);
            if (ONE.equals(受託区分)) {
                div.getRdbShinsaHohoKubun().setDisabled(true);
            }
            set高額決定情報エリア非表示();
        } else if (修正モード.equals(画面モード)) {
            if (ONE.equals(受託区分)) {
                div.getRdbShinsaHohoKubun().setDisabled(true);
            }
            set高額決定情報エリア非表示();
        } else if (送付済モード.equals(画面モード)) {
            set申請情報タブエリア非活性();
            set判定結果情報エリア非活性();
            set高額決定情報エリア非表示();
        } else if (削除モード.equals(画面モード)) {
            set申請情報タブエリア非活性();
            div.getChkKokuhorenSaiso().setDisabled(true);
            set判定結果情報エリア非活性();
            set高額決定情報エリア非表示();
        } else if (照会モード.equals(画面モード)) {
            set申請情報タブエリア非活性();
            div.getChkKokuhorenSaiso().setDisabled(true);
            set判定結果情報エリア非活性();
        }
    }

    private void set高額申請情報エリア(KougakuSabisuhiShousaiNaiyouResult result) {
        if (result != null && result.get高額介護サービス費支給申請Entity() != null) {
            div.getTxtTeikyoYM().setValue(new RDate(result.
                    get高額介護サービス費支給申請Entity().getサービス提供年月().toString()));
            if (result.get高額介護サービス費支給申請Entity().get申請年月日() != null
                    && !result.get高額介護サービス費支給申請Entity().get申請年月日().isEmpty()) {
                div.getTplShinseisha().getTxtShinseiYMD().setValue(new RDate(
                        result.get高額介護サービス費支給申請Entity().get申請年月日().toString()));
            }
            if (ONE.equals(result.get高額介護サービス費支給申請Entity().get申請者区分())) {
                div.getTplShinseisha().getRdbShinseisyaKubun().setSelectedKey(KEY0);
            } else if (TWO.equals(result.get高額介護サービス費支給申請Entity().get申請者区分())) {
                div.getTplShinseisha().getRdbShinseisyaKubun().setSelectedKey(KEY1);
            }
            div.getTplShinseisha().getTxtHokenJyaBango().setValue(
                    result.get高額介護サービス費支給申請Entity().get証記載保険者番号().value());
            if (result.get高額介護サービス費支給申請Entity().get申請者氏名() != null
                    && !result.get高額介護サービス費支給申請Entity().get申請者氏名().isEmpty()) {
                div.getTplShinseisha().getTxtShimeiKanji().setValue(
                        result.get高額介護サービス費支給申請Entity().get申請者氏名().value());
            }
            if (result.get高額介護サービス費支給申請Entity().get申請者氏名カナ() != null
                    && !result.get高額介護サービス費支給申請Entity().get申請者氏名カナ().isEmpty()) {
                div.getTplShinseisha().getTxtShimeiKana().setValue(
                        result.get高額介護サービス費支給申請Entity().get申請者氏名カナ().value());
            }
            div.getTplShinseisha().getTxtTelNo().setDomain(
                    result.get高額介護サービス費支給申請Entity().get申請者電話番号());
            div.getTplShinseisha().getTxtShinseiRiyu().setValue(
                    result.get高額介護サービス費支給申請Entity().get申請理由());

        }
        if (result != null && result.get高額介護サービス費支給判定結果Entity() != null
                && result.get高額介護サービス費支給判定結果Entity().is再送付フラグ()) {
            List<RString> list = new ArrayList();
            list.add(KEY0);
            div.getTplShinseisha().getChkKokuhorenSaiso().setSelectedItemsByKey(list);
        }
        if (result != null && result.get高額介護サービス費支給対象者合計Entity() != null) {
            div.getTplShinseisha().getTxtShiharaiTotalAmount().
                    setValue(result.get高額介護サービス費支給対象者合計Entity().get利用者負担額合計());
            if (result.get高額介護サービス費支給対象者合計Entity().is自動償還対象フラグ()) {
                div.getTplShinseisha().getTxtKotei().setValue(高額自動償還の対象者です);
            }
        }
    }

    private void set事業高額申請情報エリア(KougakuSabisuhiShousaiNaiyouResult result) {
        if (result != null && result.get事業高額介護サービス費支給申請Entity() != null) {
            div.getTxtTeikyoYM().setValue(new RDate(result.
                    get事業高額介護サービス費支給申請Entity().getサービス提供年月().toString()));
            if (result.get事業高額介護サービス費支給申請Entity().get申請年月日() != null
                    && !result.get事業高額介護サービス費支給申請Entity().get申請年月日().isEmpty()) {
                div.getTplShinseisha().getTxtShinseiYMD().setValue(new RDate(
                        result.get事業高額介護サービス費支給申請Entity().get申請年月日().toString()));
            }
            if (ONE.equals(result.get事業高額介護サービス費支給申請Entity().get申請者区分())) {
                div.getTplShinseisha().getRdbShinseisyaKubun().setSelectedKey(KEY0);
            } else if (TWO.equals(result.get事業高額介護サービス費支給申請Entity().get申請者区分())) {
                div.getTplShinseisha().getRdbShinseisyaKubun().setSelectedKey(KEY1);
            }
            div.getTplShinseisha().getTxtHokenJyaBango().setValue(
                    result.get事業高額介護サービス費支給申請Entity().get証記載保険者番号().value());
            if (result.get事業高額介護サービス費支給申請Entity().get申請者氏名() != null
                    && !result.get事業高額介護サービス費支給申請Entity().get申請者氏名().isEmpty()) {
                div.getTplShinseisha().getTxtShimeiKanji().setValue(
                        result.get事業高額介護サービス費支給申請Entity().get申請者氏名().value());
            }
            if (result.get事業高額介護サービス費支給申請Entity().get申請者氏名カナ() != null
                    && !result.get事業高額介護サービス費支給申請Entity().get申請者氏名カナ().isEmpty()) {
                div.getTplShinseisha().getTxtShimeiKana().setValue(
                        result.get事業高額介護サービス費支給申請Entity().get申請者氏名カナ().value());
            }
            div.getTplShinseisha().getTxtTelNo().setDomain(
                    result.get事業高額介護サービス費支給申請Entity().get申請者電話番号());
            div.getTplShinseisha().getTxtShinseiRiyu().setValue(
                    result.get事業高額介護サービス費支給申請Entity().get申請理由());

        }
        if (result != null && result.get事業高額介護サービス費支給判定結果Entity() != null
                && result.get事業高額介護サービス費支給判定結果Entity().is再送付フラグ()) {
            List<RString> list = new ArrayList();
            list.add(KEY0);
            div.getTplShinseisha().getChkKokuhorenSaiso().setSelectedItemsByKey(list);
        }
        if (result != null && result.get事業高額介護サービス費支給対象者合計Entity() != null) {
            div.getTplShinseisha().getTxtShiharaiTotalAmount().
                    setValue(result.get事業高額介護サービス費支給対象者合計Entity().get利用者負担額合計());
            if (result.get事業高額介護サービス費支給対象者合計Entity().is自動償還対象フラグ()) {
                div.getTplShinseisha().getTxtKotei().setValue(高額自動償還の対象者です);
            }
        }
    }

    private void set高額判定結果情報エリア(KougakuSabisuhiShousaiNaiyouResult result) {
        if (result != null && result.get高額介護サービス費支給申請Entity() != null
                && result.get高額介護サービス費支給申請Entity().get受付年月日() != null
                && !result.get高額介護サービス費支給申請Entity().get受付年月日().isEmpty()) {
            div.getTxtUketsukeYMD().setValue(new RDate(
                    result.get高額介護サービス費支給申請Entity().get受付年月日().toString()));
        }
        if (result != null && result.get高額介護サービス費支給判定結果Entity() != null) {
            if (result.get高額介護サービス費支給判定結果Entity().get決定年月日() != null
                    && !result.get高額介護サービス費支給判定結果Entity().get決定年月日().isEmpty()) {
                div.getTxtKetteiYMD().setValue(new RDate(
                        result.get高額介護サービス費支給判定結果Entity().get決定年月日().toString()));
            }
            if (ONE.equals(result.get高額介護サービス費支給判定結果Entity().get支給区分コード())) {
                div.getRdbShikyuKubun().setSelectedKey(KEY0);
                div.getTxtShikyusinaiRiyu().setDisabled(true);
            } else if (ZERO.equals(result.get高額介護サービス費支給判定結果Entity().get支給区分コード())) {
                div.getRdbShikyuKubun().setSelectedKey(KEY1);
                div.getTxtShikyuKingaku().setDisabled(true);
            }
            div.getTxtHonninShiharaiGaku().setValue(result.get高額介護サービス費支給判定結果Entity().get本人支払額());
            div.getTxtShikyuKingaku().setValue(result.get高額介護サービス費支給判定結果Entity().get支給金額());
            div.getTxtShikyusinaiRiyu().setValue(result.get高額介護サービス費支給判定結果Entity().get不支給理由());
            if (ONE.equals(result.get高額介護サービス費支給判定結果Entity().get審査方法区分())) {
                div.getRdbShinsaHohoKubun().setSelectedKey(KEY0);
            } else if (TWO.equals(result.get高額介護サービス費支給判定結果Entity().get審査方法区分())) {
                div.getRdbShinsaHohoKubun().setSelectedKey(KEY1);
            }
        }
        if (result != null && result.get高額介護サービス費支給対象者合計Entity() != null) {
            div.getTxtSetaiSyuyakuBango().setValue(result.get高額介護サービス費支給対象者合計Entity().get世帯集約番号());
            if (result.get高額介護サービス費支給対象者合計Entity().is自動償還対象フラグ()) {
                div.getRdbKogakuJidoSyokanTaisyo().setSelectedKey(KEY0);
            } else {
                div.getRdbKogakuJidoSyokanTaisyo().setSelectedKey(KEY1);
            }
        }
    }

    private void set事業高額判定結果情報エリア(KougakuSabisuhiShousaiNaiyouResult result) {
        if (result != null && result.get事業高額介護サービス費支給申請Entity() != null
                && result.get事業高額介護サービス費支給申請Entity().get受付年月日() != null
                && !result.get事業高額介護サービス費支給申請Entity().get受付年月日().isEmpty()) {
            div.getTxtUketsukeYMD().setValue(new RDate(
                    result.get事業高額介護サービス費支給申請Entity().get受付年月日().toString()));
        }
        if (result != null && result.get事業高額介護サービス費支給判定結果Entity() != null) {
            if (result.get事業高額介護サービス費支給判定結果Entity().get決定年月日() != null
                    && !result.get事業高額介護サービス費支給判定結果Entity().get決定年月日().isEmpty()) {
                div.getTxtKetteiYMD().setValue(new RDate(
                        result.get事業高額介護サービス費支給判定結果Entity().get決定年月日().toString()));
            }
            if (ONE.equals(result.get事業高額介護サービス費支給判定結果Entity().get支給区分コード())) {
                div.getRdbShikyuKubun().setSelectedKey(KEY0);
                div.getTxtShikyusinaiRiyu().setDisabled(true);
            } else if (ZERO.equals(result.get事業高額介護サービス費支給判定結果Entity().get支給区分コード())) {
                div.getRdbShikyuKubun().setSelectedKey(KEY1);
                div.getTxtShikyuKingaku().setDisabled(true);
            }
            div.getTxtHonninShiharaiGaku().setValue(result.get事業高額介護サービス費支給判定結果Entity().get本人支払額());
            div.getTxtShikyuKingaku().setValue(result.get事業高額介護サービス費支給判定結果Entity().get支給金額());
            div.getTxtShikyusinaiRiyu().setValue(result.get事業高額介護サービス費支給判定結果Entity().get不支給理由());
            if (ONE.equals(result.get事業高額介護サービス費支給判定結果Entity().get審査方法区分())) {
                div.getRdbShinsaHohoKubun().setSelectedKey(KEY0);
            } else if (TWO.equals(result.get事業高額介護サービス費支給判定結果Entity().get審査方法区分())) {
                div.getRdbShinsaHohoKubun().setSelectedKey(KEY1);
            }
        }
        if (result != null && result.get事業高額介護サービス費支給対象者合計Entity() != null) {
            div.getTxtSetaiSyuyakuBango().setValue(result.
                    get事業高額介護サービス費支給対象者合計Entity().get世帯集約番号());
            if (result.get事業高額介護サービス費支給対象者合計Entity().is自動償還対象フラグ()) {
                div.getRdbKogakuJidoSyokanTaisyo().setSelectedKey(KEY0);
            } else {
                div.getRdbKogakuJidoSyokanTaisyo().setSelectedKey(KEY1);
            }
        }
    }

//    private void set高額口座情報エリア(RString 画面モード, ShikibetsuCode 識別コード,
//            KougakuSabisuhiShousaiNaiyouResult result) {
//        SikyuSinseiJyohoParameter para = new SikyuSinseiJyohoParameter();
//        para.setShikibetsuCode(識別コード);
//        if (追加モード.equals(画面モード)) {
//            div.getCcdShiharaiHohoJyoho().initialize(para, 登録);
//        } else if (修正モード.equals(画面モード) || 送付済モード.equals(画面モード)) {
//            if (result != null) {
//                div.getCcdShiharaiHohoJyoho().initialize(set高額支払方法情報(para, result), 修正);
//            }
//        } else if (削除モード.equals(画面モード) || 照会モード.equals(画面モード)) {
//            div.getCcdShiharaiHohoJyoho().initialize(set高額支払方法情報(para, result), 照会);
//        }
//    }
    private void set事業高額口座情報エリア(RString 画面モード, ShikibetsuCode 識別コード,
            KougakuSabisuhiShousaiNaiyouResult result) {
        SikyuSinseiJyohoParameter para = new SikyuSinseiJyohoParameter();
        para.setShikibetsuCode(識別コード);
        if (追加モード.equals(画面モード)) {
            div.getCcdShiharaiHohoJyoho().initialize(para, 登録);
        } else if (修正モード.equals(画面モード) || 送付済モード.equals(画面モード)) {
            if (result != null) {
                div.getCcdShiharaiHohoJyoho().initialize(set事業高額支払方法情報(para, result), 修正);
            }
        } else if (削除モード.equals(画面モード) || 照会モード.equals(画面モード)) {
            div.getCcdShiharaiHohoJyoho().initialize(set高額支払方法情報(para, result), 照会);
        }
    }

    private void set高額決定情報エリア(KougakuSabisuhiShousaiNaiyouResult result) {
        if (result != null && result.get高額介護サービス費支給審査決定Entity() != null) {
            div.getKokuhorenKetteiJohoPanel1().getTxtTsuchiBango().setValue(
                    result.get高額介護サービス費支給審査決定Entity().get通知書番号());
            if (ONE.equals(result.get高額介護サービス費支給審査決定Entity().get支給区分コード())) {
                div.getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun().setValue(支給);
            } else if (ZERO.equals(result.get高額介護サービス費支給審査決定Entity().get支給区分コード())) {
                div.getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun().setValue(不支給);
            }
            div.getKokuhorenKetteiJohoPanel1().getTxtKetteiYM().setValue(
                    new RDate(result.get高額介護サービス費支給審査決定Entity().get決定年月().toString()));
            div.getKokuhorenKetteiJohoPanel1().getTxtShiharaiKingakuGokei().setValue(
                    result.get高額介護サービス費支給審査決定Entity().get利用者負担額());
            div.getKokuhorenKetteiJohoPanel1().getTxtKogakuShikyuGaku().setValue(
                    result.get高額介護サービス費支給審査決定Entity().get高額支給額());
            div.getKokuhorenSoufuJohoPanel().getTxtKetteiSyaUketoriYM().setValue(
                    new RDate(result.get高額介護サービス費支給審査決定Entity().get決定者受取年月().toString()));
        }
        if (result != null && result.get高額介護サービス費支給判定結果Entity() != null) {
            if (result.get高額介護サービス費支給判定結果Entity().get決定通知書作成年月日() != null
                    && !result.get高額介護サービス費支給判定結果Entity().get決定通知書作成年月日().isEmpty()) {
                div.getKokuhorenKetteiJohoPanel2().getTxtSakuseiYMD1().setValue(
                        new RDate(result.get高額介護サービス費支給判定結果Entity().
                                get決定通知書作成年月日().toString()));
            }
            if (result.get高額介護サービス費支給判定結果Entity().get振込明細書作成年月日() != null
                    && !result.get高額介護サービス費支給判定結果Entity().get振込明細書作成年月日().isEmpty()) {
                div.getFurikomiMeisaiJohoPanel().getTxtSakuseiYMD2().setValue(
                        new RDate(result.get高額介護サービス費支給判定結果Entity().
                                get振込明細書作成年月日().toString()));
            }
            if (result.get高額介護サービス費支給判定結果Entity().get判定結果送付年月() != null
                    && !result.get高額介護サービス費支給判定結果Entity().get判定結果送付年月().isEmpty()) {
                div.getKokuhorenSoufuJohoPanel().getTxtKekkaSoufuYM().setValue(
                        new RDate(result.get高額介護サービス費支給判定結果Entity().
                                get判定結果送付年月().toString()));
            }
        }
        if (result != null && result.get高額介護サービス費支給対象者合計Entity() != null
                && result.get高額介護サービス費支給対象者合計Entity().get対象者受取年月() != null
                && !result.get高額介護サービス費支給対象者合計Entity().get対象者受取年月().isEmpty()) {
            div.getKokuhorenSoufuJohoPanel().getTxtTaisyoUketoriYM().setValue(
                    new RDate(result.get高額介護サービス費支給対象者合計Entity().
                            get対象者受取年月().toString()));
        }
    }

    private void set事業高額決定情報エリア(KougakuSabisuhiShousaiNaiyouResult result) {
        if (result != null && result.get事業高額介護サービス費支給審査決定Entity() != null) {
            div.getKokuhorenKetteiJohoPanel1().getTxtTsuchiBango().setValue(
                    result.get事業高額介護サービス費支給審査決定Entity().get通知書番号());
            if (ONE.equals(result.get事業高額介護サービス費支給審査決定Entity().get支給区分コード())) {
                div.getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun().setValue(支給);
            } else if (ZERO.equals(result.get事業高額介護サービス費支給審査決定Entity().get支給区分コード())) {
                div.getKokuhorenKetteiJohoPanel1().getTxtShikyuKubun().setValue(不支給);
            }
            div.getKokuhorenKetteiJohoPanel1().getTxtKetteiYM().setValue(
                    new RDate(result.get事業高額介護サービス費支給審査決定Entity().get決定年月().toString()));
            div.getKokuhorenKetteiJohoPanel1().getTxtShiharaiKingakuGokei().setValue(
                    result.get事業高額介護サービス費支給審査決定Entity().get利用者負担額());
            div.getKokuhorenKetteiJohoPanel1().getTxtKogakuShikyuGaku().setValue(
                    result.get事業高額介護サービス費支給審査決定Entity().get事業高額支給額());
            div.getKokuhorenSoufuJohoPanel().getTxtKetteiSyaUketoriYM().setValue(
                    new RDate(result.get事業高額介護サービス費支給審査決定Entity().
                            get決定者受取年月().toString()));
        }
        if (result != null && result.get事業高額介護サービス費支給判定結果Entity() != null) {
            if (result.get事業高額介護サービス費支給判定結果Entity().get決定通知書作成年月日() != null
                    && !result.get事業高額介護サービス費支給判定結果Entity().get決定通知書作成年月日().isEmpty()) {
                div.getKokuhorenKetteiJohoPanel2().getTxtSakuseiYMD1().setValue(
                        new RDate(result.get事業高額介護サービス費支給判定結果Entity().
                                get決定通知書作成年月日().toString()));
            }
            if (result.get事業高額介護サービス費支給判定結果Entity().get振込明細書作成年月日() != null
                    && !result.get事業高額介護サービス費支給判定結果Entity().get振込明細書作成年月日().isEmpty()) {
                div.getFurikomiMeisaiJohoPanel().getTxtSakuseiYMD2().setValue(
                        new RDate(result.get事業高額介護サービス費支給判定結果Entity().
                                get振込明細書作成年月日().toString()));
            }
            if (result.get事業高額介護サービス費支給判定結果Entity().get判定結果送付年月() != null
                    && !result.get事業高額介護サービス費支給判定結果Entity().get判定結果送付年月().isEmpty()) {
                div.getKokuhorenSoufuJohoPanel().getTxtKekkaSoufuYM().setValue(
                        new RDate(result.get事業高額介護サービス費支給判定結果Entity().
                                get判定結果送付年月().toString()));
            }
        }
        if (result != null && result.get事業高額介護サービス費支給対象者合計Entity() != null
                && result.get事業高額介護サービス費支給対象者合計Entity().get対象者受取年月() != null
                && !result.get事業高額介護サービス費支給対象者合計Entity().get対象者受取年月().isEmpty()) {
            div.getKokuhorenSoufuJohoPanel().getTxtTaisyoUketoriYM().setValue(
                    new RDate(result.get事業高額介護サービス費支給対象者合計Entity().
                            get対象者受取年月().toString()));
        }
    }

    private SikyuSinseiJyohoParameter set高額支払方法情報(
            SikyuSinseiJyohoParameter para, KougakuSabisuhiShousaiNaiyouResult result) {
        para.setHihokenshaNo(result.get高額介護サービス費支給申請Entity().get被保険者番号());
        para.setShikyushinseiServiceYM(result.get高額介護サービス費支給申請Entity().getサービス提供年月());
        if (result.get高額介護サービス費支給申請Entity().get支払方法区分コード() != null) {
            para.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(
                    result.get高額介護サービス費支給申請Entity().get支払方法区分コード()));
        }
        para.setKeiyakuNo(result.get高額介護サービス費支給申請Entity().get受領委任契約番号());
        if (result.get高額介護サービス費支給申請Entity().get支払期間開始年月日() != null) {
            para.setStartYMD(new RDate(result.get高額介護サービス費支給申請Entity().get支払期間開始年月日().toString()));
        }
        if (result.get高額介護サービス費支給申請Entity().get支払期間終了年月日() != null) {
            para.setEndYMD(new RDate(result.get高額介護サービス費支給申請Entity().get支払期間終了年月日().toString()));
        }
        if (result.get高額介護サービス費支給申請Entity().get支払窓口開始時間() != null) {
            para.setStartHHMM(new RTime(result.get高額介護サービス費支給申請Entity().get支払窓口開始時間()));
        }
        if (result.get高額介護サービス費支給申請Entity().get支払窓口終了時間() != null) {
            para.setEndHHMM(new RTime(result.get高額介護サービス費支給申請Entity().get支払窓口終了時間()));
        }
        para.setKozaId(result.get高額介護サービス費支給申請Entity().get口座ID());
        para.setShiharaiBasho(result.get高額介護サービス費支給申請Entity().get支払場所());
        return para;
    }

    private SikyuSinseiJyohoParameter set事業高額支払方法情報(
            SikyuSinseiJyohoParameter para, KougakuSabisuhiShousaiNaiyouResult result) {
        para.setHihokenshaNo(result.get事業高額介護サービス費支給申請Entity().get被保険者番号());
        para.setShikyushinseiServiceYM(result.get事業高額介護サービス費支給申請Entity().getサービス提供年月());
        if (result.get事業高額介護サービス費支給申請Entity().get支払方法区分コード() != null) {
            para.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(
                    result.get事業高額介護サービス費支給申請Entity().get支払方法区分コード()));
        }
        para.setKeiyakuNo(result.get事業高額介護サービス費支給申請Entity().get受領委任契約番号());
        if (result.get事業高額介護サービス費支給申請Entity().get支払期間開始年月日() != null) {
            para.setStartYMD(new RDate(result.get事業高額介護サービス費支給申請Entity().
                    get支払期間開始年月日().toString()));
        }
        if (result.get事業高額介護サービス費支給申請Entity().get支払期間終了年月日() != null) {
            para.setEndYMD(new RDate(result.get事業高額介護サービス費支給申請Entity().get支払期間終了年月日().toString()));
        }
        if (result.get事業高額介護サービス費支給申請Entity().get支払窓口開始時間() != null) {
            para.setStartHHMM(new RTime(result.get事業高額介護サービス費支給申請Entity().get支払窓口開始時間()));
        }
        if (result.get事業高額介護サービス費支給申請Entity().get支払窓口終了時間() != null) {
            para.setEndHHMM(new RTime(result.get事業高額介護サービス費支給申請Entity().get支払窓口終了時間()));
        }
        para.setKozaId(result.get事業高額介護サービス費支給申請Entity().get口座ID());
        para.setShiharaiBasho(result.get事業高額介護サービス費支給申請Entity().get支払場所());
        return para;
    }

    private void set高額決定情報エリア非表示() {
        div.getTplKetteiJoho().setVisible(false);
        div.getKokuhorenKetteiJohoPanel1().setVisible(false);
        div.getKokuhorenKetteiJohoPanel2().setVisible(false);
        div.getFurikomiMeisaiJohoPanel().setVisible(false);
        div.getKokuhorenSoufuJohoPanel().setVisible(false);
    }

    private void set判定結果情報エリア非活性() {
        div.getTxtUketsukeYMD().setDisabled(true);
        div.getTxtHonninShiharaiGaku().setDisabled(true);
        div.getTxtKetteiYMD().setDisabled(true);
        div.getRdbShikyuKubun().setDisabled(true);
        div.getRdbShinsaHohoKubun().setDisabled(true);
        div.getTxtSetaiSyuyakuBango().setDisabled(true);
        div.getTxtShikyuKingaku().setDisabled(true);
        div.getRdbKogakuJidoSyokanTaisyo().setDisabled(true);
        div.getTxtShikyusinaiRiyu().setDisabled(true);
    }

    private void set申請情報タブエリア非活性() {
        div.getTxtShinseiYMD().setDisabled(true);
        div.getRdbShinseisyaKubun().setDisabled(true);
        div.getTxtHokenJyaBango().setDisabled(true);
        div.getTxtShimeiKanji().setDisabled(true);
        div.getTplShinseisha().getTxtShimeiKana().setDisabled(true);
        div.getTxtTelNo().setDisabled(true);
        div.getTxtShinseiRiyu().setDisabled(true);
        div.getTxtShiharaiTotalAmount().setDisabled(true);
    }

    private void set状態(RString 画面モード) {
        if (追加モード.equals(画面モード)) {
            div.getTxtJotai().setValue(新規);
        } else if (修正モード.equals(画面モード) || 送付済モード.equals(画面モード)) {
            div.getTxtJotai().setValue(修正);
        } else if (削除モード.equals(画面モード)) {
            div.getTxtJotai().setValue(削除);
        }
    }
}
