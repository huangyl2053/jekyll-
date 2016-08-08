/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ichigojihanteikekkajoho;

import jp.co.ndensan.reams.db.dbe.business.core.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichigojihanteikekkajoho.IIchiGojiHanteiKekkaJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 一五次判定結果情報のServiceクラスです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
public class IchiGojiHanteiKekkaJohoFinder {

    private final MapperProvider mapperProvider;
    private static final RString 照会 = new RString("照会");
    private static final int TEN = 10;
    private static final RString 厚労省IF識別コード_99A = new RString("99A");
    private static final RString 厚労省IF識別コード_02A = new RString("02A");
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    public IchiGojiHanteiKekkaJohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * コンストラクタです。
     */
    public IchiGojiHanteiKekkaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IchiGojiHanteiKekkaJohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IchiGojiHanteiKekkaJohoFinder}のインスタンス
     */
    public static IchiGojiHanteiKekkaJohoFinder createInstance() {
        return InstanceProvider.create(IchiGojiHanteiKekkaJohoFinder.class);
    }

    /**
     * 1.5次判定結果情報の作成です。
     *
     * @param paramter 一五次判定結果情報のパラメータ
     * @param モード 呼び出し元画面から受け取ったモード
     * @return 要介護認定一五次判定結果情報のBusiness
     */
    public IchiGojiHanteiKekkaJohoBusiness select一五次判定結果情報(
            IchiGojiHanteiKekkaJohoMapperParameter paramter,
            RString モード) {
        if (照会.equals(モード)) {
            return get照会一五次判定結果情報(paramter);
        } else {
            return get登録一五次判定結果情報(paramter);
        }
    }

    private IchiGojiHanteiKekkaJohoBusiness get照会一五次判定結果情報(IchiGojiHanteiKekkaJohoMapperParameter paramter) {
        IIchiGojiHanteiKekkaJohoMapper mapper = mapperProvider.create(IIchiGojiHanteiKekkaJohoMapper.class);
        IchiGojiHanteiKekkaJohoEntity entity = mapper.getIchiGojiHanteiKekkaJoho(paramter);
        if (entity != null) {
            Code 判定結果コード = new Code();
            Code 厚労省IF識別コード = mapper.getKoroshoIfShikibetsuCode(paramter).get厚労省IF識別コード();
            RString 厚労省IF識別コード一時的 = new RString(厚労省IF識別コード.toString());
            if (厚労省IF識別コード一時的.equals(厚労省IF識別コード_99A)) {
                判定結果コード = new Code(IchijiHanteiKekkaCode99.toValue(new RString(entity.get判定結果コード().toString())).get名称());
            } else if (厚労省IF識別コード一時的.equals(厚労省IF識別コード_02A)) {
                判定結果コード = new Code(IchijiHanteiKekkaCode02.toValue(new RString(entity.get判定結果コード().toString())).get名称());
            } else if (厚労省IF識別コード一時的.equals(厚労省IF識別コード_06A)) {
                判定結果コード = new Code(IchijiHanteiKekkaCode06.toValue(new RString(entity.get判定結果コード().toString())).get名称());
            } else if (厚労省IF識別コード一時的.equals(厚労省IF識別コード_09A) || 厚労省IF識別コード一時的.equals(厚労省IF識別コード_09B)) {
                判定結果コード = new Code(IchijiHanteiKekkaCode09.toValue(new RString(entity.get判定結果コード().toString())).get名称());
            }
            entity.set判定結果コード(判定結果コード);
            entity.set厚労省IF識別コード(mapper.getKoroshoIfShikibetsuCode(paramter).get厚労省IF識別コード());
            entity.set認定調査結果_件数(mapper.get認定調査結果件数(paramter));
            entity.set主治医意見書_件数(mapper.get主治医意見書件数(paramter));
        }
        return new IchiGojiHanteiKekkaJohoBusiness(entity);
    }

    private IchiGojiHanteiKekkaJohoBusiness get登録一五次判定結果情報(IchiGojiHanteiKekkaJohoMapperParameter paramter) {
        IchiGojiHanteiKekkaJohoBusiness ビジネス情報 = IchiGojiHanteiKekkaJohoSearch.createInstance().
                getIchiGojiHanteiKekkaJoho(paramter.getShinseishoKanriNo());

        IchiGojiHanteiKekkaJohoEntity entity = new IchiGojiHanteiKekkaJohoEntity();
        entity.set判定年月日(ビジネス情報.get判定年月日());
        entity.set主治医意見書_件数(ビジネス情報.get主治医意見書_件数());
        entity.set認定調査結果_件数(ビジネス情報.get認定調査結果_件数());
        entity.set判定警告コード(ビジネス情報.get判定警告コード());
        entity.set安定性コード(ビジネス情報.get安定性コード());
        entity.set給付区分コード(ビジネス情報.get給付区分コード());
        Code 判定結果コード = ビジネス情報.get判定結果コード();
        if (判定結果コード != null) {
            entity.set判定結果コード(new Code(IchijiHanteiKekkaCode09.toValue(new RString(判定結果コード.toString())).get名称()));
        }
        Decimal 認知症自立度Ⅱ_蓋然性 = ビジネス情報.get認知症自立度Ⅱ_蓋然性();
        if (認知症自立度Ⅱ_蓋然性 != null) {
            entity.set認知症自立度Ⅱ_蓋然性(ビジネス情報.get認知症自立度Ⅱ_蓋然性().divide(TEN));
        }
        entity.set基準時間(ビジネス情報.get基準時間() / TEN);
        entity.set基準時間_食事(ビジネス情報.get基準時間_食事() / TEN);
        entity.set基準時間_排泄(ビジネス情報.get基準時間_排泄() / TEN);
        entity.set基準時間_移動(ビジネス情報.get基準時間_移動() / TEN);
        entity.set基準時間_清潔保持(ビジネス情報.get基準時間_清潔保持() / TEN);
        entity.set基準時間_間接ケア(ビジネス情報.get基準時間_間接ケア() / TEN);
        entity.set基準時間_BPSD関連(ビジネス情報.get基準時間_BPSD関連() / TEN);
        entity.set基準時間_機能訓練(ビジネス情報.get基準時間_機能訓練() / TEN);
        entity.set基準時間_医療関連(ビジネス情報.get基準時間_医療関連() / TEN);
        entity.set基準時間_認知症加算(ビジネス情報.get基準時間_認知症加算() / TEN);
        entity.set中間評価項目得点第一群(ビジネス情報.get中間評価項目得点第一群() / TEN);
        entity.set中間評価項目得点第二群(ビジネス情報.get中間評価項目得点第二群() / TEN);
        entity.set中間評価項目得点第三群(ビジネス情報.get中間評価項目得点第三群() / TEN);
        entity.set中間評価項目得点第四群(ビジネス情報.get中間評価項目得点第四群() / TEN);
        entity.set中間評価項目得点第五群(ビジネス情報.get中間評価項目得点第五群() / TEN);

        return new IchiGojiHanteiKekkaJohoBusiness(entity);
    }
}
