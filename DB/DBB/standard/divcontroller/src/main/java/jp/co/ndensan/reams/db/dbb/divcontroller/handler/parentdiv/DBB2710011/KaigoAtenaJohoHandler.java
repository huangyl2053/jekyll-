/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.KaigoAtenaJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.NenkinInfoKensakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011.NenkinJohoKensakuDiv;
import jp.co.ndensan.reams.db.dbb.service.core.tokubetuchosyutaisyosyatoroku.TokubetuChosyutaisyosyaTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 特別徴収対象者登録ハンドラクラスです。
 *
 * @reamsid_L DBB-0670-010 wangjie2
 */
public class KaigoAtenaJohoHandler {

    private final KaigoAtenaJohoDiv div;
    private final RString 連番_0001 = new RString("0001");
    private final RString 連番_0002 = new RString("0002");
    private final RString 連番_0003 = new RString("0003");
    private final RString 連番_0004 = new RString("0004");
    private final RString 連番_0005 = new RString("0005");
    private final RString 連番_0006 = new RString("0006");
//    private final RString 特徴10月捕捉 = new RString("10");
//    private final RString 特徴12月捕捉 = new RString("12");
//    private final RString 特徴02月捕捉 = new RString("02");
//    private final RString 特徴04月捕捉 = new RString("04");
//    private final RString 特徴06月捕捉 = new RString("06");
//    private final RString 特徴08月捕捉 = new RString("08");
    private static final int INT3 = 3;

