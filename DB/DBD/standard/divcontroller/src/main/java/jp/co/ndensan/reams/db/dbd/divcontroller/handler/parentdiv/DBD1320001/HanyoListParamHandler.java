/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710040.DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710050.DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710060.DBD710060_HanyoListShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710070.DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710080.DBD710080_HanyoListFutanGendoGakuNinteiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710110.DBD710110_HanyoListKokuhoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710120.DBD710120_HanyoListKokiKoreishaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710130.DBD710130_HanyoListJigyoTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710140.DBD710140_HanyoListRiyoshaFutanwariaiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710150.DBD710150_HanyoListShisetsuNyutaishoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuKomokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.Kyakasha;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.KyuShochiSha;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.Outputs;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.NendoUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 汎用リスト出力(介護受給共通)のハンドラークラスです。
 *
 * @reamsid_L DBD-3930-010 liwul
 */
public class HanyoListParamHandler {

    private final HanyoListParamDiv div;
    private static final RString 汎用リスト_施設入退所メニューID = new RString("DBDMN13017");
    private static final RString 汎用リスト_利用者負担額減免メニューID = new RString("DBDMN13007");
    private static final RString 汎用リスト_訪問介護利用者負担額減額メニューID = new RString("DBDMN13008");
    private static final RString 汎用リスト_社会福祉法人軽減メニューID = new RString("DBDMN13009");
    private static final RString 汎用リスト_特別地域加算減免メニューID = new RString("DBDMN13010");
    private static final RString 汎用リスト_負担限度額認定メニューID = new RString("DBDMN13006");
    private static final RString 汎用リスト_国保メニューID = new RString("DBDMN13013");
    private static final RString 汎用リスト_後期高齢者メニューID = new RString("DBDMN13014");
    private static final RString 汎用リスト_事業対象者メニューID = new RString("DBDMN13015");
    private static final RString 汎用リスト_利用者負担割合メニューID = new RString("DBDMN13016");

    private static final RString 汎用リスト_施設入退所帳票ID = new RString("DBD701014_HanyoListShisetsuNyutaisho");
    private static final RString 汎用リスト_利用者負担額減免帳票ID = new RString("DBD701004_HanyoListRiyoshaFutanGakuGengaku");
    private static final RString 汎用リスト_訪問介護利用者負担額減額帳票ID = new RString("DBD701005_HanyoListHomonKaigoRiyoshaFutanGakuGengaku");
    private static final RString 汎用リスト_社会福祉法人軽減帳票ID = new RString("DBD701006_HanyoListShakaiFukushiHojinKeigen");
    private static final RString 汎用リスト_特別地域加算減免帳票ID = new RString("DBD701007_HanyoListTokubetsuChiikiKasanGemmen");
    private static final RString 汎用リスト_負担限度額認定帳票ID = new RString("DBD701003_HanyoListFutanGendoGakuNintei");
    private static final RString 汎用リスト_国保帳票ID = new RString("DBD701010_HanyoListKokuho");
    private static final RString 汎用リスト_後期高齢者帳票ID = new RString("DBD701011_HanyoListKokiKoreisha");
    private static final RString 汎用リスト_事業対象者帳票ID = new RString("DBD701012_HanyoListJigyoTaishosha");
    private static final RString 汎用リスト_利用者負担割合帳票ID = new RString("DBD701013_HanyoListRiyoshaFutanwariai");

    private static final RString 汎用リスト_施設入退所バッチID = new RString("DBD710150_HanyoListShisetsuNyutaisho");
    private static final RString 汎用リスト_利用者負担額減免バッチID = new RString("DBD710040_HanyoListRiyoshaFutanGakuGengaku");
    private static final RString 汎用リスト_訪問介護利用者負担額減額バッチID = new RString("DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengaku");
    private static final RString 汎用リスト_社会福祉法人軽減バッチID = new RString("DBD710060_HanyoListShakaiFukushiHojinKeigen");
    private static final RString 汎用リスト_特別地域加算減免バッチID = new RString("DBD710070_HanyoListTokubetsuChiikiKasanGemmen");
    private static final RString 汎用リスト_負担限度額認定バッチID = new RString("DBD710080_HanyoListFutanGendoGakuNintei");
    private static final RString 汎用リスト_国保バッチID = new RString("DBD710110_HanyoListKokuho");
    private static final RString 汎用リスト_後期高齢者バッチID = new RString("DBD710120_HanyoListKokiKoreisha");
    private static final RString 汎用リスト_事業対象者バッチID = new RString("DBD710130_HanyoListJigyoTaishosha");
    private static final RString 汎用リスト_利用者負担割合バッチID = new RString("DBD710140_HanyoListRiyoshaFutanwariai");

    private static final RString 汎用リスト_施設入退所表題 = new RString("汎用リスト　施設入退所");
    private static final RString 汎用リスト_利用者負担額減免表題 = new RString("汎用リスト　利用者負担額減免");
    private static final RString 汎用リスト_訪問介護利用者負担額減額表題 = new RString("汎用リスト　訪問介護利用者負担額減額");
    private static final RString 汎用リスト_社会福祉法人軽減表題 = new RString("汎用リスト　社会福祉法人軽減");
    private static final RString 汎用リスト_特別地域加算減免表題 = new RString("汎用リスト　特別地域加算減");
    private static final RString 汎用リスト_負担限度額認定表題 = new RString("汎用リスト　負担限度額認定");
    private static final RString 汎用リスト_国保表題 = new RString("汎用リスト　国保");
    private static final RString 汎用リスト_後期高齢者表題 = new RString("汎用リスト　後期高齢者");
    private static final RString 汎用リスト_事業対象者表題 = new RString("汎用リスト　事業対象者");
    private static final RString 汎用リスト_利用者負担割合表題 = new RString("汎用リスト　利用者負担割合");

