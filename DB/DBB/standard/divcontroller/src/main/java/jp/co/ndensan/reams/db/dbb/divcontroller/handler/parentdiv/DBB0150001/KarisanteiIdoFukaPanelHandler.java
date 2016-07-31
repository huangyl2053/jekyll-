/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0150001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.basic.karisanteiidofuka.KariSanteiIdoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.karisanteiidofuka.TyouhyouResult;
import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.ChohyoMeter;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchisho.notsu.ShutsuryokuKiKoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.KarisanteiIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.ZanteiKeisanIdoHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.FuchoKarisanteiIdoShinkiShikakuFuka;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.FuchoZanteiKeisanHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoIraikingakuKeisanHoho8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoNengakuKijunNendo8Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.KarisanteiIdoFukaPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.dgChushutsuKikan_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.dgHokenryoDankai_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.dgKarisanteiIdoshoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.dgKomokuNaiyo_Row;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFuka;
import jp.co.ndensan.reams.db.dbb.service.core.tsuchisho.notsu.ShutsuryokuKiKohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM36001_仮算定異動賦課のハンドラクラスです。
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaPanelHandler {

    private final KarisanteiIdoFukaPanelDiv div;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final RString 月 = new RString("月");
    private static final RString 未 = new RString("未");
    private static final RString 済 = new RString("済");
    private static final RString スペース = RString.HALF_SPACE;
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString STR_時刻 = new RString("235959");
    private static final RString 仮算定異動賦課_実行する = new RString("btnSantei");
    private static final RString 仮算定異動賦課通知書作成_実行する = new RString("btnIkkatsuHakko");
    private static final RString 月_6 = new RString("6月");
    private static final RString 帳票グループコード_32 = new RString("DBB01500032");
    private static final RString 帳票グループコード_3 = new RString("DBB0150003");
    private static final RString 帳票グループコード_1 = new RString("DBB0150001");
    private static final RString 帳票グループコード_12 = new RString("DBB01500012");
    private static final RString STR_0 = new RString("0");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_2 = new RString("2");
    private static final RString 対象補足月 = new RString("特徴開始月：8月（捕捉月：前年度２月）");
    private static final RString 仮算定異動賦課_処理名 = new RString("仮算定異動賦課");
    private static final RString 仮算定異動賦課確定_処理名 = new RString("仮算定異動賦課確定");
    private static final RString 仮算定異動賦課_MENU = new RString("DBBMN36001");
    private static final RString 普徴仮算定異動方法_項目 = new RString("普徴仮算定異動方法");
    private static final RString 普徴仮算定異動新規資格賦課_項目 = new RString("普徴仮算定異動新規資格賦課");
    private static final RString 普徴仮算定異動新規賦課方法_項目 = new RString("普徴仮算定異動新規賦課方法");
    private static final RString 普徴仮算定新規資格適用段階_項目 = new RString("普徴仮算定新規資格適用段階");
    private static final RString 年額基準年度_項目 = new RString("年額基準年度");
    private static final RString 特徴開始計算方法_項目 = new RString("8月特徴開始計算方法");
    private static final RString 賦課する = new RString("1");
    private static final RString 一律今年度 = new RString("12");
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");
    private static final RString 項目名 = new RString("当初出力_出力方法");
    private static final ReportId 帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final RString 別々出力 = new RString("別々出力");
    private static final RString 全件出力 = new RString("全件出力");
    private static final ReportId 帳票ID_14 = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoKigoto");
    private static final ReportId 帳票ID_15 = new ReportId("DBB100015_KarisanteiHokenryoNonyuTsuchishoKigotoRencho");
    private static final ReportId 帳票ID_28 = new ReportId("DBB100028_KarisanteiNonyuTsuchishoCVSKigoto");
    private static final ReportId 帳票ID_29 = new ReportId("DBB100029_KarisanteiNonyuTsuchishoCVSKigotoRencho");
    private static final ReportId 特別徴収開始通知書_仮算定_帳票分類ＩＤ = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 仮算定額変更通知書_帳票分類ＩＤ = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final ReportId 保険料納入通知書_本算定_帳票分類ＩＤ = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final ReportId 特徴開始通知書_仮算定 = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 仮算定額変更通知書 = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final ReportId 納入通知書 = new ReportId("DBB200006_FutsuChoshuKarisanteiKekkaIchiran");

    /**
     * コンストラクタです。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     */
    public KarisanteiIdoFukaPanelHandler(KarisanteiIdoFukaPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @return flag boolean
     */
    public boolean initialize() {

        RDate date = new RDate("20160529");
        int 境界日付 = date.getLastDay() - Integer.valueOf(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_更正月判定日数, date, SubGyomuCode.DBB介護賦課).toString());
        int 日 = date.getDayValue();
        RString 属する月 = new RString(String.valueOf(date.getMonthValue()));
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(属する月.padZeroToLeft(NUM_2), 属する月.concat(月)));
        if (日 < 境界日付 || date.getMonthValue() == NUM_3) {
            div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().setDataSource(dataSource);
            div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().setSelectedKey(属する月.padZeroToLeft(NUM_2));
        } else {
            RString 翌月 = new RString(String.valueOf(date.plusMonth(NUM_1).getMonthValue()));
            dataSource.add(new KeyValueDataSource(翌月.padZeroToLeft(NUM_2), 翌月.concat(月)));
            div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().setDataSource(dataSource);
            div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().setSelectedKey(翌月.padZeroToLeft(NUM_2));
        }

        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, date,
                SubGyomuCode.DBB介護賦課);
        set帳票グループ(date);
        set抽出条件(調定年度);
        boolean flag = set処理状態(調定年度);
        set帳票作成個別情報();
        return flag;
    }

    /**
     * 帳票グループIDの設定
     *
     * @param date システム日時
     */
    public void set帳票グループ(RDate date) {
        RString 処理対象 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().getSelectedValue();
        if (仮算定異動賦課_MENU.equals(ResponseHolder.getMenuID())) {
            if (月_6.equals(処理対象)) {
                div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran().load(
                        SubGyomuCode.DBB介護賦課, 帳票グループコード_12);
                set異動賦課_特徴捕捉分(date);
                set保険料段階と保険料率();
                管理情報確認の制御処理(date);
            } else {
                div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran().load(
                        SubGyomuCode.DBB介護賦課, 帳票グループコード_1);
                div.getShoriJokyo().getTokuchoHosoku().getTxtTaishoTokuchoKaishiTsuki().setValue(RString.EMPTY);
                div.getShoriJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan().setDisabled(true);
                set保険料段階と保険料率();
                管理情報確認の制御処理(date);
            }
        } else {
            if (月_6.equals(処理対象)) {
                div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran().load(
                        SubGyomuCode.DBB介護賦課, 帳票グループコード_32);
            } else {
                div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran().load(
                        SubGyomuCode.DBB介護賦課, 帳票グループコード_3);
            }
        }
    }

    private void set保険料段階と保険料率() {
        FlexibleYear 賦課年度 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtFukaNendo().getDomain();
        HokenryoDankaiList 保険料段階リスト = HokenryoDankaiSettings.createInstance().get保険料段階ListIn(賦課年度);
        if (保険料段階リスト != null) {
            List<HokenryoDankai> 保険料段階List = 保険料段階リスト.asList();
            Collections.sort(保険料段階List, new Comparator<HokenryoDankai>() {
                @Override
                public int compare(HokenryoDankai o1, HokenryoDankai o2) {

                    RString index1 = o1.get段階Index().padZeroToLeft(NUM_2);
                    RString index2 = o2.get段階Index().padZeroToLeft(NUM_2);
                    return index1.compareTo(index2);
                }
            });
            List<dgHokenryoDankai_Row> rowList = new ArrayList<>();
            dgHokenryoDankai_Row row;
            for (HokenryoDankai 保険料段階 : 保険料段階List) {
                row = new dgHokenryoDankai_Row();
                row.setHokenryoDankai(保険料段階.get表記());
                if (保険料段階.get保険料率() != null) {
                    row.setHokenryoRitsu(new RString(保険料段階.get保険料率().toString()));
                }
                rowList.add(row);
            }
            div.getShoriJokyo().getKanriJohoKakunin().getDgHokenryoDankai().setDataSource(rowList);
        }
    }

    private void 管理情報確認の制御処理(RDate date) {
        List<dgKomokuNaiyo_Row> dgRowList = new ArrayList<>();
        dgKomokuNaiyo_Row dgRow = new dgKomokuNaiyo_Row();
        RString 普徴仮算定異動方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動方法, date,
                SubGyomuCode.DBB介護賦課);
        dgRow.setKomoku(普徴仮算定異動方法_項目);
        dgRow.setNaiyo(ZanteiKeisanIdoHoho.toValue(普徴仮算定異動方法).get名称());
        dgRowList.add(dgRow);

        dgRow = new dgKomokuNaiyo_Row();
        RString 普徴仮算定異動新規資格賦課 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動新規資格賦課, date,
                SubGyomuCode.DBB介護賦課);
        dgRow.setKomoku(普徴仮算定異動新規資格賦課_項目);
        dgRow.setNaiyo(FuchoKarisanteiIdoShinkiShikakuFuka.toValue(普徴仮算定異動新規資格賦課).get名称());
        dgRowList.add(dgRow);

        if (賦課する.equals(普徴仮算定異動新規資格賦課)) {
            dgRow = new dgKomokuNaiyo_Row();
            RString 普徴仮算定異動新規賦課方法 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定異動新規賦課方法, date,
                    SubGyomuCode.DBB介護賦課);
            dgRow.setKomoku(普徴仮算定異動新規賦課方法_項目);
            dgRow.setNaiyo(FuchoZanteiKeisanHoho.toValue(普徴仮算定異動新規賦課方法).get略称());
            dgRowList.add(dgRow);

            if (一律今年度.equals(普徴仮算定異動新規賦課方法)) {
                dgRow = new dgKomokuNaiyo_Row();
                RString 普徴仮算定新規資格適用段階 = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定新規資格適用段階, date,
                        SubGyomuCode.DBB介護賦課);
                dgRow.setKomoku(普徴仮算定新規資格適用段階_項目);
                dgRow.setNaiyo(普徴仮算定新規資格適用段階);
                dgRowList.add(dgRow);
            }
        }
        RString 処理月 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().getSelectedValue();
        if (月_6.equals(処理月)) {
            FlexibleYear 年度 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtChoteiNendo().getDomain();
            RDate システム日時 = RDate.getNowDate();
            RDate 日時 = new RDate(Integer.valueOf(年度.minusYear(NUM_1).toString()),
                    システム日時.getMonthValue(), システム日時.getDayValue());
            dgRow = new dgKomokuNaiyo_Row();
            RString 年額基準年度 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_年額基準年度_8月開始, 日時,
                    SubGyomuCode.DBB介護賦課);
            dgRow.setKomoku(年額基準年度_項目);
            dgRow.setNaiyo(TokuchoNengakuKijunNendo8Gatsu.toValue(年額基準年度).get名称());
            dgRowList.add(dgRow);

            dgRow = new dgKomokuNaiyo_Row();
            RString 特徴開始計算方法 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_依頼金額計算方法_8月開始, 日時,
                    SubGyomuCode.DBB介護賦課);
            dgRow.setKomoku(特徴開始計算方法_項目);
            dgRow.setNaiyo(TokuchoIraikingakuKeisanHoho8Gatsu.toValue(特徴開始計算方法).get略称());
            dgRowList.add(dgRow);
        }
        div.getShoriJokyo().getKanriJohoKakunin().getDgKomokuNaiyo().setDataSource(dgRowList);

    }

    private void set異動賦課_特徴捕捉分(RDate date) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, date, SubGyomuCode.DBB介護賦課);
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        RString 依頼金計算処理区分 = idoFuka.getIraikinKeisanShoriKubun(new FlexibleYear(調定年度), null);
        if (STR_0.equals(依頼金計算処理区分)) {
            throw new ApplicationException(DbbErrorMessages.特徴対象者同定処理未完了.getMessage());
        } else if (STR_1.equals(依頼金計算処理区分)) {
            div.getShoriJokyo().getTokuchoHosoku().getTxtTaishoTokuchoKaishiTsuki().setValue(対象補足月);
            div.getShoriJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan().setDisabled(false);
        } else if (STR_2.equals(依頼金計算処理区分)) {
            div.getShoriJokyo().getTokuchoHosoku().getTxtTaishoTokuchoKaishiTsuki().setValue(RString.EMPTY);
            div.getShoriJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan().setDisabled(true);
        }
    }

    private void set帳票作成個別情報() {
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        FlexibleYear 調定年度 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtChoteiNendo().getDomain();
        ChohyoSeigyoHanyo 帳票制御汎用キー = idoFuka.getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                調定年度, 項目名);
        if (帳票制御汎用キー != null) {
            if (STR_0.equals(帳票制御汎用キー.get設定値())) {
                div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi()
                        .setValue(別々出力);
            } else if (STR_1.equals(帳票制御汎用キー.get設定値())) {
                div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi()
                        .setValue(全件出力);
            }
        }
        ShutsuryokuKiKohoFactory kohoFactory = new ShutsuryokuKiKohoFactory(調定年度);
        List<TyouhyouResult> 帳票IDList = new ArrayList<>();
        List<ShutsuryokuKiKoho> 出力期;
        get帳票ID(帳票IDList, idoFuka, 調定年度);
        if (!帳票IDList.isEmpty()) {
            boolean flag = false;
            for (TyouhyouResult result : 帳票IDList) {
                if (帳票ID_14.equals(result.getEntity().get帳票ID())
                        || 帳票ID_15.equals(result.getEntity().get帳票ID())
                        || 帳票ID_28.equals(result.getEntity().get帳票ID())
                        || 帳票ID_29.equals(result.getEntity().get帳票ID())) {
                    flag = true;
                }
            }
            出力期 = kohoFactory.create出力期候補(flag, true);
        } else {
            出力期 = kohoFactory.create出力期候補(false, true);
        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ShutsuryokuKiKoho entity : 出力期) {
            dataSource.add(new KeyValueDataSource(entity.get期月().get期(), entity.get表示文字列()));
        }
        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getDdlNotsuShuturyokuki()
                .setDataSource(dataSource);
        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getDdlNotsuShuturyokuki().setSelectedIndex(NUM_0);
        set納入通知書の発行日();
    }

    private void get帳票ID(List<TyouhyouResult> 帳票IDList, KariSanteiIdoFuka idoFuka, FlexibleYear 調定年度) {

        List<ChohyoMeter> 各通知書の帳票ID = get各通知書の帳票ID();
        FuchoKiUtil util = new FuchoKiUtil();
        KitsukiList 期月リスト = util.get期月リスト();
        RString 処理対象月 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().getSelectedKey();
        RString 算定期 = new RString(期月リスト.get月の期(Tsuki.toValue(処理対象月)).get期AsInt());
        try {
            for (ChohyoMeter 通知書の帳票ID : 各通知書の帳票ID) {
                TyouhyouResult 帳票ID = null;
                if (特徴開始通知書_仮算定.equals(通知書の帳票ID.get帳票分類ID())) {
                    帳票ID = idoFuka.getChohyoID(調定年度, 特別徴収開始通知書_仮算定_帳票分類ＩＤ,
                            算定期, 通知書の帳票ID.get出力順ID());
                } else if (仮算定額変更通知書.equals(通知書の帳票ID.get帳票分類ID())) {
                    帳票ID = idoFuka.getChohyoID(調定年度, 仮算定額変更通知書_帳票分類ＩＤ,
                            算定期, 通知書の帳票ID.get出力順ID());
                } else if (納入通知書.equals(通知書の帳票ID.get帳票分類ID())) {
                    帳票ID = idoFuka.getChohyoID(調定年度, 保険料納入通知書_本算定_帳票分類ＩＤ,
                            算定期, 通知書の帳票ID.get出力順ID());
                }
                if (帳票ID != null) {
                    帳票IDList.add(帳票ID);
                }
            }
        } catch (ApplicationException e) {
            throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
        }
    }

    private List<ChohyoMeter> get各通知書の帳票ID() {
        Map<RString, RString> rowMap = div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran()
                .getSelected帳票IdAnd出力順Id();
        List<ChohyoMeter> 出力帳票一覧 = new ArrayList<>();
        ChohyoMeter chohyoMeter;
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        for (Map.Entry<RString, RString> entry : set) {
            chohyoMeter = new ChohyoMeter();
            chohyoMeter.set帳票分類ID(new ReportId(entry.getKey()));
            chohyoMeter.set出力順ID(entry.getValue());
            出力帳票一覧.add(chohyoMeter);
        }
        return 出力帳票一覧;
    }

    private boolean set処理状態(RString 調定年度) {
        List<dgKarisanteiIdoshoriKakunin_Row> rowList = new ArrayList<>();
        dgKarisanteiIdoshoriKakunin_Row row = new dgKarisanteiIdoshoriKakunin_Row();
        boolean flag;
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        if (仮算定異動賦課_MENU.equals(ResponseHolder.getMenuID())) {
            List<ShoriDateKanri> entityList = idoFuka.getShoriDateKanriList(遷移元区分_0, new FlexibleYear(調定年度));
            RString 処理名_特徴 = ShoriName.特徴仮算定賦課.get名称();
            RString 処理名_普徴 = ShoriName.普徴仮算定賦課.get名称();
            if (entityList.isEmpty()) {
                rowList.add(setDgRow(row, 処理名_特徴));
                rowList.add(setDgRow(row, 処理名_普徴));
                flag = false;
            } else {
                flag = is仮算定異動賦課状況(処理名_特徴, 処理名_普徴, entityList, row, rowList);
            }
        } else {
            List<ShoriDateKanri> entityList = idoFuka.getShoriDateKanriList(遷移元区分_1, new FlexibleYear(調定年度));
            RString 処理名_異動 = ShoriName.仮算定異動賦課.get名称();
            if (entityList.isEmpty()) {
                rowList.add(setDgRow(row, 処理名_異動));
                flag = false;
            } else {
                FlexibleDate 基準年月日 = entityList.get(NUM_0).get基準年月日();
                YMDHMS 基準日時 = entityList.get(NUM_0).get基準日時();
                flag = is仮算定状況(基準年月日, 基準日時, row, 処理名_異動, rowList);
            }
        }
        div.getShoriJokyo().getKarisanteiIdoFukashoriKakunin().getDgKarisanteiIdoshoriKakunin().setDataSource(rowList);
        return flag;
    }

    private boolean is仮算定異動賦課状況(
            RString 処理名_特徴,
            RString 処理名_普徴,
            List<ShoriDateKanri> entityList,
            dgKarisanteiIdoshoriKakunin_Row row,
            List<dgKarisanteiIdoshoriKakunin_Row> rowList) {

        if (entityList.size() == NUM_1) {
            ShoriDateKanri entity = entityList.get(NUM_0);
            if (処理名_特徴.equals(entity.get処理名())) {
                FlexibleDate 基準年月日 = entity.get基準年月日();
                YMDHMS 基準日時 = entity.get基準日時();
                rowList.add(setDgRow(row, 処理名_普徴));
                return is仮算定状況(基準年月日, 基準日時, row, 処理名_特徴, rowList);
            } else {
                FlexibleDate 基準年月日 = entity.get基準年月日();
                YMDHMS 基準日時 = entity.get基準日時();
                rowList.add(setDgRow(row, 処理名_特徴));
                return is仮算定状況(基準年月日, 基準日時, row, 処理名_普徴, rowList);
            }
        } else {
            boolean flag1 = false;
            boolean flag2 = false;
            for (ShoriDateKanri entity : entityList) {
                if (処理名_特徴.equals(entity.get処理名())) {
                    FlexibleDate 基準年月日 = entity.get基準年月日();
                    YMDHMS 基準日時 = entity.get基準日時();
                    flag1 = is仮算定状況(基準年月日, 基準日時, row, 処理名_特徴, rowList);
                }
                if (処理名_普徴.equals(entity.get処理名())) {
                    FlexibleDate 基準年月日 = entity.get基準年月日();
                    YMDHMS 基準日時 = entity.get基準日時();
                    flag2 = is仮算定状況(基準年月日, 基準日時, row, 処理名_普徴, rowList);
                }
            }
            if (flag1 && flag2) {
                return true;
            }
        }
        return false;

    }

    private boolean is仮算定状況(FlexibleDate 基準年月日,
            YMDHMS 基準日時,
            dgKarisanteiIdoshoriKakunin_Row row,
            RString 処理名,
            List<dgKarisanteiIdoshoriKakunin_Row> rowList) {

        if (基準年月日 != null && !基準年月日.isEmpty()) {
            row = new dgKarisanteiIdoshoriKakunin_Row();
            RString 年月日 = 基準日時.getRDateTime().getDate().wareki().toDateString();
            RString 時刻 = 基準日時.getRDateTime().getTime().toFormattedTimeString(
                    DisplayTimeFormat.HH_mm_ss);
            row.getTxtShoriMei().setValue(処理名);
            row.getTxtJokyo().setValue(済);
            row.getTxtShoriNichiji().setValue(年月日.concat(スペース).concat(時刻));
            rowList.add(row);
            return true;
        } else {
            rowList.add(setDgRow(row, 処理名));
            return false;
        }
    }

    private dgKarisanteiIdoshoriKakunin_Row setDgRow(dgKarisanteiIdoshoriKakunin_Row row, RString 処理名) {
        row.getTxtShoriMei().setValue(処理名);
        row.getTxtJokyo().setValue(未);
        row.getTxtShoriNichiji().setValue(RString.EMPTY);
        return row;
    }

    /**
     * 抽出条件設定のメソッドます。
     *
     * @param 調定年度 RString
     */
    public void set抽出条件(RString 調定年度) {
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        YMDHMS 抽出開始日時 = idoFuka.getTyusyutuKaishibi(new FlexibleYear(調定年度));
        List<dgChushutsuKikan_Row> rowList = new ArrayList<>();
        dgChushutsuKikan_Row row = new dgChushutsuKikan_Row();
        if (抽出開始日時 != null) {
            RString 年月日 = 抽出開始日時.getRDateTime().getDate().wareki().toDateString();
            RString 時刻 = 抽出開始日時.getRDateTime().getTime().toFormattedTimeString(
                    DisplayTimeFormat.HH_mm_ss);
            row.getTxtChishutsuStNichiji().setValue(年月日.concat(スペース).concat(時刻));
            row.getTxtChushutsuStYMD().setValue(抽出開始日時.getRDateTime().getDate());
            row.getTxtChushutsuStTime().setValue(抽出開始日時.getRDateTime().getTime());
        }
        RString key = div.getKarisanteiIdoFukaKanriInfo().getRadChushutsuJoken().getSelectedKey();
        if (KEY0.equals(key)) {
            YMDHMS date = new YMDHMS(RDate.getNowDate().minusDay(RDate.getNowDate().getDayValue()).toDateString()
                    .concat(STR_時刻));
            set抽出終了日時_未満(row, date.getRDateTime());
        } else if (KEY1.equals(key)) {
            YMDHMS date = new YMDHMS(RDate.getNowDate().minusDay(NUM_1).toDateString()
                    .concat(STR_時刻));
            set抽出終了日時_未満(row, date.getRDateTime());
        } else {
            set抽出終了日時_未満(row, RDate.getNowDateTime());
        }
        rowList.add(row);
        div.getKarisanteiIdoFukaKanriInfo().getDgChushutsuKikan().setDataSource(rowList);
    }

    private void set抽出終了日時_未満(dgChushutsuKikan_Row row, RDateTime date) {
        RString 年月日 = date.getDate().wareki().toDateString();
        RString 時刻 = date.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        row.getTxtChishutsuEdNichiji().setValue(年月日.concat(スペース).concat(時刻));
        row.getTxtChushutsuEdYMD().setValue(date.getDate());
        row.getTxtChushutsuEdTime().setValue(date.getTime());
    }

    /**
     * 画面onLoadの時にチェックを行う。
     *
     * @return is基準日時 boolean
     */
    public boolean is基準日時() {

        RString choteiNendo = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        FlexibleYear 年度 = new FlexibleYear(choteiNendo);
        div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtChoteiNendo().setDomain(年度);
        div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtFukaNendo().setDomain(年度);
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        ShoriDateKanri dbT7022Entity = idoFuka.get基準日時(年度, 仮算定異動賦課_処理名);
        YMDHMS 異動賦課の基準日時 = dbT7022Entity.get基準日時();
        dbT7022Entity = idoFuka.get基準日時(年度, 仮算定異動賦課確定_処理名);
        YMDHMS 異動賦課確定の基準日時 = dbT7022Entity.get基準日時();
        return 異動賦課確定の基準日時.isBefore(異動賦課の基準日時);
    }

    /**
     * 入力チェックのメソッドます。
     *
     * @return ResponseData
     */
    public ValidationMessageControlPairs getCheckMessage() {
        Map<RString, RString> rowMap = div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran()
                .getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        boolean 特徴開始通知書Flag = false;
        boolean 仮算定額変更通知書Flag = false;
        boolean 納入通知書Flag = false;
        for (Map.Entry<RString, RString> entry : set) {
            if (特徴開始通知書_仮算定.value().equals(entry.getKey())) {
                特徴開始通知書Flag = true;
            }
            if (仮算定額変更通知書.value().equals(entry.getKey())) {
                仮算定額変更通知書Flag = true;
            }
            if (納入通知書.value().equals(entry.getKey())) {
                納入通知書Flag = true;
            }
        }
        KarisanteiIdoFukaPanelValidationHandler validation = new KarisanteiIdoFukaPanelValidationHandler(div);
        ValidationMessageControlPairs pairs = validation.必須チェックValidate(
                仮算定額変更通知書Flag, 納入通知書Flag, 特徴開始通知書Flag);
        return pairs;
    }

    /**
     * 納入通知書の発行日設定する。
     */
    public void set納入通知書の発行日() {
        RString 出力期 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getDdlNotsuShuturyokuki().getSelectedKey();
        if (!出力期.isEmpty()) {
            Noki 普徴納期 = FukaNokiResearcher.createInstance()
                    .get普徴納期(Integer.valueOf(出力期.toString()));
            div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuHakkoYMD()
                    .setValue(普徴納期.get通知書発行日());
        }
    }

    /**
     * 実行ボタン設定する。
     *
     * @param flag boolean
     */
    public void set実行ボタン(boolean flag) {
        if (仮算定異動賦課_MENU.equals(ResponseHolder.getMenuID())) {
            if (flag) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(仮算定異動賦課_実行する, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(仮算定異動賦課_実行する, true);
            }
        } else {
            if (flag) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(仮算定異動賦課通知書作成_実行する, false);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(仮算定異動賦課通知書作成_実行する, true);
            }
        }
    }

    /**
     * バッチパラメータに設定する。
     *
     * @return バッチパラメータ
     */
    public KarisanteiIdoFukaParameter getバッチパラメータ() {
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        KariSanteiIdoParameter parameter = new KariSanteiIdoParameter();
        FlexibleYear 調定年度 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtChoteiNendo().getDomain();
        if (調定年度 != null && !調定年度.isEmpty()) {
            parameter.set調定年度(new RString(調定年度.toString()));
        }
        FlexibleYear 賦課年度 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtFukaNendo().getDomain();
        if (賦課年度 != null && !賦課年度.isEmpty()) {
            parameter.set賦課年度(new RString(賦課年度.toString()));
        }
        RString 処理対象月 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().getSelectedKey();
        parameter.set処理対象(処理対象月);
        List<dgChushutsuKikan_Row> 抽出日時List = div.getKarisanteiIdoFukaKanriInfo().getDgChushutsuKikan().getDataSource();
        if (!抽出日時List.isEmpty()) {
            dgChushutsuKikan_Row 抽出日時 = 抽出日時List.get(NUM_0);
            parameter.set抽出開始日時(new RString(抽出日時.getTxtChushutsuStYMD().getValue().toString())
                    .concat(抽出日時.getTxtChushutsuStTime().getValue().toString()));
            parameter.set抽出終了日時(new RString(抽出日時.getTxtChushutsuEdYMD().getValue().toString())
                    .concat(抽出日時.getTxtChushutsuEdTime().getValue().toString()));
        }
        RString 処理対象 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().getSelectedValue();
        List<TyouhyouEntity> 出力帳票一覧 = new ArrayList<>();
        Map<RString, RString> rowMap = div.getKarisanteiIdoFukaChohyoHakko().getCcdChohyoIchiran()
                .getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        parameter.setバッチ起動フラグ(false);
        for (Map.Entry<RString, RString> entry : set) {
            出力帳票一覧.add(new TyouhyouEntity(new ReportId(entry.getKey()), null, entry.getValue()));
            if (特徴開始通知書_仮算定.value().equals(entry.getKey())
                    || 仮算定額変更通知書.value().equals(entry.getKey())
                    || 納入通知書.value().equals(entry.getKey())) {
                parameter.setバッチ起動フラグ(true);
            }
        }
        parameter.set出力帳票一覧List(出力帳票一覧);
        setParameter(処理対象, parameter);
        RDate 特徴_発行日 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getTxtTokuKaishiTsuchiHakkoYMD().getValue();
        if (特徴_発行日 != null) {
            parameter.set特徴_発行日(new RString(特徴_発行日.toString()));
        }
        RDate 仮算定額変更_発行日 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getTxtKariHenkoTsuchiHakkoYMD().getValue();
        if (仮算定額変更_発行日 != null) {
            parameter.set仮算定額変更_発行日(new RString(仮算定額変更_発行日.toString()));
        }
        parameter.set文書番号(div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getCcdBunshoBango().get文書番号());
        parameter.set納入_出力期(div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getDdlNotsuShuturyokuki().getSelectedKey());
        parameter.set納入_出力方式(div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getTxtNotsuShutsuryokuKi().getValue());
        RDate 納入_発行日 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuHakkoYMD()
                .getValue();
        if (納入_発行日 != null) {
            parameter.set納入_発行日(new RString(納入_発行日.toString()));
        }
        List<RString> 納入_対象者 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getChkNotsuTaishosha()
                .getSelectedValues();
        if (納入_対象者 != null && !納入_対象者.isEmpty()) {
            parameter.set納入_対象者(納入_対象者.get(NUM_0));
        }
        parameter.set納入_生活保護対象者(div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getRadNotsuSeikatsuHogo().getSelectedValue());
        parameter.set納入_ページごとに山分け(div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                .getRadNotsuYamawake().getSelectedValue());

        FuchoKiUtil util = new FuchoKiUtil();
        KitsukiList 期月リスト = util.get期月リスト();
        RString 算定期 = new RString(期月リスト.get月の期(Tsuki.toValue(処理対象月)).get期AsInt());
        parameter.set算定期(算定期);
        return idoFuka.createKariSanteiIdoParameter(parameter);
    }

    private void setParameter(RString 処理対象, KariSanteiIdoParameter parameter) {
        boolean 一括発行起動フラグ;
        if (仮算定異動賦課_MENU.equals(ResponseHolder.getMenuID())) {
            if (月_6.equals(処理対象)) {
                parameter.set帳票グループ(帳票グループコード_12);
            } else {
                parameter.set帳票グループ(帳票グループコード_1);
            }
            一括発行起動フラグ = false;
            parameter.set仮算定異動賦課メニューからの場合(
                    div.getShoriJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan().getSelectedValue());
            List<dgKarisanteiIdoshoriKakunin_Row> rowList = div.getShoriJokyo().getKarisanteiIdoFukashoriKakunin()
                    .getDgKarisanteiIdoshoriKakunin().getDataSource();
            for (dgKarisanteiIdoshoriKakunin_Row row : rowList) {
                if (ShoriName.特徴仮算定賦課.get名称().equals(row.getTxtShoriMei().getValue())) {
                    parameter.set特徴仮算定賦課処理日時(row.getTxtShoriNichiji().getValue());
                } else if (ShoriName.普徴仮算定賦課.get名称().equals(row.getTxtShoriMei().getValue())) {
                    parameter.set普徴仮算定賦課処理日時(row.getTxtShoriNichiji().getValue());
                }
            }
        } else {
            if (月_6.equals(処理対象)) {
                parameter.set帳票グループ(帳票グループコード_32);
            } else {
                parameter.set帳票グループ(帳票グループコード_3);
            }
            一括発行起動フラグ = true;
        }
        parameter.set一括発行起動フラグ(一括発行起動フラグ);
    }

    /**
     * 帳票IDのチェック。
     */
    public void check帳票ID() {
        List<TyouhyouResult> 帳票IDList = new ArrayList<>();
        KariSanteiIdoFuka idoFuka = new KariSanteiIdoFuka();
        FlexibleYear 調定年度 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getTxtChoteiNendo().getDomain();
        get帳票ID(帳票IDList, idoFuka, 調定年度);
    }
}