    /**
     * コンストラクタです。
     *
     * @param div 特別徴収対象者登録情報Div
     */
    public KaigoAtenaJohoHandler(KaigoAtenaJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param key FukaTaishoshaKey
     * @return 該当者一覧画面へ遷移フラグ
     */
    public Boolean onload(FukaTaishoshaKey key) {
        FlexibleYear 賦課年度 = null;
        ShikibetsuCode 識別コード = null;
        if (null != key) {
            賦課年度 = key.get賦課年度();
            識別コード = key.get識別コード();
        }
        if (null == 賦課年度) {
            賦課年度 = FlexibleYear.EMPTY;
        }
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoFukaKihon().load(getSearchKey(key));
        TokubetuChosyutaisyosyaTorokuManager 特別徴収対象者登録Manager = TokubetuChosyutaisyosyaTorokuManager.createInstance();
        RString 年度内処理済み連番 = 特別徴収対象者登録Manager.getShorizumiRenban(賦課年度);
        div.setYearofprocessedsequence(年度内処理済み連番);
        FlexibleDate 依頼金額計算基準日 = get依頼金額計算基準日(特別徴収対象者登録Manager, 賦課年度, 年度内処理済み連番);
        if (依頼金額計算基準日 != null) {
            throw new ApplicationException(DbbErrorMessages.依頼金額決定済みのため処理不可.getMessage());
        }
        HihokenshaNo 画面被保険者番号 = div.getCcdKaigoFukaKihon().get被保番号();
        SearchResult<ChoshuHoho> choshuHohoSearchResult = 特別徴収対象者登録Manager.getChoshuHoho(賦課年度, 画面被保険者番号);
        List<ChoshuHoho> 最新介護徴収方法情報データLst = new ArrayList<>();
        Boolean 該当者対象フラグ;
        if (null == choshuHohoSearchResult) {
            該当者対象フラグ = false;
        } else {
            最新介護徴収方法情報データLst = choshuHohoSearchResult.records();
            該当者対象フラグ = get該当者対象フラグ(最新介護徴収方法情報データLst, 年度内処理済み連番);
        }
        if (!該当者対象フラグ) {
            return true;
        }
        Boolean 資格喪失フラグ = 特別徴収対象者登録Manager.getHihokenshaFlag(画面被保険者番号);
        div.getNenkinJohoKensaku().getBtnNenkinInfoKensaku().setDisabled(資格喪失フラグ);
        ChoshuHoho 最新介護徴収方法情報データ
                = 最新介護徴収方法情報データLst.isEmpty()
                ? new ChoshuHoho(FlexibleYear.EMPTY, HihokenshaNo.EMPTY, 0) : 最新介護徴収方法情報データLst.get(0);
        //if (!資格喪失フラグ) {
        //RString 捕捉月 = get捕捉月(年度内処理済み連番, 最新介護徴収方法情報データ);
        //TokuchoStartMonth 特別徴収開始月 = get特別徴収開始月(捕捉月);
        //TODO 　ビジネスのメソッドを呼び出し、年金特徴回付情報を取得する  特徴対象者（追加含む）取得
        //}
        RString 基礎年金番号Old = null;
        RString 年金コードOld = null;
        if (連番_0001.equals(年度内処理済み連番)) {
            基礎年金番号Old = 最新介護徴収方法情報データ.get仮徴収_基礎年金番号();
            年金コードOld = 最新介護徴収方法情報データ.get仮徴収_年金コード();
        } else if (連番_0002.equals(年度内処理済み連番) || 連番_0003.equals(年度内処理済み連番) || 連番_0004.equals(年度内処理済み連番)) {
            基礎年金番号Old = 最新介護徴収方法情報データ.get本徴収_基礎年金番号();
            年金コードOld = 最新介護徴収方法情報データ.get本徴収_年金コード();
        } else if (連番_0005.equals(年度内処理済み連番) || 連番_0006.equals(年度内処理済み連番)) {
            基礎年金番号Old = 最新介護徴収方法情報データ.get翌年度仮徴収_基礎年金番号();
            年金コードOld = 最新介護徴収方法情報データ.get翌年度仮徴収_年金コード();
        }
        RString 年金名称 = null == 年金コードOld ? RString.EMPTY : get年金名称(年金コードOld);
        div.setOldNenkinCode(年金コードOld);
        div.setOldNenkinNo(基礎年金番号Old);
        div.getNenkinJohoKensaku().getTxtKisoNenkinNo().setValue(基礎年金番号Old);
        div.getNenkinJohoKensaku().getTxtNenkinCode().setValue(年金コードOld);
        div.getNenkinJohoKensaku().getTxtNenkinMeiSho().setValue(年金名称);
        return false;
    }

    private FlexibleDate get依頼金額計算基準日(
            TokubetuChosyutaisyosyaTorokuManager 特別徴収対象者登録Manager, FlexibleYear 賦課年度, RString 年度内処理済み連番) {
        FlexibleDate 依頼金額計算基準日 = null;
        if (連番_0001.equals(年度内処理済み連番)) {
            依頼金額計算基準日 = 特別徴収対象者登録Manager.getIraikinKijunbi(賦課年度, ShoriName.依頼金額計算, 年度内処理済み連番);
        } else if (連番_0002.equals(年度内処理済み連番)) {
            依頼金額計算基準日 = 特別徴収対象者登録Manager.getIraikinKijunbi(賦課年度, ShoriName.本算定賦課, 年度内処理済み連番);
        } else if (連番_0003.equals(年度内処理済み連番)) {
            依頼金額計算基準日 = 特別徴収対象者登録Manager.getIraikinKijunbi(賦課年度, ShoriName.依頼金額計算, 年度内処理済み連番);
        } else if (連番_0004.equals(年度内処理済み連番)) {
            依頼金額計算基準日 = 特別徴収対象者登録Manager.getIraikinKijunbi(賦課年度, ShoriName.依頼金額計算, 年度内処理済み連番);
        } else if (連番_0005.equals(年度内処理済み連番)) {
            依頼金額計算基準日 = 特別徴収対象者登録Manager.getIraikinKijunbi(賦課年度, ShoriName.依頼金額計算, 年度内処理済み連番);
        } else if (連番_0006.equals(年度内処理済み連番)) {
            依頼金額計算基準日 = 特別徴収対象者登録Manager.getIraikinKijunbi(
                    new FlexibleYear(String.valueOf(賦課年度.getYearValue() + 1)), ShoriName.依頼金額計算, 年度内処理済み連番);
        }
        return 依頼金額計算基準日;
    }

    private KaigoFukaKihonSearchKey getSearchKey(FukaTaishoshaKey key) {
        FlexibleYear 賦課年度 = null;
        ShikibetsuCode 識別コード = null;
        TsuchishoNo 通知書番号 = null;
        LasdecCode 市町村コード = null;
        if (null != key) {
            賦課年度 = key.get賦課年度();
            識別コード = key.get識別コード();
            通知書番号 = key.get通知書番号();
            市町村コード = key.get市町村コード();
        }
        if (null == 賦課年度) {
            賦課年度 = FlexibleYear.EMPTY;
        }
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        if (null == 通知書番号) {
            通知書番号 = TsuchishoNo.EMPTY;
        }
        if (null == 市町村コード) {
            市町村コード = LasdecCode.EMPTY;
        }
        return new KaigoFukaKihonSearchKey.Builder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
    }

//    private RString get捕捉月(RString 年度内処理済み連番, ChoshuHoho 最新介護徴収方法情報データ) {
//        RString 捕捉月 = null;
//        if (連番_0001.equals(年度内処理済み連番)) {
//            捕捉月 = 最新介護徴収方法情報データ.get仮徴収_捕捉月();
//        }
//        if (連番_0002.equals(年度内処理済み連番) || 連番_0003.equals(年度内処理済み連番) || 連番_0004.equals(年度内処理済み連番)) {
//            捕捉月 = 最新介護徴収方法情報データ.get本徴収_捕捉月();
//        }
//        if (連番_0005.equals(年度内処理済み連番) || 連番_0006.equals(年度内処理済み連番)) {
//            捕捉月 = 最新介護徴収方法情報データ.get翌年度仮徴収_捕捉月();
//        }
//        return 捕捉月;
//    }
    private boolean get該当者対象フラグ(List<ChoshuHoho> 最新介護徴収方法情報データLst, RString 年度内処理済み連番) {
        boolean 該当者対象フラグ;
        ChoshuHoho 最新介護徴収方法情報データ = 最新介護徴収方法情報データLst.get(0);
        if (RString.EMPTY.equals(年度内処理済み連番)) {
            該当者対象フラグ = false;
        } else if (連番_0001.equals(年度内処理済み連番)
                && (null == 最新介護徴収方法情報データ.get仮徴収_基礎年金番号() || 最新介護徴収方法情報データ.get仮徴収_基礎年金番号().isEmpty())) {
            該当者対象フラグ = false;
        } else if ((連番_0002.equals(年度内処理済み連番) || 連番_0003.equals(年度内処理済み連番) || 連番_0004.equals(年度内処理済み連番))
                && (null == 最新介護徴収方法情報データ.get本徴収_基礎年金番号() || 最新介護徴収方法情報データ.get本徴収_基礎年金番号().isEmpty())) {
            該当者対象フラグ = false;
        } else {
            該当者対象フラグ = !((連番_0005.equals(年度内処理済み連番) || 連番_0006.equals(年度内処理済み連番))
                    && (null == 最新介護徴収方法情報データ.get翌年度仮徴収_基礎年金番号()
                    || 最新介護徴収方法情報データ.get翌年度仮徴収_基礎年金番号().isEmpty()));
        }
        return 該当者対象フラグ;
    }

    /**
     * 特別徴収開始月を取得します。
     *
     * @param 捕捉月 捕捉月
     */
//    private TokuchoStartMonth get特別徴収開始月(RString 捕捉月) {
//        TokubetuChosyutaisyosyaTorokuManager 特別徴収対象者登録Manager = new TokubetuChosyutaisyosyaTorokuManager();
//        TokuchoHosokuMonth 捕捉月TokuchoHosokuMonth = null;
//        if (特徴02月捕捉.equals(捕捉月)) {
//            捕捉月TokuchoHosokuMonth = TokuchoHosokuMonth.特徴2月捕捉;
//        } else if (特徴04月捕捉.equals(捕捉月)) {
//            捕捉月TokuchoHosokuMonth = TokuchoHosokuMonth.特徴4月捕捉;
//        } else if (特徴06月捕捉.equals(捕捉月)) {
//            捕捉月TokuchoHosokuMonth = TokuchoHosokuMonth.特徴6月捕捉;
//        } else if (特徴08月捕捉.equals(捕捉月)) {
//            捕捉月TokuchoHosokuMonth = TokuchoHosokuMonth.特徴8月捕捉;
//        } else if (特徴10月捕捉.equals(捕捉月)) {
//            捕捉月TokuchoHosokuMonth = TokuchoHosokuMonth.特徴10月捕捉;
//        } else if (特徴12月捕捉.equals(捕捉月)) {
//            捕捉月TokuchoHosokuMonth = TokuchoHosokuMonth.特徴12月捕捉;
//        } else {
//            return null;
//        }
//        return 特別徴収対象者登録Manager.getTokuchoKaishibi(捕捉月TokuchoHosokuMonth);
//    }
    /**
     * 「年金情報を検索する」ボタンを押下すること処理です。
     */
    public void onClick_btnNenkinInfoKensaku() {
        TokubetuChosyutaisyosyaTorokuManager 特別徴収対象者登録Manager = new TokubetuChosyutaisyosyaTorokuManager();
        //TODO 特徴対象者（追加含む）取得
        特別徴収対象者登録Manager.getTokuchoTaishosha();
    }

    /**
     * 「年金コード」フォーカスロスト処理です。
     */
    public void lostFocus() {
        RString 年金コード = div.getNenkinJohoKensaku().getTxtNenkinCode().getValue();
        div.getNenkinJohoKensaku().getTxtNenkinMeiSho().setValue(get年金名称(年金コード));
    }

    /**
     * 年金コードを取得します。
     *
     * @return 年金名称
     */
    private RString get年金名称(RString 年金コード) {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBB介護賦課, new CodeShubetsu("0046"),
                new Code(年金コード.length() > INT3 ? 年金コード.substring(0, INT3) : 年金コード));
    }

