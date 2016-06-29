/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210003;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査結果登録3のHandlerクラスです。
 *
 * @reamsid_L DBE-0040-030 huangh
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

    /**
     * 認定調査結果登録3初期化の設定します。
     *
     * @param model ChosaJisshishaJohoModel
     * @param temp_申請書管理番号 ShinseishoKanriNo
     * @param temp_認定調査履歴番号 int
     * @return HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness>
     */
    public HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> onLoad(
            ChosaJisshishaJohoModel model,
            ShinseishoKanriNo temp_申請書管理番号,
            int temp_認定調査履歴番号) {

        div.getChosaTaisho().getCcdNinteiShinseishaKihonInfo().initialize(temp_申請書管理番号);
        div.getChosaTaisho().getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getCcdChosaJisshishaJoho().intialize(model);

        当前ページ数 = 1;
        this.set各特記事項基本情報(temp_申請書管理番号, temp_認定調査履歴番号);

        this.set初期化活性制御();

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

        return gaikyoTokkiNyurokuMap;
    }

    /**
     * 「前へ」ボタンの操作処理を行う。
     *
     */
    public void onClick_btnBeforeTokkiJiko() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString()) - 1;
        総ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenTotalPageCount().toString());
        this.cleanData();
        this.初期化項目設定();

        this.set初期化活性制御();

        if (当前ページ数 > 1) {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(false);
        } else {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(true);
        }

        div.getTokkiNyuryoku()
                .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        div.getTokkiNyuryoku()
                .setHiddenPageNo(new RString(String.valueOf(当前ページ数)));

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 「次へ」ボタンの操作処理を行う。
     *
     */
    public void onClick_btnAfterTokkiJiko() {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        総ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenTotalPageCount().toString());
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

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
            if (当前ページ数 == 総ページ数) {
                総ページ数 = 総ページ数 + 1;
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
            }
            当前ページ数 = 当前ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
            div.getTokkiNyuryoku()
                    .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        }

        this.cleanData();

        this.初期化項目設定();

        this.set初期化活性制御();
    }

    /**
     * 特記事項番号1のlostfocus。
     *
     */
    public void onBlur_ChosaKomokuNo1() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        int renban = 0;
        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
        }
        div.getTokkiNyuryoku().getTxtFirstTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().
                setValue(NinteichosaKomoku09B.toValue(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue()).get名称());

        if (gaikyoTokkiNyurokuMap.get(key1) == null) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtSecondTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().setDisabled(true);
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
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtFirstTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key1, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key1).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key1).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFirstTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key1).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 特記事項番号2のlostfocus。
     *
     */
    public void onBlur_ChosaKomokuNo2() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();
        int renban = 0;
        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
        }
        div.getTokkiNyuryoku().getTxtSecondTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().
                setValue(NinteichosaKomoku09B.toValue(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue()).get名称());

        if (gaikyoTokkiNyurokuMap.get(key2) == null) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().setDisabled(true);
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
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtSecondTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key2, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key2).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key2).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtSecondTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key2).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 特記事項番号3のlostfocus。
     *
     */
    public void onBlur_ChosaKomokuNo3() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        int renban = 0;
        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
        }
        div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().
                setValue(NinteichosaKomoku09B.toValue(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue()).get名称());

        if (gaikyoTokkiNyurokuMap.get(key3) == null) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFourthTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().setDisabled(true);
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
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtThirdTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key3, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key3).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key3).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtThirdTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key3).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getValue());
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
    }

    /**
     * 特記事項番号4のlostfocus。
     *
     */
    public void onBlur_ChosaKomokuNo4() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();

        int renban = 0;
        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();
            if (div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getText().equals(value.getTemp_認定調査特記事項番号())
                    && Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()) <= INT8
                    && renban < Integer.valueOf(value.getTemp_認定調査特記事項連番().toString())) {
                renban = Integer.valueOf(value.getTemp_認定調査特記事項連番().toString());

            }
        }
        div.getTokkiNyuryoku().getTxtFourthTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().
                setValue(NinteichosaKomoku09B.toValue(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue()).get名称());

        if (gaikyoTokkiNyurokuMap.get(key4) == null) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getTxtFifthTokkiRenban().setDisabled(true);
            div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().setDisabled(true);
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
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtFourthTokkiJiko().getValue());
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
    public void onBlur_ChosaKomokuNo5() {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

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
        }
        div.getTokkiNyuryoku().getTxtFifthTokkiRenban().setValue(Decimal.valueOf(renban + 1));

        div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().
                setValue(NinteichosaKomoku09B.toValue(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue()).get名称());

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
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項(div.getTokkiNyuryoku().getTxtFifthTokkiJiko().getValue());
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
     * @param temp_申請書管理番号 temp_申請書管理番号
     * @param temp_認定調査履歴番号 temp_認定調査履歴番号
     */
    public void onClick_Save(ShinseishoKanriNo temp_申請書管理番号, int temp_認定調査履歴番号) {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);

        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();
        RString 認定調査特記事項番号;

        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
            GaikyoTokkiYichiranNyurokuBusiness value = entry.getValue();

            認定調査特記事項番号 = NinteichosaKomoku09B.toValue(
                    entry.getValue().getTemp_認定調査特記事項番号()).get調査特記事項番序();

            NinteichosahyoTokkijiko ninteichosahyoTokkijiko = manager.get認定調査票_特記情報ByKey(
                    temp_申請書管理番号,
                    temp_認定調査履歴番号,
                    認定調査特記事項番号,
                    Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()),
                    value.getTemp_特記事項テキストイメージ区分(),
                    new Code(value.getTemp_原本マスク区分()));

            if (ninteichosahyoTokkijiko == null) {
                ninteichosahyoTokkijiko = new NinteichosahyoTokkijiko(
                        temp_申請書管理番号,
                        temp_認定調査履歴番号,
                        認定調査特記事項番号,
                        Integer.valueOf(value.getTemp_認定調査特記事項連番().toString()),
                        value.getTemp_特記事項テキストイメージ区分(),
                        new Code(value.getTemp_原本マスク区分()));
            }

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
     * @param gaikyoTokkiNyurokuMap HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness>
     */
    public void onClick_btnCancel(HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> gaikyoTokkiNyurokuMap) {

        当前ページ数 = 1;

        this.初期化項目設定();
        this.set初期化活性制御();

        総項目数 = gaikyoTokkiNyurokuMap.size();
        総ページ数 = get総ページ数();

        div.getTokkiNyuryoku()
                .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        div.getTokkiNyuryoku()
                .setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
        div.getTokkiNyuryoku()
                .setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));

    }

    /**
     * 各特記事項基本情報を設定します。
     *
     */
    private void set各特記事項基本情報(ShinseishoKanriNo temp_申請書管理番号, int temp_認定調査履歴番号) {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        List<NinteichosahyoTokkijiko> returnList = manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号);

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
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項番号(
                        NinteichosaKomoku09B.getAllBy調査特記事項番(returnList.get(k).get認定調査特記事項番号()).get特記事項番号());
                entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項名称(
                        NinteichosaKomoku09B.getAllBy調査特記事項番(returnList.get(k).get認定調査特記事項番号()).get名称());
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
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setVisible(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setVisible(true);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
//            div.getTokkiNyuryoku().getBtnFirstImageMasking().setVisible(true);
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

    /**
     * 各特記事項基本情報が変更した。
     *
     * @param record record
     * @param 特記事項 特記事項
     */
    public void tokkiJikoHasChanged(int record, RString 特記事項) {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return;
        }
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key = new RString(String.valueOf(当前ページ数).concat(String.valueOf(record)));

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
            if (当前ページ数 == 総ページ数) {
                総ページ数 = 総ページ数 + 1;
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
            }
            当前ページ数 = 当前ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
            div.getTokkiNyuryoku()
                    .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
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
            if (当前ページ数 == 総ページ数) {
                総ページ数 = 総ページ数 + 1;
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
            }
            当前ページ数 = 当前ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
            div.getTokkiNyuryoku()
                    .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
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
            if (当前ページ数 == 総ページ数) {
                総ページ数 = 総ページ数 + 1;
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
            }
            当前ページ数 = 当前ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
            div.getTokkiNyuryoku()
                    .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
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
            if (当前ページ数 == 総ページ数) {
                総ページ数 = 総ページ数 + 1;
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
            }
            当前ページ数 = 当前ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
            div.getTokkiNyuryoku()
                    .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        }
    }

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
            if (当前ページ数 == 総ページ数) {
                総ページ数 = 総ページ数 + 1;
                div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
            }
            当前ページ数 = 当前ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
            div.getTokkiNyuryoku()
                    .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
        }
    }
}
