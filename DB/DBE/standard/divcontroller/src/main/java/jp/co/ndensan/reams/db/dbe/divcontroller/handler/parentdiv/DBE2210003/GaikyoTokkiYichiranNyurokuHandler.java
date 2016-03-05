/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.ChosaKoumokuAndTokkiBangoMapping;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査結果登録3のHandlerクラスです。
 *
 */
public class GaikyoTokkiYichiranNyurokuHandler {

    private final GaikyoTokkiYichiranNyurokuDiv div;
    private HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> gaikyoTokkiNyurokuMap = new HashMap<>();
    private int 総項目数 = 0;
    private int 残数 = 0;
    private int 商 = 0;
    private int 総ページ数 = 1;
    private int 当前ページ数 = 1;
    private final int int1 = 1;
    private final int int2 = 2;
    private final int int3 = 3;
    private final int int4 = 4;
    private final int int5 = 5;
    private final int int8 = 8;

    /**
     * コンストラクタです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     */
    public GaikyoTokkiYichiranNyurokuHandler(GaikyoTokkiYichiranNyurokuDiv div) {
        this.div = div;
    }

    private enum ShinkiKubun {

        /**
         * Tabに既存データ, コード: "1"。
         */
        Tabに既存データ(new RString("1")),
        /**
         * 新規データ コード : "2"。
         */
        新規データ(new RString("2"));

        private final RString code;

        private ShinkiKubun(RString code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return this.code;
        }
    }

    private enum HensyuuKubun {

        /**
         * 編集なし, コード: "1"。
         */
        編集なし(new RString("1")),
        /**
         * 編集ある コード : "2"。
         */
        編集ある(new RString("2")),
        /**
         * 編集ある コード : "3"。
         */
        空白(new RString("3"));

        private final RString code;

        private HensyuuKubun(RString code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return this.code;
        }

    }

    /**
     * 認定調査結果登録3初期化の設定します。
     *
     */
    public void onLoad() {

        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(new RString("1001")));
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, 1);
        ViewStateHolder.put(ViewStateKeys.調査実施日, new RString("21060304"));
        ViewStateHolder.put(ViewStateKeys.調査実施場所, new RString("1"));
        ViewStateHolder.put(ViewStateKeys.実施場所名称, new RString("実施場所名称"));
        ViewStateHolder.put(ViewStateKeys.記入者, new RString("記入者"));
        ViewStateHolder.put(ViewStateKeys.所属機関, new RString("001"));
        ViewStateHolder.put(ViewStateKeys.調査区分, new RString("001"));

        List<NinteichosahyoTokkijiko> resultList = new ArrayList<>();

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        RString 調査実施日 = ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class);
        RString 調査実施場所 = ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class);
        RString 実施場所名称 = ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class);
        RString 所属機関 = ViewStateHolder.get(ViewStateKeys.所属機関, RString.class);
        RString 記入者 = ViewStateHolder.get(ViewStateKeys.記入者, RString.class);
        RString 調査区分 = ViewStateHolder.get(ViewStateKeys.調査区分, RString.class);
        model.set調査実施日(調査実施日);
        model.set調査実施場所(調査実施場所);
        model.set実施場所名称(実施場所名称);
        model.set所属機関(所属機関);
        model.set記入者(記入者);
        model.set調査区分(調査区分);
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());

        //  TODO 共有子DIVが未実装
