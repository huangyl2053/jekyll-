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
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishafinder.NinteiShinseishaFinderParameter;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「条件検索画面」のhandlerクラスです。
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class NinteiShinseishaFinderHandler {

    private final NinteiShinseishaFinderDiv div;
    private static final RString KEY0 = new RString("key0");
    private static final RString みなし2号申請チェックキー = new RString("True");
    private static final RString 処理状態完了 = new RString("key0");
    private static final RString 処理状態未完了 = new RString("key1");
    private static final RString MENUID_DBEMN21001 = new RString("DBEMN21001");
    private static final RString MENUID_DBEMN41005 = new RString("DBEMN41005");
    private static final RString MENUID_DBEMN42002 = new RString("DBEMN42002");
    private static final RString MENUID_DBEMN43001 = new RString("DBEMN43001");
    private static final RString MENUID_DBEMN72001 = new RString("DBEMN72001");
    private static final RString MENUID_DBEMN24001 = new RString("DBEMN24001");
    private static final RString MENUID_DBEMN31001 = new RString("DBEMN31001");
    private static final RString MENUID_DBEMN31002 = new RString("DBEMN31002");

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
        div.getCcdSaikinShorisha().initialize(div.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号());
        initialize共通処理();
        initTennyuNashi();
    }

    /**
     * パラメタの内容を初期状態としてセットした状態で初期化します。
     *
     * @param parameter パラメタ
     */
    public void initialize(NinteiShinseishaFinderParameter parameter) {
        if (parameter.get業務分類().equals(GyomuBunrui.介護認定)) {
            div.getDdlHokenshaNumber().loadHokenshaList(GyomuBunrui.介護認定);
        } else {
            div.getDdlHokenshaNumber().loadHokenshaList(GyomuBunrui.介護事務);
        }
        div.getCcdSaikinShorisha().initialize(div.getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号());
        initialize共通処理();
        initTennyuNashi();
        if (parameter.get業務分類() != null) {
            div.getDdlHokenshaNumber().loadHokenshaList(parameter.get業務分類());
        }
        set月例処理未完了(parameter.is月例処理未完了());
        setみなし2号申請チェック(parameter.isCheckedみなし2号申請());
        if (parameter.get証記載保険者番号() != null) {
            div.getDdlHokenshaNumber().setSelectedShoKisaiHokenshaNoIfExist(parameter.get証記載保険者番号());
        }
    }

    /**
     * 最近処理者を使用しない場合の検索画面初期化処理です。
     */
    public void initialize_最近処理者非表示() {
        div.getDdlHokenshaNumber().loadHokenshaList(GyomuBunrui.介護認定);
        div.getCcdSaikinShorisha().setVisible(false);
        div.getCcdSaikinShorisha().setDisplayNone(true);
        initialize共通処理();
    }

    public NinteiShinseishaFinderParameter getParameter() {
        NinteiShinseishaFinderParameter parameter = new NinteiShinseishaFinderParameter();

        return parameter;
    }

    /**
     * 初期化の共通処理です。
     */
    private void initialize共通処理() {
        // TODO  内部QA：88 Redmine：#70702 支所情報取得につきましては、現在設計を追加で行っています。実装におかれましては、TODOとして進めてください。
        List<KeyValueDataSource> ddlShichosonCode = new ArrayList<>();
        ddlShichosonCode.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        div.getDdlShichosonCode().setDataSource(ddlShichosonCode);
        div.getDdlShichosonCode().setDisplayNone(true); // 暫定対応
        List<RString> keys = new ArrayList<>();
        div.getTxtHihokenshaNumber().clearValue();
        div.getDdlShichosonCode().setSelectedIndex(0);
        div.getTxtHihokenshaName().clearValue();
        div.getDdlHihokenshaNameMatchType().setSelectedIndex(0);
        div.getChkMinashiFlag().setSelectedItemsByKey(keys);
        div.getTxtNinteiShinseiDateRange().clearFromValue();
        div.getTxtNinteiShinseiDateRange().clearToValue();
        div.getTxtBirthDateRange().clearFromValue();
        div.getTxtBirthDateRange().clearToValue();
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
        initDdlNowPhase();
        initDdlShinseijiShinseiKubun();
        clearKanryoJoho();
        setAbledKanryoJoho();
        init完了情報();
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
        div.getCcdGeninShikkan().clearDisplayedValues();
        div.getTxtShinseiKeikaNissu().clearFromValue();
        div.getTxtShinseiKeikaNissu().clearToValue();
        div.getCcdGeninShikkan().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.原因疾患コード.getコード());
    }

    /**
     * 詳細条件の完了情報パネルOPEN状態の処理です。
     */
    public void openKanryoJoho() {
        div.getKanryoJoho().setIsOpen(true);
    }

    /**
     * 入力された認定調査委託先からコード名称を取得します。
     */
    public void onBlur_txtNinteiChosaIinItakuSaki() {
        Code code = div.getTxtNinteiChosaIinItakuSaki().getDomain();
        if (code.isEmpty()) {
            div.getTxtNinteiChosaItakusakiName().clearValue();
            div.getTxtNinteiChosaInShimei().clearDomain();
            div.getTxtNinteiChosainName().clearValue();
            div.setHdnChosaItakusakiCode(RString.EMPTY);
            div.setHdnChosaShichosonCode(RString.EMPTY);
            div.setHdnChosainCode(RString.EMPTY);
        }
    }

    /**
     * 入力された認定調査員氏名からコード名称を取得します。
     */
    public void onBlur_txtNinteiChosaInShimei() {
        Code code = div.getTxtNinteiChosaInShimei().getDomain();
        if (code.isEmpty()) {
            div.getTxtNinteiChosainName().clearValue();
            div.setHdnChosainCode(RString.EMPTY);
        }
    }

    /**
     * 入力された主治医医療機関からコード名称を取得します。
     */
    public void onBlur_txtShujiiIryokikan() {
        Code code = div.getTxtShujiiIryokikan().getDomain();
        if (code.isEmpty()) {
            div.getTxtShujiiIryokikanName().clearValue();
            div.getTxtShujiiShimei().clearDomain();
            div.getTxtShujiiName().clearValue();
            div.setHdnShujiiIryokikanCode(RString.EMPTY);
            div.setHdnShujiiShichosonCode(RString.EMPTY);
            div.setHdnShujiiCode(RString.EMPTY);
        }
    }

    /**
     * 入力された主治医氏名からコード名称を取得します。
     */
    public void onBlur_txtShujiiShimei() {
        Code code = div.getTxtShujiiShimei().getDomain();
        if (code.isEmpty()) {
            div.getTxtShujiiName().clearValue();
            div.setHdnShujiiCode(RString.EMPTY);
        }
    }

    /**
     * 前回情報に入力された認定調査委託先からコード名称を取得します。
     */
    public void onBlur_txtZenkaiChosaItakusaki() {
        Code code = div.getTxtZenkaiChosaItakusaki().getDomain();
        if (code.isEmpty()) {
            div.getTxtZenkaiNinteiChosaItakusakiName().clearValue();
        }
    }

    /**
     * 前回情報に入力された主治医医療機関からコード名称を取得します
     */
    public void onBlur_txtZenkaiShujiiIryokikan() {
        Code code = div.getTxtZenkaiShujiiIryokikan().getDomain();
        if (code.isEmpty()) {
            div.getTxtZenkaiShujiiIryokikanName().clearValue();
        }
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

        List<RString> keyList = new ArrayList<>();
        keyList.add(new RString("key0"));
        keyList.add(new RString("key1"));
        div.getChkShisetsuNyusho().setSelectedItemsByKey(keyList);

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
        div.getTxtChosaJisshiDateRange().clearFromValue();
        div.getTxtChosaJisshiDateRange().clearToValue();
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
        div.getTxtIkenshoKinyuDateRange().clearFromValue();
        div.getTxtIkenshoKinyuDateRange().clearToValue();
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
        div.getTxtIchijiHanteiDateRange().clearFromValue();
        div.getTxtIchijiHanteiDateRange().clearToValue();
        div.getDdlIchijiHanteiKekka().setSelectedIndex(0);
    }

    private void initIchiGoHantei() {
        List<KeyValueDataSource> ddlIchiGohanteiKekka = new ArrayList<>();
        ddlIchiGohanteiKekka.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (IchijiHanteiKekkaCode09 code : IchijiHanteiKekkaCode09.values()) {
            ddlIchiGohanteiKekka.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlIchiGohanteiKekka().setDataSource(ddlIchiGohanteiKekka);
        div.getTxtIchiGoHanteiDateRange().clearFromValue();
        div.getTxtIchiGoHanteiDateRange().clearToValue();
        div.getDdlIchiGohanteiKekka().setSelectedIndex(0);
    }

    private void initKaigoNinteiShinsakaiJoho() {
        div.getTxtNinteiYukoKikan().clearValue();
        div.getTxtCheckDay().clearValue();
        div.getTxtNinteiYukoKaishiDateRange().clearFromValue();
        div.getTxtNinteiYukoKaishiDateRange().clearToValue();
        div.getTxtNinteiYukoShuryoDateRange().clearFromValue();
        div.getTxtNinteiYukoShuryoDateRange().clearToValue();
        div.getTxtNijiHanteiDateRange().clearFromValue();
        div.getTxtNijiHanteiDateRange().clearToValue();
        div.getTxtKaisaiDateRange().clearFromValue();
        div.getTxtKaisaiDateRange().clearToValue();
        div.getTxtKaisaiNumberStart().clearValue();
        div.getTxtKaisaiNumberEnd().clearValue();
    }

    private void initZenkaiJoho() {
        div.getTxtZenkaiNinteiChosaItakusakiName().clearValue();
        div.getTxtZenkaiShujiiIryokikanName().clearValue();
        div.getTxtZenkaiNinteiYukoKikan().clearValue();
        div.getTxtZenkaiYukoKaishiDateRange().clearFromValue();
        div.getTxtZenkaiYukoKaishiDateRange().clearToValue();
    }

    private void initDdlNowPhase() {
        List<KeyValueDataSource> ddlNowPhase = new ArrayList<>();
        ddlNowPhase.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (KanryoInfoPhase code : KanryoInfoPhase.values()) {
            ddlNowPhase.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlNowPhase().setDataSource(ddlNowPhase);
        div.getDdlNowPhase().setSelectedIndex(0);
    }

    private void initDdlShinseijiShinseiKubun() {
        List<KeyValueDataSource> ddlShinseijiShinseiKubun = new ArrayList<>();
        ddlShinseijiShinseiKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinteiShinseiShinseijiKubunCode code : NinteiShinseiShinseijiKubunCode.values()) {
            ddlShinseijiShinseiKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlShinseijiShinseiKubun().setDataSource(ddlShinseijiShinseiKubun);
        div.getDdlShinseijiShinseiKubun().setSelectedIndex(0);
    }

    private List<RString> getKeySelectingLastOnly(CheckBoxList cbl) {
        List<KeyValueDataSource> list = cbl.getDataSource();
        return list.isEmpty() ? Collections.<RString>emptyList()
                : Arrays.asList(list.get(list.size() - 1).getKey());
    }

    private void setみなし2号申請チェック(boolean checked) {
        List<RString> selectedItems = new ArrayList();
        if (checked) {
            selectedItems.add(みなし2号申請チェックキー);
        }
        div.getChkMinashiFlag().setSelectedItemsByKey(selectedItems);
    }

    private void set月例処理未完了(boolean is月例処理未完了) {
        if (is月例処理未完了 == true) {
            List<RString> selectedkeyMikann = new ArrayList<>();
            selectedkeyMikann.add(処理状態未完了);
            div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        }
    }

    public void setDisabledKanryoJoho() {
        div.getChkIchijiHantei().setDisabled(true);
        div.getChkShinseiUketsuke().setDisabled(true);
        div.getChkMasking().setDisabled(true);
        div.getChkChosaIrai().setDisabled(true);
        div.getChkShinsakaiToroku().setDisabled(true);
        div.getChkIkenshoIrai().setDisabled(true);
        div.getChkNijiHantei().setDisabled(true);
        div.getChkChosaNyushu().setDisabled(true);
        div.getChkIkenshoNyushu().setDisabled(true);
        div.getChkGetsureiShori().setDisabled(true);
    }

    public void setAbledKanryoJoho() {
        div.getChkKoshinTaishoChushutsu().setDisabled(true);
        div.getChkIchijiHantei().setDisabled(false);
        div.getChkShinseiUketsuke().setDisabled(false);
        div.getChkMasking().setDisabled(false);
        div.getChkChosaIrai().setDisabled(false);
        div.getChkShinsakaiToroku().setDisabled(false);
        div.getChkIkenshoIrai().setDisabled(false);
        div.getChkNijiHantei().setDisabled(false);
        div.getChkChosaNyushu().setDisabled(false);
        div.getChkTsuchiShori().setDisabled(true);
        div.getChkIkenshoNyushu().setDisabled(false);
        div.getChkGetsureiShori().setDisabled(false);

    }

    public void clearKanryoJoho() {
        List<RString> keys = new ArrayList<>();
        div.getChkKoshinTaishoChushutsu().setSelectedItemsByKey(keys);
        div.getChkIchijiHantei().setSelectedItemsByKey(keys);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(keys);
        div.getChkMasking().setSelectedItemsByKey(keys);
        div.getChkChosaIrai().setSelectedItemsByKey(keys);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(keys);
        div.getChkIkenshoIrai().setSelectedItemsByKey(keys);
        div.getChkNijiHantei().setSelectedItemsByKey(keys);
        div.getChkChosaNyushu().setSelectedItemsByKey(keys);
        div.getChkTsuchiShori().setSelectedItemsByKey(keys);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(keys);
        div.getChkGetsureiShori().setSelectedItemsByKey(keys);
    }

    public void set申請受付完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkShinseiUketsuke().setDisabled(false);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
    }

    public void set調査依頼完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkChosaIrai().setDisabled(false);
        div.getChkIkenshoIrai().setDisabled(false);
        div.getChkIkenshoNyushu().setDisabled(false);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set意見書依頼完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkIkenshoIrai().setDisabled(false);
        div.getChkChosaIrai().setDisabled(false);
        div.getChkChosaNyushu().setDisabled(false);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set調査入手完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkChosaNyushu().setDisabled(false);
        div.getChkIkenshoIrai().setDisabled(false);
        div.getChkIkenshoNyushu().setDisabled(false);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set意見書入手完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkIkenshoNyushu().setDisabled(false);
        div.getChkChosaIrai().setDisabled(false);
        div.getChkChosaNyushu().setDisabled(false);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set一次判定完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkIchijiHantei().setDisabled(false);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeySubete);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeySubete);
    }

    public void setマスキング完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkMasking().setDisabled(false);
        div.getChkMasking().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set審査会登録完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkShinsakaiToroku().setDisabled(false);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set二次判定完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkNijiHantei().setDisabled(false);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyKanryo);
    }

    public void set月例処理完了情報() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        List<RString> selectedkeySubete = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        selectedkeySubete.add(処理状態未完了);
        selectedkeySubete.add(処理状態完了);
        div.getChkGetsureiShori().setDisabled(false);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeySubete);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaNyushu().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkMasking().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoNyushu().setSelectedItemsByKey(selectedkeyKanryo);
    }

    /**
     * 転入申請を除く処理です。
     */
    private void setTennyuNashi() {
        List<RString> selectedTennyu = new ArrayList();
        selectedTennyu.add(KEY0);
        div.getChkTennyu().setSelectedItemsByKey(selectedTennyu);
        div.getChkTennyu().setDisabled(true);
        List<KeyValueDataSource> ddlShinseijiShinseiKubun = new ArrayList<>();
        ddlShinseijiShinseiKubun.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinteiShinseiShinseijiKubunCode code : NinteiShinseiShinseijiKubunCode.values()) {
            if (!NinteiShinseiShinseijiKubunCode.転入申請.equals(code)) {
                ddlShinseijiShinseiKubun.add(new KeyValueDataSource(code.getコード(), code.get名称()));
            }
        }
        div.getDdlShinseijiShinseiKubun().setDataSource(ddlShinseijiShinseiKubun);
        div.getDdlShinseijiShinseiKubun().setSelectedIndex(0);
        List<KeyValueDataSource> ddlNowPhase = new ArrayList<>();
        ddlNowPhase.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (KanryoInfoPhase code : KanryoInfoPhase.values()) {
            if (!KanryoInfoPhase.月例処理.equals(code)) {
                ddlNowPhase.add(new KeyValueDataSource(code.getコード(), code.get名称()));
            }
        }
        div.getDdlNowPhase().setDataSource(ddlNowPhase);
        div.getDdlNowPhase().setSelectedIndex(0);
    }

    private void initTennyuNashi() {
        List<RString> list = new ArrayList<>();
        div.getChkTennyu().setSelectedItemsByKey(list);
        RString menuID = ResponseHolder.getMenuID();
        if (MENUID_DBEMN41005.equals(menuID)
                || MENUID_DBEMN42002.equals(menuID)
                || MENUID_DBEMN43001.equals(menuID)
                || MENUID_DBEMN72001.equals(menuID)) {
            setTennyuNashi();
        }
    }

    public void init完了情報() {
        RString menuID = ResponseHolder.getMenuID();
        if (MENUID_DBEMN21001.equals(menuID)) {
            setKanryoJoho_DBEMN21001();
        } else if (MENUID_DBEMN24001.equals(menuID)) {
            setKanryoJoho_DBEMN24001();
        } else if (MENUID_DBEMN31001.equals(menuID)) {
            div.getDdlNowPhase().setSelectedKey(KanryoInfoPhase.申請受付.getコード());
            set申請受付完了情報();
            setKanryoJoho_DBEMN31001();
        } else if (MENUID_DBEMN41005.equals(menuID)) {
            div.getDdlNowPhase().setSelectedKey(KanryoInfoPhase.調査入手.getコード());
            set調査入手完了情報();
            setKanryoJoho_DBEMN41005();
        } else if (MENUID_DBEMN42002.equals(menuID)) {
            div.getDdlNowPhase().setSelectedKey(KanryoInfoPhase.意見書入手.getコード());
            set意見書入手完了情報();
            setKanryoJoho_DBEMN42002();
        } else if (MENUID_DBEMN43001.equals(menuID)) {
            List<RString> selectedkeyMikann = new ArrayList<>();
            selectedkeyMikann.add(処理状態未完了);
            div.getChkShinsakaiToroku().setSelectedItemsByKey(selectedkeyMikann);
            setKanryoJoho_DBEMN43001();
        } else if (MENUID_DBEMN72001.equals(menuID)) {
            setKanryoJoho_DBEMN72001();
        } else if (MENUID_DBEMN31002.equals(menuID)) {
            setKanryoJoho_DBEMN31002();
        }
    }

    public void setKanryoJoho() {
        RString menuID = ResponseHolder.getMenuID();
        if (MENUID_DBEMN31001.equals(menuID)) {
            setKanryoJoho_DBEMN31001();
        } else if (MENUID_DBEMN41005.equals(menuID)) {
            setKanryoJoho_DBEMN41005();
        } else if (MENUID_DBEMN42002.equals(menuID)) {
            setKanryoJoho_DBEMN42002();
        } else if (MENUID_DBEMN43001.equals(menuID)) {
            setKanryoJoho_DBEMN43001();
        } else if (MENUID_DBEMN72001.equals(menuID)) {
            setKanryoJoho_DBEMN72001();
        } else if (MENUID_DBEMN31002.equals(menuID)) {
            setKanryoJoho_DBEMN31002();
        }
    }

    private void setKanryoJoho_DBEMN21001() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
    }

    private void setKanryoJoho_DBEMN24001() {
        List<RString> selectedkeyKanryo = new ArrayList<>();
        selectedkeyKanryo.add(処理状態完了);
        div.getChkIchijiHantei().setSelectedItemsByKey(selectedkeyKanryo);
    }

    private void setKanryoJoho_DBEMN31001() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setDisabled(true);
    }

    private void setKanryoJoho_DBEMN41005() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkShinseiUketsuke().setDisabled(true);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setDisabled(true);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setDisabled(true);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setDisabled(true);
    }

    private void setKanryoJoho_DBEMN42002() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkShinseiUketsuke().setDisabled(true);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setDisabled(true);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setDisabled(true);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setDisabled(true);
    }

    private void setKanryoJoho_DBEMN43001() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkShinseiUketsuke().setDisabled(true);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setDisabled(true);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setDisabled(true);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setDisabled(true);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setDisabled(true);
    }

    private void setKanryoJoho_DBEMN72001() {
        List<RString> selectedkeyMikann = new ArrayList<>();
        List<RString> selectedkeyKanryo = new ArrayList<>();
        selectedkeyMikann.add(処理状態未完了);
        selectedkeyKanryo.add(処理状態完了);
        div.getChkShinseiUketsuke().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkShinseiUketsuke().setDisabled(true);
        div.getChkChosaIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkChosaIrai().setDisabled(true);
        div.getChkIkenshoIrai().setSelectedItemsByKey(selectedkeyKanryo);
        div.getChkIkenshoIrai().setDisabled(true);
        div.getChkNijiHantei().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkNijiHantei().setDisabled(true);
        div.getChkGetsureiShori().setSelectedItemsByKey(selectedkeyMikann);
        div.getChkGetsureiShori().setDisabled(true);
    }

    private void setKanryoJoho_DBEMN31002() {
        div.getChkGetsureiShori().setSelectedItemsByKey(Arrays.asList(処理状態未完了));
    }
}
