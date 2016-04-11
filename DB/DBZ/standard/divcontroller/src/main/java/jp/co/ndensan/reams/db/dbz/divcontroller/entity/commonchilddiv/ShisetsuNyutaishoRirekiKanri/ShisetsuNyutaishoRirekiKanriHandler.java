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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.kaigohohenshisetsu.KaigoHohenShisetsuBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.kaigohohenshisetsunyutaishoshakanri.KaigoHohenShisetsuNyutaishoshaKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 施設入退所履歴のHandlerクラスです。
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanriHandler {

    private final ShisetsuNyutaishoRirekiKanriDiv div;
    private final RString 資格異動 = new RString("資格異動");
    private final RString 台帳種別表示機能 = new RString("台帳種別表示機能");
    private final RString 適用除外者対象機能 = new RString("適用除外者対象機能");
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
            ViewStateHolder.put(ViewStateKeys.施設入退所履歴_施設入退所情報, Models.create(更新施設入退所情報));
            一覧の設定(施設入退所情報);
        } else {
            ViewStateHolder.put(ViewStateKeys.施設入退所履歴_施設入退所情報, Models.create(new ArrayList()));
        }
        switch (div.getMode_表示モード()) {
            case 照会:
                break;
            case 照会選択有:
                break;
            case 資格異動:
                資格異動モード();
                break;
        }
    }

    /**
     * 「追加する」ボタンを押下する場合、施設入退所情報パネルを活性します。
     */
    public void onClick_btnAddShisetsuNyutaisho() {
        div.setInputMode(追加);
        施設入退所情報活性();
    }

    /**
     * 「選択」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param row 選択データ
     */
    public void onSelectBySelectButton_dgShisetsuNyutaishoRireki(dgShisetsuNyutaishoRireki_Row row) {
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
        if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
            div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(row.getDaichoShubetsuKey());
        }
        if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
            div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設種類(row.getShisetsuShuruiKey());
        }
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setNyuryokuShisetsuKodo(row.getShisetsuCode());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setShisetsuMeisho(row.getShisetsu());
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setVisible(true);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi().setVisible(true);
    }

    /**
     * 「修正」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param row 選択データ
     */
    public void onSelectByModifyButton_dgShisetsuNyutaishoRireki(dgShisetsuNyutaishoRireki_Row row) {
        div.setInputMode(更新);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setDisabled(false);
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setDisabled(false);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setDisabled(false);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
        if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
            div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設種類(row.getShisetsuShuruiKey());
        }
        if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
            div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(row.getDaichoShubetsuKey());
        }
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setNyuryokuShisetsuKodo(row.getShisetsuCode());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setShisetsuMeisho(row.getShisetsu());
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setDisabled(false);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi().setDisabled(false);
    }

    /**
     * 「削除」ボタンを押下する場合、明細エリアに選択行の内容を表示します。
     *
     * @param row 選択データ
     */
    public void onSelectByDeleteButton_dgShisetsuNyutaishoRireki(dgShisetsuNyutaishoRireki_Row row) {
        div.setInputMode(削除);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setDisabled(true);
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setDisabled(true);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setDisabled(true);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
        if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
            div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set施設種類(row.getShisetsuShuruiKey());
        }
        if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
            div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().set台帳種別(row.getDaichoShubetsuKey());
        }
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setNyuryokuShisetsuKodo(row.getShisetsuCode());
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setShisetsuMeisho(row.getShisetsu());
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setDisabled(false);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi().setDisabled(false);
    }

    /**
     * 「取消する」ボタンを押下する場合、明細エリアの全項目がクリアされる。
     *
     */
    public void onClick_btnShisetsuNyutaishoTorikeshi() {
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setDisabled(true);
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setDisabled(true);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setDisabled(true);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().clearValue();
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().clearValue();
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setDisabled(true);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi().setDisabled(true);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().clear();
    }

    /**
     * 「確定する」ボタンを押下する場合、明細エリアの入力内容を一覧グリッドに反映させる。
     *
     * @param row 選択データ
     */
    public void onClick_btnShisetsuNyutaishoKakutei(dgShisetsuNyutaishoRireki_Row row) {
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model
                = ViewStateHolder.get(ViewStateKeys.施設入退所履歴_施設入退所情報, Models.class);
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getShikibetsuCode());
        List<dgShisetsuNyutaishoRireki_Row> listRow = div.getDgShisetsuNyutaishoRireki().getDataSource();
        dgShisetsuNyutaishoRireki_Row newRow = new dgShisetsuNyutaishoRireki_Row();
        int 最大履歴番号 = 1;
        if (listRow != null && !listRow.isEmpty()) {
            Collections.sort(listRow, new ShisetsuNyutaishoRirekiKanriHandler.RirekiNoDateComparator());
            最大履歴番号 = Integer.parseInt(listRow.get(0).getRirekiNo().toString()) + 1;
        } else {
            listRow = new ArrayList();
        }
        if (追加.equals(div.getInputMode())) {
            newRow.setState(追加);
            newRow.getNyushoDate().setValue(div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue());
            newRow.getTaishoDate().setValue(div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue());
            newRow.setShisetsu(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
                newRow.setShisetsuShurui(get施設種類(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類()));
                newRow.setShisetsuShuruiKey(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類());
            }
            if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
                newRow.setDaichoShubetsu(get台帳種別(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getDaichoShubetsu()));
                newRow.setDaichoShubetsuKey(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getDaichoShubetsu());
                施設種類(newRow.getDaichoShubetsuKey(), newRow);
            }
            newRow.setShisetsuCode(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            newRow.setShisetsuMeisho(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            newRow.setRirekiNo(new RString(Integer.toString(最大履歴番号)));
            listRow.add(newRow);
            ShisetsuNyutaisho 介護保険施設入退所情報 = new ShisetsuNyutaisho(識別コード, 最大履歴番号);
            施設入退所情報Model.add(追加の処理(介護保険施設入退所情報));
        } else if (更新.equals(div.getInputMode())) {
            row.getNyushoDate().setValue(div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue());
            row.getTaishoDate().setValue(div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue());
            row.setShisetsu(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
                row.setShisetsuShurui(get施設種類(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類()));
                row.setShisetsuShuruiKey(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類());
            }
            if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
                row.setDaichoShubetsu(get台帳種別(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getDaichoShubetsu()));
                row.setDaichoShubetsuKey(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getDaichoShubetsu());
                施設種類(newRow.getDaichoShubetsuKey(), newRow);
            }
            row.setShisetsuCode(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
            row.setShisetsuMeisho(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuMeisho());
            if (RString.isNullOrEmpty(row.getState())) {
                row.setState(更新);
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子 = new ShisetsuNyutaishoIdentifier(識別コード, 履歴番号);
                施設入退所情報Model.deleteOrRemove(介護保険施設入退所の識別子);
                施設入退所情報Model.add(修正の処理(介護保険施設入退所の識別子, 施設入退所情報Model));
            }
        } else if (削除.equals(div.getInputMode())) {
            if (RString.isNullOrEmpty(row.getState())) {
                row.setState(削除);
                int 履歴番号 = Integer.parseInt(row.getRirekiNo().toString());
                ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子 = new ShisetsuNyutaishoIdentifier(識別コード, 履歴番号);
                施設入退所情報Model.deleteOrRemove(介護保険施設入退所の識別子);
                施設入退所情報Model.add(削除の処理(介護保険施設入退所の識別子, 施設入退所情報Model));
            } else {
                listRow.remove(row);
            }
        }
        ViewStateHolder.put(ViewStateKeys.施設入退所履歴_施設入退所情報, Models.create(施設入退所情報Model));
        div.setInputMode(RString.EMPTY);
        div.getDgShisetsuNyutaishoRireki().setDataSource(listRow);
        onClick_btnShisetsuNyutaishoTorikeshi();
    }

    /**
     * 施設入退所履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    public void saveShisetsuNyutaisho() {
        ShikibetsuCode 識別コード = new ShikibetsuCode(div.getShikibetsuCode());
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model
                = ViewStateHolder.get(ViewStateKeys.施設入退所履歴_施設入退所情報, Models.class);
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

    private void 一覧の設定(List<KaigoHohenShisetsuBusiness> 施設入退所情報) {
        List<dgShisetsuNyutaishoRireki_Row> rowList = new ArrayList<>();
        for (KaigoHohenShisetsuBusiness 施設入退所 : 施設入退所情報) {
            dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row();
            row.getNyushoDate().setValue(施設入退所.get入所年月日());
            row.getTaishoDate().setValue(施設入退所.get退所年月日());
            row.setShisetsu(施設入退所.get事業者名称());
            row.setDaichoShubetsu(get台帳種別(施設入退所.get台帳種別()));
            row.setShisetsuShurui(get施設種類(施設入退所.get入所施設種類()));
            row.setShisetsuCode(施設入退所.get入所施設コード().getColumnValue());
            row.setShisetsuMeisho(施設入退所.get事業者名称());
            row.setDaichoShubetsuKey(施設入退所.get台帳種別());
            row.setShisetsuShuruiKey(施設入退所.get入所施設種類());
            row.setRirekiNo(new RString(施設入退所.get履歴番号().toString()));
            施設種類(施設入退所.get台帳種別(), row);
            rowList.add(row);

        }
        Collections.sort(rowList, new ShisetsuNyutaishoRirekiKanriHandler.RirekiNoDateComparator());
        div.getDgShisetsuNyutaishoRireki().setDataSource(rowList);
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
        ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys.台帳種別表示, new RString("台帳種別表示無し"));
        switch (div.getMode_利用()) {
            case 台帳種別表示機能:
                ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
                break;
            case 全施設対象機能:
                break;
            case 被保険者対象機能:
                ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys.被保険者, new RString("被保険者"));
                break;
            case 他市町村住所地特例者対象機能:
                ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys.他市町村住所地特例者, new RString("他市町村住所地特例者"));
                break;
            case 適用除外者対象機能:
                ViewStateHolder.put(jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys.適用除外者, new RString("適用除外者"));
                break;
            default:
                break;

        }
        div.getDgShisetsuNyutaishoRireki().getGridSetting().setIsShowSelectButtonColumn(false);
        div.getBtnAddShisetsuNyutaisho().setVisible(true);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setDisabled(true);
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setDisabled(true);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setDisabled(true);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setDisabled(true);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi().setDisabled(true);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().initialize();
    }

    private ShisetsuNyutaisho 追加の処理(
            ShisetsuNyutaisho 介護保険施設入退所情報) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        FlexibleDate 入所処理年月日 = FlexibleDate.EMPTY;
        FlexibleDate 退所処理年月日 = FlexibleDate.EMPTY;
        RString 台帳種別 = RString.EMPTY;
        RString 施設種類 = RString.EMPTY;
        JigyoshaNo 施設コード = JigyoshaNo.EMPTY;
        FlexibleDate 入所年月日 = FlexibleDate.EMPTY;
        FlexibleDate 退所年月日 = FlexibleDate.EMPTY;
        if (div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue() != null
                && !div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue().isEmpty()) {
            入所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            入所年月日 = div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue();
        }
        if (div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue() != null
                && !div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue().isEmpty()) {
            退所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            退所年月日 = div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue();
        }
        if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
            台帳種別 = div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getDaichoShubetsu();
        }
        if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
            施設種類 = div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類();
        }
        if (div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo() != null
                && !div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo().isEmpty()) {
            施設コード = new JigyoshaNo(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        }
        return 介護保険施設入退所情報.createBuilderForEdit()
                .set市町村コード(association.get地方公共団体コード())
                .set台帳種別(台帳種別)
                .set入所施設種類(施設種類)
                .set入所施設コード(施設コード)
                .set入所処理年月日(入所処理年月日)
                .set入所年月日(入所年月日)
                .set退所処理年月日(退所処理年月日)
                .set退所年月日(退所年月日)
                .set部屋記号番号(RString.EMPTY).build();
    }

    private ShisetsuNyutaisho 修正の処理(
            ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model) {
        FlexibleDate 入所処理年月日 = FlexibleDate.EMPTY;
        FlexibleDate 退所処理年月日 = FlexibleDate.EMPTY;
        RString 台帳種別 = RString.EMPTY;
        RString 施設種類 = RString.EMPTY;
        JigyoshaNo 施設コード = JigyoshaNo.EMPTY;
        FlexibleDate 入所年月日 = FlexibleDate.EMPTY;
        FlexibleDate 退所年月日 = FlexibleDate.EMPTY;
        if (div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue() != null
                && !div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue().isEmpty()) {
            入所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            入所年月日 = div.getShisetsuNyutaishoInput().getTxtNyushoDate().getValue();
        }
        if (div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue() != null
                && !div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue().isEmpty()) {
            退所処理年月日 = new FlexibleDate(RDate.getNowDate().toString());
            退所年月日 = div.getShisetsuNyutaishoInput().getTxtTaishoDate().getValue();
        }
        if (台帳種別表示機能.equals(new RString(div.getMode_利用().toString()))) {
            台帳種別 = div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getDaichoShubetsu();
        }
        if (!適用除外者対象機能.equals(new RString(div.getMode_利用().toString()))) {
            施設種類 = div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().get施設種類();
        }
        if (div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo() != null
                && !div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo().isEmpty()) {
            施設コード = new JigyoshaNo(div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo());
        }
        return 施設入退所情報Model.get(介護保険施設入退所の識別子).createBuilderForEdit()
                .set台帳種別(台帳種別)
                .set入所施設種類(施設種類)
                .set入所施設コード(施設コード)
                .set入所処理年月日(入所処理年月日)
                .set入所年月日(入所年月日)
                .set退所処理年月日(退所処理年月日)
                .set退所年月日(退所年月日).build();
    }

    private ShisetsuNyutaisho 削除の処理(
            ShisetsuNyutaishoIdentifier 介護保険施設入退所の識別子,
            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model) {
        // TODO 凌護行 ビジネス設計_DBAMN00000_施設入退所履歴により、削除する場合、更新項目は「論理削除フラグ　＝　True」です、但し、dbに項目「論理削除フラグ」が無し。
        return 施設入退所情報Model.get(介護保険施設入退所の識別子).createBuilderForEdit()
                .set台帳種別(資格異動).build();
    }

    private void 施設入退所情報活性() {
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().setDisabled(false);
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().setDisabled(false);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().setDisabled(false);
        div.getShisetsuNyutaishoInput().getTxtNyushoDate().clearValue();
        div.getShisetsuNyutaishoInput().getTxtTaishoDate().clearValue();
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei().setDisabled(false);
        div.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi().setDisabled(false);
        div.getShisetsuNyutaishoInput().getCcdShisetsuJoho().clear();
    }

    private void 施設種類(RString 台帳種別, dgShisetsuNyutaishoRireki_Row row) {
        if (DaichoType.適用除外者.getコード().equals(台帳種別)) {
            row.setShisetsuShurui(RString.EMPTY);
        }
    }

    private static class RirekiNoDateComparator implements Comparator<dgShisetsuNyutaishoRireki_Row>, Serializable {

        @Override
        public int compare(dgShisetsuNyutaishoRireki_Row o1, dgShisetsuNyutaishoRireki_Row o2) {
            return o2.getRirekiNo().compareTo(o1.getRirekiNo());
        }
    }
}
