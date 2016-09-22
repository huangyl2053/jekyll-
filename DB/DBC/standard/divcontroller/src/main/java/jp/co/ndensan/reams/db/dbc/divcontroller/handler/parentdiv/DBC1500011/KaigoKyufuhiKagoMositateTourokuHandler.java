/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1500011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoMoshitate;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KagoMoshitateCollect;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_MoshitateshaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitate_MoshitateshoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KyufuJissekiSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun.KyufubunruiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のコントローラクラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
public class KaigoKyufuhiKagoMositateTourokuHandler {

    private static final int 申立理由_ITN = 4;
    private static final RString MENUID_DBCMN91001 = new RString("DBCMN91001");
    private static final RString MENUID_DBCMN91002 = new RString("DBCMN91002");
    private static final RString MENUID_DBCMN91003 = new RString("DBCMN91003");
    private static final RString 新規モード = new RString("新規");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 同月審査用_KEY = new RString("forDogetsuShinsa");
    private static final RString 国保連再送付_KEY = new RString("key0");
    private static final RString 給付区分_1 = new RString("1");
    private static final RString 給付区分_2 = new RString("2");
    private static final RString 給付区分_3 = new RString("3");
    private static final RString 同月審査を行う = new RString("1");
    private static final RString 様式洗い出し = new RString("：");
    private final KaigoKyufuhiKagoMositateTourokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KaigoKyufuhiKagoMositateTourokuHandler(KaigoKyufuhiKagoMositateTourokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化します。
     */
    public void onLoad() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (MENUID_DBCMN91001.equals(menuID)) {
            div.setHdnKyuufuKubunn(KagoMoshitate_MoshitateshoKubun.過誤申立書.getコード());
        } else if (MENUID_DBCMN91002.equals(menuID)) {
            div.setHdnKyuufuKubunn(KagoMoshitate_MoshitateshoKubun.総合事業申立書_経過.getコード());
        } else if (MENUID_DBCMN91003.equals(menuID)) {
            div.setHdnKyuufuKubunn(KagoMoshitate_MoshitateshoKubun.総合事業申立書.getコード());
        }
        div.setHdnKensaku(new RString("FLASE"));
    }

    /**
     * 画面一覧の設定します。
     *
     * @param resultList 給付実績一覧
     * @return 過誤申立情報List
     */
    public KagoMoshitateCollect set画面一覧(List<KaigoKyufuhiKagoMositateTourokuResult> resultList) {
        KagoMoshitateCollect data = new KagoMoshitateCollect();
        List<dgHihokenshaSearchGaitosha_Row> rowList = new ArrayList<>();
        for (KaigoKyufuhiKagoMositateTourokuResult result : resultList) {
            RString 給付区分 = RString.EMPTY;
            if (!RString.isNullOrEmpty(result.get給付区分())) {
                給付区分 = KyufubunruiKubun.toValue(result.get給付区分()).get名称();
            }
            dgHihokenshaSearchGaitosha_Row row = new dgHihokenshaSearchGaitosha_Row(result.get過誤申立情報() != null,
                    result.get事業所番号(),
                    result.get事業者名(),
                    result.get被保険者番号(),
                    result.get氏名(),
                    set様式(result),
                    deteFormat(result.getサービス提供年月()),
                    KaigoGassan_KyufuJissekiSakuseiKubun.toValue(result.get給付実績作成区分コード()).get名称(),
                    給付区分,
                    deteFormat(result.get審査年月()));
            rowList.add(row);
        }
        div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setDataSource(rowList);
        data.set給付実績情報List(resultList);
        return data;
    }

    /**
     * 給付実績明細を設定します。
     *
     * @param 給付実績情報 給付実績情報
     */
    public void set給付実績明細(KaigoKyufuhiKagoMositateTourokuResult 給付実績情報) {
        set給付実績明細データ(給付実績情報);
    }

