/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.business.core.kaigohohenshisetsu.KaigoHohenShisetsuBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.kaigohohenshisetsunyutaishoshakanri.KaigoHohenShisetsuNyutaishoshaKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 施設入退所履歴のHandlerクラスです。
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanriHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv div;
    private final RString 台帳種別表示機能 = new RString("台帳種別表示機能");
    private final RString 適用除外者対象機能 = new RString("適用除外者対象機能");
    private final RString 全施設対象機能 = new RString("全施設対象機能");
    private final RString 被保険者対象機能 = new RString("被保険者対象機能");
    private final RString 他市町村住所地特例者対象機能 = new RString("他市町村住所地特例者対象機能");
    private final RString 追加 = new RString("追加");
    private final RString 更新 = new RString("修正");
    private final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div ShisetsuNyutaishoRirekiKanriDiv
     */
    public ShisetsuNyutaishoRirekiKanriHandler(ShisetsuNyutaishoRirekiKanriDiv div) {
        this.div = div;
    }

    /**
     * 施設入退所履歴に初期化を設定します。
     *
     * @param 識別コード 識別コード
     */
    public void initialize(ShikibetsuCode 識別コード) {
        div.setShikibetsuCode(識別コード.getColumnValue());
        List<KaigoHohenShisetsuBusiness> 施設入退所情報
                = KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().select介護保険施設入退所一覧By識別コード(識別コード).records();
        if (施設入退所情報 != null && !施設入退所情報.isEmpty()) {
            List<ShisetsuNyutaisho> 更新施設入退所情報
                    = KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().get介護保険施設入退所一覧By識別コード(識別コード).records();
            ViewStateHolder.put(ViewStateKeys.施設入退所情報, Models.create(更新施設入退所情報));
            一覧の設定(施設入退所情報);
        } else {
            ViewStateHolder.put(ViewStateKeys.施設入退所情報, Models.create(new ArrayList()));
        }
        switch (div.getMode_DisplayMode()) {
            case 照会:
                break;
            case 照会選択有:
                break;
            case 資格異動:
                資格異動モード();
                break;
            default:
                break;
        }
    }

    /**
     * 施設入退所履歴に初期化を設定します。
     *
     * @param 識別コード 識別コード
     * @param 台帳種別 台帳種別
     */
    public void initialize(ShikibetsuCode 識別コード, RString 台帳種別) {
        div.setShikibetsuCode(識別コード.getColumnValue());
        List<KaigoHohenShisetsuBusiness> 施設入退所情報
                = KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().select介護保険施設入退所一覧By識別コードと台帳種別(識別コード, 台帳種別).records();
        if (施設入退所情報 != null && !施設入退所情報.isEmpty()) {
            List<ShisetsuNyutaisho> 更新施設入退所情報
                    = KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().get介護保険施設入退所一覧By識別コードと台帳種別(識別コード, 台帳種別).records();
            ViewStateHolder.put(ViewStateKeys.施設入退所情報, Models.create(更新施設入退所情報));
            一覧の設定(施設入退所情報);
        } else {
            ViewStateHolder.put(ViewStateKeys.施設入退所情報, Models.create(new ArrayList()));
        }
        switch (div.getMode_DisplayMode()) {
            case 照会:
                div.getBtnAddShisetsuNyutaisho().setVisible(false);
                div.getShisetsuNyutaishoInput().setVisible(false);
                break;
            case 照会選択有:
                break;
            case 資格異動:
                資格異動モード();
                break;
            default:
                break;
        }
    }

    /**
     * 施設入退所履歴に初期化を設定します。外部からグリッドに設定するデータと、保存対象のデータを受け取ります。
     *
     * @param データソース グリッドに設定するデータソース
     * @param 施設入退所情報Model 施設入退所情報Model
     */
    public void initialize(List<dgShisetsuNyutaishoRireki_Row> データソース, Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model) {

        div.getDgShisetsuNyutaishoRireki().setDataSource(データソース);
        ViewStateHolder.put(ViewStateKeys.施設入退所情報, 施設入退所情報Model);

        switch (div.getMode_DisplayMode()) {
            case 照会:
                break;
            case 照会選択有:
                break;
            case 資格異動:
                資格異動モード();
                break;
            default:
                break;
        }
    }

    /**
     * 「追加する」ボタンを押下する場合、施設入退所情報パネルを活性します。
     *
     * @return ShisetsuNyutaishoRirekiKanriDiv
     */
    public ValidationMessageControlPairs onClick_btnAddShisetsuNyutaisho() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgShisetsuNyutaishoRireki_Row> rowList = div.getDgShisetsuNyutaishoRireki().getDataSource();

        for (dgShisetsuNyutaishoRireki_Row row : rowList) {
            if (row.getTaishoDate().getValue().isEmpty()) {
                validPairs.add(new ValidationMessageControlPair(ShisetsuRirekiErrorMessage.履歴退所日));
            }
        }
        if (!validPairs.existsError()) {
            div.setInputMode(追加);
            施設入退所情報活性();
        }
        return validPairs;

    }

    /**
     * 「選択」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param row 選択データ
     */
    public void onSelectBySelectButton_dgShisetsuNyutaishoRireki(dgShisetsuNyutaishoRireki_Row row) {
        div.getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
        div.getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
        if (ShisetsuNyutaishoRirekiKanriDiv.Riyou.台帳種別表示機能.equals(div.getMode_Riyou())) {
            div.getCcdShisetsuJoho().set台帳種別(row.getDaichoShubetsuKey());
        }
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())) {
            div.getCcdShisetsuJoho().set施設種類(row.getShisetsuShuruiKey());
        }
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())
                && !ShisetsuNyutaishoRirekiKanriDiv.Riyou.他市町村住所地特例者対象機能.equals(div.getMode_Riyou())
                && !RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
            div.getTxtHokensha().setValue(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            div.getTxtHokensyaMeisho().setValue(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(1));
        }
        div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(row.getShisetsuCode());
        div.getCcdShisetsuJoho().setShisetsuMeisho(row.getShisetsu());
        div.getBtnShisetsuNyutaishoKakutei().setVisible(true);
        div.getBtnShisetsuNyutaishoTorikeshi().setVisible(true);
    }

    /**
     * 「修正」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param row 選択データ
     */
    public void onSelectByModifyButton_dgShisetsuNyutaishoRireki(dgShisetsuNyutaishoRireki_Row row) {
        div.setInputMode(更新);
        div.getTxtNyushoDate().setDisabled(false);
        div.getTxtTaishoDate().setDisabled(false);
        div.getCcdShisetsuJoho().setDisabled(false);
        div.getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
        div.getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())) {
            div.getCcdShisetsuJoho().set施設種類(row.getShisetsuShuruiKey());
        }
        if (ShisetsuNyutaishoRirekiKanriDiv.Riyou.台帳種別表示機能.equals(div.getMode_Riyou())) {
            div.getCcdShisetsuJoho().set台帳種別(row.getDaichoShubetsuKey());
        }
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())
                && !ShisetsuNyutaishoRirekiKanriDiv.Riyou.他市町村住所地特例者対象機能.equals(div.getMode_Riyou())
                && !RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
            div.getTxtHokensha().setValue(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            div.getTxtHokensyaMeisho().setValue(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(1));
        }
        div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(row.getShisetsuCode());
        div.getCcdShisetsuJoho().setShisetsuMeisho(row.getShisetsu());
        div.getBtnShisetsuNyutaishoKakutei().setDisabled(false);
        div.getBtnShisetsuNyutaishoTorikeshi().setDisabled(false);
        div.getTenshutsusakiJohoPanel().setDisabled(false);
    }

    /**
     * 「削除」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param row 選択データ
     */
    public void onSelectByDeleteButton_dgShisetsuNyutaishoRireki(dgShisetsuNyutaishoRireki_Row row) {
        div.setInputMode(削除);
        div.getTxtNyushoDate().setDisabled(true);
        div.getTxtTaishoDate().setDisabled(true);
        div.getCcdShisetsuJoho().setDisabled(true);
        div.getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
        div.getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())) {
            div.getCcdShisetsuJoho().set施設種類(row.getShisetsuShuruiKey());
        }
        if (ShisetsuNyutaishoRirekiKanriDiv.Riyou.台帳種別表示機能.equals(div.getMode_Riyou())) {
            div.getCcdShisetsuJoho().set台帳種別(row.getDaichoShubetsuKey());
        }
        if (!ShisetsuNyutaishoRirekiKanriDiv.Riyou.適用除外者対象機能.equals(div.getMode_Riyou())
                && !ShisetsuNyutaishoRirekiKanriDiv.Riyou.他市町村住所地特例者対象機能.equals(div.getMode_Riyou())
                && !RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
            div.getTxtHokensha().setValue(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            div.getTxtHokensyaMeisho().setValue(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(1));
        }
        div.getCcdShisetsuJoho().setNyuryokuShisetsuKodo(row.getShisetsuCode());
        div.getCcdShisetsuJoho().setShisetsuMeisho(row.getShisetsu());
        div.getBtnShisetsuNyutaishoKakutei().setDisabled(false);
        div.getBtnShisetsuNyutaishoTorikeshi().setDisabled(false);
    }

    private static enum ShisetsuRirekiErrorMessage implements IValidationMessage {

        履歴退所日(UrErrorMessages.必須, "履歴の退所日");
        private final Message message;

        private ShisetsuRirekiErrorMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    /**
     * 「取消する」ボタンを押下する場合、明細エリアの全項目がクリアされる。
     *
     */
    public void onClick_btnShisetsuNyutaishoTorikeshi() {
        div.getTxtNyushoDate().setDisabled(true);
        div.getTxtTaishoDate().setDisabled(true);
        div.getCcdShisetsuJoho().setDisabled(true);
        div.getTxtNyushoDate().clearValue();
        div.getTxtTaishoDate().clearValue();
        div.getBtnShisetsuNyutaishoKakutei().setDisabled(true);
        div.getBtnShisetsuNyutaishoTorikeshi().setDisabled(true);
        div.getTenshutsusakiJohoPanel().setDisabled(true);
        div.getCcdShisetsuJoho().clear();
        div.getTxtHokensha().clearValue();
        div.getTxtHokensyaMeisho().clearValue();
    }

    /**
     * 「確定する」ボタンを押下する場合、明細エリアの入力内容を一覧グリッドに反映させる。
     *
     * @param row 選択データ
     */
    public void onClick_btnShisetsuNyutaishoKakutei(dgShisetsuNyutaishoRireki_Row row) {
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model
                = ViewStateHolder.get(ViewStateKeys.施設入退所情報, Models.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getShikibetsuCode());
        List<dgShisetsuNyutaishoRireki_Row> listRow = div.getDgShisetsuNyutaishoRireki().getDataSource();
        dgShisetsuNyutaishoRireki_Row newRow = new dgShisetsuNyutaishoRireki_Row();
        int 最大履歴番号 = 1;
        if (listRow != null && !listRow.isEmpty()) {
            Collections.sort(listRow, new ShisetsuNyutaishoRirekiKanriHandler.RirekiNoDateComparator());
            最大履歴番号 = Integer.parseInt(listRow.get(listRow.size() - 1).getRirekiNo().toString()) + 1;
        } else {
            listRow = new ArrayList();
        }
        if (追加.equals(div.getInputMode())) {
            newRow.setState(追加);
            newRow.getNyushoDate().setValue(div.getTxtNyushoDate().getValue());
            newRow.getTaishoDate().setValue(div.getTxtTaishoDate().getValue());
            newRow.setShisetsu(div.getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            施設種類と台帳種別の設定(newRow);
            newRow.setShisetsuCode(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            newRow.setShisetsuMeisho(div.getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            newRow.setRirekiNo(new RString(Integer.toString(最大履歴番号)));
            listRow.add(newRow);
            ShisetsuNyutaisho 介護保険施設入退所情報 = new ShisetsuNyutaisho(識別コード, 最大履歴番号);
            施設入退所情報Model.add(追加の処理(介護保険施設入退所情報, newRow));
        } else if (更新.equals(div.getInputMode())) {
            row.getNyushoDate().setValue(div.getTxtNyushoDate().getValue());
            row.getTaishoDate().setValue(div.getTxtTaishoDate().getValue());
            row.setShisetsu(div.getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            施設種類と台帳種別の設定(row);
            row.setShisetsuCode(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            row.setShisetsuMeisho(div.getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            if (削除.equals(row.getState()) || !追加.equals(row.getState())) {
                row.setState(更新);
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子 = new ShisetsuNyutaishoIdentifier(識別コード, 履歴番号);
                施設入退所情報Model.deleteOrRemove(介護保険施設入退所の識別子);
                施設入退所情報Model.add(修正の処理(介護保険施設入退所の識別子, 施設入退所情報Model, row));
            }
        } else if (削除.equals(div.getInputMode())) {
            if (!追加.equals(row.getState())) {
                row.setState(削除);
            } else {
                listRow.remove(row);
            }
        }
        ViewStateHolder.put(ViewStateKeys.施設入退所情報, Models.create(施設入退所情報Model));
        div.setInputMode(RString.EMPTY);
        Collections.sort(listRow, new ShisetsuNyutaishoRirekiKanriHandler.NyushoDateComparator());
        div.getDgShisetsuNyutaishoRireki().setDataSource(listRow);

        onClick_btnShisetsuNyutaishoTorikeshi();
    }

    /**
     * 施設入退所履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    public void saveShisetsuNyutaisho() {
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getShikibetsuCode());
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model
                = ViewStateHolder.get(ViewStateKeys.施設入退所情報, Models.class);
        List<dgShisetsuNyutaishoRireki_Row> listRow = div.getDgShisetsuNyutaishoRireki().getDataSource();
        for (dgShisetsuNyutaishoRireki_Row row : listRow) {
            if (RString.isNullOrEmpty(row.getState())) {
                continue;
            }
            ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子 = new ShisetsuNyutaishoIdentifier(識別コード, Integer.parseInt(row.getRirekiNo().toString()));
            if (追加.equals(row.getState())) {
                KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().
                        施設入退所履歴一覧情報の追加(施設入退所情報Model.get(介護保険施設入退所の識別子));
            }
            if (更新.equals(row.getState())) {
                KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().
                        介護認定審査会開催場所情報の更新(施設入退所情報Model.get(介護保険施設入退所の識別子));
            }
            if (削除.equals(row.getState())) {
                KaigoHohenShisetsuNyutaishoshaKanriManager.createInstance().
                        施設入退所履歴一覧情報の削除(施設入退所情報Model.get(介護保険施設入退所の識別子));
            }
        }
    }

    /**
     * 施設入退所履歴の一覧を取得します。
     *
     * @return List<dgShisetsuNyutaishoRireki_Row> 施設入退所履歴の一覧
     */
    public List<dgShisetsuNyutaishoRireki_Row> get施設入退所履歴一覧() {
        return div.getDgShisetsuNyutaishoRireki().getDataSource();
    }

    /**
     * 施設入退所履歴の一覧を取得します。
     *
     * @return List<dgShisetsuNyutaishoRireki_Row> 施設入退所履歴の一覧
     */
    public Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> getSaveData() {
        return ViewStateHolder.get(ViewStateKeys.施設入退所情報, Models.class);
    }

    private void 一覧の設定(List<KaigoHohenShisetsuBusiness> 施設入退所情報) {
        List<dgShisetsuNyutaishoRireki_Row> rowList = new ArrayList<>();
        for (KaigoHohenShisetsuBusiness 施設入退所 : 施設入退所情報) {
            dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row();
            row.getNyushoDate().setValue(施設入退所.get入所年月日());
            row.getTaishoDate().setValue(施設入退所.get退所年月日());
            row.setShisetsu(施設入退所.get事業者名称());
            row.setDaichoShubetsu(get台帳種別(施設入退所.get台帳種別()));
            row.setShisetsuShurui(get施設種類(施設入退所.get入所施設種類()));
            row.setShisetsuCode(get入所施設コード(施設入退所.get入所施設コード()));
            row.setShisetsuMeisho(施設入退所.get事業者名称());
            row.setDaichoShubetsuKey(施設入退所.get台帳種別());
            row.setShisetsuShuruiKey(施設入退所.get入所施設種類());
            row.setRirekiNo(new RString(施設入退所.get履歴番号().toString()));
            row.setTxtTenshutsusakiHokenshaBango(get保険者名(get保険者番号(施設入退所.get保険者番号())));
            施設種類(施設入退所.get台帳種別(), row);
            rowList.add(row);

        }
        Collections.sort(rowList, new ShisetsuNyutaishoRirekiKanriHandler.NyushoDateComparator());
        div.getDgShisetsuNyutaishoRireki().setDataSource(rowList);
    }

    private RString get入所施設コード(JigyoshaNo 入所施設コード) {
        if (入所施設コード != null && !入所施設コード.isEmpty()) {
            return 入所施設コード.value();
        }
        return RString.EMPTY;
    }

    private RString get保険者番号(HokenshaNo 保険者番号) {
        if (保険者番号 != null && !保険者番号.isEmpty()) {
            return 保険者番号.value();
        }
        return RString.EMPTY;
    }

    private List<KeyValueDataSource> get台帳種別DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList();
        for (DaichoType daicho : DaichoType.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(daicho.getコード());
            keyValue.setValue(daicho.get名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private RString get台帳種別(RString 台帳種別コード) {
        RString 台帳種別 = RString.EMPTY;
        for (KeyValueDataSource 台帳種別Enum : get台帳種別DDL()) {
            if (台帳種別コード.equals(台帳種別Enum.getKey())) {
                台帳種別 = 台帳種別Enum.getValue();
            }
        }
        return 台帳種別;
    }

    private List<KeyValueDataSource> get施設種類DDL() {
        List<KeyValueDataSource> dataSource = new ArrayList();
        for (ShisetsuType shisetsu : ShisetsuType.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(shisetsu.getコード());
            keyValue.setValue(shisetsu.get名称());
            dataSource.add(keyValue);
        }
        return dataSource;
    }

    private RString get施設種類(RString 施設種類コード) {
        RString 施設種類 = RString.EMPTY;
        for (KeyValueDataSource 施設種類Enum : get施設種類DDL()) {
            if (施設種類コード.equals(施設種類Enum.getKey())) {
                施設種類 = 施設種類Enum.getValue();
            }
        }
        return 施設種類;
    }

    private void 資格異動モード() {
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示無し"));
        switch (div.getMode_Riyou()) {
            case 台帳種別表示機能:
                ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
                break;
            case 全施設対象機能:
                break;
            case 被保険者対象機能:
                ViewStateHolder.put(ViewStateKeys.被保険者, new RString("被保険者"));
                break;
            case 他市町村住所地特例者対象機能:
                ViewStateHolder.put(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.他市町村住所地特例者, new RString("他市町村住所地特例者"));
                break;
            case 適用除外者対象機能:
                ViewStateHolder.put(jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.適用除外者, new RString("適用除外者"));
                break;
            default:
                break;

        }
        div.getDgShisetsuNyutaishoRireki().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getBtnAddShisetsuNyutaisho().setVisible(true);
        div.getTxtNyushoDate().setDisabled(true);
        div.getTxtTaishoDate().setDisabled(true);
        div.getCcdShisetsuJoho().setDisabled(true);
        div.getBtnShisetsuNyutaishoKakutei().setDisabled(true);
        div.getBtnShisetsuNyutaishoTorikeshi().setDisabled(true);
        div.getTenshutsusakiJohoPanel().setDisabled(true);
        div.getCcdShisetsuJoho().initialize();
    }

    private ShisetsuNyutaisho 追加の処理(
            ShisetsuNyutaisho 介護保険施設入退所情報,
            dgShisetsuNyutaishoRireki_Row row) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        FlexibleDate 入所処理年月日 = FlexibleDate.EMPTY;
        FlexibleDate 退所処理年月日 = FlexibleDate.EMPTY;
        RString 台帳種別 = RString.EMPTY;
        RString 施設種類 = RString.EMPTY;
        JigyoshaNo 施設コード = JigyoshaNo.EMPTY;
        FlexibleDate 入所年月日 = FlexibleDate.EMPTY;
        FlexibleDate 退所年月日 = FlexibleDate.EMPTY;
        HokenshaNo 保険者番号 = HokenshaNo.EMPTY;
        if (div.getTxtNyushoDate().getValue() != null
                && !div.getTxtNyushoDate().getValue().isEmpty()) {
            入所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            入所年月日 = div.getTxtNyushoDate().getValue();
        }
        if (div.getTxtTaishoDate().getValue() != null
                && !div.getTxtTaishoDate().getValue().isEmpty()) {
            退所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            退所年月日 = div.getTxtTaishoDate().getValue();
        }
        if (台帳種別表示機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
            if (!RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
                保険者番号 = new HokenshaNo(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            }
        } else if (被保険者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
            if (!RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
                保険者番号 = new HokenshaNo(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            }
        } else if (他市町村住所地特例者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
        } else if (適用除外者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
        } else if (全施設対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            施設種類 = row.getShisetsuShuruiKey();
            if (!RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
                保険者番号 = new HokenshaNo(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            }
        }
        if (div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo() != null
                && !div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo().isEmpty()) {
            施設コード = new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        }
        return 介護保険施設入退所情報.createBuilderForEdit()
                .set市町村コード(association.get地方公共団体コード())
                .set台帳種別(台帳種別)
                .set入所施設種類(施設種類)
                .set入所施設コード(施設コード)
                .set入所処理年月日(入所処理年月日)
                .set入所年月日(入所年月日)
                .set退所処理年月日(退所処理年月日)
                .set退所年月日(退所年月日).
                set保険者番号(保険者番号).build();
    }

    private ShisetsuNyutaisho 修正の処理(
            ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model,
            dgShisetsuNyutaishoRireki_Row row) {
        FlexibleDate 入所処理年月日;
        FlexibleDate 退所処理年月日;
        RString 台帳種別 = RString.EMPTY;
        RString 施設種類 = RString.EMPTY;
        JigyoshaNo 施設コード;
        FlexibleDate 入所年月日;
        FlexibleDate 退所年月日;
        HokenshaNo 保険者番号 = HokenshaNo.EMPTY;
        ShisetsuNyutaishoBuilder 施設入退所情報 = 施設入退所情報Model.get(介護保険施設入退所の識別子).createBuilderForEdit();
        if (div.getTxtNyushoDate().getValue() != null
                && !div.getTxtNyushoDate().getValue().isEmpty()) {
            入所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            入所年月日 = div.getTxtNyushoDate().getValue();
            施設入退所情報.set入所処理年月日(入所処理年月日).set入所年月日(入所年月日);
        }
        if (div.getTxtTaishoDate().getValue() != null) {
            退所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            退所年月日 = div.getTxtTaishoDate().getValue();
            施設入退所情報.set退所処理年月日(退所処理年月日).set退所年月日(退所年月日);
        }
        if (台帳種別表示機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
            if (!RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
                保険者番号 = new HokenshaNo(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            }
        } else if (被保険者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
            if (!RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
                保険者番号 = new HokenshaNo(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            }
        } else if (他市町村住所地特例者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
        } else if (適用除外者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            台帳種別 = row.getDaichoShubetsuKey();
            施設種類 = row.getShisetsuShuruiKey();
        } else if (全施設対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            施設種類 = row.getShisetsuShuruiKey();
            if (!RString.isNullOrEmpty(row.getTxtTenshutsusakiHokenshaBango())) {
                保険者番号 = new HokenshaNo(get保険者番号と保険者名称(row.getTxtTenshutsusakiHokenshaBango()).get(0));
            }
        }
        if (div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo() != null
                && !div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo().isEmpty()) {
            施設コード = new JigyoshaNo(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            施設入退所情報.set入所施設コード(施設コード);
        }
        return 施設入退所情報
                .set台帳種別(台帳種別)
                .set入所施設種類(施設種類)
                .set保険者番号(保険者番号).build();
    }

    private void 施設入退所情報活性() {
        div.getTxtNyushoDate().setDisabled(false);
        div.getTxtTaishoDate().setDisabled(false);
        div.getCcdShisetsuJoho().setDisabled(false);
        div.getTxtNyushoDate().clearValue();
        div.getTxtTaishoDate().clearValue();
        div.getBtnShisetsuNyutaishoKakutei().setDisabled(false);
        div.getBtnShisetsuNyutaishoTorikeshi().setDisabled(false);
        div.getTenshutsusakiJohoPanel().setDisabled(false);
        div.getCcdShisetsuJoho().clear();
        div.getTxtHokensha().clearValue();
        div.getTxtHokensyaMeisho().clearValue();
    }

    private void 施設種類(RString 台帳種別, dgShisetsuNyutaishoRireki_Row row) {
        if (DaichoType.適用除外者.getコード().equals(台帳種別)) {
            row.setShisetsuShurui(RString.EMPTY);
            row.setShisetsuShuruiKey(ShisetsuType.適用除外施設.getコード());
        }
    }

    private void 施設種類と台帳種別の設定(dgShisetsuNyutaishoRireki_Row newRow) {

        if (台帳種別表示機能.equals(new RString(div.getMode_Riyou().toString()))) {
            newRow.setDaichoShubetsu(get台帳種別(div.getCcdShisetsuJoho().getDaichoShubetsu()));
            newRow.setDaichoShubetsuKey(div.getCcdShisetsuJoho().getDaichoShubetsu());
            newRow.setShisetsuShurui(get施設種類(div.getCcdShisetsuJoho().get施設種類()));
            newRow.setShisetsuShuruiKey(div.getCcdShisetsuJoho().get施設種類());
            newRow.setTxtTenshutsusakiHokenshaBango(get保険者名(div.getTxtHokensha().getValue()));
            施設種類(newRow.getDaichoShubetsuKey(), newRow);
        } else if (被保険者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            newRow.setDaichoShubetsu(DaichoType.被保険者.get名称());
            newRow.setDaichoShubetsuKey(DaichoType.被保険者.getコード());
            newRow.setShisetsuShurui(get施設種類(div.getCcdShisetsuJoho().get施設種類()));
            newRow.setShisetsuShuruiKey(div.getCcdShisetsuJoho().get施設種類());
            newRow.setTxtTenshutsusakiHokenshaBango(get保険者名(div.getTxtHokensha().getValue()));
        } else if (他市町村住所地特例者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            newRow.setDaichoShubetsu(DaichoType.他市町村住所地特例者.get名称());
            newRow.setDaichoShubetsuKey(DaichoType.他市町村住所地特例者.getコード());
            newRow.setShisetsuShurui(get施設種類(div.getCcdShisetsuJoho().get施設種類()));
            newRow.setShisetsuShuruiKey(div.getCcdShisetsuJoho().get施設種類());
        } else if (適用除外者対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            newRow.setDaichoShubetsu(DaichoType.適用除外者.get名称());
            newRow.setDaichoShubetsuKey(DaichoType.適用除外者.getコード());
            newRow.setShisetsuShurui(ShisetsuType.適用除外施設.get名称());
            newRow.setShisetsuShuruiKey(ShisetsuType.適用除外施設.getコード());
        } else if (全施設対象機能.equals(new RString(div.getMode_Riyou().toString()))) {
            newRow.setShisetsuShurui(get施設種類(div.getCcdShisetsuJoho().get施設種類()));
            newRow.setShisetsuShuruiKey(div.getCcdShisetsuJoho().get施設種類());
            newRow.setTxtTenshutsusakiHokenshaBango(get保険者名(div.getTxtHokensha().getValue()));
        }
    }

    public boolean isSavable() {
        List<dgShisetsuNyutaishoRireki_Row> listRow = div.getDgShisetsuNyutaishoRireki().getDataSource();
        for (dgShisetsuNyutaishoRireki_Row row : listRow) {
            if (RString.isNullOrEmpty(row.getState())) {
                continue;
            }
            if (追加.equals(row.getState()) || 更新.equals(row.getState()) || 削除.equals(row.getState())) {
                return true;
            }
        }
        return false;
    }

    private RString get保険者名(RString 保険者番号) {
        if (!RString.isNullOrEmpty(保険者番号)) {
            Hokensha hokensha = HokenshaNyuryokuHojoFinder.createInstance().getHokensha(new HokenjaNo(保険者番号));
            if (hokensha != null) {
                return 保険者番号.concat(":").concat(hokensha.get保険者名());
            }
        }
        return RString.EMPTY;
    }

    private List<RString> get保険者番号と保険者名称(RString 保険者番号と保険者名称) {
        return 保険者番号と保険者名称.split(":");
    }

    private static class RirekiNoDateComparator implements Comparator<dgShisetsuNyutaishoRireki_Row>, Serializable {

        @Override
        public int compare(dgShisetsuNyutaishoRireki_Row o1, dgShisetsuNyutaishoRireki_Row o2) {
            return o1.getRirekiNo().compareTo(o2.getRirekiNo());
        }
    }

    private static class NyushoDateComparator implements Comparator<dgShisetsuNyutaishoRireki_Row>, Serializable {

        @Override
        public int compare(dgShisetsuNyutaishoRireki_Row o1, dgShisetsuNyutaishoRireki_Row o2) {
            return o2.getNyushoDate().getValue().compareTo(o1.getNyushoDate().getValue());
        }
    }
}
