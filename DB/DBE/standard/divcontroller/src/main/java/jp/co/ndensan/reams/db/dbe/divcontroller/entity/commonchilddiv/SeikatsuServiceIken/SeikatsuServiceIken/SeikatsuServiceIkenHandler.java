/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.SeikatsuServiceIken.SeikatsuServiceIken;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku18;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 生活サービス意見入力のHandlerクラスです。
 */
public class SeikatsuServiceIkenHandler {

    private static final RString 厚労省IF識別コード = new RString("09B");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString KEY4 = new RString("key4");
    private static final RString KEY5 = new RString("key5");
    private static final RString KEY6 = new RString("key6");
    private static final RString KEY7 = new RString("key7");
    private static final RString KEY8 = new RString("key8");
    private static final RString KEY9 = new RString("key9");
    private static final RString KEY10 = new RString("key10");
    private static final RString KEY11 = new RString("key11");
    private static final RString KEY12 = new RString("key12");
    private static final RString KEY13 = new RString("key13");
    private static final RString KEY14 = new RString("key14");
    private static final RString KEY15 = new RString("key15");
    private static final RString KEY16 = new RString("key16");
    private static final RString KEY17 = new RString("key17");
    private static final RString KEY18 = new RString("key18");
    private static final RString KEY19 = new RString("key19");
    private static final RString RSTR_1 = new RString("1");
    private static final RString RSTR_2 = new RString("2");
    private static final RString RSTR_3 = new RString("3");
    private static final RString RSTR_9 = new RString("9");
    private static final String STR_KEY0 = "key0";
    private static final String STR_KEY1 = "key1";
    private static final String STR_KEY2 = "key2";
    private static final int INDEX_0 = 0;
    private static final List<Integer> 連番_意見項目リスト = new ArrayList();
    private static final List<Integer> 連番_記入項目リスト = new ArrayList();
    List<RString> chkHokohojoShiyokeys = new ArrayList();
    List<RString> chkHasseiShojokeys = new ArrayList();
    List<RString> chkIgakutekiKanrikeys = new ArrayList();
    List<RString> chkJotaiSonotakeys = new ArrayList();
    List<RString> chkSonotaIryoServicekeys = new ArrayList();
    List<RString> chkSonotaIryoServiceHitsuyoSeikeys = new ArrayList();
    private final SeikatsuServiceIkenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SeikatsuServiceIkenDiv
     */
    public SeikatsuServiceIkenHandler(SeikatsuServiceIkenDiv div) {
        this.div = div;
    }

