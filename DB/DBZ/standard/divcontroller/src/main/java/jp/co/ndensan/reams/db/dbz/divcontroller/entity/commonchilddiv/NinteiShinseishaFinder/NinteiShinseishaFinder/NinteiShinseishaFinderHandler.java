/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.KanryoInfoPhase;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「条件検索画面」のhandlerクラスです。
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class NinteiShinseishaFinderHandler {

    private final NinteiShinseishaFinderDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 条件検索画面div
     */
    public NinteiShinseishaFinderHandler(NinteiShinseishaFinderDiv div) {
        this.div = div;
    }

    /**
     * 条件検索画面初期化処理です。
     */
    public void initialize() {
        div.getDdlHokenshaNumber().loadHokenshaList(GyomuBunrui.介護認定);
        // TODO  内部QA：88 Redmine：#70702 支所情報取得につきましては、現在設計を追加で行っています。実装におかれましては、TODOとして進めてください。
        List<KeyValueDataSource> ddlShichosonCode = new ArrayList<>();
        ddlShichosonCode.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        div.getDdlShichosonCode().setDataSource(ddlShichosonCode);
        div.getDdlShichosonCode().setDisplayNone(true); // 暫定対応
        List<KeyValueDataSource> ddlShinseijiShinseiKubun = new ArrayList<>();
        ddlShinseijiShinseiKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinteiShinseiShinseijiKubunCode code : NinteiShinseiShinseijiKubunCode.values()) {
            ddlShinseijiShinseiKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShinseijiShinseiKubun().setDataSource(ddlShinseijiShinseiKubun);
        List<RString> keys = new ArrayList<>();
        div.getTxtHihokenshaNumber().clearValue();
        div.getDdlShichosonCode().setSelectedIndex(0);
        div.getTxtHihokenshaName().clearValue();
        div.getDdlHihokenshaNameMatchType().setSelectedIndex(0);
        div.getChkMinashiFlag().setSelectedItemsByKey(keys);
        div.getTxtNinteiShinseiDateFrom().clearValue();
        div.getTxtNinteiShinseiDateTo().clearValue();
        div.getTxtBirthDateFrom().clearValue();
        div.getTxtBirthDateTO().clearValue();
        div.getDdlShinseijiShinseiKubun().setSelectedIndex(0);
        div.getChkSeibetsu().setSelectedItemsByKey(keys);

        List<KeyValueDataSource> ddlNinteiChosaNinchido = new ArrayList<>();
        ddlNinteiChosaNinchido.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinchishoNichijoSeikatsuJiritsudoCode code : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            ddlNinteiChosaNinchido.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlNinteiChosaNinchido().setDataSource(ddlNinteiChosaNinchido);

        List<KeyValueDataSource> ddlShujiIkubun = new ArrayList<>();
        ddlShujiIkubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (IshiKubunCode code : IshiKubunCode.values()) {
            ddlShujiIkubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShujiIkubun().setDataSource(ddlShujiIkubun);
        div.getShosaiJoken().setIsOpen(false);
        init二次判定結果DDL();
        initKihonJoho();
        initNinteiChosa();
        initShujiiJoho();
        initIchijiHantei();
        initIchiGoHantei();
        initKaigoNinteiShinsakaiJoho();
        initZenkaiJoho();
        initKanryoJoho();
    }

    private void init二次判定結果DDL() {
        div.getDdlNijiHanteiKekka().setDataSource(dataSourceOf二次判定結果From厚労省IFコード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3));
        div.getDdlNijiHanteiKekka().setSelectedIndex(0);
        div.getDdlZenkaiNijiHanteiKekka().setDataSource(dataSourceOf二次判定結果From厚労省IFコード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3));
        div.getDdlZenkaiNijiHanteiKekka().setSelectedIndex(0);
    }

    private KoroshoIfShikibetsuCode get厚労省IF識別コードOrNull() {
        RString key = div.getDdlKoroshoShikibetsuCode().getSelectedKey();
        try {
            return key.isEmpty() ? null : KoroshoIfShikibetsuCode.toValue(key);
        } catch (IllegalArgumentException | NullPointerException e) {
            return null;
        }
    }

    /**
     * 指定の厚労省IF識別コードから、二次判定結果DDLを初期化します。
     *
     * @param koroshoIFCode 厚労省IF識別コード
     */
    public void set二次判定結果DDL() {
        KoroshoIfShikibetsuCode koroshoIFCode = get厚労省IF識別コードOrNull();
        if (koroshoIFCode == null) {
            _set二次判定結果DDL(dataSourceOf二次判定結果From厚労省IFコード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3));
            _set前回二次判定結果DDL(dataSourceOf二次判定結果From厚労省IFコード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3));
        } else {
            _set二次判定結果DDL(dataSourceOf二次判定結果From厚労省IFコード(koroshoIFCode));
            _set前回二次判定結果DDL(dataSourceOf二次判定結果From厚労省IFコード(koroshoIFCode));
        }
    }

    private void _set二次判定結果DDL(List<KeyValueDataSource> dataSource) {
        RString key1 = findKey(div.getDdlNijiHanteiKekka().getSelectedKey(), dataSource);
        div.getDdlNijiHanteiKekka().setDataSource(dataSource);
        if (key1.isEmpty()) {
            div.getDdlNijiHanteiKekka().setSelectedIndex(0);
        } else {
            div.getDdlNijiHanteiKekka().setSelectedKey(key1);
        }
    }

    private void _set前回二次判定結果DDL(List<KeyValueDataSource> dataSource) {
        RString key2 = findKey(div.getDdlZenkaiNijiHanteiKekka().getSelectedKey(), dataSource);
        div.getDdlZenkaiNijiHanteiKekka().setDataSource(new ArrayList<>(dataSource));
        if (key2.isEmpty()) {
            div.getDdlZenkaiNijiHanteiKekka().setSelectedIndex(0);
        } else {
            div.getDdlZenkaiNijiHanteiKekka().setSelectedKey(key2);
        }
    }

    private static RString findKey(RString nowSelected, List<KeyValueDataSource> dataSource) {
        for (KeyValueDataSource kvs : dataSource) {
            if (Objects.equals(nowSelected, kvs.getKey())) {
                return nowSelected;
            }
        }
        return RString.EMPTY;
    }

    private static List<KeyValueDataSource> dataSourceOf二次判定結果From厚労省IFコード(KoroshoIfShikibetsuCode koroshoIFCode) {
        List<KeyValueDataSource> list = new ArrayList<>();
        list.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (IYokaigoJotaiKubun value : YokaigoJotaiKubunSupport.values(koroshoIFCode)) {
            list.add(new KeyValueDataSource(value.getCode(), value.getName()));
        }
        return list;
    }

    /**
     * 詳細条件パネルOPEN状態の処理です。
     */
    public void openShosaiJoken() {
        div.getShosaiJoken().setIsOpen(true);
        div.getKihonJoho().setIsOpen(true);
        div.getNinteiChosa().setIsOpen(false);
        div.getShujiiJoho().setIsOpen(false);
        div.getIchijiHantei().setIsOpen(false);
        div.getIchiGoHantei().setIsOpen(false);
        div.getKaigoNinteiShinsakaiJoho().setIsOpen(false);
        div.getZenkaiJoho().setIsOpen(false);
        div.getSonotaJoho().setIsOpen(false);
        div.getKanryoJoho().setIsOpen(false);
    }

    /**
     * 詳細条件の認定調査パネルOPEN状態の処理です。
     */
    public void openNinteiChosa() {
        div.getShosaiJoken().setIsOpen(true);
        div.getNinteiChosa().setIsOpen(true);
    }

    /**
     * 詳細条件の主治医情報パネルOPEN状態の処理です。
     */
    public void openShujiiJoho() {
        div.getShosaiJoken().setIsOpen(true);
        div.getShujiiJoho().setIsOpen(true);
    }

    /**
     * 詳細条件の一次判定パネルOPEN状態の処理です。
     */
    public void openIchijiHantei() {
        div.getShosaiJoken().setIsOpen(true);
        div.getIchijiHantei().setIsOpen(true);
    }

    /**
     * 詳細条件の1.5次判定パネルOPEN状態の処理です。
     */
    public void openIchiGoHantei() {
        div.getShosaiJoken().setIsOpen(true);
        div.getIchiGoHantei().setIsOpen(true);
    }

    /**
     * 詳細条件の介護認定審査会パネルOPEN状態の処理です。
     */
    public void openKaigoNinteiShinsakaiJoho() {
        div.getShosaiJoken().setIsOpen(true);
        div.getKaigoNinteiShinsakaiJoho().setIsOpen(true);
        set二次判定結果DDL();
    }

    /**
     * 詳細条件の介護認定審査会パネルOPEN状態の処理です。
     */
    public void openZenkaiJoho() {
        div.getShosaiJoken().setIsOpen(true);
        div.getZenkaiJoho().setIsOpen(true);
        set二次判定結果DDL();
    }

    /**
     * 詳細条件のその他情報パネルOPEN状態の処理です。
     */
    public void openSonotaJoho() {
        div.getShosaiJoken().setIsOpen(true);
        div.getSonotaJoho().setIsOpen(true);
        div.getTxtShinseiKeikaNissu().clearFromValue();
        div.getTxtShinseiKeikaNissu().clearToValue();
        div.getCcdGeninShikkan().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.原因疾患コード.getコード());
    }

    /**
     * 詳細条件の完了情報パネルOPEN状態の処理です。
     */
    public void openKanryoJoho() {
        div.getShosaiJoken().setIsOpen(true);
        div.getKanryoJoho().setIsOpen(true);
    }

    private void initKihonJoho() {
        List<KeyValueDataSource> ddlHihokenshaKubun = new ArrayList<>();
        ddlHihokenshaKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (HihokenshaKubunCode code : HihokenshaKubunCode.values()) {
            ddlHihokenshaKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlHihokenshaKubun().setDataSource(ddlHihokenshaKubun);

        List<KeyValueDataSource> ddlHoreiShinseiji = new ArrayList<>();
        ddlHoreiShinseiji.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinteiShinseiHoreiCode code : NinteiShinseiHoreiCode.values()) {
            ddlHoreiShinseiji.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlHoreiShinseiji().setDataSource(ddlHoreiShinseiji);

        List<KeyValueDataSource> ddlShoriKubun = new ArrayList<>();
        ddlShoriKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ShoriJotaiKubun code : ShoriJotaiKubun.values()) {
            ddlShoriKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShoriKubun().setDataSource(ddlShoriKubun);

        List<KeyValueDataSource> ddlKoroshoShikibetsuCode = new ArrayList<>();
        ddlKoroshoShikibetsuCode.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (KoroshoIfShikibetsuCode code : KoroshoIfShikibetsuCode.values()) {
            ddlKoroshoShikibetsuCode.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlKoroshoShikibetsuCode().setDataSource(ddlKoroshoShikibetsuCode);

        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                FlexibleDate.getNowDate());
        List<KeyValueDataSource> chikuDataSource = new ArrayList<>();
        chikuDataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (UzT0007CodeEntity codeEntity : codeList) {
            chikuDataSource.add(new KeyValueDataSource(codeEntity.getコード().getKey(), codeEntity.getコード名称()));
        }
        div.getDdlChiku().setDataSource(chikuDataSource);

        div.getDdlHihokenshaKubun().setSelectedIndex(0);
        div.getDdlHoreiShinseiji().setSelectedIndex(0);
        div.getDdlShoriKubun().setSelectedIndex(0);
        div.getDdlKoroshoShikibetsuCode().setSelectedIndex(0);
        div.getDdlChiku().setSelectedIndex(0);
        div.getTxtYubinNo().clearValue();
        div.getRadShisetsuNyusho().setSelectedKey(new RString("key1"));

    }

    private void initNinteiChosa() {
        List<KeyValueDataSource> ddlChosaJisshiBasho = new ArrayList<>();
        ddlChosaJisshiBasho.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosaJisshiBashoCode code : ChosaJisshiBashoCode.values()) {
            ddlChosaJisshiBasho.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlChosaJisshiBasho().setDataSource(ddlChosaJisshiBasho);

        List<KeyValueDataSource> ddlChosaKubun = new ArrayList<>();
        ddlChosaKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ChosaKubun code : ChosaKubun.values()) {
            ddlChosaKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlChosaKubun().setDataSource(ddlChosaKubun);

        List<KeyValueDataSource> ddlNinteiChosaNetakirido = new ArrayList<>();
        ddlNinteiChosaNetakirido.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ShogaiNichijoSeikatsuJiritsudoCode code : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            ddlNinteiChosaNetakirido.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlNinteiChosaNetakirido().setDataSource(ddlNinteiChosaNetakirido);

        div.getTxtNinteiChosaItakusakiName().clearValue();
        div.getTxtNinteiChosainName().clearValue();
        div.getDdlChosaJisshiBasho().setSelectedIndex(0);
        div.getDdlChosaKubun().setSelectedIndex(0);
        div.getTxtChosaJisshiDateFrom().clearValue();
        div.getTxtChosaJisshiDateTo().clearValue();
        div.getDdlNinteiChosaNetakirido().setSelectedIndex(0);
        div.getDdlNinteiChosaNinchido().setSelectedIndex(0);
    }

    private void initShujiiJoho() {
        List<KeyValueDataSource> ddlShujiJohoNetakirido = new ArrayList<>();
        ddlShujiJohoNetakirido.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ShogaiNichijoSeikatsuJiritsudoCode code : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            ddlShujiJohoNetakirido.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShujiJohoNetakirido().setDataSource(ddlShujiJohoNetakirido);

        List<KeyValueDataSource> ddlShujiJohoNinchido = new ArrayList<>();
        ddlShujiJohoNinchido.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinchishoNichijoSeikatsuJiritsudoCode code : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            ddlShujiJohoNinchido.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShujiJohoNinchido().setDataSource(ddlShujiJohoNinchido);

        div.getTxtShujiiIryokikanName().clearValue();
        div.getTxtShujiiName().clearValue();
        div.getDdlShujiIkubun().setSelectedIndex(0);
        div.getTxtIkenshoKinyuDateFrom().clearValue();
        div.getTxtIkenshoKinyuDateTo().clearValue();
        div.getDdlShujiJohoNetakirido().setSelectedIndex(0);
        div.getDdlShujiJohoNinchido().setSelectedIndex(0);
    }

    private void initIchijiHantei() {
        List<KeyValueDataSource> ddlIchijiHanteiKekka = new ArrayList<>();
        ddlIchijiHanteiKekka.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (IchijiHanteiKekkaCode09 code : IchijiHanteiKekkaCode09.values()) {
            ddlIchijiHanteiKekka.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlIchijiHanteiKekka().setDataSource(ddlIchijiHanteiKekka);
        div.getTxtIchijiHanteiDateFrom().clearValue();
        div.getTxtIchijiHanteiDateTo().clearValue();
        div.getDdlIchijiHanteiKekka().setSelectedIndex(0);
    }

    private void initIchiGoHantei() {
        List<KeyValueDataSource> ddlIchiGohanteiKekka = new ArrayList<>();
        ddlIchiGohanteiKekka.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (IchijiHanteiKekkaCode09 code : IchijiHanteiKekkaCode09.values()) {
            ddlIchiGohanteiKekka.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlIchiGohanteiKekka().setDataSource(ddlIchiGohanteiKekka);
        div.getTxtIchiGoHanteiDateFrom().clearValue();
        div.getTxtIchiGoHanteiDateTo().clearValue();
        div.getDdlIchiGohanteiKekka().setSelectedIndex(0);
    }

    private void initKaigoNinteiShinsakaiJoho() {
        div.getTxtNinteiYukoKikan().clearValue();
        div.getTxtCheckDay().clearValue();
        div.getTxtNinteiYukoKaishiDateFrom().clearValue();
        div.getTxtNinteiYukoKaishiDateTo().clearValue();
        div.getTxtNinteiYukoShuryoDateFrom().clearValue();
        div.getTxtNinteiYukoShuryoDate().clearValue();
        div.getTxtNijiHanteiDateFrom().clearValue();
        div.getTxtNijiHnateiDateTo().clearValue();
        div.getTxtKaisaiDateFrom().clearValue();
        div.getTxtKaisaiDateTo().clearValue();
        div.getTxtKaisaiNumberStart().clearValue();
        div.getTxtKaisaiNumberEnd().clearValue();
    }

    private void initZenkaiJoho() {
        div.getTxtZenkaiNinteiChosaItakusakiName().clearValue();
        div.getTxtZenkaiShujiiIryokikanName().clearValue();
        div.getTxtZenkaiNinteiYukoKikan().clearValue();
        div.getTxtZenkaiYukoKaishiDateFrom().clearValue();
        div.getTxtZenkaiYukoKaishiDateTo().clearValue();
    }

    private void initKanryoJoho() {
        List<KeyValueDataSource> ddlNowPhase = new ArrayList<>();
        ddlNowPhase.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (KanryoInfoPhase code : KanryoInfoPhase.values()) {
            ddlNowPhase.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlNowPhase().setDataSource(ddlNowPhase);
        div.getDdlNowPhase().setSelectedIndex(0);
        List<RString> keys = new ArrayList<>();
        div.getChkShoriJotai().setDisabled(true);
        div.getChkShoriJotai().setSelectedItemsByKey(keys);
        div.getChkKoshinTaishoChushutsu().setSelectedItemsByKey(keys);
        div.getChkIchijiHantei().setSelectedItemsByKey(keys);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(keys);
        div.getChkMasking().setSelectedItemsByKey(keys);
        div.getChkChosaIrai().setSelectedItemsByKey(keys);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(keys);
        div.getChkIkenshoIrai().setSelectedItemsByKey(keys);
        div.getChkNijiHantei().setSelectedItemsByKey(getKeySelectingLastOnly(div.getChkNijiHantei()));
        div.getChkChosaNyushu().setSelectedItemsByKey(keys);
        div.getChkTsuchiShori().setSelectedItemsByKey(keys);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(keys);
        div.getChkGetsureiShori().setSelectedItemsByKey(keys);
    }

    private List<RString> getKeySelectingLastOnly(CheckBoxList cbl) {
        List<KeyValueDataSource> list = cbl.getDataSource();
        return list.isEmpty() ? Collections.<RString>emptyList()
               : Arrays.asList(list.get(list.size() - 1).getKey());
    }
}
