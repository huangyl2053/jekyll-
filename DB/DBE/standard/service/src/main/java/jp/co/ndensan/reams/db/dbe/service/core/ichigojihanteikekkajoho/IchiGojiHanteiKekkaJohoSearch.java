/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ichigojihanteikekkajoho;

import jp.co.ndensan.reams.db.dbe.business.core.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichigojihanteikekkajoho.IIchiGojiHanteiKekkaJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 一五次判定結果情報取得のビジネス処理です。
 *
 * @reamsid_L DBE-3000-300 chenxiangyu
 */
public class IchiGojiHanteiKekkaJohoSearch {

    private final MapperProvider mapperProvider;
    private static final RString フィールド_申請書管理番号 = new RString("申請書管理番号");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");
    private static final int TEN = 10;
    // TODO 処理2~5で取得された項目で組み込み関数を呼び出しが実装しないので、以下はdumyデータの定義です。
    private static final Code 一五次判定警告コード = new Code(new RString("1000000000011"));
    private static final Code 一五次判定結果コード = new Code(IchijiHanteiKekkaCode09.要介護1.getコード());
    private static final Code 認知症加算後の一五次判定結果コード = new Code(IchijiHanteiKekkaCode09.要介護2.getコード());
    private static final Code 状態の安定性コード = new Code(new RString("1"));
    private static final Code 給付区分コード = new Code(new RString("1"));
    private static final Decimal 認知症自立度Ⅱ以上の蓋然性 = Decimal.ONE;
    private static final int 中間評価項目得点第一群 = 6;
    private static final int 中間評価項目得点第二群 = 7;
    private static final int 中間評価項目得点第三群 = 8;
    private static final int 中間評価項目得点第四群 = 9;
    private static final int 中間評価項目得点第五群 = 0;
    private static final int 基準時間 = 7;
    private static final int 基準時間_食事 = 8;
    private static final int 基準時間_排泄 = 9;
    private static final int 基準時間_移動 = 0;
    private static final int 基準時間_清潔保持 = 1;
    private static final int 基準時間_間接ケア = 2;
    private static final int 基準時間_BPSD関連 = 3;
    private static final int 基準時間_機能訓練 = 4;
    private static final int 基準時間_医療関連 = 4;
    private static final int 基準時間_認知症加算 = 5;

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    public IchiGojiHanteiKekkaJohoSearch(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * コンストラクタです。
     */
    public IchiGojiHanteiKekkaJohoSearch() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IchiGojiHanteiKekkaJohoSearch}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IchiGojiHanteiKekkaJohoSearch}のインスタンス
     */
    public static IchiGojiHanteiKekkaJohoSearch createInstance() {
        return InstanceProvider.create(IchiGojiHanteiKekkaJohoSearch.class);
    }

    /**
     * 1.5次判定結果情報取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return IchiGojiHanteiKekkaJohoBusiness
     */
    public IchiGojiHanteiKekkaJohoBusiness getIchiGojiHanteiKekkaJoho(RString 申請書管理番号) {
        if (RString.isNullOrEmpty(申請書管理番号)) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(フィールド_申請書管理番号.toString()));
        }

        IIchiGojiHanteiKekkaJohoMapper mapper = mapperProvider.create(IIchiGojiHanteiKekkaJohoMapper.class);
        IchiGojiHanteiKekkaJohoMapperParameter parameter = IchiGojiHanteiKekkaJohoMapperParameter.createParamter(申請書管理番号);
        Code 厚労省IF識別コード = mapper.getKoroshoIfShikibetsuCode(parameter).get厚労省IF識別コード();
        if (厚労省IF識別コード == null || !(厚労省IF識別コード_09A.equals(厚労省IF識別コード.value()) || 厚労省IF識別コード_09B.equals(厚労省IF識別コード.value()))) {
            throw new ApplicationException(DbeErrorMessages._1_5次判定実行不可.getMessage());
        }
        IchiGojiHanteiKekkaJohoEntity entity = new IchiGojiHanteiKekkaJohoEntity();
        entity.set厚労省IF識別コード(厚労省IF識別コード);
        entity.set主治医意見書_件数(mapper.get主治医意見書件数(parameter));
        entity.set認定調査結果_件数(mapper.get認定調査結果件数(parameter));