    private static final RString 利用者負担額減額データ種別名 = new RString("利用者負担額減額");
    private static final RString 訪問介護利用者負担額減額データ種別名 = new RString("訪問介護利用者負担額減額");
    private static final RString 社会福祉法人等利用者負担軽減データ種別名 = new RString("社会福祉法人等利用者負担軽減");
    private static final RString 特別地域加算減免データ種別名 = new RString("特別地域加算減免");
    private static final RString 介護保険負担限度額認定データ種別名 = new RString("介護保険負担限度額認定");
    private static final RString 国保資格情報データ種別名 = new RString("国保資格情報");
    private static final RString 後期高齢者情報データ種別名 = new RString("後期高齢者情報");
    private static final RString 利用者負担割合情報データ種別名 = new RString("利用者負担割合");
    private static final RString 二次予防事業対象者情報データ種別名 = new RString("二次予防事業対象者");
    private static final RString 年度KEY = new RString("key0");
    private static final RString 年度基準日KEY = new RString("key1");
    private static final RString 基準日KEY = new RString("key0");
    private static final RString 範囲KEY = new RString("key1");
    private static final RString 年度直近データのみKEY = new RString("key0");
    private static final RString 入所日KEY = new RString("key0");
    private static final RString 退所日KEY = new RString("key1");
    private static final RString 申請日KEY = new RString("key0");
    private static final RString 適用年月日KEY = new RString("key1");
    private static final RString 有効期限KEY = new RString("key2");
    private static final RString 決定日KEY = new RString("key3");
    private static final RString 取得日KEY = new RString("key0");
    private static final RString 喪失日KEY = new RString("key1");
    private static final RString すべてKEY = new RString("key0");
    private static final RString 直近データKEY = new RString("key1");
    private static final RString 適用開始日KEY = new RString("key0");
    private static final RString 適用終了日KEY = new RString("key1");
    private static final RString チェックリスト実施日KEY = new RString("key2");
    private static final RString 旧措置者KEY = new RString("key0");
    private static final RString 旧措置者実質的負担軽減者KEY = new RString("key1");
    private static final RString それ以外KEY = new RString("key2");
    private static final RString 第一段階KEY = new RString("key0");
    private static final RString 第二段階KEY = new RString("key1");
    private static final RString 第三段階KEY = new RString("key2");
    private static final RString 課税層第三段階KEY = new RString("key3");
    private static final RString 項目名付加KEY = new RString(1);
    private static final RString 連番付加KEY = new RString(2);
    private static final RString 日付スラッシュ付加KEY = new RString(3);
    private static final RString 直近データのみKEY = new RString(1);
    private static final RString 申請者データ抽出KEY = new RString(0);
    private static final RString 事業対象者負担１割KEY = new RString("key0");
    private static final RString 事業対象者負担２割KEY = new RString("key1");
    private static final RString 空白行KEY = new RString("key0");
    private static final boolean 非表示 = true;
    private static final boolean 表示 = false;
    private static final RString 汎用リスト_施設入退所_基準日TEXT = new RString("時点での施設入所者");
    private static final RString 汎用リスト_利用者負担額減免_基準日TEXT = new RString("時点での減免認定者");
    private static final RString 汎用リスト_社会福祉法人軽減_基準日TEXT = new RString("時点での軽減認定者");
    private static final RString 汎用リスト_負担限度額認定_基準日TEXT = new RString("時点での減額認定者");
    private static final RString 汎用リスト_国保_基準日TEXT = new RString("時点での資格取得者");
    private static final RString 汎用リスト_事業対象者TEXT = new RString("時点での総合事業対象者");
    private static final RString 汎用リスト_利用者負担額減免_基準日説明TEXT = new RString("（適用年月日と有効期限の間に基準日が入る場合に抽出）");
    private static final RString 汎用リスト_国保_基準日説明TEXT = new RString("（資格取得日と資格喪失日の間に基準日が入る場合に抽出）");
    private static final RString 汎用リスト_事業対象者説明TEXT = new RString("（適用開始日と適用終了日の間に基準日が入る場合に抽出）");
    private static final RString 表題パラメータ名称 = new RString("hyoudai");
    private static final RString 出力方法パラメータ名称 = new RString("syutsuryoku");
    private static final RString 抽出方法区分パラメータ名称1 = new RString("cyusyutsuhohokubun");
    private static final RString 抽出方法区分パラメータ名称2 = new RString("抽出方法区分");
    private static final RString 抽出項目区分パラメータ名称1 = new RString("cyusyutsukomokukubun");
    private static final RString 抽出項目区分パラメータ名称2 = new RString("抽出項目区分");
    private static final RString 基準日パラメータ名称1 = new RString("kizyunnichi");
    private static final RString 基準日パラメータ名称2 = new RString("基準日");
    private static final RString 日付範囲開始パラメータ名称1 = new RString("hitsukehanifrom");
    private static final RString 日付範囲開始パラメータ名称2 = new RString("日付範囲From");
    private static final RString 日付範囲終了パラメータ名称1 = new RString("hitsukehanito");
    private static final RString 日付範囲終了パラメータ名称2 = new RString("日付範囲To");
    private static final RString 基準日範囲パネル直近データ抽出パラメータ名称1 = new RString("isChokindatacyusyutsu");
    private static final RString 基準日範囲パネル直近データ抽出パラメータ名称2 = new RString("直近データ抽出");
    private static final RString 申請者データ抽出パラメータ名称1 = new RString("isShinseishadatacyushutsu");
    private static final RString 旧措置者パラメータ名称1 = new RString("kyusochisha");
    private static final RString 法別区分パラメータ名称1 = new RString("hobetsukubun");
    private static final RString 却下者パラメータ名称1 = new RString("kyakasha");
    private static final RString 喪失区分パラメータ名称1 = new RString("soshitsukubun");
    private static final RString 喪失区分パラメータ名称2 = new RString("喪失区分");
    private static final RString 項目名付加パラメータ名称1 = new RString("isCsvkomokumeifuka");
    private static final RString 項目名付加パラメータ名称2 = new RString("項目名付加");
    private static final RString 連番付加パラメータ名称1 = new RString("isCsvrenbanfuka");
    private static final RString 連番付加パラメータ名称2 = new RString("連番付加");
    private static final RString 日付スラッシュ付加パラメータ名称1 = new RString("isCsvhitsukesurasyuhensyu");
    private static final RString 日付スラッシュ付加パラメータ名称2 = new RString("日付スラッシュ付加");
    private static final RString 宛名抽出条件パラメータ名称1 = new RString("atenacyusyutsujyoken");
    private static final RString 宛名抽出条件パラメータ名称2 = new RString("宛名抽出条件");
    private static final RString 帳票IDパラメータ名称1 = new RString("cyohyoid");
    private static final RString 出力順パラメータ名称1 = new RString("syutsuryokujunparameter");
    private static final RString 出力順パラメータ名称2 = new RString("出力順");
    private static final RString 出力順パラメータ名称3 = new RString("syutsuryokujun");
    private static final RString 出力項目パラメータ名称1 = new RString("syutsuryokukomoku");
    private static final RString 出力項目パラメータ名称2 = new RString("出力項目");
    private static final RString 特定入所者旧措置者パラメータ名称 = new RString("shiteinyushoshakyusochisha");
    private static final RString 特定入所者負担軽減者パラメータ名称 = new RString("shiteinyushoshafutankeigensha");
    private static final RString 特定入所者その他パラメータ名称 = new RString("shiteinyushoshasonota");
    private static final RString 特定入所者第一段階パラメータ名称 = new RString("shiteinyushoshadaiichidankai");
    private static final RString 特定入所者第二段階パラメータ名称 = new RString("shiteinyushoshadainidankai");
    private static final RString 特定入所者第三段階パラメータ名称 = new RString("shiteinyushoshadaisandankai");
    private static final RString 特定入所者課税層パラメータ名称 = new RString("shiteinyushoshakazeisou");
    private static final RString 事業対象者データ抽出パラメータ名称 = new RString("isJigyotaishoshacyusyutsu");
    private static final RString 年度パラメータ名称 = new RString("nendo");
    private static final RString 年度直近データ抽出パラメータ名称 = new RString("isNendochokindatacyusyutsu");
    private static final RString 事業対象者負担１割パラメータ名称 = new RString("isJigyotaishoshafutanichiwari");
    private static final RString 事業対象者負担２割パラメータ名称 = new RString("isJigyotaishoshafutanniwari");
    private static final int 年度_10 = 10;
    private static final int 年度_1 = 1;

