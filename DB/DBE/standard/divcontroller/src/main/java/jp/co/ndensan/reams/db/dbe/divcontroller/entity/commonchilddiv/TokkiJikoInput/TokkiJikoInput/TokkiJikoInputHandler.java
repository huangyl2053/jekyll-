/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.tokkijikoinput.TokkiJikoInputModel;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSourceConverter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n3423
 */
public class TokkiJikoInputHandler {

    private final TokkiJikoInputDiv div;
    private final RString KEY第一群 = new RString("1");
    private final RString KEY第二群 = new RString("2");
    private final RString KEY第三群 = new RString("3");
    private final RString KEY第四群 = new RString("4");
    private final RString KEY第五群 = new RString("5");
    private final RString KEY特別な医療群 = new RString("6");
    private final RString 読点 = new RString("。");
    private final RString 全面テキスト = new RString("1");
    private final RString sortOrder = new RString("dbTokkiJikoNo");
    private final Decimal 最大連番数 = new Decimal(9);
    private final int dgTxtTokkiJikoWidth = 860;
    private final int 短冊特記事項最大入力文字数 = Integer.parseInt(DbBusinessConfig.get(
            ConfigNameDBE.認定調査票特記事項最大入力文字数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());

    /**
     * コンストラクタです。
     *
     * @param div TokkiJikoInputDiv
     */
    public TokkiJikoInputHandler(TokkiJikoInputDiv div) {
        this.div = div;
    }

    /**
     * 特記事項入力ダイアログのonLoad処理です。
     *
     */
    public void onLoad() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        div.getChosaTaishosha().getCcdNinteiShinseishaKihon().initialize(temp_申請書管理番号);
        div.getChosaTaishosha().getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getChosaTaishosha().setIsOpen(false);
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Shokai);

        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        model.set認定申請日(ViewStateHolder.get(ViewStateKeys.申請日, RString.class));
        model.set調査実施日(ViewStateHolder.get(ViewStateKeys.調査実施日, RString.class));
        model.set調査実施場所(ViewStateHolder.get(ViewStateKeys.調査実施場所, RString.class));
        model.set実施場所名称(ViewStateHolder.get(ViewStateKeys.実施場所名称, RString.class));
        model.set所属機関コード(ViewStateHolder.get(ViewStateKeys.所属機関コード, RString.class));
        model.set所属機関名称(ViewStateHolder.get(ViewStateKeys.所属機関名称, RString.class));
        model.set記入者コード(ViewStateHolder.get(ViewStateKeys.記入者コード, RString.class));
        model.set記入者名称(ViewStateHolder.get(ViewStateKeys.記入者名称, RString.class));
        model.set調査区分(ViewStateHolder.get(ViewStateKeys.調査区分, RString.class));
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        model.setイメージテキスト区分(ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class));
        model.set実施場所ImagePath(ViewStateHolder.get(ViewStateKeys.イメージ情報, RString.class));
        div.getChosaJisshisha().getCcdChosaJisshishaJoho().intialize(model);
        div.getChosaJisshisha().setIsOpen(false);

        div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().setSelectedKey(KEY第一群);
        setDdlTokkiJikoNo();
        set特記事項情報();
        set初期状態の保存();
        if (全面テキスト.equals(DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            div.getTokkiJikoNyuryoku().getBtnAddRemban().setDisplayNone(true);
            div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getGridSetting().getColumn(new RString("txtTokkiJiko")).setWidth(dgTxtTokkiJikoWidth);
        } else {
            div.getTokkiJikoNyuryoku().getBtnInput().setDisplayNone(true);
            div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setMaxLength(短冊特記事項最大入力文字数);
        }
    }

    private void set初期状態の保存() {
        div.setHdnRadSelectedKey(div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().getSelectedKey());
        div.setHdnDdlSelectedKey(div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey());
    }

    /**
     * ラジオボタンの切り替え時に表示するドロップダウンリストの内容を設定します。
     */
    public void setDdlTokkiJikoNo() {
        HashMap<RString, RString> map = new LinkedHashMap<>();
        RString selectedKey;
        if (KEY第一群.equals(div.getRadTokkiJikoGroup().getSelectedKey())) {
            map.put(NinteiChosaTokkiJikou.麻痺等の有無.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.麻痺等の有無));
            map.put(NinteiChosaTokkiJikou.拘縮の有無.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.拘縮の有無));
            map.put(NinteiChosaTokkiJikou.寝返り.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.寝返り));
            map.put(NinteiChosaTokkiJikou.起き上がり.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.起き上がり));
            map.put(NinteiChosaTokkiJikou.座位保持.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.座位保持));
            map.put(NinteiChosaTokkiJikou.両足での立位保持.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.両足での立位保持));
            map.put(NinteiChosaTokkiJikou.歩行.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.歩行));
            map.put(NinteiChosaTokkiJikou.立ち上がり.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.立ち上がり));
            map.put(NinteiChosaTokkiJikou.片足での立位.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.片足での立位));
            map.put(NinteiChosaTokkiJikou.洗身.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.洗身));
            map.put(NinteiChosaTokkiJikou.つめ切り.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.つめ切り));
            map.put(NinteiChosaTokkiJikou.視力.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.視力));
            map.put(NinteiChosaTokkiJikou.聴力.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.聴力));
            selectedKey = NinteiChosaTokkiJikou.麻痺等の有無.get認定調査票_特記情報_認定調査特記事項番号();
        } else if (KEY第二群.equals(div.getRadTokkiJikoGroup().getSelectedKey())) {
            map.put(NinteiChosaTokkiJikou.移乗.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.移乗));
            map.put(NinteiChosaTokkiJikou.移動.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.移動));
            map.put(NinteiChosaTokkiJikou.えん下.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.えん下));
            map.put(NinteiChosaTokkiJikou.食事摂取.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.食事摂取));
            map.put(NinteiChosaTokkiJikou.排尿.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.排尿));
            map.put(NinteiChosaTokkiJikou.排便.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.排便));
            map.put(NinteiChosaTokkiJikou.口腔清潔.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.口腔清潔));
            map.put(NinteiChosaTokkiJikou.洗顔.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.洗顔));
            map.put(NinteiChosaTokkiJikou.整髪.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.整髪));
            map.put(NinteiChosaTokkiJikou.上衣の着脱.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.上衣の着脱));
            map.put(NinteiChosaTokkiJikou.ズボン等の着脱.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.ズボン等の着脱));
            map.put(NinteiChosaTokkiJikou.外出頻度.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.外出頻度));
            selectedKey = NinteiChosaTokkiJikou.移乗.get認定調査票_特記情報_認定調査特記事項番号();
        } else if (KEY第三群.equals(div.getRadTokkiJikoGroup().getSelectedKey())) {
            map.put(NinteiChosaTokkiJikou.意思の伝達.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.意思の伝達));
            map.put(NinteiChosaTokkiJikou.毎日の日課を理解.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.毎日の日課を理解));
            map.put(NinteiChosaTokkiJikou.生年月日や年齢を言う.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.生年月日や年齢を言う));
            map.put(NinteiChosaTokkiJikou.短期記憶.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.短期記憶));
            map.put(NinteiChosaTokkiJikou.自分の名前を言う.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.自分の名前を言う));
            map.put(NinteiChosaTokkiJikou.今の季節を理解する.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.今の季節を理解する));
            map.put(NinteiChosaTokkiJikou.場所の理解.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.場所の理解));
            map.put(NinteiChosaTokkiJikou.徘徊.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.徘徊));
            map.put(NinteiChosaTokkiJikou.外出すると戻れない.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.外出すると戻れない));
            selectedKey = NinteiChosaTokkiJikou.意思の伝達.get認定調査票_特記情報_認定調査特記事項番号();
        } else if (KEY第四群.equals(div.getRadTokkiJikoGroup().getSelectedKey())) {
            map.put(NinteiChosaTokkiJikou.被害的.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.被害的));
            map.put(NinteiChosaTokkiJikou.作話.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.作話));
            map.put(NinteiChosaTokkiJikou.感情が不安定.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.感情が不安定));
            map.put(NinteiChosaTokkiJikou.昼夜逆転.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.昼夜逆転));
            map.put(NinteiChosaTokkiJikou.同じ話をする.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.同じ話をする));
            map.put(NinteiChosaTokkiJikou.大声をだす.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.大声をだす));
            map.put(NinteiChosaTokkiJikou.介護に抵抗.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.介護に抵抗));
            map.put(NinteiChosaTokkiJikou.落ち着きなし.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.落ち着きなし));
            map.put(NinteiChosaTokkiJikou.一人で出たがる.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.一人で出たがる));
            map.put(NinteiChosaTokkiJikou.収集癖.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.収集癖));
            map.put(NinteiChosaTokkiJikou.物や衣類を壊す.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.物や衣類を壊す));
            map.put(NinteiChosaTokkiJikou.ひどい物忘れ.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.ひどい物忘れ));
            map.put(NinteiChosaTokkiJikou.独り言_独り笑い.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.独り言_独り笑い));
            map.put(NinteiChosaTokkiJikou.自分勝手に行動する.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.自分勝手に行動する));
            map.put(NinteiChosaTokkiJikou.話がまとまらない.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.話がまとまらない));
            selectedKey = NinteiChosaTokkiJikou.被害的.get認定調査票_特記情報_認定調査特記事項番号();
        } else if (KEY第五群.equals(div.getRadTokkiJikoGroup().getSelectedKey())) {
            map.put(NinteiChosaTokkiJikou.薬の内服.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.薬の内服));
            map.put(NinteiChosaTokkiJikou.金銭の管理.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.金銭の管理));
            map.put(NinteiChosaTokkiJikou.日常の意思決定.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.日常の意思決定));
            map.put(NinteiChosaTokkiJikou.集団への不適応.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.集団への不適応));
            map.put(NinteiChosaTokkiJikou.買い物.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.買い物));
            map.put(NinteiChosaTokkiJikou.簡単な調理.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.簡単な調理));
            selectedKey = NinteiChosaTokkiJikou.薬の内服.get認定調査票_特記情報_認定調査特記事項番号();
        } else if (KEY特別な医療群.equals(div.getRadTokkiJikoGroup().getSelectedKey())) {
            map.put(NinteiChosaTokkiJikou.点滴の管理.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.点滴の管理));
            map.put(NinteiChosaTokkiJikou.中心静脈栄養.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.中心静脈栄養));
            map.put(NinteiChosaTokkiJikou.透析.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.透析));
            map.put(NinteiChosaTokkiJikou.ストーマの処置.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.ストーマの処置));
            map.put(NinteiChosaTokkiJikou.酸素療法.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.酸素療法));
            map.put(NinteiChosaTokkiJikou.レスピレーター.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.レスピレーター));
            map.put(NinteiChosaTokkiJikou.気管切開.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.気管切開));
            map.put(NinteiChosaTokkiJikou.疼痛の看護.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.疼痛の看護));
            map.put(NinteiChosaTokkiJikou.経管栄養.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.経管栄養));
            map.put(NinteiChosaTokkiJikou.モニター測定.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.モニター測定));
            map.put(NinteiChosaTokkiJikou.じょくそうの処置.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.じょくそうの処置));
            map.put(NinteiChosaTokkiJikou.カテーテル.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.カテーテル));
            selectedKey = NinteiChosaTokkiJikou.点滴の管理.get認定調査票_特記情報_認定調査特記事項番号();
        } else {
            map.put(NinteiChosaTokkiJikou.障害高齢者自立度.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.障害高齢者自立度));
            map.put(NinteiChosaTokkiJikou.認知症高齢者自立度.get認定調査票_特記情報_認定調査特記事項番号(), getDDL表示項目名(NinteiChosaTokkiJikou.認知症高齢者自立度));
            selectedKey = NinteiChosaTokkiJikou.障害高齢者自立度.get認定調査票_特記情報_認定調査特記事項番号();
        }
        div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().setDataSource(KeyValueDataSourceConverter.getDataSource(map));
        div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().setSelectedKey(selectedKey);
    }

    private RString getDDL表示項目名(NinteiChosaTokkiJikou 認定調査特記事項) {
        return 認定調査特記事項.get画面表示用特記事項番号().concat(new RString(" ")).concat(認定調査特記事項.get特記事項名());
    }

    /**
     * 「入力する」ボタン押下処理です。
     */
    public void onInput() {
        RString select特記事項番号 = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
        RStringBuilder 特記事項 = new RStringBuilder();
        RowState state = RowState.Unchanged;
        for (dgTokkiJikoJoho_Row row : div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource()) {
            if (row.getDbTokkiJikoNo().equals(select特記事項番号)) {
                state = row.getRowState();
                特記事項.append(row.getTxtTokkiJiko().getValue());
            }
        }
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setValue(特記事項.toRString());
        div.setHdnTokkiJiko(特記事項.toRString());
        if (!RString.isNullOrEmpty(特記事項.toRString())) {
            div.getTokkiJikoNyuryoku().getBtnDelete().setDisplayNone(false);
        }
        if (RowState.Deleted.equals(state)) {
            div.getTokkiJikoNyuryoku().getBtnDelete().setDisplayNone(true);
            div.getTokkiJikoNyuryoku().getBtnDeleteCancel().setDisplayNone(false);
        } else {
            div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setDisabled(false);
        }
    }

    /**
     * 連番数のチェック処理です。
     *
     * @return message
     */
    public Message checkMaxRemban() {
        Message message = null;
        Decimal 最大連番 = get最大連番();
        if (最大連番数.compareTo(最大連番) < 1) {
            message = new ErrorMessage(DbeErrorMessages.連番最大値を超過.getMessage().getCode(),
                    DbeErrorMessages.連番最大値を超過.getMessage().evaluate());
        }
        return message;
    }

    /**
     * 「dg修正」ボタン押下処理です。
     */
    public void onModify() {
        RString 特記事項 = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getActiveRow().getTxtTokkiJiko().getValue();
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setValue(特記事項);
        div.setHdnTokkiJiko(特記事項);
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setDisabled(false);
    }

    /**
     * 「確定する」ボタン押下時の処理です。
     */
    public void onSave() {
        RStringBuilder 特記事項Builder = new RStringBuilder(div.getTokkiJikoNyuryoku().getTxtTokkiJiko().getValue());
        if (div.getHdnTokkiJiko().equals(特記事項Builder.toRString())) {
            List<dgTokkiJikoJoho_Row> dataSource = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource();
            RString tokkiJikoNo = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
            for (dgTokkiJikoJoho_Row row : dataSource) {
                if (tokkiJikoNo.equals(row.getDbTokkiJikoNo())) {
                    if (RowState.Deleted.equals(row.getRowState())) {
                        row.setRowState(RowState.valueOf(row.getBeforeRowState().toString()));
                    }
                }
            }
            return;
        }
        List<RString> 特記事項List = new ArrayList<>();
        while (特記事項Builder.length() > 短冊特記事項最大入力文字数) {
            特記事項Builder = separate特記事項(特記事項List, 特記事項Builder);
        }
        特記事項List.add(特記事項Builder.toRString());
        List<dgTokkiJikoJoho_Row> originalDataSource = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource();
        List<dgTokkiJikoJoho_Row> newDataSource = new ArrayList<>();
        List<dgTokkiJikoJoho_Row> targetDataSource = new ArrayList<>();
        List<dgTokkiJikoJoho_Row> tokkiDataSource = createDataSource(特記事項List);
        RString 特記事項番号 = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
        UpdateOrDeleteLoop:
        for (dgTokkiJikoJoho_Row originalRow : originalDataSource) {
            if (特記事項番号.equals(originalRow.getDbTokkiJikoNo())) {
                for (dgTokkiJikoJoho_Row tokkiRow : tokkiDataSource) {
                    if (originalRow.getTxtRemban().getValue().compareTo(tokkiRow.getTxtRemban().getValue()) <= 0) {
                        originalRow.getTxtTokkiJiko().setValue(tokkiRow.getTxtTokkiJiko().getValue());
                        if (!RowState.Added.equals(originalRow.getRowState())) {
                            originalRow.setBeforeRowState(new RString(originalRow.getRowState().name()));
                            originalRow.setRowState(RowState.Modified);
                        } else {
                            originalRow.setBeforeRowState(new RString(RowState.Added.name()));
                        }
                        newDataSource.add(originalRow);
                        targetDataSource.add(originalRow);
                        continue UpdateOrDeleteLoop;
                    }
                }
                originalRow.setBeforeRowState(new RString(originalRow.getRowState().name()));
                originalRow.setRowState(RowState.Deleted);
            } else {
                newDataSource.add(originalRow);
            }
        }
        AddLoop:
        for (dgTokkiJikoJoho_Row tokkiRow : tokkiDataSource) {
            for (dgTokkiJikoJoho_Row targetRow : targetDataSource) {
                if (tokkiRow.getTxtRemban().getValue().compareTo(targetRow.getTxtRemban().getValue()) <= 0) {
                    continue AddLoop;
                }
            }
            newDataSource.add(tokkiRow);
        }
        div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().setDataSource(newDataSource);
    }

    private List<dgTokkiJikoJoho_Row> createDataSource(List<RString> 特記事項List) {
        List<dgTokkiJikoJoho_Row> dataSource = new ArrayList<>();
        RString 特記事項番号 = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
        int 連番 = 1;
        for (RString 特記事項 : 特記事項List) {
            dgTokkiJikoJoho_Row row = new dgTokkiJikoJoho_Row();
            row.setDbTokkiJikoNo(特記事項番号);
            row.getTxtNinteiChosaItemNo().setValue(NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(特記事項番号).get画面表示用特記事項番号());
            row.getTxtRemban().setValue(Decimal.valueOf(連番));
            row.getTxtNinteiChosaItemName().setValue(NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(特記事項番号).get特記事項名());
            row.getTxtTokkiJiko().setValue(特記事項);
            row.setBeforeRowState(new RString(RowState.Unchanged.name()));
            row.setRowState(RowState.Added);
            dataSource.add(row);
            連番++;
        }
        return dataSource;

    }

    /**
     * 「確定する」ボタン押下時の処理です。
     */
    public void onSaveAddRemban() {
        List<dgTokkiJikoJoho_Row> dataSource = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource();
        dgTokkiJikoJoho_Row newRow = createDataSourceRow();
        dataSource.add(newRow);
        div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().setDataSource(dataSource);
    }

    private dgTokkiJikoJoho_Row createDataSourceRow() {
        RString 特記事項番号 = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
        Decimal 最大連番 = get最大連番();
        dgTokkiJikoJoho_Row row = new dgTokkiJikoJoho_Row();
        row.setDbTokkiJikoNo(特記事項番号);
        row.getTxtNinteiChosaItemNo().setValue(NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(特記事項番号).get画面表示用特記事項番号());
        row.getTxtRemban().setValue(Decimal.valueOf(最大連番.add(Decimal.ONE).intValue()));
        row.getTxtNinteiChosaItemName().setValue(NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(特記事項番号).get特記事項名());
        row.getTxtTokkiJiko().setValue(div.getTokkiJikoNyuryoku().getTxtTokkiJiko().getValue());
        row.setBeforeRowState(new RString(RowState.Unchanged.name()));
        row.setRowState(RowState.Added);
        return row;
    }

    private Decimal get最大連番() {
        RString 特記事項番号 = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
        Decimal 最大連番 = Decimal.ZERO;
        for (dgTokkiJikoJoho_Row row : div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource()) {
            if (row.getDbTokkiJikoNo().equals(特記事項番号)) {
                if (最大連番.compareTo(row.getTxtRemban().getValue()) < 0) {
                    最大連番 = row.getTxtRemban().getValue();
                }
            }
        }
        return 最大連番;
    }

    /**
     * 「確定する」ボタン押下時の処理です。
     */
    public void onSaveModify() {
        int selectedRowId = Integer.parseInt(div.getHdnSelectedRowId().toString());
        dgTokkiJikoJoho_Row activeRow = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource().get(selectedRowId);
        RString 特記事項 = div.getTokkiJikoNyuryoku().getTxtTokkiJiko().getValue();
        if (div.getHdnTokkiJiko().equals(特記事項)) {
            return;
        }
        if (!RowState.Added.equals(activeRow.getRowState())) {
            activeRow.setBeforeRowState(new RString(activeRow.getRowState().name()));
            activeRow.setRowState(RowState.Modified);
        } else {
            activeRow.setBeforeRowState(new RString(RowState.Added.name()));
        }
        activeRow.getTxtTokkiJiko().setValue(特記事項);
    }

    /**
     * データグリッドを特記事項番号でソートします。
     */
    public void sortDataGrid() {
        div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().setSortOrder(sortOrder);
    }

    /**
     * 削除時の「確定する」ボタン押下時の処理です。
     */
    public void onSaveDelete() {
        List<dgTokkiJikoJoho_Row> originalDataSource = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource();
        List<dgTokkiJikoJoho_Row> newDataSource = new ArrayList<>();
        RString tokkiJikoNo = div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().getSelectedKey();
        for (dgTokkiJikoJoho_Row row : originalDataSource) {
            if (tokkiJikoNo.equals(row.getDbTokkiJikoNo())) {
                if (!RowState.Added.equals(row.getRowState())) {
                    row.setBeforeRowState(new RString(row.getRowState().name()));
                    row.setRowState(RowState.Deleted);
                    newDataSource.add(row);
                }
            } else {
                newDataSource.add(row);
            }
        }
        div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().setDataSource(newDataSource);
    }

    /**
     * 「dg削除」ボタン押下時の処理です。
     *
     */
    public void onSaveDataGridDelete() {
        dgTokkiJikoJoho_Row activeRow = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getActiveRow();
        if (RowState.Added.equals(activeRow.getRowState())) {
            List<dgTokkiJikoJoho_Row> dataSource = div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource();
            dataSource.remove(activeRow);
        } else if (RowState.Deleted.equals(activeRow.getRowState())) {
            activeRow.setRowState(RowState.valueOf(activeRow.getBeforeRowState().toString()));
            activeRow.setModifyButtonState(DataGridButtonState.Enabled);
        } else {
            activeRow.setBeforeRowState(new RString(activeRow.getRowState().name()));
            activeRow.setRowState(RowState.Deleted);
            activeRow.setModifyButtonState(DataGridButtonState.Disabled);
        }
    }

    private RStringBuilder separate特記事項(List<RString> 特記事項List, RStringBuilder 特記事項Builder) {
        RString 特記事項_最大文字数 = 特記事項Builder.substring(0, 短冊特記事項最大入力文字数);
        int 最終読点文字位置 = 特記事項_最大文字数.lastIndexOf(読点);
        RString 特記事項;
        if (最終読点文字位置 != -1) {
            特記事項 = 特記事項Builder.substring(0, 最終読点文字位置 + 1);
        } else {
            特記事項 = 特記事項_最大文字数;
        }
        特記事項List.add(特記事項);
        RStringBuilder afterCut特記事項Builder = 特記事項Builder.delete(0, 特記事項.length());
        return afterCut特記事項Builder;
    }

    /**
     * データグリッドの情報を保持します。
     */
    public void saveDgTokkiJikoInfo() {
        HashMap<RString, TokkiJikoInputModel> tokkiJikoMap = new LinkedHashMap<>();
        int tokkiJikoMapKey = 1;
        for (dgTokkiJikoJoho_Row row : div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().getDataSource()) {
            TokkiJikoInputModel model = new TokkiJikoInputModel();
            setTokkiJikoInputModel(row, model);
            tokkiJikoMap.put(new RString(tokkiJikoMapKey), model);
            tokkiJikoMapKey++;
        }
        ViewStateHolder.put(ViewStateKeys.特記事項一覧, tokkiJikoMap);
    }

    /**
     * 画面のコントロールを初期表示状態に設定します。
     */
    public void resetControl() {
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().clearValue();
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setDisabled(true);
        div.setHdnTokkiJiko(RString.EMPTY);
        div.setHdnSelectedRowId(RString.EMPTY);
        div.getTokkiJikoNyuryoku().getBtnSave().setDisabled(true);
        div.getTokkiJikoNyuryoku().getBtnCancel().setDisabled(true);
        div.getTokkiJikoNyuryoku().getBtnDelete().setDisplayNone(true);
        div.getTokkiJikoNyuryoku().getBtnDeleteCancel().setDisplayNone(true);
//        div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().setDisabled(false);
//        div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().setDisabled(false);
    }

    /**
     * 削除ボタン関連の処理による各ボタンのプロパティを設定します。
     *
     * @param parameter
     */
    public void setBtnControlPropertyByDelete(boolean parameter) {
        div.getTokkiJikoNyuryoku().getTxtTokkiJiko().setDisabled(parameter);
        div.getTokkiJikoNyuryoku().getBtnDelete().setDisplayNone(parameter);
        div.getTokkiJikoNyuryoku().getBtnDeleteCancel().setDisplayNone(!parameter);
    }

    /**
     * 「入力する」ボタン関連の処理による各ボタンのプロパティを設定します。
     *
     * @param parameter 入力タイミングかどうか
     */
    public void setBtnControlPropertyByInput(boolean parameter) {
        div.getTokkiJikoNyuryoku().getBtnSave().setDisabled(!parameter);
        div.getTokkiJikoNyuryoku().getBtnCancel().setDisabled(!parameter);
        div.getTokkiJikoNyuryoku().getBtnInput().setDisabled(parameter);
        div.getTokkiJikoNyuryoku().getBtnAddRemban().setDisabled(parameter);
        div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().setDisabled(parameter);
        div.getTokkiJikoNyuryoku().getDdlTokkiJikoNo().setDisabled(parameter);
        div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().setDisabled(parameter);
        div.getBtnUpdateReturn().setDisabled(parameter);
        div.getBtnCancelReturn().setDisabled(parameter);
//        div.getBtnReturn().setDisabled(parameter);
//        div.getBtnUpdateCancel().setDisabled(parameter);
    }

