/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchiGojiHanteiKekkaJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 一五次判定結果情報のハンドラークラスです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
public class IchiGojiHanteiKekkaJohoHandler {

    private final IchiGojiHanteiKekkaJohoDiv div;
    private static final int ZERO = 0;
    private static final RString ONE = new RString("1");
    private static final RString 未 = new RString("未");
    private static final RString 済 = new RString("済");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");

    /**
     * コンストラクタです。
     *
     * @param div 一次判定結果情報Div
     */
    public IchiGojiHanteiKekkaJohoHandler(IchiGojiHanteiKekkaJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param business
     */
    public void onLoad(IchiGojiHanteiKekkaJohoBusiness business) {
        if (!business.isEmpty()) {
            div.getTxtIchijiHanteibi().setValue(business.get判定年月日());
            Code 判定結果コード = business.get判定結果コード();
            if (判定結果コード != null) {
                div.getTxtIchijiHanteiKekka().setValue(判定結果コード.value());
            }
            if (business.get認定調査結果_件数() == ZERO) {
                div.getTxtJiritsudoChosa().setValue(未);
            } else {
                div.getTxtJiritsudoChosa().setValue(済);
            }
            if (business.get主治医意見書_件数() == ZERO) {
                div.getTxtJiritsudoIkensho().setValue(未);
            } else {
                div.getTxtJiritsudoIkensho().setValue(済);
            }
            Code 安定性コード = business.get安定性コード();
            if (安定性コード != null) {
                div.getTxtJyotaiAnteisei().setValue(JotaiAnteiseiCode.toValue(安定性コード.value()).get名称());
            }
            Code 給付区分コード = business.get給付区分コード();
            if (給付区分コード != null) {
                div.getTxtKyufuKbn().setValue(SuiteiKyufuKubunCode.toValue(給付区分コード.value()).get名称());
            }

            List<dgIchijiHanteiKeikokuCode_Row> rowList = new ArrayList<>();
            List<RString> codeList = new ArrayList<>();
            Code 判定警告コード = business.get判定警告コード();
            Code 厚労省IF識別コード = business.get厚労省IF識別コード();
            if (判定警告コード != null) {
                List<RString> 判定警告コードList = 判定警告コード.value().toRStringList();
                for (int i = 0, j = 判定警告コードList.size(); i < j; i++) {
                    if (ONE.equals(判定警告コードList.get(i))) {
                        codeList.add(new RString(String.format("%02d", i + 1)));
                    }
                }
                for (int i = 0, j = codeList.size(); i < j; i++) {
                    dgIchijiHanteiKeikokuCode_Row row = new dgIchijiHanteiKeikokuCode_Row();
                    row.setNo(new RString(String.valueOf(i + 1)));
                    row.setCode(codeList.get(i));
                    if (厚労省IF識別コード_09A.equals(厚労省IF識別コード.value())
                            || 厚労省IF識別コード_09B.equals(厚労省IF識別コード.value())) {
                        row.setSetsumei(IchijiHanteiKekkaCode09.toValue(codeList.get(i)).get名称());
                    }
                    rowList.add(row);
                }
                div.getDgIchijiHanteiKeikokuCode().setDataSource(rowList);
            }

            div.getTxtKijunJikan().setValue(new RString(business.get基準時間()));
            div.getTxtShokuji().setValue(new Decimal(business.get基準時間_食事()));
            div.getTxtHaisetsu().setValue(new Decimal(business.get基準時間_排泄()));
            div.getTxtIdo().setValue(new Decimal(business.get基準時間_移動()));
            div.getTxtSeiketsuHoji().setValue(new Decimal(business.get基準時間_清潔保持()));
            div.getTxtKansetsuCare().setValue(new Decimal(business.get基準時間_間接ケア()));
            div.getTxtBpsdKanren().setValue(new Decimal(business.get基準時間_BPSD関連()));
            div.getTxtKinoKunren().setValue(new Decimal(business.get基準時間_機能訓練()));
            div.getTxtIryoKanren().setValue(new Decimal(business.get基準時間_医療関連()));
            div.getTxtNinchishoKasan().setValue(new Decimal(business.get基準時間_認知症加算()));
            div.getTxtDai1gun().setValue(new Decimal(business.get中間評価項目得点第一群()));
            div.getTxtDai2gun().setValue(new Decimal(business.get中間評価項目得点第二群()));
            div.getTxtDai3gun().setValue(new Decimal(business.get中間評価項目得点第三群()));
            div.getTxtDai4gun().setValue(new Decimal(business.get中間評価項目得点第四群()));
            div.getTxtDai5gun().setValue(new Decimal(business.get中間評価項目得点第五群()));
            Decimal 認知症自立度Ⅱ_蓋然性 = business.get認知症自立度Ⅱ_蓋然性();
            if (認知症自立度Ⅱ_蓋然性 != null) {
                div.getTxtGaizensei().setValue(new Decimal(認知症自立度Ⅱ_蓋然性.toString()));
            }
        }
    }

    /**
     * 呼び出し元画面への戻り値設定。
     *
     * @param ビジネス情報
     */
    public void 呼び出し元画面への戻り値(IchiGojiHanteiKekkaJohoBusiness ビジネス情報) {
        IchiGojiHanteiKekkaJoho 情報 = new IchiGojiHanteiKekkaJoho(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        IchiGojiHanteiKekkaJohoBuilder builder = 情報.createBuilderForEdit();

        builder.set要介護認定1_5次判定年月日(FlexibleDate.getNowDate());
        // TODO QA#93089 JavaでDLLを呼び出し方のご提供がありません。
        builder.set要介護認定等基準時間(Integer.parseInt(div.getTxtKijunJikan().getValue().toString()));
        builder.set要介護認定等基準時間_食事_(div.getTxtShokuji().getValue().intValue());
        builder.set要介護認定等基準時間_排泄_(div.getTxtHaisetsu().getValue().intValue());
        builder.set要介護認定等基準時間_移動_(div.getTxtIdo().getValue().intValue());
        builder.set要介護認定等基準時間_清潔保持_(div.getTxtSeiketsuHoji().getValue().intValue());
        builder.set要介護認定等基準時間_間接ケア_(div.getTxtKansetsuCare().getValue().intValue());
        builder.set要介護認定等基準時間_BPSD関連_(div.getTxtBpsdKanren().getValue().intValue());
        builder.set要介護認定等基準時間_機能訓練_(div.getTxtKinoKunren().getValue().intValue());
        builder.set要介護認定等基準時間_医療関連_(div.getTxtIryoKanren().getValue().intValue());
        builder.set要介護認定等基準時間_認知症加算_(div.getTxtNinchishoKasan().getValue().intValue());
        builder.set中間評価項目得点第1群(div.getTxtDai1gun().getValue().intValue());
        builder.set中間評価項目得点第2群(div.getTxtDai2gun().getValue().intValue());
        builder.set中間評価項目得点第3群(div.getTxtDai3gun().getValue().intValue());
        builder.set中間評価項目得点第4群(div.getTxtDai4gun().getValue().intValue());
        builder.set中間評価項目得点第5群(div.getTxtDai5gun().getValue().intValue());

        div.setHdnIchiGojiHanteiKekka(DataPassingConverter.serialize(情報));
    }
}
