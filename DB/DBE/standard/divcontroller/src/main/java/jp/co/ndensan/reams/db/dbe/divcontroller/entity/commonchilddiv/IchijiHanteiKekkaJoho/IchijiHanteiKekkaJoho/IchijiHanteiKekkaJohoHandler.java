/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.service.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShujiiIkenshoJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 一次判定結果情報のハンドラークラスです。
 *
 * @reamsid_L DBE-3000-220 huangh
 */
public class IchijiHanteiKekkaJohoHandler {

    private final IchijiHanteiKekkaJohoDiv div;
    private static final RString VALUE_ISBLANKLINE = new RString("isBlankLine");
    private static final double DOUBLE_10 = 10;

    private enum MiSumiKubun {

        未("0", "未"),
        済("1", "済");

        private final RString key;
        private final RString value;

        private MiSumiKubun(String key, String value) {
            this.key = new RString(key);
            this.value = new RString(value);
        }

        private RString getKey() {
            return key;
        }

        private RString getValue() {
            return value;
        }

        private static MiSumiKubun toValue(RString key) {
            for (MiSumiKubun kubun : values()) {
                if (kubun.getValue().equals(key)) {
                    return kubun;
                }
            }
            return MiSumiKubun.未;
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div 一次判定結果情報Div
     */
    public IchijiHanteiKekkaJohoHandler(IchijiHanteiKekkaJohoDiv div) {
        this.div = div;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        ShinseishoKanriNo shinseishoKanriNo;
        if (!RString.isNullOrEmpty(div.getShinseishoKanriNo())) {
            shinseishoKanriNo = new ShinseishoKanriNo(div.getShinseishoKanriNo());
        } else {
            shinseishoKanriNo = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        }
        return shinseishoKanriNo;
    }

    /**
     * 共有子Divのモード（照会 or 登録）を取得します。
     *
     * @return モード
     */
    public ModeType getモード() {
        ModeType modeType;
        if (!RString.isNullOrEmpty(div.getModeType())) {
            modeType = ModeType.toValue(div.getModeType());
        } else {
            modeType = ViewStateHolder.get(ViewStateKeys.モード, ModeType.class);
        }
        return modeType;
    }

    /**
     * Ddlの選択項目を初期化します。
     */
    public void initializeDdl() {

        List<KeyValueDataSource> hanteiKekkaSource = new ArrayList<>();
        for (IchijiHanteiKekkaCode09 code : IchijiHanteiKekkaCode09.values()) {
            hanteiKekkaSource.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlIchijiHanteiKekka().setDataSource(hanteiKekkaSource);
        div.getDdlIchijiHanteiKekka().setSelectedIndex(0);
        div.getDdlIchijiHanteiKekkaNinchishoKasan().setDataSource(hanteiKekkaSource);
        div.getDdlIchijiHanteiKekkaNinchishoKasan().setSelectedIndex(0);

        List<KeyValueDataSource> miSumiSource = new ArrayList<>();
        for (MiSumiKubun code : MiSumiKubun.values()) {
            miSumiSource.add(new KeyValueDataSource(code.getKey(), code.getValue()));
        }
        div.getDdlJiritsudoChosa().setDataSource(miSumiSource);
        div.getDdlJiritsudoChosa().setSelectedIndex(0);
        div.getDdlJiritsudoIkensho().setDataSource(miSumiSource);
        div.getDdlJiritsudoIkensho().setSelectedIndex(0);

        List<KeyValueDataSource> anteiseiSource = new ArrayList<>();
        for (JotaiAnteiseiCode code : JotaiAnteiseiCode.values()) {
            anteiseiSource.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlJyotaiAnteisei().setDataSource(anteiseiSource);
        div.getDdlJyotaiAnteisei().setSelectedIndex(0);

        List<KeyValueDataSource> kyufuKubunSource = new ArrayList<>();
        for (SuiteiKyufuKubunCode code : SuiteiKyufuKubunCode.values()) {
            kyufuKubunSource.add(new KeyValueDataSource(code.getコード(), code.get名称()));
        }
        div.getDdlKyufuKbn().setDataSource(kyufuKubunSource);
        div.getDdlKyufuKbn().setSelectedIndex(0);
    }

    /**
     * 画面初期化処理です。前画面から一次判定結果情報を受け取れなかった場合の初期化を行います。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param modeType ModeType
     */
    public void initialize(ShinseishoKanriNo shinseishoKanriNo, ModeType modeType) {

        setStateOfIchijiHanteiKekka(modeType);

        IchijiHanteiKekkaJohoManager ichijiHanteiKekkaJohoManager = new IchijiHanteiKekkaJohoManager();
        IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho = ichijiHanteiKekkaJohoManager.
                get要介護認定一次判定結果情報(shinseishoKanriNo);

        if (ichijiHanteiKekkaJoho != null) {
            initialize(ichijiHanteiKekkaJoho, modeType);
        }
    }

    /**
     * 呼び出し元の親画面から一次判定結果を受け取っている場合の初期化処理です。
     *
     * @param hanteiKekka 一次判定結果
     * @param modeType 画面の状態。登録か照会かを示す。
     */
    public void initialize(IchijiHanteiKekkaJoho hanteiKekka, ModeType modeType) {
        setStateOfIchijiHanteiKekka(modeType);
        setIchijiHanteiKekka(hanteiKekka);
    }

    /**
     * 引数から受け取った一次判定結果を元に画面のコントロールに値を設定します。
     *
     * @param hanteiKekka 一次判定結果
     */
    public void setIchijiHanteiKekka(IchijiHanteiKekkaJoho hanteiKekka) {

        ShinseishoKanriNo shinseishoKanriNo = hanteiKekka.identifier().get申請書管理番号();
        Code ifShikibetsuCode = get厚労省IF識別コード(shinseishoKanriNo);

        div.getTxtIchijiHanteibi().setValue(hanteiKekka.get要介護認定一次判定年月日());

        if (!isNullOrEmpty(hanteiKekka.get要介護認定一次判定結果コード())) {
            div.getDdlIchijiHanteiKekka().setSelectedKey(hanteiKekka.get要介護認定一次判定結果コード().getColumnValue());
        }
        if (!isNullOrEmpty(hanteiKekka.get要介護認定一次判定結果コード_認知症加算())) {
            div.getDdlIchijiHanteiKekkaNinchishoKasan().setSelectedKey(hanteiKekka
                    .get要介護認定一次判定結果コード_認知症加算().getColumnValue());
        }

        div.getTxtKijunJikan().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間()).divide(DOUBLE_10));
        div.getTxtShokuji().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_食事()).divide(DOUBLE_10));
        div.getTxtHaisetsu().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_排泄()).divide(DOUBLE_10));
        div.getTxtIdo().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_移動()).divide(DOUBLE_10));
        div.getTxtSeiketsuHoji().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_清潔保持()).divide(DOUBLE_10));
        div.getTxtKansetsuCare().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_間接ケア()).divide(DOUBLE_10));
        div.getTxtBpsdKanren().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_BPSD関連()).divide(DOUBLE_10));
        div.getTxtKinoKunren().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_機能訓練()).divide(DOUBLE_10));
        div.getTxtIryoKanren().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_医療関連()).divide(DOUBLE_10));
        div.getTxtNinchishoKasan().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_認知症加算()).divide(DOUBLE_10));

        div.getTxtDai1gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第1群()).divide(DOUBLE_10));
        div.getTxtDai2gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第2群()).divide(DOUBLE_10));
        div.getTxtDai3gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第3群()).divide(DOUBLE_10));
        div.getTxtDai4gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第4群()).divide(DOUBLE_10));
        div.getTxtDai5gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第5群()).divide(DOUBLE_10));

        if (hanteiKekka.get中間評価項目得点第6群() == 0) {
            div.getTxtDai6gun().clearValue();
            div.getTxtDai6gun().setDisplayNone(true);
            div.getLblDai6gun().setDisplayNone(true);
        } else {
            div.getTxtDai6gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第6群()).divide(DOUBLE_10));
            div.getTxtDai6gun().setDisplayNone(false);
            div.getLblDai6gun().setDisplayNone(false);
        }
        if (hanteiKekka.get中間評価項目得点第7群() == 0) {
            div.getTxtDai7gun().clearValue();
            div.getTxtDai7gun().setDisplayNone(true);
            div.getLblDai7gun().setDisplayNone(true);
        } else {
            div.getTxtDai7gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第7群()).divide(DOUBLE_10));
            div.getTxtDai7gun().setDisplayNone(false);
            div.getLblDai7gun().setDisplayNone(false);
        }

        MiSumiKubun ninteiChosaMisumiKubun = hasNot認定調査票(shinseishoKanriNo) ? MiSumiKubun.未 : MiSumiKubun.済;
        div.getDdlJiritsudoChosa().setSelectedKey(ninteiChosaMisumiKubun.getKey());
        MiSumiKubun shujiiIkenshoMisumiKubun = hasNot主治医意見書(shinseishoKanriNo) ? MiSumiKubun.未 : MiSumiKubun.済;
        div.getDdlJiritsudoIkensho().setSelectedKey(shujiiIkenshoMisumiKubun.getKey());

        if (hanteiKekka.get認知症自立度Ⅱ以上の蓋然性().equals(new Decimal(-1))) {
            div.getTxtGaizensei().clearValue();
        } else {
            div.getTxtGaizensei().setValue(hanteiKekka.get認知症自立度Ⅱ以上の蓋然性());
        }

        Code jotaiAnteiseiCode = hanteiKekka.get要介護認定状態の安定性コード();
        RString jotaiAnteiseiCodeValue = jotaiAnteiseiCode == null ? RString.EMPTY : jotaiAnteiseiCode.value();
        if (!jotaiAnteiseiCodeValue.isEmpty()) {
            div.getDdlJyotaiAnteisei().setSelectedKey(JotaiAnteiseiCode.toValue(jotaiAnteiseiCodeValue).getコード());
        }

        Code suiteiKyufuKubunCode = hanteiKekka.get要介護認定状態の安定性コード();
        RString suiteiKyufuKubunCodeValue = suiteiKyufuKubunCode == null ? RString.EMPTY : suiteiKyufuKubunCode.value();
        if (!suiteiKyufuKubunCodeValue.isEmpty()) {
            div.getDdlKyufuKbn().setSelectedKey(SuiteiKyufuKubunCode.toValue(suiteiKyufuKubunCodeValue).getコード());
        }

        List<dgIchijiHanteiKeikokuCode_Row> rowList = new ArrayList<>();
        List<RString> codeList = new ArrayList<>();
        RString 一次判定警告コード = hanteiKekka.get要介護認定一次判定警告コード() == null
                ? RString.EMPTY : hanteiKekka.get要介護認定一次判定警告コード();
        List<RString> 一次判定警告コードList = 一次判定警告コード.toRStringList();
        for (int i = 0, j = 一次判定警告コードList.size(); i < j; i++) {
            if (new RString("1").equals(一次判定警告コードList.get(i))) {
                codeList.add(new RString(String.format("%02d", i + 1)));
            }
        }
        for (int i = 0, j = codeList.size(); i < j; i++) {
            dgIchijiHanteiKeikokuCode_Row row = new dgIchijiHanteiKeikokuCode_Row();
            row.setNo(new RString(String.valueOf(i + 1)));
            row.setCode(codeList.get(i));
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(ifShikibetsuCode.value())
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(ifShikibetsuCode.value())) {
                row.setSetsumei(IchijiHanteiKeikoku.toValue(codeList.get(i)).get名称());
            }
            rowList.add(row);
        }
        div.getDgIchijiHanteiKeikokuCode().setDataSource(rowList);
    }

    private boolean isNullOrEmpty(Code code) {
        if (code == null || code.isEmpty()) {
            return true;
        }
        RString codeStr = code.getColumnValue();

        return RString.isNullOrEmpty(codeStr);
    }

    private Code get厚労省IF識別コード(ShinseishoKanriNo shinseishoKanriNo) {
        NinteiShinseiJohoManager ninteiShinseiJohoManager = new NinteiShinseiJohoManager();
        NinteiShinseiJoho2 ninteiShinseiJoho = ninteiShinseiJohoManager.get要介護認定申請情報(shinseishoKanriNo);
        Code 厚労省IF識別コード = Code.EMPTY;
        if (ninteiShinseiJoho != null) {
            厚労省IF識別コード = ninteiShinseiJoho.get厚労省IF識別コード();
        }
        return 厚労省IF識別コード;
    }

    private boolean hasNot認定調査票(ShinseishoKanriNo shinseishoKanriNo) {
        NinteichosahyoKihonChosaManager ninteichosaKihonChosaManager = new NinteichosahyoKihonChosaManager();
        List<NinteichosahyoKihonChosa> returnListDbt5203
                = ninteichosaKihonChosaManager.get認定調査票_基本調査By申請書管理番号(shinseishoKanriNo);
        return returnListDbt5203.isEmpty();
    }

    private boolean hasNot主治医意見書(ShinseishoKanriNo shinseishoKanriNo) {
        ShujiiIkenshoJohoManager shujiiIkenshoJohoManager = new ShujiiIkenshoJohoManager();
        List<ShujiiIkenshoJoho> returnListDbt5302
                = shujiiIkenshoJohoManager.get要介護認定主治医意見書情報By申請書管理番号(shinseishoKanriNo);
        return returnListDbt5302.isEmpty();
    }

    /**
     * 一次判定結果を表示するコントロールの状態を切り替えます。登録モードの場合は一次判定BTNを表示し、他のコントロームも全て入力可能です。
     * 登録モード以外の場合は一次判定BTNを非表示とし、他のコントロールは全てReadOnlyとなります。
     *
     * @param modeType 画面のモード
     */
    public void setStateOfIchijiHanteiKekka(ModeType modeType) {
        boolean isReadOnly = !ModeType.ADD_MODE.equals(modeType);

        div.getBtnIchijiHantei().setDisplayNone(isReadOnly);
        div.getBtnKakutei().setDisplayNone(isReadOnly);
    }

    /**
     * 一次判定DLLに渡す引数を作成します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return
     * 引数が作成できた場合はtrue、引数の作成に失敗した場合（{@code RString.EMPTY}）だった場合はfalseを返す。
     */
    public boolean create一次判定引数(ShinseishoKanriNo shinseishoKanriNo) {
        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        div.setHanteiArgument(manager.get一次判定引数(shinseishoKanriNo));
        return !RString.isNullOrEmpty(div.getHanteiArgument());
    }

    /**
     * 呼び出し元画面への戻り値設定。
     *
     * @param ichijiHanteiKekkaJoho 一次判定結果
     * @return 入力データを反映した一次判定結果
     */
    public IchijiHanteiKekkaJoho 呼び出し元画面への戻り値(IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho) {

        boolean kariIchijiHanteiKubun = false;
        if (MiSumiKubun.未.equals(MiSumiKubun.toValue(div.getDdlJiritsudoIkensho().getSelectedKey()))) {
            kariIchijiHanteiKubun = true;
        }
        IchijiHanteiKekkaJohoBuilder builder = ichijiHanteiKekkaJoho.createBuilderForEdit();
        builder.set仮一次判定区分(kariIchijiHanteiKubun);
        builder.set要介護認定一次判定年月日(new FlexibleDate(RDate.getNowDate().toDateString()));

        builder.set要介護認定一次判定結果コード(new Code(getValueOrEmpty(div.getDdlIchijiHanteiKekka().getSelectedKey())));
        builder.set要介護認定一次判定結果コード_認知症加算(new Code(getValueOrEmpty(div.getDdlIchijiHanteiKekkaNinchishoKasan().getSelectedKey())));

        builder.set要介護認定等基準時間(div.getTxtKijunJikan().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_食事(div.getTxtShokuji().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_排泄(div.getTxtHaisetsu().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_移動(div.getTxtIdo().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_清潔保持(div.getTxtSeiketsuHoji().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_間接ケア(div.getTxtKansetsuCare().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_BPSD関連(div.getTxtBpsdKanren().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_機能訓練(div.getTxtKinoKunren().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_医療関連(div.getTxtIryoKanren().getValue().multiply(DOUBLE_10).intValue());
        builder.set要介護認定等基準時間_認知症加算(div.getTxtNinchishoKasan().getValue().multiply(DOUBLE_10).intValue());
        builder.set中間評価項目得点第1群(div.getTxtDai1gun().getValue().multiply(DOUBLE_10).intValue());
        builder.set中間評価項目得点第2群(div.getTxtDai2gun().getValue().multiply(DOUBLE_10).intValue());
        builder.set中間評価項目得点第3群(div.getTxtDai3gun().getValue().multiply(DOUBLE_10).intValue());
        builder.set中間評価項目得点第4群(div.getTxtDai4gun().getValue().multiply(DOUBLE_10).intValue());
        builder.set中間評価項目得点第5群(div.getTxtDai5gun().getValue().multiply(DOUBLE_10).intValue());
        builder.set中間評価項目得点第6群(0);
        builder.set中間評価項目得点第7群(0);

        builder.set要介護認定状態の安定性コード(new Code(getValueOrEmpty(div.getDdlJyotaiAnteisei().getSelectedKey())));
        builder.set認知症自立度Ⅱ以上の蓋然性(div.getTxtGaizensei().getValue() == null ? Decimal.ZERO : div.getTxtGaizensei().getValue());
        builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(getValueOrEmpty(div.getDdlKyufuKbn().getSelectedKey())));

        builder.set運動能力の低下していない認知症高齢者の指標コード(Code.EMPTY);
        builder.set日常生活自立度の組み合わせ_自立(0);
        builder.set日常生活自立度の組み合わせ_要支援(0);
        builder.set日常生活自立度の組み合わせ_要介護１(0);
        builder.set日常生活自立度の組み合わせ_要介護２(0);
        builder.set日常生活自立度の組み合わせ_要介護３(0);
        builder.set日常生活自立度の組み合わせ_要介護４(0);
        builder.set日常生活自立度の組み合わせ_要介護５(0);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価コード(Code.EMPTY);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価(0);
        builder.set一次判定結果送付区分(RString.EMPTY);
        builder.set一次判定結果送付年月日(FlexibleDate.EMPTY);
        builder.setチャート(RString.EMPTY);
        builder.set状態像(RString.EMPTY);

        return builder.build();
    }

    private RString getValueOrEmpty(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        }
        if (value.equals(VALUE_ISBLANKLINE)) {
            return RString.EMPTY;
        }
        return value;
    }
}
