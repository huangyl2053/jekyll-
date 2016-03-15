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
    private static final int INT5 = 5;
    private static final int INT8 = 8;

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

    private enum DBE2210003Keys {

        入力内容を取り消す用データ
    }

    /**
     * 認定調査結果登録3初期化の設定します。
     *
     */
    public void onLoad() {

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

        div.getChosaTaisho().getCcdNinteiShinseishaKihonInfo().initialize(temp_申請書管理番号);
        div.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getCcdChosaJisshishaJoho().intialize(model);

        当前ページ数 = 1;
        this.set各特記事項基本情報();

        this.set初期化活性制御();
    }

    /**
     * 「前へ」ボタンの操作処理を行う。
     *
     */
    @SuppressWarnings("unchecked")
    public void onClick_btnBeforeTokkiJiko() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString()) - 1;
        this.cleanData();
        this.初期化項目設定();

        this.set初期化活性制御();

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

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        this.cleanData();
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString()) + 1;

        if (gaikyoTokkiNyurokuMap.get(key1) == null
                || ShinkiKubun.新規データ.getCode().equals(gaikyoTokkiNyurokuMap.get(key1).getTemp_新規区分())) {
            this.first特記事項をチェック();
        } else if (gaikyoTokkiNyurokuMap.get(key2) == null
                || ShinkiKubun.新規データ.getCode().equals(gaikyoTokkiNyurokuMap.get(key2).getTemp_新規区分())) {
            this.second特記事項をチェック();
        } else if (gaikyoTokkiNyurokuMap.get(key3) == null
                || ShinkiKubun.新規データ.getCode().equals(gaikyoTokkiNyurokuMap.get(key3).getTemp_新規区分())) {
            this.third特記事項をチェック();
        } else if (gaikyoTokkiNyurokuMap.get(key4) == null
                || ShinkiKubun.新規データ.getCode().equals(gaikyoTokkiNyurokuMap.get(key4).getTemp_新規区分())) {
            this.fourth特記事項をチェック();
        } else if (gaikyoTokkiNyurokuMap.get(key5) == null
                || ShinkiKubun.新規データ.getCode().equals(gaikyoTokkiNyurokuMap.get(key5).getTemp_新規区分())) {
            this.fifth特記事項をチェック();
        } else {
            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数 + 1)));
        }

        this.初期化項目設定();

        this.set初期化活性制御();
    }

    /**
     * 特記事項番号1のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo1() {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
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
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > INT8) {
                div.getTokkiNyuryoku().getTxtFirstTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }
        div.getTokkiNyuryoku().getTxtFirstTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key1) == null) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.新規データ.getCode());

            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFirstTokkiRenban().getValue().toString()));
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getValue());
            gaikyoTokkiNyurokuMap.put(key1, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key1).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key1).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFirstTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key1).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 特記事項番号2のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo2() {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
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
            if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
            if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > INT8) {

                div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().clearValue();
                div.getTokkiNyuryoku().getTxtSecondTokkiRenban().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }
        div.getTokkiNyuryoku().getTxtSecondTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key2) == null) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.新規データ.getCode());

            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtSecondTokkiRenban().getValue().toString()));
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getValue());
            gaikyoTokkiNyurokuMap.put(key2, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key2).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key2).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtSecondTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key2).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 特記事項番号3のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo3() {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
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
            if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
            if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > INT8) {
                div.getTokkiNyuryoku().getTxtThirdTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }
        div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key3) == null) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.新規データ.getCode());

            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtThirdTokkiRenban().getValue().toString()));
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getValue());
            gaikyoTokkiNyurokuMap.put(key3, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key3).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key3).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtThirdTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key3).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 特記事項番号4のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo4() {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
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
            if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
            if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > INT8) {
                div.getTokkiNyuryoku().getTxtFourthTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }
        div.getTokkiNyuryoku().getTxtFourthTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key4) == null) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.新規データ.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFourthTokkiRenban().getValue().toString()));
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().getValue());
            gaikyoTokkiNyurokuMap.put(key4, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key4).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key4).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFourthTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key4).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));

    }

    /**
     * 特記事項番号5のlostfocus。
     *
     */
    @SuppressWarnings("unchecked")
    public void onBlur_ChosaKomokuNo5() {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
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
            if (div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
            if (div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) > INT8) {
                div.getTokkiNyuryoku().getTxtFifthTokkiRenban().clearValue();
                div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().clearValue();
                throw new ApplicationException(DbeErrorMessages.連番最大値を超過.getMessage());
            }
        }
        div.getTokkiNyuryoku().getTxtFifthTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
            if (entity.get画面表示用特記事項項番().equals(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue())) {
                div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().setValue(entity.get認定調査項目());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key5) == null) {

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.新規データ.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFifthTokkiRenban().getValue().toString()));
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().getValue());
            gaikyoTokkiNyurokuMap.put(key5, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key5).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key5).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFifthTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key5).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 「特記事項を保存する」ボタンの操作処理を行う。
     *
     */
    @SuppressWarnings("unchecked")
    public void onClick_Save() {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();
        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();
        RString 認定調査特記事項番号 = RString.EMPTY;

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();

            for (ChosaKoumokuAndTokkiBangoMapping entity : 認定調査特記事項番号List) {
                if (entity.get画面表示用特記事項項番().equals(entry.getValue().getTemp_認定調査特記事項番号())) {
                    認定調査特記事項番号 = entity.get認定調査特記事項番号();
                }
            }

            NinteichosahyoTokkijiko ninteichosahyoTokkijiko = new NinteichosahyoTokkijiko(
                    temp_申請書管理番号,
                    temp_認定調査履歴番号,
                    認定調査特記事項番号,
                    Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()),
                    value.getTemp_特記事項テキストイメージ区分(),
                    new Code(value.getTemp_原本マスク区分()));

            NinteichosahyoTokkijikoBuilder builder = ninteichosahyoTokkijiko.createBuilderForEdit();

            builder.set特記事項(value.getTemp_特記事項());

            if (ShinkiKubun.Tabに既存データ.getCode().equals(value.getTemp_新規区分())
                    && HensyuuKubun.編集ある.getCode().equals(value.getTemp_編集区分())) {
                ninteichosahyoTokkijiko = builder.build().modifiedModel();
                manager.save認定調査票_特記情報(ninteichosahyoTokkijiko);
            } else if (ShinkiKubun.新規データ.getCode().equals(value.getTemp_新規区分())
                    && HensyuuKubun.編集ある.getCode().equals(value.getTemp_編集区分())) {
                ninteichosahyoTokkijiko = builder.build();
                manager.save認定調査票_特記情報(ninteichosahyoTokkijiko);
            } else if (ShinkiKubun.Tabに既存データ.getCode().equals(value.getTemp_新規区分())
                    && HensyuuKubun.空白.getCode().equals(value.getTemp_編集区分())) {
                ninteichosahyoTokkijiko = builder.build().deleted();
                manager.save認定調査票_特記情報(ninteichosahyoTokkijiko);
            }
        }
    }

    /**
     * 「入力内容を取り消し」ボタンの操作処理を行う。
     *
     */
    @SuppressWarnings("unchecked")
    public void onClick_btnCancel() {

        gaikyoTokkiNyurokuMap = ViewStateHolder.get(DBE2210003Keys.入力内容を取り消す用データ, HashMap.class);

        this.初期化項目設定();
        this.set初期化活性制御();

    }

    /**
     * 各特記事項基本情報を設定します。
     *
     */
    private void set各特記事項基本情報() {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        List<NinteichosahyoTokkijiko> returnList = manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号);
        List<ChosaKoumokuAndTokkiBangoMapping> 認定調査特記事項番号List = this.get認定調査特記事項番号List();

        int k = 0;
        for (int i = 1; i <= (returnList.size() / INT5) + 1; i++) {
            for (int j = 1; j <= INT5; j++) {
                if (k >= returnList.size()) {
                    break;
                }
                GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_レコードNO(new RString(String.valueOf(i).concat(String.valueOf(j))));
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(returnList.get(k).get原本マスク区分().value());
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.Tabに既存データ.getCode());
                for (ChosaKoumokuAndTokkiBangoMapping entity1 : 認定調査特記事項番号List) {
                    if (entity1.get認定調査特記事項番号().equals(returnList.get(k).get認定調査特記事項番号())) {
                        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項番号(entity1.get画面表示用特記事項項番());
                        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項名称(entity1.get認定調査項目());
                    }
                }
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                        setTemp_特記事項テキストイメージ区分(returnList.get(k).get特記事項テキスト_イメージ区分());
                if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(returnList.get(k).get特記事項テキスト_イメージ区分())) {
                    entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(returnList.get(k).get特記事項());
                }
                // TODO
