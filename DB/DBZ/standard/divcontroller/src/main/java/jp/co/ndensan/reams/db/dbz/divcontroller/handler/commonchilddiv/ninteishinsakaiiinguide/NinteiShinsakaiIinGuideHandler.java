/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinsakaiiinguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideResult;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定審査会委員ガイドDivの操作を行うクラスです。
 */
public class NinteiShinsakaiIinGuideHandler {

    private final NinteiShinsakaiIinGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定審査会委員ガイドDiv
     */
    public NinteiShinsakaiIinGuideHandler(NinteiShinsakaiIinGuideDiv div) {
        this.div = div;
    }

    /**
     * 初期化
     *
     *
     */
    public void onLoad() {
        set全部クリア();
        set性別();
        set審査会委員資格();
        div.getKensakuJoken().getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        画面表示制御();
    }

    /**
     * 全項目クリア処理です。
     *
     */
    private void set全部クリア() {
        div.getKensakuJoken().getTxtShinsakaiIinCodeFrom().clearValue();
        div.getKensakuJoken().getTxtShinsakaiIinCodeTo().clearValue();
        div.getKensakuJoken().getTxtShinsakaiIinName().clearValue();
        div.getKensakuJoken().getDdlSeibetsu().setSelectedKey(RString.EMPTY);
        div.getKensakuJoken().getDdlShinsainShikakuCode().setSelectedKey(RString.EMPTY);
        div.getKensakuJoken().getTxtMaxKensu().clearValue();
        div.getKensakuJoken().getTxtMaxKensu().setValue(get最大取得件数());
        div.getBtnSaikensaku().setVisible(false);
        div.getDdlIryoKikan().getDataSource().clear();
        div.getDdlKaigoJigyosha().getDataSource().clear();
        div.getDdlSonotaJigyosha().getDataSource().clear();
        List<RString> list = new ArrayList();
        list.add(new RString("key0"));
        div.getKensakuJoken().getShosaiJoken().getChkHaishi().setSelectedItemsByKey(list);
        div.getKensakuJoken().getShosaiJoken().getChkKiken().setSelectedItemsByKey(list);
    }

    /**
     * 性別ドロップダウンリストの設定です。
     *
     */
    private void set性別() {
        List<KeyValueDataSource> 性別リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(Seibetsu.男.getコード());
        dateSource.setValue(Seibetsu.男.get名称());
        性別リスト.add(dateSource);
        KeyValueDataSource dateSource2 = new KeyValueDataSource();
        dateSource2.setKey(Seibetsu.女.getコード());
        dateSource2.setValue(Seibetsu.女.get名称());
        性別リスト.add(dateSource2);
        div.getDdlSeibetsu().setDataSource(性別リスト);
    }

