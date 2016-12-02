/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchBusiness;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 一次判定結果情報のハンドラークラスです。
 *
 * @reamsid_L DBE-3000-220 huangh
 */
public class IchijiHanteiKekkaJohoHandler {

    private final IchijiHanteiKekkaJohoDiv div;
    private static final RString 未 = new RString("未");
    private static final RString 済 = new RString("済");

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
        div.getTxtIchijiHanteiKekka().setValue(hanteiKekka.get一次判定結果名称(ifShikibetsuCode));

        div.getTxtKijunJikan().setValue(new RString(String.valueOf(hanteiKekka.get要介護認定等基準時間())));
        div.getTxtShokuji().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_食事()));
        div.getTxtHaisetsu().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_排泄()));
        div.getTxtIdo().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_移動()));
        div.getTxtSeiketsuHoji().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_清潔保持()));
        div.getTxtKansetsuCare().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_間接ケア()));
        div.getTxtBpsdKanren().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_BPSD関連()));
        div.getTxtKinoKunren().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_機能訓練()));
        div.getTxtIryoKanren().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_医療関連()));
        div.getTxtNinchishoKasan().setValue(new Decimal(hanteiKekka.get要介護認定等基準時間_認知症加算()));

        div.getTxtDai1gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第1群()));
        div.getTxtDai2gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第2群()));
        div.getTxtDai3gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第3群()));
        div.getTxtDai4gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第4群()));
        div.getTxtDai5gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第5群()));
        div.getTxtDai6gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第6群()));
        div.getTxtDai7gun().setValue(new Decimal(hanteiKekka.get中間評価項目得点第7群()));

        div.getTxtJiritsudoChosa().setValue(hasNot認定調査票(shinseishoKanriNo) ? 未 : 済);
        div.getTxtJiritsudoIkensho().setValue(hasNot主治医意見書(shinseishoKanriNo) ? 未 : 済);

        if (hanteiKekka.get認知症自立度Ⅱ以上の蓋然性().equals(new Decimal(-1))) {
            div.getTxtGaizensei().clearValue();
        } else {
            div.getTxtGaizensei().setValue(hanteiKekka.get認知症自立度Ⅱ以上の蓋然性());
        }

        Code jotaiAnteiseiCode = hanteiKekka.get要介護認定状態の安定性コード();
        RString jotaiAnteiseiCodeValue = jotaiAnteiseiCode == null ? RString.EMPTY : jotaiAnteiseiCode.value();
        if (!jotaiAnteiseiCodeValue.isEmpty()) {
            div.getTxtJyotaiAnteisei().setValue(JotaiAnteiseiCode.toValue(jotaiAnteiseiCodeValue).get名称());
        }

        Code suiteiKyufuKubunCode = hanteiKekka.get要介護認定状態の安定性コード();
        RString suiteiKyufuKubunCodeValue = suiteiKyufuKubunCode == null ? RString.EMPTY : suiteiKyufuKubunCode.value();
        if (!suiteiKyufuKubunCodeValue.isEmpty()) {
            div.getTxtKyufuKbn().setValue(SuiteiKyufuKubunCode.toValue(suiteiKyufuKubunCodeValue).get名称());
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

        div.getTxtIchijiHanteibi().setReadOnly(isReadOnly);
        div.getTxtIchijiHanteiKekka().setReadOnly(isReadOnly);
        div.getTxtKijunJikan().setReadOnly(isReadOnly);
        div.getTxtShokuji().setReadOnly(isReadOnly);
        div.getTxtHaisetsu().setReadOnly(isReadOnly);
        div.getTxtIdo().setReadOnly(isReadOnly);
        div.getTxtSeiketsuHoji().setReadOnly(isReadOnly);
        div.getTxtKansetsuCare().setReadOnly(isReadOnly);
        div.getTxtBpsdKanren().setReadOnly(isReadOnly);
        div.getTxtKinoKunren().setReadOnly(isReadOnly);
        div.getTxtIryoKanren().setReadOnly(isReadOnly);
        div.getTxtNinchishoKasan().setReadOnly(isReadOnly);
        div.getTxtDai1gun().setReadOnly(isReadOnly);
        div.getTxtDai2gun().setReadOnly(isReadOnly);
        div.getTxtDai3gun().setReadOnly(isReadOnly);
        div.getTxtDai4gun().setReadOnly(isReadOnly);
        div.getTxtDai5gun().setReadOnly(isReadOnly);
        div.getTxtDai6gun().setReadOnly(isReadOnly);
        div.getTxtDai7gun().setReadOnly(isReadOnly);
        div.getTxtJiritsudoChosa().setReadOnly(isReadOnly);
        div.getTxtJiritsudoIkensho().setReadOnly(isReadOnly);
        div.getTxtGaizensei().setReadOnly(isReadOnly);
        div.getTxtJyotaiAnteisei().setReadOnly(isReadOnly);
        div.getTxtKyufuKbn().setReadOnly(isReadOnly);
        div.getDgIchijiHanteiKeikokuCode().setReadOnly(isReadOnly);
    }

    public void create一次判定引数(ShinseishoKanriNo shinseishoKanriNo) {
        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        div.setHanteiArgument(manager.get一次判定引数(shinseishoKanriNo));
    }

    /**
     * 呼び出し元画面への戻り値設定。
     *
     * @param ichijiHanteiKekkaJoho 一次判定結果
     * @return 入力データを反映した一次判定結果
     */
    public IchijiHanteiKekkaJoho 呼び出し元画面への戻り値(IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho) {

        //TODO n8178 コメントアウト箇所は必要性の判断をしてから削除予定。親画面側の修正が完了するまでに確定する予定。
//        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
//        IchijiHanteiKekkaJohoSearchBusiness business = manager.getIchijiHanteiKekkaJoho(shinseishoKanriNo);
        boolean kariIchijiHanteiKubun = false;
        if (RString.isNullOrEmpty(div.getTxtJiritsudoIkensho().getValue())) {
            kariIchijiHanteiKubun = true;
        }
        IchijiHanteiKekkaJohoBuilder builder = ichijiHanteiKekkaJoho.createBuilderForEdit();
        builder.set仮一次判定区分(kariIchijiHanteiKubun);
        builder.set要介護認定一次判定年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
//            if (business.get一次判定結果() != null) {
//                builder.set要介護認定一次判定結果コード(new Code(business.get一次判定結果()));
//            }
//            if (business.get認知症加算後の一次判定結果() != null) {
//                builder.set要介護認定一次判定結果コード_認知症加算(new Code(business.get認知症加算後の一次判定結果()));
//            }
        builder.set要介護認定等基準時間(Integer.valueOf(div.getTxtKijunJikan().getValue().toString()));
        builder.set要介護認定等基準時間_食事(Integer.valueOf(div.getTxtShokuji().getValue().toString()));
        builder.set要介護認定等基準時間_排泄(Integer.valueOf(div.getTxtHaisetsu().getValue().toString()));
        builder.set要介護認定等基準時間_移動(Integer.valueOf(div.getTxtIdo().getValue().toString()));
        builder.set要介護認定等基準時間_清潔保持(Integer.valueOf(div.getTxtSeiketsuHoji().getValue().toString()));
        builder.set要介護認定等基準時間_間接ケア(Integer.valueOf(div.getTxtKansetsuCare().getValue().toString()));
        builder.set要介護認定等基準時間_BPSD関連(Integer.valueOf(div.getTxtBpsdKanren().getValue().toString()));
        builder.set要介護認定等基準時間_機能訓練(Integer.valueOf(div.getTxtKinoKunren().getValue().toString()));
        builder.set要介護認定等基準時間_医療関連(Integer.valueOf(div.getTxtIryoKanren().getValue().toString()));
        builder.set要介護認定等基準時間_認知症加算(Integer.valueOf(div.getTxtNinchishoKasan().getValue().toString()));
        builder.set中間評価項目得点第1群(Integer.valueOf(div.getTxtDai1gun().getValue().toString()));
        builder.set中間評価項目得点第2群(Integer.valueOf(div.getTxtDai2gun().getValue().toString()));
        builder.set中間評価項目得点第3群(Integer.valueOf(div.getTxtDai3gun().getValue().toString()));
        builder.set中間評価項目得点第4群(Integer.valueOf(div.getTxtDai4gun().getValue().toString()));
        builder.set中間評価項目得点第5群(Integer.valueOf(div.getTxtDai5gun().getValue().toString()));
        builder.set中間評価項目得点第6群(0);
        builder.set中間評価項目得点第7群(0);
//            builder.set要介護認定一次判定警告コード(business.get一次判定警告コード());
//            if (business.get状態の安定性() != null) {
//                builder.set要介護認定状態の安定性コード(new Code(business.get状態の安定性()));
//            }
//            builder.set認知症自立度Ⅱ以上の蓋然性(new Decimal(div.getTxtGaizensei().getValue().toString()));
//            if (business.get認知機能及び状態安定性から推定される給付区分() != null) {
//                builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(business.get認知機能及び状態安定性から推定される給付区分()));
//            }
        builder.set運動能力の低下していない認知症高齢者の指標コード(new Code("1"));
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
}