    /**
     * 生活サービス意見入力情報を設定します。
     *
     */
    public void onLoad() {
        連番リスト初期化処理();
        NinteiShinseiJoho ninteiShinseiJohoBusiness = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_申請書管理番号, RString.class));
        RString 履歴番号STR = ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, RString.class);
        int 履歴番号 = Integer.valueOf(履歴番号STR.toString());
        ShujiiIkenshoIraiJohoIdentifier shujiiIkenshoIraiIdentifier = new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoJohoIdentifier shujiiIkenshoJohoIdentifier = new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = ninteiShinseiJohoBusiness.getShujiiIkenshoIraiJoho(shujiiIkenshoIraiIdentifier);
        if (shujiiIkenshoIraiJoho.getShujiiIkenshoJohoList().isEmpty()) {
            shujiiIkenshoIraiJoho.createBuilderForEdit()
                    .setShujiiIkenshoJoho(create要介護認定主治医意見書情報(管理番号, 履歴番号));
        }
        ShujiiIkenshoJoho shujiiIkenshoJoho = shujiiIkenshoIraiJoho.getSeishinTechoNini(shujiiIkenshoJohoIdentifier);
        if (shujiiIkenshoJoho.getShujiiIkenshoIkenItemList().isEmpty()) {
            shujiiIkenshoJoho = create意見項目(shujiiIkenshoJoho, 管理番号, 履歴番号);
        }
        if (shujiiIkenshoJoho.getShujiiIkenshoKinyuItemList().isEmpty()) {
            shujiiIkenshoJoho = create記入項目(shujiiIkenshoJoho, 管理番号, 履歴番号);
        }
        List<ShujiiIkenshoIkenItem> 要介護認定主治医意見書意見項目リスト = shujiiIkenshoJoho.getShujiiIkenshoIkenItemList();
        List<ShujiiIkenshoKinyuItem> 要介護認定主治医意見書記入項目リスト = shujiiIkenshoJoho.getShujiiIkenshoKinyuItemList();
        要介護認定主治医意見書意見項目リスト = 意見項目初期化編集(要介護認定主治医意見書意見項目リスト, 管理番号, 履歴番号);
        要介護認定主治医意見書記入項目リスト = 記入項目初期化編集(要介護認定主治医意見書記入項目リスト, 管理番号, 履歴番号);
        viewStateSave(ninteiShinseiJohoBusiness,
                shujiiIkenshoIraiJoho, shujiiIkenshoJoho,
                要介護認定主治医意見書意見項目リスト, 要介護認定主治医意見書記入項目リスト);
    }

    /**
     * 生活サービス意見入力情報状態の処理です。
     *
     */
    public void 初期化状態定義() {
        div.getTxtEiyoShokuseikatsuRyuiten().setReadOnly(true);
        div.getTxtSonotaJotaiShosai().setReadOnly(true);
        div.getTxtShonotaIryoServiceShosai().setReadOnly(true);
        div.getTxtKetsuatsu().setReadOnly(true);
        div.getTxtIdo().setReadOnly(true);
        div.getTxtSesshoku().setReadOnly(true);
        div.getTxtUndo().setReadOnly(true);
        div.getTxtEnka().setReadOnly(true);
        div.getTxtKansenshoShosai().setReadOnly(true);
        if (KEY1.equals(div.getRadGenzaiEiyoJotai().getSelectedKey())) {
            div.getTxtEiyoShokuseikatsuRyuiten().setReadOnly(false);
        }
        if (!div.getChkJotaiSonota().getSelectedKeys().isEmpty()) {
            div.getTxtSonotaJotaiShosai().setReadOnly(false);
        }
        if (!div.getChkSonotaIryoService().getSelectedKeys().isEmpty()) {
            div.getTxtShonotaIryoServiceShosai().setReadOnly(false);
        }
        if (KEY1.equals(div.getRadKetsuatsu().getSelectedKey())) {
            div.getTxtKetsuatsu().setReadOnly(false);
        }
        if (KEY1.equals(div.getRadIdo().getSelectedKey())) {
            div.getTxtIdo().setReadOnly(false);
        }
        if (KEY1.equals(div.getRadSesshoku().getSelectedKey())) {
            div.getTxtSesshoku().setReadOnly(false);
        }
        if (KEY1.equals(div.getRadUndo().getSelectedKey())) {
            div.getTxtUndo().setReadOnly(false);
        }
        if (KEY1.equals(div.getRadEnka().getSelectedKey())) {
            div.getTxtEnka().setReadOnly(false);
        }
        if (KEY1.equals(div.getRadKansenshoUmu().getSelectedKey())) {
            div.getTxtKansenshoShosai().setReadOnly(false);
        }
    }

    /**
     * 主治医意見書作成依頼情報を設定します。
     *
     */
    public void editShujiiIkenshoJoho() {
        NinteiShinseiJoho ninteiShinseiJohoBusiness = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_申請書管理番号, RString.class));
        RString 履歴番号STR = ViewStateHolder.get(ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, RString.class);
        int 履歴番号 = Integer.valueOf(履歴番号STR.toString());

        ShujiiIkenshoIraiJohoIdentifier shujiiIkenshoIraiIdentifier = new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho = ninteiShinseiJohoBusiness.getShujiiIkenshoIraiJoho(shujiiIkenshoIraiIdentifier);
        ShujiiIkenshoJohoIdentifier shujiiIkenshoJohoIdentifier = new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoJoho shujiiIkenshoJoho = shujiiIkenshoIraiJoho.getSeishinTechoNini(shujiiIkenshoJohoIdentifier);
        List<ShujiiIkenshoIkenItem> 要介護認定主治医意見書意見項目リスト = shujiiIkenshoJoho.getShujiiIkenshoIkenItemList();
        List<ShujiiIkenshoKinyuItem> 要介護認定主治医意見書記入項目リスト = shujiiIkenshoJoho.getShujiiIkenshoKinyuItemList();
        連番リスト初期化処理();
        viewStateSave(ninteiShinseiJohoBusiness,
                shujiiIkenshoIraiJoho, shujiiIkenshoJoho,
                edit意見項目(要介護認定主治医意見書意見項目リスト), edit記入項目(要介護認定主治医意見書記入項目リスト));
    }

    private ShujiiIkenshoJoho create要介護認定主治医意見書情報(ShinseishoKanriNo 管理番号, int 履歴番号) {
        ShujiiIkenshoJoho 要介護認定主治医意見書情報 = new ShujiiIkenshoJoho(管理番号, 履歴番号);
        要介護認定主治医意見書情報 = create意見項目(要介護認定主治医意見書情報, 管理番号, 履歴番号);
        return create記入項目(要介護認定主治医意見書情報, 管理番号, 履歴番号);
    }

    private ShujiiIkenshoJoho create意見項目(ShujiiIkenshoJoho 要介護認定主治医意見書情報, ShinseishoKanriNo 管理番号, int 履歴番号) {
        for (int 意見項目_連番 : 連番_意見項目リスト) {
            要介護認定主治医意見書情報.createBuilderForEdit().setShujiiIkenshoIkenItem(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 意見項目_連番)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(厚労省IF識別コード)).build());

        }
        return 要介護認定主治医意見書情報;
    }

    private ShujiiIkenshoJoho create記入項目(ShujiiIkenshoJoho 要介護認定主治医意見書情報, ShinseishoKanriNo 管理番号, int 履歴番号) {
        for (int 記入項目_連番 : 連番_記入項目リスト) {
            要介護認定主治医意見書情報.createBuilderForEdit().setShujiiIkenshoIkenItem(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 記入項目_連番)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(厚労省IF識別コード)).build());

        }
        return 要介護認定主治医意見書情報;
    }

    private void viewStateSave(NinteiShinseiJoho ninteiShinseiJohoBusiness, ShujiiIkenshoIraiJoho shujiiIkenshoIraiJoho,
            ShujiiIkenshoJoho shujiiIkenshoJoho, List<ShujiiIkenshoIkenItem> 要介護認定主治医意見書意見項目リスト,
            List<ShujiiIkenshoKinyuItem> 要介護認定主治医意見書記入項目リスト) {
        for (ShujiiIkenshoIkenItem item : 要介護認定主治医意見書意見項目リスト) {
            shujiiIkenshoJoho.createBuilderForEdit().setShujiiIkenshoIkenItem(item);
        }
        for (ShujiiIkenshoKinyuItem item : 要介護認定主治医意見書記入項目リスト) {
            shujiiIkenshoJoho.createBuilderForEdit().setShujiiIkenshoKinyuItem(item);
        }
        shujiiIkenshoIraiJoho.createBuilderForEdit().setShujiiIkenshoJoho(shujiiIkenshoJoho);
        ninteiShinseiJohoBusiness.createBuilderForEdit().setShujiiIkenshoIraiJoho(shujiiIkenshoIraiJoho);
        ViewStateHolder.put(ViewStateKeys.主治医意見書登録_意見書情報, ninteiShinseiJohoBusiness);
    }

    private List<ShujiiIkenshoIkenItem> edit意見項目(List<ShujiiIkenshoIkenItem> 要介護認定主治医意見書意見項目リスト) {
        List<ShujiiIkenshoIkenItem> result = new ArrayList();
        for (ShujiiIkenshoIkenItem item : 要介護認定主治医意見書意見項目リスト) {
            item = edit移動エリアの意見項目(item);
            item = edit栄養_食生活エリアの意見項目編集(item);
            item = edit現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの意見項目編集(item);
            item = editサービス利用による生活機能の維持_改善の見通しエリアの意見項目編集(item);
            item = edit医学的管理の必要性エリアの意見項目編集_1(item);
            item = editサービス提供時における医学的観点からの留意点エリアの意見項目編集(item);
            item = edit感染症の有無エリアの意見項目編集(item);
            result.add(item);
        }
        return result;
    }

    private List<ShujiiIkenshoKinyuItem> edit記入項目(List<ShujiiIkenshoKinyuItem> 要介護認定主治医意見書記入項目リスト) {
        List<ShujiiIkenshoKinyuItem> result = new ArrayList();
        for (ShujiiIkenshoKinyuItem item : 要介護認定主治医意見書記入項目リスト) {
            item = edit現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの記入項目編集(item);
            item = edit医学的管理の必要性エリアの記入項目編集(item);
            item = editサービス提供時における医学的観点からの留意点エリアの記入項目編集(item);
            item = edit感染症の有無エリアの記入項目編集(item);
            result.add(item);
        }
        return result;
    }

    private ShujiiIkenshoIkenItem edit移動エリアの意見項目(ShujiiIkenshoIkenItem item) {
        if (64 == item.get連番()) {
            switch (div.getRadOkugaiHokou().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku11.自立.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku11.介助があればしている.getコード()).build();
                case STR_KEY2:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku11.していない.getコード()).build();
                default:
                    break;
            }
        }
        if (65 == item.get連番()) {
            switch (div.getRadKurumaisuShiyo().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku12.用いていない.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku12.主に自分で操作している.getコード()).build();
                case STR_KEY2:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku12.主に他人が操作している.getコード()).build();
                default:
                    break;
            }
        }
        if (66 == item.get連番()) {
            return edit_チェック無とチェック有(div.getChkHokohojoShiyo().getSelectedKeys(), item, KEY0);
        } else if (67 == item.get連番()) {
            return edit_チェック無とチェック有(div.getChkHokohojoShiyo().getSelectedKeys(), item, KEY1);
        } else if (68 == item.get連番()) {
            return edit_チェック無とチェック有(div.getChkHokohojoShiyo().getSelectedKeys(), item, KEY2);
        }
        return item;
    }

    private ShujiiIkenshoIkenItem edit_チェック無とチェック有(List<RString> keys, ShujiiIkenshoIkenItem item, RString str) {
        boolean isHas = false;
        for (RString key : keys) {
            if (str.equals(key)) {
                isHas = true;
            }
        }
        if (isHas) {
            return item.createBuilderForEdit().set意見項目(IkenKomoku13.チェック有.getコード()).build();
        } else {
            return item.createBuilderForEdit().set意見項目(IkenKomoku13.チェック無.getコード()).build();
        }
    }

    private ShujiiIkenshoIkenItem edit栄養_食生活エリアの意見項目編集(ShujiiIkenshoIkenItem item) {
        if (69 == item.get連番()) {
            switch (div.getRadShokujiKoi().getSelectedKey().toString()) {
                case STR_KEY0:
                    div.getRadShokujiKoi().setSelectedKey(KEY0);
                    return item.createBuilderForEdit().set意見項目(IkenKomoku14.自立ないし何とか自分で食べられる.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku14.全面介助.getコード()).build();
                case STR_KEY2:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku14.記載なし.getコード()).build();
                default:
                    break;
            }
        }
        if (70 == item.get連番()) {
            switch (div.getRadGenzaiEiyoJotai().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku15.良好.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku15.不良.getコード()).build();
                default:
                    break;
            }
        }
        return item;
    }

    private ShujiiIkenshoIkenItem edit現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの意見項目編集(ShujiiIkenshoIkenItem item) {
        List<RString> keys = div.getChkHasseiShojo().getSelectedKeys();
        if (71 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY0);
        }
        if (72 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY1);
        }
        if (73 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY2);
        }
        if (74 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY3);
        }
        if (75 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY4);
        }
        if (76 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY5);
        }
        if (77 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY6);
        }
        if (78 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY7);
        }
        if (79 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY8);
        }
        if (80 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY9);
        }
        if (81 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY10);
        }
        if (82 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY11);
        }
        if (83 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY12);
        }
        if (84 == item.get連番()) {
            return edit_チェック無とチェック有(div.getChkJotaiSonota().getSelectedKeys(), item, KEY0);
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem edit現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの記入項目編集(ShujiiIkenshoKinyuItem item) {
        if (14 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtSonotaJotaiShosai().getValue()).build();
        }
        if (15 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtTaishoHoushin().getValue()).build();
        }
        return item;
    }

    private ShujiiIkenshoIkenItem editサービス利用による生活機能の維持_改善の見通しエリアの意見項目編集(ShujiiIkenshoIkenItem item) {
        if (85 == item.get連番()) {
            switch (div.getRadSeikatsuKinoMitoshi().getSelectedKey().toString()) {
                case STR_KEY0:
                    div.getRadShokujiKoi().setSelectedKey(KEY0);
                    return item.createBuilderForEdit().set意見項目(IkenKomoku16.期待できる.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku16.期待できない.getコード()).build();
                case STR_KEY2:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku16.不明.getコード()).build();
                default:
                    break;
            }
        }
        return item;
    }

    private ShujiiIkenshoIkenItem edit医学的管理の必要性エリアの意見項目編集_1(ShujiiIkenshoIkenItem item) {
        List<RString> keys = div.getChkIgakutekiKanri().getSelectedKeys();
        if (86 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY0);
        }
        if (87 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY1);
        }
        if (88 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY2);
        }
        if (89 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY3);
        }
        if (90 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY4);
        }
        if (91 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY5);
        }
        if (92 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY6);
        }
        if (93 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY7);
        }
        if (94 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY8);
        }
        if (95 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY9);
        }
        if (96 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY10);
        }
        if (97 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY11);
        }
        if (98 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY12);
        }
        if (99 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY13);
        }
        if (100 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY14);
        }
        if (101 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY15);
        }
        if (102 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY16);
        }
        if (103 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY17);
        }
        if (104 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY18);
        }
        if (105 == item.get連番()) {
            return edit_チェック無とチェック有(keys, item, KEY19);
        }
        if (106 == item.get連番()) {
            return edit_チェック無とチェック有(div.getChkSonotaIryoService().getSelectedKeys(), item, KEY0);
        }
        if (107 == item.get連番()) {
            return edit_チェック無とチェック有(div.getChkSonotaIryoServiceHitsuyoSei().getSelectedKeys(), item, KEY0);
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem edit医学的管理の必要性エリアの記入項目編集(ShujiiIkenshoKinyuItem item) {
        if (16 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtShonotaIryoServiceShosai().getValue()).build();
        }
        return item;
    }

    private ShujiiIkenshoIkenItem editサービス提供時における医学的観点からの留意点エリアの意見項目編集(ShujiiIkenshoIkenItem item) {
        if (108 == item.get連番()) {
            switch (div.getRadKetsuatsu().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.特になし.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.あり.getコード()).build();
                default:
                    break;
            }
        }
        if (109 == item.get連番()) {
            switch (div.getRadIdo().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.特になし.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.あり.getコード()).build();
                default:
                    break;
            }
        }
        if (110 == item.get連番()) {
            switch (div.getRadSesshoku().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.特になし.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.あり.getコード()).build();
                default:
                    break;
            }
        }
        if (111 == item.get連番()) {
            switch (div.getRadUndo().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.特になし.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.あり.getコード()).build();
                default:
                    break;
            }
        }
        if (112 == item.get連番()) {
            switch (div.getRadEnka().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.特になし.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku17.あり.getコード()).build();
                default:
                    break;
            }
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem editサービス提供時における医学的観点からの留意点エリアの記入項目編集(ShujiiIkenshoKinyuItem item) {
        if (17 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtKetsuatsu().getValue()).build();
        }
        if (18 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtIdo().getValue()).build();
        }
        if (19 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtSesshoku().getValue()).build();
        }
        if (20 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtUndo().getValue()).build();
        }
        if (21 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtEnka().getValue()).build();
        }
        if (22 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtSonotaRyuiJiko().getValue()).build();
        }
        return item;
    }

    private ShujiiIkenshoIkenItem edit感染症の有無エリアの意見項目編集(ShujiiIkenshoIkenItem item) {
        if (113 == item.get連番()) {
            switch (div.getRadKansenshoUmu().getSelectedKey().toString()) {
                case STR_KEY0:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku18.無.getコード()).build();
                case STR_KEY1:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku18.有.getコード()).build();
                case STR_KEY2:
                    return item.createBuilderForEdit().set意見項目(IkenKomoku18.不明.getコード()).build();
                default:
                    break;
            }
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem edit感染症の有無エリアの記入項目編集(ShujiiIkenshoKinyuItem item) {
        if (23 == item.get連番()) {
            return item.createBuilderForEdit().set記入項目(div.getTxtKansenshoShosai().getValue()).build();
        }
        return item;
    }

    private List<ShujiiIkenshoIkenItem> 意見項目初期化編集(List<ShujiiIkenshoIkenItem> 要介護認定主治医意見書意見項目リスト
            , ShinseishoKanriNo 管理番号, int 履歴番号) {
        List<ShujiiIkenshoIkenItem> result = new ArrayList();
        boolean isExits = false;
        ShujiiIkenshoIkenItem itemTemp;
        chkHokohojoShiyokeys.clear();
        chkHasseiShojokeys.clear();
        chkIgakutekiKanrikeys.clear();
        for (int 連番 : 連番_意見項目リスト) {
            itemTemp = new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 連番).createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(厚労省IF識別コード)).build();
            for (ShujiiIkenshoIkenItem item : 要介護認定主治医意見書意見項目リスト) {
                if (連番 == item.get連番()) {
                    isExits = true;
                    itemTemp = item;
                    break;
                }
            }
            if (isExits && !itemTemp.isAdded()) {
                itemTemp = itemTemp.modifiedModel();
            }
            if (RString.isNullOrEmpty(itemTemp.get意見項目())) {
                itemTemp = itemTemp.createBuilderForEdit().set意見項目(RString.EMPTY).build();
            }
            result.add(itemTemp);
            移動エリアの意見項目初期化編集(itemTemp);
            栄養_食生活エリアの意見項目初期化編集(itemTemp);
            現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの意見項目初期化編集(itemTemp);
            サービス利用による生活機能の維持_改善の見通しエリアの意見項目初期化編集(itemTemp);
            サービス提供時における医学的観点からの留意点エリアの意見項目初期化編集(itemTemp);
            医学的管理の必要性エリアの意見項目初期化編集_1(itemTemp);
            感染症の有無エリアの意見項目初期化編集(itemTemp);
        }
        return result;
    }

    private List<ShujiiIkenshoKinyuItem> 記入項目初期化編集(List<ShujiiIkenshoKinyuItem> 要介護認定主治医意見書記入項目リスト
            , ShinseishoKanriNo 管理番号, int 履歴番号) {
        List<ShujiiIkenshoKinyuItem> result = new ArrayList();
        boolean isNotExits = false;
        ShujiiIkenshoKinyuItem itemTemp;
        for (int 連番 : 連番_記入項目リスト) {
            itemTemp = new ShujiiIkenshoKinyuItem(管理番号, 履歴番号, 連番).createBuilderForEdit()
                    .set厚労省IF識別コード(new Code(厚労省IF識別コード)).build();
            for (ShujiiIkenshoKinyuItem item : 要介護認定主治医意見書記入項目リスト) {
                if (連番 == item.get連番()) {
                    isNotExits = true;
                    itemTemp = item;
                    break;
                }
            }
            if (isNotExits && !itemTemp.isAdded()) {
                itemTemp = itemTemp.modifiedModel();
            }
            if (RString.isNullOrEmpty(itemTemp.get記入項目())) {
                itemTemp = itemTemp.createBuilderForEdit().set記入項目(RString.EMPTY).build();
            }
            result.add(itemTemp);
            栄養_食生活エリアの記入項目初期化編集(itemTemp);
            現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの記入項目初期化編集(itemTemp);
            医学的管理の必要性エリアの記入項目初期化編集(itemTemp);
            サービス提供時における医学的観点からの留意点エリアの記入項目初期化編集(itemTemp);
            感染症の有無エリアの記入項目初期化編集(itemTemp);
        }
        return result;
    }

    private void 移動エリアの意見項目初期化編集(ShujiiIkenshoIkenItem item) {
        if (64 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadOkugaiHokou().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadOkugaiHokou().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadOkugaiHokou().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadOkugaiHokou().setSelectedKey(KEY2);
            }
        }
        if (65 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadKurumaisuShiyo().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadKurumaisuShiyo().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadKurumaisuShiyo().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadKurumaisuShiyo().setSelectedKey(KEY2);
            }
        }
        if (66 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHokohojoShiyokeys.add(KEY0);
        }
        if (67 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHokohojoShiyokeys.add(KEY1);
        }
        if (68 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHokohojoShiyokeys.add(KEY2);
        }
        div.getChkHokohojoShiyo().setSelectedItemsByKey(chkHokohojoShiyokeys);
    }

    private void 栄養_食生活エリアの意見項目初期化編集(ShujiiIkenshoIkenItem item) {
        if (69 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadShokujiKoi().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadShokujiKoi().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadShokujiKoi().setSelectedKey(KEY1);
            } else if (RSTR_9.equals(item.get意見項目())) {
                div.getRadShokujiKoi().setSelectedKey(KEY2);
            }
        }
        if (70 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadGenzaiEiyoJotai().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadGenzaiEiyoJotai().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadGenzaiEiyoJotai().setSelectedKey(KEY1);
            }
        }
    }

    private void 栄養_食生活エリアの記入項目初期化編集(ShujiiIkenshoKinyuItem item) {
        if (13 == item.get連番()) {
            div.getTxtEiyoShokuseikatsuRyuiten().setValue(item.get記入項目());
            div.setHiddenTxtEiyoShokuseikatsuRyuiten(item.get記入項目());
        }
    }

    private void 現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの意見項目初期化編集(ShujiiIkenshoIkenItem item) {
        if (71 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY0);
        }
        if (72 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY1);
        }
        if (73 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY2);
        }
        if (74 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY3);
        }
        if (75 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY4);
        }
        if (76 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY5);
        }
        if (77 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY6);
        }
        if (78 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY7);
        }
        if (79 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY8);
        }
        if (80 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY9);
        }
        if (81 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY10);
        }
        if (82 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY11);
        }
        if (83 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkHasseiShojokeys.add(KEY12);
        }
        div.getChkHasseiShojo().setSelectedItemsByKey(chkHasseiShojokeys);
        if (84 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkJotaiSonotakeys.add(KEY0);
        }
        div.getChkJotaiSonota().setSelectedItemsByKey(chkJotaiSonotakeys);
    }

    private void 現在あるかまたは今後発生する可能性の高い状態とその対処方針エリアの記入項目初期化編集(ShujiiIkenshoKinyuItem item) {
        if (14 == item.get連番()) {
            div.getTxtSonotaJotaiShosai().setValue(item.get記入項目());
            div.setHiddenTxtSonotaJotaiShosai(item.get記入項目());
        }
        if (15 == item.get連番()) {
            div.getTxtTaishoHoushin().setValue(item.get記入項目());
        }
    }

    private void サービス利用による生活機能の維持_改善の見通しエリアの意見項目初期化編集(ShujiiIkenshoIkenItem item) {
        if (85 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadSeikatsuKinoMitoshi().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadSeikatsuKinoMitoshi().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadSeikatsuKinoMitoshi().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadSeikatsuKinoMitoshi().setSelectedKey(KEY2);
            }
        }
    }

    private void 医学的管理の必要性エリアの意見項目初期化編集_1(ShujiiIkenshoIkenItem item) {
        if (86 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY0);
        }
        if (87 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY1);
        }
        if (88 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY2);
        }
        if (89 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY3);
        }
        if (90 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY4);
        }
        if (91 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY5);
        }
        if (92 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY6);
        }
        if (93 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY7);
        }
        if (94 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY8);
        }
        if (95 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY9);
        }
        if (96 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY10);
        }
        if (97 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY11);
        }
        if (98 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY12);
        }
        医学的管理の必要性エリアの意見項目初期化編集_2(item);
    }

    private void 医学的管理の必要性エリアの意見項目初期化編集_2(ShujiiIkenshoIkenItem item) {
        if (99 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY13);
        }
        if (100 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY14);
        }
        if (101 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY15);
        }
        if (102 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY16);
        }
        if (103 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY17);
        }
        if (104 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY18);
        }
        if (105 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkIgakutekiKanrikeys.add(KEY19);
        }
        div.getChkIgakutekiKanri().setSelectedItemsByKey(chkIgakutekiKanrikeys);
        if (106 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkSonotaIryoServicekeys.add(KEY0);
        }
        div.getChkSonotaIryoService().setSelectedItemsByKey(chkSonotaIryoServicekeys);
        if (107 == item.get連番() && IkenKomoku13.チェック有.getコード().equals(item.get意見項目())) {
            chkSonotaIryoServiceHitsuyoSeikeys.add(KEY0);
        }
        div.getChkSonotaIryoServiceHitsuyoSei().setSelectedItemsByKey(chkSonotaIryoServiceHitsuyoSeikeys);
    }

    private void 医学的管理の必要性エリアの記入項目初期化編集(ShujiiIkenshoKinyuItem item) {
        if (16 == item.get連番()) {
            div.getTxtShonotaIryoServiceShosai().setValue(item.get記入項目());
            div.setHiddenTxtShonotaIryoServiceShosai(item.get記入項目());
        }
    }

    private void サービス提供時における医学的観点からの留意点エリアの意見項目初期化編集(ShujiiIkenshoIkenItem item) {
        if (108 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadKetsuatsu().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadKetsuatsu().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadKetsuatsu().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadKetsuatsu().setSelectedKey(KEY2);
            }
        }
        if (109 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadIdo().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadIdo().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadIdo().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadIdo().setSelectedKey(KEY2);
            }
        }
        if (110 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadSesshoku().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadSesshoku().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadSesshoku().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadSesshoku().setSelectedKey(KEY2);
            }
        }
        if (111 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadUndo().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadUndo().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadUndo().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadUndo().setSelectedKey(KEY2);
            }
        }
        if (112 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadEnka().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadEnka().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadEnka().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadEnka().setSelectedKey(KEY2);
            }
        }
    }

    private void サービス提供時における医学的観点からの留意点エリアの記入項目初期化編集(ShujiiIkenshoKinyuItem item) {
        if (17 == item.get連番()) {
            div.getTxtKetsuatsu().setValue(item.get記入項目());
            div.setHiddenTxtKetsuatsu(item.get記入項目());
        }
        if (18 == item.get連番()) {
            div.getTxtIdo().setValue(item.get記入項目());
            div.setHiddenTxtIdo(item.get記入項目());
        }
        if (19 == item.get連番()) {
            div.getTxtSesshoku().setValue(item.get記入項目());
            div.setHiddenTxtSesshoku(item.get記入項目());
        }
        if (20 == item.get連番()) {
            div.getTxtUndo().setValue(item.get記入項目());
            div.setHiddenTxtUndo(item.get記入項目());
        }
        if (21 == item.get連番()) {
            div.getTxtEnka().setValue(item.get記入項目());
            div.setHiddenTxtEnka(item.get記入項目());
        }
        if (22 == item.get連番()) {
            div.getTxtSonotaRyuiJiko().setValue(item.get記入項目());
            div.setHiddenTxtKansenshoShosai(item.get記入項目());
        }
    }

    private void 感染症の有無エリアの意見項目初期化編集(ShujiiIkenshoIkenItem item) {
        if (113 == item.get連番()) {
            if (RString.isNullOrEmpty(item.get意見項目())) {
                div.getRadKansenshoUmu().setSelectedKey(KEY0);
            } else if (RSTR_1.equals(item.get意見項目())) {
                div.getRadKansenshoUmu().setSelectedKey(KEY0);
            } else if (RSTR_2.equals(item.get意見項目())) {
                div.getRadKansenshoUmu().setSelectedKey(KEY1);
            } else if (RSTR_3.equals(item.get意見項目())) {
                div.getRadKansenshoUmu().setSelectedKey(KEY2);
            }
        }
    }

    private void 感染症の有無エリアの記入項目初期化編集(ShujiiIkenshoKinyuItem item) {
        if (23 == item.get連番()) {
            div.getTxtKansenshoShosai().setValue(item.get記入項目());
        }
    }

    private void 連番リスト初期化処理() {
        連番_意見項目リスト.clear();
        連番_記入項目リスト.clear();
        連番_意見項目リスト.add(64);
        連番_意見項目リスト.add(65);
        連番_意見項目リスト.add(66);
        連番_意見項目リスト.add(67);
        連番_意見項目リスト.add(68);
        連番_意見項目リスト.add(69);
        連番_意見項目リスト.add(70);
        連番_意見項目リスト.add(71);
        連番_意見項目リスト.add(72);
        連番_意見項目リスト.add(73);
        連番_意見項目リスト.add(74);
        連番_意見項目リスト.add(75);
        連番_意見項目リスト.add(76);
        連番_意見項目リスト.add(77);
        連番_意見項目リスト.add(78);
        連番_意見項目リスト.add(79);
        連番_意見項目リスト.add(80);
        連番_意見項目リスト.add(81);
        連番_意見項目リスト.add(82);
        連番_意見項目リスト.add(83);
        連番_意見項目リスト.add(84);
        連番_意見項目リスト.add(85);
        連番_意見項目リスト.add(86);
        連番_意見項目リスト.add(87);
        連番_意見項目リスト.add(88);
        連番_意見項目リスト.add(89);
        連番_意見項目リスト.add(90);
        連番_意見項目リスト.add(91);
        連番_意見項目リスト.add(92);
        連番_意見項目リスト.add(93);
        連番_意見項目リスト.add(94);
        連番_意見項目リスト.add(95);
        連番_意見項目リスト.add(96);
        連番_意見項目リスト.add(97);
        連番_意見項目リスト.add(98);
        連番_意見項目リスト.add(99);
        連番_意見項目リスト.add(100);
        連番_意見項目リスト.add(101);
        連番_意見項目リスト.add(102);
        連番_意見項目リスト.add(103);
        連番_意見項目リスト.add(104);
        連番_意見項目リスト.add(105);
        連番_意見項目リスト.add(106);
        連番_意見項目リスト.add(107);
        連番_意見項目リスト.add(108);
        連番_意見項目リスト.add(109);
        連番_意見項目リスト.add(110);
        連番_意見項目リスト.add(111);
        連番_意見項目リスト.add(112);
        連番_意見項目リスト.add(113);
        連番_記入項目リスト.add(13);
        連番_記入項目リスト.add(14);
        連番_記入項目リスト.add(15);
        連番_記入項目リスト.add(16);
        連番_記入項目リスト.add(17);
        連番_記入項目リスト.add(18);
        連番_記入項目リスト.add(19);
        連番_記入項目リスト.add(20);
        連番_記入項目リスト.add(21);
        連番_記入項目リスト.add(22);
        連番_記入項目リスト.add(23);
    }
}
