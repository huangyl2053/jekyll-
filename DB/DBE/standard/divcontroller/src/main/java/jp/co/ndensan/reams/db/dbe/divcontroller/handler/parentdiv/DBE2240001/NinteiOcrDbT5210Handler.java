/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2240001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy99A;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001.NinteiTorokuData;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果取込み（OCR）のコントローラクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
public class NinteiOcrDbT5210Handler {

    private static final RString 居宅 = new RString("0");
    private static final RString 介護老人福祉施設 = new RString("1");
    private static final RString 介護老人保健施設 = new RString("2");
    private static final RString 介護療養型医療施設 = new RString("3");
    private static final RString 認知症対応型共同生活介護適用施設 = new RString("4");
    private static final RString 特定施設入居者生活介護適用施設 = new RString("5");
    private static final RString 医療保険適用療養病床 = new RString("6");
    private static final RString 療養病床以外 = new RString("7");
    private static final RString その他 = new RString("8");

    private List<RString> 施設利用_99A;
    private List<RString> 施設利用_02A;
    private List<RString> 施設利用_06A;
    private List<RString> 施設利用_09A;
    private List<RString> 施設利用_09B;

    /**
     * 認定調査票（概況調査）施設利用を更新します。
     *
     * @param dataList 施設利用
     * @param data CSVdata
     * @return List<NinteichosahyoShisetsuRiyo>
     */
    public List<NinteichosahyoShisetsuRiyo> updateDbT5210(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(data.get厚労省IF識別コード())) {
            施設利用_99A = new ArrayList<>();
            dataList = update施設利用_99A(dataList, data);
            dataList = set新規施設利用_99A(dataList, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(data.get厚労省IF識別コード())) {
            施設利用_02A = new ArrayList<>();
            dataList = update施設利用_02A(dataList, data);
            dataList = set新規施設利用_02A(dataList, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(data.get厚労省IF識別コード())) {
            施設利用_06A = new ArrayList<>();
            dataList = update施設利用_06A(dataList, data);
            dataList = set新規施設利用_06A(dataList, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(data.get厚労省IF識別コード())) {
            施設利用_09A = new ArrayList<>();
            dataList = update施設利用_09A(dataList, data);
            dataList = set新規施設利用_09A(dataList, data);
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(data.get厚労省IF識別コード())) {
            施設利用_09B = new ArrayList<>();
            dataList = update施設利用_09B(dataList, data);
            dataList = set新規施設利用_09B(dataList, data);
        }

        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> update施設利用_99A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        for (int i = 0; i < dataList.size(); i++) {
            NinteichosahyoShisetsuRiyo joho = dataList.get(i);
            if (GaikyoChosahyouNiteichosahyouSisetuRiy99A.居宅.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
                施設利用_99A.add(GaikyoChosahyouNiteichosahyouSisetuRiy99A.居宅.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人福祉施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
                施設利用_99A.add(GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人福祉施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人保健施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
                施設利用_99A.add(GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人保健施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護療養型医療施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
                施設利用_99A.add(GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護療養型医療施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy99A.その他の施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
                施設利用_99A.add(GaikyoChosahyouNiteichosahyouSisetuRiy99A.その他の施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> set新規施設利用_99A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        if (!施設利用_99A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy99A.居宅.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(GaikyoChosahyouNiteichosahyouSisetuRiy99A.居宅.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_99A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人福祉施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人福祉施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_99A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人保健施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護老人保健施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_99A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護療養型医療施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy99A.介護療養型医療施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_99A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy99A.その他の施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy99A.その他の施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> update施設利用_02A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        for (int i = 0; i < dataList.size(); i++) {
            NinteichosahyoShisetsuRiyo joho = dataList.get(i);
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.居宅.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.居宅.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人福祉施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人福祉施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人保健施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人保健施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護療養型医療施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護療養型医療施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.認知症対応型共同生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.認知症対応型共同生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.特定施設入所者生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.特定施設入所者生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養以外.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養以外.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy02A.その他の施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
                施設利用_02A.add(GaikyoChosahyouNiteichosahyouSisetuRiy02A.その他の施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> set新規施設利用_02A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.居宅.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(GaikyoChosahyouNiteichosahyouSisetuRiy02A.居宅.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人福祉施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人福祉施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人保健施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護老人保健施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護療養型医療施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.介護療養型医療施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.認知症対応型共同生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.認知症対応型共同生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.特定施設入所者生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.特定施設入所者生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養以外.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.医療機関_療養以外.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_02A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy02A.その他の施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.その他の施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> update施設利用_06A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        for (int i = 0; i < dataList.size(); i++) {
            NinteichosahyoShisetsuRiyo joho = dataList.get(i);
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.居宅.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.居宅.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人福祉施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人福祉施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人保健施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人保健施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護療養型医療施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護療養型医療施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.認知症対応型共同生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.認知症対応型共同生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.特定施設入所者生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.特定施設入所者生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養以外.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養以外.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy06A.その他の施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
                施設利用_06A.add(GaikyoChosahyouNiteichosahyouSisetuRiy06A.その他の施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> set新規施設利用_06A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.居宅.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(GaikyoChosahyouNiteichosahyouSisetuRiy06A.居宅.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人福祉施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人福祉施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人保健施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護老人保健施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護療養型医療施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.介護療養型医療施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.認知症対応型共同生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.認知症対応型共同生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.特定施設入所者生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.特定施設入所者生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養以外.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.医療機関_療養以外.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_06A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy06A.その他の施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.その他の施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> update施設利用_09A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        for (int i = 0; i < dataList.size(); i++) {
            NinteichosahyoShisetsuRiyo joho = dataList.get(i);
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.居宅.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.居宅.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人福祉施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人福祉施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人保健施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人保健施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護療養型医療施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護療養型医療施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.認知症対応型共同生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.認知症対応型共同生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.特定施設入所者生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.特定施設入所者生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養以外.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養以外.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09A.その他の施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
                施設利用_09A.add(GaikyoChosahyouNiteichosahyouSisetuRiy09A.その他の施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> set新規施設利用_09A(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.居宅.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(GaikyoChosahyouNiteichosahyouSisetuRiy09A.居宅.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人福祉施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人福祉施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人保健施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護老人保健施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護療養型医療施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.介護療養型医療施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.認知症対応型共同生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.認知症対応型共同生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.特定施設入所者生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.特定施設入所者生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養以外.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.医療機関_療養以外.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09A.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09A.その他の施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.その他の施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> update施設利用_09B(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        for (int i = 0; i < dataList.size(); i++) {
            NinteichosahyoShisetsuRiyo joho = dataList.get(i);
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.居宅.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.居宅.get連番());
                dataList.set(i, joho);
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人福祉施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人福祉施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人保健施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人保健施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護療養型医療施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護療養型医療施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.認知症対応型共同生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.認知症対応型共同生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.特定施設入所者生活介護適用施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.特定施設入所者生活介護適用施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養以外.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養以外.get連番());
                dataList.set(i, joho.modifiedModel());
            }
            if (GaikyoChosahyouNiteichosahyouSisetuRiy09B.その他の施設.get連番().equals(new RString(joho.get連番()))) {
                joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
                施設利用_09B.add(GaikyoChosahyouNiteichosahyouSisetuRiy09B.その他の施設.get連番());
                dataList.set(i, joho.modifiedModel());
            }
        }
        return dataList;
    }

    private List<NinteichosahyoShisetsuRiyo> set新規施設利用_09B(List<NinteichosahyoShisetsuRiyo> dataList, NinteiTorokuData data) {
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.居宅.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(GaikyoChosahyouNiteichosahyouSisetuRiy09B.居宅.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(居宅.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人福祉施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人福祉施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人福祉施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人保健施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護老人保健施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護老人保健施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護療養型医療施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.介護療養型医療施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(介護療養型医療施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.認知症対応型共同生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.認知症対応型共同生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(認知症対応型共同生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.特定施設入所者生活介護適用施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.特定施設入所者生活介護適用施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(特定施設入居者生活介護適用施設.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(医療保険適用療養病床.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養以外.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.医療機関_療養以外.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(療養病床以外.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        if (!施設利用_09B.contains(GaikyoChosahyouNiteichosahyouSisetuRiy09B.その他の施設.get連番())) {
            NinteichosahyoShisetsuRiyo joho = new NinteichosahyoShisetsuRiyo(new ShinseishoKanriNo(
                    data.get申請書管理番号()), data.get認定調査依頼履歴番号(), rStringToInt(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.その他の施設.get連番()));
            joho = joho.createBuilderForEdit().set施設利用フラグ(その他.equals(data.get施設利用の有無())).build();
            joho = joho.createBuilderForEdit().set厚労省IF識別コード(new Code(data.get厚労省IF識別コード())).build();
            dataList.add(joho);
        }
        return dataList;
    }

    private int rStringToInt(RString サービスの状況_TMP) {
        return Integer.parseInt(サービスの状況_TMP.toString());
    }

}
