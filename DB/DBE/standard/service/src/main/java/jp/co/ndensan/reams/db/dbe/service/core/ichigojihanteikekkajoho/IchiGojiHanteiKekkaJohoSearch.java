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
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        if (申請書管理番号.isNullOrEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(フィールド_申請書管理番号.toString()));
        }

        IIchiGojiHanteiKekkaJohoMapper mapper = mapperProvider.create(IIchiGojiHanteiKekkaJohoMapper.class);
        IchiGojiHanteiKekkaJohoMapperParameter parameter = IchiGojiHanteiKekkaJohoMapperParameter.createParamter(申請書管理番号);
        Code 厚労省IF識別コード = mapper.getKoroshoIfShikibetsuCode(parameter).get厚労省IF識別コード();
        if (!(厚労省IF識別コード_09A.equals(厚労省IF識別コード.value()) || 厚労省IF識別コード_09B.equals(厚労省IF識別コード.value()))) {
            throw new ApplicationException(DbeErrorMessages._1_5次判定実行不可.getMessage());
        }

//        IDLLExecutor executor = DLLExecutorFactory.createInstance(DLLTypes.NCC10_09);
//        IIchijiHanteiConditions conditions = ;
//        IIchijiHanteiResults results = executor.exec();
        // TODO QA#93089 基盤で行う予定の組み込み関数は未完了です、呼び出しすることができません。
        // List<IchiGojiHanteiKekkaJohoEntity> 基本調査項目 = mapper.get基本調査項目(parameter);
        // List<IchiGojiHanteiKekkaJohoEntity> 主治医意見書項目 = mapper.get主治医意見書項目(parameter);
        // RString 認定調査_障害自立度コード = mapper.get認定調査高齢者自立度(parameter).get認定調査_障害自立度コード();
        // RString 認定調査_認知症自立度コード = mapper.get認定調査高齢者自立度(parameter).get認定調査_認知症自立度コード();
        // RString 主治医意見書_認知症自立度 = mapper.get主治医意見書高齢者自立度(parameter).get主治医意見書_認知症自立度();
        IchiGojiHanteiKekkaJohoEntity entity = new IchiGojiHanteiKekkaJohoEntity();
        entity.set厚労省IF識別コード(厚労省IF識別コード);
        entity.set主治医意見書_件数(mapper.get主治医意見書件数(parameter));
        entity.set認定調査結果_件数(mapper.get認定調査結果件数(parameter));

        return new IchiGojiHanteiKekkaJohoBusiness(entity);
    }
}
