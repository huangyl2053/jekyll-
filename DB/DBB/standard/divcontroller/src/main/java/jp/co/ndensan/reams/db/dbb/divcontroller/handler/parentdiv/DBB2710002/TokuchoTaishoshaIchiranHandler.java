/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiKouhoshaListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiKouhoshaShousaiJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoDouteiListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoMiDouteiListJoho;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.dgTokubetChoshuMidoteiIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.dgTokubetChoshuTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.dgTokuchoDoteiKohoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokuchoType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class TokuchoTaishoshaIchiranHandler {

    private final TokuchoTaishoshaIchiranDiv div;
    private final TokuchoTaishoshaIchiranSakusei tokudoutei;
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString すべて選択_VALUE = new RString("（すべて選択）");
    private static final RString 同定済一覧_VALUE = new RString("同定済一覧");
    private static final RString 未同定一覧_VALUE = new RString("未同定一覧");
    private static final RString 確認済を含む_VALUE = new RString("確認済を含む");
    private static final RString 帳票グループコード = new RString("DBB200018");
    private static final RString LEFT = new RString("(");
    private static final RString RIGHT = new RString(")");
    private static final RString 未同定_CODE = new RString("0");
    private static final RString 未同定_NAME = new RString("未同定");
    private static final RString 同定済み_CODE = new RString("1");
    private static final RString 同定済み_NAME = new RString("同定済み");
    private static final RString 対象外_CODE = new RString("2");
    private static final RString 対象外_NAME = new RString("対象外");
    private static final RString 特別徴収義務者コード種別 = new RString("0047");
    private static final RString 介護資格取得事由コード種別 = new RString("0007");
    private static final RString 介護資格喪失事由コード種別 = new RString("0010");
    private static final RString TOPINFO = new RString("被保険者番号：");
    private static final RString BOTTOMINFO = new RString("氏名：");
    private static final RString BTN同定する = new RString("btnDoutei");
    private static final RString BTN同定対象外確認済にする = new RString("btnTaishoGai");
    private static final RString 月 = new RString("月");
    private static final RString 一行のみ該当する場合 = new RString("1");
    private static final RString 複数行が該当する場合 = new RString("2");
    private static final RString 状態なし = new RString("0");
    private static final RString 一致理由_01 = new RString("01");
    private static final RString 一致理由_02 = new RString("02");
    private static final RString 一致理由_03 = new RString("03");
    private static final RString 一致理由_04 = new RString("04");
    private static final RString 一致理由_05 = new RString("05");
    private static final RString 一致理由_06 = new RString("06");
    private static final RString 一致理由_09 = new RString("09");
    private static final RString 一致理由_10 = new RString("10");
    private static final RString 一致理由_11 = new RString("11");
    private static final RString 一致理由_12 = new RString("12");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private static final RString 特別徴収対象者一覧作成 = new RString("特別徴収対象者一覧作成");
    private static final RString 特別徴収対象者一覧確認 = new RString("特別徴収対象者一覧確認");
    private static final RString STATE特別徴収対象者一覧作成 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div TokuchoTaishoshaIchiranDiv
     */
    public TokuchoTaishoshaIchiranHandler(TokuchoTaishoshaIchiranDiv div) {
        this.div = div;
        tokudoutei = TokuchoTaishoshaIchiranSakusei.createInstance();
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @return TokuchoTaishoshaIchiranSakuseiResult
     */
    public TokuchoTaishoshaIchiranSakuseiResult 特別徴収対象者一覧作成initialize() {
        div.setHiddenPageState(STATE特別徴収対象者一覧作成);
        RDate nowDate = RDate.getNowDate();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        TokuchoTaishoshaIchiranSakuseiResult result = tokudoutei.getKonkaiShoriJoho(new FlexibleYear(調定年度));
        if (result != null) {
            RString 特別徴収開始月;
            if (result.get特別徴収開始月() != null) {
                特別徴収開始月 = DateConverter.getDate256(new RYearMonth(result.get特別徴収開始月()));
            } else {
                特別徴収開始月 = RString.EMPTY;
            }
            if (result.get捕捉月表示内容() != null) {
                特別徴収開始月 = 特別徴収開始月.concat(RString.FULL_SPACE).concat(LEFT)
                        .concat(result.get捕捉月表示内容()).concat(RIGHT);
            }
            result.set捕捉月リスト(new ArrayList());
            if (result.get捕捉月１() != null) {
                RString 捕捉月 = result.get捕捉月１().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            if (result.get捕捉月２() != null) {
                RString 捕捉月 = result.get捕捉月２().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            if (result.get捕捉月３() != null) {
                RString 捕捉月 = result.get捕捉月３().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            div.getTokuchoTaishoshaIchiranSelectJokenPanel().getTxtKaishiYM().setValue(特別徴収開始月);
            result.set特別徴収開始月(特別徴収開始月);
        }
        List<KeyValueDataSource> chkList = new ArrayList();
        List<KeyValueDataSource> selectedList = new ArrayList();
        KeyValueDataSource source0 = new KeyValueDataSource(KEY0, すべて選択_VALUE);
        KeyValueDataSource source1 = new KeyValueDataSource(KEY1, 同定済一覧_VALUE);
        KeyValueDataSource source2 = new KeyValueDataSource(KEY2, 未同定一覧_VALUE);
        chkList.add(source0);
        chkList.add(source1);
        chkList.add(source2);
        selectedList.add(source0);
        div.getChkShutsuryokuTaisho().setDataSource(chkList);
        div.getChkShutsuryokuTaisho().setSelectedItems(selectedList);
        chkList.remove(source0);
        div.getChkShutsuryokuTaisho().setDisabledItem(chkList);
        div.getCcdOutputChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 帳票グループコード);
        return result;
    }

    /**
     * 同定非同定表示に戻るinitializeのメソッドです。
     */
    public void 同定非同定表示に戻るinitialize() {
        RDate nowDate = RDate.getNowDate();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        TokuchoTaishoshaIchiranSakuseiResult result = tokudoutei.getKonkaiShoriJoho(new FlexibleYear(調定年度));
        RString 特別徴収開始月 = RString.EMPTY;
        if (result != null) {
            if (!RString.isNullOrEmpty(result.get特別徴収開始月())) {
                特別徴収開始月 = DateConverter.getDate256(new RYearMonth(result.get特別徴収開始月()));
            }
            if (!RString.isNullOrEmpty(result.get捕捉月表示内容())) {
                特別徴収開始月 = 特別徴収開始月.concat(RString.FULL_SPACE).concat(LEFT)
                        .concat(result.get捕捉月表示内容()).concat(RIGHT);
            }
            result.set捕捉月リスト(new ArrayList());
            if (!RString.isNullOrEmpty(result.get捕捉月１())) {
                RString 捕捉月 = result.get捕捉月１().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            if (!RString.isNullOrEmpty(result.get捕捉月２())) {
                RString 捕捉月 = result.get捕捉月２().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            if (!RString.isNullOrEmpty(result.get捕捉月３())) {
                RString 捕捉月 = result.get捕捉月３().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
        }
        if (RString.isNullOrEmpty(特別徴収開始月)) {
            div.getTxtKaishiYM().clearValue();
        } else {
            div.getTxtKaishiYM().setValue(特別徴収開始月);
        }
        RString radhyojiTaisho = ViewStateHolder.get(ViewStateKeys.表示対象, RString.class);
        if (KEY0.equals(radhyojiTaisho)) {
            div.getRadhyojiTaisho().setSelectedValue(同定済一覧_VALUE);
        } else {
            div.getRadhyojiTaisho().setSelectedValue(未同定一覧_VALUE);
        }
        onChange_Rad表示対象(div);
        boolean chkKakuninZumiFukumu = ViewStateHolder.get(ViewStateKeys.確認済を含む, boolean.class);
        List<RString> selectedKeys = new ArrayList<>();
        if (chkKakuninZumiFukumu) {
            selectedKeys.add(KEY0);
        }
        div.getChkKakuninZumiFukumu().setSelectedItemsByKey(selectedKeys);
        RString 最大表示件数 = ViewStateHolder.get(ViewStateKeys.最大表示件数, RString.class);
        div.getTxtMaxHyojiKensu().setValue(最大表示件数);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @return TokuchoTaishoshaIchiranSakuseiResult
     */
    public TokuchoTaishoshaIchiranSakuseiResult 同定非同定表示initialize() {
        div.getRadhyojiTaisho().setSelectedValue(未同定一覧_VALUE);
        onChange_Rad表示対象(div);
        RDate nowDate = RDate.getNowDate();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        TokuchoTaishoshaIchiranSakuseiResult result = tokudoutei.getKonkaiShoriJoho(new FlexibleYear(調定年度));
        if (result != null) {
            RString 特別徴収開始月 = RString.EMPTY;
            if (!RString.isNullOrEmpty(result.get特別徴収開始月())) {
                特別徴収開始月 = DateConverter.getDate256(new RYearMonth(result.get特別徴収開始月()));
            }
            if (!RString.isNullOrEmpty(result.get捕捉月表示内容())) {
                特別徴収開始月 = 特別徴収開始月.concat(RString.FULL_SPACE).concat(LEFT)
                        .concat(result.get捕捉月表示内容()).concat(RIGHT);
            }
            result.set捕捉月リスト(new ArrayList());
            if (!RString.isNullOrEmpty(result.get捕捉月１())) {
                RString 捕捉月 = result.get捕捉月１().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            if (!RString.isNullOrEmpty(result.get捕捉月２())) {
                RString 捕捉月 = result.get捕捉月２().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            if (!RString.isNullOrEmpty(result.get捕捉月３())) {
                RString 捕捉月 = result.get捕捉月３().substring(NUM4, NUM6);
                result.get捕捉月リスト().add(捕捉月);
            }
            div.getTokuchoTaishoshaIchiranSelectJokenPanel().getTxtKaishiYM().setValue(特別徴収開始月);
            result.set特別徴収開始月(特別徴収開始月);
        }
        List<KeyValueDataSource> radList = new ArrayList();
        KeyValueDataSource source0 = new KeyValueDataSource(KEY0, 同定済一覧_VALUE);
        KeyValueDataSource source1 = new KeyValueDataSource(KEY1, 未同定一覧_VALUE);
        radList.add(source0);
        radList.add(source1);
        div.getRadhyojiTaisho().setDataSource(radList);
        div.getRadhyojiTaisho().setSelectedKey(KEY0);
        List<KeyValueDataSource> 確認済を含むList = new ArrayList();
        KeyValueDataSource source = new KeyValueDataSource(KEY0, 確認済を含む_VALUE);
        確認済を含むList.add(source);
        div.getChkKakuninZumiFukumu().setDataSource(確認済を含むList);
        onChange_Rad表示対象(div);
        RString 最大表示件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                nowDate, SubGyomuCode.DBU介護統計報告);
        div.getTxtMaxHyojiKensu().setValue(最大表示件数);
        return result;
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 特別徴収開始月 RString
     * @param 捕捉月リスト List<RString>
     * @return List<TokuchoDouteiListJoho>
     */
    public List<TokuchoDouteiListJoho> 特別徴収同定一覧initialize1(RString 特別徴収開始月, List<RString> 捕捉月リスト) {
        RDate nowDate = RDate.getNowDate();
        div.getTokuchoTaishoshaIchiranSelectJokenPanel().getTxtKaishiYM().setValue(特別徴収開始月);
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        RString 開始月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(特別徴収開始月) && !特別徴収開始月.startsWith(RString.FULL_SPACE)
                && !特別徴収開始月.startsWith(LEFT)) {
            開始月 = 特別徴収開始月.substringEmptyOnError(NUM4, NUM6);
        }
        return tokudoutei.getTokuchoTaishoListJoho(new FlexibleYear(処理年度), 開始月, 捕捉月リスト);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param result List<TokuchoDouteiListJoho>
     * @param 表示件数 int
     */
    public void 特別徴収同定一覧initialize2(List<TokuchoDouteiListJoho> result, int 表示件数) {
        List<dgTokubetChoshuTaishoshaIchiran_Row> dataGridList = new ArrayList();
        for (int i = NUM0; i < 表示件数; i++) {
            dgTokubetChoshuTaishoshaIchiran_Row newRow = new dgTokubetChoshuTaishoshaIchiran_Row();
            newRow.setHihokenshaNo(result.get(i).get被保険者番号());
            newRow.setShikibetsuCode(result.get(i).get識別コード());
            newRow.setShimei(result.get(i).get漢字氏名());
            if (!RString.isNullOrEmpty(result.get(i).get捕捉月())) {
                RString 捕捉月 = result.get(i).get捕捉月().replace(KEY0, RString.EMPTY).concat(月);
                newRow.setHosokuM(捕捉月);
            }
            RString 特別徴収義務者コード = result.get(i).get特徴義務者コード();
            if (特別徴収義務者コード != null) {
                RString codeMeisho = CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課,
                        new CodeShubetsu(特別徴収義務者コード種別), new Code(特別徴収義務者コード));
                newRow.setTokuchoGimusha(codeMeisho);
            }
            newRow.setKisoNenkinNo(result.get(i).get基礎年金番号());
            newRow.setNenkinCode(result.get(i).get年金コード());
            RString 生年月日 = result.get(i).get生年月日();
            if (!RString.isNullOrEmpty(生年月日)) {
                newRow.setBirthDay(new RDate(生年月日.toString()).wareki().toDateString());
            }
            if (result.get(i).get性別コード() != null) {
                newRow.setSeibetsu(
                        SeibetsuCodeNenkinTokuchoType.toValue(result.get(i).get性別コード()).get性別名称());
            }
            newRow.setJusho(result.get(i).get住所());
            dataGridList.add(newRow);
        }
        div.getDgTokubetChoshuTaishoshaIchiran().setDataSource(dataGridList);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 特別徴収開始月 RString
     * @param 確認済を含む boolean
     * @param 捕捉月リスト List<RString>
     * @return List<TokuchoMiDouteiListJoho>
     */
    public List<TokuchoMiDouteiListJoho> 特別徴収未同定一覧initialize1(
            RString 特別徴収開始月, boolean 確認済を含む, List<RString> 捕捉月リスト) {
        RDate nowDate = RDate.getNowDate();
        div.getTokuchoTaishoshaIchiranSelectJokenPanel().getTxtKaishiYM().setValue(特別徴収開始月);
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
        RString 開始月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(特別徴収開始月) && !特別徴収開始月
                .startsWith(RString.FULL_SPACE) && !特別徴収開始月.startsWith(LEFT)) {
            開始月 = 特別徴収開始月.substringEmptyOnError(NUM4, NUM6);
        }
        return tokudoutei.getTokuchoMiTaishoListJoho(new FlexibleYear(処理年度), 開始月, 捕捉月リスト, 確認済を含む);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param result List<TokuchoMiDouteiListJoho>
     * @param 表示件数 int
     */
    public void 特別徴収未同定一覧initialize2(List<TokuchoMiDouteiListJoho> result, int 表示件数) {
        if (result == null) {
            return;
        }
        List<dgTokubetChoshuMidoteiIchiran_Row> dataGridList = new ArrayList();
        for (int i = NUM0; i < 表示件数; i++) {
            dgTokubetChoshuMidoteiIchiran_Row newRow = new dgTokubetChoshuMidoteiIchiran_Row();
            if (未同定_CODE.equals(result.get(i).get確認状況())) {
                newRow.setTxtKakuninJokyo(未同定_NAME);
            } else if (同定済み_CODE.equals(result.get(i).get確認状況())) {
                newRow.setTxtKakuninJokyo(同定済み_NAME);
            } else if (対象外_CODE.equals(result.get(i).get確認状況())) {
                newRow.setTxtKakuninJokyo(対象外_NAME);
            }
            if (result.get(i).get不一致理由() != null) {
                newRow.setTxtFuichiRiyuCode(result.get(i).get不一致理由());
                newRow.setTxtFuichiRiyu(DoteiFuitchiRiyu.toValue(result.get(i).get不一致理由()).get不一致理由名());
            }
            if (!RString.isNullOrEmpty(result.get(i).get捕捉月())) {
                RString 捕捉月 = result.get(i).get捕捉月().concat(月);
                newRow.getTxtHosokuM().setValue(捕捉月);
            }
            newRow.getTxtKisoNenkinNo().setValue(result.get(i).get年金番号());
            newRow.getTxtNenkinCode().setValue(result.get(i).get年金コード());
            RString 特別徴収義務者コード = result.get(i).get特別徴収義務者();
            if (特別徴収義務者コード != null) {
                RString codeMeisho = CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課,
                        new CodeShubetsu(特別徴収義務者コード種別), new Code(特別徴収義務者コード));
                newRow.getTxtTokuchoGimusha().setValue(codeMeisho);
            }
            newRow.getTxtShimeiKana().setValue(result.get(i).getカナ氏名());
            if (result.get(i).get生年月日() != null) {
                newRow.getTxtUmareYMD().setValue(new RDate(result.get(i).get生年月日().toString()));
            }
            if (result.get(i).get性別() != null) {
                newRow.getTxtSeibetsu().setValue(
                        SeibetsuCodeNenkinTokuchoType.toValue(result.get(i).get性別()).get性別名称());
            }
            dataGridList.add(newRow);
        }
        div.getDgTokubetChoshuMidoteiIchiran().setDataSource(dataGridList);
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 年度 RString
     * @param 捕捉月 RString
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 特徴開始月 RString
     */
    public void 特別徴収同定候補者一覧initialize(RString 年度, RString 捕捉月,
            RString 基礎年金番号, RString 年金コード, RString 特徴開始月) {
        if (!RString.isNullOrEmpty(特徴開始月) && !特徴開始月
                .startsWith(RString.FULL_SPACE) && !特徴開始月.startsWith(LEFT)) {
            特徴開始月 = 特徴開始月.split(RString.FULL_SPACE.toString()).get(NUM0).substring(NUM4, NUM6);
        }
        FlexibleYear 処理年度 = new FlexibleYear(年度);
        List<TokuchoDouteiKouhoshaListJoho> result_一覧 = tokudoutei.getTokuchoTaishoKouhosyaListJoho(
                処理年度, 捕捉月, 基礎年金番号, 年金コード, 特徴開始月);
        if (result_一覧 == null) {
            return;
        }
        List<dgTokuchoDoteiKohoshaIchiran_Row> rowList = new ArrayList();
        for (TokuchoDouteiKouhoshaListJoho result : result_一覧) {
            dgTokuchoDoteiKohoshaIchiran_Row newRow = new dgTokuchoDoteiKohoshaIchiran_Row();
            if (result.get不一致理由コード() != null) {
                newRow.setTxtFuitchiRiyu(DoteiFuitchiRiyu.toValue(result.get不一致理由コード()).get不一致理由名());
            }
            newRow.getTxtNenkinKaifukuInfoKisoNenkinNo().setValue(result.get年金情報_基礎年金番号());
            newRow.getTxtNenkinKaifukuInfoNenkinCode().setValue(result.get年金情報_年金コード());
            newRow.getTxtNenkinKaifukuInfoShimei().setValue(result.get年金情報_氏名());
            if (result.get年金情報_生年月日() != null) {
                newRow.getTxtNenkinKaifukuInfoUmareYMD().setValue(new RDate(result.get年金情報_生年月日().toString()));
            }
            if (result.get年金情報_性別() != null) {
                newRow.getTxtNenkinKaifukuInfoSeibetsu().setValue(SeibetsuCodeNenkinTokuchoType.toValue(
                        result.get年金情報_性別()).get性別名称());
            }
            newRow.setTxtHihokenshaNo(result.get被保険者台帳_被保険者番号());
            newRow.setTxtShikibetsuCode(result.get住基情報_識別コード());
            newRow.setTxtShimei(result.get住基情報_漢字氏名());
            newRow.setTxtBirthDay(result.get住基情報_生年月日());
            if (result.get住基情報_性別() != null) {
                newRow.setTxtSeibetsu(SeibetsuCodeNenkinTokuchoType.toValue(
                        result.get住基情報_性別()).get性別名称());
            }
            if (result.get住基情報_住民種別() != null) {
                newRow.setTxtJuminshu(JuminShubetsu.toValue(result.get住基情報_住民種別()).toRString());
            }
            rowList.add(newRow);
        }
        div.getDgTokuchoDoteiKohoshaIchiran().setDataSource(rowList);
        clean特別徴収同定候補者詳細情報();
        if (result_一覧.size() == NUM1) {
            div.setHiddenState(一行のみ該当する場合);
            FlexibleYear 年金情報_処理年度 = FlexibleYear.EMPTY;
            if (result_一覧.get(NUM0).get年金情報_処理年度() != null) {
                年金情報_処理年度 = new FlexibleYear(result_一覧.get(NUM0).get年金情報_処理年度());
            }
            ShikibetsuCode 住基情報_識別コード = ShikibetsuCode.EMPTY;
            if (result_一覧.get(NUM0).get住基情報_識別コード() != null) {
                住基情報_識別コード = new ShikibetsuCode(result_一覧.get(NUM0).get住基情報_識別コード());
            }
            List<TokuchoDouteiKouhoshaShousaiJoho> result_詳細 = tokudoutei.getTokuchoTaishoKouhosyaDetailJoho(
                    年金情報_処理年度, result_一覧.get(NUM0).get年金情報_基礎年金番号(),
                    result_一覧.get(NUM0).get年金情報_年金コード(),
                    特徴開始月, 捕捉月, 住基情報_識別コード);
            if (result_詳細 != null && !result_詳細.isEmpty()) {
                set特別徴収同定候補者詳細情報(result_詳細.get(NUM0));
            }
        } else {
            div.setHiddenState(複数行が該当する場合);
        }
    }

    private void set特別徴収同定候補者詳細情報(TokuchoDouteiKouhoshaShousaiJoho result) {
        div.setHiddenFukaNendo(result.get登録済年金情報_賦課年度());
        div.getTxtKisoNenkinNo().setValue(result.get未同定年金情報_基礎年金番号());
        div.getTxtNenkinCode().setValue(result.get未同定年金情報_年金コード());
        RString 特別徴収義務者コード = result.get未同定年金情報_特別徴収義務者コード();
        if (特別徴収義務者コード != null) {
            div.setHiddenTokubetsuChoshuGimushaCode(特別徴収義務者コード);
            RString codeMeisho = CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課,
                    new CodeShubetsu(特別徴収義務者コード種別), new Code(特別徴収義務者コード));
            div.getTxtTokuchoGimusha().setValue(codeMeisho);
        }
        if (result.get未同定年金情報_生年月日() != null) {
            div.getTxtUmareYMD().setValue(new RDate(result.get未同定年金情報_生年月日().toString()));
        }
        if (result.get未同定年金情報_性別() != null) {
            div.getTxtSebetsu().setValue(SeibetsuCodeNenkinTokuchoType
                    .toValue(result.get未同定年金情報_性別()).get性別名称());
        }
        div.getTxtShimeiKana().setValue(result.get未同定年金情報_氏名カナ());
        div.getTxtShimeiKanji().setValue(result.get未同定年金情報_氏名漢字());
        div.getTxtJushoKana().setValue(result.get未同定年金情報_住所カナ());
        div.getTxtJushoKanji().setValue(result.get未同定年金情報_住所漢字());
        div.getTxtShikibetsuCode().setValue(result.get住基情報_識別コード());
        div.getTxtAtenaShimeiKana().setValue(result.get住基情報_カナ氏名());
        if (!RString.isNullOrEmpty(result.get住基情報_生年月日())) {
            div.getTxtAtenaUmareYMD().setValue(new RDate(result.get住基情報_生年月日().toString()));
        }
        div.getTxtAtenaShimeiKanji().setValue(result.get住基情報_漢字氏名());
        if (result.get住基情報_性別() != null) {
            div.getTxtAtenaSebetsu().setValue(SeibetsuCodeNenkinTokuchoType
                    .toValue(result.get住基情報_性別()).get性別名称());
        }
        if (result.get住基情報_住民種別() != null) {
            div.getTxtJuminshu().setValue(JuminShubetsu.toValue(result.get住基情報_住民種別()).toRString());
        }
        if (!RString.isNullOrEmpty(result.get住基情報_住登日())) {
            div.getTxtJutoYMD().setValue(new FlexibleDate(result.get住基情報_住登日()));
        }
        if (!RString.isNullOrEmpty(result.get住基情報_消除日())) {
            div.getTxtShojoYMD().setValue(new FlexibleDate(result.get住基情報_消除日().toString()));
        }
        div.getTxtAtenaJushoKanji().setValue(result.get住基情報_漢字住所());
        div.getTxtHihokenshaNo().setValue(result.get被保険者台帳_被保険者番号());
        if (!RString.isNullOrEmpty(result.get被保険者台帳_資格取得年月日())) {
            div.getTxtShutokuYMD().setValue(new RDate(result.get被保険者台帳_資格取得年月日().toString()));
        }
        if (result.get被保険者台帳_資格取得事由() != null) {
            div.getTxtShutokuJiyu().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(介護資格取得事由コード種別),
                    new Code(result.get被保険者台帳_資格取得事由())));
        }
        if (!RString.isNullOrEmpty(result.get被保険者台帳_資格喪失年月日())) {
            div.getTxtSoshitsuYMD().setValue(new RDate(result.get被保険者台帳_資格喪失年月日().toString()));
        }
        if (result.get被保険者台帳_資格喪失事由() != null) {
            div.getTxtSoshitsuJiyu().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(介護資格喪失事由コード種別),
                    new Code(result.get被保険者台帳_資格喪失事由())));
        }
        div.getTxtTorokuZumiKisoNenkinNo().setValue(result.get登録済年金情報_基礎年金番号());
        div.getTxtTorokuZumiNenkinCode().setValue(result.get登録済年金情報_年金コード());
        if (result.get登録済年金情報_特別徴収義務者コード() != null) {
            div.getTxtTorokuZumiTokuchoGimusha().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    new CodeShubetsu(特別徴収義務者コード種別),
                    new Code(result.get登録済年金情報_特別徴収義務者コード())));
        }
    }

    private void clean特別徴収同定候補者詳細情報() {
        div.getTxtKisoNenkinNo().clearValue();
        div.getTxtNenkinCode().clearValue();
        div.getTxtTokuchoGimusha().clearValue();
        div.getTxtShimeiKana().clearValue();
        div.getTxtUmareYMD().clearValue();
        div.getTxtShimeiKanji().clearValue();
        div.getTxtSebetsu().clearValue();
        div.getTxtJushoKana().clearValue();
        div.getTxtJushoKanji().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtAtenaShimeiKana().clearValue();
        div.getTxtAtenaUmareYMD().clearValue();
        div.getTxtJuminshu().clearValue();
        div.getTxtAtenaShimeiKanji().clearValue();
        div.getTxtAtenaSebetsu().clearValue();
        div.getTxtJutoYMD().clearValue();
        div.getTxtAtenaJushoKana().clearValue();
        div.getTxtShojoYMD().clearValue();
        div.getTxtAtenaJushoKanji().clearValue();
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtShutokuYMD().clearValue();
        div.getTxtShutokuJiyu().clearValue();
        div.getTxtSoshitsuYMD().clearValue();
        div.getTxtSoshitsuJiyu().clearValue();
        div.getTxtTorokuZumiKisoNenkinNo().clearValue();
        div.getTxtTorokuZumiNenkinCode().clearValue();
        div.getTxtTorokuZumiTokuchoGimusha().clearValue();
    }

    /**
     * 特別徴収同定候補者詳細情報を設定します。<br/>
     * 特別徴収同定候補者一覧
     *
     * @param 特別徴収開始月 RString
     * @param 捕捉月 RString
     * @return TokuchoDouteiKouhoshaShousaiJoho
     */
    public TokuchoDouteiKouhoshaShousaiJoho show特別徴収同定候補者詳細情報(
            RString 特別徴収開始月, RString 捕捉月) {
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 基礎年金番号 = div.getDgTokuchoDoteiKohoshaIchiran().getClickedItem().
                getTxtNenkinKaifukuInfoKisoNenkinNo().getValue();
        RString 年金コード = div.getDgTokuchoDoteiKohoshaIchiran().getClickedItem().
                getTxtNenkinKaifukuInfoNenkinCode().getValue();
        RString 識別コードTemp = div.getDgTokuchoDoteiKohoshaIchiran().
                getClickedItem().getTxtShikibetsuCode();
        ShikibetsuCode 識別コード = 識別コードTemp == null ? null
                : new ShikibetsuCode(識別コードTemp);
        RString 開始月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(特別徴収開始月) && !特別徴収開始月.startsWith(RString.FULL_SPACE)
                && !特別徴収開始月.startsWith(LEFT)) {
            開始月 = 特別徴収開始月.split(RString.FULL_SPACE.toString()).get(NUM0).substring(NUM4, NUM6);
        }
        List<TokuchoDouteiKouhoshaShousaiJoho> result_詳細 = tokudoutei.getTokuchoTaishoKouhosyaDetailJoho(
                new FlexibleYear(処理年度), 基礎年金番号, 年金コード, 開始月, 捕捉月, 識別コード);
        if (result_詳細 != null && !result_詳細.isEmpty()) {
            if (!RString.isNullOrEmpty(result_詳細.get(NUM0).get登録済年金情報_賦課年度())) {
                div.getTorokuZumiNenkinInfo().setDisplayNone(false);
            } else {
                div.getTorokuZumiNenkinInfo().setDisplayNone(true);
            }
            set特別徴収同定候補者詳細情報(result_詳細.get(NUM0));
            return result_詳細.get(NUM0);
        } else {
            return new TokuchoDouteiKouhoshaShousaiJoho();
        }
    }

    /**
     * 実行確認状態更新<br/>
     * 特別徴収同定候補者一覧
     *
     * @param 特別徴収開始月 RString
     * @param 捕捉月 RString
     * @param 確認状況区分 RString
     * @param 処理状態Message Message
     */
    public void execute確認状態更新(RString 特別徴収開始月, RString 捕捉月,
            RString 確認状況区分, Message 処理状態Message) {
        RString 処理年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 基礎年金番号 = div.getTxtKisoNenkinNo().getValue();
        RString 被保険者番号 = div.getTxtHihokenshaNo().getValue();
        RString 年金コード = div.getTxtNenkinCode().getValue();
        RString 識別コード = div.getTxtShikibetsuCode().getValue();
        RString 特別徴収義務者コード = div.getHiddenTokubetsuChoshuGimushaCode();
        RString 氏名 = div.getTxtAtenaShimeiKanji().getValue();
        RString 開始月 = RString.EMPTY;
        if (!RString.isNullOrEmpty(特別徴収開始月)
                && !特別徴収開始月.startsWith(RString.FULL_SPACE) && !特別徴収開始月.startsWith(LEFT)) {
            開始月 = 特別徴収開始月.split(RString.FULL_SPACE.toString()).get(NUM0).trim().substring(NUM4, NUM6).trim();
        }
        RString message_TOP = TOPINFO;
        if (!RString.isNullOrEmpty(被保険者番号)) {
            message_TOP = TOPINFO.concat(被保険者番号);
        }
        RString message_BOTTOM = BOTTOMINFO;
        if (!RString.isNullOrEmpty(氏名)) {
            message_BOTTOM = BOTTOMINFO.concat(氏名);
        }
        tokudoutei.kakuninJotaiUpdate(new FlexibleYear(処理年度), 基礎年金番号, 被保険者番号, 年金コード, 開始月,
                捕捉月, 確認状況区分, new ShikibetsuCode(識別コード), 特別徴収義務者コード);
        div.getCcdKaigoKanryoMessage()
                .setSuccessMessage(new RString(処理状態Message.evaluate()), message_TOP, message_BOTTOM);
    }

    /**
     * 出力対象変化後の処理。<br/>
     * 特別徴収対象者一覧作成
     *
     * @param div TokuchoTaishoshaIchiranDiv
     */
    public void onChange_Chk出力対象(TokuchoTaishoshaIchiranDiv div) {
        List<RString> selectedKeys = div.getChkShutsuryokuTaisho().getSelectedKeys();
        if (selectedKeys.contains(KEY0)) {
            List<RString> changedKeys = new ArrayList();
            changedKeys.add(KEY1);
            changedKeys.add(KEY2);
            div.getChkShutsuryokuTaisho().setDisabledItemsByKey(changedKeys);
        } else {
            div.getChkShutsuryokuTaisho().setDisabledItemsByKey(new ArrayList());
        }
    }

    /**
     * BatchParameterを取得するします。<br/>
     * 特別徴収対象者一覧作成
     *
     * @param 特別徴収開始月 RString
     * @param 捕捉月リスト List<RString>
     * @return TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter
            getBatchParameter(RString 特別徴収開始月, List<RString> 捕捉月リスト) {
        TokuchoTaishoshaIchiranSakuseiResult result = new TokuchoTaishoshaIchiranSakuseiResult();
        result.set捕捉月リスト(捕捉月リスト == null ? new ArrayList() : 捕捉月リスト);
        result.set特別徴収開始月(特別徴収開始月);
        List<RString> selectedKeys = div.getChkShutsuryokuTaisho().getSelectedKeys();
        if (NUM1 < selectedKeys.size()) {
            result.set出力対象(KEY0);
        } else {
            result.set出力対象(selectedKeys.get(NUM0));
        }
        return tokudoutei.getBatchiPara(result);
    }

    /**
     * 出力対象変化後の処理<br/>
     * 同定非同定表示
     *
     * @param div TokuchoTaishoshaIchiranDiv
     */
    public void onChange_Rad表示対象(TokuchoTaishoshaIchiranDiv div) {
        RString selectedKey = div.getRadhyojiTaisho().getSelectedKey();
        if (KEY0.compareTo(selectedKey) == NUM0) {
            div.getChkKakuninZumiFukumu().setSelectedItemsByKey(new ArrayList());
            div.getChkKakuninZumiFukumu().setDisabled(true);
        } else if (KEY1.compareTo(selectedKey) == NUM0) {
            div.getChkKakuninZumiFukumu().setSelectedItemsByKey(new ArrayList());
            div.getChkKakuninZumiFukumu().setDisabled(false);
        }
    }

    /**
     * onStateTransition表示制御
     *
     */
    public void stateTransition_CommonBtn() {
        RString state = div.getHiddenState();
        if (一行のみ該当する場合.compareTo(state) == NUM0) {
            一行同定候補者一覧initialize表示制御();
        } else if (複数行が該当する場合.compareTo(state) == NUM0) {
            div.getTorokuZumiNenkinInfo().setDisplayNone(true);
            div.getBtnHihokenshaFinder().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定する, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定対象外確認済にする, true);
        }
        div.setHiddenState(状態なし);
    }

    /**
     * RootTitleを設定する。
     *
     * @return ResponseData<TokuchoTaishoshaIchiranDiv>
     */
    public ResponseData<TokuchoTaishoshaIchiranDiv> stateTransition_RootTitle() {
        RString pageState = div.getHiddenPageState();
        if (STATE特別徴収対象者一覧作成.equals(pageState)) {
            return ResponseData.of(div).rootTitle(特別徴収対象者一覧作成).respond();
        }
        return ResponseData.of(div).rootTitle(特別徴収対象者一覧確認).respond();
    }

    /**
     * 初期化状態（「特別徴収同定候補者一覧」に一行のみ該当する場合）
     *
     */
    public void 一行同定候補者一覧initialize表示制御() {
        RString 不一致理由 = div.getHiddenReasonCode();
        RString 確認状況 = div.getHiddenConfirmState();
        div.getBtnHihokenshaFinder().setDisabled(false);
        if (一致理由_01.compareTo(不一致理由) == NUM0 || 一致理由_06.compareTo(不一致理由) == NUM0
                || 一致理由_05.compareTo(不一致理由) == NUM0
                || 一致理由_10.compareTo(不一致理由) == NUM0 || 一致理由_09.compareTo(不一致理由) == NUM0
                || 一致理由_02.compareTo(不一致理由) == NUM0
                || 一致理由_03.compareTo(不一致理由) == NUM0 || 一致理由_04.compareTo(不一致理由) == NUM0) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定する, false);
            if (未同定_NAME.compareTo(確認状況) == NUM0) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定対象外確認済にする, false);
            } else if (対象外_NAME.compareTo(確認状況) == NUM0) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定対象外確認済にする, true);
            }
        } else if (一致理由_11.compareTo(不一致理由) == NUM0 || 一致理由_12.compareTo(不一致理由) == NUM0) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定する, true);
            if (未同定_NAME.compareTo(確認状況) == NUM0) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定対象外確認済にする, false);
            } else if (対象外_NAME.compareTo(確認状況) == NUM0) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN同定対象外確認済にする, true);
            }
        }
        RString fukaNendo = div.getHiddenFukaNendo();
        if (fukaNendo == null) {
            div.getTorokuZumiNenkinInfo().setDisplayNone(true);
        } else {
            div.getTorokuZumiNenkinInfo().setDisplayNone(false);
        }
    }
}
