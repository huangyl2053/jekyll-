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
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
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
     * 画面初期化処理です。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param modeType ModeType
     */
    public void onLoad(ShinseishoKanriNo shinseishoKanriNo, ModeType modeType) {

        if (ModeType.SHOKAI_MODE.equals(modeType)) {

            NinteiShinseiJohoManager ninteiShinseiJohoManager = new NinteiShinseiJohoManager();
            NinteiShinseiJoho2 ninteiShinseiJoho = ninteiShinseiJohoManager.
                    get要介護認定申請情報(shinseishoKanriNo);

            IchijiHanteiKekkaJohoManager ichijiHanteiKekkaJohoManager = new IchijiHanteiKekkaJohoManager();

            IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho = ichijiHanteiKekkaJohoManager.
                    get要介護認定一次判定結果情報(shinseishoKanriNo);

            NinteichosahyoKihonChosaManager ninteichosaKihonChosaManager = new NinteichosahyoKihonChosaManager();
            List<NinteichosahyoKihonChosa> returnListDbt5203
                    = ninteichosaKihonChosaManager.get認定調査票_基本調査By申請書管理番号(shinseishoKanriNo);
            if (returnListDbt5203.isEmpty()) {
                div.getTxtJiritsudoChosa().setValue(未);
            } else {
                div.getTxtJiritsudoChosa().setValue(済);
            }

            ShujiiIkenshoJohoManager shujiiIkenshoJohoManager = new ShujiiIkenshoJohoManager();
            List<ShujiiIkenshoJoho> returnListDbt5302
                    = shujiiIkenshoJohoManager.get要介護認定主治医意見書情報By申請書管理番号(shinseishoKanriNo);
            if (returnListDbt5302.isEmpty()) {
                div.getTxtJiritsudoIkensho().setValue(未);
            } else {
                div.getTxtJiritsudoIkensho().setValue(済);
            }

            if (ichijiHanteiKekkaJoho != null) {
                div.getTxtIchijiHanteibi().setValue(ichijiHanteiKekkaJoho.toEntity().getIchijiHanteiYMD());

                if (ninteiShinseiJoho != null
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode99.toValue(ichijiHanteiKekkaJoho.toEntity().getIchijiHanteiKekkaCode().value()).get名称());
                } else if (ninteiShinseiJoho != null
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode02.toValue(ichijiHanteiKekkaJoho.toEntity().getIchijiHanteiKekkaCode().value()).get名称());
                } else if (ninteiShinseiJoho != null
                        && KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value())) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode06.toValue(ichijiHanteiKekkaJoho.toEntity().getIchijiHanteiKekkaCode().value()).get名称());
                } else if (ninteiShinseiJoho != null
                        && (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value())
                        || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                                ninteiShinseiJoho.get厚労省IF識別コード().value()))) {
                    div.getTxtIchijiHanteiKekka().setValue(
                            IchijiHanteiKekkaCode09.toValue(ichijiHanteiKekkaJoho.toEntity().getIchijiHanteiKekkaCode().value()).get名称());
                }

                div.getTxtKijunJikan().setValue(new RString(String.valueOf(ichijiHanteiKekkaJoho.get要介護認定等基準時間())));
                div.getTxtShokuji().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_食事()));
                div.getTxtHaisetsu().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_排泄()));
                div.getTxtIdo().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_移動()));
                div.getTxtSeiketsuHoji().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_清潔保持()));
                div.getTxtKansetsuCare().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_間接ケア()));
                div.getTxtBpsdKanren().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_BPSD関連()));
                div.getTxtKinoKunren().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_機能訓練()));
                div.getTxtIryoKanren().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_医療関連()));
                div.getTxtNinchishoKasan().setValue(new Decimal(ichijiHanteiKekkaJoho.get要介護認定等基準時間_認知症加算()));
                div.getTxtDai1gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第1群()));
                div.getTxtDai2gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第2群()));
                div.getTxtDai3gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第3群()));
                div.getTxtDai4gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第4群()));
                div.getTxtDai5gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第5群()));
                div.getTxtDai6gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第6群()));
                div.getTxtDai7gun().setValue(new Decimal(ichijiHanteiKekkaJoho.get中間評価項目得点第7群()));
                div.getTxtGaizensei().setValue(ichijiHanteiKekkaJoho.get認知症自立度Ⅱ以上の蓋然性());

                Code jotaiAnteiseiCode = ichijiHanteiKekkaJoho.get要介護認定状態の安定性コード();
                RString jotaiAnteiseiCodeValue = jotaiAnteiseiCode == null ? RString.EMPTY : jotaiAnteiseiCode.value();
                if (jotaiAnteiseiCode != null
                        && jotaiAnteiseiCodeValue != null) {
                    div.getTxtJyotaiAnteisei().setValue(
                            JotaiAnteiseiCode.toValue(jotaiAnteiseiCodeValue).get名称());
                }

                Code suiteiKyufuKubunCode = ichijiHanteiKekkaJoho.toEntity().getSuiteiKyufuKubunCode();
                RString suiteiKyufuKubunCodeValue = suiteiKyufuKubunCode == null ? RString.EMPTY : suiteiKyufuKubunCode.value();
                if (suiteiKyufuKubunCode != null
                        && suiteiKyufuKubunCodeValue != null) {
                    div.getTxtKyufuKbn().setValue(
                            SuiteiKyufuKubunCode.toValue(suiteiKyufuKubunCodeValue).get名称());
                }
                List<dgIchijiHanteiKeikokuCode_Row> rowList = new ArrayList<>();
                List<RString> codeList = new ArrayList<>();

                RString 一次判定警告コード = ichijiHanteiKekkaJoho.toEntity().getIchijiHnateiKeikokuCode();
                if (一次判定警告コード != null) {
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
                        if (ninteiShinseiJoho != null
                                && (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                                        ninteiShinseiJoho.get厚労省IF識別コード().value())
                                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                                        ninteiShinseiJoho.get厚労省IF識別コード().value()))) {
                            row.setSetsumei(IchijiHanteiKeikoku.toValue(codeList.get(i)).get名称());
                        }
                        rowList.add(row);
                    }
                    div.getDgIchijiHanteiKeikokuCode().setDataSource(rowList);
                }
            }
        } else if (ModeType.ADD_MODE.equals(modeType)) {
            IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
            IchijiHanteiKekkaJohoSearchBusiness business = manager.getIchijiHanteiKekkaJoho(shinseishoKanriNo);

            if (business != null) {
                div.getTxtIchijiHanteibi().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
                div.getTxtIchijiHanteiKekka().setValue(
                        IchijiHanteiKekkaCode99.toValue(business.get一次判定結果()).get名称());
                div.getTxtKijunJikan().setValue(new RString(String.valueOf(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10)));
                // TODO
                div.getTxtShokuji().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtHaisetsu().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtIdo().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtSeiketsuHoji().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtKansetsuCare().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtBpsdKanren().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtKinoKunren().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtIryoKanren().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtNinchishoKasan().setValue(new Decimal(Integer.valueOf(business.get要介護認定等基準時間().toString()) / 10));
                div.getTxtDai1gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai2gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai3gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai4gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai5gun().setValue(new Decimal(Integer.valueOf(business.get中間評価項目得点().toString()) / 10));
                div.getTxtDai6gun().setValue(new Decimal(0));
                div.getTxtDai7gun().setValue(new Decimal(0));
                div.getTxtGaizensei().setValue(new Decimal(Integer.valueOf(business.get認知症自立度Ⅱ以上の蓋然性_評価の１０倍().toString()) / 10));
                if (business.get状態の安定性() != null) {
                    div.getTxtJyotaiAnteisei().setValue(
                            JotaiAnteiseiCode.toValue(business.get状態の安定性()).get名称());
                }
                if (business.get認知機能及び状態安定性から推定される給付区分() != null) {
                    div.getTxtKyufuKbn().setValue(
                            SuiteiKyufuKubunCode.toValue(business.get認知機能及び状態安定性から推定される給付区分()).get名称());
                }

                if (business.get認定調査票_基本調査_件数() == 0) {
                    div.getTxtJiritsudoChosa().setValue(未);
                } else {
                    div.getTxtJiritsudoChosa().setValue(済);
                }

                if (business.get要介護認定主治医意見書情報件数() == 0) {
                    div.getTxtJiritsudoIkensho().setValue(未);
                } else {
                    div.getTxtJiritsudoIkensho().setValue(済);
                }

                List<dgIchijiHanteiKeikokuCode_Row> rowList = new ArrayList<>();
                List<RString> codeList = new ArrayList<>();

                RString 一次判定警告コード = business.get一次判定警告コード();
                if (一次判定警告コード != null) {
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
                        if (business.get厚労省IF識別コード() != null
                                && (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                                        business.get厚労省IF識別コード().value())
                                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                                        business.get厚労省IF識別コード().value()))) {
                            row.setSetsumei(IchijiHanteiKeikoku.toValue(codeList.get(i)).get名称());
                        }
                        rowList.add(row);
                    }
                    div.getDgIchijiHanteiKeikokuCode().setDataSource(rowList);
                }
            }
        }
    }

    /**
     * 呼び出し元画面への戻り値設定。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @return IchijiHanteiKekkaJoho
     */
    public IchijiHanteiKekkaJoho 呼び出し元画面への戻り値(ShinseishoKanriNo shinseishoKanriNo) {

        IchijiHanteiKekkaJohoSearchManager manager = IchijiHanteiKekkaJohoSearchManager.createIntance();
        IchijiHanteiKekkaJohoSearchBusiness business = manager.getIchijiHanteiKekkaJoho(shinseishoKanriNo);
        if (business != null
                && business.get厚労省IF識別コード() != null
                && (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(
                        business.get厚労省IF識別コード().value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(
                        business.get厚労省IF識別コード().value()))) {
            IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho = new IchijiHanteiKekkaJoho(shinseishoKanriNo);

            boolean kariIchijiHanteiKubun = false;
            if (div.getTxtJiritsudoIkensho().getValue().isNullOrEmpty()) {
                kariIchijiHanteiKubun = true;
            }
            IchijiHanteiKekkaJohoBuilder builder = ichijiHanteiKekkaJoho.createBuilderForEdit();
            builder.set仮一次判定区分(kariIchijiHanteiKubun);
            builder.set要介護認定一次判定年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
            builder.set要介護認定一次判定結果コード(new Code(business.get一次判定結果()));
            builder.set要介護認定一次判定結果コード_認知症加算(new Code(business.get認知症加算後の一次判定結果()));
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
            builder.set要介護認定一次判定警告コード(business.get一次判定警告コード());
            builder.set要介護認定状態の安定性コード(new Code(business.get状態の安定性()));
            builder.set認知症自立度Ⅱ以上の蓋然性(new Decimal(div.getTxtGaizensei().getValue().toString()));
            builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(business.get認知機能及び状態安定性から推定される給付区分()));
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
        return null;
    }
}
