/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0140001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.KoseiTsukiHantei;
import jp.co.ndensan.reams.db.dbb.definition.core.fucho.ZanteiKeisanHasuChosei;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.FuchoZanteiKeisanHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoKaishiMaeFucho6Gatsu;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiChohyoHakko2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.FuchoKarisanteiFukaMenuPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.ShoriJokyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.dgFuchoKarisanteiShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001.dgKanrijoho2_Row;
import jp.co.ndensan.reams.db.dbb.service.core.fuchokarisanteifuka.FuchoKariSanteiFuka;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 普徴仮算定賦課のHandlerです。
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoKarisanteiFukaMenuPanelHandler {

    private final FuchoKarisanteiFukaMenuPanelDiv div;
    private static final int 時分秒LENGTH = 2;
    private static final RDate システム日時 = RDate.getNowDate();
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");
    private static final RString 基準日時_未 = new RString("未");
    private static final RString 基準日時_済 = new RString("済");
    private static final RString コロン = new RString(":");
    private static final RString スペース = new RString("　");
    private static final RString 普徴仮算定賦課_ボタン = new RString("btnFuchoKarisanteiFukaBatch");
    private static final RString 普徴仮算定通知書一括発行_ボタン = new RString("btnFuchoKarisanteiTsuchishoBatch");
    private static final RString 普徴仮算定賦課メニュー = new RString("DBBMN34001");
    private static final RString 普徴仮算定通知書一括発行メニュー = new RString("DBBMN34002");
    private static final RString 項目列_納期限 = new RString("納期限");
    private static final RString 項目列_端数調整有無 = new RString("端数調整有無");
    private static final RString 項目列_6月特徴開始者 = new RString("6月特徴開始者");
    private static final RString 項目列_仮算定賦課方法 = new RString("仮算定賦課方法");
//    private static final RString 別々に出力 = new RString("別々に出力");
//    private static final RString 全件出力 = new RString("全件出力");
    private static final RString 出力期のタイプ_前 = new RString("期（");
    private static final RString 出力期のタイプ_別々に = new RString("月）分");
    private static final RString 出力期のタイプ_全件 = new RString("月）~");
//    private static final ReportId 帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
//    private static final RString 帳票グループコード_賦課から = new RString("DBB0140001(普徴仮算定賦課)");
//    private static final RString 帳票グループコード_一括発行から = new RString("DBB0140003(普徴仮算定通知書一括発行)");
    private static final RString 帳票グループコード_普徴仮算定賦課メニュー = new RString("DBB0140001(普徴仮算定賦課)");
    private static final RString 帳票グループコード_普徴仮算定通知書一括発行メニュー = new RString("DBB0140003(普徴仮算定通知書一括発行)");

    /**
     * 処理状況エリアの初期化メソッドです。
     */
    public void load処理状況() {
        ShoriJokyoDiv 処理状況div = div.getMainPanelBatchParameter().getFuchoKarisanteiFukaKakunin().getShoriJokyo();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, システム日時, SubGyomuCode.DBB介護賦課);
        処理状況div.getFuchoKarisanteiShoriNaiyo().getTxtChoteiNendo().setDomain(new RYear(調定年度));
        処理状況div.getFuchoKarisanteiShoriNaiyo().getTxtFukaNendo().setDomain(new RYear(調定年度));
        List<dgFuchoKarisanteiShoriKakunin_Row> dataSource = new ArrayList<>();
        RString メニューID = ResponseHolder.getMenuID();
        if (普徴仮算定賦課メニュー.equals(メニューID)) {
            List<ShoriDateKanri> 処理日付管理マスタ = FuchoKariSanteiFuka.createInstance().getShoriDateKanriList(
                    new FlexibleYear(調定年度), 遷移元区分_0);
            if (処理日付管理マスタ == null || 処理日付管理マスタ.isEmpty()) {
                dgFuchoKarisanteiShoriKakunin_Row row = new dgFuchoKarisanteiShoriKakunin_Row();
                row.setTxtShoriMei(ShoriName.特徴仮算定賦課.get名称());
                row.setTxtJokyo(基準日時_未);
                row.setTxtShoriNichiji(null);
                dataSource.add(row);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(普徴仮算定賦課_ボタン, true);
            } else {
                dataSource = setグリッド(処理日付管理マスタ.get(0), dataSource, メニューID);
            }
        } else if (普徴仮算定通知書一括発行メニュー.equals(メニューID)) {
            List<ShoriDateKanri> 処理日付管理マスタ = FuchoKariSanteiFuka.createInstance().getShoriDateKanriList(
                    new FlexibleYear(調定年度), 遷移元区分_1);
            if (処理日付管理マスタ == null || 処理日付管理マスタ.isEmpty()) {
                dgFuchoKarisanteiShoriKakunin_Row row = new dgFuchoKarisanteiShoriKakunin_Row();
                row.setTxtShoriMei(ShoriName.普徴仮算定賦課.get名称());
                row.setTxtJokyo(基準日時_未);
                row.setTxtShoriNichiji(null);
                dataSource.add(row);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(普徴仮算定通知書一括発行_ボタン, true);
            } else {
                dataSource = setグリッド(処理日付管理マスタ.get(0), dataSource, メニューID);
            }
        }
        処理状況div.getFuchoKarisanteiShoriKakunin().getDgFuchoKarisanteiShoriKakunin().setDataSource(dataSource);
    }

    /**
     * 管理情報確認グループの初期化メソッドです。
     */
    public void load管理情報確認() {
        List<dgKanrijoho2_Row> dataSource = new ArrayList<>();
        dgKanrijoho2_Row row1 = new dgKanrijoho2_Row();
        dgKanrijoho2_Row row2 = new dgKanrijoho2_Row();
        dgKanrijoho2_Row row3 = new dgKanrijoho2_Row();
        dgKanrijoho2_Row row4 = new dgKanrijoho2_Row();
        row1.setTxtKoumoku(項目列_仮算定賦課方法);
        RString 仮算定賦課方法code = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定賦課方法, システム日時, SubGyomuCode.DBB介護賦課);
        row1.setTxtNaiyo(FuchoZanteiKeisanHoho.toValue(仮算定賦課方法code).get名称());
        row2.setTxtKoumoku(項目列_端数調整有無);
        RString 端数調整有無code = DbBusinessConfig.get(ConfigNameDBB.普通徴収_仮算定端数調整有無, システム日時, SubGyomuCode.DBB介護賦課);
        row2.setTxtNaiyo(ZanteiKeisanHasuChosei.toValue(端数調整有無code).get名称());
        row3.setTxtKoumoku(項目列_納期限);
        // TODO QAあり　納期限の取得。
