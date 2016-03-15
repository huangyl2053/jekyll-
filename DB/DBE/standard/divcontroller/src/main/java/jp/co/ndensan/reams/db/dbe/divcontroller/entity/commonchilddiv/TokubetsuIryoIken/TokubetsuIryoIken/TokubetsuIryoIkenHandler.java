/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokubetsuIryoIken.TokubetsuIryoIken;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku13;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 特別医療意見のHandlerクラスです。
 */
public class TokubetsuIryoIkenHandler {

    private static final int 処置内容_点滴の管理 = 1;
    private static final int 処置内容_中心静脈栄養 = 2;
    private static final int 処置内容_透析 = 3;
    private static final int 処置内容_ストーマの処置 = 4;
    private static final int 処置内容_酸素療法 = 5;
    private static final int 処置内容_レスピレーター = 6;
    private static final int 処置内容_気管切開の処置 = 7;
    private static final int 処置内容_疼痛の看護 = 8;
    private static final int 処置内容_経管栄養 = 9;
    private static final int 特別な対応_モニター測定 = 10;
    private static final int 特別な対応_褥瘡の処置 = 11;
    private static final int 失禁への対応_カテーテル = 12;
    private final RString 処置内容_点滴の管理KEY = new RString("1");
    private final RString 処置内容_中心静脈栄養KEY = new RString("2");
    private final RString 処置内容_透析KEY = new RString("3");
    private final RString 処置内容_ストーマの処置KEY = new RString("4");
    private final RString 処置内容_酸素療法KEY = new RString("5");
    private final RString 処置内容_レスピレーターKEY = new RString("6");
    private final RString 処置内容_気管切開の処置KEY = new RString("7");
    private final RString 処置内容_疼痛の看護KEY = new RString("8");
    private final RString 処置内容_経管栄養KEY = new RString("9");
    private final RString 特別な対応_モニター測定KEY = new RString("10");
    private final RString 特別な対応_褥瘡の処置KEY = new RString("11");
    private final RString 失禁への対応_カテーテルKEY = new RString("12");
    private final RString 無 = new RString("1");
    private final RString 有 = new RString("2");
    private final TokubetsuIryoIkenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 特別医療意見Div
     */
    public TokubetsuIryoIkenHandler(TokubetsuIryoIkenDiv div) {
        this.div = div;
    }

