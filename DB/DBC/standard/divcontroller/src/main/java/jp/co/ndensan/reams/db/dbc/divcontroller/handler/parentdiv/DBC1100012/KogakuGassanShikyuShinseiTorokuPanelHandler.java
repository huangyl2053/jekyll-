/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyushinseitoroku.ShinseishoJohoResult;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShinseiKbn;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyushinseitoroku.ShinseishoJohoSearchParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.KogakuGassanShikyuShinseiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.dgTorokuSearchResult_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kogakugassan.KogakuGassanShikyuShinseiToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBCMN61001-12_高額合算支給申請書登録(申請情報検索)のHandlerです。
 *
 * @reamsid_L DBC-2040-010 lihang
 */
public class KogakuGassanShikyuShinseiTorokuPanelHandler {

    private final KogakuGassanShikyuShinseiTorokuPanelDiv div;

    private static final RString 一 = new RString("1");
    private static final RString 二 = new RString("2");
    private static final int 六 = 6;
    private static final int 平成二十年度 = 2007;
    private static final RString 九十九 = new RString("99");
    private static final RString ゼロ = new RString("00");
    private static final int ゼロ一 = 0;
    private static final RString キー = new RString("key0");
    private static final RString 計算 = new RString("txtKeisan");
    private static final RString 送信 = new RString("txtSoshin");
    private static final RString 空 = new RString("　");
    private static final RString 単一市町村モード = new RString("単一市町村モード");
    private static final RString 広域市町村モード = new RString("広域市町村モード");

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelHandler
     */
    public KogakuGassanShikyuShinseiTorokuPanelHandler(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {

        Map<RString, List<KoikiZenShichosonJoho>> map = KogakuGassanShikyuShinseiToroku.createInstance().getHokensyaBango();
        List<KeyValueDataSource> seishoSeiriBangoList = new ArrayList<>();
        List<KeyValueDataSource> shiChoSonList = new ArrayList<>();
        seishoSeiriBangoList.add(new KeyValueDataSource(キー, RString.EMPTY));
        RString モード = RString.EMPTY;
        if (map != null && map.containsKey(単一市町村モード) && map.get(単一市町村モード) != null && !map.get(単一市町村モード).isEmpty()) {
            RString 市町村識別ID = map.get(単一市町村モード).get(0).get市町村識別ID();
            seishoSeiriBangoList.add(new KeyValueDataSource(map.get(単一市町村モード).get(0).get証記載保険者番号().getColumnValue(),
                    map.get(単一市町村モード).get(0).get証記載保険者番号().getColumnValue()));
            shiChoSonList.add(new KeyValueDataSource(市町村識別ID, 市町村識別ID.concat(空).
                    concat(map.get(単一市町村モード).get(0).get市町村名称())));
            モード = 単一市町村モード;
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().setDataSource(seishoSeiriBangoList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setDataSource(seishoSeiriBangoList);
        } else if (map != null && map.containsKey(広域市町村モード) && map.get(広域市町村モード) != null && !map.get(広域市町村モード).isEmpty()) {
            shiChoSonList.add(new KeyValueDataSource(キー, RString.EMPTY));
            List<RString> keyList = new ArrayList();
            List<RString> keyList2 = new ArrayList();
            for (KoikiZenShichosonJoho chosonJoho : map.get(広域市町村モード)) {
                RString 市町村識別ID = chosonJoho.get市町村識別ID();
                if (!keyList.contains(chosonJoho.get証記載保険者番号().getColumnValue())) {
                    keyList.add(chosonJoho.get証記載保険者番号().getColumnValue());
                    seishoSeiriBangoList.add(new KeyValueDataSource(chosonJoho.get証記載保険者番号().getColumnValue(),
                            chosonJoho.get証記載保険者番号().getColumnValue()));
                }
                if (!keyList2.contains(市町村識別ID)) {
                    keyList2.add(市町村識別ID);
                    shiChoSonList.add(new KeyValueDataSource(市町村識別ID, 市町村識別ID.concat(空).concat(chosonJoho.get市町村名称())));
                }
            }
            モード = 広域市町村モード;
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().setDataSource(seishoSeiriBangoList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().setSelectedIndex(0);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setDataSource(shiChoSonList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setSelectedIndex(0);
        } else {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setDataSource(Collections.EMPTY_LIST);
        }

        状態1(モード);
    }

    /**
     * 申請対象年度のメソッドです。
     */
    public void changeNendo() {

        RString newStr = new RString("4");
        RString 年度 = div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().getSelectedValue().
                remove(0).remove(0).insert(0, newStr.toString());
        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().getSelectedValue() != null) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango1().setValue(年度);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango1().setValue(年度);
        } else if (div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().getSelectedValue() == null) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango1().clearValue();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango1().clearValue();
        }
    }

    /**
     * 介護支給申請書整理番号CHKのメソッドです。
     */
    public void changeKaigoBango() {

        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango().getSelectedKeys()
                .equals(Collections.EMPTY_LIST)) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().setDisabled(true);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().setDisabled(true);
        } else {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().setDisabled(false);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().setDisabled(false);
        }
    }

    /**
     * 医療支給申請書整理番号CHKのメソッドです。
     */
    public void changeIryoBango() {

        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango().getSelectedKeys()
                .equals(Collections.EMPTY_LIST)) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().setDisabled(true);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().setDisabled(true);
        } else {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().setDisabled(false);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().setDisabled(false);
        }
    }

    /**
     * 情報検索ラジオボタン制御のメソッドです。
     */
    public void changerdbKensaku2() {
        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().getSelectedKey().equals(キー)) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().clearSelectedItem();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbHihokensyaJohoKensaku().setSelectedKey(キー);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiDaihyoshaShimei().clearValue();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiDaihyoshaShimei().setDisabled(true);
            List<RString> emptyList = new ArrayList<>();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().setSelectedItemsByKey(emptyList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().setDisabled(true);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihobango().setDisabled(false);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihokensyaShimei().setDisabled(false);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().setDisabled(false);
            List<RString> key = new ArrayList<>();
            key.add(キー);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().setSelectedItemsByKey(key);
        }
    }

    /**
     * 情報検索ラジオボタン制御のメソッドです。
     */
    public void changerdbKensaku1() {
        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbHihokensyaJohoKensaku().getSelectedKey().equals(キー)) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbHihokensyaJohoKensaku().clearSelectedItem();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().setSelectedKey(キー);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiDaihyoshaShimei().setDisabled(false);
            List<RString> key = new ArrayList();
            key.add(キー);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().setSelectedItemsByKey(key);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().setDisabled(false);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihobango().clearValue();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihokensyaShimei().clearValue();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihobango().setDisabled(true);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihokensyaShimei().setDisabled(true);
            List<RString> emptyList = new ArrayList();
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().setSelectedItemsByKey(emptyList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().setDisabled(true);
        }
    }

    /**
     * 「条件をクリアする」ボタンのメソッドです。
     *
     * @param メニューID RString
     */
    public void btnClear(RString メニューID) {

        initialize();
    }

    /**
     * 「検索する」ボタンのメソッドです。
     *
     * @param 申請状況 RString
     */
    public void btnKensaku(RString 申請状況) {
        HokenshaNo 市町村コード = new HokenshaNo(div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().getSelectedKey());
        if (市町村コード.equals(new HokenshaNo(キー))) {
            市町村コード = null;
        }
        FlexibleYear 申請対象年度 = new FlexibleYear(div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().getSelectedKey());
        FlexibleDate 申請日 = null;
        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getFromValue() != null) {
            申請日 = new FlexibleDate(
                    div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getFromValue().toString());
        }
        FlexibleDate 申請日To = null;
        if (div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getToValue() != null) {
            申請日To = new FlexibleDate(
                    div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getToValue().toString());
        }
        RString 介護支給申請書整理番号1 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango1().getValue();
        RString 介護支給申請書整理番号2 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango2().getValue();
        RString 介護支給申請書整理番号3 = div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().getSelectedValue();
        RString 介護支給申請書整理番号4 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().getValue();
        int length2 = 介護支給申請書整理番号4.length();
        if (!RString.isNullOrEmpty(介護支給申請書整理番号4) && length2 < 六) {
            介護支給申請書整理番号4.padZeroToLeft(六 - length2);
        }
        RString 介護支給申請書整理番号list
                = 介護支給申請書整理番号1.insert(介護支給申請書整理番号1.length() - 1, 介護支給申請書整理番号2.toString());
        介護支給申請書整理番号list = 介護支給申請書整理番号list.insert(介護支給申請書整理番号list.length() - 1, 介護支給申請書整理番号3.toString());
        介護支給申請書整理番号list = 介護支給申請書整理番号list.insert(介護支給申請書整理番号list.length() - 1, 介護支給申請書整理番号4.toString());
        if (!div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango().isAllSelected()) {
            介護支給申請書整理番号list = null;
        }
        RString 医療支給申請書整理番号1 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango1().getValue();
        RString 医療支給申請書整理番号2 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango2().getValue();
        RString 医療支給申請書整理番号3 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().getValue();
        RString 医療支給申請書整理番号4 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().getValue();
        int length = 医療支給申請書整理番号4.length();
        if (!RString.isNullOrEmpty(医療支給申請書整理番号4) && length < 六) {
            医療支給申請書整理番号4 = 医療支給申請書整理番号4.padZeroToLeft(六 - length);
        }
        RString 医療支給申請書整理番号list
                = 医療支給申請書整理番号1.insert(医療支給申請書整理番号1.length() - 1, 医療支給申請書整理番号2.toString());
        医療支給申請書整理番号list = 医療支給申請書整理番号list.insert(医療支給申請書整理番号list.length() - 1, 医療支給申請書整理番号3.toString());
        医療支給申請書整理番号list = 医療支給申請書整理番号list.insert(医療支給申請書整理番号list.length() - 1, 医療支給申請書整理番号4.toString());
        if (!div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango().isAllSelected()) {
            医療支給申請書整理番号list = null;
        }
        boolean 申請基本情報検索有無 = !div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().getSelectedKey().isEmpty();
        List<RString> 前方一致list = new ArrayList<>();
        前方一致list.add(キー);
        boolean 申請代表者氏名前方一致 = div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().getSelectedKeys().equals(前方一致list);
        RString 申請代表者氏名 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiDaihyoshaShimei().getValue();
        boolean 被保険者情報検索有無 = !div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbHihokensyaJohoKensaku().getSelectedKey().isEmpty();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihobango().getValue());
        boolean 被保険者氏名前方一致 = div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().getSelectedKeys().equals(前方一致list);
        RString 被保険者氏名 = div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihokensyaShimei().getValue();
        ShinseishoJohoSearchParameter pama = new ShinseishoJohoSearchParameter(
                申請状況, 市町村コード, 申請対象年度, 申請日, 申請日To, 介護支給申請書整理番号list, 医療支給申請書整理番号list,
                申請基本情報検索有無, 申請代表者氏名前方一致, 申請代表者氏名, 被保険者情報検索有無, 被保険者番号,
                被保険者氏名前方一致, 被保険者氏名, null);
        List<ShinseishoJohoResult> list = KogakuGassanShikyuShinseiToroku.createInstance().getShinseishoJoho(pama);
        if (list == null || list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        } else {
            List<dgTorokuSearchResult_Row> rowList = new ArrayList<>();
            addRow(list, rowList);
            div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().setDataSource(rowList);

            状態2(申請状況);
        }
    }

    private void addRow(List<ShinseishoJohoResult> list, List<dgTorokuSearchResult_Row> rowList) throws IllegalArgumentException {
        for (ShinseishoJohoResult shoJohoResult : list) {
            dgTorokuSearchResult_Row row = new dgTorokuSearchResult_Row();
            if (shoJohoResult.get高額合算申請書().get支給申請書整理番号() != null) {
                row.setTxtShikyuShinseishoNo(shoJohoResult.get高額合算申請書().get支給申請書整理番号());
            }
            if (!RString.isNullOrEmpty(shoJohoResult.get高額合算申請書().get支給申請区分())) {
                row.setTxtShinseiKubun(KaigoGassan_ShinseiKbn.toValue(shoJohoResult.get高額合算申請書().get支給申請区分()).get名称());
            }
            if (shoJohoResult.get高額合算申請書().get支給申請書情報送付年月() != null) {
                row.getTxtSoshin().setValue(new FlexibleDate(shoJohoResult.get高額合算申請書().get支給申請書情報送付年月().toDateString()));
            }
            if (shoJohoResult.get高額合算申請書().get自己負担額計算年月() != null) {
                row.getTxtKeisan().setValue(new FlexibleDate(shoJohoResult.get高額合算申請書().get自己負担額計算年月().toDateString()));
            }
            if (shoJohoResult.get高額合算申請書().get申請代表者氏名() != null) {
                row.setTxtShinseiDaihyoshaName(shoJohoResult.get高額合算申請書().get申請代表者氏名().getColumnValue());
            }
            if (shoJohoResult.get高額合算申請書().get申請年月日() != null) {
                row.getTxtShinseiYMD().setValue(shoJohoResult.get高額合算申請書().get申請年月日());
            }
            if (shoJohoResult.get高額合算申請書().get申請代表者郵便番号() != null) {
                row.setTxtBango(shoJohoResult.get高額合算申請書().get申請代表者郵便番号().getColumnValue());
            }
            if (shoJohoResult.get高額合算申請書().get申請代表者住所() != null) {
                row.setTxtSyusyou(shoJohoResult.get高額合算申請書().get申請代表者住所());
            }
            if (shoJohoResult.get高額合算申請書().get申請代表者電話番号() != null) {
                row.setTxtTelbanngo(shoJohoResult.get高額合算申請書().get申請代表者電話番号().getColumnValue());
            }
            row.setTxtHihokenshaNo(shoJohoResult.get高額合算申請書().get被保険者番号().value());
            row.setTxtHihokenshaName(shoJohoResult.get被保険者名().getColumnValue());
            row.setTxtTaishoNendo(shoJohoResult.get高額合算申請書().get対象年度().toDateString());
            row.setTxtShikibetuCode(shoJohoResult.get識別コード().getColumnValue());
            row.setTxtHokenshaNo(shoJohoResult.get高額合算申請書().get保険者番号().value());
            row.setTxtSeiriNo(shoJohoResult.get高額合算申請書().get整理番号());
            row.setTxtRirekiNo(new RString(shoJohoResult.get高額合算申請書().get履歴番号().toString()));
            rowList.add(row);
        }
    }

    private void 状態1(RString モード) {
        final Integer eight = 8;
        final Integer seven = 7;
        div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().setDisabled(true);
        if (モード.equals(単一市町村モード)) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setDisplayNone(true);

        } else if (モード.equals(広域市町村モード)) {
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setDisplayNone(false);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShiChoSon().setSelectedIndex(ゼロ一);

        }
        div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().setDisabled(false);
        RDate システム日付 = RDate.getNowDate();
        List<KeyValueDataSource> nenDoList = new ArrayList<>();
        if (システム日付.getMonthValue() >= eight) {
            for (int i = 1; i <= システム日付.minusYear(1).getYearValue() - 平成二十年度; i++) {
                nenDoList.add(new KeyValueDataSource(システム日付.minusYear(i).getNendo().toDateString(),
                        システム日付.minusYear(i).getYear().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString()));
            }
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().setDataSource(nenDoList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().setSelectedValue(システム日付.minusYear(1).getYear()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
        } else if (システム日付.getMonthValue() <= seven) {
            for (int i = 2; i <= システム日付.minusYear(1).getYearValue() - 平成二十年度; i++) {
                nenDoList.add(new KeyValueDataSource(システム日付.minusYear(i).getNendo().toDateString(),
                        システム日付.minusYear(i).getYear().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString()));
            }
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().setDataSource(nenDoList);
            div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlShinseiTaisyoNendo().setSelectedValue(システム日付.minusYear(2).getYear()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString());
        }
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().clearFromValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().clearToValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().setFromDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().setToDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango().setSelectedItemsByKey(Collections.EMPTY_LIST);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango1().setDisabled(true);
        changeNendo();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango2().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango2().setValue(九十九);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().clearValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango().setSelectedItemsByKey(Collections.EMPTY_LIST);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango1().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango2().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango2().setValue(ゼロ);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().clearValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().clearValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().clearSelectedItem();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbShinseiKihonJohoKensaku().setSelectedKey(キー);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiDaihyoshaShimei().clearValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiDaihyoshaShimei().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihobango().clearValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihobango().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihokensyaShimei().clearValue();
        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtHihokensyaShimei().setDisabled(true);

        List<RString> list = new ArrayList<>();
        list.add(キー);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().setSelectedItemsByKey(list);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi1().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().setDisabled(true);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getChkZempoItchi2().setSelectedItemsByKey(list);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getRdbHihokensyaJohoKensaku().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getBtnClear().setDisabled(false);
        div.getKogakuGassanShikyuShinseiTorokuSearch().getBtnKensaku().setDisabled(false);
    }

    private void 状態2(RString 申請状況) {

        if (申請状況.equals(一)) {
            div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().getGridSetting().getColumn(送信).setVisible(true);
        } else {
            div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().getGridSetting().getColumn(送信).setVisible(false);
        }
        if (申請状況.equals(二)) {
            div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().getGridSetting().getColumn(計算).setVisible(true);
        } else {
            div.getKogakuGassanShikyuShinseiTorokuSearchResult().getDgTorokuSearchResult().getGridSetting().getColumn(計算).setVisible(false);
        }
    }
}