//        // TODO 引数1)基本調査項目74 項目 ※処理2で取得
//        List<IchiGojiHanteiKekkaJohoEntity> 基本調査項目 = mapper.get基本調査項目(parameter);
//        // TODO 引数2)主治医意見書4 項目 ※処理3で取得(短期記憶、認知能力、伝達能力、食事行為)
//        List<IchiGojiHanteiKekkaJohoEntity> 主治医意見書項目 = mapper.get主治医意見書項目(parameter);
//        IchiGojiHanteiKekkaJohoEntity 認定調査高齢者自立度 = mapper.get認定調査高齢者自立度(parameter);
//        IchiGojiHanteiKekkaJohoEntity 主治医意見書高齢者自立度 = mapper.get主治医意見書高齢者自立度(parameter);
//        // TODO 引数3)障害高齢者自立度 ※処理4で取得
//        RString 認定調査_障害自立度コード = null;
//        // TODO 引数4)認知症高齢者自立度(認定調査項目) ※処理4で取得
//        RString 認定調査_認知症自立度コード = null;
//        // TODO 引数5)認知症高齢者自立度(主治医意見書) ※処理5で取得
//        RString 主治医意見書_認知症自立度 = null;
//        if (基本調査項目.isEmpty()) {
//            基本調査項目 = null;
//        }
//        if (主治医意見書項目.isEmpty()) {
//            主治医意見書項目 = null;
//        }
//        if (認定調査高齢者自立度 != null) {
//            認定調査_障害自立度コード = 認定調査高齢者自立度.get認定調査_障害自立度コード();
//            認定調査_認知症自立度コード = 認定調査高齢者自立度.get認定調査_認知症自立度コード();
//        }
//        if (主治医意見書高齢者自立度 != null) {
//            主治医意見書_認知症自立度 = 主治医意見書高齢者自立度.get主治医意見書_認知症自立度();
//        }
        // TODO ここに処理「処理2~5で取得された項目で組み込み関数を呼び出して、1.5次判定結果情報を取得する」を実装してください。
        // TODO 処理2~5で取得された項目で組み込み関数を呼び出しての戻り値を以下の項目にセットしてください。
        entity.set判定結果コード(一五次判定結果コード);
        entity.set認知症加算後の一五次判定結果コード(認知症加算後の一五次判定結果コード);
        entity.set基準時間(基準時間 * TEN);
        entity.set基準時間_食事(基準時間_食事 * TEN);
        entity.set基準時間_排泄(基準時間_排泄 * TEN);
        entity.set基準時間_移動(基準時間_移動 * TEN);
        entity.set基準時間_清潔保持(基準時間_清潔保持 * TEN);
        entity.set基準時間_間接ケア(基準時間_間接ケア * TEN);
        entity.set基準時間_BPSD関連(基準時間_BPSD関連 * TEN);
        entity.set基準時間_機能訓練(基準時間_機能訓練 * TEN);
        entity.set基準時間_医療関連(基準時間_医療関連 * TEN);
        entity.set基準時間_認知症加算(基準時間_認知症加算 * TEN);
        entity.set中間評価項目得点第一群(中間評価項目得点第一群 * TEN);
        entity.set中間評価項目得点第二群(中間評価項目得点第二群 * TEN);
        entity.set中間評価項目得点第三群(中間評価項目得点第三群 * TEN);
        entity.set中間評価項目得点第四群(中間評価項目得点第四群 * TEN);
        entity.set中間評価項目得点第五群(中間評価項目得点第五群 * TEN);
        entity.set判定警告コード(一五次判定警告コード);
        entity.set認知症自立度Ⅱ_蓋然性(認知症自立度Ⅱ以上の蓋然性.multiply(Decimal.TEN));
        entity.set安定性コード(状態の安定性コード);
        entity.set給付区分コード(給付区分コード);

        return new IchiGojiHanteiKekkaJohoBusiness(entity);
    }
}