    /**
     * 審査会委員資格ドロップダウンリストの設定です。
     *
     */
    private void set審査会委員資格() {
        List<KeyValueDataSource> 審査会委員資格リスト = new ArrayList<>();
        KeyValueDataSource dateSource = new KeyValueDataSource();
        dateSource.setKey(Sikaku.医師.getコード());
        dateSource.setValue(Sikaku.医師.get名称());
        審査会委員資格リスト.add(dateSource);
        KeyValueDataSource dateSource1 = new KeyValueDataSource();
        dateSource1.setKey(Sikaku.歯科医師.getコード());
        dateSource1.setValue(Sikaku.歯科医師.get名称());
        審査会委員資格リスト.add(dateSource1);
        KeyValueDataSource dateSource2 = new KeyValueDataSource();
        dateSource2.setKey(Sikaku.薬剤師.getコード());
        dateSource2.setValue(Sikaku.薬剤師.get名称());
        審査会委員資格リスト.add(dateSource2);
        KeyValueDataSource dateSource3 = new KeyValueDataSource();
        dateSource3.setKey(Sikaku.保健師.getコード());
        dateSource3.setValue(Sikaku.保健師.get名称());
        審査会委員資格リスト.add(dateSource3);
        KeyValueDataSource dateSource4 = new KeyValueDataSource();
        dateSource4.setKey(Sikaku.助産師.getコード());
        dateSource4.setValue(Sikaku.助産師.get名称());
        審査会委員資格リスト.add(dateSource4);
        KeyValueDataSource dateSource5 = new KeyValueDataSource();
        dateSource5.setKey(Sikaku._准_看護師.getコード());
        dateSource5.setValue(Sikaku._准_看護師.get名称());
        審査会委員資格リスト.add(dateSource5);
        KeyValueDataSource dateSource6 = new KeyValueDataSource();
        dateSource6.setKey(Sikaku.理学療法士.getコード());
        dateSource6.setValue(Sikaku.理学療法士.get名称());
        審査会委員資格リスト.add(dateSource6);
        KeyValueDataSource dateSource7 = new KeyValueDataSource();
        dateSource7.setKey(Sikaku.作業療法士.getコード());
        dateSource7.setValue(Sikaku.作業療法士.get名称());
        審査会委員資格リスト.add(dateSource7);
        KeyValueDataSource dateSource8 = new KeyValueDataSource();
        dateSource8.setKey(Sikaku.社会福祉士.getコード());
        dateSource8.setValue(Sikaku.社会福祉士.get名称());
        審査会委員資格リスト.add(dateSource8);
        KeyValueDataSource dateSource9 = new KeyValueDataSource();
        dateSource9.setKey(Sikaku.介護福祉士.getコード());
        dateSource9.setValue(Sikaku.介護福祉士.get名称());
        審査会委員資格リスト.add(dateSource9);
        KeyValueDataSource dateSource10 = new KeyValueDataSource();
        dateSource10.setKey(Sikaku.ソーシャルワーカー.getコード());
        dateSource10.setValue(Sikaku.ソーシャルワーカー.get名称());
        審査会委員資格リスト.add(dateSource10);
        KeyValueDataSource dateSource11 = new KeyValueDataSource();
        dateSource11.setKey(Sikaku.福祉事務所現業員等.getコード());
        dateSource11.setValue(Sikaku.福祉事務所現業員等.get名称());
        審査会委員資格リスト.add(dateSource11);
        KeyValueDataSource dateSource12 = new KeyValueDataSource();
        dateSource12.setKey(Sikaku.ホームヘルパー.getコード());
        dateSource12.setValue(Sikaku.ホームヘルパー.get名称());
        審査会委員資格リスト.add(dateSource12);
        KeyValueDataSource dateSource13 = new KeyValueDataSource();
        dateSource13.setKey(Sikaku.介護職員.getコード());
        dateSource13.setValue(Sikaku.介護職員.get名称());
        審査会委員資格リスト.add(dateSource13);
        KeyValueDataSource dateSource14 = new KeyValueDataSource();
        dateSource14.setKey(Sikaku.その他福祉関係者.getコード());
        dateSource14.setValue(Sikaku.その他福祉関係者.get名称());
        審査会委員資格リスト.add(dateSource14);
        KeyValueDataSource dateSource15 = new KeyValueDataSource();
        dateSource15.setKey(Sikaku.行政関係者.getコード());
        dateSource15.setValue(Sikaku.行政関係者.get名称());
        審査会委員資格リスト.add(dateSource15);
        KeyValueDataSource dateSource16 = new KeyValueDataSource();
        dateSource16.setKey(Sikaku.その他.getコード());
        dateSource16.setValue(Sikaku.その他.get名称());
        審査会委員資格リスト.add(dateSource16);
        div.getDdlShinsainShikakuCode().setDataSource(審査会委員資格リスト);
    }