    /**
     * 「関連付を削除する」ボタンを押下すること処理です。
     */
    public void onClick_btnKanrenTsukeSakujo() {
        NenkinJohoKensakuDiv nenkinJohoKensakuDiv = div.getNenkinJohoKensaku();
        NenkinInfoKensakuDiv nenkinInfoKensakuDiv = div.getNenkinInfoKensaku();
        RString 空白 = RString.EMPTY;
        nenkinJohoKensakuDiv.getTxtKisoNenkinNo().setValue(空白);
        nenkinJohoKensakuDiv.getTxtNenkinCode().setValue(空白);
        nenkinJohoKensakuDiv.getTxtNenkinMeiSho().setValue(空白);
        nenkinInfoKensakuDiv.getTxtKaishiTsuki().setValue(空白);
        nenkinInfoKensakuDiv.getTxtHosokuTsuki().setValue(空白);
        nenkinInfoKensakuDiv.getTxtShimeiKana().setValue(空白);
        nenkinInfoKensakuDiv.getTxtShimeiKanji().setValue(空白);
        nenkinInfoKensakuDiv.getTxtJushoKana().setValue(空白);
        nenkinInfoKensakuDiv.getTxtJushoKanji().setValue(空白);
        nenkinInfoKensakuDiv.getTxtUmareYMD().setValue(FlexibleDate.EMPTY);
        nenkinInfoKensakuDiv.getTxtSebetsu().setValue(空白);
        nenkinInfoKensakuDiv.getTxtTokuchoGimusha().setValue(空白);
    }