    private void set給付実績明細データ(KaigoKyufuhiKagoMositateTourokuResult 給付実績情報) {
        div.getTxtMeisaiJigyoshaNo().setValue(給付実績情報.get事業所番号());
        div.getTxtMeisaiJigyoshaName().setValue(給付実績情報.get事業者名());
        div.getTxtMeisaiMoshitateshaKubun().setValue(KagoMoshitate_MoshitateshaKubun.保険者申立.get名称());
        div.getTxtMeisaiShokisaiHokenshaNo().setValue(給付実績情報.get証記載保険者番号());
        if (!RString.isNullOrEmpty(給付実績情報.getサービス提供年月())) {
            div.getTxtMeisaiTeikyoYM().setValue(new RDate(給付実績情報.getサービス提供年月().toString()));
        }
        div.getTxtMeisaiKagoForm().setValue(set様式(給付実績情報));
        div.getDdlMeisaiKagoMoshitateRiyu().setSelectedIndex(0);
        set申立理由DDL();
        if (給付実績情報.get過誤申立情報() != null) {
            div.getTxtMeisaiMoshitateshaKubun().setValue(KagoMoshitate_MoshitateshaKubun.toValue(給付実績情報.get過誤申立情報().get申立者区分コード()).get名称());
            FlexibleYearMonth 送付年月 = 給付実績情報.get過誤申立情報().get国保連送付年月();
            if (送付年月 != null) {
                div.getTxtMeisaiSendYM().setValue(new RDate(送付年月.toString()));
            }
            if (給付実績情報.get過誤申立情報().get申立年月日() != null) {
                div.getTxtMeisaiMoshitateDate().setValue(new RDate(給付実績情報.get過誤申立情報().get申立年月日().toString()));
            }
            div.getDdlMeisaiKagoMoshitateRiyu().setSelectedKey(給付実績情報.get過誤申立情報().get申立事由コード().substring(2, 申立理由_ITN));
        }
        set同月審査用(給付実績情報);
        set国保連再送付(給付実績情報);
    }

    private RString deteFormat(RString 年月) {
        if (RString.isNullOrEmpty(年月)) {
            return RString.EMPTY;
        }
        return new FlexibleYearMonth(年月).wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
    }