    /**
     * コンストラクタです。
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     */
    public HanyoListParamHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 汎用リスト出力の初期化。
     *
     * @param menuID メニューID
     */
    public void onLoad(RString menuID) {
        if (汎用リスト_利用者負担割合メニューID.equals(menuID)) {
            RYear 開始年度 = NendoUtil.getNendo(RDate.getNowDate());
            List<KeyValueDataSource> 年度選択肢 = new ArrayList<>();
            for (int i = 1; i <= 年度_10; i++) {
                年度選択肢.add(new KeyValueDataSource(開始年度.toDateString(), 開始年度.wareki().eraType(EraType.KANJI).toDateString()));
                開始年度 = 開始年度.plusYear(年度_1);
            }
            年度選択肢.add(new KeyValueDataSource(空白行KEY, RString.EMPTY));
            div.getDdlKijunNendo().setDataSource(年度選択肢);
            div.getDdlKijunNendo().setSelectedKey(NendoUtil.getNendo(RDate.getNowDate()).toDateString());
        } else {
            div.getDdlKijunNendo().setIsBlankLine(true);
        }
        List<KeyValueDataSource> 旧措置者DDL = new ArrayList<>();
        for (KyuShochiSha kyuShochiSha : KyuShochiSha.values()) {
            旧措置者DDL.add(new KeyValueDataSource(kyuShochiSha.getコード(), kyuShochiSha.get名称()));
        }
        div.getDdlKyuSochisya().setDataSource(旧措置者DDL);
        List<KeyValueDataSource> 法別区分DDL = new ArrayList<>();
        for (HobetsuKubun hobetsuKubun : HobetsuKubun.values()) {
            法別区分DDL.add(new KeyValueDataSource(hobetsuKubun.getコード(), hobetsuKubun.get名称()));
        }
        div.getDdlHoubetsuKubun().setDataSource(法別区分DDL);
        List<KeyValueDataSource> 却下者DDL = new ArrayList<>();
        for (Kyakasha kyakasha : Kyakasha.values()) {
            却下者DDL.add(new KeyValueDataSource(kyakasha.getコード(), kyakasha.get名称()));
        }
        div.getDdlKyakkasha().setDataSource(却下者DDL);
        List<KeyValueDataSource> 喪失区分DDL = new ArrayList<>();
        for (SoshitsuKubun soshitsuKubun : SoshitsuKubun.values()) {
            喪失区分DDL.add(new KeyValueDataSource(soshitsuKubun.getコード(), soshitsuKubun.get名称()));
        }
        div.getDdlSoshitsuKubun().setDataSource(喪失区分DDL);
        List<KeyValueDataSource> 出力方法list = new ArrayList<>();
        for (Outputs outputs : Outputs.values()) {
            出力方法list.add(new KeyValueDataSource(outputs.getコード(), outputs.get名称()));
        }
        div.getRadShuturyokuHoho().setDataSource(出力方法list);
        if (汎用リスト_施設入退所メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_施設入退所帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_施設入退所帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_施設入退所表題);
            初期化_施設入退所();
            div.getBtnParamRestore().setBatchId(汎用リスト_施設入退所バッチID);
            div.getBtnParamSave().setBatchId(汎用リスト_施設入退所バッチID);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_利用者負担額減免メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_利用者負担額減免帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_利用者負担額減免帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_利用者負担額減免表題);
            初期化_利用者負担額減免();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_利用者負担額減免バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_利用者負担額減免バッチID);
        } else if (汎用リスト_訪問介護利用者負担額減額メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_訪問介護利用者負担額減額帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_訪問介護利用者負担額減額帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_訪問介護利用者負担額減額表題);
            初期化_訪問介護利用者負担額減額();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_訪問介護利用者負担額減額バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_訪問介護利用者負担額減額バッチID);
        } else if (汎用リスト_社会福祉法人軽減メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_社会福祉法人軽減帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_社会福祉法人軽減帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_社会福祉法人軽減表題);
            初期化_社会福祉法人軽減();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_社会福祉法人軽減バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_社会福祉法人軽減バッチID);
        } else if (汎用リスト_特別地域加算減免メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_特別地域加算減免帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_特別地域加算減免帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_特別地域加算減免表題);
            初期化_特別地域加算減免();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_特別地域加算減免バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_特別地域加算減免バッチID);
        } else if (汎用リスト_負担限度額認定メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_負担限度額認定帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_負担限度額認定帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_負担限度額認定表題);
            初期化_負担限度額認定();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_負担限度額認定バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_負担限度額認定バッチID);
        } else if (汎用リスト_国保メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_国保帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_国保帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_国保表題);
            初期化_国保();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_国保バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_国保バッチID);
        } else if (汎用リスト_後期高齢者メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_後期高齢者帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_後期高齢者帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_後期高齢者表題);
            初期化_後期高齢者();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_後期高齢者バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_後期高齢者バッチID);
        } else if (汎用リスト_事業対象者メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_事業対象者帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_事業対象者帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_事業対象者表題);
            初期化_事業対象者();
            onClick_radChushutsuJokenB();
            div.getBtnParamSave().setBatchId(汎用リスト_事業対象者バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_事業対象者バッチID);
        } else if (汎用リスト_利用者負担割合メニューID.equals(menuID)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(汎用リスト_利用者負担割合帳票ID));
            div.getCcdShutsuryokuKomoku().load(汎用リスト_利用者負担割合帳票ID, SubGyomuCode.DBD介護受給);
            set表題パネル(汎用リスト_利用者負担割合表題);
            初期化_利用者負担割合();
            onClick_radChushutsuJokenA();
            div.getBtnParamSave().setBatchId(汎用リスト_利用者負担割合バッチID);
            div.getBtnParamRestore().setBatchId(汎用リスト_利用者負担割合バッチID);
        }
        onSelect_radShuturyokuHoho();
        onClick_radHaniJoken2();
    }

    /**
     * 条件の保存
     *
     * @param menuID メニューID
     * @return BatchParameterMap
     */
    public BatchParameterMap saveBatchParamterMap(RString menuID) {
        BatchParameterMap batchParameterMap = null;
        if (汎用リスト_施設入退所メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_施設入退所BatchParameter());
        } else if (汎用リスト_利用者負担額減免メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_利用者負担額減免BatchParameter());
        } else if (汎用リスト_訪問介護利用者負担額減額メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_訪問介護利用者負担額減額BatchParameter());
        } else if (汎用リスト_社会福祉法人軽減メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_社会福祉法人軽減BatchParameter());
        } else if (汎用リスト_特別地域加算減免メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_特別地域加算減免BatchParameter());
        } else if (汎用リスト_負担限度額認定メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_負担限度額認定BatchParameter());
        } else if (汎用リスト_国保メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_国保BatchParameter());
        } else if (汎用リスト_後期高齢者メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_後期高齢者BatchParameter());
        } else if (汎用リスト_事業対象者メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_事業対象者BatchParameter());
        } else if (汎用リスト_利用者負担割合メニューID.equals(menuID)) {
            batchParameterMap = new BatchParameterMap(get汎用リスト_利用者負担割合BatchParameter());
        }
        return batchParameterMap;
    }

    /**
     * 条件の復元
     *
     * @param menuID メニューID
     */
    public void restoreBatchParameter(RString menuID) {
        BatchParameterMap batchParameterMap = getBatchParameterMap();
        if (汎用リスト_施設入退所メニューID.equals(menuID)) {
            restore汎用リスト_施設入退所BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_利用者負担額減免メニューID.equals(menuID)) {
            restore汎用リスト_利用者負担額減免BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_訪問介護利用者負担額減額メニューID.equals(menuID)) {
            restore汎用リスト_訪問介護利用者負担額減額BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_社会福祉法人軽減メニューID.equals(menuID)) {
            restore汎用リスト_社会福祉法人軽減BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_特別地域加算減免メニューID.equals(menuID)) {
            restore汎用リスト_特別地域加算減免BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_負担限度額認定メニューID.equals(menuID)) {
            restore汎用リスト_負担限度額認定BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_国保メニューID.equals(menuID)) {
            restore汎用リスト_国保BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_後期高齢者メニューID.equals(menuID)) {
            restore汎用リスト_後期高齢者BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_事業対象者メニューID.equals(menuID)) {
            restore汎用リスト_事業対象者BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenB();
        } else if (汎用リスト_利用者負担割合メニューID.equals(menuID)) {
            restore汎用リスト_利用者負担割合BatchParameter(batchParameterMap);
            onClick_radChushutsuJokenA();
        }
        onSelect_radShuturyokuHoho();
        onClick_radHaniJoken2();
    }

    /**
     * 出力方法選択ラジオボタンonSelect画面項目制御
     */
    public void onSelect_radShuturyokuHoho() {
        RString selectedKey = div.getRadShuturyokuHoho().getSelectedKey();
        if (Outputs.帳票_CSV出力.getコード().equals(selectedKey)) {
            set表題パネルis非表示(表示);
            setCSV編集条件パネルis非表示(表示);
        } else if (Outputs.帳票のみ出力.getコード().equals(selectedKey)) {
            set表題パネルis非表示(表示);
            setCSV編集条件パネルis非表示(非表示);
        } else {
            set表題パネルis非表示(非表示);
            setCSV編集条件パネルis非表示(表示);
        }
    }

    /**
     * 年度RbGr onclick画面項目制御
     */
    public void onClick_radChushutsuJokenA() {
        if (年度KEY.equals(div.getRadChushutsuJokenA1().getSelectedKey())) {
            div.getDdlKijunNendo().setDisabled(表示);
            div.getChkChokkinNomiA().setDisabled(表示);
            div.getTxtKijunDateA().setDisabled(非表示);
        } else {
            div.getDdlKijunNendo().setDisabled(非表示);
            div.getChkChokkinNomiA().setDisabled(非表示);
            div.getTxtKijunDateA().setDisabled(表示);
        }
    }

    /**
     * 基準日RbGr onclick画面項目制御
     */
    public void onClick_radChushutsuJokenB() {
        if (基準日KEY.equals(div.getRadChushutsuJokenB1().getSelectedKey())) {
            基準日RbG_Onclick画面項目制御(true);
        } else {
            基準日RbG_Onclick画面項目制御(false);
        }
    }

    /**
     * 申請日RbGr onclick画面項目制御
     */
    public void onClick_radHaniJoken2() {
        if (申請日KEY.equals(div.getRadHaniJoken2().getSelectedKey())) {
            if (!div.getChkShinseishaNomi().isDisplayNone()) {
                div.getChkShinseishaNomi().setDisabled(表示);
            }
        } else {
            申請日RbGr_非申請日RbSelected();
        }
    }

    private void setCSV編集条件パネルis非表示(boolean is非表示) {
        div.getCsvHenshuHoho().setDisplayNone(is非表示);
        div.getCsvHenshuHoho().setDisabled(is非表示);
    }

    private void 申請日RbGr_非申請日RbSelected() {
        List<RString> selectdKey = new ArrayList<>();
        div.getChkShinseishaNomi().setSelectedItemsByKey(selectdKey);
        if (!div.getChkShinseishaNomi().isDisplayNone()) {
            div.getChkShinseishaNomi().setDisabled(非表示);
        }
    }

    private void 基準日RbG_Onclick画面項目制御(boolean is基準日RbSelected) {
        if (!div.getTxtKijunDateB().isDisplayNone()) {
            div.getTxtKijunDateB().setDisabled(!is基準日RbSelected);
        }
        if (div.getLblJitenTaishoshaB().isDisplayNone()) {
            div.getLblJitenTaishoshaB().setDisplayNone(!is基準日RbSelected);
        }
        if (!div.getChushutsuShosaiB21().isDisplayNone()) {
            div.getChushutsuShosaiB21().setDisabled(is基準日RbSelected);
        }
        if (!div.getChushutsuShosaiB22().isDisplayNone()) {
            div.getChushutsuShosaiB22().setDisabled(is基準日RbSelected);
        }
        if (!div.getChushutsuShosaiB23().isDisplayNone()) {
            div.getChushutsuShosaiB23().setDisabled(is基準日RbSelected);
        }
        if (!div.getChushutsuShosaiB24().isDisplayNone()) {
            div.getChushutsuShosaiB24().setDisabled(is基準日RbSelected);
        }
        if (!div.getChkShinseishaNomi().isDisplayNone()) {
            div.getChkShinseishaNomi().setDisabled(is基準日RbSelected);
        }
        if (!div.getChkChokkinNomi2().isDisplayNone()) {
            div.getChkChokkinNomi2().setDisabled(is基準日RbSelected);
        }
        if (!div.getTxtChushutsuHani().isDisplayNone()) {
            div.getTxtChushutsuHani().setDisabled(is基準日RbSelected);
        }
    }

    /**
     * 施設入退所バッチパラメータの作成。
     *
     * @return 施設入退所バッチパラメータ
     */
    public DBD710150_HanyoListShisetsuNyutaishoParameter get汎用リスト_施設入退所BatchParameter() {
        DBD710150_HanyoListShisetsuNyutaishoParameter para = new DBD710150_HanyoListShisetsuNyutaishoParameter();
        para.set抽出方法区分(get基準日範囲抽出方法区分());
        para.set抽出項目区分(get入所RbGr抽出項目区分().getコード());
        para.set基準日(get基準日());
        para.set日付範囲From(get日付範囲From());
        para.set日付範囲To(get日付範囲To());
        para.set直近データ抽出(get基準日範囲パネル直近データ抽出());
        para.set喪失区分(SoshitsuKubun.toValue(get喪失区分()));
        para.set項目名付加(get項目名付加());
        para.set連番付加(get連番付加());
        para.set日付スラッシュ付加(get日付スラッシュ付加());
        para.set宛名抽出条件(get宛名抽出条件());
        para.set出力順(div.getCcdShutsuryokujun().get出力順ID());
        para.set出力項目(get出力項目());
        para.setCyohyoid(汎用リスト_施設入退所帳票ID);
        div.getBtnParamSave().setBatchId(汎用リスト_施設入退所バッチID);
        return para;
    }

    /**
     * 利用者負担額減免バッチパラメータの作成。
     *
     * @return 利用者負担額減免バッチパラメータ
     */
    public DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter get汎用リスト_利用者負担額減免BatchParameter() {
        DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter para = new DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(利用者負担額減額データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get申請日RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setChokindatacyusyutsu(get基準日範囲パネル直近データ抽出());
        para.setShinseishadatacyushutsu(get申請者データ抽出());
        para.setKyusochisha(get旧措置者());
        para.setKyakasha(get却下者());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setSyutsuryokujunparameter(get出力順());
        para.setSyutsuryokukomoku(get出力項目());
        para.setCyohyoid(汎用リスト_利用者負担額減免帳票ID);
        return para;
    }

    /**
     * 訪問介護利用者負担額減額バッチパラメータの作成。
     *
     * @return 訪問介護利用者負担額減額バッチパラメータ
     */
    public DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter get汎用リスト_訪問介護利用者負担額減額BatchParameter() {
        DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter para = new DBD710050_HanyoListHomonKaigoRiyoshaFutanGakuGengakuParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(訪問介護利用者負担額減額データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get申請日RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setChokindatacyusyutsu(get基準日範囲パネル直近データ抽出());
        para.setHobetsukubun(get法別区分());
        para.setKyakasha(get却下者());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_訪問介護利用者負担額減額帳票ID);
        para.setSyutsuryokujunparameter(get出力順());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 社会福祉法人軽減バッチパラメータの作成。
     *
     * @return 社会福祉法人軽減バッチパラメータ
     */
    public DBD710060_HanyoListShakaiFukushiHojinKeigenParameter get汎用リスト_社会福祉法人軽減BatchParameter() {
        DBD710060_HanyoListShakaiFukushiHojinKeigenParameter para = new DBD710060_HanyoListShakaiFukushiHojinKeigenParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(社会福祉法人等利用者負担軽減データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get申請日RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setChokindatacyusyutsu(get基準日範囲パネル直近データ抽出());
        para.setShinseishadatacyushutsu(get申請者データ抽出());
        para.setKyakasha(get却下者());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_社会福祉法人軽減帳票ID);
        para.setSyutsuryokujunparameter(get出力順());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 特別地域加算減免バッチパラメータの作成。
     *
     * @return 特別地域加算減免バッチパラメータ
     */
    public DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter get汎用リスト_特別地域加算減免BatchParameter() {
        DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter para = new DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(特別地域加算減免データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get申請日RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setChokindatacyusyutsu(get基準日範囲パネル直近データ抽出());
        para.setShinseishadatacyushutsu(get申請者データ抽出());
        para.setKyakasha(get却下者());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_特別地域加算減免帳票ID);
        para.setSyutsuryokujunparameter(get出力順());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 負担限度額認定バッチパラメータの作成。
     *
     * @return 負担限度額認定バッチパラメータ
     */
    public DBD710080_HanyoListFutanGendoGakuNinteiParameter get汎用リスト_負担限度額認定BatchParameter() {
        DBD710080_HanyoListFutanGendoGakuNinteiParameter para = new DBD710080_HanyoListFutanGendoGakuNinteiParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(介護保険負担限度額認定データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get申請日RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setChokindatacyusyutsu(get基準日範囲パネル直近データ抽出());
        para.setShinseishadatacyushutsu(get申請者データ抽出());
        para.setShiteinyushoshakyusochisha(旧措置者Ck(旧措置者KEY));
        para.setShiteinyushoshafutankeigensha(旧措置者Ck(旧措置者実質的負担軽減者KEY));
        para.setShiteinyushoshasonota(旧措置者Ck(それ以外KEY));
        para.setShiteinyushoshadaiichidankai(特定入所者Ck(第一段階KEY));
        para.setShiteinyushoshadainidankai(特定入所者Ck(第二段階KEY));
        para.setShiteinyushoshadaisandankai(特定入所者Ck(第三段階KEY));
        para.setShiteinyushoshakazeisou(特定入所者Ck(課税層第三段階KEY));
        para.setKyakasha(get却下者());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_負担限度額認定帳票ID);
        para.setSyutsuryokujunparameter(get出力順());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 国保バッチパラメータの作成。
     *
     * @return 国保バッチパラメータ
     */
    public DBD710110_HanyoListKokuhoParameter get汎用リスト_国保BatchParameter() {
        DBD710110_HanyoListKokuhoParameter para = new DBD710110_HanyoListKokuhoParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(国保資格情報データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get取得喪失RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_国保帳票ID);
        para.setSyutsuryokujun(div.getCcdShutsuryokujun().get出力順ID());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 後期高齢者バッチパラメータの作成。
     *
     * @return 後期高齢者バッチパラメータ
     */
    public DBD710120_HanyoListKokiKoreishaParameter get汎用リスト_後期高齢者BatchParameter() {
        DBD710120_HanyoListKokiKoreishaParameter para = new DBD710120_HanyoListKokiKoreishaParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(後期高齢者情報データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get取得喪失RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setSoshitsukubun(get喪失区分());
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_後期高齢者帳票ID);
        para.setSyutsuryokujun(div.getCcdShutsuryokujun().get出力順ID());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 事業対象者バッチパラメータの作成。
     *
     * @return 事業対象者バッチパラメータ
     */
    public DBD710130_HanyoListJigyoTaishoshaParameter get汎用リスト_事業対象者BatchParameter() {
        DBD710130_HanyoListJigyoTaishoshaParameter para = new DBD710130_HanyoListJigyoTaishoshaParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(二次予防事業対象者情報データ種別名);
        para.setSyutsuryoku(get出力方法());
        para.setCyusyutsuhohokubun(get基準日範囲抽出方法区分().getコード());
        para.setCyusyutsukomokukubun(get適用開始日RbGr抽出項目区分().getコード());
        para.setKizyunnichi(get基準日());
        para.setHitsukehanifrom(get日付範囲From());
        para.setHitsukehanito(get日付範囲To());
        para.setJigyotaishoshacyusyutsu(直近データKEY.equals(div.getRadChusyutuKubun().getSelectedKey()));
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_事業対象者帳票ID);
        para.setSyutsuryokujun(div.getCcdShutsuryokujun().get出力順ID());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    /**
     * 利用者負担割合バッチパラメータの作成。
     *
     * @return 利用者負担割合バッチパラメータ
     */
    public DBD710140_HanyoListRiyoshaFutanwariaiParameter get汎用リスト_利用者負担割合BatchParameter() {
        DBD710140_HanyoListRiyoshaFutanwariaiParameter para = new DBD710140_HanyoListRiyoshaFutanwariaiParameter();
        para.setHyoudai(get表題());
        para.setDetasyubetsumesyo(利用者負担割合情報データ種別名);
        para.setSyutsuryoku(get出力方法());
        if (年度KEY.equals(div.getRadChushutsuJokenA1().getSelectedKey())) {
            para.setCyusyutsuhohokubun(ChushutsuHohoKubun.年度.getコード());
        } else {
            para.setCyusyutsuhohokubun(ChushutsuHohoKubun.基準日.getコード());
        }
        if (年度基準日KEY.equals(div.getRadChushutsuJokenA2().getSelectedKey())) {
            RString 年度 = div.getDdlKijunNendo().getSelectedKey();
            RDate date = div.getTxtKijunDateA().getValue();
            if (!RString.isNullOrEmpty(年度)) {
                para.setNendo(new FlexibleYear(年度));
            } else {
                para.setNendo(FlexibleYear.EMPTY);
            }
            if (date != null) {
                para.setKizyunnichi(new FlexibleDate(date.getYearValue(), date.getMonthValue(), date.getDayValue()));
            } else {
                para.setKizyunnichi(FlexibleDate.EMPTY);
            }
        } else {
            para.setNendo(FlexibleYear.EMPTY);
            para.setKizyunnichi(FlexibleDate.EMPTY);
        }
        para.setNendochokindatacyusyutsu(div.getChkChokkinNomiA().isAllSelected());
        para.setJigyotaishoshafutanichiwari(div.getChkFutanWariaiKubun().getSelectedKeys().contains(事業対象者負担１割KEY));
        para.setJigyotaishoshafutanniwari(div.getChkFutanWariaiKubun().getSelectedKeys().contains(事業対象者負担２割KEY));
        para.setCsvkomokumeifuka(get項目名付加());
        para.setCsvrenbanfuka(get連番付加());
        para.setCsvhitsukesurasyuhensyu(get日付スラッシュ付加());
        para.setAtenacyusyutsujyoken(get宛名抽出条件());
        para.setCyohyoid(汎用リスト_利用者負担割合帳票ID);
        para.setSyutsuryokujun(div.getCcdShutsuryokujun().get出力順ID());
        para.setSyutsuryokukomoku(get出力項目());
        return para;
    }

    private void restore汎用リスト_施設入退所BatchParameter(BatchParameterMap batchParameterMap) {
        ChushutsuHohoKubun 抽出方法区分 = batchParameterMap.getParameterValue(ChushutsuHohoKubun.class, 抽出方法区分パラメータ名称2);
        div.getRadChushutsuJokenB1().clearSelectedItem();
        div.getRadChushutsuJokenB2().clearSelectedItem();
        if (抽出方法区分.getコード().equals(ChushutsuHohoKubun.基準日.getコード())) {
            div.getRadChushutsuJokenB1().setSelectedKey(基準日KEY);
        } else {
            div.getRadChushutsuJokenB2().setSelectedKey(範囲KEY);
        }
        SoshitsuKubun 喪失区分 = batchParameterMap.getParameterValue(SoshitsuKubun.class, 喪失区分パラメータ名称2);
        div.getDdlSoshitsuKubun().setSelectedKey(喪失区分.getコード());
        restore抽出項目区分(batchParameterMap, 抽出項目区分パラメータ名称2);
        restore基準日(batchParameterMap, 基準日パラメータ名称2);
        restore日付範囲From(batchParameterMap, 日付範囲開始パラメータ名称2);
        restore日付範囲To(batchParameterMap, 日付範囲終了パラメータ名称2);
        restore基準日範囲パネル直近データ抽出(batchParameterMap, 基準日範囲パネル直近データ抽出パラメータ名称2);
        restoreCSV編集方法(batchParameterMap, 項目名付加パラメータ名称2, 連番付加パラメータ名称2, 日付スラッシュ付加パラメータ名称2);
        restore宛名抽出条件(batchParameterMap, 宛名抽出条件パラメータ名称2);
        Long 出力順 = batchParameterMap.getParameterValue(Long.class, 出力順パラメータ名称2);
        RString 出力項目 = batchParameterMap.getParameterValue(RString.class, 出力項目パラメータ名称2);
        RString 帳票ID = batchParameterMap.getParameterValue(RString.class, 帳票IDパラメータ名称1);
        if (出力順 != null) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(帳票ID), Long.valueOf(出力順.toString()));
        }
        if (!RString.isNullOrEmpty(出力項目)) {
            div.getCcdShutsuryokuKomoku().load(帳票ID, SubGyomuCode.DBD介護受給, 出力項目);
        }
    }

    private void restore汎用リスト_利用者負担額減免BatchParameter(BatchParameterMap batchParameterMap) {
        restore基準日範囲パネル直近データ抽出(batchParameterMap, 基準日範囲パネル直近データ抽出パラメータ名称1);
        restore申請者データ抽出(batchParameterMap, 申請者データ抽出パラメータ名称1);
        restore旧措置者(batchParameterMap, 旧措置者パラメータ名称1);
        restore却下者(batchParameterMap, 却下者パラメータ名称1);
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称1, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_訪問介護利用者負担額減額BatchParameter(BatchParameterMap batchParameterMap) {
        restore基準日範囲パネル直近データ抽出(batchParameterMap, 基準日範囲パネル直近データ抽出パラメータ名称1);
        restore法別区分(batchParameterMap, 法別区分パラメータ名称1);
        restore却下者(batchParameterMap, 却下者パラメータ名称1);
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称1, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_社会福祉法人軽減BatchParameter(BatchParameterMap batchParameterMap) {
        restore基準日範囲パネル直近データ抽出(batchParameterMap, 基準日範囲パネル直近データ抽出パラメータ名称1);
        restore申請者データ抽出(batchParameterMap, 申請者データ抽出パラメータ名称1);
        restore却下者(batchParameterMap, 却下者パラメータ名称1);
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称1, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_特別地域加算減免BatchParameter(BatchParameterMap batchParameterMap) {
        restore基準日範囲パネル直近データ抽出(batchParameterMap, 基準日範囲パネル直近データ抽出パラメータ名称1);
        restore申請者データ抽出(batchParameterMap, 申請者データ抽出パラメータ名称1);
        restore却下者(batchParameterMap, 却下者パラメータ名称1);
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称1, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_負担限度額認定BatchParameter(BatchParameterMap batchParameterMap) {
        restore基準日範囲パネル直近データ抽出(batchParameterMap, 基準日範囲パネル直近データ抽出パラメータ名称1);
        restore申請者データ抽出(batchParameterMap, 申請者データ抽出パラメータ名称1);
        restore旧措置者ck(batchParameterMap, 特定入所者旧措置者パラメータ名称, 特定入所者負担軽減者パラメータ名称, 特定入所者その他パラメータ名称);
        restore利用者負担段階ck(batchParameterMap, 特定入所者第一段階パラメータ名称, 特定入所者第二段階パラメータ名称,
                特定入所者第三段階パラメータ名称, 特定入所者課税層パラメータ名称);
        restore却下者(batchParameterMap, 却下者パラメータ名称1);
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称1, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_国保BatchParameter(BatchParameterMap batchParameterMap) {
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称3, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_後期高齢者BatchParameter(BatchParameterMap batchParameterMap) {
        restore喪失区分(batchParameterMap, 喪失区分パラメータ名称1);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称3, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_事業対象者BatchParameter(BatchParameterMap batchParameterMap) { 
        div.getRadChushutsuJokenB1().clearSelectedItem();
        div.getRadChushutsuJokenB2().clearSelectedItem();
        restore事業対象者データ抽出(batchParameterMap, 事業対象者データ抽出パラメータ名称);
        restore共通(batchParameterMap);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称3, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore汎用リスト_利用者負担割合BatchParameter(BatchParameterMap batchParameterMap) {
        restore表題(batchParameterMap, 表題パラメータ名称);
        restore出力方法(batchParameterMap, 出力方法パラメータ名称);
        restore抽出方法区分(batchParameterMap, 抽出方法区分パラメータ名称1);
        FlexibleYear 年度 = batchParameterMap.getParameterValue(FlexibleYear.class, 年度パラメータ名称);
        if (RString.isNullOrEmpty(年度.toDateString())) {
            div.getDdlKijunNendo().setSelectedKey(年度.toDateString());
        }
        FlexibleDate 基準日 = batchParameterMap.getParameterValue(FlexibleDate.class, 基準日パラメータ名称1);
        div.getTxtKijunDateA().setValue(flexibleDateToRDate(基準日));
        boolean 年度直近データ抽出 = batchParameterMap.getParameterValue(boolean.class, 年度直近データ抽出パラメータ名称);
        List<RString> selectedKeys = new ArrayList<>();
        if (年度直近データ抽出) {
            selectedKeys.add(年度直近データのみKEY);
        }
        div.getChkChokkinNomiA().setSelectedItemsByKey(selectedKeys);
        List<RString> 事業対象者負担selectedKeys = new ArrayList<>();
        boolean 事業対象者負担１割 = batchParameterMap.getParameterValue(boolean.class, 事業対象者負担１割パラメータ名称);
        boolean 事業対象者負担２割 = batchParameterMap.getParameterValue(boolean.class, 事業対象者負担２割パラメータ名称);
        if (事業対象者負担１割) {
            事業対象者負担selectedKeys.add(事業対象者負担１割KEY);
        }
        if (事業対象者負担２割) {
            事業対象者負担selectedKeys.add(事業対象者負担２割KEY);
        }
        div.getChkFutanWariaiKubun().setSelectedItemsByKey(事業対象者負担selectedKeys);
        restoreCSV編集方法(batchParameterMap, 項目名付加パラメータ名称1, 連番付加パラメータ名称1, 日付スラッシュ付加パラメータ名称1);
        restore宛名抽出条件(batchParameterMap, 宛名抽出条件パラメータ名称1);
        restore出力順_帳票ID_出力項目(batchParameterMap, 出力順パラメータ名称3, 帳票IDパラメータ名称1, 出力項目パラメータ名称1);
    }

    private void restore共通(BatchParameterMap batchParameterMap) {
        restore表題(batchParameterMap, 表題パラメータ名称);
        restore出力方法(batchParameterMap, 出力方法パラメータ名称);
        restore抽出方法区分(batchParameterMap, 抽出方法区分パラメータ名称1);
        restore抽出項目区分(batchParameterMap, 抽出項目区分パラメータ名称1);
        restore基準日(batchParameterMap, 基準日パラメータ名称1);
        restore日付範囲From(batchParameterMap, 日付範囲開始パラメータ名称1);
        restore日付範囲To(batchParameterMap, 日付範囲終了パラメータ名称1);
        restoreCSV編集方法(batchParameterMap, 項目名付加パラメータ名称1, 連番付加パラメータ名称1, 日付スラッシュ付加パラメータ名称1);
        restore宛名抽出条件(batchParameterMap, 宛名抽出条件パラメータ名称1);
    }

    private RString get表題() {
        return div.getTxtHyodaiMeisho().getValue();
    }

    private RString get出力方法() {
        return div.getRadShuturyokuHoho().getSelectedKey();
    }

    private ChushutsuHohoKubun get基準日範囲抽出方法区分() {
        if (基準日KEY.equals(div.getRadChushutsuJokenB1().getSelectedKey())) {
            return ChushutsuHohoKubun.基準日;
        }
        return ChushutsuHohoKubun.範囲;
    }

    private ChushutsuKomokuKubun get入所RbGr抽出項目区分() {
        if (入所日KEY.equals(div.getRadHaniJoken1().getSelectedKey())) {
            return ChushutsuKomokuKubun.入所日;
        }
        return ChushutsuKomokuKubun.退所日;
    }

    private ChushutsuKomokuKubun get申請日RbGr抽出項目区分() {
        if (申請日KEY.equals(div.getRadHaniJoken2().getSelectedKey())) {
            return ChushutsuKomokuKubun.申請日;
        } else if (適用年月日KEY.equals(div.getRadHaniJoken2().getSelectedKey())) {
            return ChushutsuKomokuKubun.適用年月日;
        } else if (有効期限KEY.equals(div.getRadHaniJoken2().getSelectedKey())) {
            return ChushutsuKomokuKubun.有効期限;
        } else {
            return ChushutsuKomokuKubun.決定日;
        }
    }

    private ChushutsuKomokuKubun get取得喪失RbGr抽出項目区分() {
        if (取得日KEY.equals(div.getRadHaniJoken3().getSelectedKey())) {
            return ChushutsuKomokuKubun.取得日;
        } else {
            return ChushutsuKomokuKubun.喪失日;
        }
    }

    private ChushutsuKomokuKubun get適用開始日RbGr抽出項目区分() {
        if (適用開始日KEY.equals(div.getRadHaniJoken4().getSelectedKey())) {
            return ChushutsuKomokuKubun.適用開始日;
        } else if (適用終了日KEY.equals(div.getRadHaniJoken4().getSelectedKey())) {
            return ChushutsuKomokuKubun.適用終了日;
        } else {
            return ChushutsuKomokuKubun.チェックリスト実施日;
        }
    }

    private FlexibleDate get基準日() {
        if (基準日KEY.equals(div.getRadChushutsuJokenB1().getSelectedKey())) {
            return new FlexibleDate(div.getTxtKijunDateB().getValue().toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private FlexibleDate get日付範囲From() {
        if (範囲KEY.equals(div.getRadChushutsuJokenB2().getSelectedKey()) && div.getTxtChushutsuHani().getFromValue() != null) {
            return new FlexibleDate(div.getTxtChushutsuHani().getFromValue().toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private FlexibleDate get日付範囲To() {
        if (範囲KEY.equals(div.getRadChushutsuJokenB2().getSelectedKey()) && div.getTxtChushutsuHani().getToValue() != null) {
            return new FlexibleDate(div.getTxtChushutsuHani().getToValue().toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private boolean get基準日範囲パネル直近データ抽出() {
        return div.getChkChokkinNomi2().getSelectedKeys().contains(直近データのみKEY);
    }

    private boolean get申請者データ抽出() {
        return div.getChkShinseishaNomi().getSelectedKeys().contains(申請者データ抽出KEY);
    }

    private RString get旧措置者() {
        if (!div.getDdlKyuSochisya().isDisabled()) {
            return KyuShochiSha.toValue(div.getDdlKyuSochisya().getSelectedKey()).getコード();
        }
        return RString.EMPTY;
    }

    private RString get法別区分() {
        if (!div.getDdlHoubetsuKubun().isDisabled()) {
            return HobetsuKubun.toValue(div.getDdlHoubetsuKubun().getSelectedKey()).getコード();
        }
        return RString.EMPTY;
    }

    private RString get却下者() {
        if (!div.getDdlKyakkasha().isDisabled()) {
            return Kyakasha.toValue(div.getDdlKyakkasha().getSelectedKey()).getコード();
        }
        return RString.EMPTY;
    }

    private RString get喪失区分() {
        if (!div.getDdlSoshitsuKubun().isDisabled()) {
            return SoshitsuKubun.toValue(div.getDdlSoshitsuKubun().getSelectedKey()).getコード();
        }
        return RString.EMPTY;
    }

    private boolean get項目名付加() {
        return div.getChkCsvHenshuHoho().getSelectedKeys().contains(項目名付加KEY);
    }

    private boolean get連番付加() {
        return div.getChkCsvHenshuHoho().getSelectedKeys().contains(連番付加KEY);
    }

    private boolean get日付スラッシュ付加() {
        return div.getChkCsvHenshuHoho().getSelectedKeys().contains(日付スラッシュ付加KEY);
    }

    private AtenaSelectBatchParameter get宛名抽出条件() {
        return div.getCcdHanyoListAtenaSelect().get宛名抽出条件();
    }

    private RString get出力順() {
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            return new RString(div.getCcdShutsuryokujun().get出力順ID());
        }
        return RString.EMPTY;
    }

    private RString get出力項目() {
        if (!div.getCcdShutsuryokuKomoku().isDisabled()) {
            return div.getCcdShutsuryokuKomoku().get出力項目ID();
        }
        return RString.EMPTY;
    }

    private boolean 旧措置者Ck(RString key) {
        return div.getChkKyuSochisha().getSelectedKeys().contains(key);
    }

    private boolean 特定入所者Ck(RString key) {
        if (!div.getChushutsuJokenC3().isDisabled() && !div.getChushutsuJokenC4().isDisabled()) {
            return div.getChkRiyousyaFutanDankai().getSelectedKeys().contains(key);
        }
        return false;
    }

    private void restore表題(BatchParameterMap map, RString fieldName) {
        RString 表題 = map.getParameterValue(RString.class, fieldName);
        div.getTxtHyodaiMeisho().setValue(表題);
    }

    private void restore出力方法(BatchParameterMap map, RString fieldName) {
        RString 出力方法 = map.getParameterValue(RString.class, fieldName);
        div.getRadShuturyokuHoho().setSelectedKey(出力方法);
    }

    private void restore抽出方法区分(BatchParameterMap map, RString fieldName) {
        RString 抽出方法区分 = map.getParameterValue(RString.class, fieldName);
        if (抽出方法区分.equals(ChushutsuHohoKubun.年度.getコード())) {
            div.getRadChushutsuJokenA1().setSelectedKey(年度KEY);
        } else if (抽出方法区分.equals(ChushutsuHohoKubun.年度基準日.getコード())) {
            div.getRadChushutsuJokenA2().setSelectedKey(年度基準日KEY);
        } else if (抽出方法区分.equals(ChushutsuHohoKubun.基準日.getコード())) {
            div.getRadChushutsuJokenB1().setSelectedKey(基準日KEY);
        } else {
            div.getRadChushutsuJokenB2().setSelectedKey(範囲KEY);
        }
    }

    private void restore抽出項目区分(BatchParameterMap map, RString fieldName) {
        RString 抽出項目区分 = map.getParameterValue(RString.class, fieldName);
        if (抽出項目区分.equals(ChushutsuKomokuKubun.チェックリスト実施日.getコード())) {
            div.getRadHaniJoken4().setSelectedKey(チェックリスト実施日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.入所日.getコード())) {
            div.getRadHaniJoken1().setSelectedKey(入所日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.取得日.getコード())) {
            div.getRadHaniJoken3().setSelectedKey(取得日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.喪失日.getコード())) {
            div.getRadHaniJoken3().setSelectedKey(喪失日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.有効期限.getコード())) {
            div.getRadHaniJoken2().setSelectedKey(有効期限KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.決定日.getコード())) {
            div.getRadHaniJoken2().setSelectedKey(決定日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.申請日.getコード())) {
            div.getRadHaniJoken2().setSelectedKey(申請日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.退所日.getコード())) {
            div.getRadHaniJoken1().setSelectedKey(退所日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.適用年月日.getコード())) {
            div.getRadHaniJoken2().setSelectedKey(適用年月日KEY);
        } else if (抽出項目区分.equals(ChushutsuKomokuKubun.適用終了日.getコード())) {
            div.getRadHaniJoken4().setSelectedKey(適用終了日KEY);
        } else {
            div.getRadHaniJoken4().setSelectedKey(適用開始日KEY);
        }
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        if (date != null && date.isValid()) {
            return new RDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
        }
        return null;
    }

    private void restore基準日(BatchParameterMap map, RString fieldName) {
        FlexibleDate 基準日 = map.getParameterValue(FlexibleDate.class, fieldName);
        div.getTxtKijunDateB().setValue(flexibleDateToRDate(基準日));
    }

    private void restore日付範囲From(BatchParameterMap map, RString fieldName) {
        FlexibleDate 日付範囲From = map.getParameterValue(FlexibleDate.class, fieldName);
        div.getTxtChushutsuHani().setFromValue(flexibleDateToRDate(日付範囲From));
    }

    private void restore日付範囲To(BatchParameterMap map, RString fieldName) {
        FlexibleDate 日付範囲To = map.getParameterValue(FlexibleDate.class, fieldName);
        div.getTxtChushutsuHani().setToValue(flexibleDateToRDate(日付範囲To));
    }

    private void restore基準日範囲パネル直近データ抽出(BatchParameterMap map, RString fieldName) {
        boolean 直近データ抽出 = map.getParameterValue(boolean.class, fieldName);
        List<RString> selectedKeys = new ArrayList<>();
        if (直近データ抽出) {
            selectedKeys.add(直近データのみKEY);
        }
        div.getChkChokkinNomi2().setSelectedItemsByKey(selectedKeys);

    }

    private void restore申請者データ抽出(BatchParameterMap map, RString fieldName) {
        boolean 申請者データ抽出 = map.getParameterValue(boolean.class, fieldName);
        List<RString> selectedKeys = new ArrayList<>();
        if (申請者データ抽出) {
            selectedKeys.add(申請者データ抽出KEY);
        }
        div.getChkShinseishaNomi().setSelectedItemsByKey(selectedKeys);
    }

    private void restore旧措置者(BatchParameterMap map, RString fieldName) {
        RString 旧措置者 = map.getParameterValue(RString.class, fieldName);
        div.getDdlKyuSochisya().setSelectedKey(旧措置者);
    }

    private void restore法別区分(BatchParameterMap map, RString fieldName) {
        RString 法別区分 = map.getParameterValue(RString.class, fieldName);
        div.getDdlHoubetsuKubun().setSelectedKey(法別区分);
    }

    private void restore却下者(BatchParameterMap map, RString fieldName) {
        RString 却下者 = map.getParameterValue(RString.class, fieldName);
        div.getDdlKyakkasha().setSelectedKey(却下者);
    }

    private void restore喪失区分(BatchParameterMap map, RString fieldName) {
        RString 喪失区分 = map.getParameterValue(RString.class, fieldName);
        div.getDdlSoshitsuKubun().setSelectedKey(喪失区分);
    }

    private void restoreCSV編集方法(BatchParameterMap map, RString 項目名付加fieldName, RString 連番付加fieldName, RString 日付スラッシュ付加fieldName) {
        boolean 項目名付加 = map.getParameterValue(boolean.class, 項目名付加fieldName);
        boolean 連番付加 = map.getParameterValue(boolean.class, 連番付加fieldName);
        boolean 日付スラッシュ付加 = map.getParameterValue(boolean.class, 日付スラッシュ付加fieldName);
        List<RString> selectedKeys = new ArrayList<>();
        if (項目名付加) {
            selectedKeys.add(項目名付加KEY);
        }
        if (連番付加) {
            selectedKeys.add(連番付加KEY);
        }
        if (日付スラッシュ付加) {
            selectedKeys.add(日付スラッシュ付加KEY);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(selectedKeys);

    }

    private void restore宛名抽出条件(BatchParameterMap map, RString fieldName) {
        AtenaSelectBatchParameter 宛名抽出条件 = map.getParameterValue(AtenaSelectBatchParameter.class, fieldName);
        get宛名抽出条件div().set年齢層抽出方法(宛名抽出条件.getAgeSelectKijun().getコード());
        get宛名抽出条件div().onChange_SelectKijun();
        get宛名抽出条件div().set年齢開始(宛名抽出条件.getNenreiRange().getFrom());
        get宛名抽出条件div().set年齢終了(宛名抽出条件.getNenreiRange().getTo());
        get宛名抽出条件div().set年齢基準日(宛名抽出条件.getNenreiKijunbi());
        get宛名抽出条件div().set生年月日開始(宛名抽出条件.getSeinengappiRange().getFrom());
        get宛名抽出条件div().set生年月日終了(宛名抽出条件.getSeinengappiRange().getTo());
        get宛名抽出条件div().set地区(宛名抽出条件.getChiku_Kubun().getコード());
        get宛名抽出条件div().set保険者(宛名抽出条件.getShichoson_Code());
        get宛名抽出条件div().onChange_SelectChiku();
        get宛名抽出条件div().set住所開始(new ChoikiCode(宛名抽出条件.getJusho_From()));
        get宛名抽出条件div().set住所終了(new ChoikiCode(宛名抽出条件.getJusho_To()));
        get宛名抽出条件div().set行政区開始(new GyoseikuCode(宛名抽出条件.getGyoseiku_From()));
        get宛名抽出条件div().set行政区終了(new GyoseikuCode(宛名抽出条件.getGyoseiku_To()));
        get宛名抽出条件div().set地区１開始(new ChikuCode(宛名抽出条件.getChiku1_From()));
        get宛名抽出条件div().set地区１終了(new ChikuCode(宛名抽出条件.getChiku1_To()));
        get宛名抽出条件div().set地区２開始(new ChikuCode(宛名抽出条件.getChiku2_From()));
        get宛名抽出条件div().set地区２終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
        get宛名抽出条件div().set地区３開始(new ChikuCode(宛名抽出条件.getChiku3_From()));
        get宛名抽出条件div().set地区３終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
    }

    private void restore出力順_帳票ID_出力項目(BatchParameterMap map, RString 出力順fieldName, RString 帳票IDfieldName, RString 出力項目fieldName) {
        RString 出力順 = map.getParameterValue(RString.class, 出力順fieldName);
        RString 帳票ID = map.getParameterValue(RString.class, 帳票IDfieldName);
        RString 出力項目 = map.getParameterValue(RString.class, 出力項目fieldName);
        if (!RString.isNullOrEmpty(出力項目)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(帳票ID), Long.valueOf(出力順.toString()));
        }
        if (!RString.isNullOrEmpty(帳票ID)) {
            div.getCcdShutsuryokuKomoku().load(帳票ID, SubGyomuCode.DBD介護受給, 出力項目);
        }
    }

    private void restore旧措置者ck(BatchParameterMap map, RString 旧措置者fieldName, RString 負担軽減者fieldName, RString その他fieldName) {
        boolean 旧措置者 = map.getParameterValue(boolean.class, 旧措置者fieldName);
        boolean 負担軽減者 = map.getParameterValue(boolean.class, 負担軽減者fieldName);
        boolean その他 = map.getParameterValue(boolean.class, その他fieldName);
        List<RString> selectedKeys = new ArrayList<>();
        if (旧措置者) {
            selectedKeys.add(旧措置者KEY);
        }
        if (負担軽減者) {
            selectedKeys.add(旧措置者実質的負担軽減者KEY);
        }
        if (その他) {
            selectedKeys.add(それ以外KEY);
        }
        div.getChkKyuSochisha().setSelectedItemsByKey(selectedKeys);
    }

    private void restore利用者負担段階ck(BatchParameterMap map,
            RString 第一段階fieldName,
            RString 第二段階fieldName,
            RString 第三段階fieldName,
            RString 課税層fieldName) {
        boolean 第一段階 = map.getParameterValue(boolean.class, 第一段階fieldName);
        boolean 第二段階 = map.getParameterValue(boolean.class, 第二段階fieldName);
        boolean 第三段階 = map.getParameterValue(boolean.class, 第三段階fieldName);
        boolean 課税層 = map.getParameterValue(boolean.class, 課税層fieldName);
        List<RString> selectedKeys = new ArrayList<>();
        if (第一段階) {
            selectedKeys.add(第一段階KEY);
        }
        if (第二段階) {
            selectedKeys.add(第二段階KEY);
        }
        if (第三段階) {
            selectedKeys.add(第三段階KEY);
        }
        if (課税層) {
            selectedKeys.add(課税層第三段階KEY);
        }
        div.getChkRiyousyaFutanDankai().setSelectedItemsByKey(selectedKeys);
    }

    private void restore事業対象者データ抽出(BatchParameterMap map, RString fieldName) {
        boolean 事業対象者データ抽出 = map.getParameterValue(boolean.class, fieldName);
        if (事業対象者データ抽出) {
            div.getRadChusyutuKubun().setSelectedKey(直近データKEY);
        } else {
            div.getRadChusyutuKubun().setSelectedKey(すべてKEY);
        }
    }

    private void 初期化_施設入退所() {
        div.getRadShuturyokuHoho().setSelectedKey(Outputs.CSVのみ出力.getコード());
        div.getRadShuturyokuHoho().setDisabled(非表示);
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(表示, 非表示, 非表示, 非表示);
        div.getRadHaniJoken1().setSelectedKey(入所日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_施設入退所_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(RString.EMPTY);
        set申請者のみCb(非表示);
        set直近データCb(表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 非表示, 非表示, 表示);
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_利用者負担額減免() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 表示, 非表示);
        div.getRadHaniJoken2().setSelectedKey(申請日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_利用者負担額減免_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_利用者負担額減免_基準日説明TEXT);
        set申請者のみCb(表示);
        set直近データCb(表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(表示, 非表示, 表示, 表示);
        div.getDdlKyuSochisya().setSelectedKey(KyuShochiSha.旧措置含.getコード());
        div.getDdlKyakkasha().setSelectedKey(Kyakasha.却下含.getコード());
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_訪問介護利用者負担額減額() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 表示, 非表示);
        div.getRadHaniJoken2().setSelectedKey(申請日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_利用者負担額減免_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_利用者負担額減免_基準日説明TEXT);
        set申請者のみCb(非表示);
        set直近データCb(表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 表示, 表示, 表示);
        div.getDdlHoubetsuKubun().setSelectedKey(HobetsuKubun.すべて.getコード());
        div.getDdlKyakkasha().setSelectedKey(Kyakasha.却下含.getコード());
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_社会福祉法人軽減() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 表示, 非表示);
        div.getRadHaniJoken2().setSelectedKey(申請日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_社会福祉法人軽減_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_利用者負担額減免_基準日説明TEXT);
        set申請者のみCb(表示);
        set直近データCb(表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 非表示, 表示, 表示);
        div.getDdlKyakkasha().setSelectedKey(Kyakasha.却下含.getコード());
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_特別地域加算減免() {
        // TODO : 帳票も出力するようになったら下を採用
        div.getRadShuturyokuHoho().setSelectedKey(Outputs.CSVのみ出力.getコード());
        div.getRadShuturyokuHoho().setDisplayNone(非表示);
        div.getRadShuturyokuHoho().setDisabled(非表示);
//        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 表示, 非表示);
        div.getRadHaniJoken2().setSelectedKey(申請日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_利用者負担額減免_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_利用者負担額減免_基準日説明TEXT);
        set申請者のみCb(表示);
        set直近データCb(表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 非表示, 表示, 表示);
        div.getDdlKyakkasha().setSelectedKey(Kyakasha.却下含.getコード());
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        // TODO : 出力項目選択ができるようになったら表示に変える
        set出力項目選択(非表示);
    }

    private void 初期化_負担限度額認定() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 表示, 非表示);
        div.getRadHaniJoken2().setSelectedKey(申請日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_負担限度額認定_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_利用者負担額減免_基準日説明TEXT);
        set申請者のみCb(表示);
        set直近データCb(表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 非表示, 表示, 表示);
        div.getDdlKyakkasha().setSelectedKey(Kyakasha.却下含.getコード());
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_国保() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 表示, 非表示, 非表示);
        div.getRadHaniJoken3().setSelectedKey(取得日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_国保_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_国保_基準日説明TEXT);
        set申請者のみCb(非表示);
        set直近データCb(非表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 非表示, 非表示, 表示);
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_後期高齢者() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 表示, 非表示, 非表示);
        div.getRadHaniJoken3().setSelectedKey(取得日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_国保_基準日TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_国保_基準日説明TEXT);
        set申請者のみCb(非表示);
        set直近データCb(非表示);
        set事業対象者抽出区分パネル(非表示, 非表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        set旧措置者DDLパネル(非表示, 非表示, 非表示, 表示);
        div.getDdlSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        set宛名抽出条件パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_事業対象者() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(非表示);
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 非表示, 表示);
        div.getRadHaniJoken4().setSelectedKey(適用開始日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_事業対象者TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_事業対象者説明TEXT);
        set申請者のみCb(非表示);
        set直近データCb(非表示);
        set事業対象者抽出区分パネル(表示, 非表示);
        div.getRadChusyutuKubun().setSelectedKey(直近データKEY);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        div.getChushutsuJokenC5().setDisplayNone(非表示);
        div.getChushutsuJokenC5().setDisabled(非表示);
        get宛名抽出条件div().initialize();
        get宛名抽出条件子Div().getRadSelectKijun().setDisplayNone(非表示);
        get宛名抽出条件子Div().getRadSelectKijun().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtNenrei().setDisplayNone(非表示);
        get宛名抽出条件子Div().getTxtNenrei().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtNenreiKijunbi().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtNenreiKijunbi().setDisplayNone(非表示);
        get宛名抽出条件子Div().getTxtSeinengappi().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtSeinengappi().setDisplayNone(非表示);
        set宛名抽出条件共有パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private void 初期化_利用者負担割合() {
        init出力方法ラジオボタン_グループ();
        set年度基準日パネル(表示);
        div.getRadChushutsuJokenA1().setSelectedKey(年度KEY);
        div.getDdlKijunNendo().setSelectedKey(NendoUtil.getNendo(RDate.getNowDate()).toDateString());
        div.getTxtKijunDateA().clearValue();
        set基準日RbGr();
        set基準日範囲パネル(非表示, 非表示, 非表示, 表示);
        div.getRadHaniJoken4().setSelectedKey(適用開始日KEY);
        set基準日_範囲条件();
        div.getTxtKijunDateB().setLabelRText(汎用リスト_事業対象者TEXT);
        div.getLblJitenTaishoshaB().setText(汎用リスト_事業対象者説明TEXT);
        set申請者のみCb(非表示);
        set直近データCb(非表示);
        set事業対象者抽出区分パネル(表示, 表示);
        set旧措置者チェックBOXパネル(非表示);
        set利用者負担段階(表示);
        div.getChushutsuJokenC5().setDisplayNone(非表示);
        div.getChushutsuJokenC5().setDisabled(非表示);
        get宛名抽出条件div().initialize();
        get宛名抽出条件子Div().getRadSelectKijun().setDisplayNone(非表示);
        get宛名抽出条件子Div().getRadSelectKijun().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtNenrei().setDisplayNone(非表示);
        get宛名抽出条件子Div().getTxtNenrei().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtNenreiKijunbi().setDisabled(非表示);
        get宛名抽出条件子Div().getTxtNenreiKijunbi().setDisplayNone(非表示);
        get宛名抽出条件子Div().getTxtSeinengappi().setDisplayNone(非表示);
        get宛名抽出条件子Div().getTxtSeinengappi().setDisabled(非表示);
        set宛名抽出条件共有パネル();
        setCSV編集条件パネル();
        set出力項目選択(表示);
    }

    private HanyoListAtenaSelectDiv get宛名抽出条件子Div() {
        return div.getCcdHanyoListAtenaSelect().get宛名抽出条件子Div();
    }

    private IHanyoListAtenaSelectDiv get宛名抽出条件div() {
        return div.getCcdHanyoListAtenaSelect();
    }

    private void set表題パネル(RString 表題) {
        div.getTxtHyodaiMeisho().setValue(表題);
    }

    private void set表題パネルis非表示(boolean is非表示) {
        div.getTxtHyodaiMeisho().setDisplayNone(is非表示);
        div.getTxtHyodaiMeisho().setDisabled(is非表示);
    }

    private void init出力方法ラジオボタン_グループ() {
        div.getRadShuturyokuHoho().setSelectedKey(Outputs.帳票_CSV出力.getコード());
    }

    private void set年度基準日パネル(boolean is非表示) {
        div.getChushutsuJokenA().setDisplayNone(is非表示);
        div.getChushutsuJokenA().setDisabled(is非表示);
    }

    private void set基準日RbGr() {
        div.getRadChushutsuJokenB1().setSelectedKey(基準日KEY);
    }

    private void set基準日範囲パネル(boolean 入所is非表示, boolean 取得喪失is非表示, boolean 申請日is非表示, boolean 適用開始日is非表示) {
        div.getRadHaniJoken1().setDisplayNone(入所is非表示);
        div.getRadHaniJoken1().setDisabled(入所is非表示);
        div.getRadHaniJoken3().setDisplayNone(取得喪失is非表示);
        div.getRadHaniJoken3().setDisabled(取得喪失is非表示);
        div.getRadHaniJoken2().setDisplayNone(申請日is非表示);
        div.getRadHaniJoken2().setDisabled(申請日is非表示);
        div.getRadHaniJoken4().setDisplayNone(適用開始日is非表示);
        div.getRadHaniJoken4().setDisabled(適用開始日is非表示);
    }

    private void set基準日_範囲条件() {
        div.getTxtKijunDateB().setValue(RDate.getNowDate());
        div.getTxtChushutsuHani().clearFromValue();
        div.getTxtChushutsuHani().clearToValue();
        div.getChkShinseishaNomi().setDisabled(true);
        div.getChkShinseishaNomi().setDisplayNone(true);
    }

    private void set申請者のみCb(boolean is非表示) {
        div.getChkShinseishaNomi().setDisabled(is非表示);
        div.getChkShinseishaNomi().setDisplayNone(is非表示);
    }

    private void set直近データCb(boolean is非表示) {
        div.getChkChokkinNomi2().setDisplayNone(is非表示);
        div.getChkChokkinNomi2().setDisabled(is非表示);
    }

    private void set事業対象者抽出区分パネル(boolean 抽出区分is非表示, boolean 負担割合is非表示) {
        div.getChushutsuJokenC1().setDisplayNone(抽出区分is非表示);
        div.getChushutsuJokenC1().setDisabled(抽出区分is非表示);
        div.getChushutsuJokenC2().setDisplayNone(負担割合is非表示);
        div.getChushutsuJokenC2().setDisabled(負担割合is非表示);
    }

    private void set旧措置者チェックBOXパネル(boolean is非表示) {
        div.getChushutsuJokenC3().setDisplayNone(is非表示);
        div.getChushutsuJokenC3().setDisabled(is非表示);
    }

    private void set利用者負担段階(boolean is表示) {
        div.getChushutsuJokenC4().setDisplayNone(is表示);
        div.getChushutsuJokenC4().setDisabled(is表示);
    }

    private void set旧措置者DDLパネル(boolean 旧措置者DDLIs非表示, boolean 法別区分DDLIs非表示, boolean 却下者DDLIs非表示, boolean 喪失区分DDLIs非表示) {
        div.getDdlKyuSochisya().setDisplayNone(旧措置者DDLIs非表示);
        div.getDdlKyuSochisya().setDisabled(旧措置者DDLIs非表示);
        div.getDdlHoubetsuKubun().setDisplayNone(法別区分DDLIs非表示);
        div.getDdlHoubetsuKubun().setDisabled(法別区分DDLIs非表示);
        div.getDdlKyakkasha().setDisplayNone(却下者DDLIs非表示);
        div.getDdlKyakkasha().setDisabled(却下者DDLIs非表示);
        div.getDdlSoshitsuKubun().setDisplayNone(喪失区分DDLIs非表示);
        div.getDdlSoshitsuKubun().setDisabled(喪失区分DDLIs非表示);
    }

    private void set宛名抽出条件パネル() {
        get宛名抽出条件div().initialize();
        get宛名抽出条件子Div().getRadSelectKijun().setSelectedKey(NenreiSoChushutsuHoho.年齢範囲.getコード());
        get宛名抽出条件子Div().getTxtNenrei().clearFromValue();
        get宛名抽出条件子Div().getTxtNenrei().clearFromValue();
        get宛名抽出条件子Div().getTxtNenreiKijunbi().clearValue();
        set宛名抽出条件共有パネル();
    }

    private void set宛名抽出条件共有パネル() {
        get宛名抽出条件div().set地区(Chiku.全て.getコード());
        get宛名抽出条件div().set保険者();
        get宛名抽出条件子Div().getTxtSeinengappi().clearFromValue();
        get宛名抽出条件子Div().getTxtSeinengappi().clearToValue();
    }

    private void setCSV編集条件パネル() {
        List<RString> selectedKeys = new ArrayList<>();
        selectedKeys.add(項目名付加KEY);
        selectedKeys.add(日付スラッシュ付加KEY);
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(selectedKeys);
    }

    private void set出力項目選択(boolean is非表示) {
        div.getCcdShutsuryokuKomoku().setDisplayNone(is非表示);
        div.getCcdShutsuryokuKomoku().setDisabled(is非表示);
    }

    private BatchParameterMap getBatchParameterMap() {
        return div.getBtnParamRestore().getRestoreBatchParameterMap();
    }
}
