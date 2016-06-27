/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuSetaiShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoShokanIchijiSashitomeKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共同処理用受給者異動連絡票共有子DivのHandler
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public final class KyodoJukyushaIdoRenrakuhyoDivHandler {

    private final KyodoJukyushaIdoRenrakuhyoDiv div;
    private static final RString 新規モード = new RString("新規");
    private static final RString 訂正モード = new RString("訂正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 照会モード = new RString("照会");
    private static final RString 受託あり = new RString("2");
    private static final RString 受託なし = new RString("1");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final List<KeyValueDataSource> 空 = new ArrayList<>();

    private KyodoJukyushaIdoRenrakuhyoDivHandler(KyodoJukyushaIdoRenrakuhyoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return KyodoJukyushaIdoRenrakuhyoDivHandler
     */
    public static KyodoJukyushaIdoRenrakuhyoDivHandler of(KyodoJukyushaIdoRenrakuhyoDiv div) {
        return new KyodoJukyushaIdoRenrakuhyoDivHandler(div);
    }

    /**
     * 初期化設定
     *
     * @param 処理モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     * @param 論理削除 boolean
     * @param 対象年月 FlexibleYearMonth
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam initialize(RString 処理モード, HihokenshaNo 被保険者番号,
            FlexibleDate 異動日, boolean 論理削除, FlexibleYearMonth 対象年月) {
        if (新規モード.equals(処理モード)) {
            div.setMode_DisplayMode(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.shinki);
        } else if (訂正モード.equals(処理モード)) {
            div.setMode_DisplayMode(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei);
        } else if (削除モード.equals(処理モード)) {
            div.setMode_DisplayMode(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.sakujyo);
        } else if (照会モード.equals(処理モード)) {
            div.setMode_DisplayMode(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.shokai);
        }
        init初期値();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.setMode_DisplayMode(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.shokai);
            return null;
        }
        if (Boolean.TRUE.equals(論理削除)) {
            div.setMode_DisplayMode(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.shokai);
        }

        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().getJukyushaIdoJoho(
                処理モード, 論理削除, 異動日, 被保険者番号, 対象年月);
        if (entity != null) {
            div.setHdnKyodoShoriyoJukyushaIdoEntity(DataPassingConverter.serialize(entity));
            div.getTxtHiHokenshaNo().setValue(被保険者番号.value());
            div.getTxtShoKisaiHokenshaNo().setValue(entity.get共通項目Entity().get証記載保険者番号().value());
            if (div.getMode_DisplayMode().equals(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.shinki)) {
                set初期値_新規(entity);
            } else if (div.getMode_DisplayMode().equals(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei)) {
                div.getTxtTaisyoYM().setValue(new RDate(対象年月.toString()));
                set初期値_訂正(entity);
            } else if (div.getMode_DisplayMode().equals(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.sakujyo)) {
                div.getTxtTaisyoYM().setValue(new RDate(対象年月.toString()));
                set初期値_削除(entity);
            } else if (div.getMode_DisplayMode().equals(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.shokai)) {
                div.getTxtTaisyoYM().setValue(new RDate(対象年月.toString()));
                set初期値_照会(entity);
            }
        }
        return entity;
    }

    private void init初期値() {
        List<KeyValueDataSource> 異動事由 = new ArrayList<>();
        異動事由.add(new KeyValueDataSource(JukyushaIF_JukyushaIdoJiyu.受給資格取得.getコード(),
                JukyushaIF_JukyushaIdoJiyu.受給資格取得.get名称()));
        異動事由.add(new KeyValueDataSource(JukyushaIF_JukyushaIdoJiyu.受給資格喪失.getコード(),
                JukyushaIF_JukyushaIdoJiyu.受給資格喪失.get名称()));
        異動事由.add(new KeyValueDataSource(JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.getコード(),
                JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.get名称()));
        異動事由.add(new KeyValueDataSource(JukyushaIF_JukyushaIdoJiyu.合併による新規.getコード(),
                JukyushaIF_JukyushaIdoJiyu.合併による新規.get名称()));
        異動事由.add(new KeyValueDataSource(JukyushaIF_JukyushaIdoJiyu.その他異動.getコード(),
                JukyushaIF_JukyushaIdoJiyu.その他異動.get名称()));
        div.getDdlJukyushaIdoJiyu().setDataSource(異動事由);

        List<KeyValueDataSource> 一時差止区分 = new ArrayList<>();
        一時差止区分.add(new KeyValueDataSource(JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.一部差止.getコード(),
                JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.一部差止.get名称()));
        一時差止区分.add(new KeyValueDataSource(JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.全部差止.getコード(),
                JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.全部差止.get名称()));
        div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getDdlHokenkyufuIchijiSashitomeKubun().setDataSource(一時差止区分);

        List<KeyValueDataSource> 世帯所得区分 = new ArrayList<>();
        世帯所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.一般.getコード(),
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.一般.get表示名称()));
        世帯所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.市町村民税世帯非課税者等.getコード(),
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.市町村民税世帯非課税者等.get表示名称()));
        世帯所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.生活保護.getコード(),
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.生活保護.get表示名称()));
        世帯所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.getコード(),
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.get表示名称()));
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().setDataSource(世帯所得区分);

        List<KeyValueDataSource> 所得区分 = new ArrayList<>();
        所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuShotokuKubunCode.一般.getコード(),
                JukyushaIF_KyodoKogakuShotokuKubunCode.一般.get表示名称()));
        所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuShotokuKubunCode.市町村民税世帯非課税者等.getコード(),
                JukyushaIF_KyodoKogakuShotokuKubunCode.市町村民税世帯非課税者等.get表示名称()));
        所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuShotokuKubunCode.生活保護.getコード(),
                JukyushaIF_KyodoKogakuShotokuKubunCode.生活保護.get表示名称()));
        所得区分.add(new KeyValueDataSource(JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.getコード(),
                JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.get表示名称()));
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().setDataSource(所得区分);
    }

    private void set初期値_新規(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {

        div.getTxtTaisyoYM().setValue(RDate.getNowDate());
        div.getTxtIdoYMD().setValue(RDate.getNowDate());
        div.getRadIdoKubunCode().setSelectedValue(JukyushaIF_IdoKubunCode.新規.get名称());

        div.getDdlJukyushaIdoJiyu().getDataSource().add(0, new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        div.getDdlJukyushaIdoJiyu().setIsBlankLine(true);
        List<KeyValueDataSource> items_基本 = div.getChkKihonSofuAdd().getDataSource();
        div.getChkKihonSofuAdd().setSelectedItems(items_基本);
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtKihonIdoYMD().setValue(RDate.getNowDate());
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtHiHokenshaName().setValue(entity.get基本情報Entity().getHiHokenshaName());
        TelNo telNo = entity.get基本情報Entity().getTelNo();
        if (telNo != null && !telNo.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtTelNo().setValue(telNo.value());
        }
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtYubinNo().setValue(entity.get基本情報Entity().getYubinNo());
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtAddress().setValue(entity.get基本情報Entity().getAddress());
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtAddressKana().setValue(entity.get基本情報Entity().getDdressKana());

        RString config償還 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託あり.equals(config償還)) {
            List<KeyValueDataSource> items_償還 = div.getChkShokanSofuAdd().getDataSource();
            div.getChkShokanSofuAdd().setSelectedItems(items_償還);
        }
        div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanIdoYMD().setValue(RDate.getNowDate());
        div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getDdlHokenkyufuIchijiSashitomeKubun().setIsBlankLine(true);

        RString config高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託あり.equals(config高額)) {
            List<KeyValueDataSource> items_高額 = div.getChkKogakuSofuAdd().getDataSource();
            div.getChkKogakuSofuAdd().setSelectedItems(items_高額);
        }
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuIdoYMD().setValue(RDate.getNowDate());
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().setIsBlankLine(true);
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().setIsBlankLine(true);
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRoureiFukushiNenkinJukyuAriFlag().setSelectedKey(KEY_0);
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRiyoshaFutan2DankaiAriFlag().setSelectedKey(KEY_0);
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRiyoshaFutan2DankaiAriFlag().setSelectedKey(KEY_0);

        setエリア制御();
    }

    private void set初期値_訂正(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {

        if (entity.get基本情報Entity() != null) {
            div.getTxtIdoYMD().setValue(new RDate(entity.get基本情報Entity().getIdoYMD().toString()));
            set基本送付情報エリア(entity);
        } else if (entity.get償還情報Entity() != null) {
            div.getTxtIdoYMD().setValue(new RDate(entity.get償還情報Entity().getIdoYMD().toString()));
            set償還送付情報エリア(entity);
        } else if (entity.get高額情報Entity() != null) {
            div.getTxtIdoYMD().setValue(new RDate(entity.get高額情報Entity().getIdoYMD().toString()));
            set高額送付情報エリア(entity);
        }

        if (JukyushaIF_IdoKubunCode.新規.getコード().equals(entity.get共通項目Entity().get異動区分())) {
            div.getRadIdoKubunCode().setSelectedValue(JukyushaIF_IdoKubunCode.新規.get名称());
        } else if (JukyushaIF_IdoKubunCode.変更.getコード().equals(entity.get共通項目Entity().get異動区分())) {
            div.getRadIdoKubunCode().setSelectedValue(JukyushaIF_IdoKubunCode.変更.get名称());
        }
        if (entity.get共通項目Entity().get異動事由() != null && !entity.get共通項目Entity().get異動事由().isEmpty()) {
            div.getDdlJukyushaIdoJiyu().setSelectedKey(entity.get共通項目Entity().get異動事由());
        }

        if (JukyushaIF_TeiseiKubunCode.修正.get名称().equals(div.getRadTeiseiKubunCode().getSelectedValue())) {
            if (entity.get基本情報Entity() != null) {
                List<KeyValueDataSource> add_基本 = div.getChkKihonSofuAdd().getDataSource();
                div.getChkKihonSofuAdd().setSelectedItems(add_基本);
            } else {
                div.getChkKihonSofuAdd().setDisplayNone(true);
            }
            div.getChkKihonSofuDelete().setDisplayNone(true);

            if (entity.get償還情報Entity() != null) {
                List<KeyValueDataSource> add_償還 = div.getChkShokanSofuAdd().getDataSource();
                div.getChkShokanSofuAdd().setSelectedItems(add_償還);
            } else {
                div.getChkShokanSofuAdd().setDisplayNone(true);
            }
            div.getChkShokanSofuDelete().setDisplayNone(true);

            if (entity.get高額情報Entity() != null) {
                List<KeyValueDataSource> add_高額 = div.getChkKogakuSofuAdd().getDataSource();
                div.getChkKogakuSofuAdd().setSelectedItems(add_高額);
            } else {
                div.getChkKogakuSofuAdd().setDisplayNone(true);
            }
            div.getChkKogakuSofuDelete().setDisplayNone(true);
        } else if (JukyushaIF_TeiseiKubunCode.削除.get名称().equals(div.getRadTeiseiKubunCode().getSelectedValue())) {
            if (entity.get基本情報Entity() != null) {
                List<KeyValueDataSource> delete_基本 = div.getChkKihonSofuDelete().getDataSource();
                div.getChkKihonSofuDelete().setSelectedItems(delete_基本);
            } else {
                div.getChkKihonSofuDelete().setDisplayNone(true);
            }
            div.getChkKihonSofuAdd().setDisplayNone(true);

            if (entity.get償還情報Entity() != null) {
                List<KeyValueDataSource> delete_償還 = div.getChkShokanSofuDelete().getDataSource();
                div.getChkShokanSofuDelete().setSelectedItems(delete_償還);
            } else {
                div.getChkShokanSofuDelete().setDisplayNone(true);
            }
            div.getChkShokanSofuAdd().setDisplayNone(true);

            if (entity.get高額情報Entity() != null) {
                List<KeyValueDataSource> delete_高額 = div.getChkKogakuSofuDelete().getDataSource();
                div.getChkKogakuSofuDelete().setSelectedItems(delete_高額);
            } else {
                div.getChkKogakuSofuDelete().setDisplayNone(true);
            }
            div.getChkKogakuSofuAdd().setDisplayNone(true);
        }
        setエリア制御();
    }

    private void set初期値_削除(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        if (entity.get基本情報Entity() != null) {
            if (entity.get基本情報Entity().getRirekiNo() == 1) {
                div.getTxtTeiseiYMD().setDisplayNone(true);
                div.getRadTeiseiKubunCode().setDisabled(true);
            } else {
                div.getTxtTeiseiYMD().setDisabled(true);
                div.getRadTeiseiKubunCode().setDisplayNone(true);
            }
            set基本送付情報エリア(entity);
        } else if (entity.get償還情報Entity() != null) {
            if (entity.get償還情報Entity().getRirekiNo() == 1) {
                div.getTxtTeiseiYMD().setDisplayNone(true);
                div.getRadTeiseiKubunCode().setDisabled(true);
            } else {
                div.getTxtTeiseiYMD().setDisabled(true);
                div.getRadTeiseiKubunCode().setDisplayNone(true);
            }
            set償還送付情報エリア(entity);
        } else if (entity.get高額情報Entity() != null) {
            if (entity.get高額情報Entity().getRirekiNo() == 1) {
                div.getTxtTeiseiYMD().setDisplayNone(true);
                div.getRadTeiseiKubunCode().setDisabled(true);
            } else {
                div.getTxtTeiseiYMD().setDisabled(true);
                div.getRadTeiseiKubunCode().setDisplayNone(true);
            }
            set高額送付情報エリア(entity);
        }
        setHead(entity);
    }

    private void set初期値_照会(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        setHead(entity);
        if (entity.get基本情報Entity() != null) {
            set基本送付情報エリア(entity);
        } else if (entity.get償還情報Entity() != null) {
            set償還送付情報エリア(entity);
        } else if (entity.get高額情報Entity() != null) {
            set高額送付情報エリア(entity);
        }
    }

    private void setHead(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        if (entity.get基本情報Entity() != null) {
            div.getTxtIdoYMD().setValue(new RDate(entity.get基本情報Entity().getIdoYMD().toString()));
            FlexibleDate 訂正日 = entity.get基本情報Entity().getTeiseiYMD();
            if (訂正日 != null && !訂正日.isEmpty()) {
                div.getTxtTeiseiYMD().setValue(new RDate(訂正日.toString()));
            }
            if (JukyushaIF_TeiseiKubunCode.修正.getコード().equals(entity.get基本情報Entity().getTeiseiKubunCode())) {
                div.getRadTeiseiKubunCode().setSelectedValue(JukyushaIF_TeiseiKubunCode.修正.get名称());
            } else if (JukyushaIF_TeiseiKubunCode.削除.getコード().equals(entity.get基本情報Entity().getTeiseiKubunCode())) {
                div.getRadTeiseiKubunCode().setSelectedValue(JukyushaIF_TeiseiKubunCode.削除.get名称());
            }
        } else if (entity.get償還情報Entity() != null) {
            div.getTxtIdoYMD().setValue(new RDate(entity.get償還情報Entity().getIdoYMD().toString()));
            FlexibleDate 訂正日 = entity.get償還情報Entity().getTeiseiYMD();
            if (訂正日 != null && !訂正日.isEmpty()) {
                div.getTxtTeiseiYMD().setValue(new RDate(訂正日.toString()));
            }
            if (JukyushaIF_TeiseiKubunCode.修正.getコード().equals(entity.get償還情報Entity().getTeiseiKubunCode())) {
                div.getRadTeiseiKubunCode().setSelectedValue(JukyushaIF_TeiseiKubunCode.修正.get名称());
            } else if (JukyushaIF_TeiseiKubunCode.削除.getコード().equals(entity.get償還情報Entity().getTeiseiKubunCode())) {
                div.getRadTeiseiKubunCode().setSelectedValue(JukyushaIF_TeiseiKubunCode.削除.get名称());
            }
        } else if (entity.get高額情報Entity() != null) {
            div.getTxtIdoYMD().setValue(new RDate(entity.get高額情報Entity().getIdoYMD().toString()));
            FlexibleDate 訂正日 = entity.get高額情報Entity().getTeiseiYMD();
            if (訂正日 != null && !訂正日.isEmpty()) {
                div.getTxtTeiseiYMD().setValue(new RDate(訂正日.toString()));
            }
            if (JukyushaIF_TeiseiKubunCode.修正.getコード().equals(entity.get高額情報Entity().getTeiseiKubunCode())) {
                div.getRadTeiseiKubunCode().setSelectedValue(JukyushaIF_TeiseiKubunCode.修正.get名称());
            } else if (JukyushaIF_TeiseiKubunCode.削除.getコード().equals(entity.get高額情報Entity().getTeiseiKubunCode())) {
                div.getRadTeiseiKubunCode().setSelectedValue(JukyushaIF_TeiseiKubunCode.削除.get名称());
            }
        }
        set異動区分と異動事由(entity);
    }

    private void set異動区分と異動事由(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        if (JukyushaIF_IdoKubunCode.新規.getコード().equals(entity.get共通項目Entity().get異動区分())) {
            div.getRadIdoKubunCode().setSelectedValue(JukyushaIF_IdoKubunCode.新規.get名称());
        } else if (JukyushaIF_IdoKubunCode.変更.getコード().equals(entity.get共通項目Entity().get異動区分())) {
            div.getRadIdoKubunCode().setSelectedValue(JukyushaIF_IdoKubunCode.変更.get名称());
        }
        if (entity.get共通項目Entity().get異動事由() != null && !entity.get共通項目Entity().get異動事由().isEmpty()) {
            div.getDdlJukyushaIdoJiyu().setSelectedKey(entity.get共通項目Entity().get異動事由());
        }
    }

    private void set基本送付情報エリア(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        FlexibleDate 異動日 = entity.get基本情報Entity().getIdoYMD();
        if (異動日 != null && !異動日.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtKihonIdoYMD().setValue(new RDate(異動日.toString()));
        }
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtRirekiNo().setValue(new Decimal(
                entity.get基本情報Entity().getRirekiNo()));
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtHiHokenshaName().setValue(
                entity.get基本情報Entity().getHiHokenshaName());
        TelNo telNo = entity.get基本情報Entity().getTelNo();
        if (telNo != null && !telNo.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtTelNo().setValue(telNo.value());
        }
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtChohyoOutputJunjyoCode().setValue(
                entity.get基本情報Entity().getChohyoOutputJunjyoCode());
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtYubinNo().setValue(
                entity.get基本情報Entity().getYubinNo());
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtAddress().setValue(
                entity.get基本情報Entity().getAddress());
        div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtAddressKana().setValue(
                entity.get基本情報Entity().getDdressKana());
    }

    private void set償還送付情報エリア(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        FlexibleDate 異動日 = entity.get償還情報Entity().getIdoYMD();
        if (異動日 != null && !異動日.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanIdoYMD().setValue(new RDate(異動日.toString()));
        }
        div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanRirekiNo().setValue(new Decimal(
                entity.get償還情報Entity().getRirekiNo()));
        FlexibleDate 一時差止開始日 = entity.get償還情報Entity().getHokenKyufuIchijiSashitomeKaishiYMD();
        if (一時差止開始日 != null && !一時差止開始日.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().
                    setFromValue(new RDate(一時差止開始日.toString()));
        }
        FlexibleDate 一時差止終了日 = entity.get償還情報Entity().getHokenKyufuIchijiSashitomeShuryoYMD();
        if (一時差止終了日 != null && !一時差止終了日.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().
                    setToValue(new RDate(一時差止終了日.toString()));
        }
        div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getDdlHokenkyufuIchijiSashitomeKubun().
                setSelectedKey(entity.get償還情報Entity().getHokenkyufuIchijiSashitomeKubunCode());
        div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenkyufuIchijiSashitomeKingaku().
                setValue(entity.get償還情報Entity().getHokenkyufuIchijiSashitomeKingaku());
    }

    private void set高額送付情報エリア(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        FlexibleDate 異動日 = entity.get高額情報Entity().getIdoYMD();
        if (異動日 != null && !異動日.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuIdoYMD().setValue(new RDate(異動日.toString()));
        }
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuRirekiNo().setValue(new Decimal(
                entity.get高額情報Entity().getRirekiNo()));
        div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuRirekiNo().setValue(new Decimal(
                entity.get高額情報Entity().getRirekiNo()));
        HihokenshaNo 世帯集約番号 = entity.get高額情報Entity().getSetaiShuyakuNo();
        if (世帯集約番号 != null && !世帯集約番号.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtSetaiShuyakuNo().setValue(世帯集約番号.value());
        }
        RString 世帯所得区分 = entity.get高額情報Entity().getSetaiShotokuKubunCode();
        if (世帯所得区分 != null && !世帯所得区分.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().setSelectedKey(世帯所得区分);
        }
        RString 所得区分 = entity.get高額情報Entity().getShotokuKubunCode();
        if (所得区分 != null && !所得区分.isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().setSelectedKey(所得区分);
        }
        if (entity.get高額情報Entity().getRoureiFukushiNenkinJukyuAriFlag()) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRoureiFukushiNenkinJukyuAriFlag().setSelectedKey(KEY_1);
        } else {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRoureiFukushiNenkinJukyuAriFlag().setSelectedKey(KEY_0);
        }
        if (entity.get高額情報Entity().getRiyoshaFutan2DankaiAriFlag()) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRiyoshaFutan2DankaiAriFlag().setSelectedKey(KEY_1);
        } else {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadRiyoshaFutan2DankaiAriFlag().setSelectedKey(KEY_0);
        }
        if (Boolean.TRUE.equals(entity.get高額情報Entity().getShikyuShinseishoOutputAriFlag())) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadShikyuShinseishoOutputAriFlag().setSelectedKey(KEY_0);
        } else if (Boolean.FALSE.equals(entity.get高額情報Entity().getShikyuShinseishoOutputAriFlag())) {
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getRadShikyuShinseishoOutputAriFlag().setSelectedKey(KEY_1);
        }
    }

    /**
     * エリア制御
     */
    public void setエリア制御() {
        if (div.getChkKihonSofuAdd().getSelectedItems().isEmpty()) {
            div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().setDisabled(true);
        } else {
            div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().setDisabled(false);
        }
        RString config償還 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託なし.equals(config償還)) {
            div.getChkShokanSofuAdd().setDisabled(true);
            div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().setDisabled(true);
        } else {
            if (div.getChkShokanSofuAdd().getSelectedItems().isEmpty()) {
                div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().setDisabled(true);
            } else {
                div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().setDisabled(false);
            }
        }

        RString config高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (受託なし.equals(config高額)) {
            div.getChkKogakuSofuAdd().setDisabled(true);
            div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().setDisabled(true);
        } else {
            if (div.getChkKogakuSofuAdd().getSelectedItems().isEmpty()) {
                div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().setDisabled(true);
            } else {
                div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().setDisabled(false);
            }
        }
    }

    /**
     * 最新データ取得
     *
     * @return KyodoshoriyoJukyushaIdoRenrakuhyoParam
     */
    public KyodoshoriyoJukyushaIdoRenrakuhyoParam getNewデータ() {
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = DataPassingConverter.deserialize(
                div.getHdnKyodoShoriyoJukyushaIdoEntity(), KyodoshoriyoJukyushaIdoRenrakuhyoParam.class);
        if (entity == null) {
            return null;
        }
        entity.get共通項目Entity().set被保険者番号(new HihokenshaNo(div.getTxtHiHokenshaNo().getValue()));
        entity.get共通項目Entity().set異動年月日(new FlexibleDate(div.getTxtIdoYMD().getValue().toDateString()));
        entity.get共通項目Entity().set証記載保険者番号(new ShoKisaiHokenshaNo(div.getTxtShoKisaiHokenshaNo().getValue()));
        if (JukyushaIF_IdoKubunCode.新規.get名称().equals(div.getRadIdoKubunCode().getSelectedValue())) {
            entity.get共通項目Entity().set異動区分(JukyushaIF_IdoKubunCode.新規.getコード());
        } else if (JukyushaIF_IdoKubunCode.変更.get名称().equals(div.getRadIdoKubunCode().getSelectedValue())) {
            entity.get共通項目Entity().set異動区分(JukyushaIF_IdoKubunCode.変更.getコード());
        }

        if (div.getDdlJukyushaIdoJiyu().getSelectedValue().equals(RString.EMPTY)) {
            entity.get共通項目Entity().set異動事由(null);
        } else if (div.getDdlJukyushaIdoJiyu().getSelectedValue().equals(JukyushaIF_JukyushaIdoJiyu.受給資格取得.get名称())) {
            entity.get共通項目Entity().set異動事由(JukyushaIF_JukyushaIdoJiyu.受給資格取得.getコード());
        } else if (div.getDdlJukyushaIdoJiyu().getSelectedValue().equals(JukyushaIF_JukyushaIdoJiyu.受給資格喪失.get名称())) {
            entity.get共通項目Entity().set異動事由(JukyushaIF_JukyushaIdoJiyu.受給資格喪失.getコード());
        } else if (div.getDdlJukyushaIdoJiyu().getSelectedValue().equals(JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.get名称())) {
            entity.get共通項目Entity().set異動事由(JukyushaIF_JukyushaIdoJiyu.広域連合における受給者の市町村間転居異動.getコード());
        } else if (div.getDdlJukyushaIdoJiyu().getSelectedValue().equals(JukyushaIF_JukyushaIdoJiyu.合併による新規.get名称())) {
            entity.get共通項目Entity().set異動事由(JukyushaIF_JukyushaIdoJiyu.合併による新規.getコード());
        } else if (div.getDdlJukyushaIdoJiyu().getSelectedValue().equals(JukyushaIF_JukyushaIdoJiyu.その他異動.get名称())) {
            entity.get共通項目Entity().set異動事由(JukyushaIF_JukyushaIdoJiyu.その他異動.getコード());
        }

        if (entity.get基本情報Entity() != null) {
            entity = getデータ_基本送付情報(entity);
        }
        if (entity.get償還情報Entity() != null) {
            entity = getデータ_償還送付情報(entity);
        }
        if (entity.get高額情報Entity() != null) {
            entity = getデータ_高額送付情報(entity);
        }
        return entity;
    }

    private KyodoshoriyoJukyushaIdoRenrakuhyoParam getデータ_基本送付情報(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        if (div.getTxtTeiseiYMD().getValue() != null) {
            entity.get基本情報Entity().setTeiseiYMD(new FlexibleDate(div.getTxtTeiseiYMD().getValue().toDateString()));
        }

        if (JukyushaIF_TeiseiKubunCode.修正.get名称().equals(div.getRadTeiseiKubunCode().getSelectedValue())) {
            entity.get基本情報Entity().setTeiseiKubunCode(JukyushaIF_TeiseiKubunCode.修正.getコード());
        } else if (JukyushaIF_TeiseiKubunCode.削除.get名称().equals(div.getRadTeiseiKubunCode().getSelectedValue())) {
            entity.get基本情報Entity().setTeiseiKubunCode(JukyushaIF_TeiseiKubunCode.削除.getコード());
        }

        if (div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtKihonIdoYMD().getValue() != null) {
            entity.get基本情報Entity().setIdoYMD(new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().
                    getTxtKihonIdoYMD().getValue().toDateString()));
        }

        entity.get基本情報Entity().setHiHokenshaName(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().
                getTxtHiHokenshaName().getValue());
        entity.get基本情報Entity().setTelNo(new TelNo(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().
                getTxtTelNo().getValue()));
        entity.get基本情報Entity().setChohyoOutputJunjyoCode(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().
                getTxtChohyoOutputJunjyoCode().getValue());
        entity.get基本情報Entity().setYubinNo(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtYubinNo().getValue());
        entity.get基本情報Entity().setAddress(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtAddress().getValue());
        entity.get基本情報Entity().setDdressKana(div.getKyodoJukyushaIdoRenrakuhyoKihonPanel().getTxtAddressKana().getValue());
        return entity;
    }

    private KyodoshoriyoJukyushaIdoRenrakuhyoParam getデータ_償還送付情報(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        if (div.getTxtTeiseiYMD().getValue() != null) {
            entity.get償還情報Entity().setTeiseiYMD(new FlexibleDate(div.getTxtTeiseiYMD().getValue().toDateString()));
        }

        if (JukyushaIF_TeiseiKubunCode.修正.get名称().equals(div.getRadTeiseiKubunCode().getSelectedValue())) {
            entity.get償還情報Entity().setTeiseiKubunCode(JukyushaIF_TeiseiKubunCode.修正.getコード());
        } else if (JukyushaIF_TeiseiKubunCode.削除.get名称().equals(div.getRadTeiseiKubunCode().getSelectedValue())) {
            entity.get償還情報Entity().setTeiseiKubunCode(JukyushaIF_TeiseiKubunCode.削除.getコード());
        }

        if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtShokanIdoYMD().getValue() != null) {
            entity.get償還情報Entity().setIdoYMD(new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().
                    getTxtShokanIdoYMD().getValue().toDateString()));
        }
        if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getFromValue() != null) {
            entity.get償還情報Entity().setIdoYMD(new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().
                    getTxtHokenKyufuIchijiSashitomeYMD().getFromValue().toDateString()));
        }
        if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenKyufuIchijiSashitomeYMD().getToValue() != null) {
            entity.get償還情報Entity().setIdoYMD(new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().
                    getTxtHokenKyufuIchijiSashitomeYMD().getToValue().toDateString()));
        }
        if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getDdlHokenkyufuIchijiSashitomeKubun().getSelectedValue().equals(RString.EMPTY)) {
            entity.get償還情報Entity().setHokenkyufuIchijiSashitomeKubunCode(null);
        } else if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getDdlHokenkyufuIchijiSashitomeKubun().getSelectedValue().equals(
                JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.一部差止.get名称())) {
            entity.get償還情報Entity().setHokenkyufuIchijiSashitomeKubunCode(
                    JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.一部差止.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoShokanPanel().getDdlHokenkyufuIchijiSashitomeKubun().getSelectedValue().equals(
                JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.全部差止.get名称())) {
            entity.get償還情報Entity().setHokenkyufuIchijiSashitomeKubunCode(
                    JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.全部差止.getコード());
        }
        entity.get償還情報Entity().setHokenkyufuIchijiSashitomeKingaku(div.
                getKyodoJukyushaIdoRenrakuhyoShokanPanel().getTxtHokenkyufuIchijiSashitomeKingaku().getValue());
        return entity;
    }

    private KyodoshoriyoJukyushaIdoRenrakuhyoParam getデータ_高額送付情報(KyodoshoriyoJukyushaIdoRenrakuhyoParam entity) {
        if (div.getTxtTeiseiYMD().getValue() != null) {
            entity.get高額情報Entity().setTeiseiYMD(new FlexibleDate(div.getTxtTeiseiYMD().getValue().toDateString()));
        }

        if (div.getRadTeiseiKubunCode().getSelectedValue().equals(JukyushaIF_TeiseiKubunCode.修正.get名称())) {
            entity.get高額情報Entity().setTeiseiKubunCode(JukyushaIF_TeiseiKubunCode.修正.getコード());
        } else if (div.getRadTeiseiKubunCode().getSelectedValue().equals(JukyushaIF_TeiseiKubunCode.削除.get名称())) {
            entity.get高額情報Entity().setTeiseiKubunCode(JukyushaIF_TeiseiKubunCode.削除.getコード());
        }

        if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getTxtKogakuIdoYMD().getValue() != null) {
            entity.get高額情報Entity().setIdoYMD(new FlexibleDate(div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().
                    getTxtKogakuIdoYMD().getValue().toDateString()));
        }
        entity.get高額情報Entity().setSetaiShuyakuNo(new HihokenshaNo(div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().
                getTxtSetaiShuyakuNo().getValue()));
        if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().getSelectedValue().equals(RString.EMPTY)) {
            entity.get高額情報Entity().setSetaiShotokuKubunCode(null);
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.一般.get表示名称())) {
            entity.get高額情報Entity().setSetaiShotokuKubunCode(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.一般.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.市町村民税世帯非課税者等.get表示名称())) {
            entity.get高額情報Entity().setSetaiShotokuKubunCode(
                    JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.市町村民税世帯非課税者等.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.get表示名称())) {
            entity.get高額情報Entity().setSetaiShotokuKubunCode(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.現役並み所得相当.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlSetaiShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.生活保護.get表示名称())) {
            entity.get高額情報Entity().setSetaiShotokuKubunCode(JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.生活保護.getコード());
        }

        if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().getSelectedValue().equals(RString.EMPTY)) {
            entity.get高額情報Entity().setShotokuKubunCode(null);
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuShotokuKubunCode.一般.get表示名称())) {
            entity.get高額情報Entity().setShotokuKubunCode(JukyushaIF_KyodoKogakuShotokuKubunCode.一般.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuShotokuKubunCode.市町村民税世帯非課税者等.get表示名称())) {
            entity.get高額情報Entity().setShotokuKubunCode(
                    JukyushaIF_KyodoKogakuShotokuKubunCode.市町村民税世帯非課税者等.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.get表示名称())) {
            entity.get高額情報Entity().setShotokuKubunCode(JukyushaIF_KyodoKogakuShotokuKubunCode.現役並み所得相当.getコード());
        } else if (div.getKyodoJukyushaIdoRenrakuhyoKogakuPanel().getDdlShotokuKubun().getSelectedValue().equals(
                JukyushaIF_KyodoKogakuShotokuKubunCode.生活保護.get表示名称())) {
            entity.get高額情報Entity().setShotokuKubunCode(JukyushaIF_KyodoKogakuShotokuKubunCode.生活保護.getコード());
        }

        if (div.getRadRoureiFukushiNenkinJukyuAriFlag().getSelectedKey().equals(KEY_0)) {
            entity.get高額情報Entity().setRoureiFukushiNenkinJukyuAriFlag(false);
        } else if (div.getRadRoureiFukushiNenkinJukyuAriFlag().getSelectedKey().equals(KEY_1)) {
            entity.get高額情報Entity().setRoureiFukushiNenkinJukyuAriFlag(true);
        }

        if (div.getRadRiyoshaFutan2DankaiAriFlag().getSelectedKey().equals(KEY_0)) {
            entity.get高額情報Entity().setRiyoshaFutan2DankaiAriFlag(false);
        } else if (div.getRadRiyoshaFutan2DankaiAriFlag().getSelectedKey().equals(KEY_1)) {
            entity.get高額情報Entity().setRiyoshaFutan2DankaiAriFlag(true);
        }
        boolean flag = div.getRadShikyuShinseishoOutputAriFlag().getSelectedKey().equals(KEY_0);
        entity.get高額情報Entity().setShikyuShinseishoOutputAriFlag(flag);
        return entity;
    }

    /**
     * 訂正区分変更の設定
     */
    public void setChange() {
        if (!div.getMode_DisplayMode().equals(KyodoJukyushaIdoRenrakuhyoDiv.DisplayMode.teisei)) {
            return;
        }
        KyodoshoriyoJukyushaIdoRenrakuhyoParam entity = DataPassingConverter.deserialize(
                div.getHdnKyodoShoriyoJukyushaIdoEntity(), KyodoshoriyoJukyushaIdoRenrakuhyoParam.class);
        if (div.getRadTeiseiKubunCode().getSelectedValue().equals(JukyushaIF_TeiseiKubunCode.修正.get名称())) {
            div.getChkKihonSofuAdd().setDisabled(false);
            div.getChkKihonSofuAdd().setDisplayNone(false);
            div.getChkShokanSofuAdd().setDisabled(false);
            div.getChkShokanSofuAdd().setDisplayNone(false);
            div.getChkKogakuSofuAdd().setDisabled(false);
            div.getChkKogakuSofuAdd().setDisplayNone(false);

            if (entity.get基本情報Entity() != null) {
                List<KeyValueDataSource> add_基本 = div.getChkKihonSofuAdd().getDataSource();
                div.getChkKihonSofuAdd().setSelectedItems(add_基本);
            } else {
                div.getChkKihonSofuAdd().setDisplayNone(true);
            }
            if (entity.get償還情報Entity() != null) {
                List<KeyValueDataSource> add_償還 = div.getChkShokanSofuAdd().getDataSource();
                div.getChkShokanSofuAdd().setSelectedItems(add_償還);
            } else {
                div.getChkShokanSofuAdd().setDisplayNone(true);
            }
            if (entity.get高額情報Entity() != null) {
                List<KeyValueDataSource> add_高額 = div.getChkKogakuSofuAdd().getDataSource();
                div.getChkKogakuSofuAdd().setSelectedItems(add_高額);
            } else {
                div.getChkKogakuSofuAdd().setDisplayNone(true);
            }
            div.getChkKihonSofuDelete().setSelectedItems(空);
            div.getChkShokanSofuDelete().setSelectedItems(空);
            div.getChkKogakuSofuDelete().setSelectedItems(空);
            div.getChkKihonSofuDelete().setDisplayNone(true);
            div.getChkShokanSofuDelete().setDisplayNone(true);
            div.getChkKogakuSofuDelete().setDisplayNone(true);
        } else if (div.getRadTeiseiKubunCode().getSelectedValue().equals(JukyushaIF_TeiseiKubunCode.削除.get名称())) {
            div.getChkKihonSofuDelete().setDisabled(false);
            div.getChkKihonSofuDelete().setDisplayNone(false);
            div.getChkShokanSofuDelete().setDisabled(false);
            div.getChkShokanSofuDelete().setDisplayNone(false);
            div.getChkKogakuSofuDelete().setDisabled(false);
            div.getChkKogakuSofuDelete().setDisplayNone(false);

            if (entity.get基本情報Entity() != null) {
                List<KeyValueDataSource> delete_基本 = div.getChkKihonSofuDelete().getDataSource();
                div.getChkKihonSofuDelete().setSelectedItems(delete_基本);
            } else {
                div.getChkKihonSofuDelete().setDisplayNone(true);
            }
            if (entity.get償還情報Entity() != null) {
                List<KeyValueDataSource> delete_償還 = div.getChkShokanSofuDelete().getDataSource();
                div.getChkShokanSofuDelete().setSelectedItems(delete_償還);
            } else {
                div.getChkShokanSofuDelete().setDisplayNone(true);
            }
            if (entity.get高額情報Entity() != null) {
                List<KeyValueDataSource> delete_高額 = div.getChkKogakuSofuDelete().getDataSource();
                div.getChkKogakuSofuDelete().setSelectedItems(delete_高額);
            } else {
                div.getChkKogakuSofuDelete().setDisplayNone(true);
            }

            div.getChkKihonSofuAdd().setSelectedItems(空);
            div.getChkShokanSofuAdd().setSelectedItems(空);
            div.getChkKogakuSofuAdd().setSelectedItems(空);
            div.getChkKihonSofuAdd().setDisplayNone(true);
            div.getChkShokanSofuAdd().setDisplayNone(true);
            div.getChkKogakuSofuAdd().setDisplayNone(true);
        }
        setエリア制御();
    }

    /**
     * 一時差止日の入力チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一時差止日の入力チェック() {
        return getValidationHandler(div).一時差止日の入力チェック();
    }

    /**
     * 一時差止日の関連チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 一時差止日の関連チェック() {
        return getValidationHandler(div).一時差止日の関連チェック();
    }

    private KyodoJukyushaIdoRenrakuhyoDivValidationHandler getValidationHandler(KyodoJukyushaIdoRenrakuhyoDiv div) {
        return new KyodoJukyushaIdoRenrakuhyoDivValidationHandler(div);
    }
}
