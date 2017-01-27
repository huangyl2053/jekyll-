/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3010002;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010002.IchijiHanteiExecuterDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * IchijiHanteiExecuterの処理クラスです。
 *
 * @author n8178
 */
public class IchijiHanteiExecuterHandler {

    private final IchijiHanteiExecuterDiv div;

    public IchijiHanteiExecuterHandler(IchijiHanteiExecuterDiv div) {
        this.div = div;
    }

    public void initialize() {
        RString shinseishoKanriNoStr = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(shinseishoKanriNoStr);
        div.getCcdShinseishaInfo().initialize(shinseishoKanriNo);
        div.getCcdHanteiKekka().initialize(shinseishoKanriNo);

        div.setHanteiMae(div.getCcdHanteiKekka().get一次判定結果文字列());
    }

    public boolean hasChanged一次判定結果() {
        RString hanteiMae = div.getHanteiMae() == null ? RString.EMPTY : div.getHanteiMae();
        RString hanteiAto = div.getCcdHanteiKekka().get一次判定結果文字列() == null
                ? RString.EMPTY : div.getCcdHanteiKekka().get一次判定結果文字列();

        return !hanteiMae.equals(hanteiAto);
    }

    /**
     * 元々の一次判定データを、新規に一次判定した結果で更新します。DB上に既にデータが存在した場合等に使用します。
     *
     * @param existingData 元データ（DB上に既に存在するデータ等）
     * @param newData 新規一次判定結果
     * @return 元の一次判定データを、新規の一次判定結果で更新したもの
     */
    public IchijiHanteiKekkaJoho updateHanteiKekka(IchijiHanteiKekkaJoho existingData, IchijiHanteiKekkaJoho newData) {

        IchijiHanteiKekkaJohoBuilder builder = existingData.createBuilderForEdit();

        builder.set仮一次判定区分(newData.get仮一次判定区分());
        builder.set要介護認定一次判定年月日(newData.get要介護認定一次判定年月日());

        builder.set要介護認定一次判定結果コード(newData.get要介護認定一次判定結果コード());
        builder.set要介護認定一次判定結果コード_認知症加算(newData.get要介護認定一次判定結果コード_認知症加算());

        builder.set要介護認定一次判定警告コード(newData.get要介護認定一次判定警告コード());

        builder.set要介護認定等基準時間(newData.get要介護認定等基準時間());
        builder.set要介護認定等基準時間_食事(newData.get要介護認定等基準時間_食事());
        builder.set要介護認定等基準時間_排泄(newData.get要介護認定等基準時間_排泄());
        builder.set要介護認定等基準時間_移動(newData.get要介護認定等基準時間_移動());
        builder.set要介護認定等基準時間_清潔保持(newData.get要介護認定等基準時間_清潔保持());
        builder.set要介護認定等基準時間_間接ケア(newData.get要介護認定等基準時間_間接ケア());
        builder.set要介護認定等基準時間_BPSD関連(newData.get要介護認定等基準時間_BPSD関連());
        builder.set要介護認定等基準時間_機能訓練(newData.get要介護認定等基準時間_機能訓練());
        builder.set要介護認定等基準時間_医療関連(newData.get要介護認定等基準時間_医療関連());
        builder.set要介護認定等基準時間_認知症加算(newData.get要介護認定等基準時間_認知症加算());
        builder.set中間評価項目得点第1群(newData.get中間評価項目得点第1群());
        builder.set中間評価項目得点第2群(newData.get中間評価項目得点第2群());
        builder.set中間評価項目得点第3群(newData.get中間評価項目得点第3群());
        builder.set中間評価項目得点第4群(newData.get中間評価項目得点第4群());
        builder.set中間評価項目得点第5群(newData.get中間評価項目得点第5群());
        builder.set中間評価項目得点第6群(newData.get中間評価項目得点第6群());
        builder.set中間評価項目得点第7群(newData.get中間評価項目得点第7群());

        builder.set要介護認定状態の安定性コード(newData.get要介護認定状態の安定性コード());
        builder.set認知症自立度Ⅱ以上の蓋然性(newData.get認知症自立度Ⅱ以上の蓋然性());
        builder.set認知機能及び状態安定性から推定される給付区分コード(newData.get認知機能及び状態安定性から推定される給付区分コード());

        builder.set運動能力の低下していない認知症高齢者の指標コード(newData.get運動能力の低下していない認知症高齢者の指標コード());
        builder.set日常生活自立度の組み合わせ_自立(newData.get日常生活自立度の組み合わせ_自立());
        builder.set日常生活自立度の組み合わせ_要支援(newData.get日常生活自立度の組み合わせ_要支援());
        builder.set日常生活自立度の組み合わせ_要介護１(newData.get日常生活自立度の組み合わせ_要介護１());
        builder.set日常生活自立度の組み合わせ_要介護２(newData.get日常生活自立度の組み合わせ_要介護２());
        builder.set日常生活自立度の組み合わせ_要介護３(newData.get日常生活自立度の組み合わせ_要介護３());
        builder.set日常生活自立度の組み合わせ_要介護４(newData.get日常生活自立度の組み合わせ_要介護４());
        builder.set日常生活自立度の組み合わせ_要介護５(newData.get日常生活自立度の組み合わせ_要介護５());
        builder.set認知症高齢者の日常生活自立度の蓋然性評価コード(newData.get認知症高齢者の日常生活自立度の蓋然性評価コード());
        builder.set認知症高齢者の日常生活自立度の蓋然性評価(newData.get認知症高齢者の日常生活自立度の蓋然性評価());
        builder.set一次判定結果送付区分(newData.get一次判定結果送付区分());
        builder.set一次判定結果送付年月日(newData.get一次判定結果送付年月日());
        builder.setチャート(newData.getチャート());
        builder.set状態像(newData.get状態像());

        return builder.build();
    }
}