//        div.getChosaTaisho().getCcdKaigoNinteiShiseishaInfo().  // DBZ.KaigoNinteiShinseishaInfoのinitializeメソッドを呼ぶ
        div.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getCcdChosaJisshishaJoho().intialize(model);

        当前ページ数 = 1;
        resultList = set各特記事項基本情報();

        set初期化活性制御(resultList);
    }

    /**
     * 「前へ」ボタンの操作処理を行う。
     *
     */
    @SuppressWarnings("unchecked")
    public void onClick_btnBeforeTokkiJiko() {

        List<NinteichosahyoTokkijiko> resultList = new ArrayList<>();
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString()) - 1;
        this.cleanData();
        resultList = set各特記事項基本情報();

        set初期化活性制御(resultList);

        if (当前ページ数 > 1) {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(false);
        } else {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(true);
        }
    }

    /**
     * 「次へ」ボタンの操作処理を行う。
     *
     */
    @SuppressWarnings("unchecked")
    public void onClick_btnAfterTokkiJiko() {

        List<NinteichosahyoTokkijiko> resultList = new ArrayList<>();
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        this.cleanData();
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString()) + 1;
        if (当前ページ数 <= Integer.valueOf(div.getTokkiNyuryoku().getHiddenTotalPageCount().toString())) {
            div.getTokkiNyuryoku().getBtnAfterTokkiJiko().setDisabled(false);
        } else {

            if (resultList.size() == int5) {
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
            } else if (resultList.size() == int4) {
                this.fifth特記事項をチェック();
            } else if (resultList.size() == int3) {
                this.fourth特記事項をチェック();
            } else if (resultList.size() == int2) {
                this.third特記事項をチェック();
            } else if (resultList.size() == int1) {
                this.second特記事項をチェック();
            } else if (resultList.isEmpty()) {
                this.first特記事項をチェック();
            }
        }

        resultList = set各特記事項基本情報();

        set初期化活性制御(resultList);
    }

    /**
     * 特記事項番号1のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo1() {

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = new ArrayList<>();
        認定調査特記事項番号List = this.get認定調査特記事項番号List();
        Boolean 特記事項番号正確入力フラグ = false;

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {

            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue())) {
                特記事項番号正確入力フラグ = true;
                break;
            }
        }
        if (!特記事項番号正確入力フラグ) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("特記事項番号"));
        }

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue().equals(value.getTemp_認定調査特記事項番号())
                    && value.getTemp_特記事項().isEmpty()) {

                div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.特記事項番号が追加不可.getMessage());
            }
        }

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set1 = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it1 = set1.iterator();

        int renban = 0;
        while (it1.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it1.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= int8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());
                div.getTokkiNyuryoku().getTxtFirstTokkiRenban().setValue(Decimal.valueOf(renban + 1));
            }
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > int8) {
                div.getTokkiNyuryoku().getTxtFirstTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (ShinkiKubun.新規データ.getCode()
                .equals(div.getTokkiNyuryoku().getHiddenShinkiKubun1())) {
            div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
        }
    }

    /**
     * 特記事項番号2のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo2() {

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = new ArrayList<>();
        認定調査特記事項番号List = this.get認定調査特記事項番号List();
        Boolean 特記事項番号正確入力フラグ = false;

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {

            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue())) {
                特記事項番号正確入力フラグ = true;

            }
        }
        if (!特記事項番号正確入力フラグ) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("特記事項番号"));
        }

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue().equals(value.getTemp_認定調査特記事項番号())
                    && value.getTemp_特記事項().isEmpty()) {

                div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.特記事項番号が追加不可.getMessage());
            }
        }

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set1 = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it1 = set1.iterator();
        int renban = 0;
        while (it1.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it1.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= int8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());
                div.getTokkiNyuryoku().getTxtSecondTokkiRenban().setValue(Decimal.valueOf(renban + 1));
            }
            if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > int8) {

                div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().clearValue();
                div.getTokkiNyuryoku().getTxtSecondTokkiRenban().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (ShinkiKubun.新規データ.getCode()
                .equals(div.getTokkiNyuryoku().getHiddenShinkiKubun2())) {
            div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
        }
    }

    /**
     * 特記事項番号3のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo3() {

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = new ArrayList<>();
        認定調査特記事項番号List = this.get認定調査特記事項番号List();
        Boolean 特記事項番号正確入力フラグ = false;

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {

            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue())) {
                特記事項番号正確入力フラグ = true;
                break;
            }
        }
        if (!特記事項番号正確入力フラグ) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("特記事項番号"));
        }

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class
        );

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue().equals(value.getTemp_認定調査特記事項番号())
                    && value.getTemp_特記事項().isEmpty()) {

                div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.特記事項番号が追加不可.getMessage());
            }
        }

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set1 = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it1 = set1.iterator();

        int renban = 0;
        while (it1.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it1.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= int8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(Decimal.valueOf(renban + 1));
            }
            if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > int8) {
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (ShinkiKubun.新規データ.getCode()
                .equals(div.getTokkiNyuryoku().getHiddenShinkiKubun3())) {
            div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
        }
    }

    /**
     * 特記事項番号4のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo4() {

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = new ArrayList<>();
        認定調査特記事項番号List = this.get認定調査特記事項番号List();
        Boolean 特記事項番号正確入力フラグ = false;

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {

            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue())) {
                特記事項番号正確入力フラグ = true;
                break;
            }
        }
        if (!特記事項番号正確入力フラグ) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("特記事項番号"));
        }

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class
        );

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue().equals(value.getTemp_認定調査特記事項番号())
                    && value.getTemp_特記事項().isEmpty()) {

                div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.特記事項番号が追加不可.getMessage());
            }
        }

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set1 = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it1 = set1.iterator();

        int renban = 0;
        while (it1.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it1.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= int8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(Decimal.valueOf(renban + 1));
            }
            if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > int8) {
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (ShinkiKubun.新規データ.getCode()
                .equals(div.getTokkiNyuryoku().getHiddenShinkiKubun4())) {
            div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
        }
    }

    /**
     * 特記事項番号5のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo5() {

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = new ArrayList<>();
        認定調査特記事項番号List = this.get認定調査特記事項番号List();
        Boolean 特記事項番号正確入力フラグ = false;

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {

            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue())) {
                特記事項番号正確入力フラグ = true;
                break;
            }
        }
        if (!特記事項番号正確入力フラグ) {
            throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("特記事項番号"));
        }

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue().equals(value.getTemp_認定調査特記事項番号())
                    && value.getTemp_特記事項().isEmpty()) {

                div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.特記事項番号が追加不可.getMessage());
            }
        }

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set1 = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it1 = set1.iterator();

        int renban = 0;
        while (it1.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it1.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= int8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(Decimal.valueOf(renban + 1));
            }
            if (div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > int8) {
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }
    }

    /**
     * 「特記事項を保存する」ボタンの操作処理を行う。
     *
     */
    @SuppressWarnings("unchecked")
    public void onClick_Save() {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();

            NinteichosahyoTokkijiko ninteichosahyoTokkijiko = manager.get認定調査票_特記情報ByKey(new ShinseishoKanriNo(ViewStateKeys.申請書管理番号.toString()),
                    Integer.valueOf(ViewStateKeys.認定調査履歴番号.toString()),
                    value.getTemp_認定調査特記事項番号(),
                    Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()),
                    value.getTemp_特記事項テキストイメージ区分(),
                    new Code(value.getTemp_原本マスク区分()));

            NinteichosahyoTokkijikoBuilder builder = ninteichosahyoTokkijiko.createBuilderForEdit();

            builder.set特記事項(value.getTemp_特記事項());
            //builder.set特記事項イメージ共有ファイルID(RDateTime.of(value.getTemp_特記事項イメージ共有ファイルID(), RString.EMPTY));
            manager.save認定調査票_特記情報(builder.build());
        }
    }

    /**
     * 介護認定申請者情報を設定します。
     *
     */
    private void set介護認定申請者情報() {

    }

    /**
     * 認定申請連絡先基本を設定します。
     *
     */
    private void set認定申請連絡先基本() {

    }

    /**
     * 調査実施者情報を設定します。
     *
     */
    private void set調査実施者情報() {

    }

    /**
     * 各特記事項基本情報を設定します。
     *
     */
    private List<NinteichosahyoTokkijiko> set各特記事項基本情報() {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        List<NinteichosahyoTokkijiko> returnList = new ArrayList<>();

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        returnList = manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号, 当前ページ数, false);

        div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun1(GenponMaskKubun.原本.getコード());
        div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun2(GenponMaskKubun.原本.getコード());
        div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun3(GenponMaskKubun.原本.getコード());
        div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun4(GenponMaskKubun.原本.getコード());
        div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun5(GenponMaskKubun.原本.getコード());

        div.getTokkiNyuryoku().setHiddenShinkiKubun1(ShinkiKubun.新規データ.getCode());
        div.getTokkiNyuryoku().setHiddenShinkiKubun2(ShinkiKubun.新規データ.getCode());
        div.getTokkiNyuryoku().setHiddenShinkiKubun3(ShinkiKubun.新規データ.getCode());
        div.getTokkiNyuryoku().setHiddenShinkiKubun4(ShinkiKubun.新規データ.getCode());
        div.getTokkiNyuryoku().setHiddenShinkiKubun5(ShinkiKubun.新規データ.getCode());

        div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun1(TokkijikoTextImageKubun.テキスト.getコード());
        div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun2(TokkijikoTextImageKubun.テキスト.getコード());
        div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun3(TokkijikoTextImageKubun.テキスト.getコード());
        div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun4(TokkijikoTextImageKubun.テキスト.getコード());
        div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun5(TokkijikoTextImageKubun.テキスト.getコード());

        div.getTokkiNyuryoku().setHiddenHensyuuKubun1(HensyuuKubun.空白.getCode());
        div.getTokkiNyuryoku().setHiddenHensyuuKubun2(HensyuuKubun.空白.getCode());
        div.getTokkiNyuryoku().setHiddenHensyuuKubun3(HensyuuKubun.空白.getCode());
        div.getTokkiNyuryoku().setHiddenHensyuuKubun4(HensyuuKubun.空白.getCode());
        div.getTokkiNyuryoku().setHiddenHensyuuKubun5(HensyuuKubun.空白.getCode());

