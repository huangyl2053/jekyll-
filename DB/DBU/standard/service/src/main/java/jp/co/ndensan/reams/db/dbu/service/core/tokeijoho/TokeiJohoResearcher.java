/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.tokeijoho;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.FukaSummary;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.JukyuSummary;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.ShikakuSummary;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokeijoho.TokeiJohoResearcherMybatisParameter;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokeijoho.ITokeiJohoResearcherMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 統計情報照会クラスです。
 *
 * @reamsid_L DBU-4120-030 sunhaidi
 */
public class TokeiJohoResearcher {

    private static final RString 被保険者区分コード_1 = new RString("1");
    private static final RString 被保険者区分コード_2 = new RString("2");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TokeiJohoResearcher() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 資格で登録されている人数を取得する
     *
     * @param 基準日 FlexibleDate
     * @param 市町村コード LasdecCode
     * @return 資格人数サマリー
     */
    @Transaction
    public ShikakuSummary getShikakuSummary(FlexibleDate 基準日, LasdecCode 市町村コード) {
        ShikakuSummary shikakuSummary = new ShikakuSummary();
        ITokeiJohoResearcherMapper mapper = mapperProvider.create(ITokeiJohoResearcherMapper.class);

        RString 市町村コード_Param = RString.EMPTY;
        if (市町村コード != null) {
            市町村コード_Param = 市町村コード.value();
        }

        int 一号被保険者人数 = mapper.get資格人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村なし(基準日, 被保険者区分コード_1, false, 市町村コード_Param));
        int 一号被保険者人数_内住所地特例者 = mapper.get資格人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村なし(基準日, 被保険者区分コード_1, true, 市町村コード_Param));
        int 二号被保険者人数 = mapper.get資格人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村なし(基準日, 被保険者区分コード_2, false, 市町村コード_Param));
        int 二号被保険者人数_内住所地特例者 = mapper.get資格人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村なし(基準日, 被保険者区分コード_2, true, 市町村コード_Param));
        int 資格人数 = 一号被保険者人数 + 二号被保険者人数;
        int 資格人数_内住所地特例者 = 一号被保険者人数_内住所地特例者 + 二号被保険者人数_内住所地特例者;
        int 適用除外者 = mapper.get適用除外者人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村あり(基準日, 被保険者区分コード_1, false, 市町村コード_Param));
        int 他住所地特例者 = mapper.get他住所地特例者人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村あり(基準日, 被保険者区分コード_1, false, 市町村コード_Param));

        shikakuSummary.set一号被保険者人数(一号被保険者人数);
        shikakuSummary.set一号被保険者人数_内住所地特例者(一号被保険者人数_内住所地特例者);
        shikakuSummary.set二号被保険者人数(二号被保険者人数);
        shikakuSummary.set二号被保険者人数_内住所地特例者(二号被保険者人数_内住所地特例者);
        shikakuSummary.set他住所地特例者(他住所地特例者);
        shikakuSummary.set資格人数(資格人数);
        shikakuSummary.set資格人数_内住所地特例者(資格人数_内住所地特例者);
        shikakuSummary.set適用除外者(適用除外者);
        return shikakuSummary;
    }

    /**
     * 賦課で登録されている人数を取得する。
     *
     * @param 基準日 FlexibleDate
     * @param 市町村コード LasdecCode
     * @return 資格人数サマリー
     */
    @Transaction
    public FukaSummary getFukaSummary(FlexibleDate 基準日, LasdecCode 市町村コード) {
        FukaSummary fukaSummary = new FukaSummary();
        ITokeiJohoResearcherMapper mapper = mapperProvider.create(ITokeiJohoResearcherMapper.class);

        RString 市町村コード_Param = RString.EMPTY;
        if (市町村コード != null) {
            市町村コード_Param = 市町村コード.value();
        }

        int 特別徴収人数_社保庁 = mapper.get特別徴収人数(
                TokeiJohoResearcherMybatisParameter.createParamFor賦課人数(基準日, 被保険者区分コード_1, false,
                        市町村コード_Param, ChoshuHoho.特別徴収_厚生労働省.getコード()));
        int 特別徴収人数_地共済 = mapper.get特別徴収人数(
                TokeiJohoResearcherMybatisParameter.createParamFor賦課人数(基準日, 被保険者区分コード_1, false,
                        市町村コード_Param, ChoshuHoho.特別徴収_地共済.getコード()));
        int 普通徴収人数 = mapper.get特別徴収人数(
                TokeiJohoResearcherMybatisParameter.createParamFor賦課人数(基準日, 被保険者区分コード_1, false,
                        市町村コード_Param, ChoshuHoho.普通徴収.getコード()));
        int 賦課人数 = 特別徴収人数_社保庁 + 特別徴収人数_地共済 + 普通徴収人数;
        fukaSummary.set普通徴収人数(普通徴収人数);
        fukaSummary.set特別徴収人数_地共済(特別徴収人数_地共済);
        fukaSummary.set特別徴収人数_社保庁(特別徴収人数_社保庁);
        fukaSummary.set賦課人数(賦課人数);
        return fukaSummary;
    }

    /**
     * 受給で登録されている人数を取得する。
     *
     * @param 基準日 FlexibleDate
     * @param 市町村コード LasdecCode
     * @return 資格人数サマリー
     */
    @Transaction
    public JukyuSummary getJukyuSummary(FlexibleDate 基準日, LasdecCode 市町村コード) {
        JukyuSummary jukyuSummary = new JukyuSummary();

        ITokeiJohoResearcherMapper mapper = mapperProvider.create(ITokeiJohoResearcherMapper.class);

        RString 市町村コード_Param = RString.EMPTY;
        if (市町村コード != null) {
            市町村コード_Param = 市町村コード.value();
        }

        int 要介護１人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要介護1.getコード()));
        int 要介護２人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要介護2.getコード()));
        int 要介護３人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要介護3.getコード()));
        int 要介護４人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要介護4.getコード()));
        int 要介護５人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要介護5.getコード()));
        int 要支援１人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要支援1.getコード()));
        int 要支援２人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.要支援2.getコード()));
        int 経過的要介護人数 = mapper.get要介護人数(
                TokeiJohoResearcherMybatisParameter.createParamFor要介護人数(基準日,
                        市町村コード_Param, YokaigoJotaiKubun06.経過的要介護.getコード()));
        int 受給人数 = 要介護１人数 + 要介護２人数 + 要介護３人数 + 要介護４人数 + 要介護５人数 + 要支援１人数 + 要支援２人数 + 経過的要介護人数;
        int 自立人数 = mapper.get自立人数(
                TokeiJohoResearcherMybatisParameter.createParam全市町村あり(基準日, RString.EMPTY, false,
                        市町村コード_Param));
        jukyuSummary.set受給人数(受給人数);
        jukyuSummary.set経過的要介護人数(経過的要介護人数);
        jukyuSummary.set自立人数(自立人数);
        jukyuSummary.set要介護１人数(要介護１人数);
        jukyuSummary.set要介護２人数(要介護２人数);
        jukyuSummary.set要介護３人数(要介護３人数);
        jukyuSummary.set要介護４人数(要介護４人数);
        jukyuSummary.set要介護５人数(要介護５人数);
        jukyuSummary.set要支援１人数(要支援１人数);
        jukyuSummary.set要支援２人数(要支援２人数);
        return jukyuSummary;
    }
}
