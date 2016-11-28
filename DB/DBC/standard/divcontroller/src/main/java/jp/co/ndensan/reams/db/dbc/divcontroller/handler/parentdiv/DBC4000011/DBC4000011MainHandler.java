/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4000011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sabisunaiyoutouruku.SabisuNaiyouTourukuInfo;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.GaibuServiceRiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.GendogakuTaisyogaiFlg;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.TokubetsuChikiKasanFlg;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.DBC4000011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4000011.dgService_Row;
import jp.co.ndensan.reams.db.dbc.service.core.sabisunaiyoutouruku.SabisuNaiyouTourukuManager;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouHolder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBC4000011_サービス内容登録のハンドラクラスです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public class DBC4000011MainHandler {

    private final DBC4000011MainDiv div;
    private static final RString RST検索 = new RString("%");
    private static final RString RST_0 = new RString("0");
    private static final RString RST_1 = new RString("1");
    private static final RString RST_2 = new RString("2");
    private static final RString RST_01 = new RString("01");
    private static final RString RST_10 = new RString("10");
    private static final RString RST_11 = new RString("11");
    private static final RString RST_12 = new RString("12");
    private static final RString RST_13 = new RString("13");
    private static final RString RST_3 = new RString("3");
    private static final RString RST_33 = new RString("33");
    private static final RString RST_35 = new RString("35");
    private static final RString RST_93 = new RString("93");
    private static final RString RST_010 = new RString("010");
    private static final int INT_0 = 0;
    private static final int INT_NEG_1 = -1;
    private static final RString 排他キー = new RString("DBCKaigoServiceTableDbT7131");
    private static final RString 修正 = new RString("修正");
    private static final RString 登録 = new RString("登録");

    /**
     * コンストラクタです。
     *
     * @param div DBC4000011MainDiv
     */
    public DBC4000011MainHandler(DBC4000011MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        div.getServiceNaiyoIchiran().getBtnTsuika().setDisabled(true);
        set詳細表示制御(true);
        pullDown制御();
        div.getServiceNaiyoIchiran().getDgService().init();
        div.getKensakuJoken().getCcdServiceCdInput().initialize();
    }

    private void set詳細表示制御(boolean isDisabled) {
        div.getServiceShosai().getTxtServiceMeisho().setDisabled(isDisabled);
        div.getServiceShosai().getTxtServiceNameRyaku().setDisabled(isDisabled);
        div.getServiceShosai().getTxtTeikyoKikanYM().setDisabled(isDisabled);
        div.getServiceShosai().getTxtTani().setDisabled(isDisabled);
        div.getServiceShosai().getDdlTanisuShikibetsu().setDisabled(isDisabled);
        div.getServiceShosai().getDdlIdouJiyuCode().setDisabled(isDisabled);
        div.getServiceShosai().getSegTeiritsuOrTeigaku().setDisabled(isDisabled);
        div.getServiceShosai().getDdlTanisuSanteiTaniCode().setDisabled(isDisabled);
        div.getServiceShosai().getTxtKyufuritsu().setDisabled(isDisabled);
        div.getServiceShosai().getTxtSeigenNissuKaisu().setDisabled(isDisabled);
        div.getServiceShosai().getTxtRiyoshaFutangaku().setDisabled(isDisabled);
        div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setDisabled(isDisabled);
        div.getServiceShosai().getSegTaishoJigyoJishiKubun().setDisabled(isDisabled);
        div.getServiceShosai().getSegYoshien1().setDisabled(isDisabled);
        div.getServiceShosai().getSegYoshien2().setDisabled(isDisabled);
        div.getServiceShosai().getSegNijiYobosha().setDisabled(isDisabled);
        div.getServiceShosai().getChkGendogakuTaishogai().setDisabled(isDisabled);
        div.getServiceShosai().getChkGaibuService().setDisabled(isDisabled);
        div.getServiceShosai().getChkTokubetsuChiikiKasn().setDisabled(isDisabled);
    }

    private void pullDown制御() {
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        List<UzT0007CodeEntity> 単位数識別List
                = CodeMaster.getCode(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.単位数識別コード.getコード(), nowDate);
        List<KeyValueDataSource> 単位数識別DataSource = new ArrayList<>();
        for (UzT0007CodeEntity 単位数識別 : 単位数識別List) {
            単位数識別DataSource.add(new KeyValueDataSource(単位数識別.getコード().value(), 単位数識別.getコード名称()));
        }
        div.getServiceShosai().getDdlTanisuShikibetsu().setDataSource(単位数識別DataSource);
        List<UzT0007CodeEntity> 異動事由リスト
                = CodeMaster.getCode(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.介護サービス異動事由.getコード(), nowDate);
        List<KeyValueDataSource> 異動事由DataSource = new ArrayList<>();
        for (UzT0007CodeEntity 異動事由 : 異動事由リスト) {
            異動事由DataSource.add(new KeyValueDataSource(異動事由.getコード().value(), 異動事由.getコード名称()));
        }
        div.getServiceShosai().getDdlIdouJiyuCode().setDataSource(異動事由DataSource);
        List<UzT0007CodeEntity> 算定単位リスト
                = CodeMaster.getCode(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.算定単位.getコード(), nowDate);
        List<KeyValueDataSource> 算定単位DataSource = new ArrayList<>();
        for (UzT0007CodeEntity 算定単位 : 算定単位リスト) {
            算定単位DataSource.add(new KeyValueDataSource(算定単位.getコード().value(), 算定単位.getコード名称()));
        }
        div.getServiceShosai().getDdlTanisuSanteiTaniCode().setDataSource(算定単位DataSource);
        List<UzT0007CodeEntity> 算定回数制限期間リスト
                = CodeMaster.getCode(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.算定期間回数制限_期間_時期.getコード(), nowDate);
        List<KeyValueDataSource> 算定回数制限期間DataSource = new ArrayList<>();
        算定回数制限期間DataSource.add(new KeyValueDataSource());
        for (UzT0007CodeEntity 算定回数制限期間 : 算定回数制限期間リスト) {
            算定回数制限期間DataSource.add(new KeyValueDataSource(算定回数制限期間.getコード().value(), 算定回数制限期間.getコード名称()));
        }
        div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setDataSource(算定回数制限期間DataSource);
    }

    /**
     * サービス内容を検索するのメソッドです。
     *
     * @return List<KaigoServiceNaiyou>
     */
    public List<KaigoServiceNaiyou> getサービス内容() {
        List<KaigoServiceNaiyou> kaigoServiceNaiyouList = new ArrayList<>();
        RString サービス種類コード = div.getKensakuJoken().getCcdServiceCdInput().getサービスコード1();
        RString サービス項目コード = div.getKensakuJoken().getCcdServiceCdInput().getサービスコード2();
        サービス項目コード = new RString(サービス項目コード.toString() + RST検索.toString());
        List<SabisuNaiyouTourukuInfo> サービス内容List = SabisuNaiyouTourukuManager.createInstance().
                getサービス内容データ(サービス種類コード, サービス項目コード);
        List<dgService_Row> サービス内容rows = new ArrayList<>();
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        for (SabisuNaiyouTourukuInfo サービス内容 : サービス内容List) {
            KaigoServiceNaiyou kaigoServiceNaiyou = サービス内容.getサービス内容();
            kaigoServiceNaiyouList.add(kaigoServiceNaiyou);
            dgService_Row row = new dgService_Row();
            row.setServiceCd(new RString(kaigoServiceNaiyou.getサービス種類コード().value().toString()
                    + kaigoServiceNaiyou.getサービス項目コード().toString()));
            row.setTeikyoKaishiYM(new RString(kaigoServiceNaiyou.get提供開始年月().
                    wareki().firstYear(FirstYear.ICHI_NEN).toDateString().toString()));
            if (kaigoServiceNaiyou.get提供終了年月() != null && !kaigoServiceNaiyou.get提供終了年月().isEmpty()) {
                row.setTeikyoShuryoYM(new RString(kaigoServiceNaiyou.get提供終了年月().wareki().
                        firstYear(FirstYear.ICHI_NEN).toDateString().toString()));
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            }
            row.setServiceName(kaigoServiceNaiyou.getサービス名称());
            row.setServiceNameRyaku(kaigoServiceNaiyou.getサービス略称());
            row.setTaniSu(DecimalFormatter.toコンマ区切りRString(new Decimal(kaigoServiceNaiyou.get単位数()), 0));
            RString 単位数識別 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.単位数識別コード.getコード(), kaigoServiceNaiyou.get単位数識別(), nowDate);
            row.setTanisuShikibetsu(単位数識別);
            RString 単位数算定単位 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.算定単位.getコード(), kaigoServiceNaiyou.get単位数算定単位(), nowDate);
            row.setTanisuSanteiTani(単位数算定単位);
            RString 異動事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    DBCCodeShubetsu.介護サービス異動事由.getコード(), kaigoServiceNaiyou.get異動事由(), nowDate);
            row.setIdouJiyu(異動事由);
            row.setGendogakuTaishogai(GendogakuTaisyogaiFlg.toValue(kaigoServiceNaiyou.get限度額対象外フラグ()).get名称());
            row.setGaibuServiceRiyoKata(GaibuServiceRiyoKubun.toValue(kaigoServiceNaiyou.get外部サービス利用型区分()).get名称());
            row.setTokubetsuChiikiKasan(TokubetsuChikiKasanFlg.toValue(kaigoServiceNaiyou.get特別地域加算フラグ()).get名称());
            row.setServiceShuruiCd(kaigoServiceNaiyou.getサービス種類コード().getColumnValue());
            row.setServiceKoumokuCd(kaigoServiceNaiyou.getサービス項目コード());
            row.setRirekiNo(new RString(kaigoServiceNaiyou.get履歴番号().toString()));
            row.setServiceShuruiCd(kaigoServiceNaiyou.getサービス種類コード().getColumnValue());
            FlexibleDate 提供開始年月 = new FlexibleDate(kaigoServiceNaiyou.get提供開始年月().toDateString());
            row.getTeikyoKaishiKey().setValue(提供開始年月);
            row.setServiceBunrruicode(サービス内容.getサービス分類コード());
            row.setServiceShoBunrui(サービス内容.getサービス小分類());
            サービス内容rows.add(row);
        }
        div.getServiceNaiyoIchiran().getDgService().setDataSource(サービス内容rows);
        div.getKensakuJoken().getCcdServiceCdInput().setDisabled(true);
        div.getServiceNaiyoIchiran().getBtnTsuika().setDisabled(false);
        div.getBtnSearch().setDisabled(true);
        clear詳細パネル();
        return kaigoServiceNaiyouList;
    }

    /**
     * 追加するのメソッドです。
     *
     */
    public void 追加する() {
        set詳細表示制御(false);
        div.getServiceNaiyoIchiran().getBtnTsuika().setDisabled(true);
        List<dgService_Row> rows = div.getServiceNaiyoIchiran().getDgService().getDataSource();
        for (dgService_Row row : rows) {
            row.setDeleteButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
        }
        clear詳細パネル();
        div.getServiceShosai().getTxtTeikyoKikanYM().setFromDisabled(false);
        div.getServiceShosai().getTxtTeikyoKikanYM().setToDisabled(true);
        編集状態の画面制御();
        定率定額区分選択();
    }

    /**
     * 修正するのメソッドです。
     *
     * @param holder KaigoServiceNaiyouHolder
     *
     * @return KaigoServiceNaiyouIdentifier
     */
    public KaigoServiceNaiyouIdentifier 修正する(KaigoServiceNaiyouHolder holder) {
        KaigoServiceNaiyouIdentifier identifier = サービス内容一覧選択(holder);
        set詳細表示制御(false);
        div.getServiceShosai().getTxtTeikyoKikanYM().setFromDisabled(true);
        div.getServiceShosai().getTxtTeikyoKikanYM().setToDisabled(true);
        div.getServiceNaiyoIchiran().getBtnTsuika().setDisabled(true);
        List<dgService_Row> rows = div.getServiceNaiyoIchiran().getDgService().getDataSource();
        for (dgService_Row row : rows) {
            row.setDeleteButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
        }
        編集状態の画面制御();
        定率定額区分選択();
        return identifier;
    }

    private void 編集状態の画面制御() {
        List<dgService_Row> 選択rows = div.getServiceNaiyoIchiran().getDgService().getDataSource();
        if (選択rows == null || 選択rows.isEmpty()) {
            return;
        }
        RString サービス分類コード = 選択rows.get(INT_0).getServiceBunrruicode();
        RString サービス小分類 = 選択rows.get(INT_0).getServiceShoBunrui();
        RString サービス種類 = div.getKensakuJoken().getCcdServiceCdInput().getサービスコード1();
        if (RST_10.equals(サービス分類コード) || RST_11.equals(サービス分類コード)) {
            div.getServiceShosai().getSegNijiYobosha().setDisabled(false);
            div.getServiceShosai().getSegTaishoJigyoJishiKubun().setDisabled(false);
            div.getServiceShosai().getSegYoshien1().setDisabled(false);
            div.getServiceShosai().getSegYoshien2().setDisabled(false);
        } else if (RST_12.equals(サービス分類コード) || RST_13.equals(サービス分類コード)) {
            div.getServiceShosai().getSegNijiYobosha().setDisabled(true);
            div.getServiceShosai().getSegTaishoJigyoJishiKubun().setDisabled(false);
            div.getServiceShosai().getSegYoshien1().setDisabled(false);
            div.getServiceShosai().getSegYoshien2().setDisabled(false);
        } else {
            div.getServiceShosai().getSegTaishoJigyoJishiKubun().setDisabled(true);
            div.getServiceShosai().getSegYoshien1().setDisabled(true);
            div.getServiceShosai().getSegYoshien2().setDisabled(true);
        }
        if (RST_2.equals(サービス小分類) || RST_3.equals(サービス小分類)) {
            div.getServiceShosai().getDdlTanisuSanteiTaniCode().setDisabled(false);
            div.getServiceShosai().getTxtSeigenNissuKaisu().setDisabled(false);
            div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setDisabled(false);
            div.getServiceShosai().getDdlTanisuShikibetsu().setDisabled(true);
        } else {
            div.getServiceShosai().getDdlTanisuSanteiTaniCode().setDisabled(true);
            div.getServiceShosai().getTxtSeigenNissuKaisu().setDisabled(true);
            div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setDisabled(true);
            div.getServiceShosai().getDdlTanisuShikibetsu().setDisabled(false);
        }
        if (RST_33.equals(サービス種類) || RST_35.equals(サービス種類) || RST_93.equals(サービス種類)) {
            div.getServiceShosai().getChkGaibuService().setDisabled(false);
        } else {
            div.getServiceShosai().getChkGaibuService().setDisabled(true);
        }
    }

    /**
     * 削除するのメソッドです。
     *
     * @param holder KaigoServiceNaiyouHolder
     *
     * @return KaigoServiceNaiyouIdentifier
     */
    public KaigoServiceNaiyouIdentifier 削除する(KaigoServiceNaiyouHolder holder) {
        KaigoServiceNaiyouIdentifier identifier = サービス内容一覧選択(holder);
        set詳細表示制御(true);
        div.getServiceNaiyoIchiran().getBtnTsuika().setDisabled(true);
        List<dgService_Row> rows = div.getServiceNaiyoIchiran().getDgService().getDataSource();
        for (dgService_Row row : rows) {
            row.setDeleteButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
        }
        RString 選択Key = div.getServiceShosai().getSegTeiritsuOrTeigaku().getSelectedKey();
        if (RST_1.equals(選択Key)) {
            div.getServiceShosai().getTxtRiyoshaFutangaku().clearValue();
        } else if (RST_2.equals(選択Key)) {
            div.getServiceShosai().getTxtKyufuritsu().clearValue();
        }
        return identifier;
    }

    /**
     * サービス内容一覧選択のメソッドです。
     *
     * @param holder KaigoServiceNaiyouHolder
     *
     * @return KaigoServiceNaiyouIdentifier
     */
    public KaigoServiceNaiyouIdentifier サービス内容一覧選択(KaigoServiceNaiyouHolder holder) {
        List<dgService_Row> サービス内容選択rows = div.getServiceNaiyoIchiran().getDgService().getSelectedItems();
        if (サービス内容選択rows == null || サービス内容選択rows.isEmpty()) {
            clear詳細パネル();
            return null;
        }
        dgService_Row row = サービス内容選択rows.get(INT_0);
        FlexibleYearMonth 提供開始年月 = row.getTeikyoKaishiKey().getValue().getYearMonth();
        KaigoServiceNaiyouIdentifier identifier = new KaigoServiceNaiyouIdentifier(
                new ServiceShuruiCode(row.getServiceShuruiCd()), row.getServiceKoumokuCd(),
                提供開始年月, new Decimal(row.getRirekiNo().toString()));
        KaigoServiceNaiyou サービス内容 = holder.getKaigoServiceNaiyou(identifier);
        if (サービス内容 == null) {
            clear詳細パネル();
            return null;
        }
        詳細パネル設定(サービス内容);
        RString 選択Key = div.getServiceShosai().getSegTeiritsuOrTeigaku().getSelectedKey();
        if (RST_1.equals(選択Key)) {
            div.getServiceShosai().getTxtRiyoshaFutangaku().clearValue();
        } else if (RST_2.equals(選択Key)) {
            div.getServiceShosai().getTxtKyufuritsu().clearValue();
        }
        return identifier;

    }

    private void 詳細パネル設定(KaigoServiceNaiyou サービス内容) {
        div.getServiceShosai().getTxtServiceMeisho().setValue(サービス内容.getサービス名称());
        div.getServiceShosai().getTxtServiceNameRyaku().setValue(サービス内容.getサービス略称());
        RDate 提供開始年月 = new RDate(サービス内容.get提供開始年月().getYearValue(), サービス内容.get提供開始年月().getMonthValue());
        div.getServiceShosai().getTxtTeikyoKikanYM().setFromValue(提供開始年月);
        if (サービス内容.get提供終了年月() != null && !サービス内容.get提供終了年月().isEmpty()) {
            RDate 提供終了年月 = new RDate(サービス内容.get提供終了年月().getYearValue(), サービス内容.get提供終了年月().getMonthValue());
            div.getServiceShosai().getTxtTeikyoKikanYM().setToValue(提供終了年月);
        } else {
            div.getServiceShosai().getTxtTeikyoKikanYM().clearToValue();
        }
        div.getServiceShosai().getTxtTani().setValue(new Decimal(サービス内容.get単位数()));
        div.getServiceShosai().getDdlTanisuShikibetsu().setSelectedKey(サービス内容.get単位数識別().getColumnValue());
        div.getServiceShosai().getDdlIdouJiyuCode().setSelectedKey(サービス内容.get異動事由().getColumnValue());
        RString 利用者負担定率定額区分 = サービス内容.get利用者負担定率定額区分();
        if (RST_1.equals(利用者負担定率定額区分) || RST_2.equals(利用者負担定率定額区分)) {
            div.getServiceShosai().getSegTeiritsuOrTeigaku().setSelectedKey(サービス内容.get利用者負担定率定額区分());
        } else {
            div.getServiceShosai().getSegTeiritsuOrTeigaku().clearSelectedItem();
        }        
        if (!RString.isNullOrEmpty(サービス内容.get給付率())) {
            div.getServiceShosai().getTxtKyufuritsu().setValue(new Decimal(サービス内容.get給付率().toString()));
        } else {
            div.getServiceShosai().getTxtKyufuritsu().clearValue();
        }
        if (!RString.isNullOrEmpty(サービス内容.get利用者負担額())) {
            div.getServiceShosai().getTxtRiyoshaFutangaku().setValue(new Decimal(サービス内容.get利用者負担額().toString()));
        } else {
            div.getServiceShosai().getTxtRiyoshaFutangaku().clearValue();
        }
        div.getServiceShosai().getDdlTanisuSanteiTaniCode().setSelectedKey(サービス内容.get単位数算定単位().getColumnValue());
        if (!RString.isNullOrEmpty(サービス内容.get制限日数回数())) {
            div.getServiceShosai().getTxtSeigenNissuKaisu().setValue(new Decimal(サービス内容.get制限日数回数().toString()));
        } else {
            div.getServiceShosai().getTxtSeigenNissuKaisu().clearValue();
        }
        div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setSelectedKey(サービス内容.get算定回数制限期間区分());
        RString 対象事業者実施区分 = サービス内容.get対象事業者実施区分();
        if (RST_1.equals(対象事業者実施区分) || RST_2.equals(対象事業者実施区分)) {
            div.getServiceShosai().getSegTaishoJigyoJishiKubun().setSelectedKey(対象事業者実施区分);
        } else {
            div.getServiceShosai().getSegTaishoJigyoJishiKubun().clearSelectedItem();
        }
        RString 要支援１ = サービス内容.get要支援１受給者実施区分();
        if (RST_1.equals(要支援１) || RST_2.equals(要支援１)) {
            div.getServiceShosai().getSegYoshien1().setSelectedKey(要支援１);
        } else {
            div.getServiceShosai().getSegTaishoJigyoJishiKubun().clearSelectedItem();
        }
        RString 要支援２ = サービス内容.get要支援２受給者実施区分();
        if (RST_1.equals(要支援２) || RST_2.equals(要支援２)) {
            div.getServiceShosai().getSegYoshien2().setSelectedKey(要支援２);
        } else {
            div.getServiceShosai().getSegYoshien2().clearSelectedItem();
        }
        RString 二次予防 = サービス内容.get二次予防事業対象者実施区分非該当();
        if (RST_1.equals(二次予防) || RST_2.equals(二次予防)) {
            div.getServiceShosai().getSegNijiYobosha().setSelectedKey(二次予防);
        } else {
            div.getServiceShosai().getSegNijiYobosha().clearSelectedItem();
        }
        RString 限度額対象外 = サービス内容.get限度額対象外フラグ();
        List<RString> selectList限度額対象外 = new ArrayList<>();
        if (RST_1.equals(限度額対象外)) {
            selectList限度額対象外.add(限度額対象外);
        }
        div.getServiceShosai().getChkGendogakuTaishogai().setSelectedItemsByKey(selectList限度額対象外);
        RString 外部サービス利用型区分 = サービス内容.get外部サービス利用型区分();
        List<RString> selectList外部サービス利用型区分 = new ArrayList<>();
        if (RST_2.equals(外部サービス利用型区分)) {
            selectList外部サービス利用型区分.add(外部サービス利用型区分);
        }
        div.getServiceShosai().getChkGaibuService().setSelectedItemsByKey(selectList外部サービス利用型区分);
        RString 特別地域 = サービス内容.get特別地域加算フラグ();
        List<RString> selectList = new ArrayList<>();
        if (RST_1.equals(特別地域)) {
            selectList.add(特別地域);
        }
        div.getServiceShosai().getChkTokubetsuChiikiKasn().setSelectedItemsByKey(selectList);
    }

    private void clear詳細パネル() {
        div.getServiceShosai().getTxtServiceMeisho().clearValue();
        div.getServiceShosai().getTxtServiceNameRyaku().clearValue();
        div.getServiceShosai().getTxtTeikyoKikanYM().clearFromValue();
        div.getServiceShosai().getTxtTeikyoKikanYM().clearToValue();
        div.getServiceShosai().getTxtTani().clearValue();
        div.getServiceShosai().getDdlTanisuShikibetsu().setSelectedKey(RST_01);
        div.getServiceShosai().getDdlIdouJiyuCode().setSelectedKey(RST_010);
        div.getServiceShosai().getSegTeiritsuOrTeigaku().clearSelectedItem();
        div.getServiceShosai().getTxtKyufuritsu().clearValue();
        div.getServiceShosai().getTxtRiyoshaFutangaku().clearValue();
        div.getServiceShosai().getDdlTanisuSanteiTaniCode().setSelectedKey(RST_01);
        div.getServiceShosai().getTxtSeigenNissuKaisu().clearValue();
        div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setSelectedIndex(INT_0);
        div.getServiceShosai().getSegTaishoJigyoJishiKubun().clearSelectedItem();
        div.getServiceShosai().getSegYoshien1().clearSelectedItem();
        div.getServiceShosai().getSegYoshien2().clearSelectedItem();
        div.getServiceShosai().getSegNijiYobosha().clearSelectedItem();
        List<RString> selectList = new ArrayList<>();
        div.getServiceShosai().getChkGendogakuTaishogai().setSelectedItemsByKey(selectList);
        div.getServiceShosai().getChkGaibuService().setSelectedItemsByKey(selectList);
        div.getServiceShosai().getChkTokubetsuChiikiKasn().setSelectedItemsByKey(selectList);
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        LockingKey lockKey = new LockingKey(排他キー);
        return RealInitialLocker.tryGetLock(lockKey);
    }

    /**
     * 前排他を解除のメソッドです。
     */
    public void 前排他を解除する() {
        LockingKey lockKey = new LockingKey(排他キー);
        RealInitialLocker.release(lockKey);
    }

    /**
     * 初期状態表示のメソッドです。
     */
    public void 初期状態返る() {
        List<dgService_Row> サービス内容rows = new ArrayList<>();
        div.getServiceNaiyoIchiran().getDgService().setDataSource(サービス内容rows);
        div.getKensakuJoken().getCcdServiceCdInput().clear();
        div.getKensakuJoken().getCcdServiceCdInput().setDisabled(false);
        div.getKensakuJoken().getBtnSearch().setDisabled(false);
        div.getServiceNaiyoIchiran().getBtnTsuika().setDisabled(false);
        詳細パネル初期();
        set詳細表示制御(true);
    }

    private void 詳細パネル初期() {
        div.getServiceShosai().getTxtServiceMeisho().clearValue();
        div.getServiceShosai().getTxtServiceNameRyaku().clearValue();
        div.getServiceShosai().getTxtTeikyoKikanYM().clearFromValue();
        div.getServiceShosai().getTxtTeikyoKikanYM().clearToValue();
        div.getServiceShosai().getTxtTani().clearValue();
        div.getServiceShosai().getDdlTanisuShikibetsu().setSelectedKey(RString.EMPTY);
        div.getServiceShosai().getDdlIdouJiyuCode().setSelectedKey(RString.EMPTY);
        div.getServiceShosai().getSegTeiritsuOrTeigaku().clearSelectedItem();
        div.getServiceShosai().getTxtKyufuritsu().clearValue();
        div.getServiceShosai().getTxtRiyoshaFutangaku().clearValue();
        div.getServiceShosai().getDdlTanisuSanteiTaniCode().setSelectedKey(RString.EMPTY);
        div.getServiceShosai().getTxtSeigenNissuKaisu().clearValue();
        div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().setSelectedKey(RString.EMPTY);
        div.getServiceShosai().getSegTaishoJigyoJishiKubun().clearSelectedItem();
        div.getServiceShosai().getSegYoshien1().clearSelectedItem();
        div.getServiceShosai().getSegYoshien2().clearSelectedItem();
        div.getServiceShosai().getSegNijiYobosha().clearSelectedItem();
        List<RString> selectList = new ArrayList<>();
        div.getServiceShosai().getChkGendogakuTaishogai().setSelectedItemsByKey(selectList);
        div.getServiceShosai().getChkGaibuService().setSelectedItemsByKey(selectList);
        div.getServiceShosai().getChkTokubetsuChiikiKasn().setSelectedItemsByKey(selectList);
    }

    /**
     * 定率定額区分選択のメソッドです。
     */
    public void 定率定額区分選択() {
        RString 選択Key = div.getServiceShosai().getSegTeiritsuOrTeigaku().getSelectedKey();
        if (RST_1.equals(選択Key)) {
            div.getServiceShosai().getTxtKyufuritsu().setDisabled(false);
            div.getServiceShosai().getTxtRiyoshaFutangaku().setDisabled(true);
            div.getServiceShosai().getTxtRiyoshaFutangaku().clearValue();
        } else if (RST_2.equals(選択Key)) {
            div.getServiceShosai().getTxtRiyoshaFutangaku().setDisabled(false);
            div.getServiceShosai().getTxtKyufuritsu().setDisabled(true);
            div.getServiceShosai().getTxtKyufuritsu().clearValue();
        }

    }

    /**
     * 入力をやめるのメソッドです。
     */
    public void 入力をやめる() {
        getサービス内容();
        set詳細表示制御(true);
    }

    /**
     * 保存するボタンの処理です。
     *
     * @param holder KaigoServiceNaiyouHolder
     * @param 状態 RString
     * @param identifier KaigoServiceNaiyouIdentifier
     */
    public void 保存する(KaigoServiceNaiyouHolder holder, RString 状態, KaigoServiceNaiyouIdentifier identifier) {
        List<dgService_Row> サービス内容rows = div.getServiceNaiyoIchiran().getDgService().getDataSource();
        if (登録.equals(状態)) {
            RString サービス種類コード = div.getKensakuJoken().getCcdServiceCdInput().getサービスコード1();
            RString サービス項目コード = div.getKensakuJoken().getCcdServiceCdInput().getサービスコード2();
            RString サービスコード = サービス種類コード.concat(サービス項目コード);
            RString 提供開始年月 = div.getServiceShosai().getTxtTeikyoKikanYM().getFromValue().getYearMonth().toDateString();
            KaigoServiceNaiyou kaigoServiceNaiyou = new KaigoServiceNaiyou(
                    new ServiceShuruiCode(サービス種類コード), サービス項目コード, new FlexibleYearMonth(提供開始年月), Decimal.ONE);
            KaigoServiceNaiyou result = setResult追加修正(kaigoServiceNaiyou, 登録);
            SabisuNaiyouTourukuManager.createInstance().save(result);
            for (dgService_Row row : サービス内容rows) {
                if (!サービスコード.equals(row.getServiceCd())) {
                    continue;
                }
                if (!RString.isNullOrEmpty(row.getTeikyoShuryoYM())) {
                    continue;
                }
                FlexibleYearMonth row提供開始年月 = row.getTeikyoKaishiKey().getValue().getYearMonth();
                KaigoServiceNaiyouIdentifier rowIdentifier = new KaigoServiceNaiyouIdentifier(
                        new ServiceShuruiCode(row.getServiceShuruiCd()), row.getServiceKoumokuCd(),
                        row提供開始年月, new Decimal(row.getRirekiNo().toString()));
                KaigoServiceNaiyou サービス内容 = holder.getKaigoServiceNaiyou(rowIdentifier);
                KaigoServiceNaiyou 提供終了年月更新 = サービス内容.createBuilderForEdit().set提供終了年月(
                        new FlexibleYearMonth(提供開始年月).plusMonth(INT_NEG_1)).setIsDeleted(false).build();
                提供終了年月更新 = 提供終了年月更新.modifiedModel();
                SabisuNaiyouTourukuManager.createInstance().save(提供終了年月更新);
            }
            return;
        }
        if (identifier == null) {
            clear詳細パネル();
            return;
        }
        FlexibleYearMonth 提供開始年月 = identifier.get提供開始年月();
        KaigoServiceNaiyou kaigoServiceNaiyou = holder.getKaigoServiceNaiyou(identifier);
        if (修正.equals(状態)) {
            KaigoServiceNaiyou result = setResult追加修正(kaigoServiceNaiyou, 修正);
            result = result.modifiedModel();
            SabisuNaiyouTourukuManager.createInstance().save(result);
            return;
        }
        RString 選択サービスコード = identifier.getサービス種類コード().getColumnValue().concat(identifier.getサービス項目コード());
        for (dgService_Row row : サービス内容rows) {
            if (!選択サービスコード.equals(row.getServiceCd())) {
                continue;
            }
            if (RString.isNullOrEmpty(row.getTeikyoShuryoYM())) {
                continue;
            }
            FlexibleYearMonth row提供開始年月 = row.getTeikyoKaishiKey().getValue().getYearMonth();
            KaigoServiceNaiyouIdentifier updateIdentifier = new KaigoServiceNaiyouIdentifier(
                    new ServiceShuruiCode(row.getServiceShuruiCd()), row.getServiceKoumokuCd(),
                    row提供開始年月, new Decimal(row.getRirekiNo().toString()));
            KaigoServiceNaiyou updateサービス内容 = holder.getKaigoServiceNaiyou(updateIdentifier);
            FlexibleYearMonth 提供終了年月 = updateサービス内容.get提供終了年月();
            if (!提供終了年月.equals(提供開始年月.plusMonth(INT_NEG_1))) {
                continue;
            }
            KaigoServiceNaiyou 提供終了年月更新 = updateサービス内容.createBuilderForEdit().set提供終了年月(
                    FlexibleYearMonth.EMPTY).setIsDeleted(false).build();
            提供終了年月更新 = 提供終了年月更新.modifiedModel();
            SabisuNaiyouTourukuManager.createInstance().save(提供終了年月更新);
        }
        kaigoServiceNaiyou = kaigoServiceNaiyou.deleted();
        SabisuNaiyouTourukuManager.createInstance().delete(kaigoServiceNaiyou);
    }

    /**
     * 修正のメソッドます。
     *
     * @param result KaigoServiceNaiyou
     * @param 状態 RString
     * @return KaigoServiceNaiyou
     */
    public KaigoServiceNaiyou setResult追加修正(KaigoServiceNaiyou result, RString 状態) {
        FlexibleYearMonth 提供終了年月 = FlexibleYearMonth.EMPTY;
        if (div.getServiceShosai().getTxtTeikyoKikanYM().getToValue() != null) {
            提供終了年月 = new FlexibleYearMonth(div.getServiceShosai().getTxtTeikyoKikanYM().getToValue().getYearMonth().toDateString());
        }
        RString 限度額対象外フラグ;
        if (div.getServiceShosai().getChkGendogakuTaishogai().getSelectedKeys().isEmpty()) {
            限度額対象外フラグ = RST_0;
        } else {
            限度額対象外フラグ = RST_1;
        }
        RString 外部サービス利用型区分;
        if (div.getServiceShosai().getChkGaibuService().isDisabled()) {
            外部サービス利用型区分 = RST_0;
        } else if (div.getServiceShosai().getChkGaibuService().getSelectedKeys().isEmpty()) {
            外部サービス利用型区分 = RST_1;
        } else {
            外部サービス利用型区分 = RST_2;
        }
        RString 特別地域加算フラグ;
        if (div.getServiceShosai().getChkTokubetsuChiikiKasn().getSelectedKeys().isEmpty()) {
            特別地域加算フラグ = RST_0;
        } else {
            特別地域加算フラグ = RST_1;
        }
        RString 二次予防者 = RST_0;
        if (!RString.isNullOrEmpty(div.getServiceShosai().getSegNijiYobosha().getSelectedKey())) {
            二次予防者 = div.getServiceShosai().getSegNijiYobosha().getSelectedKey();
        }
        RString 要支援１ = RST_0;
        if (!RString.isNullOrEmpty(div.getServiceShosai().getSegYoshien1().getSelectedKey())) {
            要支援１ = div.getServiceShosai().getSegYoshien1().getSelectedKey();
        }
        RString 要支援2 = RST_0;
        if (!RString.isNullOrEmpty(div.getServiceShosai().getSegYoshien2().getSelectedKey())) {
            要支援2 = div.getServiceShosai().getSegYoshien2().getSelectedKey();
        }
        RString 対象事業者 = RST_0;
        if (!RString.isNullOrEmpty(div.getServiceShosai().getSegTaishoJigyoJishiKubun().getSelectedKey())) {
            対象事業者 = div.getServiceShosai().getSegTaishoJigyoJishiKubun().getSelectedKey();
        }
        RString 利用者負担定率_定額区分 = RST_0;
        if (!RString.isNullOrEmpty(div.getServiceShosai().getSegTeiritsuOrTeigaku().getSelectedKey())) {
            利用者負担定率_定額区分 = div.getServiceShosai().getSegTeiritsuOrTeigaku().getSelectedKey();
        }
        RString 利用者負担額 = RString.EMPTY;
        if (div.getServiceShosai().getTxtRiyoshaFutangaku().getValue() != null) {
            利用者負担額 = new RString(div.getServiceShosai().getTxtRiyoshaFutangaku().getValue().toString());
        }
        RString 給付率 = RString.EMPTY;
        if (div.getServiceShosai().getTxtKyufuritsu().getValue() != null) {
            給付率 = new RString(div.getServiceShosai().getTxtKyufuritsu().getValue().toString());
        }
        RString 制限日数回数 = RString.EMPTY;
        if (div.getServiceShosai().getTxtSeigenNissuKaisu().getValue() != null) {
            制限日数回数 = new RString(div.getServiceShosai().getTxtSeigenNissuKaisu().getValue().toString());
        }
        if (修正.equals(状態)) {
            return result.createBuilderForEdit()
                    .setサービス名称(div.getServiceShosai().getTxtServiceMeisho().getValue())
                    .setサービス略称(div.getServiceShosai().getTxtServiceNameRyaku().getValue())
                    .set単位数(div.getServiceShosai().getTxtTani().getValue().intValue())
                    .set単位数識別(new Code(div.getServiceShosai().getDdlTanisuShikibetsu().getSelectedKey().toString()))
                    .set単位数算定単位(new Code(div.getServiceShosai().getDdlTanisuSanteiTaniCode().getSelectedKey().toString()))
                    .set異動事由(new Code(div.getServiceShosai().getDdlIdouJiyuCode().getSelectedKey().toString()))
                    .set限度額対象外フラグ(限度額対象外フラグ)
                    .set外部サービス利用型区分(外部サービス利用型区分)
                    .set特別地域加算フラグ(特別地域加算フラグ)
                    .set利用者負担定率_定額区分(利用者負担定率_定額区分)
                    .set利用者負担額(利用者負担額)
                    .set給付率(給付率)
                    .set二次予防事業対象者実施区分_非該当(二次予防者)
                    .set要支援１受給者実施区分(要支援１)
                    .set要支援２受給者実施区分(要支援2)
                    .set対象事業者実施区分(対象事業者)
                    .set制限日数回数(制限日数回数)
                    .set算定回数制限期間区分(div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().getSelectedKey())
                    .setIsDeleted(false)
                    .build();
        }
        return result.createBuilderForEdit()
                .set提供終了年月(提供終了年月)
                .setサービス名称(div.getServiceShosai().getTxtServiceMeisho().getValue())
                .setサービス略称(div.getServiceShosai().getTxtServiceNameRyaku().getValue())
                .set単位数(div.getServiceShosai().getTxtTani().getValue().intValue())
                .set単位数識別(new Code(div.getServiceShosai().getDdlTanisuShikibetsu().getSelectedKey().toString()))
                .set単位数算定単位(new Code(div.getServiceShosai().getDdlTanisuSanteiTaniCode().getSelectedKey().toString()))
                .set異動事由(new Code(div.getServiceShosai().getDdlIdouJiyuCode().getSelectedKey().toString()))
                .set限度額対象外フラグ(限度額対象外フラグ)
                .set外部サービス利用型区分(外部サービス利用型区分)
                .set特別地域加算フラグ(特別地域加算フラグ)
                .set利用者負担定率_定額区分(利用者負担定率_定額区分)
                .set更新有無フラグ(RString.EMPTY)
                .set元点数(RString.EMPTY)
                .set元限度額対象外フラグ(RString.EMPTY)
                .set元単位数識別コード(RString.EMPTY)
                .set利用者負担額(利用者負担額)
                .set給付率(給付率)
                .set二次予防事業対象者実施区分_非該当(二次予防者)
                .set要支援１受給者実施区分(要支援１)
                .set要支援２受給者実施区分(要支援2)
                .set対象事業者実施区分(対象事業者)
                .set総合事業サービス区分(RString.EMPTY)
                .set制限日数回数(制限日数回数)
                .set算定回数制限期間区分(div.getServiceShosai().getDdlSanteiKaisuSeigenKikanKubun().getSelectedKey())
                .setIsDeleted(false)
                .build();
    }

}