    /**
     * 「保存する」ボタンを押下すること処理です。
     *
     * @param key FukaTaishoshaKey
     */
    public void onClick_btnUpdate(FukaTaishoshaKey key) {
        if (is年金情報パネルが空白() && div.getNenkinJohoKensaku().getBtnNenkinInfoKensaku().isDisabled()) {
            throw new ApplicationException(DbbErrorMessages.被保険者でないため変更不可.getMessage());
        }
        TokubetuChosyutaisyosyaTorokuManager 特別徴収対象者登録Manager = TokubetuChosyutaisyosyaTorokuManager.createInstance();
        FlexibleYear 賦課年度 = null;
        ShikibetsuCode 識別コード = null;
        if (null != key) {
            識別コード = key.get識別コード();
            賦課年度 = key.get賦課年度();
        }
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        if (null == 賦課年度) {
            賦課年度 = FlexibleYear.EMPTY;
        }
        HihokenshaNo 被保険者番号 = div.getCcdKaigoFukaKihon().get被保番号();
        RString 基礎年金番号 = div.getNenkinJohoKensaku().getTxtKisoNenkinNo().getValue();
        RString 年金コード = div.getNenkinJohoKensaku().getTxtNenkinCode().getValue();
        int 登録件数 = 特別徴収対象者登録Manager.insChoshuHoho(賦課年度, 被保険者番号, 基礎年金番号, 年金コード);
        RString 氏名 = div.getCcdKaigoAtenaInfo().get氏名漢字();
        if (登録件数 > 0) {
            div.getCcdKaigoKanryoMessge().setMessage(UrInformationMessages.保存終了, 識別コード.getColumnValue(), 氏名, true);
        } else {
            div.getCcdKaigoKanryoMessge().setMessage(UrInformationMessages.保存終了, 識別コード.getColumnValue(), 氏名, false);
        }
    }