    /**
     * 特別医療意見の初期化を設定します。
     *
     */
    public void onLoad() {
        NinteiShinseiJoho shinseiJohoModels
                = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);
        ShinseishoKanriNo 管理番号 = ViewStateHolder.get(
                ViewStateKeys.要介護認定申請検索_申請書管理番号, ShinseishoKanriNo.class);
        int 履歴番号 = ViewStateHolder.get(
                ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, Integer.class);
        ShujiiIkenshoIraiJohoIdentifier 依頼情報Key = new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoJohoIdentifier 主治医意見書情報Key = new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoJoho 要介護認定主治医意見書情報 = shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報Key).
                getSeishinTechoNini(主治医意見書情報Key);

        if (要介護認定主治医意見書情報 != null) {
            List<ShujiiIkenshoIkenItem> 主治医意見書登録意見書情報 = 要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList();
            if (主治医意見書登録意見書情報 != null && !主治医意見書登録意見書情報.isEmpty()) {
                モード判断(主治医意見書登録意見書情報, 管理番号, 履歴番号, shinseiJohoModels, 依頼情報Key, 主治医意見書情報Key);
            }
        }
    }

    /**
     * 確認ボタンを押下する場合、処理なし、本画面を閉じる。
     */
    public void btnKakutei() {
        List<KeyValueDataSource> 処置内容 = div.getChkTokubetsuIryo().getDataSource();
        List<KeyValueDataSource> 特別な対応 = div.getChkTokubetsuTaiou().getDataSource();
        List<KeyValueDataSource> 失禁への対応 = div.getChkShikkinTaio().getDataSource();
        NinteiShinseiJoho shinseiJohoModels
                = ViewStateHolder.get(ViewStateKeys.主治医意見書登録_意見書情報, NinteiShinseiJoho.class);

        ShinseishoKanriNo 管理番号 = ViewStateHolder.get(
                ViewStateKeys.要介護認定申請検索_申請書管理番号, ShinseishoKanriNo.class);
        int 履歴番号 = ViewStateHolder.get(
                ViewStateKeys.要介護認定申請検索_主治医意見書作成依頼履歴番号, Integer.class);
        ShujiiIkenshoIraiJohoIdentifier 依頼情報の識別子 = new ShujiiIkenshoIraiJohoIdentifier(管理番号, 履歴番号);
        ShujiiIkenshoJohoIdentifier 意見書情報の識別子 = new ShujiiIkenshoJohoIdentifier(管理番号, 履歴番号);

        for (KeyValueDataSource keyValue : 処置内容) {
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子
                    = new ShujiiIkenshoIkenItemIdentifier(管理番号, 履歴番号, Integer.parseInt(keyValue.getKey().toString()));
            データクリア(shinseiJohoModels, 依頼情報の識別子, 意見書情報の識別子, 意見書意見項目の識別子);
        }
        for (KeyValueDataSource keyValue : 特別な対応) {
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子
                    = new ShujiiIkenshoIkenItemIdentifier(管理番号, 履歴番号, Integer.parseInt(keyValue.getKey().toString()));
            データクリア(shinseiJohoModels, 依頼情報の識別子, 意見書情報の識別子, 意見書意見項目の識別子);
        }
        for (KeyValueDataSource keyValue : 失禁への対応) {
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子
                    = new ShujiiIkenshoIkenItemIdentifier(管理番号, 履歴番号, Integer.parseInt(keyValue.getKey().toString()));
            データクリア(shinseiJohoModels, 依頼情報の識別子, 意見書情報の識別子, 意見書意見項目の識別子);
        }
        List<RString> 処置内容KEYList = div.getChkTokubetsuIryo().getSelectedKeys();
        List<RString> 特別な対応KEYList = div.getChkTokubetsuTaiou().getSelectedKeys();
        List<RString> 失禁への対応KEYList = div.getChkShikkinTaio().getSelectedKeys();
        for (RString 処置内容KEY : 処置内容KEYList) {
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子
                    = new ShujiiIkenshoIkenItemIdentifier(管理番号, 履歴番号, Integer.parseInt(処置内容KEY.toString()));
            データ編集(shinseiJohoModels, 依頼情報の識別子, 意見書情報の識別子, true, 意見書意見項目の識別子);
        }
        for (RString 特別な対応KEY : 特別な対応KEYList) {
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子
                    = new ShujiiIkenshoIkenItemIdentifier(管理番号, 履歴番号, Integer.parseInt(特別な対応KEY.toString()));
            データ編集(shinseiJohoModels, 依頼情報の識別子, 意見書情報の識別子, true, 意見書意見項目の識別子);
        }
        for (RString 失禁への対応KEY : 失禁への対応KEYList) {
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子
                    = new ShujiiIkenshoIkenItemIdentifier(管理番号, 履歴番号, Integer.parseInt(失禁への対応KEY.toString()));
            データ編集(shinseiJohoModels, 依頼情報の識別子, 意見書情報の識別子, true, 意見書意見項目の識別子);
        }
        ViewStateHolder.put(ViewStateKeys.主治医意見書登録_意見書情報, shinseiJohoModels);
    }

    private void モード判断(
            List<ShujiiIkenshoIkenItem> 主治医意見書登録意見書情報,
            ShinseishoKanriNo 管理番号,
            int 履歴番号,
            NinteiShinseiJoho shinseiJohoModels,
            ShujiiIkenshoIraiJohoIdentifier 依頼情報Key,
            ShujiiIkenshoJohoIdentifier 主治医意見書情報Key) {
        ShujiiIkenshoIkenItem 意見書登録意見書情報 = 主治医意見書登録意見書情報.get(0);
        List<RString> 処置内容KeyList = new ArrayList();
        List<RString> 特別な対応KeyList = new ArrayList();
        List<RString> 失禁への対応KeyList = new ArrayList();
        boolean 点滴の管理 = false;
        boolean 中心静脈栄養 = false;
        boolean 透析 = false;
        boolean ストーマの処置 = false;
        boolean 酸素療法 = false;
        boolean レスピレーター = false;
        boolean 気管切開の処置 = false;
        boolean 疼痛の看護 = false;
        boolean 経管栄養 = false;
        boolean モニター測定 = false;
        boolean 褥瘡の処置 = false;
        boolean カテーテル = false;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(意見書登録意見書情報.get厚労省IF識別コード().getColumnValue())) {
            for (ShujiiIkenshoIkenItem 意見書情報 : 主治医意見書登録意見書情報) {
                switch (意見書情報.get連番()) {
                    case 処置内容_点滴の管理:
                        点滴の管理 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_点滴の管理KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_中心静脈栄養:
                        中心静脈栄養 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_中心静脈栄養KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_透析:
                        透析 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_透析KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_ストーマの処置:
                        ストーマの処置 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_ストーマの処置KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_酸素療法:
                        酸素療法 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_酸素療法KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_レスピレーター:
                        レスピレーター = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_レスピレーターKEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_気管切開の処置:
                        気管切開の処置 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_気管切開の処置KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_疼痛の看護:
                        疼痛の看護 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_疼痛の看護KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 処置内容_経管栄養:
                        経管栄養 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            処置内容KeyList.add(処置内容_経管栄養KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 特別な対応_モニター測定:
                        モニター測定 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            特別な対応KeyList.add(特別な対応_モニター測定KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 特別な対応_褥瘡の処置:
                        褥瘡の処置 = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            特別な対応KeyList.add(特別な対応_褥瘡の処置KEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    case 失禁への対応_カテーテル:
                        カテーテル = true;
                        if (意見項目の変更(意見書情報.get意見項目())) {
                            失禁への対応KeyList.add(失禁への対応_カテーテルKEY);
                        }
                        モード判断設定(意見書情報);
                        break;
                    default:
                        break;
                }
            }
            div.getChkTokubetsuIryo().setSelectedItemsByKey(処置内容KeyList);
            div.getChkTokubetsuTaiou().setSelectedItemsByKey(特別な対応KeyList);
            div.getChkShikkinTaio().setSelectedItemsByKey(失禁への対応KeyList);
        }
        if (!点滴の管理) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_点滴の管理)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!中心静脈栄養) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_中心静脈栄養)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!透析) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_透析)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!ストーマの処置) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_ストーマの処置)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!酸素療法) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_酸素療法)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!レスピレーター) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_レスピレーター)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!気管切開の処置) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_気管切開の処置)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!疼痛の看護) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_疼痛の看護)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!経管栄養) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 処置内容_経管栄養)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!モニター測定) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 特別な対応_モニター測定)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!褥瘡の処置) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 特別な対応_褥瘡の処置)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!カテーテル) {
            主治医意見書登録意見書情報.add(new ShujiiIkenshoIkenItem(管理番号, 履歴番号, 失禁への対応_カテーテル)
                    .createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        for (ShujiiIkenshoIkenItem 意見書情報 : 主治医意見書登録意見書情報) {
            shinseiJohoModels.createBuilderForEdit().setShujiiIkenshoIraiJoho(
                    shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報Key).createBuilderForEdit().setShujiiIkenshoJoho(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報Key).
                            getSeishinTechoNini(主治医意見書情報Key).createBuilderForEdit().setShujiiIkenshoIkenItem(意見書情報).build()).build());
        }
        ViewStateHolder.put(ViewStateKeys.主治医意見書登録_意見書情報, shinseiJohoModels);
    }

    private void データクリア(NinteiShinseiJoho shinseiJohoModels,
            ShujiiIkenshoIraiJohoIdentifier 依頼情報の識別子,
            ShujiiIkenshoJohoIdentifier 意見書情報の識別子,
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子) {
        shinseiJohoModels.createBuilderForEdit().setShujiiIkenshoIraiJoho(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子)
                .createBuilderForEdit().setShujiiIkenshoJoho(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子).getSeishinTechoNini(意見書情報の識別子)
                        .createBuilderForEdit().setShujiiIkenshoIkenItem(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子).
                                getSeishinTechoNini(意見書情報の識別子).getShujiiIkenshoIkenItem(意見書意見項目の識別子).createBuilderForEdit()
                                .set意見項目(意見項目の変更(false)).build()).build()).build());
    }

    private void データ編集(
            NinteiShinseiJoho shinseiJohoModels,
            ShujiiIkenshoIraiJohoIdentifier 依頼情報の識別子,
            ShujiiIkenshoJohoIdentifier 意見書情報の識別子,
            boolean 意見項目,
            ShujiiIkenshoIkenItemIdentifier 意見書意見項目の識別子) {
        shinseiJohoModels.createBuilderForEdit().setShujiiIkenshoIraiJoho(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子)
                .createBuilderForEdit().setShujiiIkenshoJoho(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子).getSeishinTechoNini(意見書情報の識別子)
                        .createBuilderForEdit().setShujiiIkenshoIkenItem(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子).
                                getSeishinTechoNini(意見書情報の識別子).getShujiiIkenshoIkenItem(意見書意見項目の識別子).createBuilderForEdit()
                                .set意見項目(意見項目の変更(意見項目)).build()).build()).build());
        System.out.print(shinseiJohoModels.getShujiiIkenshoIraiJoho(依頼情報の識別子).
                getSeishinTechoNini(意見書情報の識別子).getShujiiIkenshoIkenItem(意見書意見項目の識別子).toEntity().getState());
    }

    private ShujiiIkenshoIkenItem モード判断設定(ShujiiIkenshoIkenItem 意見書情報) {
        if (!EntityDataState.Added.equals(意見書情報.toEntity().getState())) {
            return 意見書情報.modifiedModel();
        }
        return 意見書情報;
    }

    private boolean 意見項目の変更(RString 意見項目) {
        return IkenKomoku13.チェック有.getコード().equals(意見項目);
    }

    private RString 意見項目の変更(boolean 意見項目) {
        if (意見項目) {
            return IkenKomoku13.チェック有.getコード();
        }
        return IkenKomoku13.チェック無.getコード();
    }
}