//        FukaNokiResearcher.createInstance().get普徴納期ALL().get(0).get法定納期限();
//        row3.setTxtNaiyo();
        row4.setTxtKoumoku(項目列_6月特徴開始者);
        RString 列_6月特徴開始者code = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始前普通徴収_6月, システム日時, SubGyomuCode.DBB介護賦課);
        row4.setTxtNaiyo(TokuchoKaishiMaeFucho6Gatsu.toValue(列_6月特徴開始者code).get名称());
        dataSource.add(row1);
        dataSource.add(row2);
        dataSource.add(row3);
        dataSource.add(row4);
        div.getMainPanelBatchParameter().getFuchoKarisanteiFukaKakunin().getFuchoKarisanteiKanrijoho().getDgKanrijoho2().setDataSource(dataSource);
    }

    /**
     * 算定帳票作成エリアの初期化メソッドです。
     */
    public void load算定帳票作成() {
        RString メニューID = ResponseHolder.getMenuID();
        RString 帳票グループコード = RString.EMPTY;
        if (普徴仮算定賦課メニュー.equals(メニューID)) {
            // TODO 帳票グループコードのtype
            帳票グループコード = 帳票グループコード_普徴仮算定賦課メニュー;
        } else if (普徴仮算定通知書一括発行メニュー.equals(メニューID)) {
            帳票グループコード = 帳票グループコード_普徴仮算定通知書一括発行メニュー;
        }
        div.getMainPanelBatchParameter().getFuchoKarisanteiChohyoHakko2().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 帳票グループコード);
    }

    /**
     * 帳票作成個別情報エリアの初期化メソッドです。
     */
    public void load帳票作成個別情報() {
        KoseiTsukiHantei 更正月判定 = new KoseiTsukiHantei();
        RDate 発行日 = FukaNokiResearcher.createInstance().get普徴納期(
                更正月判定.find更正月(システム日時).get期AsInt()).get通知書発行日();
        FuchoKarisanteiChohyoHakko2Div 帳票作成個別情報Panel = div.getMainPanelBatchParameter().getFuchoKarisanteiChohyoHakko2();
        帳票作成個別情報Panel.getFuchoTsuchiKobetsuJoho().getTxtHakkoYMD().setValue(発行日);
        List<Kitsuki> 期月リスト = new FuchoKiUtil().get期月リスト().filtered仮算定期間().toList();
        // TODO 当初出力_出力方法を取得する。実装しない。
//        FuchoKariSanteiFuka.createInstance().getChohyoHanyoKey(SubGyomuCode.DBB介護賦課, 帳票分類ID, FlexibleYear.MAX, コロン)
//        ChohyoSeigyoHanyo 当初出力_出力方法 = new ChohyoSeigyoHanyo(new DbT7067ChohyoSeigyoHanyoEntity());
//        当初出力_出力方法.
        帳票作成個別情報Panel.getFuchoTsuchiKobetsuJoho().getTxtNotsuShutsuryokukiType2().setValue(new RString("別々に出力"));
        List<KeyValueDataSource> 出力期のタイプ_別々に出力 = get出力期のタイプ(期月リスト, 出力期のタイプ_別々に);
//        List<KeyValueDataSource> 出力期のタイプ_全件出力 = get出力期のタイプ(期月リスト, 出力期のタイプ_全件);
        帳票作成個別情報Panel.getFuchoTsuchiKobetsuJoho().getDdlNotsuShuturyokuki2().setDataSource(出力期のタイプ_別々に出力);
        // TODO 対象者 生活保護対象者をまとめて先頭に出力 ページごとに山分け QA
    }

    private List<KeyValueDataSource> get出力期のタイプ(List<Kitsuki> 期月リスト, RString 出力期のタイプ) {
        List<KeyValueDataSource> keyValueDataSources = new ArrayList<>();
        int i = 0;
        for (Kitsuki 期月 : 期月リスト) {
            int 期 = 期月.get期AsInt();
            int 月 = 期月.get月AsInt();
            RStringBuilder builder = new RStringBuilder();
            builder.append(RStringUtil.convert半角to全角(new RString(String.valueOf(期))));
            builder.append(出力期のタイプ_前);
            builder.append(RStringUtil.convert半角to全角(new RString(String.valueOf(月))));
            if (出力期のタイプ_別々に.equals(出力期のタイプ)) {
                builder.append(出力期のタイプ_別々に);
            } else {
                builder.append(出力期のタイプ_全件);
            }
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(new RString(String.valueOf(i)), builder.toRString());
            keyValueDataSources.add(keyValueDataSource);
            i = i + 1;
        }
        return keyValueDataSources;
    }

    private List<dgFuchoKarisanteiShoriKakunin_Row> setグリッド(
            ShoriDateKanri 処理日付管理マスタ,
            List<dgFuchoKarisanteiShoriKakunin_Row> dataSource,
            RString メニューID) {
        RString 処理名 = RString.EMPTY;
        YMDHMS 基準日時 = 処理日付管理マスタ.get基準日時();
        dgFuchoKarisanteiShoriKakunin_Row row = new dgFuchoKarisanteiShoriKakunin_Row();
        if (基準日時 == null || 基準日時.isEmpty()) {
            if (普徴仮算定賦課メニュー.equals(メニューID)) {
                処理名 = ShoriName.特徴仮算定賦課.get名称();
                CommonButtonHolder.setDisabledByCommonButtonFieldName(普徴仮算定賦課_ボタン, true);
            } else if (普徴仮算定通知書一括発行メニュー.equals(メニューID)) {
                処理名 = ShoriName.普徴仮算定賦課.get名称();
                CommonButtonHolder.setDisabledByCommonButtonFieldName(普徴仮算定通知書一括発行_ボタン, false);
            }
            row.setTxtShoriMei(処理名);
            row.setTxtJokyo(基準日時_未);
            row.setTxtShoriNichiji(null);
            dataSource.add(row);
        } else {
            if (普徴仮算定賦課メニュー.equals(メニューID)) {
                処理名 = ShoriName.特徴仮算定賦課.get名称();
                CommonButtonHolder.setDisabledByCommonButtonFieldName(普徴仮算定賦課_ボタン, true);
            } else if (普徴仮算定通知書一括発行メニュー.equals(メニューID)) {
                処理名 = ShoriName.普徴仮算定賦課.get名称();
                CommonButtonHolder.setDisabledByCommonButtonFieldName(普徴仮算定通知書一括発行_ボタン, false);
            }
            row.setTxtShoriMei(処理名);
            row.setTxtJokyo(基準日時_済);
            RStringBuilder builder = new RStringBuilder();
            builder.append(new RString(基準日時.getDate().wareki().toString()));
            builder.append(スペース);
            builder.append(new RString(基準日時.getRDateTime().getHour()).padZeroToLeft(時分秒LENGTH));
            builder.append(コロン);
            builder.append(new RString(基準日時.getRDateTime().getMinute()).padZeroToLeft(時分秒LENGTH));
            builder.append(コロン);
            builder.append(new RString(基準日時.getRDateTime().getSecond()).padZeroToLeft(時分秒LENGTH));
            row.setTxtShoriNichiji(builder.toRString());
            dataSource.add(row);
        }
        return dataSource;
    }

    /**
     * コンストラクタです
     *
     * @param div MainPanelDiv
     */
    public FuchoKarisanteiFukaMenuPanelHandler(FuchoKarisanteiFukaMenuPanelDiv div) {
        this.div = div;
    }
}