    private void set申立理由DDL() {
        RString 給付区分 = div.getHdnKyuufuKubunn();
        List<KeyValueDataSource> 申立理由DateSource = new ArrayList<>();
        CodeShubetsu コード種別 = CodeShubetsu.EMPTY;
        if (給付区分_1.equals(給付区分)) {
            コード種別 = DBCCodeShubetsu.過誤申立事由コード_下２桁_申立理由.getコード();
        } else if (給付区分_2.equals(給付区分)) {
            コード種別 = DBCCodeShubetsu.総合事業_経過措置_過誤申立理由_理由.getコード();
        } else if (給付区分_3.equals(給付区分)) {
            コード種別 = DBCCodeShubetsu.総合事業過誤申立事由_理由.getコード();
        }
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBC介護給付, コード種別, FlexibleDate.getNowDate());
        for (UzT0007CodeEntity entity : codeList) {
            RStringBuilder 申立理由 = new RStringBuilder();
            申立理由.append(entity.getコード().value());
            申立理由.append(様式洗い出し);
            申立理由.append(entity.getコード名称());
            申立理由DateSource.add(new KeyValueDataSource(entity.getコード().value(), 申立理由.toRString()));
        }
        div.getDdlMeisaiKagoMoshitateRiyu().setDataSource(申立理由DateSource);
        div.getDdlMeisaiKagoMoshitateRiyu().setSelectedIndex(0);
    }

    /**
     * DB出力用データを作成します。
     *
     * @param 給付実績情報 給付実績情報
     * @param 最大履歴番号 最大履歴番号
     * @return KagoMoshitate
     */
    public KagoMoshitate setDB出力データ(KaigoKyufuhiKagoMositateTourokuResult 給付実績情報, int 最大履歴番号) {
        KagoMoshitate data = 給付実績情報.get過誤申立情報();
        RString 画面モード = div.getHdnState();
        if (新規モード.equals(画面モード)) {
            data = new KagoMoshitate(new JigyoshaNo(給付実績情報.get事業所番号()),
                    new HihokenshaNo(給付実績情報.get被保険者番号()),
                    new FlexibleYearMonth(給付実績情報.getサービス提供年月()),
                    最大履歴番号 + 1);
            data = set新規DB出力データ(data);
        } else if (修正モード.equals(画面モード)) {
            data = 給付実績情報.get過誤申立情報();
            data = set修正DB出力データ(data).modifiedModel();
        } else if (削除モード.equals(画面モード)) {
            data = 給付実績情報.get過誤申立情報().deleted();
        }
        return data;
    }

    private KagoMoshitate set修正DB出力データ(KagoMoshitate data) {
        data = data.createBuilderForEdit().set申立年月日(new FlexibleDate(div.getTxtMeisaiMoshitateDate().getValue()
                .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString())).build();
        data = data.createBuilderForEdit().set申立事由コード(div.getTxtMeisaiKagoForm()
                .getValue().substring(0, 2).concat(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())).build();
        return data;
    }

    private KagoMoshitate set新規DB出力データ(KagoMoshitate data) {
        data = data.createBuilderForEdit().set申立年月日(new FlexibleDate(div.getTxtMeisaiMoshitateDate().getValue()
                .seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString())).build();
        RString 申立者区分コード = RString.EMPTY;
        RString 申立者区分 = div.getTxtMeisaiMoshitateshaKubun().getValue();
        for (KagoMoshitate_MoshitateshaKubun 申立者区分_ENUM : KagoMoshitate_MoshitateshaKubun.values()) {
            if (申立者区分_ENUM.get名称().equals(申立者区分)) {
                申立者区分コード = 申立者区分_ENUM.getコード();
            }
        }
        data = data.createBuilderForEdit().set申立者区分コード(申立者区分コード).build();
        data = data.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(div.getTxtMeisaiShokisaiHokenshaNo().getValue())).build();
        data = data.createBuilderForEdit().set申立事由コード(div.getTxtMeisaiKagoForm()
                .getValue().substring(0, 2).concat(div.getDdlMeisaiKagoMoshitateRiyu().getSelectedKey())).build();
        if (div.getTxtMeisaiSendYM().getValue() != null) {
            data = data.createBuilderForEdit().set国保連送付年月(new FlexibleYearMonth(div.getTxtMeisaiSendYM().getValue().toDateString())).build();
        }
        data = data.createBuilderForEdit().set同月審査有フラグ(div.getChkMeisaiForDogetsuShinsa().getSelectedKeys().contains(同月審査用_KEY)).build();
        data = data.createBuilderForEdit().set国保連再送付有フラグ(div.getKokuhirenSaiSofu().getSelectedKeys().contains(国保連再送付_KEY)).build();
        RString 申立書区分コード = RString.EMPTY;
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (MENUID_DBCMN91001.equals(menuID)) {
            申立書区分コード = KagoMoshitate_MoshitateshoKubun.過誤申立書.getコード();
        } else if (MENUID_DBCMN91002.equals(menuID)) {
            申立書区分コード = KagoMoshitate_MoshitateshoKubun.総合事業申立書_経過.getコード();
        } else if (MENUID_DBCMN91003.equals(menuID)) {
            申立書区分コード = KagoMoshitate_MoshitateshoKubun.総合事業申立書.getコード();
        }
        data = data.createBuilderForEdit().set申立書区分コード(申立書区分コード).build();
        return data;
    }

    private void set同月審査用(KaigoKyufuhiKagoMositateTourokuResult result) {
        if (result.get過誤申立情報() != null
                && result.get過誤申立情報().is同月審査有フラグ()) {
            List<RString> 同月審査用 = new ArrayList<>();
            同月審査用.add(同月審査用_KEY);
            div.getChkMeisaiForDogetsuShinsa().setSelectedItemsByKey(同月審査用);
        }
        RString 給付区分 = div.getHdnKyuufuKubunn();
        if (同月審査を行う.equals(DbBusinessConfig.get(ConfigNameDBC.過誤取下げ再請求指示_同月審査区分, RDate.getNowDate()))
                && (給付区分_1.equals(給付区分)
                || 給付区分_2.equals(給付区分)
                || 給付区分_3.equals(給付区分))) {
            div.getChkMeisaiForDogetsuShinsa().setVisible(true);
        } else {
            div.getChkMeisaiForDogetsuShinsa().setVisible(false);
        }
    }

    private void set国保連再送付(KaigoKyufuhiKagoMositateTourokuResult result) {
        if (div.getTxtMeisaiSendYM().getValue() == null) {
            div.getKokuhirenSaiSofu().setReadOnly(true);
        } else {
            div.getKokuhirenSaiSofu().setReadOnly(false);
        }
        if (result.get過誤申立情報() != null
                && result.get過誤申立情報().is国保連再送付有フラグ()) {
            List<RString> 国保連再送付 = new ArrayList<>();
            国保連再送付.add(国保連再送付_KEY);
            div.getKokuhirenSaiSofu().setSelectedItemsByKey(国保連再送付);
        }
    }

    private RString set様式(KaigoKyufuhiKagoMositateTourokuResult result) {
        RString 給付区分 = div.getHdnKyuufuKubunn();
        CodeShubetsu コード種別 = CodeShubetsu.EMPTY;
        if (給付区分_1.equals(給付区分)) {
            コード種別 = DBCCodeShubetsu.過誤申立事由_上２桁_様式番号.getコード();
        } else if (給付区分_2.equals(給付区分)) {
            コード種別 = DBCCodeShubetsu.総合事業_経過措置_過誤申立事由_様式_.getコード();
        } else if (給付区分_3.equals(給付区分)) {
            コード種別 = DBCCodeShubetsu.総合事業過誤申立事由_様式.getコード();
        }
        RString コード = result.get様式番号();
        RStringBuilder 様式 = new RStringBuilder();
        if (!RString.isNullOrEmpty(コード)) {
            RString 名称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, コード種別, new Code(コード), FlexibleDate.getNowDate());
            様式.append(コード);
            様式.append(様式洗い出し);
            様式.append(名称);
        }
        return 様式.toRString();
    }
}
