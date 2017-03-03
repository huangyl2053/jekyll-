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
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.HokenshaDDLPattem;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定審査会委員ガイドDivの操作を行うクラスです。
 */
public class NinteiShinsakaiIinGuideHandler {

    private final NinteiShinsakaiIinGuideDiv div;
    private static final RString KEY0 = new RString("key0");

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
        画面表示制御();
        RString 基準日 = div.getHiddenKijunYMD();
        if (基準日 != null && !基準日.isEmpty()) {
            div.getTxtKijunbi().setValue(new RDate(基準日.toString()));
        }
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
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiName().clearValue();
        div.getTxtIryoKikanCode().clearValue();
        div.getTxtIryoKikanName().clearValue();
        div.getTxtSonotaJigyoshaCode().clearValue();
        div.getTxtSonotaJigyoshaName().clearValue();
        List<RString> list = new ArrayList();
        list.add(KEY0);
        div.getKensakuJoken().getChkHaishi().setSelectedItemsByKey(list);
        div.getKensakuJoken().getRadKikan().setSelectedKey(KEY0);
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
        for (Sikaku sikaku : Sikaku.values()) {
            審査会委員資格リスト.add(new KeyValueDataSource(sikaku.getコード(), sikaku.get名称()));
        }
        審査会委員資格リスト.remove(new KeyValueDataSource(Sikaku.精神科医.getコード(), Sikaku.精神科医.get名称()));
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
     * 保険者選択の処理です。
     *
     */
    public void set保険者選択() {
        List<dgShinsakaiIinIchiran_Row> 検索一覧データ = new ArrayList<>();
        div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().setDataSource(検索一覧データ);
        div.getShinsakaiIinIchiran().setIsOpen(false);
        div.getBtnSaikensaku().setVisible(false);
    }

    private void 画面表示制御() {
        if (new RString("合議体情報作成").equals(div.getHiddenMode())) {
            div.getPnlShosaiJoken().setDisplayNone(true);
        } else {
            div.getKensakuJoken().getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定, HokenshaDDLPattem.全市町村以外);
            ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
            div.getKensakuJoken().getCcdHokensha().setSelectedShichosonIfExist(市町村セキュリティ情報.get市町村情報().get市町村コード());
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
            row.setSeibetsu(result.get性別() == null ? RString.EMPTY : Seibetsu.toValue(result.get性別()).get名称());
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
