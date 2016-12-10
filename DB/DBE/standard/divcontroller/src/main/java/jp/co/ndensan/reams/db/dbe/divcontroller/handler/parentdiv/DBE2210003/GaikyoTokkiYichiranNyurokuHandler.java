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
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
    private HashMap<RString, GaikyoTokkiYichiranNyurokuBusiness> gaikyoTokkiNyurokuMap_MASK = new HashMap<>();
    private int 総項目数 = 0;
    private int 残数 = 0;
    private int 商 = 0;
    private int 総ページ数 = 1;
    private int 当前ページ数 = 1;
    private static final int INT1 = 1;
    private static final int INT4 = 4;
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
        div.getRenrakusakiKihon().getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().intialize(model);

        cleanData();

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
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));

        div.getTokkiNyuryoku()
                .setHiddenOriginalGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenOriginalGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));

        return gaikyoTokkiNyurokuMap;
    }

    /**
     * 「前へ」ボタンの操作処理を行う。
     *
     * @param temp_申請書管理番号 temp_申請書管理番号
     */
    public void onClick_btnBeforeTokkiJiko(ShinseishoKanriNo temp_申請書管理番号) {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString()) - 1;
        総ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenTotalPageCount().toString());
        this.cleanData();
        this.初期化項目設定(temp_申請書管理番号);

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
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 「次へ」ボタンの操作処理を行う。
     *
     * @param temp_申請書管理番号 temp_申請書管理番号
     */
    public void onClick_btnAfterTokkiJiko(ShinseishoKanriNo temp_申請書管理番号) {

        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        総ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenTotalPageCount().toString());
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);

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

        this.初期化項目設定(temp_申請書管理番号);

        this.set初期化活性制御();
    }

    /**
     * 認定調査特記事項番号を指定のフォームに変換します。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 指定フォームに変換した認定調査特記事項番号
     */
    public RString to認定調査特記事項番号_表示Form(TextBox 認定調査特記事項番号) {
        RStringBuilder 調査項目番号 = new RStringBuilder();
        調査項目番号.append(認定調査特記事項番号.getValue());
        if (調査項目番号.length() <= 1) {
            return 調査項目番号.toRString();
        }
        if (!調査項目番号.stringAt(INT1).equals(new RString("-"))) {
            if (調査項目番号.stringAt(INT1).equals(new RString("0"))) {
                調査項目番号.deleteCharAt(INT1);
            }
            調査項目番号.insert(INT1, new RString("-"));
        }
        return 調査項目番号.toRString();
    }

    /**
     * 認定調査特記事項番号をテキストマスキングダイアログの指定のフォームに変換します。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @return 指定フォームに変換した認定調査特記事項番号
     */
    public RString to認定調査特記事項番号_マスキングForm(TextBox 認定調査特記事項番号) {
        RStringBuilder 調査項目番号 = new RStringBuilder();
        調査項目番号.append(認定調査特記事項番号.getValue());
        調査項目番号.deleteCharAt(INT1);
        return 調査項目番号.toRString();
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
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        save認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号, gaikyoTokkiNyurokuMap.entrySet());
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        save認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号, gaikyoTokkiNyurokuMap_MASK.entrySet());
    }

    /**
     * 「入力内容を取り消し」ボタンの操作処理を行う。
     *
     * @param temp_申請書管理番号 temp_申請書管理番号
     */
    public void onClick_btnCancel(ShinseishoKanriNo temp_申請書管理番号) {

        当前ページ数 = 1;
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenOriginalGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenOriginalGaikyoTokkiNyurokuMap_MASK(), HashMap.class);

        this.cleanData();
        this.初期化項目設定(temp_申請書管理番号);
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
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));

    }

    /**
     * 各特記事項基本情報が変更した。
     *
     * @param key key
     * @param 特記事項 特記事項
     */
    public void tokkiJikoHasChanged(RString key, RString 特記事項) {

        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return;
        }
        if (特記事項.isEmpty()) {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.空白.getCode());
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(RString.EMPTY);
            }
        } else if (!特記事項.equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項())) {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.編集ある.getCode());
        }

        gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項修正時、修正対象が妥当かどうかチェックします。
     *
     * @param key 修正対象の特記事項のKEY
     * @param 特記事項 修正後特記事項
     * @return エラーメッセージ 修正対象が妥当であればNull, 妥当でなければエラーメッセージ
     */
    public ErrorMessage checkChange特記事項(RString key, RString 特記事項) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        ErrorMessage message = new ErrorMessage(null, null);

        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return message;
        }
        if (特記事項.isEmpty()) {
            if (getExists特記事項最大連番(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号())
                    .compareTo(new Decimal(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番().toString())) != 0) {
                message = new ErrorMessage(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode(),
                        DbeErrorMessages.特記事項追加削除不可.getMessage().replace("削除", "最大", "削除").evaluate());
            }
        } else if (HensyuuKubun.空白.getCode().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_編集区分())
                && !特記事項.equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項())
                && getNotExists特記事項最小連番(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号())
                .compareTo(new Decimal(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番().toString())) != 0) {
            message = new ErrorMessage(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode(),
                    DbeErrorMessages.特記事項追加削除不可.getMessage().replace("追加", "最小", "追加").evaluate());
        }
        return message;
    }

    /**
     * 入力済みの特記事項を取得します。
     *
     * @param key 対象となる特記事項のKEYです。
     * @return 入力済みの特記事項
     */
    public RString get変更前特記事項(RString key) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return RString.EMPTY;
        }
        return gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項();
    }

    private Decimal getNotExists特記事項最小連番(RString 認定調査特記事項番号) {
        Decimal 最小連番 = Decimal.TEN;
        for (GaikyoTokkiYichiranNyurokuBusiness 特記事項情報 : gaikyoTokkiNyurokuMap.values()) {
            if (特記事項情報.getTemp_原本マスク区分().equals(GenponMaskKubun.原本.getコード())
                    && 認定調査特記事項番号.equals(特記事項情報.getTemp_認定調査特記事項番号())
                    && 特記事項情報.getTemp_特記事項().isEmpty()
                    && 最小連番.compareTo(new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString())) > 0) {
                最小連番 = new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString());
            }
        }
        return 最小連番;
    }

    private Decimal getExists特記事項最大連番(RString 認定調査特記事項番号) {
        Decimal 最大連番 = Decimal.ZERO;
        for (GaikyoTokkiYichiranNyurokuBusiness 特記事項情報 : gaikyoTokkiNyurokuMap.values()) {
            if (特記事項情報.getTemp_原本マスク区分().equals(GenponMaskKubun.原本.getコード())
                    && 認定調査特記事項番号.equals(特記事項情報.getTemp_認定調査特記事項番号())
                    && !特記事項情報.getTemp_特記事項().isEmpty()
                    && 最大連番.compareTo(new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString())) < 0) {
                最大連番 = new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString());
            }
        }
        return 最大連番;
    }

    /**
     * マスクした特記事項の変更処理です。
     *
     * @param key 概況特記一覧から対象となる特記事項を取得するKEY
     * @param 特記事項 修正後特記事項
     */
    public void changeHiddenTokkiJiko(RString key, RString 特記事項) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);

        if (gaikyoTokkiNyurokuMap_MASK.get(key) == null) {
            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.マスク.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.新規データ.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.編集ある.getCode());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項名称());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
            gaikyoTokkiNyurokuMap_MASK.put(key, entity);
        } else {
            if (特記事項.isEmpty()) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                        setTemp_編集区分(HensyuuKubun.空白.getCode());
            } else {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                        setTemp_編集区分(HensyuuKubun.編集ある.getCode());
            }
            gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
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
     * 各特記事項基本情報を設定します。
     *
     */
    private void set各特記事項基本情報(ShinseishoKanriNo temp_申請書管理番号, int temp_認定調査履歴番号) {

        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);

        List<NinteichosahyoTokkijiko> returnList = manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号);
        RString 前回認定調査特記事項番号 = RString.EMPTY;
        int 前回認定調査特記事項連番 = 0;

        int k = 0;
        outSide:
        for (int i = 1; i <= (returnList.size() / INT5) + 1; i++) {
            for (int j = 1; j <= INT4 || !RString.isNullOrEmpty(前回認定調査特記事項番号);) {
                if (!RString.isNullOrEmpty(前回認定調査特記事項番号)
                        && (!前回認定調査特記事項番号.equals(returnList.get(k).get認定調査特記事項番号())
                        || 前回認定調査特記事項連番 != returnList.get(k).get認定調査特記事項連番())) {
                    j++;
                }
                if (returnList.size() <= 0) {
                    break outSide;
                }
                if (GenponMaskKubun.原本.getコード().equals(returnList.get(k).get原本マスク区分().value())) {
                    GaikyoTokkiYichiranNyurokuBusiness entity = get概況特記一覧Entity(i, j, returnList.get(k));
                    gaikyoTokkiNyurokuMap.put(new RString(String.valueOf(i).concat(String.valueOf(j))), entity);
                } else if (GenponMaskKubun.マスク.getコード().equals(returnList.get(k).get原本マスク区分().value())) {
                    GaikyoTokkiYichiranNyurokuBusiness entity = get概況特記一覧Entity(i, j, returnList.get(k));
                    gaikyoTokkiNyurokuMap_MASK.put(new RString(String.valueOf(i).concat(String.valueOf(j))), entity);
                }

                前回認定調査特記事項番号 = returnList.get(k).get認定調査特記事項番号();
                前回認定調査特記事項連番 = returnList.get(k).get認定調査特記事項連番();
                k++;
                if (k >= returnList.size()) {
                    break outSide;
                }
                if (j > INT4 && (!前回認定調査特記事項番号.equals(returnList.get(k).get認定調査特記事項番号())
                        || 前回認定調査特記事項連番 != returnList.get(k).get認定調査特記事項連番())) {
                    前回認定調査特記事項番号 = RString.EMPTY;
                    前回認定調査特記事項連番 = 0;
                }
            }
        }
        this.初期化項目設定(temp_申請書管理番号);
    }

    private GaikyoTokkiYichiranNyurokuBusiness get概況特記一覧Entity(int i, int j, NinteichosahyoTokkijiko 認定調査票特記事項) {
        GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_レコードNO(new RString(String.valueOf(i).concat(String.valueOf(j))));
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(認定調査票特記事項.get原本マスク区分().value());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_新規区分(ShinkiKubun.Tabに既存データ.getCode());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項番号(
                NinteichosaKomoku09B.getAllBy調査特記事項番(認定調査票特記事項.get認定調査特記事項番号()).get特記事項番号());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項名称(
                NinteichosaKomoku09B.getAllBy調査特記事項番(認定調査票特記事項.get認定調査特記事項番号()).get名称());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                setTemp_特記事項テキストイメージ区分(認定調査票特記事項.get特記事項テキスト_イメージ区分());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(認定調査票特記事項.get特記事項());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_編集区分(HensyuuKubun.編集なし.getCode());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                setTemp_認定調査特記事項連番(new RString(String.valueOf(認定調査票特記事項.get認定調査特記事項連番())));

        return entity;
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

    private RString 共有ファイルを引き出す(Image イメージ情報, ShinseishoKanriNo temp_申請書管理番号, RString 認定調査特記事項番号) {
        RString imagePath = RString.EMPTY;
        if (イメージ情報 != null) {
            NinteiShinseiJohoManager manager = InstanceProvider.create(NinteiShinseiJohoManager.class);
            NinteiShinseiJoho entity = manager.get要介護認定申請情報(temp_申請書管理番号);
            FilesystemName sharedFileName = new FilesystemName(
                    entity.get証記載保険者番号().concat(entity.get被保険者番号()).concat(認定調査特記事項番号));
            imagePath = getFilePath(イメージ情報.getイメージ共有ファイルID(), sharedFileName.toRString());
            if (RString.isNullOrEmpty(imagePath)) {
                imagePath = getFilePath(イメージ情報.getイメージ共有ファイルID(), sharedFileName.toRString());
            }
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
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
        div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().getImgFirstTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtSecondTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtSecondTokkiJiko().clearValue();
        div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().getImgSecondTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtThirdTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtThirdTokkiJiko().clearValue();
        div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().getImgThirdTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtFourthTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtFourthTokkiJiko().clearValue();
        div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().getImgFourthTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTxtFifthTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTxtFifthTokkiJiko().clearValue();
        div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().getImgFifthTokkiJiko().setSrc(RString.EMPTY);

    }

    /**
     * first活性制御を行う。
     *
     */
    private void first活性制御(RString key) {
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(true);
            div.getTokkiNyuryoku().getBtnFirstImageMasking().setDisabled(true);
        }

    }

    /**
     * second活性制御を行う。
     *
     */
    private void second活性制御(RString key) {
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(true);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(true);
            div.getTokkiNyuryoku().getBtnSecondImageMasking().setDisabled(true);
        }
    }

    /**
     * third活性制御を行う。
     *
     */
    private void third活性制御(RString key) {
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(true);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(true);
            div.getTokkiNyuryoku().getBtnThirdImageMasking().setDisabled(true);
        }
    }

    /**
     * fourth活性制御を行う。
     *
     */
    private void fourth活性制御(RString key) {
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(true);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(true);
            div.getTokkiNyuryoku().getBtnFourthImageMasking().setDisabled(true);
        }
    }

    /**
     * fifth活性制御を行う。
     *
     */
    private void fifth活性制御(RString key) {
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().setDisabled(true);
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setVisible(false);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {

            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(true);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(true);
            div.getTokkiNyuryoku().getBtnFifthImageMasking().setDisabled(true);
        }
    }

    /**
     * 初期化項目設定を行う。
     *
     */
    private void 初期化項目設定(ShinseishoKanriNo temp_申請書管理番号) {

        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(temp_申請書管理番号);

        if (gaikyoTokkiNyurokuMap.get(key1) != null) {

            div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtFirstTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key1).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTxtFirstTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項());
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key1))) {
                div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key1).getTemp_特記事項());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key2) != null) {

            div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtSecondTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key2).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTxtSecondTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項());
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key2))) {
                div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key2).getTemp_特記事項());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key3) != null) {

            div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtThirdTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key3).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTxtThirdTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項());
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key3))) {
                div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key3).getTemp_特記事項());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key4) != null) {

            div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtFourthTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key4).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTxtFourthTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項());
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key4))) {
                div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key4).getTemp_特記事項());
            }
        }

        if (gaikyoTokkiNyurokuMap.get(key5) != null) {

            div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTxtFifthTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.
                            get(key5).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTxtFifthTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項());
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key5))) {
                div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key5).getTemp_特記事項());
            }
        }
    }

    private boolean isExistsテキストマスク特記事項(GaikyoTokkiYichiranNyurokuBusiness 概況特記マスク一覧情報) {
        if (概況特記マスク一覧情報 != null && (TokkijikoTextImageKubun.テキスト.getコード()).equals(
                概況特記マスク一覧情報.getTemp_特記事項テキストイメージ区分())) {
            return true;
        }
        return false;
    }

    private void save認定調査票_特記情報(ShinseishoKanriNo temp_申請書管理番号,
            int temp_認定調査履歴番号,
            Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set) {
        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
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
                ninteichosahyoTokkijiko.toEntity().setState(EntityDataState.Added);
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