    /**
     * 画面内容の変更有無チェック。
     *
     * @return 画面内容の変更有無
     */
    public Boolean is画面内容の変更有無() {
        RString 入力基礎年金番号 = div.getNenkinJohoKensaku().getTxtKisoNenkinNo().getValue();
        RString 入力年金コード = div.getNenkinJohoKensaku().getTxtNenkinCode().getValue();
        return !(div.getOldNenkinNo().equals(入力基礎年金番号) && div.getOldNenkinCode().equals(入力年金コード));
    }

    /**
     * 年金情報パネルが空白チェック。
     */
    private Boolean is年金情報パネルが空白() {
        NenkinInfoKensakuDiv nenkinInfoKensakuDiv = div.getNenkinInfoKensaku();
        return is空白(nenkinInfoKensakuDiv.getTxtKaishiTsuki().getValue())
                && is空白(nenkinInfoKensakuDiv.getTxtHosokuTsuki().getValue())
                && is空白(nenkinInfoKensakuDiv.getTxtShimeiKana().getValue())
                && is空白(nenkinInfoKensakuDiv.getTxtShimeiKanji().getValue())
                && is空白(nenkinInfoKensakuDiv.getTxtJushoKana().getValue())
                && is空白(nenkinInfoKensakuDiv.getTxtJushoKanji().getValue())
                && (null == nenkinInfoKensakuDiv.getTxtUmareYMD().getValue()
                || FlexibleDate.EMPTY.equals(nenkinInfoKensakuDiv.getTxtUmareYMD().getValue()))
                && is空白(nenkinInfoKensakuDiv.getTxtSebetsu().getValue())
                && is空白(nenkinInfoKensakuDiv.getTxtTokuchoGimusha().getValue());
    }

    /**
     * 年金情報パネル単項目空白チェック。
     */
    private Boolean is空白(RString 単項目) {
        return RString.EMPTY.equals(単項目) || null == 単項目;
    }

    /**
     * 引数定義<br/>
     *
     */
    public enum DBB2710011ViewStateKey {

        /**
         * 被保険者番号です。
         */
        被保険者番号,
        /**
         * 賦課年度です。
         */
        賦課年度;
    }

}
