/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1211011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC040050.DBC040050_KogakugassanShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanShomeisho_Insho;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.SofuTorikomiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011.KogakuGassanShikyuKetteiTsuchishoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.YmdKubun;

/**
 * 画面設計_DBCMN63004_高額合算支給決定通知書（一括）のハンドラクラスです。
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public class KogakuGassanShikyuKetteiTsuchishoHandler {

    private final KogakuGassanShikyuKetteiTsuchishoDiv div;
    private static final ReportId 高額合算決定通知書 = new ReportId("DBC100053_GassanKetteiTsuchisho");
    private static final RString 前回対象年月 = new RString("前回対象年月");
    private static final RString 前回対象日 = new RString("前回対象日");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString NUM_0001 = new RString("0001");
    private static final RString NUM_0002 = new RString("0002");
    private static final RString NUM_0003 = new RString("0003");
    private FlexibleYearMonth 最新受取年月;
    private FlexibleYearMonth 前回受取年月;
    private FlexibleDate 前回申請年月開始;
    private FlexibleDate 前回申請年月終了;
    private FlexibleDate 前回決定年月開始;
    private FlexibleDate 前回決定年月終了;
    private LasdecCode 市町村コード;
    private static final RString NUM_0 = new RString("0");
    private static final RString NUM_1 = new RString("1");
    private static final RString NUM_2 = new RString("2");
    private static final RString NUM_3 = new RString("3");
    private static final RString 項目名 = new RString("支払予定日印字有無");

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     */
    public KogakuGassanShikyuKetteiTsuchishoHandler(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanShikyuKetteiTsuchishoDiv
     * @return ハンドラ
     */
    public static KogakuGassanShikyuKetteiTsuchishoHandler of(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        return new KogakuGassanShikyuKetteiTsuchishoHandler(div);
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void initialize() {
        作成条件受取年月();
        div.getRadKetteibiIkkatsuKoshinKBN().setSelectedKey(KEY_0);
        決定日一括更新区分();
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, 高額合算決定通知書);
        RString 支払予定日印字有無 = get支払予定日印字有無();
        List<KeyValueDataSource> list = new ArrayList<>();
        KeyValueDataSource 単票発行済を除く = new KeyValueDataSource(KaigoGassan_JikoFutanShomeisho_Insho.単票発行済を除く.getコード(),
                KaigoGassan_JikoFutanShomeisho_Insho.単票発行済を除く.get名称());
        KeyValueDataSource 単票発行済も含める = new KeyValueDataSource(KaigoGassan_JikoFutanShomeisho_Insho.単票発行済も含める.getコード(),
                KaigoGassan_JikoFutanShomeisho_Insho.単票発行済も含める.get名称());
        KeyValueDataSource 未発行分のみ = new KeyValueDataSource(KaigoGassan_JikoFutanShomeisho_Insho.未発行分のみ.getコード(),
                KaigoGassan_JikoFutanShomeisho_Insho.未発行分のみ.get名称());
        list.add(単票発行済を除く);
        list.add(単票発行済も含める);
        list.add(未発行分のみ);
        div.getDdlInsho().setDataSource(list);
        div.getDdlInsho().setSelectedKey(KaigoGassan_JikoFutanShomeisho_Insho.単票発行済を除く.getコード());
        if (支払予定日印字有無.equals(NUM_0)) {
            div.getTxtShiharaiYoteiYMD().setDisplayNone(true);
        }
        if (支払予定日印字有無.equals(NUM_1)) {
            div.getTxtShiharaiYoteiYMD().setVisible(true);
        }
        RDate 基準日 = RDate.getNowDate();
        div.getTxtHakkoYMD().setValue(基準日);
    }

    /**
     * 処理日付管理取得のメソッドます。
     *
     */
    public void 処理日付管理取得() {
        RDate 基準日 = RDate.getNowDate();
        RString 交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号,
                基準日, SubGyomuCode.DBC介護給付);
        RString 送付取込区分 = SofuTorikomiKubun.取込.getコード();
        RString 処理状態区分 = ShoriJotaiKubun.終了.getコード();
        KokuhorenInterfaceKanri 国保連インターフェース管理 = new KokuhorenInterfaceKanriManager().get最新の処理年月(
                交換情報識別番号, 送付取込区分, 処理状態区分);
        if (!(国保連インターフェース管理 == null)) {
            最新受取年月 = 国保連インターフェース管理.get処理年月();
        }
        市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        RString 処理名 = ShoriName.高額合算支給決定通知書_一括.get名称();
        RString 処理枝番 = NUM_0001;
        ShoriDateKanri 処理日付管理マスタ = new ShoriDateKanriManager().get処理日付管理マスタ(SubGyomuCode.DBC介護給付,
                市町村コード, 処理名, 処理枝番);
        if (!(処理日付管理マスタ == null)) {
            前回受取年月 = 処理日付管理マスタ.get対象開始年月日().getYearMonth();
        }
        処理枝番 = NUM_0002;
        処理日付管理マスタ = new ShoriDateKanriManager().get処理日付管理マスタ(SubGyomuCode.DBC介護給付, 市町村コード,
                処理名, 処理枝番);
        if (!(処理日付管理マスタ == null)) {
            前回申請年月開始 = 処理日付管理マスタ.get対象開始年月日();
            前回申請年月終了 = 処理日付管理マスタ.get対象終了年月日();
        }
        処理枝番 = NUM_0003;
        処理日付管理マスタ = new ShoriDateKanriManager().get処理日付管理マスタ(SubGyomuCode.DBC介護給付, 市町村コード,
                処理名, 処理枝番);
        if (!(処理日付管理マスタ == null)) {
            前回決定年月開始 = 処理日付管理マスタ.get対象開始年月日();
            前回決定年月終了 = 処理日付管理マスタ.get対象終了年月日();
        }
    }

    /**
     * 作成条件受取年月のメソッドです。
     *
     */
    public void 作成条件受取年月() {
        処理日付管理取得();
        div.getTxtKetteiYMD().clearFromValue();
        div.getTxtKetteiYMD().clearToValue();
        div.getTxtShinseiYMD().clearFromValue();
        div.getTxtShinseiYMD().clearToValue();
        div.getRadUketoriYM().setRequired(true);
        div.getRadKetteiYMD().setRequired(false);
        div.getRadShinseiYMD().setRequired(false);
        div.getLblZenkaiHizuke().setText(前回対象年月);
        div.getTxtUketoriYM().setVisible(true);
        div.getTxtZenkaiKaishiYMD().clearValue();
        div.getTxtZenkaiShuryoYMD().clearValue();
        div.getTxtZenkaiKaishiYMD().setYmdKubunEnum(YmdKubun.年月);
        if (!(前回受取年月 == null || 前回受取年月.isEmpty())) {
            div.getTxtZenkaiKaishiYMD().setValue(new RDate(前回受取年月.toString()));
        }
        div.getLblKara().setVisible(false);
        div.getTxtZenkaiShuryoYMD().setVisible(false);
        div.getRadUketoriYM().setSelectedKey(KEY_0);
        div.getTxtUketoriYM().setDisabled(false);
        div.getTxtUketoriYM().setYmdKubunEnum(YmdKubun.年月);
        if (!(最新受取年月 == null || 最新受取年月.isEmpty())) {
            div.getTxtUketoriYM().setValue(new RDate(最新受取年月.toString()));
        }
        div.getTxtKetteiYMD().setDisabled(true);
        div.getTxtShinseiYMD().setDisabled(true);
    }

    /**
     * 作成条件申請年月日のメソッドです。
     *
     */
    public void 作成条件申請年月日() {
        処理日付管理取得();
        div.getTxtKetteiYMD().clearFromValue();
        div.getTxtKetteiYMD().clearToValue();
        div.getTxtUketoriYM().clearValue();
        div.getRadUketoriYM().setRequired(false);
        div.getRadKetteiYMD().setRequired(false);
        div.getRadShinseiYMD().setRequired(true);
        div.getLblZenkaiHizuke().setText(前回対象日);
        div.getTxtZenkaiKaishiYMD().setYmdKubunEnum(YmdKubun.年月日);
        div.getTxtZenkaiKaishiYMD().clearValue();
        div.getTxtZenkaiShuryoYMD().clearValue();
        if (前回申請年月開始 == null || 前回申請年月開始.isEmpty()) {
            div.getTxtZenkaiKaishiYMD().setValue(null);
        } else {
            div.getTxtZenkaiKaishiYMD().setValue(new RDate(前回申請年月開始.toString()));
        }
        div.getLblKara().setVisible(true);
        div.getTxtZenkaiShuryoYMD().setVisible(true);
        if (前回申請年月終了 == null || 前回申請年月終了.isEmpty()) {
            div.getTxtZenkaiShuryoYMD().setValue(null);
        } else {
            div.getTxtZenkaiShuryoYMD().setValue(new RDate(前回申請年月終了.toString()));
        }
        div.getTxtUketoriYM().setDisabled(true);
        div.getTxtShinseiYMD().setDisabled(false);
        if (前回申請年月開始 == null || 前回申請年月開始.isEmpty()) {
            div.getTxtShinseiYMD().setFromValue(null);
        } else {
            div.getTxtShinseiYMD().setFromValue(new RDate(前回申請年月開始.toString()).plusDay(1));
        }
        RDate システム日付 = RDate.getNowDate();
        div.getTxtShinseiYMD().setToValue(システム日付);
        div.getRadShinseiYMD().setSelectedKey(KEY_0);
        div.getTxtKetteiYMD().setDisabled(true);
    }

    /**
     * 作成条件決定年月日のメソッドです。
     *
     */
    public void 作成条件決定年月日() {
        処理日付管理取得();
        div.getTxtUketoriYM().clearValue();
        div.getTxtShinseiYMD().clearFromValue();
        div.getTxtShinseiYMD().clearToValue();
        div.getRadUketoriYM().setRequired(false);
        div.getRadKetteiYMD().setRequired(true);
        div.getRadShinseiYMD().setRequired(false);
        div.getLblZenkaiHizuke().setText(前回対象日);
        div.getTxtZenkaiKaishiYMD().clearValue();
        div.getTxtZenkaiShuryoYMD().clearValue();
        div.getTxtZenkaiKaishiYMD().setYmdKubunEnum(YmdKubun.年月日);
        if (前回決定年月開始 == null || 前回決定年月開始.isEmpty()) {
            div.getTxtZenkaiKaishiYMD().setValue(null);
        } else {
            div.getTxtZenkaiKaishiYMD().setValue(new RDate(前回決定年月開始.toString()));
        }
        div.getLblKara().setVisible(true);
        div.getTxtZenkaiShuryoYMD().setVisible(true);
        if (前回決定年月終了 == null || 前回決定年月終了.isEmpty()) {
            div.getTxtZenkaiShuryoYMD().setValue(null);
        } else {
            div.getTxtZenkaiShuryoYMD().setValue(new RDate(前回決定年月終了.toString()));
        }
        div.getTxtUketoriYM().setDisabled(true);
        div.getTxtShinseiYMD().setDisabled(true);
        div.getTxtKetteiYMD().setDisabled(false);
        div.getRadKetteiYMD().setSelectedKey(KEY_0);
        if (前回決定年月開始 == null || 前回決定年月開始.isEmpty()) {
            div.getTxtKetteiYMD().setFromValue(null);
        } else {
            div.getTxtKetteiYMD().setFromValue(new RDate(前回決定年月開始.toString()).plusDay(1));
        }
        RDate システム日付 = RDate.getNowDate();
        div.getTxtKetteiYMD().setToValue(システム日付);
    }

    /**
     * 決定日一括更新区分のメソッドです。
     *
     */
    public void 決定日一括更新区分() {
        if (div.getRadKetteibiIkkatsuKoshinKBN().getSelectedKey().equals(KEY_0)) {
            div.getTxtKetteiymd().clearValue();
            div.getTxtKetteiymd().setVisible(false);
        } else if (div.getRadKetteibiIkkatsuKoshinKBN().getSelectedKey().equals(KEY_1)) {
            div.getTxtKetteiymd().clearValue();
            div.getTxtKetteiymd().setVisible(true);
        }

    }

    /**
     * getバッチのメソッドです。
     *
     * @return ResponseData
     * DBC040050_KogakugassanShikyuKetteitsuchishoBatchParameter
     */
    public DBC040050_KogakugassanShikyuKetteitsuchishoParameter setバッチ() {
        DBC040050_KogakugassanShikyuKetteitsuchishoParameter parameter = new DBC040050_KogakugassanShikyuKetteitsuchishoParameter();
        RDate 受取年月 = div.getTxtUketoriYM().getValue();
        RDate 申請開始年月日 = div.getTxtShinseiYMD().getFromValue();
        RDate 申請終了年月日 = div.getTxtShinseiYMD().getToValue();
        RDate 決定開始年月日 = div.getTxtKetteiYMD().getFromValue();
        RDate 決定終了年月日 = div.getTxtKetteiYMD().getToValue();
        RString 印書 = div.getDdlInsho().getSelectedKey();
        Long 出力順 = div.getCcdChohyoShutsuryokujun().get出力順ID();
        RDate 発行日 = div.getTxtHakkoYMD().getValue();
        RDate 支払予定日 = div.getTxtShiharaiYoteiYMD().getValue();
        RDate 決定日 = div.getTxtKetteiymd().getValue();
        RString 文書番号 = div.getCcdBunshoBangoInput().get文書番号();
        YMDHMS 処理日時 = YMDHMS.now();
        if (div.getRadUketoriYM().getSelectedKey().equals(KEY_0)) {
            parameter.set日付選択区分(NUM_1);
        }
        if (div.getRadShinseiYMD().getSelectedKey().equals(KEY_0)) {
            parameter.set日付選択区分(NUM_2);
        }
        if (div.getRadKetteiYMD().getSelectedKey().equals(KEY_0)) {
            parameter.set日付選択区分(NUM_3);
        }
        if (受取年月 != null) {
            parameter.set受取年月(new FlexibleDate(受取年月.toString()).getYearMonth());
        }
        if (申請開始年月日 == null) {
            parameter.set申請開始年月日(FlexibleDate.MIN);
        } else {
            parameter.set申請開始年月日(new FlexibleDate(申請開始年月日.toString()));
        }
        if (申請終了年月日 != null) {
            parameter.set申請終了年月日(new FlexibleDate(申請終了年月日.toString()));
        }
        if (決定開始年月日 == null) {
            parameter.set決定開始年月日(FlexibleDate.MIN);
        } else {
            parameter.set決定開始年月日(new FlexibleDate(決定開始年月日.toString()));
        }
        if (決定終了年月日 != null) {
            parameter.set決定終了年月日(new FlexibleDate(決定終了年月日.toString()));
        }
        parameter.set印書区分(印書);
        if (出力順 != null) {
            parameter.set改頁出力順ID(new RString(出力順.toString()));
        }
        if (発行日 != null) {
            parameter.set発行日(new FlexibleDate(発行日.toString()));
        }
        parameter.set支払予定日印字有無(get支払予定日印字有無());
        if (支払予定日 != null) {
            parameter.set支払予定日(new FlexibleDate(支払予定日.toString()));
        }
        if (div.getRadKetteibiIkkatsuKoshinKBN().getSelectedKey().equals(KEY_0)) {
            parameter.set決定日一括更新区分(NUM_0);
        } else if (div.getRadKetteibiIkkatsuKoshinKBN().getSelectedKey().equals(KEY_1)) {
            parameter.set決定日一括更新区分(NUM_1);
        }
        if (決定日 != null) {
            parameter.set決定日(new FlexibleDate(決定日.toString()));
        }
        parameter.set文書番号(文書番号);
        parameter.set処理日時(処理日時);
        return parameter;
    }

    /**
     * 支払予定日印字有無のメソッドです。
     *
     * @return RString
     */
    public RString get支払予定日印字有無() {
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御汎用キー = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付,
                高額合算決定通知書, 項目名);
        if (帳票制御汎用キー == null) {
            return NUM_0;
        }
        return 帳票制御汎用キー.get設定値();
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他を解除のメソッドです。
     */
    public void 前排他を解除する() {
        LockingKey key = new LockingKey(UrControlDataFactory.createInstance().getMenuID());
        RealInitialLocker.release(key);
    }
}
