/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultKomoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.JotaiAnteiseiKubun;
import jp.co.ndensan.reams.db.dbe.business.NichijoSeikatsuJiritsudoKumiawase;
import jp.co.ndensan.reams.db.dbe.business.NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.business.NoryokuMiteikaNinchishoKoreishaShihyoKomoku;
import jp.co.ndensan.reams.db.dbe.business.SuiteiKyuhuKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiChukanHyokaKomokuTokuten;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiKijunTime;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChukanHyokaKomokuTokutenItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiSohuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NichijoSeikatsuJiritsudoKumiawaseItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiKijunTimeItemGroup;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;

/**
 * 一次判定結果の詳細情報をマッピングするクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiResultDetailMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private IchijiHanteiResultDetailMapper() {
    }

    /**
     * 引数から一次判定結果Entityと一次判定警告Listを受け取り、その情報をマッピングして一次判定クラスを作成します。<br/>
     * 引数のいずれかにnullが渡された場合はnullが返ります。
     *
     * @param entity 一次判定結果Entity
     * @param 一次判定警告List 一次判定警告List
     * @return 一次判定結果
     */
    public static IchijiHanteiResultDetail to一次判定結果(DbT5016IchijiHanteiKekkaJohoEntity entity, IchijiHanteiKeikokuList 一次判定警告List) {
        if (entity == null || 一次判定警告List == null) {
            return null;
        }
        return new IchijiHanteiResultDetail(entity.getShinseishoKanriNo(),
                KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode()),
                KariIchijiHanteiKubun.toValue(entity.getKariIchijiHanteiKubun()),
                entity.getIchijiHanteiYMD(),
                create一次判定結果(entity),
                create認知症加算一次判定結果(entity),
                create要介護認定等基準時間(entity),
                create中間項目得点群(entity),
                一次判定警告List,
                create介護認定状態安定性(entity),
                entity.getNinchishoJiritsudoIIijoNoGaizensei(),
                create推定給付区分(entity),
                create能力未低下認知症高齢者指標(entity),
                create日常生活自立度組み合わせ(entity),
                create認知症高齢者自立度蓋然性評価(entity),
                entity.getGaizenseiHyokaPercent(),
                IchijiHanteiSohuKubun.toValue(entity.getIchijiHanteiSofuKubun()),
                entity.getIchijiHanteiKekkaSofuYMD());
    }

    private static IchijiHanteiResultKomoku create一次判定結果(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new IchijiHanteiResultKomoku(entity.getIchijiHanteiKekkaCode(),
                entity.getIchijiHanteiKekkaCodeMeisho(), entity.getIchijiHanteiKekkaCodeRyakusho());
    }

    private static IchijiHanteiResultKomoku create認知症加算一次判定結果(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new IchijiHanteiResultKomoku(entity.getIchijiHanteiKekkaNinchishoKasanCode(),
                entity.getIchijiHanteiKekkaNinchishoKasanCodeMeisho(), entity.getIchijiHanteiKekkaNinchishoKasanCodeRyakusho());
    }

    private static YokaigoNinteiKijunTime create要介護認定等基準時間(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        Map<YokaigoNinteiKijunTimeItemGroup, Integer> 基準時間 = new EnumMap<>(YokaigoNinteiKijunTimeItemGroup.class);
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間, entity.getKijunJikan());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_食事, entity.getKijunJikanShokuji());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_排泄, entity.getKijunJikanHaisetsu());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_移動, entity.getKijunJikanIdo());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_清潔保持, entity.getKijunJikanSeiketsuHoji());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_間接ケア, entity.getKijunJikanKansetsuCare());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_BPSD関連, entity.getKijunJikanBPSDKanren());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_機能訓練, entity.getKijunJikanKinoKunren());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_医療関連, entity.getKijunJikanIryoKanren());
        基準時間.put(YokaigoNinteiKijunTimeItemGroup.基準時間_認知症加算, entity.getKijunJikanNinchishoKasan());
        return new YokaigoNinteiKijunTime(基準時間);
    }

    private static YokaigoNinteiChukanHyokaKomokuTokuten create中間項目得点群(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        Map<ChukanHyokaKomokuTokutenItemGroup, Integer> 得点群 = new EnumMap<>(ChukanHyokaKomokuTokutenItemGroup.class);
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第1群, entity.getChukanHyokaKomoku1gun());
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第2群, entity.getChukanHyokaKomoku2gun());
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第3群, entity.getChukanHyokaKomoku3gun());
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第4群, entity.getChukanHyokaKomoku4gun());
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第5群, entity.getChukanHyokaKomoku5gun());
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第6群, entity.getChukanHyokaKomoku6gun());
        得点群.put(ChukanHyokaKomokuTokutenItemGroup.第7群, entity.getChukanHyokaKomoku7gun());
        return new YokaigoNinteiChukanHyokaKomokuTokuten(得点群);
    }

    private static JotaiAnteiseiKubun create介護認定状態安定性(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new JotaiAnteiseiKubun(entity.getJotaiAnteiseiCode(),
                entity.getJotaiAnteiseiCodeMeisho(), entity.getJotaiAnteiseiCodeRyakusho());
    }

    private static SuiteiKyuhuKubun create推定給付区分(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new SuiteiKyuhuKubun(entity.getSuiteiKyufuKubunCode(),
                entity.getSuiteiKyufuKubunCodeMeisho(), entity.getSuiteiKyufuKubunCodeRyakusho());
    }

    private static NoryokuMiteikaNinchishoKoreishaShihyoKomoku create能力未低下認知症高齢者指標(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(entity.getNinchishoKoreishaShihyoCode(),
                entity.getNinchishoKoreishaShihyoCodeMeisho(), entity.getNinchishoKoreishaShihyoCodeRyakusho());
    }

    private static NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku create認知症高齢者自立度蓋然性評価(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        return new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(entity.getGaizenseiHyokaCode(),
                entity.getGaizenseiHyokaCodeMeisho(), entity.getGaizenseiHyokaCodeRyakusho());
    }

    private static NichijoSeikatsuJiritsudoKumiawase create日常生活自立度組み合わせ(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        Map<NichijoSeikatsuJiritsudoKumiawaseItemGroup, Integer> 日常生活自立度組み合わせ =
                new EnumMap<>(NichijoSeikatsuJiritsudoKumiawaseItemGroup.class);
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.自立, entity.getJiritsudoKumiawase1());
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要支援, entity.getJiritsudoKumiawase2());
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護1, entity.getJiritsudoKumiawase3());
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護2, entity.getJiritsudoKumiawase4());
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護3, entity.getJiritsudoKumiawase5());
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護4, entity.getJiritsudoKumiawase6());
        日常生活自立度組み合わせ.put(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護5, entity.getJiritsudoKumiawase7());
        return new NichijoSeikatsuJiritsudoKumiawase(日常生活自立度組み合わせ);
    }

    /**
     * 一次判定結果を受け取り、その情報をマッピングして一次判定結果Entityを生成します。<br/>
     * 引数にnullが渡されたときはnullが返ります。
     *
     * @param 一次判定結果 一次判定結果
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity to一次判定結果Entity(IchijiHanteiResultDetail 一次判定結果) {
        if (一次判定結果 == null) {
            return null;
        }
        DbT5016IchijiHanteiKekkaJohoEntity entity = new DbT5016IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(一次判定結果.get申請書管理番号());
        entity.setKoroshoIfShikibetsuCode(一次判定結果.get厚労省IF区分().getCode());
        entity.setKariIchijiHanteiKubun(一次判定結果.get仮一次判定区分().is仮判定());
        entity.setIchijiHanteiYMD(一次判定結果.get一次判定年月日());
        entity.setIchijiHanteiKekkaCode(一次判定結果.get一次判定結果().getCode());
        entity.setIchijiHanteiKekkaNinchishoKasanCode(一次判定結果.get認知症加算一次判定結果().getCode());
        entity.setKijunJikan(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間));
        entity.setKijunJikanShokuji(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_食事));
        entity.setKijunJikanHaisetsu(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_排泄));
        entity.setKijunJikanIdo(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_移動));
        entity.setKijunJikanSeiketsuHoji(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_清潔保持));
        entity.setKijunJikanKansetsuCare(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_間接ケア));
        entity.setKijunJikanBPSDKanren(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_BPSD関連));
        entity.setKijunJikanKinoKunren(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_機能訓練));
        entity.setKijunJikanIryoKanren(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_医療関連));
        entity.setKijunJikanNinchishoKasan(一次判定結果.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.基準時間_認知症加算));
        entity.setChukanHyokaKomoku1gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第1群));
        entity.setChukanHyokaKomoku2gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第2群));
        entity.setChukanHyokaKomoku3gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第3群));
        entity.setChukanHyokaKomoku4gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第4群));
        entity.setChukanHyokaKomoku5gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第5群));
        entity.setChukanHyokaKomoku6gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第6群));
        entity.setChukanHyokaKomoku7gun(一次判定結果.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第7群));
        entity.setIchijiHanteiKeikokuCode(一次判定結果.get一次判定警告List().get警告配列コード().toRString());
        entity.setJotaiAnteiseiCode(一次判定結果.get認定状態安定性().getCode());
        entity.setNinchishoJiritsudoIIijoNoGaizensei(一次判定結果.get認知症自立度2以上蓋然性());
        entity.setSuiteiKyufuKubunCode(一次判定結果.get推定給付区分().getCode());
        entity.setNinchishoKoreishaShihyoCode(一次判定結果.get運動能力未低下認知症高齢者指標().getCode());
        entity.setJiritsudoKumiawase1(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.自立));
        entity.setJiritsudoKumiawase2(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要支援));
        entity.setJiritsudoKumiawase3(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護1));
        entity.setJiritsudoKumiawase4(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護2));
        entity.setJiritsudoKumiawase5(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護3));
        entity.setJiritsudoKumiawase6(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護4));
        entity.setJiritsudoKumiawase7(一次判定結果.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護5));
        entity.setGaizenseiHyokaCode(一次判定結果.get認知症高齢者日常生活自立度蓋然性評価().getCode());
        entity.setGaizenseiHyokaPercent(一次判定結果.get認知症高齢者日常生活自立度蓋然性評価率());
        entity.setIchijiHanteiSofuKubun(一次判定結果.get一次判定結果送付区分().get送付区分コード());
        entity.setIchijiHanteiKekkaSofuYMD(一次判定結果.get一次判定結果送付年月日());
        return entity;
    }
}