//        int k = 0;
//        for (int i = 0; i < returnList.size() / 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//
//                GaikyoTokkiYichiranNyurokuBusiness entity1 = new GaikyoTokkiYichiranNyurokuBusiness(
//                        new RString(String.valueOf(i).concat(String.valueOf(j))),
//                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().getText(),
//                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().getText(),
//                        div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun1(),
//                        div.getTokkiNyuryoku().getHiddenGenbonMasukuKubun1(),
//                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue(),
//                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().getSrc(),
//                        div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getText(),
//                        div.getTokkiNyuryoku().getHiddenShinkiKubun1(),
//                        div.getTokkiNyuryoku().getHiddenHensyuuKubun1());
//                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(当前ページ数).concat("1")), entity1);
//            }
//
//        }
        this.初期化項目設定(returnList);

        List<NinteichosahyoTokkijiko> listForCount = new ArrayList<>();
        listForCount = manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号, 0, true);

        総項目数 = listForCount.size();
        総ページ数 = get総ページ数();

        div.getTokkiNyuryoku()
                .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        div.getTokkiNyuryoku()
                .setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
        div.getTokkiNyuryoku()
                .setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));

        return returnList;
    }

    private int get総ページ数() {

        残数 = 総項目数 % int5;
        商 = 総項目数 / int5;

        if (総項目数 == 0 || 残数 != 0) {
            総ページ数 = 商 + 1;
        } else {
            総ページ数 = 商;
        }
        return 総ページ数;
    }

    private void set初期化活性制御(List<NinteichosahyoTokkijiko> resultList) {

        div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(true);
        div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(true);
        div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(true);

        if (resultList.isEmpty()) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(true);
        } else if (resultList.size() == 1) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            this.first活性制御();

            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(true);
        } else if (resultList.size() == 2) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            this.first活性制御();
            this.second活性制御();

            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(true);
        } else if (resultList.size() == int3) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            this.first活性制御();
            this.second活性制御();
            this.third活性制御();

            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(true);
        } else if (resultList.size() == int4) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(false);
            this.first活性制御();
            this.second活性制御();
            this.third活性制御();
            this.fourth活性制御();

            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(true);
        } else if (resultList.size() == int5) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(false);
            this.first活性制御();
            this.second活性制御();
            this.third活性制御();
            this.fourth活性制御();
            this.fifth活性制御();

        }

        if (当前ページ数 == 1) {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(false);
        }

        if (resultList.size() == int5) {
            div.getTokkiNyuryoku().getBtnAfterTokkiJiko().setDisabled(false);
        } else {
            div.getTokkiNyuryoku().getBtnAfterTokkiJiko().setDisabled(true);
        }
    }

    private List<ChosaKoumokuAndTokkiBangoMapping> get認定調査特記事項番号List() {

        List<ChosaKoumokuAndTokkiBangoMapping> list = new ArrayList<>();
        ChosaKoumokuAndTokkiBangoMapping entity
                = new ChosaKoumokuAndTokkiBangoMapping(new RString("11△"), new RString("1-1"), new RString("麻痺"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("12△"), new RString("1-2"), new RString("拘縮"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("13△"), new RString("1-3"), new RString("寝返り"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("14△"), new RString("1-4"), new RString("起き上がり"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("15△"), new RString("1-5"), new RString("座位保持"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("16△"), new RString("1-6"), new RString("両足での立位"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("17△"), new RString("1-7"), new RString("歩行"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("18△"), new RString("1-8"), new RString("立ち上がり"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("19△"), new RString("1-9"), new RString("片足での立位"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("110"), new RString("1-10"), new RString("洗身"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("111"), new RString("1-11"), new RString("つめ切り"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("112"), new RString("1-12"), new RString("視力"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("113"), new RString("1-13"), new RString("聴力"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("21△"), new RString("2-1"), new RString("移乗"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("22△"), new RString("2-2"), new RString("移動"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("23△"), new RString("2-3"), new RString("えん下"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("24△"), new RString("2-4"), new RString("食事摂取"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("25△"), new RString("2-5"), new RString("排尿"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("26△"), new RString("2-6"), new RString("排便"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("27△"), new RString("2-7"), new RString("口腔清潔"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("28△"), new RString("2-8"), new RString("洗顔"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("29△"), new RString("2-9"), new RString("整髪"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("210"), new RString("2-10"), new RString("上衣の着脱"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("211"), new RString("2-11"), new RString("ズボン等の着脱"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("212"), new RString("2-12"), new RString("外出頻度"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("31△"), new RString("3-1"), new RString("意思の伝達"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("32△"), new RString("3-2"), new RString("毎日の日課を理解"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("33△"), new RString("3-3"), new RString("生年月日をいう"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("34△"), new RString("3-4"), new RString("短期記憶"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("35△"), new RString("3-5"), new RString("自分の名前をいう"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("36△"), new RString("3-6"), new RString("今の季節を理解"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("37△"), new RString("3-7"), new RString("場所の理解"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("38△"), new RString("3-8"), new RString("徘徊"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("39△"), new RString("3-9"), new RString("外出して戻れない"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("41△"), new RString("4-1"), new RString("被害的"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("42△"), new RString("4-2"), new RString("作話"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("43△"), new RString("4-3"), new RString("感情が不安定"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("44△"), new RString("4-4"), new RString("昼夜逆転"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("45△"), new RString("4-5"), new RString("同じ話をする"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("46△"), new RString("4-6"), new RString("大声を出す"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("47△"), new RString("4-7"), new RString("介護に抵抗"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("48△"), new RString("4-8"), new RString("落ち着きなし"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("49△"), new RString("4-9"), new RString("一人で出たがる"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("410"), new RString("4-10"), new RString("収集癖"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("411"), new RString("4-11"), new RString("物や衣類を壊す"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("412"), new RString("4-12"), new RString("ひどい物忘れ"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("413"), new RString("4-13"), new RString("独り言・独り笑い"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("414"), new RString("4-14"), new RString("自分勝手に行動する"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("415"), new RString("4-15"), new RString("話がまとまらない"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("51△"), new RString("5-1"), new RString("薬の内服"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("52△"), new RString("5-2"), new RString("金銭の管理"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("53△"), new RString("5-3"), new RString("日常の意思決定"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("54△"), new RString("5-4"), new RString("集団への不適応"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("55△"), new RString("5-5"), new RString("買い物"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("56△"), new RString("5-6"), new RString("簡単な調理"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("61△"), new RString("6-1"), new RString("点滴の管理"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("62△"), new RString("6-2"), new RString("中心静脈栄養"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("63△"), new RString("6-3"), new RString("透析"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("64△"), new RString("6-4"), new RString("ストーマの処置"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("65△"), new RString("6-5"), new RString("酸素療法"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("66△"), new RString("6-6"), new RString("レスピレーター"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("67△"), new RString("6-7"), new RString("気管切開の処置"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("68△"), new RString("6-8"), new RString("疼痛の看護"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("69△"), new RString("6-9"), new RString("経管栄養"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("610"), new RString("6-10"), new RString("モニター測定"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("611"), new RString("6-11"), new RString("じょくそうの処置"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("612"), new RString("6-12"), new RString("カテーテル"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("71△"), new RString("7-1"), new RString("障害高齢者自立度"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("72△"), new RString("7-2"), new RString("認知症高齢者自立度"));
        list.add(entity);

        return list;
    }

    /**
     * 各特記事項基本情報が変更した。
     *
     * @param record record
     * @param 特記事項 特記事項
     */
    @SuppressWarnings("unchecked")
    public void tokkiJikoHasChanged(int record, RString 特記事項) {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        RString key = RString.EMPTY;
        key = new RString(String.valueOf(当前ページ数).concat(String.valueOf(record)));

        if (特記事項.isEmpty()) {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
        } else if (!特記事項.equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項())) {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.編集ある.getCode());
        }

        gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));

    }

    /**
     * 各特記事項基本情報が変更した。
     *
     * @param record record
     * @param マスキングされたファイルID マスキングされたファイルID
     */
    @SuppressWarnings("unchecked")
    public void imgHasChanged(int record, RString マスキングされたファイルID) {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        RString key = RString.EMPTY;
        key = new RString(String.valueOf(当前ページ数).concat(String.valueOf(record)));

        if (!マスキングされたファイルID.equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項イメージ共有ファイルID())) {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.編集ある.getCode());
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.マスク.getコード());
        }

        gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity()
                .setTemp_特記事項イメージ共有ファイルID(マスキングされたファイルID);

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));

    }

    /**
     * 「戻る」ボタンの操作処理を行う。
     *
     * @return notEmptyFlg notEmptyFlg
     */
    @SuppressWarnings("unchecked")
    public boolean onClick_btnBack() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();
        boolean notEmptyFlg = false;
        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (!value.getTemp_特記事項().isEmpty()) {
                notEmptyFlg = true;
                break;
            }
        }
        return notEmptyFlg;
    }

    /**
     * 各特記事項基本情報が変更した。
     *
     */
    private void cleanData() {

        div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtFirstTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtFirstTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtSecondTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtSecondTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtThirdTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtThirdTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtFourthTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtFourthTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtFifthTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtFifthTokkiJiko().clearValue();

    }

    /**
     * first活性制御を行う。
     *
     */
    private void first活性制御() {
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun1())) {

            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun1())) {

            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setVisible(false);
        }

    }

    /**
     * second活性制御を行う。
     *
     */
    private void second活性制御() {
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun2())) {

            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun2())) {

            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * third活性制御を行う。
     *
     */
    private void third活性制御() {
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun3())) {

            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun3())) {

            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * fourth活性制御を行う。
     *
     */
    private void fourth活性制御() {
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun4())) {

            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun4())) {

            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * fifth活性制御を行う。
     *
     */
    private void fifth活性制御() {
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun5())) {

            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun5())) {

            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * 初期化項目設定を行う。
     *
     */
    private void 初期化項目設定(List<NinteichosahyoTokkijiko> returnList) {
        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
        for (int i = 0; i < returnList.size(); i++) {
            if (i == 0) {
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setValue(new Decimal(returnList.get(i).get認定調査特記事項連番()));
                div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun1(returnList.get(i).get特記事項テキスト_イメージ区分());
                div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun1(returnList.get(i).get原本マスク区分().value());
                div.getTokkiNyuryoku().setHiddenShinkiKubun1(ShinkiKubun.Tabに既存データ.getCode());
                div.getTokkiNyuryoku().setHiddenHensyuuKubun1(HensyuuKubun.編集なし.getCode());
                for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
                    if (entity.get認定調査特記事項番号().equals(returnList.get(i).get認定調査特記事項番号())) {
                        div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().setValue(entity.get画面表示用特記事項項番());
                        div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().setValue(entity.get認定調査項目());
                    }
                }
                if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setValue(returnList.get(i).get特記事項());
                } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
                }
                GaikyoTokkiYichiranNyurokuBusiness entity1 = new GaikyoTokkiYichiranNyurokuBusiness(
                        new RString(String.valueOf(当前ページ数).concat("1")),
                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().getText(),
                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().getText(),
                        div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun1(),
                        div.getTokkiNyuryoku().getHiddenGenbonMasukuKubun1(),
                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue(),
                        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().getSrc(),
                        div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getText(),
                        div.getTokkiNyuryoku().getHiddenShinkiKubun1(),
                        div.getTokkiNyuryoku().getHiddenHensyuuKubun1());
                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(当前ページ数).concat("1")), entity1);
            } else if (i == 1) {
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setValue(new Decimal(returnList.get(i).get認定調査特記事項連番()));
                div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun2(returnList.get(i).get特記事項テキスト_イメージ区分());
                div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun2(returnList.get(i).get原本マスク区分().value());
                div.getTokkiNyuryoku().setHiddenShinkiKubun2(ShinkiKubun.Tabに既存データ.getCode());
                div.getTokkiNyuryoku().setHiddenHensyuuKubun2(HensyuuKubun.編集なし.getCode());
                for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
                    if (entity.get認定調査特記事項番号().equals(returnList.get(i).get認定調査特記事項番号())) {
                        div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setValue(entity.get画面表示用特記事項項番());
                        div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().setValue(entity.get認定調査項目());
                    }
                }
                if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setValue(returnList.get(i).get特記事項());
                } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    //div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
                }
                GaikyoTokkiYichiranNyurokuBusiness entity2 = new GaikyoTokkiYichiranNyurokuBusiness(
                        new RString(String.valueOf(当前ページ数).concat("2")),
                        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getText(),
                        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().getText(),
                        div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun2(),
                        div.getTokkiNyuryoku().getHiddenGenbonMasukuKubun2(),
                        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().getValue(),
                        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().getSrc(),
                        div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getText(),
                        div.getTokkiNyuryoku().getHiddenShinkiKubun2(),
                        div.getTokkiNyuryoku().getHiddenHensyuuKubun2());
                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(当前ページ数).concat("2")), entity2);
            } else if (i == 2) {
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setValue(new Decimal(returnList.get(i).get認定調査特記事項連番()));
                div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun3(returnList.get(i).get特記事項テキスト_イメージ区分());
                div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun3(returnList.get(i).get原本マスク区分().value());
                div.getTokkiNyuryoku().setHiddenShinkiKubun3(ShinkiKubun.Tabに既存データ.getCode());
                div.getTokkiNyuryoku().setHiddenHensyuuKubun3(HensyuuKubun.編集なし.getCode());
                for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
                    if (entity.get認定調査特記事項番号().equals(returnList.get(i).get認定調査特記事項番号())) {
                        div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setValue(entity.get画面表示用特記事項項番());
                        div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().setValue(entity.get認定調査項目());
                    }
                }
                if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setValue(returnList.get(i).get特記事項());
                } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    //div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
                }
                GaikyoTokkiYichiranNyurokuBusiness entity3 = new GaikyoTokkiYichiranNyurokuBusiness(
                        new RString(String.valueOf(当前ページ数).concat("3")),
                        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getText(),
                        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().getText(),
                        div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun3(),
                        div.getTokkiNyuryoku().getHiddenGenbonMasukuKubun3(),
                        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue(),
                        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().getSrc(),
                        div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getText(),
                        div.getTokkiNyuryoku().getHiddenShinkiKubun3(),
                        div.getTokkiNyuryoku().getHiddenHensyuuKubun3());
                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(当前ページ数).concat("3")), entity3);
            } else if (i == int3) {
                div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setValue(new Decimal(returnList.get(i).get認定調査特記事項連番()));
                div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun4(returnList.get(i).get特記事項テキスト_イメージ区分());
                div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun4(returnList.get(i).get原本マスク区分().value());
                div.getTokkiNyuryoku().setHiddenShinkiKubun4(ShinkiKubun.Tabに既存データ.getCode());
                div.getTokkiNyuryoku().setHiddenHensyuuKubun4(HensyuuKubun.編集なし.getCode());
                for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
                    if (entity.get認定調査特記事項番号().equals(returnList.get(i).get認定調査特記事項番号())) {
                        div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setValue(entity.get画面表示用特記事項項番());
                        div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().setValue(entity.get認定調査項目());
                    }
                }
                if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setValue(returnList.get(i).get特記事項());
                } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    // div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
                }
                GaikyoTokkiYichiranNyurokuBusiness entity4 = new GaikyoTokkiYichiranNyurokuBusiness(
                        new RString(String.valueOf(当前ページ数).concat("4")),
                        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getText(),
                        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().getText(),
                        div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun4(),
                        div.getTokkiNyuryoku().getHiddenGenbonMasukuKubun4(),
                        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue(),
                        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().getSrc(),
                        div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().getText(),
                        div.getTokkiNyuryoku().getHiddenShinkiKubun4(),
                        div.getTokkiNyuryoku().getHiddenHensyuuKubun4());
                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(当前ページ数).concat("4")), entity4);
            } else if (i == int4) {
                div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setValue(new Decimal(returnList.get(i).get認定調査特記事項連番()));
                div.getTokkiNyuryoku().setHiddenTokkijikoTextImageKubun5(returnList.get(i).get特記事項テキスト_イメージ区分());
                div.getTokkiNyuryoku().setHiddenGenbonMasukuKubun5(returnList.get(i).get原本マスク区分().value());
                div.getTokkiNyuryoku().setHiddenShinkiKubun5(ShinkiKubun.Tabに既存データ.getCode());
                div.getTokkiNyuryoku().setHiddenHensyuuKubun5(HensyuuKubun.編集なし.getCode());
                for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
                    if (entity.get認定調査特記事項番号().equals(returnList.get(i).get認定調査特記事項番号())) {
                        div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setValue(entity.get画面表示用特記事項項番());
                        div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().setValue(entity.get認定調査項目());
                    }
                }
                if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setValue(returnList.get(i).get特記事項());
                } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(returnList.get(i).get特記事項テキスト_イメージ区分())) {
                    // div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
                }
                GaikyoTokkiYichiranNyurokuBusiness entity5 = new GaikyoTokkiYichiranNyurokuBusiness(
                        new RString(String.valueOf(当前ページ数).concat("5")),
                        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getText(),
                        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getText(),
                        div.getTokkiNyuryoku().getHiddenTokkijikoTextImageKubun5(),
                        div.getTokkiNyuryoku().getHiddenGenbonMasukuKubun5(),
                        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue(),
                        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().getSrc(),
                        div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().getText(),
                        div.getTokkiNyuryoku().getHiddenShinkiKubun5(),
                        div.getTokkiNyuryoku().getHiddenHensyuuKubun5());
                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(当前ページ数).concat("5")), entity5);
            }
        }
    }

    /**
     * fifth特記事項をチェックする。
     *
     */
    private void fifth特記事項をチェック() {

        if (div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue().isEmpty()) {

            throw new ApplicationException(DbeErrorMessages.新規未入力特記事項が有で新ページが追加不可.getMessage());
        } else {

            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
        }
    }

    /**
     * fourth特記事項をチェックする。
     *
     */
    private void fourth特記事項をチェック() {

        if (div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue().isEmpty()) {

            throw new ApplicationException(DbeErrorMessages.新規未入力特記事項が有で新ページが追加不可.getMessage());
        } else {

            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
        }
    }

    /**
     * third特記事項をチェックする。
     *
     */
    private void third特記事項をチェック() {

        if (div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue().isEmpty()) {

            throw new ApplicationException(DbeErrorMessages.新規未入力特記事項が有で新ページが追加不可.getMessage());
        } else {

            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
        }
    }

    /**
     * second特記事項をチェックする。
     *
     */
    private void second特記事項をチェック() {

        if (div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue().isEmpty()) {

            throw new ApplicationException(DbeErrorMessages.新規未入力特記事項が有で新ページが追加不可.getMessage());
        } else {

            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
        }
    }

    /**
     * first特記事項をチェックする。
     *
     */
    private void first特記事項をチェック() {

        if (div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getText().isEmpty()
                || div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue().isEmpty()) {

            throw new ApplicationException(DbeErrorMessages.新規未入力特記事項が有で新ページが追加不可.getMessage());
        } else {

            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
        }
    }
}