//                else if (TokkijikoTextImageKubun.イメージ.getコード().equals(returnList.get(k).get特記事項テキスト_イメージ区分())) {
//                    //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
//                }
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.編集なし.getCode());
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                        setTemp_認定調査特記事項連番(new RString(String.valueOf(returnList.get(k).get認定調査特記事項連番())));

                gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(i).concat(String.valueOf(j))), entity);

                k++;
            }
        }

        this.初期化項目設定();

    }

    private int get総ページ数() {

        残数 = 総項目数 % INT5;
        商 = 総項目数 / INT5;

        if (総項目数 == 0 || 残数 != 0) {
            総ページ数 = 商 + 1;
        } else {
            総ページ数 = 商;
        }
        return 総ページ数;
    }

    private void set初期化活性制御() {

        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

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

        if (gaikyoTokkiNyurokuMap.get(key1) == null) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(true);
        } else if (gaikyoTokkiNyurokuMap.get(key2) == null) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            this.first活性制御(key1);

            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(true);
        } else if (gaikyoTokkiNyurokuMap.get(key3) == null) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);

            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(true);
        } else if (gaikyoTokkiNyurokuMap.get(key4) == null) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
            this.third活性制御(key3);

            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(true);
        } else if (gaikyoTokkiNyurokuMap.get(key5) == null) {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
            this.third活性制御(key3);
            this.fourth活性制御(key4);

            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().setDisabled(true);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(true);
        } else {

            div.getTokkiNyuryoku().getTblFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
            this.third活性制御(key3);
            this.fourth活性制御(key4);
            this.fifth活性制御(key5);

        }

        if (当前ページ数 == 1) {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(true);
        } else {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(false);
        }
    }

    private List<ChosaKoumokuAndTokkiBangoMapping> get認定調査特記事項番号List() {

        List<ChosaKoumokuAndTokkiBangoMapping> list = new ArrayList<>();
        ChosaKoumokuAndTokkiBangoMapping entity
                = new ChosaKoumokuAndTokkiBangoMapping(new RString("101"), new RString("1-1"), new RString("麻痺"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("102"), new RString("1-2"), new RString("拘縮"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("103"), new RString("1-3"), new RString("寝返り"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("104"), new RString("1-4"), new RString("起き上がり"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("105"), new RString("1-5"), new RString("座位保持"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("106"), new RString("1-6"), new RString("両足での立位"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("107"), new RString("1-7"), new RString("歩行"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("108"), new RString("1-8"), new RString("立ち上がり"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("109"), new RString("1-9"), new RString("片足での立位"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("110"), new RString("1-10"), new RString("洗身"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("111"), new RString("1-11"), new RString("つめ切り"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("112"), new RString("1-12"), new RString("視力"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("113"), new RString("1-13"), new RString("聴力"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("201"), new RString("2-1"), new RString("移乗"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("202"), new RString("2-2"), new RString("移動"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("203"), new RString("2-3"), new RString("えん下"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("204"), new RString("2-4"), new RString("食事摂取"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("205"), new RString("2-5"), new RString("排尿"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("206"), new RString("2-6"), new RString("排便"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("207"), new RString("2-7"), new RString("口腔清潔"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("208"), new RString("2-8"), new RString("洗顔"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("209"), new RString("2-9"), new RString("整髪"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("210"), new RString("2-10"), new RString("上衣の着脱"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("211"), new RString("2-11"), new RString("ズボン等の着脱"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("212"), new RString("2-12"), new RString("外出頻度"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("301"), new RString("3-1"), new RString("意思の伝達"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("302"), new RString("3-2"), new RString("毎日の日課を理解"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("303"), new RString("3-3"), new RString("生年月日をいう"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("304"), new RString("3-4"), new RString("短期記憶"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("305"), new RString("3-5"), new RString("自分の名前をいう"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("306"), new RString("3-6"), new RString("今の季節を理解"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("307"), new RString("3-7"), new RString("場所の理解"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("308"), new RString("3-8"), new RString("徘徊"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("309"), new RString("3-9"), new RString("外出して戻れない"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("401"), new RString("4-1"), new RString("被害的"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("402"), new RString("4-2"), new RString("作話"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("403"), new RString("4-3"), new RString("感情が不安定"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("404"), new RString("4-4"), new RString("昼夜逆転"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("405"), new RString("4-5"), new RString("同じ話をする"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("406"), new RString("4-6"), new RString("大声を出す"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("407"), new RString("4-7"), new RString("介護に抵抗"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("408"), new RString("4-8"), new RString("落ち着きなし"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("409"), new RString("4-9"), new RString("一人で出たがる"));
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
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("501"), new RString("5-1"), new RString("薬の内服"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("502"), new RString("5-2"), new RString("金銭の管理"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("503"), new RString("5-3"), new RString("日常の意思決定"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("504"), new RString("5-4"), new RString("集団への不適応"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("505"), new RString("5-5"), new RString("買い物"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("506"), new RString("5-6"), new RString("簡単な調理"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("601"), new RString("6-1"), new RString("点滴の管理"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("602"), new RString("6-2"), new RString("中心静脈栄養"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("603"), new RString("6-3"), new RString("透析"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("604"), new RString("6-4"), new RString("ストーマの処置"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("605"), new RString("6-5"), new RString("酸素療法"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("606"), new RString("6-6"), new RString("レスピレーター"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("607"), new RString("6-7"), new RString("気管切開の処置"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("608"), new RString("6-8"), new RString("疼痛の看護"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("609"), new RString("6-9"), new RString("経管栄養"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("610"), new RString("6-10"), new RString("モニター測定"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("611"), new RString("6-11"), new RString("じょくそうの処置"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("612"), new RString("6-12"), new RString("カテーテル"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("701"), new RString("7-1"), new RString("障害高齢者自立度"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("702"), new RString("7-2"), new RString("認知症高齢者自立度"));
        list.add(entity);
        entity = new ChosaKoumokuAndTokkiBangoMapping(new RString("001"), new RString("0-0"), new RString("その他特記事項"));
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
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
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
    private void first活性制御(RString key) {
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setVisible(false);
        }

    }

    /**
     * second活性制御を行う。
     *
     */
    private void second活性制御(RString key) {
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * third活性制御を行う。
     *
     */
    private void third活性制御(RString key) {
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * fourth活性制御を行う。
     *
     */
    private void fourth活性制御(RString key) {
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * fifth活性制御を行う。
     *
     */
    private void fifth活性制御(RString key) {
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setVisible(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setVisible(false);
        }
    }

    /**
     * 初期化項目設定を行う。
     *
     */
    private void 初期化項目設定() {

        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        if (gaikyoTokkiNyurokuMap.get(key1) != null) {

            div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtFirstTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key1).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項名称());

            if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項テキストイメージ区分())) {
                div.getTokkiNyuryoku().getTxtFirstTokkiJiko().setValue(
                        gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項());
            }
            //TODO
            //else if (TokkijikoTextImageKubun.イメージ.getコード().equals(
            //gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項テキストイメージ区分())) {
            //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
            //}
        }

        if (gaikyoTokkiNyurokuMap.get(key2) != null) {

            div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtSecondTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key2).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項名称());

            if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項テキストイメージ区分())) {
                div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setValue(
                        gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項());
            }
            // TODO
//            else if (TokkijikoTextImageKubun.イメージ.getコード().equals(
//                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項テキストイメージ区分())) {
//                //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
//            }
        }

        if (gaikyoTokkiNyurokuMap.get(key3) != null) {

            div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key3).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項名称());

            if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項テキストイメージ区分())) {
                div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setValue(
                        gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項());
            }
            // TODO
//            else if (TokkijikoTextImageKubun.イメージ.getコード().equals(
//                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項テキストイメージ区分())) {
//                //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
//            }
        }

        if (gaikyoTokkiNyurokuMap.get(key4) != null) {

            div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtFourthTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key4).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項名称());

            if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項テキストイメージ区分())) {
                div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setValue(
                        gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項());
            }
            // TODO
//            else if (TokkijikoTextImageKubun.イメージ.getコード().equals(
//                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項テキストイメージ区分())) {
//                //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
//            }
        }

        if (gaikyoTokkiNyurokuMap.get(key5) != null) {

            div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtFifthTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key5).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項名称());

            if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項テキストイメージ区分())) {
                div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setValue(
                        gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項());
            }
            // TODO
//            else if (TokkijikoTextImageKubun.イメージ.getコード().equals(
//                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項テキストイメージ区分())) {
//                //div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(new RString(returnList.get(i).get特記事項イメージ共有ファイルID().toString()));
//            }
        }

        総項目数 = gaikyoTokkiNyurokuMap.size();
        総ページ数 = get総ページ数();

        div.getTokkiNyuryoku()
                .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        div.getTokkiNyuryoku()
                .setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
        div.getTokkiNyuryoku()
                .setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));

        ViewStateHolder.put(DBE2210003Keys.入力内容を取り消す用データ, gaikyoTokkiNyurokuMap);
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