    private Decimal get最大取得件数() {
        Decimal 最大取得件数 = new Decimal(0);
        if (DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告) != null) {
            最大取得件数 = new Decimal(DbBusinessConfig.get(
                    ConfigNameDBU.検索制御_最大取得件数,
                    RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告).toString());
        }
        return 最大取得件数;
    }

    /**
     * 医療機関情報ドロップダウンリストの設定です。
     *
     * @param 市町村コード 市町村コード
     */
    private void set医療機関() {
        LasdecCode 市町村コード = div.getKensakuJoken().getCcdHokensha().getSelectedItem().get市町村コード();
        List<KeyValueDataSource> 医療機関リスト = createInstanceOfManager().get主治医医療機関情報(市町村コード).records();
        div.getKensakuJoken().getDdlIryoKikan().setDataSource(医療機関リスト);
        div.getKensakuJoken().getShosaiJoken().getDdlIryoKikan().setSelectedKey(RString.EMPTY);
    }

    /**
     * 介護事業者ドロップダウンリストの設定です。
     *
     * @param 市町村コード 市町村コード
     */
    private void set介護事業者() {
        LasdecCode 市町村コード = div.getKensakuJoken().getCcdHokensha().getSelectedItem().get市町村コード();
        List<KeyValueDataSource> 介護事業者リスト = createInstanceOfManager().get認定調査委託先情報(市町村コード).records();
        div.getDdlKaigoJigyosha().setDataSource(介護事業者リスト);
        div.getKensakuJoken().getShosaiJoken().getDdlKaigoJigyosha().setSelectedKey(RString.EMPTY);
    }

    /**
     * 介護事業者ドロップダウンリストの設定です。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    private void setその他事業者() {
        ShoKisaiHokenshaNo 証記載保険者番号 = div.getKensakuJoken().getCcdHokensha().getSelectedItem().get証記載保険者番号();
        List<KeyValueDataSource> その他事業者リスト = createInstanceOfManager().getその他機関情報(証記載保険者番号).records();
        div.getDdlSonotaJigyosha().setDataSource(その他事業者リスト);
        div.getKensakuJoken().getShosaiJoken().getDdlSonotaJigyosha().setSelectedKey(RString.EMPTY);
    }
    
    /**
     * 保険者選択の処理です。
     *
     */
    public void set保険者選択() {
        画面表示制御();
        List<dgShinsakaiIinIchiran_Row> 検索一覧データ = new ArrayList<>();
        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(検索一覧データ);
        div.getShinsakaiIinIchiran().setIsOpen(false);
        div.getBtnSaikensaku().setVisible(false);
    }
    
    private void 画面表示制御() {
        if (RString.isNullOrEmpty(div.getKensakuJoken().getCcdHokensha().getSelectedItem().get市町村名称())) {
            div.getKensakuJoken().getShosaiJoken().getDdlIryoKikan().setDisplayNone(Boolean.TRUE);
            div.getKensakuJoken().getShosaiJoken().getDdlKaigoJigyosha().setDisplayNone(Boolean.TRUE);
            div.getKensakuJoken().getShosaiJoken().getDdlSonotaJigyosha().setDisplayNone(Boolean.TRUE);
            div.getKensakuJoken().getShosaiJoken().getLblShozoku().setDisplayNone(Boolean.TRUE);

        } else {
            div.getKensakuJoken().getShosaiJoken().getDdlIryoKikan().setDisplayNone(Boolean.FALSE);
            div.getKensakuJoken().getShosaiJoken().getDdlKaigoJigyosha().setDisplayNone(Boolean.FALSE);
            div.getKensakuJoken().getShosaiJoken().getDdlSonotaJigyosha().setDisplayNone(Boolean.FALSE);
            div.getKensakuJoken().getShosaiJoken().getLblShozoku().setDisplayNone(Boolean.FALSE);
            set医療機関();
            set介護事業者();
            setその他事業者();
        }

    }
    
    
    /**
     * 審査会委員一覧情報の設定です。
     *
     * @param 審査会委員一覧リスト 審査会委員一覧リスト
     */
    public void 審査会委員一覧情報の設定(List<NinteiShinsakaiIinGuideResult> 審査会委員一覧リスト) {

        List<dgShinsakaiIinIchiran_Row> 検索一覧データ = new ArrayList<>();
        for (NinteiShinsakaiIinGuideResult result : 審査会委員一覧リスト) {
            dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row();
            row.setCode(result.getコード());
            row.setShinsakaiIinName(result.get審査会委員名称().value());
            row.setShinsakaiIinKanaName(result.get審査会委員名カナ().value());
            row.setSeibetsu(Seibetsu.toValue(result.get性別()).get名称());
            row.setShinsakaiIinShikaku(Sikaku.toValue(result.get審査会委員資格().value()).get名称());
            検索一覧データ.add(row);
        }
        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(検索一覧データ);
    }

    /**
     * 大小関係チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs onClick_btnKensakku() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                NinteiShinsakaiIinGuideHandlerMessages.大小関係が不正));
        return validationMessages;
    }

    /**
     * 審査会委員一覧データなしチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs data_Nasi() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                NinteiShinsakaiIinGuideHandlerMessages.該当データなし));
        return validationMessages;
    }

    private NinteiShinsakaiIinGuideManager createInstanceOfManager() {
        return NinteiShinsakaiIinGuideManager.createInstance();
    }

    private static enum NinteiShinsakaiIinGuideHandlerMessages implements IValidationMessage {

        大小関係が不正(UrErrorMessages.大小関係が不正, "審査会委員コード"),
        該当データなし(UrErrorMessages.該当データなし);

        private final Message message;

        private NinteiShinsakaiIinGuideHandlerMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