//    /**
//     * 「変更内容を取り消す」ボタン押下時の処理です。
//     */
//    public void onClear() {
//        resetControl();
//        div.getTokkiJikoNyuryoku().getRadTokkiJikoGroup().setSelectedKey(KEY第一群);
//        setDdlTokkiJikoNo();
//        set特記事項情報();
//        set初期状態の保存();
//    }
    private void setTokkiJikoInputModel(dgTokkiJikoJoho_Row row, TokkiJikoInputModel model) {
        model.set特記事項番号(row.getDbTokkiJikoNo());
        model.set特記連番(row.getTxtRemban().getValue().intValue());
        model.set特記事項(row.getTxtTokkiJiko().getValue());
        model.setBeforeRowState(RowState.valueOf(row.getBeforeRowState().toString()));
        model.setRowState(row.getRowState());
    }

    private void set特記事項情報() {
        HashMap<RString, TokkiJikoInputModel> tokkiJikoMap = ViewStateHolder.get(ViewStateKeys.特記事項一覧, LinkedHashMap.class);
        Set<Map.Entry<RString, TokkiJikoInputModel>> set = tokkiJikoMap.entrySet();
        Iterator<Map.Entry<RString, TokkiJikoInputModel>> it = set.iterator();
        List<dgTokkiJikoJoho_Row> rowList = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<RString, TokkiJikoInputModel> entry = it.next();
            TokkiJikoInputModel value = entry.getValue();
            dgTokkiJikoJoho_Row row = new dgTokkiJikoJoho_Row();
            setRowData(row, value);
            rowList.add(row);
        }
        div.getTokkiJikoNyuryoku().getDgTokkiJikoJoho().setDataSource(rowList);
    }

    private void setRowData(dgTokkiJikoJoho_Row row, TokkiJikoInputModel model) {
        row.setDbTokkiJikoNo(model.get特記事項番号());
        row.getTxtNinteiChosaItemNo().setValue(NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(model.get特記事項番号()).get画面表示用特記事項番号());
        row.getTxtRemban().setValue(Decimal.valueOf(model.get特記連番()));
        row.getTxtNinteiChosaItemName().setValue(NinteiChosaTokkiJikou.getEnumByDbt5205認定調査特記事項番号(model.get特記事項番号()).get特記事項名());
        row.getTxtTokkiJiko().setValue(model.get特記事項());
        row.setBeforeRowState(new RString(model.getBeforeRowState().name()));
        row.setRowState(model.getRowState());
    }
}
