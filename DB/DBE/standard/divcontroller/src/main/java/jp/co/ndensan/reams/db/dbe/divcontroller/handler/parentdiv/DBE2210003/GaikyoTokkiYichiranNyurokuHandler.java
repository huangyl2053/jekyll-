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
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003.GaikyoTokkiYichiranNyurokuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
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
    private static final RString DELETE = new RString("DELETE");

    /**
     * コンストラクタです。
     *
     * @param div GaikyoTokkiYichiranNyurokuDiv
     */
    public GaikyoTokkiYichiranNyurokuHandler(GaikyoTokkiYichiranNyurokuDiv div) {
        this.div = div;
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
        div.getRenrakusakiKihon().setIsOpen(false);
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().intialize(model);
        div.getChosaJisshisha().setIsOpen(false);

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
     * 特記事項の最大文字数を設定します。
     * 特記事項の最大文字数はコンフィグで制御します。
     */
    public void set特記事項最大文字数() {
        int 最大文字数 = Integer.parseInt(DbBusinessConfig.get(
                ConfigNameDBE.認定調査票特記事項最大入力文字数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setMaxLength(最大文字数);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setMaxLength(最大文字数);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setMaxLength(最大文字数);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setMaxLength(最大文字数);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setMaxLength(最大文字数);
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
        cleanData();
        初期化項目設定(temp_申請書管理番号);
        set初期化活性制御();

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
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);

        setPageNo();
        cleanData();
        初期化項目設定(temp_申請書管理番号);
        set初期化活性制御();
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
     * 特記事項番号1のonChange処理。
     *
     */
    public void onChange_ChosaKomokuNo1() {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key = new RString(String.valueOf(当前ページ数).concat("1"));
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

        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            setCommonItem(entity);
            setEachItem(entity,
                    div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().getValue(),
                    new RString(div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().getValue().toString()),
                    div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().getValue(),
                    div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFirstTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFirstChosaKomokuMeisho().getValue());
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(null);
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getLblFirstMaskExist().setDisplayNone(true);
                div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(RString.EMPTY);
                div.getTokkiNyuryoku().setHiddenIsDeleteFirstTokki(RString.EMPTY);
            }
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項番号2のonChange処理。
     *
     */
    public void onChange_ChosaKomokuNo2() {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key = new RString(String.valueOf(当前ページ数).concat("2"));
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

        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            setCommonItem(entity);
            setEachItem(entity,
                    div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().getValue(),
                    new RString(div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().getValue().toString()),
                    div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().getValue(),
                    div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtSecondChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtSecondTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtSecondTokkiJikoMeisho().getValue());
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(null);
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getLblSecondMaskExist().setDisplayNone(true);
                div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(RString.EMPTY);
                div.getTokkiNyuryoku().setHiddenIsDeleteSecondTokki(RString.EMPTY);
            }
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項番号3のonChange処理。
     *
     */
    public void onChange_ChosaKomokuNo3() {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key = new RString(String.valueOf(当前ページ数).concat("3"));
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

        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            setCommonItem(entity);
            setEachItem(entity,
                    div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().getValue(),
                    new RString(div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().getValue().toString()),
                    div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().getValue(),
                    div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtThirdChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtThirdTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtThirdTokkiJikoMeisho().getValue());
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(null);
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getLblThirdMaskExist().setDisplayNone(true);
                div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(RString.EMPTY);
                div.getTokkiNyuryoku().setHiddenIsDeleteThirdTokki(RString.EMPTY);
            }
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項番号4のonChange処理。
     *
     */
    public void onChange_ChosaKomokuNo4() {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key = new RString(String.valueOf(当前ページ数).concat("4"));
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

        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            setCommonItem(entity);
            setEachItem(entity,
                    div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().getValue(),
                    new RString(div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().getValue().toString()),
                    div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().getValue(),
                    div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFourthChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFourthTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFourthTokkiJikoMeisho().getValue());
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(null);
                div.getTokkiNyuryoku().getTblFourthTokkiJiko().getLblFourthMaskExist().setDisplayNone(true);
                div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(RString.EMPTY);
                div.getTokkiNyuryoku().setHiddenIsDeleteFourthTokki(RString.EMPTY);
            }
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項番号5のonChange処理。
     *
     */
    public void onChange_ChosaKomokuNo5() {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        当前ページ数 = Integer.valueOf(div.getTokkiNyuryoku().getHiddenPageNo().toString());
        RString key = new RString(String.valueOf(当前ページ数).concat("5"));
        Set<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Entry<RString, GaikyoTokkiYichiranNyurokuBusiness>> it = set.iterator();
        int renban = 0;
        while (it.hasNext()) {
            Entry<RString, GaikyoTokkiYichiranNyurokuBusiness> entry = it.next();
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

        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);

            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            setCommonItem(entity);
            setEachItem(entity,
                    div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().getValue(),
                    new RString(div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().getValue().toString()),
                    div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().getValue(),
                    div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().getValue());
            gaikyoTokkiNyurokuMap.put(key, entity);
        } else {
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(div.getTokkiNyuryoku().getTxtFifthChosaKomokuNo().getValue());
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(new RString(div.getTokkiNyuryoku().getTxtFifthTokkiRenban().getValue().toString()));
            gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(div.getTokkiNyuryoku().getTxtFifthTokkiJikoMeisho().getValue());
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(null);
                div.getTokkiNyuryoku().getTblFifthTokkiJiko().getLblFifthMaskExist().setDisplayNone(true);
                div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(RString.EMPTY);
                div.getTokkiNyuryoku().setHiddenIsDeleteFifthTokki(RString.EMPTY);
            }
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項が変更されたかどうか取得します。
     *
     * @param key MapのKey
     * @param 変更後特記事項番号 変更後特記事項番号
     * @return true：変更有　false：変更なし
     */
    public boolean isChange特記事項番号(RString key, RString 変更後特記事項番号) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return true;
        }
        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            return true;
        }
        if (!変更後特記事項番号.equals(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号())) {
            return true;
        }
        return false;
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
            if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
                gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(RString.EMPTY);
            }
        }

        gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * マスクした特記事項の変更処理です。
     *
     * @param key 概況特記一覧から対象となる特記事項を取得するKEY
     * @param 特記事項 修正後特記事項
     * @param isDelete 特記事項マスクの削除フラグ
     */
    public void changeHiddenTokkiJiko(RString key, RString 特記事項, boolean isDelete) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);

        if (gaikyoTokkiNyurokuMap_MASK.get(key) == null) {
            GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.マスク.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項番号(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_認定調査特記事項連番(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                    setTemp_特記事項名称(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項名称());
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
            entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setDelete(isDelete);
            gaikyoTokkiNyurokuMap_MASK.put(key, entity);
        } else {
            gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
            gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setDelete(isDelete);
        }

        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 削除対象が妥当かどうかチェックします。
     *
     * @param key 修正対象の特記事項のKEY
     * @param isDelete 削除かどうか
     * @return エラーメッセージ 修正対象が妥当であればNull, 妥当でなければエラーメッセージ
     */
    public ErrorMessage checkChange削除(RString key, boolean isDelete) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        ErrorMessage message = new ErrorMessage(null, null);

        if (isDelete) {
            if (getExists特記事項最大連番_削除フラグ変更(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号())
                    .compareTo(new Decimal(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番().toString())) != 0) {
                message = new ErrorMessage(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode(),
                        DbeErrorMessages.特記事項追加削除不可.getMessage().replace("削除", "最大", "削除").evaluate());
            }
        } else {
            if (getNotExists特記事項最小連番_削除フラグ変更(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号())
                    .compareTo(new Decimal(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番().toString())) != 0) {
                message = new ErrorMessage(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode(),
                        DbeErrorMessages.特記事項追加削除不可.getMessage().replace("追加", "最小", "追加").evaluate());
            }
        }
        return message;
    }

    /**
     * EntityのDeleteフラグを設定します。
     *
     * @param key
     * @param isDelete
     */
    public void setDeleteFlag(RString key, Boolean isDelete) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        gaikyoTokkiNyurokuMap.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setDelete(isDelete);
        if (gaikyoTokkiNyurokuMap_MASK.get(key) != null) {
            gaikyoTokkiNyurokuMap_MASK.get(key).getGaikyoTokkiYichiranNyurokuRelateEntity().setDelete(isDelete);
        }
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap));
        div.getTokkiNyuryoku()
                .setHiddenGaikyoTokkiNyurokuMap_MASK(DataPassingConverter.serialize(gaikyoTokkiNyurokuMap_MASK));
    }

    /**
     * 特記事項番号修正時、修正対象が妥当かどうかチェックします。
     *
     * @param key 特記事項番号のKEY
     * @param 特記事項番号 修正後特記事項番号
     * @return エラーメッセージ 修正対象が妥当であればNull, 妥当でなければエラーメッセージ
     */
    public ErrorMessage checkChange特記事項番号(RString key, RString 特記事項番号) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        ErrorMessage message = new ErrorMessage(null, null);
        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return message;
        }
        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            if (isExistsDeleteFlag(特記事項番号)) {
                message = new ErrorMessage(UrErrorMessages.設定不可.getMessage().getCode(),
                        UrErrorMessages.設定不可.getMessage().replace("削除対象に同一特記事項番号が選択されている").evaluate());
            }
        } else {
            if (getExists特記事項最大連番_特記事項番号変更(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号())
                    .compareTo(new Decimal(gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項連番().toString())) != 0) {
                message = new ErrorMessage(DbeErrorMessages.特記事項追加削除不可.getMessage().getCode(),
                        DbeErrorMessages.特記事項追加削除不可.getMessage().replace("変更", "最大", "変更").evaluate());
            }
            if (isExistsDeleteFlag(特記事項番号)) {
                message = new ErrorMessage(UrErrorMessages.設定不可.getMessage().getCode(),
                        UrErrorMessages.設定不可.getMessage().replace("削除対象に同一特記事項番号が選択されている").evaluate());
            }
        }
        return message;
    }

    /**
     * 修正前の特記事項番号を取得します。
     *
     * @param key 対象となる特記事項番号のKEYです。
     * @return 修正前の特記事項番号
     */
    public RString get変更前特記事項番号(RString key) {
        gaikyoTokkiNyurokuMap = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap(), HashMap.class);
        if (gaikyoTokkiNyurokuMap == null || gaikyoTokkiNyurokuMap.isEmpty()) {
            return RString.EMPTY;
        }
        if (gaikyoTokkiNyurokuMap.get(key) == null) {
            return RString.EMPTY;
        }
        return gaikyoTokkiNyurokuMap.get(key).getTemp_認定調査特記事項番号();
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

    /**
     * 特記事項１に関するコントロールの活性制御
     *
     * @param isDisabled
     */
    public void setDisabledTokkiNyuryoku_First(boolean isDisabled) {
        div.getTokkiNyuryoku().getTxtFirstChosaKomokuNo().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getTxtFirstTokkiJiko().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnFirstMasking().setDisabled(isDisabled);
    }

    /**
     * 特記事項２に関するコントロールの活性制御
     *
     * @param isDisabled
     */
    public void setDisabledTokkiNyuryoku_Second(boolean isDisabled) {
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnSecondMasking().setDisabled(isDisabled);
    }

    /**
     * 特記事項３に関するコントロールの活性制御
     *
     * @param isDisabled
     */
    public void setDisabledTokkiNyuryoku_Third(boolean isDisabled) {
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnThirdMasking().setDisabled(isDisabled);
    }

    /**
     * 特記事項４に関するコントロールの活性制御
     *
     * @param isDisabled
     */
    public void setDisabledTokkiNyuryoku_Fourth(boolean isDisabled) {
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnFourthMasking().setDisabled(isDisabled);
    }

    /**
     * 特記事項５に関するコントロールの活性制御
     *
     * @param isDisabled
     */
    public void setDisabledTokkiNyuryoku_Fifth(boolean isDisabled) {
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(isDisabled);
        div.getTokkiNyuryoku().getBtnFifthMasking().setDisabled(isDisabled);
    }

    /**
     * マスクデータがあるかどうかを取得します。
     *
     * @param key MapのKEY
     * @return true：マスクデータ有　false：マスクデータなし
     */
    public boolean isExistMaskData(RString key) {
        gaikyoTokkiNyurokuMap_MASK = DataPassingConverter.deserialize(div.getTokkiNyuryoku().getHiddenGaikyoTokkiNyurokuMap_MASK(), HashMap.class);
        if (gaikyoTokkiNyurokuMap_MASK == null) {
            return false;
        }
        if (gaikyoTokkiNyurokuMap_MASK.get(key) == null) {
            return false;
        }
        if (gaikyoTokkiNyurokuMap_MASK.get(key).getTemp_特記事項() == null) {
            return false;
        }
        return true;
    }

    private Decimal getExists特記事項最大連番_特記事項番号変更(RString 認定調査特記事項番号) {
        Decimal 最大連番 = Decimal.ZERO;
        for (GaikyoTokkiYichiranNyurokuBusiness 特記事項情報 : gaikyoTokkiNyurokuMap.values()) {
            if (特記事項情報.getTemp_原本マスク区分().equals(GenponMaskKubun.原本.getコード())
                    && 認定調査特記事項番号.equals(特記事項情報.getTemp_認定調査特記事項番号())
                    && 最大連番.compareTo(new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString())) < 0) {
                最大連番 = new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString());
            }
        }
        return 最大連番;
    }

    private boolean isExistsDeleteFlag(RString 認定調査特記事項番号) {
        for (GaikyoTokkiYichiranNyurokuBusiness 特記事項情報 : gaikyoTokkiNyurokuMap.values()) {
            if (特記事項情報.getTemp_原本マスク区分().equals(GenponMaskKubun.原本.getコード())
                    && 認定調査特記事項番号.equals(特記事項情報.getTemp_認定調査特記事項番号())
                    && 特記事項情報.isDelete()) {
                return true;
            }
        }
        return false;
    }

    private Decimal getNotExists特記事項最小連番_削除フラグ変更(RString 認定調査特記事項番号) {
        Decimal 最小連番 = Decimal.TEN;
        for (GaikyoTokkiYichiranNyurokuBusiness 特記事項情報 : gaikyoTokkiNyurokuMap.values()) {
            if (特記事項情報.getTemp_原本マスク区分().equals(GenponMaskKubun.原本.getコード())
                    && 認定調査特記事項番号.equals(特記事項情報.getTemp_認定調査特記事項番号())
                    && 特記事項情報.isDelete()
                    && 最小連番.compareTo(new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString())) > 0) {
                最小連番 = new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString());
            }
        }
        return 最小連番;
    }

    private Decimal getExists特記事項最大連番_削除フラグ変更(RString 認定調査特記事項番号) {
        Decimal 最大連番 = Decimal.ZERO;
        for (GaikyoTokkiYichiranNyurokuBusiness 特記事項情報 : gaikyoTokkiNyurokuMap.values()) {
            if (特記事項情報.getTemp_原本マスク区分().equals(GenponMaskKubun.原本.getコード())
                    && 認定調査特記事項番号.equals(特記事項情報.getTemp_認定調査特記事項番号())
                    && !特記事項情報.isDelete()
                    && 最大連番.compareTo(new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString())) < 0) {
                最大連番 = new Decimal(特記事項情報.getTemp_認定調査特記事項連番().toString());
            }
        }
        return 最大連番;
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
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項番号(
                NinteichosaKomoku09B.getAllBy調査特記事項番(認定調査票特記事項.get認定調査特記事項番号()).get特記事項番号());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項名称(
                NinteichosaKomoku09B.getAllBy調査特記事項番(認定調査票特記事項.get認定調査特記事項番号()).get名称());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                setTemp_特記事項テキストイメージ区分(認定調査票特記事項.get特記事項テキスト_イメージ区分());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(認定調査票特記事項.get特記事項());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                setTemp_認定調査特記事項連番(new RString(String.valueOf(認定調査票特記事項.get認定調査特記事項連番())));

        return entity;
    }

    private void set初期化活性制御() {
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        if (gaikyoTokkiNyurokuMap.get(key1) == null) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(false);
        } else if (gaikyoTokkiNyurokuMap.get(key2) == null) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);
            this.first活性制御(key1);
        } else if (gaikyoTokkiNyurokuMap.get(key3) == null) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
        } else if (gaikyoTokkiNyurokuMap.get(key4) == null) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
            this.third活性制御(key3);
        } else if (gaikyoTokkiNyurokuMap.get(key5) == null) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
            this.third活性制御(key3);
            this.fourth活性制御(key4);
        } else {
            div.getTokkiNyuryoku().getBtnAfterTokkiJiko().setDisabled(false);
            this.first活性制御(key1);
            this.second活性制御(key2);
            this.third活性制御(key3);
            this.fourth活性制御(key4);
            this.fifth活性制御(key5);
        }
        if (当前ページ数 != 1) {
            div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(false);
        }
        set特記事項最大文字数();
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

    private void cleanData() {
        List<RString> clearList = new ArrayList<>();
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().clearValue();
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getLblFirstMaskExist().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().setSelectedItemsByKey(clearList);
        div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFirstMasking().setDisabled(true);
        div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().setHiddenIsDeleteFirstTokki(RString.EMPTY);

        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getLblSecondMaskExist().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().setSelectedItemsByKey(clearList);
        div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().setDisabled(true);
        div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnSecondMasking().setDisabled(true);
        div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().setHiddenIsDeleteSecondTokki(RString.EMPTY);

        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getLblThirdMaskExist().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().setSelectedItemsByKey(clearList);
        div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().setDisabled(true);
        div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnThirdMasking().setDisabled(true);
        div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().setHiddenIsDeleteThirdTokki(RString.EMPTY);

        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getLblFourthMaskExist().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().setSelectedItemsByKey(clearList);
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFourthMasking().setDisabled(true);
        div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().setHiddenIsDeleteFourthTokki(RString.EMPTY);

        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().clearValue();
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().clearValue();
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().clearValue();
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().clearValue();
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setSrc(RString.EMPTY);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getLblFifthMaskExist().setDisplayNone(true);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().setSelectedItemsByKey(clearList);
        div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(true);
        div.getTokkiNyuryoku().getBtnFifthMasking().setDisabled(true);
        div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(RString.EMPTY);
        div.getTokkiNyuryoku().setHiddenIsDeleteFifthTokki(RString.EMPTY);

        div.getTokkiNyuryoku().getBtnBeforeTokkiJiko().setDisabled(true);
        div.getTokkiNyuryoku().getBtnAfterTokkiJiko().setDisabled(true);
    }

    private void first活性制御(RString key) {
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().setDisabled(false);
            if (!gaikyoTokkiNyurokuMap.get(key).isDelete()) {
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setDisabled(false);
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisabled(false);
                div.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun().setDisabled(false);
                div.getTokkiNyuryoku().getBtnFirstMasking().setDisabled(false);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setDisplayNone(true);
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setDisplayNone(false);
        }
    }

    private void second活性制御(RString key) {
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().setDisabled(false);
            if (!gaikyoTokkiNyurokuMap.get(key).isDelete()) {
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setDisabled(false);
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisabled(false);
                div.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun().setDisabled(false);
                div.getTokkiNyuryoku().getBtnSecondMasking().setDisabled(false);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setDisplayNone(true);
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setDisplayNone(false);
        }
    }

    private void third活性制御(RString key) {
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().setDisabled(false);
            if (!gaikyoTokkiNyurokuMap.get(key).isDelete()) {
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setDisabled(false);
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisabled(false);
                div.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun().setDisabled(false);
                div.getTokkiNyuryoku().getBtnThirdMasking().setDisabled(false);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setDisplayNone(true);
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setDisplayNone(false);
        }
    }

    private void fourth活性制御(RString key) {
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
        }
        div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().setDisabled(false);
        if (!gaikyoTokkiNyurokuMap.get(key).isDelete()) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setDisabled(false);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun().setDisabled(false);
            div.getTokkiNyuryoku().getBtnFourthMasking().setDisabled(false);
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setDisplayNone(true);
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setDisplayNone(false);
        }
    }

    private void fifth活性制御(RString key) {
        if ((TokkijikoTextImageKubun.テキスト.getコード()).equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().setDisabled(false);
            if (!gaikyoTokkiNyurokuMap.get(key).isDelete()) {
                div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setDisabled(false);
                div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisabled(false);
                div.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun().setDisabled(false);
                div.getTokkiNyuryoku().getBtnFifthMasking().setDisabled(false);
            }
        } else if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key).getTemp_特記事項テキストイメージ区分())) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setDisplayNone(true);
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko().setDisplayNone(false);
        }
    }

    private void 初期化項目設定(ShinseishoKanriNo temp_申請書管理番号) {
        RString key1 = new RString(String.valueOf(当前ページ数).concat("1"));
        RString key2 = new RString(String.valueOf(当前ページ数).concat("2"));
        RString key3 = new RString(String.valueOf(当前ページ数).concat("3"));
        RString key4 = new RString(String.valueOf(当前ページ数).concat("4"));
        RString key5 = new RString(String.valueOf(当前ページ数).concat("5"));

        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(temp_申請書管理番号);
        List<RString> deleteList = new ArrayList<>();
        deleteList.add(new RString("0"));

        if (gaikyoTokkiNyurokuMap.get(key1) != null) {
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項());
            if (gaikyoTokkiNyurokuMap.get(key1).isDelete()) {
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getChkFirstChosaDelete().setSelectedItemsByKey(deleteList);
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key1).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key1).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key1))
                    && gaikyoTokkiNyurokuMap_MASK.get(key1).getTemp_特記事項() != null) {
                div.getTokkiNyuryoku().setHiddenFirstTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key1).getTemp_特記事項());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getLblFirstMaskExist().setDisplayNone(false);
                if (gaikyoTokkiNyurokuMap_MASK.get(key1).isDelete()) {
                    div.getTokkiNyuryoku().setHiddenIsDeleteFirstTokki(DELETE);
                }
            }
        }
        if (gaikyoTokkiNyurokuMap.get(key2) != null) {
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項());
            if (gaikyoTokkiNyurokuMap.get(key2).isDelete()) {
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getChkSecondChosaDelete().setSelectedItemsByKey(deleteList);
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key2).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key2).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key2))
                    && gaikyoTokkiNyurokuMap_MASK.get(key2).getTemp_特記事項() != null) {
                div.getTokkiNyuryoku().setHiddenSecondTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key2).getTemp_特記事項());
                div.getTokkiNyuryoku().getTblSecondTokkiJiko().getLblSecondMaskExist().setDisplayNone(false);
                if (gaikyoTokkiNyurokuMap_MASK.get(key2).isDelete()) {
                    div.getTokkiNyuryoku().setHiddenIsDeleteSecondTokki(DELETE);
                }
            }
        }
        if (gaikyoTokkiNyurokuMap.get(key3) != null) {
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項());
            if (gaikyoTokkiNyurokuMap.get(key3).isDelete()) {
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getChkThirdChosaDelete().setSelectedItemsByKey(deleteList);
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key3).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key3).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key3))
                    && gaikyoTokkiNyurokuMap_MASK.get(key3).getTemp_特記事項() != null) {
                div.getTokkiNyuryoku().setHiddenThirdTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key3).getTemp_特記事項());
                div.getTokkiNyuryoku().getTblThirdTokkiJiko().getLblThirdMaskExist().setDisplayNone(false);
                if (gaikyoTokkiNyurokuMap_MASK.get(key3).isDelete()) {
                    div.getTokkiNyuryoku().setHiddenIsDeleteThirdTokki(DELETE);
                }
            }
        }
        if (gaikyoTokkiNyurokuMap.get(key4) != null) {
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項());
            if (gaikyoTokkiNyurokuMap.get(key4).isDelete()) {
                div.getTokkiNyuryoku().getTblFourthTokkiJiko().getChkFourthChosaDelete().setSelectedItemsByKey(deleteList);
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key4).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key4).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key4))
                    && gaikyoTokkiNyurokuMap_MASK.get(key4).getTemp_特記事項() != null) {
                div.getTokkiNyuryoku().setHiddenFourthTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key4).getTemp_特記事項());
                div.getTokkiNyuryoku().getTblFourthTokkiJiko().getLblFourthMaskExist().setDisplayNone(false);
                if (gaikyoTokkiNyurokuMap_MASK.get(key4).isDelete()) {
                    div.getTokkiNyuryoku().setHiddenIsDeleteFourthTokki(DELETE);
                }
            }
        }
        if (gaikyoTokkiNyurokuMap.get(key5) != null) {
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項番号());
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban().setValue(
                    new Decimal(gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項連番().toString()));
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項名称());
            div.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko().setValue(
                    gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項());
            if (gaikyoTokkiNyurokuMap.get(key5).isDelete()) {
                div.getTokkiNyuryoku().getTblFifthTokkiJiko().getChkFifthChosaDelete().setSelectedItemsByKey(deleteList);
            }
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(gaikyoTokkiNyurokuMap.get(key5).getTemp_特記事項テキストイメージ区分())) {
                RString path = 共有ファイルを引き出す(イメージ情報, temp_申請書管理番号,
                        gaikyoTokkiNyurokuMap.get(key5).getTemp_認定調査特記事項番号());
                div.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko().setSrc(path);
            }
            if (isExistsテキストマスク特記事項(gaikyoTokkiNyurokuMap_MASK.get(key5))
                    && gaikyoTokkiNyurokuMap_MASK.get(key5).getTemp_特記事項() != null) {
                div.getTokkiNyuryoku().setHiddenFifthTokkiJiko(gaikyoTokkiNyurokuMap_MASK.get(key5).getTemp_特記事項());
                div.getTokkiNyuryoku().getTblFifthTokkiJiko().getLblFifthMaskExist().setDisplayNone(false);
                if (gaikyoTokkiNyurokuMap_MASK.get(key5).isDelete()) {
                    div.getTokkiNyuryoku().setHiddenIsDeleteFifthTokki(DELETE);
                }
            }
        }
    }

    private void setCommonItem(GaikyoTokkiYichiranNyurokuBusiness entity) {
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
    }

    private void setEachItem(GaikyoTokkiYichiranNyurokuBusiness entity,
            RString 認定調査特記事項番号,
            RString 認定調査特記事項連番,
            RString 特記事項名称,
            RString 特記事項) {
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項番号(認定調査特記事項番号);
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項連番(認定調査特記事項連番);
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項名称(特記事項名称);
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(特記事項);
    }

    private boolean isExistsテキストマスク特記事項(GaikyoTokkiYichiranNyurokuBusiness 概況特記マスク一覧情報) {
        if (概況特記マスク一覧情報 != null && (TokkijikoTextImageKubun.テキスト.getコード()).equals(
                概況特記マスク一覧情報.getTemp_特記事項テキストイメージ区分())) {
            return true;
        }
        return false;
    }

    private void setPageNo() {
        if (当前ページ数 == 総ページ数) {
            総ページ数 = 総ページ数 + 1;
            div.getTokkiNyuryoku().setHiddenTotalPageCount(new RString(String.valueOf(総ページ数)));
        }
        当前ページ数 = 当前ページ数 + 1;
        div.getTokkiNyuryoku().setHiddenPageNo(new RString(String.valueOf(当前ページ数)));
        div.getTokkiNyuryoku()
                .getLblTokkiJikoPage().setText(new RString(String.valueOf(当前ページ数).concat("/").concat(String.valueOf(総ページ数))));
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
}
